/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
 * All Rights Reserved.
 * 
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 * 
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
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
		return " " + FaultTreeUtils.getCutsetLabel(context);
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
		return FaultTreeUtils.isASharedEvent((Event) context) ? "yes" : "no";
	}

	public String getHazardDescription(EObject context) {
		return FaultTreeUtils.getHazardDescription(context);
	}

	public String getProbability(EObject context) {
		return FaultTreeUtils.getProbability(context);
	}

	public String getAssignedProbability(EObject context) {
		return FaultTreeUtils.getAssignedProbability(context);
	}

	public String getComputedProbability(EObject context) {
		return FaultTreeUtils.getComputedProbability(context);
	}

}
