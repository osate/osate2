package org.osate.aadl2.errormodel.faulttree.design;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.errormodel.FaultTree.Event;
import org.osate.aadl2.errormodel.FaultTree.FaultTree;

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

	public String ProbabilityToString(EObject context) {
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

}
