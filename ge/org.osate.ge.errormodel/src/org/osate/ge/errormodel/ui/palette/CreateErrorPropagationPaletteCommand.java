/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file).
 * All Rights Reserved.
 *
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 *
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 *
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.ge.errormodel.ui.palette;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.Feature;
import org.osate.aadl2.NamedElement;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.StringUtil;
import org.osate.ge.aadl2.AadlGraphicalEditorException;
import org.osate.ge.errormodel.combined.CombinedErrorModelSubclause;
import org.osate.ge.errormodel.combined.PropagationNode;
import org.osate.ge.errormodel.model.KeywordPropagationPoint;
import org.osate.ge.errormodel.model.KeywordPropagationPointType;
import org.osate.ge.errormodel.ui.ErrorModelUiUtil;
import org.osate.ge.errormodel.util.ErrorModelGeUtil;
import org.osate.ge.operations.Operation;
import org.osate.ge.operations.StepResultBuilder;
import org.osate.ge.palette.BasePaletteCommand;
import org.osate.ge.palette.GetTargetedOperationContext;
import org.osate.ge.palette.TargetedPaletteCommand;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelFactory;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.FeatureorPPReference;
import org.osate.xtext.aadl2.errormodel.errorModel.PropagationPoint;

import com.google.common.base.Objects;

public class CreateErrorPropagationPaletteCommand extends BasePaletteCommand implements TargetedPaletteCommand {
	private final DirectionType direction;
	private final boolean containment;

	public CreateErrorPropagationPaletteCommand(final DirectionType direction, final boolean containment) {
		super(StringUtil.capitalize(direction.getName()) + (containment ? " Error Containment" : " Error Propagation"),
				ErrorModelPaletteCategories.ERROR_PROPAGATION, null);
		this.direction = direction;
		this.containment = containment;
	}

	@Override
	public Optional<Operation> getOperation(final GetTargetedOperationContext ctx) {
		final Object bo = ctx.getTarget().getBusinessObject();
		if (bo instanceof Feature) {
			return createPropgationCreationOperation(ctx.getTarget(), (newPropagation, subclause) -> {
				// Find the feature in the context of the EMV subclause. This is needed for reliable serialization.
				final List<URI> path = ErrorModelGeUtil.createQualifiedPropagationPointPath(ctx.getTarget(),
						ErrorModelGeUtil.getClassifierSourceBoc(ctx.getTarget()).get(),
						new ArrayList<>());

				newPropagation.setFeatureorPPRef(buildFeatureReference(subclause.eResource().getResourceSet(), path));
			});
		} else if (bo instanceof KeywordPropagationPoint) {
			final KeywordPropagationPoint kw = (KeywordPropagationPoint) bo;
			if (kw.getType() != KeywordPropagationPointType.ALL) {
				return createPropgationCreationOperation(ctx.getTarget(), (newPropagation, subclause) -> {
					newPropagation.setKind(kw.getType().getKind());
				});
			}
		} else if (bo instanceof PropagationPoint) {
			return createPropgationCreationOperation(ctx.getTarget(), (newPropagation, subclause) -> {
				// Find the propagation in the context of the EMV subclause.
				// Check inherited subclauses as well. This is needed for reliable serialization.
				final CombinedErrorModelSubclause combined = CombinedErrorModelSubclause
						.create(subclause.getContainingClassifier());
				final String boName = ((PropagationPoint) bo).getName();
				final PropagationPoint pp = combined.getPoints().filter(p -> Objects.equal(p.getName(), boName))
						.findAny().orElseThrow(() -> new AadlGraphicalEditorException("Unable to find propagation point"));
				final FeatureorPPReference ppRef = ErrorModelFactory.eINSTANCE.createFeatureorPPReference();
				ppRef.setFeatureorPP(pp);
				newPropagation.setFeatureorPPRef(ppRef);
			});
		}

		return Optional.empty();
	}

