package org.osate.ge.internal.model;

import java.util.Collection;
import java.util.Objects;

import org.osate.aadl2.Property;

import com.google.common.collect.ImmutableList;

/**
 * Stores all property values for a particular property which have the same owner and reference the same model element.
 * The owner of the property value is not necessarily the same model element to which the property value is applied.
 *
 */
public class PropertyValueGroup {
	private final Property property;
	private final Long referencedId; // Optional. The diagram element that is referenced by the property value group. Needed for property values which are represented as a connection.
	private final ImmutableList<AgePropertyValue> values;

	public PropertyValueGroup(final Property property,
			final Long referencedId,
			final Collection<AgePropertyValue> values) {
		this.property = Objects.requireNonNull(property, "property must not be null");
		this.referencedId = referencedId;
		this.values = ImmutableList.copyOf(values);
	}

	public final Property getProperty() {
		return property;
	}

	public final Long getReferenceId() {
		return referencedId;
	}

	public final ImmutableList<AgePropertyValue> getPropertyValues() {
		return values;
	}

	public final AgePropertyValue getFirstValueBasedOnCompletelyProcessedAssociation() {
		for(final AgePropertyValue pv : values) {
			if(pv.isBasedOnCompletelyProcessedAssociation()) {
				return pv;
			}
		}

		return null;
	}

	// Determine whether the property value group contains multiple values, values based on not-completely processed property associations,
	// or non-fully resolved references.
	public final boolean isAbstract() {
		boolean isAbstract = false;
		if (getPropertyValues().size() > 1) {
			isAbstract = true;
		} else {
			final AgePropertyValue firstValueFromCompleteAssociation = getFirstValueBasedOnCompletelyProcessedAssociation();

			// If there is a value based on a completely processed property association, then the reference shouldn't be shown as being partial
			isAbstract = firstValueFromCompleteAssociation == null || !firstValueFromCompleteAssociation.isReferenceFullyResolved();
		}

		return isAbstract;
	}
}
