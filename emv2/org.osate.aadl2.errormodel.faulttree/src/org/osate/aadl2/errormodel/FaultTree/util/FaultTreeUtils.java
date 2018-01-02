package org.osate.aadl2.errormodel.FaultTree.util;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.Element;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.errormodel.FaultTree.Event;
import org.osate.aadl2.errormodel.FaultTree.EventType;
import org.osate.aadl2.errormodel.FaultTree.FaultTree;
import org.osate.aadl2.errormodel.FaultTree.FaultTreeFactory;
import org.osate.aadl2.errormodel.FaultTree.LogicOperation;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorSource;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypes;
import org.osate.xtext.aadl2.errormodel.util.EMV2Properties;
import org.osate.xtext.aadl2.errormodel.util.EMV2Util;

public class FaultTreeUtils {

	private static String buildName(ConnectionInstance conni, NamedElement namedElement, ErrorTypes type) {
		String identifier;

		identifier = conni.getName();
		identifier += "-";

		if (namedElement == null) {
			identifier += "unidentified";

		} else {
			identifier += EMV2Util.getPrintName(namedElement);
		}

		if (type == null) {
//			identifier+="-notypes";
		} else if (type.getName() != null) {
			identifier += "-" + type.getName();
		} else {
			identifier += "-" + EMV2Util.getPrintName(type);
		}
		identifier = identifier.replaceAll("\\{", "").replaceAll("\\}", "").toLowerCase();
		return identifier;
	}

	public static String buildName(ComponentInstance component, NamedElement namedElement, ErrorTypes type) {
		return buildIdentifier(component, namedElement, type);
	}

	public static String buildIdentifier(ComponentInstance component, NamedElement namedElement, ErrorTypes type) {
		String identifier;

		identifier = component instanceof SystemInstance
				? component.getComponentClassifier().getQualifiedName().replaceAll("::", "_").replaceAll("\\.", "_")
						: component.getComponentInstancePath();
				identifier += "-";

				if (namedElement == null) {
					identifier += "unidentified";

				} else {
					identifier += EMV2Util.getPrintName(namedElement);
				}

				if (type == null) {
//			identifier+="-notypes";
				} else if (type.getName() != null) {
					identifier += "-" + type.getName();
				} else {
					identifier += "-" + EMV2Util.getPrintName(type);
				}
				identifier = identifier.replaceAll("\\{", "").replaceAll("\\}", "").toLowerCase();
				return identifier;
	}

	private static void redoCount(FaultTree ftaModel) {
		for (Event ev : ftaModel.getEvents()) {
			ev.setReferenceCount(0);
		}
		doCount(ftaModel.getRoot());
	}

	private static void doCount(Event ev) {
		ev.setReferenceCount(ev.getReferenceCount() + 1);
		for (Event subev : ev.getSubEvents()) {
			doCount(subev);
		}
	}

	public static void removeEventOrphans(FaultTree ftaModel) {
		redoCount(ftaModel);
		List<Event> toRemove = new LinkedList<Event>();
		for (Event ev : ftaModel.getEvents()) {
			if (ev.getReferenceCount() == 0) {
				toRemove.add(ev);
			}
		}
		ftaModel.getEvents().removeAll(toRemove);
	}

	public static boolean hasSharedEvents(FaultTree ftaModel) {
		for (Event ev : ftaModel.getEvents()) {
			if (ev.getReferenceCount() > 1) {
				return true;
			}
		}
		return false;
	}

	/**
	 * create a BASIC event with the specified component, error model element, and type name
	 * @param component
	 * @param namedElement
	 * @param type
	 * @return Event
	 */
	public static Event createBasicEvent(FaultTree ftaModel, ComponentInstance component, NamedElement namedElement,
			ErrorTypes type) {
		String name = buildName(component, namedElement, type);
		Event result = findEvent(ftaModel, name);
		if (result != null) {
			return result;
		}
		Event newEvent = FaultTreeFactory.eINSTANCE.createEvent();
		ftaModel.getEvents().add(newEvent);
		newEvent.setName(name);
		newEvent.setType(EventType.BASIC);
		newEvent.setRelatedInstanceObject(component);
		newEvent.setRelatedEMV2Object(namedElement);
		newEvent.setRelatedErrorType(type);
		return newEvent;
	}

