package org.osate.ge.fx;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

// TODO: Document
public interface Styleable {
	default void setBackgroundColor(final Color value) {
	}

	default void setOutlineColor(final Color value) {
	}

	default void setFontColor(final Color value) {
	}

	default void setFont(final Font value) {
	}

	default void setImage(final Image image) {
	}

	default void setLabelPosition(Pos value) {
	}

	default void setStrokeDashOffset(double value) {
	}

	default void setStrokeDashArray(double... values) {
	}

	default void setLineWidth(final double value) {
	}
}
