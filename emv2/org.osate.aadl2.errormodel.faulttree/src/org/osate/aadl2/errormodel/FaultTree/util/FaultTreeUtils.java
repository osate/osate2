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
package org.osate.aadl2.errormodel.FaultTree.util;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.Element;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.errormodel.FaultTree.Event;
import org.osate.aadl2.errormodel.FaultTree.EventType;
import org.osate.aadl2.errormodel.FaultTree.FaultTree;
import org.osate.aadl2.errormodel.FaultTree.FaultTreeFactory;
import org.osate.aadl2.errormodel.FaultTree.FaultTreeType;
import org.osate.aadl2.errormodel.FaultTree.LogicOperation;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.xtext.aadl2.errormodel.errorModel.CompositeState;
import org.osate.xtext.aadl2.errormodel.errorModel.ConditionExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorTransition;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorDetection;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorSource;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypes;
import org.osate.xtext.aadl2.errormodel.errorModel.OutgoingPropagationCondition;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeToken;
import org.osate.xtext.aadl2.errormodel.util.EMV2Properties;
import org.osate.xtext.aadl2.errormodel.util.EMV2Util;

public class FaultTreeUtils {

	private static String buildName(ConnectionInstance conni, NamedElement namedElement, TypeToken type) {
		String identifier;

		identifier = conni.getName();

		if (namedElement == null) {
			identifier += "-unidentified";

		} else {
			String name = EMV2Util.getDirectionName(namedElement);
			if (!name.isEmpty()) {
				identifier += "-" + name;
			}
		}
		if (type != null) {
			identifier += "-" + EMV2Util.getName(type);
		}
		identifier = identifier.replaceAll("\\{", "").replaceAll("\\}", "").toLowerCase();
		return identifier;
	}

	public static String buildName(ComponentInstance component, NamedElement namedElement, TypeToken type) {
		String identifier;
		if (component == null) {
			return "Null Component Reference";
		}

		identifier = component instanceof SystemInstance
				? component.getComponentClassifier().getQualifiedName().replaceAll("::", "_").replaceAll("\\.", "_")
				: component.getComponentInstancePath();

		if (namedElement == null) {
			identifier += "-unidentified";
		} else {
			String name = EMV2Util.getDirectionName(namedElement);
			if (!name.isEmpty()) {
				identifier += "-" + name;
			}
		}

		if (type != null) {
			identifier += "-" + EMV2Util.getName(type);
		}
		identifier = identifier.replaceAll("\\{", "").replaceAll("\\}", "").toLowerCase();
		return identifier;
	}

	private static void redoCount(FaultTree ftaModel) {
		for (Event ev : ftaModel.getEvents()) {
			ev.setReferenceCount(0);
		}
		doCount(ftaModel.getRoot());
	}

	private static void doCount(Event ev) {
		ev.setReferenceCount(ev.getReferenceCount() + 1);
		for (Event subev : ev.getSubEvents()) {
			doCount(subev);
		}
	}

	public static void removeEventOrphans(FaultTree ftaModel) {
		redoCount(ftaModel);
		List<Event> toRemove = new LinkedList<Event>();
		for (Event ev : ftaModel.getEvents()) {
			if (ev.getReferenceCount() == 0) {
				toRemove.add(ev);
			}
		}
		ftaModel.getEvents().removeAll(toRemove);
	}

	public static boolean hasSharedEvents(FaultTree ftaModel) {
		for (Event ev : ftaModel.getEvents()) {
			if (isASharedEvent(ev)) {
				return true;
			}
		}
		return false;
	}

	public static boolean isASharedEvent(Event event) {
		return event.getReferenceCount() > 1;
	}

	/**
	 * create a BASIC event with the specified component, error model element, and type name
	 * @param component
	 * @param namedElement
	 * @param type
	 * @return Event
	 */
	public static Event createBasicEvent(FaultTree ftaModel, ComponentInstance component, NamedElement namedElement,
			TypeToken type) {
		String name = buildName(component, namedElement, type);
		Event result = findEvent(ftaModel, name);
		if (result != null) {
			return result;
		}
		Event newEvent = FaultTreeFactory.eINSTANCE.createEvent();
		ftaModel.getEvents().add(newEvent);
		newEvent.setName(name);
		newEvent.setType(EventType.BASIC);
		newEvent.setRelatedInstanceObject(component);
		newEvent.setRelatedEMV2Object(namedElement);
		newEvent.setRelatedErrorType(type);
		return newEvent;
	}

