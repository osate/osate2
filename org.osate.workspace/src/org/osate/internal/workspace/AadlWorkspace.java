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

import java.util.Hashtable;
import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.osate.workspace.IAadlProject;
import org.osate.workspace.IAadlWorkspace;

/**
 * @author lwrage
 */
public class AadlWorkspace extends AadlElement implements IAadlWorkspace {

	private static AadlWorkspace theWorkspace = new AadlWorkspace();

	private Hashtable lookupFile = new Hashtable();

	public static IAadlWorkspace getAadlWorkspace() {
		return theWorkspace;
	}

	/**
	 * Constructs a new AADL workspace.
	 *
	 * @exception Error if called more than once
	 */
	protected AadlWorkspace() throws Error {
		super(null, "" /* workspace has empty name */); //$NON-NLS-1$
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * edu.cmu.sei.osate.core.IAadlWorkspace#contains(org.eclipse.core.resources
	 * .IResource)
	 */
	@Override
	public boolean contains(IResource resource) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * edu.cmu.sei.osate.core.IAadlWorkspace#getAadlProject(java.lang.String)
	 */
	@Override
	public IAadlProject getAadlProject(String projectName) {
		return new AadlProject(ResourcesPlugin.getWorkspace().getRoot().getProject(projectName), this);
	}

	/**
	 * Creates an AADL project associated with the specified resource.
	 *
	 * @return The AADL project for the resource, or <code>null</code> if the
	 *         resource is not in a project. This happens when the resource is a
	 *         File that does not exist in the workspace (i.e., it is a standard
	 *         property set).
	 */
	@Override
	public IAadlProject getAadlProject(IResource resource) {
		final IProject project;
		final int type = resource.getType();
		if (type == IResource.FOLDER || type == IResource.FILE) {
			project = resource.getProject();
		} else if (type == IResource.PROJECT) {
			project = (IProject) resource;
		} else {
			throw new IllegalArgumentException("Invalid Resource for Project");
		}

		if (project.exists()) {
			return new AadlProject(project, this);
		} else {
			return null;
		}
	}

	/**
	 * Creates AADL projects for all projects in the workspace that have an AADL
	 * nature.
	 *
	 * @return An array of AADL project handles.
	 */
	@Override
	public IAadlProject[] getAadlProjects() {
		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
		IAadlProject[] tmp = new IAadlProject[projects.length];

		int cn = 0;
		for (int i = 0, max = projects.length; i < max; i++) {
			IProject project = projects[i];
			if (AadlProject.hasAadlNature(project)) {
				tmp[cn++] = new AadlProject(project, this);
			}
		}
		IAadlProject[] aadlProjects = new IAadlProject[cn];
		for (int j = 0; j < cn; j++) {
			aadlProjects[j] = tmp[j];
		}
		return aadlProjects;
	}

	/**
	 * Creates AADL projects for all open projects in the workspace that have an
	 * AADL nature.
	 *
	 * @return An array of AADL project handles.
	 */
	@Override
	public IAadlProject[] getOpenAadlProjects() {
		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
		IAadlProject[] tmp = new IAadlProject[projects.length];

		int cn = 0;
		for (int i = 0, max = projects.length; i < max; i++) {
			IProject project = projects[i];
			if (AadlProject.hasAadlNature(project) && project.isOpen()) {
				tmp[cn++] = new AadlProject(project, this);
			}
		}
		IAadlProject[] aadlProjects = new IAadlProject[cn];
		for (int j = 0; j < cn; j++) {
			aadlProjects[j] = tmp[j];
		}
		return aadlProjects;
	}

	public IAadlProject getFirstOpenAadlProject() {
		IAadlProject[] projects = getOpenAadlProjects();
		if (projects.length > 0) {
			return projects[0];
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see edu.cmu.sei.osate.core.IAadlWorkspace#getWorkspace()
	 */
	@Override
	public IWorkspace getWorkspace() {
		return ResourcesPlugin.getWorkspace();
	}

	/**
	 * the workspace maintains a lookup table to map names to File objects. This
	 * method removes any entries for which the value (IFile) does not exist
	 */
	public void validateLookupTable() {
		Iterator keyit = lookupFile.keySet().iterator();
		for (Iterator it = lookupFile.values().iterator(); it.hasNext();) {
			IFile f = (IFile) it.next();
			String s = (String) keyit.next();
			if (!f.exists()) {
				lookupFile.remove(f.getName());
			}
		}
	}

	/**
	 * the workspace maintains a lookup table to map names to File objects. This
	 * method clears the lookup table.
	 */
	public void clearLookupTable() {
		lookupFile.clear();
	}

	/**
	 * remove the specified file from the lookup table
	 *
	 * @param f IFile
	 */
	@Override
	public void removeFromLookupTable(IFile f) {
		lookupFile.remove(f.getName());
	}
}