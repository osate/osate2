package org.osate.aadl2.errormodel.faulttree.design;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.errormodel.FaultTree.Event;
import org.osate.aadl2.errormodel.FaultTree.EventType;
import org.osate.aadl2.errormodel.FaultTree.FaultTree;
import org.osate.aadl2.errormodel.FaultTree.util.FaultTreeUtils;

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

	public int getWidth(EObject context) {
		Event ev = (Event) context;
		String labeltext = FaultTreeUtils.getInstanceDescription(ev);
		String emv2label = FaultTreeUtils.getEMV2ElementDescription(ev);
		if (labeltext.length() > emv2label.length()) {
			return labeltext.length() / 2 + 4;
		}
		return emv2label.length() / 2 + 4;
	}

	public String getDescriptionAndProbability(EObject context) {
		return FaultTreeUtils.getDescriptionAndProbability(context);
	}

	public String getDescription(EObject context) {
		return FaultTreeUtils.getDescription((Event) context);
	}

	public String getHazardDescriptionAndProbability(EObject context) {
		return FaultTreeUtils.getHazardDescriptionAndProbability(context);
	}

	public String getEventTypeLogic(EObject context) {
		Event ev = (Event) context;
		if (ev.getType() == EventType.INTERMEDIATE) {
			return ev.getSubEventLogic().getName() + " gate";
		}
		return ev.getType().getName() + " event";
	}

	public String getGateLogic(EObject context) {
		Event ev = (Event) context;
		if (ev.getType() == EventType.INTERMEDIATE) {
			return ev.getSubEventLogic().getName();
		}
		return "";
	}

	public String getDependentEventLabel(EObject context) {
		return ((Event) context).isSharedEvent() ? "yes" : "no";
	}

	public String getHazardDescription(EObject context) {
		return FaultTreeUtils.getHazardDescription(context);
	}

	public String getProbability(EObject context) {
		Event ev = (Event) context;
		return String.format("%1$.3E", ev.getProbability());
	}

}
