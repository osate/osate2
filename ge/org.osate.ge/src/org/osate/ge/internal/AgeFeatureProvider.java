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
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.emf.ecore.EClass;
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
import org.eclipse.graphiti.features.IReconnectionFeature;
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
import org.eclipse.graphiti.features.context.IReconnectionContext;
import org.eclipse.graphiti.features.context.IRemoveBendpointContext;
import org.eclipse.graphiti.features.context.IRemoveContext;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.features.impl.DefaultAddBendpointFeature;
import org.eclipse.graphiti.features.impl.DefaultMoveBendpointFeature;
import org.eclipse.graphiti.features.impl.DefaultRemoveBendpointFeature;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.features.DefaultFeatureProvider;
import org.osate.aadl2.AccessType;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.Element;
import org.osate.ge.internal.features.ChangeFeatureTypeFeature;
import org.osate.ge.internal.features.ChangeSubcomponentTypeFeature;
import org.osate.ge.internal.features.ComponentImplementationToTypeFeature;
import org.osate.ge.internal.features.GoToPackageDiagramFeature;
import org.osate.ge.internal.features.ConfigureInModesFeature;
import org.osate.ge.internal.features.DrillDownFeature;
import org.osate.ge.internal.features.GraphicalToTextualFeature;
import org.osate.ge.internal.features.InstantiateComponentImplementationFeature;
import org.osate.ge.internal.features.LayoutDiagramFeature;
import org.osate.ge.internal.features.SwitchDirectionOfConnectionFeature;
import org.osate.ge.internal.graphiti.features.AgeResizeShapeFeature;
import org.osate.ge.internal.graphiti.features.BoHandlerAddFeature;
import org.osate.ge.internal.graphiti.features.BoHandlerCreateConnectionFeature;
import org.osate.ge.internal.graphiti.features.BoHandlerCreateFeature;
import org.osate.ge.internal.graphiti.features.BoHandlerDeleteFeature;
import org.osate.ge.internal.graphiti.features.BoHandlerDirectEditFeature;
import org.osate.ge.internal.graphiti.features.BoHandlerLayoutFeature;
import org.osate.ge.internal.graphiti.features.AgeFeatureUtil;
import org.osate.ge.internal.graphiti.features.AgeMoveShapeFeature;
import org.osate.ge.internal.graphiti.features.BoHandlerUpdateFeature;
import org.osate.ge.internal.graphiti.features.CommandCustomFeature;
import org.osate.ge.internal.graphiti.features.SelectAncestorFeature;
import org.osate.ge.internal.query.AncestorUtil;
import org.osate.ge.internal.graphiti.features.BoHandlerRefreshHelper;
import org.osate.ge.internal.features.SetDerivedModesFeature;
import org.osate.ge.internal.features.SetDimensionsFeature;
import org.osate.ge.internal.features.SetInitialModeFeature;
import org.osate.ge.internal.features.SetModeTransitionTriggersFeature;
import org.osate.ge.internal.features.EditFlowsFeature;
import org.osate.ge.internal.features.MoveSubprogramCallDownFeature;
import org.osate.ge.internal.features.MoveSubprogramCallUpFeature;
import org.osate.ge.internal.features.RefineConnectionFeature;
import org.osate.ge.internal.features.RefineSubcomponentFeature;
import org.osate.ge.internal.features.SetConnectionBidirectionalityFeature;
import org.osate.ge.internal.features.SetSubcomponentClassifierFeature;
import org.osate.ge.internal.features.PackageSetExtendedClassifierFeature;
import org.osate.ge.internal.features.RefineFeatureFeature;
import org.osate.ge.internal.features.RefineFlowSpecificationFeature;
import org.osate.ge.internal.features.SetAccessFeatureKindFeature;
import org.osate.ge.internal.features.SetFeatureDirectionFeature;
import org.osate.ge.internal.features.SetFeatureGroupInverseFeature;
import org.osate.ge.EmfContainerProvider;
import org.osate.ge.PaletteEntry;
import org.osate.ge.di.GetPaletteEntries;
import org.osate.ge.di.Names;
import org.osate.ge.internal.services.AadlModificationService;
import org.osate.ge.internal.services.AnchorService;
import org.osate.ge.internal.services.BusinessObjectResolutionService;
import org.osate.ge.internal.services.ConnectionCreationService;
import org.osate.ge.internal.services.ConnectionService;
import org.osate.ge.internal.services.DiagramService;
import org.osate.ge.internal.services.ExtensionService;
import org.osate.ge.internal.services.GhostingService;
import org.osate.ge.internal.services.PropertyService;
import org.osate.ge.internal.services.QueryService;
import org.osate.ge.internal.services.SerializableReferenceService;
import org.osate.ge.internal.services.LabelService;
import org.osate.ge.internal.services.ShapeCreationService;
import org.osate.ge.internal.services.ShapeService;
import org.osate.ge.internal.services.impl.ReferenceEncoder;
import org.osate.ge.internal.util.AadlFeatureUtil;
import org.osate.ge.internal.util.SubcomponentUtil;

