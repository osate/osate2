package org.osate.ge.internal.features;

import java.util.Objects;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.graphiti.features.ICustomUndoRedoFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.features.impl.AbstractCreateConnectionFeature;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.osate.ge.internal.Categorized;
import org.osate.ge.internal.SimplePaletteEntry;
import org.osate.ge.di.CanCreateConnection;
import org.osate.ge.di.CanStartConnection;
import org.osate.ge.di.CreateBusinessObject;
import org.osate.ge.di.GetCreateOwningBusinessObject;
import org.osate.ge.di.Names;
import org.osate.ge.internal.services.AadlModificationService;
import org.osate.ge.internal.services.BusinessObjectResolutionService;
import org.osate.ge.internal.services.ExtensionService;
import org.osate.ge.internal.services.AadlModificationService.AbstractModifier;

// ICreateConnectionFeature implementation that delegates behavior to a pictogram handler
public class PictogramHandlerCreateConnectionFeature extends AbstractCreateConnectionFeature implements Categorized, ICustomUndoRedoFeature {
	private final ExtensionService extService;
	private final AadlModificationService aadlModService;
	private final BusinessObjectResolutionService bor;
	private final SimplePaletteEntry paletteEntry;
	private final Object handler;
	
	public PictogramHandlerCreateConnectionFeature(final ExtensionService extService, final AadlModificationService aadlModService, 
			final BusinessObjectResolutionService bor, final IFeatureProvider fp, 
			final SimplePaletteEntry paletteEntry, final Object pictogramHandler) {
		super(fp, paletteEntry.getLabel(), "");
		this.extService = Objects.requireNonNull(extService, "extService must not be null");
		this.aadlModService = Objects.requireNonNull(aadlModService, "aadlModService must not be null");
		this.bor = Objects.requireNonNull(bor, "bor must not be null");
		this.paletteEntry = Objects.requireNonNull(paletteEntry, "paletteEntry must not be null");
		this.handler = Objects.requireNonNull(pictogramHandler, "pictogramHandler must not be null");
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
			
			eclipseCtx.set(Names.PALETTE_ENTRY_CONTEXT, paletteEntry.getContext());
			eclipseCtx.set(Names.SOURCE_BO, srcBo);
			eclipseCtx.set(Names.DESTINATION_BO, dstBo);
			
			return (boolean)ContextInjectionFactory.invoke(handler, CanCreateConnection.class, eclipseCtx, false);			
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

		final IEclipseContext eclipseCtx = extService.createChildContext();
		try {
			eclipseCtx.set(Names.PALETTE_ENTRY_CONTEXT, paletteEntry.getContext());
			eclipseCtx.set(Names.SOURCE_BO, srcBo);
			eclipseCtx.set(Names.DESTINATION_BO, dstBo);
			
			final EObject ownerBo = (EObject)ContextInjectionFactory.invoke(handler, GetCreateOwningBusinessObject.class, eclipseCtx, null);
			if(ownerBo == null) {
				return null;
			}	
			
			// Modify the model
			aadlModService.modify(ownerBo, new AbstractModifier<EObject, Object>() {
				@Override
				public Object modify(Resource resource, EObject ownerBo) {
					return ContextInjectionFactory.invoke(handler, CreateBusinessObject.class, eclipseCtx, null);					
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
