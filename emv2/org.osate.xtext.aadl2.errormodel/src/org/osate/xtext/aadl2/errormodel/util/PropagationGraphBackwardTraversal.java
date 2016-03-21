package org.osate.xtext.aadl2.errormodel.util;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.util.OsateDebug;
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
import org.osate.xtext.aadl2.errormodel.errorModel.OutgoingPropagationCondition;
import org.osate.xtext.aadl2.errormodel.errorModel.QualifiedErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.SConditionElement;
import org.osate.xtext.aadl2.errormodel.errorModel.TransitionBranch;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;

public class PropagationGraphBackwardTraversal {
	class PropagationRecord {
		ErrorPropagation ep;
		TypeSet constraint;
	}

	private AnalysisModel currentAnalysisModel;
	private ComponentInstance rootComponent;

	public PropagationGraphBackwardTraversal(ComponentInstance root) {

		rootComponent = root;
		currentAnalysisModel = new AnalysisModel(rootComponent);
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
	public Object traverseOutgoingErrorPropagation(final ComponentInstance component,
			final ErrorPropagation errorPropagation, ErrorTypes type, Object param) {
		List<Object> subResults = new LinkedList<Object>();
		type = getTargetType(errorPropagation.getTypeSet(), type);
		Object newparam = preProcessOutgoingErrorPropagation(component, errorPropagation, type, param);
		for (OutgoingPropagationCondition opc : EMV2Util.getAllOutgoingPropagationConditions(component)) {
//	XXX		ErrorTypes condTargetType = getTargetType(opc.getTypeToken(), targetType);
			if ((EMV2Util.isSame(opc.getOutgoing(), errorPropagation) || opc.isAllPropagations()) // && type subset matches
			) {
				Object res = handleOutgoingErrorPropagationCondition(component, opc, type, newparam);
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
					for (PropagationPathEnd ppe : currentAnalysisModel.getAllPropagationSourceEnds(component,
							errorPropagation)) {
						// traverse incoming
						ComponentInstance componentSource = ppe.getComponentInstance();
						ErrorPropagation propagationSource = ppe.getErrorPropagation();
						Object result = traverseOutgoingErrorPropagation(componentSource, propagationSource, type,
								param);
						if (result != null) {
							subResults.add(result);
						}
					}
				}
			} else if (ef instanceof ErrorSource) {
				ErrorSource errorSource = (ErrorSource) ef;

				if (EMV2Util.isSame(errorSource.getOutgoing(), errorPropagation)) {
					if (EM2TypeSetUtil.contains(errorSource.getTypeTokenConstraint(), type)) {
						Object newEvent = processErrorSource(component, errorSource, ef.getTypeTokenConstraint(),
								param);
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
	private Object handleOutgoingErrorPropagationCondition(ComponentInstance component,
			OutgoingPropagationCondition opc, ErrorTypes type, Object param) {
		Object conditionResult = null;
		Object stateResult = null;
		if (opc.getCondition() != null) {
			conditionResult = processCondition(component, opc.getCondition(), type, param);
		}
		if (opc.getState() != null) {
			stateResult = traverseErrorBehaviorState(component, opc.getState(), type, param);
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
	 * process error state according to transitions. Recursively deal with source states of transitions (an AND gate).
	 * We only process error events (not recover or repair) and error propagations referenced by the expression.
	 * @param component ComponentInstance
	 * @param state ErrorBehaviorState
	 * @param type ErrorTypes
	 * @return event
	 */
	public Object traverseErrorBehaviorState(ComponentInstance component, ErrorBehaviorState state, ErrorTypes type,
			Object param) {
		if (state == null) {
			return null;
		}
		List<Object> subResults = new LinkedList<Object>();
		param = preProcessErrorBehaviorState(component, state, type, param);
		for (ErrorBehaviorTransition ebt : EMV2Util.getAllErrorBehaviorTransitions(component)) {
			ConditionExpression conditionExpression = null;
			// XXX deal with types
			double scale = 1;
			if (ebt.getTarget() != null && EMV2Util.isSame(state, ebt.getTarget())) {
				if (!EMV2Util.isSame(ebt.getSource(), state)) {
					conditionExpression = ebt.getCondition();
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
				Object conditionResult = processCondition(component, conditionExpression, type, scale, param);
				// XXX this is the recursive call
				Object stateResult = traverseErrorBehaviorState(component, ebt.getSource(), type, param);
				if (conditionResult != null && stateResult != null) {
					return processTransitionCondition(component, ebt.getSource(), type, conditionResult, stateResult);
				} else if (conditionResult == null && stateResult != null) {
					return stateResult;
				}
				// (conditionResult !=/== null && stateResult == null){
				return conditionResult;
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
	public Object processCondition(ComponentInstance component, ConditionExpression condition, ErrorTypes type,
			Object param) {
		return processCondition(component, condition, type, 1, param);
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
	public Object processCondition(ComponentInstance component, ConditionExpression condition, ErrorTypes type,
			double scale, Object param) {
		/**
		 * We have an AND expression, so, we create an EVENT to AND' sub events.
		 */
		if (condition instanceof AndExpression) {
			param = preProcessAnd(component, condition, type, scale, param);
			AndExpression expression = (AndExpression) condition;
			List<Object> subResults = new LinkedList<Object>();

			for (ConditionExpression ce : expression.getOperands()) {
				Object res = processCondition(component, ce, type, scale, param);
				if (res != null) {
					subResults.add(res);
				}
			}

			return postProcessAnd(component, condition, type, scale, subResults);
		}

		if (condition instanceof OrExpression) {
			param = preProcessXor(component, condition, type, scale, param);
			OrExpression expression = (OrExpression) condition;
			List<Object> subResults = new LinkedList<Object>();

			for (ConditionExpression ce : expression.getOperands()) {
				Object res = processCondition(component, condition, type, scale);
				if (res != null) {
					subResults.add(res);
				}
			}
			return postProcessXor(component, condition, type, scale, subResults);
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
					Object result = null;
					ErrorTypes referencedErrorType = getTargetType(sconditionElement.getConstraint(), type);
					if (referencedInstance != null) {
						result = traverseCompositeErrorState(referencedInstance, EMV2Util.getState(sconditionElement),
								referencedErrorType, param);
					}
					if (result != null) {
						return result;
					}
					// XXX should this be just process instead of traverse?
					return traverseErrorBehaviorState(referencedInstance, EMV2Util.getState(sconditionElement),
							referencedErrorType, param);
				}

			}

			if (conditionElement.getQualifiedErrorPropagationReference() != null) {
				EMV2Path path = conditionElement.getQualifiedErrorPropagationReference();

				ComponentInstance relatedComponent = EMV2Util.getLastComponentInstance(path, component);
				NamedElement errorModelElement = EMV2Util.getErrorModelElement(path);
				/**
				 * Here, we have an error event. Likely, this is something we
				 * can get when we are analyzing error component behavior.
				 */
				if (errorModelElement instanceof ErrorEvent) {
					return processErrorEvent(component, (ErrorEvent) errorModelElement, type, param);
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
								conditionElement.getConstraint(), param);
					} else {
						return traverseOutgoingErrorPropagation(relatedComponent, errorPropagation,
								conditionElement.getConstraint(), param);
					}
				}

			}
		}
		return null;

	}

	private Object traverseIncomingErrorPropagation(ComponentInstance component, ErrorPropagation errorPropagation,
			ErrorTypes type, Object param) {
		List<Object> subResults = new LinkedList<Object>();
		type = getTargetType(errorPropagation.getTypeSet(), type);
		param = preProcessOutgoingErrorPropagation(component, errorPropagation, type, param);
		for (PropagationPathEnd ppe : currentAnalysisModel.getAllPropagationSourceEnds(component, errorPropagation)) {
			// traverse incoming
			ComponentInstance componentSource = ppe.getComponentInstance();
			ErrorPropagation propagationSource = ppe.getErrorPropagation();
			Object result = traverseOutgoingErrorPropagation(componentSource, propagationSource, type, param);
			if (result != null) {
				subResults.add(result);
			}
		}
		if (!subResults.isEmpty()) {
			return postProcessIncomingErrorPropagation(component, errorPropagation, type, subResults);
		}
		return processIncomingErrorPropagation(component, errorPropagation, type, param);
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
	public Object traverseCompositeErrorState(ComponentInstance component, ErrorBehaviorState state, ErrorTypes type,
			Object param) {
		List<Object> subResults;
		subResults = new LinkedList<Object>();
		// should only match one composite state declaration.
		for (CompositeState cs : EMV2Util.getAllCompositeStates(component)) {
			if (cs.getState() == state) {
				Object res = processCondition(component, cs.getCondition(), type, param);
				if (res != null) {
					subResults.add(res);
				}
			}
		}
		return postProcessCompositeErrorStates(component, state, type, subResults);
	}

//	

	private Object postProcessOutgoingErrorPropagation(ComponentInstance component, ErrorPropagation errorPropagation,
			ErrorTypes targetType, List<Object> subResults) {
		OsateDebug.osateDebug("postProcessOutgoingErrorPropagation " + component.getName() + " propagation "
				+ EMV2Util.getPropagationName(errorPropagation));
		return subResults;
	}

	private Object preProcessOutgoingErrorPropagation(ComponentInstance component, ErrorPropagation errorPropagation,
			ErrorTypes targetType, Object param) {
		OsateDebug.osateDebug("preProcessOutgoingErrorPropagation " + component.getName() + " propagation "
				+ EMV2Util.getPropagationName(errorPropagation));
		return param;
	}

	private Object postProcessErrorFlows(ComponentInstance component, ErrorPropagation errorPropagation,
			ErrorTypes targetType, List<Object> subResults) {
		return subResults;
	}

	private Object processErrorSource(ComponentInstance component, ErrorSource errorSource, TypeSet typeTokenConstraint,
			Object param) {
		OsateDebug.osateDebug("processErrorSource " + component.getName() + " error source " + errorSource.getName());
		return param;
	}

	private Object processIncomingErrorPropagation(ComponentInstance component, ErrorPropagation incoming,
			ErrorTypes type, Object param) {
		OsateDebug.osateDebug("processIncomingErrorPropagation " + component.getName() + " propagation "
				+ EMV2Util.getPropagationName(incoming));
		return param;
	}

	private Object postProcessIncomingErrorPropagation(ComponentInstance component, ErrorPropagation errorPropagation,
			ErrorTypes targetType, List<Object> subResults) {
		OsateDebug.osateDebug("processIncomingErrorPropagation " + component.getName() + " propagation "
				+ EMV2Util.getPropagationName(errorPropagation));
		return subResults;
	}

	private Object processOutgoingErrorPropagationCondition(ComponentInstance component,
			OutgoingPropagationCondition opc, ErrorTypes type, Object conditionResult, Object param) {
		OsateDebug.osateDebug(
				"processOutgoingErrorPropagationCondition " + component.getName() + " condition " + opc.getName());
		return param;
	}

	private Object postProcessCompositeErrorStates(ComponentInstance component, ErrorBehaviorState state,
			ErrorTypes targetType, List<Object> subResults) {
		OsateDebug.osateDebug("postProcessCompositeErrorStates " + component.getName() + " state " + state.getName());
		return subResults;
	}

	private Object postProcessErrorBehaviorState(ComponentInstance component, ErrorBehaviorState state, ErrorTypes type,
			Object param) {
		OsateDebug.osateDebug("postProcessErrorBehaviorState " + component.getName() + " state " + state.getName());
		return param;
	}

	private Object processTransitionCondition(ComponentInstance component, ErrorBehaviorState source, ErrorTypes type,
			Object conditionResult, Object stateresult) {
		OsateDebug.osateDebug("processTransitionCondition " + component.getName() + " state " + source.getName());
		return conditionResult;
	}

	private Object preProcessErrorBehaviorState(ComponentInstance component, ErrorBehaviorState state, ErrorTypes type,
			Object param) {
		OsateDebug.osateDebug("preProcessErrorBehaviorState " + component.getName() + " state " + state.getName());
		return param;
	}

	private Object processErrorEvent(ComponentInstance component, ErrorEvent errorModelElement, ErrorTypes type,
			Object param) {
		OsateDebug
				.osateDebug("processErrorEvent " + component.getName() + " error event " + errorModelElement.getName());
		return param;
	}

	private Object preProcessAnd(ComponentInstance component, ConditionExpression condition, ErrorTypes type,
			double scale, Object param) {
		OsateDebug.osateDebug("preProcessAnd " + component.getName());
		return param;
	}

	private Object postProcessAnd(ComponentInstance component, ConditionExpression condition, ErrorTypes type,
			double scale, List<Object> subResults) {
		OsateDebug.osateDebug("postProcessAnd " + component.getName());
		return subResults;
	}

	private Object postProcessXor(ComponentInstance component, ConditionExpression condition, ErrorTypes type,
			double scale, Object param) {
		OsateDebug.osateDebug("postProcessXor " + component.getName());
		return param;
	}

	private Object preProcessXor(ComponentInstance component, ConditionExpression condition, ErrorTypes type,
			double scale, Object param) {
		OsateDebug.osateDebug("posteProcessXor " + component.getName());
		return param;
	}

}
