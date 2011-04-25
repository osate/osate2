/*
 * <copyright>
 * Copyright  2004 by Carnegie Mellon University, all rights reserved.
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
package org.osate.aadl2.modelsupport.eclipseinterface;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourceAttributes;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Preferences;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMLParserPoolImpl;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.preference.PreferenceStore;
import org.eclipse.swt.SWTException;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Element;
import org.osate.aadl2.GlobalNamespace;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.PrivatePackageSection;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyConstant;
import org.osate.aadl2.PropertySet;
import org.osate.aadl2.PropertyType;
import org.osate.aadl2.PublicPackageSection;
import org.osate.aadl2.impl.GlobalNamespaceImpl;
import org.osate.aadl2.modelsupport.Activator;
import org.osate.aadl2.util.Aadl2ResourceImpl;
import org.osate.internal.workspace.AadlWorkspace;
import org.osate.pluginsupport.PluginSupportUtil;
import org.osate.workspace.IResourceUtility;
import org.osate.workspace.WorkspacePlugin;
import org.osate.workspace.names.standard.AadlProject;
import org.osate.workspace.names.standard.CommunicationProperties;
import org.osate.workspace.names.standard.DeploymentProperties;
import org.osate.workspace.names.standard.MemoryProperties;
import org.osate.workspace.names.standard.ModelingProperties;
import org.osate.workspace.names.standard.ProgrammingProperties;
import org.osate.workspace.names.standard.ThreadProperties;
import org.osate.workspace.names.standard.TimingProperties;


/* TODO: [PROPERTIES] uncomment and fixed when properties are added
 import org.osate.aadl2.EnumLiteral;
 import org.osate.aadl2.EnumType;
 import org.osate.aadl2.PropertyConstant;
 import org.osate.aadl2.PropertyDefinition;
 import org.osate.aadl2.PropertySet;
 import org.osate.aadl2.PropertyType;
 import org.osate.aadl2.UnitLiteral;
 import org.osate.aadl2.UnitsType;
 */

/**
 * static utility methods for handling models as persistent resources
 * 
 * @author phf
 * @version $Id: OsateResourceManager.java,v 1.17 2009-07-09 19:23:11 jseibel
 *          Exp $
 */
public class OsateResourceManager {

	/**
	 * Reference to the global namespace singleton for OSATE.
	 */
	public static final GlobalNamespace GLOBAL_NAMESPACE = new OsateGlobalNamespace();

	private static final Set<String> PREDECLARED_PROPERTY_SET_UPPER_CASE_NAMES;

	static {
		HashSet<String> predeclaredPropertySetUpperCaseNames = new HashSet<String>();
		predeclaredPropertySetUpperCaseNames.add(DeploymentProperties._NAME
				.toUpperCase());
		predeclaredPropertySetUpperCaseNames.add(ThreadProperties._NAME
				.toUpperCase());
		predeclaredPropertySetUpperCaseNames.add(TimingProperties._NAME
				.toUpperCase());
		predeclaredPropertySetUpperCaseNames.add(CommunicationProperties._NAME
				.toUpperCase());
		predeclaredPropertySetUpperCaseNames.add(MemoryProperties._NAME
				.toUpperCase());
		predeclaredPropertySetUpperCaseNames.add(ProgrammingProperties._NAME
				.toUpperCase());
		predeclaredPropertySetUpperCaseNames.add(ModelingProperties._NAME
				.toUpperCase());
		predeclaredPropertySetUpperCaseNames.add(AadlProject._NAME
				.toUpperCase());
		PREDECLARED_PROPERTY_SET_UPPER_CASE_NAMES = Collections
				.unmodifiableSet(predeclaredPropertySetUpperCaseNames);
	}

	private static boolean DEBUG = true;

	public static final String PLUGIN_RESOURCES_DIRECTORY_NAME = "Plugin_Resources";

	/**
	 * The resource set to be used for all aaxl resources with cross references
	 * to each other This means all packages stored as separate files, as well
	 * as graphic file for an Aadl model
	 */
	protected static OsateResourceSet resourceSet;

	static final XMLParserPoolImpl parserPool = new XMLParserPoolImpl();

	public static final Map<Object, Object> LOAD_OPTIONS;

	public static final Map<Object, Object> SAVE_OPTIONS;
	
	static {
		SAVE_OPTIONS = new HashMap<Object, Object>();
		SAVE_OPTIONS.put(XMLResource.OPTION_ENCODING, "UTF-8");
		SAVE_OPTIONS.put(XMLResource.OPTION_USE_ENCODED_ATTRIBUTE_STYLE, Boolean.TRUE);
		SAVE_OPTIONS.put(XMLResource.OPTION_CONFIGURATION_CACHE, Boolean.TRUE);
		SAVE_OPTIONS.put(XMLResource.OPTION_USE_FILE_BUFFER, Boolean.TRUE);

		LOAD_OPTIONS = new HashMap<Object, Object>();
		LOAD_OPTIONS.put(XMLResource.OPTION_ENCODING, "UTF-8");
		LOAD_OPTIONS.put(XMLResource.OPTION_USE_ENCODED_ATTRIBUTE_STYLE, Boolean.TRUE);
		LOAD_OPTIONS.put(XMLResource.OPTION_DISABLE_NOTIFY, Boolean.TRUE);
		LOAD_OPTIONS.put(XMLResource.OPTION_DEFER_IDREF_RESOLUTION, Boolean.FALSE);
		LOAD_OPTIONS.put(XMLResource.OPTION_USE_PARSER_POOL, parserPool);
	}
	/**
	 * Get the resource set shared by a collection of Aaxl, aagl files if it has
	 * not been initialized, this method will initialize it.
	 * 
	 * @return ResourceSet
	 */
	public static OsateResourceSet getResourceSet() {
		if (resourceSet == null) {
			resourceSet = new OsateResourceSet();
			populateResourceSet();
			loadPluginContributedAadl();
			Activator.getWorkspace().addResourceChangeListener(resourceSet,
					IResourceChangeEvent.POST_CHANGE);
		}
		return resourceSet;
	}

	public static void printResourceSet() {
		if (!DEBUG)
			return;
		if (resourceSet == null)
			return;
		EList<Resource> rl = resourceSet.getResources();
		System.out.println("ResourceSet");
		for (Resource r : rl) {
			System.out.println("  " + r.getURI().path());
		}
	}

	/**
	 * removes the resources from the resourceset Does unload resources from
	 * resourceset
	 */
	public static void removeResources() {
		final List<Resource> reslist = getResourceSet().getResources();
		final List<Aadl2ResourceImpl> temp = new ArrayList<Aadl2ResourceImpl>(
				reslist.size());
		for (Resource res : reslist) {
			// Don't unload standard property sets
			if ((res instanceof Aadl2ResourceImpl) && (res.isLoaded())) {
				temp.add((Aadl2ResourceImpl) res);
			}
		}

		for (Aadl2ResourceImpl res : temp) {
			removeResource(res);
		}
		temp.clear();
	}

	/**
	 * Unload and remove from the resource set the Resource associated with the
	 * given IResource.
	 * 
	 * @param ires
	 */
	public static void removeResource(IResource ires) {
		if (ires == null)
			return;
		IPath path = ires.getFullPath();
		EList<Resource> reslist = getResourceSet().getResources();
		URI resuri = URI.createPlatformResourceURI(path.toString(), false);
		for (Resource res : reslist) {
			if (res.getURI().equals(resuri)) {
				res.unload();
				getResourceSet().getResources().remove(res);
				return;
			}
		}
	}

	/**
	 * Unload and remove from the resource set the given Resource. If the
	 * Resource is not part of the resource set no action is taken (i.e., it is
	 * <em>not</em> unloaded).
	 */
	public static void removeResource(Resource res) {
		final EList<Resource> resources = getResourceSet().getResources();
		res.unload();
		resources.remove(res);
	}

	/**
	 * add all model files in workspace into resourceset. If they are already in
	 * the resource set. force their reload.
	 */
	public static void populateResourceSet() {
		// loadPluginContributedAadl();
		EList<IFile> files = AadlWorkspace.getAadlWorkspace()
				.getAllModelFiles();
		populateResourceSet(files);
	}

	/**
	 * add all model files into resourceset. If they are already in the resource
	 * set. force their reload.
	 * 
	 * @param files
	 */
	public static void populateResourceSet(final List<? extends IFile> files) {
		if (files.size() > 5) {
			try {
				ProgressMonitorDialog progressDialog = new ProgressMonitorDialog(
						Display.getDefault().getActiveShell());
				try {
					progressDialog.run(true, false,
							new IRunnableWithProgress() {
								public void run(IProgressMonitor monitor)
										throws InvocationTargetException,
										InterruptedException {
									OsateResourceManager.run(files, monitor);
								}
							});
				} catch (InvocationTargetException ite) {
					Activator.logThrowable(ite);
				} catch (InterruptedException ie) {
					Activator.logThrowable(ie);
				}
			} catch (SWTException e) {
				doModelFiles(files);
			}

		} else {
			doModelFiles(files);
		}
	}

	private static void doModelFiles(List<? extends IFile> files) {
		for (IFile ires : files) {
			IPath path = ires.getFullPath();
			URI uri = URI.createPlatformResourceURI(path.toString(), false);
			forceLoadResource(uri);
		}
	}

	/**
	 * force the loading of a resource identified by the uri. Reload if it was
	 * already loaded, but not if just saved.
	 * 
	 * @param uri
	 */
	public static void forceLoadResource(URI uri) {
		Resource res = findResource(uri);
		if (res != null) {
			if (res instanceof Aadl2ResourceImpl) {
				if (!((Aadl2ResourceImpl) res).getJustSaved()) {
					reload(res);
				} else {
					((Aadl2ResourceImpl) res).setJustSaved(false);
				}
			}
		} else {
			getResource(uri);
		}
	}

