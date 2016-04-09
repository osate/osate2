package org.osate.xtext.aadl2.errormodel.util;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.util.OsateDebug;
import org.osate.xtext.aadl2.errormodel.errorModel.AllExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.AndExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.BranchValue;
import org.osate.xtext.aadl2.errormodel.errorModel.CompositeState;
import org.osate.xtext.aadl2.errormodel.errorModel.ConditionElement;
import org.osate.xtext.aadl2.errormodel.errorModel.ConditionExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.EMV2Path;
import org.osate.xtext.aadl2.errormodel.errorModel.EMV2PropertyAssociation;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorTransition;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorFlow;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPath;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorSource;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypes;
import org.osate.xtext.aadl2.errormodel.errorModel.OrExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.OrmoreExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.OutgoingPropagationCondition;
import org.osate.xtext.aadl2.errormodel.errorModel.QualifiedErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.SConditionElement;
import org.osate.xtext.aadl2.errormodel.errorModel.TransitionBranch;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;

public class PropagationGraphBackwardTraversal {

	private AnalysisModel currentAnalysisModel;
	private ComponentInstance rootComponent;

	public PropagationGraphBackwardTraversal(ComponentInstance root) {

		rootComponent = root;
		currentAnalysisModel = new AnalysisModel(rootComponent, false);
	}

	public ComponentInstance getRootComponent() {
		return rootComponent;
	}

	/**
	 * process an Outgoing Error Propagation by going backwards in the propagation graph
	 * First we attempt to go backwards according to the component error behavior, i.e., the OutgoingPropagationCondition.
	 * If not present we do it according to error flow specifications.
	 * @param component ComponentInstance
	 * @param errorPropagation outgoing ErrorPropagation
	 * @param type ErrorTypes
	 * @return Event 
	 */
	public EObject traverseOutgoingErrorPropagation(final ComponentInstance component,
			final ErrorPropagation errorPropagation, ErrorTypes type) {
		List<EObject> subResults = new LinkedList<EObject>();
		type = getTargetType(errorPropagation.getTypeSet(), type);
		EObject found = preProcessOutgoingErrorPropagation(component, errorPropagation, type);
		if (found != null) {
			// used to return cached object
			return found;
		}
		for (OutgoingPropagationCondition opc : EMV2Util.getAllOutgoingPropagationConditions(component)) {
			ErrorTypes condTargetType = getTargetType(opc.getTypeToken(), type);
			if ((EMV2Util.isSame(opc.getOutgoing(), errorPropagation) || opc.isAllPropagations())
					&& EM2TypeSetUtil.contains(type, opc.getTypeToken())) {
				EObject res = handleOutgoingErrorPropagationCondition(component, opc, condTargetType);
				if (res != null) {
					subResults.add(res);
				}
			}
		}
		if (!subResults.isEmpty()) {
			return postProcessOutgoingErrorPropagation(component, errorPropagation, type, subResults);
		}
		for (ErrorFlow ef : EMV2Util.getAllErrorFlows(component)) {
			if (ef instanceof ErrorPath) {
				ErrorPath ep = (ErrorPath) ef;
				if (EMV2Util.isSame(ep.getOutgoing(), errorPropagation)
						&& EM2TypeSetUtil.contains(type, ep.getTargetToken())) {
					EObject newEvent = traverseIncomingErrorPropagation(component, ep.getIncoming(),
							getTargetType(ep.getTypeTokenConstraint(), type));
					subResults.add(newEvent);
				}
			} else if (ef instanceof ErrorSource) {
				ErrorSource errorSource = (ErrorSource) ef;

				if (EMV2Util.isSame(errorSource.getOutgoing(), errorPropagation)) {
					if (EM2TypeSetUtil.contains(errorSource.getTypeTokenConstraint(), type)) {
						EObject newEvent = processErrorSource(component, errorSource, ef.getTypeTokenConstraint());
						subResults.add(newEvent);
					}
				}
			}
		}
		return postProcessErrorFlows(component, errorPropagation, type, subResults);
	}

	/**
	 * determine the target type given the original type of a backward propagation.
	 * Use the original if no constraint was provided (null)
	 * If the original is contained in the constraint use it. 
	 * If not use the constraint as it may represent a mapping, e.g., for an error path
	 * @param constraint ErrorTypes that is expected on the left hand side
	 * @param original ErrroTypes that is the actual origin of the backward proapagation
	 * @return ErrorTypes
	 */
	private ErrorTypes getTargetType(ErrorTypes constraint, ErrorTypes original) {
		if (constraint == null)
			return original;
		if (original == null)
			return constraint;
		return EM2TypeSetUtil.contains(constraint, original) ? original : constraint;
	}

