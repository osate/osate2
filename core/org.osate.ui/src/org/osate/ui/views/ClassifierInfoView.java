package org.osate.ui.views;

import org.eclipse.jface.layout.TreeColumnLayout;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.ViewPart;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentType;

public final class ClassifierInfoView extends ViewPart implements ISelectionListener {
	/**
	 * The current selection.
	 */
	private ISelection currentSelection;

	private Label label2;

	private TreeViewer ancestorTree;

	public ClassifierInfoView() {
		// TODO Auto-generated constructor stub
	}

	// ======================================================================
	// == Creation and clean up of all the UI stuff
	// ======================================================================

	@Override
	public void createPartControl(final Composite parent) {
		final SashForm sash = new SashForm(parent, SWT.HORIZONTAL);

		ancestorTree = createAncestorTree(sash);

//		label1 = new Label(sash, SWT.LEFT);
//		label1.setText("Hierarchy section");

		label2 = new Label(sash, SWT.LEFT);
		label2.setText("Member section");
	}

	@Override
	public void init(final IViewSite site) throws PartInitException {
		site.getPage().addPostSelectionListener(this);
		super.init(site);
	}

	@Override
	public void dispose() {
		getSite().getPage().removePostSelectionListener(this);
		currentSelection = null;
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub
	}

	private TreeViewer createAncestorTree(final Composite parent) {
		final Composite treeComposite = new Composite(parent, SWT.NONE);
		final TreeColumnLayout treeColumnLayout = new TreeColumnLayout();
		treeComposite.setLayout(treeColumnLayout);

		final TreeViewer treeViewer = new TreeViewer(treeComposite, SWT.H_SCROLL | SWT.V_SCROLL);
		treeViewer.getTree().setLinesVisible(false);
		treeViewer.getTree().setHeaderVisible(false);
		treeViewer.getTree().setFont(parent.getFont());

		final TreeViewerColumn treeViewerCol = new TreeViewerColumn(treeViewer, SWT.LEFT);
		treeColumnLayout.setColumnData(treeViewerCol.getColumn(), new ColumnWeightData(1, true));
		treeViewerCol.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(final Object element) {
				final ComponentClassifier componentClassifier = (ComponentClassifier) element;
				return componentClassifier.getCategory() + " " + componentClassifier.getQualifiedName();
			}
		});
		treeViewer.setContentProvider(new ITreeContentProvider() {
			@Override
			public boolean hasChildren(final Object element) {
				// TODO Feature Groups
				// TODO Component Implementation
				if (element instanceof ComponentType) {
					return ((ComponentType) element).getExtended() != null;
				} else {
					return false;
				}
			}

			@Override
			public Object getParent(Object element) {
				return null;
			}

			@Override
			public Object[] getElements(Object inputElement) {
				if (inputElement != null) {
					return ((AncestorTreeRoot) inputElement).getChildren();
				} else {
					return new Object[0];
				}
			}

			@Override
			public Object[] getChildren(Object parentElement) {
				// TODO Feature Groups
				// TODO Component Implementation
				if (parentElement instanceof ComponentType) {
					return new Object[] { ((ComponentType) parentElement).getExtended() };
				} else {
					return new Object[0];
				}
			}
		});

		return treeViewer;
	}

	// ======================================================================
	// == Listeners
	// ======================================================================

	@Override
	public void selectionChanged(final IWorkbenchPart part, final ISelection selection) {
		if (part == null || selection == null | selection.equals(currentSelection)) {
			return;
		}

		currentSelection = selection;

		String classifier = null;
		ComponentClassifier input = null;
		if (selection.isEmpty()) {
			classifier = "<no selection>";
		} else if (selection instanceof IStructuredSelection) {
			final Object selectedObject = ((IStructuredSelection) selection).getFirstElement();
			if (selectedObject == null) {
				classifier = "<selection is null>";
			} else if (selectedObject instanceof ComponentClassifier) {
				input = (ComponentClassifier) selectedObject;
				classifier = ((ComponentClassifier) selectedObject).getQualifiedName();
			} else {
				classifier = "<selection is not a component classifier: " + selectedObject.getClass() + ">";
			}
		} else {
			classifier = "<not structured>";
		}
		if (input != null) {
			ancestorTree.setInput(new AncestorTreeRoot(input));
		}
		label2.setText(classifier);
	}

	// ======================================================================
	// == Helper classes
	// ======================================================================

	private static final class AncestorTreeRoot {
		private final Object[] children;

		public AncestorTreeRoot(final ComponentClassifier componentClassifier) {
			children = new Object[] { componentClassifier };
		}

		public Object[] getChildren() {
			return children;
		}
	}
}
