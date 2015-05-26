package org.osate.aadl2.errormodel.analysis.fta;

import java.util.ArrayList;
import java.util.List;

import edu.cmu.emfta.EmftaFactory;
import edu.cmu.emfta.GateType;

public class Event {
	private String name;
	private String description;
	private double probability;
	private List<Event> subEvents;
	private boolean showProbability;
	private EventType type;
	private static int generalId = 1;
	private String identifier;
	private Event parent;

	public Event() {
		identifier = "event" + generalId;
		name = identifier;
		description = null;
		probability = 0.0;
		showProbability = false;
		type = EventType.NORMAL;
		parent = null;
		subEvents = new ArrayList<Event>();
		generalId++;
	}

	public Event getParent() {
		return parent;
	}

	public void setParent(Event ev) {
		parent = ev;
	}

	public EventType getType() {
		return type;
	}

	public EventType getEventType() {
		return type;
	}

	public void setEventType(EventType et) {
		type = et;
	}

	public String getName() {
		return name;
	}

	public void showProbability(boolean b) {
		showProbability = b;
	}

	public String getDescription() {
		return description;
	}

	public double getProbability() {
		return probability;
	}

	public void setIdentifier(String n) {
		identifier = n.replace(' ', '_');
	}

	public String getIdentifier() {
		String suffix;
		switch (type) {
		case AND: {
			suffix = "_a";
			break;
		}
		case OR: {
			suffix = "_o";
			break;
		}
		default: {
			suffix = "_d";
			break;
		}
		}
		return identifier + suffix;

	}

	public void setName(String n) {
		name = n;
	}

	public void setDescription(String d) {
		description = d;
	}

	public void setProbability(double p) {
		probability = p;
		showProbability = true;
	}

	public List<Event> getSubEvents() {
		return subEvents;
	}

	public void addSubEvent(Event e) {
		e.setParent(this);
		subEvents.add(e);
	}

	public String toEMFTA() {
		StringBuffer sb;

		sb = new StringBuffer();

		return sb.toString();
	}

	public edu.cmu.emfta.Event toEmftaEvent() {
		edu.cmu.emfta.Event emftaEvent;
		emftaEvent = EmftaFactory.eINSTANCE.createEvent();
		emftaEvent.setName(this.name);
		emftaEvent.setDescription(this.description);
		emftaEvent.setProbability(this.probability);

		return emftaEvent;
	}

	public edu.cmu.emfta.Gate toEmftaGate() {
		edu.cmu.emfta.Gate emftaGate;
		emftaGate = EmftaFactory.eINSTANCE.createGate();

		if (this.type == EventType.AND) {
			emftaGate.setType(GateType.AND);
		}

		if (this.type == EventType.OR) {
			emftaGate.setType(GateType.OR);
		}

		for (Event e : this.getSubEvents()) {
			if ((e.getEventType() == EventType.EVENT) || (e.getEventType() == EventType.NORMAL)) {
				emftaGate.getEvents().add(e.toEmftaEvent());
			}

			if ((e.getEventType() == EventType.AND) || (e.getEventType() == EventType.OR)) {
				emftaGate.getGates().add(e.toEmftaGate());
			}
		}
		return emftaGate;
	}

	public edu.cmu.emfta.Tree toEmftaTree() {
		edu.cmu.emfta.Tree emftaTree;
		emftaTree = EmftaFactory.eINSTANCE.createTree();
		emftaTree.setName(this.name);
		emftaTree.setDescription(this.description);

		emftaTree.setGate(this.subEvents.get(0).toEmftaGate());
		return emftaTree;
	}

	public edu.cmu.emfta.FTAModel toEmftaModel() {
		edu.cmu.emfta.FTAModel emftaModel;
		emftaModel = EmftaFactory.eINSTANCE.createFTAModel();
		emftaModel.setName(this.name);
		emftaModel.setDescription(this.description);
		emftaModel.setRoot(this.toEmftaTree());

		return emftaModel;
	}

	public String toXML() {
		StringBuffer sb;

		sb = new StringBuffer();

		sb.append("<event");
		if (type == EventType.NORMAL) {
			sb.append(" id=\"" + name + "\" ");
		} else {
			sb.append(" id=\"" + getIdentifier() + "\" ");
		}

		if (probability != 0.0) {
			sb.append(" probability=\"" + probability + "\"");
		}

		if (type != EventType.NORMAL) {
			sb.append(" type=\"" + EventType.toString(type) + "\"");
		}
		if (description != null) {
			sb.append(" description=" + description);
		}
		sb.append(">");

		sb.append("\n");
		for (Event e : subEvents) {
			sb.append(e.toXML());
		}
		sb.append("</event>");
		sb.append("\n");

		return sb.toString();
	}

	public String toPED() {
		double prob;
		String description;

		StringBuffer sb = new StringBuffer();

		if (type == EventType.EVENT) {
			prob = getProbability();
			/**
			 * A probability of 0 makes the whole thing crash.
			 * So, we put a default prob of 0.1
			 */
			if (prob == 0) {
				prob = 0.1;
			}
			if (getDescription() != null) {
				description = getDescription();
			} else {
				description = name + "(no extended description)";
			}
			sb.append(identifier + ";;B;" + description + ";" + prob + ";L;\n");
			return sb.toString();
		}

		for (Event e : subEvents) {
			sb.append(e.toPED());
		}
		return sb.toString();
	}

	public String toFTA() {
		StringBuffer sb;

		sb = new StringBuffer();
		String title = "";
		if (type == EventType.EVENT) {
//			String tmp = this.name;
//			tmp = tmp.replace(' ', '_');
//			tmp = tmp.replace('/', '-');
//			tmp = tmp.replace('(', '-');
//			tmp = tmp.replace(')', '-');
//			tmp = tmp.replace("__", "_");
//
//			tmp = tmp.toLowerCase();
			sb.append("B " + identifier + " 0\n");
			return sb.toString();
		}

		if ((type == EventType.NORMAL)
				|| ((parent != null) && (type == EventType.AND) && (parent.getType() == EventType.AND))
				|| ((parent != null) && (type == EventType.AND) && (parent.getType() == EventType.OR))
				|| ((parent != null) && (type == EventType.OR) && (parent.getType() == EventType.AND))
				|| ((parent != null) && (type == EventType.OR) && (parent.getType() == EventType.OR))) {
			sb.append("M " + identifier);

			if (type == EventType.NORMAL) {
				if (subEvents.size() > 0) {
					sb.append(" " + subEvents.size() + "\n");
				} else {
					sb.append(" 1\n");
				}
			} else {
				sb.append(" 1\n");
			}

			title = name;

			if (getDescription() != null) {
				title = getDescription();
			}

			sb.append("" + title.length() + " " + title + "\n");

			/**
			 * If a state does not have subevents, we add a diamond in the FTA to show
			 * that it does not have other contributors. This makes the FTA complete.
			 * It has been suggestion by Bill Fletecher from the SAE S18 group.
			 */
			if ((type == EventType.NORMAL) && (subEvents.size() == 0)) {
				sb.append("U NULL 0\n");
			}
		}

		switch (type) {
		case AND: {
			sb.append("A " + identifier + " " + subEvents.size() + "\n");
			break;
		}
		case OR: {
			sb.append("O " + identifier + " " + subEvents.size() + "\n");
			break;
		}
		default: {
			break;
		}

		}

		for (Event e : subEvents) {
			sb.append(e.toFTA());
		}

		return sb.toString();
	}

}
