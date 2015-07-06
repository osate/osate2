package org.osate.aadl2.errormodel.analysis.fta;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Port;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.instance.ComponentInstance;
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
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypes;
import org.osate.xtext.aadl2.errormodel.errorModel.FeatureorPPReference;
import org.osate.xtext.aadl2.errormodel.errorModel.OrExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.SAndExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.SOrExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.SubcomponentElement;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;
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
		if (propertyDescription != null) {
			event.setDescription(propertyDescription);
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
	public static List<Event> getAllEventsFromPropagationSource(ComponentInstance component,
			ErrorPropagation errorPropagation, TypeSet typeSet) {
		List<PropagationPathEnd> propagationSources;
		Event newEvent;
		List<Event> returnedEvents;
		String description;
		TypeSet reportedTypeSet;
		ComponentInstance remoteComponent;
		List<Event> subEvents;

		returnedEvents = new ArrayList<Event>();

		/**
		 * Right now, the analysis model does not return the source ends for a processor
		 * error propagation. So, we just add a new event.
		 */
		if ((errorPropagation.getKind() != null) && (errorPropagation.getKind().equalsIgnoreCase("processor"))) {
//			OsateDebug.osateDebug("From Processor");
			newEvent = new Event();
			newEvent.setEventType(EventType.EVENT);
			description = "Processor error";

			if (typeSet != null) {
				description += " with types " + EMV2Util.getPrintName(typeSet);
			}

			newEvent.setDescription(description);
			returnedEvents.add(newEvent);
		}

		/**
		 * We just browse recursively the propagation and eventually reach down
		 * to the original fault.
		 */
		propagationSources = currentAnalysisModel.getAllPropagationSourceEnds(component, errorPropagation);
		subEvents = new ArrayList<Event>();

		for (PropagationPathEnd ppe : propagationSources) {
			ErrorPropagation remotePropagation;
			remoteComponent = ppe.getComponentInstance();
			remotePropagation = ppe.getErrorPropagation();
			newEvent = new Event();
			description = "Error from component " + ppe.getComponentInstance().getName();

			if ((EMV2Util.getFeatureorPPRefs(remotePropagation) != null) && (EMV2Util.getFeatureorPPRefs(remotePropagation).size() > 0)) {
				description += " on " + EMV2Util.getFeatureorPPRefs(remotePropagation).get(0).getFeatureorPP().getName();
			}

			if ((typeSet != null) && (typeSet.getTypeTokens().size() > 0)) {
				reportedTypeSet = typeSet;
			} else {
				reportedTypeSet = remotePropagation.getTypeSet();
			}

			if (reportedTypeSet.getTypeTokens().size() > 0) {
				description += " with types " + EMV2Util.getPrintName(reportedTypeSet);
			}

//			OsateDebug.osateDebug("FTAUtils",
//					"error on " + description + "Types = " + EMV2Util.getPrintName(reportedTypeSet));

			/**
			 * We try here to gather potential additional incoming flows. We take
			 * the flows from the component and see the internal error paths
			 * and call recursively the same method.
			 */
//			OsateDebug.osateDebug("FTAUtils", "remote component=" + remoteComponent.getName());
			Collection<ErrorFlow> errorFlows = EMV2Util.getAllErrorFlows(remoteComponent);

			for (ErrorFlow ef : errorFlows) {
//				OsateDebug.osateDebug("FTAUtils", "flow-id=" + ef.getName());

				if (ef instanceof ErrorPath) {
					ErrorPath errorPath = (ErrorPath) ef;

//					OsateDebug.osateDebug("FTAUtils", "path kind=" + errorPath.getIncoming().getKind());
//					OsateDebug.osateDebug("FTAUtils", "report token" + EMV2Util.getPrintName(reportedTypeSet));
//
//					OsateDebug.osateDebug("FTAUtils",
//							"target token" + EMV2Util.getPrintName(errorPath.getTargetToken()));

					if (EM2TypeSetUtil.contains(errorPath.getTargetToken(), reportedTypeSet)) {
						ErrorPropagation incomingPropagation = errorPath.getIncoming();

//						OsateDebug.osateDebug("FTAUtils", "Should consider incoming" + incomingPropagation);
						subEvents.addAll(getAllEventsFromPropagationSource(remoteComponent, incomingPropagation,
								errorPath.getTypeTokenConstraint()));

					}
				}
			}

			newEvent.setDescription(description);
			fillProperties(newEvent, remoteComponent, remotePropagation, reportedTypeSet);

			if (subEvents.size() > 0) {
				if (subEvents.size() == 1) {
					return subEvents;
				} else {
					newEvent.setEventType(EventType.NORMAL);
					Event orEvent = new Event();
					orEvent.setEventType(EventType.OR);
					for (Event ev : subEvents) {
						orEvent.addSubEvent(ev);
					}
					newEvent.addSubEvent(orEvent);

				}
			} else {
				newEvent.setEventType(EventType.EVENT);

			}
			returnedEvents.add(newEvent);
		}

		return returnedEvents;
	}

	public static String getFeatureFromErrorPropagation(ErrorPropagation errorPropagation) {
		for (FeatureorPPReference fp : EMV2Util.getFeatureorPPRefs(errorPropagation)) {
			return fp.getFeatureorPP().getName();
		}
		return "unknown feature";
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
		List<Event> contributors;

		returnedEvents = new ArrayList<Event>();

//		OsateDebug.osateDebug("[FTAUtils] condition=" + condition);

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
		}

		if ((condition instanceof SAndExpression)) {
			SAndExpression expression;
			Event newEvent;

			newEvent = new Event();
			newEvent.setEventType(EventType.AND);
			newEvent.setDescription("Occurrence of all the following events");

			expression = (SAndExpression) condition;
			for (ConditionExpression ce : expression.getOperands()) {
				for (Event tmp : processCondition(component, ce)) {
					newEvent.addSubEvent(tmp);
				}
			}
			returnedEvents.add(newEvent);
		}

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
		}

		if (condition instanceof SOrExpression) {
			SOrExpression expression;
			Event newEvent;

			newEvent = new Event();
			newEvent.setEventType(EventType.OR);
			newEvent.setDescription("Occurrence of one of the following events");

			expression = (SOrExpression) condition;
			for (ConditionExpression ce : expression.getOperands()) {
				for (Event tmp : processCondition(component, ce)) {
					newEvent.addSubEvent(tmp);
				}
			}
			returnedEvents.add(newEvent);
		}

		/**
		 * Here, we have a single condition element.
		 */
		if (condition instanceof ConditionElement) {
			ConditionElement conditionElement = (ConditionElement) condition;
			if (conditionElement.getIncoming() != null) {
//				OsateDebug.osateDebug("[FTAUtils] processCondition incoming=" + conditionElement.getIncoming());

				/**
				 * Here, we have an error event. Likely, this is something we can get
				 * when we are analyzing error component behavior.
				 */
				if (conditionElement.getIncoming() instanceof ErrorEvent) {
					ErrorEvent errorEvent;
					Event newEvent;

					errorEvent = (ErrorEvent) conditionElement.getIncoming();

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
				if (conditionElement.getIncoming() instanceof ErrorPropagation) {
					ErrorPropagation errorPropagation;
					Event newEvent;
					FeatureorPPReference fpr;
					String propagationPoint;

					errorPropagation = (ErrorPropagation) conditionElement.getIncoming();

					if ((EMV2Util.getFeatureorPPRefs(errorPropagation) != null)
							&& (EMV2Util.getFeatureorPPRefs(errorPropagation).size() > 0)) {
						fpr = EMV2Util.getFeatureorPPRefs(errorPropagation).get(0);
					} else {
						fpr = null;
					}
					propagationPoint = "unknown propagation point";

//					OsateDebug.osateDebug("[FTAUtils] fpr=" + fpr.getFeatureorPP());

					if ((fpr != null) && (fpr.getFeatureorPP() instanceof Port)) {
						propagationPoint = ((Port) fpr.getFeatureorPP()).getName();
					}

//					for (PropagationPathRecord ppr : currentAnalysisModel.getAllReversePropagationPaths(component, errorPropagation))
//					{
//						OsateDebug.osateDebug("FTAUtils", "ppr ci      =" + ppr.getSrcCI());
//						OsateDebug.osateDebug("FTAUtils", "ppr path end=" + ppr.getPathSrc().getComponentInstance());
//					}

					contributors = getAllEventsFromPropagationSource(component, errorPropagation,
							conditionElement.getConstraint());

					/**
					 * We found the contributors (it means that the error paths are defined in the model)
					 */
					if (contributors.size() > 0) {
						/**
						 * If there is only one path, then, we add it as an event.
						 *
						 */
						if (contributors.size() == 1) {
							returnedEvents.add(contributors.get(0));
						} else {
							/**
							 * If we have multiple error path leading to this event, then, we created
							 * an OR gate to OR'ed all the events.
							 */
							Event orEvent = new Event();
							orEvent.setEventType(EventType.OR);

							for (Event ev : contributors) {
								orEvent.addSubEvent(ev);
							}
							returnedEvents.add(orEvent);
						}

					} else {
						/**
						 * Here, we are not able to find the related sources and error path
						 * We just add an event in the tree.
						 */
						newEvent = new Event();
						newEvent.setDescription("Error Propagation on " + propagationPoint + "types "
								+ EMV2Util.getPrintName(errorPropagation.getTypeSet()));
						newEvent.setEventType(EventType.EVENT);
						returnedEvents.add(newEvent);
					}

				}
			}

			/**
			 * Here, we have a reference to a subcomponent and then, potentially
			 * one of its state. This is what we find in a composite error
			 * state machine.
			 */
			if (conditionElement.getSubcomponents().size() > 0) {
				/**
				 * In the following, it seems that we reference another component.
				 * This is typically the case when the condition is within
				 * an composite error behavior.
				 *
				 * So, we find the referenced component in the component hierarchy
				 * and add all its contributors to the returned events.
				 */
//				OsateDebug.osateDebug("[FTAUtils] processCondition subcomponents are present, size=" + conditionElement.getSubcomponents().size());
				SubcomponentElement subcomponentElement = conditionElement.getSubcomponents().get(0);
				Subcomponent subcomponent = subcomponentElement.getSubcomponent();
				ComponentInstance referencedInstance;
				ErrorTypes referencedErrorType;
				referencedInstance = null;
				referencedErrorType = null;
//				OsateDebug.osateDebug("[FTAUtils] subcomponent=" + subcomponent);

				for (ComponentInstance sub : component.getComponentInstances()) {
//					OsateDebug.osateDebug("[FTAUtils] sub=" + sub.getSubcomponent());
					if (sub.getSubcomponent().getName().equalsIgnoreCase(subcomponent.getName())) {
						referencedInstance = sub;
					}
				}

				if ((conditionElement.getConstraint() != null)
						&& (conditionElement.getConstraint().getTypeTokens().size() > 0)) {
					referencedErrorType = conditionElement.getConstraint().getTypeTokens().get(0).getType().get(0);
				}

//				OsateDebug.osateDebug("[FTAUtils] referenced component instance=" + referencedInstance);
//				OsateDebug.osateDebug("[FTAUtils] referenced type=" + referencedErrorType);

				returnedEvents.add(processErrorState(referencedInstance, conditionElement.getState(),
						referencedErrorType));
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
		returnedEvent.setDescription("component " + component.getName() + " in state " + state.getName());
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

			if (subEvents.get(0).getEventType() == EventType.NORMAL) {
				/**
				 * If the subevent is also a normal event, we directly return
				 * it and bypass the other one.
				 */
				return subEvents.get(0);
			} else {
				/**
				 * In that case, here, we have an event. We add it directly.
				 */
				returnedEvent.addSubEvent(subEvents.get(0));
			}
		}

		/**
		 * If we have several intermediate subevents, we consider
		 * that each one is independent. So, we make an OR gate
		 * to connect all these events altogether.
		 */
		if (subEvents.size() > 1) {
//			OsateDebug.osateDebug("FTAUtils", "More than one event, needs to make an or");
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
