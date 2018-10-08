package org.osate.ge.graphics.internal;

import org.osate.ge.GraphicalConfigurationBuilder;

/**
 * Internal extension of the graphical configuration builder which allows changing values that are not part of the API.
 * Because inherited methods return GraphicalConfigurationBuilder, the methods on the internal builder should be called first.
 *
 */
public class InternalGraphicalConfigurationBuilder extends GraphicalConfigurationBuilder {
	protected InternalGraphicalConfigurationBuilder() {
	}

	public static InternalGraphicalConfigurationBuilder create() {
		return new InternalGraphicalConfigurationBuilder();
	}

	public InternalGraphicalConfigurationBuilder primaryLabelIsMultiline(final boolean value) {
		this.primaryLabelIsMultiline = value;
		return this;
	}
}
