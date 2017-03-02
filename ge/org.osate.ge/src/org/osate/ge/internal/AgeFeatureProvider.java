// Based on OSATE Graphical Editor. Modifications are: 
/*
Copyright (c) 2016, Rockwell Collins.
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
/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.internal;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IAddBendpointFeature;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IDeleteFeature;
import org.eclipse.graphiti.features.IDirectEditingFeature;
import org.eclipse.graphiti.features.ILayoutFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IMoveBendpointFeature;
import org.eclipse.graphiti.features.IMoveConnectionDecoratorFeature;
import org.eclipse.graphiti.features.IMoveShapeFeature;
import org.eclipse.graphiti.features.IRemoveBendpointFeature;
import org.eclipse.graphiti.features.IRemoveFeature;
import org.eclipse.graphiti.features.IResizeShapeFeature;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.IAddBendpointContext;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.features.context.ILayoutContext;
import org.eclipse.graphiti.features.context.IMoveBendpointContext;
import org.eclipse.graphiti.features.context.IMoveConnectionDecoratorContext;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
import org.eclipse.graphiti.features.context.IRemoveBendpointContext;
import org.eclipse.graphiti.features.context.IRemoveContext;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.features.impl.DefaultAddBendpointFeature;
import org.eclipse.graphiti.features.impl.DefaultMoveBendpointFeature;
import org.eclipse.graphiti.features.impl.DefaultRemoveBendpointFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.ui.features.DefaultFeatureProvider;
import org.osate.aadl2.Element;
import org.osate.aadl2.Generalization;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.ge.internal.graphiti.features.AgeResizeShapeFeature;
import org.osate.ge.internal.graphiti.features.BoHandlerAddFeature;
import org.osate.ge.internal.graphiti.features.BoHandlerCreateConnectionFeature;
import org.osate.ge.internal.graphiti.features.BoHandlerCreateFeature;
import org.osate.ge.internal.graphiti.features.BoHandlerDeleteFeature;
import org.osate.ge.internal.graphiti.features.BoHandlerDirectEditFeature;
import org.osate.ge.internal.graphiti.features.BoHandlerLayoutFeature;
import org.osate.ge.internal.features.LayoutDiagramFeature;
import org.osate.ge.internal.graphiti.features.AgeMoveShapeFeature;
import org.osate.ge.internal.graphiti.features.BoHandlerUpdateFeature;
import org.osate.ge.internal.graphiti.features.CommandCustomFeature;
import org.osate.ge.internal.graphiti.features.SelectAncestorFeature;
import org.osate.ge.internal.model.SubprogramCallOrder;
import org.osate.ge.internal.graphiti.features.BoHandlerRefreshHelper;
import org.osate.ge.EmfContainerProvider;
import org.osate.ge.PaletteEntry;
import org.osate.ge.di.GetPaletteEntries;
import org.osate.ge.di.Names;
import org.osate.ge.internal.services.AadlModificationService;
import org.osate.ge.internal.services.AnchorService;
import org.osate.ge.internal.services.BusinessObjectResolutionService;
import org.osate.ge.internal.services.CachingService;
import org.osate.ge.internal.services.ConnectionCreationService;
import org.osate.ge.internal.services.ConnectionService;
import org.osate.ge.internal.services.DiagramService;
import org.osate.ge.internal.services.ExtensionService;
import org.osate.ge.internal.services.GhostingService;
import org.osate.ge.internal.services.PropertyService;
import org.osate.ge.internal.services.QueryService;
import org.osate.ge.internal.services.LabelService;
import org.osate.ge.internal.services.ShapeCreationService;
import org.osate.ge.internal.services.ShapeService;
import org.osate.ge.internal.services.StyleService;

public class AgeFeatureProvider extends DefaultFeatureProvider {
	private final boolean enableIndependenceProviderCaching = true;
	private IEclipseContext eclipseContext;
	private ConnectionService connectionService;
	private ExtensionService extService;
	private DiagramService diagramService;
	private AadlModificationService aadlModService;
	private ShapeService shapeService;
	private BusinessObjectResolutionService bor;
	private PropertyService propertyService;
	private BoHandlerDeleteFeature defaultDeleteFeature;
	private BoHandlerDirectEditFeature defaultDirectEditFeature;
	private BoHandlerLayoutFeature defaultLayoutFeature;
	private BoHandlerRefreshHelper pictogramRefreshHelper;
	private AgeMoveShapeFeature defaultMoveShapeFeature;
	private AgeResizeShapeFeature defaultResizeShapeFeature;
	
	public AgeFeatureProvider(final IDiagramTypeProvider dtp) {
		super(dtp);
	}
	
	public void initialize(final IEclipseContext context) {
		this.eclipseContext = context.createChild();
		this.eclipseContext.set(IFeatureProvider.class, this);
		this.connectionService = Objects.requireNonNull(eclipseContext.get(ConnectionService.class), "unable to get connection service");		
		this.extService = Objects.requireNonNull(eclipseContext.get(ExtensionService.class), "unable to retrieve extension service");
		this.diagramService = Objects.requireNonNull(eclipseContext.get(DiagramService.class), "unable to retrieve diagram service");
		this.aadlModService = Objects.requireNonNull(eclipseContext.get(AadlModificationService.class), "unable to retrieve aadl modification service");
		this.shapeService = Objects.requireNonNull(eclipseContext.get(ShapeService.class), "unable to retrieve shape service");
		this.bor = Objects.requireNonNull(context.get(BusinessObjectResolutionService.class), "unable to retrieve business object resolution service");
		this.propertyService = Objects.requireNonNull(eclipseContext.get(PropertyService.class), "unable to retrieve property service");
		
		// Create the refresh helper
		final GhostingService ghostingService = Objects.requireNonNull(context.get(GhostingService.class), "unable to retrieve ghosting service");
		final LabelService labelService = Objects.requireNonNull(eclipseContext.get(LabelService.class), "unable to retrieve label service");
		final ShapeCreationService shapeCreationService = Objects.requireNonNull(eclipseContext.get(ShapeCreationService.class), "unable to retrieve shape creation service");
		final ConnectionCreationService connectionCreationService = Objects.requireNonNull(eclipseContext.get(ConnectionCreationService.class), "unable to retrieve connection creation service");
		final AnchorService anchorService = Objects.requireNonNull(eclipseContext.get(AnchorService.class), "unable to retrieve anchor service");
		final StyleService styleService = Objects.requireNonNull(context.get(StyleService.class), "unable to retrieve style service");
		final QueryService queryService = Objects.requireNonNull(context.get(QueryService.class), "unable to retrieve query service");
		this.pictogramRefreshHelper = new BoHandlerRefreshHelper(extService, ghostingService, labelService, shapeCreationService, connectionCreationService, anchorService, propertyService, styleService, connectionService, queryService, bor, this);
		
		final IndependenceProvider nonCachingIndependenceProvider = make(IndependenceProvider.class);
		if(enableIndependenceProviderCaching) {
			final CachingIndependenceProvider cachingIndependenceProvider = new CachingIndependenceProvider(nonCachingIndependenceProvider);
			eclipseContext.get(CachingService.class).registerCache(cachingIndependenceProvider);
			setIndependenceSolver(cachingIndependenceProvider);
		} else {
			setIndependenceSolver(nonCachingIndependenceProvider);
		}
		
		// Create the feature to use for pictograms which do not have a specialized feature. Delegates to business object handlers.
		defaultDeleteFeature = make(BoHandlerDeleteFeature.class);
		defaultDirectEditFeature = make(BoHandlerDirectEditFeature.class);
		defaultLayoutFeature = make(BoHandlerLayoutFeature.class);
		defaultMoveShapeFeature = make(AgeMoveShapeFeature.class);
		defaultResizeShapeFeature = make(AgeResizeShapeFeature.class);
	}

	@Override
	public void dispose() {
		if(eclipseContext != null) {
			eclipseContext.dispose();
		}
		
		super.dispose();
	}
	
	/**
	 * Instantiates an object and injects the current context into it
	 * @param clazz
	 * @return
	 */
	protected final <T> T make(final Class<T> clazz) {
		return ContextInjectionFactory.make(clazz, eclipseContext);
	}
	
	// Don't allow removing, just deleting.
	@Override 
	public IRemoveFeature getRemoveFeature(final IRemoveContext context) {
		return null;
	}

	@Override
	public IDeleteFeature getDeleteFeature(final IDeleteContext context) {
		return defaultDeleteFeature;
	}
	
	@Override
	public ICustomFeature[] getCustomFeatures(final ICustomContext context) {
		final ArrayList<ICustomFeature> features = new ArrayList<ICustomFeature>();
		addCustomFeatures(features);
		return features.toArray(new ICustomFeature[] {});
	}	
	
	/**
	 * Method used to additively build a list of custom features. Subclasses can override to add additional custom features while including those supported by parent classes.
	 * @param features
	 */
	protected void addCustomFeatures(final List<ICustomFeature> features) {
		features.add(make(SelectAncestorFeature.class));
		features.add(make(LayoutDiagramFeature.class));

		// Commands
		for(final Object cmd : extService.getCommands()) {
			features.add(new CommandCustomFeature(cmd, extService, bor, aadlModService, propertyService, connectionService, this)); 		
		}
	}
	
	// Helper methods to hide the fact that we are wrapping our AADL Elements to hide the fact they are EMF objects from Graphiti. See AadlElementWrapper
	@Override
	public PictogramElement getPictogramElementForBusinessObject(Object businessObject) {
		if(businessObject instanceof Element) {
			businessObject =  new AadlElementWrapper((Element)businessObject);
		}
		
		return super.getPictogramElementForBusinessObject(businessObject);
	}
	
	public PictogramElement[] getAllPictogramElementsForBusinessObject(Object businessObject) {
		if(businessObject instanceof Element) {
			businessObject =  new AadlElementWrapper((Element)businessObject);
		}
		
		return super.getAllPictogramElementsForBusinessObject(businessObject);
	}

	@Override
	public IDirectEditingFeature getDirectEditingFeature(final IDirectEditingContext context) {
		return defaultDirectEditFeature;
	}
	
	@Override
	public ICreateFeature[] getCreateFeatures() {		
		final List<ICreateFeature> features = new ArrayList<>();
		
		if(getDiagramBusinessObject() != null) {			
			final IEclipseContext childCtx = createGetPaletteEntriesContext();
			try {
				for(final Object boHandler : extService.getBusinessObjectHandlers()) {
					final PaletteEntry[] extPaletteEntries = (PaletteEntry[])ContextInjectionFactory.invoke(boHandler, GetPaletteEntries.class, childCtx, null);
					if(extPaletteEntries != null) {
						for(final PaletteEntry entry : extPaletteEntries) {
							final SimplePaletteEntry simpleEntry = (SimplePaletteEntry)entry;
							if(simpleEntry .getType() == SimplePaletteEntry.Type.CREATE) {
								features.add(new BoHandlerCreateFeature(bor, extService, aadlModService, shapeService, propertyService, connectionService, this, simpleEntry, boHandler));
							}
						}
					}
				}		
			} finally {
				childCtx.dispose();
			}
		}
		
		return features.toArray(new ICreateFeature[0]);
	}
			
	@Override
	public IAddFeature getAddFeature(final IAddContext addCtx) {
		final Object boHandler = extService.getApplicableBusinessObjectHandler(AadlElementWrapper.unwrap(addCtx.getNewObject()));
		if(boHandler != null) {
			return new BoHandlerAddFeature(extService, pictogramRefreshHelper, this, boHandler);
		}

		return null;
	}
	
	@Override
	public IUpdateFeature getUpdateFeature(final IUpdateContext updateCtx) {
		final PictogramElement pe = updateCtx.getPictogramElement(); 
		final Object bo = bor.getBusinessObjectForPictogramElement(pe);
		if(bo == null) {
			return null;
		}
		
		final Object boHandler = extService.getApplicableBusinessObjectHandler(bo);
		if(boHandler != null) {
			return new BoHandlerUpdateFeature(diagramService, bor, connectionService, pictogramRefreshHelper, this, boHandler);
		}

		return null;
	}
		
	@Override
	public ICreateConnectionFeature[] getCreateConnectionFeatures() {
		final List<ICreateConnectionFeature> retList = new ArrayList<ICreateConnectionFeature>();
		if(getDiagramBusinessObject() != null) {			
			// Add extension create connection features		
			final IEclipseContext childCtx = createGetPaletteEntriesContext();
			try {
				for(final Object boHandler : extService.getBusinessObjectHandlers()) {
					final PaletteEntry[] extPaletteEntries = (PaletteEntry[])ContextInjectionFactory.invoke(boHandler, GetPaletteEntries.class, childCtx, null);
					if(extPaletteEntries != null) {
						for(final PaletteEntry entry : extPaletteEntries) {
							final SimplePaletteEntry simpleEntry = (SimplePaletteEntry)entry;
							if(simpleEntry.getType() == SimplePaletteEntry.Type.CREATE_CONNECTION) {
								retList.add(new BoHandlerCreateConnectionFeature(extService, aadlModService, bor, propertyService, connectionService, this, simpleEntry, boHandler));
							}
						}
					}
				}		
			} finally {
				childCtx.dispose();
			}
		}

		return retList.toArray(new ICreateConnectionFeature[0]);
	}
		
	// Specialized handling for manipulating bendpoints.
	// Currently only allow editing when working with a limited subset of connections.
	// This will disable manipulating connections associated with flow specifications and other model elements which are not persisted. 	
	private final IMoveBendpointFeature moveBendpointFeature = new DefaultMoveBendpointFeature(this) {
		@Override
		public boolean canMoveBendpoint(IMoveBendpointContext context) {
			return allowBendpointManipulation(context.getConnection());
		}
		
		@Override
		public boolean moveBendpoint(final IMoveBendpointContext ctx) {
			boolean result = super.moveBendpoint(ctx);			
			connectionService.updateConnectionAnchor(ctx.getConnection());						
			return result;
		}
	};
	
	@Override 
	public IMoveBendpointFeature getMoveBendpointFeature(final IMoveBendpointContext context) {
		return moveBendpointFeature;
	}
	
	private final IAddBendpointFeature addBendpointFeature = new DefaultAddBendpointFeature(this) {
		@Override
		public boolean canAddBendpoint(IAddBendpointContext context) {
			return allowBendpointManipulation(context.getConnection());
		}
		
		@Override
		public void addBendpoint(final IAddBendpointContext ctx) {
			super.addBendpoint(ctx);			
			connectionService.updateConnectionAnchor(ctx.getConnection());						
		}
	};
	
	@Override 
	public IAddBendpointFeature getAddBendpointFeature(final IAddBendpointContext context) {
		return addBendpointFeature;
	}
	
	private final IRemoveBendpointFeature removeBendpointFeature = new DefaultRemoveBendpointFeature(this) {
		@Override
		public boolean canRemoveBendpoint(IRemoveBendpointContext context) {
			return allowBendpointManipulation(context.getConnection());
		}
		
		@Override
		public void removeBendpoint(final IRemoveBendpointContext ctx) {
			super.removeBendpoint(ctx);			
			connectionService.updateConnectionAnchor(ctx.getConnection());						
		}
	};
	
	@Override 
	public IRemoveBendpointFeature getRemoveBendpointFeature(final IRemoveBendpointContext context) {
		return removeBendpointFeature;
	}

	private boolean allowBendpointManipulation(final PictogramElement pe) {
		final Object bo = bor.getBusinessObjectForPictogramElement(pe);
		return bo instanceof org.osate.aadl2.Connection || bo instanceof org.osate.aadl2.FlowSpecification || bo instanceof SubprogramCallOrder || bo instanceof ConnectionReference || bo instanceof Generalization;
	}
	
	private IEclipseContext createGetPaletteEntriesContext() {
		final Object diagramBo = getDiagramBusinessObject();
		final IEclipseContext childCtx = extService.createChildContext();
		childCtx.set(Names.DIAGRAM_BO, diagramBo);
		return childCtx;
	}
	
	final Object getDiagramBusinessObject() {
		return bor.getBusinessObjectForPictogramElement(getDiagramTypeProvider().getDiagram());
	}
	
	@Override
	public IMoveConnectionDecoratorFeature getMoveConnectionDecoratorFeature(IMoveConnectionDecoratorContext context) {
		// Don't allow moving connection decorators which do not have names
		if(context.getConnectionDecorator() == null || propertyService.getName(context.getConnectionDecorator()) == null) {
			return null;
		}
		
		return super.getMoveConnectionDecoratorFeature(context);
	}
	
	@Override
	public IMoveShapeFeature getMoveShapeFeature(final IMoveShapeContext context) {
		return defaultMoveShapeFeature;
	}
	
	@Override
	public IResizeShapeFeature getResizeShapeFeature(final IResizeShapeContext context) {
		return defaultResizeShapeFeature;
	}
	
	@Override
	public ILayoutFeature getLayoutFeature(ILayoutContext context) {
		return defaultLayoutFeature;
	}
	
	@Override
	public void link(final PictogramElement pictogramElement, final Object[] businessObjects) {
		// Prevent linkage from occurring if we are unable to get a resource for the EObject.
		// This is to prevent linking when the root of the EObject is not an expected object. In such cases, annex references may be invalid because such references
		// often depend on getting the reference for the root package.
		for(final Object rawBo : businessObjects) {
			// Get an EMF object
			Object bo = AadlElementWrapper.unwrap(rawBo);
			if(bo instanceof EmfContainerProvider) {
				bo = ((EmfContainerProvider) bo).getEmfContainer();
			}
			
			if(bo == null) {
				return;
			}
			
			if(!(bo instanceof EObject)) {
				return;
			}
			
			if(bo instanceof EObject) {
				// Check if the resource is valid.
				final EObject eobj = (EObject)bo;
				if(eobj.eResource() == null) {
					return;
				}
			}
		}
		
		super.link(pictogramElement, businessObjects);
	}
}

