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
package org.osate.aadl2.modelsupport.resources;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMLParserPoolImpl;
import org.eclipse.xtext.resource.SaveOptions;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;
import org.osate.aadl2.Element;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.util.Aadl2ResourceImpl;
import org.osate.core.OsateCorePlugin;
import org.osate.workspace.WorkspacePlugin;

import com.google.inject.Injector;



/**
 * static utility methods for handling models as persistent resources
 * 
 * @author phf
 * @version $Id: OsateResourceManager.java,v 1.17 2009-07-09 19:23:11 jseibel
 *          Exp $
 */
public class OsateResourceUtil {


	private static boolean DEBUG = true;

	public static final String PLUGIN_RESOURCES_DIRECTORY_NAME = "Plugin_Resources";

    
    private static Injector injector = OsateCorePlugin
            .getDefault().getInjector("org.osate.xtext.aadl2.properties.Properties");//org.osate.xtext.aadl2.Aadl2");

    private static IResourceSetProvider fResourceSetProvider;
    
    private static XtextResourceSet resourceSet;
    
	public static ResourceSet getResourceSet(Element context){
		ResourceSet crs = context.eResource().getResourceSet();
		setResourceSet(crs);
		return crs; 
	}
    
    public static void setResourceSet(ResourceSet rs){
    	if (resourceSet == null && rs instanceof XtextResourceSet){
    		resourceSet =(XtextResourceSet) rs;
    	}
    	if (resourceSet != null && resourceSet != rs){
    		return;
    	}
    }
    
    public static XtextResourceSet getResourceSet(){
    	if (injector==null) {
    		injector = OsateCorePlugin
    				.getDefault().getInjector("org.osate.xtext.aadl2.properties.Properties");
    		if (injector == null){
    			return null;
    		}
    	}
        PredeclaredProperties.initPluginContributedAadl();
        IWorkspace workspace = ResourcesPlugin.getWorkspace();
        IWorkspaceRoot root = workspace.getRoot();
        IProject project = root.getProject(PredeclaredProperties.PLUGIN_RESOURCES_DIRECTORY_NAME);
        if (fResourceSetProvider == null)
        	fResourceSetProvider = injector.getInstance(IResourceSetProvider.class);

        if (resourceSet == null) 
        	resourceSet = (XtextResourceSet) fResourceSetProvider.get(project);
        return resourceSet;
   	
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
		if (uri != null) {
			return getOsateIFile(uri);
		}
		return null;
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
	public static IFile getOsateIFile(final URI resourceURI) {
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
		IWorkspaceRoot myWorkspaceRoot = ResourcesPlugin.getWorkspace()
				.getRoot();
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
			return myWorkspaceRoot.getFile(new Path(null, path.toString()));
		} else if (resourceURI.isFile()) {
			return  myWorkspaceRoot.getFile(new Path(resourceURI.toFileString())); //ForLocation
		} else {
			throw new IllegalArgumentException("Cannot decode URI protocol: "
					+ resourceURI.scheme());
		}
	}

//	/**
//	 * Find the resource for given URI, but do not demand load
//	 * 
//	 * @param uri
//	 *            URI
//	 * @return Resource, null if it is not in the resource set.
//	 */
//	public static Resource findResource(URI uri) {
//		return getResourceSet().getResource(uri, false);
//	}

	/**
	 * Find the resource for given URI, but do not demand load
	 * 
	 * @param uri
	 *            URI
	 * @return Resource, null if it is not in the resource set.
	 */
	public static Resource findResource(URI uri, Element context) {
		return context.eResource().getResourceSet().getResource(uri, false);
	}

	/**
	 * creates a Resource for file name with path within Eclipse If it exists,
	 * it will delete the file before creating the resource.
	 * 
	 * @param uri Assumed to be an aadl or aaxl extension
	 * @return Resource Xtext resource for aadl and Aadl2ResourceImpl for aaxl
	 */
	public static Resource getEmptyAadl2Resource(URI uri) {
		Resource res = null;
		if (uri != null) {
			IResource iResource =  getOsateIFile(uri);
			if (iResource != null && iResource.exists()) {
				try {
					iResource.delete(true, null);
				} catch (CoreException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
		}

		res = getResourceSet().createResource(uri);
		return res;
	}

	/**
	 * creates a Resource for file name with path within Eclipse If it exists,
	 * it will delete the file before creating the resource.
	 * 
	 * @param uri Assumed to be an aadl or aaxl extension
	 * @return Resource Xtext resource for aadl and Aadl2ResourceImpl for aaxl
	 */
	public static Resource getEmptyAadl2Resource(URI uri, Element context) {
		Resource res = null;
		if (uri != null) {
			IResource iResource =  getOsateIFile(uri);
			if (iResource != null && iResource.exists()) {
				try {
					iResource.delete(true, null);
				} catch (CoreException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
		}
		res = getResourceSet(context).createResource(uri);
		return res;
	}

	/**
	 * creates a Resource for file name with path within Eclipse If it exists,
	 * it will delete the file before creating the resource.
	 * 
	 * @param uri Assumed to be an aaxl extension
	 * @return Resource Aadl2ResourceImpl for aaxl
	 */
	public static Resource getEmptyAaxl2Resource(URI uri, Element context) {
		if (uri == null) return null;
		Resource res  = findResource(uri,context);
//			IResource iResource =  getOsateIFile(uri);
//			if (iResource != null && iResource.exists()) {
//				try {
//					iResource.delete(true, null);
//				} catch (CoreException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				}
		if (res == null){
			res = getResourceSet(context).createResource(uri);
		} else {
			// remove content
			res.getContents().clear();
		}
		return res;
	}

	public static void save(Resource res){
		try {
			res.save(null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Save model as text and apply Formatter in the process
	 */
	public static void saveFormatted(Resource res){
		SaveOptions.Builder sb = SaveOptions.newBuilder();
		sb = sb.format();
		try {
			res.save(sb.getOptions().toOptionsMap());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		return getResource(URI.createPlatformResourceURI(path.toString(), false));
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

	/*
	 * returns the instance model URI for a given system implementation
	 * 
	 * @param si
	 * 
	 * @return URI for instance model file
	 */
	public static URI getInstanceModelURI(SystemImplementation si) {
		Resource res = si.eResource();
		URI modeluri = res.getURI();
		String last = modeluri.lastSegment();
		String filename = last.substring(0, last.indexOf('.'));
		URI path = modeluri.trimSegments(1);
		if (path.lastSegment().equalsIgnoreCase(WorkspacePlugin.AADL_PACKAGES_DIR)){
			path = path.trimSegments(1);
		}
		URI instanceURI = path.appendSegment(WorkspacePlugin.AADL_INSTANCES_DIR)
				.appendSegment(
				filename + "_" + si.getTypeName() + "_" + si.getImplementationName() + WorkspacePlugin.INSTANCE_MODEL_POSTFIX );
		instanceURI = instanceURI.appendFileExtension(WorkspacePlugin.INSTANCE_FILE_EXT);
		return instanceURI;
	}


}