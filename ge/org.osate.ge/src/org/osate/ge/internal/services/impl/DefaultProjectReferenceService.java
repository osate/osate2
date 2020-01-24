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
package org.osate.ge.internal.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.osate.ge.di.Names;
import org.osate.ge.di.ResolveCanonicalReference;
import org.osate.ge.internal.diagram.runtime.CanonicalBusinessObjectReference;
import org.osate.ge.internal.diagram.runtime.RelativeBusinessObjectReference;
import org.osate.ge.internal.services.ProjectProvider;
import org.osate.ge.internal.services.ProjectReferenceService;
import org.osate.ge.internal.services.ReferenceLabelService;
import org.osate.ge.services.ReferenceBuilderService;
import org.osate.ge.services.ReferenceResolutionService;

public class DefaultProjectReferenceService implements ProjectReferenceService {
	private static final String REFERENCE_RESOLVER_ELEMENT_NAME = "referenceResolver";
	private final ReferenceBuilderService referenceBuilder;
	private final ReferenceLabelService referenceLabelService;
	private final IEclipseContext ctx;
	private List<Object> referenceResolvers = null;
	private DeclarativeReferenceResolver declarativeReferenceResolver;

	// Use a static class to avoid keeping references to the project reference service
	private static class SimpleProjectProvider implements ProjectProvider {
		private final IProject project;

		public SimpleProjectProvider(final IProject project) {
			this.project = project;
		}

		@Override
		public IProject getProject() {
			return project;
		}
	}

	/**
	 *
	 * @param referenceBuilder
	 * @param project
	 * @param ctx an Eclipse context which will be used to create extensions and invoke extension methods. Passed in to allow it to be disposed by the owner of the project reference service
	 */
	public DefaultProjectReferenceService(final ReferenceBuilderService referenceBuilder,
			final ReferenceLabelService referenceLabelService,
			final IProject project,
			final IEclipseContext ctx) {
		this.referenceBuilder = Objects.requireNonNull(referenceBuilder, "referenceBuilder must not be null");
		this.referenceLabelService = Objects.requireNonNull(referenceLabelService,
				"referenceLabelService must not be null");
		this.ctx = Objects.requireNonNull(ctx, "ctx must not be null");
		ctx.set(ProjectProvider.class, new SimpleProjectProvider(project));
	}

	/**
	 * Lazy instantiate reference resolvers. Ensures that all services are available.
	 */
	private void ensureReferenceResolversHaveBeenInstantiated() {
		if(referenceResolvers == null) {
			// Instantiate reference resolvers
			referenceResolvers = new ArrayList<>();

			// Create the declarative reference handler. It is not registered with plugin.xml because an explicit reference to it is needed
			this.declarativeReferenceResolver = ContextInjectionFactory.make(DeclarativeReferenceResolver.class, ctx);
			referenceResolvers.add(declarativeReferenceResolver);

			// Instantiate other reference handlers

			final IExtensionRegistry registry = Platform.getExtensionRegistry();
			final IExtensionPoint point = Objects.requireNonNull(registry.getExtensionPoint(DefaultReferenceService.REFERENCES_EXTENSION_POINT_ID), "unable to retrieve references extension point");
			for(final IExtension extension : point.getExtensions()) {
				for(final IConfigurationElement ce : extension.getConfigurationElements()) {
					if(ce.getName().equals(REFERENCE_RESOLVER_ELEMENT_NAME)) {
						try {
							final String className = ce.getAttribute("class");
							final Class<?> resolverClass = Platform.getBundle(ce.getContributor().getName()).loadClass(className);
							referenceResolvers.add(ContextInjectionFactory.make(resolverClass, ctx));
						} catch(final ClassNotFoundException ex) {
							throw new RuntimeException(ex);
						}
					}
				}
			}
		}
	}

	@Override
	public Object resolve(final CanonicalBusinessObjectReference reference) {
		ensureReferenceResolversHaveBeenInstantiated();

		final IEclipseContext argCtx = EclipseContextFactory.create(); // Used for method arguments
		try {
			// Set context fields
			argCtx.set(ReferenceResolutionService.class, this);
			argCtx.set(Names.REFERENCE, reference.toSegmentArray());

			for(final Object refResolver : referenceResolvers) {
				final Object referencedObject = ContextInjectionFactory.invoke(refResolver, ResolveCanonicalReference.class, ctx, argCtx, null);
				if(referencedObject != null) {
					return referencedObject;
				}
			}
		} finally {
			argCtx.dispose();
		}

		return null;
	}

	@Override
	public CanonicalBusinessObjectReference getCanonicalReference(final Object bo) {
		return referenceBuilder.getCanonicalReference(bo);
	}

	@Override
	public RelativeBusinessObjectReference getRelativeReference(Object bo) {
		return referenceBuilder.getRelativeReference(bo);
	}

	// Must be called when the model changes to invalidate caches.
	void onModelChanged() {
		if(declarativeReferenceResolver != null) {
			// Notify the declarative reference resolvers of the model change.
			// If other resolvers need to receive the notification, an API should be created for it.
			declarativeReferenceResolver.invalidateCache();
		}
	}

	@Override
	public String getLabel(final CanonicalBusinessObjectReference ref, final IProject project) {
		return referenceLabelService.getLabel(ref, project);
	}

	@Override
	public String getLabel(final RelativeBusinessObjectReference ref) {
		return referenceLabelService.getLabel(ref);
	}
}
