package org.osate.aadl2.errormodel.analysis.fta;

import java.util.ArrayList;
import java.util.List;

public class Event {
	protected String name;
	protected String description;
	protected double probability;
	protected List<Event> subEvents;
	protected boolean showProbability;
	protected EventType type;
	private static int generalId;
	protected String identifier;
	protected Event parent;

	public static void init() {
		generalId = 0;
	}

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