	/**
	 * Process all OutgoingPropagationConditions that match the propagation and type of interest
	 * It is an OR of the OutgoingPropagationConditions that match. 
	 * Fore each it is an AND of the source state (if it involves an error event or propagation).
	 * @param component ComponentInstance
	 * @param propagation (outgoing) ErrorPropagation
	 * @param type ErrorTypes
	 * @return Event (can be null)
	 */
	private EObject handleOutgoingErrorPropagationCondition(ComponentInstance component,
			OutgoingPropagationCondition opc, ErrorTypes type) {
		EObject conditionResult = null;
		EObject stateResult = null;
		if (opc.getCondition() != null) {
			conditionResult = processCondition(component, opc.getCondition(), type);
		}
		if (opc.getState() != null) {
			stateResult = traverseErrorBehaviorState(component, opc.getState(), type);
		}
		if (conditionResult != null && stateResult != null) {
			return processOutgoingErrorPropagationCondition(component, opc, type, conditionResult, stateResult);
		} else if (conditionResult == null && stateResult != null) {
			return stateResult;
		}
		// (conditionResult !=/== null && stateResult == null){
		return conditionResult;
	}

	/**
	 * process error state. Recursively deal with source states of transitions (an AND gate).
	 * We only process error events (not recover or repair) and error propagations referenced by the expression.
	 * @param component ComponentInstance
	 * @param state ErrorBehaviorState
	 * @param type ErrorTypes
	 * @return event
	 */
	public EObject traverseErrorBehaviorState(ComponentInstance component, ErrorBehaviorState state, ErrorTypes type) {
		if (state == null) {
			return null;
		}
		List<EObject> subResults = new LinkedList<EObject>();
		preProcessErrorBehaviorState(component, state, type);
		for (ErrorBehaviorTransition ebt : EMV2Util.getAllErrorBehaviorTransitions(component)) {
			ConditionExpression conditionExpression = null;
			// XXX deal with types
			double scale = 1;
			boolean sameState = false;
			if (ebt.getTarget() != null && EMV2Util.isSame(state, ebt.getTarget())) {
				if (!(EMV2Util.isSame(ebt.getSource(), state) || ebt.isSteadyState())) {
					conditionExpression = ebt.getCondition();
				} else {
					sameState = true;
				}
			} else {
				// deal with transition branches
				EList<TransitionBranch> tbs = ebt.getDestinationBranches();
				for (TransitionBranch transitionBranch : tbs) {
					if (EMV2Util.isSame(transitionBranch.getTarget(), state)) {
						conditionExpression = ebt.getCondition();
						BranchValue val = transitionBranch.getValue();
						if (val.getRealvalue() != null) {
							scale = Double.valueOf(val.getRealvalue());
						} else if (val.getSymboliclabel() != null) {
							if (!EMV2Util.isSame(ebt.getSource(), state)) {
								ComponentClassifier cl = EMV2Util.getAssociatedClassifier(ebt);
								List<EMV2PropertyAssociation> pa = EMV2Properties
										.getProperty(val.getSymboliclabel().getQualifiedName(), cl, ebt, null);
								for (EMV2PropertyAssociation emv2PropertyAssociation : pa) {
									scale = scale + EMV2Properties.getRealValue(emv2PropertyAssociation);
								}
								break;
							}
						}
					}
				}
			}
			if (conditionExpression != null) {
				EObject conditionResult = processCondition(component, conditionExpression, type, scale);
				// XXX this is the recursive call
				EObject stateResult = sameState ? null : traverseErrorBehaviorState(component, ebt.getSource(), type);
				if (conditionResult != null && stateResult != null) {
					subResults.add(
							processTransitionCondition(component, ebt.getSource(), type, conditionResult, stateResult));
				} else if (conditionResult == null && stateResult != null) {
					subResults.add(stateResult);
				} else {
					// (conditionResult !=/== null && stateResult == null){
					subResults.add(conditionResult);
				}
			}
		}
		return postProcessErrorBehaviorState(component, state, type, subResults);
	}

	/**
	 * Process a condition, either from a component error behavior or a
	 * composite error behavior.
	 *
	 * @param component
	 *            - the component that contains the condition
	 * @param condition
	 *            - the ConditionExpression to be analyzed
	 * @return a list of events related to the condition
	 */
	public EObject processCondition(ComponentInstance component, ConditionExpression condition, ErrorTypes type) {
		return processCondition(component, condition, type, 1);
	}

