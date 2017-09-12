package org.osate.aadl2.errormodel.analysis.fta;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.util.OsateDebug;
import org.osate.xtext.aadl2.errormodel.errorModel.AndExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.CompositeState;
import org.osate.xtext.aadl2.errormodel.errorModel.ConditionElement;
import org.osate.xtext.aadl2.errormodel.errorModel.ConditionExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorTransition;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorFlow;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPath;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorSource;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypes;
import org.osate.xtext.aadl2.errormodel.errorModel.EventOrPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.OrExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.SConditionElement;
import org.osate.xtext.aadl2.errormodel.errorModel.SubcomponentElement;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeToken;
import org.osate.xtext.aadl2.errormodel.util.AnalysisModel;
import org.osate.xtext.aadl2.errormodel.util.EM2TypeSetUtil;
import org.osate.xtext.aadl2.errormodel.util.EMV2Properties;
import org.osate.xtext.aadl2.errormodel.util.EMV2Util;
import org.osate.xtext.aadl2.errormodel.util.PropagationPathEnd;

public class FTAUtils {
	private static AnalysisModel currentAnalysisModel;

	/**
	 * Init the FTAUtils class for a particular
	 * component instance.
	 * @param root - the root system instance to be processed.
	 */
	public static void init(ComponentInstance root) {
		currentAnalysisModel = new AnalysisModel(root);
	}

	public static String getDescription(ComponentInstance component, NamedElement errorModelArtifact, TypeSet typeSet) {
		String description;
		description = "";

		if (errorModelArtifact instanceof ErrorSource) {
			ErrorSource errorSource = (ErrorSource) errorModelArtifact;

			description += "Error source";

			if (errorSource.getName() != null) {
				description += " " + errorSource.getName();
			}
			description += " on component " + component.getName();

			if ((errorSource.getOutgoing().getFeatureorPPRef() != null)
					&& (errorSource.getOutgoing().getFeatureorPPRef().getFeatureorPP() != null)) {
				NamedElement el = errorSource.getOutgoing().getFeatureorPPRef().getFeatureorPP();
				description += " from ";
				description += el.getName();
			}

			description += " with types " + EMV2Util.getPrintName(typeSet);

		}

		if (errorModelArtifact instanceof ErrorEvent) {
			ErrorEvent errorEvent = (ErrorEvent) errorModelArtifact;
			description += "Error";
			description += " event " + errorEvent.getName();
			description += " with types " + EMV2Util.getPrintName(typeSet);
			description += " on component " + component.getName();

		}

		if (errorModelArtifact instanceof ErrorBehaviorState) {
			ErrorBehaviorState ebs = (ErrorBehaviorState) errorModelArtifact;
			description = "component " + component.getName() + " in state " + ebs.getName();
		}

		return description;
	}

	/**
	 * Fill an Event with all the properties from the AADL model. Likely, all the related
	 * values in the Hazard property from EMV2.
	 *
	 * @param event					- the event related to the EMV2 artifact
	 * @param component             - the component from the event
	 * @param errorModelArtifact    - the EMV2 artifact (error event, error propagation, etc)
	 * @param typeSet               - the type set (null if none)
	 */
	public static void fillProperties(Event event, ComponentInstance component, NamedElement errorModelArtifact,
			TypeSet typeSet) {
		String propertyDescription;
		propertyDescription = EMV2Properties.getDescription(errorModelArtifact, component);

		if (propertyDescription == null) {
			event.setDescription(getDescription(component, errorModelArtifact, typeSet));
		} else {
			event.setDescription(propertyDescription + "(component " + component.getName() + ")");
		}

		event.setProbability(EMV2Properties.getProbability(component, errorModelArtifact, typeSet));
	}

