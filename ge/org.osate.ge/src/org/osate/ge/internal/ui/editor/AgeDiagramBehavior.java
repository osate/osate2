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
package org.osate.ge.internal.ui.editor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListener;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.impl.InternalTransactionalEditingDomain;
import org.eclipse.gef.ContextMenuProvider;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.Tool;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.editparts.ZoomManager;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.graphiti.IExecutionInfo;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IFeatureAndContext;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.context.impl.CustomContext;
import org.eclipse.graphiti.features.context.impl.UpdateContext;
import org.eclipse.graphiti.internal.command.DefaultExecutionInfo;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.editor.DefaultPaletteBehavior;
import org.eclipse.graphiti.ui.editor.DefaultPersistencyBehavior;
import org.eclipse.graphiti.ui.editor.DefaultRefreshBehavior;
import org.eclipse.graphiti.ui.editor.DiagramBehavior;
import org.eclipse.graphiti.ui.editor.IDiagramContainerUI;
import org.eclipse.graphiti.ui.editor.IDiagramEditorInput;
import org.eclipse.graphiti.ui.internal.action.DeleteAction;
import org.eclipse.graphiti.ui.internal.editor.GFCommandStack;
import org.eclipse.graphiti.ui.internal.services.GraphitiUiInternal;
import org.eclipse.graphiti.ui.platform.IConfigurationProvider;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.events.MouseTrackListener;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchSite;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.contexts.IContextService;
import org.eclipse.ui.internal.EditorSite;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.ui.statushandlers.StatusManager;
import org.eclipse.ui.views.contentoutline.ContentOutline;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.osate.ge.di.Names;
import org.osate.ge.graphics.Color;
import org.osate.ge.internal.Activator;
import org.osate.ge.internal.diagram.runtime.AgeDiagram;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.DiagramSerialization;
import org.osate.ge.internal.diagram.runtime.layout.DiagramElementLayoutUtil;
import org.osate.ge.internal.diagram.runtime.layout.LayoutInfoProvider;
import org.osate.ge.internal.graphiti.AgeDiagramTypeProvider;
import org.osate.ge.internal.graphiti.AgeFeatureProvider;
import org.osate.ge.internal.graphiti.GraphitiAgeDiagramProvider;
import org.osate.ge.internal.graphiti.LegacyDiagramUtil;
import org.osate.ge.internal.graphiti.LegacyGraphitiDiagramConverter;
import org.osate.ge.internal.graphiti.diagram.ColoringProvider;
import org.osate.ge.internal.graphiti.diagram.GraphitiAgeDiagram;
import org.osate.ge.internal.graphiti.features.AgeActionCustomFeature;
import org.osate.ge.internal.graphiti.features.AgeMoveShapeFeature;
import org.osate.ge.internal.services.ActionExecutor;
import org.osate.ge.internal.services.ActionExecutor.ExecutionMode;
import org.osate.ge.internal.services.ActionService;
import org.osate.ge.internal.services.ActionService.ActionStackChangeListener;
import org.osate.ge.internal.services.ColoringService;
import org.osate.ge.internal.services.DiagramService;
import org.osate.ge.internal.services.ExtensionRegistryService;
import org.osate.ge.internal.services.ExtensionService;
import org.osate.ge.internal.services.ModelChangeNotifier;
import org.osate.ge.internal.services.ModelChangeNotifier.ChangeListener;
import org.osate.ge.internal.ui.editor.actions.CopyAction;
import org.osate.ge.internal.ui.editor.actions.PasteAction;
import org.osate.ge.internal.ui.editor.actions.RedoAction;
import org.osate.ge.internal.ui.editor.actions.SelectAllAction;
import org.osate.ge.internal.ui.editor.actions.UndoAction;
import org.osate.ge.internal.ui.handlers.AgeHandlerUtil;
import org.osate.ge.internal.ui.util.ContextHelpUtil;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableList;

@SuppressWarnings("restriction")
public class AgeDiagramBehavior extends DiagramBehavior implements GraphitiAgeDiagramProvider {
	private GraphitiAgeDiagram graphitiAgeDiagram;
	private IProject project = null;
	private boolean updateInProgress = false;
	private boolean updateWhenVisible = false;
	private boolean updateQueued = false; // Only access by ui thread
	private boolean updateQueuedRequireVisible = false;
	private volatile boolean dirtyModel = false;
	private volatile boolean forceUpdateOnNextModelChange = false;
	private ToolHandler toolHandler;
	private ContextMenuProvider contextMenuProvider = null;
	private IResourceChangeListener resourceChangeListener;
	private AgeDiagram ageDiagram;
	private AgeTabbedPropertySheetPage propertySheetPage;
	private boolean diagramContextIsValid = true;
	private int cleanDiagramChangeNumber = -1; // The diagram change number of the "clean" diagram.
	private ActionExecutor actionExecutor;
	private ImmutableList<DiagramElement> diagramElementsToSelect; // A list of diagram elements that will be selected during the next refresh
	private PaintListener paintListener = e -> {
		if(updateWhenVisible) {
			updateDiagram(true);
			updateWhenVisible = false;
		}
	};

	private final ISelectionListener toolPostSelectionListener = (part, selection) -> {
		toolHandler.setSelectedElements(AgeHandlerUtil.getSelectedBusinessObjectContexts());
	};

	@Override
	protected void initConfigurationProvider(IDiagramTypeProvider diagramTypeProvider) {
		super.initConfigurationProvider(diagramTypeProvider);

		CommandStack commandStack = new AgeGFCommandStack(getConfigurationProvider(), getEditingDomain());
		getEditDomain().setCommandStack(commandStack);
	}

	// Custom command stack which handles moving connection bendpoints when moving multiple shapes.
	// Handle adjusting bendpoints when multiple shapes are moved. The default bendpoint shifting behavior is not suitable because there are bendpoints that
	// should be adjusted but would not be adjusted if each shape is handled separately.
	private class AgeGFCommandStack extends GFCommandStack {
		public AgeGFCommandStack(IConfigurationProvider configurationProvider,
				TransactionalEditingDomain editingDomain) {
			super(configurationProvider, editingDomain);
		}

