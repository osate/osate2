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

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.Adapters;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.ListenerList;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.gef.fx.nodes.InfiniteCanvas;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.operations.UndoRedoActionGroup;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.osate.ge.gef.DiagramEditorNode;
import org.osate.ge.gef.ui.diagram.GefAgeDiagram;
import org.osate.ge.internal.AgeDiagramProvider;
import org.osate.ge.internal.diagram.runtime.AgeDiagram;
import org.osate.ge.internal.diagram.runtime.AgeDiagramUtil;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.DiagramModifier;
import org.osate.ge.internal.diagram.runtime.DiagramSerialization;
import org.osate.ge.internal.diagram.runtime.botree.DefaultBusinessObjectNodeFactory;
import org.osate.ge.internal.diagram.runtime.botree.DefaultTreeUpdater;
import org.osate.ge.internal.diagram.runtime.botree.TreeUpdater;
import org.osate.ge.internal.diagram.runtime.layout.DiagramElementLayoutUtil;
import org.osate.ge.internal.diagram.runtime.layout.LayoutInfoProvider;
import org.osate.ge.internal.diagram.runtime.updating.DefaultDiagramElementGraphicalConfigurationProvider;
import org.osate.ge.internal.diagram.runtime.updating.DiagramUpdater;
import org.osate.ge.internal.services.AadlModificationService;
import org.osate.ge.internal.services.ActionExecutor;
import org.osate.ge.internal.services.ActionExecutor.ExecutionMode;
import org.osate.ge.internal.services.ActionService;
import org.osate.ge.internal.services.ColoringService;
import org.osate.ge.internal.services.ExtensionRegistryService;
import org.osate.ge.internal.services.ExtensionRegistryService.RegisteredImage;
import org.osate.ge.internal.services.ModelChangeNotifier;
import org.osate.ge.internal.services.ModelChangeNotifier.ChangeListener;
import org.osate.ge.internal.services.ProjectProvider;
import org.osate.ge.internal.services.ProjectReferenceService;
import org.osate.ge.internal.services.ReferenceService;
import org.osate.ge.internal.services.SystemInstanceLoadingService;
import org.osate.ge.internal.services.UiService;
import org.osate.ge.internal.services.impl.DefaultActionService;
import org.osate.ge.internal.services.impl.DefaultColoringService;
import org.osate.ge.internal.services.impl.DefaultUiService;
import org.osate.ge.internal.services.impl.ProjectReferenceServiceProxy;
import org.osate.ge.internal.ui.editor.ActivateAgeEditorAction;
import org.osate.ge.internal.ui.editor.AgeContentOutlinePage;
import org.osate.ge.internal.ui.editor.DiagramContextChecker;
import org.osate.ge.internal.ui.editor.InternalDiagramEditor;
import org.osate.ge.internal.ui.tools.Tool;
import org.osate.ge.services.QueryService;
import org.osate.ge.services.ReferenceResolutionService;
import org.osate.ge.services.impl.DefaultQueryService;
import org.osate.ge.services.impl.DefaultReferenceResolutionService;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import javafx.embed.swt.FXCanvas;
import javafx.scene.Scene;
import javafx.scene.image.Image;

// TODO: Implement selection notification.
// TODO: Rename to AgeDiagramEditor to match name of existing editor?
// TODO: Implement public GraphicalEditor interface
public class AgeEditor extends EditorPart implements InternalDiagramEditor, ITabbedPropertySheetPageContributor {
	// TODO: Review names
	private final ModelChangeNotifier modelChangeNotifier;
	private final ReferenceService referenceService;
	private final ExtensionRegistryService extRegistry;
	private final QueryService queryService;
	private final SystemInstanceLoadingService systemInstanceLoader; // TODO: How to rework this to avoid needing. AADL specific
	private final AadlModificationService aadlModService; // TODO: Diagram Specific. AADL specific?
	private final ProjectReferenceService projectReferenceService; // TODO: Diagram specific
	private final ActionService actionService;
	private final ColoringService coloringService;
	private final TreeUpdater boTreeExpander;
	private final DefaultDiagramElementGraphicalConfigurationProvider deInfoProvider;
	private final DiagramUpdater diagramUpdater;
	private AgeDiagram diagram;
	private GefAgeDiagram gefDiagram; // TODO: Rename
	private IFile diagramFile;
	private IProject project;
	private ProjectProvider projectProvider = () -> project; // TODO
	private AgeDiagramProvider diagramProvider = () -> diagram; // TODO
	private FXCanvas fxCanvas;
	private InfiniteCanvas canvas; // TODO: Rename?
	private int cleanDiagramChangeNumber = -1; // The diagram change number of the "clean" diagram.
	private ActionExecutor actionExecutor;