	/**
	 * create the appropriate EMFTA events according to the expression.
	 * When calculating the probability apply the specified scale to each probability..
	 * Used to perform scaling according to the transition branch probability.
	 * @param component
	 * @param condition
	 * @param type
	 * @param scale
	 * @return
	 */
	public EObject processCondition(ComponentInstance component, ConditionExpression condition, ErrorTypes type,
			double scale) {
		/**
		 * We have an AND expression, so, we create an EVENT to AND' sub events.
		 */
		if (condition instanceof AndExpression) {
			preProcessAnd(component, condition, type, scale);
			AndExpression expression = (AndExpression) condition;
			List<EObject> subResults = new LinkedList<EObject>();

			for (ConditionExpression ce : expression.getOperands()) {
				EObject res = processCondition(component, ce, type, scale);
				if (res != null) {
					subResults.add(res);
				}
			}

			return postProcessAnd(component, condition, type, scale, subResults);
		}
		if (condition instanceof AllExpression) {
			List<EObject> subResults = new LinkedList<EObject>();

			AllExpression allCondition = (AllExpression) condition;
			if (allCondition.getCount() == 0) {
				preProcessAnd(component, condition, type, scale);
				AndExpression expression = (AndExpression) condition;
				for (ConditionExpression ce : expression.getOperands()) {
					EObject res = processCondition(component, ce, type, scale);
					if (res != null) {
						subResults.add(res);
					}
				}
			}
			return postProcessAnd(component, condition, type, scale, subResults);
		}

		if (condition instanceof OrExpression) {
			preProcessXor(component, condition, type, scale);
			OrExpression expression = (OrExpression) condition;
			List<EObject> subResults = new LinkedList<EObject>();

			for (ConditionExpression ce : expression.getOperands()) {
				EObject res = processCondition(component, ce, type, scale);
				if (res != null) {
					subResults.add(res);
				}
			}
			return postProcessXor(component, condition, type, scale, subResults);
		}

		if (condition instanceof OrmoreExpression) {
			OrmoreExpression omCondition = (OrmoreExpression) condition;
			List<EObject> subResults = new LinkedList<EObject>();

			if (omCondition.getCount() == 1) {
				preProcessOr(component, condition, type, scale);
				for (ConditionExpression ce : omCondition.getOperands()) {
					EObject res = processCondition(component, ce, type, scale);
					if (res != null) {
						subResults.add(res);
					}
				}
			}
			return postProcessOr(component, condition, type, scale, subResults);
		}

		/**
		 * Here, we have a single condition element.
		 */
		if (condition instanceof ConditionElement) {
			ConditionElement conditionElement = (ConditionElement) condition;

			if (condition instanceof SConditionElement) {
				SConditionElement sconditionElement = (SConditionElement) condition;
				if (sconditionElement.getQualifiedState() != null) {
					/**
					 * In the following, it seems that we reference another
					 * component. This is typically the case when the condition is
					 * within an composite error behavior.
					 *
					 * So, we find the referenced component in the component
					 * hierarchy and add all its contributors to the returned
					 * events.
					 */
					QualifiedErrorBehaviorState qs = sconditionElement.getQualifiedState();
					ComponentInstance referencedInstance = EMV2Util.getLastComponentInstance(qs, component);
					EObject result = null;
					ErrorTypes referencedErrorType = getTargetType(sconditionElement.getConstraint(), type);
					if (referencedInstance != null) {
						result = traverseCompositeErrorState(referencedInstance, EMV2Util.getState(sconditionElement),
								referencedErrorType);
					}
					// XXX traverse returns the FailStop state
					// thus we do not try to find the error event triggering it.
					if (result != null) {
						return result;
					}
					return traverseErrorBehaviorState(referencedInstance, EMV2Util.getState(sconditionElement),
							referencedErrorType);
				}

			}

			if (conditionElement.getQualifiedErrorPropagationReference() != null) {
				EMV2Path path = conditionElement.getQualifiedErrorPropagationReference();

				ComponentInstance relatedComponent = EMV2Util.getLastComponentInstance(path, component);
				NamedElement errorModelElement = EMV2Util.getErrorModelElement(path);
				ErrorTypes referencedErrorType = conditionElement.getConstraint();
				/**
				 * Here, we have an error event. Likely, this is something we
				 * can get when we are analyzing error component behavior.
				 */
				if (errorModelElement instanceof ErrorEvent) {
					return processErrorEvent(component, (ErrorEvent) errorModelElement, referencedErrorType, scale);
				}

				/**
				 * Here, we have an error propagation. This is notified with the
				 * in propagation within a composite error model.
				 */
				if (errorModelElement instanceof ErrorPropagation) {
					ErrorPropagation errorPropagation = (ErrorPropagation) errorModelElement;
					// XXX deal with type constraint
					if (errorPropagation.getDirection() == DirectionType.IN) {
						return traverseIncomingErrorPropagation(relatedComponent, errorPropagation,
								referencedErrorType);
					} else {
						return traverseOutgoingErrorPropagation(relatedComponent, errorPropagation,
								referencedErrorType);
					}
				}

			}
		}
		return null;

	}