		@Override
		public void execute(org.eclipse.gef.commands.Command gefCommand) {
			if (gefCommand != null) {
				final DefaultExecutionInfo executionInfo = new DefaultExecutionInfo();
				GraphitiUiInternal.getCommandService().completeExecutionInfo(executionInfo, gefCommand);

				final List<IMoveShapeContext> ctxs = getMoveShapeContexts(executionInfo);
				if (ctxs.size() > 0) {
					final Point delta = ctxs.stream().map(ctx -> new Point(ctx.getDeltaX(), ctx.getDeltaY())).findAny()
							.orElse(null);
					if (delta != null) {
						graphitiAgeDiagram.modify(gefCommand.getLabel(), m -> {
							super.execute(gefCommand);

							// Shift connection bendpoints and flow indicator positions
							DiagramElementLayoutUtil.shiftRelatedConnections(
									ctxs.stream().map(ctx -> ctx.getShape()).map(shape -> graphitiAgeDiagram
											.getDiagramElement(
													shape)),
									new org.osate.ge.graphics.Point(delta.x, delta.y), m, true, true, true);

							// Reset the positions of associated flow anchors. Flow anchors will be set after child shape positions are updated
							// by the GraphitiAgeDiagram
							DiagramElementLayoutUtil.resetFlowIndicatorsWithStartElementsPositions(m,
									ctxs.stream().filter(ctx -> {
										final Object daChanged = ctx.getProperty(AgeMoveShapeFeature.DOCK_AREA_CHANGED);
										return daChanged == null || daChanged == Boolean.TRUE;
									}).map(ctx -> ctx.getShape())
									.map(shape -> graphitiAgeDiagram.getDiagramElement(shape))
									.flatMap(DiagramElement::getAllDiagramNodes));
						});

						return;
					}
				}
			}

			super.execute(gefCommand);
		}
	}

	private static List<IMoveShapeContext> getMoveShapeContexts(final IExecutionInfo executionInfo) {
		final List<IMoveShapeContext> ctxs = new ArrayList<>();
		for (final IFeatureAndContext feature : executionInfo.getExecutionList()) {
			if (feature.getFeature() instanceof AgeMoveShapeFeature) {
				final IMoveShapeContext ctx = (IMoveShapeContext) feature.getContext();
				ctxs.add(ctx);
			}
		}

		return ctxs;
	}

	private final IPartListener toolPartListener = new IPartListener() {
		@Override
		public void partClosed(final IWorkbenchPart part) {
			if (getDiagramEditor() == part) {
				toolHandler.deactivateActiveTool();

				// Stop listening for part events
				getDiagramEditor().getSite().getWorkbenchWindow().getPartService().removePartListener(this);
			}
		}

		@Override
		public void partDeactivated(final IWorkbenchPart part) {
		}

		@Override
		public void partActivated(final IWorkbenchPart part) {
			if (getDiagramEditor() != part && !(part instanceof ContentOutline)) {
				toolHandler.deactivateActiveTool();
			}
		}

		@Override
		public void partBroughtToTop(final IWorkbenchPart part) {}

		@Override
		public void partOpened(final IWorkbenchPart part) {}
	};

	private ChangeListener modelChangeListener = new ChangeListener() {
		@Override
		public void afterModelChangeNotification() {
			final boolean requireVisible = !forceUpdateOnNextModelChange;
			forceUpdateOnNextModelChange = false; // Reset flag
			dirtyModel = true;
			updateDiagram(requireVisible);
		}
	};

	private final ActionStackChangeListener actionStackChangeListener = () -> {
		final IDiagramContainerUI diagramContainer = getDiagramContainer();
		if (diagramContainer != null) {
			diagramContainer.updateDirtyState();
		}
	};

	// Diagram change listener which refreshes the entire diagram. This is needed because there are cases where graphiti does not
	// correctly update the diagram after shapes are moved.
	private final ResourceSetListener diagramChangeListener = new ResourceSetListener() {
		@Override
		public NotificationFilter getFilter() {
			return NotificationFilter.NOT_TOUCH;
		}

		@Override
		public Command transactionAboutToCommit(ResourceSetChangeEvent event) throws RollbackException {
			return null;
		}

		@Override
		public void resourceSetChanged(final ResourceSetChangeEvent event) {
			getRefreshBehavior().initRefresh();
			refresh();
		}

		@Override
		public boolean isAggregatePrecommitListener() {
			return false;
		}

		@Override
		public boolean isPostcommitOnly() {
			return true;
		}

		@Override
		public boolean isPrecommitOnly() {
			return false;
		}
	};

	public AgeDiagramBehavior(final IDiagramContainerUI diagramContainer) {
		super(diagramContainer);
	}

	@Override
	protected void initActionRegistry(final ZoomManager zoomManager) {
		super.initActionRegistry(zoomManager);

		final IWorkbenchPart parentPart = getParentPart();
		if (!(parentPart instanceof AgeDiagramEditor)) {
			throw new RuntimeException("parent part must be an AgeDiagramEditor");
		}

		final AgeDiagramEditor editor = (AgeDiagramEditor) parentPart;
		registerAction(new CopyAction(editor));
		registerAction(new PasteAction(editor));
		registerAction(new UndoAction(editor));
		registerAction(new RedoAction(editor));
		registerAction(new SelectAllAction(editor));

		// Disable Graphiti's default delete action.
		final IDiagramContainerUI diagramContainer = getDiagramContainer();
		if (diagramContainer != null) {
			final IAction deleteAction = diagramContainer.getActionRegistry().getAction(DeleteAction.ACTION_ID);
			if (deleteAction != null) {
				diagramContainer.getActionRegistry().removeAction(deleteAction);
			}
		}
	}

