/*
 * <copyright>
 * Copyright  2005 by Carnegie Mellon University, all rights reserved.
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
 * </copyright>
 */
package org.osate.annexsupport;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.osate.aadl2.parsesupport.ParseUtil;

/**
 * @author lwrage
 * @version $Id: AnnexRegistry.java,v 1.4 2007-07-10 20:41:44 jseibel Exp $
 */
public abstract class AnnexRegistry {

	/** ID of annex parser extension point */
	public static final String ANNEX_PARSER_EXT_ID = "parser";

	/** ID of annex unparser extension point */
	public static final String ANNEX_UNPARSER_EXT_ID = "unparser";

	/** ID of annex resolver extension point */
	public static final String ANNEX_RESOLVER_EXT_ID = "resolver";

	/** ID of annex resolver extension point */
	public static final String ANNEX_LINKINGSERVICE_EXT_ID = "linkingservice";

	/** ID of annex resolver extension point */
	public static final String ANNEX_TEXTPOSITIONRESOLVER_EXT_ID = "textpositionresolver";

	/** ID of annex instantiator extension point */
	public static final String ANNEX_INSTANTIATOR_EXT_ID = "instantiator";

	/** ID of annex highlighter extension point */
	public static final String ANNEX_HIGHLIGHTER_EXT_ID = "highlighter";

	/** ID of annex content assist extention point */
	public static final String ANNEX_CONTENT_ASSIST_EXT_ID = "contentassist";

	private static final String ATT_ANNEXNAME = "annexName";
	private static final String ATT_ANNEXNSURI = "annexNSURI";

	private static final Map registries = new HashMap();

	/** The extensions in this registry */
	protected Map extensions;

	/**
	 * Get the annex parser registry.
	 *
	 * @return the single instance of this class.
	 */
	public static AnnexRegistry getRegistry(String extensionId) {
		AnnexRegistry registry = (AnnexRegistry) registries.get(extensionId);

		if (registry == null) {
			registry = createRegistry(extensionId);
			registries.put(extensionId, registry);
		}
		return registry;
	}

	protected static AnnexRegistry createRegistry(String extensionId) {
		if (extensionId == ANNEX_PARSER_EXT_ID) {
			return new AnnexParserRegistry();
		} else if (extensionId == ANNEX_UNPARSER_EXT_ID) {
			return new AnnexUnparserRegistry();
		} else if (extensionId == ANNEX_RESOLVER_EXT_ID) {
			return new AnnexResolverRegistry();
		} else if (extensionId == ANNEX_LINKINGSERVICE_EXT_ID) {
			return new AnnexLinkingServiceRegistry();
		} else if (extensionId == ANNEX_TEXTPOSITIONRESOLVER_EXT_ID) {
			return new AnnexTextPositionResolverRegistry();
		} else if (extensionId == ANNEX_INSTANTIATOR_EXT_ID) {
			return new AnnexInstantiatorRegistry();
		} else if (extensionId == ANNEX_HIGHLIGHTER_EXT_ID) {
			return new AnnexHighlighterRegistry();
		} else if (extensionId == ANNEX_CONTENT_ASSIST_EXT_ID) {
			return new AnnexContentAssistRegistry();
		}

		return null;
	}

	protected void initialize(String extensionId) {
		IExtensionRegistry extensionRegistry = Platform.getExtensionRegistry();
		IExtensionPoint extensionPoint = extensionRegistry.getExtensionPoint(AnnexPlugin.PLUGIN_ID, extensionId);
		IExtension[] exts = extensionPoint.getExtensions();

		extensions = new HashMap();
		for (int i = 0; i < exts.length; i++) {
			IConfigurationElement[] configElems = exts[i].getConfigurationElements();

			for (int j = 0; j < configElems.length; j++) {
				String annexName = configElems[j].getAttribute(ATT_ANNEXNAME);
				String annexNSURI = configElems[j].getAttribute(ATT_ANNEXNSURI);

				if (extensions.get(annexName) != null) {
					AnnexPlugin.logError("Duplicate extension: " + extensionId + ", annex " + annexName, null);
				} else {
					ParseUtil.setAnnexNS(annexName, annexNSURI);

					extensions.put(annexName.toLowerCase(), createProxy(configElems[j]));
				}
			}
		}
	}

	/**
	 * Factory method for annex proxies.
	 */
	protected abstract AnnexProxy createProxy(IConfigurationElement configElem);
}