	/**
	 * add all model files in workspace into resourceset.
	 * 
	 */
	protected static void run(final List<? extends IFile> files,
			final IProgressMonitor monitor) {
		monitor.beginTask("Loading aaxl files", files.size());
		for (IFile ires : files) {
			IPath path = ires.getFullPath();
			URI uri = URI.createPlatformResourceURI(path.toString(), false);
			forceLoadResource(uri);
			monitor.worked(1);
		}
		monitor.done();
	}

	/**
	 * load resource
	 * 
	 * @param res
	 *            resource
	 */
	public static void load(Resource res) {
		if (!res.isLoaded()) {
			try {
				if (res instanceof Aadl2ResourceImpl) {
					((Aadl2ResourceImpl) res).load();
				} else {
					res.load(Collections.EMPTY_MAP);
				}
			} catch (IOException e1) {
				Activator.logThrowable(e1);
			}
		}
		return;
	}

	/**
	 * load resource
	 * 
	 * @param res
	 *            resource
	 */
	public static void reload(Resource res) {
		if (res == null)
			return;
		if (res.isLoaded()) {
			res.unload();
		}
		load(res);
		return;
	}

	/**
	 * save the resource as aaxl file Called by the editors. Will propagate the
	 * model change to update references.
	 * 
	 * @param res
	 *            Resource
	 */
	public static void save(Resource res) {

		Preferences prefs = WorkspacePlugin.getDefault().getPluginPreferences();
		String referenceFlag = prefs
				.getString(WorkspacePlugin.EMF_REFERENCE_FLAG);
		doSaveResource(res);
		if (referenceFlag.equalsIgnoreCase("true")) {
			// we are saving in EMF. Need to update EMF reference to model
			doPropagateModelChange(res);
		}
	}

	/**
	 * saves the resource as CoreResource with the correct map and marks it as
	 * just saved If it is a regular Resource (like a diagram file) it gets
	 * saved with a basic map This is a utility method used by the save method
	 * called by editors or called by the parser to save as derived file.
	 * 
	 * @param res
	 */
	private static void doSaveResource(Resource res) {
		try {
			if (res instanceof Aadl2ResourceImpl) {
				((Aadl2ResourceImpl) res).setJustSaved(true);
				((Aadl2ResourceImpl) res).save();

			} else {
				Map<String, Object> options = new HashMap<String, Object>();
				options.put(XMLResource.OPTION_ENCODING, "UTF-8");
				options.put(XMLResource.OPTION_USE_ENCODED_ATTRIBUTE_STYLE,
						Boolean.TRUE);
				res.save(options);
			}
		} catch (IOException e1) {
			if (res instanceof Aadl2ResourceImpl)
				((Aadl2ResourceImpl) res).setJustSaved(false);
			Activator.logThrowable(e1);
		}

	}

	/**
	 * converts Resource into corresponding IResource without use of registry.
	 * 
	 * @param res
	 *            Resource
	 * @return IResource
	 */
	public static IResource convertToIResource(Resource res) {
		if (res == null)
			return null;
		URI uri = res.getURI();
		IWorkspaceRoot myWorkspaceRoot = ResourcesPlugin.getWorkspace()
				.getRoot();
		if (uri != null) {
			IPath path = getOsatePath(uri);
			return myWorkspaceRoot.getFile(path);
		}
		return null;
	}

	/**
	 * return the IResource of the given path
	 * 
	 * @param path
	 * @return IResource
	 */
	public static IResource getIResource(IPath path) {
		IWorkspaceRoot myWorkspaceRoot = ResourcesPlugin.getWorkspace()
				.getRoot();
		IResource ires = myWorkspaceRoot.getFile(path);
		return ires;
	}

	/**
	 * gets Resource for given IResource. Will create the resource if it does
	 * not exist
	 * 
	 * @param ires
	 *            IResource
	 * @return Resource
	 */
	public static Resource getResource(IResource ires) {
		IPath path = ires.getFullPath();
		return getResource(URI
				.createPlatformResourceURI(path.toString(), false));
	}

	/**
	 * gets Resource for given URI. Will create the resource if it does not
	 * exist
	 * 
	 * @param uri
	 *            URI
	 * @return Resource
	 */
	public static Resource getResource(URI uri) {
		Resource res = null;
		try {
			res = getResourceSet().getResource(uri, true);
		} catch (RuntimeException e) {
			// the resource may have been created but load failed
			// let's retrieve the resource without loading
			// NOTE: since demandload is false it will not even be created if it
			// does not already
			// exist
			res = getResourceSet().getResource(uri, false);
			// if the retrieval fails create the resource
			if (res == null)
				res = getResourceSet().createResource(uri);
		}
		return res;
	}

	/**
	 * gets Resource for given URI. returns null if it does not exist or load
	 * failed
	 * 
	 * @param uri
	 *            URI
	 * @return Resource
	 */
	public static Resource loadResource(URI uri) {
		Resource res = null;
		try {
			res = getResourceSet().getResource(uri, true);
		} catch (RuntimeException e) {
			// the resource may have been created but load failed
			// let's retrieve the resource without loading
			if (res != null) {
				removeResource(OsateResourceManager.convertToIResource(res));
				return null;
			}
		}
		return res;
	}

	/**
	 * Find the resource for given URI, but do not demand load
	 * 
	 * @param uri
	 *            URI
	 * @return Resource, null if it is not in the resource set.
	 */
	public static Resource findResource(URI uri) {
		return getResourceSet().getResource(uri, false);
	}

	/**
	 * Find the resource for given name in resource set This is done by
	 * comparing the name with the name in the root object of a CoreResourceImpl
	 * 
	 * @param name
	 *            String
	 * @return Resource, null if it is not in the resource set.
	 */
	public static Resource findResource(String name) {
		if (name.length() == 0)
			return null;
		for (Resource resobj : getResourceSet().getResources()) {
			if (resobj instanceof Aadl2ResourceImpl) {
				Aadl2ResourceImpl res = (Aadl2ResourceImpl) resobj;
				URI uri = res.getURI();
				String uriName = uri.trimFileExtension().lastSegment();
				if (name.equalsIgnoreCase(uriName)) {
					return res;
				}
				EList<EObject> el = res.getContents();
				if (!el.isEmpty()) {
					EObject obj = el.get(0);
					if (obj instanceof NamedElement) {
						String objname = ((NamedElement) obj).getName();
						if (name.equalsIgnoreCase(objname)) {
							return resobj;
						}
					}
				}
			}
		}
		return null;
	}

	/**
	 * creates a Resource for file name with path within Eclipse If it exists,
	 * it will empty its content.
	 * 
	 * @param uri
	 *            uri
	 * @return Resource
	 */
	public static Resource getEmptyResource(URI uri) {
		Resource res = null;

		/*
		 * XXX: THis try-catch block is out of date: Both the try and catch do
		 * the same thing. This needs to be rethough?
		 */
		try {
			res = getResourceSet().getResource(uri, false);
		} catch (RuntimeException e) {
			// the resource may have been created but load failed
			// let's retrieve the resource without loading
			// NOTE: since demandload is false it will not even be created if it
			// does not already
			// exist
			res = getResourceSet().getResource(uri, false);
		}
		if (res == null) {
			res = getResourceSet().createResource(uri);
		} else {
			if (res.isLoaded()) {
				res.unload();
			}
			if (!res.getContents().isEmpty())
				res.getContents().clear();

			// now clear all markers
			final IResource iResource = convertToIResource(res);
			if (iResource != null && iResource.exists()) {
				try {
					iResource.deleteMarkers(null, true,
							IResource.DEPTH_INFINITE);
				} catch (CoreException e1) {
					Activator.logThrowable(e1);
				}
			}
		}
		return res;
	}

	/**
	 * return the IPath for the path. Strips the leading "resource" as necessary
	 * 
	 * @param resourceURI
	 *            The URI of the Resource
	 * @return IPath to the file identified by the URI
	 * @exception IllegalArgumentException
	 *                Thrown if the URI is does not use the "platform:"
	 *                protocol.
	 */
	public static IPath getOsatePath(final URI resourceURI) {
		/*
		 * I don't really understand why this method does what it does, but the
		 * point seems to be to take a URI for a Resource that resembles
		 * "platform:/resource/xxx/yyy/zzz" and return the Eclipse IPath to the
		 * file for that Resource. This seems to involve removing the
		 * "/resource/" part.
		 * 
		 * --aarong
		 */

		// Is it a "plaform:" uri?
		if (resourceURI.scheme() != null
				&& resourceURI.scheme().equalsIgnoreCase("platform")) {
			// Get the segments. See if the first is "resource"
			final String[] segments = resourceURI.segments();
			final StringBuffer path = new StringBuffer();

			if (segments.length >= 1) {
				final int firstSegment = segments[0].equals("resource") ? 1 : 0;
				final int lastIdx = segments.length - 1;
				for (int i = firstSegment; i < (lastIdx); i++) {
					path.append(segments[i]);
					path.append('/');
				}
				if (lastIdx >= 0)
					path.append(segments[lastIdx]);
			}
			return new Path(null, path.toString());
		} else if (resourceURI.isFile()) {
			return new Path(resourceURI.toFileString());
		} else {
			throw new IllegalArgumentException("Cannot decode URI protocol: "
					+ resourceURI.scheme());
		}
	}

	/**
	 * is the file an XML file of an Aadl model. Currently checks for extension
	 * "aaxl"
	 * 
	 * @param ires
	 */
	public static boolean isAadlXMLResource(IResource ires) {
		if (!(ires instanceof IFile))
			return false;
		String ext = ires.getFileExtension();
		if (ext == null)
			return false;
		return WorkspacePlugin.MODEL_FILE_EXT.equalsIgnoreCase(ext);
	}

