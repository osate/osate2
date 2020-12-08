package org.osate.ge.gef.graphics;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javafx.scene.image.Image;

/**
 * Class for managing images. Handles loading and reloading images.
 * Does not monitor the file system for changes. Rather reloadImages() should be called to check for changes.
 *
 * All function must be called on the Java FX application thread.
 */
public class ImageManager implements AutoCloseable {
	private final ReferenceQueue<ImageReference> referenceQueue = new ReferenceQueue<ImageReference>();
	private final Map<Path, WeakImageReference> pathToImageReference = new HashMap<>();
	private final Thread referenceCleanupThread;

	public ImageManager() {
		// Start thread to remove image references from the cache when they are no longer being used.
		final Runnable referenceCleanupRunnable = (Runnable) () -> {
			while (Thread.currentThread().isInterrupted()) {
				try {
					final WeakImageReference weakRef = (WeakImageReference) referenceQueue.remove();
					cleanup(weakRef);
				} catch (final InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			}
		};

		// Start the reference cleanup thread
		referenceCleanupThread = new Thread(referenceCleanupRunnable);
		referenceCleanupThread.setDaemon(true);
		referenceCleanupThread.start();
	}

	@Override
	public void close() {
		referenceCleanupThread.interrupt();
	}

	/**
	 * Gets an image reference for the specified file path. If an image reference for the path already exists, the existing
	 * instance is returned. When an image reference is no longer referenced, the image will be freed and will be reloaded
	 * if referenced again.
	 */
	public synchronized ImageReference getImageReference(final Path path) {
		// Get the existinge weak reference
		final WeakImageReference ref = pathToImageReference.get(path);
		if (ref != null) {
			// Return the image reference if it is still available
			final ImageReference imageReference = ref.get();
			if (imageReference != null) {
				return imageReference;
			}

			// Otherwise, cleanup the weak reference and treat this as a new image.
			cleanup(ref);
		}

		// Load the image and return an image reference for it.
		final ImageReference imageReference = new ImageReference();
		final WeakImageReference weak = new WeakImageReference(imageReference, path, referenceQueue);
		pathToImageReference.put(path, weak);
		refreshImage(weak);

		return imageReference;

	}

	// Reload all images that have changed
	public synchronized void refreshImages() {
		for (final WeakImageReference weak : pathToImageReference.values()) {
			refreshImage(weak);
		}
	}

	/**
	 * Updates an image for an image reference. If the image has changed, then it is reloaded.
	 * Checks for changes by comparing the last modified timestamp.
	 */
	private synchronized void refreshImage(final WeakImageReference weak) {
		final ImageReference ref = weak.get();
		if (ref == null) {
			return;
		}

		final File file = weak.path.toFile();
		final long lastModified = file.lastModified();

		// Check for changes
		if (weak.lastModified != lastModified) {
			weak.lastModified = lastModified;

			// Update the image
			Image image = null;
			if (file.exists()) {
				try (final FileInputStream stream = new FileInputStream(file)) {
					image = new Image(stream);
				} catch (IOException e) {
					// Print error and then ignore. Will be treated as a missing image.
					e.printStackTrace();
				}
			}

			ref.setImage(image);
		}
	}

	/**
	 * Removes the path contained in the weak image reference from the map used by the cache. Marks the reference as
	 * cleaned up to avoid potentially removing the image twice.
	 */
	private synchronized void cleanup(final WeakImageReference ref) {
		if (!ref.cleanedUp) {
			pathToImageReference.remove(ref.path);
			ref.cleanedUp = true;
		}
	}
}

/**
 * Internal weak reference type. Used to store additional data needed for cleanup.
 *
 */
class WeakImageReference extends WeakReference<ImageReference> {
	final Path path;
	long lastModified;
	boolean cleanedUp = false;

	public WeakImageReference(ImageReference imageReference, final Path path, ReferenceQueue<ImageReference> q) {
		super(imageReference, q);
		this.path = Objects.requireNonNull(path, "path must not be null");
	}
}
