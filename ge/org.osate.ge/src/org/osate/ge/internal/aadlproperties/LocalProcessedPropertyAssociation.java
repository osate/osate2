package org.osate.ge.internal.aadlproperties;

import java.util.Objects;

import org.osate.aadl2.PropertyAssociation;

/**
 * ProcessedPropertyAssociation implementation for property associations which do not include applies to clauses.
 */
class LocalProcessedPropertyAssociation implements ProcessedPropertyAssociation {
	private final PropertyAssociation propertyAssociation;

	public LocalProcessedPropertyAssociation(final PropertyAssociation propertyAssociation) {
		this.propertyAssociation = Objects.requireNonNull(propertyAssociation,
				"propertyAssociation must not be null");
	}

	@Override
	public PropertyAssociation getPropertyAssociation() {
		return propertyAssociation;
	}

	@Override
	public int getPropertyAssociationOwnerAncestorLevel() {
		return 0;
	}

	@Override
	public boolean isCompletelyProcessed() {
		return true;
	}

	@Override
	public String getUnprocessedPathDescription() {
		return "";
	}

	@Override
	public boolean hasArrayIndices() {
		return false;
	}

	@Override
	public boolean isBindingSpecific() {
		return false;
	}

	@Override
	public boolean isModal() {
		return false;
	}
}