package org.osate.ge.internal.diagram;

import java.util.HashSet;
import java.util.Set;

public class DiagramConfigurationBuilder {
	private CanonicalBusinessObjectReference rootBoReference;
	private final Set<String> lcEnabledAadlPropertyNames = new HashSet<>();
	
	public DiagramConfigurationBuilder() {
		this.rootBoReference = null;
	}
	
	public DiagramConfigurationBuilder(final DiagramConfiguration config) {
		this.rootBoReference = config.getRootBoReference();
		this.lcEnabledAadlPropertyNames.addAll(config.getEnabledAadlPropertyNames());
	}
	
	public DiagramConfigurationBuilder setRootBoReference(final CanonicalBusinessObjectReference value) {
		this.rootBoReference = value;
		return this;
	}
	
	public DiagramConfigurationBuilder addAadlProperty(final String qualifiedPropertyName) {
		lcEnabledAadlPropertyNames.add(qualifiedPropertyName.toLowerCase());
		return this;
	}
	
	public DiagramConfigurationBuilder removeAadlProperty(final String qualifiedPropertyName) {
		lcEnabledAadlPropertyNames.remove(qualifiedPropertyName.toLowerCase());
		return this;
	}
	
	public DiagramConfiguration build() {
		return new DiagramConfiguration(rootBoReference, lcEnabledAadlPropertyNames);
	}
}