	public static void addBasicEvent(Event parent, ComponentInstance component, NamedElement namedElement,
			TypeToken type) {
		Event newEvent = createBasicEvent((FaultTree) parent.eContainer(), component, namedElement, type);
		parent.getSubEvents().add(newEvent);
	}

	public static Event createBasicEvent(FaultTree ftaModel, ConnectionInstance conni, NamedElement namedElement,
			TypeToken type) {
		String name = buildName(conni, namedElement, type);
		Event result = findEvent(ftaModel, name);
		if (result != null) {
			return result;
		}
		Event newEvent = FaultTreeFactory.eINSTANCE.createEvent();
		ftaModel.getEvents().add(newEvent);
		newEvent.setName(name);
		newEvent.setType(EventType.BASIC);
		newEvent.setRelatedInstanceObject(conni);
		newEvent.setRelatedEMV2Object(namedElement);
		newEvent.setRelatedErrorType(type);
		return newEvent;
	}

	public static void addBasicEvent(Event parent, ConnectionInstance conni, NamedElement namedElement,
			TypeToken type) {
		Event newEvent = createBasicEvent((FaultTree) parent.eContainer(), conni, namedElement, type);
		parent.getSubEvents().add(newEvent);
	}

	/**
	 * create a INTERMEDIATE event with the specified component, error model element, and type name
	 * @param component
	 * @param namedElement
	 * @param type
	 * @return Event
	 */
	public static Event createIntermediateEvent(FaultTree ftaModel, ComponentInstance component, EObject element,
			TypeToken type) {
		return createIntermediateEvent(ftaModel, component, element, type, false);
	}

	public static Event createUniqueIntermediateEvent(FaultTree ftaModel, ComponentInstance component, EObject element,
			TypeToken type) {
		return createIntermediateEvent(ftaModel, component, element, type, true);
	}

	/**
	 * create a generic intermediate Event
	 * @return
	 */
	private static int count = 1;

	public static void resetIntermediateEventCount() {
		count = 1;
	}

	private static Event createIntermediateEvent(FaultTree ftaModel, ComponentInstance component, EObject element,
			TypeToken type, boolean unique) {
		String name;
		if (element instanceof NamedElement && !unique && ((NamedElement) element).getName() != null) {
			name = buildName(component, (NamedElement) element, type);
			Event result = findEvent(ftaModel, name);
			if (result != null && result.getType() == EventType.INTERMEDIATE) {
				return result;
			}
		} else {
			name = "Intermediate" + count++;
		}
		Event newEvent = FaultTreeFactory.eINSTANCE.createEvent();
		ftaModel.getEvents().add(newEvent);
		newEvent.setName(name);
		newEvent.setType(EventType.INTERMEDIATE);
		newEvent.setRelatedInstanceObject(component);
		newEvent.setRelatedEMV2Object(element);
		newEvent.setRelatedErrorType(type);
		return newEvent;
	}

	public static Event findEvent(FaultTree ftaModel, String eventName) {
		for (Event event : ftaModel.getEvents()) {
			if (event.getName().equalsIgnoreCase(eventName)) {
				return event;
			}
		}
		return null;
	}

	public static Event findSharedSubtree(FaultTree ftaModel, List<EObject> subEvents, LogicOperation optype,
			ComponentInstance component, Element ne, TypeToken type) {
		for (Event event : ftaModel.getEvents()) {
			if (event.getRelatedInstanceObject() == component && event.getRelatedEMV2Object() == ne
					&& event.getRelatedErrorType() == type) {
				if (!event.getSubEvents().isEmpty() && event.getSubEventLogic() == optype
						&& event.getSubEvents().size() == subEvents.size()
						&& subEvents.containsAll(event.getSubEvents())) {
					return event;
				}
			}
		}
		return null;
	}

	public static List<Event> copy(FaultTree ftaModel, List<Event> alts) {
		LinkedList<Event> altscopy = new LinkedList<Event>();
		for (Event alt : alts) {
			Event newalt = EcoreUtil.copy(alt);
			altscopy.add(newalt);
			ftaModel.getEvents().add(newalt);
		}
		return altscopy;
	}