	private EObject traverseIncomingErrorPropagation(ComponentInstance component, ErrorPropagation errorPropagation,
			ErrorTypes type) {
		List<EObject> subResults = new LinkedList<EObject>();
		type = getTargetType(errorPropagation.getTypeSet(), type);
		preProcessIncomingErrorPropagation(component, errorPropagation, type);
		for (PropagationPathEnd ppe : currentAnalysisModel.getAllPropagationSourceEnds(component, errorPropagation)) {
			// traverse incoming
			ComponentInstance componentSource = ppe.getComponentInstance();
			ErrorPropagation propagationSource = ppe.getErrorPropagation();
			if (propagationSource.getDirection() == DirectionType.IN) {
				// we have an external incoming propagation
				EObject result = processIncomingErrorPropagation(componentSource, propagationSource, type);
				if (result != null) {
					subResults.add(result);
				}
			} else {
				EObject result = traverseOutgoingErrorPropagation(componentSource, propagationSource, type);
				if (result != null) {
					subResults.add(result);
				}
			}
		}
		if (!subResults.isEmpty()) {
			return postProcessIncomingErrorPropagation(component, errorPropagation, type, subResults);
		}
		return processIncomingErrorPropagation(component, errorPropagation, type);
	}

	/**
	 * Process composite error states who target is the specified state.
	 * We may process more than one composite state declaration if the error type is matched by more than one composite target.
	 * recursively descend composite state declarations
	 * For each composite state declaration also follow incoming propagations.
	 * For each leaf state look up the occurrence probability
	 *
	 * @param component
	 *            - the component under analysis
	 * @param state
	 *            - the target state under analysis
	 * @param type
	 *            - the type associated to the target state (if any)
	 * @return - Event
	 */
	public EObject traverseCompositeErrorState(ComponentInstance component, ErrorBehaviorState state, ErrorTypes type) {
		preProcessCompositeErrorStates(component, state, type);
		List<EObject> subResults = new LinkedList<EObject>();
		// should only match one composite state declaration.
		for (CompositeState cs : EMV2Util.getAllCompositeStates(component)) {
			if (cs.getState() == state) {
				EObject res = processCondition(component, cs.getCondition(), type);
				if (res != null) {
					subResults.add(res);
				}
			}
		}
		if (subResults.isEmpty()) {
			EObject res = traverseErrorBehaviorState(component, state, type);
			if (res != null) {
				subResults.add(res);
			}
		}
		return postProcessCompositeErrorStates(component, state, type, subResults);
	}

//	methods to be overwritten by applicaitons

	protected EObject postProcessOutgoingErrorPropagation(ComponentInstance component,
			ErrorPropagation errorPropagation, ErrorTypes targetType, List<EObject> subResults) {
		OsateDebug.osateDebug("postProcessOutgoingErrorPropagation " + component.getName() + " propagation "
				+ EMV2Util.getPropagationName(errorPropagation));
		return component;
	}

	protected EObject preProcessOutgoingErrorPropagation(ComponentInstance component, ErrorPropagation errorPropagation,
			ErrorTypes targetType) {
		OsateDebug.osateDebug("preProcessOutgoingErrorPropagation " + component.getName() + " propagation "
				+ EMV2Util.getPropagationName(errorPropagation));
		return component;
	}

	protected EObject postProcessErrorFlows(ComponentInstance component, ErrorPropagation errorPropagation,
			ErrorTypes targetType, List<EObject> subResults) {
		OsateDebug.osateDebug("postProcessErrorFlows " + component.getName() + " propagation "
				+ EMV2Util.getPropagationName(errorPropagation));
		return component;
	}

	protected EObject processErrorSource(ComponentInstance component, ErrorSource errorSource,
			TypeSet typeTokenConstraint) {
		OsateDebug.osateDebug("processErrorSource " + component.getName() + " error source " + errorSource.getName());
		return component;
	}

