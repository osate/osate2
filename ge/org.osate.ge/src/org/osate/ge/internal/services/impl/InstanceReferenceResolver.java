/*
Copyright (c) 2015, Rockwell Collins.
Developed with the sponsorship of Defense Advanced Research Projects Agency (DARPA).

Permission is hereby granted, free of charge, to any person obtaining a copy of this data, 
including any software or models in source or binary form, as well as any drawings, specifications, 
and documentation (collectively "the Data"), to deal in the Data without restriction, including
without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, 
and/or sell copies of the Data, and to permit persons to whom the Data is furnished to do so, 
subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or 
substantial portions of the Data.

THE DATA IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT 
LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. 
IN NO EVENT SHALL THE AUTHORS, SPONSORS, DEVELOPERS, CONTRIBUTORS, OR COPYRIGHT HOLDERS BE LIABLE 
FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, 
ARISING FROM, OUT OF OR IN CONNECTION WITH THE DATA OR THE USE OR OTHER DEALINGS IN THE DATA.
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
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.ge.di.Names;
import org.osate.ge.di.ResolveReference;
import org.osate.ge.internal.services.CachingService;
import org.osate.ge.internal.services.GraphitiService;
import org.osate.ge.internal.services.SystemInstanceLoadingService;

public class InstanceReferenceResolver {
	private final GraphitiService graphitiService;
	private final CachingService cachingService;
	private final SystemInstanceLoadingService systemInstanceLoader;
	private final Map<String, SystemInstanceInfo> keyToSystemInstanceInfoMap = new HashMap<String, SystemInstanceInfo>();
	private final IResourceChangeListener resourceChangeListener = new IResourceChangeListener() {
		private boolean invalidateCache = false;
		
		private IResourceDeltaVisitor deltaVisitor = new IResourceDeltaVisitor() {
			public boolean visit(final IResourceDelta delta) {
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
							invalidateCache = true;
							return false;
						}
					}
				}
								
				return true;
			}
		};

		@Override
		public void resourceChanged(final IResourceChangeEvent event) {
			if(event.getType() == IResourceChangeEvent.POST_CHANGE) {
				final IResourceDelta delta = event.getDelta();
				
				try {
					// Process the resource delta
					delta.accept(deltaVisitor);
					
					// Invalidate the cache
					if(invalidateCache) {
						cachingService.invalidate();
					}
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
	public InstanceReferenceResolver(final GraphitiService graphitiService, final SystemInstanceLoadingService systemInstanceLoader, final CachingService cachingService) {
		this.graphitiService = Objects.requireNonNull(graphitiService, "graphitiService must not be null");
		this.systemInstanceLoader = Objects.requireNonNull(systemInstanceLoader, "systemInstanceLoader must not be null");
		this.cachingService = Objects.requireNonNull(cachingService, "cachingService must not be null");
		
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
	
	@ResolveReference
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
				if(type.equals(InstanceReferenceBuilder.COMPONENT_INSTANCE_KEY) || type.equals(InstanceReferenceBuilder.FEATURE_INSTANCE_KEY) || type.equals(InstanceReferenceBuilder.CONNECTION_REFERENCE_KEY)) {
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
				final IProject project = graphitiService.getProject();
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
