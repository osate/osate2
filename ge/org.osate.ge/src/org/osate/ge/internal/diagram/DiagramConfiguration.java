package org.osate.ge.internal.diagram;

/**
 * Immutable type which represents the diagram configuration.
 * 
 * @see DiagramConfigurationBuilder
 */
public class DiagramConfiguration {
	private final BusinessObjectReference rootBoReference;
	
	DiagramConfiguration(final BusinessObjectReference rootBoReference) {
		this.rootBoReference = rootBoReference == null ? null : rootBoReference;
	}
	
	public BusinessObjectReference getRootBoReference() {
		return rootBoReference;
	}
}
