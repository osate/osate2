package org.osate.ge.internal.ui.editor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.IEclipsePreferences.IPreferenceChangeListener;
import org.eclipse.core.runtime.preferences.IEclipsePreferences.PreferenceChangeEvent;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IDeleteFeature;
import org.eclipse.graphiti.features.IDirectEditingFeature;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.impl.CustomContext;
import org.eclipse.graphiti.features.context.impl.DeleteContext;
import org.eclipse.graphiti.features.context.impl.DirectEditingContext;
import org.eclipse.graphiti.features.context.impl.MultiDeleteInfo;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IPropertyListener;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.views.contentoutline.ContentOutlinePage;
import org.osate.ge.internal.Activator;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.DiagramNode;
import org.osate.ge.internal.graphiti.diagram.GraphitiAgeDiagram;
import org.osate.ge.internal.ui.util.ImageUiHelper;
import org.osate.ge.internal.util.StringUtil;

public class AgeContentOutlinePage extends ContentOutlinePage {
	private static final String PREFERENCE_OUTLINE_LINK_WITH_EDITOR = "outline.linkWithEditor";
	private IEclipsePreferences preferences = InstanceScope.INSTANCE.getNode(Activator.PLUGIN_ID);
	
	private AgeDiagramEditor editor;
	
	// Flag for indicating the the outline and editor selection is being synchronized. 
	// Used to avoid adjusting either selection in response to a change to itself.
	// This is important to allow selecting items in the editor which aren't contained in the outline.
	private boolean synchronizingSelection = false;
	
	public AgeContentOutlinePage(final AgeDiagramEditor editor) {
		this.editor = Objects.requireNonNull(editor, "editor must not be null");
		preferences.addPreferenceChangeListener(preferenceChangeListener);
	}
	
	@Override
	public void dispose() {
		preferences.removePreferenceChangeListener(preferenceChangeListener);
		super.dispose();
	}
	
	private final IPreferenceChangeListener preferenceChangeListener = new IPreferenceChangeListener() {
		@Override
		public void preferenceChange(final PreferenceChangeEvent event) {
			// Update the state of the button based on the new property value. 
			// This will not trigger a synchronization.
			if(PREFERENCE_OUTLINE_LINK_WITH_EDITOR.equals(event.getKey())) {
				if(event.getNewValue() != null) {
					linkWithEditorAction.setChecked(Boolean.parseBoolean(event.getNewValue().toString()));
				}
			}
		}
	};	

