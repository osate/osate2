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

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * static utility methods for handling models as persistent resources
 *
 * @author phf
 * @version $Id: OsateResourceManager.java,v 1.17 2009-07-09 19:23:11 jseibel
 *          Exp $
 */
public final class OsateResourceUtil {
	// private constructor to prevent instantiation
	private OsateResourceUtil() {
		super();
	}

	/**
	 * @deprecated Will be removed in 2.5.1
	 */
	@Deprecated
	public static boolean USES_GUI = true;

	/**
	 * converts Resource into corresponding IResource without use of registry.
	 *
	 * @param res
	 *            Resource
	 * @return IResource
	 * @deprecated Use {@code toFile(resource.getURI())} instead. Will be removed in 2.5.1
	 */
	@Deprecated
	public static IFile convertToIResource(Resource res) {
		if (res == null) {
			return null;
		}

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
	 * @deprecated Use {@link #toIFile(URI)} instead. Will be removed in 2.5.1
	 */
	@Deprecated
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
		IWorkspaceRoot myWorkspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
		if (resourceURI.isPlatform()) {
			// FIXME JD
			// Fixes bug 162, see https://github.com/osate/osate2/issues/162
			return myWorkspaceRoot.getFile(new Path(null, resourceURI.toPlatformString(true)));
		} else if (resourceURI.isFile()) {
			try {
				return myWorkspaceRoot.getFile(new Path(resourceURI.toFileString())); // ForLocation
			} catch (IllegalArgumentException e) {
				return null;
			}
		} else {
			throw new IllegalArgumentException("Cannot decode URI protocol: " + resourceURI.scheme());
		}
	}

	/**
	 * return the IPath for the path. Strips the leading "resource" as necessary
	 *
	 * @param resourceURI The URI of the Resource
	 * @return IPath to the file identified by the URI
	 * @exception IllegalArgumentException Thrown if the URI is
	 * does not use the "platform:" protocol.
	 * @deprecated Use {@code toIFile(URI).getFullPath()} instead. Will be removed in 2.5.1
	 */
	@Deprecated
	public static IPath getOsatePath(final URI resourceURI) {
		/*
		 * I don't really understand why this method does what it does, but
		 * the point seems to be to take a URI for a Resource that resembles
		 * "platform:/resource/xxx/yyy/zzz" and return the Eclipse IPath to
		 * the file for that Resource. This seems to involve removing the
		 * "/resource/" part.
		 *
		 * --aarong
		 */

		// Is it a "plaform:" uri?
		if (resourceURI.scheme() != null && resourceURI.scheme().equalsIgnoreCase("platform")) {
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
				if (lastIdx >= 0) {
					path.append(segments[lastIdx]);
				}
			}
			return new Path(null, path.toString());
		} else if (resourceURI.isFile()) {
			return new Path(resourceURI.toFileString());
		} else {
			throw new IllegalArgumentException("Cannot decode URI protocol: " + resourceURI.scheme());
		}
	}
	
	/**
	 * Gets an IFile from an EMF Resource's URI.
	 * 
	 * @param resourceURI URI of an EMF Resource in the workspace. Must not be null.
	 * @return The IFile corresponding to the EMF Resource. Never null.
	 */
	public static IFile toIFile(URI resourceURI) {
		return ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(resourceURI.toPlatformString(true)));
	}
	
	/**
	 * Gets a Resource's URI from an IResource.
	 */
	public static URI toResourceURI(IResource iResource) {
		return URI.createPlatformResourceURI(iResource.getFullPath().toString(), true);
	}

	/**
	 * gets Resource for given IResource. Will create the resource if it does
	 * not exist
	 *
	 * @param ires
	 *            IResource
	 * @return Resource
	 * @deprecated Use {@code new ResourceSetImpl().getResource(toResourceURI(IResource), boolean)} or
	 *             {@code new ResourceSetImpl().createResource(toResourceURI(IResource))} instead.
	 *             Will be removed in 2.5.1
	 */
	@Deprecated
	public static Resource getResource(IResource ires) {
		IPath path = ires.getFullPath();
		return getResource(URI.createPlatformResourceURI(path.toString(), false));
	}

	/**
	 * @deprecated Use {@code new ResourceSetImpl().getResource(toResourceURI(IResource), boolean)} or
	 *             {@code new ResourceSetImpl().createResource(toResourceURI(IResource))} instead.
	 *             Will be removed in 2.5.1
	 */
	@Deprecated
	public static Resource getResource(IResource ires, ResourceSet rset) {
		IPath path = ires.getFullPath();
		return getResource(URI.createPlatformResourceURI(path.toString(), false), rset);
	}

	/**
	 * gets Resource for given IResource. Will create the resource if it does
	 * not exist
	 *
	 * @param ires
	 *            IResource
	 * @return Resource
	 * @deprecated Use {@link #toResourceURI(IResource)} instead. Will be removed in 2.5.1
	 */
	@Deprecated
	public static URI getResourceURI(IResource ires) {
		IPath path = ires.getFullPath();
		return URI.createPlatformResourceURI(path.toString(), false);
	}

	/**
	 * gets Resource for given URI. Will create the resource if it does not
	 * exist
	 *
	 * @param uri
	 *            URI
	 * @return Resource
	 * @deprecated Use {@link ResourceSet#getResource(URI, boolean)} or {@link ResourceSet#createResource(URI)} instead.
	 *             Will be removed in 2.5.1
	 */
	@Deprecated
	public static Resource getResource(URI uri) {
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource res = null;
		try {
			res = resourceSet.getResource(uri, true);
		} catch (RuntimeException e) {
			// the resource may have been created but load failed
			// let's retrieve the resource without loading
			// NOTE: since demandload is false it will not even be created if it
			// does not already
			// exist
			res = resourceSet.getResource(uri, false);
			// if the retrieval fails create the resource
			if (res == null) {
				res = resourceSet.createResource(uri);
			}
		}
		return res;
	}

	/**
	 * @deprecated Use {@link ResourceSet#getResource(URI, boolean)} or {@link ResourceSet#createResource(URI)} instead.
	 *             Will be removed in 2.5.1
	 */
	@Deprecated
	public static Resource getResource(URI uri, ResourceSet rset) {
		Resource res = null;
		try {
			res = rset.getResource(uri, true);
		} catch (RuntimeException e) {
			// the resource may have been created but load failed
			// let's retrieve the resource without loading
			// NOTE: since demandload is false it will not even be created if it
			// does not already
			// exist
			res = rset.getResource(uri, false);
			// if the retrieval fails create the resource
			if (res == null) {
				res = rset.createResource(uri);
			}
		}
		return res;
	}

	/**
	 * @deprecated Will be removed in 2.5.1
	 */
	@Deprecated
	public static URI saveEMFModel(EObject root, final URI newURI, EObject context) {
		try {
			ResourceSet set = context.eResource().getResourceSet();
			Resource res = getResource(newURI, set);
			res.getContents().clear();
			res.getContents().add(root);
			res.save(null);
			return EcoreUtil.getURI(root);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newURI;
	}

}
