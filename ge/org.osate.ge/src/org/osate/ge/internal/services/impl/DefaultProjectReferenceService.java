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

import java.util.Objects;
import java.util.Optional;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.Platform;
import org.osate.ge.CanonicalBusinessObjectReference;
import org.osate.ge.RelativeBusinessObjectReference;
import org.osate.ge.internal.services.ProjectReferenceService;
import org.osate.ge.internal.services.ReferenceLabelService;
import org.osate.ge.referencehandling.CreateReferenceResolverFactoryContext;
import org.osate.ge.referencehandling.ReferenceResolver;
import org.osate.ge.referencehandling.ResolveContext;
import org.osate.ge.referencehandling.internal.ReferenceResolverRegistry;
import org.osate.ge.services.ReferenceBuilderService;

import com.google.common.collect.ImmutableList;

public class DefaultProjectReferenceService implements ProjectReferenceService, AutoCloseable {
	private static class CleanupRunnable implements Runnable {
		private final ImmutableList<ReferenceResolver> referenceResolvers;
		private boolean cleanedUp = false;

		public CleanupRunnable(final ImmutableList<ReferenceResolver> referenceResolvers) {
			this.referenceResolvers = Objects.requireNonNull(referenceResolvers,
					"referenceResolvers must not be null");
		}

		@Override
		public void run() {
			if (!cleanedUp) {
				this.referenceResolvers.forEach(ReferenceResolver::close);
				cleanedUp = true;
			}
		}
	}

	private final ReferenceBuilderService referenceBuilder;
	private final ReferenceLabelService referenceLabelService;
	private final ImmutableList<ReferenceResolver> referenceResolvers;
	private final CleanupRunnable cleanup;

	public DefaultProjectReferenceService(final ReferenceBuilderService referenceBuilder,
			final ReferenceLabelService referenceLabelService,
			final IProject project) {
		this.referenceBuilder = Objects.requireNonNull(referenceBuilder, "referenceBuilder must not be null");
		this.referenceLabelService = Objects.requireNonNull(referenceLabelService,
				"referenceLabelService must not be null");

		// Initialize
		final CreateReferenceResolverFactoryContext ctx = new CreateReferenceResolverFactoryContext(
				Objects.requireNonNull(project, "project must not be null"));
		final ReferenceResolverRegistry registry = new ReferenceResolverRegistry(Platform.getExtensionRegistry());
		this.referenceResolvers = registry.getFactories().stream()
				.map(f -> Objects.requireNonNull(f.create(ctx),
						"Reference resolver factory returned null resolver. Factory:'" + f.getClass()
						+ "'"))
				.collect(ImmutableList.toImmutableList());

		// Initialize closer
		this.cleanup = new CleanupRunnable(this.referenceResolvers);
	}

	@Override
	public void close() {
		this.cleanup.run();
	}

	/**
	 * Returns a runnable which can be used to cleanup the service. The returned runnable will not prevent the service from being garbage collected. It is intended
	 * to allow cleaning up reference resolvers after the project reference service is no longer referenced. It should only be called when the project reference
	 * service is no longer in use.
	 * @return a runnable that will cleanup objects used by the service.
	 */
	public Runnable getCleanupRunnable() {
		return cleanup;
	}

	@Override
	public Object resolve(final CanonicalBusinessObjectReference reference) {
		final ResolveContext ctx = new ResolveContext(reference, this);
		for (final ReferenceResolver resolver : referenceResolvers) {
			final Optional<Object> referencedObject = resolver.resolve(ctx);
			if (referencedObject.isPresent()) {
				return referencedObject.get();
			}
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

	@Override
	public String getLabel(final CanonicalBusinessObjectReference ref) {
		return referenceLabelService.getLabel(ref);
	}

	@Override
	public String getLabel(final RelativeBusinessObjectReference ref) {
		return referenceLabelService.getLabel(ref);
	}

}
