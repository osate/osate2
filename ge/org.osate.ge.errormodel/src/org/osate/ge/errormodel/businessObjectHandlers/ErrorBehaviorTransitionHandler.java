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
package org.osate.ge.errormodel.businessObjectHandlers;

import java.util.Optional;

import javax.inject.Named;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.GraphicalConfiguration;
import org.osate.ge.GraphicalConfigurationBuilder;
import org.osate.ge.PaletteEntry;
import org.osate.ge.PaletteEntryBuilder;
import org.osate.ge.di.BuildCreateOperation;
import org.osate.ge.di.CanCreate;
import org.osate.ge.di.CanDelete;
import org.osate.ge.di.CanStartConnection;
import org.osate.ge.di.GetGraphicalConfiguration;
import org.osate.ge.di.GetName;
import org.osate.ge.di.GetNameForEditing;
import org.osate.ge.di.GetPaletteEntries;
import org.osate.ge.di.IsApplicable;
import org.osate.ge.di.Names;
import org.osate.ge.di.ValidateName;
import org.osate.ge.errormodel.ErrorModelCategories;
import org.osate.ge.errormodel.model.BehaviorTransitionTrunk;
import org.osate.ge.errormodel.util.ErrorModelGeUtil;
import org.osate.ge.errormodel.util.ErrorModelNamingUtil;
import org.osate.ge.graphics.Color;
import org.osate.ge.graphics.Dimension;
import org.osate.ge.graphics.EllipseBuilder;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.graphics.Style;
import org.osate.ge.graphics.StyleBuilder;
import org.osate.ge.internal.ui.dialogs.ElementSelectionDialog;
import org.osate.ge.operations.Operation;
import org.osate.ge.operations.StepResult;
import org.osate.ge.operations.StepResultBuilder;
import org.osate.ge.query.StandaloneQuery;
import org.osate.ge.services.QueryService;
import org.osate.xtext.aadl2.errormodel.errorModel.BranchValue;
import org.osate.xtext.aadl2.errormodel.errorModel.ConditionElement;
import org.osate.xtext.aadl2.errormodel.errorModel.ConditionExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.EMV2PathElement;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorTransition;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.QualifiedErrorEventOrPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.TransitionBranch;

/**
 * Branchless error behavior transitions are represented as a single connection from the source to the target.
 * If the transition has a branch, the transition business object is represented as a shape which serves as a branch point. In that case
 * the business object provider will contribute a trunk object and branch objects as children of the transition.
 * The trunk will be represented as a connection between the source and the branch point.
 * The branches will be represented as a connection from the branch point to the target.
 */
public class ErrorBehaviorTransitionHandler {
	private static final Graphic branchPointGraphic = EllipseBuilder.create().fixedSize(new Dimension(8, 8)).build();
	private static StandaloneQuery srcQuery = StandaloneQuery.create((rootQuery) -> rootQuery.parent().children()
			.filterByBusinessObjectRelativeReference(ebt -> ((ErrorBehaviorTransition) ebt).getSource()));
	private static StandaloneQuery dstQuery = StandaloneQuery
			.create((rootQuery) -> rootQuery.parent().children().filterByBusinessObjectRelativeReference(ebt -> {
				final ErrorBehaviorTransition t = (ErrorBehaviorTransition) ebt;
				return t.isSteadyState() ? t.getSource() : t.getTarget();
			}));
	private static Style branchPointStyle = StyleBuilder.create().backgroundColor(Color.BLACK).labelsAboveTop()
			.labelsLeft().primaryLabelVisible(false).build();

	@IsApplicable
	@CanDelete
	public boolean isApplicable(final @Named(Names.BUSINESS_OBJECT) ErrorBehaviorTransition transition) {
		return true;
	}

	@GetGraphicalConfiguration
	public GraphicalConfiguration getGraphicalConfiguration(
			final @Named(Names.BUSINESS_OBJECT) ErrorBehaviorTransition transition,
			final @Named(Names.BUSINESS_OBJECT_CONTEXT) BusinessObjectContext boc, final QueryService queryService) {
		if (transition.getDestinationBranches().isEmpty()) {
			return GraphicalConfigurationBuilder.create().graphic(ErrorModelGeUtil.transitionConnectionGraphic)
					.style(ErrorModelGeUtil.transitionConnectionStyle).source(getSource(boc, queryService))
					.destination(getDestination(boc, queryService)).build();
		} else {
			return GraphicalConfigurationBuilder.create().graphic(branchPointGraphic).style(branchPointStyle).build();
		}

	}

