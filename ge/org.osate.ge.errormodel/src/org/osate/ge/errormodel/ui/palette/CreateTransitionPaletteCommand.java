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

import java.util.Optional;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.swt.widgets.Display;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.aadl2.ui.NamedElementCollectionSingleSelectorModel;
import org.osate.ge.errormodel.model.BehaviorTransitionTrunk;
import org.osate.ge.errormodel.util.ErrorModelNamingUtil;
import org.osate.ge.operations.Operation;
import org.osate.ge.operations.StepResult;
import org.osate.ge.operations.StepResultBuilder;
import org.osate.ge.palette.BasePaletteCommand;
import org.osate.ge.palette.CanStartConnectionContext;
import org.osate.ge.palette.CreateConnectionPaletteCommand;
import org.osate.ge.palette.GetCreateConnectionOperationContext;
import org.osate.ge.swt.selectors.FilteringSelectorDialog;
import org.osate.ge.swt.selectors.LabelFilteringListSelectorModel;
import org.osate.xtext.aadl2.errormodel.errorModel.BranchValue;
import org.osate.xtext.aadl2.errormodel.errorModel.ConditionElement;
import org.osate.xtext.aadl2.errormodel.errorModel.EMV2PathElement;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorTransition;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.QualifiedErrorEventOrPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.TransitionBranch;

public class CreateTransitionPaletteCommand extends BasePaletteCommand implements CreateConnectionPaletteCommand {
	public CreateTransitionPaletteCommand() {
		super("Error Behavior Transition", ErrorModelPaletteCategories.ERROR_MODEL, null);
	}

	@Override
	public boolean canStartConnection(CanStartConnectionContext ctx) {
		final Object src = ctx.getSource().getBusinessObject();
		return src instanceof ErrorBehaviorState || src instanceof ErrorBehaviorTransition
				|| src instanceof BehaviorTransitionTrunk || src instanceof TransitionBranch;
	}

	@Override
	public Optional<Operation> getOperation(GetCreateConnectionOperationContext ctx) {
		return ctx.getDestination().getBusinessObject(ErrorBehaviorState.class).map(targetStateReadonly -> {
			if(getStateMachine(ctx.getSource().getBusinessObject()) != getStateMachine(targetStateReadonly)) {
				return null;
			}

			return buildCreateOperation(ctx.getSource(), targetStateReadonly);
		});
	}

	private Operation buildCreateOperation(final BusinessObjectContext srcBoc,
			final ErrorBehaviorState targetStateReadonly) {
		final Object srcBo = srcBoc.getBusinessObject();
		final URI targetStateUri = EcoreUtil.getURI(targetStateReadonly);

		if (srcBo instanceof ErrorBehaviorState) {
			final ErrorBehaviorState srcStateReadonly = (ErrorBehaviorState) srcBo;
			final URI srcStateUri = EcoreUtil.getURI(srcStateReadonly);

			return Operation.createWithBuilder(createOp -> {
				createOp.supply(() -> StepResult.forValue(getStateMachine(srcStateReadonly)))
						.modifyPreviousResult(stateMachine -> {
							final ErrorBehaviorState targetState = (ErrorBehaviorState) stateMachine.eResource()
									.getResourceSet().getEObject(targetStateUri, true);
							final ErrorBehaviorState srcState = (ErrorBehaviorState) stateMachine.eResource()
									.getResourceSet().getEObject(srcStateUri, true);

							final NamedElementCollectionSingleSelectorModel<ErrorBehaviorEvent> model = new NamedElementCollectionSingleSelectorModel<>(
									stateMachine.getEvents());
							if (!FilteringSelectorDialog.open(Display.getCurrent().getActiveShell(), "Select Event",
									new LabelFilteringListSelectorModel<>(
											model))) {
								return null;
							}

							final ErrorBehaviorEvent event = model.getSelectedElement();
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
			if (srcBo instanceof ErrorBehaviorTransition) {
				transitionReadonly = (ErrorBehaviorTransition) srcBo;
			} else if (srcBo instanceof BehaviorTransitionTrunk) {
				transitionReadonly = ((BehaviorTransitionTrunk) srcBo).getTransition();
			} else if (srcBo instanceof TransitionBranch) {
				transitionReadonly = (ErrorBehaviorTransition) ((TransitionBranch) srcBo).eContainer();
			} else {
				throw new RuntimeException("Unexpected case: " + srcBo);
			}

			return Operation.createWithBuilder(createOp -> {
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
}