	/**
	 * For one incoming error propagation and one component, returns all the potential
	 * errors contributors.
	 * @param component         - the component that has the incoming error propagation
	 * @param errorPropagation  - the error propagation
	 * @return                  - a list of event that has all the error contributors
	 */
	public static Event getAllEventsFromPropagationSource(final ComponentInstance component,
			final ErrorPropagation errorPropagation, final TypeToken typeToken, final Stack<Event> history) {
		List<PropagationPathEnd> propagationSources;
		Event result;
		List<Event> subEvents;

		subEvents = new ArrayList<Event>();

		if (component.getName().equalsIgnoreCase("engine")) {
			OsateDebug.osateDebug("FTAUtils", "engine");
		}

		if (component.getName().equalsIgnoreCase("sm_pcs")) {
			OsateDebug.osateDebug("FTAUtils", "sm_pcs");
		}

//		if (errorPropagation.getKind() != null)
//		{
//			throw new UnsupportedOperationException("special kind");
//		}

		if (EMV2Util.isProcessor(errorPropagation)) {
			OsateDebug.osateDebug("OsateUtils", "processor");
		}

		if (EMV2Util.isAccess(errorPropagation)) {
			OsateDebug.osateDebug("OsateUtils", "access");
			throw new UnsupportedOperationException("special kind");

		}

		if (EMV2Util.isBinding(errorPropagation)) {
			OsateDebug.osateDebug("OsateUtils", "access");
			throw new UnsupportedOperationException("special kind");
		}

		OsateDebug.osateDebug("FTAUtils", "propagation=" + EMV2Util.getPrintName(errorPropagation));
		OsateDebug.osateDebug("FTAUtils", "types=" + EMV2Util.getPrintName(typeToken));

		propagationSources = currentAnalysisModel.getAllPropagationSourceEnds(component, errorPropagation);

		for (PropagationPathEnd ppe : propagationSources) {
			ComponentInstance componentSource = ppe.getComponentInstance();
			ErrorPropagation propagationSource = ppe.getErrorPropagation();
			ComponentInstance componentDestination = component;
			ErrorPropagation propagationDestination = errorPropagation;

			/**
			 * Compute the correct type to search for
			 */

			for (ErrorFlow ef : EMV2Util.getAllErrorFlows(componentSource)) {
				/**
				 * Let's walk through all error path and see which one to browse
				 */
				if (ef instanceof ErrorPath) {
					ErrorPath errorPath = (ErrorPath) ef;
					OsateDebug.osateDebug("FTAUtils", "==========================");
					OsateDebug.osateDebug("FTAUtils",
							"Analyzing propagation: " + EMV2Util.getPrintName(propagationSource));
					OsateDebug.osateDebug("FTAUtils", "Analyzing typetoken  : " + EMV2Util.getPrintName(typeToken));

					OsateDebug.osateDebug("FTAUtils", "Error Path: " + errorPath.getName());
					OsateDebug.osateDebug("FTAUtils", "source=" + EMV2Util.getPrintName(errorPath.getIncoming()));
					OsateDebug.osateDebug("FTAUtils", "dest  =" + EMV2Util.getPrintName(errorPath.getOutgoing()));
					OsateDebug.osateDebug("FTAUtils",
							"constraint type=" + EMV2Util.getPrintName(errorPath.getTypeTokenConstraint()));
					OsateDebug.osateDebug("FTAUtils",
							"target token=" + EMV2Util.getPrintName(errorPath.getTargetToken()));

					if (propagationEndsMatches(errorPath.getOutgoing(), propagationSource) == false) {
						OsateDebug.osateDebug("FTAUtils",
								"ends do not match on path" + errorPath.getName() + "source="
										+ EMV2Util.getPropagationName(propagationSource) + ";types2="
										+ EMV2Util.getPropagationName(propagationDestination));
						continue;
					}

					/**
					 * If in the path the
					 */
					if (errorPath.getTargetToken() != null) {
						if (!EM2TypeSetUtil.contains(errorPath.getTargetToken(), typeToken)) {
							OsateDebug.osateDebug("FTAUtils",
									"types do not match on path " + errorPath.getName() + ";types1="
											+ EMV2Util.getPrintName(errorPath.getTargetToken()) + ";types2="
											+ EMV2Util.getPrintName(typeToken));
							continue;
						}

						if (errorPath.getTypeTokenConstraint() == null) {
							subEvents.add(getAllEventsFromPropagationSource(componentSource, errorPath.getIncoming(),
									null, history));
						} else {
							for (TypeToken tt : errorPath.getTypeTokenConstraint().getTypeTokens()) {
								subEvents.add(getAllEventsFromPropagationSource(componentSource,
										errorPath.getIncoming(), tt, history));
							}
						}
					} else {
						if (!EM2TypeSetUtil.contains(errorPath.getTypeTokenConstraint(), typeToken)) {
							OsateDebug.osateDebug("FTAUtils",
									"types do not match on path " + errorPath.getName() + ";types1="
											+ EMV2Util.getPrintName(errorPath.getTypeTokenConstraint()) + ";types2="
											+ EMV2Util.getPrintName(typeToken));
							continue;
						}
						if (errorPath.getTypeTokenConstraint() == null) {
							subEvents.add(getAllEventsFromPropagationSource(componentSource, errorPath.getIncoming(),
									null, history));
						} else {
							for (TypeToken tt : errorPath.getTypeTokenConstraint().getTypeTokens()) {
								subEvents.add(getAllEventsFromPropagationSource(componentSource,
										errorPath.getIncoming(), tt, history));
							}
						}

					}
				}

				/**
				 * If the error source is actually the source
				 * of the error propagation.
				 */
				if (ef instanceof ErrorSource) {
					ErrorSource errorSource = (ErrorSource) ef;

					if (propagationEndsMatches(propagationSource, errorSource.getOutgoing())) {
						if (EM2TypeSetUtil.contains(errorSource.getTypeTokenConstraint(), typeToken)) {
							Event newEvent = new Event();
							newEvent.setEventType(EventType.EVENT);
							fillProperties(newEvent, componentSource, errorSource, ef.getTypeTokenConstraint());
							subEvents.add(newEvent);
						}
					}
				}
			}
		}

		/**
		 * Then, we build the final tree.
		 */
		switch (subEvents.size()) {
		case 0: {
			result = new Event();
			String desc = "Events from component " + component.getName() + " on "
					+ EMV2Util.getPrintName(errorPropagation);
			if (typeToken != null) {
				desc += " with types " + EMV2Util.getPrintName(typeToken);
			}
			desc += " (no error source found)";

			result.setDescription(desc);
			result.setEventType(EventType.EVENT);
			break;
		}
		case 1: {
			result = subEvents.get(0);
			result.setEventType(EventType.EVENT);
			break;
		}
		default: {
			result = new Event();
			String desc = "Events from component " + component.getName() + " on "
					+ EMV2Util.getPrintName(errorPropagation);
			if (typeToken != null) {
				desc += " with types " + EMV2Util.getPrintName(typeToken);
			}
			result.setDescription(desc);

			result.setEventType(EventType.NORMAL);

			Event gate = new Event();
			gate.setEventType(EventType.OR);
			gate.getSubEvents().addAll(subEvents);
			result.getSubEvents().add(gate);

		}
		}

		return result;
	}