	/**
	 * Given an IResource, returns the root Element of the contains aadl meta
	 * model, if the resource contains one. Returns <code>null</code> otherwise.
	 */
	public static Element getElementFromIResource(IResource ires) {
		if (!isAadlXMLResource(ires)) {
			return null;
		} else {
			Resource resource = getResource(ires);
			if (resource == null) {
				return null;
			} else {
				if (!resource.getContents().isEmpty()) {
					return (Element) resource.getContents().get(0);
				} else {
					return null;
				}
			}
		}
	}

	/**
	 * Find an AADL property set by name in a resource in the resource set. The
	 * lookup is controlled by the given <code>context</code> object, which is
	 * the object on whose behalf the lookup is being performed. If the object
	 * is inside an AadlSpec that contains local property set or defintions, we
	 * first try to find the named property set in those local definitions. If
	 * not found, or if the AadlSpec doesn't contain local property definitions,
	 * the global name space is searched. If the <code>context</code> is
	 * <code>null</code> then the search starts with global name space.
	 * 
	 * TODO: This global name space is bounded by the projects that the project
	 * that contains the AadlSpec is declared to depend on.
	 * 
	 * @param psn
	 *            String property set name
	 * @param context
	 *            The model object on whose behalf this lookup is being
	 *            performed. For example, this could be the AadlSpec of the
	 *            model being analyzed. Or it could be the object whose property
	 *            values are of interest.
	 * @return Reference to the property set, null if not found.
	 */

	/*
	 * TODO: [PROPERTIES] Uncomment and fixed when properties are added public
	 * static PropertySet findPropertySet(String psn, AObject context) { if (psn
	 * == null || psn.length() == 0) { return null; }
	 * 
	 * // Get the NameSpace that we should search final AadlSpec localSpec =
	 * getPropertySetNameSpace(context);
	 * 
	 * // local lookup if (localSpec != null) { final PropertySet ps =
	 * localSpec.findPropertySet(psn); if (ps != null) return ps; } return
	 * findPropertySet(psn); }
	 */

	// TODO: [SPECIFICATION] Consider removing this method because AadlSpecs no
	// longer exist.
	// /**
	// * Return the property set name space for the object. This is either
	// * <code>null</code> or an {@link AadlSpec} object. If <code>null</code>,
	// * only the globally declared property sets are relevent to this element.
	// If
	// * non-<code>null</code> then referenced AadlSpec contains at least one
	// * locally declared property set whose contents take precedence over any
	// * globally declared property sets when interpreting this element. For a
	// * declarative model element, this AadlSpec object is the aadl spec that
	// * contains the element. For an instance model element the AadlSpec object
	// * is the aadl spec that contains the system implementation declaration
	// that
	// * is instantiated by the instance model.
	// *
	// * Returns <code>null</code> if the given object is <code>null</code>.
	// *
	// * @param obj
	// * The model object for which the name space is needed.
	// * @return See description.
	// */
	// private static AadlSpecification getPropertySetNameSpace(final AObject
	// obj) {
	// if (obj == null) {
	// return null;
	// } else {
	// final AadlSpecification spec = ((Element)obj).getAadlSpecification();
	// /* If the AadlSpec is not a global property set but contains at least
	// * one property set declaration, return the spec
	// */
	// if (spec == null)
	// return null;
	// if (spec.isSpecification() ){ /* TODO: [PROPERTIES] &&
	// (spec.getPropertySet().size() > 0)) {*/
	// return spec;
	// } else {
	// return null;
	// }
	// }
	// }
	/**
	 * Find an AADL property set by name in a resource in the resource set, in
	 * global namespace only
	 * 
	 * @param psn
	 *            String property set name; must be non-null and have a non-zero
	 *            length.
	 * @return Reference to the property set, null if not found.
	 */
	/*
	 * TODO: [PROPERTIES] uncomment and fix when properties are added private
	 * static PropertySet findPropertySet(String psn) { // already check in
	 * caller // if (psn == null || psn.length() == 0) { // return null; // }
	 * PropertySet ps = findPropertySetInResourceSet(psn); if (ps == null) { //
	 * make sure all files are loaded and try again // populateResourceSet(); //
	 * ps = findPropertySetInResourceSet(psn); }
	 * 
	 * return ps; }
	 */

	/**
	 * Find an AADL property set by name in a resource in the resource set, in
	 * global namespace only
	 * 
	 * @param psn
	 *            String property set name; must be non-null and have a non-zero
	 *            length.
	 * @return Reference to the property set, null if not found.
	 */

	/*
	 * TODO: [PROPERTIES] uncomment when properties added private static
	 * PropertySet findPropertySetInModel(String psn, AObject obj) { PropertySet
	 * ps = findPropertySetInResourceSet(psn, obj.eResource().getResourceSet());
	 * if (ps == null) { // make sure all files are loaded and try again //
	 * populateResourceSet(); // ps = findPropertySetInResourceSet(psn); }
	 * 
	 * return ps; }
	 */

	/**
	 * Find property set in resource set. We only find the resource if it
	 * contains only that property set
	 * 
	 * @param psn
	 *            property set name
	 * @return PropertySet or null
	 */

	/*
	 * TODO: [PROPERTIES] uncomment when properties added public static
	 * PropertySet findPropertySetInResourceSet(String psn) { PropertySet
	 * result1 = null; PropertySet result2 = null; int count = 0;
	 * 
	 * for (Resource r : getResourceSet().getResources()) { PropertySet ps =
	 * getPropertySet(r); if (ps != null) { String name = ps.getName(); if (name
	 * != null && name.equalsIgnoreCase(psn)) { // return ps; if (count == 0)
	 * result1 = ps; else if (count == 1) result2 = ps; count += 1; } } }
	 * 
	 * if (count == 0) { return null; } else if (count == 1) { return result1; }
	 * else if (count == 2) { // See if one of the property sets shadows the
	 * other. final boolean r1pre =
	 * OsateResourceManager.isPredeclaredResource(result1.eResource()); final
	 * boolean r2pre =
	 * OsateResourceManager.isPredeclaredResource(result2.eResource()); if
	 * (r1pre && !r2pre) return result2; if (!r1pre && r2pre) return result1;
	 * 
	 * Neither shadows the other: either both are plug-in property sets or both
	 * are in projects in the workspace. Return the first one we found. This is
	 * consistent with what we had been doing, but we could also return null.
	 * 
	 * return result1; } else { Too many property sets with the same name, just
	 * give up and return the first one we found. This is consistent with what
	 * we had been doing, but we could also return null.
	 * 
	 * return result1; } }
	 */

	/**
	 * Find property set in resource set. We only find the resource if it
	 * contains only that property set
	 * 
	 * @param psn
	 *            property set name
	 * @return PropertySet or null
	 */

	/*
	 * TODO: [PROPERTIES] uncomment when properties added public static
	 * PropertySet findPropertySetInResourceSet(String psn, ResourceSet resset)
	 * { PropertySet result1 = null; PropertySet result2 = null; int count = 0;
	 * 
	 * for (Resource r : resset.getResources()) { PropertySet ps =
	 * getPropertySet(r); if (ps != null) { String name = ps.getName(); if (name
	 * != null && name.equalsIgnoreCase(psn)) { // return ps; if (count == 0)
	 * result1 = ps; else if (count == 1) result2 = ps; count += 1; } } }
	 * 
	 * if (count == 0) { return null; } else if (count == 1) { return result1; }
	 * else if (count == 2) { // See if one of the property sets shadows the
	 * other. final boolean r1pre =
	 * OsateResourceManager.isPredeclaredResource(result1.eResource()); final
	 * boolean r2pre =
	 * OsateResourceManager.isPredeclaredResource(result2.eResource()); if
	 * (r1pre && !r2pre) return result2; if (!r1pre && r2pre) return result1;
	 * 
	 * Neither shadows the other: either both are plug-in property sets or both
	 * are in projects in the workspace. Return the first one we found. This is
	 * consistent with what we had been doing, but we could also return null.
	 * 
	 * return result1; } else { Too many property sets with the same name, just
	 * give up and return the first one we found. This is consistent with what
	 * we had been doing, but we could also return null.
	 * 
	 * return result1; } }
	 */

	/**
	 * Return the property set as the single root of this file. The property set
	 * must be the root itself. If the root object is not a property set or
	 * there is no root, then null is returned.
	 * 
	 * @param res
	 *            Resource to hold PropertySet
	 * @return PropertySet or null
	 */
	public static PropertySet getPropertySet(Resource res) {
		if (res != null) {
			EList<EObject> l = res.getContents();
			if (!l.isEmpty()) {
				EObject obj = l.get(0);
				if (obj instanceof PropertySet) {
					return (PropertySet) obj;
				}
			}
		}
		return null;
	}

	/**
	 * Find an AADL property definition by name.
	 * 
	 * @param propertySet
	 *            The name of the property set in which to look for the property
	 *            definition.
	 * @param propertyName
	 *            The name of the property to look for
	 * @param context
	 *            The model object on whose behalf this lookup is being
	 *            performed. For example, this could be the AadlSpec of the
	 *            model being analyzed. Or it could be the object whose property
	 *            values are of interest. See
	 *            {@link #findPropertySet(String, Element)}
	 * 
	 * @return The {@link edu.cmu.sei.aadl.model.property.PropertyDefinition}of
	 *         the given property if found, or <code>null</code> if the property
	 *         definition cannot be found. The property might not be found if
	 *         either the property set does not exist, or if the property is not
	 *         found in the given property set.
	 */

	/*
	 * TODO: [PROPERTIES] uncomment when properties added 
	 */
	public static Property findProperty(final String propertySet, final String propertyName) 
	{ 
		final PropertySet ps = OsateResourceManager.findPropertySet(propertySet); 
		if (ps !=	  null) 
		{ 
			NamedElement searchResult = ps.findNamedElement(propertyName);
			if (searchResult instanceof Property)
				return (Property) searchResult;
			else
				return null;
		}
		else {
			return null; 
		} 
	}

