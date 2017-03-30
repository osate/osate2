package org.osate.ge.internal.diagram;

public class DiagramConfigurationBuilder {
	private CanonicalBusinessObjectReference rootBoReference;
	
	public DiagramConfigurationBuilder() {
		this.rootBoReference = null;
	}
	
	public DiagramConfigurationBuilder(final DiagramConfiguration config) {
		this.rootBoReference = config.getRootBoReference();
	}
	
	public DiagramConfigurationBuilder setRootBoReference(final CanonicalBusinessObjectReference value) {
		this.rootBoReference = value;
		return this;
	}
	
	public DiagramConfiguration build() {
		return new DiagramConfiguration(rootBoReference);
	}
}
