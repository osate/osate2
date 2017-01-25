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
import org.eclipse.graphiti.features.IMoveShapeFeature;
import org.eclipse.graphiti.features.IReconnectionFeature;
import org.eclipse.graphiti.features.IRemoveBendpointFeature;
import org.eclipse.graphiti.features.IRemoveFeature;
import org.eclipse.graphiti.features.IResizeShapeFeature;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.IAddBendpointContext;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.features.context.ILayoutContext;
import org.eclipse.graphiti.features.context.IMoveBendpointContext;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
import org.eclipse.graphiti.features.context.IReconnectionContext;
import org.eclipse.graphiti.features.context.IRemoveBendpointContext;
import org.eclipse.graphiti.features.context.IRemoveContext;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.context.impl.CreateContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.features.impl.DefaultAddBendpointFeature;
import org.eclipse.graphiti.features.impl.DefaultMoveBendpointFeature;
import org.eclipse.graphiti.features.impl.DefaultRemoveBendpointFeature;
import org.eclipse.graphiti.func.IDelete;
import org.eclipse.graphiti.func.IReconnection;
import org.eclipse.graphiti.func.IUpdate;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.pattern.CreateConnectionFeatureForPattern;
import org.eclipse.graphiti.pattern.DefaultFeatureProviderWithPatterns;
import org.eclipse.graphiti.pattern.IConnectionPattern;
import org.eclipse.graphiti.pattern.IPattern;
import org.eclipse.graphiti.pattern.ReconnectionFeatureForPattern;
import org.eclipse.graphiti.pattern.UpdateFeatureForPattern;
import org.eclipse.graphiti.ui.features.DefaultDeleteFeature;
import org.osate.aadl2.AccessType;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.Element;
import org.osate.aadl2.FlowKind;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.ModeTransition;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.ge.internal.businessObjectHandlers.AadlFeatureUtil;
import org.osate.ge.internal.features.ChangeFeatureTypeFeature;
import org.osate.ge.internal.features.ChangeSubcomponentTypeFeature;
import org.osate.ge.internal.features.CommandCustomFeature;
import org.osate.ge.internal.features.ComponentImplementationToTypeFeature;
import org.osate.ge.internal.features.GoToPackageDiagramFeature;
import org.osate.ge.internal.features.ConfigureInModesFeature;
import org.osate.ge.internal.features.DrillDownFeature;
import org.osate.ge.internal.features.GraphicalToTextualFeature;
import org.osate.ge.internal.features.InstantiateComponentImplementationFeature;
import org.osate.ge.internal.features.LayoutDiagramFeature;
import org.osate.ge.internal.features.SelectAncestorFeature;
import org.osate.ge.internal.features.SwitchDirectionOfConnectionFeature;
import org.osate.ge.internal.features.UpdateLayoutFromClassifierDiagramFeature;
import org.osate.ge.internal.graphiti.features.AgeResizeShapeFeature;
import org.osate.ge.internal.graphiti.features.BoHandlerAddFeature;
import org.osate.ge.internal.graphiti.features.BoHandlerCreateConnectionFeature;
import org.osate.ge.internal.graphiti.features.BoHandlerCreateFeature;
import org.osate.ge.internal.graphiti.features.BoHandlerDeleteFeature;
import org.osate.ge.internal.graphiti.features.BoHandlerDirectEditFeature;
import org.osate.ge.internal.graphiti.features.BoHandlerLayoutFeature;
import org.osate.ge.internal.graphiti.features.AgeMoveShapeFeature;
import org.osate.ge.internal.graphiti.features.BoHandlerUpdateFeature;
import org.osate.ge.internal.graphiti.features.BoHandlerRefreshHelper;
import org.osate.ge.internal.features.RenameModeTransitionFeature;
import org.osate.ge.internal.features.SetDerivedModesFeature;
import org.osate.ge.internal.features.SetDimensionsFeature;
import org.osate.ge.internal.features.SetFeatureClassifierFeature;
import org.osate.ge.internal.features.SetInitialModeFeature;
import org.osate.ge.internal.features.SetModeTransitionTriggersFeature;
import org.osate.ge.internal.features.UpdateClassifierDiagramFeature;
import org.osate.ge.internal.patterns.AgeConnectionPattern;
import org.osate.ge.internal.patterns.ClassifierPattern;
import org.osate.ge.internal.patterns.ConnectionPattern;
import org.osate.ge.internal.patterns.FlowSpecificationPattern;
import org.osate.ge.internal.patterns.ModeTransitionPattern;
import org.osate.ge.internal.features.EditFlowsFeature;
import org.osate.ge.internal.features.MoveSubprogramCallDownFeature;
import org.osate.ge.internal.features.MoveSubprogramCallUpFeature;
import org.osate.ge.internal.features.RefineConnectionFeature;
import org.osate.ge.internal.features.RefineSubcomponentFeature;
import org.osate.ge.internal.features.RenameConnectionFeature;
import org.osate.ge.internal.features.SetConnectionBidirectionalityFeature;
import org.osate.ge.internal.features.SetSubcomponentClassifierFeature;
import org.osate.ge.internal.patterns.SubprogramCallOrder;
import org.osate.ge.internal.patterns.SubprogramCallPattern;
import org.osate.ge.internal.patterns.SubprogramCallSequencePattern;
import org.osate.ge.internal.features.PackageSetExtendedClassifierFeature;
import org.osate.ge.internal.features.CreateSimpleFlowSpecificationFeature;
import org.osate.ge.internal.features.RefineFeatureFeature;
import org.osate.ge.internal.features.RefineFlowSpecificationFeature;
import org.osate.ge.internal.features.RenameFlowSpecificationFeature;
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

