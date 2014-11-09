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
		this.severity = s;
	}

	public String getSeverity() {
		return this.severity;
	}

	public String getCause() {
		return this.cause;
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
		return this.relatedComponents;
	}

	public void addRelatedComponent(ComponentInstance ci) {
		this.relatedComponents.add(ci);
	}

	public void setSource(String s) {
		this.source = s;
	}

	public void setMode(String m) {
		this.mode = m;
	}

	public void setJustification(String j) {
		this.justification = j;
	}

	public String getJustification() {
		return this.justification;
	}

	public String getMode() {
		return this.mode;
	}

	public String getSource() {
		return this.source;
	}

	public void setType(EntryType t) {
		this.type = t;
	}

	public EntryType getType() {
		return this.type;
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
		return typeToString(this.type);
	}

	public boolean equalsTo(Object o) {
		if (o instanceof CMAReportEntry) {
			CMAReportEntry other = (CMAReportEntry) o;
			return (this.relatedComponents.containsAll(other.getRelatedComponents())
					&& this.mode.equalsIgnoreCase(other.getMode()) && this.source.equalsIgnoreCase(other.getSource()));
		}

		return false;

	}
}
