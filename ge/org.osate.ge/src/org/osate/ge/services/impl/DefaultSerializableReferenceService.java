package org.osate.ge.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.osate.aadl2.Element;
import org.osate.ge.diagrams.common.AadlElementWrapper;
import org.osate.ge.ext.Names;
import org.osate.ge.ext.annotations.ResolveReference;
import org.osate.ge.services.ExtensionService;
import org.osate.ge.services.ReferenceBuilderService;
import org.osate.ge.services.SerializableReferenceService;

public class DefaultSerializableReferenceService implements SerializableReferenceService {
	private static final String REFERENCE_RESOLVER_ELEMENT_NAME = "referenceResolver";
	private final ReferenceBuilderService referenceBuilderService;
	private final IEclipseContext ctx;
	private final IEclipseContext argCtx = EclipseContextFactory.create(); // Used for method arguments
	private List<Object> referenceResolvers = null;

	public DefaultSerializableReferenceService(final ExtensionService extService, final ReferenceBuilderService referenceBuilderService) {
		this.referenceBuilderService = referenceBuilderService;
		ctx = extService.createChildContext();
	}
	
	public void dispose() {
		// Disposing of the context will dispose of reference resolvers
		ctx.dispose();
	}
	
	/**
	 * Lazy instantiate reference resolvers. Ensures that all services are available.
	 */
	private void ensureReferenceResolversHaveBeenInstantiated() {
		if(referenceResolvers == null) {
			// Instantiate reference resolvers
			referenceResolvers = new ArrayList<>();
			final IExtensionRegistry registry = Platform.getExtensionRegistry();	
			final IExtensionPoint point = Objects.requireNonNull(registry.getExtensionPoint(DefaultReferenceBuilderService.REFERENCES_EXTENSION_POINT_ID), "unable to retrieve references extension point");
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
	public String getReference(final Object bo) {
		return referenceBuilderService.getReference(bo);
	}
		
	@Override
	public Object getReferencedObject(final String referenceStr) {
		Objects.requireNonNull(referenceStr, "referenceStr must not be null");
		ensureReferenceResolversHaveBeenInstantiated();
		
		// Break the reference into segments
		final String[] ref = referenceStr.split(" ");
		if(ref.length < 2) {
			return null;
		}
			
		try {
			// Set context fields
			argCtx.set(Names.REFERENCE, ref);	
			
			for(final Object refResolver : referenceResolvers) {
				final Object referencedObject = ContextInjectionFactory.invoke(refResolver, ResolveReference.class, ctx, argCtx, null);
				if(referencedObject != null) {
					return referencedObject instanceof Element ?  new AadlElementWrapper((Element)referencedObject) : referencedObject;
				}
			}
		} finally {
			argCtx.remove(Names.REFERENCE);
		}
		
		return null;
	}
}
