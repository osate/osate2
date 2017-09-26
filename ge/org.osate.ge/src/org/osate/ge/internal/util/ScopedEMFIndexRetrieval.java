/*******************************************************************************
 * Copyright (C) 2016 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0105.
 *******************************************************************************/
package org.osate.ge.internal.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.eclipse.xtext.ui.resource.LiveScopeResourceSetInitializer;
import org.osate.core.OsateCorePlugin;
import org.osate.ge.internal.ui.util.SelectionUtil;
import org.osate.xtext.aadl2.ui.internal.Aadl2Activator;

import com.google.inject.Injector;

public class ScopedEMFIndexRetrieval {
	/**
	 * Gets a collection containing all EObjects of a specified type which may be directly referenced from the project containing the specified resource.
	 */
	public static Collection<IEObjectDescription> getAllEObjectsByType(final Resource resource, final EClass type) {
		return getAllEObjectsByType(SelectionUtil.getProject(resource), type);
	}

	/**
	 * Gets a collection containing all EObjects of a specified type which may be directly referenced from the specified project
	 */
	public static Collection<IEObjectDescription> getAllEObjectsByType(final IProject project, final EClass type) {
		final Set<IResourceDescription> resourceDescriptions = calculateResourceDescriptions(getReferenceableProjects(project));
		final List<IEObjectDescription> objectDescriptions = new ArrayList<IEObjectDescription>();

		for(final IResourceDescription rd : resourceDescriptions) {
			for(final IEObjectDescription od : rd.getExportedObjectsByType(type)) {
				objectDescriptions.add(od);
			}
		}

		return objectDescriptions;
	}

	/**
	 * Returns the set of projects that can be referenced from the specified project. Includes the specified project.
	 * Not recursive(Projects referenced by referenced projects are not included).
	 * @param resource
	 * @return
	 */
	private static Set<IProject> getReferenceableProjects(final IProject project) {
		try {
			final Set<IProject> projects = new HashSet<IProject>();
			projects.add(project);

			for(final IProject referencedProject : project.getReferencedProjects()) {
				if(!projects.contains(referencedProject)) {
					projects.add(referencedProject);
				}
			}

			return projects;
		} catch(final CoreException ex) {
			throw new RuntimeException(ex);
		}
	}

	public static Set<IResourceDescription> calculateResourceDescriptions(final Set<IProject> projects) {
		final Set<IResourceDescription> resourceDescriptions = new HashSet<IResourceDescription>();
		final Injector injector = OsateCorePlugin.getDefault().getInjector("org.osate.xtext.aadl2.properties.Properties");
		final ResourceDescriptionsProvider resourceDescProvider = injector.getInstance(ResourceDescriptionsProvider.class);
		final XtextResourceSet rs = new XtextResourceSet();
		Aadl2Activator.getInstance().getInjector(Aadl2Activator.ORG_OSATE_XTEXT_AADL2_AADL2)
		.getInstance(LiveScopeResourceSetInitializer.class).initialize(rs);
		final IResourceDescriptions resDescriptions = resourceDescProvider.getResourceDescriptions(rs);
		for(final IResourceDescription resDesc : resDescriptions.getAllResourceDescriptions()) {
			final IPath resPath = new Path(resDesc.getURI().toPlatformString(true));
			for(final IProject p : projects) {
				if(p.getFullPath().isPrefixOf(resPath)) {
					resourceDescriptions.add(resDesc);
					break;
				}
			}
		}

		return resourceDescriptions;
	}
}
