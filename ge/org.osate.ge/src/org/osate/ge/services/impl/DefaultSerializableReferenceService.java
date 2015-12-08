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
import org.eclipse.gef.EditPart;
import org.osate.aadl2.Element;
import org.osate.ge.diagrams.common.AadlElementWrapper;
import org.osate.ge.ext.Names;
import org.osate.ge.ext.annotations.GetReference;
import org.osate.ge.ext.annotations.GetReferencedObject;
import org.osate.ge.services.ExtensionService;
import org.osate.ge.services.SerializableReferenceService;

public class DefaultSerializableReferenceService implements SerializableReferenceService {
	private static final String REFERENCE_HANDLERS_EXTENSION_POINT_ID = "org.osate.ge.referenceHandlers";
	private static final String REFERENCE_HANDLER_ELEMENT_NAME = "referenceHandler";
	private final IEclipseContext ctx;
	private final IEclipseContext argCtx = EclipseContextFactory.create(); // Used for method arguments
	private List<Object> referenceHandlers = null;

	public DefaultSerializableReferenceService(final ExtensionService extService) {
		ctx = extService.createChildContext();
	}
	
	public void dispose() {
		// Disposing of the context will dispose of reference handlers
		ctx.dispose();
	}
	
	/**
	 * Lazy instantiate reference handlers. Ensures that all services are available.
	 */
	private void ensureReferenceHandlersHaveBeenInstantiated() {
		if(referenceHandlers == null) {
			// Instantiate reference handlers
			referenceHandlers = new ArrayList<>();
			final IExtensionRegistry registry = Platform.getExtensionRegistry();	
			final IExtensionPoint point = Objects.requireNonNull(registry.getExtensionPoint(REFERENCE_HANDLERS_EXTENSION_POINT_ID), "unable to retrieve reference handlers extension point");
			for(final IExtension extension : point.getExtensions()) {
				for(final IConfigurationElement ce : extension.getConfigurationElements()) {
					if(ce.getName().equals(REFERENCE_HANDLER_ELEMENT_NAME)) {
						try {
							final String className = ce.getAttribute("class");
							final Class<?> handlerClass = Platform.getBundle(ce.getContributor().getName()).loadClass(className);
							referenceHandlers.add(ContextInjectionFactory.make(handlerClass, ctx));
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
		ensureReferenceHandlersHaveBeenInstantiated();
		
		// Ignore EditPart objects
		if(bo instanceof EditPart) {
			return null;
		}
		
		try {
			// Set context fields
			argCtx.set(Names.BUSINESS_OBJECT, bo);
			for(final Object refHandler : referenceHandlers) {
				final String ref = (String)ContextInjectionFactory.invoke(refHandler, GetReference.class, ctx, argCtx, null);
				
				if(ref != null) {
					return ref;
				}
			}
		} finally {
			// Remove entries from context
			argCtx.remove(Names.BUSINESS_OBJECT);
		}
		
		return null;
	}
		
	@Override
	public Object getReferencedObject(final String reference) {
		Objects.requireNonNull(reference, "reference must not be null");
		ensureReferenceHandlersHaveBeenInstantiated();
		
		// Break the reference into segments
		final String[] refSegs = reference.split(" ");
		if(refSegs.length < 2) {
			return null;
		}
			
		try {
			// Set context fields
			argCtx.set(Names.REFERENCE, reference);
			argCtx.set(Names.REFERENCE_SEGMENTS, refSegs);			
			
			for(final Object refHandler : referenceHandlers) {
				final Object referencedObject = ContextInjectionFactory.invoke(refHandler, GetReferencedObject.class, ctx, argCtx, null);
				if(referencedObject != null) {
					return referencedObject instanceof Element ?  new AadlElementWrapper((Element)referencedObject) : null;
				}
			}
		} finally {
			argCtx.remove(Names.REFERENCE);
			argCtx.remove(Names.REFERENCE_SEGMENTS);
		}
		
		return null;
	}
}
