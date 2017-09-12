package org.osate.ge.graphics.internal;

import java.util.Objects;

import org.osate.ge.DockingPosition;
import org.osate.ge.GraphicalConfiguration;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.graphics.Style;
import org.osate.ge.internal.diagram.runtime.DiagramElement;

public class AgeGraphicalConfiguration implements GraphicalConfiguration {
	public final Graphic graphic;
	public final DockingPosition defaultDockingPosition;
	public final DiagramElement connectionSource;
	public final DiagramElement connectionDestination;
	public final Style style;
	public final boolean isDecoration;

	public AgeGraphicalConfiguration(final Graphic graphic, final DockingPosition defaultDockingPosition,
			final DiagramElement connectionSource, final DiagramElement connectionDestination, final Style style,
			final boolean isDecoration) {
		this.graphic = Objects.requireNonNull(graphic, "graphic must not be null");
		this.defaultDockingPosition = defaultDockingPosition;
		this.connectionSource = connectionSource;
		this.connectionDestination = connectionDestination;
		this.style = Objects.requireNonNull(style, "style must not be null");
		this.isDecoration = isDecoration;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((connectionDestination == null) ? 0 : connectionDestination.hashCode());
		result = prime * result + ((connectionSource == null) ? 0 : connectionSource.hashCode());
		result = prime * result + ((defaultDockingPosition == null) ? 0 : defaultDockingPosition.hashCode());
		result = prime * result + ((style == null) ? 0 : style.hashCode());
		result = prime * result + ((graphic == null) ? 0 : graphic.hashCode());
		result = prime * result + (isDecoration ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		AgeGraphicalConfiguration other = (AgeGraphicalConfiguration) obj;
		if (connectionDestination == null) {
			if (other.connectionDestination != null) {
				return false;
			}
		} else if (!connectionDestination.equals(other.connectionDestination)) {
			return false;
		}
		if (connectionSource == null) {
			if (other.connectionSource != null) {
				return false;
			}
		} else if (!connectionSource.equals(other.connectionSource)) {
			return false;
		}
		if (defaultDockingPosition != other.defaultDockingPosition) {
			return false;
		}
		if (style == null) {
			if (other.style != null) {
				return false;
			}
		} else if (!style.equals(other.style)) {
			return false;
		}
		if (graphic == null) {
			if (other.graphic != null) {
				return false;
			}
		} else if (!graphic.equals(other.graphic)) {
			return false;
		}
		if (isDecoration != other.isDecoration) {
			return false;
		}
		return true;
	}
}
