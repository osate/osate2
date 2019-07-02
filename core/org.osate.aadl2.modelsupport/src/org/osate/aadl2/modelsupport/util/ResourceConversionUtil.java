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
package org.osate.aadl2.modelsupport.util;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.osate.aadl2.SystemImplementation;
import org.osate.workspace.WorkspacePlugin;

/**
 * static utility methods for handling models as persistent resources
 *
 * @author phf
 * @version $Id: OsateResourceManager.java,v 1.17 2009-07-09 19:23:11 jseibel
 *          Exp $
 * @deprecated Unused, will be removed in 2.5.0
 */
@Deprecated
public class ResourceConversionUtil {

	/**
	 * converts Resource into corresponding IResource without use of registry.
	 *
	 * @param res
	 *            Resource
	 * @return IResource
	 */
	public static IResource convertToIResource(Resource res) {
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
		IWorkspaceRoot myWorkspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
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
			return myWorkspaceRoot.getFile(new Path(null, path.toString()));
		} else if (resourceURI.isFile()) {
			return myWorkspaceRoot.getFile(new Path(resourceURI.toFileString())); // ForLocation
		} else {
			throw new IllegalArgumentException("Cannot decode URI protocol: " + resourceURI.scheme());
		}
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
		if (path.lastSegment().equalsIgnoreCase(WorkspacePlugin.AADL_PACKAGES_DIR)) {
			path = path.trimSegments(1);
		}
		URI instanceURI = path.appendSegment(WorkspacePlugin.AADL_INSTANCES_DIR)
				.appendSegment(filename + "_" + si.getTypeName() + "_" + si.getImplementationName());
		instanceURI = instanceURI.appendFileExtension(WorkspacePlugin.INSTANCE_FILE_EXT);
		return instanceURI;
	}

}