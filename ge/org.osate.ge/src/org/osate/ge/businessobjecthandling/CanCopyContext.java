package org.osate.ge.businessobjecthandling;

import java.util.Objects;
import java.util.Optional;

/**
 * Contains contextual information for determining if a business object can be copied.
 *
 * @since 2.0
 * @noextend This class is not intended to be subclassed by clients.
 */
public class CanCopyContext {
	private final Object bo;

	/**
	 * Creates a new instance.
	 * @param bo is the business object which is being copied.
	 * @noreference This constructor is not intended to be referenced by clients.
	 */
	public CanCopyContext(final Object bo) {
		this.bo = Objects.requireNonNull(bo, "bo must not be null");
	}

	/**
	 * Retrieves the business object which is being copied if it is an instance
	 * of the specified class.
	 * @param <T> is the requested type.
	 * @param c is the class to which to cast the business object.
	 * @return an optional containing the context's business object. An empty optional if the context's business object is not
	 * an instance the specified class.
	 */
	public <T> Optional<T> getBusinessObject(final Class<T> boType) {
		if (!boType.isInstance(bo)) {
			return Optional.empty();
		}

		return Optional.of(boType.cast(bo));
	}
}
