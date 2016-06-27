/*
 * <copyright>
 * Copyright  2014 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/org/documents/epl-v10.html.
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
 * Carnegie Mellon Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 * </copyright>
 */
package org.osate.xtext.aadl2.ui.containers;

import static org.osate.aadl2.modelsupport.resources.PredeclaredProperties.AADL_PROJECT;
import static org.osate.aadl2.modelsupport.resources.PredeclaredProperties.AADL_PROJECT_DEFAULT;
import static org.osate.aadl2.modelsupport.resources.PredeclaredProperties.AADL_PROJECT_HANDLE;
import static org.osate.aadl2.modelsupport.resources.PredeclaredProperties.AADL_PROJECT_KEY;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.ui.containers.WorkspaceProjectsStateHelper;
import org.osate.aadl2.modelsupport.Activator;
import org.osate.core.AadlNature;

import com.google.inject.Singleton;

@Singleton
public class Aadl2ProjectsStateHelper extends WorkspaceProjectsStateHelper {

	private final static Logger log = Logger.getLogger(Aadl2ProjectsStateHelper.class);
	private final static String VIRTUAL_HANDLE = "$virtual_handle$";
	private final static URI VTEST_URI = URI.createPlatformPluginURI("/org.osate.xtext.aadl2.properties.ui/VTest.aadl", true);
	
	private IEclipsePreferences prefs = InstanceScope.INSTANCE.getNode(Activator.PLUGIN_ID);

	@Override
	public String initHandle(URI uri) {
		String path = prefs.get(AADL_PROJECT_KEY, AADL_PROJECT_DEFAULT);
		if (uri.lastSegment().equals(AADL_PROJECT) && !uri.equals(URI.createPlatformResourceURI(path, true))) {
			log.debug("skipped " + path);
			return null;
		} else if (uri.equals(VTEST_URI)) {
			return VIRTUAL_HANDLE;
		}
		return super.initHandle(uri);
	}

	@Override
	public Collection<URI> initContainedURIs(String containerHandle) {
		Collection<URI> result;
		if (containerHandle.equals(AADL_PROJECT_HANDLE)) {
			String path = prefs.get(AADL_PROJECT_KEY, AADL_PROJECT_DEFAULT);
			result = Collections.singleton(URI.createPlatformResourceURI(path, true));
			log.debug("added " + path);
		} else if (containerHandle.equals(VIRTUAL_HANDLE)) {
			result = Collections.singleton(VTEST_URI);
		} else {
			result = new HashSet<URI>();
			for (URI uri : super.initContainedURIs(containerHandle)) {
				if (!uri.lastSegment().equals(AADL_PROJECT)) {
					result.add(uri);
				}
			}
		}
		return result;
	}

	@Override
	public List<String> initVisibleHandles(String handle) {
		List<String> result = new ArrayList<>(super.initVisibleHandles(handle));

		result.add(AADL_PROJECT_HANDLE);
		result.add(VIRTUAL_HANDLE);
		return result;
	}

	protected boolean isAccessibleAadlProject(IProject project) {
		try {
			return isAccessibleXtextProject(project) && project.hasNature(AadlNature.ID);
		} catch (CoreException e) {
			log.error(e.getMessage(), e);
		}
		return false;
	}
}
