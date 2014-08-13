/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.diagrams.common;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IAddBendpointFeature;
import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.IDeleteFeature;
import org.eclipse.graphiti.features.IDirectEditingFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IMoveBendpointFeature;
import org.eclipse.graphiti.features.IReconnectionFeature;
import org.eclipse.graphiti.features.IRemoveBendpointFeature;
import org.eclipse.graphiti.features.IRemoveFeature;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.IAddBendpointContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.features.context.IMoveBendpointContext;
import org.eclipse.graphiti.features.context.IReconnectionContext;
import org.eclipse.graphiti.features.context.IRemoveBendpointContext;
import org.eclipse.graphiti.features.context.IRemoveContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.features.impl.DefaultAddBendpointFeature;
import org.eclipse.graphiti.features.impl.DefaultMoveBendpointFeature;
import org.eclipse.graphiti.features.impl.DefaultRemoveBendpointFeature;
import org.eclipse.graphiti.func.IDelete;
import org.eclipse.graphiti.func.IReconnection;
import org.eclipse.graphiti.func.IUpdate;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.pattern.CreateConnectionFeatureForPattern;
import org.eclipse.graphiti.pattern.DefaultFeatureProviderWithPatterns;
import org.eclipse.graphiti.pattern.IConnectionPattern;
import org.eclipse.graphiti.pattern.IPattern;
import org.eclipse.graphiti.pattern.ReconnectionFeatureForPattern;
import org.eclipse.graphiti.pattern.UpdateFeatureForPattern;
import org.eclipse.graphiti.ui.features.DefaultDeleteFeature;
import org.eclipse.ui.PlatformUI;
import org.osate.aadl2.Element;
import org.osate.aadl2.ModeTransition;
import org.osate.ge.diagrams.common.features.ComponentImplementationToTypeFeature;
import org.osate.ge.diagrams.common.features.ComponentToPackageFeature;
import org.osate.ge.diagrams.common.features.ConfigureInModesFeature;
import org.osate.ge.diagrams.common.features.DrillDownFeature;
import org.osate.ge.diagrams.common.features.GraphicalToTextualFeature;
import org.osate.ge.diagrams.common.features.LayoutDiagramFeature;
import org.osate.ge.diagrams.common.features.RenameModeTransitionFeature;
import org.osate.ge.diagrams.common.features.SetDerivedModesFeature;
import org.osate.ge.diagrams.common.features.SetInitialModeFeature;
import org.osate.ge.diagrams.common.features.SetModeTransitionTriggersFeature;
import org.osate.ge.diagrams.common.patterns.FeaturePattern;
import org.osate.ge.services.AadlFeatureService;
import org.osate.ge.services.AadlModificationService;
import org.osate.ge.services.AnchorService;
import org.osate.ge.services.BusinessObjectResolutionService;
import org.osate.ge.services.ConnectionCreationService;
import org.osate.ge.services.ConnectionService;
import org.osate.ge.services.DiagramModificationService;
import org.osate.ge.services.DiagramService;
import org.osate.ge.services.GraphicsAlgorithmCreationService;
import org.osate.ge.services.GraphicsAlgorithmManipulationService;
import org.osate.ge.services.HighlightingService;
import org.osate.ge.services.LayoutService;
import org.osate.ge.services.NamingService;
import org.osate.ge.services.PropertyService;
import org.osate.ge.services.PrototypeService;
import org.osate.ge.services.ShapeCreationService;
import org.osate.ge.services.ShapeService;
import org.osate.ge.services.StyleProviderService;
import org.osate.ge.services.StyleService;
import org.osate.ge.services.SubcomponentService;
import org.osate.ge.services.UserInputService;
import org.osate.ge.services.VisibilityService;
import org.osate.ge.services.impl.DefaultAadlFeatureService;
import org.osate.ge.services.impl.DefaultAadlModificationService;
import org.osate.ge.services.impl.DefaultAnchorService;
import org.osate.ge.services.impl.DefaultBusinessObjectResolutionService;
import org.osate.ge.services.impl.DefaultConnectionCreationService;
import org.osate.ge.services.impl.DefaultConnectionService;
import org.osate.ge.services.impl.DefaultDiagramModificationService;
import org.osate.ge.services.impl.DefaultGraphicsAlgorithmCreationService;
import org.osate.ge.services.impl.DefaultGraphicsAlgorithmManipulationService;
import org.osate.ge.services.impl.DefaultHighlightingService;
import org.osate.ge.services.impl.DefaultLayoutService;
import org.osate.ge.services.impl.DefaultNamingService;
import org.osate.ge.services.impl.DefaultPropertyService;
import org.osate.ge.services.impl.DefaultPrototypeService;
import org.osate.ge.services.impl.DefaultShapeCreationService;
import org.osate.ge.services.impl.DefaultShapeService;
import org.osate.ge.services.impl.DefaultStyleService;
import org.osate.ge.services.impl.DefaultSubcomponentService;
import org.osate.ge.services.impl.DefaultUserInputService;
import org.osate.ge.services.impl.DefaultVisibilityService;
import org.osate.ge.ui.util.impl.DefaultGhostPurger;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