public class AgeFeatureProvider extends DefaultFeatureProvider {
	private static final String KEY_BUSINESS_OBJECT = "bo"; // TODO: Rename?
	private static final String REFERENCE_TYPE_ABSOLUTE = "abs";
	private static final String REFERENCE_TYPE_RELATIVE = "rel";
	
	// TODO: Rename?
	private static final String LEGACY_KEY_INDEPENDENT_PROPERTY = "independentObject"; // Property which was used to store references by Graphiti before migration to custom handling of references.
	private IEclipseContext eclipseContext;
	private ConnectionService connectionService;
	private ExtensionService extService;
	private DiagramService diagramService;
	private AadlModificationService aadlModService;
	private ShapeService shapeService;
	private BusinessObjectResolutionService bor;
	private PropertyService propertyService;
	private SerializableReferenceService referenceService;
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
		this.referenceService = Objects.requireNonNull(eclipseContext.get(SerializableReferenceService.class), "unable to retrieve serializable reference service");
		
		// Create the refresh helper
		final GhostingService ghostingService = Objects.requireNonNull(context.get(GhostingService.class), "unable to retrieve ghosting service");
		final LabelService labelService = Objects.requireNonNull(eclipseContext.get(LabelService.class), "unable to retrieve label service");
		final ShapeCreationService shapeCreationService = Objects.requireNonNull(eclipseContext.get(ShapeCreationService.class), "unable to retrieve shape creation service");
		final ConnectionCreationService connectionCreationService = Objects.requireNonNull(eclipseContext.get(ConnectionCreationService.class), "unable to retrieve connection creation service");
		final AnchorService anchorService = Objects.requireNonNull(eclipseContext.get(AnchorService.class), "unable to retrieve anchor service");
		final QueryService queryService = Objects.requireNonNull(context.get(QueryService.class), "unable to retrieve query service");
		this.pictogramRefreshHelper = new BoHandlerRefreshHelper(extService, ghostingService, labelService, shapeCreationService, connectionCreationService, anchorService, propertyService, connectionService, queryService, bor, this);
		
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
	

	private IEclipseContext getContext() {
		return eclipseContext;
	}
	
	/**
	 * Instantiates an object and injects the current context into it
	 * @param clazz
	 * @return
	 */
	protected final <T> T make(final Class<T> clazz) {
		return ContextInjectionFactory.make(clazz, eclipseContext);
	}
	
	// Referencing
	@Override
	public Object[] getAllBusinessObjectsForPictogramElement(final PictogramElement pictogramElement) {
		// A maximum of one business object per pictogram element is supported
		final Object bo = getBusinessObjectForPictogramElement(pictogramElement);
		return bo == null ? new Object[0] : new Object[] { bo };
	}
	
	@Override
	public Object getBusinessObjectForPictogramElement(final PictogramElement pictogramElement) {
		if(pictogramElement == null) {
			return null;
		}
		
		// TODO: Implement using AgeDiagram
		throw new RuntimeException("Not implemented");
	}
	
	@Override
	public PictogramElement[] getAllPictogramElementsForBusinessObject(Object businessObject) {		
		throw new RuntimeException("Not supported");
	}
		
	@Override
	public PictogramElement getPictogramElementForBusinessObject(final Object businessObject) {
		throw new RuntimeException("Not supported");
	}
		
