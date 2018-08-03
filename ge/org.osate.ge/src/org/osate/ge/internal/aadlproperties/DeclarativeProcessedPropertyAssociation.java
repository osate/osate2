package org.osate.ge.internal.aadlproperties;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.osate.aadl2.ContainmentPathElement;
import org.osate.aadl2.ModalPropertyValue;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.PropertyAssociation;

class DeclarativeProcessedPropertyAssociation implements ProcessedPropertyAssociation {
	private final PropertyAssociation propertyAssociation; // Property Association
	private final List<ContainmentPathElement> appliedToPathElements; // ContainedNamedElement - AppliesTo
	private final int processedAppliedToPathElements; // Count of number of ContainmentPathElement processed in the applies to

	public DeclarativeProcessedPropertyAssociation(final PropertyAssociation propertyAssociation,
			final List<ContainmentPathElement> appliedToPathElements, final int processedAppliedToPathElements) {
		this.propertyAssociation = Objects.requireNonNull(propertyAssociation,
				"propertyAssociation must not be null");
		this.appliedToPathElements = Objects.requireNonNull(appliedToPathElements,
				"appliedToPathElements must not be null");
		this.processedAppliedToPathElements = processedAppliedToPathElements;
	}

	@Override
	public PropertyAssociation getPropertyAssociation() {
		return propertyAssociation;
	}

	@Override
	public int getPropertyAssociationOwnerAncestorLevel() {
		return processedAppliedToPathElements;
	}

	@Override
	public boolean isCompletelyProcessed() {
		return appliedToPathElements.size() == processedAppliedToPathElements;
	}

	private List<ContainmentPathElement> getUnprocessedPathElements() {
		return appliedToPathElements.subList(processedAppliedToPathElements, appliedToPathElements.size());
	}

	@Override
	public String getUnprocessedPathDescription() {
		return getUnprocessedPathElements().stream().map(pe -> getNonNullName(pe.getNamedElement()))
				.collect(Collectors.joining(".")).toLowerCase();
	}

	private static String getNonNullName(final NamedElement ne) {
		if (ne == null) {
			return "";
		}

		final String name = ne.getName();
		if (name == null) {
			return "";
		}

		return name;
	}

	@Override
	public boolean hasArrayIndices() {
		for(final ContainmentPathElement e: appliedToPathElements) {
			if(e.getArrayRanges() != null && e.getArrayRanges().size() > 0) {
				return true;
			}
		}

		return false;
	}

	@Override
	public boolean isBindingSpecific() {
		return propertyAssociation.getInBindings() != null && propertyAssociation.getInBindings().size() > 0;
	}

	@Override
	public boolean isModal() {
		for(final ModalPropertyValue mpv : propertyAssociation.getOwnedValues()) {
			if(mpv.getInModes() != null && mpv.getInModes().size() > 0) {
				return true;
			}
		}
		return false;
	}
}