	// TODO: Move to the other
	// TODO: Could encapsulate this and other fields?
	private boolean updateInProgress = false; // TODO: Move
	private boolean updateQueued = false; // Only access by ui thread // TODO: Move
	private boolean updateQueuedRequireVisible = false;
	private boolean updateWhenVisible = false;
	private volatile boolean dirtyModel = false;
	private volatile boolean forceUpdateOnNextModelChange = false; // TODO: Should this really be volatile? Probably
	private IEclipseContext serviceContext; // TODO: Rename?
	private boolean disposed = false;
	private ChangeListener modelChangeListener = new ChangeListener() {
		@Override
		public void afterModelChangeNotification() {
			final boolean requireVisible = !forceUpdateOnNextModelChange;
			forceUpdateOnNextModelChange = false; // Reset flag
			dirtyModel = true;
			updateDiagram(requireVisible);
		}
	};

	private PaintListener paintListener = e -> {
		if (updateWhenVisible) {
			updateDiagram(true);
			updateWhenVisible = false;
		}
	};

	public AgeEditor() {
		// TODO; Need to look at AgeDiagramTypeProvider... create diagram specific items.. TODO: Need to dispose objects as appropriate

		final Bundle bundle = FrameworkUtil.getBundle(getClass());
		this.serviceContext = EclipseContextFactory.getServiceContext(bundle.getBundleContext());

		// TODO; CLeanup "this."
		this.modelChangeNotifier = Objects.requireNonNull(serviceContext.get(ModelChangeNotifier.class),
				"unable to retrieve model change notifier");
		this.referenceService = Objects.requireNonNull(serviceContext.get(ReferenceService.class),
				"unable to retrieve reference service");
		this.extRegistry = Objects.requireNonNull(serviceContext.get(ExtensionRegistryService.class),
				"Unable to retrieve extension registry");
		this.queryService = new DefaultQueryService(referenceService);
		this.aadlModService = Objects.requireNonNull(serviceContext.get(AadlModificationService.class),
				"unable to retrieve AADL modification service");
		this.projectReferenceService = new ProjectReferenceServiceProxy(referenceService, projectProvider);
		this.actionService = Objects.requireNonNull(serviceContext.get(ActionService.class),
				"unable to retrieve action service");

		final DefaultBusinessObjectNodeFactory nodeFactory = new DefaultBusinessObjectNodeFactory(
				projectReferenceService);
		boTreeExpander = new DefaultTreeUpdater(projectProvider, extRegistry, projectReferenceService, queryService,
				nodeFactory);
		deInfoProvider = new DefaultDiagramElementGraphicalConfigurationProvider(projectReferenceService, queryService,
				diagramProvider, extRegistry);
		diagramUpdater = new DiagramUpdater(boTreeExpander, deInfoProvider, actionService, projectReferenceService,
				projectReferenceService);
		systemInstanceLoader = Objects.requireNonNull(serviceContext.get(SystemInstanceLoadingService.class),
				"unable to retrieve system instance loading service");

		adapterMap.put(UiService.class, new DefaultUiService(() -> this));
		adapterMap.put(ProjectReferenceService.class, projectReferenceService);
		adapterMap.put(ReferenceResolutionService.class,
				new DefaultReferenceResolutionService(projectReferenceService));

		// TODO; SHould GefAgeDiagram implement this service directly?
		this.coloringService = new DefaultColoringService(
				new org.osate.ge.internal.services.impl.DefaultColoringService.StyleRefresher() {
					@Override
					public void refreshDiagramColoring() {
						if (Display.getCurrent() != Display.getDefault()) {
							throw new RuntimeException("Invalid thread");
						}

						gefDiagram.refreshDiagramStyles();
					}

					@Override
					public void refreshColoring(final Collection<DiagramElement> diagramElements) {
						if (Display.getCurrent() != Display.getDefault()) {
							throw new RuntimeException("Invalid thread");
						}

						gefDiagram.refreshStyle(diagramElements);
					}
				});
	}

