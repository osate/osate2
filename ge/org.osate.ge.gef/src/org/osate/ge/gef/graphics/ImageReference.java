package org.osate.ge.gef.graphics;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.image.Image;

// TODO: Document
// TODO: Move to an image package?
// TODO: Should only be provided by an image service.
// TODO: image service should monitor paths and update image based on that.
public class ImageReference {
	private ObjectProperty<Image> image = new SimpleObjectProperty<Image>(null);

	// TODO
	public Image getImage() {
		return image.get();
	}

	public void setImage(final Image value) {
		image.set(value);
	}

	public ObjectProperty<Image> imageProperty() {
		return image;
	}
}
