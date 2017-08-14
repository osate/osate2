package org.osate.aadl2.errormodel.faulttree.design;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.errormodel.FaultTree.Event;
import org.osate.aadl2.errormodel.FaultTree.FaultTree;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypes;
import org.osate.xtext.aadl2.errormodel.util.EMV2Properties;

public class Services {

	public EList<Event> getEvents(EObject context) {
		EList<Event> eventsToReturn = new BasicEList<Event>();
		if (context instanceof FaultTree) {
			eventsToReturn.add(((FaultTree) context).getRoot());
		} else if (context instanceof Event) {
			eventsToReturn.addAll(((Event) context).getSubEvents());
		}
		return eventsToReturn;
	}

	public EList<Event> getCutsets(EObject context) {
		EList<Event> eventsToReturn = new BasicEList<Event>();
		if (context instanceof FaultTree) {
			eventsToReturn.add(((FaultTree) context).getRoot());
		} else if (context instanceof Event) {
			eventsToReturn.addAll(((Event) context).getSubEvents());
		}
		return eventsToReturn;
	}

	public EList<EObject> getChildren(EObject context) {
		EList<EObject> childrenToReturn = new BasicEList<EObject>();
		if (context instanceof FaultTree) {
			childrenToReturn.add(((FaultTree) context).getRoot());
		} else if (context instanceof Event) {
			childrenToReturn.addAll(((Event) context).getSubEvents());
		}
		return childrenToReturn;
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