	public void createControl(final Composite parent) {
		super.createControl(parent);

		final IDiagramTypeProvider diagramTypeProvider = editor.getDiagramTypeProvider();
		final TreeViewer viewer =  getTreeViewer();
		viewer.setContentProvider(new ITreeContentProvider() {
			@Override
			public void dispose() {
			}

			@Override
			public void inputChanged(final Viewer viewer, final Object oldInput, final Object newInput) {
			}

			@Override
			public Object[] getElements(final Object inputElement) {
				if(inputElement instanceof AgeDiagramEditor) {
					final AgeDiagramEditor editor = (AgeDiagramEditor)inputElement;
					final GraphitiAgeDiagram graphitiAgeDiagram = editor.getGraphitiAgeDiagram();
					return getChildren(graphitiAgeDiagram.getAgeDiagram());
				}

				return new Object[0];
			}

			@Override
			public Object[] getChildren(final Object parentElement) {
				if(parentElement instanceof DiagramNode) {
					// Show all diagram elements for which the label provider can generate a label.
					return ((DiagramNode) parentElement).getDiagramElements().stream().filter((de) -> de.getName() != null || de.getBusinessObject() instanceof EObject).toArray();
				}
				
				return new Object[0];
			}

			@Override
			public Object getParent(final Object element) {
				if(element instanceof DiagramElement) {
					return ((DiagramElement) element).getContainer();
				}

				return null;
			}

			@Override
			public boolean hasChildren(final Object element) {
				if(element instanceof DiagramNode) {
					return getChildren(element).length > 0;
				}

				return false;
			}
		});

		viewer.setSorter(new ViewerSorter() {
			@Override
			public int compare(final Viewer viewer, final Object o1, final Object o2) {
				final TreeViewer treeViewer = (TreeViewer)viewer;
				final LabelProvider labelProvider = (LabelProvider)treeViewer.getLabelProvider();
				final String s1 = labelProvider.getText(o1);
				final String s2 = labelProvider.getText(o2);

				return s1.compareToIgnoreCase(s2);
			}
		});

		viewer.setLabelProvider(new LabelProvider() {			
			@Override
			public String getText(final Object element) {
				if(element instanceof DiagramElement) {
					final DiagramElement de = (DiagramElement)element;
					final Object bo = de.getBusinessObject();
					String lblTxt = "";
					if(bo instanceof EObject) {
						lblTxt += StringUtil.camelCaseToUser(((EObject)bo).eClass().getName()) + " ";
					}
					
					if(de.getName() != null) {
						lblTxt += de.getName();
					}
					
					return lblTxt;
				}
				
				return super.getText(element);
			}

			@Override
			public Image getImage(final Object element) {
				if(element instanceof DiagramElement) {
					final DiagramElement de = (DiagramElement)element;
					final Object bo = de.getBusinessObject();
					return ImageUiHelper.getImage(bo);
				}

				return null;
			}
		});

		final MenuManager menuMgr = new MenuManager();
		menuMgr.setRemoveAllWhenShown(true);

		menuMgr.addMenuListener(new IMenuListener() {
			@Override
			public void menuAboutToShow(final IMenuManager contextMenu) {
				final PictogramElement[] treePes = getCurrentlySelectedPictogramElements();
				final ICustomContext context = new CustomContext(treePes);
				final ICustomFeature[] customFeatures = diagramTypeProvider.getFeatureProvider().getCustomFeatures(context);				

				// Renaming
				if(context.getPictogramElements().length > 0) {
					final PictogramElement pe = context.getPictogramElements()[0];
					final DirectEditingContext directEditingContext = getDirectEditingContext(pe);
					if(directEditingContext != null) {
						final IDirectEditingFeature directEditingFeature = editor.getDiagramTypeProvider().getFeatureProvider().getDirectEditingFeature(directEditingContext);
						if(context.getPictogramElements().length == 1 && directEditingFeature.canDirectEdit(directEditingContext)) {
							menuMgr.add(new Action("Rename...") {
								@Override
								public void run() {
									final RenameDialog nameDialog = new RenameDialog(Display.getCurrent().getActiveShell(), directEditingFeature, directEditingContext);
									if(nameDialog.open() == Dialog.CANCEL || nameDialog.getValue() == null) {
										return;
									}

									directEditingFeature.setValue(nameDialog.getValue(), directEditingContext);
									directEditingFeature.execute(directEditingContext);
								}
							});
						}
					}
				}

				// Delete
				final HashMap<DeleteContext, IDeleteFeature> deleteContextToFeatureMap = new LinkedHashMap<>();
				for(final PictogramElement pe : context.getPictogramElements()) {
					final DeleteContext deleteContext = new DeleteContext(pe);
					final IDeleteFeature deleteFeature = diagramTypeProvider.getFeatureProvider().getDeleteFeature(deleteContext);

					if(context.getPictogramElements().length > 1) {
						deleteContext.setMultiDeleteInfo(new MultiDeleteInfo(false, false, context.getPictogramElements().length));
					}
					
					if(!deleteFeature.canDelete(deleteContext)) {
						deleteContextToFeatureMap.clear();
						break;
					} else {
						deleteContextToFeatureMap.put(deleteContext, deleteFeature);
					}
				}

				if(!deleteContextToFeatureMap.isEmpty()) {
					final Map.Entry<DeleteContext, IDeleteFeature> firstEntry = deleteContextToFeatureMap.entrySet().iterator().next();

					if(firstEntry.getKey().getMultiDeleteInfo() != null) {
						firstEntry.getKey().getMultiDeleteInfo().setShowDialog(true);
					}
					
					contextMenu.add(new Action("Delete") {
						@Override
						public void run() {
							for(final DeleteContext deleteContext : deleteContextToFeatureMap.keySet()) {
								final IDeleteFeature deleteFeature = deleteContextToFeatureMap.get(deleteContext);
								editor.getDiagramBehavior().executeFeature(deleteFeature, deleteContext);
								if(deleteContext.getMultiDeleteInfo() != null && deleteContext.getMultiDeleteInfo().isDeleteCanceled()) {
									break;
								}
							}
						}
					});
				}

				// Custom Features
				for(int i = 0; i < customFeatures.length; i++) {
					final ICustomFeature customFeature = customFeatures[i];
					if(customFeature.isAvailable(context)) {
						final Action customFeatAction = new Action(customFeature.getName()) {
							public void run() {
								editor.getDiagramBehavior().executeFeature(customFeature, context);
							};
						};

						customFeatAction.setEnabled(customFeature.canExecute(context));
						contextMenu.add(customFeatAction);
					}
				}
			}
		});

		final Tree tree = viewer.getTree();
		final Menu menu = menuMgr.createContextMenu(tree);
		tree.setMenu(menu);

		if(editor.getGraphicalViewer() != null) {
			editor.getGraphicalViewer().addSelectionChangedListener(new ISelectionChangedListener() {
				@Override
				public void selectionChanged(final SelectionChangedEvent event) {
					updateOutlineSelectionIfLinked();
				}
			});
	
			editor.addPropertyListener(new IPropertyListener() {
				@Override
				public void propertyChanged(Object source, int propId) {
					if(!getTreeViewer().getTree().isDisposed() && getTreeViewer() != null) {
						getTreeViewer().refresh();
					}
				}
			});
	
			viewer.addSelectionChangedListener(this);
			viewer.setInput(editor);
		}
	}

