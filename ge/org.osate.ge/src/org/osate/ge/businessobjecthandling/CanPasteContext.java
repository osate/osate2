package org.osate.ge.businessobjecthandling;

import java.util.Objects;
import java.util.Optional;

import org.osate.ge.BusinessObjectContext;

/**
 * @since 2.0
 */
public class CanPasteContext {
	private final BusinessObjectContext dstDiagramNode;
	private final BusinessObjectContext copiedDiagramElement;

	public CanPasteContext(final BusinessObjectContext dstDiagramNode,
			final BusinessObjectContext copiedDiagramElement) {
		this.dstDiagramNode = Objects.requireNonNull(dstDiagramNode, "destination boc cannot be null");
		this.copiedDiagramElement = Objects.requireNonNull(copiedDiagramElement, "copied boc cannot be null");
	}

	public <T> Optional<T> getBusinessObject(final Class<T> boType) {
		return copiedDiagramElement.getBusinessObject(boType);
	}

	public <T> Optional<T> getDestinationBusinessObject(final Class<T> boType) {
		return dstDiagramNode.getBusinessObject(boType);
	}
}
