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

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

import javafx.scene.image.Image;

/**
 * Class for managing images. Handles loading and reloading images.
 * Does not monitor the file system for changes. Rather reloadImages() should be called to check for changes.
 *
 * All methods except {@link #close()} must be called on the Java FX application thread.
 */
public class ImageManager implements AutoCloseable {
	private final ReferenceQueue<ImageReference> referenceQueue = new ReferenceQueue<>();
	private final Map<Path, WeakImageReference> pathToImageReference = new HashMap<>();
	private final Thread referenceCleanupThread;
	private final Function<Path, File> pathResolver;

	/**
	 * Creates a new instance. Path resolver assumes path are file system paths.
	 */
	public ImageManager() {
		this(Path::toFile);
	}

	/**
	 * Creates a new instance
	 * @param pathResolver converts the path to the file. The path is not required to be a file system path.
	 */
	public ImageManager(final Function<Path, File> pathResolver) {
		this.pathResolver = Objects.requireNonNull(pathResolver, "pathToFile must not be null");

		// Start thread to remove image references from the cache when they are no longer being used.
		final Runnable referenceCleanupRunnable = (Runnable) () -> {
			while (!Thread.currentThread().isInterrupted()) {
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
	 * @param path the path of the image for which to return the reference.
	 * @return the image reference
	 */
	public synchronized ImageReference getImageReference(final Path path) {
		// Get the existing weak reference
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

	/**
	 * Reload all images that have changed
	 */
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

		final File file = pathResolver.apply(weak.path);
		final long lastModified = file == null ? -1 : file.lastModified();

		// Check for changes
		if (weak.lastModified != lastModified) {
			weak.lastModified = lastModified;

			// Update the image
			Image image = null;
			if (file != null && file.exists()) {
				try (final FileInputStream stream = new FileInputStream(file)) {
					image = new Image(stream);

					// Set the image to null to indicate that the image is not loaded if there was an error loading the image.
					if (image.isError()) {
						image = null;
					}
				} catch (final IOException e) {
					// File not found should not be thrown because we check that the file exists.
					// An exception should only be thrown when there is an error closing the file input stream.
					throw new AgeGefRuntimeException("Error refreshing image", e);
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
	/**
	 * The path to the image file
	 */
	final Path path;

	/**
	 * The timestamp of the last modification as returned by {@link File#lastModified()}
	 */
	long lastModified;

	/**
	 * Whether the reference has been removed from the path to image reference map
	 */
	boolean cleanedUp = false;

	/**
	 * Creates a new instance
	 * @param imageReference the image reference
	 * @param path the path to the image
	 * @param q the reference queue used to cleanup the references
	 */
	public WeakImageReference(ImageReference imageReference, final Path path, ReferenceQueue<ImageReference> q) {
		super(imageReference, q);
		this.path = Objects.requireNonNull(path, "path must not be null");
	}
}
