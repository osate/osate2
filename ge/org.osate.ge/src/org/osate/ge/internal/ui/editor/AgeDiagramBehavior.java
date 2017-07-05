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
package org.osate.ge.internal.ui.editor;

import java.awt.Color;
import java.util.Collections;
import java.util.EventObject;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListener;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.ContextMenuProvider;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.context.impl.UpdateContext;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.editor.DefaultPaletteBehavior;
import org.eclipse.graphiti.ui.editor.DefaultPersistencyBehavior;
import org.eclipse.graphiti.ui.editor.DefaultRefreshBehavior;
import org.eclipse.graphiti.ui.editor.DefaultUpdateBehavior;
import org.eclipse.graphiti.ui.editor.DiagramBehavior;
import org.eclipse.graphiti.ui.editor.DiagramEditorContextMenuProvider;
import org.eclipse.graphiti.ui.editor.IDiagramContainerUI;
import org.eclipse.graphiti.ui.editor.IDiagramEditorInput;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.events.MouseTrackListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.EditorPart;
import org.osate.ge.di.Names;
import org.osate.ge.internal.Activator;
import org.osate.ge.internal.diagram.runtime.AgeDiagram;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.DiagramLayoutUtil;
import org.osate.ge.internal.diagram.runtime.DiagramModification;
import org.osate.ge.internal.diagram.runtime.DiagramModifier;
import org.osate.ge.internal.diagram.runtime.DiagramSerialization;
import org.osate.ge.internal.graphiti.AgeDiagramTypeProvider;
import org.osate.ge.internal.graphiti.AgeFeatureProvider;
import org.osate.ge.internal.graphiti.GraphitiAgeDiagramProvider;
import org.osate.ge.internal.graphiti.LegacyGraphitiDiagramConverter;
import org.osate.ge.internal.graphiti.diagram.ColoringProvider;
import org.osate.ge.internal.graphiti.diagram.GraphitiAgeDiagram;
import org.osate.ge.internal.graphiti.diagram.GraphitiAgeDiagram.UpdaterListener;
import org.osate.ge.internal.graphiti.features.UpdateDiagramFeature;
import org.osate.ge.internal.services.ColoringService;
import org.osate.ge.internal.services.DiagramService;
import org.osate.ge.internal.services.ExtensionService;
import org.osate.ge.internal.services.ModelChangeNotifier;
import org.osate.ge.internal.services.ModelChangeNotifier.ChangeListener;
import org.osate.ge.internal.util.DiagramUtil;
import org.osate.ge.internal.util.Log;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import java.util.Map;

public class AgeDiagramBehavior extends DiagramBehavior implements GraphitiAgeDiagramProvider {	
	private GraphitiAgeDiagram graphitiAgeDiagram;
	private IProject project = null;
	private boolean updateInProgress = false;
	private boolean updateWhenVisible = false;
	private boolean forceNotDirty = false;
	private boolean updatingFeatureWhileForcingNotDirty = false;
	private ToolHandler toolHandler;
	private IResourceChangeListener resourceChangeListener;
	private AgeDiagram ageDiagram;
	private PaintListener paintListener = new PaintListener() {
		@Override
		public void paintControl(PaintEvent e) {
			if(updateWhenVisible) {
				update();
				updateWhenVisible = false;
			}
		}			
	};
	
