package org.osate.ui.rerun;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.osate.aadl2.instance.SystemInstance;

/**
 * @since 6.0
 */
public interface Runner {
	/**
	 * Get the name of the runner.
	 * @return A non-{@code null} String.
	 */
	public String getName();

	/**
	 * Get the URI of the system instance that will run over.
	 * @return A non-{@code null} URI to a {@link SystemInstance} object.
	 */
	public URI getInstanceURI();

	/**
	 * Get a human readable description of the settings for this run.  SHould include
	 * the URI from {@link #getInstanceURI}.
	 */
	public String getDescription();

	/**
	 * Create a component that displays the settings for this run.  Should not
	 * included the URI from {@link #getInstanceURI}.
	 */
	public Control createContents(Composite parent);

	/**
	 * Get the image to display when showing information about this runner.
	 * @return The image descriptor that describes the image, or {@code null} if
	 * the runner doesn't have a special image.
	 */
	public ImageDescriptor getImageDescriptor();

	/**
	 * Run the task using the given configuration.
	 * @param progress A progress monitor for tracking the progress of the run.
	 * May be {@code null}.
	 */
	public void run(IProgressMonitor progress);

	/**
	 * Runners should implement this method so that the manager can test that
	 * two runs are for the same analysis with same configuration.
	 */
	@Override
	public boolean equals(Object other);
}
