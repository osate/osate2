package org.osate.aadl2.modelsupport.modeltraversal;

import java.util.HashSet;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.internal.workspace.AadlProject;
import org.osate.workspace.WorkspacePlugin;

public class TraverseWorkspace {
	
	public static HashSet<IFile> getAadlAaxlFilesInWorkspace(){
		return getFiles(getProjects());
	}

	private static IProject[] getProjects() {
		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
		
		IProject[] tmp = new IProject[projects.length];

		int cn = 0;
		for (int i = 0, max = projects.length; i < max; i++) {
			IProject project = projects[i];
			if ( project.isOpen() && AadlProject.hasAadlNature(project)
					&& !project.getName().equalsIgnoreCase(OsateResourceUtil.PLUGIN_RESOURCES_DIRECTORY_NAME)) {
				tmp[cn++] = project;
			}
		}
		return tmp;
	}

	private static HashSet<IFile> getFiles(IProject[] resources) {
		HashSet<IFile> result = new HashSet<IFile>();

		for (int i = 0; i < resources.length; i++) {
			if (resources[i] instanceof IFile) {
				IFile file = (IFile) resources[i];
				if (file.getFileExtension().equalsIgnoreCase(WorkspacePlugin.SOURCE_FILE_EXT)
						|| file.getFileExtension().equalsIgnoreCase("aadl2")
						||file.getFileExtension().equalsIgnoreCase(WorkspacePlugin.INSTANCE_FILE_EXT)){
					result.add( (IFile) resources[i]);
				}
			} else if (resources[i] instanceof IContainer) {
				IContainer cont = (IContainer) resources[i];
				getFiles(cont, result);
			}
		}
		return result;
	}

	private static HashSet<IFile> getFiles(IContainer folder, HashSet<IFile> result) {
		IResource[] resources;
		try {
			resources = folder.members();
			for (int i = 0; i < resources.length; i++) {
				if (resources[i] instanceof IFile) {
					IFile file = (IFile) resources[i];
					if (file.getFileExtension().equalsIgnoreCase(WorkspacePlugin.SOURCE_FILE_EXT)
							|| file.getFileExtension().equalsIgnoreCase("aadl2")
							||file.getFileExtension().equalsIgnoreCase(WorkspacePlugin.INSTANCE_FILE_EXT)){
						result.add( (IFile) resources[i]);
					}
				} else if (resources[i] instanceof IContainer) {
					IContainer cont = (IContainer) resources[i];
					getFiles(cont, result);
				}
			}
		} catch (CoreException e) {
			WorkspacePlugin.log(e);
		}
		return result;
	}

}
