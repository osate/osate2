package org.osate.ge.fx;

import java.util.Objects;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.WeakChangeListener;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeLineCap;

/**
 * Resizable node that displays an image reference. If the referenced image is updated, then the displayed image is updated.
 *
 */
public class ImageNode extends Region {
	private ImageReference imageReference;
	private final ErrorImage errorImage = new ErrorImage();
	private final ImageView imageView = new ImageView();

	// Update the visible widgets and image view when the image changes
	private final ChangeListener<Image> imageChangeListener = (ChangeListener<Image>) (observable, oldValue,
			newValue) -> {
		imageView.setImage(newValue);
		imageView.setVisible(newValue != null);
		errorImage.setVisible(newValue == null);
	};

	public ImageNode(final ImageReference imageReference) {
		Objects.requireNonNull(imageReference, "image must not be null");
		imageView.setPreserveRatio(true);
		setImageReference(imageReference);
		imageReference.imageProperty().addListener(imageChangeListener);

		// Add children
		this.getChildren().addAll(errorImage, imageView);
	}

	@Override
	public void layoutChildren() {
		final double width = this.getWidth();
		final double height = this.getHeight();

		imageView.setFitWidth(width);
		imageView.setFitHeight(height);
		imageView.resize(width, height);
		errorImage.resize(width, height);
	}

	/**
	 * Updates the image displayed
	 */
	public void setImageReference(final ImageReference value) {
		if(imageReference != null) {
			imageReference.imageProperty().removeListener(imageChangeListener);
		}

		this.imageReference = value;
		imageReference.imageProperty().addListener(new WeakChangeListener<>(imageChangeListener));
		imageChangeListener.changed(null, null, imageReference.getImage());
	}
}

class ErrorImage extends Region {
	private final Rectangle rectangle = new Rectangle();
	private final Line l1 = new Line();
	private final Line l2 = new Line();

	public ErrorImage() {
		this.getChildren().addAll(rectangle, l1, l2);
		final double strokeWidth = 5.0;
		rectangle.setFill(Color.WHITE);
		rectangle.setStrokeWidth(strokeWidth);
		rectangle.setStroke(Color.RED);
		l1.setStroke(Color.RED);
		l1.setStrokeWidth(strokeWidth);
		l1.setStrokeLineCap(StrokeLineCap.ROUND);
		l2.setStroke(Color.RED);
		l2.setStrokeWidth(strokeWidth);
		l2.setStrokeLineCap(StrokeLineCap.ROUND);
	}

	@Override
	public void resize(double width, double height) {
		super.resize(width, height);

		rectangle.setWidth(width);
		rectangle.setHeight(height);

		l1.setStartX(0.0f);
		l1.setStartY(0.0f);
		l1.setEndX(width);
		l1.setEndY(height);

		l2.setStartX(width);
		l2.setStartY(0.0f);
		l2.setEndX(0.0);
		l2.setEndY(height);
	}
}