	protected EObject preProcessIncomingErrorPropagation(ComponentInstance component, ErrorPropagation errorPropagation,
			ErrorTypes type) {
		OsateDebug.osateDebug("preProcessIncomingErrorPropagation " + component.getName() + " propagation "
				+ EMV2Util.getPropagationName(errorPropagation));
		return component;
	}

	protected EObject processIncomingErrorPropagation(ComponentInstance component, ErrorPropagation incoming,
			ErrorTypes type) {
		OsateDebug.osateDebug("processIncomingErrorPropagation " + component.getName() + " propagation "
				+ EMV2Util.getPropagationName(incoming));
		return component;
	}

	protected EObject postProcessIncomingErrorPropagation(ComponentInstance component,
			ErrorPropagation errorPropagation, ErrorTypes targetType, List<EObject> subResults) {
		OsateDebug.osateDebug("postProcessIncomingErrorPropagation " + component.getName() + " propagation "
				+ EMV2Util.getPropagationName(errorPropagation));
		return component;
	}

	protected EObject processOutgoingErrorPropagationCondition(ComponentInstance component,
			OutgoingPropagationCondition opc, ErrorTypes type, EObject conditionResult, EObject stateResult) {
		OsateDebug.osateDebug(
				"processOutgoingErrorPropagationCondition " + component.getName() + " condition " + opc.getName());
		return stateResult;
	}

	protected EObject preProcessCompositeErrorStates(ComponentInstance component, ErrorBehaviorState state,
			ErrorTypes targetType) {
		OsateDebug.osateDebug("preProcessCompositeErrorStates " + component.getName() + " state " + state.getName());
		return component;
	}

	protected EObject postProcessCompositeErrorStates(ComponentInstance component, ErrorBehaviorState state,
			ErrorTypes targetType, List<EObject> subResults) {
		OsateDebug.osateDebug("postProcessCompositeErrorStates " + component.getName() + " state " + state.getName());
		return component;
	}

	protected EObject postProcessErrorBehaviorState(ComponentInstance component, ErrorBehaviorState state,
			ErrorTypes type, List<EObject> subResults) {
		OsateDebug.osateDebug("postProcessErrorBehaviorState " + component.getName() + " state " + state.getName());
		return component;
	}

	protected EObject processTransitionCondition(ComponentInstance component, ErrorBehaviorState source,
			ErrorTypes type, EObject conditionResult, EObject stateResult) {
		OsateDebug.osateDebug("processTransitionCondition " + component.getName() + " state " + source.getName());
		return conditionResult;
	}

	protected EObject preProcessErrorBehaviorState(ComponentInstance component, ErrorBehaviorState state,
			ErrorTypes type) {
		OsateDebug.osateDebug("preProcessErrorBehaviorState " + component.getName() + " state " + state.getName());
		return component;
	}

	protected EObject processErrorEvent(ComponentInstance component, ErrorEvent errorModelElement, ErrorTypes type,
			double scale) {
		OsateDebug
				.osateDebug("processErrorEvent " + component.getName() + " error event " + errorModelElement.getName());
		return component;
	}

	protected EObject preProcessAnd(ComponentInstance component, ConditionExpression condition, ErrorTypes type,
			double scale) {
		OsateDebug.osateDebug("preProcessAnd " + component.getName());
		return component;
	}

	protected EObject postProcessAnd(ComponentInstance component, ConditionExpression condition, ErrorTypes type,
			double scale, List<EObject> subResults) {
		OsateDebug.osateDebug("postProcessAnd " + component.getName());
		return component;
	}

	protected EObject postProcessXor(ComponentInstance component, ConditionExpression condition, ErrorTypes type,
			double scale, List<EObject> subResults) {
		OsateDebug.osateDebug("postProcessXor " + component.getName());
		return component;
	}

	protected EObject preProcessXor(ComponentInstance component, ConditionExpression condition, ErrorTypes type,
			double scale) {
		OsateDebug.osateDebug("postProcessXor " + component.getName());
		return component;
	}

	protected EObject postProcessOr(ComponentInstance component, ConditionExpression condition, ErrorTypes type,
			double scale, List<EObject> subResults) {
		OsateDebug.osateDebug("postProcessOr " + component.getName());
		return component;
	}

	protected EObject preProcessOr(ComponentInstance component, ConditionExpression condition, ErrorTypes type,
			double scale) {
		OsateDebug.osateDebug("postProcessOr " + component.getName());
		return component;
	}

}
