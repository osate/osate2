/**
 * Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file).
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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.IOperationHistoryListener;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.ListenerList;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.gef.fx.nodes.InfiniteCanvas;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.contexts.IContextService;
import org.eclipse.ui.operations.UndoRedoActionGroup;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.statushandlers.StatusManager;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.CanonicalBusinessObjectReference;
import org.osate.ge.gef.AgeGefRuntimeException;
import org.osate.ge.gef.DiagramEditorNode;
import org.osate.ge.gef.palette.SimplePaletteItem;
import org.osate.ge.gef.ui.AgeGefUiPlugin;
import org.osate.ge.gef.ui.diagram.GefAgeDiagram;
import org.osate.ge.gef.ui.editor.Interaction.InteractionState;
import org.osate.ge.gef.ui.editor.overlays.Overlays;
import org.osate.ge.internal.AgeDiagramProvider;
import org.osate.ge.internal.diagram.runtime.AgeDiagram;
import org.osate.ge.internal.diagram.runtime.AgeDiagramUtil;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.DiagramModificationAdapter;
import org.osate.ge.internal.diagram.runtime.DiagramModificationListener;
import org.osate.ge.internal.diagram.runtime.DiagramModifier;
import org.osate.ge.internal.diagram.runtime.DiagramNode;
import org.osate.ge.internal.diagram.runtime.DiagramSerialization;
import org.osate.ge.internal.diagram.runtime.ModificationsCompletedEvent;
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
import org.osate.ge.internal.ui.editor.actions.CopyAction;
import org.osate.ge.internal.ui.editor.actions.PasteAction;
import org.osate.ge.internal.ui.editor.actions.SelectAllAction;
import org.osate.ge.internal.ui.handlers.AgeHandlerUtil;
import org.osate.ge.internal.ui.tools.ActivatedEvent;
import org.osate.ge.internal.ui.tools.DeactivatedEvent;
import org.osate.ge.internal.ui.tools.Tool;
import org.osate.ge.services.QueryService;
import org.osate.ge.services.ReferenceResolutionService;
import org.osate.ge.services.impl.DefaultQueryService;
import org.osate.ge.services.impl.DefaultReferenceResolutionService;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import com.google.common.collect.ImmutableList;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.embed.swt.FXCanvas;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.InputEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Transform;

/**
 * JavaFX/GEF based diagram editor implementation
 */
public class AgeEditor extends EditorPart implements InternalDiagramEditor, ITabbedPropertySheetPageContributor {
	public static final ImmutableList<Double> ZOOM_LEVELS = ImmutableList.of(.1, .2, .5, .75, 1.0, 1.25, 1.5, 2.0, 2.5,
			3.0, 4.0, 5.0, 7.5, 10.0);
	private static final String CONTRIBUTOR_ID = "org.osate.ge.editor.AgeDiagramEditor";
	private static final String CONTEXT_ID = "org.osate.ge.context";
	private static final String MENU_ID = CONTRIBUTOR_ID;
	private static final double DIAGRAM_PADDING = 16.0; // Padding around the diagram

	// Class which handles activation and deactivation of tools
	public class ToolHandler {
		private Tool activeTool = null;
		private ImmutableList<BusinessObjectContext> selectedBocs = ImmutableList.of();

		public void activate(final Tool tool) {
			Objects.requireNonNull(tool, "tool must not be null");

			// Deactivate the current tool
			if (activeTool != null) {
				deactivateActiveTool();
			}

			activeTool = tool;
			paletteModel.deactivateNonSelectItem();

			activeTool.activated(new ActivatedEvent(selectedBocs, diagram, aadlModService, getAdapter(UiService.class),
					coloringService));
		}

		public void deactivateActiveTool() {
			if (activeTool != null) {
				activeTool.deactivated(new DeactivatedEvent());
				activeTool = null;
				paletteModel.deactivateNonSelectItem();
			}
		}

		void setSelectedElements(final ImmutableList<BusinessObjectContext> newSelectedBocs) {
			// Ignore the selection if nothing has changed
			if (Objects.equals(this.selectedBocs, newSelectedBocs)) {
				return;
			}

			this.selectedBocs = newSelectedBocs;

			if (selectedBocs.isEmpty()) {
				return;
			}

			// Notify the active tool
			if (activeTool != null) {
				activeTool.selectionChanged(new org.osate.ge.internal.ui.tools.SelectionChangedEvent(selectedBocs));
			}
		}
	}

	/**
	 * Class for managing the editor's selection
	 */
	private class SelectionProvider implements ISelectionProvider {
		private final ListenerList<ISelectionChangedListener> listeners = new ListenerList<>();
		private IStructuredSelection currentSelection;

