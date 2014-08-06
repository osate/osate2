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
package org.osate.workspace;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;

/**
 * Represent an AADL project. This object mirrors an Eclipse project.
 * <p>
 * This interface provides methods for finding files in projects.
 * </p>
 * <p>
 * This interface is not intended to be implemented by clients.
 */
public interface IAadlProject extends IAadlElement {

	IAadlElement findElement(IPath element);

	IProject getProject();

	/**
	 * Look up a package or property set by name in this project
	 *
	 * @param name the name of the package to find
	 * @return the file resource for the source, an .aadl file, or null if the
	 *         file cannot be found.
	 */
	IFile findAadlSourceFile(String name);

	/**
	 * Look up a package or property set XML model by name in all projects in
	 * the workspace. The lookup uses the projects' aadlpaths.
	 *
	 * @param name the name of the package to find
	 * @return the file resource for the model, an .aaxl file, or null if the
	 *         file cannot be found.
	 */
	IFile findAadlModelFile(String name);

	/**
	 * Create the path of the XML ouput file for a given AADL source file in
	 * this project.
	 *
	 * @param aadlFile the AADL source file
	 * @return the path of the corresponding model file
	 */
	IPath getAaxlPath(IFile aadlFile);

	/**
	 * return the path to the AADL text file that corresponds to the specified
	 * aaxl model file
	 *
	 * @param file
	 * @return IPath path
	 */
	IPath getAadlPath(IFile file);

	/**
	 * return recent aaxl file. return null if there are syntax errors, or the
	 * aaxl filedoes not exist or is out of date
	 *
	 * @param file IFile aadl text file
	 * @return IFile aaxl file
	 */
	IFile getRecentAaxlFile(IFile file);

	/**
	 * clean all declarative AADL (XML) files
	 */
	void cleanAllDeclarativeModelFiles(IProgressMonitor monitor);

	/**
	 * clean all AADL Text files
	 */
	void cleanAllAADLTextFiles(IProgressMonitor monitor);

	/**
	 * get the output (model) file for the specified file, or null
	 *
	 * @param aadlFile
	 * @return model file or null
	 */
	IFile getAaxlFile(IFile aadlFile);

	/**
	 * get the aadl file for the aaxl file, or null
	 *
	 * @param aaxlFile XML aadl file
	 * @return model file or null
	 */
	IFile getAadlFile(IFile aaxlFile);

	/**
	 * return the Aadl folder corresponding to the aaxl folder
	 *
	 * @param folder
	 */
	IFolder getComplementFolder(IFolder folder);

	/**
	 * get all source files
	 */
	EList<IFile> getAllSourceFiles();

	/**
	 * delete all instance files
	 */
	void deleteAllInstanceModelFiles(IProgressMonitor monitor);

	/**
	 * get all instance model files
	 */
	EList<IFile> getAllInstanceModelFiles(IProgressMonitor monitor);

	/** Get all the model files in the project, both declarative and instance. */
	EList<IFile> getAllModelFiles();

	public String getAadlProjectFile();
}