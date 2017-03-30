package org.osate.ge.internal.ui.editor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;


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
import org.eclipse.graphiti.ui.services.GraphitiUi;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.resource.ImageDescriptor;
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
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IPropertyListener;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.views.contentoutline.ContentOutlinePage;
import org.osate.aadl2.NamedElement;
import org.osate.ge.internal.diagram.DiagramElement;
import org.osate.ge.internal.diagram.DiagramNode;
import org.osate.ge.internal.services.BusinessObjectResolutionService;
import org.osate.ge.internal.util.ImageHelper;
import org.osate.ge.internal.util.StringUtil;

public class AgeContentOutlinePage extends ContentOutlinePage {
	private AgeDiagramEditor editor;
	private final BusinessObjectResolutionService bor;
	
	public AgeContentOutlinePage(final AgeDiagramEditor editor) {
		this.editor = Objects.requireNonNull(editor, "editor must not be null");
		this.bor = Objects.requireNonNull((BusinessObjectResolutionService)editor.getAdapter(BusinessObjectResolutionService.class), "Unable to retrieve business object resolution service");
	}

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
				// TODO: Need access to AgeDiagram
				// return getChildren(getAgeDiagram()));
				return new Object[0];
			}

			@Override
			public Object[] getChildren(final Object parentElement) {
				if(parentElement instanceof DiagramNode) {
					return ((DiagramNode) parentElement).getDiagramElements().toArray();
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
					return ((DiagramNode) element).getDiagramElements().size() > 0;
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
			public String getText(Object element) {
				final Object bo = bor.getBusinessObjectForPictogramElement((PictogramElement)element);
				if(bo instanceof NamedElement) {
					final NamedElement ne = (NamedElement)bo;

					return StringUtil.camelCaseToUser(ne.eClass().getName()) + " " + ne.getName();
				}

				return super.getText(element);
			}

			@Override
			public Image getImage(final Object element) {
				final Object bo = bor.getBusinessObjectForPictogramElement((PictogramElement)element);
				if(bo instanceof NamedElement) {
					final NamedElement ne = (NamedElement)bo;
					final ImageDescriptor imgDesc = GraphitiUi.getImageService().getImageDescriptorForId(diagramTypeProvider.getProviderId(),
							ImageHelper.getImage(ne.eClass().getName()));

					// Check if ImageDescriptor has a valid type.
					final ImageData imageData = imgDesc.getImageData();
					if(imageData != null && imageData.type >= 0) {
						return imgDesc.createImage();
					}
				}

				return super.getImage(element);
			}
		});

		final MenuManager menuMgr = new MenuManager();
		menuMgr.setRemoveAllWhenShown(true);

		menuMgr.addMenuListener(new IMenuListener() {
			@Override
			public void menuAboutToShow(final IMenuManager contextMenu) {
				final Object[] ss = ((IStructuredSelection)getSelection()).toArray();
				final PictogramElement[] treePes = Arrays.copyOf(ss, ss.length, PictogramElement[].class);
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

		editor.getGraphicalViewer().addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(final SelectionChangedEvent event) {
				if(linkWithEditorAction.isChecked()) {
					final TreeViewer treeViewer = getTreeViewer();
					final Object[] ss = ((IStructuredSelection)getSelection()).toArray();
					final PictogramElement[] treePes = Arrays.copyOf(ss, ss.length, PictogramElement[].class);
					
					if(treeViewer != null && treeViewer.getContentProvider() != null && updateLinkWithEditor(treePes, editor.getSelectedPictogramElements())) {
						treeViewer.setSelection(getTreeSelection());
					}
				}
			}

			private TreeSelection getTreeSelection() {
				final ArrayList<TreePath> treePathList = new ArrayList<>();
				final PictogramElement[] selectedPes = editor.getSelectedPictogramElements();
				for(final PictogramElement selectedPe : selectedPes) {
					if(selectedPe == null || (selectedPe instanceof ConnectionDecorator)) {
						return TreeSelection.EMPTY;
					}

					treePathList.add(new TreePath(new Object[] { selectedPe } ));
				}

				return new TreeSelection(treePathList.toArray(new TreePath[treePathList.size()]));
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

	// Link With Editor action added to Outline menu
	@Override
	public void makeContributions(final IMenuManager menuManager, final IToolBarManager toolBarManager,
			final IStatusLineManager statusLineManager) {
		// Default Link With Editor enabled
		linkWithEditorAction.setChecked(true);
		linkWithEditorAction.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_ELCL_SYNCED));
		toolBarManager.add(linkWithEditorAction);
	}

	private void selectEditorPictogramElements() {
		final Object[] ss = ((IStructuredSelection)getSelection()).toArray();
		final PictogramElement[] treePes = Arrays.copyOf(ss, ss.length, PictogramElement[].class);
		final PictogramElement[] editorPes = editor.getSelectedPictogramElements();
		if(getTreeViewer() != null && getTreeViewer().getContentProvider() != null && updateLinkWithEditor(treePes, editorPes)) {
			editor.selectPictogramElements(treePes);
		}
	}

	// Check if Link With Editor elements needs updated
	private boolean updateLinkWithEditor(final PictogramElement[] treePes, final PictogramElement[] editorPes) {
		return !Arrays.equals(treePes, editorPes);
	}

	@Override
	public void selectionChanged(final SelectionChangedEvent event) {
		if(linkWithEditorAction.isChecked() && !getSelection().isEmpty()) {
			// Select TreeItems on editor
			selectEditorPictogramElements();
		}
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
	
	private final Action linkWithEditorAction = new Action("Link With Editor", SWT.TOGGLE) {
		@Override
		public void run() {
			// Select elements in editor if TreeItems are selected
			if(linkWithEditorAction.isChecked() && !getSelection().isEmpty()) {
				selectEditorPictogramElements();
			}
		}
	};

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
