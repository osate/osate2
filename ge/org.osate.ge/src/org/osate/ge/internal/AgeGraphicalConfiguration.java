package org.osate.ge.internal;

import java.awt.Color;
import java.util.Objects;

import org.osate.ge.GraphicalConfiguration;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.internal.diagram.DiagramElement;
import org.osate.ge.internal.labels.AgeLabelConfiguration;

// TODO: Rename
public class AgeGraphicalConfiguration implements GraphicalConfiguration {
	public final Graphic graphic;
	public final DockingPosition defaultDockingPosition;
	public final AgeLabelConfiguration defaultLabelConfiguration;
	public final DiagramElement connectionSource;
	public final DiagramElement connectionDestination;
	public final Color foreground;
	
	public AgeGraphicalConfiguration(final Graphic graphic,
			final DockingPosition defaultDockingPosition,
			final AgeLabelConfiguration defaultLabelConfiguration,
			final DiagramElement connectionSource,
			final DiagramElement connectionDestination,
			final Color foreground) {
		this.graphic = Objects.requireNonNull(graphic, "graphic must not be null");
		this.defaultDockingPosition = defaultDockingPosition;
		this.defaultLabelConfiguration = defaultLabelConfiguration;
		this.connectionSource = connectionSource;
		this.connectionDestination = connectionDestination;
		this.foreground = Objects.requireNonNull(foreground, "foreground must not be null");
	}
}
