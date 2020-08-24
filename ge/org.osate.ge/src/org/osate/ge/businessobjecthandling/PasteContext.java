package org.osate.ge.businessobjecthandling;

import java.util.Objects;
import java.util.Optional;

import org.eclipse.emf.ecore.EObject;
import org.osate.ge.BusinessObjectContext;

/**
 * @since 2.0
 */
public class PasteContext {
	private final BusinessObjectContext destBoc;
	private final EObject copiedEObject;

	public PasteContext(final BusinessObjectContext destBoc,
			final EObject copiedEObject) {
		this.destBoc = Objects.requireNonNull(destBoc, "destBoc cannot be null");
		this.copiedEObject = Objects.requireNonNull(copiedEObject, "copiedEObject cannot be null");
	}

	public <T> Optional<T> getBusinessObject(final Class<T> boType) {
		if (!boType.isInstance(copiedEObject)) {
			return Optional.empty();
		}

		return Optional.of(boType.cast(copiedEObject));
	}

	public <T> Optional<T> getDestinationBusinessObject(final Class<T> boType) {
		return destBoc.getBusinessObject(boType);
	}
}