	@Override
	public void dispose() {
		try {
			this.modelChangeNotifier.removeChangeListener(modelChangeListener);

			if (gefDiagram != null) {
				gefDiagram.close();
				gefDiagram = null;
			}

			super.dispose();
		} finally {
			disposed = true;

			// Remove invalidated actions from the action service.
			actionService.invalidateInvalidActions();
		}
	}

	@Override
	public boolean isDisposed() {
		return disposed;
	}

	private class SelectionProvider implements ISelectionProvider {
		private final ListenerList<ISelectionChangedListener> listeners = new ListenerList<>();
		private IStructuredSelection selection; // TODO: Rename

		@Override
		public void setSelection(final ISelection selection) {
			// TODO: Create a new selection that just contains diagram elements? Update UI, etc?
			if (selection instanceof IStructuredSelection) {
				updateSelection((IStructuredSelection) selection);
			}
		}

		@Override
		public void addSelectionChangedListener(final ISelectionChangedListener listener) {
			listeners.add(listener);
		}

		@Override
		public void removeSelectionChangedListener(final ISelectionChangedListener listener) {
			listeners.remove(listener);
		}

		@Override
		public IStructuredSelection getSelection() {
			return this.selection;
		}

		// TODO: Document...should this be called when setSelection() is called? If it is called like the current version. Why have two method?
		public void updateSelection(final IStructuredSelection value) {
			if (!Objects.equals(selection, value)) {
				selection = value;
				final SelectionChangedEvent e = new SelectionChangedEvent(this, selection);
				for (final ISelectionChangedListener listener : listeners) {
					listener.selectionChanged(e);
				}
			}
		}
	};

	// TODO: Move
	private final SelectionProvider selectionProvider = new SelectionProvider();

	@Override
	public void init(final IEditorSite site, final IEditorInput input) throws PartInitException {
		setInput(input);
		setSite(site);

		site.setSelectionProvider(selectionProvider);

		// TODO test
		// TODO; UndoRedoActionGroup is deprecated?
		UndoRedoActionGroup historyActionGroup = new UndoRedoActionGroup(site, DefaultActionService.CONTEXT, true);
		historyActionGroup.fillActionBars(site.getActionBars());

		// TODO: Cleanup
		final URI emfUri = URI.createPlatformResourceURI(diagramFile.getFullPath().toString(), true);

		// TODO: Consider how project reference is handled in other editor.. file may be moved...
		final org.osate.ge.diagram.Diagram mmDiagram = DiagramSerialization.readMetaModelDiagram(emfUri);
		final Bundle bundle = FrameworkUtil.getBundle(getClass());
		final ExtensionRegistryService extRegistry = Objects.requireNonNull(
				EclipseContextFactory.getServiceContext(bundle.getBundleContext()).get(ExtensionRegistryService.class),
				"Unable to retrieve extension registry");

		final IProject project = getProject();
		diagram = DiagramSerialization.createAgeDiagram(project, mmDiagram, extRegistry);

		// Ensure the project is built. This prevents being unable to find the context due to the Xtext index not having completed.
		try {
			project.build(IncrementalProjectBuilder.INCREMENTAL_BUILD, new NullProgressMonitor());
		} catch (CoreException e) {
			throw new RuntimeException(e);
		}

		// Treat the current state of the diagram as clean.
		cleanDiagramChangeNumber = diagram.getCurrentChangeNumber();

		// Update the diagram to finish initializing the diagram's fields
		actionService.execute("Update on Load", ExecutionMode.HIDE, () -> {
			diagram.modify("Update Diagram", m -> {
				// Check the diagram's context
				// TODO
				final DiagramContextChecker contextChecker = new DiagramContextChecker(project, projectReferenceService,
						systemInstanceLoader);
				final boolean workbenchIsVisible = isWorkbenchVisible();
				final DiagramContextChecker.Result result = contextChecker.checkContextFullBuild(diagram,
						workbenchIsVisible);

				if (!result.isContextValid()) {
					// If the workbench is not visible, then close the diagram to avoid an error which could have been avoided by relinking since
					// we only prompts to relink if the workbench is visible.
					if (!workbenchIsVisible) {
						closeEditor();
					}

					final String refContextLabel = projectReferenceService
							.getLabel(diagram.getConfiguration().getContextBoReference());

					// TODO
					throw new RuntimeException("Unable to resolve context: " + refContextLabel);
				}

				diagramUpdater.updateDiagram(diagram);
			});
			return null;
		});

		// TODO: Must dispose:
		// Project Reference Serivce
		// Context - If any

		this.modelChangeNotifier.addChangeListener(modelChangeListener);

		// Set the initial selection to the diagram
		selectionProvider.updateSelection(new StructuredSelection(diagram));
	}