	/**
	 * Find a predeclared AADL property definition by name.
	 * 
	 * @param propertyName
	 *            The name of the property to look for
	 * @return The {@link Property} of the given property if found, or
	 *         <code>null</code> if the property definition cannot be found. The
	 *         property might not be found if either the property set does not
	 *         exist, or if the property is not found in the given property set.
	 */

	public static Property findProperty(final String propertyName) {
		for (PropertySet predeclaredPropertySet : getPredeclaredPropertySets()) {
			NamedElement searchResult = predeclaredPropertySet
					.findNamedElement(propertyName);
			if (searchResult instanceof Property)
				return (Property) searchResult;
		}
		return null;
	}

	/**
	 * Find a predeclared AADL property definition by name.
	 * 
	 * @param propertyName
	 *            The name of the property to look for
	 * @return The {@link edu.cmu.sei.aadl.model.property.PropertyDefinition}of
	 *         the given property if found, or <code>null</code> if the property
	 *         definition cannot be found. The property might not be found if
	 *         either the property set does not exist, or if the property is not
	 *         found in the given property set.
	 */

	/*
	 * TODO: [PROPERTIES] uncomment when properties added public static
	 * PropertyDefinition findPropertyDefinitionInModel(final String
	 * propertyName, AObject modelobj) { PropertySet ps =
	 * OsateResourceManager.findPropertySetInModel(AadlProperties._NAME,
	 * modelobj); PropertyDefinition pd = null; if (ps != null) { pd =
	 * ps.findPropertyDefinition(propertyName); } if (pd == null) { ps =
	 * OsateResourceManager.findPropertySetInModel(AadlProject._NAME, modelobj);
	 * if (ps != null) { pd = ps.findPropertyDefinition(propertyName); } }
	 * return pd; }
	 */

	/**
	 * Find a predeclared AADL property definition by name.
	 * 
	 * @param propertySetName
	 * @param propertyName
	 *            The name of the property to look for
	 * @return The {@link edu.cmu.sei.aadl.model.property.PropertyDefinition}of
	 *         the given property if found, or <code>null</code> if the property
	 *         definition cannot be found. The property might not be found if
	 *         either the property set does not exist, or if the property is not
	 *         found in the given property set.
	 */

	/*
	 * TODO: [PROPERTIES] uncomment when properties added public static
	 * PropertyDefinition findPropertyDefinitionInModel(final String
	 * propertySetName,final String propertyName, AObject modelobj) {
	 * PropertySet ps =
	 * OsateResourceManager.findPropertySetInModel(propertySetName, modelobj);
	 * PropertyDefinition pd = null; if (ps != null) { pd =
	 * ps.findPropertyDefinition(propertyName); } return pd; }
	 */

	/**
	 * Find an AADL property constant by name.
	 * 
	 * @param propertySet
	 *            The name of the property set in which to look for the property
	 *            constant.
	 * @param constantName
	 *            The name of the constant to look for
	 * @param context
	 *            The model object on whose behalf this lookup is being
	 *            performed. For example, this could be the AadlSpec of the
	 *            model being analyzed. Or it could be the object whose property
	 *            values are of interest. See
	 *            {@link #findPropertySet(String, Element)}
	 * @return The {@link edu.cmu.sei.aadl.model.property.PropertyConstant}of
	 *         the given constant if found, or <code>null</code> if the property
	 *         constant cannot be found. The constant might not be found if
	 *         either the property set does not exist, or if the constant is not
	 *         found in the given property set.
	 */

	public static PropertyConstant findPropertyConstant(final String propertyName) {
		for (PropertySet predeclaredPropertySet : getPredeclaredPropertySets()) {
			NamedElement searchResult = predeclaredPropertySet
					.findNamedElement(propertyName);
			if (searchResult instanceof PropertyConstant)
				return (PropertyConstant) searchResult;
		}
		return null;
	}

	public static PropertyConstant findPropertyConstant(final String propertySet, final String propertyName) 
	{ 
		final PropertySet ps = OsateResourceManager.findPropertySet(propertySet); 
		if (ps !=	  null) 
		{ 
			NamedElement searchResult = ps.findNamedElement(propertyName);
			if (searchResult instanceof PropertyConstant)
				return (PropertyConstant) searchResult;
			else
				return null;
		}
		else {
			return null; 
		} 
	}

	/*
	 * TODO: [PROPERTIES] uncomment when properties added public static
	 * PropertyConstant findPropertyConstant(final String propertySet, final
	 * String constantName, final AObject context) { final PropertySet ps =
	 * OsateResourceManager.findPropertySet(propertySet, context); if (ps !=
	 * null) { return ps.findPropertyConstant(constantName); } else { return
	 * null; } }
	 */

	/**
	 * Find a predeclared AADL property constant by name.
	 * 
	 * @param constantName
	 *            The name of the constant to look for
	 * @return The {@link edu.cmu.sei.aadl.model.property.PropertyConstant}of
	 *         the given constant if found, or <code>null</code> if the property
	 *         constant cannot be found. The constant might not be found if
	 *         either the property set does not exist, or if the constant is not
	 *         found in the predeclared property set.
	 */

	/*
	 * TODO: [PROPERTIES] uncomment when properties added public static
	 * PropertyConstant findPropertyConstant(final String constantName) {
	 * PropertySet ps =
	 * OsateResourceManager.findPropertySet(AadlProperties._NAME, null);
	 * PropertyConstant pc = null; if (ps != null) { pc =
	 * ps.findPropertyConstant(constantName); } if (pc == null) { ps =
	 * OsateResourceManager.findPropertySet(AadlProject._NAME, null); if (ps !=
	 * null) { pc = ps.findPropertyConstant(constantName); } } return pc; }
	 */

	/**
	 * Find a predeclared AADL property type by name.
	 * 
	 * @param typeName
	 *            The name of the type to look for
	 * @return The {@link edu.cmu.sei.aadl.model.property.PropertyType}of the
	 *         given type if found, or <code>null</code> if the property type
	 *         cannot be found. The type might not be found if either the
	 *         property set does not exist, or if the type is not found in the
	 *         given property set.
	 */

	/* 
	 * 
	 * */
	public static PropertyType findPropertyType(final String typeName) {
		for (PropertySet predeclaredPropertySet : getPredeclaredPropertySets()) {
			NamedElement searchResult = predeclaredPropertySet
					.findNamedElement(typeName);
			if (searchResult instanceof PropertyType)
				return (PropertyType) searchResult;
		}
		return null;
	}

	public static PropertyType findPropertyType(final String propertySet, final String propertyName) 
	{ 
		final PropertySet ps = OsateResourceManager.findPropertySet(propertySet); 
		if (ps !=	  null) 
		{ 
			NamedElement searchResult = ps.findNamedElement(propertyName);
			if (searchResult instanceof PropertyType)
				return (PropertyType) searchResult;
			else
				return null;
		}
		else {
			return null; 
		} 
	}
	
	/**
	 * Find an AADL property type by name.
	 * 
	 * @param propertySet
	 *            The name of the property set in which to look for the property
	 *            constant.
	 * @param constantName
	 *            The name of the type to look for
	 * @param context
	 *            The model object on whose behalf this lookup is being
	 *            performed. For example, this could be the AadlSpec of the
	 *            model being analyzed. Or it could be the object whose property
	 *            values are of interest. See
	 *            {@link #findPropertySet(String, AObject)}
	 * @return The {@link edu.cmu.sei.aadl.model.property.PropertyType}of the
	 *         given type if found, or <code>null</code> if the property type
	 *         cannot be found. The type might not be found if either the
	 *         property set does not exist, or if the type is not found in the
	 *         given property set.
	 */

	/*
	 * TODO: [PROPERTIES] uncomment when properties added public static
	 * PropertyType findPropertyType(final String propertySet, final String
	 * constantName, final AObject context) { final PropertySet ps =
	 * OsateResourceManager.findPropertySet(propertySet, context); if (ps !=
	 * null) { return ps.findPropertyType(constantName); } else { return null; }
	 * }
	 */

	/**
	 * Find an AADL unit literal by name. This method is a static alternative of
	 * 
	 * <code>edu.cmu.sei.osate.ui.actions.AbstractAaxlAction.lookupUnitLiteral(String, String, String)</code>
	 * .
	 * 
	 * @param propertySetName
	 *            The name of the property set in which to look for the units
	 *            type.
	 * @param unitsTypeName
	 *            The name of the units type in which to look for the unit
	 *            literal.
	 * @param unitLiteralName
	 *            The name of the unit literal to look for.
	 * @param context
	 *            The model object on whose behalf this lookup is being
	 *            performed. For example, this could be the AadlSpec of the
	 *            model being analyzed. Or it could be the object whose property
	 *            values are of interest. See
	 *            {@link #findPropertySet(String, AObject)}
	 * @return The {@link edu.cmu.sei.aadl.model.property.UnitLiteral} of the
	 *         given literal if found, or <code>null</code> if the units type or
	 *         unit literal cannot be found. The unit literal might not be found
	 *         if the property set does not exist, the units type is not found
	 *         in the given property set, or the units literal is not found in
	 *         the given units type.
	 * @throws ClassCastException
	 *             Thrown if <code>unitsTypeName</code> refers to a
	 *             {@link edu.cmu.sei.aadl.model.property.PropertyType} object
	 *             in the given property set which is not a
	 *             {@link edu.cmu.sei.aadl.model.property.UnitsType}.
	 */

	/*
	 * TODO : [PROPERTIES] uncomment when properties added public static
	 * UnitLiteral findUnitLiteral(final String propertySetName, final String
	 * unitsTypeName, final String unitLiteralName, AObject context) { final
	 * UnitsType type = (UnitsType)findPropertyType(propertySetName,
	 * unitsTypeName, context); if (type != null) return
	 * type.findUnitLiteral(unitLiteralName); else return null; }
	 */