	/**
	 * Returns true if there is already a propagation defined for the target.
	 * This function only checks the first subclause of the classifier associated with the target. This is because
	 * propagation points may override those in other subclauses.
	 * @param target the target
	 * @return whether a matching propagation is already defined.
	 */
	private boolean propagationAlreadyExists(final BusinessObjectContext target) {
		return ErrorModelGeUtil.getClassifier(target).map(classifier -> {
			final PropagationNode propagations = new PropagationNode();
			ErrorModelGeUtil.getFirstErrorModelSubclause(classifier)
					.ifPresent(subclause -> subclause.getPropagations().forEach(propagations::put));
			return propagations.getPropagationsForBusinessObjectContext(target)
					.anyMatch(p -> p.isNot() == containment && p.getDirection() == direction);
		}).orElse(false);
	}

	/**
	 * Builds a {@link FeatureorPPReference} based on a name path. Throws an exception if unable to find any of the
	 * referenced features.
	 */
	private FeatureorPPReference buildFeatureReference(final ResourceSet resourceSet, final List<URI> path) {
		FeatureorPPReference topPpRef = null;
		FeatureorPPReference lastPpRef = null;

		for (final URI pathSegmentUri : path) {
			final EObject pathSegment = resourceSet.getEObject(pathSegmentUri, true);
			if (!(pathSegment instanceof Feature)) {
				throw new AadlGraphicalEditorException("Unexpected path segment: " + pathSegment);
			}

			final FeatureorPPReference ppRef = ErrorModelFactory.eINSTANCE.createFeatureorPPReference();
			ppRef.setFeatureorPP((Feature) pathSegment);

			if (lastPpRef == null) {
				topPpRef = ppRef;
			} else {
				lastPpRef.setNext(ppRef);
			}

			lastPpRef = ppRef;
		}

		return topPpRef;
	}

	/**
	 * Creates an operation for creating a propagation for the target.
	 * @param target is the target of the propagation. It should be the context which will be the parent of the propagation
	 * @param init function called to finish initializing the propagation. It must set the kind or the feature or PP reference.
	 * @return the operation or an empty optional if a classifier could not be determined.
	 */
	private Optional<Operation> createPropgationCreationOperation(final BusinessObjectContext target,
			final BiConsumer<ErrorPropagation, ErrorModelSubclause> init) {
		return ErrorModelGeUtil.getClassifierSourceBoc(target).flatMap(container -> {
			final AadlPackage pkg = container.getBusinessObject(NamedElement.class).map(ne -> ne.getElementRoot())
					.map(root -> root instanceof AadlPackage ? ((AadlPackage) root) : null)
					.orElseThrow(() -> new AadlGraphicalEditorException("Unable to find model"));

			return ErrorModelGeUtil.createErrorModelSubclausePromptAndModifyOperation(container, () -> {
				if (propagationAlreadyExists(target)) {
					final String propagationOrContainmentLabel = (containment ? "containment" : "propagation");
					final String inputOrOutputLabel = direction == DirectionType.IN ? "intput" : "output";
					MessageDialog.openError(Display.getDefault().getActiveShell(),
							"Unable to create " + propagationOrContainmentLabel,
							"Propagation already exists. A propagation point may only have one " + inputOrOutputLabel
									+ " error " + propagationOrContainmentLabel + " defined.");
					return Optional.empty();
				}

				return ErrorModelUiUtil.promptForTypeSet(pkg);
			}, (subclause, typeSet) -> {
				final ErrorPropagation newPropagation = ErrorModelFactory.eINSTANCE.createErrorPropagation();
				newPropagation.setTypeSet(typeSet);
				newPropagation.setNot(containment);
				newPropagation.setDirection(direction);
				init.accept(newPropagation, subclause);
				subclause.getPropagations().add(newPropagation);

				return StepResultBuilder.create().showNewBusinessObject(target, newPropagation).build();
			});
		});
	}
}
