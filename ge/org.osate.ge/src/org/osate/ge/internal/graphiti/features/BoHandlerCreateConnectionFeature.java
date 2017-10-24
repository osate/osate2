package org.osate.ge.internal.graphiti.features;

import java.util.Objects;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.ICustomUndoRedoFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.features.impl.AbstractCreateConnectionFeature;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.di.CanCreate;
import org.osate.ge.di.CanStartConnection;
import org.osate.ge.di.Create;
import org.osate.ge.di.GetBusinessObjectToModify;
import org.osate.ge.di.GetCreateOwner;
import org.osate.ge.di.Names;
import org.osate.ge.internal.Categorized;
import org.osate.ge.internal.SimplePaletteEntry;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.DiagramNode;
import org.osate.ge.internal.diagram.runtime.RelativeBusinessObjectReference;
import org.osate.ge.internal.diagram.runtime.updating.DiagramUpdater;
import org.osate.ge.internal.graphiti.GraphitiAgeDiagramProvider;
import org.osate.ge.internal.graphiti.diagram.GraphitiAgeDiagram;
import org.osate.ge.internal.services.AadlModificationService;
import org.osate.ge.internal.services.ExtensionService;
import org.osate.ge.services.ReferenceBuilderService;

// ICreateConnectionFeature implementation that delegates behavior to a business object handler
public class BoHandlerCreateConnectionFeature extends AbstractCreateConnectionFeature implements Categorized, ICustomUndoRedoFeature {
	private final GraphitiAgeDiagramProvider graphitiAgeDiagramProvider;
	private final ExtensionService extService;
	private final AadlModificationService aadlModService;
	private final DiagramUpdater diagramUpdater;
	private final ReferenceBuilderService refBuilder;
	private final SimplePaletteEntry paletteEntry;
	private final Object handler;

	public BoHandlerCreateConnectionFeature(final GraphitiAgeDiagramProvider graphitiAgeDiagramProvider,
			final ExtensionService extService,
			final AadlModificationService aadlModService,
			final DiagramUpdater diagramUpdater,
			final ReferenceBuilderService refBuilder,
			final IFeatureProvider fp,
			final SimplePaletteEntry paletteEntry,
			final Object boHandler) {
		super(fp, paletteEntry.getLabel(), "");
		this.graphitiAgeDiagramProvider = Objects.requireNonNull(graphitiAgeDiagramProvider, "graphitiAgeDiagramProvider must not be null");
		this.extService = Objects.requireNonNull(extService, "extService must not be null");
		this.aadlModService = Objects.requireNonNull(aadlModService, "aadlModService must not be null");
		this.diagramUpdater = Objects.requireNonNull(diagramUpdater, "diagramUpdater must not be null");
		this.refBuilder = Objects.requireNonNull(refBuilder, "refBuilder must not be null");
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
			final DiagramElement srcElement = graphitiAgeDiagramProvider.getGraphitiAgeDiagram().getClosestDiagramElement(context.getSourcePictogramElement());
			if(srcElement == null) {
				return false;
			}

			eclipseCtx.set(Names.PALETTE_ENTRY_CONTEXT, paletteEntry.getContext());
			eclipseCtx.set(Names.SOURCE_BO, srcElement.getBusinessObject());
			eclipseCtx.set(Names.SOURCE_BUSINESS_OBJECT_CONTEXT, srcElement);

			return (boolean)ContextInjectionFactory.invoke(handler, CanStartConnection.class, eclipseCtx, false);
		} finally {
			eclipseCtx.dispose();
		}
	}

	@Override
	public boolean canCreate(final ICreateConnectionContext context) {
		final IEclipseContext eclipseCtx = extService.createChildContext();
		try {
			final GraphitiAgeDiagram graphitiAgeDiagram = graphitiAgeDiagramProvider.getGraphitiAgeDiagram();
			final DiagramElement srcElement = graphitiAgeDiagram.getClosestDiagramElement(context.getSourcePictogramElement());
			final DiagramElement dstElement = graphitiAgeDiagram.getClosestDiagramElement(context.getTargetPictogramElement());
			if(srcElement == null || dstElement == null) {
				return false;
			}

			eclipseCtx.set(Names.PALETTE_ENTRY_CONTEXT, paletteEntry.getContext());
			eclipseCtx.set(Names.SOURCE_BO, srcElement.getBusinessObject());
			eclipseCtx.set(Names.SOURCE_BUSINESS_OBJECT_CONTEXT, srcElement);
			eclipseCtx.set(Names.DESTINATION_BO, dstElement.getBusinessObject());
			eclipseCtx.set(Names.DESTINATION_BUSINESS_OBJECT_CONTEXT, dstElement);

			return (boolean)ContextInjectionFactory.invoke(handler, CanCreate.class, eclipseCtx, false);
		} finally {
			eclipseCtx.dispose();
		}
	}

	@Override
	public Connection create(final ICreateConnectionContext context) {
		final GraphitiAgeDiagram graphitiAgeDiagram = graphitiAgeDiagramProvider.getGraphitiAgeDiagram();
		final DiagramElement srcElement = graphitiAgeDiagram.getClosestDiagramElement(context.getSourcePictogramElement());
		final DiagramElement dstElement = graphitiAgeDiagram.getClosestDiagramElement(context.getTargetPictogramElement());
		if(srcElement == null || dstElement == null) {
			return null;
		}

		final IEclipseContext eclipseCtx = extService.createChildContext();
		try {
			eclipseCtx.set(Names.PALETTE_ENTRY_CONTEXT, paletteEntry.getContext());
			eclipseCtx.set(Names.SOURCE_BO, srcElement.getBusinessObject());
			eclipseCtx.set(Names.SOURCE_BUSINESS_OBJECT_CONTEXT, srcElement);
			eclipseCtx.set(Names.DESTINATION_BO, dstElement.getBusinessObject());
			eclipseCtx.set(Names.DESTINATION_BUSINESS_OBJECT_CONTEXT, dstElement);

			final BusinessObjectContext ownerBoc = (BusinessObjectContext)ContextInjectionFactory.invoke(handler, GetCreateOwner.class, eclipseCtx);
			if (!(ownerBoc instanceof DiagramNode)) {
				throw new RuntimeException("Owner must be a diagram node");
			}

			final Object boToModify = ContextInjectionFactory.invoke(handler,
					GetBusinessObjectToModify.class, eclipseCtx, ownerBoc.getBusinessObject());
			if (!(boToModify instanceof EObject)) {
				throw new RuntimeException("Business object being modified must be an EObject");
			}

			final DiagramNode ownerNode = (DiagramNode)ownerBoc;

			// Modify the model
			aadlModService.modify((EObject) boToModify, (resource, ownerBo) -> {
				eclipseCtx.set(Names.MODIFY_BO, ownerBo);
				final Object newBo = ContextInjectionFactory.invoke(handler, Create.class, eclipseCtx, null);
				if(newBo != null) {
					final RelativeBusinessObjectReference newRef = refBuilder.getRelativeReference(newBo);
					if(newRef != null) {
						diagramUpdater.addToNextUpdate(ownerNode, newRef, null);
					}
				}

				return newBo;
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
