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
package org.osate.aadl2.modelsupport.modeltraversal;

import java.util.HashSet;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Element;
import org.osate.aadl2.ModelUnit;
import org.osate.aadl2.PropertySet;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.workspace.WorkspacePlugin;

public class TraverseWorkspace {

	public static HashSet<IFile> getAadlandInstanceFilesInWorkspace() {
		HashSet<IFile> result = new HashSet<IFile>();
		getFiles(getProjects(), result, WorkspacePlugin.SOURCE_FILE_EXT);
		getFiles(getProjects(), result, WorkspacePlugin.INSTANCE_FILE_EXT);
		return result;
	}

	public static HashSet<IFile> getAadlFilesInWorkspace() {
		HashSet<IFile> result = new HashSet<IFile>();
		getFiles(getProjects(), result, WorkspacePlugin.SOURCE_FILE_EXT);
		return result;
	}

	public static HashSet<IFile> getInstanceModelFilesInWorkspace() {
		HashSet<IFile> result = new HashSet<IFile>();
		getFiles(getProjects(), result, WorkspacePlugin.INSTANCE_FILE_EXT);
		return result;
	}

	public final EList<Element> getModelUnitsInWorkspace() {
		EList<Element> result = new BasicEList<Element>();
		HashSet<IFile> files = TraverseWorkspace.getAadlFilesInWorkspace();
		for (IFile file : files) {
			ModelUnit target = (ModelUnit) AadlUtil.getElement(file);
			result.add(target);
		}
		return result;
	}

	public final EList<Element> getPackagesInWorkspace() {
		EList<Element> result = new BasicEList<Element>();
		HashSet<IFile> files = TraverseWorkspace.getAadlFilesInWorkspace();
		for (IFile file : files) {
			ModelUnit target = (ModelUnit) AadlUtil.getElement(file);
			if (target instanceof AadlPackage) {
				result.add(target);
			}
		}
		return result;
	}

	public final EList<Element> getPropertysetsInWorkspace() {
		EList<Element> result = new BasicEList<Element>();
		HashSet<IFile> files = TraverseWorkspace.getAadlFilesInWorkspace();
		for (IFile file : files) {
			ModelUnit target = (ModelUnit) AadlUtil.getElement(file);
			if (target instanceof PropertySet) {
				result.add(target);
			}
		}
		return result;
	}

	private static IProject[] getProjects() {
		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();

		IProject[] tmp = new IProject[projects.length];

		int cn = 0;
		for (int i = 0, max = projects.length; i < max; i++) {
			IProject project = projects[i];
			if (project.isOpen()) {
				tmp[cn++] = project;
			}
		}
		return tmp;
	}

	private static HashSet<IFile> getFiles(IResource[] resources, HashSet<IFile> result, String extension) {
		try {
			for (int i = 0; i < resources.length; i++) {
				if (resources[i] instanceof IFile) {
					IFile file = (IFile) resources[i];
					String ext = file.getFileExtension();
					if (ext != null) {
						if (extension.equalsIgnoreCase(WorkspacePlugin.SOURCE_FILE_EXT)
								&& ext.equalsIgnoreCase(WorkspacePlugin.SOURCE_FILE_EXT)) {
							result.add((IFile) resources[i]);
						}
						// looking for old style instance file names (i.e., extension aaxl2
						if (extension.equalsIgnoreCase(WorkspacePlugin.MODEL_FILE_EXT)
								&& ext.equalsIgnoreCase(WorkspacePlugin.MODEL_FILE_EXT)
								&& file.getName().endsWith(WorkspacePlugin.INSTANCE_MODEL_POSTFIX)) {
							result.add((IFile) resources[i]);
						}
						// looking for new style file name extension (aail2) and finding old style instance file names.
						if (extension.equalsIgnoreCase(WorkspacePlugin.INSTANCE_FILE_EXT)
								&& ext.equalsIgnoreCase(WorkspacePlugin.MODEL_FILE_EXT)
								&& file.getName().endsWith(WorkspacePlugin.INSTANCE_MODEL_POSTFIX)) {
							result.add((IFile) resources[i]);
						}
						// looking for and finding new style instance file names
						if (extension.equalsIgnoreCase(WorkspacePlugin.INSTANCE_FILE_EXT)
								&& ext.equalsIgnoreCase(WorkspacePlugin.INSTANCE_FILE_EXT)) {
							result.add((IFile) resources[i]);
						}
					}
				} else if (resources[i] instanceof IContainer) {
					IContainer cont = (IContainer) resources[i];
					if (!cont.getName().startsWith(".")) {
						getFiles(cont.members(), result, extension);
					}
				}
			}
		} catch (CoreException e) {
			WorkspacePlugin.log(e);
		}
		return result;
	}

}
