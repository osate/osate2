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
package org.osate.ge.gef.ui.editor;

import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.emf.common.util.URI;
import org.eclipse.gef.mvc.fx.models.SelectionModel;
import org.eclipse.gef.mvc.fx.ui.parts.AbstractFXEditor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PartInitException;
import org.osate.ge.fx.DiagramEditorNode;
import org.osate.ge.gef.AgeModule;
import org.osate.ge.gef.ui.AgeUiModule;
import org.osate.ge.internal.AgeDiagramProvider;
import org.osate.ge.internal.diagram.runtime.AgeDiagram;
import org.osate.ge.internal.diagram.runtime.AgeDiagramUtil;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.DiagramSerialization;
import org.osate.ge.internal.diagram.runtime.botree.DefaultBusinessObjectNodeFactory;
import org.osate.ge.internal.diagram.runtime.botree.DefaultTreeUpdater;
import org.osate.ge.internal.diagram.runtime.botree.TreeUpdater;
import org.osate.ge.internal.diagram.runtime.updating.DefaultDiagramElementGraphicalConfigurationProvider;
import org.osate.ge.internal.diagram.runtime.updating.DiagramUpdater;
import org.osate.ge.internal.services.AadlModificationService;
import org.osate.ge.internal.services.ActionExecutor.ExecutionMode;
import org.osate.ge.internal.services.ActionService;
import org.osate.ge.internal.services.ExtensionRegistryService;
import org.osate.ge.internal.services.ProjectProvider;
import org.osate.ge.internal.services.ProjectReferenceService;
import org.osate.ge.internal.services.ReferenceService;
import org.osate.ge.internal.services.SystemInstanceLoadingService;
import org.osate.ge.internal.services.impl.ProjectReferenceServiceProxy;
import org.osate.ge.internal.ui.editor.DiagramContextChecker;
import org.osate.ge.services.QueryService;
import org.osate.ge.services.impl.DefaultQueryService;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import com.google.inject.Guice;
import com.google.inject.util.Modules;

import javafx.embed.swt.FXCanvas;
import javafx.scene.Scene;
import javafx.scene.image.Image;

// TODO: Implement selection notification..
// TODO: Rename to AgeDiagramEditor to match name of existing editor?
public class AgeEditor extends AbstractFXEditor {
	// TODO: Review names
	private final ReferenceService referenceService;
	private final ExtensionRegistryService extRegistry;
	private final QueryService queryService;
	private final SystemInstanceLoadingService systemInstanceLoader; // TODO: How to rework this to avoid needing. AADL specific
	private final AadlModificationService aadlModService; // TODO: Diagram Specific. AADL specific?
	private final ProjectReferenceService referenceResolver; // TODO: Diagram specific
	private final ActionService actionService;
	private final TreeUpdater boTreeExpander;
	private final DefaultDiagramElementGraphicalConfigurationProvider deInfoProvider;
	private final DiagramUpdater diagramUpdater;
	private IProject project;
	private AgeDiagram diagram;
	private ProjectProvider projectProvider = () -> project; // TODO
	private AgeDiagramProvider diagramProvider = () -> diagram; // TODO

	public AgeEditor() {
		super(Guice.createInjector(Modules.override(new AgeModule()).with(new AgeUiModule())));

		// TODO; Need to look at AgeDiagramTypeProvider... create diagram specific items.. TODO: Need to dispose objects as appropriate

		final Bundle bundle = FrameworkUtil.getBundle(getClass());
		IEclipseContext eclipseContext = EclipseContextFactory.getServiceContext(bundle.getBundleContext());

		// TODO; CLeanup "this."

		this.referenceService = Objects.requireNonNull(eclipseContext.get(ReferenceService.class),
				"unable to retrieve reference service service");
		this.extRegistry = Objects.requireNonNull(
				eclipseContext.get(ExtensionRegistryService.class),
				"Unable to retrieve extension registry");
		this.queryService = new DefaultQueryService(referenceService);
		this.aadlModService = Objects.requireNonNull(eclipseContext.get(AadlModificationService.class),
				"unable to retrieve AADL modification service");
		this.referenceResolver = new ProjectReferenceServiceProxy(referenceService, projectProvider);
		this.actionService = Objects.requireNonNull(eclipseContext.get(ActionService.class),
				"unable to retrieve action service");

		// Create the refresh diagram feature
		final DefaultBusinessObjectNodeFactory nodeFactory = new DefaultBusinessObjectNodeFactory(referenceResolver);
		boTreeExpander = new DefaultTreeUpdater(projectProvider, extRegistry, referenceResolver, queryService,
				nodeFactory);
		deInfoProvider = new DefaultDiagramElementGraphicalConfigurationProvider(referenceResolver, queryService,
				diagramProvider, extRegistry);
		diagramUpdater = new DiagramUpdater(boTreeExpander, deInfoProvider, actionService, referenceResolver,
				referenceResolver);
		systemInstanceLoader = Objects.requireNonNull(
				eclipseContext.get(SystemInstanceLoadingService.class),
				"unable to retrieve system instance loading service");
//		this.updateDiagramFeature = new UpdateDiagramFeature(this, actionService, graphitiService, diagramUpdater,
//				graphitiService, referenceResolver, systemInstanceLoader);
	}

