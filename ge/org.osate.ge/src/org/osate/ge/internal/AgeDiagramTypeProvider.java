/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.internal;

import java.util.Objects;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.graphiti.dt.AbstractDiagramTypeProvider;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.tb.IToolBehaviorProvider;
import org.osate.ge.internal.services.AadlArrayService;
import org.osate.ge.internal.services.AadlFeatureService;
import org.osate.ge.internal.services.AadlModificationService;
import org.osate.ge.internal.services.AnchorService;
import org.osate.ge.internal.services.BusinessObjectResolutionService;
import org.osate.ge.internal.services.CachingService;
import org.osate.ge.internal.services.ColoringService;
import org.osate.ge.internal.services.ConnectionCreationService;
import org.osate.ge.internal.services.ConnectionService;
import org.osate.ge.internal.services.DiagramModificationService;
import org.osate.ge.internal.services.ExtensionRegistryService;
import org.osate.ge.internal.services.ExtensionService;
import org.osate.ge.internal.services.GhostingService;
import org.osate.ge.internal.services.GraphicsAlgorithmCreationService;
import org.osate.ge.internal.services.DiagramService;
import org.osate.ge.internal.services.GraphitiService;
import org.osate.ge.internal.services.LabelService;
import org.osate.ge.internal.services.LayoutService;
import org.osate.ge.internal.services.NamingService;
import org.osate.ge.internal.services.PropertyService;
import org.osate.ge.internal.services.PrototypeService;
import org.osate.ge.internal.services.QueryService;
import org.osate.ge.internal.services.RefactoringService;
import org.osate.ge.internal.services.InternalReferenceBuilderService;
import org.osate.ge.internal.services.SavedAadlResourceService;
import org.osate.ge.internal.services.SerializableReferenceService;
import org.osate.ge.internal.services.ShapeCreationService;
import org.osate.ge.internal.services.ShapeService;
import org.osate.ge.internal.services.StyleService;
import org.osate.ge.internal.services.SubcomponentService;
import org.osate.ge.internal.services.UiService;
import org.osate.ge.internal.services.UserInputService;
import org.osate.ge.internal.services.impl.DefaultAadlArrayService;
import org.osate.ge.internal.services.impl.DefaultAadlFeatureService;
import org.osate.ge.internal.services.impl.DefaultAadlModificationService;
import org.osate.ge.internal.services.impl.DefaultAnchorService;
import org.osate.ge.internal.services.impl.DefaultBusinessObjectResolutionService;
import org.osate.ge.internal.services.impl.DefaultCachingService;
import org.osate.ge.internal.services.impl.DefaultColoringService;
import org.osate.ge.internal.services.impl.DefaultConnectionCreationService;
import org.osate.ge.internal.services.impl.DefaultConnectionService;
import org.osate.ge.internal.services.impl.DefaultDiagramModificationService;
import org.osate.ge.internal.services.impl.DefaultExtensionService;
import org.osate.ge.internal.services.impl.DefaultGhostingService;
import org.osate.ge.internal.services.impl.DefaultGraphicsAlgorithmCreationService;
import org.osate.ge.internal.services.impl.DefaultGraphitiService;
import org.osate.ge.internal.services.impl.DefaultLabelService;
import org.osate.ge.internal.services.impl.DefaultLayoutService;
import org.osate.ge.internal.services.impl.DefaultNamingService;
import org.osate.ge.internal.services.impl.DefaultPropertyService;
import org.osate.ge.internal.services.impl.DefaultPrototypeService;
import org.osate.ge.internal.services.impl.DefaultQueryService;
import org.osate.ge.internal.services.impl.DefaultRefactoringService;
import org.osate.ge.internal.services.impl.DefaultSerializableReferenceService;
import org.osate.ge.internal.services.impl.DefaultShapeCreationService;
import org.osate.ge.internal.services.impl.DefaultShapeService;
import org.osate.ge.internal.services.impl.DefaultStyleService;
import org.osate.ge.internal.services.impl.DefaultSubcomponentService;
import org.osate.ge.internal.services.impl.DefaultUiService;
import org.osate.ge.internal.services.impl.DefaultUserInputService;
import org.osate.ge.internal.ui.util.impl.DefaultGhostPurger;
import org.osate.ge.services.ReferenceResolutionService;
import org.osate.ge.services.impl.DefaultReferenceResolutionService;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

public class AgeDiagramTypeProvider extends AbstractDiagramTypeProvider {
	private final IEclipseContext context;
	private DefaultSerializableReferenceService serializableReferenceService;
	private DefaultStyleService styleService;
	
	public AgeDiagramTypeProvider() {	
		final AgeFeatureProvider featureProvider = new AgeFeatureProvider(this);
		this.context = createEclipseContext(featureProvider);
		featureProvider.initialize(context);		
		setFeatureProvider(featureProvider);
	}
	
