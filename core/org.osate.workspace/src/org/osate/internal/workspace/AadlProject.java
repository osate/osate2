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

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.osate.workspace.IAadlElement;
import org.osate.workspace.IAadlProject;
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
}