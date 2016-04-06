package org.osate.ge.internal.features;

import java.util.Objects;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
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
import org.osate.ge.di.CreateConnectionBusinessObject;
import org.osate.ge.di.Names;
import org.osate.ge.internal.services.AadlModificationService;
import org.osate.ge.internal.services.DiagramModificationService;
import org.osate.ge.internal.services.ExtensionService;

// ICreateConnectionFeature implementation that delegates behavior to a pictogram handler
public class PictogramHandlerCreateConnectionFeature extends AbstractCreateConnectionFeature implements Categorized, ICustomUndoRedoFeature {
	private final ExtensionService extService;
	private final AadlModificationService aadlModService;
	private final DiagramModificationService diagramModService;
	private final SimplePaletteEntry paletteEntry;
	private final Object handler;
	
	public PictogramHandlerCreateConnectionFeature(final ExtensionService extService, final AadlModificationService aadlModService, final DiagramModificationService diagramModService, final IFeatureProvider fp, final SimplePaletteEntry paletteEntry, final Object pictogramHandler) {
		super(fp, paletteEntry.getLabel(), "");
		this.extService = Objects.requireNonNull(extService, "extService must not be null");
		this.aadlModService = Objects.requireNonNull(aadlModService, "aadlModService must not be null");
		this.diagramModService = Objects.requireNonNull(diagramModService, "diagramModService must not be null");
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
		final IEclipseContext eclipseCtx = createEclipseContext(context);
		try {
			return (boolean)ContextInjectionFactory.invoke(handler, CanStartConnection.class, eclipseCtx);
		} finally {
			eclipseCtx.dispose();
		}
	}
	
	@Override
	public boolean canCreate(final ICreateConnectionContext context) {
		final IEclipseContext eclipseCtx = createEclipseContext(context);
		try {
			return (boolean)ContextInjectionFactory.invoke(handler, CanCreateConnection.class, eclipseCtx);
		} finally {
			eclipseCtx.dispose();
		}
	}

	@Override
	public Connection create(final ICreateConnectionContext context) {
		final IEclipseContext eclipseCtx = createEclipseContext(context);
		try {
			return (Connection)ContextInjectionFactory.invoke(handler, CreateConnectionBusinessObject.class, eclipseCtx);
		} finally {
			eclipseCtx.dispose();
		}
	}
	
	private final IEclipseContext createEclipseContext(final ICreateConnectionContext createCtx) {
		final IEclipseContext eclipseCtx = extService.createChildContext();
		try {
			// TODO: Replace with something else
			//eclipseCtx.set(Names.SOURCE_PICTOGRAM_ELEMENT, createCtx.getSourcePictogramElement());
			//eclipseCtx.set(Names.TARGET_PICTOGRAM_ELEMENT, createCtx.getTargetPictogramElement());
			eclipseCtx.set(Names.PALETTE_ENTRY_CONTEXT, paletteEntry.getContext());
			return eclipseCtx;
		} catch(Exception ex) {
			eclipseCtx.dispose();
			throw ex;
		}		
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