public class AgeFeatureProvider extends DefaultFeatureProviderWithPatterns {
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
		
		// Add patterns
		addConnectionPattern(make(FlowSpecificationPattern.class));
		addConnectionPattern(make(ModeTransitionPattern.class));

		addAadlConnectionPatterns();
		
		// Subprogram Calls
		addPattern(make(SubprogramCallSequencePattern.class));
		addPattern(make(SubprogramCallPattern.class));
		
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
	
	// Don't allow removing, just deleting.
	@Override 
	public IRemoveFeature getRemoveFeature(final IRemoveContext context) {
		return null;
	}

	// As of 2013-07-03 Graphiti doesn't support connection patterns handling deletes so check if the pattern implements IDeleteFeature and return a feature based on the pattern
	@Override 
	public IDeleteFeature getDeleteFeature(final IDeleteContext context) {
		PictogramElement pictogramElement = context.getPictogramElement();
		if(pictogramElement instanceof Connection) {
			for(final IConnectionPattern conPattern : getConnectionPatterns()) {
				if(conPattern instanceof IDelete) {
					final IDelete deleter = (IDelete)conPattern;
					if(deleter.canDelete(context)) {
						// Create a new feature that wraps the connection pattern
						final IDeleteFeature f = new DefaultDeleteFeature(this) {
							@Override
							public boolean canDelete(IDeleteContext context) {
								return deleter.canDelete(context);
							}

							@Override
							public void preDelete(IDeleteContext context) {
								deleter.preDelete(context);
							}

							@Override
							public void delete(IDeleteContext context) {
								deleter.delete(context);
							}

							@Override
							public void postDelete(IDeleteContext context) {
								deleter.postDelete(context);
							}
						};
						
						// Check the Feature
						if (checkFeatureAndContext(f, context)) {
							return f;
						}
					}
				}
			}
		}
		
		return super.getDeleteFeature(context);
	}
	
