package org.osate.xtext.aadl2.errormodel.util;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.Connection;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.util.InstanceUtil;
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

@Deprecated
public class PropagationGraphBackwardTraversal {

	private AnalysisModel currentAnalysisModel;

	public PropagationGraphBackwardTraversal(AnalysisModel m) {
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
			if (!EMV2TypeSetUtil.isNoError(opc.getTypeToken())) {
				// TODO deal with map result a type set
				ErrorTypes condTargetType = mapTargetType(opc.getTypeToken(), type);
				if ((EMV2Util.isSame(opc.getOutgoing(), errorPropagation) || opc.isAllPropagations())
						&& EMV2TypeSetUtil.contains(type, opc.getTypeToken())) {
					EObject res = handleOutgoingErrorPropagationCondition(component, opc, condTargetType);
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
		EList<PropagationPathEnd> propagationSources = currentAnalysisModel.getAllPropagationSourceEnds(component,
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
				boolean typeContained = EMV2TypeSetUtil.contains(ep.getTargetToken(), type);
				if (EMV2Util.isSame(ep.getOutgoing(), errorPropagation) && typeContained) {
					// TODO check on map
					EObject newEvent = traverseIncomingErrorPropagation(component, ep.getIncoming(),
							mapTargetType(ep.getTypeTokenConstraint(), type));
					if (newEvent != null) {
						subResults.add(newEvent);
					}
				}
			} else if (ef instanceof ErrorSource) {
				ErrorSource errorSource = (ErrorSource) ef;

				if (EMV2Util.isSame(errorSource.getSourceModelElement(), errorPropagation)) {
					if (EMV2TypeSetUtil.contains(errorSource.getTypeTokenConstraint(), type)) {
						EObject newEvent = processErrorSource(component, errorSource, ef.getTypeTokenConstraint());
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
			// XXX deal with types
			double scale = 1;
			boolean sameState = false;
			if (ebt.getTarget() != null && EMV2Util.isSame(state, ebt.getTarget())) {
				conditionExpression = ebt.getCondition();
				if (ebt.getSource() != null && EMV2Util.isSame(state, ebt.getSource())) {
					sameState = true;
				}
			} else if (!ebt.getDestinationBranches().isEmpty()) {
				// deal with transition branches
				EList<TransitionBranch> tbs = ebt.getDestinationBranches();
				for (TransitionBranch transitionBranch : tbs) {
					if (transitionBranch.getTarget() != null) {
						if (EMV2Util.isSame(transitionBranch.getTarget(), state)) {
							conditionExpression = ebt.getCondition();
							if (EMV2Util.isSame(ebt.getSource(), state)) {
								sameState = true;
							}

						}
					} else if (transitionBranch.isSteadyState()) {
						// same state
						if (ebt.getSource() != null && EMV2Util.isSame(state, ebt.getSource())) {
							conditionExpression = ebt.getCondition();
							sameState = true;
						}
					}
					if (conditionExpression != null) {
						BranchValue val = transitionBranch.getValue();
						if (val.getRealvalue() != null) {
							scale = Double.valueOf(EMV2Util.stripUnderScore(val.getRealvalue()));
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
				if (ebt.getSource() != null && EMV2Util.isSame(state, ebt.getSource())) {
					conditionExpression = ebt.getCondition();
					sameState = true;
				}
			}
			if (!sameState && conditionExpression != null) {
				// don't include transition staying in same state
				EObject conditionResult = processCondition(component, conditionExpression, type, scale);
				// XXX this is the recursive call
				// do not traverse back in same state
				// we also do not traverse back if left is allstates.
				if (conditionResult != null) {
					EObject stateResult = sameState || ebt.isAllStates() ? null
							: traverseErrorBehaviorState(component, ebt.getSource(), type);
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
			return processErrorBehaviorState(component, state, type);
		} else {
			// we have found an operational error state (no incoming transitions with error events)
			// Do not include in EMFTA tree
			return null;
		}
	}

	/**
	 * Process a condition, either from a component error behavior or a
	 * composite error behavior.
	 *
	 * @param component the component that contains the condition
	 * @param condition the ConditionExpression to be analyzed
	 * @return an EObject related to the condition (can be null)
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
	 * @return an EObject related to the condition (can be null)
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
				for (ConditionExpression ce : allCondition.getOperands()) {
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
					ErrorTypes referencedErrorType = mapTargetType(sconditionElement.getConstraint(), type);
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
				ErrorTypes referencedErrorType = mapTargetType(conditionElement.getConstraint(), type);

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
					if (EMV2TypeSetUtil.isNoError(referencedErrorType)) {
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
		for (PropagationPathRecord ppr : currentAnalysisModel.getAllReversePropagationPaths(component,
				errorPropagation)) {
			// traverse incoming
			PropagationPathEnd ppe = ppr.getPathSrc();
			if (ppr.getConnectionInstance() != null) {
				ErrorSource ces = EMV2Util
						.findConnectionErrorSourceForConnection(ppr.getConnectionInstance());
				if (ces != null && EMV2TypeSetUtil.contains(ces.getTypeTokenConstraint(), type)) {
					EObject result = processConnectionErrorSource(
							InstanceUtil.findConnectionContext(ppr.getConnectionInstance(),
									(Connection) ces.getSourceModelElement()),
							ces,
							type);
					if (result != null) {
						subResults.add(result);
					}
				}
			}
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
		if (!subResults.isEmpty()) {
			return postProcessCompositeErrorStates(component, state, type, subResults);
		}
		return traverseErrorBehaviorState(component, state, type);
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
	protected EObject processErrorSource(ComponentInstance component, ErrorSource errorSource,
			TypeSet typeTokenConstraint) {
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
	protected EObject processConnectionErrorSource(ComponentInstance component, ErrorSource errorSource,
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
	protected EObject preProcessAnd(ComponentInstance component, ConditionExpression condition, ErrorTypes type,
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
	protected EObject postProcessAnd(ComponentInstance component, ConditionExpression condition, ErrorTypes type,
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
	protected EObject postProcessXor(ComponentInstance component, ConditionExpression condition, ErrorTypes type,
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
	protected EObject preProcessXor(ComponentInstance component, ConditionExpression condition, ErrorTypes type,
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
	protected EObject postProcessOr(ComponentInstance component, ConditionExpression condition, ErrorTypes type,
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
	protected EObject preProcessOr(ComponentInstance component, ConditionExpression condition, ErrorTypes type,
			double scale) {
//		OsateDebug.osateDebug("postProcessOr " + component.getName());
		return null;
	}

}