	@Override
	protected void setInput(final IEditorInput input) {
		if (!(input instanceof IFileEditorInput)) {
			throw new RuntimeException("Input must implement " + IFileEditorInput.class.getName());
		}

		super.setInput(input);

		final IFileEditorInput fileInput = (IFileEditorInput) input;
		this.diagramFile = fileInput.getFile();
		this.setPartName(this.diagramFile.getName());
		this.project = this.diagramFile.getProject();
	}

	@Override
	public void createPartControl(final Composite parent) {
		fxCanvas = new FXCanvas(parent, SWT.NONE); // TODO: Look at what GEF factory does?
		fxCanvas.addPaintListener(paintListener);

		// TODO: DOes any of this need to be disposed?
		final String menuId = "org.osate.ge.editor.AgeDiagramEditor"; // TODO: Rename cleanup
		final MenuManager menuManager = new MenuManager(menuId, menuId);
		menuManager.setRemoveAllWhenShown(true); // TODO?
		// manager.addMenuListener(getContextMenuListener()); // TODO
		final Menu testMenu = menuManager.createContextMenu(fxCanvas); // TODO: Rename
		fxCanvas.setMenu(testMenu);

		getEditorSite().registerContextMenu(menuId, menuManager, selectionProvider, false); // TODO: Check last argument

		// Initialize things
		// TODO: Get extension service....
		// TODO: Check if diagram i s null?

		Object diagramBo = AgeDiagramUtil.getConfigurationContextBusinessObject(diagram, projectReferenceService);
		if (diagramBo == null) {
			// TODO; Check project
			diagramBo = getProject(); // TODO
		}

		actionExecutor = (label, mode, action) -> {
			final boolean reverseActionWasSpecified = actionService.execute(label, mode, action);

			// If an action isn't running and the action is executing as normal, then activate the editor if the action is undoable.
			// This will ensure that when the action is undone, the editor will be switched to the one in which the action was performed.
			if (isEditorActive() && reverseActionWasSpecified && !actionService.isActionExecuting()
					&& mode == ExecutionMode.NORMAL) {
				actionService.execute("Activate Editor", ExecutionMode.APPEND_ELSE_HIDE,
						new ActivateAgeEditorAction(AgeEditor.this));
			}

			return reverseActionWasSpecified;
		};

		// TODO: Refresh dirty state

		// TODO; SHould this be part of GefAgeDiagram?
		diagram.setActionExecutor(actionExecutor);

		final AgeEditorPaletteModel.ImageProvider imageProvider = id -> {
			final RegisteredImage img = extRegistry.getImageMap().get(id);
			if (img == null) {
				return Optional.empty();
			}

			final URI imageUri = URI.createPlatformPluginURI("/" + img.plugin + "/" + img.path, true);
			if (CommonPlugin.asLocalURI(imageUri).isFile()) {
				return Optional.of(new Image(imageUri.toString()));
			} else {
				return Optional.empty();
			}
		};

		// TODO: Rename and review
		canvas = new InfiniteCanvas();
		fxCanvas.setScene(new Scene(new DiagramEditorNode(
				new AgeEditorPaletteModel(extRegistry.getPaletteContributors(), diagramBo, imageProvider), canvas)));
		gefDiagram = new GefAgeDiagram(diagram, coloringService, actionExecutor);
		canvas.getContentGroup().getChildren().add(gefDiagram.getNode());
		adapterMap.put(LayoutInfoProvider.class, gefDiagram);

		// TODO: Ook at docs
//		Register any global actions with the site's IActionBars.
//		Register any context menus with the site.
//		Register a selection provider with the site, to make it available to the workbench's ISelectionService (optional).

		final IOperationHistory history = PlatformUI.getWorkbench().getOperationSupport().getOperationHistory();
		history.addOperationHistoryListener(event -> {
			if (event.getOperation().hasContext(DefaultActionService.CONTEXT)) {
				refreshDirtyState();
			}
		});
	}

