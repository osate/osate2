package org.osate.ge.internal;

import java.awt.Color;
import java.util.Objects;

import org.osate.ge.GraphicalConfiguration;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.labels.AgeLabelConfiguration;

public class AgeGraphicalConfiguration implements GraphicalConfiguration {
	public final Graphic graphic;
	public final DockingPosition defaultDockingPosition;
	public final AgeLabelConfiguration defaultLabelConfiguration;
	public final DiagramElement connectionSource;
	public final DiagramElement connectionDestination;
	public final Color defaultBackgroundColor;
	public final Color defaultOutlineColor;
	public final Color defaultFontColor;
	public final boolean isDecoration;

	public AgeGraphicalConfiguration(final Graphic graphic, final DockingPosition defaultDockingPosition,
			final AgeLabelConfiguration defaultLabelConfiguration, final DiagramElement connectionSource,
			final DiagramElement connectionDestination, final Color defaultBackgroundColor,
			final Color defaultOutlineColor, final Color defaultFontColor, final boolean isDecoration) {
		this.graphic = Objects.requireNonNull(graphic, "graphic must not be null");
		this.defaultDockingPosition = defaultDockingPosition;
		this.defaultLabelConfiguration = defaultLabelConfiguration;
		this.connectionSource = connectionSource;
		this.connectionDestination = connectionDestination;
		this.defaultBackgroundColor = Objects.requireNonNull(defaultBackgroundColor,
				"defaultBackgroundColor must not be null");
		this.defaultOutlineColor = Objects.requireNonNull(defaultOutlineColor,
				"defaultOutlineColor must not be null");
		this.defaultFontColor = Objects.requireNonNull(defaultFontColor, "defaultFontColor must not be null");
		this.isDecoration = isDecoration;
	}
}