	@Override
	public void init(final IEditorSite site, final IEditorInput input) throws PartInitException {
		super.init(site, input);

		if (!(input instanceof IFileEditorInput)) {
			throw new RuntimeException("Input must implement " + IFileEditorInput.class.getName());
		}

		// TODO: Cleanup
		// TODO: Rename
		final IFileEditorInput uriInput = (IFileEditorInput) input;
		final URI emfUri = URI.createPlatformResourceURI(uriInput.getFile().getFullPath().toString(), true);
		updateProjectByUri(emfUri);
		// TODO: Consider how project reference is handled in other editor.. file may be moved...
		final org.osate.ge.diagram.Diagram mmDiagram = DiagramSerialization
				.readMetaModelDiagram(emfUri);
		final Bundle bundle = FrameworkUtil.getBundle(getClass());
		final ExtensionRegistryService extRegistry = Objects.requireNonNull(
				EclipseContextFactory.getServiceContext(bundle.getBundleContext()).get(ExtensionRegistryService.class),
				"Unable to retrieve extension registry");

		diagram = DiagramSerialization.createAgeDiagram(project, mmDiagram, extRegistry);

		// Ensure the project is built. This prevents being unable to find the context due to the Xtext index not having completed.
		try {
			project.build(IncrementalProjectBuilder.INCREMENTAL_BUILD, new NullProgressMonitor());
		} catch (CoreException e) {
			throw new RuntimeException(e);
		}

		// Update the diagram to finish initializing the diagram's fields
		actionService.execute("Update on Load", ExecutionMode.HIDE, () -> {
			diagram.modify("Update Diagram", m -> {
				// Check the diagram's context
				// TODO
				final DiagramContextChecker contextChecker = new DiagramContextChecker(project,
						referenceResolver, systemInstanceLoader);
				final boolean workbenchIsVisible = true; // TODO isWorkbenchVisible();
				final DiagramContextChecker.Result result = contextChecker.checkContextFullBuild(diagram,
						workbenchIsVisible);

				if (!result.isContextValid()) {
					// If the workbench is not visible, then close the diagram to avoid an error which could have been avoided by relinking since
					// we only prompts to relink if the workbench is visible.
					if (!workbenchIsVisible) {
						// TODO
						// closeDiagramContainer();
					}

					final String refContextLabel = referenceResolver
							.getLabel(diagram.getConfiguration().getContextBoReference());

					// TODO
					throw new RuntimeException("Unable to resolve context: " + refContextLabel);
				}

				diagramUpdater.updateDiagram(diagram);
			});
			return null;
		});

		getContentViewer().getContents().setAll(diagram.getDiagramElements());
	}

	private void updateProjectByUri(final URI uri) {
		final IPath projectPath = new Path(uri.toPlatformString(true)).uptoSegment(1);
		final IResource projectResource = ResourcesPlugin.getWorkspace().getRoot().findMember(projectPath);
		if (!(projectResource instanceof IProject)) {
			throw new RuntimeException("Unable to determine project");
		}

		project = (IProject) projectResource;
	}

	// Provide access to the SWT widget. This should only be used for testing.
	@Override
	public FXCanvas getCanvas() {
		return super.getCanvas();
	}

	@Override
	public void createPartControl(final Composite parent) {
		super.createPartControl(parent);

		// Create SWT Menu for testing purposes. In reality it would be registered to accept contributions
		final FXCanvas canvas = getCanvas();
		final Menu testMenu = new Menu(canvas);
		canvas.setMenu(testMenu);

		final MenuItem miTest = new MenuItem(testMenu, SWT.NONE);
		miTest.setText("Test Menu Item");
		miTest.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				final SelectionModel selectionModel = getContentViewer().getAdapter(SelectionModel.class);
				final String selectionDescription = selectionModel.getSelectionUnmodifiable().stream()
						.map(cp -> cp.getContent()).filter(c -> c instanceof DiagramElement).map(de -> de.toString())
						.collect(Collectors.joining("\n"));
				MessageDialog.openInformation(canvas.getShell(), "Test",
						"Test Menu Item was selected.\nEditor Selection:\n" + selectionDescription);
			}
		});
	}

	@Override
	protected void hookViewers() {
		// TODO: Get extension service....

		// TODO: Check if diagram i s null?

		Object diagramBo = AgeDiagramUtil.getConfigurationContextBusinessObject(
				diagram, referenceResolver);
		if (diagramBo == null) {
			// TODO; Check project
			diagramBo = project;
		}

		final ImageProvider imageProvider = id -> {
			final String path = extRegistry.getImageIdToPathMap().get(id);
			if (path == null) {
				return Optional.empty();
			}

			// TODO:
			System.err.println(path);

			return Optional.of(new Image(path));
		};

		// TODO: Rename and review
		getCanvas()
				.setScene(new Scene(
						new DiagramEditorNode(new ActualPaletteModel(extRegistry.getPaletteContributors(),
								diagramBo, imageProvider),
								getContentViewer().getCanvas())));
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		// TODO
	}

	@Override
	public void doSaveAs() {
		// TODO
	}

	@Override
	public boolean isSaveAsAllowed() {
		// TODO
		return false;
	}

	@Override
	public Object getAdapter(@SuppressWarnings("rawtypes") Class required) {
		// TODO; Outline
//		if (IContentOutlinePage.class.equals(required)) {
//			if (outlinePage == null) {
//				outlinePage = new AgeContentOutlinePage(this, Adapters.adapt(this, ProjectProvider.class),
//						Adapters.adapt(this, ExtensionRegistryService.class),
//						Adapters.adapt(this, ProjectReferenceService.class));
//			}
//			return outlinePage;
//		}

		// TODO: Properties...

		// TODO: Other services

		return super.getAdapter(required);
	}

}
