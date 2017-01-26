package org.osate.ge.internal.graphiti.features;

import java.util.Objects;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.ICustomUndoRedoFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.features.impl.AbstractCreateConnectionFeature;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.osate.ge.internal.Categorized;
import org.osate.ge.internal.SimplePaletteEntry;
import org.osate.ge.internal.di.InternalNames;
import org.osate.ge.internal.graphiti.PictogramElementProxy;
import org.osate.ge.di.CanCreate;
import org.osate.ge.di.CanStartConnection;
import org.osate.ge.di.Create;
import org.osate.ge.di.GetCreateOwner;
import org.osate.ge.di.Names;
import org.osate.ge.internal.services.AadlModificationService;
import org.osate.ge.internal.services.BusinessObjectResolutionService;
import org.osate.ge.internal.services.ExtensionService;
import org.osate.ge.internal.services.PropertyService;
import org.osate.ge.internal.services.AadlModificationService.AbstractModifier;

// ICreateConnectionFeature implementation that delegates behavior to a business object handler
public class BoHandlerCreateConnectionFeature extends AbstractCreateConnectionFeature implements Categorized, ICustomUndoRedoFeature {
	private final ExtensionService extService;
	private final AadlModificationService aadlModService;
	private final BusinessObjectResolutionService bor;
	private final PropertyService propertyService;
	private final SimplePaletteEntry paletteEntry;
	private final Object handler;
	
	public BoHandlerCreateConnectionFeature(final ExtensionService extService, final AadlModificationService aadlModService, 
			final BusinessObjectResolutionService bor, final PropertyService propertyService, final IFeatureProvider fp, 
			final SimplePaletteEntry paletteEntry, final Object boHandler) {
		super(fp, paletteEntry.getLabel(), "");
		this.extService = Objects.requireNonNull(extService, "extService must not be null");
		this.aadlModService = Objects.requireNonNull(aadlModService, "aadlModService must not be null");
		this.bor = Objects.requireNonNull(bor, "bor must not be null");
		this.propertyService = Objects.requireNonNull(propertyService, "propertyService must not be null");
		this.paletteEntry = Objects.requireNonNull(paletteEntry, "paletteEntry must not be null");
		this.handler = Objects.requireNonNull(boHandler, "boHandler must not be null");
	}

	@Override
	public String getCategory() {
		return paletteEntry.getCategory();
	}

	@Override
	public String getCreateImageId() {
		return paletteEntry.getImageId();
	}

	@Override
	public boolean canStartConnection(final ICreateConnectionContext context) {
		final IEclipseContext eclipseCtx = extService.createChildContext();
		try {
			final Object srcBo = context.getSourcePictogramElement() == null ? null : bor.getBusinessObjectForPictogramElement(context.getSourcePictogramElement());
			if(srcBo == null) {
				return false;
			}
			
			eclipseCtx.set(Names.PALETTE_ENTRY_CONTEXT, paletteEntry.getContext());
			eclipseCtx.set(Names.SOURCE_BO, srcBo);
			eclipseCtx.set(InternalNames.SOURCE_DIAGRAM_ELEMENT_PROXY, new PictogramElementProxy(AgeFeatureUtil.getLogicalPictogramElement(context.getSourcePictogramElement(), propertyService)));
			
			return (boolean)ContextInjectionFactory.invoke(handler, CanStartConnection.class, eclipseCtx, false);			
		} finally {
			eclipseCtx.dispose();
		}
	}
	
