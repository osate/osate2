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
		getFiles(getProjects(), result, WorkspacePlugin.SOURCE_FILE_EXT2);
		getFiles(getProjects(), result, WorkspacePlugin.INSTANCE_FILE_EXT);
		return result;
	}

	public static HashSet<IFile> getAadlFilesInWorkspace() {
		HashSet<IFile> result = new HashSet<IFile>();
		getFiles(getProjects(), result, WorkspacePlugin.SOURCE_FILE_EXT);
		getFiles(getProjects(), result, WorkspacePlugin.SOURCE_FILE_EXT2);
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
						if ((extension.equalsIgnoreCase(WorkspacePlugin.SOURCE_FILE_EXT)
								&& (ext.equalsIgnoreCase(WorkspacePlugin.SOURCE_FILE_EXT))
								|| (extension.equalsIgnoreCase(WorkspacePlugin.SOURCE_FILE_EXT2)
										&& ext.equalsIgnoreCase(WorkspacePlugin.SOURCE_FILE_EXT2)))) {
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