	// Link With Editor action added to Outline menu
	@Override
	public void makeContributions(final IMenuManager menuManager, final IToolBarManager toolBarManager,
			final IStatusLineManager statusLineManager) {
		toolBarManager.add(linkWithEditorAction);
	}

	private void updateOutlineSelectionIfLinked() {
		if(!synchronizingSelection && linkWithEditorAction.isChecked()) {
			try {
				synchronizingSelection = true;
				final TreeViewer treeViewer = getTreeViewer();
				final Set<DiagramNode> outlineNodes = getCurrentlySelectedDiagramNodes();			
				if(treeViewer != null && 
						treeViewer.getContentProvider() != null && 
						!outlineNodes.equals(getSelectedDiagramNodesFromEditor())) {
					treeViewer.setSelection(buildDiagramNodeTreeSelectionFromEditor());
				}
			} finally {
				synchronizingSelection = false;
			}
		}
	}
	
	private TreeSelection buildDiagramNodeTreeSelectionFromEditor() {
		final Set<DiagramNode> selectedDiagramNodes = getSelectedDiagramNodesFromEditor();
		if(selectedDiagramNodes == null) {
			return TreeSelection.EMPTY;
		}
		
		final TreePath[] treePaths = selectedDiagramNodes.stream().map((dn) -> new TreePath(new Object[] { dn } )).toArray(TreePath[]::new);
		return new TreeSelection(treePaths);
	}
	
	private void updateEditorSelectionIfLinked() {
		try {
			if(!synchronizingSelection && linkWithEditorAction.isChecked() && !getSelection().isEmpty()) {
				// Select TreeItems on editor
				synchronizingSelection = true;
				selectEditorPictogramElements();
			}
		} finally {
			synchronizingSelection = false;
		}
	}
	
	private void selectEditorPictogramElements() {
		// Compare using diagram nodes to allow selecting labels when link with editor is enabled
		final Set<DiagramNode>  outlineNodes = getCurrentlySelectedDiagramNodes();
		final Set<DiagramNode> editorNodes = getSelectedDiagramNodesFromEditor();
		if(getTreeViewer() != null && 
				getTreeViewer().getContentProvider() != null && 
				!outlineNodes.equals(editorNodes)) {
			// Select pictogram elements
			editor.selectPictogramElements(getCurrentlySelectedPictogramElements());
		}
	}

	@Override
	public void selectionChanged(final SelectionChangedEvent event) {
		updateEditorSelectionIfLinked();
		super.selectionChanged(event);
	};