	@GetPaletteEntries
	public PaletteEntry[] getPaletteEntries() {
		return new PaletteEntry[] { PaletteEntryBuilder.create().connectionCreation().label("Error Behavior Transition")
				.category(ErrorModelCategories.ERROR_MODEL).build() };
	}

	private BusinessObjectContext getSource(final BusinessObjectContext boc, final QueryService queryService) {
		return queryService.getFirstResult(srcQuery, boc);
	}

	private BusinessObjectContext getDestination(final BusinessObjectContext boc, final QueryService queryService) {
		return queryService.getFirstResult(dstQuery, boc);
	}

	@GetName
	public String getName(final @Named(Names.BUSINESS_OBJECT) ErrorBehaviorTransition bo) {
		final String name = bo.getName() == null ? "" : bo.getName() + ": ";
		return name + getText(bo.getCondition()).map(t -> "-[" + t + "]").orElse("");
	}

	private static Optional<String> getText(final ConditionExpression e) {
		return Optional.ofNullable(e).map(el -> NodeModelUtils.findActualNodeFor(el)).map(n -> n.getText());
	}

	@GetNameForEditing
	public String getNameForEditing(final @Named(Names.BUSINESS_OBJECT) ErrorBehaviorTransition bo) {
		return bo.getName();
	}

	@ValidateName
	public String validateName(final @Named(Names.BUSINESS_OBJECT) ErrorBehaviorTransition transition,
			final @Named(Names.NAME) String value) {
		final ErrorBehaviorStateMachine stateMachine = (ErrorBehaviorStateMachine) transition.eContainer();
		return ErrorModelNamingUtil.validateName(stateMachine, transition.getName(), value);
	}

	@CanStartConnection
	public boolean canStartConnection(@Named(Names.SOURCE_BO) final Object src) {
		return src instanceof ErrorBehaviorState || src instanceof ErrorBehaviorTransition
				|| src instanceof BehaviorTransitionTrunk || src instanceof TransitionBranch;
	}

	@CanCreate
	public boolean canCreateConnection(@Named(Names.SOURCE_BO) final Object src,
			@Named(Names.DESTINATION_BO) final ErrorBehaviorState targetState) {
		return getStateMachine(src) == getStateMachine(targetState);
	}

	private static ErrorBehaviorStateMachine getStateMachine(final Object bo) {
		if (bo instanceof TransitionBranch) {
			return (ErrorBehaviorStateMachine) ((TransitionBranch) bo).eContainer().eContainer();
		} else if (bo instanceof ErrorBehaviorState || bo instanceof ErrorBehaviorTransition) {
			return (ErrorBehaviorStateMachine) ((EObject) bo).eContainer();
		} else if (bo instanceof BehaviorTransitionTrunk) {
			return (ErrorBehaviorStateMachine) ((BehaviorTransitionTrunk) bo).getTransition().eContainer();
		} else {
			throw new RuntimeException("Unsupported case");
		}
	}

