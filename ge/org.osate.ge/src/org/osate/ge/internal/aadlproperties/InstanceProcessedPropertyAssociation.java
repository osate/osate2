package org.osate.ge.internal.aadlproperties;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.instance.InstanceObject;

import com.google.common.base.Strings;
import com.google.common.collect.Iterables;

/**
 * Implementation of ProcessedPropertyAssociation for use with instance property associations which are relevant to the diagram but
 * are owned by a business object which is not represented in the diagram.
 *
 */
class InstanceProcessedPropertyAssociation implements ProcessedPropertyAssociation {
	private final PropertyAssociation propertyAssociation;
	private final Iterable<InstanceObject> pathToPropertyAssociationContainer;
	private final int propertyAssociationOwnerAncestorLevel;

	public InstanceProcessedPropertyAssociation(final PropertyAssociation propertyAssociation,
			final Iterable<InstanceObject> pathToPropertyAssociationContainer) {
		this.propertyAssociation = Objects.requireNonNull(propertyAssociation,
				"propertyAssociation must not be null");
		this.pathToPropertyAssociationContainer = Objects.requireNonNull(pathToPropertyAssociationContainer,
				"pathToPropertyAssociationContainer must not be null");
		this.propertyAssociationOwnerAncestorLevel = -Iterables.size(pathToPropertyAssociationContainer);
	}

	@Override
	public PropertyAssociation getPropertyAssociation() {
		return propertyAssociation;
	}

	@Override
	public int getPropertyAssociationOwnerAncestorLevel() {
		return propertyAssociationOwnerAncestorLevel;
	}

	@Override
	public boolean isCompletelyProcessed() {
		return false;
	}

	@Override
	public String getUnprocessedPathDescription() {
		return StreamSupport.stream(pathToPropertyAssociationContainer.spliterator(), false).map(io -> Strings.nullToEmpty(io.getFullName()))
				.collect(Collectors.joining(".")).toLowerCase();
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