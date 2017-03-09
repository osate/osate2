package org.osate.ge.internal.graphiti.diagram;

import java.util.Iterator;
import java.util.Objects;
import java.util.stream.Stream;

import org.eclipse.core.resources.IProject;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.impl.AddContext;
import org.eclipse.graphiti.features.context.impl.UpdateContext;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.osate.aadl2.Element;
import org.osate.ge.di.GetChildren;
import org.osate.ge.di.GetGraphic;
import org.osate.ge.di.Names;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.internal.AadlElementWrapper;
import org.osate.ge.internal.businessObjectHandlers.BusinessObjectHandlerProvider;
import org.osate.ge.internal.di.InternalNames;
import org.osate.ge.internal.diagram.DiagramConfiguration;
import org.osate.ge.internal.diagram.DiagramUpdater;
import org.osate.ge.internal.diagram.DiagramUpdater.BusinessObjectTreeFactory;
import org.osate.ge.internal.graphics.AgeConnection;
import org.osate.ge.internal.graphics.AgeShape;
import org.osate.ge.internal.graphiti.PictogramElementProxy;
import org.osate.ge.internal.graphiti.features.AgeAddConnectionContext;
import org.osate.ge.internal.services.ExtensionService;
import org.osate.ge.internal.ui.util.SelectionHelper;

// TODO: Rename?
public class GraphitiAgeDiagramUpdater {
	private final DiagramUpdater diagramUpdater; 
	private final BusinessObjectHandlerProvider boHandlerProvider;
	private final ExtensionService extService;
	
	// TODO: Replace extservice with something more specific
	public GraphitiAgeDiagramUpdater(final BusinessObjectTreeFactory boTreeFactory,
			final BusinessObjectHandlerProvider boHandlerProvider, 
			final ExtensionService extService) {
		this.diagramUpdater = new DiagramUpdater(boTreeFactory, null); // TODO: Register listener
		this.boHandlerProvider = Objects.requireNonNull(boHandlerProvider, "boHandlerProvider must not be null");
		this.extService = Objects.requireNonNull(extService, "extService must not be null");
	}

	public void updateDiagram(final GraphitiAgeDiagram diagram) {
		// Required
		// Update diagram. See DiagramUpdater
		
		// Ghost elements and their descendants that are no longer used
		// Create/Update pictogram elements as appropriate
	}
	/*
		Objects.requireNonNull(project, "project must not be null");
		
		final PictogramElementProxy parentDiagramElementProxy = new PictogramElementProxy(null);
		final PictogramElementProxy diagramElementProxy = new PictogramElementProxy(null);
		
		final IEclipseContext eclipseCtx = extService.createChildContext();
		try {
			// TODO
			eclipseCtx.set(InternalNames.PARENT_DIAGRAM_ELEMENT_PROXY, parentDiagramElementProxy);		
			eclipseCtx.set(InternalNames.DIAGRAM_ELEMENT_PROXY, diagramElementProxy);
			eclipseCtx.set(InternalNames.PROJECT, project);

			// TODO: will need to pass in children..
			createDiagramElement(eclipseCtx, parentDiagramElementProxy, diagramElementProxy, diagram, null, rootBo);
		} finally {
			eclipseCtx.dispose();
		}
		
		// TODO. Create by calling @GetChildren. Later will use passed in diagram configuraiton.
		return null;
	}
	
	private DiagramElement<PictogramElement> createDiagramElement(final IEclipseContext eclipseCtx,
			final PictogramElementProxy parentPictogramProxy,
			final PictogramElementProxy pictogramProxy,
			final Diagram diagram, 
			final DiagramElement<PictogramElement> parent,
			final Object bo) {
		
		// Get the business object
		final Object boHandler = boHandlerProvider.getApplicableBusinessObjectHandler(bo);
		if(boHandler == null) {
			return null;
		}		
		
		// Update the context
		eclipseCtx.set(Names.BUSINESS_OBJECT, bo);
		pictogramProxy.setPictogramElement(null); // Should not be used for GetChildren
		
		// Update/Create stub graphic		
		final PictogramElement pictogramElement;
		final Graphic gr = Objects.requireNonNull((Graphic)ContextInjectionFactory.invoke(boHandler, GetGraphic.class, eclipseCtx), "Result of invoking @GetGraphic method must not be null. " + boHandler.getClass().getName());
		if(gr instanceof AgeShape) {
			final AgeShape ageShape = (AgeShape)gr;
		} else if(gr instanceof AgeConnection) {
			final AgeConnection ageConnection = (AgeConnection)gr;
		} else {
			throw new RuntimeException("Unsupported graphic: " + gr);
		}
		
		// TODO: Create/Update the shape as appropriate.. Move from BoHandlerRefreshHelper?
		pictogramElement = null; // TODO: Remove
		
		// NOTE: Can't do this based on graphiti diagram? Need to do it based on previous diagram element tree?
			// Otherwise we get back to the relative path issue.
			// Need to handle ghosting if this uses this tree and not diagram? Want to ensure that things work as expected?
		
			// Ideally.. Look through graphiti diagram.. However.. Need to get current connetions.
			// This impacts how connection cache is done?
		
		// TODO: Should this be createUpdateDiagramElemenTree.
		// How does this fit in with the refresh. Refresh should use this tree? Second phase... Don't even use graphiti features?
		// TODO: How to handle not destroying shapes if bo handler no longer exists. No pictogram element but want to maintain any parameters.
		
		// Overview
		// - Try to get existing. Allow ghosted? Think so
		// - Create if it doesn't exist
		// - Delete if it doesn't
		

		
		// TODO: Where should elements be ghosted at. Here or later? 
		// TODO: What about: connectionService.onConnectionCreated(owner, bo, connection); That will need to be updated too..
		
		System.err.println("TEST: " + getClass().getName());
		
		// Update Proxies for Getting Children
		pictogramProxy.setPictogramElement(pictogramElement);
		
		// TODO: Create the diagram element
		final DiagramElement<PictogramElement> newDiagramElement = new DiagramElement<PictogramElement>(parent, bo, pictogramElement);
		
		// Create children
		final Stream<?> childBos = (Stream<?>)ContextInjectionFactory.invoke(boHandler, GetChildren.class, eclipseCtx, null);
		if(childBos != null) {
			final Iterator<?> childIt = childBos.iterator();
			while(childIt.hasNext()) {
				final Object childBo = childIt.next();
				
				// Update the parent pictogram proxy
				parentPictogramProxy.setPictogramElement(parent == null ? null : parent.getInternalObject());
				
				// Create child
				final DiagramElement<PictogramElement> childDiagramElement = createDiagramElement(eclipseCtx, parentPictogramProxy, pictogramProxy, diagram, newDiagramElement, childBo);
				newDiagramElement.addChild(childDiagramElement);
			}
		}
		
		// Return the new diagram element
		return newDiagramElement;
	}
	*/
}
