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

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import java.util.jar.JarFile;
import java.util.jar.Manifest;
import java.util.zip.ZipEntry;

import org.eclipse.core.runtime.ContributorFactorySimple;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IContributor;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.RegistryFactory;
import org.eclipse.core.runtime.spi.IRegistryProvider;
import org.eclipse.core.runtime.spi.RegistryStrategy;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.URIConverter;
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

	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected void initialize(String extensionId) {
		extensions = new HashMap();

		final IExtensionRegistry extensionRegistry = Platform.getExtensionRegistry();
		if (extensionRegistry != null) {
			IExtensionPoint extensionPoint = extensionRegistry.getExtensionPoint(AnnexPlugin.PLUGIN_ID, extensionId);
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
		} else {
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

	/*
	 * Mostly stolen from EcorePlugin$ExtensionProcessor.process()
	 */

	private static boolean initializedAlready = false;

	@FunctionalInterface
	public static interface RegistryLogger {
		public void log(IStatus status);
	}

	private final static RegistryLogger NULL_REGISTRY_LOGGER = new RegistryLogger() {
		@Override
		public void log(final IStatus status) {
			// do nothing
		}
	};

	public static void initializeExtensionRegistry() throws CoreException, IOException {
		initializeExtensionRegistry(NULL_REGISTRY_LOGGER);
	}

	public static synchronized void initializeExtensionRegistry(final RegistryLogger registryLogger)
			throws CoreException, IOException {
		// Ensure processing only happens once and only when not running an Eclipse application.
		//
		if (!initializedAlready && !EMFPlugin.IS_ECLIPSE_RUNNING) {
			initializedAlready = true;

			// If there isn't already a registry...
			//
			IExtensionRegistry registry = RegistryFactory.getRegistry();
			if (registry == null) {
				// Create a new registry.
				//
				final IExtensionRegistry newRegistry = RegistryFactory.createRegistry(new RegistryStrategy(null, null) {
					@Override
					public void log(final IStatus status) {
						registryLogger.log(status);
					}

					@Override
					public String translate(String key, ResourceBundle resources) {
						try {
							// The org.eclipse.core.resources bundle has keys that aren't translated, so avoid exception propagation.
							//
							return super.translate(key, resources);
						} catch (Throwable throwable) {
							return key;
						}
					}
				}, null, null);

				// Make the new registry the default.
				//
				RegistryFactory.setDefaultRegistryProvider(new IRegistryProvider() {
					@Override
					public IExtensionRegistry getRegistry() {
						return newRegistry;
					}
				});

				registry = newRegistry;
			}

			// Use the thread's context class loader.
			//
			final ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

			// Process all the URIs for plugin.xml files from the class path or the class loader.
			//
			for (URI pluginXMLURI : getPluginXMLs(classLoader)) {
				// Construct the URI for the manifest and check that it exists...
				//
				URI pluginLocation;
				URI manifestURI;
				if (pluginXMLURI.isHierarchical()) {
					pluginLocation = pluginXMLURI.trimSegments(1);
					manifestURI = pluginLocation.appendSegments(new String[] { "META-INF", "MANIFEST.MF" });
				} else {
					// We have to do this through string manipulation
					final String uriString = pluginXMLURI.toString();
					final int loc = uriString.lastIndexOf('/');
					final String pluginLocationString = uriString.substring(0, loc + 1);
					pluginLocation = URI.createURI(pluginLocationString);
					final String manifestURIString = pluginLocationString + "META-INF/MANIFEST.MF";
					manifestURI = URI.createURI(manifestURIString);
				}

				if (URIConverter.INSTANCE.exists(manifestURI, null)) {
					InputStream manifestInputStream = null;
					// Read the manifest.
					//
					manifestInputStream = URIConverter.INSTANCE.createInputStream(manifestURI);
					Manifest manifest = new Manifest(manifestInputStream);
					java.util.jar.Attributes mainAttributes = manifest.getMainAttributes();

					// Determine the bundle's name
					//
					String bundleSymbolicName = mainAttributes.getValue("Bundle-SymbolicName");
					if (bundleSymbolicName != null) {
						// Split out the OSGi noise.
						//
						bundleSymbolicName = bundleSymbolicName.split(";")[0].trim();

						// Compute the map entry from platform:/plugin/<bundleSymbolicName>/ to the location URI's root.
						//
						URI logicalPlatformPluginURI = URI.createPlatformPluginURI(bundleSymbolicName, true)
								.appendSegment("");
						URI pluginLocationURI = pluginLocation.isArchive() ? pluginLocation
								: pluginLocation.appendSegment("");

						// Also create a global URI mapping so that any uses of platform:/plugin/<plugin-ID> will map to the physical location of that
						// plugin.
						// This ensures that registered URI mappings that use a relative URI into the plugin will work correctly.
						//
						URIConverter.URI_MAP.put(logicalPlatformPluginURI, pluginLocationURI);

						// Find the localization resource bundle, if there is one.
						//
						String bundleLocalization = mainAttributes.getValue("Bundle-Localization");
						ResourceBundle resourceBundle = null;
						if (bundleLocalization != null) {
							bundleLocalization += ".properties";
							InputStream bundleLocalizationInputStream = URIConverter.INSTANCE
									.createInputStream(pluginLocation.appendSegment(bundleLocalization));
							resourceBundle = new PropertyResourceBundle(bundleLocalizationInputStream);
							bundleLocalizationInputStream.close();
						}

						// Add the contribution.
						//
						InputStream pluginXMLInputStream = URIConverter.INSTANCE.createInputStream(pluginXMLURI);
						IContributor contributor = ContributorFactorySimple.createContributor(bundleSymbolicName);
						registry.addContribution(pluginXMLInputStream, contributor, false, bundleSymbolicName,
								resourceBundle, null);
					}
				}
			}
		}
	}

	/*
	 * Stolen from EcorePlugin
	 */
	private static List<URI> getPluginXMLs(ClassLoader classLoader) {
		List<URI> result = new ArrayList<URI>();

		String classpath = null;
		try {
			// Try to get the classpath from the class loader.
			//
			Method method = classLoader.getClass().getMethod("getClassPath");
			if (method != null) {
				classpath = (String) method.invoke(classLoader);
			}
		} catch (Throwable throwable) {
			// Failing that, get it from the system properties.
			//
			classpath = System.getProperty("java.class.path");
		}

		// Keep track of whether we find any plugin.xml in the parent of a folder on the classpath, i.e., whether we're in development mode with bin folders on
		// the classpath.
		//
		boolean nonClasspathXML = false;

		// If we have a classpath to use...
		//
		if (classpath != null) {
			// Split out the entries on the classpath.
			//
			for (String classpathEntry : classpath.split(File.pathSeparator)) {
				classpathEntry = classpathEntry.trim();

				// Determine if the entry is a folder or an archive file.
				//
				File file = new File(classpathEntry);
				if (file.isDirectory()) {
					// Determine if there is a plugin.xml at the root of the folder.
					//
					File pluginXML = new File(file, "plugin.xml");
					if (!pluginXML.exists()) {
						// If not, check if there is one in the parent folder.
						//
						File parentFile = file.getParentFile();
						pluginXML = new File(parentFile, "plugin.xml");
						if (pluginXML.isFile()) {
							// If there is, then we have plugin.xml files that aren't on the classpath.
							//
							nonClasspathXML = true;
						} else if (parentFile != null) {
							// The parent has a parent, check if there is one in the parent's parent folder.
							//
							pluginXML = new File(parentFile.getParentFile(), "plugin.xml");
							if (pluginXML.isFile()) {
								// If there is, then we have plugin.xml files that aren't on the classpath.
								//
								nonClasspathXML = true;
							} else {
								// Otherwise this is bogus too.
								//
								pluginXML = null;
							}
						} else {
							// Otherwise this is bogus too.
							//
							pluginXML = null;
						}
					}

					// If we found a plugin.xml, create a URI for it.
					//
					if (pluginXML != null) {
						result.add(URI.createFileURI(pluginXML.getPath()));
					}
				} else if (file.isFile()) {
					// The file must be a jar...
					//
					JarFile jarFile = null;
					try {
						// Look for a plugin.xml entry...
						//
						jarFile = new JarFile(classpathEntry);
						ZipEntry entry = jarFile.getEntry("plugin.xml");
						if (entry != null) {
							// If we find one, create a URI for it.
							//
							result.add(URI.createURI("archive:" + URI.createFileURI(classpathEntry) + "!/" + entry));
						}
					} catch (IOException exception) {
						// Ignore.
					} finally {
						if (jarFile != null) {
							try {
								jarFile.close();
							} catch (IOException exception) {
								AnnexPlugin.logError(exception);
							}
						}
					}
				}
			}
		}

		// If we didn't find any non-classpath plugin.xml files, use the class loader to enumerate all the plugin.xml files.
		// This is more reliable given the possibility of specialized class loader behavior.
		//
		if (!nonClasspathXML) {
			result.clear();
			try {
				for (Enumeration<URL> resources = classLoader.getResources("plugin.xml"); resources
						.hasMoreElements();) {
					// Create a URI for each plugin.xml found by the class loader.
					//
					URL url = resources.nextElement();
					result.add(URI.createURI(url.toURI().toString()));
				}
			} catch (IOException exception) {
				AnnexPlugin.logError(exception);
			} catch (URISyntaxException exception) {
				AnnexPlugin.logError(exception);
			}
		}

		return result;
	}
}