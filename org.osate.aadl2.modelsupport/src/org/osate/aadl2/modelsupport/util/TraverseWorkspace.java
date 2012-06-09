package org.osate.aadl2.modelsupport.util;

import java.util.HashSet;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.osate.workspace.WorkspacePlugin;

public class TraverseWorkspace {
	
	public static HashSet<IFile> getAadlandInstanceFilesInWorkspace(){
		HashSet<IFile> result = new HashSet<IFile>();
		getFiles(getProjects(),result,WorkspacePlugin.SOURCE_FILE_EXT);
		getFiles(getProjects(),result,WorkspacePlugin.INSTANCE_FILE_EXT);
		return result;
	}
	
	public static HashSet<IFile> getAadlFilesInWorkspace(){
		HashSet<IFile> result = new HashSet<IFile>();
		getFiles(getProjects(),result,WorkspacePlugin.SOURCE_FILE_EXT);
		return result;
	}
	
	public static HashSet<IFile> getInstanceModelFilesInWorkspace(){
		HashSet<IFile> result = new HashSet<IFile>();
		getFiles(getProjects(),result,WorkspacePlugin.INSTANCE_FILE_EXT);
		return result;
	}

	private static IProject[] getProjects() {
		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
		
		IProject[] tmp = new IProject[projects.length];

		int cn = 0;
		for (int i = 0, max = projects.length; i < max; i++) {
			IProject project = projects[i];
			if ( project.isOpen()// && AadlProject.hasAadlNature(project)
					&& !project.getName().equalsIgnoreCase(PredeclaredProperties.PLUGIN_RESOURCES_DIRECTORY_NAME)) {
				tmp[cn++] = project;
			}
		}
		return tmp;
	}
	
	public static IFile getAADLProjectFile(){
		IWorkspaceRoot myWorkspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
		IProject prproject = myWorkspaceRoot.getProject(PredeclaredProperties.PLUGIN_RESOURCES_DIRECTORY_NAME);
		return prproject.getFile("AADL_Project.aadl");
	}


	private static HashSet<IFile> getFiles(IResource[] resources, HashSet<IFile> result, String extension) {
		try {
			for (int i = 0; i < resources.length; i++) {
				if (resources[i] instanceof IFile) {
					IFile file = (IFile) resources[i];
					String ext = file.getFileExtension();
					if (ext != null){
						if( extension.equalsIgnoreCase(WorkspacePlugin.SOURCE_FILE_EXT) && (ext.equalsIgnoreCase(extension)
								|| ext.equalsIgnoreCase("aadl2"))){
							result.add( (IFile) resources[i]);
						}
						if (extension.equalsIgnoreCase(WorkspacePlugin.MODEL_FILE_EXT) && ext.equalsIgnoreCase(extension) &&
								file.getName().endsWith(WorkspacePlugin.INSTANCE_MODEL_POSTFIX)){
							result.add( (IFile) resources[i]);
						}
						if (extension.equalsIgnoreCase(WorkspacePlugin.INSTANCE_FILE_EXT) && ext.equalsIgnoreCase(extension) ){
							result.add( (IFile) resources[i]);
						}
					}
				} else if (resources[i] instanceof IContainer) {
					IContainer cont = (IContainer) resources[i];
					if (!cont.getName().startsWith(".")){
						getFiles(cont.members(), result,extension);
					}
				}
			}
		} catch (CoreException e) {
			WorkspacePlugin.log(e);
		}
		return result;
	}

}
