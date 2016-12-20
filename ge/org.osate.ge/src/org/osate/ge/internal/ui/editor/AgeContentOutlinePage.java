package org.osate.ge.internal.ui.editor;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
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
import org.eclipse.jface.viewers.ITreeViewerListener;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeExpansionEvent;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IPropertyListener;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.views.contentoutline.ContentOutlinePage;
import org.osate.aadl2.NamedElement;
import org.osate.ge.internal.query.PictogramQuery;
import org.osate.ge.internal.query.QueryRunner;
import org.osate.ge.internal.query.RootPictogramQuery;
import org.osate.ge.internal.services.BusinessObjectResolutionService;
import org.osate.ge.internal.services.ConnectionService;
import org.osate.ge.internal.services.PropertyService;
import org.osate.ge.internal.services.RefactoringService;
import org.osate.ge.internal.services.InternalReferenceBuilderService;
import org.osate.ge.internal.services.NamingService;

public class AgeContentOutlinePage extends ContentOutlinePage {
	private static String IMAGE_ID_PREFIX = "org.osate.ge.";
	private boolean linkWithEditor;
	private AgeDiagramEditor editor;
	private QueryRunner queryRunner;
	private PictogramElement rootPictogramElement;
	private final PictogramQuery<Object> rootPictogramQuery = new RootPictogramQuery(() -> this.rootPictogramElement);
	private final PictogramQuery<Object> parentQuery = rootPictogramQuery.ancestor(1);
	private final PictogramQuery<Object> childrenQuery = rootPictogramQuery.children().filter((fa) -> fa.getBusinessObject() instanceof NamedElement);
	private final BusinessObjectResolutionService bor;

	public AgeContentOutlinePage(final AgeDiagramEditor editor) {
		this.editor = Objects.requireNonNull(editor, "editor must not be null");
		this.bor = (BusinessObjectResolutionService)editor.getAdapter(BusinessObjectResolutionService.class);
		this.queryRunner = new QueryRunner((PropertyService)editor.getAdapter(PropertyService.class),
				(ConnectionService)editor.getAdapter(ConnectionService.class), 
				bor, 
				(InternalReferenceBuilderService)editor.getAdapter(InternalReferenceBuilderService.class));
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
				if(inputElement instanceof AgeDiagramEditor) {
					final AgeDiagramEditor editor = (AgeDiagramEditor)inputElement;
					if(editor.getDiagramTypeProvider() != null) {
						return getChildren(editor.getDiagramTypeProvider().getDiagram());					
					}
				}

				return new Object[0];
			}

			@Override
			public Object[] getChildren(final Object parentElement) {
				if(parentElement instanceof PictogramElement) {
					rootPictogramElement = (PictogramElement)parentElement;
					return queryRunner.getPictogramElements(childrenQuery, null).toArray();
				}
				return new Object[0];
			}

			@Override
			public Object getParent(final Object element) {
				if(element instanceof PictogramElement) {
					rootPictogramElement = (PictogramElement)element;
					final Object parent = queryRunner.getFirstResult(parentQuery, null);
					return parent;
				}

				return false;
			}

