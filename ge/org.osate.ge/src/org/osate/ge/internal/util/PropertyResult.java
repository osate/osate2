package org.osate.ge.internal.util;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import org.osate.aadl2.ListValue;
import org.osate.aadl2.ModalPropertyValue;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.ReferenceValue;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.ge.internal.query.Queryable;
import org.osate.ge.internal.util.AadlPropertyResolver.ProcessedPropertyAssociation;

/**
 * Contains the result of retrieving the value of a property.
 *
 */
public class PropertyResult {
	public static enum NullReason {
		ARRAY_ELEMENT_SPECIFIC,
		MODAL,
		BINDING_SPECIFIC,
		UNDEFINED
	}
	
	/**
	 * Contains the reference value and information regarding the start of the path relative to the Queryable with which it is association. 
	 *
	 */
	public static class ReferenceValueWithContext {
		public final ReferenceValue referenceValue;

		/**
		 * The property association belongs to an ancestor this many levels up from the element the Queryable is associated.
		 * For example, a value of 1 indicates that the path begins at the parent of the Queryable.
		 * The first element in the reference value's path will be a sibling of the queryable.
		 */
		public final int ownerAncestorLevel;
		
		public ReferenceValueWithContext(final ReferenceValue referenceValue, final int ownerAncestorLevel) {
			this.referenceValue = referenceValue;
			this.ownerAncestorLevel = ownerAncestorLevel;
		}
	}
	
	public PropertyResult(final NullReason nullReason) {
		this.value = null;
		this.nullReason = Objects.requireNonNull(nullReason, "nullReason must not be null");
	}
	
	public PropertyResult(final Object value) {
		this.value = Objects.requireNonNull(value, "value must not be null");
		this.nullReason = null;
	}
		
	// An object of this class will either have a non-null value or a reason why the value is null.
	
	/**
	 * value is the value of the property when it is not specific to an array index, mode, or binding.
	 * The value will be null if any of the flags are true or if there is not a value for the property 
	 */
	public final Object value;
	public final NullReason nullReason;
	
	public static PropertyResult getPropertyValue(AadlPropertyResolver qr, final Queryable q, final Property p) {
		return getPropertyValue(qr, q, p, 0);
	}
			
	/**
	 * 
	 * @param qr
	 * @param q
	 * @param p
	 * @param ancestorLevelOffset is the offset between the queryable the value is being retrieved for an the queryable specified. (This function
	 * is called recursively for inherited properties)
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private static PropertyResult getPropertyValue(AadlPropertyResolver qr, final Queryable q, final Property p, final int ancestorLevelOffset) {
		// Return null if the business object isn't a named element.
		final Object bo = q.getBusinessObject();
		if(!(bo instanceof NamedElement)) {
			return null;
		}
		
		// Return null if the element doesn't accept the property
		final NamedElement namedElement = (NamedElement)bo;
		if(!namedElement.acceptsProperty(p)) {
			return null;
		}
				
		// Find the value which isn't tied to a specific array element, mode, or binding
		Object value = null;
		for(ProcessedPropertyAssociation ppa : qr.getProcessedPropertyAssociations(q, p)) {
			// Only look at property associations that are applied to the queryable
			if(ppa.isCompletelyProcessed()) {
				// Check for cases which result in not being able to return the property value
				if(ppa.hasArrayIndices()) {
					return new PropertyResult(NullReason.ARRAY_ELEMENT_SPECIFIC);
				}

				if(ppa.isModal()) {
					return new PropertyResult(NullReason.MODAL);
				}
				
				if(ppa.isBindingSpecific()) {
					return new PropertyResult(NullReason.BINDING_SPECIFIC);
				}

				final PropertyAssociation pa = ppa.propertyAssociation;			
				for(final ModalPropertyValue mpv : pa.getOwnedValues()) {
					final Object newValue = convertValue(mpv.getOwnedValue(), ppa.processedAppliedToPathElements+ancestorLevelOffset);
					if(value != null && newValue instanceof LinkedList) {
						final LinkedList<Object> valueList = ((LinkedList<Object>)value);
						
						// Iterate backwards so we can prepend bindings properly.
						final List<Object> newList = (List<Object>)newValue;
						for(int i = newList.size() - 1; i >= 0; i--) {
							final Object newListElement = newList.get(i);
							valueList.addFirst(newListElement);
						}
					} else {
						value = newValue;
					}
				}

				// Stop determining the value unless appending to a list.
				if(pa.isAppend()) {
					break;
				}
			}
		}
		
		if(value == null) {
			// Handle inherited properties
			// Don't process inherit for instance objects. The instance model already contains the property associations
			if(p.isInherit() && !(q.getBusinessObject() instanceof InstanceObject)) {
				final Queryable parent = q.getParent();
				if(parent != null) {
					final PropertyResult result = getPropertyValue(qr, parent, p, ancestorLevelOffset+1);
					if(result != null && result.nullReason != NullReason.UNDEFINED) {
						return result;
					}
				}
			}
			
			// Use the default value
			value = convertValue(p.getDefaultValue(), 0);
		}

		return value == null ? new PropertyResult(NullReason.UNDEFINED) : new PropertyResult(value);
	}
	
	private static Object convertValue(final PropertyExpression propertyExpression, final int processedAppliedToPathElements) {
		if(propertyExpression == null) {
			return null;
		}
		
		if(propertyExpression instanceof ListValue) {
			// Convert the ListValue to a java list
			final ListValue lv = (ListValue)propertyExpression;
			final List<Object> convertedList = new LinkedList<>();
			for(final PropertyExpression innerExpression : lv.getOwnedListElements()) {
				final Object innerValue = convertValue(innerExpression, processedAppliedToPathElements);
				if(innerValue != null) {
					convertedList.add(innerValue);
				}
			}
			
			return convertedList;
		} else if(propertyExpression instanceof ReferenceValue) {
			return new ReferenceValueWithContext((ReferenceValue)propertyExpression, processedAppliedToPathElements);
		} else {
			return propertyExpression;
		}
	}
}