		@Override
		public void setSelection(final ISelection newSelection) {
			// Set our selection to the diagram nodes contained in the specified selection.
			if (newSelection instanceof IStructuredSelection) {
				final IStructuredSelection ss = (IStructuredSelection) newSelection;
				final List<?> selectedObjects = ss.toList();
				final IStructuredSelection newStructuredSelection = new StructuredSelection(selectedObjects.stream()
						.filter(DiagramNode.class::isInstance).map(DiagramNode.class::cast).distinct().toArray());

				// Update the current selection and notify listeners
				if (!Objects.equals(currentSelection, newStructuredSelection)) {
					currentSelection = newStructuredSelection;

					// Notify listeners
					final SelectionChangedEvent e = new SelectionChangedEvent(this, currentSelection);
					for (final ISelectionChangedListener listener : listeners) {
						listener.selectionChanged(e);
					}
				}
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
			return this.currentSelection;
		}
	};

	// Global Services
	private final ModelChangeNotifier modelChangeNotifier;
	private final ReferenceService referenceService;
	private final ExtensionRegistryService extRegistry;
	private final ActionService actionService;
	private final SystemInstanceLoadingService systemInstanceLoader;
	private final AadlModificationService aadlModService;
	private IEclipseContext eclipseContext;

	private boolean disposed = false;
	private AgeDiagram diagram;
	private GefAgeDiagram gefDiagram;
	private Overlays overlays;
	private IFile diagramFile;
	private IProject project;

	// Diagram-specific Services
	private final QueryService queryService;
	private final ColoringService coloringService;
	private final TreeUpdater boTreeUpdater;
	private final DefaultDiagramElementGraphicalConfigurationProvider deInfoProvider;
	private final DiagramUpdater diagramUpdater;
	private ProjectProvider projectProvider = () -> project;
	private AgeDiagramProvider diagramProvider = () -> diagram;
	private final ProjectReferenceServiceProxy projectReferenceService;
	private ActionExecutor actionExecutor;
	private final SelectionProvider selectionProvider = new SelectionProvider();
	private final Map<Class<?>, Object> adapterMap = new HashMap<>();

	private MenuManager contextMenuManager;
	private AgeContentOutlinePage outlinePage;
	private TabbedPropertySheetPage propertySheetPage;
	private FXCanvas fxCanvas;
	private InfiniteCanvas canvas;
	private int cleanDiagramChangeNumber = -1; // The diagram change number of the "clean" diagram.
	private AgeEditorPaletteModel paletteModel;
	private final ToolHandler toolHandler = new ToolHandler();
	private TooltipManager tooltipManager;
	private final List<InputEventHandler> inputEventHandlers = new ArrayList<>();
	private Interaction activeInteraction;
	private final ISelectionListener toolPostSelectionListener = (part, selection) -> {
		toolHandler.setSelectedElements(AgeHandlerUtil.getSelectedBusinessObjectContexts());
	};
	private final IPartListener partListener = new IPartListener() {
		@Override
		public void partDeactivated(IWorkbenchPart part) {
			if (part == AgeEditor.this) {
				tooltipManager.hideTooltip();
			}
		}

		@Override
		public void partClosed(IWorkbenchPart part) {
			if (part == AgeEditor.this) {
				tooltipManager.hideTooltip();
				final IWorkbenchSite site = getSite();
				if (site != null && site.getWorkbenchWindow() != null
						&& site.getWorkbenchWindow().getPartService() != null) {
					site.getWorkbenchWindow().getPartService().removePartListener(this);
				}
			}
		}

		@Override
		public void partOpened(IWorkbenchPart part) {
		}

		@Override
		public void partActivated(IWorkbenchPart part) {
		}

		@Override
		public void partBroughtToTop(IWorkbenchPart part) {
		}
	};
	private final IOperationHistoryListener operationHistoryListener = event -> {
		if (event.getOperation().hasContext(DefaultActionService.CONTEXT)) {
			fireDirtyPropertyChangeEvent();
		}
	};
	private final DoubleProperty zoom = new SimpleDoubleProperty(1.0) {
		@Override
		protected void invalidated() {
			final Bounds canvasBounds = canvas.getLayoutBounds();

			// Get the center point in diagram coordinates
			final double viewCenterX = (canvasBounds.getWidth() / 2 - canvas.getHorizontalScrollOffset())
					/ canvas.getContentTransform().getMxx();
			final double viewCenterY = (canvasBounds.getHeight() / 2 - canvas.getVerticalScrollOffset())
					/ canvas.getContentTransform().getMyy();

			// Adjust the scaling
			final double scaling = zoom.get();
			canvas.setContentTransform(new Affine(Transform.scale(scaling, scaling)));

			// Set a new horizontal and vertical scroll offset based on thew new scaling
			canvas.setHorizontalScrollOffset((canvasBounds.getWidth() / 2) - viewCenterX * scaling);
			canvas.setVerticalScrollOffset((canvasBounds.getHeight() / 2) - viewCenterY * scaling);
		}
	};

