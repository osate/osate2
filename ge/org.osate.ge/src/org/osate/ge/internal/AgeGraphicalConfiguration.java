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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((connectionDestination == null) ? 0 : connectionDestination.hashCode());
		result = prime * result + ((connectionSource == null) ? 0 : connectionSource.hashCode());
		result = prime * result + ((defaultBackgroundColor == null) ? 0 : defaultBackgroundColor.hashCode());
		result = prime * result + ((defaultDockingPosition == null) ? 0 : defaultDockingPosition.hashCode());
		result = prime * result + ((defaultFontColor == null) ? 0 : defaultFontColor.hashCode());
		result = prime * result + ((defaultLabelConfiguration == null) ? 0 : defaultLabelConfiguration.hashCode());
		result = prime * result + ((defaultOutlineColor == null) ? 0 : defaultOutlineColor.hashCode());
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
		if (defaultBackgroundColor == null) {
			if (other.defaultBackgroundColor != null) {
				return false;
			}
		} else if (!defaultBackgroundColor.equals(other.defaultBackgroundColor)) {
			return false;
		}
		if (defaultDockingPosition != other.defaultDockingPosition) {
			return false;
		}
		if (defaultFontColor == null) {
			if (other.defaultFontColor != null) {
				return false;
			}
		} else if (!defaultFontColor.equals(other.defaultFontColor)) {
			return false;
		}
		if (defaultLabelConfiguration == null) {
			if (other.defaultLabelConfiguration != null) {
				return false;
			}
		} else if (!defaultLabelConfiguration.equals(other.defaultLabelConfiguration)) {
			return false;
		}
		if (defaultOutlineColor == null) {
			if (other.defaultOutlineColor != null) {
				return false;
			}
		} else if (!defaultOutlineColor.equals(other.defaultOutlineColor)) {
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
