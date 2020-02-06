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

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.FlowSpecificationInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.ModeInstance;
import org.osate.aadl2.instance.ModeTransitionInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.ge.di.Names;
import org.osate.ge.di.ResolveCanonicalReference;
import org.osate.ge.internal.services.ProjectProvider;
import org.osate.ge.internal.services.SystemInstanceLoadingService;

public class InstanceReferenceResolver {
	private final ProjectProvider projectProvider;
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
		private final Map<String, InstanceObject> idToElementMap = new HashMap<String, InstanceObject>();

		public SystemInstanceInfo(final SystemInstance systemInstance) {
			this.systemInstance = systemInstance;

			// Add component instances
			for(final ComponentInstance ci : systemInstance.getAllComponentInstances()) {
				idToElementMap.put(ci.getInstanceObjectPath().toLowerCase(), ci);

				for(final FeatureInstance featureInstance : ci.getFeatureInstances()) {
					addFeatureInstance(featureInstance);
				}
			}

			for(final ConnectionInstance ci : systemInstance.getAllConnectionInstances()) {
				for(final ConnectionReference cr : ci.getConnectionReferences()) {
					idToElementMap.put(InstanceReferenceBuilder.buildConnectionReferenceId(cr), cr);
				}
			}

			for(final FlowSpecificationInstance fsi : systemInstance.getFlowSpecifications()) {
				idToElementMap.put(fsi.getInstanceObjectPath().toLowerCase(), fsi);
			}

			for (final ModeInstance mi : systemInstance.getModeInstances()) {
				idToElementMap.put(mi.getInstanceObjectPath().toLowerCase(), mi);
			}

			for (final ModeTransitionInstance mti : systemInstance.getModeTransitionInstances()) {
				idToElementMap.put(mti.getInstanceObjectPath().toLowerCase(), mti);
			}
		}

		private void addFeatureInstance(final FeatureInstance fi) {
			idToElementMap.put(fi.getInstanceObjectPath().toLowerCase(), fi);
			for(final FeatureInstance child : fi.getFeatureInstances()) {
				addFeatureInstance(child);
			}
		}

		public InstanceObject getInstanceObject(final String id) {
			return idToElementMap.get(id);
		}
	}

	@Inject
	public InstanceReferenceResolver(final ProjectProvider projectProvider,
			final SystemInstanceLoadingService systemInstanceLoader) {
		this.projectProvider = Objects.requireNonNull(projectProvider, "projectProvider must not be null");
		this.systemInstanceLoader = Objects.requireNonNull(systemInstanceLoader, "systemInstanceLoader must not be null");

		ResourcesPlugin.getWorkspace().addResourceChangeListener(resourceChangeListener);
	}

	@PreDestroy
	public void dispose() {
		// Remove the resource listener
		ResourcesPlugin.getWorkspace().removeResourceChangeListener(resourceChangeListener);

		// Clear the map
		synchronized(keyToSystemInstanceInfoMap) {
			keyToSystemInstanceInfoMap.clear();
		}
	}

	@ResolveCanonicalReference
	public Object getReferencedObject(final @Named(Names.REFERENCE) String[] refSegs) {
		if(refSegs.length < 3) {
			return null;
		}

		if(!InstanceReferenceBuilder.ID.equals(refSegs[0])) {
			return null;
		}

		final String type = refSegs[1];
		final String systemInstanceKey = refSegs[2];
		final SystemInstanceInfo siInfo = getSystemInstanceInfo(systemInstanceKey);
		if(siInfo != null) {
			if(type.equals(InstanceReferenceBuilder.SYSTEM_INSTANCE_KEY)) {
				return siInfo.systemInstance;
			} else if(refSegs.length >= 4) {
				if (type.equals(InstanceReferenceBuilder.COMPONENT_INSTANCE_KEY)
						|| type.equals(InstanceReferenceBuilder.FEATURE_INSTANCE_KEY)
						|| type.equals(InstanceReferenceBuilder.CONNECTION_REFERENCE_KEY)
						|| type.equals(InstanceReferenceBuilder.FLOW_SPECIFICATION_INSTANCE_KEY)
						|| type.equals(InstanceReferenceBuilder.MODE_INSTANCE_KEY)
						|| type.equals(InstanceReferenceBuilder.MODE_TRANSITION_INSTANCE_KEY)) {
					return siInfo.getInstanceObject(refSegs[3]);
				}
			}
		}

		return null;
	}

	private SystemInstanceInfo getSystemInstanceInfo(final String key) {
		synchronized(keyToSystemInstanceInfoMap) {
			SystemInstanceInfo siInfo = keyToSystemInstanceInfoMap.get(key);

			// If it wasn't loaded previously, load the system instance
			if(siInfo == null) {
				final IProject project = projectProvider.getProject();
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
