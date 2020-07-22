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
package org.osate.ge.aadl2.internal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Optional;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.emf.common.util.URI;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.ge.internal.services.SystemInstanceLoadingService;
import org.osate.ge.referencehandling.CreateReferenceResolverFactoryContext;
import org.osate.ge.referencehandling.ReferenceResolver;
import org.osate.ge.referencehandling.ReferenceResolverFactory;
import org.osate.ge.referencehandling.ResolveContext;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

public class InstanceReferenceResolver implements ReferenceResolver {
	public static class Factory implements ReferenceResolverFactory {
		@Override
		public ReferenceResolver create(final CreateReferenceResolverFactoryContext ctx) {
			final Bundle bundle = FrameworkUtil.getBundle(Factory.class);
			final SystemInstanceLoadingService systemInstanceLoader = Objects
					.requireNonNull(
							EclipseContextFactory.getServiceContext(bundle.getBundleContext())
							.get(SystemInstanceLoadingService.class),
							"Unable to get system instance loading service");

			return new InstanceReferenceResolver(ctx.getProject(), systemInstanceLoader);
		}
	}

	private final IProject project;
	private final SystemInstanceLoadingService systemInstanceLoader;
	private final Map<String, SystemInstanceInfo> keyToSystemInstanceInfoMap = new HashMap<String, SystemInstanceInfo>();
	private final IResourceChangeListener resourceChangeListener = new IResourceChangeListener() {
		private IResourceDeltaVisitor deltaVisitor = delta -> {
			final IResource resource = delta.getResource();
			if(resource.getType() == IResource.FILE) {
				// Check if the file matches the resource of one of the system instances
				synchronized(keyToSystemInstanceInfoMap) {
					final URI changedUri = URI.createPlatformResourceURI(delta.getResource().getFullPath().toString(), true);
					String systemInstanceKey = null;
					for(final Entry<String, SystemInstanceInfo> mapEntry : keyToSystemInstanceInfoMap.entrySet()) {
						if(changedUri.equals(mapEntry.getValue().systemInstance.eResource().getURI())) {
							systemInstanceKey = mapEntry.getKey();
							break;
						}
					}

					// Remove the entry from the map
					if(systemInstanceKey != null) {
						keyToSystemInstanceInfoMap.remove(systemInstanceKey);
						return false;
					}
				}
			}

			return true;
		};

		@Override
		public void resourceChanged(final IResourceChangeEvent event) {
			if(event.getType() == IResourceChangeEvent.POST_CHANGE) {
				final IResourceDelta delta = event.getDelta();

				try {
					// Process the resource delta
					delta.accept(deltaVisitor);
				} catch (final CoreException e) {
					throw new RuntimeException(e);
				}
			}
		}
	};

	/**
	 * Stores mappings for elements inside of a system instance
	 *
	 */
	private class SystemInstanceInfo {
		public final SystemInstance systemInstance;

		public SystemInstanceInfo(final SystemInstance systemInstance) {
			this.systemInstance = systemInstance;
		}
	}

	public InstanceReferenceResolver(
			final IProject project,
			final SystemInstanceLoadingService systemInstanceLoader) {
		this.project = Objects.requireNonNull(project, "project must not be null");
		this.systemInstanceLoader = Objects.requireNonNull(systemInstanceLoader, "systemInstanceLoader must not be null");

		ResourcesPlugin.getWorkspace().addResourceChangeListener(resourceChangeListener);
	}

	@Override
	public void close() {
		// Remove the resource listener
		ResourcesPlugin.getWorkspace().removeResourceChangeListener(resourceChangeListener);

		// Clear the map
		synchronized(keyToSystemInstanceInfoMap) {
			keyToSystemInstanceInfoMap.clear();
		}
	}

	@Override
	public Optional<Object> resolve(final ResolveContext ctx) {
		final List<String> refSegs = ctx.getReference().getSegments();
		if (refSegs.size() < 3) {
			return Optional.empty();
		}

		if (!AadlReferenceUtil.INSTANCE_ID.equals(refSegs.get(0))) {
			return Optional.empty();
		}

		final String type = refSegs.get(1);
		final String systemInstanceKey = refSegs.get(2);
		final SystemInstanceInfo siInfo = getSystemInstanceInfo(systemInstanceKey);
		if(siInfo != null) {
			if (type.equals(AadlReferenceUtil.SYSTEM_INSTANCE_KEY)) {
				return Optional.of(siInfo.systemInstance);
			}
		}

		return Optional.empty();
	}

	private SystemInstanceInfo getSystemInstanceInfo(final String key) {
		synchronized(keyToSystemInstanceInfoMap) {
			SystemInstanceInfo siInfo = keyToSystemInstanceInfoMap.get(key);

			// If it wasn't loaded previously, load the system instance
			if(siInfo == null) {
				final SystemInstance si = systemInstanceLoader.loadSystemInstance(project, key);
				if(si != null) {
					siInfo = new SystemInstanceInfo(si);

					// Add it the map
					keyToSystemInstanceInfoMap.put(key, siInfo);
				}
			}

			return siInfo;
		}
	}
}