	/**
	 * Find a predeclared AADL unit literal by name. This method is a static
	 * alternative of
	 * <code>edu.cmu.sei.osate.ui.actions.AbstractAaxlAction.lookupUnitLiteral(String, String)</code>
	 * .
	 * 
	 * @param unitsTypeName
	 *            The name of the units type in which to look for the unit
	 *            literal.
	 * @param unitLiteralName
	 *            The name of the unit literal to look for.
	 * @return The {@link edu.cmu.sei.aadl.model.property.UnitLiteral} of the
	 *         given literal if found, or <code>null</code> if the units type or
	 *         unit literal cannot be found. The unit literal might not be found
	 *         if the units type is not found in the predeclared property sets
	 *         or the units literal is not found in the given units type.
	 * @throws ClassCastException
	 *             Thrown if <code>unitsTypeName</code> refers to a
	 *             {@link edu.cmu.sei.aadl.model.property.PropertyType} object
	 *             which is not a
	 *             {@link edu.cmu.sei.aadl.model.property.UnitsType}.
	 */

	/*
	 * TODO : [PROPERTIES] uncomment when properties added public static
	 * UnitLiteral findUnitLiteral(final String unitsTypeName, final String
	 * unitLiteralName) { final UnitsType type =
	 * (UnitsType)findPropertyType(unitsTypeName); if (type != null) return
	 * type.findUnitLiteral(unitLiteralName); else return null; }
	 */

	/**
	 * Find an AADL enum literal by name. This method is a static alternative of
	 * 
	 * <code>edu.cmu.sei.osate.ui.actions.AbstractAaxlAction.lookupEnumerationLiteral(String, String, String)</code>
	 * .
	 * 
	 * @param propertySetName
	 *            The name of the property set in which to look for the enum
	 *            type.
	 * @param enumTypeName
	 *            The name of the enum type in which to look for the enum
	 *            literal.
	 * @param enumLiteralName
	 *            The name of the enum literal to look for.
	 * @param context
	 *            The model object on whose behalf this lookup is being
	 *            performed. For example, this could be the AadlSpec of the
	 *            model being analyzed. Or it could be the object whose property
	 *            values are of interest. See
	 *            {@link #findPropertySet(String, AObject)}
	 * @return The {@link edu.cmu.sei.aadl.model.property.EnumLiteral} of the
	 *         given literal if found, or <code>null</code> if the enum type or
	 *         enum literal cannot be found. The enum literal might not be found
	 *         if the property set does not exist, the enum type is not found in
	 *         the given property set, or the enum literal is not found in the
	 *         given enum type.
	 * @throws ClassCastException
	 *             Thrown if <code>enumTypeName</code> refers to a
	 *             {@link edu.cmu.sei.aadl.model.property.PropertyType} object
	 *             in the given property set which is not an
	 *             {@link edu.cmu.sei.aadl.model.property.EnumType}.
	 */

	/*
	 * TODO : [PROPERTIES] uncomment when properties added public EnumLiteral
	 * findEnumerationLiteral(final String propertySetName, final String
	 * enumTypeName, final String enumLiteralName, AObject context) { final
	 * EnumType type = (EnumType)findPropertyType(propertySetName, enumTypeName,
	 * context); if (type != null) return type.findEnumLiteral(enumLiteralName);
	 * else return null; }
	 */

	/**
	 * Find a predeclared AADL enum literal by name. This method is a static
	 * alternative of
	 * <code>edu.cmu.sei.osate.ui.actions.AbstractAaxlAction.lookupEnumerationLiteral(String, String)</code>
	 * .
	 * 
	 * @param enumTypeName
	 *            The name of the enum type in which to look for the enum
	 *            literal.
	 * @param enumLiteralName
	 *            The name of the enum literal to look for.
	 * @return The {@link edu.cmu.sei.aadl.model.property.EnumLiteral} of the
	 *         given literal if found, or <code>null</code> if the enum type or
	 *         enum literal cannot be found. The enum literal might not be found
	 *         if the enum type is not found in the predeclared property sets or
	 *         the enum literal is not found in the given enum type.
	 * @throws ClassCastException
	 *             Thrown if <code>enumTypeName</code> refers to a
	 *             {@link edu.cmu.sei.aadl.model.property.PropertyType} object
	 *             which is not an
	 *             {@link edu.cmu.sei.aadl.model.property.EnumType}.
	 */

	/*
	 * TODO : [PROPERTIES] uncomment when properties added public EnumLiteral
	 * findEnumerationLiteral(final String enumTypeName, final String
	 * enumLiteralName) { final EnumType type =
	 * (EnumType)findPropertyType(enumTypeName); if (type != null) return
	 * type.findEnumLiteral(enumLiteralName); return null; }
	 */
	private static void getAllGlobalPropertySets(final Set<PropertySet> propSets) {
		for (Resource res : getResourceSet().getResources()) {
			PropertySet obj = getPropertySet(res);
			if (obj != null) {
				propSets.add(obj);
			}
		}
	}

	private static void getAllGlobalPublicPackages(
			final Set<AadlPackage> pubPackage) {
		for (Resource res : getResourceSet().getResources()) {
			AadlPackage obj = getPublicAadlPackage(res);
			if (obj != null) {
				pubPackage.add(obj);
			}
		}
	}

	/**
	 * Get all the global property sets in the resource set.
	 * 
	 * @return {@link java.util.Set} of {@link PropertySet}objects.
	 */
	public static Set<PropertySet> getAllPropertySets() {
		final Set<PropertySet> propSets = new HashSet<PropertySet>();
		getAllGlobalPropertySets(propSets);
		return Collections.unmodifiableSet(propSets);
	}

	/**
	 * Get all the global public packages in the resource set.
	 * 
	 * @return {@link java.util.Set} of Public Packages.
	 */
	public static Set<AadlPackage> getAllPublicPackages() {
		final Set<AadlPackage> pubPackages = new HashSet<AadlPackage>();
		getAllGlobalPublicPackages(pubPackages);
		return Collections.unmodifiableSet(pubPackages);
	}

	/**
	 * Get all the property sets visible to the given model element. If the
	 * given element is <code>null</code>, only the global property sets are
	 * returned. If the given element is not <code>null</code>, then any locally
	 * declared property sets in the model object's name space (see
	 * {@link #findPropertySet(String, AObject)}) are also returned, and they
	 * shadow any globally declared property sets with the same name.
	 * 
	 * @param context
	 *            The model object on whose behalf this lookup is being
	 *            performed. For example, this could be the AadlSpec of the
	 *            model being analyzed. Or it could be the object whose property
	 *            values are of interest. See
	 *            {@link #findPropertySet(String, AObject)}
	 */

	/*
	 * TODO: [PROPERTIES] uncomment when properties are added public static
	 * Set<PropertySet> getAllPropertySets(final AObject context) { final
	 * Set<PropertySet> propSets = new HashSet<PropertySet>();
	 * getAllGlobalPropertySets(propSets); final AadlSpec localNameSpace =
	 * getPropertySetNameSpace(context); if (localNameSpace != null) { final
	 * EList localSets = localNameSpace.getPropertySet(); for (Iterator i =
	 * localSets.iterator(); i.hasNext();) { final PropertySet ps =
	 * (PropertySet) i.next(); replacePropertySet(propSets, ps); } } return
	 * Collections.unmodifiableSet(propSets); }
	 */

	/**
	 * Get all the property sets visible to the given model element. If the
	 * given element is <code>null</code>, only the global property sets are
	 * returned. If the given element is not <code>null</code>, then any locally
	 * declared property sets in the model object's name space (see
	 * {@link #findPropertySet(String, Element)}) are also returned, and they
	 * shadow any globally declared property sets with the same name.
	 * 
	 * @param context
	 *            The model object on whose behalf this lookup is being
	 *            performed. For example, this could be the AadlSpec of the
	 *            model being analyzed. Or it could be the object whose property
	 *            values are of interest. See
	 *            {@link #findPropertySet(String, Element)}
	 */
	public static Set<AadlPackage> getAllPublicPackages(final Element context) {
		final Set<AadlPackage> pubPackages = new HashSet<AadlPackage>();
		getAllGlobalPublicPackages(pubPackages);

		/*
		 * TODO : [PROPERTIES] uncomment when properties added final
		 * AadlSpecification localNameSpace = getPropertySetNameSpace(context);
		 * if (localNameSpace != null) { final EList localSets =
		 * localNameSpace.getPropertySet(); for (Iterator i =
		 * localSets.iterator(); i.hasNext();) { final AadlPackage ps =
		 * (AadlPackage) i.next(); replacePackage(pubPackages, ps); } }
		 */
		return Collections.unmodifiableSet(pubPackages);
	}

	/*
	 * TODO : [PROPERTIES] uncomment when properties added private static void
	 * replacePropertySet(final Set<PropertySet> s, final PropertySet ps) { //
	 * remove any property set with the same name for (final
	 * Iterator<PropertySet> i = s.iterator(); i.hasNext();) { final PropertySet
	 * ps2 = i.next(); final String newName = ps2.getName(); if (newName != null
	 * && newName.equalsIgnoreCase(ps.getName())) { i.remove(); break; } } //
	 * add the new one s.add(ps); }
	 */

	private static void replacePackage(final Set<AadlPackage> s,
			final AadlPackage ps) {
		// remove any property set with the same name
		for (final Iterator<AadlPackage> i = s.iterator(); i.hasNext();) {
			final AadlPackage ps2 = i.next();
			final String newName = ps2.getName();
			if (newName != null && newName.equalsIgnoreCase(ps.getName())) {
				i.remove();
				break;
			}
		}
		// add the new one
		s.add(ps);
	}