	@Override
	public void configureGraphicalViewer() {
		super.configureGraphicalViewer();

		final AgeDiagramEditor editor = (AgeDiagramEditor)this.getParentPart();
		if(editor != null) {
			final ExtensionService extService = (ExtensionService)getAdapter(ExtensionService.class);

			// Register mouse listeners to handle tooltips
			class ToolTipHandler implements MouseMoveListener, MouseTrackListener, IPartListener {
				private Shell tooltipShell = null;
				private DiagramElement tooltipElement = null;
				private int tooltipCursorX = Integer.MIN_VALUE;
				private int tooltipCursorY = Integer.MIN_VALUE;
				private final int cursorMoveThreshold = 40;

				@Override
				public void mouseEnter(MouseEvent e) {
				}
				@Override
				public void mouseExit(MouseEvent e) {
					disposeCurrentToolTip();
				}

				@Override
				public void mouseHover(final MouseEvent e) {
					final PictogramElement hoverPe = getPictogramElementByControlCoordinates(e.x, e.y);
					final DiagramElement hoverElement = hoverPe == null ? null : graphitiAgeDiagram.getClosestDiagramElement(hoverPe);

					// Only show tooltips if a diagram element was found
					if(hoverElement != null) {
						if(hoverElement != tooltipElement || exceedsCursorMoveThreshold(e.x, e.y)) {
							disposeCurrentToolTip();

							if (hoverElement.getBusinessObject() != null) {
								tooltipElement = hoverElement;

								// Create new tooltip shell
								final Display display = Display.getCurrent();
								tooltipShell = new Shell(display.getActiveShell(), SWT.ON_TOP | SWT.TOOL | SWT.CENTER);
								tooltipShell.setVisible(false);
								tooltipShell.setBackground(display.getSystemColor(SWT.COLOR_INFO_BACKGROUND));
								tooltipShell.setBackgroundMode(SWT.INHERIT_FORCE);

								// Configure layout
								final GridLayout tooltipLayout = GridLayoutFactory.fillDefaults().create();
								tooltipLayout.marginLeft = 5;
								tooltipLayout.marginRight = 5;
								tooltipShell.setLayout(tooltipLayout);

								// Call tooltip contributors
								final IEclipseContext context = extService.createChildContext();
								try {
									context.set(Composite.class, tooltipShell);
									context.set(Names.BUSINESS_OBJECT, tooltipElement.getBusinessObject());
									context.set(Names.BUSINESS_OBJECT_CONTEXT, tooltipElement);
									for (final Object tooltipContributor : extService.getTooltipContributors()) {
										ContextInjectionFactory.invoke(tooltipContributor, org.osate.ge.di.Activate.class, context, null);
									}
								} finally {
									context.dispose();
								}

								// Show tooltip shell if something was contributed
								if (tooltipShell.getChildren().length > 0) {
									// Attempt to restrict the width of widget which are wider than the preferred maximum.
									for (final Control tooltipChild : tooltipShell.getChildren()) {
										final int maxTooltipWidth = 600;
										if (tooltipChild.computeSize(SWT.DEFAULT, SWT.DEFAULT).x > maxTooltipWidth) {
											tooltipChild.setLayoutData(
													GridDataFactory.fillDefaults().hint(maxTooltipWidth, SWT.DEFAULT)
													.create());
										}
									}

									final Point point = display.getCursorLocation();
									tooltipShell.setLocation(point.x, point.y+20);
									tooltipCursorX = e.x;
									tooltipCursorY = e.y;
									tooltipShell.pack(true);
									tooltipShell.setVisible(true);
								}
							}
						}
					}
				}

				@Override
				public void mouseMove(final MouseEvent e) {
					final PictogramElement movePe = getPictogramElementByControlCoordinates(e.x, e.y);
					final DiagramElement moveElement = movePe == null ? null : graphitiAgeDiagram.getClosestDiagramElement(movePe);
					if (tooltipShell != null && (movePe instanceof Diagram || moveElement != tooltipElement || exceedsCursorMoveThreshold(e.x, e.y))) {
						disposeCurrentToolTip();
					}
				}

				private void disposeCurrentToolTip() {
					if(tooltipShell != null) {
						tooltipShell.dispose();
					}

					tooltipShell = null;
					tooltipElement = null;
					tooltipCursorX = Integer.MIN_VALUE;
					tooltipCursorY = Integer.MIN_VALUE;
				}

				private boolean exceedsCursorMoveThreshold(final int cursorX, final int cursorY) {
					return (Math.abs(cursorX - tooltipCursorX) + Math.abs(cursorY - tooltipCursorY)) >= cursorMoveThreshold;
				}

				@Override
				public void partActivated(final IWorkbenchPart part) {
				}

				@Override
				public void partBroughtToTop(final IWorkbenchPart part) {

				}

				@Override
				public void partClosed(final IWorkbenchPart part) {
					if(part == editor) {
						disposeCurrentToolTip();

						// Unregister listeners
						if(editor.getGraphicalViewer() != null && editor.getGraphicalViewer().getControl() != null) {
							editor.getGraphicalViewer().getControl().removeMouseMoveListener(this);
							editor.getGraphicalViewer().getControl().removeMouseTrackListener(this);
						}

						if(editor.getSite() != null && editor.getSite().getWorkbenchWindow() != null && editor.getSite().getWorkbenchWindow().getPartService() != null) {
							editor.getSite().getWorkbenchWindow().getPartService().removePartListener(this);
						}
					}
				}

				@Override
				public void partDeactivated(final IWorkbenchPart part) {
					if(part == editor) {
						disposeCurrentToolTip();
					}
				}

				@Override
				public void partOpened(final IWorkbenchPart part) {
				}

			};

			// Instantiate tooltip handler and register listeners
			final ToolTipHandler toolTipHandler = new ToolTipHandler();
			editor.getGraphicalViewer().getControl().addMouseMoveListener(toolTipHandler);
			editor.getGraphicalViewer().getControl().addMouseTrackListener(toolTipHandler);
			editor.getSite().getWorkbenchWindow().getPartService().addPartListener(toolTipHandler);

			// Register an action for each tool
			toolHandler = new ToolHandler(extService, getPaletteBehavior());

			editor.getSite().getWorkbenchWindow().getSelectionService()
			.addPostSelectionListener(toolPostSelectionListener);
			toolHandler.setSelectedElements(AgeHandlerUtil.getSelectedBusinessObjectContexts());

			// Deactivate the tool when the part is deactivated or closed
			editor.getSite().getWorkbenchWindow().getPartService().addPartListener(toolPartListener);

			// Activate Context
			final IContextService contextService = editor.getSite().getService(IContextService.class);
			if (contextService != null) {
				contextService.activateContext("org.osate.ge.context");
			}
		}
	}

