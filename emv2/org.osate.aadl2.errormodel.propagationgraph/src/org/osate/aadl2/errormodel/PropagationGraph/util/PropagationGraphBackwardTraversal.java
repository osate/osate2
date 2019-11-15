package org.osate.aadl2.errormodel.PropagationGraph.util;

import static org.osate.xtext.aadl2.errormodel.util.EMV2TypeSetUtil.contains;
import static org.osate.xtext.aadl2.errormodel.util.EMV2TypeSetUtil.filterTokenThroughConstraint;
import static org.osate.xtext.aadl2.errormodel.util.EMV2TypeSetUtil.flattenTypesetElements;
import static org.osate.xtext.aadl2.errormodel.util.EMV2TypeSetUtil.isNoError;
import static org.osate.xtext.aadl2.errormodel.util.EMV2TypeSetUtil.isSame;
import static org.osate.xtext.aadl2.errormodel.util.EMV2TypeSetUtil.mapTokenThroughConstraint;
import static org.osate.xtext.aadl2.errormodel.util.EMV2TypeSetUtil.reverseMapTypeTokenToContributor;
import static org.osate.xtext.aadl2.errormodel.util.EMV2TypeSetUtil.reverseMapTypeTokenToSource;

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
			final ErrorPropagation errorPropagation, TypeToken proptype, BigDecimal scale) {
		List<EObject> subResults = new LinkedList<EObject>();
		Collection<TypeToken> filteredTypes = filterTokenThroughConstraint(errorPropagation.getTypeSet(), proptype);
		if (filteredTypes.isEmpty()) {
			return null;
		}

		HashMultimap<ErrorPropagation, String> handledEOPs = HashMultimap.create();
		boolean traverse = false;
		for (TypeToken type : filteredTypes) {
			boolean didProp = false;
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
			if (st.visited(errorPropagation, type)) {
				// we were there before.
				return foundCycle;
			} else {
				st.setVisitToken(errorPropagation, type);
			}

			// processing call has to be after the preproccessing call so it is not found and we proceed in processing.
			// On the other hand it needs to be called here so the event exists in ftamodel and is found the next time around.
			// Originally we were creating the events bottom up thus the loop did not find the event.
//			EObject myEvent = processOutgoingErrorPropagation(component, errorPropagation, type, scale);
			Collection<ErrorFlow> errorFlows = EMV2Util.getAllErrorFlows(component);
			Collection<OutgoingPropagationCondition> opcs = EMV2Util.getAllOutgoingPropagationConditions(component);
			for (OutgoingPropagationCondition opc : opcs) {
				if ((opc.getTypeToken() != null && !isNoError(opc.getTypeToken())) || opc.getTypeToken() == null) {
					if (opc.isAllPropagations() || (EMV2Util.isSame(opc.getOutgoing(), errorPropagation))) {
						// opc token if OPC token is subtype or same type
						Collection<TypeToken> opcFilteredTypes = filterTokenThroughConstraint(opc.getTypeToken(), type);
						for (TypeToken opctype : opcFilteredTypes) {
							if (contains(opc.getTypeToken(), opctype)) {
								EObject res = handleOutgoingErrorPropagationCondition(component, opc, opctype,
										handledEOPs, scale);
								addSubresult(subResults, res);
								didProp = true;
							}
						}
					}
				}
			}
			// try to find a path from an outer to an inner out error propagation
			EList<PropagationPathEnd> propagationSources = Util.getAllPropagationSourceEnds(currentAnalysisModel,
					component, errorPropagation);
			for (PropagationPathEnd ppe : propagationSources) {
				ComponentInstance componentSource = ppe.getComponentInstance();
				ErrorPropagation propagationSource = ppe.getErrorPropagation();
				if (propagationSource.getDirection() == DirectionType.OUT) {
					Set<ErrorPropagation> eops = handledEOPs.keySet();
					if (!containsEOP(eops, propagationSource)) {
						// if not already handled by a opc
						EObject res = traverseOutgoingErrorPropagation(componentSource, propagationSource, type, scale);
						addSubresult(subResults, res);
						didProp = true;
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
								Collection<TypeToken> mappedTypes = filterTokenThroughConstraint(ep.getTargetToken(),
										type);
								for (TypeToken mappedtype : mappedTypes) {
									// we have a type mapping
									EList<TypeToken> result;
									if (ep.getTypeTokenConstraint() != null) {
										// get type from path constraint
										result = mapTokenThroughConstraint(ep.getTypeTokenConstraint(), mappedtype);
									} else {
										// get incoming type from propagation
										result = mapTokenThroughConstraint(ep.getIncoming().getTypeSet(), mappedtype);
									}
									for (TypeToken newToken : result) {
										if (ep.isAllIncoming()) {
											Collection<ErrorPropagation> inprops = EMV2Util
													.getAllIncomingErrorPropagations(component);
											for (ErrorPropagation eprop : inprops) {
												handledEOPs.put(eprop, EMV2Util.getPrintName(newToken));
												EObject newEvent = traverseIncomingErrorPropagation(component, eprop,
														newToken, newscale);
												addSubresult(subResults, newEvent);
												didProp = true;
											}

										} else {
											handledEOPs.put(ep.getIncoming(), EMV2Util.getPrintName(newToken));
											EObject newEvent = traverseIncomingErrorPropagation(component,
													ep.getIncoming(), newToken, newscale);
											addSubresult(subResults, newEvent);
											didProp = true;
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
										}
										EList<TypeToken> filteredtypes = filterTokenThroughConstraint(matchtype,
												type);
										for (TypeToken subtype : filteredtypes) {
											handledEOPs.put(eprop, EMV2Util.getPrintName(subtype));
											EObject newEvent = traverseIncomingErrorPropagation(component, eprop,
													subtype, newscale);
											addSubresult(subResults, newEvent);
											didProp = true;
										}
									}
								} else {
									ErrorPropagation inep = ep.getIncoming();
									TypeSet matchtype = ep.getTypeTokenConstraint();
									if (matchtype == null) {
										matchtype = inep.getTypeSet();
									}
									Collection<TypeToken> mappedtypes = filterTokenThroughConstraint(matchtype, type);
									for (TypeToken subtype : mappedtypes) {
										handledEOPs.put(inep, EMV2Util.getPrintName(subtype));
										EObject newEvent = traverseIncomingErrorPropagation(component, inep, subtype,
												newscale);
										addSubresult(subResults, newEvent);
										didProp = true;
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
						if (errorSource.isAll()
								|| EMV2Util.isSame(errorSource.getSourceModelElement(), errorPropagation)) {
							Collection<TypeToken> mappedTypes = filterTokenThroughConstraint(
									errorSource.getTypeTokenConstraint(), type);
							for (TypeToken mappedType : mappedTypes) {
								if (src instanceof ErrorPropagation) {
									handledEOPs.put((ErrorPropagation) src, EMV2Util.getPrintName(mappedType));
								}
								if (errorSource.getFailureModeReference() != null) {
									List<EObject> stResults = new LinkedList<EObject>();
									ErrorBehaviorState ebs = errorSource.getFailureModeReference();
									EObject sEvent = traverseErrorBehaviorState(component, ebs, mappedType, scale);
									addSubresult(stResults, sEvent);
									EObject newEvent = postProcessErrorSource(component, errorSource, proptype,
											stResults, scale);
									addSubresult(subResults, newEvent);
									didProp = true;
								} else {
									EObject newEvent = processErrorSource(component, errorSource, mappedType, scale);
									addSubresult(subResults, newEvent);
									didProp = true;
								}
							}
						}
					}
				}
			}
			st.removeVisitedToken(errorPropagation, type);
			if (didProp) {
				traverse = true;
			}
		}
		if (!subResults.isEmpty()) {
			return postProcessOutgoingErrorPropagation(component, errorPropagation, proptype, subResults, scale);
		}
		if (traverse && !handledEOPs.isEmpty()) {
			return null;
		}
		return processOutgoingErrorPropagation(component, errorPropagation, proptype, scale);
	}

	private boolean containsEOP(Collection<ErrorPropagation> eops, ErrorPropagation eprop) {
		for (ErrorPropagation eop : eops) {
			if (EMV2Util.isSame(eop, eprop)) {
					return true;

				}
		}
		return false;
	}

	private boolean targetsEOP(Collection<OutgoingPropagationCondition> opcs, ErrorPropagation srcep, TypeToken type) {
		for (OutgoingPropagationCondition opc : opcs) {
			if ((opc.getTypeToken() != null && !isNoError(opc.getTypeToken()))
					|| opc.getTypeToken() == null) {
				if (opc.isAllPropagations() || (EMV2Util.isSame(opc.getOutgoing(), srcep))
						&& contains(opc.getTypeToken(), type)) {
					return true;
				}
			}
		}
		return false;
	}


	private boolean addSubresult(List<EObject> subResults, EObject result) {
		if (result == foundCycle) {
			return false;
		} else if (result != null) {
			subResults.add(result);
			return true;
		} else {
			// propagation path exists but type is not propagated
			return false;
		}

	}

	/**
	 * Process all OutgoingPropagationConditions that match the propagation and type of interest
	 * It is an OR of the OutgoingPropagationConditions that match.
	 * Fore each it is an AND of the source state (if it involves an error event or propagation).
	 * @param component ComponentInstance
	 * @param propagation (outgoing) ErrorPropagation
	 * @param type TypeToken
	 * @return Event (can be null)
	 */
	private EObject handleOutgoingErrorPropagationCondition(ComponentInstance component,
			OutgoingPropagationCondition opc, TypeToken type, HashMultimap<ErrorPropagation, String> handledEOPs,
			BigDecimal scale) {
		EObject conditionResult = null;
		EObject stateResult = null;
		if (opc.getCondition() != null) {
			conditionResult = processCondition(component, opc.getCondition(), type, FaultTreeUtils.BigOne, false);
		}
		ErrorBehaviorState state = opc.getState();
		if (state != null) {
			// use constraint as we have mapping
			TypeSet newtypeset = null;
			if (opc.getTypeTokenConstraint() != null) {
				newtypeset = opc.getTypeTokenConstraint();
			} else if (state.getTypeSet() != null) {
				newtypeset = state.getTypeSet();
			}
			List<EObject> subResults = new LinkedList<EObject>();
			if (newtypeset != null) {
				EList<TypeToken> types = flattenTypesetElements(newtypeset);
				for (TypeToken typeToken : types) {
					EObject res = traverseErrorBehaviorState(component, state, typeToken, scale);
					if (res != null) {
						subResults.add(res);
					}
				}
				if (subResults.isEmpty()) {
					stateResult = processErrorBehaviorState(component, state, type, scale);
				} else if (subResults.size() == 1) {
					stateResult = subResults.get(0);
				} else {
					stateResult = postProcessXor(component, state, type, BigOne, subResults);
				}
			} else {
				stateResult = traverseErrorBehaviorState(component, state, null, scale);
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
	public EObject traverseErrorBehaviorState(ComponentInstance component, ErrorBehaviorState state, TypeToken type,
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
			Collection<TypeToken> newtypes = new LinkedList<TypeToken>();
			if (ebt.getTarget() != null && EMV2Util.isSame(state, ebt.getTarget())) {
				if (ebt.getTargetToken() != null) {
					Collection<TypeToken> filteredtypes = filterTokenThroughConstraint(ebt.getTargetToken(), type);
					for (TypeToken filteredtype : filteredtypes) {
						if (contains(ebt.getTargetToken(), filteredtype)) {
							conditionExpression = ebt.getCondition();
							if (ebt.getSource() != null && EMV2Util.isSame(state, ebt.getSource())
									&& isSame(type, ebt.getTypeTokenConstraint())) {
								sameState = true;
								newtypes.add(filteredtype);
							}
						}
					}
				} else {
					conditionExpression = ebt.getCondition();
				}
			} else if (!ebt.getDestinationBranches().isEmpty()) {
				// deal with transition branches
				EList<TransitionBranch> tbs = ebt.getDestinationBranches();
				for (TransitionBranch transitionBranch : tbs) {
					if (transitionBranch.getTarget() != null) {
						if (EMV2Util.isSame(transitionBranch.getTarget(), state)) {
							if (ebt.getTargetToken() != null) {
								Collection<TypeToken> filteredtypes = filterTokenThroughConstraint(
										ebt.getTargetToken(), type);
								for (TypeToken filteredtype : filteredtypes) {
									if (contains(transitionBranch.getTargetToken(), filteredtype)) {
										conditionExpression = ebt.getCondition();
										if (EMV2Util.isSame(ebt.getSource(), state)
												&& isSame(type, ebt.getTypeTokenConstraint())) {
											sameState = true;
											newtypes.add(filteredtype);
										}
									}
								}
							} else {
								conditionExpression = ebt.getCondition();
							}
						}
					} else if (transitionBranch.isSteadyState()) {
						// same state
						if (ebt.getSource() != null && EMV2Util.isSame(state, ebt.getSource())
								&& isSame(type, ebt.getTypeTokenConstraint())) {
							conditionExpression = ebt.getCondition();
							sameState = true;
							newtypes.add(type);
						}
					}
					if (conditionExpression != null) {
						// get branch prob value
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
									branchscale = branchscale.subtract(
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
						// XXX why break?
						break;
					}
				}
			} else if (ebt.isSteadyState()) {
				// same state
				if (ebt.getSource() != null && EMV2Util.isSame(state, ebt.getSource())
						&& isSame(type, ebt.getTypeTokenConstraint())) {
					conditionExpression = ebt.getCondition();
					sameState = true;
					newtypes.add(type);
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
						if (newtypes.isEmpty()) {
							stateResult = traverseErrorBehaviorState(component, ebt.getSource(), null,
									combinedscale);
						} else {
							List<EObject> subsubResults = new LinkedList<EObject>();
							for (TypeToken typeToken : newtypes) {
								EObject newEvent = traverseErrorBehaviorState(component, state, typeToken,
										combinedscale);
								if (newEvent != null) {
									subsubResults.add(newEvent);
								}
							}
							if (subsubResults.isEmpty()) {
								stateResult = processErrorBehaviorState(component, state, type, inscale);
							} else if (subsubResults.size() == 1) {
								stateResult = subsubResults.get(0);
							} else {
								stateResult = processTypesetElements(component, state, type, subsubResults,
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
	public EObject processCondition(ComponentInstance component, ConditionExpression condition, TypeToken type,
			BigDecimal scale, boolean stateOnly) {

		// Mapping of AND expression
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

		// Mapping of All expression
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

		// Mapping of OR expression
		if (condition instanceof OrExpression) {
			preProcessXor(component, condition, type, scale); // XXX preProcessOr ?
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

		// Mapping of ORMORE expression
		if (condition instanceof OrmoreExpression) {
			OrmoreExpression omCondition = (OrmoreExpression) condition;
			List<EObject> subResults = new LinkedList<EObject>();

			if (omCondition.getCount() == 1) {
				/* 1 ormore is mapped to a OR gate */
				preProcessOr(component, condition, type, scale);
				for (ConditionExpression ce : omCondition.getOperands()) {
					EObject res = processCondition(component, ce, type, scale, stateOnly);
					if (res != null) {
						subResults.add(res);
					}
				}
				return postProcessOr(component, condition, type, subResults, scale);

			} else {
				/* x ormore with x > 1 is mapped to a ORMORE gate */
				preProcessOrMore(component, condition, type, scale);
				for (ConditionExpression ce : omCondition.getOperands()) {
					EObject res = processCondition(component, ce, type, scale, stateOnly);
					if (res != null) {
						subResults.add(res);
					}
				}
				return postProcessOrMore(component, condition, type, subResults, scale);
			}
		}

		// Mapping of single condition element
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
					ErrorBehaviorState state = EMV2Util.getState(sconditionElement);
					// either original type or mapped to constraint in condition or type set on state declaration
					TypeSet referencedErrorType = (sconditionElement.getConstraint() != null)
							? sconditionElement.getConstraint()
							: state.getTypeSet();
					if (referencedInstance != null) {
						List<EObject> subResults = new LinkedList<EObject>();
						if (referencedErrorType == null) {
							EObject newEvent = traverseCompositeErrorState(referencedInstance, state, null, stateOnly,
									scale);
							if (newEvent != null) {
								subResults.add(newEvent);
							}
						} else {
							// handle type set on states
							// get incoming type from propagation
							EList<TypeToken> leaftypes = EMV2TypeSetUtil.flattenTypesetElements(referencedErrorType);
							for (TypeToken typeToken : leaftypes) {
								EObject newEvent = traverseCompositeErrorState(component, state, typeToken, stateOnly,
										scale);
								if (newEvent != null) {
									subResults.add(newEvent);
								}
							}
						}
						if (subResults.isEmpty()) {
							return processErrorBehaviorState(referencedInstance, EMV2Util.getState(sconditionElement),
									type, scale);
						} else if (subResults.size() == 1) {
							return subResults.get(0);
						} else {
							return postProcessXor(component, sconditionElement, type, scale, subResults);
						}
					}
					return processErrorBehaviorState(referencedInstance, EMV2Util.getState(sconditionElement),
								type, scale);
				} else if (sconditionElement.getQualifiedErrorPropagationReference() != null) {
					EMV2Path path = sconditionElement.getQualifiedErrorPropagationReference();
					ComponentInstance referencedInstance = EMV2Util.getLastComponentInstance(path, component);
					ErrorPropagation ep = EMV2Util.getErrorPropagation(path);
					// either original type or mapped to constraint in condition or type set on state declaration
					TypeSet referencedErrorType = (sconditionElement.getConstraint() != null)
							? sconditionElement.getConstraint()
							: ep.getTypeSet();
					if (referencedInstance != null) {
						// handle type set on states
						// get incoming type from propagation
						EList<TypeToken> leaftypes = EMV2TypeSetUtil
									.flattenTypesetElements(referencedErrorType);
						List<EObject> subResults = new LinkedList<EObject>();
						for (TypeToken typeToken : leaftypes) {
							// XXX ErrorType newtype = mapTargetType(typeToken, type);
							EObject newEvent = traverseIncomingErrorPropagation(component, ep, typeToken, scale);
							if (newEvent != null) {
								subResults.add(newEvent);
							}
						}
						if (subResults.isEmpty()) {
							return processIncomingErrorPropagation(referencedInstance, ep, type,
									scale);
						} else if (subResults.size() == 1) {
							return subResults.get(0);
						} else {
							return postProcessXor(component, sconditionElement, type, scale,
									subResults);
						}
					}
					return processErrorBehaviorState(referencedInstance, EMV2Util.getState(sconditionElement), type,
							scale);
				}
				// should not reach this
				return processErrorBehaviorState(component, EMV2Util.getState(sconditionElement), null, scale);
			} // end SConditionElement

			if (conditionElement.getConstraint() != null) {
				if (isNoError(conditionElement.getConstraint())) {
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
					if (Util.conditionHolds((ErrorEvent) errorModelElement, component)) {
						Collection<TypeToken> referencedErrorTypes = conditionElement.getConstraint() != null
								? mapTokenThroughConstraint(conditionElement.getConstraint(), type)
								: mapTokenThroughConstraint(((ErrorEvent) errorModelElement).getTypeSet(), type);
						if (referencedErrorTypes.isEmpty()) {
							return processErrorEvent(component, (ErrorEvent) errorModelElement, null, scale);
						} else {
							List<EObject> subResults = new LinkedList<EObject>();
							for (TypeToken et : referencedErrorTypes) {
								EObject newEvent = processErrorEvent(component, (ErrorEvent) errorModelElement, et,
										scale);
								if (newEvent != null) {
									subResults.add(newEvent);
								}
							}
							if (subResults.isEmpty()) {
								return null;
							} else if (subResults.size() == 1) {
								return subResults.get(0);
							} else {
								return postProcessXor(component, conditionElement, type, scale, subResults);
							}
						}
					}
				}

				/**
				 * Here, we have an error propagation. This is notified with the
				 * in propagation within a composite error model.
				 */
				if (errorModelElement instanceof ErrorPropagation) {
					ErrorPropagation errorPropagation = (ErrorPropagation) errorModelElement;
//					Collection<TypeToken> referencedErrorTypes = conditionElement.getConstraint() != null
//							? filterFromIncomingPropagation(conditionElement.getConstraint(), type)
//							: filterFromIncomingPropagation(errorPropagation.getTypeSet(), type);
					Collection<TypeToken> referencedErrorTypes = conditionElement.getConstraint() != null
							? EMV2TypeSetUtil.flattenTypesetElements(conditionElement.getConstraint())
							: EMV2TypeSetUtil.flattenTypesetElements(errorPropagation.getTypeSet());
					if (referencedErrorTypes.isEmpty()) {

					}
					List<EObject> subResults = new LinkedList<EObject>();
					for (TypeToken et : referencedErrorTypes) {
						if (isNoError(et)) {
							// this is a recovery transition since an incoming propagation became error free
							continue;
						}
						if (errorPropagation.getDirection() == DirectionType.IN) {
							EObject newEvent = traverseIncomingErrorPropagation(relatedComponent, errorPropagation, et,
									scale);
							if (newEvent != null) {
								subResults.add(newEvent);
							}
						} else {
							EObject newEvent = traverseOutgoingErrorPropagation(relatedComponent, errorPropagation, et,
									scale);
							if (newEvent != null) {
								subResults.add(newEvent);
							}
						}
					}
					if (subResults.isEmpty()) {
						return null;
					} else if (subResults.size() == 1) {
						return subResults.get(0);
					} else {
						return postProcessXor(component, conditionElement, type, scale, subResults);
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
			TypeToken proptype, BigDecimal scale) {
		List<EObject> results = new LinkedList<EObject>();
		Collection<TypeToken> filteredtypes = filterTokenThroughConstraint(errorPropagation.getTypeSet(), proptype);
		if (filteredtypes.isEmpty()) {
			return null;
		}
		boolean traversed = false;
		List<EObject> subResults = new LinkedList<EObject>();
		for (TypeToken type : filteredtypes) {
			boolean didProp = false;
			EObject preResult = preProcessIncomingErrorPropagation(component, errorPropagation, type, scale);
			if (preResult != null) {
				results.add(preResult);// found common event
				continue;
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
			if (st.visited(errorPropagation, type)) {
				// we were there before.
				return foundCycle;
			} else {
				st.setVisitToken(errorPropagation, type);
			}
			for (PropagationGraphPath ppr : Util.getAllReversePropagationPaths(currentAnalysisModel, component,
					errorPropagation)) {
				// traverse incoming
				if (ppr.getConnection() != null) {
					ErrorSource ces = EMV2Util.findConnectionErrorSourceForConnection(ppr.getConnection());
					// the type constraint has to come from the error source as the connection does not have one
					if (ces != null && contains(ces.getTypeTokenConstraint(), type)) { // XXX filter type
						EObject result = processConnectionErrorSource(ppr.getConnection(), ces, type, scale);
						addSubresult(subResults, result);
						didProp = true;
					}
					ComponentInstance contextCI = ppr.getConnection().getComponentInstance();
					TypeTransformationSet tts = EMV2Util.getAllTypeTransformationSet(contextCI);

					for (PropagationPathEnd ppe : Util.getAllPropagationSourceEnds(currentAnalysisModel,
							ppr.getConnection())) {
						ComponentInstance componentSource = ppe.getComponentInstance();
						ErrorPropagation propagationSource = ppe.getErrorPropagation();
						TypeSet newtype = reverseMapTypeTokenToContributor(type, tts);
						if (newtype != null) {
							EList<TypeToken> ttlist = flattenTypesetElements(newtype);
							for (TypeToken typeToken : ttlist) {
								TypeToken ntype = EMV2TypeSetUtil.contains(typeToken, type) ? type : typeToken;
								EObject result = traverseOutgoingErrorPropagation(componentSource, propagationSource,
										ntype, scale);
								addSubresult(subResults, result);
								didProp = true;
							}
						} else {
							EObject result = traverseOutgoingErrorPropagation(componentSource, propagationSource, type,
									scale);
							addSubresult(subResults, result);
							didProp = true;
						}
						// source of connection
						newtype = reverseMapTypeTokenToSource(type, tts);
						if (newtype != null) {
							EList<TypeToken> ttlist = flattenTypesetElements(newtype);
							for (TypeToken typeToken : ttlist) {
								TypeToken ntype = EMV2TypeSetUtil.contains(typeToken, type) ? type : typeToken;
								EObject result = traverseOutgoingErrorPropagation(componentSource, propagationSource,
										ntype, scale);
								addSubresult(subResults, result);
								didProp = true;
							}
						} else {
							EObject result = traverseOutgoingErrorPropagation(componentSource, propagationSource, type,
									scale);
							if (!addSubresult(subResults, result)) {
								didProp = true;
							}
						}
					}
				}
				PropagationPathEnd ppe = ppr.getPathSrc();
				ComponentInstance componentSource = ppe.getComponentInstance();
				ErrorPropagation propagationSource = ppe.getErrorPropagation();
				if (propagationSource.getDirection() == DirectionType.IN) {
					// we have an external incoming propagation
					EObject result = processIncomingErrorPropagation(componentSource, propagationSource, type, scale);
					addSubresult(subResults, result);
					didProp = true;
				} else {
					EObject result = traverseOutgoingErrorPropagation(componentSource, propagationSource, type, scale);
					addSubresult(subResults, result);
					didProp = true;
				}
			}
			st.removeVisitedToken(errorPropagation, type);
			if (didProp) {
				traversed = true;
			}
		}
		if (!subResults.isEmpty()) {
			return postProcessIncomingErrorPropagation(component, errorPropagation, proptype, subResults, scale);
		}
		if (traversed) {
			return null;
		}
		// we have no subresults and did not prune. Allow handling of incoming propagation as endpoint of traversal
		return processIncomingErrorPropagation(component, errorPropagation, proptype, scale);
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
	public EObject traverseCompositeErrorState(ComponentInstance component, ErrorBehaviorState state, TypeToken type,
			BigDecimal scale) {
		return traverseCompositeErrorState(component, state, type, false, scale);
	}

	public EObject traverseCompositeErrorState(ComponentInstance component, ErrorBehaviorState state, TypeToken type,
			boolean stateOnly, BigDecimal scale) {
		preProcessCompositeErrorStates(component, state, type, scale);
		List<EObject> subResults = new LinkedList<EObject>();
		// should only match one composite state declaration.
		for (CompositeState cs : EMV2Util.getAllCompositeStates(component)) {
			if (cs.getState() == state && (type == null || EMV2TypeSetUtil.contains(cs.getTypedToken(), type))) {
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
			TypeToken type, BigDecimal scale) {
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
			ErrorPropagation errorPropagation, TypeToken targetType, List<EObject> subResults, BigDecimal scale) {
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
			TypeToken targetType, BigDecimal scale) {
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
	protected EObject processErrorSource(ComponentInstance component, ErrorSource errorSource, TypeToken type,
			BigDecimal scale) {
		return null;
	}

	/**
	 * post-process error source to add a subgraph for the error behavior state of when
	 * @param component
	 * @param errorSource
	 * @param typeTokenConstraint
	 * @return EObject (can be null)
	 */
	protected EObject postProcessErrorSource(ComponentInstance component, ErrorSource errorSource, TypeToken type,
			List<EObject> subResults, BigDecimal scale) {
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
			TypeToken typeTokenConstraint, BigDecimal scale) {
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
			TypeToken type, BigDecimal scale) {
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
			TypeToken type, BigDecimal scale) {
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
			ErrorPropagation errorPropagation, TypeToken targetType, List<EObject> subResults, BigDecimal scale) {
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
			TypeToken type, BigDecimal scale) {
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
			OutgoingPropagationCondition opc, TypeToken type, EObject conditionResult, EObject stateResult,
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
			TypeToken targetType, BigDecimal scale) {
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
			TypeToken targetType, List<EObject> subResults, BigDecimal scale) {
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
			TypeToken type, BigDecimal scale) {
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
			TypeToken type, List<EObject> subResults, BigDecimal scale) {
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
			TypeToken type, BigDecimal scale) {
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
			TypeToken type, EObject conditionResult, EObject stateResult, BigDecimal scale) {
		return null;
	}

	/**
	 * process error event as leaf of traversal
	 * @param component ComponentInstance
	 * @param event Error Event
	 * @param type Error Type
	 * @return EObject (can be null but is expected to return object representing traversal leaf)
	 */
	protected EObject processErrorEvent(ComponentInstance component, ErrorEvent errorEvent, TypeToken type,
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
	protected EObject preProcessAnd(ComponentInstance component, Element condition, TypeToken type, BigDecimal scale) {
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
	protected EObject postProcessAnd(ComponentInstance component, Element condition, TypeToken type,
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
	protected EObject preProcessPriorityAnd(ComponentInstance component, Element condition, TypeToken type,
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
	protected EObject postProcessPriorityAnd(ComponentInstance component, Element condition, TypeToken type,
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
	protected EObject preProcessXor(ComponentInstance component, Element condition, TypeToken type, BigDecimal scale) {
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
	protected EObject postProcessXor(ComponentInstance component, Element condition, TypeToken type, BigDecimal scale,
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
	protected EObject preProcessOr(ComponentInstance component, Element condition, TypeToken type, BigDecimal scale) {
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
	protected EObject postProcessOr(ComponentInstance component, Element condition, TypeToken type,
			List<EObject> subResults, BigDecimal scale) {
		return null;
	}

	/**
	 * pre process results ORRMORE expression
	 * called with non-empty subResults list
	 * @param component
	 * @param condition OR expression
	 * @param type Error Type
	 * @param scale scaling factor for probability
	 */
	protected EObject preProcessOrMore(ComponentInstance component, Element condition, TypeToken type,
			BigDecimal scale) {
		return null;
	}

	/**
	 * post process results ORMORE expression
	 * called with non-empty subResults list
	 * @param component
	 * @param condition OR expression
	 * @param type Error Type
	 * @param scale scaling factor for probability
	 * @param subResults Entities encountered as part of the sub-traversal
	 * @return EObject result representing the processing of the subresults list (can be null )
	 */
	protected EObject postProcessOrMore(ComponentInstance component, Element condition, TypeToken type,
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
	protected EObject processTypesetElements(ComponentInstance component, Element state, TypeToken type,
			List<EObject> subResults, BigDecimal scale) {
		return null;
	}

}