	public static void addBasicEvent(Event parent, ComponentInstance component, NamedElement namedElement,
			ErrorTypes type) {
		Event newEvent = createBasicEvent((FaultTree) parent.eContainer(), component, namedElement, type);
		parent.getSubEvents().add(newEvent);
	}

	public static Event createBasicEvent(FaultTree ftaModel, ConnectionInstance conni, NamedElement namedElement,
			ErrorTypes type) {
		String name = buildName(conni, namedElement, type);
		Event result = findEvent(ftaModel, name);
		if (result != null) {
			return result;
		}
		Event newEvent = FaultTreeFactory.eINSTANCE.createEvent();
		ftaModel.getEvents().add(newEvent);
		newEvent.setName(name);
		newEvent.setType(EventType.BASIC);
		newEvent.setRelatedInstanceObject(conni);
		newEvent.setRelatedEMV2Object(namedElement);
		newEvent.setRelatedErrorType(type);
		return newEvent;
	}

	public static void addBasicEvent(Event parent, ConnectionInstance conni, NamedElement namedElement,
			ErrorTypes type) {
		Event newEvent = createBasicEvent((FaultTree) parent.eContainer(), conni, namedElement, type);
		parent.getSubEvents().add(newEvent);
	}

	/**
	 * create a INTERMEDIATE event with the specified component, error model element, and type name
	 * @param component
	 * @param namedElement
	 * @param type
	 * @return Event
	 */
	public static Event createIntermediateEvent(FaultTree ftaModel, ComponentInstance component, EObject element,
			ErrorTypes type) {
		return createIntermediateEvent(ftaModel, component, element, type, false);
	}

	public static void addIntermediateEvent(Event parent, ComponentInstance component, Element element,
			ErrorTypes type) {
		parent.getSubEvents()
		.add(createIntermediateEvent((FaultTree) parent.eContainer(), component, element, type, false));
	}

	public static Event createUniqueIntermediateEvent(FaultTree ftaModel, ComponentInstance component, EObject element,
			ErrorTypes type) {
		return createIntermediateEvent(ftaModel, component, element, type, true);
	}

	public static void addUniqueIntermediateEvent(Event parent, ComponentInstance component, Element element,
			ErrorTypes type) {
		parent.getSubEvents()
		.add(createUniqueIntermediateEvent((FaultTree) parent.eContainer(), component, element, type));
	}

	/**
	 * create a generic intermediate Event
	 * @return
	 */
	private static int count = 1;

	public static void resetIntermediateEventCount() {
		count = 0;
	}

	private static Event createIntermediateEvent(FaultTree ftaModel, ComponentInstance component, EObject element,
			ErrorTypes type,
			boolean unique) {
		String name;
		if (element instanceof NamedElement && !unique) {
			name = buildName(component, (NamedElement) element, type);
			Event result = findEvent(ftaModel, name);
			if (result != null) {
				return result;
			}
		} else {
			name = "Intermediate" + count++;
		}
		Event newEvent = FaultTreeFactory.eINSTANCE.createEvent();
		ftaModel.getEvents().add(newEvent);
		newEvent.setName(name);
		newEvent.setType(EventType.INTERMEDIATE);
		newEvent.setRelatedInstanceObject(component);
		newEvent.setRelatedEMV2Object(element);
		newEvent.setRelatedErrorType(type);
		return newEvent;
	}

	private static Event findEvent(FaultTree ftaModel, String eventName) {
		for (Event event : ftaModel.getEvents()) {
			if (event.getName().equalsIgnoreCase(eventName)) {
				return event;
			}
		}
		return null;
	}

	public static Event findSharedSubtree(FaultTree ftaModel, List<EObject> subEvents, LogicOperation type) {
		for (Event event : ftaModel.getEvents()) {
			if (!event.getSubEvents().isEmpty() && event.getSubEventLogic() == type
					&& event.getSubEvents().size() == subEvents.size() && subEvents.containsAll(event.getSubEvents())) {
				return event;
			}
		}
		return null;
	}