	// Resource change listener which updates the editor's input when the resource for the existing input is renamed and closed the editor
	// when the resource is deleted.
	private IResourceChangeListener resourceChangeListener = event -> {
		if (event.getType() != IResourceChangeEvent.POST_CHANGE) {
			return;
		}

		// Determine whether the diagram input has changed and store the new values. This is done here to avoid storing resource deltas
		// which may expire. Editor changes will be performed in the UI thread.
		final IResourceDelta rootDelta = event.getDelta();
		final IResourceDelta diagramDelta = rootDelta.findMember(getInput().getFile().getFullPath());
		final boolean removed;
		final IFile newDiagramFile;
		if (diagramDelta != null && diagramDelta.getKind() == IResourceDelta.REMOVED) {
			removed = (diagramDelta.getFlags() & IResourceDelta.MOVED_TO) == 0;

			// Find the resource for the new file
			final IPath newPath = diagramDelta.getMovedToPath();
			final IResource newResource = ResourcesPlugin.getWorkspace().getRoot().findMember(newPath);
			newDiagramFile = newResource instanceof IFile ? (IFile) newResource : null;
		} else {
			removed = false;
			newDiagramFile = null;
		}

		Display.getDefault().asyncExec(() -> {
			//
			// Handle Image Updates
			//
			if (gefDiagram != null) {
				gefDiagram.refreshImages();
			}

			//
			// Handle the diagram input update
			//
			if (removed) {
				// Close editor
				closeEditor();
			} else if (newDiagramFile != null) {
				setInput(new FileEditorInput(newDiagramFile));
			}
		});
	};

	// Fields related to handling model and diagram updates
	private boolean updateInProgress = false;
	private boolean updateQueued = false; // Only accessed by UI thread
	private boolean updateQueuedRequireVisible = false;
	private boolean updateWhenVisible = false;
	private volatile boolean dirtyModel = false;
	private volatile boolean forceUpdateOnNextModelChange = false;
	private boolean diagramContextWasValid = true;
	private boolean diagramContextIsValid = true;

	private ChangeListener modelChangeListener = new ChangeListener() {
		@Override
		public void afterModelChangeNotification() {
			final boolean requireVisible = !forceUpdateOnNextModelChange;
			forceUpdateOnNextModelChange = false; // Reset flag
			dirtyModel = true;
			updateDiagram(requireVisible);

			// In some cases, the property sheet page doesn't refresh. Although the model has changed the selected elements
			// have not. This forces the property sheet page to be updated.
			if (propertySheetPage != null && propertySheetPage.getCurrentTab() != null) {
				final IStructuredSelection selection = selectionProvider.getSelection();
				propertySheetPage.selectionChanged(AgeEditor.this, StructuredSelection.EMPTY);
				propertySheetPage.selectionChanged(AgeEditor.this, selection);
			}
		}
	};

	private PaintListener paintListener = e -> {
		if (updateWhenVisible) {
			updateDiagram(true);
			updateWhenVisible = false;
		}
	};

	private final DiagramModificationListener diagramModificationListener = new DiagramModificationAdapter() {
		@Override
		public void modificationsCompleted(final ModificationsCompletedEvent e) {
			// Refresh overlays in case the nodes representing the selected diagram elements have changed.
			if (overlays != null) {
				overlays.refresh(selectionProvider.getSelection());
			}
		}
	};

