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

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Subcomponent;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.aadl2.AadlGraphicalEditorException;
import org.osate.ge.errormodel.util.ErrorModelGeUtil;
import org.osate.ge.errormodel.util.ErrorModelNamingUtil;
import org.osate.ge.operations.Operation;
import org.osate.ge.operations.StepResultBuilder;
import org.osate.ge.palette.BasePaletteCommand;
import org.osate.ge.palette.CanStartConnectionContext;
import org.osate.ge.palette.CreateConnectionPaletteCommand;
import org.osate.ge.palette.GetCreateConnectionOperationContext;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelFactory;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause;
import org.osate.xtext.aadl2.errormodel.errorModel.PropagationPath;
import org.osate.xtext.aadl2.errormodel.errorModel.PropagationPoint;
import org.osate.xtext.aadl2.errormodel.errorModel.QualifiedPropagationPoint;
import org.osate.xtext.aadl2.errormodel.errorModel.SubcomponentElement;

public class CreatePropagatonPathPaletteCommand extends BasePaletteCommand implements CreateConnectionPaletteCommand {
	public CreatePropagatonPathPaletteCommand() {
		super("Propagation Path", ErrorModelPaletteCategories.ERROR_PROPAGATION, null);
	}

	@Override
	public boolean canStartConnection(final CanStartConnectionContext ctx) {
		return isValidEndpoint(ctx.getSource());
	}

	@Override
	public Optional<Operation> getOperation(final GetCreateConnectionOperationContext ctx) {
		// Check the type of the destination business object
		if (!isValidEndpoint(ctx.getDestination())) {
			return Optional.empty();
		}

		// Find the common ancestor which is a source for the classifier to update
		final BusinessObjectContext classifierSourceBoc = BusinessObjectContext
				.getFirstCommonAncestor(ctx.getSource().getParent(), ctx.getDestination().getParent())
				.flatMap(ancestor -> ErrorModelGeUtil.getClassifierSourceBoc(ancestor)).orElse(null);
		if (classifierSourceBoc == null) {
			return Optional.empty();
		}

		return ErrorModelGeUtil.createErrorModelSubclauseModifyOperation(classifierSourceBoc, (subclause) -> {
			final PropagationPath newPath = ErrorModelFactory.eINSTANCE.createPropagationPath();
			final String newName = ErrorModelNamingUtil.buildUniqueIdentifier(subclause.getContainingClassifier(),
					"new_propagation_path");
			newPath.setName(newName);
			newPath.setSource(createQualifiedPropagationPoint(subclause, ctx.getSource(), classifierSourceBoc));
			newPath.setTarget(createQualifiedPropagationPoint(subclause, ctx.getDestination(), classifierSourceBoc));
			subclause.getPaths().add(newPath);

			return StepResultBuilder.create().showNewBusinessObject(classifierSourceBoc, newPath).build();
		});
	}

	private static boolean isValidEndpoint(final BusinessObjectContext boc) {
		final Object bo = boc.getBusinessObject();
		return (bo instanceof Feature && !(boc.getParent().getBusinessObject() instanceof FeatureGroup))
				|| bo instanceof PropagationPoint;
	}

	/**
	 * Creates a {@link QualifiedPropagationPoint} for referencing a business object context using business objects contained
	 * in the same resource as the specified subclause. Throws an exception on error.
	 * @param subclause is the subclause used to find the resource set.
	 * @param boc is the business object context which contains the element to reference
	 * @param classifierSource is the classifier which serves as the root of the path.
	 * @return the new {@link QualifiedPropagationPoint} instance.
	 */
	private static QualifiedPropagationPoint createQualifiedPropagationPoint(final ErrorModelSubclause subclause,
			final BusinessObjectContext boc, final BusinessObjectContext classifierSource) {
		final List<URI> path = ErrorModelGeUtil.createQualifiedPropagationPointPath(boc, classifierSource,
				new ArrayList<>());

		QualifiedPropagationPoint result = null;
		QualifiedPropagationPoint lastSegmentRef = null;

		final ResourceSet rs = subclause.eResource().getResourceSet();
		for (final URI pathSegmentUri : path) {
			final EObject pathSegment = rs.getEObject(pathSegmentUri, true);

			// Create the QualifiedPropagationPoint instance for the path segment
			final QualifiedPropagationPoint newPoint = ErrorModelFactory.eINSTANCE.createQualifiedPropagationPoint();
			if (pathSegment instanceof Subcomponent) {
				final SubcomponentElement scElement = ErrorModelFactory.eINSTANCE.createSubcomponentElement();
				scElement.setSubcomponent((Subcomponent) pathSegment);
				newPoint.setSubcomponent(scElement);
			} else if (pathSegment instanceof NamedElement) {
				newPoint.setPropagationPoint((NamedElement) pathSegment);
			} else {
				throw new AadlGraphicalEditorException("Unexpected path segment: " + pathSegment);
			}

			if (result == null) {
				result = newPoint;
			} else {
				lastSegmentRef.setNext(newPoint);
			}

			lastSegmentRef = newPoint;
		}

		return result;
	}
}