	public static List<Event> copy(FaultTree ftaModel, List<Event> alts) {
		LinkedList<Event> altscopy = new LinkedList<Event>();
		for (Event alt : alts) {
			Event newalt = EcoreUtil.copy(alt);
			altscopy.add(newalt);
			ftaModel.getEvents().add(newalt);
		}
		return altscopy;
	}

	public static boolean sameEvent(Event e1, Event e2) {
		return e1.getName().equalsIgnoreCase(e2.getName());
	}

	/**
	 * Fill an Event with all the properties from the AADL model. Likely, all the related
	 * values in the Hazard property from EMV2.
	 *
	 * @param event					- the event related to the EMV2 artifact
	 * @param component             - the component from the event
	 * @param errorModelArtifact    - the EMV2 artifact (error event, error propagation, etc)
	 * @param type               - the type set (null if none)
	 */

	public static void fillProperties(Event event, InstanceObject io, NamedElement ne, ErrorTypes type, double scale) {
		if (io instanceof ComponentInstance) {
			event.setDescription(getDescription(event, (ComponentInstance) io, ne, type));
		} else {
			String hazardDescription = EMV2Properties.getHazardDescription(ne, io);
			event.setDescription("Connection " + ((ErrorSource) ne).getSourceModelElement().getName() + " Hazard "
					+ hazardDescription);
		}

		event.setProbability(EMV2Properties.getProbability(io, ne, type) * scale);
	}

	public static void fillProperties(Event event, ComponentInstance component, NamedElement errorModelArtifact,
			ErrorTypes type) {
		fillProperties(event, component, errorModelArtifact, type, 1);
	}

	public static void fillProperties(Event event, ComponentInstance component, ErrorSource ces,
			ErrorTypes type) {
		fillProperties(event, component, ces, type, 1);
	}

	public static void fillProperties(Event event, ConnectionInstance conni, NamedElement ces, ErrorTypes type) {
		fillProperties(event, conni, ces, type, 1);
	}

	public static String getName(ComponentInstance component) {
		return (component instanceof SystemInstance ? component.getComponentClassifier().getName()
				: component.getComponentInstancePath());
	}

	public static String getDescription(Event event, ComponentInstance component, NamedElement errorModelArtifact,
			ErrorTypes type) {
		String description;
		description = "";
		if (errorModelArtifact instanceof ErrorSource) {
			ErrorSource errorSource = (ErrorSource) errorModelArtifact;
			description += "Component '" + getName(component) + "'";
			if (errorSource.getFailureModeType() != null) {
				description += " failure source '" + EMV2Util.getName(errorSource.getFailureModeType()) + "'";
			} else if (errorSource.getFailureModeReference() != null) {
				description += " failure mode '" + errorSource.getFailureModeReference().getName() + "'";
			}
			if (errorSource.getFailureModeDescription() != null) {
				description += " failure '" + errorSource.getFailureModeDescription() + "'";
			}
			if (type != null) {
				if (errorSource.getFailureModeType() == null && errorSource.getFailureModeReference() == null
						&& errorSource.getFailureModeDescription() == null) {
					description += " failure source '" + EMV2Util.getName(type) + "'";
				} else {
					description += " propagates '" + EMV2Util.getName(type) + "'";
				}
			}
//			if ((errorSource.getOutgoing() != null && errorSource.getOutgoing().getFeatureorPPRef() != null)
//					&& (errorSource.getOutgoing().getFeatureorPPRef().getFeatureorPP() != null)) {
//				NamedElement el = errorSource.getOutgoing().getFeatureorPPRef().getFeatureorPP();
//				description += " via '";
//				description += el.getName() + "'";
//			}

		}

		if (errorModelArtifact instanceof ErrorEvent) {
			description += "Component '" + getName(component) + "' failure event '"
					+ EMV2Util.getName(errorModelArtifact) + "'";
			if (type != null) {
				description += " type '" + EMV2Util.getName(type) + "'";
			}
		}

		if (errorModelArtifact instanceof ErrorBehaviorState) {
			description = "Component '" + getName(component) + "' in failure mode '" + errorModelArtifact.getName()
			+ "'";
			if (type != null) {
				description += " type '" + EMV2Util.getName(type) + "'";
			}
		}

		if (errorModelArtifact instanceof ErrorPropagation) {
			ErrorPropagation ep = (ErrorPropagation) errorModelArtifact;
			String boundaryLabel = null;
			String epname = EMV2Util.getPrintName(ep);
			if (event.getType() == EventType.EXTERNAL) {
				boundaryLabel = "external ";
			} else if (event.getType() == EventType.UNDEVELOPED) {
				boundaryLabel = "undeveloped ";
			}
			String directionLabel = ep.getDirection() == DirectionType.IN ? "incoming " : "outgoing ";
			description = "Component '" + getName(component) + "' with " + directionLabel;
			if (type != null) {
				description += " failure '" + EMV2Util.getName(type)
				+ (boundaryLabel == null ? "" : ("' from " + boundaryLabel + "'" + epname + "'"));
			}
		}

		return description;
	}

