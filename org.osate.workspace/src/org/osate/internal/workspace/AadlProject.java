/*******************************************************************************
 * Copyright (c) 2000, 2004 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/cpl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Carnegie Mellon University - adapted for use in OSATE
 *******************************************************************************/
package org.osate.internal.workspace;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.preference.PreferenceStore;
import org.osate.workspace.IAadlElement;
import org.osate.workspace.IAadlProject;
import org.osate.workspace.IResourceUtility;
import org.osate.workspace.WorkspacePlugin;

/**
 * @author lwrage
 * @version $Id: AadlProject.java,v 1.24 2009-10-07 16:46:48 lwrage Exp $
 */
public class AadlProject extends AadlElement implements IAadlProject {

	public static final String AADLNATURE_ID = "org.osate.core.aadlnature";

	/**
	 * The platform project this <code>IJavaProject</code> is based on
	 */
	private IProject project;

	public AadlProject() {
		super(null, null);
	}

	public AadlProject(IProject project, AadlElement parent) {
		super(parent, project.getName());
		this.project = project;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * edu.cmu.sei.osate.core.IAadlProject#findElement(org.eclipse.core.runtime
	 * .IPath)
	 */
	@Override
	public IAadlElement findElement(IPath element) {
		return null;
	}

	public IFile findFile(IPath path) {
		IFile f = project.getFile(path);

		if (f.exists()) {
			return f;
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see edu.cmu.sei.osate.core.IAadlProject#getProject()
	 */
	@Override
	public IProject getProject() {
		return project;
	}

	/**
	 * Find Aadl source file in file system, i.e., a file with the extension
	 * aadl. Search in the project source folder. Search for file according type
	 * by looking in packages or propertysets as necessary.
	 *
	 * @param name name of AadlSpec, AadlPackage, or propertyset. Package name
	 *            may have "::" as separator.
	 * @return IFile the file
	 */
	@Override
	public IFile findAadlSourceFile(String name) {
		IFile f = null;
		String filename;

		PreferenceStore projectProperties = WorkspacePlugin.getPreferenceStore(project);
		String currentPath = projectProperties.getString(WorkspacePlugin.PROJECT_SOURCE_DIR);
		filename = name.replaceAll(WorkspacePlugin.AADL_PACKAGE_SEPARATOR, WorkspacePlugin.FILE_PACKAGE_SEPARATOR) + "."
				+ WorkspacePlugin.SOURCE_FILE_EXT;
		f = findAadlFile(new Path(currentPath), filename);
		if (f == null) {
			filename = name.replaceAll(WorkspacePlugin.AADL_PACKAGE_SEPARATOR, WorkspacePlugin.FILE_PACKAGE_SEPARATOR)
					+ "." + WorkspacePlugin.SOURCE_FILE_EXT2;
			f = findAadlFile(new Path(currentPath), filename);
		}
		return f;
	}

	/**
	 * Find Aadl model file in file system, i.e., a file with the extension
	 * aaxl. Search in the project model folder. Search for file according type
	 * by looking in packages or propertysets as necessary
	 *
	 * @param name name of AadlSpec, AadlPackage, or propertyset. Package name
	 *            may have "::" as separator.
	 * @return IFile the file
	 */
	@Override
	public IFile findAadlModelFile(String name) {

		PreferenceStore projectProperties = WorkspacePlugin.getPreferenceStore(project);
		String currentPath = projectProperties.getString(WorkspacePlugin.PROJECT_MODEL_DIR);

		IFile f = null;
		String filename = name + "." + WorkspacePlugin.MODEL_FILE_EXT;

		f = findAadlFile(new Path(currentPath), filename);
		return f;
	}

	private IFile tryOtherPackageSeparators(String name, String extension, String currentPath) {
		IFile f = null;
		if (name.indexOf(WorkspacePlugin.AADL_PACKAGE_SEPARATOR) >= 0) {
			String filename = name.replaceAll(WorkspacePlugin.AADL_PACKAGE_SEPARATOR, "_") + "." + extension;
			f = findAadlFile(new Path(currentPath), filename);
			if (f == null) {
				filename = name.replaceAll(WorkspacePlugin.AADL_PACKAGE_SEPARATOR, ".") + "." + extension;
				f = findAadlFile(new Path(currentPath), filename);
			}
		}
		return f;
	}

	/**
	 * find file in specified folder.
	 *
	 * @param path The folder in which to look for the file
	 * @param filename Filename with extension
	 */
	/**
	 * Does preorder processing of containment hierarchy The default
	 * implementation applies the suchThat condition and if true adds the
	 * element to the result list
	 *
	 * @param obj root object
	 * @return EList result list of IFile
	 */
	private IFile findAadlFile(IPath path, String filename) {
		IFolder folder = project.getFolder(path);
		if (!folder.exists()) {
			return null;
		}
		return doFindAadlFile(folder, filename);
	}

	private IFile doFindAadlFile(IContainer folder, String filename) {
		try {
			IResource[] resources = folder.members();

			for (int i = 0; i < resources.length; i++) {
				if (resources[i] instanceof IFile) {
					IFile file = (IFile) resources[i];
					if (file.getName().equalsIgnoreCase(filename)) {
						return file;
					}
				} else if (resources[i] instanceof IContainer) {
					IContainer cont = (IContainer) resources[i];
					IFile file = doFindAadlFile(cont, filename);
					if (file != null) {
						return file;
					}
				}
			}
		} catch (CoreException e) {
			WorkspacePlugin.log(e);
		}
		return null;
	}

	/**
	 * Returns true if the given project is accessible and it has a Aadl nature,
	 * otherwise false.
	 *
	 * @param project IProject
	 * @return boolean
	 */
	public static boolean hasAadlNature(IProject project) {
		try {
			return project.hasNature(AADLNATURE_ID);
		} catch (CoreException e) {
			// project does not exist or is not open
		}
		return false;
	}

	/**
	 * return the path to the AAXL file that corresponds to the specified aadl
	 * file
	 *
	 * @param file
	 * @return IPath path
	 */
	@Override
	public IPath getAaxlPath(IFile file) {
		IPath p = file.getProjectRelativePath();
		IPath result = null;

		PreferenceStore projectProperties = WorkspacePlugin.getPreferenceStore(project);
		IPath src = new Path(projectProperties.getString(WorkspacePlugin.PROJECT_SOURCE_DIR));
		if (src.isPrefixOf(p)) {
			int i = src.segmentCount();
			result = new Path(projectProperties.getString(WorkspacePlugin.PROJECT_MODEL_DIR))
					.append(p.removeFirstSegments(i));
			result = result.removeFileExtension().addFileExtension(WorkspacePlugin.MODEL_FILE_EXT);
			result = new Path(project.getName()).append(result);
		} else {
			result = new Path(project.getName())
					.append(p.removeFileExtension().addFileExtension(WorkspacePlugin.MODEL_FILE_EXT));
		}
		return result;
	}

	/**
	 * return the path to the AADL text file that corresponds to the specified
	 * aaxl model file
	 *
	 * @param file
	 * @return IPath path
	 */
	@Override
	public IPath getAadlPath(IFile file) {
		IPath p = file.getProjectRelativePath();
		IPath result = new Path("/" + project.getName());
		result = result.append(p);
		String fileExtension = result.getFileExtension();
		char version = fileExtension.charAt(fileExtension.length() - 1);
		fileExtension = WorkspacePlugin.SOURCE_FILE_EXT;
		if (Character.isDigit(version)) {
			fileExtension += version;
		}
		result = result.removeFileExtension().addFileExtension(fileExtension);
		return result;
	}

	/**
	 * return the Aadl folder corresponding to the aaxl folder
	 *
	 * @param folder
	 * @return
	 */
	@Override
	public IFolder getComplementFolder(IFolder folder) {
		IPath p = folder.getProjectRelativePath();

		PreferenceStore projectProperties = WorkspacePlugin.getPreferenceStore(project);
		IPath mdl = new Path(projectProperties.getString(WorkspacePlugin.PROJECT_MODEL_DIR));
		IPath text = new Path(projectProperties.getString(WorkspacePlugin.PROJECT_SOURCE_DIR));
		IPath result = new Path("/" + project.getName());
		if (mdl.isPrefixOf(p)) {
			int i = mdl.segmentCount();
			result = result.append(text).append(p.removeFirstSegments(i));
		} else if (text.isPrefixOf(p)) {
			int i = text.segmentCount();
			result = result.append(mdl).append(p.removeFirstSegments(i));
		} else {
			result = result.append(p);
		}
		IFolder outFolder = getProject().getFolder(result.removeFirstSegments(1));
		return outFolder;
	}

	/**
	 * get the output (model) file for the specified file, or null
	 *
	 * @param aadlFile textual aadl file
	 * @return model file or null
	 */
	@Override
	public IFile getAaxlFile(IFile aadlFile) {
		IPath p = getAaxlPath(aadlFile);
		IFile outFile = getProject().getFile(p.removeFirstSegments(1));
		return outFile;
	}

	/**
	 * get the aadl file for the aaxl file, or null
	 *
	 * @param aaxlFile XML aadl file
	 * @return model file or null
	 */
	@Override
	public IFile getAadlFile(IFile aaxlFile) {
		IPath p = getAadlPath(aaxlFile);
		IFile outFile = getProject().getFile(p.removeFirstSegments(1));
		return outFile;
	}

	/**
	 * return recent aaxl file. return null if there are syntax errors, or the
	 * aaxl filedoes note xist or is out of date
	 *
	 * @param file IFile aadl text file
	 * @return IFile aaxl file
	 */
	@Override
	public IFile getRecentAaxlFile(IFile file) {
		IFile aaxlFile = getAaxlFile(file);
		if (!aaxlFile.exists() || IResourceUtility.isModelTaggedWithSyntaxErrors(aaxlFile)) {
			return null;
		}
		// project
		// name
		long inTime = file.getLocalTimeStamp();
		long outTime = aaxlFile.getLocalTimeStamp();

		if (outTime > IResource.NULL_STAMP && inTime < outTime) {
			return aaxlFile;
		} else if (((IResource) file).isDerived()) {
			return aaxlFile;
		}
		return null;
	}

	private final String instanceEnd = WorkspacePlugin.INSTANCE_MODEL_POSTFIX + "." + WorkspacePlugin.INSTANCE_FILE_EXT;

	/**
	 * clean all declarative model files, i.e., files with the extension aaxl
	 * that contain AadlSpec, AadlPacakge, or PropertySet cleaning them means
	 * marking them as having syntax errors which will cause the compile to
	 * occur
	 */
	@Override
	public void cleanAllDeclarativeModelFiles(final IProgressMonitor monitor) {
		IPath path = null;
		IContainer folder = null;
		PreferenceStore projectProperties = WorkspacePlugin.getPreferenceStore(project);
		String currentPath = projectProperties.getString(WorkspacePlugin.PROJECT_MODEL_DIR);
		IPath modelfolder = new Path(currentPath);
		path = modelfolder;
		if (path.segmentCount() == 0) {
			folder = project;

		} else {
			folder = project.getFolder(path);
		}
		if (folder.exists()) {
			new ForAllIFile() {
				@Override
				protected void process(IFile theFile) {
					String filename = theFile.getName();
					if (filename.endsWith(WorkspacePlugin.MODEL_FILE_EXT) && !filename.endsWith(instanceEnd)) {
						IResourceUtility.tagModelWithSyntaxErrors(theFile);
					}
				}
			}.traverse(folder);
		}
	}

	/**
	 * clean all AADL Text files, i.e., make sure they are not marked as derived
	 * In the new scheme of things text filees are always up to date with XML
	 * models thus can be used to do a clean build
	 */
	@Override
	@Deprecated
	public void cleanAllAADLTextFiles(final IProgressMonitor monitor) {
		IPath path = null;
		IContainer folder = null;
		PreferenceStore projectProperties = WorkspacePlugin.getPreferenceStore(project);
		String currentPath = projectProperties.getString(WorkspacePlugin.PROJECT_SOURCE_DIR);
		IPath modelfolder = new Path(currentPath);
		path = modelfolder;
		if (path.segmentCount() == 0) {
			folder = project;

		} else {
			folder = project.getFolder(path);
		}
		if (folder.exists()) {
			new ForAllIFile() {
				@Override
				protected void process(IFile theFile) {
					String filename = theFile.getName();
					if (filename.endsWith(WorkspacePlugin.SOURCE_FILE_EXT)
							|| filename.endsWith(WorkspacePlugin.SOURCE_FILE_EXT2)) {
						try {
							theFile.setDerived(false);
						} catch (CoreException e) {
							WorkspacePlugin.log(e);
						}
					}
				}
			}.traverse(folder);
		}
	}

	/**
	 * get all instance model files
	 */
	@Override
	public EList<IFile> getAllInstanceModelFiles(final IProgressMonitor monitor) {
		IPath path = null;
		IContainer folder = null;
		PreferenceStore projectProperties = WorkspacePlugin.getPreferenceStore(project);
		String currentPath = projectProperties.getString(WorkspacePlugin.PROJECT_MODEL_DIR);
		IPath modelfolder = new Path(currentPath);
		path = modelfolder;
		if (path.segmentCount() == 0) {
			folder = project;

		} else {
			folder = project.getFolder(path);
		}
		if (folder.exists()) {
			EList<IFile> result = new ForAllIFile() {
				@Override
				protected boolean suchThat(IFile obj) {
					String filename = obj.getName();
					return filename.endsWith(instanceEnd);
				}
			}.traverse(folder);
			return result;
		}
		return new BasicEList<IFile>();
	}

	/**
	 * delete all model instance files, i.e., files with the extension aaxl that
	 * contain instance models. The file is recognized by the filename ending in
	 * "_instance.aaxl"
	 */
	@Override
	public void deleteAllInstanceModelFiles(final IProgressMonitor monitor) {
		IPath path = null;
		IContainer folder = null;
		PreferenceStore projectProperties = WorkspacePlugin.getPreferenceStore(project);
		String currentPath = projectProperties.getString(WorkspacePlugin.PROJECT_MODEL_DIR);
		IPath modelfolder = new Path(currentPath);
		path = modelfolder;
		if (path.segmentCount() == 0) {
			folder = project;

		} else {
			folder = project.getFolder(path);
		}
		if (folder.exists()) {
			new ForAllIFile() {
				@Override
				protected void process(IFile theFile) {
					String name = theFile.getName();
					if (name.endsWith(instanceEnd)) {
						try {
							theFile.delete(true, monitor);
						} catch (CoreException e) {
							WorkspacePlugin.log(e);
						}
					}
				}
			}.traverse(folder);
		}
	}

	/**
	 * add all source files to be processed
	 */
	@Override
	public EList<IFile> getAllSourceFiles() {
		IPath path = null;
		IContainer folder = null;
		PreferenceStore projectProperties = WorkspacePlugin.getPreferenceStore(project);
		String currentPath = projectProperties.getString(WorkspacePlugin.PROJECT_SOURCE_DIR);
		IPath modelfolder = new Path(currentPath);
		path = modelfolder;
		if (path.segmentCount() == 0) {
			folder = project;

		} else {
			folder = project.getFolder(path);
		}
		if (folder.exists()) {
			EList<IFile> result = new ForAllIFile() {
				@Override
				protected boolean suchThat(IFile obj) {
					String name = obj.getName();
					return (name.endsWith(WorkspacePlugin.SOURCE_FILE_EXT)
							|| name.endsWith(WorkspacePlugin.SOURCE_FILE_EXT2));
				}
			}.traverse(folder);
			return result;
		}
		return new BasicEList<IFile>();
	}

	/**
	 * Get all the model files (declarative and instance) in the Aadl Project.
	 */
	@Override
	public EList<IFile> getAllModelFiles() {
		IPath path = null;
		IContainer folder = null;
		PreferenceStore projectProperties = WorkspacePlugin.getPreferenceStore(project);
		String currentPath = projectProperties.getString(WorkspacePlugin.PROJECT_MODEL_DIR);
		IPath modelfolder = new Path(currentPath);
		path = modelfolder;
		if (path.segmentCount() == 0) {
			folder = project;

		} else {
			folder = project.getFolder(path);
		}
		if (folder.exists()) {
			EList<IFile> result = new ForAllIFile() {
				@Override
				protected boolean suchThat(IFile obj) {
					String name = obj.getName();
					return name.endsWith(WorkspacePlugin.MODEL_FILE_EXT);
				}
			}.traverse(folder);
			return result;
		}
		return new BasicEList<IFile>();
	}

	@Override
	public String getAadlProjectFile() {
		String customFile = WorkspacePlugin.getPreferenceStore(project).getString(WorkspacePlugin.AADL_PROJECT_FILE);

		if (project.getFile(customFile).exists()) {
			return customFile;
		}
		return null;
	}

}