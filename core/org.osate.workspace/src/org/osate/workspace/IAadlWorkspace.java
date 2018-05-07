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
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;

/**
 * Represent the root AADL element corresponding to the workspace. There is only
 * one such root element. The AADL model element has no parent (it is the root
 * of the Java element hierarchy). Its children are <code>IJavaProject</code> s.
 * <p>
 * This interface provides methods for performing copy, move, rename, and delete
 * operations on multiple Java elements.
 * </p>
 * <p>
 * This interface is not intended to be implemented by clients. An instance of
 * one of these handles can be created via
 * <code>JavaCore.create(workspace.getRoot())</code>.
 * </p>
 */
public interface IAadlWorkspace extends IAadlElement, IParent {
	/**
	 * @param resource the resource to check
	 * @return true if the resource is accessible through the Java model
	 * @since 2.1
	 */
	boolean contains(IResource resource);

	/**
	 * Returns the AADL project with the given name. This is a handle-only
	 * method. The project may or may not exist.
	 *
	 * @param name the name of the AADL project
	 * @return the AADL project with the given name
	 */
	IAadlProject getAadlProject(String name);

	/**
	 * Returns the AADL project for a given workbench resource. This is a
	 * handle-only method. The project may or may not exist.
	 *
	 * @return the AADL project with the given name
	 */
	IAadlProject getAadlProject(IResource resource);

	/**
	 * Returns the AADL projects in this AADL workspace, or an empty array if
	 * there are none.
	 *
	 * @return the AADL projects in this AADL workspace, or an empty array if
	 *         there are none
	 */
	IAadlProject[] getAadlProjects();

	/**
	 * Creates AADL projects for all open projects in the workspace that have an
	 * AADL nature.
	 *
	 * @return An array of AADL project handles.
	 */
	IAadlProject[] getOpenAadlProjects();

	/**
	 * Returns an array of non-Java resources (that is, non-Java projects) in
	 * the workspace.
	 * <p>
	 * Non-Java projects include all projects that are closed (even if they have
	 * the Java nature).
	 * </p>
	 *
	 * @return an array of non-Java projects (<code>IProject</code>s) contained
	 *         in the workspace.
	 * @throws AadlModelException if this element does not exist or if an
	 *             exception occurs while accessing its corresponding resource
	 * @since 2.1
	 */
	// Object[] getNonAadlResources() throws AadlModelException;
	/**
	 * Returns the workspace associated with this Java model.
	 *
	 * @return the workspace associated with this Java model
	 */
	IWorkspace getWorkspace();

	/**
	 * remove the specified file from the lookup table
	 *
	 * @param f IFile
	 */
	void removeFromLookupTable(IFile f);

}