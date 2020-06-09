/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.ge.internal.util;

import java.util.Collections;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.osate.ge.internal.Activator;
import org.osate.ge.internal.services.impl.DefaultExtensionRegistryService;
import org.osgi.framework.FrameworkUtil;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;

public class EclipseExtensionUtil {
	private EclipseExtensionUtil() {
	}

	// Returns an immutable collection containing the objects created by instantiating class referenced by the "class" attribute of all configuration elements
	// with the specified name for a specified extension point.
	public static <T> ImmutableCollection<T> instantiateSimpleExtensions(
			final IExtensionRegistry registry,
			final String extensionPointId, final String elementName, final Class<T> extClass) {
		final ImmutableList.Builder<T> extensionListBuilder = ImmutableList.builder();
		instantiateSimpleExtensions(extensionListBuilder, registry, extensionPointId, elementName, extClass);
		return extensionListBuilder.build();
	}

	private static <T> void instantiateSimpleExtensions(final ImmutableList.Builder<T> extensionListBuilder,
			final IExtensionRegistry registry, final String extensionPointId, final String elementName,
			final Class<T> extClass) {
		final ILog logger = Platform.getLog(FrameworkUtil.getBundle(DefaultExtensionRegistryService.class));
		final IExtensionPoint point = registry.getExtensionPoint(extensionPointId);
		if (point != null) {
			// Iterate over all the extensions
			for (final IExtension extension : point.getExtensions()) {
				for (final IConfigurationElement ce : extension.getConfigurationElements()) {
					if (ce.getName().equals(elementName)) {
						try {
							final Object extObj = ce.createExecutableExtension("class");

							// If object is iterable, add each element
							final Iterable<?> exts;
							if (extObj instanceof Iterable) {
								exts = (Iterable<?>) extObj;
							} else {
								exts = Collections.singletonList(extObj);
							}

							for (final Object ext : exts) {
								if (extClass.isInstance(ext)) {
									extensionListBuilder.add(extClass.cast(ext));
								}
							}
						} catch (final CoreException | ClassCastException ex) {
							logger.log(
									new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Error instantiating extension",
											ex));
						}
					}
				}
			}
		}
	}
}