	/**
	 * For leaf event it returns the probability stored with the event.
	 * For non-leaf events (events with a gate) it recursively calculates the probability from subevents.
	 * @param event
	 * @return double probability
	 */
	public static double getProbability(Event event) {
		double result;

		if (!event.getSubEvents().isEmpty()) {
			switch (event.getSubEventLogic()) {
			case AND: {
				result = 1;
				for (Event subEvent : event.getSubEvents()) {
					result = result * getProbability(subEvent);
				}
				break;
			}
			case PRIORITY_AND: {
				// TODO need to adjust for ordered events
				result = 1;
				for (Event subEvent : event.getSubEvents()) {
					result = result * getProbability(subEvent);
				}
				break;
			}
			case XOR: {
				double inverseProb = 1;
				for (Event subEvent : event.getSubEvents()) {
					inverseProb *= (1 - getProbability(subEvent));
				}
				result = 1 - inverseProb;
				break;
			}
			case OR: {
				result = 0;
				for (Event subEvent : event.getSubEvents()) {
					result = result + getProbability(subEvent);
				}
				break;
			}
			default: {
				System.out.println("[Utils] Unsupported for now");
				result = 1;
				break;
			}
			}

		} else {
			result = event.getProbability();
		}
		return result;
	}

	/**
	 * return sum of probabilities of direct subevents.
	 * @param event
	 * @return double
	 */
	public static double getSubeventProbabilities(Event event) {
		double result;

		if (!event.getSubEvents().isEmpty()) {
			switch (event.getSubEventLogic()) {
			case AND: {
				result = 1;
				for (Event subEvent : event.getSubEvents()) {
					result = result * subEvent.getProbability();
				}
				break;
			}
			case PRIORITY_AND: {
				// TODO need to adjust for ordered events
				result = 1;
				for (Event subEvent : event.getSubEvents()) {
					result = result * subEvent.getProbability();
				}
				break;
			}
			case XOR: {
				double inverseProb = 1;
				for (Event subEvent : event.getSubEvents()) {
					inverseProb *= (1 - subEvent.getProbability());
				}
				result = 1 - inverseProb;
				break;
			}
			case OR: {
				result = 0;
				for (Event subEvent : event.getSubEvents()) {
					result = result + subEvent.getProbability();
				}
				break;
			}
			default: {
				System.out.println("[Utils] Unsupported for now");
				result = 1;
				break;
			}
			}
			System.out.println("[Utils] Probability for " + event.getName() + ":" + result);

		} else {
			result = event.getProbability();
		}
		return result;
	}

	public static void performUpdate(Event event) {
		if (!event.getSubEvents().isEmpty()) {
			double probability;
			// TODO change the order. First, recurse

			for (Event e : event.getSubEvents()) {
				performUpdate(e);
			}
			probability = getSubeventProbabilities(event);
			event.setProbability(probability);
		}
	}

}
