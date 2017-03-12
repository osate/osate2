package org.osate.ge.internal.diagram;

/**
 * Immutable type which represents the diagram configuration.
 * 
 * @see DiagramConfigurationBuilder
 */
public class DiagramConfiguration {
	private final RelativeBusinessObjectReference rootBoReference;
	
	DiagramConfiguration(final RelativeBusinessObjectReference rootBoReference) {
		this.rootBoReference = rootBoReference == null ? null : rootBoReference;
	}
	
	public RelativeBusinessObjectReference getRootBoReference() {
		return rootBoReference;
	}
	
	@Override
	public String toString() {
		return "{ root business object reference: " + rootBoReference + " } ";
	}
}