	public static boolean sameEvent(Event e1, Event e2) {
		return e1.getName().equalsIgnoreCase(e2.getName());
	}

	public static void fillProbability(Event event) {
		if (!(event.getRelatedEMV2Object() instanceof NamedElement)) {
			return;
		}
		InstanceObject io = (InstanceObject) event.getRelatedInstanceObject();
		NamedElement ne = (NamedElement) event.getRelatedEMV2Object();
		TypeToken type = (TypeToken) event.getRelatedErrorType();
		event.setAssignedProbability(
				new BigDecimal(EMV2Properties.getProbability(io, ne, type), MathContext.UNLIMITED));
	}

	public static String getName(ComponentInstance component) {
		return (component instanceof SystemInstance ? component.getComponentClassifier().getName()
				: component.getComponentInstancePath());
	}

	public static String getDescription(Event event) {
		return getInstanceDescription(event) + " " + getEMV2ElementDescription(event);
	}

	public static String getEventDescription(Event event) {
		return getInstanceDescription(event);
	}

	public static String getErrorDescription(Event event) {
		return getEMV2ElementDescription(event);
	}

	public static String getInstanceDescription(Event event) {
		InstanceObject io = (InstanceObject) event.getRelatedInstanceObject();
		String description = "";
		if (io instanceof ComponentInstance) {
			description = "'" + getName((ComponentInstance) io) + "'";
		} else if (io instanceof ConnectionInstance) {
			description = "Connection '" + ((ConnectionInstance) io).getName() + "'";
		}
		EObject errorModelArtifact = event.getRelatedEMV2Object();
		if (errorModelArtifact instanceof ErrorSource) {
			ErrorSource errorSource = (ErrorSource) errorModelArtifact;
			description += " source '" + EMV2Util.getName(errorSource) + "'";
		}
		if (errorModelArtifact instanceof ErrorEvent) {
			ErrorEvent errorSource = (ErrorEvent) errorModelArtifact;
			description += " event '" + EMV2Util.getName(errorSource) + "'";
		}
		if (errorModelArtifact instanceof ErrorPropagation) {
			ErrorPropagation ep = (ErrorPropagation) errorModelArtifact;
			String directionLabel = ep.getDirection() == DirectionType.IN ? " incoming " : " outgoing ";
			description += directionLabel + "'" + EMV2Util.getName(ep) + "'";
		}
		return description;
	}

	public static String getEMV2ElementDescription(Event event) { // JH looks like the code to do the boxes in FTA
		EObject errorModelArtifact = event.getRelatedEMV2Object();
		TypeToken type = (TypeToken) event.getRelatedErrorType();
		String description;
		description = "";
		if (errorModelArtifact instanceof ErrorSource) {
			ErrorSource errorSource = (ErrorSource) errorModelArtifact;
			description = (type != null ? "{" + EMV2Util.getName(type) + "} from " : "") + "error source '"
					+ EMV2Util.getName(errorSource) + "'";
		}

		if (errorModelArtifact instanceof ErrorEvent) {
			ErrorEvent ee = (ErrorEvent) errorModelArtifact;
			if (type != null) {
				description += "{" + EMV2Util.getName(type) + "} from ";
			}
			description += "error event '" + EMV2Util.getName(ee) + "'";
		}

		if (errorModelArtifact instanceof ErrorBehaviorState) {
			if (type != null) {
				description += "{" + EMV2Util.getName(type) + "} from ";
			}
			description += "error state '" + ((ErrorBehaviorState) errorModelArtifact).getName() + "'";
		}

		if (errorModelArtifact instanceof ErrorPropagation) {
			String boundaryLabel = "";
			if (event.getType() == EventType.EXTERNAL) {
				boundaryLabel = "external";
			} else if (event.getType() == EventType.UNDEVELOPED) {
				boundaryLabel = "undeveloped";
			}
			if (type != null) {
				description = "{" + EMV2Util.getName(type) + "}";
				if (!boundaryLabel.isEmpty()) {
					description += " from " + boundaryLabel;
				}
			} else {
				description = boundaryLabel;
			}
		}

		if (errorModelArtifact instanceof ConditionExpression) {
			// TODO

			errorModelArtifact = EMV2Util.getConditionExpressionContext(errorModelArtifact);
			String opcontext = "";
			if (type instanceof TypeSet) {
				opcontext = " on type set " + EMV2Util.getPrintName((TypeSet) type);
			} else if (errorModelArtifact instanceof ErrorBehaviorTransition) {
				String branch = ((ErrorBehaviorTransition) errorModelArtifact).getDestinationBranches().isEmpty() ? ""
						: "branch ";
				opcontext = " in transition " + branch + EMV2Util.getName(errorModelArtifact);
			} else if (errorModelArtifact instanceof OutgoingPropagationCondition) {
				opcontext = " in outgoing propagation condition " + EMV2Util.getName(errorModelArtifact);
			} else if (errorModelArtifact instanceof ErrorDetection) {
				opcontext = " in error detection " + EMV2Util.getName(errorModelArtifact);
			} else if (errorModelArtifact instanceof CompositeState) {
				opcontext = " in composite state " + EMV2Util.getName(errorModelArtifact);
			}

			if (event.getSubEventLogic() == LogicOperation.KORMORE) {
				description = "'" + event.getSubEventLogic() + "' with k =" + event.getK() + opcontext;
			} else {
				description = "'" + event.getSubEventLogic() + "'" + opcontext;
			}
		}

		return description;
	}

