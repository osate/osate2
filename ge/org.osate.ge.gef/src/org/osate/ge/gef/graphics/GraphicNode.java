package org.osate.ge.gef.graphics;

import org.eclipse.gef.geometry.planar.IGeometry;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;

// TODO: Document. Consider renaming
// TODO: Consider reworking into separate interfaces based on what type of Node. Just have a Graphic interface, etc
// remove methods that aren't relevant to them. Consider usage.
public interface GraphicNode {
	default void setBackgroundColor(final Color value) {
	}

	default void setOutlineColor(final Color value) {
	}

	default void setFontColor(final Color value) {
	}

	default void setFont(final Font value) {
	}

	default void setStrokeDashOffset(double value) {
	}

	default void setStrokeDashArray(double... values) {
	}

	default void setLineWidth(final double value) {
	}

	/**
	 * Returns an outline of the graphic suitable for use for chopbox anchors
	 * @return the outline of the node. Must not return null.
	 */
	IGeometry getOutline();
}
