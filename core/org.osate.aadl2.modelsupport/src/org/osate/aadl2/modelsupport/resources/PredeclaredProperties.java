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
package org.osate.aadl2.modelsupport.resources;

import org.apache.log4j.Logger;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.osate.aadl2.modelsupport.Activator;
import org.osgi.service.prefs.BackingStoreException;

public class PredeclaredProperties {
	public static final String AADL_PROJECT = "AADL_Project.aadl";
	private static final String AADL_PROJECT_KEY = "aadl.project.properties";
	public static final String AADL_PROJECT_DEFAULT = "platform:/plugin/org.osate.workspace/resources/properties/Predeclared_Property_Sets/"
			+ AADL_PROJECT;

	private final static Logger log = Logger.getLogger(PredeclaredProperties.class);

	public static void setAadlProject(final IResource newAadlProject) throws ExecutionException {
		IEclipsePreferences prefs = InstanceScope.INSTANCE.getNode(Activator.PLUGIN_ID);
		final String oldAadlProjectPath = prefs.get(AADL_PROJECT_KEY, AADL_PROJECT_DEFAULT);
		String newAadlProjectPath = newAadlProject.getFullPath().toString();
		prefs.put(AADL_PROJECT_KEY, newAadlProjectPath);
		try {
			prefs.flush();
		} catch (BackingStoreException e) {
			log.error(e.getMessage(), e);
			throw new ExecutionException("Could not save preference " + Activator.PLUGIN_ID + " - " + AADL_PROJECT_KEY,
					e);
		}
		// make a change to the project description to force Xtext to rebuild
		new WorkspaceJob("") {
			@Override
			public IStatus runInWorkspace(IProgressMonitor monitor) throws CoreException {
				// This build approach seems to work OK.
				try {
					IProject project = newAadlProject.getProject();
					IProjectDescription description = project.getDescription();
					description.setComment("aadl-project:" + newAadlProject.getFullPath().toString() + "-"
							+ System.currentTimeMillis());
					project.setDescription(description, null);

					String projectName = new Path(oldAadlProjectPath).segment(0);
					project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
					if (project.exists()) {
						description = project.getDescription();
						String oldComment = description.getComment();
						description.setComment(oldComment.replaceFirst("aadl-project:" + oldAadlProjectPath, ""));
						project.setDescription(description, null);
					}
					return new Status(IStatus.OK, Activator.PLUGIN_ID, "");
				} catch (CoreException e) {
					log.error(e.getMessage());
					return new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Could not change project description", e);
				}
			};
		}.schedule();
	}

	public static void resetAadlProject() throws ExecutionException {
		IEclipsePreferences prefs = InstanceScope.INSTANCE.getNode(Activator.PLUGIN_ID);
		prefs.put(AADL_PROJECT_KEY, AADL_PROJECT_DEFAULT);
		try {
			prefs.flush();
		} catch (BackingStoreException e) {
			log.error(e.getMessage(), e);
			throw new ExecutionException("Could not save preference " + Activator.PLUGIN_ID + " - " + AADL_PROJECT_KEY,
					e);
		}
	}

	public static String getAADLProjectPreference() {
		return InstanceScope.INSTANCE.getNode(Activator.PLUGIN_ID).get(AADL_PROJECT_KEY, AADL_PROJECT_DEFAULT);
	}
}