	@Override
	public void doSave(final IProgressMonitor monitor) {
		// TODO: Save
		cleanDiagramChangeNumber = diagram.getCurrentChangeNumber();
		firePropertyChange(PROP_DIRTY);
		refreshDirtyState();
	}

	private boolean isEditorActive() {
		final IWorkbenchSite site = getSite();
		if (site == null) {
			return false;
		}

		final IWorkbenchPage page = site.getPage();
		if (page == null) {
			return false;
		}

		return page.getActiveEditor() == this;
	}

	// Updates the diagram in the current thread if it is the display thread or asynchronous if it isn't
	private final Runnable updateDiagramRequireVisibleRunnable = () -> doUpdate(true);
	private final Runnable updateDiagramNoRequireVisibleRunnable = () -> doUpdate(false);

	private void updateDiagram(final boolean requireVisible) {
		final Runnable updateDiagramRunnable = requireVisible ? updateDiagramRequireVisibleRunnable
				: updateDiagramNoRequireVisibleRunnable;

		if (Display.getDefault().getThread() == Thread.currentThread()) {
			updateDiagramRunnable.run();
		} else {
			Display.getDefault().asyncExec(updateDiagramRunnable);
		}
	}

	private void doUpdate(final boolean requireVisible) {
		if (Display.getDefault().getThread() != Thread.currentThread()) {
			throw new RuntimeException("doUpdate() must be called from the UI thread");
		}

		// A mutex is not needed because this runnable and other code that access variables used by this runnable are ran in the display thread
		// Don't update if update is already in progress
		if (!updateInProgress) {
			updateQueued = false;
			updateInProgress = true;

			try {
				// Don't update unless the diagram is visible
				final boolean isVisible = fxCanvas != null && fxCanvas.isVisible();
				if (!requireVisible || isVisible) {
					// Update the entire diagram
					updateWhenVisible = false;
					dirtyModel = false;
					updateDiagram();
				} else {
					// Queue the update for when the control becomes visible
					updateWhenVisible = true;
				}

			} finally {
				updateInProgress = false;
			}

			// Check if an update has been queued
			if (updateQueued) {
				updateDiagram(updateQueuedRequireVisible);
			}
		} else {
			// Queue the update
			updateQueued = true;
			updateQueuedRequireVisible = updateQueuedRequireVisible && requireVisible;
		}
	}

	// TODO: Rename. are both of these actually needed?
	private boolean wasContextValid = true; // TODO: Rename
	private boolean diagramContextIsValid = true;

