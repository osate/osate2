package aadl_project;

import org.osate.aadl2.AbstractNamedValue;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.PropertyExpression;

public enum SupportedConnectionPatterns {
	ONE_TO_ONE("One_To_One"),
	ALL_TO_ALL("All_To_All"),
	ONE_TO_ALL("One_To_All"),
	ALL_TO_ONE("All_To_One"),
	NEXT("Next"),
	PREVIOUS("Previous"),
	CYCLIC_NEXT("Cyclic_Next"),
	CYCLIC_PREVIOUS("Cyclic_Previous"),
	ODD_TO_ODD("Odd_To_Odd"),
	EVEN_TO_EVEN("Even_To_Even"),
	NEXT_NEXT("Next_Next"),
	CYCLIC_NEXT_NEXT("Cyclic_Next_Next"),
	PREVIOUS_PREVIOUS("Previous_Previous"),
	CYCLIC_PREVIOUS_PREVIOUS("Cyclic_Previous_Previous");
	
	private final String originalName;
	
	private SupportedConnectionPatterns(String originalName) {
		this.originalName = originalName;
	}
	
	public static SupportedConnectionPatterns valueOf(PropertyExpression propertyExpression) {
		AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
		return valueOf(((EnumerationLiteral) abstractNamedValue).getName().toUpperCase());
	}
	
	@Override
	public String toString() {
		return originalName;
	}
}