	private static boolean propagationEndsMatches(ErrorPropagation propagationSource,
			ErrorPropagation propagationDestination) {
		return EMV2Util.isSame(propagationSource, propagationDestination);
	}

	/**
	 * Process a condition, either from a component error behavior or
	 * a composite error behavior.
	 * @param component - the component that contains the condition
	 * @param condition - the ConditionExpression to be analyzed
	 * @return a list of events related to the condition
	 */
	public static List<Event> processCondition(ComponentInstance component, ConditionExpression condition) {
		List<Event> returnedEvents;

		returnedEvents = new ArrayList<Event>();

		// OsateDebug.osateDebug("[FTAUtils] condition=" + condition);

		/**
		 * We have an AND expression, so, we create an EVENT to AND'
		 * sub events.
		 */
		if (condition instanceof AndExpression) {
			AndExpression expression;
			Event newEvent;

			newEvent = new Event();
			newEvent.setEventType(EventType.AND);
			newEvent.setDescription("Occurrence of all the following events");

			expression = (AndExpression) condition;
			for (ConditionExpression ce : expression.getOperands()) {
				for (Event tmp : processCondition(component, ce)) {
					newEvent.addSubEvent(tmp);
				}
			}
			returnedEvents.add(newEvent);
		} else

		/**
		 * We have an OR expression, so, we create an EVENT to OR'd
		 * sub events.
		 */
		if (condition instanceof OrExpression) {
			OrExpression expression;
			Event newEvent;

			newEvent = new Event();
			newEvent.setEventType(EventType.OR);
			newEvent.setDescription("Occurrence of one of the following events");

			expression = (OrExpression) condition;
			for (ConditionExpression ce : expression.getOperands()) {
				for (Event tmp : processCondition(component, ce)) {
					newEvent.addSubEvent(tmp);
				}
			}
			returnedEvents.add(newEvent);
		} else

		if (condition instanceof OrExpression) {
			OrExpression expression;
			Event newEvent;

			newEvent = new Event();
			newEvent.setEventType(EventType.OR);
			newEvent.setDescription("Occurrence of one of the following events");

			expression = (OrExpression) condition;
			for (ConditionExpression ce : expression.getOperands()) {
				for (Event tmp : processCondition(component, ce)) {
					newEvent.addSubEvent(tmp);
				}
			}
			returnedEvents.add(newEvent);
		} else

		/**
		 * Here, we have a single condition element.
		 */
		if (condition instanceof ConditionElement) {
			ConditionElement conditionElement = (ConditionElement) condition;
			/**
			 * Here, we have a reference to a subcomponent and then, potentially
			 * one of its state. This is what we find in a composite error
			 * state machine.
			 */
			if (condition instanceof SConditionElement) {
				SConditionElement sConditionElement = (SConditionElement) condition;
				if (sConditionElement.getQualifiedState() != null) {
					/**
					 * In the following, it seems that we reference another component.
					 * This is typically the case when the condition is within
					 * an composite error behavior.
					 *
					 * So, we find the referenced component in the component hierarchy
					 * and add all its contributors to the returned events.
					 */
					// OsateDebug.osateDebug("[FTAUtils] processCondition subcomponents are present, size=" + conditionElement.getSubcomponents().size());
					SubcomponentElement subcomponentElement = sConditionElement.getQualifiedState().getSubcomponent();
					Subcomponent subcomponent = subcomponentElement.getSubcomponent();
					ComponentInstance referencedInstance;
					ErrorTypes referencedErrorType;
					referencedInstance = null;
					referencedErrorType = null;
					// OsateDebug.osateDebug("[FTAUtils] subcomponent=" + subcomponent);

					for (ComponentInstance sub : component.getComponentInstances()) {
						// OsateDebug.osateDebug("[FTAUtils] sub=" + sub.getSubcomponent());
						if (sub.getSubcomponent().getName().equalsIgnoreCase(subcomponent.getName())) {
							referencedInstance = sub;
						}
					}

					if ((conditionElement.getConstraint() != null)
							&& (conditionElement.getConstraint().getTypeTokens().size() > 0)) {
						referencedErrorType = conditionElement.getConstraint().getTypeTokens().get(0).getType().get(0);
					}

					// OsateDebug.osateDebug("[FTAUtils] referenced component instance=" + referencedInstance);
					// OsateDebug.osateDebug("[FTAUtils] referenced type=" + referencedErrorType);

					returnedEvents.add(processErrorState(referencedInstance, EMV2Util.getState(sConditionElement),
							referencedErrorType));
				}
			} else {

				EventOrPropagation eop = EMV2Util.getErrorEventOrPropagation(conditionElement);
				if (eop != null) {
					// OsateDebug.osateDebug("[FTAUtils] processCondition incoming=" + conditionElement.getIncoming());

					/**
					 * Here, we have an error event. Likely, this is something we can get
					 * when we are analyzing error component behavior.
					 */
					if (eop instanceof ErrorEvent) {
						ErrorEvent errorEvent;
						Event newEvent;

						errorEvent = (ErrorEvent) eop;

						newEvent = new Event();
						newEvent.setDescription("Error event " + errorEvent.getName() + "types "
								+ EMV2Util.getPrintName(errorEvent.getTypeSet()));
						newEvent.setEventType(EventType.EVENT);

						fillProperties(newEvent, component, errorEvent, errorEvent.getTypeSet());

						returnedEvents.add(newEvent);

					}

					/**
					 * Here, we have an error propagation. This is notified
					 * with the in propagation within a composite error
					 * model.
					 */
					if (eop instanceof ErrorPropagation) {
						ErrorPropagation errorPropagation;
						Event newEvent;
						errorPropagation = (ErrorPropagation) eop;
						TypeSet constraint = conditionElement.getConstraint();
						if (constraint == null) {
							constraint = ((ErrorPropagation) eop).getTypeSet();
						}

						newEvent = new Event();
						newEvent.setDescription("Error Propagation on " + EMV2Util.getPrintName(errorPropagation)
								+ " types " + EMV2Util.getPrintName(constraint));
						newEvent.setEventType(EventType.EVENT);

						returnedEvents.add(newEvent);

						List<Event> contributors = new ArrayList<Event>();
						for (TypeToken tt : constraint.getTypeTokens()) {
							contributors.add(getAllEventsFromPropagationSource(component, errorPropagation, tt,
									new Stack<Event>()));
						}

						if (contributors.size() > 0) {
							Event orGate = new Event();
							orGate.setEventType(EventType.OR);
							orGate.setDescription("Occurrence of one of the following events");
							orGate.getSubEvents().addAll(contributors);
							newEvent.addSubEvent(orGate);
							newEvent.setEventType(EventType.NORMAL);
						}
					}
				}
			}
		}

		return returnedEvents;
	}