	public ActionExecutor getActionExecutor() {
		return actionExecutor;
	}

	public void activateTool(final Object tool) {
		toolHandler.activate(tool);
	}

	/**
	 * Gets the pictogram element based on a set of coordinates relative to the graphical viewer control
	 * @param controlX
	 * @param controlY
	 * @return
	 */
	private PictogramElement getPictogramElementByControlCoordinates(int controlX, int controlY) {
		final AgeDiagramEditor parentPart = getDiagramEditor();
		if(parentPart.getGraphicalViewer().getRootEditPart() instanceof GraphicalEditPart) {
			// Transform the control coordinates to diagram coordinates
			final GraphicalEditPart rootEditPart = (GraphicalEditPart)parentPart.getGraphicalViewer().getRootEditPart();
			final org.eclipse.draw2d.geometry.Point p = new org.eclipse.draw2d.geometry.Point(controlX, controlY);
			rootEditPart.getContentPane().translateToRelative(p);

			final EditPart ep = org.eclipse.graphiti.ui.internal.services.GraphitiUiInternal.getGefService().findEditPartAt(parentPart.getGraphicalViewer(), new org.eclipse.draw2d.geometry.Point(p.x, p.y), true);
			if(ep != null  && ep.getModel() instanceof PictogramElement) {
				return (PictogramElement)ep.getModel();
			}
		}

		return null;
	}

	public void deactivateActiveTool() {
		toolHandler.deactivateActiveTool();
	}

	@Override
	protected void addGefListeners() {
		super.addGefListeners();
		getContentEditPart().getViewer().getControl().addPaintListener(paintListener);
	}

	@Override
	protected void disposeAfterGefDispose() {
		try {
			super.disposeAfterGefDispose();

			getActionService().removeChangeListener(actionStackChangeListener);

			if (toolHandler != null) {
				toolHandler.dispose();
			}
		} finally {
			if (graphitiAgeDiagram != null) {
				graphitiAgeDiagram.close();
				graphitiAgeDiagram = null;
			}

			ageDiagram = null;
		}
	}

	private ActionService getActionService() {
		return Objects.requireNonNull(PlatformUI.getWorkbench().getService(ActionService.class),
				"Unable to retrieve action service");
	}

	private final Runnable updateNowIfModelHasChangedRunnable = () -> updateDiagram(false);

	public void updateNowIfModelHasChanged() {
		if(dirtyModel) {
			final Display display = Display.getDefault();
			if(display == null || display.getThread() == Thread.currentThread()) {
				updateNowIfModelHasChangedRunnable.run();
			} else {
				display.syncExec(updateNowIfModelHasChangedRunnable);
			}
		}
	}

	public void updateDiagramWhenVisible() {
		updateDiagram(true);
	}

	final Runnable updateDiagramRequireVisibleRunnable = () -> doUpdate(true);

	final Runnable updateDiagramNoRequireVisibleRunnable = () -> doUpdate(false);

	public void forceDiagramUpdateOnNextModelChange() {
		this.forceUpdateOnNextModelChange = true;
	}

	// Updates the diagram in the current thread if it is the display thread or asynchronous if it isn't
	private void updateDiagram(final boolean requireVisible) {
		final Runnable updateDiagramRunnable = requireVisible ? updateDiagramRequireVisibleRunnable : updateDiagramNoRequireVisibleRunnable;

		if(Display.getDefault().getThread() == Thread.currentThread()) {
			updateDiagramRunnable.run();
		} else {
			Display.getDefault().asyncExec(updateDiagramRunnable);
		}
	}

	private void doUpdate(final boolean requireVisible) {
		if(Display.getDefault().getThread() != Thread.currentThread()) {
			throw new RuntimeException("doUpdate() must be called from the UI thread");
		}

		// Reset active tool. Fixes exception if user was dragging.
		final DefaultEditDomain editDomain = getEditDomain();
		if (editDomain != null) {
			final Tool activeTool = editDomain.getActiveTool();
			if (activeTool != null) {
				editDomain.setActiveTool(null);
				editDomain.setActiveTool(activeTool);
			}
		}

		// A mutex is not needed because this runnable and other code that access variables used by this runnable are ran in the display thread
		// Don't update if update is already in progress
		if(!updateInProgress) {
			updateQueued = false;
			updateInProgress = true;

			try {
				// Don't update unless the diagram is visible
				final boolean isVisible = (getContentEditPart().getViewer().getControl() != null
						&& getContentEditPart().getViewer().getControl().isVisible());
				if (!requireVisible || isVisible) {
					// Update the entire diagram
					updateWhenVisible = false;
					dirtyModel = false;
					getDiagramTypeProvider().getNotificationService()
					.updatePictogramElements(new PictogramElement[] { getDiagramTypeProvider().getDiagram() });
					refresh();
				} else {
					// Queue the update for when the control becomes visible
					updateWhenVisible = true;
				}

			} finally {
				updateInProgress = false;
			}

			// Check if an update has been queued
			if(updateQueued) {
				updateDiagram(updateQueuedRequireVisible);
			}
		} else {
			// Queue the update
			updateQueued = true;
			updateQueuedRequireVisible = updateQueuedRequireVisible && requireVisible;
		}
	}

	@Override
	protected DefaultPaletteBehavior createPaletteBehaviour() {
		return new DefaultPaletteBehavior(this) {
			@Override
			public void refreshPalette() {
				super.refreshPalette();

				// Hide palette drawers if a tool is active or if the diagram context is invalid
				final boolean paletteIsDisabled = (toolHandler != null && toolHandler.isToolActive())
						|| !diagramContextIsValid;
				if (paletteIsDisabled) {
					final PaletteRoot root = getPaletteRoot();
					for(final Object child : root.getChildren()) {
						if(child instanceof PaletteDrawer) {
							final PaletteDrawer drawer = (PaletteDrawer)child;
							drawer.setVisible(false);
						}
					}
				}
			}
		};
	}

