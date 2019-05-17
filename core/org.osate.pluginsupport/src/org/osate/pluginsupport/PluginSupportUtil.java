/**
 * <copyright>
 * Copyright 2006 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/legal/cpl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE "DELIVERABLES") ARE ON AN "AS-IS" BASIS.
 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
 * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
 * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
 * MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
 * APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.
 *
 * Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
 * employees, and agents from all claims or demands made against them (and any related losses, expenses, or
 * attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
 * misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
 * assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
 * product liability, personal injury, death, damage to property, or violation of any laws or regulations.
 *
 * Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 *
 * </copyright>
 */
package org.osate.pluginsupport;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.function.Function;
import java.util.stream.IntStream;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;

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
