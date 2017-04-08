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
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
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
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
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
import org.eclipse.ui.part.EditorPart;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.IXtextModelListener;
import org.osate.aadl2.NamedElement;
import org.osate.ge.di.Names;
import org.osate.ge.internal.diagram.AgeDiagram;
import org.osate.ge.internal.diagram.CanonicalBusinessObjectReference;
import org.osate.ge.internal.diagram.DiagramConfigurationBuilder;
import org.osate.ge.internal.diagram.DiagramElement;
import org.osate.ge.internal.diagram.DiagramNode;
import org.osate.ge.internal.graphiti.GraphitiAgeDiagramProvider;
import org.osate.ge.internal.graphiti.diagram.ColoringProvider;
import org.osate.ge.internal.graphiti.diagram.GraphitiAgeDiagram;
import org.osate.ge.internal.graphiti.features.UpdateDiagramFeature;
import org.osate.ge.internal.services.CachingService;
import org.osate.ge.internal.services.ColoringService;
import org.osate.ge.internal.services.ExtensionService;
import org.osate.ge.internal.services.impl.ReferenceEncoder;
import org.osate.ge.internal.ui.xtext.AgeXtextUtil;
import org.osate.ge.internal.util.Log;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
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
	private PaintListener paintListener = new PaintListener() {
		@Override
		public void paintControl(PaintEvent e) {
			if(updateWhenVisible) {
				update();
				updateWhenVisible = false;
			}
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
	
	private ColoringProvider coloringProvider = new ColoringProvider() {
		ColoringService cs;
		
		@Override
		public Color getForegroundColor(final DiagramElement de) {
			if(cs == null) {
				cs = (ColoringService)getAdapter(ColoringService.class);
			}
			
			return cs.getForegroundColor(de);
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
				private Object tooltipBo = null;
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
					
					// Don't show tooltips for the diagram pictogram element
					if(!(hoverPe instanceof Diagram)) {
						final Object hoverBo = getClosestBusinessObject(hoverPe);						
						if (hoverBo != null) {
							if(!hoverBo.equals(tooltipBo) || exceedsCursorMoveThreshold(e.x, e.y)) {
								disposeCurrentToolTip();
								tooltipBo = hoverBo;
																
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
									context.set(Names.BUSINESS_OBJECT, tooltipBo);
									for (final Object tooltipContributor : extService.getTooltipContributors()) {
										ContextInjectionFactory.invoke(tooltipContributor, org.osate.ge.di.Activate.class, context);
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
				}
				
				@Override
				public void mouseMove(final MouseEvent e) {
					final PictogramElement movePe = getPictogramElementByControlCoordinates(e.x, e.y);
					final Object moveBo = getClosestBusinessObject(movePe);
					if (tooltipShell != null && (movePe instanceof Diagram || !moveBo.equals(tooltipBo) || exceedsCursorMoveThreshold(e.x, e.y))) {
						disposeCurrentToolTip();
					}
				}
				
				private void disposeCurrentToolTip() {
					if(tooltipShell != null) {
						tooltipShell.dispose();
					}
					
					tooltipShell = null;
					tooltipBo = null;
					tooltipCursorX = Integer.MIN_VALUE;
					tooltipCursorY = Integer.MIN_VALUE;
				}
				
				private boolean exceedsCursorMoveThreshold(final int cursorX, final int cursorY) {
					return (Math.abs(cursorX - tooltipCursorX) + Math.abs(cursorY - tooltipCursorY)) >= cursorMoveThreshold;
				}
				
				private Object getClosestBusinessObject(final PictogramElement pe) {
					if(pe == null) {
						return null;
					}
					
					final DiagramNode dn = getGraphitiAgeDiagram().getClosestDiagramElement(pe);
					if(dn == null) {
						return null;
					}
					
					return dn.getBusinessObject();
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
	
	private IXtextModelListener modelListener = new IXtextModelListener() {
		@Override
		public void modelChanged(final XtextResource resource) {
			if(resource.getContents().size() > 0) {
				// Invalidate the cache
				final CachingService cachingService = (CachingService)getAdapter(CachingService.class);
				if(cachingService != null) {
					cachingService.invalidate();
				}
				
				// Update the diagram
				final EObject contents = resource.getContents().get(0);
				if(contents instanceof NamedElement) { // Filter out changes to non AADL Xtext models
					updateIfDiagramResourceMatches(resource);
				}
			}					
		}	
	};

	private void updateIfDiagramResourceMatches(final Resource resource) {
		// Ensure the method is called in the UI thread
		if (Display.getCurrent() == null) {
			Display.getDefault().asyncExec(new Runnable() {
				public void run() {
					updateIfDiagramResourceMatches(resource);
				}
			});
			return;
		}
		
		// TODO: Migrate. Need to only update if the modified resource is somehow connected to this diagram.
		update();
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
		
		AgeXtextUtil.addModelListener(modelListener);
	}
	
	@Override
	protected void unregisterBusinessObjectsListener() {
		AgeXtextUtil.removeModelListener(modelListener);
		
		// Do not call super method
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
	
	private void updateProjectByUri(final URI uri) {
		final IPath projectPath = new Path(uri.toPlatformString(true)).uptoSegment(1);
		final IResource projectResource = ResourcesPlugin.getWorkspace().getRoot().findMember(projectPath);
		if(!(projectResource instanceof IProject)) {
			throw new RuntimeException("Unable to determine project");
		}

		project = (IProject)projectResource;
	}
	
	@Override
	protected DefaultPersistencyBehavior createPersistencyBehavior() {
		return new DefaultPersistencyBehavior(this) {
			@Override
			public Diagram loadDiagram(final URI uri) {
				updateProjectByUri(uri);

				// TODO: Replace with something that supports loading the the native format and loading and converting a legacy(Graphiti) format diagram
				// TODO: Should consider a custom resource implementation which would handle the conversion and saving at the EMF resource level.
				
				// Load the graphiti diagram
				final ResourceSet resourceSet = new ResourceSetImpl();
				final Diagram tmpDiagram = (Diagram)resourceSet.getEObject(uri, true);
				if(tmpDiagram == null) {
					// TODO: Handle
					throw new RuntimeException("Unable to open diagram");
				}
				
				final String rootBoRefStr = Graphiti.getPeService().getPropertyValue(tmpDiagram, "independentObject"); // TODO: Use constant
				if(rootBoRefStr == null) {
					throw new RuntimeException("Unable to get root business object reference");
				}
				
				final CanonicalBusinessObjectReference rootBoRef = new CanonicalBusinessObjectReference(ReferenceEncoder.decode(rootBoRefStr));
				
				final AgeDiagram ageDiagram = new AgeDiagram();

				// TODO: Cleanup. Part of loading legacy diagram. Set the root business object reference
				ageDiagram.setDiagramConfiguration(new DiagramConfigurationBuilder(ageDiagram.getConfiguration()).setRootBoReference(rootBoRef).build());

				// Create the Graphiti AGE diagram which will own a Graphiti diagram and keep it updated with any changes to the AGE diagram		
				graphitiAgeDiagram = new GraphitiAgeDiagram(ageDiagram, diagramBehavior.getEditingDomain(), coloringProvider);				
								
				return graphitiAgeDiagram.getGraphitiDiagram();
			}
			
			protected Set<Resource> save(final TransactionalEditingDomain editingDomain, final Map<Resource, Map<?, ?>> saveOptions, final IProgressMonitor monitor) {
				// TODO: Implement saving to native format
				/*
				final Diagram diagram = getDiagramTypeProvider().getDiagram();

				editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
					@Override
					protected void doExecute() {
						// Delete all the ghosts
						ghostPurger.purgeGhosts(diagram);
					}				
				});				
				
				// Save the diagram				
				final Set<Resource> retValue = super.save(editingDomain, saveOptions, monitor);

				// Set the persistent properties
				diagramService.savePersistentProperties(diagram);
				
				return retValue;
				*/
				//TODO: Migrate!
				throw new RuntimeException("TODO: Migrate");
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
}
