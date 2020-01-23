/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
 * All Rights Reserved.
 * 
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 * 
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.ge.internal.util;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.eclipse.xtext.ui.resource.LiveScopeResourceSetInitializer;
import org.osate.ge.internal.ui.util.SelectionUtil;
import org.osate.xtext.aadl2.ui.internal.Aadl2Activator;

import com.google.common.collect.Streams;
import com.google.inject.Injector;

public class ScopedEMFIndexRetrieval {
	/**
	 * Gets a collection containing all EObjects of a specified type which may be directly referenced from the project containing the specified resource.
	 */
	public static Collection<IEObjectDescription> getAllEObjectsByType(final Resource resource, final EClass type) {
		return getAllEObjectsByType(SelectionUtil.getProjectOrThrow(resource), type);
	}

	/**
	 * Gets a collection containing all EObjects of a specified type which may be directly referenced from the specified project
	 */
	public static Collection<IEObjectDescription> getAllEObjectsByType(final IProject project, final EClass type) {
		return calculateVisibleResourceDescriptions(project)
				.flatMap(rd -> Streams.stream(rd.getExportedObjectsByType(type)))
				.collect(Collectors.toList());
	}

	private static boolean isInProject(final IResourceDescription rd, final IProject project) {
		final IPath resPath = new Path(rd.getURI().toPlatformString(true));
		if (project.getFullPath().isPrefixOf(resPath)) {
			return true;
		}

		return false;
	}

	public static Stream<IResourceDescription> calculateVisibleResourceDescriptions(final IProject project) {
		final ResourceSet liveResourceSet = ProjectUtil.getLiveResourceSet(project);

		final Injector injector = Objects.requireNonNull(
				Aadl2Activator.getInstance().getInjector(Aadl2Activator.ORG_OSATE_XTEXT_AADL2_AADL2),
				"Unable to retrieve injector");
		final ResourceDescriptionsProvider resourceDescProvider = Objects.requireNonNull(
				injector.getInstance(ResourceDescriptionsProvider.class),
				"Unable to get resource descriptions provider");
		final IResourceDescriptions resDescriptions = Objects.requireNonNull(
				resourceDescProvider.getResourceDescriptions(liveResourceSet), "Unable to get resource descriptions");
		final Optional<IResourceDescription> maybeResourceDescription = Streams
				.stream(resDescriptions.getAllResourceDescriptions()).filter(rd -> isInProject(rd, project)).findAny();
		if (!maybeResourceDescription.isPresent()) {
			return Stream.empty();
		}

		final IContainer.Manager containerManager = Objects
				.requireNonNull(injector.getInstance(IContainer.Manager.class), "Unable to get container manager");
		return containerManager.getVisibleContainers(maybeResourceDescription.get(), resDescriptions).stream()
				.flatMap(container -> Streams.stream(container.getResourceDescriptions()));
	}

	public static Set<IResourceDescription> calculateResourceDescriptions(final Set<IProject> projects) {
		final Set<IResourceDescription> resourceDescriptions = new HashSet<IResourceDescription>();
		Injector injector = IResourceServiceProvider.Registry.INSTANCE
				.getResourceServiceProvider(URI.createFileURI("dummy.aadl")).get(Injector.class);
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

	/**
	 * Returns the EObject of the specified type which are contained in the specified project
	 */
	public static Collection<IEObjectDescription> getContainedEObjectsByType(final IProject project,
			final EClass type) {
		return calculateResourceDescriptions(Collections.singleton(project)).stream()
				.flatMap(rd -> StreamSupport.stream(rd.getExportedObjectsByType(type).spliterator(), false))
				.collect(Collectors.toList());
	}
}
