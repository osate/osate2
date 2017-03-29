/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.internal.graphiti;

import java.util.Objects;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.graphiti.dt.AbstractDiagramTypeProvider;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.tb.IToolBehaviorProvider;
import org.osate.ge.internal.graphiti.diagram.GraphitiAgeDiagram;
import org.osate.ge.internal.query.QueryRunner;
import org.osate.ge.internal.query.QueryRunnerFactory;
import org.osate.ge.internal.services.AadlModificationService;
import org.osate.ge.internal.services.AadlPropertyService;
import org.osate.ge.internal.services.BusinessObjectResolutionService;
import org.osate.ge.internal.services.CachingService;
import org.osate.ge.internal.services.ColoringService;
import org.osate.ge.internal.services.DiagramModificationService;
import org.osate.ge.internal.services.ExtensionRegistryService;
import org.osate.ge.internal.services.ExtensionService;
import org.osate.ge.internal.services.DiagramService;
import org.osate.ge.internal.services.GraphitiService;
import org.osate.ge.internal.services.NamingService;
import org.osate.ge.internal.services.PropertyService;
import org.osate.ge.internal.services.QueryService;
import org.osate.ge.internal.services.RefactoringService;
import org.osate.ge.internal.services.InternalReferenceBuilderService;
import org.osate.ge.internal.services.SavedAadlResourceService;
import org.osate.ge.internal.services.ReferenceService;
import org.osate.ge.internal.services.ShapeService;
import org.osate.ge.internal.services.UiService;
import org.osate.ge.internal.services.UserInputService;
import org.osate.ge.internal.services.impl.DefaultAadlModificationService;
import org.osate.ge.internal.services.impl.DefaultAadlPropertyService;
import org.osate.ge.internal.services.impl.DefaultBusinessObjectResolutionService;
import org.osate.ge.internal.services.impl.DefaultCachingService;
import org.osate.ge.internal.services.impl.DefaultColoringService;
import org.osate.ge.internal.services.impl.DefaultDiagramModificationService;
import org.osate.ge.internal.services.impl.DefaultExtensionService;
import org.osate.ge.internal.services.impl.DefaultGraphitiService;
import org.osate.ge.internal.services.impl.DefaultNamingService;
import org.osate.ge.internal.services.impl.DefaultPropertyService;
import org.osate.ge.internal.services.impl.DefaultQueryService;
import org.osate.ge.internal.services.impl.DefaultRefactoringService;
import org.osate.ge.internal.services.impl.DefaultReferenceService;
import org.osate.ge.internal.services.impl.DefaultShapeService;
import org.osate.ge.internal.services.impl.DefaultUiService;
import org.osate.ge.internal.services.impl.DefaultUserInputService;
import org.osate.ge.internal.ui.editor.AgeDiagramBehavior;
import org.osate.ge.services.ReferenceResolutionService;
import org.osate.ge.services.impl.DefaultReferenceResolutionService;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

public class AgeDiagramTypeProvider extends AbstractDiagramTypeProvider {
	private final IEclipseContext context;
	private DefaultReferenceService serializableReferenceService;
	private IToolBehaviorProvider[] toolBehaviorProviders;
	
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
		final DefaultPropertyService propertyUtil = new DefaultPropertyService();
		final DefaultDiagramModificationService diagramModificationService = new DefaultDiagramModificationService(internalDiagramService, refBuilder, bor);
		final DefaultNamingService namingService = new DefaultNamingService();
		final DefaultUserInputService userInputService = new DefaultUserInputService(bor);
		final DefaultAadlModificationService modificationService = new DefaultAadlModificationService(savedAadlResourceService, fp);
		final DefaultRefactoringService refactoringService = new DefaultRefactoringService(modificationService, diagramModificationService);
		final ExtensionService extensionService = new DefaultExtensionService(Objects.requireNonNull(context.get(ExtensionRegistryService.class), "Unable to retrieve ExtensionRegistryService"), context);
		serializableReferenceService = new DefaultReferenceService(extensionService, cachingService, Objects.requireNonNull(context.get(InternalReferenceBuilderService.class), "Unable to retrieve ReferenceBuilderService"));
		final DefaultShapeService shapeHelper = new DefaultShapeService(serializableReferenceService, propertyUtil, bor);
	
		final QueryRunnerFactory queryRunnerFactory = new QueryRunnerFactory() {
			@Override
			public QueryRunner create() {
				return new QueryRunner(propertyUtil, bor, refBuilder);
			}			
		};
		
		final DefaultColoringService highlightingHelper = new DefaultColoringService(shapeHelper, propertyUtil, bor, fp);		
		final DefaultGraphitiService graphitiService = new DefaultGraphitiService(this, fp);
		final DefaultQueryService queryService = new DefaultQueryService(propertyUtil, bor, refBuilder);
		final DefaultAadlPropertyService aadlPropertyService = new DefaultAadlPropertyService(cachingService, this, propertyUtil, bor, queryRunnerFactory);
		
		// Populate the context.
		// This context is used by extensions so it should only contain objects which are part of the graphical editor's API or which 
		// are in internal package. It should not include Graphiti objects.
		context.set(ExtensionService.class, extensionService);
		context.set(UiService.class, uiService);
		context.set(CachingService.class, cachingService);
		context.set(ReferenceService.class, serializableReferenceService);
		context.set(BusinessObjectResolutionService.class, bor);
		context.set(DiagramModificationService.class, diagramModificationService);
		context.set(NamingService.class, namingService);
		context.set(UserInputService.class, userInputService);
		context.set(AadlModificationService.class, modificationService);
		context.set(RefactoringService.class, refactoringService);
		context.set(PropertyService.class, propertyUtil);
		context.set(ShapeService.class, shapeHelper);
		context.set(ColoringService.class, highlightingHelper);
		context.set(GraphitiService.class, graphitiService);
		context.set(QueryService.class, queryService);
		context.set(AadlPropertyService.class, aadlPropertyService);
		context.set(QueryRunnerFactory.class, queryRunnerFactory);
		context.set(GraphitiAgeDiagramProvider.class, new GraphitiAgeDiagramProvider() {
			@Override
			public GraphitiAgeDiagram getGraphitiAgeDiagram() {
				return ((AgeDiagramBehavior)getDiagramBehavior()).getGraphitiAgeDiagram();
			}
		});
		
		// Create Public Services
		context.set(ReferenceResolutionService.class, new DefaultReferenceResolutionService(serializableReferenceService));
				
		return context;
	}
	
	@Override
	public void dispose() {
		if(serializableReferenceService != null) {
			serializableReferenceService.dispose();
		}

		if(context != null) {
			context.dispose();
		}
		
		super.dispose();
	}
	
	@Override 
	public String getDiagramTitle() {
		return super.getDiagramTitle();
	}
	
	@Override
	public boolean isAutoUpdateAtStartup() {
		return true;
	}	
	
	@Override
    public IToolBehaviorProvider[] getAvailableToolBehaviorProviders() {
        if (toolBehaviorProviders == null) {
            toolBehaviorProviders = new IToolBehaviorProvider[] { ContextInjectionFactory.make(AgeToolBehaviorProvider.class, context) };
        }
        return toolBehaviorProviders;
    }
}