	@Override
	protected void registerDiagramResourceSetListener() {
		// Do not call super method. This diagram behavior has a custom diagram change listener.
		final TransactionalEditingDomain eDomain = getEditingDomain();
		eDomain.addResourceSetListener(diagramChangeListener);
	}

	@Override
	protected void unregisterDiagramResourceSetListener() {
		// Do not call super method. This diagram behavior has a custom diagram change listener.
		if (diagramChangeListener != null) {
			//diagramChangeListener.stopListening();
			final TransactionalEditingDomain editingDomain = getEditingDomain();
			if (editingDomain != null) {
				editingDomain.removeResourceSetListener(diagramChangeListener);
			}
		}
	}

	@Override
	protected void registerBusinessObjectsListener() {
		// Do not call super method

		// Add listener
		getModelChangeNotifier().addChangeListener(modelChangeListener);
	}

	@Override
	protected void unregisterBusinessObjectsListener() {
		// Do not call super method

		// Remove listener. Notifier may be null if there was a problem during initialization.
		final ModelChangeNotifier modelChangeNotifier = getModelChangeNotifier();
		if(modelChangeNotifier != null) {
			getModelChangeNotifier().removeChangeListener(modelChangeListener);
		}
	}

	private ModelChangeNotifier getModelChangeNotifier() {
		return (ModelChangeNotifier)getAdapter(ModelChangeNotifier.class);
	}

	@Override
	protected DefaultRefreshBehavior createRefreshBehavior() {
		return new DefaultRefreshBehavior(this) {
			@Override
			public void handleAutoUpdateAtStartup() {
				// Perform incremental layout on startup.
				final LayoutInfoProvider layoutInfoProvider = (LayoutInfoProvider) getDiagramTypeProvider()
						.getCurrentToolBehaviorProvider()
						.getAdapter(LayoutInfoProvider.class);
				ageDiagram.modify("Incremental Layout",
						m -> DiagramElementLayoutUtil.layoutIncrementally(ageDiagram, m, layoutInfoProvider));
			}

			@Override
			protected void autoUpdate() {
				IDiagramTypeProvider diagramTypeProvider = getDiagramTypeProvider();
				Diagram diagram = diagramTypeProvider.getDiagram();
				IFeatureProvider featureProvider = diagramTypeProvider.getFeatureProvider();
				IUpdateContext updateCtx = new UpdateContext(diagram);
				featureProvider.updateIfPossible(updateCtx);
				refresh();
			}

			@Override
			public void refresh() {
				if (Display.getCurrent() == null) {
					Display.getDefault().asyncExec(() -> refresh());
					return;
				}

				// Update the toolbars
				if(getDiagramContainer() instanceof EditorPart) {
					((EditorPart)getDiagramContainer()).getEditorSite().getActionBars().getToolBarManager().update(true);
				}

				super.refresh();

				selectBufferedDiagramElements();
			}
		};
	}

	private void selectBufferedDiagramElements() {
		if (diagramElementsToSelect != null) {
			// Get pictogram elements for the specified diagram elements
			final GraphitiAgeDiagram graphitiDiagram = getGraphitiAgeDiagram();
			final PictogramElement[] pes = diagramElementsToSelect.stream().map(graphitiDiagram::getPictogramElement)
					.filter(Predicates.notNull()).toArray(s -> new PictogramElement[s]);

			selectPictogramElements(pes);
			setDiagramElementsForSelection(null);
		}
	}

	public void setDiagramElementsForSelection(final ImmutableList<DiagramElement> value) {
		this.diagramElementsToSelect = value;
	}

	@Override
	public DefaultPersistencyBehavior getPersistencyBehavior() {
		return super.getPersistencyBehavior();
	}

	@Override
	protected ContextMenuProvider createContextMenuProvider() {
		return new ContextMenuProvider(getDiagramContainer().getGraphicalViewer()) {

			@Override
			public void buildContextMenu(final IMenuManager menu) {
			}
		};
	}

	// Disable registering of the context menu to allow disabling includeEditorInput in our overridden intiializeGraphicalViewer
	@Override
	protected boolean shouldRegisterContextMenu() {
		return false;
	}

	@Override
	protected void initializeGraphicalViewer() {
		super.initializeGraphicalViewer();

		final IWorkbenchPart parentPart = getParentPart();
		final GraphicalViewer graphicalViewer = getDiagramContainer().getGraphicalViewer();
		if (graphicalViewer != null && parentPart != null && parentPart.getSite() instanceof EditorSite) {
			// Register the context menu and disable includeEditorInput
			contextMenuProvider = createContextMenuProvider();
			graphicalViewer.setContextMenu(contextMenuProvider);
			((EditorSite) parentPart.getSite()).registerContextMenu(contextMenuProvider, graphicalViewer, false);

			// Register context sensitive help
			ContextHelpUtil.setHelp(graphicalViewer.getControl(), ContextHelpUtil.DIAGRAM_EDITOR);
		}
	}

	public void setDiagramContextIsValid(final boolean value) {
		final boolean prevContextWasValid = diagramContextIsValid;
		diagramContextIsValid = value;
		if (diagramContextIsValid != prevContextWasValid) {
			Display.getDefault().asyncExec(() -> {
				getPaletteBehavior().refreshPalette();

				// Close the editor if the context isn't valid.
				if (!diagramContextIsValid) {
					final IDiagramContainerUI container = getDiagramContainer();
					if (container != null) {
						container.close();
					}
				}
			});
		}
	}

	public boolean isEditable() {
		return diagramContextIsValid;
	}

	/**
	 * Returns the project in which the diagram is contained.
	 * @return
	 */
	public IProject getProject() {
		return project;
	}

	public IFile getFile() {
		final IDiagramEditorInput input = getInput();
		if(input == null) {
			return null;
		}

		final URI uri = input.getUri();
		if(uri == null) {
			return null;
		}

		final IResource resource = ResourcesPlugin.getWorkspace().getRoot().findMember(getPath(uri));
		if(!(resource instanceof IFile)) {
			return null;
		}

		return (IFile)resource;
	}

