package org.osate.ui.views;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.layout.TreeColumnLayout;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.ViewPart;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.Prototype;
import org.osate.ui.UiUtil;

public final class ClassifierInfoView extends ViewPart implements ISelectionListener {
	/**
	 * The current selection.
	 */
	private ISelection currentSelection;

	private TreeViewer ancestorTree;
	private TreeViewer memberTree;

	private final ILabelProvider modelElementLabelProvider;
	private Image aadlImage;

	public ClassifierInfoView() {
		modelElementLabelProvider = UiUtil.getModelElementLabelProvider();
	}

	// ======================================================================
	// == Creation and clean up of all the UI stuff
	// ======================================================================

	@Override
	public void createPartControl(final Composite parent) {
		final SashForm sash = new SashForm(parent, SWT.HORIZONTAL);

		ancestorTree = createAncestorTree(sash);
		memberTree = createMemberTree(sash);
	}

	@Override
	public void init(final IViewSite site) throws PartInitException {
		site.getPage().addPostSelectionListener(this);
		aadlImage = new Image(site.getShell().getDisplay(),
				ClassifierInfoView.class.getResourceAsStream("/icons/aadl.gif"));
		super.init(site);
	}

	@Override
	public void dispose() {
		getSite().getPage().removePostSelectionListener(this);
		aadlImage.dispose();
		aadlImage = null;
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
			public Image getImage(Object element) {
				return ((AncestorTreeNode) element).getImage();
			}

			@Override
			public String getText(final Object element) {
				return ((AncestorTreeNode) element).getText();
			}
		});
		treeViewer.setContentProvider(new ITreeContentProvider() {
			@Override
			public boolean hasChildren(final Object element) {
				return ((AncestorTreeNode) element).hasChildren();
			}

			@Override
			public Object getParent(final Object element) {
				return ((AncestorTreeNode) element).getParent();
			}

			@Override
			public Object[] getElements(final Object inputElement) {
				if (inputElement != null) {
					return ((AncestorTree) inputElement).getChildren();
				} else {
					return new Object[0];
				}
			}

			@Override
			public Object[] getChildren(final Object parentElement) {
				return ((AncestorTreeNode) parentElement).getChildren();
			}
		});

		return treeViewer;
	}

	private TreeViewer createMemberTree(final Composite parent) {
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
			public Image getImage(Object element) {
				return ((MemberTreeNode) element).getImage();
			}

			@Override
			public String getText(final Object element) {
				return ((MemberTreeNode) element).getText();
			}
		});
		treeViewer.setContentProvider(new ITreeContentProvider() {
			@Override
			public boolean hasChildren(final Object element) {
				return ((MemberTreeNode) element).hasChildren();
			}

			@Override
			public Object getParent(final Object element) {
//				return ((AncestorTreeNode) element).getParent();
				return null;
			}

			@Override
			public Object[] getElements(final Object inputElement) {
				if (inputElement != null) {
					return ((MemberTree) inputElement).getSections();
				} else {
					return new Object[0];
				}
			}

			@Override
			public Object[] getChildren(final Object parentElement) {
				return ((MemberTreeNode) parentElement).getChildren();
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

		Classifier input = null;
		if (selection.isEmpty()) {
//			classifier = "<no selection>";
		} else if (selection instanceof IStructuredSelection) {
			final Object selectedObject = ((IStructuredSelection) selection).getFirstElement();
			if (selectedObject == null) {
//				classifier = "<selection is null>";
			} else if (selectedObject instanceof Classifier) {
				input = (Classifier) selectedObject;
//				classifier = ((Classifier) selectedObject).getQualifiedName();
			} else {
//				classifier = "<selection is not a component classifier: " + selectedObject.getClass() + ">";
			}
		} else {
//			classifier = "<not structured>";
		}
		if (input != null) {
			ancestorTree.setInput(createAncestorTree(input));
			if (input instanceof ComponentType) {
				memberTree.setInput(createMemberTree((ComponentType) input));
				memberTree.expandToLevel(2);
				printOut((ComponentType) input);
			}
		}
	}

	private void printOut(final ComponentType ct) {
		System.out.println();
		final List<Prototype> prototypes = ct.getAllPrototypes();
		for (final Prototype p : prototypes) {
			final ComponentType q = (ComponentType) p.eContainer();
			final boolean isLocal = q.equals(ct);
			final boolean isRefined = p.getRefined() != null;
			System.out.print(modelElementLabelProvider.getText(p));
			if (!isLocal) {
				System.out.print(" [from " + q.getFullName() + "]");
			}
			if (isRefined) {
				System.out.print(" [refined]");
			}
			System.out.println();
		}
	}

	// ======================================================================
	// == Helper classes
	// ======================================================================

	// ----------------------------------------------------------------------
	// -- Ancestor tree
	// ----------------------------------------------------------------------

	private final class AncestorTree {
		private final AncestorTreeNode[] children;

		private AncestorTree(final AncestorTreeNode root) {
			children = new AncestorTreeNode[] { root };
		}

		public AncestorTreeNode[] getChildren() {
			return children;
		}
	}

	private AncestorTree createAncestorTree(final Classifier classifier) {
		return new AncestorTree(createAncestorTreeNode(classifier, ""));
	}

	private final class AncestorTreeNode {
		protected final Classifier classifier;
		private final String prefix;
		private AncestorTreeNode parent;
		private AncestorTreeNode[] children;

		private AncestorTreeNode(final Classifier classifier, final String prefix, final AncestorTreeNode[] children) {
			this.classifier = classifier;
			this.prefix = prefix;
			this.children = children;
			for (final AncestorTreeNode child : children) {
				child.setParent(this);
			}
		}

		public Image getImage() {
			return modelElementLabelProvider.getImage(classifier);
		}

		public String getText() {
			return prefix + modelElementLabelProvider.getText(classifier);
		}

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

	private AncestorTreeNode createAncestorTreeNode(final Classifier classifier, final String prefix) {
		AncestorTreeNode[] children = new AncestorTreeNode[0];
		if (classifier instanceof ComponentType) {
			final ComponentType extended = ((ComponentType) classifier.getExtended());
			if (extended != null) {
				children = new AncestorTreeNode[] { createAncestorTreeNode(extended, "extends ") };
			}
		} else if (classifier instanceof ComponentImplementation) {
			final ComponentImplementation asCompImpl = (ComponentImplementation) classifier;
			final ComponentType implemented = asCompImpl.getType();
			final ComponentImplementation extended = asCompImpl.getExtended();
			if (extended == null) {
				children = new AncestorTreeNode[] { createAncestorTreeNode(implemented, "implements ") };
			} else {
				children = new AncestorTreeNode[] { createAncestorTreeNode(implemented, "implements "),
						createAncestorTreeNode(extended, "extends ") };
			}
		} else if (classifier instanceof FeatureGroupType) {
			final FeatureGroupType asFeatureGroup = (FeatureGroupType) classifier;
			final FeatureGroupType inverseOf = asFeatureGroup.getInverse();
			final FeatureGroupType extended = asFeatureGroup.getExtended();
			final List<AncestorTreeNode> childrenList = new ArrayList<>(2);
			if (inverseOf != null) {
				childrenList.add(createAncestorTreeNode(inverseOf, "inverse of "));
			}
			if (extended != null) {
				childrenList.add(createAncestorTreeNode(extended, "extends "));
			}
			children = childrenList.toArray(children);
		}
		return new AncestorTreeNode(classifier, prefix, children);
	}

	// ----------------------------------------------------------------------
	// -- Member tree
	// ----------------------------------------------------------------------

	private final static class MemberTree {
		private final SectionNode[] sections;

		private MemberTree(List<SectionNode> sectionsList) {
			sections = sectionsList.toArray(new SectionNode[sectionsList.size()]);
		}

		public SectionNode[] getSections() {
			return sections;
		}
	}

	public MemberTree createMemberTree(final ComponentType ct) {
		final List<SectionNode> sections = new ArrayList<>();
		final List<Prototype> prototypes = ct.getAllPrototypes();
		if (prototypes != null && prototypes.size() > 0) {
			sections.add(createPrototypesSection(ct, prototypes));
		}
		final List<Feature> features = ct.getAllFeatures();
		if (features != null && features.size() > 0) {
			sections.add(createFeaturesSection(ct, features));
		}
		return new MemberTree(sections);
	}

	private static interface MemberTreeNode {
		public String getText();

		public Image getImage();
		public boolean hasChildren();
		public Object[] getChildren();
	}

	private final class SectionNode implements MemberTreeNode {
		private final String heading;
		private final MemberNode[] members;

		private SectionNode(final String heading, List<MemberNode> membersList) {
			this.heading = heading;
			this.members = membersList.toArray(new MemberNode[membersList.size()]);
		}

		@Override
		public String getText() {
			return heading;
		}

		@Override
		public Image getImage() {
			return aadlImage;
		}

		@Override
		public boolean hasChildren() {
			return members.length > 0;
		}

		@Override
		public MemberNode[] getChildren() {
			return members;
		}
	}

	public SectionNode createPrototypesSection(final ComponentType ct, final List<Prototype> prototypes) {
		final List<MemberNode> members = new ArrayList<>();
		for (final Prototype p : prototypes) {
			members.add(createPrototypeNode(ct, p));
		}
		return new SectionNode("Prototypes", members);
	}

	public SectionNode createFeaturesSection(final ComponentType ct, final List<Feature> features) {
		final List<MemberNode> members = new ArrayList<>();
		for (final Feature f : features) {
			members.add(createFeatureNode(ct, f));
		}
		return new SectionNode("Features", members);
	}

	private final class MemberNode implements MemberTreeNode {
		private final Object member;
		private final String name;
		private final Classifier inheritedFrom;
		private final boolean isRefined;
		private final MemberNode[] ancestorMember;

		private MemberNode(final Object m, final String n, final Classifier from, final boolean refined,
				final MemberNode ancestor) {
			member = m;
			name = n;
			inheritedFrom = from;
			isRefined = refined;
			ancestorMember = ancestor == null ? new MemberNode[0] : new MemberNode[] { ancestor };
		}

		@Override
		public String getText() {
			return (isRefined ? "refined " : "") + name
					+ (inheritedFrom != null ? (" [from " + inheritedFrom.getName() + "]") : "");
		}

		@Override
		public Image getImage() {
			return modelElementLabelProvider.getImage(member);
		}

		@Override
		public boolean hasChildren() {
			return ancestorMember.length > 0;
		}

		@Override
		public MemberNode[] getChildren() {
			return ancestorMember;
		}
	}

	public MemberNode createPrototypeNode(final ComponentType ct, final Prototype prototype) {
		final ComponentType q = (ComponentType) prototype.eContainer();
		final boolean isLocal = q.equals(ct);
		final Prototype refined = prototype.getRefined();
		final boolean isRefined = refined != null;
		return new MemberNode(prototype, prototype.getName(), isLocal ? null : q, isRefined,
				!isRefined ? null : createPrototypeNode(ct /* (ComponentType) refined.eContainer() */, refined));
	}

	public MemberNode createFeatureNode(final ComponentType ct, final Feature feature) {
		final ComponentType q = (ComponentType) feature.eContainer();
		final boolean isLocal = q.equals(ct);
		final Feature refined = feature.getRefined();
		final boolean isRefined = refined != null;
		return new MemberNode(feature, feature.getName(), isLocal ? null : q, isRefined,
				!isRefined ? null : createFeatureNode(ct /* (ComponentType) refined.eContainer() */, refined));
	}

}
