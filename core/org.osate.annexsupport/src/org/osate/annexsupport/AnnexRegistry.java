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
 * For headlesx (non-eclipse) applications, there are two options:
 *
 * <ol>
 * <li>Force the environment to read the <code>plugin.xml</code> files and initialize the Eclipse extension registry.  This is done
 * by calling {@link #initializeExtensionRegistry}.  This can be slow because all the plug-ins need to be searched.
 *
 * <li>Register the annex extensions that you care about using method calls.  This is most easily done using the {@link #registerAnnex}
 * method.
 * </ol>
 *
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

	@SuppressWarnings("rawtypes")
	private static final Map registries = new HashMap();

	/** The extensions in this registry */
	@SuppressWarnings("rawtypes")
	protected Map extensions;

	/**
	 * Get the annex parser registry.
	 *
	 * @return the single instance of this class.
	 */
	@SuppressWarnings("unchecked")
	public static AnnexRegistry getRegistry(String extensionId) {
		AnnexRegistry registry = (AnnexRegistry) registries.get(extensionId);

		if (registry == null) {
			registry = createRegistry(extensionId);
			registries.put(extensionId, registry);
		}
		return registry;
	}

	protected static AnnexRegistry createRegistry(String extensionId) {
		if (extensionId.equalsIgnoreCase(ANNEX_PARSER_EXT_ID)) {
			return new AnnexParserRegistry();
		} else if (extensionId.equalsIgnoreCase(ANNEX_UNPARSER_EXT_ID)) {
			return new AnnexUnparserRegistry();
		} else if (extensionId.equalsIgnoreCase(ANNEX_RESOLVER_EXT_ID)) {
			return new AnnexResolverRegistry();
		} else if (extensionId.equalsIgnoreCase(ANNEX_LINKINGSERVICE_EXT_ID)) {
			return new AnnexLinkingServiceRegistry();
		} else if (extensionId.equalsIgnoreCase(ANNEX_TEXTPOSITIONRESOLVER_EXT_ID)) {
			return new AnnexTextPositionResolverRegistry();
		} else if (extensionId.equalsIgnoreCase(ANNEX_INSTANTIATOR_EXT_ID)) {
			return new AnnexInstantiatorRegistry();
		} else if (extensionId.equalsIgnoreCase(ANNEX_HIGHLIGHTER_EXT_ID)) {
			return new AnnexHighlighterRegistry();
		} else if (extensionId.equalsIgnoreCase(ANNEX_CONTENT_ASSIST_EXT_ID)) {
			return new AnnexContentAssistRegistry();
		}

		return null;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected void initialize(String extensionId) {
		extensions = new HashMap();

		boolean hasExtensionPoints = false;
		final IExtensionRegistry extensionRegistry = Platform.getExtensionRegistry();
		if (extensionRegistry != null) {
			IExtensionPoint extensionPoint = extensionRegistry.getExtensionPoint(AnnexPlugin.PLUGIN_ID, extensionId);
			if (extensionPoint != null) {
				hasExtensionPoints = true;
				IExtension[] exts = extensionPoint.getExtensions();

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
		}

		if (!hasExtensionPoints) {
			/* Running outside of eclipse and the extension registry is missing: just use the default support */
			final Object defaultHandler = getDefault();
			if (defaultHandler != null) {
				extensions.put("*", defaultHandler);
			}
		}
	}

	protected Object getDefault() {
		// By default, there is no default thing to do
		return null;
	}

	/**
	 * Used by programs running outside of eclipse (so called "stand alone") to register annex extensions.
	 */
	@SuppressWarnings("unchecked")
	private final void registerExtension(final String annexName, final Object handler) {
		extensions.put(annexName.toLowerCase(), handler);
	}

	/**
	 * Used by programs running outside of eclipse to register annex extensions.  Checks if <code>handler</code>
	 * is <code>null</code>, and doesn't register anything if it is.  This is a convenience method and
	 * is equivalent to
	 *
	 * <code>getRegistry(extensionId).registerProxy(id, name, annexName, className)</code>.
	 */
	private static void registerExtension(final String extensionId, final String annexName, Object handler) {
		if (handler != null) {
			getRegistry(extensionId).registerExtension(annexName, handler);
		}
	}

	public static void registerContentAssist(final String annexName, final AnnexContentAssist extension) {
		registerExtension(ANNEX_CONTENT_ASSIST_EXT_ID, annexName, extension);
	}

	public static void registerHighlighter(final String annexName, final AnnexHighlighter extension) {
		registerExtension(ANNEX_HIGHLIGHTER_EXT_ID, annexName, extension);
	}

	public static void registerInstantiator(final String annexName, final AnnexInstantiator extension) {
		registerExtension(ANNEX_INSTANTIATOR_EXT_ID, annexName, extension);
	}

	public static void registerLinkingService(final String annexName, final AnnexLinkingService extension) {
		registerExtension(ANNEX_LINKINGSERVICE_EXT_ID, annexName, extension);
	}

	public static void registerParser(final String annexName, final AnnexParser extension) {
		registerExtension(ANNEX_PARSER_EXT_ID, annexName, extension);
	}

	public static void registerResolver(final String annexName, final AnnexResolver extension) {
		registerExtension(ANNEX_RESOLVER_EXT_ID, annexName, extension);
	}

	public static void registerTextPositionResolver(final String annexName, final AnnexTextPositionResolver extension) {
		registerExtension(ANNEX_TEXTPOSITIONRESOLVER_EXT_ID, annexName, extension);
	}

	public static void registerUnparser(final String annexName, final AnnexUnparser extension) {
		registerExtension(ANNEX_UNPARSER_EXT_ID, annexName, extension);
	}

	/**
	 * Single method to register an annex from a stand-alone application.
	 */
	public static void registerAnnex(final String annexName, final AnnexParser parser, final AnnexUnparser unparser,
			final AnnexLinkingService linkingService, final AnnexContentAssist contextAssist,
			final AnnexHighlighter highlighter, final AnnexInstantiator instantiator, final AnnexResolver resolver,
			final AnnexTextPositionResolver textPositionResolver) {
		registerParser(annexName, parser);
		registerUnparser(annexName, unparser);
		registerLinkingService(annexName, linkingService);
		registerContentAssist(annexName, contextAssist);
		registerHighlighter(annexName, highlighter);
		registerInstantiator(annexName, instantiator);
		registerResolver(annexName, resolver);
		registerTextPositionResolver(annexName, textPositionResolver);
	}

	/**
	 * Factory method for annex proxies that are created from reading the extension registry.
	 */
	protected abstract AnnexProxy createProxy(IConfigurationElement configElem);
}