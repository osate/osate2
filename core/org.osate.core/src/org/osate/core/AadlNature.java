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
package org.osate.core;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.xtext.builder.nature.XtextNature;

@SuppressWarnings("restriction")
public class AadlNature extends XtextNature implements IProjectNature {

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