	/**
	 * Find an AADL package by name in in the local aadlspec, a resource in the
	 * resource set or workspace. The package must have a public part.
	 * 
	 * @param pn
	 *            string property set name
	 * @param context
	 *            AObject whose root object may provide a local context for
	 *            package lookup
	 * @return AadlPackage to the package, null if not found.
	 */
	public static AadlPackage findPublicAadlPackage(String pn, Element context) {
		if (pn == null || pn.length() == 0) {
			return null;
		}
		// local lookup
		if (context != null) {
			Element as = context.getElementRoot();
			if (as instanceof AadlPackage) {
				AadlPackage p = (AadlPackage) as;
				if (p.getPublicSection() != null) {
					return p;
				}
			}
		}
		AadlPackage pkg = findPublicAadlPackageInResourceSet(pn);
		// if (pkg == null){
		// populateResourceSet();
		// pkg = findPublicAadlPackageInResourceSet(pn);
		// }
		return pkg;
	}

	/**
	 * find public package in resource set.
	 * 
	 * @param pn
	 *            package name in AADL syntax
	 * @return AadlPackage or null
	 */
	public static AadlPackage findPublicAadlPackageInResourceSet(String pn) {
		for (Resource r : getResourceSet().getResources()) {
			AadlPackage p = getPublicAadlPackage(r);
			if (p != null) {
				String name = p.getName();
				if (name != null && name.equalsIgnoreCase(pn)) {
					if (p.getPublicSection() != null) {
						return p;
					}
				}
			}
		}
		return null;
	}

	// TODO: [SPECIFICATION] Rewrite this because there are no more AadlSpecs.
	// /**
	// * Find an AADL package by name in in the local aadlspec, a resource in
	// the resource set or workspace.
	// * The package must have a only private part.
	// * @param pn
	// * string property set name
	// * @param context
	// * AObject whose root object may provide a local context for
	// * package lookup
	// * @return AadlPackage to the package, null if not found.
	// */
	// public static AadlPackage findPrivateOnlyAadlPackage(String pn, AObject
	// context) {
	// if (pn == null || pn.length() == 0) {
	// return null;
	// }
	// // local lookup
	// if (context != null) {
	// Element as = ((Element)context).getElementRoot();
	// if (as instanceof AadlPackage) {
	// AadlPackage p = (AadlPackage) as;
	// if (p.getPublic() == null && p.getPrivate() != null) {
	// return p;
	// }
	// }
	// }
	// // lookup in global namespace (resource set first)
	// for (Resource r : getResourceSet().getResources()) {
	// AadlPackage p = getPrivateOnlyAadlPackage(r);
	// if (p != null) {
	// String name = p.getName();
	// if (name != null && name.equalsIgnoreCase(pn)) {
	// return p;
	// }
	// }
	// }
	// return null;
	// }

	/**
	 * return the AadlPackage if it has a public part. The AadlPackage may be
	 * the root itself or the single element of the AadlSpec
	 * 
	 * @param res
	 *            Resource to hold AadlPackage
	 * @return AadlPackage or null
	 */
	public static AadlPackage getPublicAadlPackage(Resource res) {
		if (res != null) {
			EList<EObject> l = res.getContents();
			AadlPackage pkg = null;
			if (!l.isEmpty()) {
				EObject obj = l.get(0);
				if (obj instanceof AadlPackage) {
					pkg = (AadlPackage) obj;
					if (pkg.getPublicSection() != null)
						return pkg;
					else
						return null;
				}
			}
		}
		return null;
	}

	/**
	 * If the resource contains a package declaration only, then it is returned.
	 * The package can have public, private, or both public and private parts.
	 */
	public static AadlPackage getAadlPackage(Resource res) {
		if (res != null) {
			EList<EObject> l = res.getContents();
			if (!l.isEmpty()) {
				EObject obj = l.get(0);
				if (obj instanceof AadlPackage) {
					return (AadlPackage) obj;
				}
			}
		}
		return null;
	}

	// TODO: [SPECIFICATION] Rewrite this method because there are no more
	// AadlSpecs.
	// /**
	// * return the AadlPackage if it only has a private part.
	// * The AadlPackage may be the root itself or the single element of the
	// AadlSpec
	// * @param res Resource to hold AadlPackage
	// * @return AadlPackage or null
	// */
	// public static AadlPackage getPrivateOnlyAadlPackage(Resource res) {
	// if (res != null) {
	// EList<EObject> l = res.getContents();
	// AadlPackage pkg = null;
	// if (!l.isEmpty()) {
	// EObject obj = l.get(0);
	// if (obj instanceof AadlPackage) {
	// pkg = (AadlPackage) obj;
	// } else if (obj instanceof AadlSpecification) {
	// EList<EObject> cl = ((AadlSpecification) obj).eContents();
	// if (cl.size() == 1) {
	// obj = cl.get(0);
	// if (obj instanceof AadlPackage) {
	// pkg = (AadlPackage) obj;
	// }
	// }
	// }
	// }
	// if (pkg != null && pkg.getPublic() == null && pkg.getPrivate() != null) {
	// return pkg;
	// }
	// }
	// return null;
	// }

	/**
	 * Get all resources in the resource set that have just been parsed.
	 * 
	 * @return {@link java.util.Set} of {@link Resource} objects.
	 */
	public static Set<Aadl2ResourceImpl> getAllParsedResources() {
		final Set<Aadl2ResourceImpl> resources = new HashSet<Aadl2ResourceImpl>();
		for (Resource obj : getResourceSet().getResources()) {
			if (obj instanceof Aadl2ResourceImpl
					&& ((Aadl2ResourceImpl) obj).getJustParsed()) {
				resources.add((Aadl2ResourceImpl) obj);
			}
		}
		return Collections.unmodifiableSet(resources);
	}

	/**
	 * Clear all the "just parsed" flags.
	 */
	public static void clearJustParsed() {
		for (Resource obj : getResourceSet().getResources()) {
			if (obj instanceof Aadl2ResourceImpl
					&& ((Aadl2ResourceImpl) obj).getJustParsed()) {
				((Aadl2ResourceImpl) obj).setJustParsed(false);
			}
		}
	}

	/**
	 * Save all resources in the resource set that have been parsed. They are
	 * saved and marked as derived.
	 */
	public static void saveAllParsed() {
		WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {
			@Override
			protected void execute(IProgressMonitor monitor) {
				try {
					for (final Resource resource : getResourceSet()
							.getResources()) {
						if (resource instanceof Aadl2ResourceImpl) {
							final Aadl2ResourceImpl aadl2Res = (Aadl2ResourceImpl) resource;
							if (aadl2Res.getJustParsed()) {
								// save only if it was compiled
								saveAsDerived(resource);
							}
						}
					}
				} catch (Exception exception) {
					Activator.logThrowable(exception);
				}
			}
		};
		try {
			// This runs the options, and shows progress.
			//
			operation.run(null);

		} catch (Exception exception) {
			// Something went wrong that shouldn't.
			//
			Activator.logThrowable(exception);
		}
	}

	/**
	 * save resource as derived file. to be called by parser.
	 * 
	 * @param res
	 */
	public static void saveAsDerived(Resource res) {
		// get the resource and mark it as derived
		doSaveResource(res);
		IResource ires = convertToIResource(res);
		try {
			ires.setDerived(true);
		} catch (CoreException e1) {
		}
	}

	public static boolean containsIResourceByPath(Collection iresset,
			IResource matchIRes) {
		if (matchIRes == null)
			return false;
		String matchPath = matchIRes.getFullPath().toString();
		for (Iterator it = iresset.iterator(); it.hasNext();) {
			IResource ires = (IResource) it.next();
			String iresPath = ires.getFullPath().toString();
			if (iresPath.equalsIgnoreCase(matchPath))
				return true;
		}
		return false;
	}

	/**
	 * tag the IResource of the model Resource is tagged with syntax errors
	 * i.e., its corresponding aadl text file has syntax errors It is also
	 * touched to make sure it has a newer date than the text.
	 * 
	 * @param model
	 *            Resource of aaxl model
	 */
	public static void tagModelWithSyntaxErrors(Resource model) {
		if (model != null) {
			IResource modelfile = OsateResourceManager
					.convertToIResource(model);
			IResourceUtility.tagModelWithSyntaxErrors(modelfile);
		}
	}

	/**
	 * untag the IResource of the model Resource is tagged with syntax errors
	 * i.e., its corresponding aadl text file has syntax errors
	 * 
	 * @param model
	 *            Resource of aaxl model
	 */
	public static void untagModelWithSyntaxErrors(Resource model) {
		if (model != null) {
			IResource modelfile = OsateResourceManager
					.convertToIResource(model);
			IResourceUtility.untagModelWithSyntaxErrors(modelfile);
		}
	}

	/**
	 * check whether the IResource of the model Resource is tagged with syntax
	 * errors i.e., its corresponding aadl text file has syntax errors
	 * 
	 * @param model
	 *            any EObject in the model
	 * @return true if its resource is tagged as its aadl text equivalent having
	 *         syntax errors
	 */
	public static boolean isModelTaggedWithSyntaxErrors(EObject model) {
		if (model != null) {
			IResource modelfile = OsateResourceManager.convertToIResource(model
					.eResource());
			return IResourceUtility.isModelTaggedWithSyntaxErrors(modelfile);
		}
		return false;
	}

	/**
	 * check whether the IResource of the model Resource is tagged with syntax
	 * errors i.e., its corresponding aadl text file has syntax errors
	 * 
	 * @param model
	 *            Resource of aaxl model
	 * @return true if it is tagged as its aadl text equivalent having syntax
	 *         errors
	 */
	public static boolean isModelTaggedWithSyntaxErrors(Resource model) {
		if (model != null) {
			IResource modelfile = OsateResourceManager
					.convertToIResource(model);
			return IResourceUtility.isModelTaggedWithSyntaxErrors(modelfile);
		}
		return false;
	}