	public AgeEditor() {
		final Bundle bundle = FrameworkUtil.getBundle(getClass());
		this.eclipseContext = EclipseContextFactory.getServiceContext(bundle.getBundleContext());

		// Retrieve global services
		this.modelChangeNotifier = Objects.requireNonNull(eclipseContext.get(ModelChangeNotifier.class),
				"unable to retrieve model change notifier");
		this.referenceService = Objects.requireNonNull(eclipseContext.get(ReferenceService.class),
				"unable to retrieve reference service");
		this.extRegistry = Objects.requireNonNull(eclipseContext.get(ExtensionRegistryService.class),
				"Unable to retrieve extension registry");
		this.queryService = new DefaultQueryService(referenceService);
		this.aadlModService = Objects.requireNonNull(eclipseContext.get(AadlModificationService.class),
				"unable to retrieve AADL modification service");
		this.actionService = Objects.requireNonNull(eclipseContext.get(ActionService.class),
				"unable to retrieve action service");
		systemInstanceLoader = Objects.requireNonNull(eclipseContext.get(SystemInstanceLoadingService.class),
				"unable to retrieve system instance loading service");

		// Create diagram-specific services
		this.projectReferenceService = new ProjectReferenceServiceProxy(referenceService, projectProvider);
		final DefaultBusinessObjectNodeFactory nodeFactory = new DefaultBusinessObjectNodeFactory(
				projectReferenceService);
		boTreeUpdater = new DefaultTreeUpdater(projectProvider, extRegistry, projectReferenceService, queryService,
				nodeFactory);
		deInfoProvider = new DefaultDiagramElementGraphicalConfigurationProvider(projectReferenceService, queryService,
				diagramProvider, extRegistry);
		diagramUpdater = new DiagramUpdater(boTreeUpdater, deInfoProvider, actionService, projectReferenceService,
				projectReferenceService);
		this.coloringService = new DefaultColoringService(
				new org.osate.ge.internal.services.impl.DefaultColoringService.StyleRefresher() {
					@Override
					public void refreshDiagramColoring() {
						if (Display.getCurrent() != Display.getDefault()) {
							throw new AgeGefRuntimeException("Invalid thread");
						}

						gefDiagram.refreshDiagramStyles();
					}

					@Override
					public void refreshColoring(final Collection<DiagramElement> diagramElements) {
						if (Display.getCurrent() != Display.getDefault()) {
							throw new AgeGefRuntimeException("Invalid thread");
						}

						gefDiagram.refreshStyle(diagramElements);
					}
				});

		// Initialize the tooltip manager
		this.tooltipManager = new TooltipManager(extRegistry);

		// Initialize the outline and property sheet page
		outlinePage = new AgeContentOutlinePage(this, projectProvider, extRegistry, projectReferenceService);
		propertySheetPage = new TabbedPropertySheetPage(this);

		// Store editor specific adapters in the adapter map. Global services will be retrieved from the eclipse context.
		adapterMap.put(ColoringService.class, coloringService);
		adapterMap.put(QueryService.class, queryService);
		adapterMap.put(AgeDiagramProvider.class, diagramProvider);
		adapterMap.put(ProjectProvider.class, projectProvider);
		adapterMap.put(UiService.class, new DefaultUiService(() -> this));
		adapterMap.put(ProjectReferenceService.class, projectReferenceService);
		adapterMap.put(ReferenceResolutionService.class,
				new DefaultReferenceResolutionService(projectReferenceService));
		adapterMap.put(IContentOutlinePage.class, outlinePage);
		adapterMap.put(IPropertySheetPage.class, propertySheetPage);
	}

	@Override
	public void dispose() {
		try {
			// Remove listeners
			ResourcesPlugin.getWorkspace().removeResourceChangeListener(resourceChangeListener);
			PlatformUI.getWorkbench().getOperationSupport().getOperationHistory()
					.removeOperationHistoryListener(operationHistoryListener);
			getSite().getWorkbenchWindow().getSelectionService().removePostSelectionListener(toolPostSelectionListener);
			this.modelChangeNotifier.removeChangeListener(modelChangeListener);

			if (overlays != null) {
				selectionProvider.removeSelectionChangedListener(overlays);
			}

			if (diagram != null) {
				diagram.removeModificationListener(diagramModificationListener);
			}

			// Dispose of other objects
			if (gefDiagram != null) {
				gefDiagram.close();
				gefDiagram = null;
			}

			if (contextMenuManager != null) {
				contextMenuManager.removeAll();
				contextMenuManager.dispose();
			}

			projectReferenceService.dispose();
			outlinePage.dispose();
			propertySheetPage.dispose();
			adapterMap.clear();

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

	@Override
	public void init(final IEditorSite site, final IEditorInput input) throws PartInitException {
		setInput(input);
		setSite(site);

		// Register a resource change listener to handle moving and deleting the resource.
		ResourcesPlugin.getWorkspace().addResourceChangeListener(resourceChangeListener);

		site.getWorkbenchWindow().getSelectionService().addPostSelectionListener(toolPostSelectionListener);
		site.setSelectionProvider(selectionProvider);

		// Activate Context
		final IContextService contextService = site.getService(IContextService.class);
		if (contextService != null) {
			contextService.activateContext(CONTEXT_ID);
		}

		// Register actions for retargatable actions
		new UndoRedoActionGroup(site, DefaultActionService.CONTEXT, true).fillActionBars(site.getActionBars());
		registerAction(new CopyAction(this));
		registerAction(new PasteAction(this));
		registerAction(new SelectAllAction(this));

		// Load the diagram
		final org.osate.ge.diagram.Diagram mmDiagram = DiagramSerialization
				.readMetaModelDiagram(URI.createPlatformResourceURI(diagramFile.getFullPath().toString(), true));
		diagram = DiagramSerialization.createAgeDiagram(project, mmDiagram, extRegistry);

		// Ensure the project is built. This prevents being unable to find the context due to the Xtext index not having completed.
		try {
			project.build(IncrementalProjectBuilder.INCREMENTAL_BUILD, new NullProgressMonitor());
		} catch (CoreException e) {
			throw new AgeGefRuntimeException(e);
		}

		// Treat the current state of the diagram as clean.
		cleanDiagramChangeNumber = diagram.getCurrentChangeNumber();

		// Update the diagram to finish initializing the diagram's fields
		actionService.execute("Update on Load", ExecutionMode.HIDE, () -> {
			diagram.modify("Update Diagram", m -> {
				// Check the diagram's context
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

					throw new AgeGefRuntimeException("Unable to resolve context: " + refContextLabel);
				}

				diagramUpdater.updateDiagram(diagram);
			});
			return null;
		});

		this.modelChangeNotifier.addChangeListener(modelChangeListener);

		// Set the initial selection to the diagram
		selectionProvider.setSelection(new StructuredSelection(diagram));

		site.getWorkbenchWindow().getPartService().addPartListener(partListener);
		diagram.addModificationListener(diagramModificationListener);
	}

	private void registerAction(final IAction action) {
		getEditorSite().getActionBars().setGlobalActionHandler(action.getId(), action);

	}

	@Override
	protected void setInput(final IEditorInput input) {
		if (!(input instanceof IFileEditorInput)) {
			throw new AgeGefRuntimeException("Input must implement " + IFileEditorInput.class.getName());
		}

		super.setInput(input);

		final IFileEditorInput fileInput = (IFileEditorInput) input;
		this.diagramFile = fileInput.getFile();
		this.setPartName(this.diagramFile.getName());
		this.project = this.diagramFile.getProject();
	}

	private IFileEditorInput getInput() {
		final IEditorInput input = getEditorInput();
		if (!(input instanceof IFileEditorInput)) {
			throw new AgeGefRuntimeException("Unexpected editor input: " + input);
		}

		return (IFileEditorInput) input;
	}

	@Override
	public void createPartControl(final Composite parent) {
		//
		// Create the FX canvas which is an SWT widget for embedding JavaFX content.
		//
		fxCanvas = new FXCanvas(parent, SWT.NONE);
		fxCanvas.addPaintListener(paintListener);

		// Suppress SWT key press handling when interaction is active
		fxCanvas.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(final org.eclipse.swt.events.KeyEvent e) {
				if (activeInteraction != null) {
					e.doit = false;
				}
			}
		});

