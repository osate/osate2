package org.osate.ge.diagrams.common.features;

import java.util.Objects;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.osate.aadl2.Element;
import org.osate.ge.ext.Categorized;
import org.osate.ge.ext.ExtensionPaletteEntry;
import org.osate.ge.ext.Names;
import org.osate.ge.ext.annotations.CanCreate;
import org.osate.ge.ext.annotations.CreateBusinessObject;
import org.osate.ge.ext.annotations.GetCreateOwningBusinessObject;
import org.osate.ge.services.AadlModificationService;
import org.osate.ge.services.BusinessObjectResolutionService;
import org.osate.ge.services.DiagramModificationService;
import org.osate.ge.services.ExtensionService;
import org.osate.ge.services.AadlModificationService.AbstractModifier;

// ICreateFeature implementation that delegates behavior to a pictogram handler
public class PictogramHandlerCreateFeature extends AbstractCreateFeature implements Categorized {
	private final BusinessObjectResolutionService bor;
	private final ExtensionService extService;
	private final AadlModificationService aadlModService;
	private final DiagramModificationService diagramModService;
	private final ExtensionPaletteEntry paletteEntry;
	private final Object handler;
	
	public PictogramHandlerCreateFeature(final BusinessObjectResolutionService bor, final ExtensionService extService, final AadlModificationService aadlModService, 
			final DiagramModificationService diagramModService, final IFeatureProvider fp, final ExtensionPaletteEntry paletteEntry, final Object pictogramHandler) {
		super(fp, paletteEntry.getLabel(), "");
		this.bor = Objects.requireNonNull(bor, "bor must not be null");
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
	public boolean canCreate(final ICreateContext context) {
		final IEclipseContext eclipseCtx = extService.createChildContext();
		try {
			eclipseCtx.set(Names.PALETTE_ENTRY_CONTEXT, paletteEntry.getContext());
			eclipseCtx.set(Names.CONTAINER, context.getTargetContainer());
			return (boolean)ContextInjectionFactory.invoke(handler, CanCreate.class, eclipseCtx);
		} finally {
			eclipseCtx.dispose();
		}
	}
	
	@Override
	public Object[] create(final ICreateContext context) {		
		final Object ownerBo = getOwnerBo(context.getTargetContainer());
		if(ownerBo == null) {
			return EMPTY;
		}
		
		// TODO: Support non elements
		if(!(ownerBo instanceof Element)) {
			return EMPTY;
		}
		
		// TODO: Remove references to "Element"
		aadlModService.modify((Element)ownerBo, new AbstractModifier<Element, Object>() {
			@Override
			public Object modify(Resource resource, Element ownerBo) {
				// TODO: Adjust... Include container business object in context
				final IEclipseContext eclipseCtx = extService.createChildContext();
				try {
					eclipseCtx.set(Names.PALETTE_ENTRY_CONTEXT, paletteEntry.getContext());
					eclipseCtx.set(Names.OWNER_BO, ownerBo);
					final Object newBo = ContextInjectionFactory.invoke(handler, CreateBusinessObject.class, eclipseCtx);
					// TODO: Verify that BO array is supposed to be returned
					return newBo == null ? EMPTY : new Object[] { newBo };
				} finally {
					eclipseCtx.dispose();
				}
			}
			
		});
		
		// TODO: Return appropriate value
		
		return EMPTY;
	}
	
	private Object getOwnerBo(final PictogramElement container) {
		final IEclipseContext eclipseCtx = extService.createChildContext();
		try {
			eclipseCtx.set(Names.PALETTE_ENTRY_CONTEXT, paletteEntry.getContext());
			eclipseCtx.set(Names.CONTAINER, container);
			final Object ownerBo = ContextInjectionFactory.invoke(handler, GetCreateOwningBusinessObject.class, eclipseCtx, null);
			if(ownerBo != null) {
				return ownerBo;
			}
		} finally {
			eclipseCtx.dispose();
		}
		
		return bor.getBusinessObjectForPictogramElement(container);
	}
}
