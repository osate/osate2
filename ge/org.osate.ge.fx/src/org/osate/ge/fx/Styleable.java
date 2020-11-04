package org.osate.ge.fx;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;

// TODO: Document. Consider renaming
// TODO: Consider reworking into separate interfaces based on what type of Node. Just have a Graphic interface, etc
// remove methods that aren't relevant to them. Consider usage.
public interface Styleable {
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
}
