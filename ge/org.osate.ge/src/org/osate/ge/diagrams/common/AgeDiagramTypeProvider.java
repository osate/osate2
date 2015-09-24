/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.diagrams.common;

import java.util.Objects;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.graphiti.dt.AbstractDiagramTypeProvider;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.tb.IToolBehaviorProvider;
import org.osate.ge.services.AadlArrayService;
import org.osate.ge.services.AadlFeatureService;
import org.osate.ge.services.AadlModificationService;
import org.osate.ge.services.AnchorService;
import org.osate.ge.services.BusinessObjectResolutionService;
import org.osate.ge.services.CachingService;
import org.osate.ge.services.ComponentImplementationService;
import org.osate.ge.services.ConnectionCreationService;
import org.osate.ge.services.ConnectionService;
import org.osate.ge.services.DiagramModificationService;
import org.osate.ge.services.DiagramService;
import org.osate.ge.services.ExtensionService;
import org.osate.ge.services.GhostingService;
import org.osate.ge.services.GraphicsAlgorithmCreationService;
import org.osate.ge.services.GraphicsAlgorithmManipulationService;
import org.osate.ge.services.ColoringService;
import org.osate.ge.services.LabelService;
import org.osate.ge.services.LayoutService;
import org.osate.ge.services.NamingService;
import org.osate.ge.services.PropertyService;
import org.osate.ge.services.PrototypeService;
import org.osate.ge.services.RefactoringService;
import org.osate.ge.services.SerializableReferenceService;
import org.osate.ge.services.ShapeCreationService;
import org.osate.ge.services.ShapeService;
import org.osate.ge.services.StyleService;
import org.osate.ge.services.SubcomponentService;
import org.osate.ge.services.ExtensionRegistryService;
import org.osate.ge.services.UiService;
import org.osate.ge.services.UserInputService;
import org.osate.ge.services.impl.DefaultAadlArrayService;
import org.osate.ge.services.impl.DefaultAadlFeatureService;
import org.osate.ge.services.impl.DefaultAadlModificationService;
import org.osate.ge.services.impl.DefaultAnchorService;
import org.osate.ge.services.impl.DefaultBusinessObjectResolutionService;
import org.osate.ge.services.impl.DefaultCachingService;
import org.osate.ge.services.impl.DefaultComponentImplementationService;
import org.osate.ge.services.impl.DefaultConnectionCreationService;
import org.osate.ge.services.impl.DefaultConnectionService;
import org.osate.ge.services.impl.DefaultDiagramModificationService;
import org.osate.ge.services.impl.DefaultExtensionService;
import org.osate.ge.services.impl.DefaultGhostingService;
import org.osate.ge.services.impl.DefaultGraphicsAlgorithmCreationService;
import org.osate.ge.services.impl.DefaultGraphicsAlgorithmManipulationService;
import org.osate.ge.services.impl.DefaultColoringService;
import org.osate.ge.services.impl.DefaultLabelService;
import org.osate.ge.services.impl.DefaultLayoutService;
import org.osate.ge.services.impl.DefaultNamingService;
import org.osate.ge.services.impl.DefaultPropertyService;
import org.osate.ge.services.impl.DefaultPrototypeService;
import org.osate.ge.services.impl.DefaultRefactoringService;
import org.osate.ge.services.impl.DefaultSerializableReferenceService;
import org.osate.ge.services.impl.DefaultShapeCreationService;
import org.osate.ge.services.impl.DefaultShapeService;
import org.osate.ge.services.impl.DefaultStyleService;
import org.osate.ge.services.impl.DefaultSubcomponentService;
import org.osate.ge.services.impl.DefaultUiService;
import org.osate.ge.services.impl.DefaultUserInputService;
import org.osate.ge.ui.util.impl.DefaultGhostPurger;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

