package org.osate.ge;

import java.util.Objects;

import org.osate.ge.graphics.Graphic;
import org.osate.ge.graphics.Style;
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

	private Graphic graphic;
	private Style style = Style.EMPTY;
	private DockingPosition defaultDockingPosition = DockingPosition.NOT_DOCKABLE;
	private AgeLabelConfiguration defaultLabelConfiguration = defaultDefaultLabelConfiguration;
	private DiagramElement connectionSource;
	private DiagramElement connectionDestination;
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
		this.defaultLabelConfiguration = Objects.requireNonNull((AgeLabelConfiguration) value,
				"value must not be null");
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

	public GraphicalConfigurationBuilder defaultStyle(final Style value) {
		this.style = value;
		return this;
	}

	public GraphicalConfigurationBuilder decoration() {
		this.isDecoration = true;
		return this;
	}

	public GraphicalConfiguration build() {
		return new AgeGraphicalConfiguration(graphic, defaultDockingPosition, defaultLabelConfiguration,
				connectionSource, connectionDestination, style,
				isDecoration);
	}
}