	/**
	 * check whether the model IResource is tagged with syntax errors i.e., its
	 * corresponding aadl text file has syntax errors
	 * 
	 * @param modelfile
	 *            aaxl file
	 * @return true if it is tagged as its aadl text equivalent having syntax
	 *         errors
	 */
	public static boolean isModelTaggedWithSyntaxErrors(IResource modelfile) {
		return IResourceUtility.isModelTaggedWithSyntaxErrors(modelfile);
	}

	/**
	 * check whether the ires IResource is tagged with syntax errors i.e., its
	 * corresponding aadl text file has syntax errors
	 * 
	 * @param ires
	 *            project, folder, or IResource
	 * @return true if it contains a IResource that is tagged as its aadl text
	 *         equivalent having syntax errors
	 */
	public static boolean containsModelTaggedWithSyntaxErrors(IResource ires) {
		return IResourceUtility.containsModelTaggedWithSyntaxErrors(ires);
	}

	/**
	 * Get all resources in the resource set except res or standard property
	 * sets
	 * 
	 * @param res
	 *            resoruce to be excluded
	 * @return {@link java.util.Set} of {@link Resource} objects.
	 */
	public static Set<Resource> getAllOtherResources(Resource res) {
		final Set<Resource> resources = new HashSet<Resource>();
		for (Resource obj : getResourceSet().getResources()) {
			if (obj != res && !isPredeclaredResource(obj)) {
				resources.add(obj);
			}
		}
		return Collections.unmodifiableSet(resources);
	}

	public static void loadPluginContributedAadl() {
		try {
			new WorkspaceModifyOperation() {
				protected void execute(IProgressMonitor monitor)
						throws CoreException, InvocationTargetException {
					try {
						IProject pluginResourcesProject = getPluginResourcesProject();
						if (pluginResourcesProject.isOpen()) {
							for (URI contributedResourceUri : PluginSupportUtil
									.getContributedAadl()) {
								String resourceName = contributedResourceUri
										.trimFileExtension()
										.appendFileExtension(
												WorkspacePlugin.SOURCE_FILE_EXT)
										.lastSegment();
								IFile contributedResourceInWorkspace = pluginResourcesProject
										.getFolder(
												WorkspacePlugin.DEFAULT_SOURCE_DIR)
										.getFile(resourceName);
								if (!contributedResourceInWorkspace.exists()
										|| contributedResourceInWorkspace
												.getResourceAttributes()
												.isReadOnly())
									copyContributedResourceIntoWorkspace(
											contributedResourceUri,
											contributedResourceInWorkspace);
							}
						} else {
							Activator
									.logErrorMessage("Cannot load plugin property sets and packages.  The project '"
											+ PLUGIN_RESOURCES_DIRECTORY_NAME
											+ "' is closed.");
						}
					} catch (IOException e) {
						throw new InvocationTargetException(e);
					}
				}
			}.run(null);
		} catch (InvocationTargetException e) {
			Activator.logThrowable(e.getCause());
			Activator
					.logErrorMessage("Cannot load plugin property sets and packages.");
		} catch (InterruptedException e) {
			Activator.logThrowable(e);
			Activator
					.logErrorMessage("Cannot load plugin property sets and packages.");
		}
	}

	private static IProject getPluginResourcesProject() throws CoreException,
			IOException {
		IProject pluginResourcesProject = ResourcesPlugin.getWorkspace()
				.getRoot().getProject(PLUGIN_RESOURCES_DIRECTORY_NAME);
		if (!pluginResourcesProject.exists()) {
			try {
				pluginResourcesProject.create(null);
				pluginResourcesProject.open(null);
				IFolder modelDirectory = pluginResourcesProject
						.getFolder(WorkspacePlugin.DEFAULT_MODEL_DIR);
				IFolder sourceDirectory = pluginResourcesProject
						.getFolder(WorkspacePlugin.DEFAULT_SOURCE_DIR);
				modelDirectory.create(true, true, null);
				sourceDirectory.create(true, true, null);
				PreferenceStore preferenceStore = new PreferenceStore(
						pluginResourcesProject.getFile(
								WorkspacePlugin.AADLPATH_FILENAME)
								.getRawLocation().toString());
				preferenceStore.setValue(WorkspacePlugin.PROJECT_SOURCE_DIR,
						WorkspacePlugin.DEFAULT_SOURCE_DIR);
				preferenceStore.setValue(WorkspacePlugin.PROJECT_MODEL_DIR,
						WorkspacePlugin.DEFAULT_MODEL_DIR);
				preferenceStore.save();
				pluginResourcesProject.refreshLocal(1, null);

				/*
				 * We really should just have the following line:
				 * AadlNature.addNature(pluginResourcesProject, null);
				 * 
				 * This cannot be done because it would introduce a cycle in the
				 * plugin dependencies. Perhaps this can be cleaned up at a
				 * later date, but this solution is good enough for now.
				 */
				IProjectDescription pluginResourcesProjectDescription = pluginResourcesProject
						.getDescription();
				pluginResourcesProjectDescription
						.setNatureIds(new String[] { "edu.cmu.sei.osate.core.aadlnature" });
				pluginResourcesProject.setDescription(
						pluginResourcesProjectDescription, null);
			} catch (CoreException e) {
				if (pluginResourcesProject.exists()) {
					try {
						pluginResourcesProject.delete(true, true, null);
					} catch (CoreException ex) {
						// Ignore this exception.
					}
				}
				throw e;
			} catch (IOException e) {
				if (pluginResourcesProject.exists()) {
					try {
						pluginResourcesProject.delete(true, true, null);
					} catch (CoreException ex) {
						// Ignore this exception.
					}
				}
				throw e;
			}
		}
		return pluginResourcesProject;
	}

	public static void revertToContributed(
			final IFile contributedResourceInWorkspace) throws IOException,
			CoreException {
		if (!contributedResourceInWorkspace.getProject().getName().equals(
				PLUGIN_RESOURCES_DIRECTORY_NAME))
			throw new IllegalArgumentException(
					"contributedResourceInWorkspace is not in the project "
							+ PLUGIN_RESOURCES_DIRECTORY_NAME);
		for (final URI contributedResourceUri : PluginSupportUtil
				.getContributedAadl()) {
			if (contributedResourceUri.trimFileExtension().appendFileExtension(
					WorkspacePlugin.SOURCE_FILE_EXT).lastSegment().equals(
					contributedResourceInWorkspace.getName())) {
				try {
					new WorkspaceModifyOperation() {
						@Override
						protected void execute(IProgressMonitor monitor)
								throws CoreException, InvocationTargetException {
							try {
								copyContributedResourceIntoWorkspace(
										contributedResourceUri,
										contributedResourceInWorkspace);
							} catch (IOException e) {
								throw new InvocationTargetException(e);
							}
						}
					}.run(null);
				} catch (InvocationTargetException e) {
					if (e.getCause() instanceof IOException)
						throw (IOException) e.getCause();
					else if (e.getCause() instanceof CoreException)
						throw (CoreException) e.getCause();
					else
						Activator.logThrowable(e);
				} catch (InterruptedException e) {
					Activator.logThrowable(e);
				}
				break;
			}
		}
	}

	public static boolean isPredeclaredResource(final Resource r) {
		IProject project = convertToIResource(r).getProject();
		try
		{
			return project.equals(getPluginResourcesProject());
		}
		catch (IOException e)
		{
			return project.getName().equals(PLUGIN_RESOURCES_DIRECTORY_NAME);
		}
		catch (CoreException e)
		{
			return project.getName().equals(PLUGIN_RESOURCES_DIRECTORY_NAME);
		}
	}

	private static void copyContributedResourceIntoWorkspace(
			URI contributedResourceUri, IFile contributedResourceInWorkspace)
			throws IOException, CoreException {
		URIConverter uricvt = getResourceSet().getURIConverter();
		InputStream contributedResourceContentsAsStream = uricvt
				.createInputStream(contributedResourceUri.trimFileExtension()
						.appendFileExtension(WorkspacePlugin.SOURCE_FILE_EXT));
		if (contributedResourceInWorkspace.exists()) {
			// Temporarily make it read-write.
			ResourceAttributes attributes = contributedResourceInWorkspace
					.getResourceAttributes();
			attributes.setReadOnly(false);
			contributedResourceInWorkspace.setResourceAttributes(attributes);
			contributedResourceInWorkspace.setContents(
					contributedResourceContentsAsStream, false, true, null);
		} else
			contributedResourceInWorkspace.create(
					contributedResourceContentsAsStream, false, null);
		ResourceAttributes attributes = contributedResourceInWorkspace
				.getResourceAttributes();
		attributes.setReadOnly(true);
		contributedResourceInWorkspace.setResourceAttributes(attributes);
	}

	/**
	 * delete the complement file for the given deleted file if the complement
	 * is a derived file
	 * 
	 * @param deletedfile
	 */
	public static void deleteComplementFileIfGenerated(IFile deletedfile) {
		IFile complementfile = IResourceUtility.getComplementFile(deletedfile);
		if (complementfile != null && complementfile.isDerived())
			deleteFile(complementfile);
	}

	/**
	 * delete the complement file for the given deleted file
	 * 
	 * @param deletedfile
	 */
	public static void deleteComplementFile(IFile deletedfile) {
		IFile complementfile = IResourceUtility.getComplementFile(deletedfile);
		if (complementfile != null)
			deleteFile(complementfile);
	}