	public static BigDecimal BigZero = new BigDecimal(0.0);
	public static BigDecimal BigOne = new BigDecimal(1.0);

	/**
	 * return computed & spec probability - if computed is zero then only spec.
	 * @param context
	 * @return
	 */
	public static String getProbability(EObject context) {
		Event ev = (Event) context;
		String specProb = "";
		if (ev.getComputedProbability() != null && ev.getComputedProbability().compareTo(BigZero) != 0
				&& ev.getAssignedProbability() != null && ev.getAssignedProbability().compareTo(BigZero) != 0) {
			specProb = String.format(" (Spec %1$.1e)", ev.getAssignedProbability());
		}
		return String.format("%1$.1e%2$s", ev.getProbability(), specProb) + getScale(context);
	}

	/**
	 * return spec probability, i.e., probability assigned by property
	 * @param context
	 * @return
	 */
	public static String getAssignedProbability(EObject context) {
		Event ev = (Event) context;
		if (ev.getAssignedProbability() == null || ev.getAssignedProbability().compareTo(BigZero) == 0) {
			return "";
		}
		return String.format("%1$.1e", ev.getAssignedProbability()) + getScale(context);
	}

	/**
	 * return computed probability
	 * @param context
	 * @return
	 */
	public static String getComputedProbability(EObject context) {
		Event ev = (Event) context;
		if (ev.getComputedProbability() == null || ev.getComputedProbability().compareTo(BigZero) == 0) {
			return "";
		}
		return String.format("%1$.1e", ev.getComputedProbability()) + getScale(context);
	}

	// return scaling factor if different from 1.0, otherwise empty string
	public static String getScale(EObject context) {
		Event ev = (Event) context;
		if (ev.getScale() == null || ev.getScale().compareTo(BigOne) == 0) {
			return "";
		}
		return String.format(" * %1$.1f", ev.getScale());
	}

	public static String getDescriptionAndProbability(EObject context) {
		if (context instanceof Event) {
			Event ev = (Event) context;
			FaultTree ft = (FaultTree) ev.eContainer();
			String labeltext = ft.getFaultTreeType().equals(FaultTreeType.MINIMAL_CUT_SET)
					? FaultTreeUtils.getCutsetLabel(ev)
					: FaultTreeUtils.getInstanceDescription(ev);
			if (labeltext == null || labeltext.isEmpty()) {
				labeltext = ev.getName();
			}
			String emv2label = FaultTreeUtils.getEMV2ElementDescription(ev);
			String ftmsg = ft.getMessage();
			if (ftmsg != null) {
				return "ERROR: " + ftmsg + "\n" + labeltext;
			}
//			String msg = ev.getMessage() != null ? "NOTE: " + ev.getMessage() : " ";
//			String fullText = String.format("%1$s\n%2$s\n%4$s(%3$.3E)", labeltext, emv2label, val, msg);
			String fullText = String.format("%1$s \n%2$s \n%3$s", labeltext, emv2label, getProbability(ev));
			if (ev == ft.getRoot()) {
				// mark probability with star if shared events are involved
				if (FaultTreeUtils.hasSharedEvents(ft)) {
					return fullText + "*";
				} else {
					return fullText;
				}
			} else if (isASharedEvent(ev)) {
				return "*" + fullText;
			} else {
				return fullText;
			}
		}
		return "";
	}

