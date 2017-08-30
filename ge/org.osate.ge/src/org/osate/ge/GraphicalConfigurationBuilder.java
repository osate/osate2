package org.osate.ge;

import org.osate.ge.graphics.Graphic;
import org.osate.ge.graphics.Style;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.graphics.AgeGraphicalConfiguration;

/**
 * Builder for creating graphical configurations.
 * @noextend
 * @see GraphicalConfiguration
 */
public class GraphicalConfigurationBuilder {
	private Graphic graphic;
	private Style style = Style.EMPTY;
	private DockingPosition defaultDockingPosition = DockingPosition.NOT_DOCKABLE;
	private DiagramElement connectionSource;
	private DiagramElement connectionDestination;
	private boolean isDecoration = false;

	private GraphicalConfigurationBuilder() {
	}

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

	public GraphicalConfigurationBuilder source(final BusinessObjectContext value) {
		this.connectionSource = (DiagramElement) value;
		return this;
	}

	public GraphicalConfigurationBuilder destination(final BusinessObjectContext value) {
		this.connectionDestination = (DiagramElement) value;
		return this;
	}

	public GraphicalConfigurationBuilder style(final Style value) {
		this.style = value;
		return this;
	}

	public GraphicalConfigurationBuilder decoration() {
		this.isDecoration = true;
		return this;
	}

	public GraphicalConfiguration build() {
		return new AgeGraphicalConfiguration(graphic, defaultDockingPosition, connectionSource, connectionDestination,
				style, isDecoration);
	}
}