	@Override
	public void updateDiagram() {
		// Get the editor
		// Check the context
		Display.getCurrent().syncExec(() -> {
//				final boolean promptToRelink = fxCanvas.isVisible() && (wasContextValid
//								|| Boolean.TRUE.equals(context.getProperty(promptToRelinkMissingContextProperty)));
			// TODO: Need to replace with something equivilent to the old proprty
			final boolean promptToRelink = fxCanvas.isVisible() && wasContextValid;
			final DiagramContextChecker contextChecker = new DiagramContextChecker(project, projectReferenceService,
					systemInstanceLoader);
			final DiagramContextChecker.Result result = contextChecker.checkContextIncrementalBuild(diagram,
					promptToRelink);
			wasContextValid = result.isContextValid(); // Store for next execution
			setDiagramContextIsValid(result.isContextValid()); // Update editor with new state
		});

		System.err.println("UPDATE DIAGRAM");

		// Updating the diagram should not be part of the undo stack. The layout portion is not included in the action because
		// layout needs to be undoable.
		actionService.execute("Update Diagram", ExecutionMode.APPEND_ELSE_HIDE, () -> {
			// Update the diagram
			diagramUpdater.updateDiagram(diagram);

			// TODO: Review command and behavior. Need to wait until layout is updated?
			// Perform the layout as a separate operation because the sizes for the shapes are assigned by the Graphiti modification listener.
			diagram.modify("Layout Incrementally",
					m -> DiagramElementLayoutUtil.layoutIncrementally(diagram, m, gefDiagram));

			return null;
		});
	}

	private void setDiagramContextIsValid(final boolean value) {
		final boolean prevContextWasValid = diagramContextIsValid;
		diagramContextIsValid = value;
		if (diagramContextIsValid != prevContextWasValid) {
			Display.getDefault().asyncExec(() -> {
				// TODO: Is this needed?
				// getPaletteBehavior().refreshPalette();

				// Close the editor if the context isn't valid.
				if (!diagramContextIsValid) {
					closeEditor();
				}
			});
		}
	}

	// TODO: Rename
	private final void refreshDirtyState() {
		firePropertyChange(PROP_DIRTY);
	}

	@Override
	public void doSaveAs() {
		throw new UnsupportedOperationException("Save as not supported");
	}

	@Override
	public boolean isSaveAsAllowed() {
		return false;
	}

	@Override
	public boolean isDirty() {
		return cleanDiagramChangeNumber != diagram.getCurrentChangeNumber();
	}

	@Override
	public void setFocus() {
		fxCanvas.setFocus();
	}

	@Override
	public <T> T getAdapter(final Class<T> required) {
		// TODO: Be consistent. Move more to map
		if (required == IContentOutlinePage.class) {
			// TODO: Dspose of outline?
			if (outlinePage == null) {
				outlinePage = new AgeContentOutlinePage(this, Adapters.adapt(this, ProjectProvider.class),
						Adapters.adapt(this, ExtensionRegistryService.class),
						Adapters.adapt(this, ProjectReferenceService.class));
			}
			return required.cast(outlinePage);
		} else if (required == ColoringService.class) {
			return required.cast(coloringService);
		} else if (required == QueryService.class) {
			return required.cast(queryService);
		} else if (required == AgeDiagramProvider.class) {
			return required.cast(diagramProvider);
		} else if (required == AadlModificationService.class) {
			return required.cast(aadlModService);
		} else if (required == ProjectProvider.class) {
			return required.cast(projectProvider);
		} else if (required == IPropertySheetPage.class) {
			// TODO: Does this need to lazily initialized? Could do somewhere else?
			if (propertySheetPage == null) {
				this.propertySheetPage = new AgeTabbedPropertySheetPage(this);
			}
			return required.cast(this.propertySheetPage);
		} else {
			Object adapter = adapterMap.get(required);
			if (adapter == null) {
				adapter = serviceContext.get(required);
			}

			if (adapter != null) {
				return required.cast(adapter);
			}
		}

		return super.getAdapter(required);
	}

	private final Map<Class<?>, Object> adapterMap = new HashMap<>();

	private AgeContentOutlinePage outlinePage; // TODO: Move

	// TODO: For property sheet
	@Override
	public String getContributorId() {
		return "org.osate.ge.editor.AgeDiagramEditor"; // TODO: Should be constant
	}

	private AgeTabbedPropertySheetPage propertySheetPage; // TODO: Move