	/**
	 * Process a component error behavior, analyze its transition
	 * and produces a list of all events that could then be
	 * added in a fault-tree.
	 * @param component - The component under analysis (the one that contains the error behavior)
	 * @param state     - The target states of the transitions under analysis
	 * @param type      - The type associated with the target state
	 * @return          - list of events that are related to the target state in this component.
	 */
	public static List<Event> processComponentErrorBehavior(ComponentInstance component, ErrorBehaviorState state,
			ErrorTypes type) {
		/**
		 * Depending on the condition, it returns either a single element, an AND or an OR.
		 */
		List<Event> returnedEvents;

		returnedEvents = new ArrayList<Event>();

		for (ErrorBehaviorTransition transition : EMV2Util.getAllErrorBehaviorTransitions(component)) {
			if (transition.getTarget() == state) {
				returnedEvents.addAll(processCondition(component, transition.getCondition()));
			}
		}

		return returnedEvents;
	}

	/**
	 * Process a composite error behavior for a component and try to get
	 * all related potential events to add in a FTA
	 * @param component  - the component under analysis
	 * @param state      - the target state under analysis
	 * @param type       - the type associated to the target state (if any)
	 * @return           - the list of all potential related FTA events
	 */
	public static List<Event> processCompositeErrorBehavior(ComponentInstance component, ErrorBehaviorState state,
			ErrorTypes type) {
		/**
		 * Depending on the condition, it returns either a single element, an AND or an OR.
		 */
		List<Event> returnedEvents;

		returnedEvents = new ArrayList<Event>();

		for (CompositeState cs : EMV2Util.getAllCompositeStates(component)) {
			if (cs.getState() == state) {
				returnedEvents.addAll(processCondition(component, cs.getCondition()));
			}
		}

		return returnedEvents;
	}

