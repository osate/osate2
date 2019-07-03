package org.osate.ge.internal.model;

/**
 * Interface for model objects which are embedded into the diagram. Such objects are required to by copyable. EmbeddedBusinessObject implementations must be immutable.
 */
public interface EmbeddedBusinessObject {
	/**
	 * Produces a copy of the business object. If the object contains a UUID, then the copied object should have a new UUID.
	 * @return
	 */
	EmbeddedBusinessObject copy();

	/**
	 * Returns a string that should be stored in the diagram element in order to embed the object into the diagram.
	 * An embedded business object is not required to have data. The required data may be encoded as part of its reference.
	 */
	default String getData() {
		return null;
	}
}