public class AgeFeatureProvider extends DefaultFeatureProviderWithPatterns {
	private final IEclipseContext context;
	
	public AgeFeatureProvider(final IDiagramTypeProvider dtp) {
		super(dtp);
		setIndependenceSolver(new IndependenceProvider(this));
		
		// Create the eclipse context
		this.context = createEclipseContext();
	}
	
	private IEclipseContext createEclipseContext() {
		// Create objects for the context
		final BusinessObjectResolutionService bor = new DefaultBusinessObjectResolutionService(this);
		final DiagramService diagramService = (DiagramService)PlatformUI.getWorkbench().getActiveWorkbenchWindow().getService(DiagramService.class);
		final DefaultPropertyService propertyUtil = new DefaultPropertyService();
		final DefaultVisibilityService visibilityHelper = new DefaultVisibilityService(propertyUtil, bor, this);
		final DefaultGhostPurger ghostPurger = new DefaultGhostPurger(propertyUtil);
		final DefaultDiagramModificationService diagramModificationService = new DefaultDiagramModificationService(diagramService, ghostPurger, bor);
		final StyleProviderService styleProviderService = (StyleProviderService)PlatformUI.getWorkbench().getActiveWorkbenchWindow().getService(StyleProviderService.class);
		final DefaultNamingService namingService = new DefaultNamingService();
		final DefaultUserInputService userInputService = new DefaultUserInputService(bor);
		final DefaultAadlModificationService modificationService = new DefaultAadlModificationService(this);
		final DefaultGraphicsAlgorithmManipulationService graphicsAlgorithmUtil = new DefaultGraphicsAlgorithmManipulationService();
		final DefaultStyleService styleUtil = new DefaultStyleService(this, styleProviderService);
		final DefaultAnchorService anchorUtil = new DefaultAnchorService(propertyUtil);
		final DefaultLayoutService layoutService = new DefaultLayoutService(visibilityHelper, bor, this);
		final DefaultShapeService shapeHelper = new DefaultShapeService(propertyUtil, visibilityHelper, bor);
		final DefaultPrototypeService prototypeService = new DefaultPrototypeService(bor);
		final DefaultAadlFeatureService featureService = new DefaultAadlFeatureService(prototypeService, bor);
		final DefaultSubcomponentService subcomponentService = new DefaultSubcomponentService(prototypeService);
		final DefaultShapeCreationService shapeCreationService = new DefaultShapeCreationService(shapeHelper, propertyUtil, layoutService, this);
		final DefaultConnectionService connectionService = new DefaultConnectionService(anchorUtil, shapeHelper, bor, this);
		final DefaultConnectionCreationService connectionCreationService = new DefaultConnectionCreationService(connectionService, this);
		final DefaultGraphicsAlgorithmCreationService graphicsAlgorithmCreator = new DefaultGraphicsAlgorithmCreationService(styleUtil, featureService, subcomponentService, graphicsAlgorithmUtil);		
		final DefaultHighlightingService highlightingHelper = new DefaultHighlightingService(propertyUtil, styleUtil, bor, this);		
		
		// Create the eclipse context
		final Bundle bundle = FrameworkUtil.getBundle(getClass());	
		final IEclipseContext context =  EclipseContextFactory.getServiceContext(bundle.getBundleContext()).createChild();
		
		// Populate the context. 
		context.set(IFeatureProvider.class, this);
		context.set(BusinessObjectResolutionService.class, bor);
		context.set(DiagramService.class, diagramService);
		context.set(DiagramModificationService.class, diagramModificationService);
		context.set(StyleProviderService.class, styleProviderService);
		context.set(NamingService.class, namingService);
		context.set(UserInputService.class, userInputService);
		context.set(AadlModificationService.class, modificationService);
		context.set(GraphicsAlgorithmManipulationService.class, graphicsAlgorithmUtil);
		context.set(PropertyService.class, propertyUtil);
		context.set(LayoutService.class, layoutService);
		context.set(StyleService.class, styleUtil);
		context.set(AnchorService.class, anchorUtil);
		context.set(VisibilityService.class, visibilityHelper);
		context.set(ShapeService.class, shapeHelper);
		context.set(ShapeCreationService.class, shapeCreationService);
		context.set(AadlFeatureService.class, featureService);
		context.set(SubcomponentService.class, subcomponentService);
		context.set(PrototypeService.class, prototypeService);
		context.set(ConnectionService.class, connectionService);
		context.set(ConnectionCreationService.class, connectionCreationService);
		context.set(GraphicsAlgorithmCreationService.class, graphicsAlgorithmCreator);
		context.set(HighlightingService.class, highlightingHelper);
		
		return context;
	}
	