	// TODO: Review... dispose as appropriate, etc
	private static class AgeTabbedPropertySheetPage extends TabbedPropertySheetPage {
		private boolean disposed = false;
		private IWorkbenchPart part; // TODO: Review AgeDiagramBehavior.. used by selectPictogramElements

		public AgeTabbedPropertySheetPage(
				final ITabbedPropertySheetPageContributor tabbedPropertySheetPageContributor) {
			super(tabbedPropertySheetPageContributor);
		}

		@Override
		public void dispose() {
			super.dispose();
			disposed = true;
			part = null;
		}

		@Override
		public void selectionChanged(final IWorkbenchPart part, final ISelection selection) {
			if (!disposed) {
				super.selectionChanged(part, selection);
				this.part = part;
			}
		}
	}

	@Override
	public void selectDiagramElementsForBusinessObject(Object bo) {
		// TODO Auto-generated method stub
	}

	@Override
	public AgeDiagram getDiagram() {
		return diagram;
	}

	@Override
	public IProject getProject() {
		return project;
	}

	@Override
	public IFile getDiagramFile() {
		return diagramFile;
	}

	@Override
	public void forceDiagramUpdateOnNextModelChange() {
		this.forceUpdateOnNextModelChange = true;
	}

	private final Runnable updateNowIfModelHasChangedRunnable = () -> updateDiagram(false);

	@Override
	public void updateNowIfModelHasChanged() {
		if (dirtyModel) {
			final Display display = Display.getDefault();
			if (display == null || display.getThread() == Thread.currentThread()) {
				updateNowIfModelHasChangedRunnable.run();
			} else {
				display.syncExec(updateNowIfModelHasChangedRunnable);
			}
		}
	}

	@Override
	public void modifyDiagram(final String label, final DiagramModifier modifier) {
		diagram.modify(label, modifier);
	}

	@Override
	public DiagramUpdater getDiagramUpdater() {
		return diagramUpdater;
	}

	@Override
	public TreeUpdater getBoTreeUpdater() {
		return boTreeExpander;
	}

	@Override
	public void closeEditor() {
		getSite().getPage().closeEditor(this, false);
	}

	@Override
	public ActionExecutor getActionExecutor() {
		return actionExecutor;
	}

	@Override
	public void activateTool(final Tool tool) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deactivateActiveTool() {
		// TODO Auto-generated method stub
	}

	@Override
	public IAction getGlobalActionHandler(final String actionId) {
		final IEditorSite site = getEditorSite();
		if (site == null) {
			return null;
		}

		return site.getActionBars().getGlobalActionHandler(actionId);
	}

	@Override
	public Set<DiagramElement> getSelectedDiagramElements() {
		System.err.println("E");
		final IStructuredSelection selection = selectionProvider.getSelection();
		if (selection == null) {
			return Collections.emptySet();
		}

		final HashSet<DiagramElement> selectedElements = new HashSet<>();
		for (final Object s : selection) {
			if (s instanceof DiagramElement) {
				selectedElements.add((DiagramElement) s);
			}
		}

		return selectedElements;
	}

	@Override
	public void selectDiagramElements(final Collection<DiagramElement> diagramElements) {
		// TODO: Is this correct? Threading...
		System.err.println("A");
		selectionProvider.updateSelection(new StructuredSelection(diagramElements.toArray()));
	}

	@Override
	public void clearSelection() {
		System.err.println("B");
		// TODO: Implement: TODO: Is this ocrrect?
		selectDiagramElements(Collections.emptyList());
	}

	@Override
	public void addSelectionChangedListener(final ISelectionChangedListener listener) {
		// TODO
		System.err.println("C");
		selectionProvider.addSelectionChangedListener(listener);
	}

	@Override
	public boolean isEditable() {
		// TODO: Copy implementation from AgeDiagramEditor
		// return diagramContextIsValid;
		return true;
	}

	private static boolean isWorkbenchVisible() {
		return PlatformUI.getWorkbench() != null && PlatformUI.getWorkbench().getActiveWorkbenchWindow() != null
				&& PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell() != null
				&& PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell().isVisible();
	}

}
