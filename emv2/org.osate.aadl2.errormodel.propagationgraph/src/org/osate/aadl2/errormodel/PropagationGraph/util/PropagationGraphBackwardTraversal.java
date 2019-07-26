package org.osate.aadl2.errormodel.PropagationGraph.util;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.Element;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.errormodel.FaultTree.util.FaultTreeUtils;
import org.osate.aadl2.errormodel.PropagationGraph.PropagationGraph;
import org.osate.aadl2.errormodel.PropagationGraph.PropagationGraphPath;
import org.osate.aadl2.errormodel.PropagationGraph.PropagationPathEnd;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.FeatureInstance;
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
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelFactory;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPath;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorSource;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorType;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypes;
import org.osate.xtext.aadl2.errormodel.errorModel.EventOrPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.OrExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.OrmoreExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.OutgoingPropagationCondition;
import org.osate.xtext.aadl2.errormodel.errorModel.QualifiedErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.SConditionElement;
import org.osate.xtext.aadl2.errormodel.errorModel.TransitionBranch;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeToken;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeTransformationSet;
import org.osate.xtext.aadl2.errormodel.util.EMV2Properties;
import org.osate.xtext.aadl2.errormodel.util.EMV2TypeSetUtil;
import org.osate.xtext.aadl2.errormodel.util.EMV2Util;
import org.osate.xtext.aadl2.errormodel.util.ErrorModelState;
import org.osate.xtext.aadl2.errormodel.util.ErrorModelStateAdapterFactory;

import com.google.common.collect.HashMultimap;

public class PropagationGraphBackwardTraversal {


	public static BigDecimal BigZero = new BigDecimal(0.0);
	public static BigDecimal BigOne = new BigDecimal(1.0);

	private PropagationGraph currentAnalysisModel;

	public PropagationGraphBackwardTraversal(PropagationGraph m) {
		currentAnalysisModel = m;
	}