		fxCanvas.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				deactivateInteraction();
			}
		});

		// Create the context menu
		contextMenuManager = new MenuManager(MENU_ID, MENU_ID);
		contextMenuManager.setRemoveAllWhenShown(true);
		final Menu contextMenu = contextMenuManager.createContextMenu(fxCanvas);
		fxCanvas.setMenu(contextMenu);
		getEditorSite().registerContextMenu(MENU_ID, contextMenuManager, selectionProvider, true);

		// Create the action executor. It will append an action to activate the editor when undoing and redoing actions.
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

		// Initialize the palette model
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

		Object diagramBo = AgeDiagramUtil.getConfigurationContextBusinessObject(diagram, projectReferenceService);
		if (diagramBo == null) {
			diagramBo = project;
		}

		this.paletteModel = new AgeEditorPaletteModel(extRegistry.getPaletteContributors(), diagramBo, imageProvider);

		// If the palette item changes while an interaction is active, deactivate the interaction.
		this.paletteModel.activeItemProperty().addListener(
				(javafx.beans.value.ChangeListener<SimplePaletteItem>) (observable, oldValue, newValue) -> {
					deactivateInteraction();
				});

		// Initialize the JavaFX nodes based on the diagram
		canvas = new InfiniteCanvas();
		final Scene scene = new Scene(new DiagramEditorNode(paletteModel, canvas));
		fxCanvas.setScene(scene);
		gefDiagram = new GefAgeDiagram(diagram, coloringService);

		// Create a wrapper around the diagram's scene node. This wrapper adds padding around the diagram.
		final Group wrapper = new Group() {
			// The content bounds of the canvas will be set by the geometry bounds.
			// Create padding by creating a rectangle filled with a transparent color.
			final Rectangle invisibleBoundsRect = new Rectangle();
			{
				invisibleBoundsRect.setFill(Color.TRANSPARENT);
				getChildren().setAll(invisibleBoundsRect, gefDiagram.getSceneNode());
			}

			@Override
			protected void layoutChildren() {
				super.layoutChildren();

				if (getChildren().size() >= 2) {
					// Adjust size of rectangle. Right and bottom sides have more padding to allow for scroll bars.
					final Bounds diagramBounds = getChildren().get(1).getBoundsInParent();
					invisibleBoundsRect.setX(diagramBounds.getMinX() - DIAGRAM_PADDING);
					invisibleBoundsRect.setY(diagramBounds.getMinY() - DIAGRAM_PADDING);
					invisibleBoundsRect.setWidth(diagramBounds.getWidth() + DIAGRAM_PADDING * 3);
					invisibleBoundsRect.setHeight(diagramBounds.getHeight() + DIAGRAM_PADDING * 3);
				}
			}
		};

		// Add the wrapper to the canvas
		canvas.getContentGroup().getChildren().add(wrapper);

		gefDiagram.updateDiagramFromSceneGraph();
		adapterMap.put(LayoutInfoProvider.class, gefDiagram);

		// Create overlays
		overlays = new Overlays(gefDiagram);
		selectionProvider.addSelectionChangedListener(overlays);
		canvas.getScrolledOverlayGroup().getChildren().add(overlays);

		// Perform the initial incremental layout
		diagram.modify("Incremental Layout", m -> DiagramElementLayoutUtil.layoutIncrementally(diagram, m, gefDiagram));

		// Set action executor after initial load. This occurs after the incremental layout to prevent the loading and initial layout from being undoable
		diagram.setActionExecutor(actionExecutor);

		// Refresh the dirty state whenever an operation occurs
		final IOperationHistory history = PlatformUI.getWorkbench().getOperationSupport().getOperationHistory();
		history.addOperationHistoryListener(operationHistoryListener);

		canvas.setOnScroll(e -> {
			if (e.isControlDown()) {
				// Adjust zoom
				if (e.getDeltaY() < 0.0) {
					zoomOut();
				} else {
					zoomIn();
				}
			} else {
				if (e.isShiftDown()) {
					// Scroll in X direction
					canvas.setHorizontalScrollOffset(canvas.getHorizontalScrollOffset() - e.getDeltaY());
				} else { // Scroll
					canvas.setHorizontalScrollOffset(canvas.getHorizontalScrollOffset() - e.getDeltaX());
					canvas.setVerticalScrollOffset(canvas.getVerticalScrollOffset() + e.getDeltaY());
				}
			}
		});

		//
		// Listeners to handle tooltips
		//
		canvas.addEventHandler(MouseEvent.MOUSE_ENTERED_TARGET, e -> {
			if (e.getTarget() instanceof Node) {
				final DiagramElement de = gefDiagram.getDiagramElement((Node) e.getTarget());
				if (tooltipManager != null && de != null) {
					tooltipManager.mouseEnter(de);
				}
			}
		});

		canvas.addEventHandler(MouseEvent.MOUSE_EXITED_TARGET, e -> {
			if (e.getTarget() instanceof Node) {
				final DiagramElement de = gefDiagram.getDiagramElement((Node) e.getTarget());
				if (tooltipManager != null && de != null) {
					tooltipManager.mouseExit(de);
				}
			}
		});

		canvas.addEventFilter(MouseEvent.MOUSE_MOVED, e -> {
			if (tooltipManager != null) {
				tooltipManager.mouseMove(e.getScreenX(), e.getScreenY());
			}
		});

		//
		// General input handlers
		//
		// Event handler. Delegates to input event handlers or the active interaction as appropriate
		final EventHandler<? super InputEvent> handleInput = e -> {
			if (activeInteraction == null) {
				// Delegate processing of the event to the input event handlers
				for (final InputEventHandler inputEventHandler : inputEventHandlers) {
					final InputEventHandler.HandledEvent r = inputEventHandler.handleEvent(e);
					if (r != null) {
						activeInteraction = r.newInteraction;
						return;
					}
				}
			} else {
				if (activeInteraction.handleEvent(e) == InteractionState.COMPLETE) {
					deactivateInteraction();
				}
			}
		};

		// Handle mouse button presses
		canvas.addEventFilter(MouseEvent.MOUSE_PRESSED, handleInput);
		canvas.addEventFilter(MouseEvent.MOUSE_DRAGGED, handleInput);
		canvas.addEventFilter(MouseEvent.MOUSE_RELEASED, handleInput);
		scene.addEventFilter(KeyEvent.KEY_PRESSED, handleInput);
		canvas.addEventFilter(MouseEvent.MOUSE_MOVED, e -> {
			Cursor cursor = Cursor.DEFAULT;
			if (activeInteraction != null) {
				cursor = activeInteraction.getCursor(e);
			} else {
				for (final InputEventHandler inputEventHandler : inputEventHandlers) {
					final Cursor overrideCursor = inputEventHandler.getCursor(e);
					if (overrideCursor != null) {
						cursor = overrideCursor;
						break;
					}
				}
			}

			canvas.setCursor(cursor);

			handleInput.handle(e);
		});

		// Create input event handlers
		inputEventHandlers.add(new OpenPropertiesViewInputEventHandler(this));
		inputEventHandlers.add(new MarqueeSelectInputEventHandler(this));
		inputEventHandlers.add(new MoveConnectionPointTool(this));
		inputEventHandlers.add(new SelectAndRenameInputEventHandler(this));
		inputEventHandlers.add(new PaletteCommandInputEventHandler(this));
	}

	/**
	 * Deactivate the current interaction. If an interaction is not active then this function is a no-op.
	 */
	private void deactivateInteraction() {
		if (activeInteraction != null) {
			// Set the active interaction field to null to avoid events potentially causing this block to be executed
			// multiple times for the same interaction.
			final Interaction tmp = activeInteraction;
			activeInteraction = null;
			tmp.close();
			canvas.setCursor(Cursor.DEFAULT);
		}
	}

	/**
	 * Returns the {@link FXCanvas} which contains the JavaFX scene. Intended to be used only by tests.
	 * @return the {@link FXCanvas}.
	 */
	public final FXCanvas getFxCanvas() {
		return fxCanvas;
	}

	/**
	 * Returns the palette model.
	 * @return the palette model
	 */
	public final AgeEditorPaletteModel getPaletteModel() {
		return paletteModel;
	}

	/**
	 * The overlays scene graph node
	 * @return the overlays
	 */
	public final Overlays getOverlays() {
		return overlays;
	}

	/**
	 * Gets the scene node for a diagram node.
	 * @param dn the diagram node for which to get the scene node
	 * @return the scene node
	 */
	public final Node getSceneNode(final DiagramNode dn) {
		return gefDiagram.getSceneNode(dn);
	}

	/**
	 * Ensures a scene node which is inside the infinite canvas is visible. Must be called from the UI thread.
	 * @param sceneNode the scene node to reveal.
	 */
	public final void reveal(final Node sceneNode) {
		canvas.reveal(sceneNode);
	}

	public final DoubleProperty zoomProperty() {
		return zoom;
	}

	public double getZoom() {
		return zoom.get();
	}

	/**
	 * Sets the zoom level
	 * @param value the zoom level. In order for incremental zooming to work, the zoom level must be a value contained in {@link #ZOOM_LEVELS}
	 */
	public void setZoom(final double value) {
		zoom.set(value);
	}

	public void zoomIn() {
		final int newZoomLevelIndex = ZOOM_LEVELS.indexOf(getZoom()) + 1;
		if (newZoomLevelIndex > 0 && newZoomLevelIndex < ZOOM_LEVELS.size()) {
			setZoom(ZOOM_LEVELS.get(newZoomLevelIndex));
		}
	}

	public void zoomOut() {
		final int newZoomLevelIndex = ZOOM_LEVELS.indexOf(getZoom()) - 1;
		if (newZoomLevelIndex >= 0) {
			setZoom(ZOOM_LEVELS.get(newZoomLevelIndex));
		}
	}

	@Override
	public void doSave(final IProgressMonitor monitor) {
		try {
			final IFileEditorInput input = getInput();
			final IFile diagramFile = input.getFile();

			// Handle the diagram being read-only
			if (diagramFile.isReadOnly()) {
				final IStatus status = ResourcesPlugin.getWorkspace().validateEdit(new IFile[] { diagramFile },
						getSite().getShell());

				if (status.matches(IStatus.CANCEL) || !status.isOK() || diagramFile.isReadOnly()) {
					Display.getDefault().syncExec(() -> monitor.setCanceled(true));

					// Display error message in a subset of cases
					if (!status.isOK()) {
						StatusManager.getManager().handle(status, StatusManager.SHOW);
					} else if (diagramFile.isReadOnly()) {
						StatusManager.getManager().handle(
								new Status(IStatus.ERROR, AgeGefUiPlugin.PLUGIN_ID, "Diagram is read-only"),
								StatusManager.SHOW);
					}

					return;
				}
			}

			// Save the file
			DiagramSerialization.write(getProject(), diagram,
					URI.createPlatformResourceURI(diagramFile.getFullPath().toString(), true));

			// Clear Ghosts
			diagramUpdater.clearGhosts();

			// Store current change number
			cleanDiagramChangeNumber = diagram.getCurrentChangeNumber();
			fireDirtyPropertyChangeEvent();
		} catch (final Exception e) {
			Status errorStatus = new Status(IStatus.ERROR, AgeGefUiPlugin.PLUGIN_ID, 0, e.getMessage(), e);
			Display.getDefault().asyncExec(() -> new ErrorDialog(Display.getDefault().getActiveShell(),
					"Error Saving Diagram", "Unable to save diagram.", errorStatus, IStatus.ERROR).open());
			throw e;
		}
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

	// Updates the diagram in the current thread if it is the display thread or asynchronously if it isn't
	private void updateDiagram(final boolean requireVisible) {
		if (Display.getDefault().getThread() != Thread.currentThread()) {
			Display.getDefault().asyncExec(() -> updateDiagram(requireVisible));
			return;
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

	@Override
	public void updateDiagram() {
		// Check the context
		Display.getCurrent().syncExec(() -> {
			final boolean promptToRelink = fxCanvas.isVisible() && diagramContextWasValid;
			final DiagramContextChecker contextChecker = new DiagramContextChecker(project, projectReferenceService,
					systemInstanceLoader);
			final DiagramContextChecker.Result result = contextChecker.checkContextIncrementalBuild(diagram,
					promptToRelink);
			diagramContextWasValid = result.isContextValid(); // Store for next execution
			setDiagramContextIsValid(result.isContextValid()); // Update editor with new state
		});

		// Updating the diagram should not be part of the undo stack. The layout portion is not included in the action because
		// layout needs to be undoable.
		actionService.execute("Update Diagram", ExecutionMode.APPEND_ELSE_HIDE, () -> {
			// Update the diagram
			diagramUpdater.updateDiagram(diagram);

			// Perform the layout as a separate operation because the sizes for the shapes will not be set until the JavaFX nodes are updated.
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
				// Close the editor if the context isn't valid.
				if (!diagramContextIsValid) {
					closeEditor();
				}
			});
		}
	}

	private final void fireDirtyPropertyChangeEvent() {
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
		Object adapter = adapterMap.get(required);
		if (adapter == null) {
			adapter = eclipseContext.get(required);
		}

		if (adapter != null) {
			return required.cast(adapter);
		}

		return super.getAdapter(required);
	}

	/**
	 * Provide a contributor ID that matches the original graphical editor. If the editor ID is modified to match the original ID, this will
	 * no longer be necessary.
	 */
	@Override
	public String getContributorId() {
		return CONTRIBUTOR_ID;
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
		return boTreeUpdater;
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
		toolHandler.activate(tool);
	}

	@Override
	public void deactivateActiveTool() {
		toolHandler.deactivateActiveTool();
	}

	@Override
	public IAction getGlobalActionHandler(final String actionId) {
		final IEditorSite site = getEditorSite();
		if (site == null) {
			return null;
		}

		return site.getActionBars().getGlobalActionHandler(actionId);
	}

	/**
	 * Returns a new mutable list containing the diagram elements contained in the selection.
	 * @return the selected diagram elements.
	 */
	public List<DiagramElement> getSelectedDiagramElementList() {
		final IStructuredSelection selection = selectionProvider.getSelection();
		if (selection == null) {
			return Collections.emptyList();
		}

		final List<DiagramElement> selectedElements = new ArrayList<>(selection.size());
		for (final Object s : selection) {
			if (s instanceof DiagramElement) {
				selectedElements.add((DiagramElement) s);
			}
		}

		return selectedElements;
	}

	@Override
	public Set<DiagramElement> getSelectedDiagramElements() {
		return new HashSet<>(getSelectedDiagramElementList());
	}

	@Override
	public void selectDiagramNodes(final Collection<? extends DiagramNode> diagramNodes) {
		selectionProvider.setSelection(new StructuredSelection(diagramNodes.toArray()));
	}

	@Override
	public void selectDiagramElementsForBusinessObject(final Object bo) {
		final CanonicalBusinessObjectReference searchRef = referenceService.getCanonicalReference(bo);
		final List<DiagramElement> elementsForBo = diagram.getAllDiagramNodes().filter(DiagramElement.class::isInstance)
				.map(DiagramElement.class::cast)
				.filter(de -> Objects.equals(searchRef, referenceService.getCanonicalReference(de.getBusinessObject())))
				.collect(Collectors.toList());
		selectDiagramNodes(elementsForBo);
	}

	@Override
	public void clearSelection() {
		selectDiagramNodes(Collections.emptyList());

		if (outlinePage != null) {
			// Clear outline selection
			outlinePage.setSelection(null);
		}
	}

	GefAgeDiagram getGefDiagram() {
		return gefDiagram;
	}

	ReferenceService getReferenceService() {
		return referenceService;
	}

	AadlModificationService getAadlModificationService() {
		return aadlModService;
	}

	QueryService getQueryService() {
		return queryService;
	}

	ModelChangeNotifier getModelChangeNotifier() {
		return modelChangeNotifier;
	}

	@Override
	public void addSelectionChangedListener(final ISelectionChangedListener listener) {
		selectionProvider.addSelectionChangedListener(listener);
	}

	@Override
	public boolean isEditable() {
		return diagramContextIsValid;
	}

	private static boolean isWorkbenchVisible() {
		return PlatformUI.getWorkbench() != null && PlatformUI.getWorkbench().getActiveWorkbenchWindow() != null
				&& PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell() != null
				&& PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell().isVisible();
	}
}
