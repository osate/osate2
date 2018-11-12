package org.osate.ge.internal.ui.editor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.IEclipsePreferences.IPreferenceChangeListener;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.part.IPageSite;
import org.eclipse.ui.views.contentoutline.ContentOutlinePage;
import org.osate.ge.internal.Activator;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.DiagramNode;
import org.osate.ge.internal.graphiti.diagram.GraphitiAgeDiagram;
import org.osate.ge.internal.ui.util.ImageUiHelper;
import org.osate.ge.internal.ui.util.UiUtil;
import org.osate.ge.internal.util.StringUtil;

public class AgeContentOutlinePage extends ContentOutlinePage {
	private static final String PREFERENCE_OUTLINE_LINK_WITH_EDITOR = "outline.linkWithEditor";
	private IEclipsePreferences preferences = InstanceScope.INSTANCE.getNode(Activator.PLUGIN_ID);

	private AgeDiagramEditor editor;
	private final Action linkWithEditorAction = new ToggleLinkWithEditorAction();

	// Flag for indicating the the outline and editor selection is being synchronized.
	// Used to avoid adjusting either selection in response to a change to itself.
	// This is important to allow selecting items in the editor which aren't contained in the outline.
	private boolean synchronizingSelection = false;

	public AgeContentOutlinePage(final AgeDiagramEditor editor) {
		this.editor = Objects.requireNonNull(editor, "editor must not be null");
		preferences.addPreferenceChangeListener(preferenceChangeListener);
	}

	@Override
	public void init(IPageSite pageSite) {
		super.init(pageSite);
		final ActionRegistry actionRegistry = Objects.requireNonNull(editor.getActionRegistry(),
				"Unable to retrieve action registry");
		final IActionBars actionBars = pageSite.getActionBars();
		registerGlobalActionHandler(actionBars, actionRegistry, ActionFactory.UNDO.getId());
		registerGlobalActionHandler(actionBars, actionRegistry, ActionFactory.REDO.getId());
		registerGlobalActionHandler(actionBars, actionRegistry, ActionFactory.COPY.getId());
		registerGlobalActionHandler(actionBars, actionRegistry, ActionFactory.PASTE.getId());
		registerGlobalActionHandler(actionBars, actionRegistry, ActionFactory.PRINT.getId());
		registerGlobalActionHandler(actionBars, actionRegistry, ActionFactory.SAVE_AS.getId());
	}

	private static void registerGlobalActionHandler(final IActionBars actionBars, final ActionRegistry actionRegistry,
			final String actionId) {
		actionBars.setGlobalActionHandler(actionId, actionRegistry.getAction(actionId));
	}

	@Override
	public void dispose() {
		preferences.removePreferenceChangeListener(preferenceChangeListener);
		super.dispose();
	}

	private final IPreferenceChangeListener preferenceChangeListener = event -> {
		// Update the state of the button based on the new property value.
		// This will not trigger a synchronization.
		if (PREFERENCE_OUTLINE_LINK_WITH_EDITOR.equals(event.getKey())) {
			if(event.getNewValue() != null) {
				linkWithEditorAction.setChecked(Boolean.parseBoolean(event.getNewValue().toString()));
			}
		}
	};

	@Override
	public void createControl(final Composite parent) {
		super.createControl(parent);

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
					return ((DiagramNode) parentElement).getDiagramElements().stream().filter(
							(de) -> de.getUserInterfaceName() != null || de.getBusinessObject() instanceof EObject)
							.toArray();
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

		viewer.setComparator(new ViewerComparator());

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

					if (de.getUserInterfaceName() != null) {
						lblTxt += de.getUserInterfaceName();
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

		viewer.addDoubleClickListener(event -> UiUtil.openPropertiesView());

		final MenuManager menuMgr = new MenuManager();
		menuMgr.setRemoveAllWhenShown(true);

		final Tree tree = viewer.getTree();
		final Menu menu = menuMgr.createContextMenu(tree);
		tree.setMenu(menu);
		getSite().registerContextMenu("org.osate.ge.editor.AgeDiagramEditor", menuMgr, viewer); // Allow contributions

		if(editor.getGraphicalViewer() != null) {
			editor.getGraphicalViewer().addSelectionChangedListener(event -> updateOutlineSelectionIfLinked());

			editor.addPropertyListener((source, propId) -> {
				if(!getTreeViewer().getTree().isDisposed() && getTreeViewer() != null) {
					getTreeViewer().refresh();
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
}
