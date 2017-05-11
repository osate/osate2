package org.osate.ge.internal.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import org.osate.aadl2.Property;
import org.osate.ge.internal.util.PropertyResult;

/**
 * Represents a value provided by a property result. 
 */
public class PropertyResultValue {
	private Property property;
	private Object appliedToBo; // The business object to which the property is applied.
	private PropertyResult propertyResult; // Property result from which the value was retrieved
	private Object value; // A value from the property result. May be null. In that case the property value returns the null reason.
	private List<Integer> arrayIndices; // Zero-based indices of the value if the property result contains a list and this object refers to a single element.
	
	/**
	 * @param arrayIndices array indices for the value. This class will make a copy of the array.
	 */
	public PropertyResultValue(final Property property, 
			final Object appliedToBo,
			final PropertyResult propertyResult, 
			final Object value, 
			final Collection<Integer> arrayIndices) {
		this.property = Objects.requireNonNull(property, "property must not be null");
		this.appliedToBo = Objects.requireNonNull(appliedToBo, "appliedToBo must not be null");
		this.propertyResult = Objects.requireNonNull(propertyResult, "propertyResult must not be null");
		this.value = value;
		this.arrayIndices = arrayIndices == null ? Collections.emptyList() : Collections.unmodifiableList(Arrays.asList(arrayIndices.toArray(new Integer[arrayIndices.size()])));		
	}
	
	public final Property getProperty() {
		return property;
	}
	
	public final Object getAppliedToBo() {
		return appliedToBo;
	}
	
	public final PropertyResult getPropertyResult() {
		return propertyResult;
	}
	
	public final Object getValue() {
		return value;
	}
	
	public final List<Integer> getArrayIndices() {
		return arrayIndices;
	}
}