	/**
	 * Process a particular error behavior state and try to
	 * get all potential error contributors, either from the
	 * component error behavior or the composite error behavior.
	 *
	 * @param component - the component under analysis
	 * @param state     - the failure mode under analysis
	 * @param type      - the type related to the failure mode (null if not useful)
	 * @return          - a node that represents either the single failure state or
	 *                    an AND- or OR- nodes if several.
	 */
	public static Event processErrorState(ComponentInstance component, ErrorBehaviorState state, ErrorTypes type) {
		List<Event> subEvents;
		Event returnedEvent;

		returnedEvent = new Event();
		returnedEvent.setEventType(EventType.NORMAL);

		fillProperties(returnedEvent, component, state, state.getTypeSet());

		subEvents = new ArrayList<Event>();

		subEvents.addAll(processComponentErrorBehavior(component, state, type));
		subEvents.addAll(processCompositeErrorBehavior(component, state, type));

		/**
		 * If we have only one subevent, we directly attach it
		 * to the main event.
		 */
		if (subEvents.size() == 1) {
			return subEvents.get(0);

			// The following code is commented. When we have only one sub event, it does
			// not seem to make sense to continue and try to process more events.

			// if (subEvents.get(0).getEventType() == EventType.NORMAL) {
			// /**
			// * If the subevent is also a normal event, we directly return
			// * it and bypass the other one.
			// */
			// return subEvents.get(0);
			// } else {
			// /**
			// * In that case, here, we have an event. We add it directly.
			// */
			// returnedEvent.addSubEvent(subEvents.get(0));
			// }
		}

		/**
		 * If we have several intermediate subevents, we consider
		 * that each one is independent. So, we make an OR gate
		 * to connect all these events altogether.
		 */
		if (subEvents.size() > 1) {
			// OsateDebug.osateDebug("FTAUtils", "More than one event, needs to make an or");
			Event intermediateEvent = new Event();
			intermediateEvent.setEventType(EventType.OR);
			intermediateEvent.setDescription("Occurrence of one of the following events");

			for (Event ev : subEvents) {
				intermediateEvent.addSubEvent(ev);
			}
			returnedEvent.addSubEvent(intermediateEvent);
		}

		return returnedEvent;

	}
}
