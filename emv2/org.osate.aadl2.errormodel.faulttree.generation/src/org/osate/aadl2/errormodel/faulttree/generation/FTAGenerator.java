package org.osate.aadl2.errormodel.faulttree.generation;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osate.aadl2.Element;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.errormodel.FaultTree.Event;
import org.osate.aadl2.errormodel.FaultTree.EventType;
import org.osate.aadl2.errormodel.FaultTree.FaultTree;
import org.osate.aadl2.errormodel.FaultTree.FaultTreeFactory;
import org.osate.aadl2.errormodel.FaultTree.LogicOperation;
import org.osate.aadl2.errormodel.FaultTree.util.FaultTreeUtils;
import org.osate.aadl2.errormodel.PropagationGraph.PropagationGraph;
import org.osate.aadl2.errormodel.PropagationGraph.util.PropagationGraphBackwardTraversal;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.xtext.aadl2.errormodel.errorModel.ConditionExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.ConnectionErrorSource;
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
	}

	public FaultTree getftaModel(ComponentInstance rootComponent, NamedElement rootStateOrPropagation,
			ErrorTypes rootComponentTypes, boolean transformTree, boolean sharedEventsAsGraph, boolean minimalCutSet) {
		if (ftaModel == null) {
			Event emftaRootEvent;

			ftaModel = FaultTreeFactory.eINSTANCE.createFaultTree();
			ftaModel.setName(FaultTreeUtils.buildIdentifier(rootComponent, rootStateOrPropagation, rootComponentTypes));
			ftaModel.setDescription("Top Level Failure");

			if (rootStateOrPropagation instanceof ErrorBehaviorState) {
				emftaRootEvent = (Event) traverseCompositeErrorState(rootComponent,
						(ErrorBehaviorState) rootStateOrPropagation,
						rootComponentTypes);
			} else {
				emftaRootEvent = (Event) traverseOutgoingErrorPropagation(rootComponent,
						(ErrorPropagation) rootStateOrPropagation,
						rootComponentTypes);
			}
			if (emftaRootEvent == null) {
				emftaRootEvent = FaultTreeUtils.createIntermediateEvent(ftaModel, rootComponent, rootStateOrPropagation,
						rootComponentTypes);
			}
			String longName = FaultTreeUtils.buildName(rootComponent, rootStateOrPropagation, rootComponentTypes);
			if (emftaRootEvent.getSubEvents().isEmpty() && !emftaRootEvent.getName().equals(longName)) {
				Event topEvent = FaultTreeUtils.createIntermediateEvent(ftaModel, rootComponent, rootStateOrPropagation,
						rootComponentTypes);
				topEvent.getSubEvents().add(emftaRootEvent);
				emftaRootEvent = topEvent;
			}
			flattenGates(emftaRootEvent);
			cleanupXORGates(emftaRootEvent);
//			xformXORtoOR(emftaRootEvent);
			if (transformTree) {
				emftaRootEvent = optimizeGates(emftaRootEvent);
				flattenGates(emftaRootEvent);
			}
			if (minimalCutSet) {
				emftaRootEvent = minimalCutSet(emftaRootEvent);
			}
			emftaRootEvent.setName(longName);
			ftaModel.setRoot(emftaRootEvent);
			FaultTreeUtils.removeEventOrphans(ftaModel);
			boolean hasDependentEvents = FaultTreeUtils.hasSharedEvents(ftaModel);
			if (!sharedEventsAsGraph) {
				replicateSharedEvents(emftaRootEvent);
			}
			FaultTreeUtils.removeEventOrphans(ftaModel);
			for (Event event : ftaModel.getEvents()) {
				EObject element = event.getRelatedEMV2Object();
				if (element instanceof NamedElement) {
					FaultTreeUtils.fillProperties(event, (ComponentInstance) event.getRelatedInstanceObject(),
							(NamedElement) element,
							(ErrorTypes) event.getRelatedErrorType());
				}
			}
			if (transformTree || minimalCutSet || !hasDependentEvents) {
				FaultTreeUtils.performUpdate(ftaModel.getRoot());
			}
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
		Event combined = FaultTreeUtils.findSharedSubtree(ftaModel, subEvents, LogicOperation.XOR);
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
		Event combined = FaultTreeUtils.findSharedSubtree(ftaModel, subEvents, LogicOperation.OR);
		if (combined != null) {
			return combined;
		}
		combined = FaultTreeUtils.createIntermediateEvent(ftaModel, component, ne, type);
		combined.setSubEventLogic(LogicOperation.OR);

		for (Object seobj : subEvents) {
			Event se = (Event) seobj;
			combined.getSubEvents().add(se);
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
		Event combined = FaultTreeUtils.findSharedSubtree(ftaModel, subEvents, LogicOperation.AND);
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
		Event combined = FaultTreeUtils.findSharedSubtree(ftaModel, subEvents, LogicOperation.PRIORITY_AND);
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
		EventType mytype = event.getType();
		EList<Event> subEvents = event.getSubEvents();
		List<Event> toAdd = new LinkedList<Event>();
		List<Event> toRemove = new LinkedList<Event>();
		for (Event se : subEvents) {
			if (!se.getSubEvents().isEmpty() && se.getType() == mytype) {
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
		Event alternatives = FaultTreeUtils.createUniqueIntermediateEvent(ftaModel,
				(ComponentInstance) rootevent.getRelatedInstanceObject(),
				(NamedElement) rootevent.getRelatedEMV2Object(), (ErrorTypes) rootevent.getRelatedErrorType());
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
				Event alternative = FaultTreeUtils.createUniqueIntermediateEvent(ftaModel,
						(ComponentInstance) rootevent.getRelatedInstanceObject(),
						(NamedElement) rootevent.getRelatedEMV2Object(), (ErrorTypes) rootevent.getRelatedErrorType());
				alternative.setSubEventLogic(LogicOperation.AND);
				toAdd.add(alternative);
				normalizeEvent(alt, toAdd);
				for (Event addMe : toAdd) {
					addAsMinimalAndSet(alternatives, addMe);
				}
				toAdd.clear();
			}
		} else if (rootevent.getSubEventLogic() == LogicOperation.AND
				|| rootevent.getSubEventLogic() == LogicOperation.PRIORITY_AND) {
			Event alternative = FaultTreeUtils.createUniqueIntermediateEvent(ftaModel,
					(ComponentInstance) rootevent.getRelatedInstanceObject(),
					(NamedElement) rootevent.getRelatedEMV2Object(), (ErrorTypes) rootevent.getRelatedErrorType());
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

	private void normalizeEvent(Event event, List<Event> alternatives) {
		if (event.getSubEvents().isEmpty()) {
			for (Event alternative : alternatives) {
				alternative.getSubEvents().add(event);
			}
			return;
		}
		if (event.getSubEventLogic() == LogicOperation.AND || event.getSubEventLogic() == LogicOperation.PRIORITY_AND) {
			for (Event subevent : event.getSubEvents()) {
				normalizeEvent(subevent, alternatives);
			}
		} else if (event.getSubEventLogic() == LogicOperation.OR || event.getSubEventLogic() == LogicOperation.XOR
				|| event.getSubEventLogic() == LogicOperation.KORMORE) {
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
	 * recursively flatten gates with same subgates
	 * @param rootevent
	 * @return Event original or new root event
	 */
	private void replicateSharedEvents(Event rootevent) {
		UniqueEList<Event> found = new UniqueEList<Event>();
		replicateSharedEvents(rootevent, found);
		return;
	}

	private void replicateSharedEvents(Event rootevent, UniqueEList<Event> found) {
		if (rootevent.getSubEvents().isEmpty()) {
			return;
		}
		List<Event> subEvents = rootevent.getSubEvents();
		List<Event> toAdd = new LinkedList<Event>();
		List<Event> toRemove = new LinkedList<Event>();
		for (Event event : subEvents) {
			if (!event.getSubEvents().isEmpty()) {
				replicateSharedEvents(event, found);
			}
			if (!found.add(event)) {
				// make new event instance and link it in
				Event newEvent = recursiveCopy(event);
				toAdd.add(newEvent);
				toRemove.add(event);
			}
		}
		subEvents.removeAll(toRemove);
		subEvents.addAll(toAdd);
		return;
	}

	private Event recursiveCopy(Event event) {
		Event newEvent = EcoreUtil.copy(event);
		ftaModel.getEvents().add(newEvent);
		tagAsSharedEvent(newEvent);
		tagAsSharedEvent(event);
		if (!event.getSubEvents().isEmpty()) {
			newEvent.getSubEvents().clear();
			for (Event subevent : event.getSubEvents()) {
				Event copy = recursiveCopy(subevent);
				newEvent.getSubEvents().add(copy);
			}
		}
		return newEvent;
	}

	private void tagAsSharedEvent(Event ev) {
		if (!ev.getName().endsWith("*")) {
			ev.setName(ev.getName() + "*");
		}
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
		if (res.getSubEventLogic() == LogicOperation.AND) {
			Event tmp = transformSubgates(rootevent, LogicOperation.OR, res.getSubEventLogic());
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
		if (res.getSubEventLogic() == LogicOperation.AND || res.getSubEventLogic() == LogicOperation.XOR) {
			res = removeSubEventsCommonWithEnclosingEvents(res, LogicOperation.OR);
		}
		if (res.getSubEventLogic() == LogicOperation.OR) {
			res = removeSubEventsCommonWithEnclosingEvents(res, LogicOperation.AND);
		}
		if (res.getSubEventLogic() == LogicOperation.OR) {
			res = removeSubEventsCommonWithEnclosingEvents(res, LogicOperation.PRIORITY_AND);
		}
		if (res.getSubEventLogic() == LogicOperation.OR) {
			res = removeSubEventsCommonWithEnclosingEvents(res, LogicOperation.XOR);
		}
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
		if (res.getSubEventLogic() == LogicOperation.AND) {
			Event tmp = transformSubgates(rootevent, LogicOperation.OR, res.getSubEventLogic());
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
		if (res.getSubEventLogic() == LogicOperation.AND || res.getSubEventLogic() == LogicOperation.XOR) {
			res = removeSubEventsCommonWithEnclosingEvents(res, LogicOperation.OR);
		}
		if (res.getSubEventLogic() == LogicOperation.OR) {
			res = removeSubEventsCommonWithEnclosingEvents(res, LogicOperation.AND);
		}
		if (res.getSubEventLogic() == LogicOperation.OR) {
			res = removeSubEventsCommonWithEnclosingEvents(res, LogicOperation.PRIORITY_AND);
		}
		if (res.getSubEventLogic() == LogicOperation.OR) {
			res = removeSubEventsCommonWithEnclosingEvents(res, LogicOperation.XOR);
		}
		flattenSubgates(res);
		removeZeroOneEventSubGates(res);
		if (res.getSubEvents().size() == 1 && res.getType() != EventType.INTERMEDIATE) {
			res = res.getSubEvents().get(0);
		}
		if (!rootname.startsWith("Intermediate")) {
			res.setName(rootname);
		}
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
							(NamedElement) topevent.getRelatedEMV2Object(),
							(ErrorTypes) topevent.getRelatedErrorType());
					if (!topevent.getName().startsWith("Intermediate")) {
						String newname = newtopevent.getName();
						newtopevent.setName(topevent.getName());
						topevent.setName(newname);
					}
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
							(NamedElement) topevent.getRelatedEMV2Object(),
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
					// create intermediate topgate for subset of gates and remove from original top gate
					Event newsubtopevent = FaultTreeUtils.createIntermediateEvent(ftaModel,
							(ComponentInstance) topevent.getRelatedInstanceObject(),
							(NamedElement) topevent.getRelatedEMV2Object(),
							(ErrorTypes) topevent.getRelatedErrorType());
					newsubtopevent.setSubEventLogic(topgt);
					newsubtopevent.getSubEvents().addAll(todo);
					topevent.getSubEvents().removeAll(todo);
					newtopevent.getSubEvents().add(newsubtopevent);
					removeCommonEventsFromSubgates(newsubtopevent, gt);
					flattenSubgates(newsubtopevent);
					removeZeroOneEventSubGates(newsubtopevent);
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
	 * find events in subgates that already exist in enclosing gate
	 * Law of Absorption
	 * @param topevent
	 * @param gt
	 * @return Event topevent
	 */
	private Event removeSubEventsCommonWithEnclosingEvents(Event topevent, LogicOperation gt) {
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
			ErrorPropagation errorPropagation, ErrorTypes targetType, List<EObject> subResults) {
		Event result = finalizeAsOrEvents(component, errorPropagation, targetType, subResults);
		if (result != null && result.getType() == EventType.INTERMEDIATE) {
			result.setName(FaultTreeUtils.buildName(component, errorPropagation, targetType));
		}
		return result;
	}

	@Override
	protected EObject postProcessErrorFlows(ComponentInstance component, ErrorPropagation errorPropagation,
			ErrorTypes targetType, List<EObject> subResults) {
		Event result = finalizeAsOrEvents(component, errorPropagation, targetType, subResults);
		if (result != null && result.getType() == EventType.INTERMEDIATE) {
			result.setName(FaultTreeUtils.buildName(component, errorPropagation, targetType));
		}
		return result;
	}

	@Override
	protected EObject processOutgoingErrorPropagation(ComponentInstance component, ErrorPropagation errorPropagation,
			ErrorTypes targetType) {
		Event newEvent = FaultTreeUtils.createBasicEvent(ftaModel, component, errorPropagation, targetType);
		return newEvent;
	}

	@Override
	protected EObject processErrorSource(ComponentInstance component, ErrorSource errorSource, ErrorTypes type) {
		Event newEvent = FaultTreeUtils.createBasicEvent(ftaModel, component, errorSource, type);
		return newEvent;
	}

	@Override
	protected EObject processConnectionErrorSource(ConnectionInstance conni, ConnectionErrorSource errorSource,
			ErrorTypes typeTokenConstraint) {
		Event newEvent = FaultTreeUtils.createBasicEvent(ftaModel, conni, errorSource, typeTokenConstraint);
		return newEvent;
	}

	@Override
	protected EObject processIncomingErrorPropagation(ComponentInstance component, ErrorPropagation incoming,
			ErrorTypes type) {
		Event res = FaultTreeUtils.createBasicEvent(ftaModel, component, incoming, type);
		if (component instanceof SystemInstance) {
			res.setType(EventType.EXTERNAL);
		} else {
			res.setType(EventType.UNDEVELOPED);
		}
		return res;
	}

	@Override
	protected EObject postProcessIncomingErrorPropagation(ComponentInstance component,
			ErrorPropagation errorPropagation, ErrorTypes targetType, List<EObject> subResults) {
		return finalizeAsOrEvents(component, errorPropagation, targetType, subResults);
	}

	@Override
	protected EObject processOutgoingErrorPropagationCondition(ComponentInstance component,
			OutgoingPropagationCondition opc, ErrorTypes type, EObject conditionResult, EObject stateResult) {
		Event consolidated = consolidateAsPriorityAnd((Event) stateResult, (Event) conditionResult,
				component, opc, type);
		return consolidated;
	}

	@Override
	protected EObject postProcessCompositeErrorStates(ComponentInstance component, ErrorBehaviorState state,
			ErrorTypes targetType, List<EObject> subResults) {
		Event result = finalizeAsOrEvents(component, state, targetType, subResults);
		if (result == null) {
			Event newEvent = FaultTreeUtils.createBasicEvent(ftaModel, component, state, targetType);
			return newEvent;
		}
		return result;
	}

	@Override
	protected EObject processErrorBehaviorState(ComponentInstance component, ErrorBehaviorState state,
			ErrorTypes type) {
		Event newEvent = FaultTreeUtils.createBasicEvent(ftaModel, component, state, type);
		return newEvent;
	}

	@Override
	protected EObject postProcessErrorBehaviorState(ComponentInstance component, ErrorBehaviorState state,
			ErrorTypes type, List<EObject> subResults) {
		Event result = finalizeAsOrEvents(component, state, type, subResults);
		if (result != null && result.getType() == EventType.INTERMEDIATE) {
			result.setName(FaultTreeUtils.buildName(component, state, type));
		}
		return result;
	}

	@Override
	protected EObject processTransitionCondition(ComponentInstance component, ErrorBehaviorState source,
			ErrorTypes type, EObject conditionResult, EObject stateResult) {
		Event consolidated = consolidateAsPriorityAnd((Event) stateResult, (Event) conditionResult,
				component, source, type);
		return consolidated;
	}

	@Override
	protected EObject processErrorEvent(ComponentInstance component, ErrorEvent errorEvent, ErrorTypes type,
			double scale) {
		Event emftaEvent = FaultTreeUtils.createBasicEvent(ftaModel, component, errorEvent, type);
		return emftaEvent;
	}

	@Override
	protected EObject postProcessAnd(ComponentInstance component, ConditionExpression condition, ErrorTypes type,
			double scale, List<EObject> subResults) {
		return finalizeAsAndEvents(component, condition, type, subResults);
	}

	@Override
	protected EObject postProcessXor(ComponentInstance component, ConditionExpression condition, ErrorTypes type,
			double scale, List<EObject> subResults) {
		return finalizeAsXOrEvents(component, condition, type, subResults);
	}

	@Override
	protected EObject postProcessOr(ComponentInstance component, ConditionExpression condition, ErrorTypes type,
			double scale, List<EObject> subResults) {
		return finalizeAsOrEvents(component, condition, type, subResults);
	}

}
