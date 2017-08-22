package org.osate.aadl2.errormodel.faulttree.design;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.errormodel.FaultTree.Event;
import org.osate.aadl2.errormodel.FaultTree.FaultTree;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypes;
import org.osate.xtext.aadl2.errormodel.util.EMV2Properties;

public class Services {

	public Collection<Event> getEvents(EObject context) {
		Collection<Event> eventsToReturn = new ArrayList<Event>();
		if (context instanceof FaultTree) {
			eventsToReturn.add(((FaultTree) context).getRoot());
		} else if (context instanceof Event) {
			return ((Event) context).getSubEvents();
		}
		return eventsToReturn;
	}

	public Collection<Event> getCutsets(EObject context) {
		Collection<Event> eventsToReturn = new ArrayList<Event>();
		if (context instanceof FaultTree) {
			eventsToReturn.add(((FaultTree) context).getRoot());
		} else if (context instanceof Event) {
			return ((Event) context).getSubEvents();
		}
		return eventsToReturn;
	}

	public String getDescriptionAndProbability(EObject context) {
		if (context instanceof Event) {
			double val = ((Event) context).getProbability();
			String labeltext = ((Event) context).getDescription();
			if (labeltext == null || labeltext.isEmpty()) {
				labeltext = ((Event) context).getName();
			}
			return String.format("%1$s\n(%2$.3E)", labeltext, val);
		}
		return "";
	}

	public String getHazardDescriptionAndProbability(EObject context) {
		if (context instanceof Event) {
			Event ev = (Event) context;
			double val = ev.getProbability();
			String hazardDescription = EMV2Properties.getHazardDescription(
					(InstanceObject) ev.getRelatedInstanceObject(), (NamedElement) ev.getRelatedEMV2Object(),
					(ErrorTypes) ev.getRelatedErrorType());
			String labeltext = ((Event) context).getDescription();
			if (labeltext == null || labeltext.isEmpty()) {
				labeltext = ((Event) context).getName();
			}
			if (hazardDescription == null) {
				return String.format("%1$s\nOccurrence probability %2$.3E", labeltext, val);
			} else {
				return String.format("%1$s\n%3$s\nOccurrence probability %2$.3E", labeltext, val,
						"Hazard: " + hazardDescription);
			}
		}
		return "";
	}

}