	@Override
	public boolean canCreate(final ICreateConnectionContext context) {
		final IEclipseContext eclipseCtx = extService.createChildContext();
		try {
			final Object srcBo = context.getSourcePictogramElement() == null ? null : bor.getBusinessObjectForPictogramElement(context.getSourcePictogramElement());
			final Object dstBo = context.getTargetPictogramElement() == null ? null : bor.getBusinessObjectForPictogramElement(context.getTargetPictogramElement());		
			if(srcBo == null || dstBo == null) {
				return false;
			}			
			
			// TODO: Determine mechanism to allow usage of source and destination objects which are not EMF Objects. Need to be able to find them in resource which is being modified.
			// Source and destination must both be an EObject
			if(!(srcBo instanceof EObject && dstBo instanceof EObject)) {
				return false;
			}
			
			eclipseCtx.set(Names.PALETTE_ENTRY_CONTEXT, paletteEntry.getContext());
			eclipseCtx.set(Names.SOURCE_BO, srcBo);
			eclipseCtx.set(InternalNames.SOURCE_DIAGRAM_ELEMENT_PROXY, new PictogramElementProxy(AgeFeatureUtil.getLogicalPictogramElement(context.getSourcePictogramElement(), propertyService)));
			eclipseCtx.set(Names.DESTINATION_BO, dstBo);
			eclipseCtx.set(InternalNames.DESTINATION_DIAGRAM_ELEMENT_PROXY, new PictogramElementProxy(AgeFeatureUtil.getLogicalPictogramElement(context.getTargetPictogramElement(), propertyService)));
			
			return (boolean)ContextInjectionFactory.invoke(handler, CanCreate.class, eclipseCtx, false);			
		} finally {
			eclipseCtx.dispose();
		}
	}

	@Override
	public Connection create(final ICreateConnectionContext context) {
		final Object srcBo = context.getSourcePictogramElement() == null ? null : bor.getBusinessObjectForPictogramElement(context.getSourcePictogramElement());
		final Object dstBo = context.getTargetPictogramElement() == null ? null : bor.getBusinessObjectForPictogramElement(context.getTargetPictogramElement());
		if(srcBo == null || dstBo == null) {
			return null;
		}

		// TODO: Support non-EMF Objects
		final URI srcUri = EcoreUtil.getURI((EObject)srcBo);
		final URI dstUri = EcoreUtil.getURI((EObject)dstBo);
		if(srcUri == null || dstUri == null) {
			return null;
		}

		final IEclipseContext eclipseCtx = extService.createChildContext();
		try {
			eclipseCtx.set(Names.PALETTE_ENTRY_CONTEXT, paletteEntry.getContext());
			eclipseCtx.set(Names.SOURCE_BO, srcBo);
			eclipseCtx.set(InternalNames.SOURCE_DIAGRAM_ELEMENT_PROXY, new PictogramElementProxy(AgeFeatureUtil.getLogicalPictogramElement(context.getSourcePictogramElement(), propertyService)));
			eclipseCtx.set(Names.DESTINATION_BO, dstBo);
			eclipseCtx.set(InternalNames.DESTINATION_DIAGRAM_ELEMENT_PROXY, new PictogramElementProxy(AgeFeatureUtil.getLogicalPictogramElement(context.getTargetPictogramElement(), propertyService)));					
			
			final EObject ownerBo = (EObject)ContextInjectionFactory.invoke(handler, GetCreateOwner.class, eclipseCtx);
			if(ownerBo == null) {
				return null;
			}
			
			// Modify the model
			aadlModService.modify(ownerBo, new AbstractModifier<EObject, Object>() {
				@Override
				public Object modify(final Resource resource, final EObject ownerBo) {
					// TODO: Support Non EMF Objects	
					final EObject srcBo = resource.getResourceSet().getEObject(srcUri, true);
					final EObject dstBo = resource.getResourceSet().getEObject(dstUri, true);
					if(ownerBo == null || srcBo == null || dstBo == null) {
						return null;
					}
					
					eclipseCtx.set(Names.OWNER_BO, ownerBo);
					eclipseCtx.set(Names.SOURCE_BO, srcBo);
					eclipseCtx.set(Names.DESTINATION_BO, dstBo);
					
					return ContextInjectionFactory.invoke(handler, Create.class, eclipseCtx, null);					
				}
			});
		} finally {
			eclipseCtx.dispose();
		}
		
		return null;
	}

	// ICustomUndoRedoFeature
	@Override
	public boolean canUndo(final IContext context) {
		return false;
	}
	
	@Override
	public void preUndo(IContext context) {
	}

	@Override
	public void postUndo(IContext context) {
	}

	@Override
	public boolean canRedo(IContext context) {
		return false;
	}

	@Override
	public void preRedo(IContext context) {
	}

	@Override
	public void postRedo(IContext context) {
	}
}
