package org.osate.ge.internal.diagram.runtime;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class DiagramConfigurationBuilder {
	private CanonicalBusinessObjectReference contextBoReference;
	private final Set<String> lcEnabledAadlPropertyNames = new HashSet<>();
	private Boolean connectionPrimaryLabelsVisible;

	public DiagramConfigurationBuilder() {
		this.contextBoReference = null;
	}

	public DiagramConfigurationBuilder(final DiagramConfiguration config) {
		Objects.requireNonNull(config, "config must not be null");
		this.contextBoReference = config.getContextBoReference();
		this.lcEnabledAadlPropertyNames.addAll(config.getEnabledAadlPropertyNames());
		this.connectionPrimaryLabelsVisible = config.getConnectionPrimaryLabelsVisible();
	}

	public CanonicalBusinessObjectReference getContextBoReference() {
		return this.contextBoReference;
	}

	public DiagramConfigurationBuilder setContextBoReference(final CanonicalBusinessObjectReference value) {
		this.contextBoReference = value;
		return this;
	}

	public Boolean getConnectionPrimaryLabelsVisible() {
		return connectionPrimaryLabelsVisible;
	}

	public DiagramConfigurationBuilder connectionPrimaryLabelsVisible(final Boolean value) {
		this.connectionPrimaryLabelsVisible = value;
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

	public Set<String> getEnabledAadlPropertiesLowercase() {
		return Collections.unmodifiableSet(lcEnabledAadlPropertyNames);
	}

	public DiagramConfiguration build() {
		return new DiagramConfiguration(contextBoReference, lcEnabledAadlPropertyNames, connectionPrimaryLabelsVisible);
	}
}
