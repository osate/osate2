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
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;

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
	 * return the path to the AADL text file that corresponds to the specified
	 * aaxl model file
	 *
	 * @param file
	 * @return IPath path
	 */
	IPath getAadlPath(IFile file);

	/**
	 * get the aadl file for the aaxl file, or null
	 *
	 * @param aaxlFile XML aadl file
	 * @return model file or null
	 */
	IFile getAadlFile(IFile aaxlFile);
}