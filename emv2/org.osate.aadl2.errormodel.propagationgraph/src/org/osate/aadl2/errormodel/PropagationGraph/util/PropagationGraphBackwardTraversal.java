package org.osate.aadl2.errormodel.PropagationGraph.util;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.Element;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.errormodel.PropagationGraph.PropagationGraph;
import org.osate.aadl2.errormodel.PropagationGraph.PropagationGraphPath;
import org.osate.aadl2.errormodel.PropagationGraph.PropagationPathEnd;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
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
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorType;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypes;
import org.osate.xtext.aadl2.errormodel.errorModel.OrExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.OrmoreExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.OutgoingPropagationCondition;
import org.osate.xtext.aadl2.errormodel.errorModel.QualifiedErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.SConditionElement;
import org.osate.xtext.aadl2.errormodel.errorModel.TransitionBranch;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeToken;
import org.osate.xtext.aadl2.errormodel.util.EM2TypeSetUtil;
import org.osate.xtext.aadl2.errormodel.util.EMV2Properties;
import org.osate.xtext.aadl2.errormodel.util.EMV2Util;

public class PropagationGraphBackwardTraversal {

	private PropagationGraph currentAnalysisModel;

	public PropagationGraphBackwardTraversal(PropagationGraph m) {
		currentAnalysisModel = m;
	}

