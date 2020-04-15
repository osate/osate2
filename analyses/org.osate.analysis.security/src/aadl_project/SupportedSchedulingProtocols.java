package aadl_project;

import org.osate.aadl2.AbstractNamedValue;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.PropertyExpression;

public enum SupportedSchedulingProtocols {
	STATIC("Static"),
	ROUND_ROBIN_PROTOCOL("Round_Robin_Protocol"),
	POSIX_1003_HIGHEST_PRIORITY_FIRST_PROTOCOL("POSIX_1003_HIGHEST_PRIORITY_FIRST_PROTOCOL"),
	FIXEDTIMELINE("FixedTimeline"),
	COOPERATIVE("Cooperative"),
	RMS("RMS"),
	DMS("DMS"),
	EDF("EDF"),
	SPORADICSERVER("SporadicServer"),
	SLACKSERVER("SlackServer"),
	ARINC653("ARINC653");
	
	private final String originalName;
	
	private SupportedSchedulingProtocols(String originalName) {
		this.originalName = originalName;
	}
	
	public static SupportedSchedulingProtocols valueOf(PropertyExpression propertyExpression) {
		AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
		return valueOf(((EnumerationLiteral) abstractNamedValue).getName().toUpperCase());
	}
	
	@Override
	public String toString() {
		return originalName;
	}
}