	private ChangeListener modelChangeListener = new ChangeListener() {		
		@Override
		public void afterModelChangeNotification() {
			updateDiagramWhenVisible();
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

		public boolean isAggregatePrecommitListener() {
			return false;
		}

		public boolean isPostcommitOnly() {
			return true;
		}

		public boolean isPrecommitOnly() {
			return false;
		}		
	};
	
	public AgeDiagramBehavior(final IDiagramContainerUI diagramContainer) {
		super(diagramContainer);
	}	
	
	@Override
	public void configureGraphicalViewer() {
		super.configureGraphicalViewer();

		final AgeDiagramEditor editor = (AgeDiagramEditor)this.getParentPart();
		if(editor != null) {
			final ActionRegistry actionRegistry = getDiagramContainer().getActionRegistry();
			@SuppressWarnings("unchecked")
			final List<String> selectionActions = getDiagramContainer().getSelectionActions();
			IAction action;
			action = new MatchSizeAction(editor);
			actionRegistry.registerAction(action);
			selectionActions.add(action.getId());
			action = new DistributeHorizontallyAction(editor);
			actionRegistry.registerAction(action);
			selectionActions.add(action.getId());
			action = new DistributeVerticallyAction(editor);
			actionRegistry.registerAction(action);
			selectionActions.add(action.getId());
			
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
							tooltipElement = hoverElement;
															
							// Create new tooltip shell
							final Display display = Display.getCurrent();
							tooltipShell = new Shell(display.getActiveShell(), SWT.ON_TOP | SWT.TOOL | SWT.CENTER);
							tooltipShell.setVisible(false);
							tooltipShell.setBackground(display.getSystemColor(SWT.COLOR_INFO_BACKGROUND));
							tooltipShell.setBackgroundMode(SWT.INHERIT_FORCE);
							
							// Configure layout
							final RowLayout rowLayout = new RowLayout();
							rowLayout.fill = true;
			                rowLayout.wrap = false;
			                rowLayout.pack = true;
			                rowLayout.type = SWT.VERTICAL;
			                rowLayout.spacing = 0;
			                tooltipShell.setLayout(rowLayout);
			                
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
	 		toolHandler = new ToolHandler(this, extService, getPaletteBehavior());
	 		for(final Object tool : extService.getTools()) {
	 			registerAction(new ActivateToolAction(editor, toolHandler, tool));
	 		}
	 		
	 		editor.getGraphicalViewer().addSelectionChangedListener(new ISelectionChangedListener() {
				@Override
				public void selectionChanged(final SelectionChangedEvent event) {
					final PictogramElement[] selectedPes = editor.getSelectedPictogramElements();
					if(selectedPes != null) {
						toolHandler.setSelectedPictogramElements(selectedPes);
					}
				}	 			
	 		});	 		
	 		toolHandler.setSelectedPictogramElements(editor.getSelectedPictogramElements());
	 			 		
	 		// Deactivate the tool when the part is deactivated or closed
	 		editor.getSite().getWorkbenchWindow().getPartService().addPartListener(new IPartListener() {
	 			@Override
	 			public void partClosed(final IWorkbenchPart part) {
	 				if (editor == part) {
	 					toolHandler.deactivateActiveTool();
	 					
	 					// Stop listening for part events
	 					editor.getSite().getWorkbenchWindow().getPartService().removePartListener(this);
	 				}	 				
	 			}

	 			@Override
	 			public void partDeactivated(final IWorkbenchPart part) {
	 				if (editor == part) {
	 					toolHandler.deactivateActiveTool();
	 				}
	 			}

	 			@Override
	 			public void partActivated(final IWorkbenchPart part) {}
	 			
	 			@Override
	 			public void partBroughtToTop(final IWorkbenchPart part) {}
	 			
	 			@Override
	 			public void partOpened(final IWorkbenchPart part) {}
	 		});
		}
	}
	
	/**
	 * Throws exception if the action for the specified tool cannot be found.
	 * @param toolId
	 * @return
	 */
	public IAction getActivateToolAction(final String toolId) {
		Objects.requireNonNull(toolId, "toolId must not be null");
		final ActionRegistry actionRegistry = getDiagramContainer().getActionRegistry();
		return Objects.requireNonNull(actionRegistry.getAction(ActivateToolAction.getActionId(toolId)), "unable to retrieve action for tool: " + toolId);
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
			
			@SuppressWarnings("restriction")
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
		super.disposeAfterGefDispose();
		
		if(toolHandler != null) {
			toolHandler.dispose();
		}
	}
	
	public void updateDiagramWhenVisible() {
		update();
	}
	
	private void update() {
		final Runnable updateDiagramRunnable = new Runnable() {
			private boolean updateQueued = false;
			
			public void run() {
				// A mutex is not needed because this runnable and other code that access variables used by this runnable are ran in the display thread
				// Don't update if update is already in progress
				if(!updateInProgress) {
					updateQueued = false;
					updateInProgress = true;
					
					try {
						// Don't update unless the diagram is visible
						if(getContentEditPart().getViewer().getControl().isVisible()) {
							// Update the entire diagram
							getDiagramTypeProvider().getNotificationService().updatePictogramElements(new PictogramElement[] { getDiagramTypeProvider().getDiagram() });									
						} else {
							// Queue the update for when the control becomes visible
							updateWhenVisible = true;
						}
						
					} finally {
						updateInProgress = false;
					}
					
					// Check if an update has been queued
					if(updateQueued) {
						update();
					}
				
				} else {
					// Queue the update
					updateQueued = true;
				}								
			}
		};
		
		if(Display.getDefault().getThread() == Thread.currentThread()) {
			Log.info("Updating diagram synchronously - current thread is the display thread");
			updateDiagramRunnable.run();
		} else {
			Log.info("Updating diagram asynchronously - current thread is not the display thread");
			Display.getDefault().asyncExec(updateDiagramRunnable);	
		}
	}

	@Override
	protected DefaultUpdateBehavior createUpdateBehavior() {
		return new AgeUpdateBehavior(this);
	}	
	
	@Override
	protected DefaultPaletteBehavior createPaletteBehaviour() {
		return new DefaultPaletteBehavior(this) {
			@Override
			public void refreshPalette() {
				super.refreshPalette();
				
				// Hide palette drawers if a tool is active
				if(toolHandler != null && toolHandler.isToolActive()) {
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
		
		// Remove listener
		getModelChangeNotifier().removeChangeListener(modelChangeListener);
	}
	
	private ModelChangeNotifier getModelChangeNotifier() {
		return Objects.requireNonNull((ModelChangeNotifier)getAdapter(ModelChangeNotifier.class), "unable to retrieve model change notifier");
	}
	
	@Override
	protected DefaultRefreshBehavior createRefreshBehavior() {		
		return new DefaultRefreshBehavior(this) {
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
					Display.getDefault().asyncExec(new Runnable() {
						public void run() {
							refresh();
						}
					});
					return;
				}
				
				// Update the toolbars
				if(getDiagramContainer() instanceof EditorPart) {
					((EditorPart)getDiagramContainer()).getEditorSite().getActionBars().getToolBarManager().update(true);
				}
				
				super.refresh();
			}
		};
	}
	
	public DefaultPersistencyBehavior getPersistencyBehavior() {
		return super.getPersistencyBehavior();
	}
	
	@Override
	protected ContextMenuProvider createContextMenuProvider() {
		return new DiagramEditorContextMenuProvider(getDiagramContainer().getGraphicalViewer(),
				getDiagramContainer().getActionRegistry(),
				getConfigurationProvider()) {

			@Override
			public void buildContextMenu(final IMenuManager manager) {
				// Don't populate context menu when a tool is active
				if(toolHandler == null  || !toolHandler.isToolActive()) {
					super.buildContextMenu(manager);
				}
			}					
		};
	}
	
	/**
	 * Returns the number of visible objects in the diagram. Only certain objects are checked. Used to decide whether the diagram has changed after an update
	 * @return
	 */
	private int getVisibleObjectsInDiagram() {
		int count = 0;
		final Iterator<EObject> it = getDiagramTypeProvider().getDiagram().eAllContents();
		while(it.hasNext()) {
			final EObject obj = it.next();
			if((obj instanceof Shape || obj instanceof Connection)) {
				final PictogramElement pe = (PictogramElement)obj;
				if(pe.isVisible()) {
					count++;
				}
			}
		}
		
		return count;
	}
	
	@Override
	public Object executeFeature(final IFeature feature, final IContext context) {
		// If we are forcing the diagram to not be seen as dirty, decide whether to start using the typical dirty check
		if(forceNotDirty) {
			// Prevent the initial diagram update from making the diagram dirty if the number of objects doesn't change.			
			if(feature instanceof UpdateDiagramFeature) {
				final int startCount = getVisibleObjectsInDiagram();
				updatingFeatureWhileForcingNotDirty = true;
				final Object retValue = super.executeFeature(feature, context);
				updatingFeatureWhileForcingNotDirty = false;
				final int endCount = getVisibleObjectsInDiagram();
				if(startCount != endCount) {
					forceNotDirty = false;
				}
				return retValue;
			} else {
				if(!updatingFeatureWhileForcingNotDirty) {
					forceNotDirty = false;
				}
			}
		}
		return super.executeFeature(feature, context);
	}
	
	
	@Override
	protected void editingDomainInitialized() {
		super.editingDomainInitialized();
		
		final TransactionalEditingDomain editingDomain = getEditingDomain();
		if(editingDomain != null) {
			final BasicCommandStack commandStack = (BasicCommandStack) editingDomain.getCommandStack();
			if(commandStack != null) {
				commandStack.addCommandStackListener(new CommandStackListener() {
					@Override
					public void commandStackChanged(EventObject event) {
						if(!updatingFeatureWhileForcingNotDirty) {
							forceNotDirty = false;
						}
					}					
				});
				
				// Since we have successfully created a command stack listener, force the diagram to be seen as not dirty until there is a change
				forceNotDirty = true;
			}
		}
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

			if(DiagramUtil.isLegacy((IFile)resource)) {
				// Only prompt for converting if the workbench window is already visible. 
				// The primary purpose is to be prevent confusion by not prompting for conversion on the first load of the workspace after upgrading.
				if(PlatformUI.getWorkbench() !=  null &&
					PlatformUI.getWorkbench().getActiveWorkbenchWindow() != null &&
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell() != null &&
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell().isVisible()) {
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
					getDiagramContainer().close();
				}
			}
		}				
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
		
		super.setInput(input);
		
		if(resourceChangeListener == null) {
			// Create and register a resource change listener. This listener is needed to handle moving and deleting of the resource file.
			// Graphiti's built-in support cannot be used because the editor has a custom persistency behavior that doesn't use EMF
			final IWorkspace workspace = ResourcesPlugin.getWorkspace();
			resourceChangeListener = new IResourceChangeListener() {
				public void resourceChanged(final IResourceChangeEvent event) {
					if(event.getType() != IResourceChangeEvent.POST_CHANGE) {
						return;
					}
					
					final IResourceDelta rootDelta = event.getDelta();
					final IResourceDelta diagramDelta = rootDelta.findMember(getPath(getInput().getUri()));
					if (diagramDelta == null) {
			            return;
					}
					
					if(diagramDelta.getKind() == IResourceDelta.REMOVED) {
						Display.getDefault().asyncExec(new Runnable() {							
							@Override
							public void run() {
								if((diagramDelta.getFlags() & IResourceDelta.MOVED_TO) == 0) {
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
							}
						});
					} 
				}
		   };
		   workspace.addResourceChangeListener(resourceChangeListener);
		}
	}
	
	@Override
	protected void disposeBeforeGefDispose() {
		// Unregister our resource change listener
		if(resourceChangeListener != null) {
			final IWorkspace workspace = ResourcesPlugin.getWorkspace();
			workspace.removeResourceChangeListener(resourceChangeListener);
		}
		
		super.disposeBeforeGefDispose();	
	}

	@Override
	protected DefaultPersistencyBehavior createPersistencyBehavior() {
		return new DefaultPersistencyBehavior(this) {
			@Override
			public Diagram loadDiagram(final URI uri) {
				updateProjectByUri(uri);
				ageDiagram = new AgeDiagram();
				DiagramSerialization.read(ageDiagram, uri);
				
				// Create an empty Graphiti diagram. It will be updated after in initDiagramTypeProvider() after the diagram type provider is initialized and 
				// the required services are available.
				return Graphiti.getPeService().createDiagram(GraphitiAgeDiagram.AADL_DIAGRAM_TYPE_ID, "", true);
			}
			
			protected Set<Resource> save(final TransactionalEditingDomain editingDomain, final Map<Resource, Map<?, ?>> saveOptions, final IProgressMonitor monitor) {
				try {
					// Get the resource
					final IResource resource = ResourcesPlugin.getWorkspace().getRoot().findMember(new Path(getInput().getUri().toPlatformString(true)));
					if(!(resource instanceof IFile)) {
						throw new RuntimeException("Unable to retrieve file for resource.");
					}
					
					// Save the file
		            DiagramSerialization.write(ageDiagram, getInput().getUri());
		            
					// Clear legacy persistent properties
					final DiagramService diagramService = Objects.requireNonNull((DiagramService)getAdapter(DiagramService.class), "unable to retrieve diagram service");
					diagramService.clearLegacyPersistentProperties(resource);
					
					// Clear Ghosts
					final AgeFeatureProvider fp = (AgeFeatureProvider)getDiagramTypeProvider().getFeatureProvider();
					fp.getDiagramUpdater().clearGhosts();

					// Return a set containing the diagram resource
					if(editingDomain.getResourceSet().getResources().size() == 1) {
						return Collections.singleton(editingDomain.getResourceSet().getResources().get(0));
					} else {
						return Collections.emptySet();
					}
				} catch(final Exception e) {
					Status errorStatus = new Status(IStatus.ERROR, Activator.PLUGIN_ID, 0, e.getMessage(), e);
					Display.getDefault().asyncExec(new Runnable() {
						@Override
						public void run() {
							new ErrorDialog(Display.getDefault().getActiveShell(), "Error Saving Diagram",
									"Unable to save diagram.", errorStatus, IStatus.ERROR).open();
						}
					});
					throw e;
				}
			}
			
			// Keep the forceNotDirty check
			@Override
			public boolean isDirty() {
				if(forceNotDirty) {
					return false;
				}
				
				return super.isDirty();
			}
		};
	}
	
	@Override
	protected IDiagramTypeProvider initDiagramTypeProvider(final Diagram diagram) {
		final IDiagramTypeProvider dtp = super.initDiagramTypeProvider(diagram);

		// Update the diagram to finish initializing the diagram's fields before creating the GrpahitiAgeDiagram object
		final AgeFeatureProvider fp = (AgeFeatureProvider)dtp.getFeatureProvider();
		fp.getDiagramUpdater().updateDiagram(ageDiagram);
		
		// Perform incremental layout
		ageDiagram.modify(new DiagramModifier() {
			@Override
			public void modify(final DiagramModification m) {
				DiagramLayoutUtil.layout(ageDiagram, m, false);	
			}						
		});
				
		// Set the coloring service field. It is needed 
		final ColoringProvider coloringProvider = new ColoringProvider() {
			private ColoringService cs = ((AgeDiagramTypeProvider)dtp).getColoringService();
			@Override
			public Color getForegroundColor(final DiagramElement de) {
				return cs.getForegroundColor(de);
			}
		};		
		
		// Create the Graphiti AGE diagram which will own a Graphiti diagram and keep it updated with any changes to the AGE diagram
		graphitiAgeDiagram = new GraphitiAgeDiagram(ageDiagram, dtp.getDiagram(), getEditingDomain(), coloringProvider, 
			new UpdaterListener() {
				@Override
				public void onUpdateFinished() {
					// Refresh the selection. This prevents the editor from losing the selection in some cases such as aligning shapes.
					final PictogramElement[] pes = getSelectedPictogramElements();
					setPictogramElementsForSelection(pes);
				}
		});

		// Prevent the diagram from being marked as dirty.
		forceNotDirty = true;
		
		return dtp;
	}
	
	/**
	 * Method intended to allow getting the Graphiti Age Diagram from the Grpahiti Diagram Type Provider
	 * @return
	 */
	public GraphitiAgeDiagram getGraphitiAgeDiagram() {
		return graphitiAgeDiagram;
	}

	private final AgeDiagramEditor getDiagramEditor() {
		return (AgeDiagramEditor)getParentPart();
	}
	
	// This prevents cluttering the context menu with global eclipse menu items
	@Override
	protected boolean shouldRegisterContextMenu() {
		return false;
	}
	
	private static Path getPath(final URI uri) {
		return new Path(uri.toPlatformString(true));
	}
}
