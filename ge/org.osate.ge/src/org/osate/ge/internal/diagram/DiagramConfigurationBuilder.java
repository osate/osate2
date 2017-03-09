package org.osate.ge.internal.diagram;

public class DiagramConfigurationBuilder {
	private BusinessObjectReference rootBoReference;
	
	public DiagramConfigurationBuilder() {
		this.rootBoReference = null;
	}
	
	public DiagramConfigurationBuilder(final DiagramConfiguration config) {
		this.rootBoReference = config.getRootBoReference();
	}
	
	public DiagramConfiguration build() {
		return new DiagramConfiguration(rootBoReference);
	}
}