	private void updateProjectByUri(final URI uri) {
		final IPath projectPath = new Path(uri.toPlatformString(true)).uptoSegment(1);
		final IResource projectResource = ResourcesPlugin.getWorkspace().getRoot().findMember(projectPath);
		if(!(projectResource instanceof IProject)) {
			throw new RuntimeException("Unable to determine project");
		}

		project = (IProject)projectResource;
	}

// Prompts the user to convert the file if the input is a legacy(Graphiti) file.
	private void handleLegacyDiagramConversion(final IDiagramEditorInput input) {
		if(input != null) {
			final IResource resource = ResourcesPlugin.getWorkspace().getRoot().findMember(getPath(input.getUri()));
			if(!(resource instanceof IFile)) {
				throw new RuntimeException("Unable to retrieve file for resource.");
			}

			if(LegacyDiagramUtil.isLegacy((IFile)resource)) {
				// Only prompt for converting if the workbench window is already visible.
				// The primary purpose is to be prevent confusion by not prompting for conversion on the first load of the workspace after upgrading.
				if (isWorkbenchVisible()) {
					// The file is a legacy file
					// Prompt user as to whether to convert the file
					if(MessageDialog.openQuestion(null, "Conversion Required", "This diagram file uses a legacy file format which is not supported by this version of OSATE.\nDo you wish to convert the file to the latest format?\n\nConverted files will not be compatible with older versions of OSATE.\nThe original file will be removed after conversion.")) {
						final URI convertedDiagramUri = new LegacyGraphitiDiagramConverter().convertLegacyDiagram(input.getUri());
						input.updateUri(convertedDiagramUri);

						// If the resource was converted, delete the old resource
						try {
							resource.delete(true, null);
						} catch (CoreException e) {
							throw new RuntimeException(e);
						}
					} else {
						setEditorInitializationError("Unable to load diagram. This diagram file is stored in a legacy format. The diagram must be converted before it can be edited with this version of the OSATE Graphical Editor.");
						return;
					}
				} else {
					// Close the editor if the window isn't open. This usually occurs when eclipse is loading with legacy diagrams opened.
					closeDiagramContainer();
				}
			}
		}
	}

	private static boolean isWorkbenchVisible() {
		return PlatformUI.getWorkbench() != null && PlatformUI.getWorkbench().getActiveWorkbenchWindow() != null
				&& PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell() != null
				&& PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell().isVisible();
	}

	public boolean initializationFailed() {
		return getEditorInitializationError() != null;
	}

	@Override
	public void setInput(final IDiagramEditorInput input) {
		handleLegacyDiagramConversion(input);

		// Abort if initialization failed
		if(initializationFailed()) {
			return;
		}

		try {
			super.setInput(input);

			if (initializationFailed()) {
				return;
			}

			if (resourceChangeListener == null) {
				// Create and register a resource change listener. This listener is needed to handle moving and deleting of the resource file.
				// Graphiti's built-in support cannot be used because the editor has a custom persistency behavior that doesn't use EMF
				final IWorkspace workspace = ResourcesPlugin.getWorkspace();
				resourceChangeListener = event -> {
					if (event.getType() != IResourceChangeEvent.POST_CHANGE) {
						return;
					}

					final IResourceDelta rootDelta = event.getDelta();
					final IResourceDelta diagramDelta = rootDelta.findMember(getPath(getInput().getUri()));
					if (diagramDelta == null) {
						return;
					}

					if (diagramDelta.getKind() == IResourceDelta.REMOVED) {
						Display.getDefault().asyncExec(() -> {
							if ((diagramDelta.getFlags() & IResourceDelta.MOVED_TO) == 0) {
								// Close editor
								getDiagramContainer().close();
							} else {
								// Update the input's URI and refresh the title
								final IPath newPath = diagramDelta.getMovedToPath();
								final URI newUri = URI.createPlatformResourceURI(newPath.toString(), true);
								getInput().updateUri(newUri);
								updateProjectByUri(newUri);
								getDiagramContainer().refreshTitle();
							}
						});
					}
				};
				workspace.addResourceChangeListener(resourceChangeListener);
			}
		} catch (final InitializationException ex) {
			setEditorInitializationError(ex.getMessage());
		}
	}

	@Override
	protected void disposeBeforeGefDispose() {
		final AgeDiagramEditor editor = getDiagramEditor();
		if (editor != null) {
			// Remove listeners used for implementing tools
			editor.getSite().getWorkbenchWindow().getPartService().removePartListener(toolPartListener);
			editor.getSite().getWorkbenchWindow().getSelectionService()
			.removePostSelectionListener(toolPostSelectionListener);
		}

		// Unregister our resource change listener
		if(resourceChangeListener != null) {
			final IWorkspace workspace = ResourcesPlugin.getWorkspace();
			workspace.removeResourceChangeListener(resourceChangeListener);
		}

		// Dispose of the context menu provider
		if (contextMenuProvider != null) {
			contextMenuProvider.dispose();
			contextMenuProvider = null;
		}

		super.disposeBeforeGefDispose();
	}