	protected IEclipseContext getContext() {
		return context;
	}
	
	/**
	 * Instantiates an object and injects the current context into it
	 * @param clazz
	 * @return
	 */
	protected final <T> T make(final Class<T> clazz) {
		return ContextInjectionFactory.make(clazz, context);
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
		features.add(make(ComponentImplementationToTypeFeature.class));
		features.add(make(ComponentToPackageFeature.class));
		features.add(make(GraphicalToTextualFeature.class));
		features.add(make(LayoutDiagramFeature.class));
		
		features.add(make(ConfigureInModesFeature.class));
		features.add(createSetInitialModeFeature(true));
		features.add(createSetInitialModeFeature(false));
		features.add(createSetDerivedModesFeature(true));
		features.add(createSetDerivedModesFeature(false));
		features.add(make(SetModeTransitionTriggersFeature.class));
	}
	
	private ICustomFeature createSetInitialModeFeature(final Boolean isInitial) {
		final IEclipseContext childCtx = getContext().createChild();
		childCtx.set("Is Initial", isInitial);
		return ContextInjectionFactory.make(SetInitialModeFeature.class, childCtx);
	}
	
	private ICustomFeature createSetDerivedModesFeature(final Boolean derivedModes) {
		final IEclipseContext childCtx = getContext().createChild();
		childCtx.set("Derived Modes", derivedModes);
		return ContextInjectionFactory.make(SetDerivedModesFeature.class, childCtx);
	}
	
	@Override
	public IUpdateFeature getUpdateFeature(IUpdateContext context) {	
		PictogramElement pictogramElement = context.getPictogramElement();
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
	
	private IPattern createFeaturePattern(final EClass featureType) {
		final IEclipseContext childCtx = getContext().createChild();
		childCtx.set("Feature Type", featureType);
		return ContextInjectionFactory.make(FeaturePattern.class, childCtx);
	}
	
	/**
	 * Creates and adds patterns related to AADL Features
	 */
	protected final void addAadlFeaturePatterns() {
		// Create the feature patterns
		for(final EClass featureType : FeaturePattern.getFeatureTypes()) {
			this.addPattern(createFeaturePattern(featureType));	
		}
	}
	
	@Override
	protected IDirectEditingFeature getDirectEditingFeatureAdditional(final IDirectEditingContext context) {
		final BusinessObjectResolutionService bor = getContext().get(BusinessObjectResolutionService.class);
		if(bor != null) {
			final Object bo = bor.getBusinessObjectForPictogramElement(context.getPictogramElement());
			if(bo instanceof ModeTransition) {
				return make(RenameModeTransitionFeature.class);
			}
		}

		return super.getDirectEditingFeatureAdditional(context);
	}
	
	protected boolean allowConnectionCreation(final IConnectionPattern conPattern) {
		return true;
	}
	
	/**
	 * Override of getCreateConnectionFeatures() that borrows code from DefaultFeatureProviderWithPatterns but allows connection creation to be disabled for a connection pattern by overriding allowConnectionCreation()
	 */
	@Override
	public ICreateConnectionFeature[] getCreateConnectionFeatures() {
		ICreateConnectionFeature[] ret = new ICreateConnectionFeature[0];
		List<ICreateConnectionFeature> retList = new ArrayList<ICreateConnectionFeature>();

		for (IConnectionPattern conPattern : getConnectionPatterns()) {
			if(allowConnectionCreation(conPattern)) {
				retList.add(new CreateConnectionFeatureForPattern(this, conPattern));
			}
		}

		ICreateConnectionFeature[] a = getCreateConnectionFeaturesAdditional();
		for (ICreateConnectionFeature element : a) {
			retList.add(element);
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
	// Currently only allow editing when working with AadlConnections
	// This will disable manipulating connections associated with flow specifications and other model elements
	
	private final IMoveBendpointFeature moveBendpointFeature = new DefaultMoveBendpointFeature(this) {
		@Override
		public boolean canMoveBendpoint(IMoveBendpointContext context) {
			return allowBendpointManipulation(context.getConnection());
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
	};
	
	@Override 
	public IRemoveBendpointFeature getRemoveBendpointFeature(final IRemoveBendpointContext context) {
		return removeBendpointFeature;
	}

	private boolean allowBendpointManipulation(final PictogramElement pe) {
		final BusinessObjectResolutionService bor = getContext().get(BusinessObjectResolutionService.class);
		return bor.getBusinessObjectForPictogramElement(pe) instanceof org.osate.aadl2.Connection;
	}
}