	public static String getCutsetLabel(EObject context) {
		Event event = (Event) context;
		FaultTree ft = (FaultTree) event.eContainer();
		if (ft.getRoot().getSubEvents().contains(event)) {
			return event.getName();
		}
		return FaultTreeUtils.getDescription((Event) context);
	}

	public static String getHazardDescription(EObject context) {
		if (context instanceof Event) {
			Event ev = (Event) context;
			String hazardDescription = EMV2Properties.getHazardDescription(
					(InstanceObject) ev.getRelatedInstanceObject(), (NamedElement) ev.getRelatedEMV2Object(),
					(ErrorTypes) ev.getRelatedErrorType());
			return hazardDescription;
		}
		return "";
	}

	public static String getHazardDescriptionAndProbability(EObject context) {
		if (context instanceof Event) {
			Event ev = (Event) context;
			FaultTree ft = (FaultTree) ev.eContainer();
			String hazardDescription = EMV2Properties.getHazardDescription(
					(InstanceObject) ev.getRelatedInstanceObject(), (NamedElement) ev.getRelatedEMV2Object(),
					(ErrorTypes) ev.getRelatedErrorType());
			String labeltext = FaultTreeUtils.getDescription(ev);
			if (labeltext == null || labeltext.isEmpty()) {
				labeltext = ((Event) context).getName();
			}
			String msg = ev.getMessage() != null ? "\nMessage: " + ev.getMessage() : "";
			String problabel = "";
			if (isASharedEvent(ev)) {
				labeltext = "Dependent event: " + labeltext;
			} else if (ev == ft.getRoot()) {
				// mark probability with star if shared events are involved
				if (FaultTreeUtils.hasSharedEvents(ft)) {
					problabel = " (incl. dependent event probabilities)";
				}
			}

			if (hazardDescription == null) {
				return String.format("%1$s%4$s\nOccurrence probability %2$s%3$s", labeltext, getProbability(ev),
						problabel, msg);
			} else {
				return String.format("%1$s\n%3$s%5$s\nOccurrence probability %2$s%4$s", labeltext, getProbability(ev),
						"Hazard: " + hazardDescription, problabel, msg);
			}
		}
		return "";
	}

	/**
	 * return sum of probabilities of direct subevents.
	 * @param event
	 * @return double
	 */
	public static BigDecimal getSubeventProbabilities(Event event) {
		if (!event.getSubEvents().isEmpty()) {
			switch (event.getSubEventLogic()) {
			case AND: {
				return pANDEvents(event);
			}
			case PRIORITY_AND: {
				// TODO need to adjust for ordered events
				return pANDEvents(event);
			}
			case XOR: {
				// P(1of(A,B,..) = SUM (PEi)*P(Ek k <>i k in 1..n)
				return p1OFEvents(event);
			}
			case OR: {
				return pOREvents(event);
			}
			case KORMORE: {
				return pORMOREEvents(event);
			}

			default: {
				System.out.println("[Utils] Unsupported operator for now: " + event.getSubEventLogic());
				return BigOne;
			}
			}
		} else {
			return getScaledProbability(event);
		}
	}

	public static BigDecimal pOREvents(Event event) {
		// From equation (VI-17) from NRC guide, Fault Tree Handbook NUREG-0492
		// P (E1 or E2 or E3 .. En) = 1 - ( (1-P(E1)) * (1-P(E2)) * (1-P(E3)) * ... * (1-P(En)) )

		BigDecimal inverseProb = BigOne;
		for (Event subEvent : event.getSubEvents()) {
			inverseProb = inverseProb.multiply((BigOne.subtract(getScaledProbability(subEvent))));
		}
		return BigOne.subtract(inverseProb);
	}

