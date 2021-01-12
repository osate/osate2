package org.osate.ge.gef;

import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.scene.image.Image;

/**
 * A reference to an image. Created and updated by {@link ImageManager}.
 */
public class ImageReference {
	private ReadOnlyObjectWrapper<Image> image = new ReadOnlyObjectWrapper<Image>(null);

	/**
	 * Creates a new instance
	 */
	ImageReference() {
	}

	/**
	 * Returns the referenced image. If the image is updated, the image will be changed.
	 * @return the referenced image
	 */
	public Image getImage() {
		return image.get();
	}

	/**
	 * Sets the referenced image.
	 * @param value the new referenced image.
	 */
	void setImage(final Image value) {
		image.set(value);
	}

	/**
	 * A read-only property for the referenced image.
	 * @return read-only property for the referenced image.
	 */
	public ReadOnlyObjectProperty<Image> imageProperty() {
		return image.getReadOnlyProperty();
	}
}
