package org.osate.ge.diagrams.common.features;

import java.util.Objects;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.osate.ge.ext.Categorized;
import org.osate.ge.ext.ExtensionPaletteEntry;
import org.osate.ge.ext.Names;
import org.osate.ge.ext.annotations.CanCreateShape;
import org.osate.ge.ext.annotations.CreateShape;
import org.osate.ge.services.ExtensionService;

// ICreateFeature implementation that delegates behavior to a pictogram handler
public class PictogramHandlerCreateFeature extends AbstractCreateFeature implements Categorized {
	private final ExtensionService extService;
	private final ExtensionPaletteEntry paletteEntry;
	private final Object handler;
	
	public PictogramHandlerCreateFeature(final ExtensionService extService, final IFeatureProvider fp, final ExtensionPaletteEntry paletteEntry, final Object pictogramHandler) {
		super(fp, paletteEntry.getLabel(), "");
		this.extService = Objects.requireNonNull(extService, "extService must not be null");
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
	public boolean canCreate(final ICreateContext context) {
		final IEclipseContext eclipseCtx = createEclipseContext(context);
		try {
			return (boolean)ContextInjectionFactory.invoke(handler, CanCreateShape.class, eclipseCtx);
		} finally {
			eclipseCtx.dispose();
		}
	}

	@Override
	public Object[] create(final ICreateContext context) {
		final IEclipseContext eclipseCtx = createEclipseContext(context);
		try {
			return (Object[])ContextInjectionFactory.invoke(handler, CreateShape.class, eclipseCtx);
		} finally {
			eclipseCtx.dispose();
		}
	}
	
	private final IEclipseContext createEclipseContext(final ICreateContext createCtx) {
		final IEclipseContext eclipseCtx = extService.createChildContext();
		try {
			eclipseCtx.set(Names.CONTAINER, createCtx.getTargetContainer());
			eclipseCtx.set(Names.PALETTE_ENTRY_CONTEXT, paletteEntry.getContext());
			return eclipseCtx;
		} catch(Exception ex) {
			eclipseCtx.dispose();
			throw ex;
		}		
	}
}
