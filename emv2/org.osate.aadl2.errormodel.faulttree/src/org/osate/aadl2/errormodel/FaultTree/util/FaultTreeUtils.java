package org.osate.aadl2.errormodel.FaultTree.util;

import org.osate.aadl2.NamedElement;
import org.osate.aadl2.errormodel.FaultTree.Event;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.InstanceObject;
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

	public static void fillProperties(Event event, InstanceObject io, NamedElement ne, ErrorTypes type, double scale) {
		if (io instanceof ComponentInstance) {
			event.setDescription(getDescription((ComponentInstance) io, ne, type));
		} else {
			String hazardDescription = EMV2Properties.getHazardDescription(ne, io);
			event.setDescription("Connection " + ((ConnectionErrorSource) ne).getConnection().getName() + " Hazard "
					+ hazardDescription);
		}

		event.setProbability(EMV2Properties.getProbability(io, ne, type) * scale);
	}

	public static void fillProperties(Event event, ComponentInstance component, NamedElement errorModelArtifact,
			ErrorTypes type) {
		fillProperties(event, component, errorModelArtifact, type, 1);
	}

	public static void fillProperties(Event event, ComponentInstance component, ConnectionErrorSource ces,
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

	public static String getDescription(ComponentInstance component, NamedElement errorModelArtifact, ErrorTypes type) {
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
			description += "Component '" + getName(component) + "'";
			if (type != null) {
				description += " failure event '" + EMV2Util.getName(type) + "'";
			}
		}

		if (errorModelArtifact instanceof ErrorBehaviorState) {
			ErrorBehaviorState ebs = (ErrorBehaviorState) errorModelArtifact;
			description = "Component '" + getName(component) + "' in failure mode '" + ebs.getName() + "'";
			if (type != null) {
				description += " type '" + EMV2Util.getName(type) + "'";
			}
		}

		if (errorModelArtifact instanceof ErrorPropagation) {
			ErrorPropagation ep = (ErrorPropagation) errorModelArtifact;
			String boundaryLabel = "";
			if (component instanceof SystemInstance) {
				boundaryLabel = " external ";
			} else {
				boundaryLabel = " undeveloped ";
			}
			description = "Component '" + getName(component) + "' with " + boundaryLabel + ep.getDirection();
			if (type != null) {
				description += " failure '" + EMV2Util.getName(type) + "'";
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
