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
package org.osate.pluginsupport;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.ui.statushandlers.StatusManager;
import org.osgi.framework.Bundle;

/**
 * Utility methods
 *
 * @author lwrage
 * @version $Id: PluginSupportUtil.java,v 1.2 2007-06-04 17:03:01 lwrage Exp $
 */
public class PluginSupportUtil {
	private static List<URI> getContributedAadl(final Function<IConfigurationElement, URI> makeUri) {
		ArrayList<URI> result = new ArrayList<URI>();
		IExtensionRegistry extensionRegistry = Platform.getExtensionRegistry();
		IExtensionPoint extensionPoint = extensionRegistry.getExtensionPoint(PluginSupportPlugin.PLUGIN_ID,
				PluginSupportPlugin.AADL_CONTRIBUTION_EXTENSION_ID);
		IExtension[] exts = extensionPoint.getExtensions();

		for (int i = 0; i < exts.length; i++) {
			IConfigurationElement[] configElems = exts[i].getConfigurationElements();

			for (int j = 0; j < configElems.length; j++) {
				result.add(makeUri.apply(configElems[j]));
			}
		}
		return result;
	}

	public static List<URI> getContributedAadl() {
		return getContributedAadl(configElem -> {
			String path = configElem.getAttribute("file");
			String fullpath = configElem.getDeclaringExtension().getContributor().getName()
					+ (path.charAt(0) == '/' ? "" : "/") + path;
			return URI.createPlatformPluginURI(fullpath, false);
		});
	}

	private static Map<URI, String> contributedPropertySets = null;

	/**
	 * Gets all of the plugin contributed property sets, but not packages. Entries in the returned map are from the
	 * property set's URI to its name.
	 * @since 2.0
	 */
	public static Map<URI, String> getContributedPropertySets() {
		if (contributedPropertySets == null) {
			Map<URI, String> modifiablePropertySets = new HashMap<>();
			for (URI uri : getContributedAadl()) {
				getPropertySetName(uri).ifPresent(name -> modifiablePropertySets.put(uri, name));
			}
			contributedPropertySets = Collections.unmodifiableMap(modifiablePropertySets);
		}
		return contributedPropertySets;
	}

	private static Optional<String> getPropertySetName(URI uri) {
		if (uri.segmentCount() > 2) {
			Bundle bundle = Platform.getBundle(uri.segment(1));
			IPath path = new Path(
					uri.segmentsList().subList(2, uri.segmentCount()).stream().collect(Collectors.joining("/")));
			try (BufferedReader reader = new BufferedReader(
					new InputStreamReader(FileLocator.openStream(bundle, path, false)))) {
				String contents = reader.lines().map(line -> {
					int commentIndex = line.indexOf("--");
					if (commentIndex == -1) {
						return line;
					} else {
						return line.substring(0, commentIndex);
					}
				}).collect(Collectors.joining("\n"));

				// Find property keyword
				int i = 0;
				while (i < contents.length() && Character.isWhitespace(contents.charAt(i))) {
					i++;
				}
				int afterToken = i;
				while (afterToken < contents.length() && !Character.isWhitespace(contents.charAt(afterToken))) {
					afterToken++;
				}
				if (!contents.substring(i, afterToken).toLowerCase().equals("property")) {
					return Optional.empty();
				}
				i = afterToken;

				// Find set keyword
				while (i < contents.length() && Character.isWhitespace(contents.charAt(i))) {
					i++;
				}
				afterToken = i;
				while (afterToken < contents.length() && !Character.isWhitespace(contents.charAt(afterToken))) {
					afterToken++;
				}
				if (!contents.substring(i, afterToken).toLowerCase().equals("set")) {
					return Optional.empty();
				}

				// Find name
				i = afterToken;
				while (i < contents.length() && Character.isWhitespace(contents.charAt(i))) {
					i++;
				}
				afterToken = i;
				while (afterToken < contents.length() && !Character.isWhitespace(contents.charAt(afterToken))) {
					afterToken++;
				}
				return Optional.of(contents.substring(i, afterToken));
			} catch (IOException e) {
				IStatus status = new Status(IStatus.ERROR, PluginSupportPlugin.PLUGIN_ID,
						"Unable to read contributed file.", e);
				StatusManager.getManager().handle(status);
				return Optional.empty();
			}
		} else {
			return Optional.empty();
		}
	}

	private static final String CLASSPATH_PREFIX = "classpath:/";

	public static List<URI> getContributedAadlAsClasspath() {
		return getContributedAadl(configElem -> {
			String path = configElem.getAttribute("file");
			return URI.createURI(CLASSPATH_PREFIX + path);
		});
	}

	public static OptionalInt getFirstSignificantIndex(URI uri) {
		return IntStream.range(2, uri.segmentCount()).filter(index -> {
			String segment = uri.segment(index);
			return !(segment.startsWith("resource") || segment.startsWith("package") || segment.startsWith("propert"));
		}).findFirst();
	}
}