	@Override
	protected IDeleteFeature getDeleteFeatureAdditional(final IDeleteContext context) {
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
		features.add(make(DrillDownFeature.class));
		features.add(make(SelectAncestorFeature.class));
		features.add(make(ComponentImplementationToTypeFeature.class));
		features.add(make(GoToPackageDiagramFeature.class));
		features.add(make(GraphicalToTextualFeature.class));
		features.add(make(LayoutDiagramFeature.class));
		features.add(make(InstantiateComponentImplementationFeature.class));
		features.add(make(SwitchDirectionOfConnectionFeature.class));
		features.add(make(UpdateLayoutFromClassifierDiagramFeature.class));
		features.add(make(ConfigureInModesFeature.class));
		features.add(createSetInitialModeFeature(true));
		features.add(createSetInitialModeFeature(false));
		features.add(createSetDerivedModesFeature(true));
		features.add(createSetDerivedModesFeature(false));
		features.add(make(SetModeTransitionTriggersFeature.class));		
		features.add(make(SetFeatureClassifierFeature.class));
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
		
		for(final EClass subcomponentType : ClassifierPattern.getSubcomponentTypes()) {
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
			features.add(new CommandCustomFeature(cmd, extService, bor, this)); 		
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
	public IUpdateFeature getUpdateFeature(IUpdateContext context) {	
		PictogramElement pictogramElement = context.getPictogramElement();
		
		if(pictogramElement instanceof Diagram) {
			final BusinessObjectResolutionService bor = getContext().get(BusinessObjectResolutionService.class);
			if(bor != null) {
				final Object bo = bor.getBusinessObjectForPictogramElement(context.getPictogramElement());
				if(bo instanceof Classifier) {
					return make(UpdateClassifierDiagramFeature.class);
				}
			}
		}
		   
		// As of 2013-07-08 Graphiti doesn't support connection patterns handling updates so check if the pattern implements IUpdate and return a feature based on the pattern
		if(pictogramElement instanceof Connection) {
			for(final IConnectionPattern conPattern : getConnectionPatterns()) {
				if(conPattern instanceof IUpdate) {
					if(((IUpdate)conPattern).canUpdate(context)) {
						final IUpdateFeature f = new UpdateFeatureForPattern(this, (IUpdate)conPattern);
						if (checkFeatureAndContext(f, context)) {
							return f;
						}
					}
				}
			}
		}
 
		return super.getUpdateFeature(context);
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
	protected IDirectEditingFeature getDirectEditingFeatureAdditional(final IDirectEditingContext context) {
		final Object bo = bor.getBusinessObjectForPictogramElement(context.getPictogramElement());			
		if(bo instanceof org.osate.aadl2.Connection) {
			return make(RenameConnectionFeature.class);
		} else if(bo instanceof ModeTransition) {
			return make(RenameModeTransitionFeature.class);
		} else if(bo instanceof FlowSpecification) {
			return make(RenameFlowSpecificationFeature.class);
		} else {	
			return defaultDirectEditFeature;
		}
	}
	
	@Override
	protected ICreateFeature[] getCreateFeaturesAdditional() {
		final IContext ctx = new CreateContext();
		final List<ICreateFeature> features = new ArrayList<>();
		addIfAvailable(features, createCreateSimpleFlowSpecificationFeature(FlowKind.SOURCE), ctx);
		addIfAvailable(features, createCreateSimpleFlowSpecificationFeature(FlowKind.SINK), ctx);
		
		final IEclipseContext childCtx = createGetPaletteEntriesContext();
		try {
			for(final Object boHandler : extService.getBusinessObjectHandlers()) {
				final PaletteEntry[] extPaletteEntries = (PaletteEntry[])ContextInjectionFactory.invoke(boHandler, GetPaletteEntries.class, childCtx, null);
				if(extPaletteEntries != null) {
					for(final PaletteEntry entry : extPaletteEntries) {
						final SimplePaletteEntry simpleEntry = (SimplePaletteEntry)entry;
						if(simpleEntry .getType() == SimplePaletteEntry.Type.CREATE) {
							features.add(new BoHandlerCreateFeature(bor, extService, aadlModService, shapeService, propertyService, this, simpleEntry, boHandler));
						}
					}
				}
			}		
		} finally {
			childCtx.dispose();
		}
		
		return features.toArray(new ICreateFeature[0]);
	}
			
	@Override
	protected IAddFeature getAddFeatureAdditional(final IAddContext addCtx) {
		final Object boHandler = extService.getApplicableBusinessObjectHandler(AadlElementWrapper.unwrap(addCtx.getNewObject()));
		if(boHandler != null) {
			return new BoHandlerAddFeature(extService, pictogramRefreshHelper, this, boHandler);
		}

		return super.getAddFeatureAdditional(addCtx);
	}
	
	@Override
	protected IUpdateFeature getUpdateFeatureAdditional(final IUpdateContext updateCtx) {
		final PictogramElement pe = updateCtx.getPictogramElement(); 
		final Object boHandler = extService.getApplicableBusinessObjectHandler(bor.getBusinessObjectForPictogramElement(pe));
		if(boHandler != null) {
			return new BoHandlerUpdateFeature(diagramService, bor, connectionService, pictogramRefreshHelper, this, boHandler);
		}

		return super.getUpdateFeatureAdditional(updateCtx);
	}
	
	private void addIfAvailable(final List<ICreateFeature> features, final ICreateFeature feature, final IContext context) {
		if(feature.isAvailable(context)) {
			features.add(feature);
		}
	}
	
	/**
	 * Override of getCreateConnectionFeatures() that allow connection patterns to be hidden by implementing isPaletteApplicable()
	 * As of 2014-09-18 Graphiti's connection pattern interface does not contain such a mechanism.
	 */
	@Override
	public ICreateConnectionFeature[] getCreateConnectionFeatures() {
		final ICreateConnectionFeature[] ret = new ICreateConnectionFeature[0];
		final List<ICreateConnectionFeature> retList = new ArrayList<ICreateConnectionFeature>();

		for (IConnectionPattern conPattern : getConnectionPatterns()) {
			if(conPattern instanceof AgeConnectionPattern) {
				if(((AgeConnectionPattern) conPattern).isPaletteApplicable()) {
					retList.add(new CreateConnectionFeatureForPattern(this, conPattern));					
				}
			}
		}
		
		final ICreateConnectionFeature[] a = getCreateConnectionFeaturesAdditional();
		for (ICreateConnectionFeature element : a) {
			retList.add(element);
		}
		
		// Add extension create connection features		
		final IEclipseContext childCtx = createGetPaletteEntriesContext();
		try {
			for(final Object boHandler : extService.getBusinessObjectHandlers()) {
				final PaletteEntry[] extPaletteEntries = (PaletteEntry[])ContextInjectionFactory.invoke(boHandler, GetPaletteEntries.class, childCtx, null);
				if(extPaletteEntries != null) {
					for(final PaletteEntry entry : extPaletteEntries) {
						final SimplePaletteEntry simpleEntry = (SimplePaletteEntry)entry;
						if(simpleEntry.getType() == SimplePaletteEntry.Type.CREATE_CONNECTION) {
							retList.add(new BoHandlerCreateConnectionFeature(extService, aadlModService, bor, this, simpleEntry, boHandler));
						}
					}
				}
			}		
		} finally {
			childCtx.dispose();
		}

		return retList.toArray(ret);
	}
	
	@Override
	public IReconnectionFeature getReconnectionFeature(final IReconnectionContext context) {
		for(final IConnectionPattern conPattern : getConnectionPatterns()) {
			if(conPattern instanceof IReconnection) {
				final IReconnection reconnection = (IReconnection)conPattern;
				if(reconnection.canReconnect(context)) {
					final ReconnectionFeatureForPattern f = new ReconnectionFeatureForPattern(this, reconnection);
					if (checkFeatureAndContext(f, context)) {
						return f;
					}
				}
			}
		}
		
		// Disable all other reconnection
		return null;
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
			connectionService.createUpdateMidpointAnchor(ctx.getConnection());						
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
			connectionService.createUpdateMidpointAnchor(ctx.getConnection());						
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
			connectionService.createUpdateMidpointAnchor(ctx.getConnection());						
		}
	};
	
	@Override 
	public IRemoveBendpointFeature getRemoveBendpointFeature(final IRemoveBendpointContext context) {
		return removeBendpointFeature;
	}

	private boolean allowBendpointManipulation(final PictogramElement pe) {
		final Object bo = bor.getBusinessObjectForPictogramElement(pe);
		return bo instanceof org.osate.aadl2.Connection || bo instanceof org.osate.aadl2.FlowSpecification || bo instanceof SubprogramCallOrder || bo instanceof ConnectionReference;
	}
	
	// ComponentImplementation
	/**
	 * Creates and adds patterns related to AADL Connections
	 */
	private void addAadlConnectionPatterns() {
		// Create the connection patterns
		for(final EClass connectionType : ConnectionPattern.getConnectionTypes()) {
			addConnectionPattern(createConnectionPattern(connectionType));
		}
	}
	
	private IConnectionPattern createConnectionPattern(final EClass connectionType) {
		final IEclipseContext childCtx = getContext().createChild();
		try {
			childCtx.set("Connection Type", connectionType);
			return ContextInjectionFactory.make(ConnectionPattern.class, childCtx);
		} finally {
			childCtx.dispose();
		}
	}
	
	private IPattern createClassifierPattern(final EClass scType) {
		final IEclipseContext childCtx = getContext().createChild();
		try {
			childCtx.set("Subcomponent Type", scType);
			return ContextInjectionFactory.make(ClassifierPattern.class, childCtx);
		} finally {
			childCtx.dispose();
		}
	}

	/**
	 * Creates and adds patterns related to AADL Features
	 */
	protected final void addSubcomponentPatterns() {
		// Create the subcomponent patterns
		for(final EClass scType : ClassifierPattern.getSubcomponentTypes()) {
			this.addPattern(createClassifierPattern(scType));
		}
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
	
	private CreateSimpleFlowSpecificationFeature createCreateSimpleFlowSpecificationFeature(final FlowKind flowKind) 
	{
		final IEclipseContext childCtx = getContext().createChild();
		try {			
			childCtx.set("Kind", flowKind);
			return ContextInjectionFactory.make(CreateSimpleFlowSpecificationFeature.class, childCtx);
		} finally {
			childCtx.dispose();
		}
	}
	
	private IEclipseContext createGetPaletteEntriesContext() {
		final Object diagramBo = bor.getBusinessObjectForPictogramElement(getDiagramTypeProvider().getDiagram());
		final IEclipseContext childCtx = extService.createChildContext();
		childCtx.set(Names.DIAGRAM_BO, diagramBo);
		return childCtx;
	}
	
	// Don't allow moving transient shapes
	@Override
	protected IMoveShapeFeature getMoveShapeFeatureAdditional(final IMoveShapeContext context) {
		return defaultMoveShapeFeature;
	}
	
	@Override
	protected IResizeShapeFeature getResizeShapeFeatureAdditional(final IResizeShapeContext context) {
		return defaultResizeShapeFeature;
	}
	
	@Override
	protected ILayoutFeature getLayoutFeatureAdditional(final ILayoutContext context) {
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
			
			// Check if the resource is valid.
			final EObject eobj = (EObject)bo;
			if(eobj.eResource() == null) {
				return;
			}
		}
		
		super.link(pictogramElement, businessObjects);
	}
}

