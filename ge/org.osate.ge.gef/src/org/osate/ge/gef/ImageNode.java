/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
 * All Rights Reserved.
 *
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 *
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 *
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
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
public class ImageNode extends Region implements ChopBoxGeometryProvider, Stylable {
	private ImageReference imageReference;
	private final Rectangle background = new Rectangle();
	private final Rectangle outline = new Rectangle();
	private final ErrorImage errorImage = new ErrorImage();
	private final ImageView imageView = new ImageView();

	// Update the visible widgets and image view when the image changes
	private final ChangeListener<Image> imageChangeListener = (ChangeListener<Image>) (observable, oldValue,
			newValue) -> {
		imageView.setImage(newValue);
		imageView.setVisible(newValue != null);
		background.setVisible(newValue != null);
		outline.setVisible(newValue != null);
		errorImage.setVisible(newValue == null);
	};

	/**
	 * Create a new instance
	 */
	public ImageNode() {
		// Add children
		this.getChildren().addAll(background, imageView, outline, errorImage);

		imageView.setPreserveRatio(true);
		setImageReference(null);
		outline.setFill(null);
		outline.setStrokeType(StrokeType.INSIDE);
		outline.setStrokeLineCap(StrokeLineCap.BUTT);
		outline.setStrokeWidth(4.0);

		// Apply initial style
		apply(FxStyle.DEFAULT);
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
		background.setWidth(width);
		background.setHeight(height);
		outline.setWidth(width);
		outline.setHeight(height);
	}

	/**
	 * Updates the image displayed
	 * @param value the reference to the image which will be displayed by this node.
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

	@Override
	public final void apply(final FxStyle style) {
		background.setFill(style.getBackgroundColor());
		outline.setStroke(style.getOutlineColor());
	}

	@Override
	public IGeometry getChopBoxGeometry() {
		return FX2Geometry.toRectangle(getLayoutBounds());
	}
}

/**
 * Node shown when an image is not available for display.
 *
 */
class ErrorImage extends Region {
	private static final double STROKE_WIDTH = 4.0;

	private final Rectangle rectangle = new Rectangle();
	private final Path path = new Path();

	/**
	 * Creates a new instance
	 */
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
