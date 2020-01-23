/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
 * All Rights Reserved.
 * 
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 * 
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.ge.internal.graphiti;

import java.util.Objects;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.graphiti.dt.AbstractDiagramTypeProvider;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.platform.ga.IGraphicsAlgorithmRendererFactory;
import org.eclipse.graphiti.tb.IToolBehaviorProvider;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.ResourceManager;
import org.osate.ge.internal.AgeDiagramProvider;
import org.osate.ge.internal.diagram.runtime.layout.LayoutInfoProvider;
import org.osate.ge.internal.graphiti.services.GraphitiService;
import org.osate.ge.internal.graphiti.services.impl.DefaultColoringService;
import org.osate.ge.internal.graphiti.services.impl.DefaultGraphitiService;
import org.osate.ge.internal.services.ColoringService;
import org.osate.ge.internal.services.EditorProvider;
import org.osate.ge.internal.services.ExtensionRegistryService;
import org.osate.ge.internal.services.ExtensionService;
import org.osate.ge.internal.services.ProjectProvider;
import org.osate.ge.internal.services.ProjectReferenceService;
import org.osate.ge.internal.services.ReferenceService;
import org.osate.ge.internal.services.SystemInstanceLoadingService;
import org.osate.ge.internal.services.UiService;
import org.osate.ge.internal.services.impl.DefaultExtensionService;
import org.osate.ge.internal.services.impl.DefaultUiService;
import org.osate.ge.internal.services.impl.ProjectReferenceServiceProxy;
import org.osate.ge.services.QueryService;
import org.osate.ge.services.ReferenceResolutionService;
import org.osate.ge.services.impl.DefaultQueryService;
import org.osate.ge.services.impl.DefaultReferenceResolutionService;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

public class AgeDiagramTypeProvider extends AbstractDiagramTypeProvider {
	public static final String id = "org.osate.ge.aadlDiagramTypeProvider";
	private final IEclipseContext context;
	private final AgeGraphicsAlgorithmRendererFactory graphicsAlgorithmRendererFactory = new AgeGraphicsAlgorithmRendererFactory();
	private ProjectReferenceServiceProxy projectReferenceService;
	private IToolBehaviorProvider[] toolBehaviorProviders;
	private boolean disposed = false;

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
		final ReferenceService globalReferenceService = Objects.requireNonNull(context.get(ReferenceService.class), "Unable to retrieve global reference service");
		final ExtensionService extensionService = new DefaultExtensionService(Objects.requireNonNull(context.get(ExtensionRegistryService.class), "Unable to retrieve ExtensionRegistryService"), context);

		final DefaultGraphitiService graphitiService = new DefaultGraphitiService(this, fp);
		final UiService uiService = new DefaultUiService(graphitiService);
		projectReferenceService = new ProjectReferenceServiceProxy(globalReferenceService, graphitiService);
		final DefaultColoringService coloringService = new DefaultColoringService(graphitiService);
		final DefaultQueryService queryService = new DefaultQueryService(globalReferenceService);

		// Populate the context.
		// This context is used by extensions so it should only contain objects which are part of the graphical editor's API or which
		// are in internal package. It should not include Graphiti objects.
		context.set(ExtensionService.class, extensionService);
		context.set(UiService.class, uiService);
		context.set(ProjectReferenceService.class, projectReferenceService);
		context.set(ColoringService.class, coloringService);
		context.set(GraphitiService.class, graphitiService);
		context.set(ProjectProvider.class, graphitiService);
		context.set(EditorProvider.class, graphitiService);
		context.set(QueryService.class, queryService);
		context.set(GraphitiAgeDiagramProvider.class, graphitiService);
		context.set(AgeDiagramProvider.class, graphitiService);
		context.set(LayoutInfoProvider.class, graphitiService);

		// Create Public Services
		context.set(ReferenceResolutionService.class, new DefaultReferenceResolutionService(projectReferenceService));

		return context;
	}

	@Override
	public void dispose() {
		projectReferenceService.dispose();

		if(context != null) {
			context.dispose();
		}

		disposed = true;

		super.dispose();
	}

	@Override
	public boolean isAutoUpdateAtStartup() {
		// Disable auto updating on startup because the diagram is updated as part of the diagram loading process.
		return false;
	}

	public ColoringService getColoringService() {
		return context.get(ColoringService.class);
	}

	public SystemInstanceLoadingService getSystemInstanceLoader() {
		return context.get(SystemInstanceLoadingService.class);
	}

	public ProjectReferenceService getProjectReferenceService() {
		return projectReferenceService;
	}

	@Override
	public IToolBehaviorProvider[] getAvailableToolBehaviorProviders() {
		if (toolBehaviorProviders == null) {
			// Don't initialize tool behavior providers if the diagram type provider has already been disposed. Create
			// and empty array because this method must not return null
			if (disposed) {
				toolBehaviorProviders = new IToolBehaviorProvider[0];
			} else {
				toolBehaviorProviders = new IToolBehaviorProvider[] {
						ContextInjectionFactory.make(AgeToolBehaviorProvider.class, context) };
			}
		}
		return toolBehaviorProviders;
	}

	@Override
	public IGraphicsAlgorithmRendererFactory getGraphicsAlgorithmRendererFactory() {
		return graphicsAlgorithmRendererFactory;
	}

	public static ResourceManager getResources() {
		return JFaceResources.getResources();
	}
}
