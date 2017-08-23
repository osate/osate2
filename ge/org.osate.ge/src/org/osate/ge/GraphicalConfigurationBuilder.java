package org.osate.ge;

import java.awt.Color;

import org.osate.ge.graphics.Graphic;
import org.osate.ge.internal.AgeGraphicalConfiguration;
import org.osate.ge.internal.DockingPosition;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.labels.AgeLabelConfiguration;
import org.osate.ge.internal.labels.LabelConfiguration;
import org.osate.ge.internal.labels.LabelConfigurationBuilder;

/**
 * Builder for creating graphical configurations.
 * @noextend
 * @see GraphicalConfiguration
 */
public class GraphicalConfigurationBuilder {
	private final static AgeLabelConfiguration defaultDefaultLabelConfiguration = (AgeLabelConfiguration) LabelConfigurationBuilder.create().build();
	private final static java.awt.Color defaultDefaultBackgroundColor = Color.WHITE;
	private final static java.awt.Color defaultDefaultOutlineColor = Color.BLACK;
	private final static java.awt.Color defaultDefaultFontColor = Color.BLACK;

	private Graphic graphic;
	private DockingPosition defaultDockingPosition = DockingPosition.NOT_DOCKABLE;
	private AgeLabelConfiguration defaultLabelConfiguration = defaultDefaultLabelConfiguration;
	private DiagramElement connectionSource;
	private DiagramElement connectionDestination;
	private java.awt.Color defaultBackgroundColor = defaultDefaultBackgroundColor;
	private java.awt.Color defaultOutlineColor = defaultDefaultOutlineColor;
	private java.awt.Color defaultFontColor = defaultDefaultFontColor;
	private boolean isDecoration = false;

	private GraphicalConfigurationBuilder() {}

	public static GraphicalConfigurationBuilder create() {
		return new GraphicalConfigurationBuilder();
	}

	public GraphicalConfigurationBuilder graphic(final Graphic value) {
		this.graphic = value;
		return this;
	}

	public GraphicalConfigurationBuilder defaultDockingPosition(final DockingPosition value) {
		this.defaultDockingPosition = value;
		return this;
	}

	public GraphicalConfigurationBuilder defaultLabelConfiguration(final LabelConfiguration value) {
		this.defaultLabelConfiguration = (AgeLabelConfiguration)value;
		return this;
	}

	public GraphicalConfigurationBuilder source(final BusinessObjectContext value) {
		this.connectionSource = (DiagramElement)value;
		return this;
	}

	public GraphicalConfigurationBuilder destination(final BusinessObjectContext value) {
		this.connectionDestination = (DiagramElement)value;
		return this;
	}

	// Sets both the font and outline colors
	public GraphicalConfigurationBuilder defaultForeground(final Color value) {
		return defaultOutlineColor(value).defaultFontColor(value);
	}

	public GraphicalConfigurationBuilder defaultBackgroundColor(final Color value) {
		this.defaultBackgroundColor = value == null ? defaultBackgroundColor : value;
		return this;
	}

	public GraphicalConfigurationBuilder defaultOutlineColor(final Color value) {
		this.defaultOutlineColor = value == null ? defaultOutlineColor : value;
		return this;
	}

	public GraphicalConfigurationBuilder defaultFontColor(final Color value) {
		this.defaultFontColor = value == null ? defaultFontColor : value;
		return this;
	}

	public GraphicalConfigurationBuilder decoration() {
		this.isDecoration = true;
		return this;
	}

	public GraphicalConfiguration build() {
		return new AgeGraphicalConfiguration(graphic, defaultDockingPosition, defaultLabelConfiguration,
				connectionSource, connectionDestination, defaultBackgroundColor, defaultOutlineColor, defaultFontColor,
				isDecoration);
	}
}