	@BuildCreateOperation
	public Operation buildCreateOperation(
			final @Named(Names.SOURCE_BUSINESS_OBJECT_CONTEXT) BusinessObjectContext srcBoc,
			final @Named(Names.SOURCE_BO) Object srcBo,
			final @Named(Names.DESTINATION_BO) ErrorBehaviorState targetStateReadonly) {

		final URI targetStateUri = EcoreUtil.getURI(targetStateReadonly);

		if (srcBo instanceof ErrorBehaviorState) {
			final ErrorBehaviorState srcStateReadonly = (ErrorBehaviorState) srcBo;
			final URI srcStateUri = EcoreUtil.getURI(srcStateReadonly);

			return Operation.create(createOp -> {
				createOp.supply(() -> StepResult.forValue(getStateMachine(srcStateReadonly)))
						.modifyPreviousResult(stateMachine -> {
							final ErrorBehaviorState targetState = (ErrorBehaviorState) stateMachine.eResource()
									.getResourceSet().getEObject(targetStateUri, true);
							final ErrorBehaviorState srcState = (ErrorBehaviorState) stateMachine.eResource()
									.getResourceSet().getEObject(srcStateUri, true);

							final ElementSelectionDialog selectEventDialog = new ElementSelectionDialog(
									Display.getCurrent().getActiveShell(), "Select Event", "Select event",
									stateMachine.getEvents());

							if (selectEventDialog.open() == Window.CANCEL) {
								return null;
							}

							final ErrorBehaviorEvent event = (ErrorBehaviorEvent) selectEventDialog
									.getFirstSelectedElement();
							// Create the transition
							final ErrorBehaviorTransition newTransition = (ErrorBehaviorTransition) EcoreUtil
									.create(ErrorModelPackage.eINSTANCE.getErrorBehaviorTransition());

							newTransition.setSource(srcState);

							// Set the target
							if (srcState == targetState) {
								newTransition.setSteadyState(true);
							} else {
								newTransition.setTarget(targetState);
							}

							newTransition.setName(
									ErrorModelNamingUtil.buildUniqueIdentifier(stateMachine, "new_transition"));

							final ConditionElement conditionElement = (ConditionElement) EcoreUtil
									.create(ErrorModelPackage.eINSTANCE.getConditionElement());

							newTransition.setCondition(conditionElement);

							final EMV2PathElement conditionPathElement = (EMV2PathElement) EcoreUtil
									.create(ErrorModelPackage.eINSTANCE.getEMV2PathElement());
							conditionPathElement.setNamedElement(event);

							final QualifiedErrorEventOrPropagation errorEventOrPropogation = (QualifiedErrorEventOrPropagation) EcoreUtil
									.create(ErrorModelPackage.eINSTANCE.getQualifiedErrorEventOrPropagation());
							errorEventOrPropogation.setEmv2Target(conditionPathElement);

							conditionElement.setQualifiedErrorPropagationReference(errorEventOrPropogation);

							stateMachine.getTransitions().add(newTransition);

							return StepResultBuilder.create().showNewBusinessObject(srcBoc.getParent(), newTransition)
									.build();

						});
			});
		} else if (srcBo instanceof ErrorBehaviorTransition || srcBo instanceof BehaviorTransitionTrunk
				|| srcBo instanceof TransitionBranch) {
			// Gee the transition to modify
			final ErrorBehaviorTransition transitionReadonly;
			if(srcBo instanceof ErrorBehaviorTransition) {
				transitionReadonly = (ErrorBehaviorTransition)srcBo;
			} else if(srcBo instanceof BehaviorTransitionTrunk) {
				transitionReadonly = ((BehaviorTransitionTrunk) srcBo).getTransition();
			} else if(srcBo instanceof TransitionBranch) {
				transitionReadonly = (ErrorBehaviorTransition)((TransitionBranch) srcBo).eContainer();
			} else {
				throw new RuntimeException("Unexpected case: " + srcBo);
			}

			return Operation.create(createOp -> {
				createOp.supply(() -> StepResult.forValue(transitionReadonly)).modifyPreviousResult(transition -> {
					final ErrorBehaviorState targetState = (ErrorBehaviorState) transition.eResource().getResourceSet()
							.getEObject(targetStateUri, true);

					// Convert from using steady state and target field to using branches.
					if (transition.getDestinationBranches().isEmpty()) {
						final TransitionBranch firstBranch = (TransitionBranch) EcoreUtil
								.create(ErrorModelPackage.eINSTANCE.getTransitionBranch());

						final BranchValue firstBranchValue = (BranchValue) EcoreUtil
								.create(ErrorModelPackage.eINSTANCE.getBranchValue());
						firstBranchValue.setRealvalue("1.0");

						if (transition.isSteadyState()) {
							firstBranch.setSteadyState(true);
						} else {
							firstBranch.setTarget(transition.getTarget());
						}
						firstBranch.setValue(firstBranchValue);
						transition.getDestinationBranches().add(firstBranch);

						transition.eUnset(ErrorModelPackage.eINSTANCE.getErrorBehaviorTransition_Target());
						transition.eUnset(ErrorModelPackage.eINSTANCE.getErrorBehaviorTransition_TargetToken());
						transition.eUnset(ErrorModelPackage.eINSTANCE.getErrorBehaviorTransition_SteadyState());
					}

					// Create the new branch
					final TransitionBranch newBranch = (TransitionBranch) EcoreUtil
							.create(ErrorModelPackage.eINSTANCE.getTransitionBranch());

					final BranchValue newBranchValue = (BranchValue) EcoreUtil
							.create(ErrorModelPackage.eINSTANCE.getBranchValue());
					newBranchValue.setRealvalue("1.0");

					// Set the target
					if (transition.getSource() == targetState) {
						newBranch.setSteadyState(true);
					} else {
						newBranch.setTarget(targetState);
					}

					newBranch.setValue(newBranchValue);

					transition.getDestinationBranches().add(newBranch);

					return StepResultBuilder.create().build();
				});
			});
		} else {
			throw new RuntimeException("Unsupported case: " + srcBo);
		}
	}
}
