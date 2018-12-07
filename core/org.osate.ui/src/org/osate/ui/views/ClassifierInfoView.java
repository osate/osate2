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
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.FeatureGroupType;

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
				return ((AncestorTreeNode) element).getLabel();
			}
		});
		treeViewer.setContentProvider(new ITreeContentProvider() {
			@Override
			public boolean hasChildren(final Object element) {
				return ((AncestorTreeNode) element).hasChildren();
			}

			@Override
			public Object getParent(Object element) {
				return ((AncestorTreeNode) element).getParent();
			}

			@Override
			public Object[] getElements(Object inputElement) {
				if (inputElement != null) {
					return ((AncestorTree) inputElement).getChildren();
				} else {
					return new Object[0];
				}
			}

			@Override
			public Object[] getChildren(Object parentElement) {
				return ((AncestorTreeNode) parentElement).getChildren();
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
		Classifier input = null;
		if (selection.isEmpty()) {
			classifier = "<no selection>";
		} else if (selection instanceof IStructuredSelection) {
			final Object selectedObject = ((IStructuredSelection) selection).getFirstElement();
			if (selectedObject == null) {
				classifier = "<selection is null>";
			} else if (selectedObject instanceof Classifier) {
				input = (Classifier) selectedObject;
				classifier = ((Classifier) selectedObject).getQualifiedName();
			} else {
				classifier = "<selection is not a component classifier: " + selectedObject.getClass() + ">";
			}
		} else {
			classifier = "<not structured>";
		}
		if (input != null) {
			ancestorTree.setInput(AncestorTree.createFor(input));
		}
		label2.setText(classifier);
	}

	// ======================================================================
	// == Helper classes
	// ======================================================================

	private static final class AncestorTree {
		private final AncestorTreeRoot[] children;

		private AncestorTree(final AncestorTreeRoot root) {
			children = new AncestorTreeRoot[] { root };
		}

		public AncestorTreeRoot[] getChildren() {
			return children;
		}

		public static AncestorTree createFor(final Classifier classifier) {
			return new AncestorTree(AncestorTreeRoot.create(classifier));
		}
	}

	private static abstract class AncestorTreeNode {
		protected final Classifier classifier;
		private AncestorTreeNode parent;
		private AncestorTreeNode[] children;

		private AncestorTreeNode(final Classifier classifier, final AncestorTreeNode[] children) {
			this.classifier = classifier;
			this.children = children;
			for (final AncestorTreeNode child : children) {
				child.setParent(this);
			}
		}

		public abstract String getLabel();

		public final boolean hasChildren() {
			return children.length > 0;
		}

		public final AncestorTreeNode[] getChildren() {
			return children;
		}

		public final AncestorTreeNode getParent() {
			return parent;
		}

		final void setParent(final AncestorTreeNode parent) {
			this.parent = parent;
		}
	}

	private static final class AncestorTreeRoot extends AncestorTreeNode {
		private AncestorTreeRoot(final Classifier classifier, final AncestorTreeNode[] children) {
			super(classifier, children);
		}

		public static AncestorTreeRoot create(final Classifier classifier) {
			AncestorTreeNode[] children = new AncestorTreeNode[0];
			if (classifier instanceof ComponentType) {
				final ComponentType extended = ((ComponentType) classifier.getExtended());
				if (extended != null) {
					children = new AncestorTreeNode[] { AncestorTreeAncestor.create(extended) };
				}
			} else if (classifier instanceof FeatureGroupType) {
				final FeatureGroupType extended = ((FeatureGroupType) classifier).getExtended();
				if (extended != null) {
					children = new AncestorTreeNode[] { AncestorTreeAncestor.create(extended) };
				}
			}
			return new AncestorTreeRoot(classifier, children);
		}

		@Override
		public String getLabel() {
			if (classifier instanceof ComponentType) {
				return ((ComponentType) classifier).getCategory() + " " + classifier.getQualifiedName();
			} else if (classifier instanceof FeatureGroupType) {
				return "feature group " + classifier.getQualifiedName();
			} else {
				return "***";
			}
		}
	}

	private static final class AncestorTreeAncestor extends AncestorTreeNode {
		private AncestorTreeAncestor(final Classifier classifier, final AncestorTreeNode[] children) {
			super(classifier, children);
		}

		public static AncestorTreeAncestor create(final Classifier classifier) {
			AncestorTreeNode[] children = new AncestorTreeNode[0];
			if (classifier instanceof ComponentType) {
				final ComponentType extended = ((ComponentType) classifier.getExtended());
				if (extended != null) {
					children = new AncestorTreeNode[] { AncestorTreeAncestor.create(extended) };
				}
			} else if (classifier instanceof FeatureGroupType) {
				final FeatureGroupType extended = ((FeatureGroupType) classifier).getExtended();
				if (extended != null) {
					children = new AncestorTreeNode[] { AncestorTreeAncestor.create(extended) };
				}
			}
			return new AncestorTreeAncestor(classifier, children);
		}

		@Override
		public String getLabel() {
			if (classifier instanceof ComponentType) {
				return "extends " + ((ComponentType) classifier).getCategory() + " " + classifier.getQualifiedName();
			} else if (classifier instanceof FeatureGroupType) {
				return "extends feature group " + classifier.getQualifiedName();
			} else {
				return "extends ***";
			}
		}
	}

}