	@Override
	protected DefaultPersistencyBehavior createPersistencyBehavior() {
		return new DefaultPersistencyBehavior(this) {
			@Override
			public Diagram loadDiagram(final URI uri) {
				updateProjectByUri(uri);
				final org.osate.ge.diagram.Diagram mmDiagram = DiagramSerialization.readMetaModelDiagram(uri);
				final Bundle bundle = FrameworkUtil.getBundle(getClass());
				final ExtensionRegistryService extRegistry = Objects.requireNonNull(EclipseContextFactory
						.getServiceContext(bundle.getBundleContext()).get(ExtensionRegistryService.class),
						"Unable to retrieve extension registry");

				ageDiagram = DiagramSerialization.createAgeDiagram(getProject(), mmDiagram, extRegistry);

				// Display warning if the diagram is stored with a newer version of the diagram file format.
				if(mmDiagram.getFormatVersion() > DiagramSerialization.FORMAT_VERSION) {
					MessageDialog.openWarning(Display.getCurrent().getActiveShell(),
							"Diagram Created with Newer Version of OSATE", "The diagram '" + uri.lastSegment()
							+ "' was created with a newer version of the OSATE. The diagram may not be correctly displayed. Saving the diagram with the running version of OSATE may result in the loss of diagram information.");
				}

				// Create an empty Graphiti diagram. It will be updated after in initDiagramTypeProvider() after the diagram type provider is initialized and
				// the required services are available.
				return Graphiti.getPeService().createDiagram(GraphitiAgeDiagram.AADL_DIAGRAM_TYPE_ID, "", true);
			}

			@Override
			protected Set<Resource> save(final TransactionalEditingDomain editingDomain, final Map<Resource, Map<?, ?>> saveOptions, final IProgressMonitor monitor) {
				try {
					// Get the resource
					final IResource resource = ResourcesPlugin.getWorkspace().getRoot().findMember(new Path(getInput().getUri().toPlatformString(true)));
					if(!(resource instanceof IFile)) {
						throw new RuntimeException("Unable to retrieve file for resource.");
					}

					final IFile diagramFile = (IFile) resource;

					// Handle the diagram being read-only
					if (diagramFile.isReadOnly()) {
						final IStatus status = ResourcesPlugin.getWorkspace().validateEdit(new IFile[] { diagramFile },
								getParentPart().getSite().getShell());

						if (status.matches(IStatus.CANCEL) || !status.isOK() || diagramFile.isReadOnly()) {
							Display.getDefault().syncExec(() -> monitor.setCanceled(true));

							// Display error message in a subset of cases
							if (!status.isOK()) {
								StatusManager.getManager().handle(status, StatusManager.SHOW);
							} else if (diagramFile.isReadOnly()) {
								StatusManager.getManager().handle(
										new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Diagram is read-only"),
										StatusManager.SHOW);
							}

							return Collections.emptySet();
						}
					}

					// Save the file
					DiagramSerialization.write(getProject(), ageDiagram, getInput().getUri());

					// Clear legacy persistent properties
					final DiagramService diagramService = Objects.requireNonNull((DiagramService)getAdapter(DiagramService.class), "unable to retrieve diagram service");
					diagramService.clearLegacyPersistentProperties(resource);

					// Clear Ghosts
					final AgeFeatureProvider fp = (AgeFeatureProvider)getDiagramTypeProvider().getFeatureProvider();
					fp.getDiagramUpdater().clearGhosts();

					// Store current change number
					cleanDiagramChangeNumber = ageDiagram.getCurrentChangeNumber();

					// Return a set containing the diagram resource
					if(editingDomain.getResourceSet().getResources().size() == 1) {
						return Collections.singleton(editingDomain.getResourceSet().getResources().get(0));
					} else {
						return Collections.emptySet();
					}
				} catch(final Exception e) {
					Status errorStatus = new Status(IStatus.ERROR, Activator.PLUGIN_ID, 0, e.getMessage(), e);
					Display.getDefault().asyncExec(() -> new ErrorDialog(Display.getDefault().getActiveShell(), "Error Saving Diagram",
							"Unable to save diagram.", errorStatus, IStatus.ERROR).open());
					throw e;
				}
			}

			@Override
			public boolean isDirty() {
				return ageDiagram == null || cleanDiagramChangeNumber != ageDiagram.getCurrentChangeNumber();
			}
		};
	}

