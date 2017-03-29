package org.osate.ge.internal.diagram;

/**
 * Immutable type which represents the diagram configuration.
 * 
 * @see DiagramConfigurationBuilder
 */
public class DiagramConfiguration {
	private final CanonicalBusinessObjectReference rootBoReference;
	
	DiagramConfiguration(final CanonicalBusinessObjectReference rootBoReference) {
		this.rootBoReference = rootBoReference == null ? null : rootBoReference;
	}
	
	public CanonicalBusinessObjectReference getRootBoReference() {
		return rootBoReference;
	}
	
	@Override
	public String toString() {
		return "{ root business object reference: " + rootBoReference + " } ";
	}
}
