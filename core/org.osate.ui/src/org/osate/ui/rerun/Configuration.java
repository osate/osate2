package org.osate.ui.rerun;

import org.eclipse.emf.common.util.URI;
import org.osate.aadl2.instance.SystemInstance;

/**
 * @since 6.0
 */
public interface Configuration {
	/**
	 * Get the URI of the system instance used with this configuration.
	 * @return A non-{@code null} URI to a {@link SystemInstance} object.
	 */
	public URI getInstanceURI();
}
