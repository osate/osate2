package org.osate.ge.gef;

import java.util.Objects;

import org.eclipse.gef.geometry.convert.fx.FX2Geometry;
import org.eclipse.gef.geometry.planar.IGeometry;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.WeakChangeListener;
import javafx.geometry.Bounds;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeType;

/**
 * Resizable node that displays an image reference. Maintains aspect ratio.
 * If the referenced image is updated, then the displayed image is updated. If the image is not valid, an error
 * symbol is displayed.
 */
public class ImageNode extends Region implements ChopBoxGeometryProvider {
	private ImageReference imageReference;
	private final RectangleNode rectangle = new RectangleNode();
	private final ErrorImage errorImage = new ErrorImage();
	private final ImageView imageView = new ImageView();

	// Update the visible widgets and image view when the image changes
	private final ChangeListener<Image> imageChangeListener = (ChangeListener<Image>) (observable, oldValue,
			newValue) -> {
		imageView.setImage(newValue);
		imageView.setVisible(newValue != null);
		rectangle.setVisible(newValue != null);
		errorImage.setVisible(newValue == null);
	};

	/**
	 * Create a new instance
	 */
	public ImageNode() {
		imageView.setPreserveRatio(true);
		setImageReference(null);

		// Add children
		this.getChildren().addAll(rectangle, errorImage, imageView);
	}

	@Override
	public void layoutChildren() {
		final double width = this.getWidth();
		final double height = this.getHeight();

		imageView.setFitWidth(width);
		imageView.setFitHeight(height);
		imageView.resize(width, height);

		final Bounds imageBounds = imageView.getLayoutBounds();
		imageView.relocate((width - imageBounds.getWidth()) / 2.0, (height - imageBounds.getHeight()) / 2.0);

		errorImage.resize(width, height);
		rectangle.resize(width, height);
	}

	public ImageReference getImageReference() {
		return this.imageReference;
	}

	/**
	 * Updates the image displayed
	 */
	public void setImageReference(final ImageReference value) {
		if (!Objects.equals(imageReference, value)) {
			if (imageReference != null) {
				imageReference.imageProperty().removeListener(imageChangeListener);
			}

			this.imageReference = value;

			if (imageReference == null) {
				imageChangeListener.changed(null, null, null);
			} else {
				imageReference.imageProperty().addListener(new WeakChangeListener<>(imageChangeListener));
				imageChangeListener.changed(null, null, imageReference.getImage());
			}
		}
	}

	public final void setBackgroundColor(final Color value) {
		rectangle.setBackgroundColor(value);
	}

	public final void setOutlineColor(final Color value) {
		rectangle.setOutlineColor(value);
	}

	public final void setLineWidth(final double value) {
		rectangle.setLineWidth(value);
	}

	@Override
	public IGeometry getChopBoxGeometry() {
		return FX2Geometry.toRectangle(getLayoutBounds());
	}
}

class ErrorImage extends Region {
	private static final double STROKE_WIDTH = 4.0;

	private final Rectangle rectangle = new Rectangle();
	private final Path path = new Path();

	public ErrorImage() {
		this.getChildren().addAll(rectangle, path);

		rectangle.setFill(Color.WHITE);
		rectangle.setStrokeWidth(STROKE_WIDTH);
		rectangle.setStrokeType(StrokeType.INSIDE);
		rectangle.setStroke(Color.RED);

		path.setStrokeWidth(STROKE_WIDTH);
		path.setStroke(Color.RED);
		path.setStrokeLineCap(StrokeLineCap.BUTT);
	}

	@Override
	public void resize(double width, double height) {
		super.resize(width, height);
		rectangle.setWidth(width);
		rectangle.setHeight(height);

		path.getElements().setAll(new MoveTo(STROKE_WIDTH, STROKE_WIDTH),
				new LineTo(width - STROKE_WIDTH, height - STROKE_WIDTH), new MoveTo(width - STROKE_WIDTH, STROKE_WIDTH),
				new LineTo(STROKE_WIDTH, height - STROKE_WIDTH));
	}
}