	public static BigDecimal pORMOREEvents(Event event) {
		// For this computation, we use the algorithm presented in
		// "Computing k-out-of-n System Reliability", by R. E. Barlow and K. D. Heidtmann
		// in IEEE Transactions on Reliability, Vol R-33, No 4, October 1984
		//
		// The general intuition of this algorithm goes as follows, using LaTex notation for the equations
		// Conventions:
		// $q_i$ is the failure rate of component i
		// $p_i$ is the reliability rate of component i, $p_i = 1 - q_i$
		// Re(k, n) is the probability that there are exactly k working components out of n
		//
		// Borderline cases as managed by the following conventions:
		// $\forall j \in \{1 .. n\}, Re(-1, j) = Re(j+1, j) = 0$
		// $Re(0, 0) = 0$
		//
		// Barlow and Heidtmann propose the following generating function
		//
		// g(z)=\prod_{i=1}^n (q_i + p_i z)
		//
		// By recurrence, one can establish that $g(z)=\prod_{i=1}^n (q_i + p_i z)=\sum_{i=0}^ n Re(i,n) z^i$
		// using $Re(i,j) = q_j * Re(i, j - 1) + p_j * Re(i-1, j-1)$.
		//
		// It follows that computing $Re(k, n)$ for some $k \leq n$ is equivalent to computing the k-th element in the polynom
		// g (z) = \sum_{i=0}^ n g_i z^i$ and perform term identification

		// For simplicity, we implement PROGRAM 1
		// Note: to match the original algorithm, we start with index at 1, up-to index n + 1

		int n = event.getSubEvents().size();
		BigDecimal[] probabilities = new BigDecimal[n + 2];
		Arrays.fill(probabilities, BigDecimal.ZERO);

		BigDecimal[] A = new BigDecimal[n + 2];
		Arrays.fill(A, BigDecimal.ZERO);

		A[1] = BigOne;

		int k = 1;
		for (Event subEvent : event.getSubEvents()) {
			probabilities[k] = BigOne.subtract(getScaledProbability(subEvent));
			k++;
		}

		for (int j = 1; j <= n; j++) {
			for (int i = j + 1; i >= 1; i--) {
				// At each step, we perform A(i) = A(i) + P(j) * (A(i - 1) - A(i))
				A[i] = A[i].add(probabilities[j].multiply(A[i - 1].subtract(A[i])));
			}
		}

		// The associated failure probability of k or more is $1 - \Sum_{j=k}^n Re(j, n)$
		BigDecimal R = BigZero;

		for (int j = event.getK() + 1; j <= n + 1; j++) {
			R = R.add(A[j]);
		}

		R = BigOne.subtract(R);
		return R;
	}

	public static BigDecimal pANDEvents(Event event) {
		BigDecimal result = BigOne;
		for (Event subEvent : event.getSubEvents()) {
			result = result.multiply(getScaledProbability(subEvent));
		}
		return result;
	}

	// Sum P(Xi)*P(!Xk) for k <> i k in 1..n
	public static BigDecimal p1OFEvents(Event event) {
		BigDecimal result = BigZero;
		for (Event subEvent : event.getSubEvents()) {
			BigDecimal subresult = BigOne;
			for (Event notEvent : event.getSubEvents()) {
				if (subEvent == notEvent) {
					subresult = subresult.multiply(getScaledProbability(subEvent));
				} else {
					subresult = subresult.multiply((BigOne.subtract(getScaledProbability(subEvent))));
				}
			}
			result = result.add(subresult);
		}
		return result;
	}

	public static BigDecimal getScaledProbability(Event event) {
		return event.getProbability().multiply(event.getScale());
	}

	public static void fillProbabilities(FaultTree ftaModel) {
		for (Event event : ftaModel.getEvents()) {
			EObject element = event.getRelatedEMV2Object();
			if (element instanceof NamedElement) {
				FaultTreeUtils.fillProbability(event);
			}
		}

	}

	public static void computeProbabilities(Event event) {
		if (!event.getSubEvents().isEmpty()) {
			for (Event e : event.getSubEvents()) {
				computeProbabilities(e);
			}
			BigDecimal subtotalprobability = getSubeventProbabilities(event);
			event.setComputedProbability(subtotalprobability);
		}
	}
}
