package org.osate.aadl2.errormodel.FaultTree.util;

import org.osate.aadl2.NamedElement;
import org.osate.aadl2.errormodel.FaultTree.Event;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.xtext.aadl2.errormodel.errorModel.ConnectionErrorSource;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorSource;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypes;
import org.osate.xtext.aadl2.errormodel.util.EMV2Properties;
import org.osate.xtext.aadl2.errormodel.util.EMV2Util;

public class FaultTreeUtils {

	/**
	 * Fill an Event with all the properties from the AADL model. Likely, all the related
	 * values in the Hazard property from EMV2.
	 *
	 * @param event					- the event related to the EMV2 artifact
	 * @param component             - the component from the event
	 * @param errorModelArtifact    - the EMV2 artifact (error event, error propagation, etc)
	 * @param type               - the type set (null if none)
	 */
	public static void fillProperties(Event event, ComponentInstance component, NamedElement errorModelArtifact,
			ErrorTypes type, double scale) {
		String propertyDescription;
		propertyDescription = EMV2Properties.getDescription(errorModelArtifact, component);

		if (propertyDescription == null) {
			event.setDescription(getDescription(component, errorModelArtifact, type));
		} else {
			event.setDescription(propertyDescription + "(component " + component.getName() + ")");
		}

		event.setProbability(EMV2Properties.getProbability(component, errorModelArtifact, type) * scale);
	}

	public static void fillProperties(Event event, ComponentInstance component, NamedElement errorModelArtifact,
			ErrorTypes type) {
		fillProperties(event, component, errorModelArtifact, type, 1);
	}

	public static void fillProperties(Event event, ComponentInstance component, ConnectionErrorSource ces,
			ErrorTypes type, double scale) {
		String propertyDescription;
		propertyDescription = EMV2Properties.getDescription(ces, component);

		if (propertyDescription == null) {
			event.setDescription(getDescription(component, ces, type));
		} else {
			event.setDescription(propertyDescription + "(connection " + ces.getConnection().getName() + ")");
		}

		event.setProbability(EMV2Properties.getProbability(component, ces, type) * scale);
	}

	public static void fillProperties(Event event, ComponentInstance component, ConnectionErrorSource ces,
			ErrorTypes type) {
		fillProperties(event, component, ces, type, 1);
	}

	public static String getDescription(ComponentInstance component, NamedElement errorModelArtifact, ErrorTypes type) {
		String description;
		description = "";

		if (errorModelArtifact instanceof ErrorSource) {
			ErrorSource errorSource = (ErrorSource) errorModelArtifact;

			description += "Error source";

			if (errorSource.getName() != null) {
				description += " " + errorSource.getName();
			}
			description += " on component " + (component instanceof SystemInstance ? component.getName()
					: component.getComponentInstancePath());

			if ((errorSource.getOutgoing().getFeatureorPPRef() != null)
					&& (errorSource.getOutgoing().getFeatureorPPRef().getFeatureorPP() != null)) {
				NamedElement el = errorSource.getOutgoing().getFeatureorPPRef().getFeatureorPP();
				description += " from ";
				description += el.getName();
			}
			if (type != null) {
				description += " with types " + EMV2Util.getPrintName(type);
			}

		}

		if (errorModelArtifact instanceof ErrorEvent) {
			ErrorEvent errorEvent = (ErrorEvent) errorModelArtifact;
			description += "Error";
			description += " event " + errorEvent.getName();
			if (type != null) {
				description += " with types " + EMV2Util.getPrintName(type);
			}
			description += " on component " + component.getName();

		}

		if (errorModelArtifact instanceof ErrorBehaviorState) {
			ErrorBehaviorState ebs = (ErrorBehaviorState) errorModelArtifact;
			description = "component " + component.getName() + " in state " + ebs.getName();
		}

		if (errorModelArtifact instanceof ErrorPropagation) {
			ErrorPropagation ep = (ErrorPropagation) errorModelArtifact;
			description = "component " + component.getName() + " with " + ep.getDirection() + " propagation "
					+ EMV2Util.getPropagationName(ep);
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
