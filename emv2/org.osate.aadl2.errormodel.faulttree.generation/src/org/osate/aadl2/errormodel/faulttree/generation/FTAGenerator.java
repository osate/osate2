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
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypes;
import org.osate.xtext.aadl2.errormodel.errorModel.OutgoingPropagationCondition;

public class FTAGenerator extends PropagationGraphBackwardTraversal {
	private FaultTree ftaModel;

	public FTAGenerator(PropagationGraph currentPropagationGraph) {
		super(currentPropagationGraph);
		ftaModel = null;
		FaultTreeUtils.resetIntermediateEventCount();
	}

	public FaultTree getftaModel(ComponentInstance rootComponent, NamedElement rootStateOrPropagation,
			ErrorTypes rootComponentTypes, FaultTreeType faultTreeType) {
		if (ftaModel == null) {
			Event ftaRootEvent = null;
			String errorMsg = "";
			ftaModel = FaultTreeFactory.eINSTANCE.createFaultTree();
			ftaModel.setName(FaultTreeUtils.buildIdentifier(rootComponent, rootStateOrPropagation, rootComponentTypes));
			ftaModel.setInstanceRoot(rootComponent);
			ftaModel.setFaultTreeType(faultTreeType);

			if (rootStateOrPropagation instanceof ErrorBehaviorState) {
				if (faultTreeType.equals(FaultTreeType.COMPOSITE_PARTS)) {
					ftaRootEvent = (Event) traverseCompositeErrorStateOnly(rootComponent,
							(ErrorBehaviorState) rootStateOrPropagation, rootComponentTypes, BigOne);

				} else {
					ftaRootEvent = (Event) traverseCompositeErrorState(rootComponent,
							(ErrorBehaviorState) rootStateOrPropagation, rootComponentTypes, BigOne);
				}
			} else {
				if (faultTreeType.equals(FaultTreeType.COMPOSITE_PARTS)) {
					errorMsg = "Select error state for composite parts fault tree";
					ftaRootEvent = FaultTreeUtils.createIntermediateEvent(ftaModel, rootComponent,
							rootStateOrPropagation, rootComponentTypes);
					ftaModel.setMessage(errorMsg);
					ftaModel.setRoot(ftaRootEvent);
					return ftaModel;
				} else {
					ftaRootEvent = (Event) traverseOutgoingErrorPropagation(rootComponent,
							(ErrorPropagation) rootStateOrPropagation,
							rootComponentTypes, BigOne);
				}
			}
			if (ftaRootEvent == null) {
				ftaRootEvent = FaultTreeUtils.createIntermediateEvent(ftaModel, rootComponent, rootStateOrPropagation,
						rootComponentTypes);
			}
			String longName = FaultTreeUtils.buildName(rootComponent, rootStateOrPropagation, rootComponentTypes);
			if (ftaRootEvent.getSubEvents().isEmpty() && !ftaRootEvent.getName().equals(longName)) {
				Event topEvent = FaultTreeUtils.createIntermediateEvent(ftaModel, rootComponent, rootStateOrPropagation,
						rootComponentTypes);
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
	private Event finalizeAsXOrEvents(ComponentInstance component, Element el, ErrorTypes type,
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

	private Event finalizeAsOrEvents(ComponentInstance component, Element ne, ErrorTypes type,
			List<EObject> subEvents) {
		if (subEvents.size() == 0) {
			return null;
		}
//		if (subEvents.size() == 1) {
//			return (Event) subEvents.get(0);
//		}
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

	private Event finalizeAsAndEvents(ComponentInstance component, Element ne, ErrorTypes type,
			List<EObject> subEvents) {
		if (subEvents.size() == 0) {
			return null;
		}
//		if (subEvents.size() == 1) {
//			return (Event) subEvents.get(0);
//		}
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

	private Event finalizeAsPriorityAndEvents(ComponentInstance component, Element ne, ErrorTypes type,
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
				rootevent.getRelatedEMV2Object(), (ErrorTypes) rootevent.getRelatedErrorType());
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
						rootevent.getRelatedEMV2Object(), (ErrorTypes) rootevent.getRelatedErrorType());
				alternative.setSubEventLogic(LogicOperation.AND);
				toAdd.add(alternative);
				// normalize each of the subevents
				normalizeEvent(alt, toAdd);
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
					rootevent.getRelatedEMV2Object(), (ErrorTypes) rootevent.getRelatedErrorType());
			alternative.setSubEventLogic(LogicOperation.AND);
			toAdd.add(alternative);
			normalizeEvent(rootevent, toAdd);
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
	private void normalizeEvent(Event event, List<Event> alternatives) {
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
				normalizeEvent(subevent, alternatives);
			}
		} else if (event.getSubEventLogic() == LogicOperation.OR || event.getSubEventLogic() == LogicOperation.XOR
				|| event.getSubEventLogic() == LogicOperation.KORMORE) {
			// for each sub-event of OR etc create a separate alternative
			List<Event> origalts = FaultTreeUtils.copy(ftaModel, alternatives);
			boolean first = true;
			for (Event subevent : event.getSubEvents()) {
				if (first) {
					normalizeEvent(subevent, alternatives);
					first = false;
				} else {
					List<Event> morealts = FaultTreeUtils.copy(ftaModel, origalts);
					normalizeEvent(subevent, morealts);
					alternatives.addAll(morealts);
				}
			}
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
		if (res.getSubEventLogic() == LogicOperation.AND ) {
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
	 * Distributive Law 3a and 3b (se NRC Fault Tree Handbook page 80.
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
					Event newtopevent = FaultTreeUtils.createIntermediateEvent(ftaModel,
							(ComponentInstance) topevent.getRelatedInstanceObject(),
							topevent.getRelatedEMV2Object(),
							(ErrorTypes) topevent.getRelatedErrorType());
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
							(ErrorTypes) topevent.getRelatedErrorType());
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
			NamedElement ne, ErrorTypes targetType) {
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
			ErrorPropagation errorPropagation, ErrorTypes targetType, List<EObject> subResults, BigDecimal scale) {
		Event result = finalizeAsOrEvents(component, errorPropagation, targetType, subResults);
		if (result != null && result.getType() == EventType.INTERMEDIATE) {
			result.setName(FaultTreeUtils.buildName(component, errorPropagation, targetType));
		}
		return result;
	}

	@Override
	protected EObject processOutgoingErrorPropagation(ComponentInstance component, ErrorPropagation errorPropagation,
			ErrorTypes targetType, BigDecimal scale) {
		Event newEvent = FaultTreeUtils.createBasicEvent(ftaModel, component, errorPropagation, targetType);
		newEvent.setScale(scale);
		return newEvent;
	}

	@Override
	protected EObject processErrorSource(ComponentInstance component, ErrorSource errorSource, ErrorTypes type,
			BigDecimal scale) {
		Event newEvent = FaultTreeUtils.createBasicEvent(ftaModel, component, errorSource, type);
		newEvent.setScale(scale);
		return newEvent;
	}

	@Override
	protected EObject processConnectionErrorSource(ConnectionInstance conni, ErrorSource errorSource,
			ErrorTypes typeTokenConstraint, BigDecimal scale) {
		Event newEvent = FaultTreeUtils.createBasicEvent(ftaModel, conni, errorSource, typeTokenConstraint);
		newEvent.setScale(scale);
		return newEvent;
	}

	@Override
	protected EObject processIncomingErrorPropagation(ComponentInstance component, ErrorPropagation incoming,
			ErrorTypes type, BigDecimal scale) {
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
			ErrorPropagation errorPropagation, ErrorTypes targetType, List<EObject> subResults, BigDecimal scale) {
		return finalizeAsOrEvents(component, errorPropagation, targetType, subResults);
	}

	@Override
	protected EObject processOutgoingErrorPropagationCondition(ComponentInstance component,
			OutgoingPropagationCondition opc, ErrorTypes type, EObject conditionResult, EObject stateResult,
			BigDecimal scale) {
		Event consolidated = consolidateAsPriorityAnd((Event) stateResult, (Event) conditionResult,
				component, opc, type);
		return consolidated;
	}

	@Override
	protected EObject postProcessCompositeErrorStates(ComponentInstance component, ErrorBehaviorState state,
			ErrorTypes targetType, List<EObject> subResults, BigDecimal scale) {
		if (subResults.size() == 1) {
			Event result = (Event) subResults.get(0);
			result.setRelatedInstanceObject(component);
			result.setRelatedEMV2Object(state);
			result.setRelatedErrorType(targetType);
			return result;
		}
		Event result = finalizeAsOrEvents(component, state, targetType, subResults);
		if (result == null) {
			Event newEvent = FaultTreeUtils.createBasicEvent(ftaModel, component, state, targetType);
			return newEvent;
		}
		return result;
	}

	@Override
	protected EObject processErrorBehaviorState(ComponentInstance component, ErrorBehaviorState state,
			ErrorTypes type, BigDecimal scale) {
		Event newEvent = FaultTreeUtils.createBasicEvent(ftaModel, component, state, type);
		newEvent.setScale(scale);
		return newEvent;
	}

	@Override
	protected EObject postProcessErrorBehaviorState(ComponentInstance component, ErrorBehaviorState state,
			ErrorTypes type, List<EObject> subResults, BigDecimal scale) {
		Event result = finalizeAsOrEvents(component, state, type, subResults);
		if (result != null && result.getType() == EventType.INTERMEDIATE) {
			result.setName(FaultTreeUtils.buildName(component, state, type));
		}
		return result;
	}

	@Override
	protected EObject processTransitionCondition(ComponentInstance component, ErrorBehaviorState source,
			ErrorTypes type, EObject conditionResult, EObject stateResult, BigDecimal scale) {
		Event consolidated = consolidateAsPriorityAnd((Event) stateResult, (Event) conditionResult,
				component, source, type);
		return consolidated;
	}

	@Override
	protected EObject processErrorEvent(ComponentInstance component, ErrorEvent errorEvent, ErrorTypes type,
			BigDecimal scale) {
		Event ftaEvent = FaultTreeUtils.createBasicEvent(ftaModel, component, errorEvent, type);
		ftaEvent.setScale(scale);
		return ftaEvent;
	}

	@Override
	protected EObject postProcessAnd(ComponentInstance component, Element condition, ErrorTypes type,
			List<EObject> subResults, BigDecimal scale) {
		Event ftaEvent = finalizeAsAndEvents(component, condition, type, subResults);
		return ftaEvent;
	}

	@Override
	protected EObject postProcessXor(ComponentInstance component, Element condition, ErrorTypes type,
			BigDecimal scale, List<EObject> subResults) {
		Event ftaEvent = finalizeAsXOrEvents(component, condition, type, subResults);
		return ftaEvent;
	}

	@Override
	protected EObject postProcessOr(ComponentInstance component, Element condition, ErrorTypes type,
			List<EObject> subResults, BigDecimal scale) {
		Event ftaEvent = finalizeAsOrEvents(component, condition, type, subResults);
		return ftaEvent;
	}

	@Override
	protected EObject processTypesetElements(ComponentInstance component, Element condition, ErrorTypes type,
			List<EObject> subResults, BigDecimal scale) {
		return finalizeAsOrEvents(component, condition, type, subResults);
	}

}