public class AgeDiagramTypeProvider extends AbstractDiagramTypeProvider {
	private final IEclipseContext context;
	
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
		final UiService uiService = new DefaultUiService(this);
		final CachingService cachingService = new DefaultCachingService();
		final SerializableReferenceService serializableReferenceService = new DefaultSerializableReferenceService();
		final BusinessObjectResolutionService bor = new DefaultBusinessObjectResolutionService(fp);
		final ComponentImplementationService componentImplementationService = new DefaultComponentImplementationService();
		final DiagramService diagramService = Objects.requireNonNull(context.get(DiagramService.class), "Unable to retrieve DiagramService");
		final DefaultAadlArrayService arrayService = new DefaultAadlArrayService();
		final DefaultPropertyService propertyUtil = new DefaultPropertyService();
		final DefaultAnchorService anchorUtil = new DefaultAnchorService(propertyUtil);
		final DefaultGhostPurger ghostPurger = new DefaultGhostPurger(propertyUtil);
		final DefaultShapeService shapeHelper = new DefaultShapeService(serializableReferenceService, propertyUtil, bor);
		final ConnectionService connectionService = new DefaultConnectionService(anchorUtil, serializableReferenceService, shapeHelper, propertyUtil, bor, fp);
		final DefaultGhostingService ghostingService = new DefaultGhostingService(propertyUtil, connectionService, bor, fp);
		final DefaultDiagramModificationService diagramModificationService = new DefaultDiagramModificationService(diagramService, ghostPurger, bor);
		final DefaultNamingService namingService = new DefaultNamingService();
		final DefaultUserInputService userInputService = new DefaultUserInputService(bor);
		final DefaultAadlModificationService modificationService = new DefaultAadlModificationService(fp);
		final DefaultRefactoringService refactoringService = new DefaultRefactoringService(modificationService, diagramModificationService);
		final DefaultGraphicsAlgorithmManipulationService graphicsAlgorithmUtil = new DefaultGraphicsAlgorithmManipulationService();
		final ExtensionService extensionService = new DefaultExtensionService(Objects.requireNonNull(context.get(ExtensionRegistryService.class), "Unable to retrieve ExtensionRegistryService"), this, context);
		final DefaultStyleService styleUtil = new DefaultStyleService(fp, extensionService);
		final DefaultLayoutService layoutService = new DefaultLayoutService(propertyUtil, shapeHelper, bor, fp);
		final DefaultPrototypeService prototypeService = new DefaultPrototypeService(bor);
		final DefaultAadlFeatureService featureService = new DefaultAadlFeatureService(prototypeService, bor);
		final DefaultSubcomponentService subcomponentService = new DefaultSubcomponentService(prototypeService);
		final DefaultShapeCreationService shapeCreationService = new DefaultShapeCreationService(shapeHelper, propertyUtil, layoutService, fp);		
		final DefaultConnectionCreationService connectionCreationService = new DefaultConnectionCreationService(connectionService, fp);
		final DefaultGraphicsAlgorithmCreationService graphicsAlgorithmCreator = new DefaultGraphicsAlgorithmCreationService(styleUtil, featureService, subcomponentService, graphicsAlgorithmUtil);		
		final DefaultColoringService highlightingHelper = new DefaultColoringService(shapeHelper, propertyUtil, styleUtil, bor, fp);		
		final DefaultLabelService labelService = new DefaultLabelService(propertyUtil, graphicsAlgorithmCreator, fp);
				
		// Populate the context.
		context.set(IDiagramTypeProvider.class, this);
		context.set(IFeatureProvider.class, fp);
		context.set(ExtensionService.class, extensionService);
		context.set(UiService.class, uiService);
		context.set(CachingService.class, cachingService);
		context.set(SerializableReferenceService.class, serializableReferenceService);
		context.set(BusinessObjectResolutionService.class, bor);
		context.set(ComponentImplementationService.class, componentImplementationService);
		context.set(AadlArrayService.class, arrayService);
		context.set(DiagramModificationService.class, diagramModificationService);
		context.set(NamingService.class, namingService);
		context.set(UserInputService.class, userInputService);
		context.set(AadlModificationService.class, modificationService);
		context.set(RefactoringService.class, refactoringService);
		context.set(GraphicsAlgorithmManipulationService.class, graphicsAlgorithmUtil);
		context.set(PropertyService.class, propertyUtil);
		context.set(LayoutService.class, layoutService);
		context.set(StyleService.class, styleUtil);
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
		
		return context;
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
