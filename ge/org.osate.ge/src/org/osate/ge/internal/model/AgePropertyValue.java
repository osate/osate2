package org.osate.ge.internal.model;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

import org.osate.ge.internal.aadlproperties.PropertyResult;

import com.google.common.collect.ImmutableList;

/**
 * Represents a single property value from a PropertyResult.
 * Note: This class is not used as a business object. It is only referenced by other model objects.
 * @see PropertyValueGroup
 */
public class AgePropertyValue {
	private final PropertyResult propertyResult;
	private ImmutableList<Integer> arrayIndices; // Zero-based indices of the value if the property result contains a list and this object refers to a single element.
	private final String appliesToDescendantRef; // Description of the descendant to which this property value applies. Will be null if property association was completely processed. May not be valid AADL. In other words.
	private final boolean isReferenceFullyResolved; // Only applicable for references. Indicates whether the reference has been fully resolved. Does the reference id of the group point to the object referred to by the value or to one of its containers.
	
	/**
	 * @param arrayIndices array indices for the value. This class will make a copy of the array.
	 */
	public AgePropertyValue(final PropertyResult propertyResult, 
			final Collection<Integer> arrayIndices,
			final String appliesToDescendantRef, 
			final boolean isReferenceFullyResolved) {
		this.propertyResult = Objects.requireNonNull(propertyResult, "propertyResult must not be null");
		this.arrayIndices = arrayIndices == null ? ImmutableList.of() : ImmutableList.copyOf(arrayIndices);
		this.appliesToDescendantRef = appliesToDescendantRef;
		this.isReferenceFullyResolved = isReferenceFullyResolved;
	}
		
	public final boolean isBasedOnCompletelyProcessedAssociation() {
		return appliesToDescendantRef == null;
	}
	
	public final String getAppliesToRef() {
		return appliesToDescendantRef;
	}
	
	public final PropertyResult getPropertyResult() {
		return propertyResult;
	}
	
	public final ImmutableList<Integer> getArrayIndices() {
		return arrayIndices;
	}
	
	public final Object getValue() {
		return getValue(propertyResult.value, arrayIndices, 0);
	}
	
	public final boolean isReferenceFullyResolved() {
		return isReferenceFullyResolved;
	}
	
	/**
	 * Recursive function for looking up value while handling array indices.
	 * @param container
	 * @param indices
	 * @param indexIndex is the next index in the indices array to use to retrieve the value.
	 * @return the retrieved value. If indexIndex >= the size of the indices list, then the container is returned.
	 */
	private static Object getValue(final Object container, final List<Integer> indices, int indexIndex) {
		if(indexIndex >= indices.size()) {
			return container;
		}
		
		final Integer index = indices.get(indexIndex);
		return getValue(((List<?>)container).get(index), indices, indexIndex+1);
	}
}