	@Override
	public void link(final PictogramElement pictogramElement, final Object[] businessObjects) {
		throw new RuntimeException("Not supported");
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

	// Don't allow reconnection
	public IReconnectionFeature getReconnectionFeature(IReconnectionContext context) {
		return null;
	}
	
	/**
	 * Method used to additively build a list of custom features. Subclasses can override to add additional custom features while including those supported by parent classes.
	 * @param features
	 */
	protected void addCustomFeatures(final List<ICustomFeature> features) {
		features.add(make(DrillDownFeature.class));
		features.add(make(SelectAncestorFeature.class));
		features.add(make(ComponentImplementationToTypeFeature.class));
		features.add(make(GoToPackageDiagramFeature.class));
		features.add(make(GraphicalToTextualFeature.class));
		features.add(make(LayoutDiagramFeature.class));
		features.add(make(InstantiateComponentImplementationFeature.class));
		features.add(make(SwitchDirectionOfConnectionFeature.class));
		features.add(make(ConfigureInModesFeature.class));
		features.add(createSetInitialModeFeature(true));
		features.add(createSetInitialModeFeature(false));
		features.add(createSetDerivedModesFeature(true));
		features.add(createSetDerivedModesFeature(false));
		features.add(make(SetModeTransitionTriggersFeature.class));		
	//	features.add(make(SetFeatureClassifierFeature.class));
		features.add(make(SetDimensionsFeature.class));
		
		for(final EClass featureType : AadlFeatureUtil.getFeatureTypes()) {
			final IEclipseContext childCtx = getContext().createChild();
			try {
				try {
					childCtx.set("Feature Type", featureType);
					features.add(ContextInjectionFactory.make(ChangeFeatureTypeFeature.class, childCtx));
				} finally {
					childCtx.dispose();
				}
			} finally {
				childCtx.dispose();
			}
		}
		
		// Component Implementation
		features.add(make(EditFlowsFeature.class));
		features.add(make(SetSubcomponentClassifierFeature.class));
		features.add(make(RefineSubcomponentFeature.class));
		features.add(make(RefineConnectionFeature.class));
		
		for(final EClass subcomponentType : SubcomponentUtil.getSubcomponentTypes()) {
			final IEclipseContext childCtx = getContext().createChild();
			try {
				childCtx.set("Subcomponent Type", subcomponentType);
				features.add(ContextInjectionFactory.make(ChangeSubcomponentTypeFeature.class, childCtx));	
			} finally {
				childCtx.dispose();
			}
		}
		
		features.add(createSetConnectionBidirectionalityFeature(false));
		features.add(createSetConnectionBidirectionalityFeature(true));
		
		// Package
		features.add(make(PackageSetExtendedClassifierFeature.class));
		
		// Type
		features.add(make(RefineFeatureFeature.class));
		features.add(make(RefineFlowSpecificationFeature.class));
		
		features.add(createSetFeatureGroupInverseFeature(true));
		features.add(createSetFeatureGroupInverseFeature(false));
		features.add(createSetFeatureDirectionFeature(DirectionType.IN));
		features.add(createSetFeatureDirectionFeature(DirectionType.OUT));
		features.add(createSetFeatureDirectionFeature(DirectionType.IN_OUT));		
		features.add(createSetFeatureKindFeature(AccessType.PROVIDES));
		features.add(createSetFeatureKindFeature(AccessType.REQUIRES));
		
		// Subprogram Call
		features.add(make(MoveSubprogramCallUpFeature.class));
		features.add(make(MoveSubprogramCallDownFeature.class));
		
		// Commands
		for(final Object cmd : extService.getCommands()) {
			features.add(new CommandCustomFeature(cmd, extService, bor, aadlModService, propertyService, connectionService, this)); 		
		}
	}
	
	private ICustomFeature createSetInitialModeFeature(final Boolean isInitial) {
		final IEclipseContext childCtx = getContext().createChild();
		try {
			childCtx.set("Is Initial", isInitial);
			return ContextInjectionFactory.make(SetInitialModeFeature.class, childCtx);
		} finally {
			childCtx.dispose();
		}
	}
	
	private ICustomFeature createSetDerivedModesFeature(final Boolean derivedModes) {
		final IEclipseContext childCtx = getContext().createChild();
		try {
			childCtx.set("Derived Modes", derivedModes);
			return ContextInjectionFactory.make(SetDerivedModesFeature.class, childCtx);
		} finally {
			childCtx.dispose();
		}
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
		public void removeBendpoint(final IRemoveBendpointContext ctx) {
			super.removeBendpoint(ctx);			
			connectionService.updateConnectionAnchor(ctx.getConnection());						
		}
	};
	
	@Override 
	public IRemoveBendpointFeature getRemoveBendpointFeature(final IRemoveBendpointContext context) {
		return removeBendpointFeature;
	}

	private ICustomFeature createSetConnectionBidirectionalityFeature(final Boolean bidirectionalityValue) {
		final IEclipseContext childCtx = getContext().createChild();
		try {
			childCtx.set("Value", bidirectionalityValue);
			return ContextInjectionFactory.make(SetConnectionBidirectionalityFeature.class, childCtx);
		} finally {
			childCtx.dispose();
		}
	}
	
	// Type
	private SetFeatureDirectionFeature createSetFeatureDirectionFeature(final DirectionType dirType) 
	{
		final IEclipseContext childCtx = getContext().createChild();
		try {
			childCtx.set("Direction", dirType);
			return ContextInjectionFactory.make(SetFeatureDirectionFeature.class, childCtx);
		} finally {
			childCtx.dispose();
		}
	}
	
	private SetFeatureGroupInverseFeature createSetFeatureGroupInverseFeature(final boolean inverse) 
	{
		final IEclipseContext childCtx = getContext().createChild();
		try {
			childCtx.set("Inverse", inverse);
			return ContextInjectionFactory.make(SetFeatureGroupInverseFeature.class, childCtx);
		} finally {
			childCtx.dispose();
		}
	}
	
	private SetAccessFeatureKindFeature createSetFeatureKindFeature(final AccessType accType) 
	{
		final IEclipseContext childCtx = getContext().createChild();
		try {
			childCtx.set("Access", accType);
			return ContextInjectionFactory.make(SetAccessFeatureKindFeature.class, childCtx);
		} finally {
			childCtx.dispose();
		}
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
}

