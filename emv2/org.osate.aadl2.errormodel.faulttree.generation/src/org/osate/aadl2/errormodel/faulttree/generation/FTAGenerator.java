/**
 * Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.aadl2.errormodel.faulttree.generation;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.Element;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.errormodel.FaultTree.Event;
import org.osate.aadl2.errormodel.FaultTree.EventType;
import org.osate.aadl2.errormodel.FaultTree.FaultTree;
import org.osate.aadl2.errormodel.FaultTree.FaultTreeFactory;
import org.osate.aadl2.errormodel.FaultTree.FaultTreeType;
import org.osate.aadl2.errormodel.FaultTree.LogicOperation;
import org.osate.aadl2.errormodel.FaultTree.util.FaultTreeUtils;
import org.osate.aadl2.errormodel.PropagationGraph.PropagationGraph;
import org.osate.aadl2.errormodel.PropagationGraph.util.PropagationGraphBackwardTraversal;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorSource;
import org.osate.xtext.aadl2.errormodel.errorModel.OrmoreExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.OutgoingPropagationCondition;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeToken;

public class FTAGenerator extends PropagationGraphBackwardTraversal {
	private FaultTree ftaModel;

	public FTAGenerator(PropagationGraph currentPropagationGraph) {
		super(currentPropagationGraph);
		ftaModel = null;
		FaultTreeUtils.resetIntermediateEventCount();
	}

	public FaultTree getftaModel(ComponentInstance rootComponent, NamedElement rootStateOrPropagation,
			TypeToken rootComponentType, FaultTreeType faultTreeType) {
		if (ftaModel == null) {
			Event ftaRootEvent = null;
			String errorMsg = "";
			ftaModel = FaultTreeFactory.eINSTANCE.createFaultTree();
			ftaModel.setName(FaultTreeUtils.buildName(rootComponent, rootStateOrPropagation, rootComponentType));
			ftaModel.setInstanceRoot(rootComponent);
			ftaModel.setFaultTreeType(faultTreeType);

			if (rootStateOrPropagation instanceof ErrorBehaviorState) {
				if (faultTreeType.equals(FaultTreeType.COMPOSITE_PARTS)) {
					ftaRootEvent = (Event) traverseCompositeErrorStateOnly(rootComponent,
							(ErrorBehaviorState) rootStateOrPropagation, rootComponentType, BigOne);

				} else {
					ftaRootEvent = (Event) traverseCompositeErrorState(rootComponent,
							(ErrorBehaviorState) rootStateOrPropagation, rootComponentType, BigOne);
				}
			} else {
				if (faultTreeType.equals(FaultTreeType.COMPOSITE_PARTS)) {
					errorMsg = "Select error state for composite parts fault tree";
					ftaRootEvent = FaultTreeUtils.createIntermediateEvent(ftaModel, rootComponent,
							rootStateOrPropagation, rootComponentType);
					ftaModel.setMessage(errorMsg);
					ftaModel.setRoot(ftaRootEvent);
					return ftaModel;
				} else {
					ftaRootEvent = (Event) traverseOutgoingErrorPropagation(rootComponent,
							(ErrorPropagation) rootStateOrPropagation, rootComponentType, BigOne);
				}
			}
			if (ftaRootEvent == null) {
				ftaRootEvent = FaultTreeUtils.createIntermediateEvent(ftaModel, rootComponent, rootStateOrPropagation,
						rootComponentType);
			}
			String longName = FaultTreeUtils.buildName(rootComponent, rootStateOrPropagation, rootComponentType);
			if (ftaRootEvent.getSubEvents().isEmpty() && !ftaRootEvent.getName().equals(longName)) {
				Event topEvent = FaultTreeUtils.createIntermediateEvent(ftaModel, rootComponent, rootStateOrPropagation,
						rootComponentType);
				topEvent.getSubEvents().add(ftaRootEvent);
				ftaRootEvent = topEvent;
			}
			if (!faultTreeType.equals(FaultTreeType.FAULT_TRACE)
					&& !faultTreeType.equals(FaultTreeType.COMPOSITE_PARTS)) {
				flattenGates(ftaRootEvent);
				cleanupXORGates(ftaRootEvent);
//			xformXORtoOR(emftaRootEvent);
				if (faultTreeType.equals(FaultTreeType.FAULT_TREE)) {
					flattenGates(ftaRootEvent);
					ftaRootEvent = optimizeGates(ftaRootEvent);
					flattenGates(ftaRootEvent);
				}
				// remove gate with single event from root
				if (ftaRootEvent.getSubEvents().size() == 1) {
					Event subevent = ftaRootEvent.getSubEvents().get(0);
					if (subevent.getType() == EventType.INTERMEDIATE) {
						subevent.setName(ftaRootEvent.getName());
						subevent.setMessage(ftaRootEvent.getMessage());
						subevent.setRelatedInstanceObject(ftaRootEvent.getRelatedInstanceObject());
						subevent.setRelatedErrorType(ftaRootEvent.getRelatedErrorType());
						subevent.setRelatedEMV2Object(ftaRootEvent.getRelatedEMV2Object());
						ftaRootEvent = subevent;
					}
				}
				if (faultTreeType.equals(FaultTreeType.MINIMAL_CUT_SET)) {
					ftaRootEvent = minimalCutSet(ftaRootEvent);
				}
			}
			ftaRootEvent.setName(longName);
			ftaModel.setRoot(ftaRootEvent);
			FaultTreeUtils.removeEventOrphans(ftaModel);
			FaultTreeUtils.fillProbabilities(ftaModel);
			FaultTreeUtils.computeProbabilities(ftaModel.getRoot());
		}
		return ftaModel;
	}

	/**
	 * turn list of subevents into an specified gate.
	 * In the process flatten any sub gates of the same type (one level is sufficient since we flatten at each step
	 * @param subEvents List<Event>
	 * @return Event (or null if empty list)
	 */
	private Event finalizeAsXOrEvents(ComponentInstance component, Element el, TypeToken type,
			List<EObject> subEvents) {
		if (subEvents.size() == 0) {
			return null;
		}
		Event combined = FaultTreeUtils.findSharedSubtree(ftaModel, subEvents, LogicOperation.XOR, component, el, type);
		if (combined != null) {
			return combined;
		}
		combined = FaultTreeUtils.createIntermediateEvent(ftaModel, component, el, type);
		combined.setSubEventLogic(LogicOperation.XOR);
		for (Object seobj : subEvents) {
			Event se = (Event) seobj;
			combined.getSubEvents().add(se);
		}
		return combined;

	}

	private Event finalizeAsOrEvents(ComponentInstance component, Element ne, TypeToken type,
			List<EObject> subEvents) {
		if (subEvents.size() == 0) {
			return null;
		}
		Event combined = FaultTreeUtils.findSharedSubtree(ftaModel, subEvents, LogicOperation.OR, component, ne, type);
		if (combined != null) {
			return combined;
		}
		combined = FaultTreeUtils.createIntermediateEvent(ftaModel, component, ne, type);
		combined.setSubEventLogic(LogicOperation.OR);

		for (Object seobj : subEvents) {
			combined.getSubEvents().add((Event) seobj);
		}
		return combined;
	}

	private Event finalizeAsUniqueOrEvents(ComponentInstance component, Element ne, TypeToken type,
			List<EObject> subEvents) {
		if (subEvents.size() == 0) {
			return null;
		}
		Event combined = FaultTreeUtils.createUniqueIntermediateEvent(ftaModel, component, ne, type);
		combined.setSubEventLogic(LogicOperation.OR);

		for (Object seobj : subEvents) {
			combined.getSubEvents().add((Event) seobj);
		}
		return combined;
	}

	private Event finalizeAsOrMoreEvents(ComponentInstance component, Element ne, TypeToken type,
			List<EObject> subEvents) {
		if (subEvents.size() == 0) {
			return null;
		}
		Event combined = FaultTreeUtils.findSharedSubtree(ftaModel, subEvents, LogicOperation.KORMORE, component, ne,
				type);
		if (combined != null) {
			return combined;
		}

		combined = FaultTreeUtils.createIntermediateEvent(ftaModel, component, ne, type);
		combined.setSubEventLogic(LogicOperation.KORMORE);

		// Propagate the K value from the original element
		OrmoreExpression omCondition = (OrmoreExpression) ne;
		combined.setK((int) omCondition.getCount()); // XXX this cast indicates discrepancy between two meta models

		for (Object seobj : subEvents) {
			combined.getSubEvents().add((Event) seobj);
		}
		return combined;
	}

	private Event finalizeAsAndEvents(ComponentInstance component, Element ne, TypeToken type,
			List<EObject> subEvents) {
		if (subEvents.size() == 0) {
			return null;
		}
		Event combined = FaultTreeUtils.findSharedSubtree(ftaModel, subEvents, LogicOperation.AND, component, ne, type);
		if (combined != null) {
			return combined;
		}
		combined = FaultTreeUtils.createIntermediateEvent(ftaModel, component, ne, type);
		combined.setSubEventLogic(LogicOperation.AND);

		for (Object seobj : subEvents) {
			Event se = (Event) seobj;
			combined.getSubEvents().add(se);
		}
		return combined;
	}

	private Event finalizeAsPriorityAndEvents(ComponentInstance component, Element ne, TypeToken type,
			List<EObject> subEvents, String eventname) {
		if (subEvents.size() == 0) {
			return null;
		}
		Event combined = FaultTreeUtils.findSharedSubtree(ftaModel, subEvents, LogicOperation.PRIORITY_AND, component,
				ne, type);
		if (combined != null) {
			return combined;
		}
		combined = FaultTreeUtils.createIntermediateEvent(ftaModel, component, ne, type);
		combined.setSubEventLogic(LogicOperation.PRIORITY_AND);
		for (Object seobj : subEvents) {
			Event se = (Event) seobj;
			combined.getSubEvents().add(se);
		}
		return combined;
	}

	/*************
	 * Optimizations
	 */

	/**
	 * remove subgates with a single event and place event in enclosing gate
	 * @param topgate
	 */
	private void removeZeroOneEventSubGates(Event topEvent) {
		if (topEvent.getSubEvents().isEmpty()) {
			return;
		}
		List<Event> subEvents = topEvent.getSubEvents();
		List<Event> toRemove = new LinkedList<Event>();
		List<Event> toAdd = new LinkedList<Event>();
		for (Event event : subEvents) {
			if (!event.getSubEvents().isEmpty()) {
				EList<Event> subs = event.getSubEvents();
				if (subs.size() == 1) {
					toRemove.add(event);
					toAdd.add(event.getSubEvents().get(0));
				} else if (subs.isEmpty()) {
					toRemove.add(event);
				}
			}
		}
		if (!toRemove.isEmpty()) {
			subEvents.removeAll(toRemove);
		}
		if (!toAdd.isEmpty()) {
			subEvents.addAll(toAdd);
		}
	}

	/**
	 * flatten subgates of same type into given gate
	 * @param gate
	 */
	private void flattenSubgates(Event event) {
		if (event.getSubEvents().isEmpty()) {
			return;
		}
		LogicOperation mygate = event.getSubEventLogic();
		EList<Event> subEvents = event.getSubEvents();
		List<Event> toAdd = new LinkedList<Event>();
		List<Event> toRemove = new LinkedList<Event>();
		for (Event se : subEvents) {
			if (!se.getSubEvents().isEmpty() && se.getSubEventLogic() == mygate) {
				for (Event ev : se.getSubEvents()) {
					toAdd.add(ev);
				}
				toRemove.add(se);
			}
		}
		if (!toRemove.isEmpty()) {
			subEvents.removeAll(toRemove);
		}
		if (!toAdd.isEmpty()) {
			subEvents.addAll(toAdd);
		}
	}

	/**
	 * recursively flatten gates with same subgates
	 * @param rootevent
	 * @return Event original or new root event
	 */
	private void flattenGates(Event rootevent) {
		if (rootevent.getSubEvents().isEmpty()) {
			return;
		}
		List<Event> subEvents = rootevent.getSubEvents();
		for (Event event : subEvents) {
			if (!event.getSubEvents().isEmpty()) {
				flattenGates(event);
			}
		}
		flattenSubgates(rootevent);
		removeZeroOneEventSubGates(rootevent);
		return;
	}

	/**
	 * normalize graph
	 */

	private Event minimalCutSet(Event rootevent) {
		if (rootevent.getSubEvents().isEmpty()) {
			return rootevent;
		}
		List<Event> toAdd = new LinkedList<Event>();
		// alternatives : collection of minimal cutsets
		Event alternatives = FaultTreeUtils.createUniqueIntermediateEvent(ftaModel,
				(ComponentInstance) rootevent.getRelatedInstanceObject(),
				rootevent.getRelatedEMV2Object(), (TypeToken) rootevent.getRelatedErrorType());
		alternatives.setName("Alternatives");
		if (rootevent.getSubEventLogic() == LogicOperation.XOR) {
			alternatives.setSubEventLogic(LogicOperation.XOR);
		} else {
			alternatives.setSubEventLogic(LogicOperation.OR);
		}
		if (rootevent.getSubEventLogic() == LogicOperation.OR || rootevent.getSubEventLogic() == LogicOperation.XOR
				|| rootevent.getSubEventLogic() == LogicOperation.KORMORE
				|| rootevent.getType() == EventType.INTERMEDIATE) {
			for (Event alt : rootevent.getSubEvents()) {
				// if top-level is OR, XOR, KORMORE each of the sub-events become the starting point of a cutset
				Event alternative = FaultTreeUtils.createUniqueIntermediateEvent(ftaModel,
						(ComponentInstance) rootevent.getRelatedInstanceObject(),
						rootevent.getRelatedEMV2Object(), (TypeToken) rootevent.getRelatedErrorType());
				alternative.setSubEventLogic(LogicOperation.AND);
				toAdd.add(alternative);
				// normalize each of the subevents
				normalizeEvent(alt, toAdd, alternatives);
				for (Event addMe : toAdd) {
					addAsMinimalAndSet(alternatives, addMe);
				}
				toAdd.clear();
			}
		} else if (rootevent.getSubEventLogic() == LogicOperation.AND
				|| rootevent.getSubEventLogic() == LogicOperation.PRIORITY_AND) {
			// in case of AND or P-AND we take the root as starting point
			Event alternative = FaultTreeUtils.createUniqueIntermediateEvent(ftaModel,
					(ComponentInstance) rootevent.getRelatedInstanceObject(),
					rootevent.getRelatedEMV2Object(), (TypeToken) rootevent.getRelatedErrorType());
			alternative.setSubEventLogic(LogicOperation.AND);
			toAdd.add(alternative);
			normalizeEvent(rootevent, toAdd, alternatives);
			for (Event addMe : toAdd) {
				addAsMinimalAndSet(alternatives, addMe);
			}
		}
		int cutsetcount = 1;
		for (Event alt : alternatives.getSubEvents()) {
			alt.setName("Cutset" + cutsetcount++);
		}
		return alternatives;
	}

	/**
	 * event as starting point turn everything into alternatives of ANDed events
	 * the resulting alternatives are added to the list of alternatives
	 * @param event
	 * @param alternatives
	 */
	private void normalizeEvent(Event event, List<Event> alternatives, Event existingAlternatives) {
		for (Event alternative : alternatives) {
			if (event.getScale().compareTo(FaultTreeUtils.BigOne) < 0) {
				alternative.setScale(alternative.getScale().multiply(event.getScale()));
			}
		}
		if (event.getSubEvents().isEmpty()) {
			// add the leaf event to all alternatives
			for (Event alternative : alternatives) {
				alternative.getSubEvents().add(event);
			}
			return;
		}
		if (event.getSubEventLogic() == LogicOperation.AND || event.getSubEventLogic() == LogicOperation.PRIORITY_AND) {
			// in case of AND normalize each sub-event (adding it or its normalized collection)
			for (Event subevent : event.getSubEvents()) {
				normalizeEvent(subevent, alternatives, existingAlternatives);
			}
		} else if (event.getSubEventLogic() == LogicOperation.OR || event.getSubEventLogic() == LogicOperation.XOR
				|| event.getSubEventLogic() == LogicOperation.KORMORE) {
			// alternatives could grow huge and copying them could easily lead to OOM error,
			// so by eager cleanup here we avoid exponential memory consumption
			minimizeAlternativesSize(alternatives, existingAlternatives);
			// for each sub-event of OR etc create a separate alternative
			List<Event> origalts = FaultTreeUtils.copy(ftaModel, alternatives);
			boolean first = true;
			for (Event subevent : event.getSubEvents()) {
				if (first) {
					normalizeEvent(subevent, alternatives, existingAlternatives);
					first = false;
				} else {
					List<Event> morealts = FaultTreeUtils.copy(ftaModel, origalts);
					normalizeEvent(subevent, morealts, existingAlternatives);
					alternatives.addAll(morealts);
				}
			}
		}
	}

	/**
	 * In some cases it's very likely that a lot of newly generated alternatives doesn't make sense in broader context of
	 * previously calculated alternatives as they will be minimized anyway,
	 * so it makes no sense to keep them as they will only slow down any further calculations
	 * @param alternatives - list of alternatives to cleanup
	 * @param existingAlternatives - global, previously minimized set of alternatives
	 */
	private void minimizeAlternativesSize(List<Event> alternatives, Event existingAlternatives) {
		List<Event> toRemove = new LinkedList<Event>();
		for (Event altEvent : alternatives) {
			for (Event matchEvent : existingAlternatives.getSubEvents()) {
				if (!matchEvent.getSubEvents().isEmpty() && !altEvent.getSubEvents().isEmpty()
						&& matchEvent.getSubEventLogic() == LogicOperation.AND
						&& altEvent.getSubEventLogic() == LogicOperation.AND) {
					if (altEvent.getSubEvents().containsAll(matchEvent.getSubEvents())) {
						toRemove.add(altEvent);
					}
				} else {
					if (matchEvent.getSubEvents().isEmpty() && !altEvent.getSubEvents().isEmpty()
							&& altEvent.getSubEventLogic() == LogicOperation.AND) {
						if (altEvent.getSubEvents().contains(matchEvent)) {
							toRemove.add(altEvent);
						}
					} else if (altEvent.getSubEvents().isEmpty() && matchEvent.getSubEvents().isEmpty()) {
						if (matchEvent == altEvent) {// matchEvent.equals(altEvent)) {
							toRemove.add(altEvent);
						}
					}
				}
			}
		}
		if (!toRemove.isEmpty()) {
			alternatives.removeAll(toRemove);
		}
	}

	private void addAsMinimalAndSet(Event alternatives, Event altEvent) {
		EList<Event> existingAlternatives = alternatives.getSubEvents();
		List<Event> toRemove = new LinkedList<Event>();
		for (Event matchEvent : existingAlternatives) {
			if (!matchEvent.getSubEvents().isEmpty() && !altEvent.getSubEvents().isEmpty()
					&& matchEvent.getSubEventLogic() == LogicOperation.AND
					&& altEvent.getSubEventLogic() == LogicOperation.AND) {
				if (matchEvent.getSubEvents().containsAll(altEvent.getSubEvents())) {
					toRemove.add(matchEvent);
				} else if (altEvent.getSubEvents().containsAll(matchEvent.getSubEvents())) {
					return;
				}
			} else {
				if (matchEvent.getSubEvents().isEmpty() && !altEvent.getSubEvents().isEmpty()
						&& altEvent.getSubEventLogic() == LogicOperation.AND) {
					if (altEvent.getSubEvents().contains(matchEvent)) {
						return;
					}
				} else if (altEvent.getSubEvents().isEmpty() && !matchEvent.getSubEvents().isEmpty()
						&& matchEvent.getSubEventLogic() == LogicOperation.AND) {
					if (matchEvent.getSubEvents().contains(altEvent)) {
						toRemove.add(matchEvent);
					}
				} else if (altEvent.getSubEvents().isEmpty() && matchEvent.getSubEvents().isEmpty()) {
					if (matchEvent == altEvent) {// matchEvent.equals(altEvent)) {
						return;
					}
				}
			}
		}
		if (!toRemove.isEmpty()) {
			existingAlternatives.removeAll(toRemove);
		}
		existingAlternatives.add(altEvent);
	}

	/**
	 * recursively remove common events from subgates of XOR gates
	 * @param rootevent
	 * @return Event original or new root event
	 */
	private void cleanupXORGates(Event rootevent) {
		if (rootevent.getSubEvents().isEmpty()) {
			return;
		}
		List<Event> subEvents = rootevent.getSubEvents();
		for (Event event : subEvents) {
			if (!event.getSubEvents().isEmpty()) {
				cleanupXORGates(event);
			}
		}
		if (rootevent.getSubEventLogic() == LogicOperation.XOR) {
			removeCommonEventsFromSubgates(rootevent, LogicOperation.OR);
		}
		return;
	}

	/**
	 * recursively remove common events from subgates of XOR gates
	 * @param rootevent
	 * @return Event original or new root event
	 */
	private void xformXORtoOR(Event rootevent) {
		if (rootevent.getSubEvents().isEmpty()) {
			return;
		}
		List<Event> subEvents = rootevent.getSubEvents();
		for (Event event : subEvents) {
			if (!event.getSubEvents().isEmpty()) {
				cleanupXORGates(event);
			}
		}
		if (rootevent.getSubEventLogic() == LogicOperation.XOR) {
			doXformXORtoOR(rootevent);
		}
		return;
	}

	/**
	 * recursively apply optimizations on subgates.
	 * At the end optimize gate of rootevent.
	 * This may result in a new rootevent
	 * @param rootevent
	 * @return Event original or new root event
	 */
	private Event optimizeGates(Event rootevent) {
		if (rootevent.getSubEvents().isEmpty()) {
			return rootevent;
		}
		String rootname = rootevent.getName();
		Event res = rootevent;
		List<Event> toAdd = new LinkedList<Event>();
		List<Event> toRemove = new LinkedList<Event>();
		res = optimizeEvent(res);
		// now we recurse to do bottom up transformation
		List<Event> subEvents = res.getSubEvents();
		for (Event event : subEvents) {
			if (!event.getSubEvents().isEmpty()) {
				Event tmp = optimizeGates(event);
				if (tmp != event) {
					toAdd.add(tmp);
					toRemove.add(event);
				}
			}
		}
		if (!toAdd.isEmpty()) {
			subEvents.removeAll(toRemove);
			subEvents.addAll(toAdd);
			flattenSubgates(res);
			removeZeroOneEventSubGates(res);
		}
		res = optimizeEvent(res);
		if (res.getSubEvents().size() == 1 && res.getType() != EventType.INTERMEDIATE) {
			res = res.getSubEvents().get(0);
		}
		if (!rootname.startsWith("Intermediate")) {
			res.setName(rootname);
		}
		return res;
	}

	private Event optimizeEvent(Event rootevent) {
		Event res = rootevent;
		if (res.getSubEventLogic() == LogicOperation.AND || res.getSubEventLogic() == LogicOperation.PRIORITY_AND) {
			Event tmp = transformSubgates(res, LogicOperation.OR, res.getSubEventLogic());
			if (tmp != res) {
				res = tmp;
				flattenSubgates(res);
				removeZeroOneEventSubGates(res);
			}
		}
		if (res.getSubEventLogic() == LogicOperation.AND || res.getSubEventLogic() == LogicOperation.PRIORITY_AND) {
			Event tmp = transformSubgates(res, LogicOperation.XOR, res.getSubEventLogic());
			if (tmp != res) {
				res = tmp;
				flattenSubgates(res);
				removeZeroOneEventSubGates(res);
			}
		}
		if (res.getSubEventLogic() == LogicOperation.OR || res.getSubEventLogic() == LogicOperation.XOR) {
			Event tmp = transformSubgates(res, LogicOperation.AND, res.getSubEventLogic());
			if (tmp != res) {
				res = tmp;
				flattenSubgates(res);
				removeZeroOneEventSubGates(res);
			}
		}
		if (res.getSubEventLogic() == LogicOperation.OR || res.getSubEventLogic() == LogicOperation.XOR) {
			Event tmp = transformSubgates(res, LogicOperation.PRIORITY_AND, res.getSubEventLogic());
			if (tmp != res) {
				res = tmp;
				flattenSubgates(res);
				removeZeroOneEventSubGates(res);
			}
		}
		if (res.getSubEventLogic() == LogicOperation.AND) {
			res = removeSubEventsCommonWithEnclosingEvents(res, LogicOperation.AND, LogicOperation.OR);
		}
		if (res.getSubEventLogic() == LogicOperation.OR) {
			res = removeSubEventsCommonWithEnclosingEvents(res, LogicOperation.OR, LogicOperation.AND);
		}
		if (res.getSubEventLogic() == LogicOperation.OR) {
			res = removeSubEventsCommonWithEnclosingEvents(res, LogicOperation.OR, LogicOperation.PRIORITY_AND);
		}
		flattenSubgates(res);
		removeZeroOneEventSubGates(res);
		return res;
	}

	/**
	 * find common events in subgates and move them to an enclosing gate
	 * Currently does it if all of the gates of a given type have something in common.
	 * It also does it for various subsets of events with the matching gate type.
	 * Distributive Law 3a and 3b (see NRC Fault Tree Handbook page 80).
	 * @param topevent
	 * @param gt
	 * @return Event
	 */
	private Event transformSubgates(Event topevent, LogicOperation gt, LogicOperation topgt) {
		List<Event> subEvents = topevent.getSubEvents();
		if (subEvents.isEmpty()) {
			return topevent;
		}
		if (subEvents.size() == 1) {
			return topevent;// (Event) subEvents.get(0);
		}
		Set<Event> intersection = null;
		List<Event> todo = new LinkedList<Event>();
		while (true) {
			todo.clear();
			for (Event se : subEvents) {
				if (!se.getSubEvents().isEmpty() && (se.getSubEventLogic() == gt)) {
					if (intersection == null) {
						intersection = new HashSet<Event>(se.getSubEvents());
						todo.add(se);
					} else {
						if (intersects(intersection, se.getSubEvents())) {
							intersection.retainAll(se.getSubEvents());
							todo.add(se);
						}
					}
				}
			}
			if (todo.size() > 1 && intersection != null && !intersection.isEmpty()) {
				if (subEvents.size() == todo.size()) {
					// all subgates are involved
					// remove from lower OR and create an OR above top gate
					Event newtopevent = FaultTreeUtils.createUniqueIntermediateEvent(ftaModel,
							(ComponentInstance) topevent.getRelatedInstanceObject(),
							topevent.getRelatedEMV2Object(),
							(TypeToken) topevent.getRelatedErrorType());
					newtopevent.setSubEventLogic(gt);
					newtopevent.getSubEvents().add(topevent);
					for (Event event : intersection) {
						newtopevent.getSubEvents().add(event);
					}
					for (Event se : todo) {
						EList<Event> rem = se.getSubEvents();
						rem.removeAll(intersection);
					}
					flattenSubgates(topevent);
					removeZeroOneEventSubGates(topevent);
					flattenSubgates(newtopevent);
					removeZeroOneEventSubGates(newtopevent);
					return newtopevent;
				} else {
					// transformed subtree to top gate replacing subset of events involved in transformation
					Event newtopevent = FaultTreeUtils.createIntermediateEvent(ftaModel,
							(ComponentInstance) topevent.getRelatedInstanceObject(),
							topevent.getRelatedEMV2Object(),
							(TypeToken) topevent.getRelatedErrorType());
					newtopevent.setSubEventLogic(gt);
					topevent.getSubEvents().add(newtopevent);
					// remove intersection fro subset of gates
					for (Event event : intersection) {
						newtopevent.getSubEvents().add(event);
					}
					for (Event se : todo) {
						EList<Event> rem = se.getSubEvents();
						rem.removeAll(intersection);
					}
					topevent.getSubEvents().removeAll(todo);
					flattenSubgates(newtopevent);
					removeZeroOneEventSubGates(newtopevent);
					flattenSubgates(topevent);
					removeZeroOneEventSubGates(topevent);
					return topevent;
				}
			} else {
				flattenSubgates(topevent);
				removeZeroOneEventSubGates(topevent);
				return topevent;
			}
		}
	}

	private boolean intersects(Collection<Event> list1, Collection<Event> list2) {
		for (Event event : list2) {
			if (list1.contains(event)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * find common events in subgates and remove them.
	 * This is done for an XOR gate, which should not include common events.
	 * Currently does it if all of the gates of a given type have something in common.
	 * also for various subsets of events with the matching gate type.
	 * Distributive Law 3a and 3b (se NRC Fault Tree Handbook page 80.
	 * @param topevent
	 * @param gt
	 * @return Event
	 */
	private void removeCommonEventsFromSubgates(Event topevent, LogicOperation gt) {
		List<Event> subEvents = topevent.getSubEvents();
		if (subEvents.isEmpty()) {
			return;
		}
		if (subEvents.size() == 1) {
			return;
		}
		Set<Event> intersection = null;
		List<Event> todo = new LinkedList<Event>();
		while (true) {
			todo.clear();
			for (Event se : subEvents) {
				if (!se.getSubEvents().isEmpty() && (se.getSubEventLogic() == gt)) {
					if (intersection == null) {
						intersection = new HashSet<Event>(se.getSubEvents());
						todo.add(se);
					} else {
						if (intersects(intersection, se.getSubEvents())) {
							intersection.retainAll(se.getSubEvents());
							todo.add(se);
						}
					}
				}
			}
			if (todo.size() > 1 && intersection != null && !intersection.isEmpty()) {
				if (subEvents.size() == todo.size()) {
					// all subgates are involved
					// remove from lower OR
					for (Event se : todo) {
						EList<Event> rem = se.getSubEvents();
						rem.removeAll(intersection);
					}
					flattenSubgates(topevent);
					removeZeroOneEventSubGates(topevent);
					return;
				} else {
					// remove intersection fro subset of gates
					for (Event se : todo) {
						EList<Event> rem = se.getSubEvents();
						rem.removeAll(intersection);
					}
					flattenSubgates(topevent);
					removeZeroOneEventSubGates(topevent);
				}
			} else {
				flattenSubgates(topevent);
				removeZeroOneEventSubGates(topevent);
				return;
			}
		}
	}

	/**
	 * remove shared OR from AND if also as subevent of XOR
	 * @param topevent
	 * @param gt
	 * @return Event
	 */
	private void doXformXORtoOR(Event topevent) {
		List<Event> subEvents = topevent.getSubEvents();
		if (subEvents.isEmpty()) {
			return;
		}
		if (subEvents.size() == 1) {
			return;
		}
		List<Event> todo = new LinkedList<Event>();
		todo.clear();
		for (Event se : subEvents) {
			if (!se.getSubEvents().isEmpty() && (se.getSubEventLogic() == LogicOperation.OR)) {
				for (Event andevent : subEvents) {
					if (!andevent.getSubEvents().isEmpty() && (andevent.getSubEventLogic() == LogicOperation.AND)) {
						if (andevent.getSubEvents().contains(se)) {
							andevent.getSubEvents().remove(se);
							todo.add(se);
						}
					}
				}
			}
		}
		if (todo.size() > 0) {
			topevent.setSubEventLogic(LogicOperation.OR);
			topevent.getSubEvents().removeAll(todo);
		}
	}

	/**
	 * find subevents that contain other subevents of the topevent and remove them if they do contain one.
	 * Law of Absorption
	 * @param topevent
	 * @param gt
	 * @return Event topevent
	 */
	private Event removeSubEventsCommonWithEnclosingEvents(Event topevent, LogicOperation topgt, LogicOperation gt) {
		List<Event> subEvents = topevent.getSubEvents();
		if (subEvents.isEmpty()) {
			return null;
		}
		LinkedList<Event> toRemove = new LinkedList<Event>();
		for (Event se : subEvents) {
			for (Event subse : subEvents) {
				if (subse != se && !subse.getSubEvents().isEmpty() && (subse.getSubEventLogic() == gt)) {
					if (subse.getSubEvents().contains(se)) {
						toRemove.add(subse);
					} else {
						for (Event subsub : subse.getSubEvents()) {
							if (subsub.getSubEventLogic() == topgt) {
								if (subsub.getSubEvents().contains(se)) {
									if (topgt == LogicOperation.OR || topgt == LogicOperation.AND) {
										subsub.getSubEvents().remove(se);
									}
								}
							}
						}
					}
				}
			}
		}
		if (!toRemove.isEmpty()) {
			subEvents.removeAll(toRemove);
			removeZeroOneEventSubGates(topevent);
		}
		return topevent;
	}

	/**
	 * create an PRIORITY_AND gate if both are non-null. Otherwise return the non-null Event or null if both are null.
	 * @param stateEvent Event representing the source state of a transition or outgoing propagation condition
	 * @param conditionEvent Event representing the condition of a transition or outgoing propagation condition
	 * @return Event or null
	 */
	private Event consolidateAsPriorityAnd(Event stateEvent, Event conditionEvent, ComponentInstance component,
			NamedElement ne, TypeToken targetType) {
		if (stateEvent == null && conditionEvent != null) {
			return conditionEvent;
		} else if (stateEvent != null && conditionEvent == null) {
			return stateEvent;
		} else if (stateEvent != null && conditionEvent != null) {
			Event inter = FaultTreeUtils.createIntermediateEvent(ftaModel, component, ne, targetType);
			inter.setSubEventLogic(LogicOperation.PRIORITY_AND);
			if (!stateEvent.getSubEvents().isEmpty() && stateEvent.getSubEventLogic() == LogicOperation.PRIORITY_AND) {
				inter.getSubEvents().addAll(stateEvent.getSubEvents());
			} else {
				inter.getSubEvents().add(stateEvent);
			}
			if (!conditionEvent.getSubEvents().isEmpty()
					&& conditionEvent.getSubEventLogic() == LogicOperation.PRIORITY_AND) {
				inter.getSubEvents().addAll(conditionEvent.getSubEvents());
			} else {
				inter.getSubEvents().add(conditionEvent);
			}
			return inter;
		}
		return null;
	}

//	methods to be overwritten by applications

	@Override
	protected EObject postProcessOutgoingErrorPropagation(ComponentInstance component,
			ErrorPropagation errorPropagation, TypeToken targetType, List<EObject> subResults, BigDecimal scale) {
		Event result = finalizeAsOrEvents(component, errorPropagation, targetType, subResults);
		if (result != null && result.getType() == EventType.INTERMEDIATE) {
			result.setName(FaultTreeUtils.buildName(component, errorPropagation, targetType));
		}
		return result;
	}

	@Override
	protected EObject processOutgoingErrorPropagation(ComponentInstance component, ErrorPropagation errorPropagation,
			TypeToken targetType, BigDecimal scale) {
		Event newEvent = FaultTreeUtils.createBasicEvent(ftaModel, component, errorPropagation, targetType);
		newEvent.setScale(scale);
		return newEvent;
	}

	@Override
	protected EObject preProcessOutgoingErrorPropagation(ComponentInstance component, ErrorPropagation errorPropagation,
			TypeToken targetType, BigDecimal scale) {
		String name = FaultTreeUtils.buildName(component, errorPropagation, targetType);
		Event result = FaultTreeUtils.findEvent(ftaModel, name);
		return result;
	}

	@Override
	protected EObject preProcessIncomingErrorPropagation(ComponentInstance component, ErrorPropagation errorPropagation,
			TypeToken targetType, BigDecimal scale) {
		String name = FaultTreeUtils.buildName(component, errorPropagation, targetType);
		Event result = FaultTreeUtils.findEvent(ftaModel, name);
		return result;
	}

	@Override
	protected EObject processErrorSource(ComponentInstance component, ErrorSource errorSource, TypeToken type,
			BigDecimal scale) {
		Event newEvent = FaultTreeUtils.createBasicEvent(ftaModel, component, errorSource, type);
		newEvent.setScale(scale);
		return newEvent;
	}

	@Override
	protected EObject postProcessErrorSource(ComponentInstance component, ErrorSource errorSource, TypeToken type,
			List<EObject> subResults, BigDecimal scale) {
		return finalizeAsOrEvents(component, errorSource, type, subResults);
	}

	@Override
	protected EObject processConnectionErrorSource(ConnectionInstance conni, ErrorSource errorSource,
			TypeToken typeTokenConstraint, BigDecimal scale) {
		Event newEvent = FaultTreeUtils.createBasicEvent(ftaModel, conni, errorSource, typeTokenConstraint);
		newEvent.setScale(scale);
		return newEvent;
	}

	@Override
	protected EObject processIncomingErrorPropagation(ComponentInstance component, ErrorPropagation incoming,
			TypeToken type, BigDecimal scale) {
		Event res = FaultTreeUtils.createBasicEvent(ftaModel, component, incoming, type);
		res.setScale(scale);
		if (component instanceof SystemInstance) {
			res.setType(EventType.EXTERNAL);
		} else {
			res.setType(EventType.UNDEVELOPED);
		}
		return res;
	}

	@Override
	protected EObject postProcessIncomingErrorPropagation(ComponentInstance component,
			ErrorPropagation errorPropagation, TypeToken targetType, List<EObject> subResults, BigDecimal scale) {
		return finalizeAsOrEvents(component, errorPropagation, targetType, subResults);
	}

	@Override
	protected EObject processOutgoingErrorPropagationCondition(ComponentInstance component,
			OutgoingPropagationCondition opc, TypeToken type, EObject conditionResult, EObject stateResult,
			BigDecimal scale) {
		Event consolidated = consolidateAsPriorityAnd((Event) stateResult, (Event) conditionResult, component, opc,
				type);
		return consolidated;
	}

	@Override
	protected EObject postProcessCompositeErrorStates(ComponentInstance component, ErrorBehaviorState state,
			TypeToken targetType, List<EObject> subResults, BigDecimal scale) {
		Event result = finalizeAsOrEvents(component, state, targetType, subResults);
		if (result == null) {
			Event newEvent = FaultTreeUtils.createBasicEvent(ftaModel, component, state, targetType);
			return newEvent;
		}
		return result;
	}


	@Override
	protected EObject processErrorBehaviorState(ComponentInstance component, ErrorBehaviorState state,
			TypeToken type, BigDecimal scale) {
		Event newEvent = FaultTreeUtils.createBasicEvent(ftaModel, component, state, type);
		newEvent.setScale(scale);
		return newEvent;
	}

	@Override
	protected EObject postProcessErrorBehaviorState(ComponentInstance component, ErrorBehaviorState state,
			TypeToken type, List<EObject> subResults, BigDecimal scale) {
		String name = FaultTreeUtils.buildName(component, state, type);
		Event found = FaultTreeUtils.findEvent(ftaModel, name);
		if (found != null) {
			return null;
		}
		Event result = finalizeAsUniqueOrEvents(component, state, type, subResults);
		return result;
	}

	@Override
	protected EObject processTransitionCondition(ComponentInstance component, ErrorBehaviorState source,
			TypeToken type, EObject conditionResult, EObject stateResult, BigDecimal scale) {
		Event consolidated = consolidateAsPriorityAnd((Event) stateResult, (Event) conditionResult,
				component, source, type);
		return consolidated;
	}

	@Override
	protected EObject processErrorEvent(ComponentInstance component, ErrorEvent errorEvent, TypeToken type,
			BigDecimal scale) {
		Event ftaEvent = FaultTreeUtils.createBasicEvent(ftaModel, component, errorEvent, type);
		ftaEvent.setScale(scale);
		return ftaEvent;
	}

	@Override
	protected EObject postProcessAnd(ComponentInstance component, Element condition, TypeToken type,
			List<EObject> subResults, BigDecimal scale) {
		Event ftaEvent = finalizeAsAndEvents(component, condition, type, subResults);
		return ftaEvent;
	}

	@Override
	protected EObject postProcessXor(ComponentInstance component, Element condition, TypeToken type,
			BigDecimal scale, List<EObject> subResults) {
		Event ftaEvent = finalizeAsXOrEvents(component, condition, type, subResults);
		return ftaEvent;
	}

	@Override
	protected EObject postProcessOr(ComponentInstance component, Element condition, TypeToken type,
			List<EObject> subResults, BigDecimal scale) {
		Event ftaEvent = finalizeAsOrEvents(component, condition, type, subResults);
		return ftaEvent;
	}

	@Override
	protected EObject postProcessOrMore(ComponentInstance component, Element condition, TypeToken type,
			List<EObject> subResults, BigDecimal scale) {

		Event ftaEvent = finalizeAsOrMoreEvents(component, condition, type, subResults);
		return ftaEvent;
	}

	@Override
	protected EObject processTypesetElements(ComponentInstance component, Element state, TypeToken type,
			List<EObject> subResults, BigDecimal scale) {
		return finalizeAsOrEvents(component, state, type, subResults);
	}

}