			@Override
			public boolean hasChildren(final Object element) {
				if(element instanceof PictogramElement) {
					rootPictogramElement = (PictogramElement)element;
					return queryRunner.getFirstResult(childrenQuery, null) != null;
				}

				return false;
			}		
		});

		viewer.addTreeListener(new ITreeViewerListener() {
			@Override
			public void treeExpanded(final TreeExpansionEvent event) {
				if(linkWithEditor) {
					setSelection(viewer);
				}
			}

			@Override
			public void treeCollapsed(final TreeExpansionEvent event) {}
		});

		viewer.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(final Object element) {
				final Object bo = bor.getBusinessObjectForPictogramElement((PictogramElement)element);
				if(bo instanceof NamedElement) {
					final NamedElement ne = (NamedElement)bo;
					return ne.eClass().getName() + " " + ne.getName();
				}

				return "AA";
			}

			@Override
			public Image getImage(final Object element) {
				final Object bo = bor.getBusinessObjectForPictogramElement((PictogramElement)element);

				if(bo instanceof NamedElement) {
					final NamedElement ne = (NamedElement)bo;
					final String neImageId = IMAGE_ID_PREFIX + ne.eClass().getInstanceClass().getSimpleName();
					final Image neImage = GraphitiUi.getImageService().getImageDescriptorForId(diagramTypeProvider.getProviderId(), neImageId).createImage();

					return neImage;
				}

				return super.getImage(element);
			}
		});

		final MenuManager menuMgr = new MenuManager();
		menuMgr.setRemoveAllWhenShown(true);

		menuMgr.addMenuListener(new IMenuListener() {
			@Override
			public void menuAboutToShow(final IMenuManager contextMenu) {
				final ICustomContext context = new CustomContext(editor.getSelectedPictogramElements());
				final ICustomFeature[] customFeatures = diagramTypeProvider.getFeatureProvider().getCustomFeatures(context);				

				for(int i = 0; i < customFeatures.length; i++) {
					final ICustomFeature customFeature = customFeatures[i];
					if(customFeature.isAvailable(context)) {
						contextMenu.add(new Action(customFeature.getName()) {
							public void run() {
								customFeature.execute(context);
							};
						});
					}
				}

				final HashMap<IDeleteFeature, DeleteContext> iDelete = new HashMap<>();
				for(final PictogramElement pe : context.getPictogramElements()) {
					final DeleteContext deleteContext = new DeleteContext(pe);
					final IDeleteFeature deleteFeature = diagramTypeProvider.getFeatureProvider().getDeleteFeature(deleteContext);

					deleteContext.setMultiDeleteInfo(new MultiDeleteInfo(false, false, editor.getSelectedPictogramElements().length));
					if(!deleteFeature.canDelete(deleteContext)) {
						iDelete.clear();
						break;
					} else {
						iDelete.put(deleteFeature, deleteContext);
					}
				}
				
				if(!iDelete.isEmpty()) {
					final Map.Entry<IDeleteFeature, DeleteContext> firstEntry = iDelete.entrySet().iterator().next();
					firstEntry.getValue().getMultiDeleteInfo().setShowDialog(true);
					contextMenu.add(new Action(firstEntry.getKey().getName()) {
						@Override
						public void run() {
							for(final IDeleteFeature deleteFeature : iDelete.keySet()) {
								final DeleteContext deleteContext = iDelete.get(deleteFeature);
								deleteFeature.delete(deleteContext);
								if(deleteContext.getMultiDeleteInfo().isDeleteCanceled()) {
									break;
								}
							}
						}
					});
				}
				
				final PictogramElement pe = context.getPictogramElements()[0];
				final DirectEditingContext directEditingContext = getDirectEditingContext(pe);

				if(directEditingContext != null) {
					final Object bo = bor.getBusinessObjectForPictogramElement(pe);
					final IDirectEditingFeature directEditingFeature = editor.getDiagramTypeProvider().getFeatureProvider().getDirectEditingFeature(directEditingContext);
					
					if(context.getPictogramElements().length == 1 && bo instanceof NamedElement && directEditingFeature.canDirectEdit(directEditingContext)) {
						final NamedElement namedElement = (NamedElement)bo;
						menuMgr.add(new Action("Rename") {
							@Override
							public void run() {
								final NamingService namingService = (NamingService)editor.getAdapter(NamingService.class);
								final RefactoringService refactoringService = (RefactoringService)editor.getAdapter(RefactoringService.class);
		
								final NameDialog nameDialog = new NameDialog(Display.getCurrent().getActiveShell(), namedElement, namingService);
								if(nameDialog.open() == Dialog.CANCEL || nameDialog.getValue() == null) {
									return;
								}
		
								refactoringService.renameElement(namedElement, nameDialog.getValue());
							}
						});
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
				if(linkWithEditor) {
					setSelection(viewer);
				}
			}
		});

		editor.addPropertyListener(new IPropertyListener() {
			@Override
			public void propertyChanged(Object source, int propId) {
				if(getTreeViewer() != null) {
					getTreeViewer().refresh();
				}
			}
		});

		viewer.addSelectionChangedListener(this);
		viewer.setInput(editor);
	}

	@Override
	public void makeContributions(final IMenuManager menuManager, final IToolBarManager toolBarManager,
			final IStatusLineManager statusLineManager) {		
		final Action action = new Action("Link With Editor", SWT.TOGGLE) {
			@Override
			public void run() {
				linkWithEditor = isChecked();
				if(linkWithEditor && !getSelection().isEmpty()) {
					selectPictogramElements(((IStructuredSelection)getSelection()).toArray());
				}
			}
		};

		linkWithEditor = true;
		action.setChecked(true);
		final URL url = FileLocator.find(Platform.getBundle(PlatformUI.PLUGIN_ID), new Path("/icons/full/elcl16/synced.gif"), null);
		action.setImageDescriptor(ImageDescriptor.createFromURL(url));

		toolBarManager.add(action);
	}

	private void selectPictogramElements(final Object[] ss) {
		final PictogramElement[] treePes = Arrays.copyOf(ss, ss.length, PictogramElement[].class);
		final ArrayList<PictogramElement> editorPes = new ArrayList<>(Arrays.asList(editor.getSelectedPictogramElements()));

		if(!editorPes.contains(treePes[0]) || editorPes.size() != ss.length) {
			editor.selectPictogramElements(treePes);
		}
	}

	private void setSelection(final TreeViewer viewer) {
		final ITreeContentProvider treeContentProvider = (ITreeContentProvider)viewer.getContentProvider();
		if(treeContentProvider != null) {
			final ArrayList<TreePath> list = new ArrayList<TreePath>();
			for(final PictogramElement selectedPe : editor.getSelectedPictogramElements()) {
				if(selectedPe != null && !(selectedPe instanceof ConnectionDecorator)) {
					for(final Object ob : treeContentProvider.getElements(editor)) {
						list.addAll(findAndSelectTreeElement(viewer, ob, selectedPe));
					}
				}
			}

			viewer.setSelection(new TreeSelection(list.toArray(new TreePath[list.size()])));
		}
	}

	@Override
	public void selectionChanged(final SelectionChangedEvent event) {
		if(linkWithEditor && !getSelection().isEmpty()) {
			selectPictogramElements(((IStructuredSelection)getSelection()).toArray());
		}
	};

	private List<TreePath> findAndSelectTreeElement(final TreeViewer viewer, final Object element, final PictogramElement selectedPe) {
		final ArrayList<TreePath> treeElements = new ArrayList<>();
		final ITreeContentProvider treeContentProvider = (ITreeContentProvider)viewer.getContentProvider();
		if(treeContentProvider.hasChildren(element)) {
			for(final Object childEle : treeContentProvider.getChildren(element)) {
				if(selectedPe == childEle) {
					treeElements.addAll(findAndSelectTreeElement(viewer, childEle, selectedPe));
				}
			}
		}

		if(selectedPe == element) {
			treeElements.add(new TreePath(new Object[] { element } ));
		}

		return treeElements;
	}
	
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
		}
		
		return null;
	}

	// Rename Dialog
	private static class NameDialog extends InputDialog {
		public NameDialog(final Shell parentShell, final NamedElement ne, final NamingService namingService) {
			super(parentShell, "Rename", "Rename the element", ne.getName(), new IInputValidator() {
				@Override
				public String isValid(final String newName) {
					return namingService.checkNameValidity(ne, newName);
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