	@Override
	protected IDiagramTypeProvider initDiagramTypeProvider(final Diagram diagram) {
		final AgeDiagramTypeProvider dtp = (AgeDiagramTypeProvider) super.initDiagramTypeProvider(diagram);

		try {
			// Ensure the project is built. This prevents being unable to find the context due to the Xtext index not having completed.
			try {
				project.build(IncrementalProjectBuilder.INCREMENTAL_BUILD, new NullProgressMonitor());
			} catch (CoreException e) {
				throw new RuntimeException(e);
			}

			// Treat the current state of the diagram as clean.
			cleanDiagramChangeNumber = ageDiagram.getCurrentChangeNumber();

			final AgeFeatureProvider fp = (AgeFeatureProvider) dtp.getFeatureProvider();

			// Update the diagram to finish initializing the diagram's fields before creating the GraphitiAgeDiagram object
			final ActionService actionService = getActionService();
			actionService.execute("Update on Load", ExecutionMode.HIDE, () -> {
				ageDiagram.modify("Update Diagram", m -> {
					// Check the diagram's context
					final DiagramContextChecker contextChecker = new DiagramContextChecker(project,
							dtp.getProjectReferenceService(), dtp.getSystemInstanceLoader());
					final boolean workbenchIsVisible = isWorkbenchVisible();
					final DiagramContextChecker.Result result = contextChecker.checkContextFullBuild(ageDiagram,
							workbenchIsVisible);

					if (!result.isContextValid()) {
						// If the workbench is not visible, then close the diagram to avoid an error which could have been avoided by relinking since
						// we only prompts to relink if the workbench is visible.
						if (!workbenchIsVisible) {
							closeDiagramContainer();
						}

						final String refContextLabel = dtp.getProjectReferenceService()
								.getLabel(ageDiagram.getConfiguration().getContextBoReference(), project);

						throw new InitializationException("Unable to resolve context: " + (refContextLabel == null
								? ageDiagram.getConfiguration().getContextBoReference().toString()
										: refContextLabel));
					}

					fp.getDiagramUpdater().updateDiagram(ageDiagram);
				});
				return null;
			});

			// Set the coloring service field. It is needed
			final ColoringProvider coloringProvider = new ColoringProvider() {
				private ColoringService cs = dtp.getColoringService();

				@Override
				public Map<DiagramElement, Color> buildForegroundColorMap() {
					return cs.buildForegroundColorMap();
				}
			};

			actionService.addChangeListener(actionStackChangeListener);

			actionExecutor = (label, mode, action) -> {
				final boolean inTransaction = ((InternalTransactionalEditingDomain) getEditingDomain())
						.getActiveTransaction() != null;

				// Don't create a transaction if already in one or if the modification listener is disabled. In the latter case, the graphiti diagram will
				// not be updated.
				final boolean reverseActionWasSpecified;
				if (inTransaction) {
					reverseActionWasSpecified = actionService.execute(label, mode, action);
				} else {
					final AgeActionCustomFeature actionFeature = new AgeActionCustomFeature(actionService, label,
							action, fp);
					executeFeature(actionFeature, new CustomContext());
					reverseActionWasSpecified = actionFeature.getExecuteResult();
				}

				// If an action isn't running and the action is executing as normal, then activate the editor if the action is undoable.
				// This will ensure that when the action is undone, the editor will be switched to the one in which the action was performed.
				if (isEditorActive() && reverseActionWasSpecified && !actionService.isActionExecuting()
						&& mode == ExecutionMode.NORMAL) {
					actionService.execute("Activate Editor", ExecutionMode.APPEND_ELSE_HIDE,
							new ActivateAgeEditorAction(getDiagramEditor()));
				}

				// Flush the command stack to avoid keeping references to commands. The graphical editor's ActionService keeps its own command stack.
				getEditingDomain().getCommandStack().flush();

				return reverseActionWasSpecified;
			};

			// Create a URI to use for the resource. This resource uses a scheme which does not have a registered handler.
			// A handler is not needed the resource's save() should not be called. The URI just serves as a unique identifier in the resource set.
			final URI ignoredUri = URI.createHierarchicalURI("osate_ge_ignore", null, null,
					new String[] { "internal.aadl_diagram" }, null, null);

			// Create the diagram resource and add the diagram to it.
			final TransactionalEditingDomain editingDomain = getEditingDomain();
			final Resource diagramResource = editingDomain.getResourceSet().createResource(ignoredUri);
			editingDomain.getCommandStack().execute(new AbstractCommand() {
				@Override
				protected boolean prepare() {
					return true;
				}

				@Override
				public void execute() {
					diagramResource.getContents().add(diagram);
				}

				@Override
				public boolean canUndo() {
					return false;
				}

				@Override
				public void redo() {
				}
			});

			// Create the Graphiti AGE diagram which will own a Graphiti diagram and keep it updated with any changes to the AGE diagram
			graphitiAgeDiagram = new GraphitiAgeDiagram(ageDiagram, dtp.getDiagram(), actionExecutor, coloringProvider,
					() -> {
						// Refresh the selection. This prevents the editor from losing the selection in some cases such as aligning shapes.
						final PictogramElement[] pes = getSelectedPictogramElements();
						setPictogramElementsForSelection(pes);
					});

			return dtp;
		} catch (final InitializationException ex) {
			// Dispose the diagram type provider because it isn't being returned
			if (dtp != null) {
				dtp.dispose();
			}
			throw ex;
		}
	}

	private boolean isEditorActive() {
		final AgeDiagramEditor editor = getDiagramEditor();
		if(editor == null) {
			return false;
		}

		final IWorkbenchSite site = editor.getSite();
		if(site == null) {
			return false;
		}

		final IWorkbenchPage page = site.getPage();
		if(page == null) {
			return false;
		}

		return page.getActiveEditor() == getDiagramEditor();
	}

	private void closeDiagramContainer() {
		// Need to wait until opening finishes before attempting to close the editor.
		// Otherwise, exceptions will be triggered in addition to the editor being closed.
		Display.getCurrent().asyncExec(() -> {
			getDiagramContainer().close();
		});
	}

	/**
	 * Method intended to allow getting the Graphiti Age Diagram from the Grpahiti Diagram Type Provider
	 * @return
	 */
	@Override
	public GraphitiAgeDiagram getGraphitiAgeDiagram() {
		return graphitiAgeDiagram;
	}

	public AgeDiagram getAgeDiagram() {
		return ageDiagram;
	}

	private final AgeDiagramEditor getDiagramEditor() {
		return (AgeDiagramEditor)getParentPart();
	}

	private static Path getPath(final URI uri) {
		return new Path(uri.toPlatformString(true));
	}

	@Override
	public Object getAdapter(@SuppressWarnings("rawtypes") Class type) {
		if (type == IPropertySheetPage.class) {
			final IConfigurationProvider cfgProvider = getConfigurationProvider();
			if (cfgProvider != null && getDiagramContainer() instanceof ITabbedPropertySheetPageContributor) {
				ITabbedPropertySheetPageContributor contributor = (ITabbedPropertySheetPageContributor) getDiagramContainer();
				if (contributor.getContributorId() != null) {
					propertySheetPage = new AgeTabbedPropertySheetPage(contributor);
					return propertySheetPage;
				}
			}
			return null; // not yet initialized
		}

		return super.getAdapter(type);
	}

	private static class AgeTabbedPropertySheetPage extends TabbedPropertySheetPage {
		private boolean disposed = false;
		private IWorkbenchPart part;

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

// Update the property sheet selection if it has changed and the part the property sheet is interested in is the editor.
// This check is needed to avoid problems with outline selection.
	@Override
	public void selectPictogramElements(final PictogramElement[] pes) {
		super.selectPictogramElements(pes);

		final IWorkbenchPart parentPart = getParentPart();
		if (parentPart != null && propertySheetPage != null
				&& (propertySheetPage.part == parentPart || propertySheetPage.part instanceof ContentOutline)
				&& parentPart.getSite() != null
				&& parentPart.getSite().getSelectionProvider() != null) {
			propertySheetPage.selectionChanged(parentPart, parentPart.getSite().getSelectionProvider().getSelection());

			// Refresh the property sheet page. This is important because the selected pictogram element may not have changed but the business objects
			// they are associated with may have.
			if (propertySheetPage != null && propertySheetPage.getCurrentTab() != null) {
				propertySheetPage.refresh();
			}
		}
	}

// Special exception for handling errors during the initialization process.
	private static class InitializationException extends RuntimeException {
		private static final long serialVersionUID = 2650849956029822898L;

		public InitializationException(final String message) {
			super(message);
		}
	}
}