	/**
	 * delete the complement file for the given deleted file
	 * 
	 * @param deletedfolder
	 */
	public static void deleteComplementFolder(IFolder deletedfolder) {
		IFolder complementfolder = IResourceUtility
				.getComplementFolder(deletedfolder);
		if (complementfolder != null)
			try {
				complementfolder.delete(IResource.FORCE, null);
			} catch (CoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	/**
	 * Delete the given file.
	 */
	public static void deleteFile(IFile model) {
		if (model != null) {
			OsateResourceManager.removeResource(model);
		}
		if (model != null && model.exists()) {
			try {
				model.delete(true, null);
			} catch (CoreException e) {
			}
		}
	}

	/**
	 * make resources as modified if their model objects point to the any object
	 * in the given model (resource)
	 * 
	 * @param obj
	 */
	public static void doPropagateModelChange(Resource origres) {
		if (origres.getContents().isEmpty()) {
			return;
		}
		Object aobj = origres.getContents().get(0);

		/*
		 * TODO: [INSTANCES] uncomment when instances added if (aobj instanceof
		 * SystemInstance) return;
		 */
		for (Resource res : OsateResourceManager.getAllOtherResources(origres)) {
			if (isPredeclaredResource(res)) {
				break;
			}
			if (!res.isModified()
					&& (res instanceof Aadl2ResourceImpl
							&& !((Aadl2ResourceImpl) res).getContents()
									.isEmpty() && (((Aadl2ResourceImpl) res)
							.getContents().get(0) instanceof AadlPackage))) {// ||
				// TODO: [PROPERTIES] Uncomment when properties are added.
				// ((CoreResourceImpl)res).getContents().get(0) instanceof
				// PropertySet))){
				Map<EObject, Collection<EStructuralFeature.Setting>> map = EcoreUtil.ExternalCrossReferencer
						.find(res);
				if (!map.isEmpty()) {
					res.setModified(true);
					break;
				}
			}
		}
	}

	/**
	 * make resources as modified if their model objects point to the named
	 * object
	 * 
	 * @param obj
	 */
	public static void doPropagateNameChange(Element obj) {
		if (!getResourceSet().isPropagateNameChange())
			return;
		Element aobj = ((Element) obj).getElementRoot();
		// TODO: [SPECIFICATION] Rewrite this because there are no more
		// AadlSpecs.
		// if (aobj instanceof AadlSpecification){
		// if(((AadlSpecification)aobj).isSpecification())
		// return;
		// }
		for (Resource res : OsateResourceManager.getAllOtherResources(obj
				.eResource())) {
			if (isPredeclaredResource(res)) {
				break;
			}
			if (!res.isModified()) {// &&
				// TODO: [SPECIFICATION] Rewrite this because there are no more
				// AadlSpecs.
				// // other AadlSpec files cannot point to it since it is a
				// local name space
				// (res instanceof CoreResourceImpl &&
				// !((CoreResourceImpl)res).getContents().isEmpty() &&
				// (((CoreResourceImpl)res).getContents().get(0) instanceof
				// AadlSpecification
				// // not for instance models they are handled separately ||
				// ((CoreResourceImpl)res).getContents().get(0) instanceof
				// SystemInstance
				// )
				// )){
				Map<EObject, Collection<EStructuralFeature.Setting>> map = EcoreUtil.ExternalCrossReferencer
						.find(res);
				if (!map.isEmpty()) {
					for (Map.Entry<EObject, Collection<EStructuralFeature.Setting>> entry : map
							.entrySet()) {
						EObject externalReference = entry.getKey();
						if (EcoreUtil.isAncestor(obj, externalReference)) {
							res.setModified(true);
							break;
						}
					}
				}
			}
		}
	}

	/**
	 * Find a {@link PublicPackageSection} in the resource set. The name of a
	 * {@link PublicPackageSection} is the same as the name of its containing
	 * {@link AadlPackage}. Returns {@code null} if a
	 * {@link PublicPackageSection} with the specified name cannot be found.
	 * 
	 * @param name
	 *            The name of the {@link AadlPackage} and
	 *            {@link PublicPackageSection} to search for.
	 * @return The specified {@link PublicPackageSection} or {@code null} if it
	 *         cannot be found.
	 */
	public static PublicPackageSection findPublicPackageSection(String name) {
		if (name == null || name.length() == 0)
			return null;
		for (Resource resource : getResourceSet().getResources()) {
			if (!resource.getContents().isEmpty()
					&& resource.getContents().get(0) instanceof AadlPackage) {
				AadlPackage aadlPackage = (AadlPackage) resource.getContents()
						.get(0);
				if (aadlPackage.getOwnedPublicSection() != null
						&& name.equalsIgnoreCase(aadlPackage.getName()))
					return aadlPackage.getOwnedPublicSection();
			}
		}
		return null;
	}

	/**
	 * Find a {@link PrivatePackageSection} in the resource set. The name of a
	 * {@link PrivatePackageSection} is the same as the name of its containing
	 * {@link AadlPackage}. Returns {@code null} if a
	 * {@link PrivatePackageSection} with the specified name cannot be found.
	 * 
	 * @param name
	 *            The name of the {@link AadlPackage} and
	 *            {@link PrivatePackageSection} to search for.
	 * @return The specified {@link PrivatePackageSection} or {@code null} if it
	 *         cannot be found.
	 */
	public static PrivatePackageSection findPrivatePackageSection(String name) {
		if (name == null || name.length() == 0)
			return null;
		for (Resource resource : getResourceSet().getResources()) {
			if (!resource.getContents().isEmpty()
					&& resource.getContents().get(0) instanceof AadlPackage) {
				AadlPackage aadlPackage = (AadlPackage) resource.getContents()
						.get(0);
				if (aadlPackage.getOwnedPrivateSection() != null
						&& name.equalsIgnoreCase(aadlPackage.getName()))
					return aadlPackage.getOwnedPrivateSection();
			}
		}
		return null;
	}

	/**
	 * Find an {@link AadlPackage} or a {@link PropertySet} in the resource set.
	 * Returns {@code null} if an {@link AadlPackage} or a {@link PropertySet}
	 * with the specified name cannot be found.
	 * 
	 * @param name
	 *            The name of the {@link AadlPackage} or {@link PropertySet} to
	 *            search for.
	 * @return The specified {@link AadlPackage} or {@link PropertySet} or
	 *         {@code null} if it cannot be found.
	 */
	public static NamedElement findPackageOrPropertySet(String name) {
		if (name == null || name.length() == 0)
			return null;
		for (Resource resource : getResourceSet().getResources()) {
			if (!resource.getContents().isEmpty()) {
				EObject rootObject = resource.getContents().get(0);
				if ((rootObject instanceof AadlPackage || rootObject instanceof PropertySet)
						&& ((NamedElement) rootObject).getName()
								.equalsIgnoreCase(name))
					return (NamedElement) rootObject;
			}
		}
		return null;
	}

	public static PropertySet findPropertySet(String name) {
		if (name == null || name.length() == 0)
			return null;
		for (Resource resource : getResourceSet().getResources()) {
			if (!resource.getContents().isEmpty()) {
				EObject rootObject = resource.getContents().get(0);
				if ((rootObject instanceof PropertySet)
						&& ((NamedElement) rootObject).getName()
								.equalsIgnoreCase(name))
					return (PropertySet) rootObject;
			}
		}
		return null;
	}

	public static List<PropertySet> getPredeclaredPropertySets() {
		ArrayList<PropertySet> predeclaredPropertySets = new ArrayList<PropertySet>();
		for (PropertySet propertySet : GLOBAL_NAMESPACE.getPropertySets()) {
			if (PREDECLARED_PROPERTY_SET_UPPER_CASE_NAMES.contains(propertySet
					.getName().toUpperCase()))
				predeclaredPropertySets.add(propertySet);
		}
		// TODO: Report an error or throw an exception if a property set is
		// missing.
		return predeclaredPropertySets;
	}

	private static class OsateGlobalNamespace extends GlobalNamespaceImpl {
		@Override
		public EList<PublicPackageSection> getPackages() {
			EList<PublicPackageSection> publicSections = new BasicEList<PublicPackageSection>();
			for (Resource res : getResourceSet().getResources()) {
				if (!res.getContents().isEmpty()
						&& res.getContents().get(0) instanceof AadlPackage
						&& ((AadlPackage) res.getContents().get(0))
								.getOwnedPublicSection() != null) {
					publicSections.add(((AadlPackage) res.getContents().get(0))
							.getOwnedPublicSection());
				}
			}
			return publicSections;
		}

		@Override
		public EList<PropertySet> getPropertySets() {
			EList<PropertySet> propertySets = new BasicEList<PropertySet>();
			for (Resource res : getResourceSet().getResources())
				if (!res.getContents().isEmpty()
						&& res.getContents().get(0) instanceof PropertySet)
					propertySets.add((PropertySet) res.getContents().get(0));
			return propertySets;
		}

		@Override
		public EList<NamedElement> getMembers() {
			EList<NamedElement> members = new BasicEList<NamedElement>();
			for (Resource res : getResourceSet().getResources()) {
				if (!res.getContents().isEmpty()) {
					EObject rootObject = res.getContents().get(0);
					if (rootObject instanceof PropertySet)
						members.add((PropertySet) rootObject);
					else if (rootObject instanceof AadlPackage
							&& ((AadlPackage) rootObject)
									.getOwnedPublicSection() != null)
						members.add(((AadlPackage) rootObject)
								.getOwnedPublicSection());
				}
			}
			return members;
		}

		@Override
		public EList<NamedElement> getOwnedMembers() {
			return getMembers();
		}
	}
	
	/**
	 * compare modification date of a to b based on LocalTimeStamp
	 * 
	 * @param res
	 *            Resource to be compared against
	 * @return true if a is newer than b
	 */
	public static boolean isNewerThan(Resource a, Resource b) {
		IResource aFile = OsateResourceManager.convertToIResource(a);
		IResource bFile = OsateResourceManager.convertToIResource(b);
		long aTime = aFile.getLocalTimeStamp();
		long bTime = bFile.getLocalTimeStamp();

		if (aTime > IResource.NULL_STAMP && bTime > IResource.NULL_STAMP && aTime > bTime) {
			return true;
		}
		return false;
	}

}