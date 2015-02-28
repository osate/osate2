package org.osate.aadl2.errormodel.analysis.cma;

import java.util.ArrayList;
import java.util.List;

import org.osate.aadl2.instance.ComponentInstance;

public class CMAReportEntry {
	private String source;
	private String mode;
	private String justification;
	private EntryType type;
	private String severity;
	private String cause;
	private List<ComponentInstance> relatedComponents;

	public enum EntryType {
		NONE, SPECIFICATION, ARCHITECTURE_DESIGN, INSTALLATION, OPERATION, ENVIRONMENTAL_FACTOR, FAULT
	};

	public CMAReportEntry() {
		source = null;
		mode = null;
		justification = null;
		type = EntryType.NONE;
		severity = "none";
		cause = "unknwon";
		relatedComponents = new ArrayList<ComponentInstance>();

	}

	public void setSeverity(String s) {
		severity = s;
	}

	public String getSeverity() {
		return severity;
	}

	public String getCause() {
		return cause;
	}

	public String getComponentsString() {
		String componentsString;
		componentsString = "";

		for (ComponentInstance ci : relatedComponents) {
			componentsString += ci.getName() + "(" + ci.getCategory().getName() + ") ";
		}

		return componentsString;
	}

	public List<ComponentInstance> getRelatedComponents() {
		return relatedComponents;
	}

	public void addRelatedComponent(ComponentInstance ci) {
		relatedComponents.add(ci);
	}

	public void setSource(String s) {
		source = s;
	}

	public void setMode(String m) {
		mode = m;
	}

	public void setJustification(String j) {
		justification = j;
	}

	public String getJustification() {
		return justification;
	}

	public String getMode() {
		return mode;
	}

	public String getSource() {
		return source;
	}

	public void setType(EntryType t) {
		type = t;
	}

	public EntryType getType() {
		return type;
	}

	public static String typeToString(EntryType type) {
		String typeString = "unknown entry type";

		switch (type) {
		case SPECIFICATION: {
			typeString = "specification";
			break;
		}

		case ARCHITECTURE_DESIGN: {
			typeString = "architecture design";
			break;
		}

		case INSTALLATION: {
			typeString = "installation";
			break;
		}

		case OPERATION: {
			typeString = "operation";
			break;
		}

		case FAULT: {
			typeString = "fault";
			break;
		}

		case ENVIRONMENTAL_FACTOR: {
			typeString = "specification";
			break;
		}
		}

		return typeString;

	}

	public String getTypeString() {
		return typeToString(type);
	}

	public boolean equalsTo(Object o) {
		if (o instanceof CMAReportEntry) {
			CMAReportEntry other = (CMAReportEntry) o;
			return (relatedComponents.containsAll(other.getRelatedComponents())
					&& mode.equalsIgnoreCase(other.getMode()) && source.equalsIgnoreCase(other.getSource()));
		}

		return false;

	}
}
