/**
 * Copyright (c) 2004-2025 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.ge.internal.services;

import org.eclipse.core.runtime.IPath;
import org.osate.aadl2.instance.SystemInstance;

/**
 * Global service for loading AADL instance models
 *
 */
public interface SystemInstanceLoadingService {
	/**
	 * Loads a system instance using the specified key. Depending on the implementation, this operation is likely to be expensive.
	 * @param key as provided by {@link #getKey(IPath)} and {@link #getKey(SystemInstance)}
	 * @return the loaded system instance. Returns null if the system could not be loaded.
	 */
	SystemInstance loadSystemInstance(final String key);

	/**
	 * Returns a string for later loading of the system instance. The string is suitable for long term storage.
	 * Throws an exception if unable to return the key. Must not return null.
	 * @param systemInstance is the system instance for which to return the key
	 * @return the key for the system instance
	 */
	String getKey(final SystemInstance systemInstance);

	/**
	 * Returns a string for later loading of the system instance. The string is suitable for long term storage. Must not return null.
	 * @param systemInstanceFile is the file of the system instance for which to return the key
	 * @return the key for the system instance
	 */
	String getKey(final IPath systemInstanceFile);
}