	private IEclipseContext createEclipseContext(final IFeatureProvider fp) {
		// Create the eclipse context
		final Bundle bundle = FrameworkUtil.getBundle(getClass());	
		final IEclipseContext context =  EclipseContextFactory.getServiceContext(bundle.getBundleContext()).createChild();
		
		// Create objects for the context
		final InternalReferenceBuilderService refBuilder = Objects.requireNonNull(context.get(InternalReferenceBuilderService.class), "Unable to retrieve ReferenceBuilderService");
		final SavedAadlResourceService savedAadlResourceService = Objects.requireNonNull(context.get(SavedAadlResourceService.class), "Unable to retrieve SavedAadlResourceService");
		final UiService uiService = new DefaultUiService(this);
		final CachingService cachingService = new DefaultCachingService();
		final BusinessObjectResolutionService bor = new DefaultBusinessObjectResolutionService(fp);
		final DiagramService internalDiagramService = Objects.requireNonNull(context.get(DiagramService.class), "Unable to retrieve DiagramService");
		final DefaultAadlArrayService arrayService = new DefaultAadlArrayService();
		final DefaultPropertyService propertyUtil = new DefaultPropertyService();
		final DefaultAnchorService anchorUtil = new DefaultAnchorService(propertyUtil);
		final DefaultGhostPurger ghostPurger = new DefaultGhostPurger(propertyUtil);
		final DefaultDiagramModificationService diagramModificationService = new DefaultDiagramModificationService(internalDiagramService, ghostPurger, refBuilder, bor);
		final DefaultNamingService namingService = new DefaultNamingService();
		final DefaultUserInputService userInputService = new DefaultUserInputService(bor);
		final DefaultAadlModificationService modificationService = new DefaultAadlModificationService(savedAadlResourceService, fp);
		final DefaultRefactoringService refactoringService = new DefaultRefactoringService(modificationService, diagramModificationService);
		final ExtensionService extensionService = new DefaultExtensionService(Objects.requireNonNull(context.get(ExtensionRegistryService.class), "Unable to retrieve ExtensionRegistryService"), context);
		serializableReferenceService = new DefaultSerializableReferenceService(extensionService, Objects.requireNonNull(context.get(InternalReferenceBuilderService.class), "Unable to retrieve ReferenceBuilderService"));
		final DefaultShapeService shapeHelper = new DefaultShapeService(serializableReferenceService, propertyUtil, bor);
		final ConnectionService connectionService = new DefaultConnectionService(anchorUtil, serializableReferenceService, shapeHelper, propertyUtil, bor, cachingService, extensionService, refBuilder, fp);
		final DefaultGhostingService ghostingService = new DefaultGhostingService(propertyUtil, connectionService, fp);
		styleService = new DefaultStyleService(fp);
		final DefaultLayoutService layoutService = new DefaultLayoutService(propertyUtil, shapeHelper, bor, fp);
		final DefaultPrototypeService prototypeService = new DefaultPrototypeService(bor);
		final DefaultAadlFeatureService featureService = new DefaultAadlFeatureService(prototypeService, bor);
		final DefaultSubcomponentService subcomponentService = new DefaultSubcomponentService(prototypeService);
		final DefaultShapeCreationService shapeCreationService = new DefaultShapeCreationService(shapeHelper, propertyUtil, layoutService, fp);		
		final DefaultConnectionCreationService connectionCreationService = new DefaultConnectionCreationService(connectionService, fp);
		final DefaultGraphicsAlgorithmCreationService graphicsAlgorithmCreator = new DefaultGraphicsAlgorithmCreationService(styleService, featureService, subcomponentService);		
		final DefaultColoringService highlightingHelper = new DefaultColoringService(shapeHelper, propertyUtil, bor, fp);		
		final DefaultLabelService labelService = new DefaultLabelService(propertyUtil, graphicsAlgorithmCreator, fp);
		final DefaultGraphitiService graphitiService = new DefaultGraphitiService(this, fp);
		final DefaultQueryService queryService = new DefaultQueryService(propertyUtil, connectionService, bor, refBuilder);
		
		// Populate the context.
		// This context is used by extensions so it should only contain objects which are part of the graphical editor's API or which 
		// are in internal package. It should not include Graphiti objects.
		context.set(ExtensionService.class, extensionService);
		context.set(UiService.class, uiService);
		context.set(CachingService.class, cachingService);
		context.set(SerializableReferenceService.class, serializableReferenceService);
		context.set(BusinessObjectResolutionService.class, bor);
		context.set(AadlArrayService.class, arrayService);
		context.set(DiagramModificationService.class, diagramModificationService);
		context.set(NamingService.class, namingService);
		context.set(UserInputService.class, userInputService);
		context.set(AadlModificationService.class, modificationService);
		context.set(RefactoringService.class, refactoringService);
		context.set(PropertyService.class, propertyUtil);
		context.set(LayoutService.class, layoutService);
		context.set(StyleService.class, styleService);
		context.set(AnchorService.class, anchorUtil);
		context.set(GhostingService.class, ghostingService);
		context.set(ShapeService.class, shapeHelper);
		context.set(ShapeCreationService.class, shapeCreationService);
		context.set(AadlFeatureService.class, featureService);
		context.set(SubcomponentService.class, subcomponentService);
		context.set(PrototypeService.class, prototypeService);
		context.set(ConnectionService.class, connectionService);
		context.set(ConnectionCreationService.class, connectionCreationService);
		context.set(GraphicsAlgorithmCreationService.class, graphicsAlgorithmCreator);
		context.set(ColoringService.class, highlightingHelper);
		context.set(LabelService.class, labelService);
		context.set(GraphitiService.class, graphitiService);
		context.set(QueryService.class, queryService);
		
		// Create Public Services
		context.set(ReferenceResolutionService.class, new DefaultReferenceResolutionService(serializableReferenceService));
				
		return context;
	}
	
	@Override
	public void dispose() {
		// Dispose of services that need disposing
		if(styleService != null) {
			styleService.dispose();
		}
		
		if(serializableReferenceService != null) {
			serializableReferenceService.dispose();
		}

		if(context != null) {
			context.dispose();
		}
		
		super.dispose();
	}
	
	@Override
	public boolean isAutoUpdateAtStartup() {
		return true;
	}	

	private IToolBehaviorProvider[] toolBehaviorProviders;
	
	@Override
    public IToolBehaviorProvider[] getAvailableToolBehaviorProviders() {
        if (toolBehaviorProviders == null) {
            toolBehaviorProviders = new IToolBehaviorProvider[] { ContextInjectionFactory.make(AgeToolBehaviorProvider.class, context) };
        }
        return toolBehaviorProviders;
    }
}
