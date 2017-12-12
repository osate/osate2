/**
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
 *
 * @version $Id: AadlNature.java,v 1.6 2007-12-27 22:15:05 jseibel Exp $
 */
package org.osate.core;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.xtext.builder.nature.XtextNature;

@SuppressWarnings("restriction")
public class AadlNature extends XtextNature implements IProjectNature {

	public static final String copyright = "Copyright 2004 by Carnegie Mellon University, all rights reserved";

	public static final String ID = OsateCorePlugin.PLUGIN_ID + ".aadlnature";

	public static final String DEBUG_OPTION = OsateCorePlugin.PLUGIN_ID + "/nature/debug";

	public static boolean DEBUG = false;

	private IProject project;

	public AadlNature() {
		DEBUG = OsateCorePlugin.isDebug(DEBUG_OPTION);
	}

	/**
	 * @see IProjectNature#getProject()
	 */
	@Override
	public IProject getProject() {
		return project;
	}

	/**
	 * @see IProjectNature#setProject(IProject)
	 */
	@Override
	public void setProject(IProject project) {
		this.project = project;
	}

	/**
	 * @see IProjectNature#configure()
	 */
	@Override
	public void configure() throws CoreException {
		if (DEBUG) {
			System.out.println("configuring AADL nature");
		}
	}

	/**
	 * @see IProjectNature#deconfigure()
	 */
	@Override
	public void deconfigure() throws CoreException {
		if (DEBUG) {
			System.out.println("deconfiguring AADL nature");
		}
	}

	public static void addNature(IProject project, IProgressMonitor monitor) {
		if (project != null) {
			if (DEBUG) {
				System.out.println("adding AADL nature to project '" + project.getName() + "'");
			}
			try {
				if (!project.hasNature(ID)) {
					IProjectDescription desc = project.getDescription();
					String[] oldNatures = desc.getNatureIds();
					String[] newNatures = new String[oldNatures.length + 1];
					System.arraycopy(oldNatures, 0, newNatures, 1, oldNatures.length);
					newNatures[0] = ID;
					desc.setNatureIds(newNatures);
					project.setDescription(desc, monitor);
				}
			} catch (CoreException e) {
				OsateCorePlugin.log(e);
			}
		}
	}

	public static void removeNature(IProject project, IProgressMonitor monitor) {
		if (project != null) {
			if (DEBUG) {
				System.out.println("removing AADL nature from project '" + project.getName() + "'");
			}
			try {
				if (project.hasNature(ID)) {
					IProjectDescription desc = project.getDescription();
					String[] oldNatures = desc.getNatureIds();
					String[] newNatures = new String[oldNatures.length - 1];
					int newIndex = oldNatures.length - 2;
					for (int i = oldNatures.length - 1; i >= 0; i--) {
						if (!oldNatures[i].equals(ID)) {
							newNatures[newIndex--] = oldNatures[i];
						}
					}
					desc.setNatureIds(newNatures);
					project.setDescription(desc, monitor);
				}
			} catch (CoreException e) {
				OsateCorePlugin.log(e);
			}
		}
	}

	/**
	 * Returns true if given project has an AADL project nature.
	 * @see IProject#hasNature(String)
	 */
	public static boolean hasNature(IProject project) {
		boolean hasNature;
		if (!project.isOpen()) {
			return false;
		}
		try {
			hasNature = project.hasNature(ID);
		} catch (CoreException e) {
			OsateCorePlugin.log(e);
			hasNature = false;
		}
		return hasNature;
	}

}