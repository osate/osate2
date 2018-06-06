package org.osate.ge.internal.diagram.runtime;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import org.osate.ge.DiagramType;

public class DiagramConfigurationBuilder {
	private DiagramType diagramType;
	private CanonicalBusinessObjectReference contextBoReference;
	private final Set<String> lcEnabledAadlPropertyNames = new HashSet<>();
	private Boolean connectionPrimaryLabelsVisible;

	/**
	 *
	 * @param diagramType
	 * @param populateDefaults if true then the value of fields will be populated based on the specified diagram type.
	 */
	public DiagramConfigurationBuilder(final DiagramType diagramType, final boolean populateDefaults) {
		this.diagramType = Objects.requireNonNull(diagramType, "diagramType must not be null");
		this.contextBoReference = null;

		if (populateDefaults) {
			for (final String propertyName : this.diagramType.getDefaultAadlPropertyNames()) {
				addAadlProperty(propertyName);
			}

			connectionPrimaryLabelsVisible(diagramType.getDefaultConnectionPrimaryLabelsVisible());
		}
	}

	public DiagramConfigurationBuilder(final DiagramConfiguration config) {
		Objects.requireNonNull(config, "config must not be null");
		this.diagramType = config.getDiagramType();
		this.contextBoReference = config.getContextBoReference();
		this.lcEnabledAadlPropertyNames.addAll(config.getEnabledAadlPropertyNames());
		this.connectionPrimaryLabelsVisible = config.getConnectionPrimaryLabelsVisible();
	}

	public DiagramType getDiagramType() {
		return this.diagramType;
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
		return new DiagramConfiguration(diagramType, contextBoReference, lcEnabledAadlPropertyNames,
				connectionPrimaryLabelsVisible);
	}
}