	/**
	 * process an Outgoing Error Propagation by going backwards in the propagation graph
	 * if preProcessOutgoingerrorPropagation returns non-null return its value as traverse result.
	 * First we attempt to go backwards according to the component error behavior, i.e., the OutgoingPropagationCondition.
	 * If subresults is non-null then return value of postProcessingErrorPropagationCOndition.
	 * If not present we do it according to error flow specifications.
	 *
	 * @param component ComponentInstance
	 * @param errorPropagation outgoing ErrorPropagation
	 * @param type ErrorTypes
	 * @return EObject (can be null)
	 */
	public EObject traverseOutgoingErrorPropagation(final ComponentInstance component,
			final ErrorPropagation errorPropagation, ErrorTypes type) {
		List<EObject> subResults = new LinkedList<EObject>();
		type = matchTargetType(errorPropagation.getTypeSet(), type);
		if (type == null) {
			return null;
		}
		EObject found = preProcessOutgoingErrorPropagation(component, errorPropagation, type);
		if (found != null) {
			// used to return cached object
			return found;
		}
		for (OutgoingPropagationCondition opc : EMV2Util.getAllOutgoingPropagationConditions(component)) {
			if ((opc.getTypeToken() != null && !EM2TypeSetUtil.isNoError(opc.getTypeToken()))
					|| opc.getTypeToken() == null) {
				if ((EMV2Util.isSame(opc.getOutgoing(), errorPropagation) || opc.isAllPropagations())
						&& EM2TypeSetUtil.contains(opc.getTypeToken(), type)) {
					EObject res = handleOutgoingErrorPropagationCondition(component, opc, type);
					if (res != null) {
						subResults.add(res);
					}
				}
			}
		}
		if (!subResults.isEmpty()) {
			return postProcessOutgoingErrorPropagation(component, errorPropagation, type, subResults);
		}
		// try to find a path from an inner to an outer error propagation
		EList<PropagationPathEnd> propagationSources = Util.getAllPropagationSourceEnds(currentAnalysisModel, component,
				errorPropagation);

		for (PropagationPathEnd ppe : propagationSources) {
			ComponentInstance componentSource = ppe.getComponentInstance();
			ErrorPropagation propagationSource = ppe.getErrorPropagation();
			EObject res = traverseOutgoingErrorPropagation(componentSource, propagationSource, type);
			if (res != null) {
				subResults.add(res);
			}
		}
		if (!subResults.isEmpty()) {
			return postProcessOutgoingErrorPropagation(component, errorPropagation, type, subResults);
		}

		for (ErrorFlow ef : EMV2Util.getAllErrorFlows(component)) {
			if (ef instanceof ErrorPath) {
				ErrorPath ep = (ErrorPath) ef;

				/**
				 * Make sure that the error type we are looking for is contained
				 * in the error types for the out propagation.
				 * This is a fix for the JMR/SAVI WBS model.
				 */
				if (EMV2Util.isSame(ep.getOutgoing(), errorPropagation)) {
					if (ep.getTargetToken() != null && EM2TypeSetUtil.contains(ep.getTargetToken(), type)) {
						// we have a type mapping
						EList<TypeToken> result;
						if (ep.getTypeTokenConstraint() != null) {
							// get type from path constraint
							result = EM2TypeSetUtil.generateAllLeafTypeTokens(ep.getTypeTokenConstraint(),
									EMV2Util.getUseTypes(ep));
						} else {
							// get incoming type from propagation
							result = EM2TypeSetUtil.generateAllLeafTypeTokens(ep.getIncoming().getTypeSet(),
									EMV2Util.getUseTypes(ep));
						}
						for (TypeToken typeToken : result) {
							EList<ErrorTypes> tl = typeToken.getType();
							// TODO deal with type product
							ErrorTypes newtype = tl.get(0);
							EObject newEvent = traverseIncomingErrorPropagation(component, ep.getIncoming(),
									newtype);
							if (newEvent != null) {
								subResults.add(newEvent);
							}
						}
					} else {
						// no type mapping
						EObject newEvent = traverseIncomingErrorPropagation(component, ep.getIncoming(), type);
						if (newEvent != null) {
							subResults.add(newEvent);
						}
					}
				}
			} else if (ef instanceof ErrorSource) {
				ErrorSource errorSource = (ErrorSource) ef;

				if (EMV2Util.isSame(errorSource.getSourceModelElement(), errorPropagation)) {
					if (EM2TypeSetUtil.contains(errorSource.getTypeTokenConstraint(), type)) {
						EObject newEvent = processErrorSource(component, errorSource, type);
						if (newEvent != null) {
							subResults.add(newEvent);
						}
					}
				}
			}
		}
		if (!subResults.isEmpty()) {
			return postProcessErrorFlows(component, errorPropagation, type, subResults);
		}
		return processOutgoingErrorPropagation(component, errorPropagation, type);
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
	private ErrorTypes mapTargetType(ErrorTypes constraint, ErrorTypes original) {
		if (constraint == null) {
			return original;
		}
		if (original == null) {
			return constraint;
		}
		return EM2TypeSetUtil.contains(constraint, original) ? original : constraint;
	}

	private ErrorTypes matchTargetType(ErrorTypes constraint, ErrorTypes original) {
		if (constraint == null) {
			return original;
		}
		if (original == null) {
			return constraint;
		}
		return EM2TypeSetUtil.contains(constraint, original) ? original : null;
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
			conditionResult = processCondition(component, opc.getCondition(), type, 1, false);
		}
		ErrorBehaviorState state = opc.getState();
		if (state != null) {
			ErrorTypes newtype = null;
			if (opc.getTypeTokenConstraint() != null) {
				newtype = mapTargetType(opc.getTypeTokenConstraint(), type);
			} else if (state.getTypeSet() != null) {
				newtype = mapTargetType(state.getTypeSet(), type);
			}
			if (newtype instanceof ErrorType || newtype == null) {
				stateResult = traverseErrorBehaviorState(component, state, newtype);
			} else {
				// multiple types to trace back
				EList<TypeToken> types = EM2TypeSetUtil.generateAllLeafTypeTokens((TypeSet) newtype,
						EMV2Util.getUseTypes(opc));
				List<EObject> subResults = new LinkedList<EObject>();
				for (TypeToken typeToken : types) {
					EList<ErrorTypes> tl = typeToken.getType();
					// TODO deal with type product
					EObject res = traverseErrorBehaviorState(component, opc.getState(), tl.get(0));
					if (res != null) {
						subResults.add(res);
					}
				}
				if (subResults.isEmpty()) {
					stateResult = processErrorBehaviorState(component, state, type);
				} else if (subResults.size() == 1) {
					stateResult = subResults.get(0);
				} else {
					stateResult = postProcessXor(component, state, newtype, 1, subResults);
				}
			}
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
	 * process error state. Recursively deal with source states of transitions (an PRIORITY AND gate).
	 * We only process error events (not recover or repair) and error propagations referenced by the expression.
	 * @param component ComponentInstance
	 * @param state ErrorBehaviorState
	 * @param type ErrorTypes
	 * @return EObject (can be null)
	 */
	public EObject traverseErrorBehaviorState(ComponentInstance component, ErrorBehaviorState state, ErrorTypes type) {
		if (state == null) {
			return null;
		}
		List<EObject> subResults = new LinkedList<EObject>();
		preProcessErrorBehaviorState(component, state, type);
		Collection<ErrorBehaviorTransition> transitions = EMV2Util.getAllErrorBehaviorTransitions(component);
		for (ErrorBehaviorTransition ebt : transitions) {
			ConditionExpression conditionExpression = null;
			// XXX deal with types on states
			double scale = 1;
			boolean sameState = false;
			ErrorTypes newtype = type;
			if (ebt.getTarget() != null && EMV2Util.isSame(state, ebt.getTarget())
					&& EM2TypeSetUtil.contains(ebt.getTargetToken(), type)) {
				conditionExpression = ebt.getCondition();
				if (ebt.getSource() != null && EMV2Util.isSame(state, ebt.getSource())
						&& EM2TypeSetUtil.isSame(type, ebt.getTypeTokenConstraint())) {
					sameState = true;
					newtype = mapTargetType(ebt.getTypeTokenConstraint(), type);
				}
			} else if (!ebt.getDestinationBranches().isEmpty()) {
				// deal with transition branches
				EList<TransitionBranch> tbs = ebt.getDestinationBranches();
				for (TransitionBranch transitionBranch : tbs) {
					if (transitionBranch.getTarget() != null) {
						if (EMV2Util.isSame(transitionBranch.getTarget(), state)
								&& EM2TypeSetUtil.contains(transitionBranch.getTargetToken(), type)) {
							conditionExpression = ebt.getCondition();
							if (EMV2Util.isSame(ebt.getSource(), state)
									&& EM2TypeSetUtil.isSame(type, ebt.getTypeTokenConstraint())) {
								sameState = true;
								newtype = mapTargetType(ebt.getTypeTokenConstraint(), type);
							}

						}
					} else if (transitionBranch.isSteadyState()) {
						// same state
						if (ebt.getSource() != null && EMV2Util.isSame(state, ebt.getSource())
								&& EM2TypeSetUtil.isSame(type, ebt.getTypeTokenConstraint())) {
							conditionExpression = ebt.getCondition();
							sameState = true;
							newtype = mapTargetType(ebt.getTypeTokenConstraint(), type);
						}
					}
					if (conditionExpression != null) {
						BranchValue val = transitionBranch.getValue();
						if (val.getRealvalue() != null) {
							scale = Double.valueOf(val.getRealvalue());
						} else if (val.getSymboliclabel() != null) {
							ComponentClassifier cl = EMV2Util.getAssociatedClassifier(ebt);
							List<EMV2PropertyAssociation> pa = EMV2Properties
									.getProperty(val.getSymboliclabel().getQualifiedName(), cl, ebt, null);
							for (EMV2PropertyAssociation emv2PropertyAssociation : pa) {
								scale = scale + EMV2Properties.getRealValue(emv2PropertyAssociation);
							}
						}
						break;
					}
				}
			} else if (ebt.isSteadyState()) {
				// same state
				if (ebt.getSource() != null && EMV2Util.isSame(state, ebt.getSource())
						&& EM2TypeSetUtil.isSame(type, ebt.getTypeTokenConstraint())) {
					conditionExpression = ebt.getCondition();
					sameState = true;
					newtype = mapTargetType(ebt.getTypeTokenConstraint(), type);
				}
			}
			if (!sameState && conditionExpression != null) {
				// don't include transition staying in same state
				EObject conditionResult = processCondition(component, conditionExpression, type, scale, false);
				// XXX this is the recursive call
				// do not traverse back in same state
				// we also do not traverse back if left is allstates.
				if (conditionResult != null) {
					EObject stateResult = null;
					if (!(sameState || ebt.isAllStates())) {
						if (newtype instanceof ErrorType || newtype == null) {
							stateResult = traverseErrorBehaviorState(component, ebt.getSource(), newtype);
						} else if (newtype instanceof TypeSet) {
							EList<TypeToken> leaftypes = EM2TypeSetUtil.generateAllLeafTypeTokens((TypeSet) newtype,
									EMV2Util.getUseTypes(ebt));
							List<EObject> subsubResults = new LinkedList<EObject>();
							for (TypeToken typeToken : leaftypes) {
								EList<ErrorTypes> tl = typeToken.getType();
								// TODO deal with type product
								ErrorTypes ntype = tl.get(0);
								EObject newEvent = traverseErrorBehaviorState(component, state, ntype);
								if (newEvent != null) {
									subsubResults.add(newEvent);
								}
							}
							if (subsubResults.isEmpty()) {
								stateResult = processErrorBehaviorState(component, state, type);
							} else if (subsubResults.size() == 1) {
								stateResult = subsubResults.get(0);
							} else {
								stateResult = postProcessXor(component, state, newtype, scale,
										subsubResults);
							}
						}
					}
					if (stateResult != null) {
						EObject tmpresult = processTransitionCondition(component, ebt.getSource(), type,
								conditionResult, stateResult);
						if (tmpresult != null) {
							subResults.add(tmpresult);
						}
					} else if (stateResult == null) {
						subResults.add(conditionResult);
					}
				}
			}
		}
		if (!subResults.isEmpty()) {
			return postProcessErrorBehaviorState(component, state, type, subResults);
		}
		// subResults is empty if state without incoming transition triggered by error events or incoming propagations
		// or if no transitions specified for state machine
		if (transitions.isEmpty()) {
			// we cannot trace back to an error event triggering a transition
			// give the opportunity to present the error state as Event
			return traverseCompositeErrorStateOnly(component, state, type);// processErrorBehaviorState(component, state, type);
		} else {
			// we have found an operational error state (no incoming transitions with error events)
			// Do not include
			return null;
		}
	}


	/**
	 * create the appropriate FTA events according to the expression.
	 * When calculating the probability apply the specified scale to each probability..
	 * Used to perform scaling according to the transition branch probability.
	 * @param component
	 * @param condition
	 * @param type
	 * @param scale
	 * @param stateOnly do not trace via transitions
	 * @return an EObject related to the condition (can be null)
	 */
	public EObject processCondition(ComponentInstance component, ConditionExpression condition, ErrorTypes type,
			double scale, boolean stateOnly) {
		/**
		 * We have an AND expression, so, we create an EVENT to AND' sub events.
		 */
		if (condition instanceof AndExpression) {
			preProcessAnd(component, condition, type, scale);
			AndExpression expression = (AndExpression) condition;
			List<EObject> subResults = new LinkedList<EObject>();

			for (ConditionExpression ce : expression.getOperands()) {
				EObject res = processCondition(component, ce, type, scale, stateOnly);
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
				for (ConditionExpression ce : allCondition.getOperands()) {
					EObject res = processCondition(component, ce, type, scale, stateOnly);
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
				EObject res = processCondition(component, ce, type, scale, stateOnly);
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
					EObject res = processCondition(component, ce, type, scale, stateOnly);
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
					ErrorBehaviorState state = EMV2Util.getState(sconditionElement);
					// either original type or mapped to constraint in condition or type set on state declaration
					ErrorTypes referencedErrorType = (sconditionElement.getConstraint() != null)
							? sconditionElement.getConstraint()
									: state.getTypeSet();
							if (referencedInstance != null) {
								if (referencedErrorType == null || referencedErrorType instanceof ErrorType) {
									result = traverseCompositeErrorState(referencedInstance, state,
											referencedErrorType, stateOnly);
								} else {
									// handle type set on states
									// get incoming type from propagation
									EList<TypeToken> leaftypes = EM2TypeSetUtil.generateAllLeafTypeTokens(
											(TypeSet) referencedErrorType,
											EMV2Util.getUseTypes(state));
									List<EObject> subResults = new LinkedList<EObject>();
									for (TypeToken typeToken : leaftypes) {
										EList<ErrorTypes> tl = typeToken.getType();
										// TODO deal with type product
										ErrorTypes newtype = tl.get(0);
										EObject newEvent = traverseCompositeErrorState(component, state,
												newtype, stateOnly);
										if (newEvent != null) {
											subResults.add(newEvent);
										}
									}
									if (subResults.isEmpty()) {
										return processErrorBehaviorState(referencedInstance,
												EMV2Util.getState(sconditionElement), referencedErrorType);
									} else if (subResults.size() == 1) {
										return subResults.get(0);
									} else {
										return postProcessXor(component, sconditionElement, referencedErrorType, scale,
												subResults);
									}
								}
								if (result != null) {
									return result;
								}
								return processErrorBehaviorState(referencedInstance, EMV2Util.getState(sconditionElement),
										referencedErrorType);
							}
				} else if (sconditionElement.getQualifiedErrorPropagationReference() != null) {
					EMV2Path path = sconditionElement.getQualifiedErrorPropagationReference();
					ComponentInstance referencedInstance = EMV2Util.getLastComponentInstance(path, component);
					EObject result = null;
					ErrorPropagation ep = EMV2Util.getErrorPropagation(path);
					// either original type or mapped to constraint in condition or type set on state declaration
					ErrorTypes referencedErrorType = (sconditionElement.getConstraint() != null)
							? sconditionElement.getConstraint()
									: ep.getTypeSet();
							if (referencedInstance != null) {
								if (referencedErrorType == null || referencedErrorType instanceof ErrorType) {
									result = traverseIncomingErrorPropagation(referencedInstance, ep, referencedErrorType);
								} else {
									// handle type set on states
									// get incoming type from propagation
									EList<TypeToken> leaftypes = EM2TypeSetUtil
											.generateAllLeafTypeTokens((TypeSet) referencedErrorType, EMV2Util.getUseTypes(ep));
									List<EObject> subResults = new LinkedList<EObject>();
									for (TypeToken typeToken : leaftypes) {
										EList<ErrorTypes> tl = typeToken.getType();
										// TODO deal with type product
										ErrorTypes newtype = tl.get(0);
								EObject newEvent = traverseIncomingErrorPropagation(component, ep, newtype);
										if (newEvent != null) {
											subResults.add(newEvent);
										}
									}
									if (subResults.isEmpty()) {
										return processIncomingErrorPropagation(referencedInstance, ep, referencedErrorType);
									} else if (subResults.size() == 1) {
										return subResults.get(0);
									} else {
										return postProcessXor(component, sconditionElement, referencedErrorType, scale,
												subResults);
									}
								}
								if (result != null) {
									return result;
								}
								return processErrorBehaviorState(referencedInstance, EMV2Util.getState(sconditionElement),
										referencedErrorType);
							}
				}
				// should not reach this
				return processErrorBehaviorState(component, EMV2Util.getState(sconditionElement), null);
			}

			if (conditionElement.getConstraint() != null) {
				if (EM2TypeSetUtil.isNoError(conditionElement.getConstraint())) {
					// this is a recovery transition since an incoming propagation constraint is NoError
					return null;
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
					ErrorTypes referencedErrorType = conditionElement.getConstraint() != null
							? mapTargetType(conditionElement.getConstraint(), type)
									: mapTargetType(((ErrorEvent) errorModelElement).getTypeSet(), type);
							return processErrorEvent(component, (ErrorEvent) errorModelElement, referencedErrorType, scale);
				}

				/**
				 * Here, we have an error propagation. This is notified with the
				 * in propagation within a composite error model.
				 */
				if (errorModelElement instanceof ErrorPropagation) {
					ErrorPropagation errorPropagation = (ErrorPropagation) errorModelElement;
					ErrorTypes referencedErrorType = conditionElement.getConstraint() != null
							? mapTargetType(conditionElement.getConstraint(), type)
									: mapTargetType(errorPropagation.getTypeSet(), type);
							if (EM2TypeSetUtil.isNoError(referencedErrorType)) {
								// this is a recovery transition since an incoming propagation became error free
								return null;
							}
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


	/**
	 * traverse backwards according to propagation paths
	 * if preProcessing result is non-null return it instead of result of actual traversal (used for shared subtrees)
	 * handle external incoming propagations as origin by calling on processIncomingErrorPropagation
	 * handle source outgoing propagation
	 * collection of those results are post processed postProcessIncomingPropagation.
	 * If empty incoming propagation itself is processed as "leaf" by processIncomingErrorPropagation
	 * @param component component instance with incoming propagation
	 * @param errorPropagation incoming propagation
	 * @param type error type
	 * @return EObject (can be null)
	 */
	private EObject traverseIncomingErrorPropagation(ComponentInstance component, ErrorPropagation errorPropagation,
			ErrorTypes type) {
		List<EObject> subResults = new LinkedList<EObject>();
		type = matchTargetType(errorPropagation.getTypeSet(), type);
		if (type == null) {
			return null;
		}
		EObject preResult = preProcessIncomingErrorPropagation(component, errorPropagation, type);
		if (preResult != null) {
			return preResult;
		}
		for (PropagationGraphPath ppr : Util.getAllReversePropagationPaths(currentAnalysisModel, component,
				errorPropagation)) {
			// traverse incoming
			PropagationPathEnd ppe = ppr.getPathSrc();
			if (ppr.getConnection() != null) {
				ErrorSource ces = EMV2Util.findConnectionErrorSourceForConnection(ppr.getConnection());
				// the type constraint has to come from the error source as the connection does not have one
				if (ces != null && EM2TypeSetUtil.contains(ces.getTypeTokenConstraint(), type)) {
					EObject result = processConnectionErrorSource(ppr.getConnection(), ces, type);
					if (result != null) {
						subResults.add(result);
					}
				}
			} else {
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
		}
		if (!subResults.isEmpty()) {
			return postProcessIncomingErrorPropagation(component, errorPropagation, type, subResults);
		}
		return processIncomingErrorPropagation(component, errorPropagation, type);
	}

	/**
	 * Process composite error states whose target is the specified state.
	 * We process the composite state condition and as result recurse on states down the hierarchy
	 * If the composite results in empty sub results (leaf states)
	 * we process the leaf state according to transitions.
	 *
	 * @param component the component under analysis
	 * @param state the target state under analysis
	 * @param type Error Type
	 * @return - EObject (non-null)
	 */
	public EObject traverseCompositeErrorState(ComponentInstance component, ErrorBehaviorState state, ErrorTypes type) {
		return traverseCompositeErrorState(component, state, type, false);
	}

	public EObject traverseCompositeErrorState(ComponentInstance component, ErrorBehaviorState state, ErrorTypes type,
			boolean stateOnly) {
		preProcessCompositeErrorStates(component, state, type);
		List<EObject> subResults = new LinkedList<EObject>();
		// should only match one composite state declaration.
		for (CompositeState cs : EMV2Util.getAllCompositeStates(component)) {
			if (cs.getState() == state && EM2TypeSetUtil.contains(cs.getTypedToken(), type)) {
				EObject res = processCondition(component, cs.getCondition(), type, 1, stateOnly);
				if (res != null) {
					subResults.add(res);
				}
			}
		}
		if (!subResults.isEmpty()) {
			return postProcessCompositeErrorStates(component, state, type, subResults);
		}
		if (stateOnly) {
			return processErrorBehaviorState(component, state, type);
		} else {
			return traverseErrorBehaviorState(component, state, type);
		}
	}

	public EObject traverseCompositeErrorStateOnly(ComponentInstance component, ErrorBehaviorState state,
			ErrorTypes type) {
		return traverseCompositeErrorState(component, state, type, true);
	}

//	methods to be overwritten by applications

	/**
	 * post process results from back traversal
	 * called with non-empty subResults list
	 * @param component
	 * @param errorPropagation
	 * @param targetType
	 * @param subResults
	 * @return EObject (can be null)
	 */
	protected EObject postProcessOutgoingErrorPropagation(ComponentInstance component,
			ErrorPropagation errorPropagation, ErrorTypes targetType, List<EObject> subResults) {
//		OsateDebug.osateDebug("postProcessOutgoingErrorPropagation " + component.getName() + " propagation "
//				+ EMV2Util.getPropagationName(errorPropagation));
		return null;
	}

	/**
	 * pre process outgoing propagation
	 * Non-null result will use it as result of traversal
	 * This allows handling of previously produced subtrees
	 * @param component
	 * @param errorPropagation
	 * @param targetType
	 * @return EObject or null
	 */
	protected EObject preProcessOutgoingErrorPropagation(ComponentInstance component, ErrorPropagation errorPropagation,
			ErrorTypes targetType) {
//		OsateDebug.osateDebug("preProcessOutgoingErrorPropagation " + component.getName() + " propagation "
//				+ EMV2Util.getPropagationName(errorPropagation));
		return null;
	}

	/**
	 * post process results from back traversal
	 * called with non-empty subResults list
	 * @param component
	 * @param errorPropagation
	 * @param targetType
	 * @param subResults
	 * @return EObject (can be null)
	 */
	protected EObject postProcessErrorFlows(ComponentInstance component, ErrorPropagation errorPropagation,
			ErrorTypes targetType, List<EObject> subResults) {
//		OsateDebug.osateDebug("postProcessErrorFlows " + component.getName() + " propagation "
//				+ EMV2Util.getPropagationName(errorPropagation));
		return null;
	}

	/**
	 * process error source as leaf of traversal
	 * @param component
	 * @param errorSource
	 * @param typeTokenConstraint
	 * @return EObject (can be null)
	 */
	protected EObject processErrorSource(ComponentInstance component, ErrorSource errorSource, ErrorTypes type) {
//		OsateDebug.osateDebug("processErrorSource " + component.getName() + " error source " + errorSource.getName());
		return null;
	}

	/**
	 * process connection error source as leaf of traversal
	 * @param connection instance
	 * @param errorSource
	 * @param typeTokenConstraint
	 * @return EObject (can be null)
	 */
	protected EObject processConnectionErrorSource(ConnectionInstance component, ErrorSource errorSource,
			ErrorTypes typeTokenConstraint) {
//		OsateDebug.osateDebug("processErrorSource " + component.getName() + " error source " + errorSource.getName());
		return null;
	}

	/**
	 * pre process incoming propagation
	 * Non-null result will use it as result of traversal
	 * This allows handling of previously produced subtrees
	 * @param component
	 * @param errorPropagation
	 * @param targetType
	 * @return EObject or null
	 */
	protected EObject preProcessIncomingErrorPropagation(ComponentInstance component, ErrorPropagation errorPropagation,
			ErrorTypes type) {
//		OsateDebug.osateDebug("preProcessIncomingErrorPropagation " + component.getName() + " propagation "
//				+ EMV2Util.getPropagationName(errorPropagation));
		return null;
	}

	/**
	 * process incoming propagation as leaf of traversal
	 * @param component ComponnetInstance
	 * @param incoming ErrorPropagation
	 * @param type Error Type
	 * @return EObject (can be null but is expected to return object representing traversal leaf)
	 */
	protected EObject processIncomingErrorPropagation(ComponentInstance component, ErrorPropagation incoming,
			ErrorTypes type) {
//		OsateDebug.osateDebug("processIncomingErrorPropagation " + component.getName() + " propagation "
//				+ EMV2Util.getPropagationName(incoming));
		return null;
	}

	/**
	 * post process results from back traversal
	 * called with non-empty subResults list
	 * @param component
	 * @param errorPropagation
	 * @param targetType
	 * @param subResults
	 * @return EObject (can be null)
	 */
	protected EObject postProcessIncomingErrorPropagation(ComponentInstance component,
			ErrorPropagation errorPropagation, ErrorTypes targetType, List<EObject> subResults) {
//		OsateDebug.osateDebug("postProcessIncomingErrorPropagation " + component.getName() + " propagation "
//				+ EMV2Util.getPropagationName(errorPropagation));
		return null;
	}

	/**
	 * process outgoing propagation as leaf of traversal
	 * @param component ComponnetInstance
	 * @param outgoing ErrorPropagation
	 * @param type Error Type
	 * @return EObject (can be null but is expected to return object representing traversal leaf)
	 */
	protected EObject processOutgoingErrorPropagation(ComponentInstance component, ErrorPropagation ep,
			ErrorTypes type) {
//		OsateDebug
//				.osateDebug("processOutgoingErrorPropagation " + component.getName() + " propagation " + ep.getName());
		return null;
	}

	/**
	 * process outgoing EP condition with both conditional result and state result non-null
	 * @param component Component Instance
	 * @param opc outgoing error propagation condition
	 * @param type Error Type
	 * @param conditionResult trigger condition result object
	 * @param stateResult original state result object
	 * @return EObject or null
	 */
	protected EObject processOutgoingErrorPropagationCondition(ComponentInstance component,
			OutgoingPropagationCondition opc, ErrorTypes type, EObject conditionResult, EObject stateResult) {
//		OsateDebug.osateDebug(
//				"processOutgoingErrorPropagationCondition " + component.getName() + " condition " + opc.getName());
		return null;
	}

	/**
	 * pre process composite states
	 * Non-null result will use it as result of traversal
	 * This allows handling of previously produced subtrees
	 * @param component
	 * @param state
	 * @param targetType
	 * @return EObject or null
	 */
	protected EObject preProcessCompositeErrorStates(ComponentInstance component, ErrorBehaviorState state,
			ErrorTypes targetType) {
//		OsateDebug.osateDebug("preProcessCompositeErrorStates " + component.getName() + " state " + state.getName());
		return null;
	}

	/**
	 * post process results composite error states back traversal result
	 * called with non-empty subResults list
	 * @param component
	 * @param state
	 * @param targetType
	 * @param subResults
	 * @return EObject (can be null )
	 */
	protected EObject postProcessCompositeErrorStates(ComponentInstance component, ErrorBehaviorState state,
			ErrorTypes targetType, List<EObject> subResults) {
//		OsateDebug.osateDebug("postProcessCompositeErrorStates " + component.getName() + " state " + state.getName());
		return null;
	}

	/**
	 * pre process error behavior state
	 * Non-null result will use it as result of traversal
	 * This allows handling of previously produced subtrees
	 * @param component
	 * @param state
	 * @param type
	 * @return EObject or null
	 */
	protected EObject preProcessErrorBehaviorState(ComponentInstance component, ErrorBehaviorState state,
			ErrorTypes type) {
//		OsateDebug.osateDebug("preProcessErrorBehaviorState " + component.getName() + " state " + state.getName());
		return null;
	}

	/**
	 * post process error behavior state back traversal result based on transitions
	 * called with non-empty subResults list
	 * @param component
	 * @param state
	 * @param targetType
	 * @param subResults
	 * @return EObject (can be null )
	 */
	protected EObject postProcessErrorBehaviorState(ComponentInstance component, ErrorBehaviorState state,
			ErrorTypes type, List<EObject> subResults) {
//		OsateDebug.osateDebug("postProcessErrorBehaviorState " + component.getName() + " state " + state.getName());
		return null;
	}

	/**
	 * process error behavior state as leaf of traversal
	 * @param component ComponentInstance
	 * @param state
	 * @param type Error Type
	 * @return EObject (can be null but is expected to return object representing traversal leaf)
	 */
	protected EObject processErrorBehaviorState(ComponentInstance component, ErrorBehaviorState state,
			ErrorTypes type) {
//		OsateDebug.osateDebug("processErrorBehaviorState " + component.getName() + " state " + state.getName());
		return null;
	}

	/**
	 * process results of trigger condition and state backward traversal.
	 * @param component
	 * @param source ErrorBehaviorState
	 * @param type Error Type
	 * @param conditionResult (non-null)
	 * @param stateResult (non-null)
	 * @return EObject (non-null)
	 */
	protected EObject processTransitionCondition(ComponentInstance component, ErrorBehaviorState source,
			ErrorTypes type, EObject conditionResult, EObject stateResult) {
//		OsateDebug.osateDebug("processTransitionCondition " + component.getName() + " state " + source.getName());
		return null;
	}

	/**
	 * process error event as leaf of traversal
	 * @param component ComponentInstance
	 * @param event Error Event
	 * @param type Error Type
	 * @return EObject (can be null but is expected to return object representing traversal leaf)
	 */
	protected EObject processErrorEvent(ComponentInstance component, ErrorEvent errorEvent, ErrorTypes type,
			double scale) {
//		OsateDebug.osateDebug("processErrorEvent " + component.getName() + " error event " + errorEvent.getName());
		return null;
	}

	/**
	 * pre process results AND expression
	 * called with non-empty subResults list
	 * @param component
	 * @param condition AND expression
	 * @param type Error Type
	 * @param scale scaling factor for probability
	 * @param subResults
	 * @return EObject (can be null )
	 */
	protected EObject preProcessAnd(ComponentInstance component, Element condition, ErrorTypes type,
			double scale) {
//		OsateDebug.osateDebug("preProcessAnd " + component.getName());
		return null;
	}

	/**
	 * post process results AND expression
	 * called with non-empty subResults list
	 * @param component
	 * @param condition AND expression
	 * @param type Error Type
	 * @param scale scaling factor for probability
	 * @param subResults
	 * @return EObject (can be null )
	 */
	protected EObject postProcessAnd(ComponentInstance component, Element condition, ErrorTypes type,
			double scale, List<EObject> subResults) {
//		OsateDebug.osateDebug("postProcessAnd " + component.getName());
		return null;
	}

	/**
	 * post process results XOR expression
	 * called with non-empty subResults list
	 * @param component
	 * @param condition XOR expression
	 * @param type Error Type
	 * @param scale scaling factor for probability
	 * @param subResults
	 * @return EObject (can be null )
	 */
	protected EObject postProcessXor(ComponentInstance component, Element condition, ErrorTypes type,
			double scale, List<EObject> subResults) {
//		OsateDebug.osateDebug("postProcessXor " + component.getName());
		return null;
	}

	/**
	 * pre process results XOR expression
	 * called with non-empty subResults list
	 * @param component
	 * @param condition XOR expression
	 * @param type Error Type
	 * @param scale scaling factor for probability
	 * @param subResults
	 * @return EObject (can be null )
	 */
	protected EObject preProcessXor(ComponentInstance component, Element condition, ErrorTypes type,
			double scale) {
//		OsateDebug.osateDebug("postProcessXor " + component.getName());
		return null;
	}

	/**
	 * post process results OR expression
	 * called with non-empty subResults list
	 * @param component
	 * @param condition OR expression
	 * @param type Error Type
	 * @param scale scaling factor for probability
	 * @param subResults
	 * @return EObject (can be null )
	 */
	protected EObject postProcessOr(ComponentInstance component, Element condition, ErrorTypes type,
			double scale, List<EObject> subResults) {
//		OsateDebug.osateDebug("postProcessOr " + component.getName());
		return null;
	}

	/**
	 * pre process results OR expression
	 * called with non-empty subResults list
	 * @param component
	 * @param condition OR expression
	 * @param type Error Type
	 * @param scale scaling factor for probability
	 * @param subResults
	 * @return EObject (can be null )
	 */
	protected EObject preProcessOr(ComponentInstance component, Element condition, ErrorTypes type,
			double scale) {
//		OsateDebug.osateDebug("postProcessOr " + component.getName());
		return null;
	}

}