	/**
	 * Get DirectEditingContext
	 * @param pe - selected PictogramElement
	 * @return DirectEditingContext
	 */
	private static DirectEditingContext getDirectEditingContext(final PictogramElement pe) {
		if(pe instanceof ContainerShape) {
			for(final Shape shape : ((ContainerShape)pe).getChildren()) {
				final GraphicsAlgorithm ga = shape.getGraphicsAlgorithm();
				for(final GraphicsAlgorithm childGa : ga.getGraphicsAlgorithmChildren()) {
					if(childGa instanceof Text) {
						return new DirectEditingContext(ga.getPictogramElement(), childGa);
					}
				}

				if(ga instanceof Text) {
					return new DirectEditingContext(ga.getPictogramElement(), ga);
				}
			}
		} else if(pe instanceof Connection) {
			final Connection con = (Connection)pe;
			for(final ConnectionDecorator conDecorator : con.getConnectionDecorators()) {
				if(conDecorator.isActive()) {
					if(conDecorator.getGraphicsAlgorithm() instanceof Text) {
						return new DirectEditingContext(conDecorator, conDecorator.getGraphicsAlgorithm());
					}
				}
			}
		}

		return null;
	}
	
	private class ToggleLinkWithEditorAction extends Action {
		public ToggleLinkWithEditorAction() {
			super("Link With Editor", SWT.TOGGLE);
			
			// Default Link With Editor enabled
			setChecked(getEnabledFromPreferenceStore());
			setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_ELCL_SYNCED));
		}
		
		@Override
		public void run() {
			preferences.putBoolean(PREFERENCE_OUTLINE_LINK_WITH_EDITOR, isChecked());			
			updateOutlineSelectionIfLinked();
		}
		
		private boolean getEnabledFromPreferenceStore() {
			return preferences.getBoolean(PREFERENCE_OUTLINE_LINK_WITH_EDITOR, true);
		}
	};
	
	final Action linkWithEditorAction = new ToggleLinkWithEditorAction();
	
	private PictogramElement[] getCurrentlySelectedPictogramElements() {
		final Object[] outlineSelection = ((IStructuredSelection)getSelection()).toArray();
		final List<PictogramElement> pes = new ArrayList<>();
		final GraphitiAgeDiagram graphitiAgeDiagram = editor.getGraphitiAgeDiagram();
		for(final Object selectedDiagramNode : outlineSelection) {
			final PictogramElement pe = graphitiAgeDiagram.getPictogramElement((DiagramNode)selectedDiagramNode);
			if(pe != null) {
				pes.add(pe);
			}
		}
		
		return pes.toArray(new PictogramElement[pes.size()]);
	}
	
	// Sets are used in the following methods to allow correct comparison between editor and outline selection. The editor may have multiple pictogram 
	// elements for the same diagram node.
	/**
	 * Will never return null. 
	 * @return
	 */
	private Set<DiagramNode> getCurrentlySelectedDiagramNodes() {
		final Object[] outlineSelection = ((IStructuredSelection)getSelection()).toArray();
		final Set<DiagramNode> diagramNodes = new HashSet<>();
		for(final Object diagramNode : outlineSelection) {
			diagramNodes.add((DiagramNode)diagramNode);
		}
		
		return diagramNodes;
	}

	/**
	 * Will return null if it is unable to determine the diagram nodes for all the selected pictogram elements.
	 * @return
	 */
	private Set<DiagramNode> getSelectedDiagramNodesFromEditor() {
		final PictogramElement[] selectedPes = editor.getSelectedPictogramElements();
		final Set<DiagramNode> selectedDiagramNodes = new HashSet<>();
		final GraphitiAgeDiagram graphitiAgeDiagram = editor.getGraphitiAgeDiagram();
		for(final PictogramElement selectedPe : selectedPes) {
			if(selectedPe == null) {
				return null;
			}
			
			final DiagramNode diagramNode = graphitiAgeDiagram.getClosestDiagramElement(selectedPe);
			if(diagramNode == null) {
				return null;
			}
			
			selectedDiagramNodes.add(diagramNode);
		}
		
		return selectedDiagramNodes;
	}	
	
	// Rename Dialog
	private static class RenameDialog extends InputDialog {
		public RenameDialog(final Shell parentShell, final IDirectEditingFeature directEditingFeature, final DirectEditingContext directEditingContext) {
			super(parentShell, "Rename", "Enter Name", directEditingFeature.getInitialValue(directEditingContext), new IInputValidator() {
				@Override
				public String isValid(final String newName) {
					return directEditingFeature.checkValueValid(newName, directEditingContext);
				}
			});

			setShellStyle(getShellStyle() | SWT.RESIZE);
		}

		@Override
		protected void configureShell(final Shell shell) {
			super.configureShell(shell);
			shell.setMinimumSize(225, 185);
		}
	}
}
