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

	public String getDescriptionAndProbability(EObject context) {
		return FaultTreeUtils.getDescriptionAndProbability(context);
	}

	public String getDescription(EObject context) {
		return FaultTreeUtils.getDescription((Event) context);
	}

	public String getCutsetLabel(EObject context) {
		Event event = (Event) context;
		FaultTree ft = (FaultTree) event.eContainer();
		if (ft.getRoot().getSubEvents().contains(event)) {
			return " " + event.getName();
		}
		return " " + FaultTreeUtils.getDescription((Event) context);
	}

	public String getEventDescription(EObject context) {
		return " " + FaultTreeUtils.getEventDescription((Event) context);
	}

	public String getErrorDescription(EObject context) {
		return FaultTreeUtils.getErrorDescription((Event) context);
	}

	public String getHazardDescriptionAndProbability(EObject context) {
		return FaultTreeUtils.getHazardDescriptionAndProbability(context);
	}

	public String getEventTypeLogic(EObject context) {
		Event ev = (Event) context;
		if (ev.getType() == EventType.INTERMEDIATE && ev.getSubEvents().size() > 1) {
			return ev.getSubEventLogic().getName() + " gate";
		}
		return ev.getType().getName() + " event";
	}

	public String getGateLogic(EObject context) {
		Event ev = (Event) context;
		if (ev.getType() == EventType.INTERMEDIATE && ev.getSubEvents().size() > 1) {
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
		return FaultTreeUtils.getProbability(context);
	}

}
