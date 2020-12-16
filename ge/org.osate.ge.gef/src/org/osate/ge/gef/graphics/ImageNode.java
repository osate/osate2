package org.osate.ge.gef.graphics;

import java.util.Objects;

import org.eclipse.gef.geometry.convert.fx.FX2Geometry;
import org.eclipse.gef.geometry.planar.IGeometry;
import org.osate.ge.gef.FxStyle;

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
public class ImageNode extends Region implements GraphicNode {
	private ImageReference imageReference;
	private final RectangleNode rectangle = new RectangleNode();
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
		this.getChildren().addAll(rectangle, errorImage, imageView);

		// TODo
//		setLineWidth(2);
//		setBackgroundColor(Color.WHITE);
//		setOutlineColor(Color.BLACK);
//		rect.setStrokeType(StrokeType.INSIDE);
	}

	@Override
	public void layoutChildren() {
		final double width = this.getWidth();
		final double height = this.getHeight();

		imageView.setFitWidth(width);
		imageView.setFitHeight(height);
		imageView.resize(width, height);
		errorImage.resize(width, height);
		rectangle.resize(width, height);
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
	public void apply(FxStyle style) {
		// Applying style is handled by the rectangle child which is styled node.
	}

	@Override
	public IGeometry getOutline() {
		return FX2Geometry.toRectangle(getLayoutBounds());
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
