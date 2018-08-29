package org.osate.ge.internal.services;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.osate.aadl2.instance.SystemInstance;

public interface SystemInstanceLoadingService {
	/**
	 * Loads a system instance using the specified key. Depending on the implementation, this operation is likely to be expensive.
	 * @param key as provided by getKey()
	 * @return
	 */
	SystemInstance loadSystemInstance(final IProject project, final String key);

	/**
	 * Returns a string for later loading of the system instance. The string is suitable for long term storage.
	 * @param io
	 * @return
	 */
	String getKey(final SystemInstance systemInstance);

	/**
	 * Returns a string for later loading of the system instance. The string is suitable for long term storage.
	 * @param io
	 * @return
	 */
	String getKey(final IPath systemInstanceFile);
}
