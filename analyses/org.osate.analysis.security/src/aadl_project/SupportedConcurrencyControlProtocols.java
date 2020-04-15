package aadl_project;

import org.osate.aadl2.AbstractNamedValue;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.PropertyExpression;

public enum SupportedConcurrencyControlProtocols {
	NONE_SPECIFIED("None_Specified"),
	INTERRUPT_MASKING("Interrupt_Masking"),
	MAXIMUM_PRIORITY("Maximum_Priority"),
	PRIORITY_INHERITANCE("Priority_Inheritance"),
	PRIORITY_CEILING("Priority_Ceiling"),
	SPIN_LOCK("Spin_Lock"),
	SEMAPHORE("Semaphore"),
	PROTECTED_ACCESS("Protected_Access");
	
	private final String originalName;
	
	private SupportedConcurrencyControlProtocols(String originalName) {
		this.originalName = originalName;
	}
	
	public static SupportedConcurrencyControlProtocols valueOf(PropertyExpression propertyExpression) {
		AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
		return valueOf(((EnumerationLiteral) abstractNamedValue).getName().toUpperCase());
	}
	
	@Override
	public String toString() {
		return originalName;
	}
}