	public static EObject foundCycle = ErrorModelFactory.eINSTANCE.createTypeToken();

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
			final ErrorPropagation errorPropagation, ErrorTypes type, BigDecimal scale) {
		List<EObject> subResults = new LinkedList<EObject>();
		type = matchTargetType(errorPropagation.getTypeSet(), type);
		if (type == null) {
			return null;
		}
		EObject found = preProcessOutgoingErrorPropagation(component, errorPropagation, type, scale);
		if (found != null) {
			return found;// found common event
		}
		// we want to track cycles.
		// we do that by tagging the feature instance of the error propagation with the error type (as token)
		ErrorModelState st = null;
		FeatureInstance fi = EMV2Util.findFeatureInstance(errorPropagation, component);
		if (fi != null) {
			st = (ErrorModelState) ErrorModelStateAdapterFactory.INSTANCE.adapt(fi, ErrorModelState.class);
		} else {
			st = (ErrorModelState) ErrorModelStateAdapterFactory.INSTANCE.adapt(component, ErrorModelState.class);
		}
		TypeToken tt = ErrorModelFactory.eINSTANCE.createTypeToken();
		tt.getType().add(type);
		if (st.visited(errorPropagation, tt)) {
			// we were there before.
			return foundCycle;
		} else {
			st.setVisitToken(errorPropagation, tt);
		}

		boolean pruneGraph = false;

		// processing call has to be after the preproccessing call so it is not found and we proceed in processing.
		// On the other hand it needs to be called here so the event exists in ftamodel and is found the next time around.
		// Originally we were creating the events bottom up thus the loop did not find the event.
//		EObject myEvent = processOutgoingErrorPropagation(component, errorPropagation, type, scale);

		HashMultimap<ErrorPropagation, String> handledEOPs = HashMultimap.create();
		Collection<ErrorFlow> errorFlows = EMV2Util.getAllErrorFlows(component);
		Collection<OutgoingPropagationCondition> opcs = EMV2Util.getAllOutgoingPropagationConditions(component);
		for (OutgoingPropagationCondition opc : opcs) {
			if ((opc.getTypeToken() != null && !EMV2TypeSetUtil.isNoError(opc.getTypeToken()))
					|| opc.getTypeToken() == null) {
				if (opc.isAllPropagations() || (EMV2Util.isSame(opc.getOutgoing(), errorPropagation))
						&& EMV2TypeSetUtil.contains(opc.getTypeToken(), type)) {
					EObject res = handleOutgoingErrorPropagationCondition(component, opc, type, handledEOPs,
							scale);
					if (res == foundCycle) {
						pruneGraph = true;
					} else if (res != null) {
						subResults.add(res);
					} else {
						pruneGraph = true;
					}
				}
			}
		}
		// try to find a path from an outer to an inner out error propagation
		EList<PropagationPathEnd> propagationSources = Util.getAllPropagationSourceEnds(currentAnalysisModel, component,
				errorPropagation);
		for (PropagationPathEnd ppe : propagationSources) {
			ComponentInstance componentSource = ppe.getComponentInstance();
			ErrorPropagation propagationSource = ppe.getErrorPropagation();
			if (propagationSource.getDirection() == DirectionType.OUT) {
				Set<ErrorPropagation> eops = handledEOPs.keySet();
				if (!containsEOP(eops, propagationSource)) {
					// if not already handled by a opc
					EObject res = traverseOutgoingErrorPropagation(componentSource, propagationSource, type, scale);
					if (res == foundCycle) {
						pruneGraph = true;
					} else if (res != null) {
						subResults.add(res);
					} else {
						pruneGraph = true;
					}
				}
			}
		}
		for (ErrorFlow ef : errorFlows) {
			if (ef instanceof ErrorPath) {
				ErrorPath ep = (ErrorPath) ef;
				if (handledEOPs.containsEntry(ep.getIncoming(), EMV2Util.getPrintName(type))) {
					// already handled by a opc
					continue;
				}
				if (Util.conditionHolds(ef, component)) {
					/**
					 * Make sure that the error type we are looking for is contained
					 * in the error types for the out propagation.
					 * This is a fix for the JMR/SAVI WBS model.
					 */
					if (ep.isAllOutgoing() || EMV2Util.isSame(ep.getOutgoing(), errorPropagation)) {
						BigDecimal newscale = scale;
						double pathprobability = EMV2Properties.getProbability(component, ep, type);
						if (pathprobability > 0) {
							newscale = scale.multiply(new BigDecimal(pathprobability));
						}
						if (ep.getTargetToken() != null) {
							if (EMV2TypeSetUtil.contains(ep.getTargetToken(), type)) {
								// we have a type mapping
								EList<TypeToken> result;
								if (ep.getTypeTokenConstraint() != null) {
									// get type from path constraint
									result = EMV2TypeSetUtil.flattenTypesetElements(ep.getTypeTokenConstraint(),
											EMV2Util.getUseTypes(ep));
								} else {
									// get incoming type from propagation
									result = EMV2TypeSetUtil.flattenTypesetElements(ep.getIncoming().getTypeSet(),
											EMV2Util.getUseTypes(ep));
								}
								for (TypeToken typeToken : result) {
									EList<ErrorTypes> tl = typeToken.getType();
									// TODO deal with type product
									ErrorTypes newtype = mapTargetType(tl.get(0), type);
									if (ep.isAllIncoming()) {
										Collection<ErrorPropagation> inprops = EMV2Util
												.getAllIncomingErrorPropagations(component);
										for (ErrorPropagation eprop : inprops) {
											EObject newEvent = traverseIncomingErrorPropagation(component, eprop,
													newtype, newscale);
											if (newEvent == foundCycle) {
												pruneGraph = true;
											} else if (newEvent != null) {
												subResults.add(newEvent);
											} else {
												pruneGraph = true;
											}
										}

									} else {
										EObject newEvent = traverseIncomingErrorPropagation(component, ep.getIncoming(),
												newtype, newscale);
										if (newEvent == foundCycle) {
											pruneGraph = true;
										} else if (newEvent != null) {
											subResults.add(newEvent);
										} else {
											pruneGraph = true;
										}
									}
								}
							}
						} else {
							// no type mapping
							if (ep.isAllIncoming()) {
								Collection<ErrorPropagation> inprops = EMV2Util
										.getAllIncomingErrorPropagations(component);
								for (ErrorPropagation eprop : inprops) {
									TypeSet matchtype = ep.getTypeTokenConstraint();
									if (matchtype == null) {
										matchtype = eprop.getTypeSet();
										if (EMV2TypeSetUtil.contains(matchtype, type)) {
											EObject newEvent = traverseIncomingErrorPropagation(component, eprop, type,
													newscale);
											if (newEvent == foundCycle) {
												pruneGraph = true;
											} else if (newEvent != null) {
												subResults.add(newEvent);
											} else {
												pruneGraph = true;
											}
										}
									}
								}

							} else {
								ErrorPropagation inep = ep.getIncoming();
								TypeSet matchtype = ep.getTypeTokenConstraint();
								if (matchtype == null) {
									matchtype = inep.getTypeSet();
								}
									if (EMV2TypeSetUtil.contains(matchtype, type)) {
										EObject newEvent = traverseIncomingErrorPropagation(component, inep, type,
												newscale);
										if (newEvent == foundCycle) {
											pruneGraph = true;
										} else if (newEvent != null) {
											subResults.add(newEvent);
										} else {
											pruneGraph = true;
										}
									}
							}
						}
					}
				}
			} else if (ef instanceof ErrorSource) {
				ErrorSource errorSource = (ErrorSource) ef;
				NamedElement src = errorSource.getSourceModelElement();
				if (src instanceof ErrorPropagation) {
					// check if error source was already handled by opc
					ErrorPropagation srcep = (ErrorPropagation) src;
					if (targetsEOP(opcs, srcep, type)) {
						// already handled by a opc with the same target
						continue;
					}
				}
				if (Util.conditionHolds(ef, component)) {
					if (errorSource.isAll() || EMV2Util.isSame(errorSource.getSourceModelElement(), errorPropagation)) {
						if (EMV2TypeSetUtil.contains(errorSource.getTypeTokenConstraint(), type)) {
							EObject newEvent = processErrorSource(component, errorSource, type, scale);
							if (newEvent == foundCycle) {
								pruneGraph = true;
							} else if (newEvent != null) {
								subResults.add(newEvent);
							} else {
								pruneGraph = true;
							}
						}
					}
				}
			}
		}
		st.removeVisitedToken(errorPropagation, tt);
		if (!subResults.isEmpty()) {
			return postProcessOutgoingErrorPropagation(component, errorPropagation, type, subResults, scale);
		}
		if (pruneGraph) {
			return null;
		}
		return processOutgoingErrorPropagation(component, errorPropagation, type, scale);
	}

	private boolean containsEOP(Collection<ErrorPropagation> eops, ErrorPropagation eprop) {
		for (ErrorPropagation eop : eops) {
			if (EMV2Util.isSame(eop, eprop)) {
					return true;

				}
		}
		return false;
	}

	private boolean targetsEOP(Collection<OutgoingPropagationCondition> opcs, ErrorPropagation srcep, ErrorTypes type) {
		for (OutgoingPropagationCondition opc : opcs) {
			if ((opc.getTypeToken() != null && !EMV2TypeSetUtil.isNoError(opc.getTypeToken()))
					|| opc.getTypeToken() == null) {
				if (opc.isAllPropagations() || (EMV2Util.isSame(opc.getOutgoing(), srcep))
						&& EMV2TypeSetUtil.contains(opc.getTypeToken(), type)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * determine the target type given the original type of a backward propagation.
	 * Use the original if no constraint was provided (null)
	 * If the original is contained in the constraint use the original.
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
		return EMV2TypeSetUtil.contains(constraint, original) ? original : constraint;
	}

	private ErrorTypes matchTargetType(ErrorTypes constraint, ErrorTypes original) {
		if (constraint == null) {
			return original;
		}
		if (original == null) {
			return constraint;
		}
		return EMV2TypeSetUtil.contains(constraint, original) ? original : null;
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
			OutgoingPropagationCondition opc, ErrorTypes type, HashMultimap<ErrorPropagation, String> handledEOPs,
			BigDecimal scale) {
		EObject conditionResult = null;
		EObject stateResult = null;
		if (opc.getCondition() != null) {
			conditionResult = processCondition(component, opc.getCondition(), type, FaultTreeUtils.BigOne, false);
		}
		ErrorBehaviorState state = opc.getState();
		if (state != null) {
			ErrorTypes newtype = type;
			if (opc.getTypeTokenConstraint() != null) {
				newtype = mapTargetType(opc.getTypeTokenConstraint(), type);
			} else if (state.getTypeSet() != null) {
				newtype = mapTargetType(state.getTypeSet(), type);
			}
			if (newtype instanceof ErrorType || newtype == null) {
				stateResult = traverseErrorBehaviorState(component, state, newtype, scale);
			} else {
				// multiple types to trace back
				EList<TypeToken> types = EMV2TypeSetUtil.flattenTypesetElements((TypeSet) newtype,
						EMV2Util.getUseTypes(opc));
				List<EObject> subResults = new LinkedList<EObject>();
				for (TypeToken typeToken : types) {
					EList<ErrorTypes> tl = typeToken.getType();
					// TODO deal with type product
					EObject res = traverseErrorBehaviorState(component, opc.getState(), tl.get(0), scale);
					if (res != null) {
						subResults.add(res);
					}
				}
				if (subResults.isEmpty()) {
					stateResult = processErrorBehaviorState(component, state, type, scale);
				} else if (subResults.size() == 1) {
					stateResult = subResults.get(0);
				} else {
					stateResult = postProcessXor(component, state, newtype, BigOne, subResults);
				}
			}
		}
		if (conditionResult == null && stateResult != null) {
			for (ErrorBehaviorTransition trans : EMV2Util.getAllErrorBehaviorTransitions(component)) {
				if (state == trans.getTarget()) {
					Collection<ConditionElement> conde = EMV2Util
							.getAllConditionElementsFromConditionExpression(trans.getCondition());
					for (ConditionElement conditionElement : conde) {
						EventOrPropagation eop = EMV2Util.getErrorEventOrPropagation(conditionElement);
						if (eop instanceof ErrorPropagation) {
							handledEOPs.put((ErrorPropagation) eop, EMV2Util.getPrintName(type));
						}
					}
				}
			}
		} else {
			// error paths
			Collection<ConditionElement> conde = EMV2Util
					.getAllConditionElementsFromConditionExpression(opc.getCondition());
			for (ConditionElement conditionElement : conde) {
				EventOrPropagation eop = EMV2Util.getErrorEventOrPropagation(conditionElement);
				if (eop instanceof ErrorPropagation) {
					handledEOPs.put((ErrorPropagation) eop, EMV2Util.getPrintName(type));
				}
			}
		}
		return processOutgoingErrorPropagationCondition(component, opc, type, conditionResult, stateResult, scale);
	}

	/**
	 * process error state. Recursively deal with source states of transitions (an PRIORITY AND gate).
	 * We only process error events (not recover or repair) and error propagations referenced by the expression.
	 * @param component ComponentInstance
	 * @param state ErrorBehaviorState
	 * @param type ErrorTypes
	 * @return EObject (can be null)
	 */
	public EObject traverseErrorBehaviorState(ComponentInstance component, ErrorBehaviorState state, ErrorTypes type,
			BigDecimal inscale) {
		if (state == null) {
			return null;
		}
		List<EObject> subResults = new LinkedList<EObject>();
		preProcessErrorBehaviorState(component, state, type, inscale);
		Collection<ErrorBehaviorTransition> transitions = EMV2Util.getAllErrorBehaviorTransitions(component);
		BigDecimal combinedscale = inscale;
		for (ErrorBehaviorTransition ebt : transitions) {
			ConditionExpression conditionExpression = null;
			BigDecimal branchscale = BigOne;
			boolean sameState = false;
			ErrorTypes newtype = type;
			if (ebt.getTarget() != null && EMV2Util.isSame(state, ebt.getTarget())
					&& EMV2TypeSetUtil.contains(ebt.getTargetToken(), type)) {
				conditionExpression = ebt.getCondition();
				if (ebt.getSource() != null && EMV2Util.isSame(state, ebt.getSource())
						&& EMV2TypeSetUtil.isSame(type, ebt.getTypeTokenConstraint())) {
					sameState = true;
					newtype = mapTargetType(ebt.getTypeTokenConstraint(), type);
				}
			} else if (!ebt.getDestinationBranches().isEmpty()) {
				// deal with transition branches
				EList<TransitionBranch> tbs = ebt.getDestinationBranches();
				for (TransitionBranch transitionBranch : tbs) {
					if (transitionBranch.getTarget() != null) {
						if (EMV2Util.isSame(transitionBranch.getTarget(), state)
								&& EMV2TypeSetUtil.contains(transitionBranch.getTargetToken(), type)) {
							conditionExpression = ebt.getCondition();
							if (EMV2Util.isSame(ebt.getSource(), state)
									&& EMV2TypeSetUtil.isSame(type, ebt.getTypeTokenConstraint())) {
								sameState = true;
								newtype = mapTargetType(ebt.getTypeTokenConstraint(), type);
							}

						}
					} else if (transitionBranch.isSteadyState()) {
						// same state
						if (ebt.getSource() != null && EMV2Util.isSame(state, ebt.getSource())
								&& EMV2TypeSetUtil.isSame(type, ebt.getTypeTokenConstraint())) {
							conditionExpression = ebt.getCondition();
							sameState = true;
							newtype = mapTargetType(ebt.getTypeTokenConstraint(), type);
						}
					}
					if (conditionExpression != null) {
						BranchValue val = transitionBranch.getValue();
						if (val.getRealvalue() != null) {
							branchscale = new BigDecimal(EMV2Util.stripUnderScore(val.getRealvalue()));
						} else if (val.getSymboliclabel() != null) {
							ComponentClassifier cl = EMV2Util.getAssociatedClassifier(ebt);
							List<EMV2PropertyAssociation> pa = EMV2Properties
									.getProperty(val.getSymboliclabel().getQualifiedName(), cl, ebt, null);
							for (EMV2PropertyAssociation emv2PropertyAssociation : pa) {
								branchscale = new BigDecimal(EMV2Properties.getRealValue(emv2PropertyAssociation));
							}
						} else if (val.isOthers()) {
							branchscale = BigOne;
							for (TransitionBranch tb : tbs) {
								BranchValue valcount = tb.getValue();
								if (valcount.getRealvalue() != null) {
									branchscale = branchscale
											.subtract(
													new BigDecimal(EMV2Util.stripUnderScore(valcount.getRealvalue())));
								} else if (valcount.getSymboliclabel() != null) {
									ComponentClassifier cl = EMV2Util.getAssociatedClassifier(ebt);
									List<EMV2PropertyAssociation> pa = EMV2Properties
											.getProperty(valcount.getSymboliclabel().getQualifiedName(), cl, ebt, null);
									for (EMV2PropertyAssociation emv2PropertyAssociation : pa) {
										branchscale = branchscale.subtract(
												new BigDecimal(EMV2Properties.getRealValue(emv2PropertyAssociation)));
									}
								}
							}
						}
						break;
					}
				}
			} else if (ebt.isSteadyState()) {
				// same state
				if (ebt.getSource() != null && EMV2Util.isSame(state, ebt.getSource())
						&& EMV2TypeSetUtil.isSame(type, ebt.getTypeTokenConstraint())) {
					conditionExpression = ebt.getCondition();
					sameState = true;
					newtype = mapTargetType(ebt.getTypeTokenConstraint(), type);
				}
			}
			combinedscale = inscale.multiply(branchscale);
			if (!sameState && conditionExpression != null) {
				// don't include transition staying in same state
				EObject conditionResult = processCondition(component, conditionExpression, type, combinedscale, false);
				// XXX this is the recursive call
				// do not traverse back in same state
				// we also do not traverse back if left is allstates.
				if (conditionResult != null) {
					EObject stateResult = null;
					if (!(sameState || ebt.isAllStates())) {
						if (newtype instanceof ErrorType || newtype == null) {
							stateResult = traverseErrorBehaviorState(component, ebt.getSource(), newtype,
									combinedscale);
						} else if (newtype instanceof TypeSet) {
							EList<TypeToken> leaftypes = EMV2TypeSetUtil.flattenTypesetElements((TypeSet) newtype,
									EMV2Util.getUseTypes(ebt));
							List<EObject> subsubResults = new LinkedList<EObject>();
							for (TypeToken typeToken : leaftypes) {
								EList<ErrorTypes> tl = typeToken.getType();
								// TODO deal with type product
								// already dealt with mapTargetType
								ErrorTypes ntype = tl.get(0);
								EObject newEvent = traverseErrorBehaviorState(component, state, ntype, combinedscale);
								if (newEvent != null) {
									subsubResults.add(newEvent);
								}
							}
							if (subsubResults.isEmpty()) {
								stateResult = processErrorBehaviorState(component, state, type, inscale);
							} else if (subsubResults.size() == 1) {
								stateResult = subsubResults.get(0);
							} else {
								stateResult = processTypesetElements(component, state, newtype, subsubResults,
										combinedscale);
							}
						}
					}
					if (stateResult != null) {
						EObject tmpresult = processTransitionCondition(component, ebt.getSource(), type,
								conditionResult, stateResult, combinedscale);
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
			return postProcessErrorBehaviorState(component, state, type, subResults, combinedscale);
		}
		// subResults is empty if state without incoming transition triggered by error events or incoming propagations
		// or if no transitions specified for state machine
		if (transitions.isEmpty()) {
			// we cannot trace back to an error event triggering a transition
			// give the opportunity to present the error state as Event
			return traverseCompositeErrorStateOnly(component, state, type, inscale);// processErrorBehaviorState(component, state, type);
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
			BigDecimal scale, boolean stateOnly) {
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

			return postProcessAnd(component, condition, type, subResults, scale);
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
			return postProcessAnd(component, condition, type, subResults, scale);
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
			return postProcessOr(component, condition, type, subResults, scale);
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
							result = traverseCompositeErrorState(referencedInstance, state, referencedErrorType,
									stateOnly, scale);
						} else {
							// handle type set on states
							// get incoming type from propagation
							EList<TypeToken> leaftypes = EMV2TypeSetUtil
									.flattenTypesetElements((TypeSet) referencedErrorType, EMV2Util.getUseTypes(state));
							List<EObject> subResults = new LinkedList<EObject>();
							for (TypeToken typeToken : leaftypes) {
								EList<ErrorTypes> tl = typeToken.getType();
								// TODO deal with type product
								ErrorTypes newtype = mapTargetType(tl.get(0), type);
								EObject newEvent = traverseCompositeErrorState(component, state, newtype, stateOnly,
										scale);
								if (newEvent != null) {
									subResults.add(newEvent);
								}
							}
							if (subResults.isEmpty()) {
								return processErrorBehaviorState(referencedInstance,
										EMV2Util.getState(sconditionElement), referencedErrorType, scale);
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
								referencedErrorType, scale);
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
							result = traverseIncomingErrorPropagation(referencedInstance, ep, referencedErrorType,
									scale);
						} else {
							// handle type set on states
							// get incoming type from propagation
							EList<TypeToken> leaftypes = EMV2TypeSetUtil
									.flattenTypesetElements((TypeSet) referencedErrorType, EMV2Util.getUseTypes(ep));
							List<EObject> subResults = new LinkedList<EObject>();
							for (TypeToken typeToken : leaftypes) {
								EList<ErrorTypes> tl = typeToken.getType();
								// TODO deal with type product
								ErrorTypes newtype = mapTargetType(tl.get(0), type);
								EObject newEvent = traverseIncomingErrorPropagation(component, ep, newtype, scale);
								if (newEvent != null) {
									subResults.add(newEvent);
								}
							}
							if (subResults.isEmpty()) {
								return processIncomingErrorPropagation(referencedInstance, ep, referencedErrorType,
										scale);
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
								referencedErrorType, scale);
					}
				}
				// should not reach this
				return processErrorBehaviorState(component, EMV2Util.getState(sconditionElement), null, scale);
			}

			if (conditionElement.getConstraint() != null) {
				if (EMV2TypeSetUtil.isNoError(conditionElement.getConstraint())) {
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
					if (Util.conditionHolds((ErrorEvent) errorModelElement, component)) {
						return processErrorEvent(component, (ErrorEvent) errorModelElement, referencedErrorType, scale);
					}
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
					if (EMV2TypeSetUtil.isNoError(referencedErrorType)) {
						// this is a recovery transition since an incoming propagation became error free
						return null;
					}
					if (errorPropagation.getDirection() == DirectionType.IN) {
						if (referencedErrorType instanceof ErrorType) {
							return traverseIncomingErrorPropagation(relatedComponent, errorPropagation,
									referencedErrorType, scale);
						} else {
							// type set need to treat each element separately and put them in an OR
							EList<TypeToken> tselements = EMV2TypeSetUtil.flattenTypesetElements(
									(TypeSet) referencedErrorType, EMV2Util.getUseTypes(errorPropagation));
							if (tselements.size() == 1) {
								return traverseIncomingErrorPropagation(relatedComponent, errorPropagation,
										tselements.get(0).getType().get(0), scale);
							} else {
								List<EObject> subResults = new LinkedList<EObject>();
								for (TypeToken tt : tselements) {
									EObject res = traverseIncomingErrorPropagation(relatedComponent, errorPropagation,
											tt.getType().get(0), scale);
									subResults.add(res);
								}
								return postProcessOr(relatedComponent, conditionElement, referencedErrorType,
										subResults, scale);
							}
						}
					} else {
						return traverseOutgoingErrorPropagation(relatedComponent, errorPropagation,
								referencedErrorType, scale);
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
			ErrorTypes type, BigDecimal scale) {
		List<EObject> subResults = new LinkedList<EObject>();
		type = matchTargetType(errorPropagation.getTypeSet(), type);
		if (type == null) {
			return null;
		}
		EObject preResult = preProcessIncomingErrorPropagation(component, errorPropagation, type, scale);
		if (preResult != null) {
			return preResult;// found common event
		}
		// we want to track cycles.
		// we do that by tagging the feature instance of the error propagation with the error type (as token)
		ErrorModelState st = null;
		FeatureInstance fi = EMV2Util.findFeatureInstance(errorPropagation, component);
		if (fi != null) {
			st = (ErrorModelState) ErrorModelStateAdapterFactory.INSTANCE.adapt(fi, ErrorModelState.class);
		} else {
			st = (ErrorModelState) ErrorModelStateAdapterFactory.INSTANCE.adapt(component, ErrorModelState.class);
		}
		TypeToken tt = ErrorModelFactory.eINSTANCE.createTypeToken();
		tt.getType().add(type);
		if (st.visited(errorPropagation, tt)) {
			// we were there before.
			return foundCycle;
		} else {
			st.setVisitToken(errorPropagation, tt);
		}
		boolean pruneGraph = false;
		for (PropagationGraphPath ppr : Util.getAllReversePropagationPaths(currentAnalysisModel,
				component, errorPropagation)) {
			// traverse incoming
			ErrorTypes srctype = type;
			if (ppr.getConnection() != null) {
				ErrorSource ces = EMV2Util.findConnectionErrorSourceForConnection(ppr.getConnection());
				// the type constraint has to come from the error source as the connection does not have one
				if (ces != null && EMV2TypeSetUtil.contains(ces.getTypeTokenConstraint(), type)) {
					EObject result = processConnectionErrorSource(ppr.getConnection(), ces, type, scale);
					if (result == foundCycle) {
						pruneGraph = true;
					} else if (result != null) {
						subResults.add(result);
					} else {
						// error source exists but type is not propagated
						pruneGraph = true;
					}
				}
				ComponentInstance contextCI = ppr.getConnection().getComponentInstance();
				TypeTransformationSet tts = EMV2Util.getAllTypeTransformationSet(contextCI);

				for (PropagationPathEnd ppe : Util.getAllPropagationSourceEnds(currentAnalysisModel,
						ppr.getConnection())) {
					ComponentInstance componentSource = ppe.getComponentInstance();
					ErrorPropagation propagationSource = ppe.getErrorPropagation();
					ErrorTypes newtype = EMV2TypeSetUtil.reverseMapTypeTokenToContributor(type, tts);
					if (newtype instanceof ErrorType) {
						newtype = mapTargetType(newtype, type);
						EObject result = traverseOutgoingErrorPropagation(componentSource, propagationSource, newtype,
								scale);
						if (result == foundCycle) {
							pruneGraph = true;
						} else if (result != null) {
							subResults.add(result);
						} else {
							// propagation path exists but type is not propagated
							pruneGraph = true;
						}
					} else {
						EList<TypeToken> ttlist = EMV2TypeSetUtil.flattenTypesetElements((TypeSet) newtype,
								EMV2Util.getUseTypes(propagationSource));
						for (TypeToken typeToken : ttlist) {
							EList<ErrorTypes> tl = typeToken.getType();
							// TODO deal with type product
							ErrorTypes ntype = mapTargetType(tl.get(0), type);
								EObject result = traverseOutgoingErrorPropagation(componentSource, propagationSource,
										ntype, scale);
							if (result == foundCycle) {
								pruneGraph = true;
							} else if (result != null) {
								subResults.add(result);
							} else {
								// propagation path exists but type is not propagated
								pruneGraph = true;
							}
						}
					}
				}
				srctype = EMV2TypeSetUtil.reverseMapTypeTokenToSource(type, tts);
			}
			PropagationPathEnd ppe = ppr.getPathSrc();
			ComponentInstance componentSource = ppe.getComponentInstance();
			ErrorPropagation propagationSource = ppe.getErrorPropagation();
			if (srctype instanceof ErrorType) {
				if (propagationSource.getDirection() == DirectionType.IN) {
					// we have an external incoming propagation
					EObject result = processIncomingErrorPropagation(componentSource, propagationSource, srctype,
							scale);
					if (result == foundCycle) {
						pruneGraph = true;
					} else if (result != null) {
						subResults.add(result);
					} else {
						// propagation path exists but type is not propagated
						pruneGraph = true;
					}
				} else {
						EObject result = traverseOutgoingErrorPropagation(componentSource, propagationSource, srctype,
								scale);
					if (result == foundCycle) {
						pruneGraph = true;
					} else if (result != null) {
						subResults.add(result);
					} else {
						// propagation path exists but type is not propagated
						pruneGraph = true;
					}
				}
			} else {
				EList<TypeToken> ttlist = EMV2TypeSetUtil.flattenTypesetElements((TypeSet) srctype,
						EMV2Util.getUseTypes(propagationSource));
				for (TypeToken typeToken : ttlist) {
					EList<ErrorTypes> tl = typeToken.getType();
					// TODO deal with type product
					ErrorTypes ntype = tl.get(0);
					if (propagationSource.getDirection() == DirectionType.IN) {
						// we have an external incoming propagation
						EObject result = processIncomingErrorPropagation(componentSource, propagationSource, ntype,
								scale);
						if (result != null) {
							subResults.add(result);
						} else {
							// propagation path exists but type is not propagated
							pruneGraph = true;
						}
					} else {
							EObject result = traverseOutgoingErrorPropagation(componentSource, propagationSource, ntype,
									scale);
						if (result == foundCycle) {
							pruneGraph = true;
						} else if (result != null) {
							subResults.add(result);
						} else {
							// propagation path exists but type is not propagated
							pruneGraph = true;
						}
					}
				}
			}
		}
		st.removeVisitedToken(errorPropagation, tt);
		if (!subResults.isEmpty()) {
			return postProcessIncomingErrorPropagation(component, errorPropagation, type, subResults, scale);
		}
		if (pruneGraph) {
			return null;
		}
		// we have no subresults and did not prune. Allow handling of incoming propagation as endpoint of traversal
		return processIncomingErrorPropagation(component, errorPropagation, type, scale);
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
	public EObject traverseCompositeErrorState(ComponentInstance component, ErrorBehaviorState state, ErrorTypes type,
			BigDecimal scale) {
		return traverseCompositeErrorState(component, state, type, false, scale);
	}

	public EObject traverseCompositeErrorState(ComponentInstance component, ErrorBehaviorState state, ErrorTypes type,
			boolean stateOnly, BigDecimal scale) {
		preProcessCompositeErrorStates(component, state, type, scale);
		List<EObject> subResults = new LinkedList<EObject>();
		// should only match one composite state declaration.
		for (CompositeState cs : EMV2Util.getAllCompositeStates(component)) {
			if (cs.getState() == state && EMV2TypeSetUtil.contains(cs.getTypedToken(), type)) {
				EObject res = processCondition(component, cs.getCondition(), type, new BigDecimal(1.0), stateOnly);
				if (res != null) {
					subResults.add(res);
				}
			}
		}
		if (!subResults.isEmpty()) {
			return postProcessCompositeErrorStates(component, state, type, subResults, scale);
		}
		if (stateOnly) {
			return processErrorBehaviorState(component, state, type, scale);
		} else {
			return traverseErrorBehaviorState(component, state, type, scale);
		}
	}

	public EObject traverseCompositeErrorStateOnly(ComponentInstance component, ErrorBehaviorState state,
			ErrorTypes type, BigDecimal scale) {
		return traverseCompositeErrorState(component, state, type, true, scale);
	}


//	methods to be overwritten by applications

	/**
	 * post process results from back traversal
	 * called with non-empty subResults list.
	 * @param component
	 * @param errorPropagation
	 * @param targetType
	 * @param subResults (EObjects created as part of traversing out propagation, e.g., FTA events).
	 * @return EObject The result of post processing the subresults list (can be null)
	 */
	protected EObject postProcessOutgoingErrorPropagation(ComponentInstance component,
			ErrorPropagation errorPropagation, ErrorTypes targetType, List<EObject> subResults, BigDecimal scale) {
		return null;
	}

	/**
	 * pre process outgoing propagation
	 * Non-null result will result in returning the result instead of sub traversal.
	 * @param component
	 * @param errorPropagation
	 * @param targetType
	 * @return EObject or null
	 */
	protected EObject preProcessOutgoingErrorPropagation(ComponentInstance component, ErrorPropagation errorPropagation,
			ErrorTypes targetType, BigDecimal scale) {
		return null;
	}

	/**
	 * process error source as leaf of traversal
	 * For FTA we would create a BASIC event.
	 * @param component
	 * @param errorSource
	 * @param typeTokenConstraint
	 * @return EObject (can be null)
	 */
	protected EObject processErrorSource(ComponentInstance component, ErrorSource errorSource, ErrorTypes type,
			BigDecimal scale) {
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
			ErrorTypes typeTokenConstraint, BigDecimal scale) {
		return null;
	}

	/**
	 * pre process incoming propagation
	 * Non-null result will result in returning the result instead of sub traversal.
	 * @param component
	 * @param errorPropagation
	 * @param targetType
	 * @return EObject or null
	 */
	protected EObject preProcessIncomingErrorPropagation(ComponentInstance component, ErrorPropagation errorPropagation,
			ErrorTypes type, BigDecimal scale) {
		return null;
	}

	/**
	 * process incoming propagation as leaf of traversal, i.e., there was no propagation path/connection to the incoming port.
	 * @param component ComponentInstance
	 * @param incoming ErrorPropagation
	 * @param type Error Type
	 * @return EObject (can be null but is expected to return object representing traversal leaf)
	 */
	protected EObject processIncomingErrorPropagation(ComponentInstance component, ErrorPropagation incoming,
			ErrorTypes type, BigDecimal scale) {
		return null;
	}

	/**
	 * post process results from back traversal
	 * called with non-empty subResults list
	 * @param component
	 * @param errorPropagation
	 * @param targetType
	 * @param subResults (EObjects created as part of traversing out propagation, e.g., FTA events).
	 * @return EObject The result of post processing the subresults list (can be null)
	 */
	protected EObject postProcessIncomingErrorPropagation(ComponentInstance component,
			ErrorPropagation errorPropagation, ErrorTypes targetType, List<EObject> subResults, BigDecimal scale) {
		return null;
	}

	/**
	 * process outgoing propagation as leaf of traversal, i.e., when there is no error internal error or path to incoming features.
	 * @param component ComponnetInstance
	 * @param outgoing ErrorPropagation
	 * @param type Error Type
	 * @return EObject (can be null but is expected to return object representing traversal leaf)
	 */
	protected EObject processOutgoingErrorPropagation(ComponentInstance component, ErrorPropagation ep,
			ErrorTypes type, BigDecimal scale) {
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
			OutgoingPropagationCondition opc, ErrorTypes type, EObject conditionResult, EObject stateResult,
			BigDecimal scale) {
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
			ErrorTypes targetType, BigDecimal scale) {
		return null;
	}

	/**
	 * post process results composite error states back traversal result
	 * called with non-empty subResults list
	 * @param component
	 * @param state
	 * @param targetType
	 * @param subResults Entities encountered as part of the sub-traversal
	 * @return EObject result representing the processing of the subresults list (can be null )
	 */
	protected EObject postProcessCompositeErrorStates(ComponentInstance component, ErrorBehaviorState state,
			ErrorTypes targetType, List<EObject> subResults, BigDecimal scale) {
		return null;
	}

	/**
	 * pre process error behavior state
	 * Non-null result will use it as result of traversal
	 * This allows handling of previously produced state related traversal subtrees
	 * @param component
	 * @param state
	 * @param type
	 * @return EObject or null
	 */
	protected EObject preProcessErrorBehaviorState(ComponentInstance component, ErrorBehaviorState state,
			ErrorTypes type, BigDecimal scale) {
		return null;
	}

	/**
	 * post process error behavior state back traversal result based on transitions
	 * called with non-empty subResults list
	 * @param component
	 * @param state
	 * @param targetType
	 * @param subResults Entities encountered as part of the sub-traversal
	 * @return EObject result representing the processing of the subresults list (can be null )
	 */
	protected EObject postProcessErrorBehaviorState(ComponentInstance component, ErrorBehaviorState state,
			ErrorTypes type, List<EObject> subResults, BigDecimal scale) {
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
			ErrorTypes type, BigDecimal scale) {
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
			ErrorTypes type, EObject conditionResult, EObject stateResult, BigDecimal scale) {
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
			BigDecimal scale) {
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
	protected EObject preProcessAnd(ComponentInstance component, Element condition, ErrorTypes type, BigDecimal scale) {
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
			List<EObject> subResults, BigDecimal scale) {
		return null;
	}

	/**
	 * pre process results Priority AND expression
	 * called with non-empty subResults list
	 * @param component
	 * @param condition XOR expression
	 * @param type Error Type
	 * @param scale scaling factor for probability
	 */
	protected EObject preProcessPriorityAnd(ComponentInstance component, Element condition, ErrorTypes type,
			BigDecimal scale) {
		return null;
	}

	/**
	 * post process results Priority AND expression
	 * called with non-empty subResults list
	 * @param component
	 * @param condition XOR expression
	 * @param type Error Type
	 * @param scale scaling factor for probability
	 * @param subResults Entities encountered as part of the sub-traversal
	 * @return EObject result representing the processing of the subresults list (can be null )
	 */
	protected EObject postProcessPriorityAnd(ComponentInstance component, Element condition, ErrorTypes type,
			List<EObject> subResults, BigDecimal scale) {
		return null;
	}

	/**
	 * pre process results XOR expression
	 * called with non-empty subResults list
	 * @param component
	 * @param condition XOR expression
	 * @param type Error Type
	 * @param scale scaling factor for probability
	 */
	protected EObject preProcessXor(ComponentInstance component, Element condition, ErrorTypes type, BigDecimal scale) {
		return null;
	}

	/**
	 * post process results XOR expression
	 * called with non-empty subResults list
	 * @param component
	 * @param condition XOR expression
	 * @param type Error Type
	 * @param scale scaling factor for probability
	 * @param subResults Entities encountered as part of the sub-traversal
	 * @return EObject result representing the processing of the subresults list (can be null )
	 */
	protected EObject postProcessXor(ComponentInstance component, Element condition, ErrorTypes type, BigDecimal scale,
			List<EObject> subResults) {
		return null;
	}


	/**
	 * pre process results OR expression
	 * called with non-empty subResults list
	 * @param component
	 * @param condition OR expression
	 * @param type Error Type
	 * @param scale scaling factor for probability
	 */
	protected EObject preProcessOr(ComponentInstance component, Element condition, ErrorTypes type, BigDecimal scale) {
		return null;
	}

	/**
	 * post process results OR expression
	 * called with non-empty subResults list
	 * @param component
	 * @param condition OR expression
	 * @param type Error Type
	 * @param scale scaling factor for probability
	 * @param subResults Entities encountered as part of the sub-traversal
	 * @return EObject result representing the processing of the subresults list (can be null )
	 */
	protected EObject postProcessOr(ComponentInstance component, Element condition, ErrorTypes type,
			List<EObject> subResults, BigDecimal scale) {
		return null;
	}

	/**
	 * process elements of a type set in conjunction with an error state
	 * called with non-empty subResults list
	 * @param component
	 * @param state error state
	 * @param type Error Type
	 * @param scale scaling factor for probability
	 * @param subResults Entities encountered as part of the sub-traversal
	 * @return EObject result representing the processing of the subresults list (can be null )
	 */
	protected EObject processTypesetElements(ComponentInstance component, Element state, ErrorTypes type,
			List<EObject> subResults, BigDecimal scale) {
		return null;
	}

}
