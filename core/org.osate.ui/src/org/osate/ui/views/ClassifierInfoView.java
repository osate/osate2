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
package org.osate.ui.views;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
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
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.ViewPart;
import org.osate.aadl2.BehavioredImplementation;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.Connection;
import org.osate.aadl2.Element;
import org.osate.aadl2.EndToEndFlow;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.FlowImplementation;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.ModeFeature;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Prototype;
import org.osate.aadl2.Subcomponent;
import org.osate.ui.OsateUiPlugin;
import org.osate.ui.UiUtil;

public final class ClassifierInfoView extends ViewPart {
	public static final String VIEW_ID = "org.osate.ui.classifier_info_view";

	private static final String LINK_ICON = "icons/link_to_editor.png";

	/**
	 * The most recently selected element in the view, or <code>null</code> is there is no
	 * selection.  Remembered so that if we toggle from DONT_SYNC to SYNC, we know where to
	 * jump to.
	 */
	private Element lastSelectedElement = null;

	private TreeViewer ancestorTree;
	private TreeViewer memberTree;

	private final ILabelProvider modelElementLabelProvider;
	private Image aadlImage;

	private volatile boolean syncWithEditor = true;

	public ClassifierInfoView() {
		modelElementLabelProvider = UiUtil.getModelElementLabelProvider();
	}

	// ======================================================================
	// == Static helper methods
	// ======================================================================

	/**
	 * Make the view is open and in front.
	 */
	public static ClassifierInfoView open(final IWorkbenchWindow window) {
		/* I basically stole this from org.eclipse.jdt.internal.ui.util.OpenTypeHiearchyUtil.openInViewPart() */
		final IWorkbenchPage page = window.getActivePage();
		try {
//			ClassifierInfoView result = (ClassifierInfoView) page.findView(VIEW_ID);
			final ClassifierInfoView result = (ClassifierInfoView) page.showView(VIEW_ID);
			return result;
		} catch (CoreException e) {
			OsateUiPlugin.log(e);
		}
		return null;
	}

	// ======================================================================
	// == Creation and clean up of all the UI stuff
	// ======================================================================

	@Override
	public void createPartControl(final Composite parent) {
		final SashForm sash = new SashForm(parent, SWT.HORIZONTAL);

		ancestorTree = createAncestorTree(sash);
		memberTree = createMemberTree(sash);

		final IAction syncWithEditorAction = new Action("Link with Editor", SWT.TOGGLE) {
			{
				setToolTipText("Link with Editor");
				setImageDescriptor(OsateUiPlugin.getImageDescriptor(LINK_ICON));
				setChecked(syncWithEditor);
			}

			@Override
			public void run() {
				syncWithEditor = !syncWithEditor;
				if (syncWithEditor) {
					gotoElement(lastSelectedElement);
				}
			}
		};
		getViewSite().getActionBars().getToolBarManager().add(syncWithEditorAction);
	}

	@Override
	public void init(final IViewSite site) throws PartInitException {
		aadlImage = new Image(site.getShell().getDisplay(),
				ClassifierInfoView.class.getResourceAsStream("/icons/aadl.gif"));
		super.init(site);
	}

	@Override
	public void dispose() {
		aadlImage.dispose();
		aadlImage = null;
	}

	@Override
	public void setFocus() {
		memberTree.getControl().setFocus();
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
		treeViewer.addSelectionChangedListener(event -> {
			Element selectedElement = null;
			final ISelection selection = event.getSelection();
			if (selection instanceof IStructuredSelection) {
				final IStructuredSelection structuredSelection = (IStructuredSelection) selection;
				if (structuredSelection.size() == 1) {
					final AncestorTreeNode selectedNode = (AncestorTreeNode) structuredSelection.getFirstElement();
					selectedElement = selectedNode.getClassifier();
					if (syncWithEditor) {
						gotoElement(selectedElement);
					}
				}
			}
			lastSelectedElement = selectedElement;
		});
		treeViewer.addDoubleClickListener(event -> {
			final IStructuredSelection selected = (IStructuredSelection) event.getSelection();
			final AncestorTreeNode selectedNode = (AncestorTreeNode) selected.getFirstElement();
			final Classifier selectedElement = selectedNode.getClassifier();
			gotoElement(selectedElement);
			lastSelectedElement = selectedElement;
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
		treeViewer.addSelectionChangedListener(event -> {
			Element selectedElement = null;
			final ISelection selection = event.getSelection();
			if (selection instanceof IStructuredSelection) {
				final IStructuredSelection structuredSelection = (IStructuredSelection) selection;
				if (structuredSelection.size() == 1) {
					final MemberTreeNode selectedNode = (MemberTreeNode) structuredSelection.getFirstElement();
					if (selectedNode instanceof MemberNode) {
						selectedElement = ((MemberNode) selectedNode).getMember();
						if (syncWithEditor) {
							gotoElement(selectedElement);
						}
					}
				}
			}
			lastSelectedElement = selectedElement;
		});
		treeViewer.addDoubleClickListener(event -> {
			final IStructuredSelection selected = (IStructuredSelection) event.getSelection();
			final MemberTreeNode selectedNode = (MemberTreeNode) selected.getFirstElement();
			if (selectedNode instanceof MemberNode) {
				final Element selectedElement = ((MemberNode) selectedNode).getMember();
				gotoElement(selectedElement);
				lastSelectedElement = selectedElement;
			} else {
				if (treeViewer.isExpandable(selectedNode)) {
					if (treeViewer.getExpandedState(selectedNode)) {
						treeViewer.collapseToLevel(selectedNode, 1);
					} else {
						treeViewer.expandToLevel(selectedNode, 1);
					}
				}
			}
		});

		return treeViewer;
	}

	// ======================================================================
	// == Set the view input
	// ======================================================================

	public void setInput(final Classifier input) {
		if (input != null) {
			final AncestorTree tree = createAncestorTree(input);
			ancestorTree.setInput(tree);
			ancestorTree.expandToLevel(2);
			if (input instanceof ComponentType) {
				memberTree.setInput(createMemberTree((ComponentType) input));
				memberTree.expandToLevel(2);
			} else if (input instanceof ComponentImplementation) {
				memberTree.setInput(createMemberTree((ComponentImplementation) input));
				memberTree.expandToLevel(2);
			} else if (input instanceof FeatureGroupType) {
				memberTree.setInput(createMemberTree((FeatureGroupType) input));
				memberTree.expandToLevel(2);
			}
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

		public Classifier getClassifier() {
			return classifier;
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

	private MemberTree createMemberTree(final FeatureGroupType fgt) {
		final List<SectionNode> sections = new ArrayList<>();
		addSection(sections, "Prototypes", fgt, fgt.getAllPrototypes(), ClassifierInfoView::getRefinedPrototype);
		final EList<Feature> allFeatures = fgt.getAllFeatures();
		addFeatureGroupFeaturesSection(sections, fgt, allFeatures);
		return new MemberTree(sections);
	}

	private MemberTree createMemberTree(final ComponentType ct) {
		final List<SectionNode> sections = new ArrayList<>();
		addSection(sections, "Prototypes", ct, ct.getAllPrototypes(), ClassifierInfoView::getRefinedPrototype);
		addSection(sections, "Features", ct, ct.getAllFeatures(), ClassifierInfoView::getRefinedFeature);
		addSection(sections, "Flows", ct, ct.getAllFlowSpecifications(), ClassifierInfoView::getRefinedFlowSpec);
		addSection(sections, "Modes", ct, getAllModesAndModeTransitions(ct), ClassifierInfoView::cannotBeRefined);
		return new MemberTree(sections);
	}

	private MemberTree createMemberTree(final ComponentImplementation ci) {
		final List<SectionNode> sections = new ArrayList<>();
		addSection(sections, "Prototypes", ci, ci.getAllPrototypes(), ClassifierInfoView::getRefinedPrototype);
		addSection(sections, "Features", ci, ci.getType().getAllFeatures(), ClassifierInfoView::getRefinedFeature);
		addSection(sections, "Subcomponents", ci, ci.getAllSubcomponents(), ClassifierInfoView::getRefinedSubcomponent);
		addSection(sections, "Internal features", ci, ci.getAllInternalFeatures(), ClassifierInfoView::cannotBeRefined);
		addSection(sections, "Processor features", ci, ci.getAllProcessorFeatures(),
				ClassifierInfoView::cannotBeRefined);
		if (ci instanceof BehavioredImplementation) {
			addSection(sections, "Calls", ci, ((BehavioredImplementation) ci).getAllSubprogramCallSequences(),
					ClassifierInfoView::cannotBeRefined);
		}
		addSection(sections, "Connections", ci, ci.getAllConnections(), ClassifierInfoView::getRefinedConnection);
		addFlowImplementationSection(sections, ci);
		addSection(sections, "Modes", ci, getAllModesAndModeTransitions(ci), ClassifierInfoView::cannotBeRefined);
		return new MemberTree(sections);
	}

	private <M extends NamedElement> void addSection(final List<SectionNode> sections, final String heading,
			final Classifier classifier, final List<M> members, final GetRefined<M> gr) {
		if (members != null && members.size() > 0) {
			sections.add(createSectionNode(classifier, members, heading, gr));
		}
	}

	private void addFeatureGroupFeaturesSection(final List<SectionNode> sections, final FeatureGroupType fgt,
			final List<Feature> members) {
		if (members != null && members.size() > 0) {
			sections.add(createFeatureGroupFeaturesSectionNode(fgt, members));
		}
	}

	private void addFlowImplementationSection(final List<SectionNode> sections, final ComponentImplementation ci) {
		List<FlowImplementation> flowImpls = ci.getAllFlowImplementations();
		if (flowImpls == null) {
			flowImpls = Collections.emptyList();
		}
		List<EndToEndFlow> end2endFlows = ci.getAllEndToEndFlows();
		if (end2endFlows == null) {
			end2endFlows = Collections.emptyList();
		}
		if (!flowImpls.isEmpty() || !end2endFlows.isEmpty()) {
			sections.add(createSectionFromFlowImplementations(ci, flowImpls, end2endFlows));
		}
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

	public <M extends NamedElement> SectionNode createSectionNode(final Classifier classifier, final List<M> members,
			final String heading, final GetRefined<M> gr) {
		Collections.sort(members, MEMBER_COMPARATOR);
		final List<MemberNode> memberNodes = new ArrayList<>();
		for (final M member : members) {
			memberNodes.add(createMemberNode(classifier, member, gr));
		}
		return new SectionNode(heading, memberNodes);
	}

	public SectionNode createFeatureGroupFeaturesSectionNode(final FeatureGroupType fgt, final List<Feature> members) {
		final Collection<Classifier> ancestors = fgt.getSelfPlusAllExtended();
		// Don't sort the features of a feature group type because the order matters
		final List<MemberNode> memberNodes = new ArrayList<>();
		for (final Feature member : members) {
			memberNodes.add(createMemberNode(fgt, ancestors, member, ClassifierInfoView::getRefinedFeature));
		}
		return new SectionNode("Features", memberNodes);
	}

	public SectionNode createSectionFromFlowImplementations(final ComponentImplementation ci,
			List<FlowImplementation> flowImpls, List<EndToEndFlow> end2endFlows) {
		final List<MemberNode> memberNodes = new ArrayList<>();

		Collections.sort(flowImpls, MEMBER_COMPARATOR);
		for (final FlowImplementation flowImpl : flowImpls) {
			memberNodes.add(createMemberNodeFromFlowImplementation(ci, flowImpl));
		}

		Collections.sort(end2endFlows, MEMBER_COMPARATOR);
		for (final EndToEndFlow e2e : end2endFlows) {
			memberNodes.add(createMemberNode(ci, e2e, ClassifierInfoView::getRefinedEndToEndFlow));
		}
		return new SectionNode("Flows", memberNodes);
	}

	private final class MemberNode implements MemberTreeNode {
		private final Element member;
		private final String name;
		private final Classifier inheritedFrom;
		private final boolean isInverted;
		private final boolean isRefined;
		private final MemberNode[] ancestorMember;

		private MemberNode(final Element m, final String n, final Classifier from, final boolean inverted,
				final boolean refined,
				final MemberNode ancestor) {
			member = m;
			name = n;
			inheritedFrom = from;
			isInverted = inverted;
			isRefined = refined;
			ancestorMember = ancestor == null ? new MemberNode[0] : new MemberNode[] { ancestor };
		}

		private MemberNode(final Element m, final String n, final Classifier from, final boolean refined,
				final MemberNode ancestor) {
			this(m, n, from, false, refined, ancestor);
		}

		public Element getMember() {
			return member;
		}

		@Override
		public String getText() {
			return (isInverted ? "inverse of " : "") + (isRefined ? "refined " : "") + unparseMember(member, name)
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

		private String unparseMember(final EObject member, final String name) {
			return name;
		}
	}

	public <M extends NamedElement> MemberNode createMemberNode(final Classifier classifier, final M member,
			final GetRefined<M> gr) {
		final Classifier q = (Classifier) member.eContainer();
		final boolean isLocal = q.equals(classifier);
		final M refined = gr.getRefined(member);
		final boolean isRefined = refined != null;
		return new MemberNode(member, member.getName(),
				isLocal ? null : q, isRefined,
				!isRefined ? null : createMemberNode(classifier, refined, gr));
	}

	public <M extends NamedElement> MemberNode createMemberNode(final FeatureGroupType fgt,
			final Collection<Classifier> ancestors, final M member, final GetRefined<M> gr) {
		final Classifier q = (Classifier) member.eContainer();
		final boolean isLocal = q.equals(fgt);
		final M refined = gr.getRefined(member);
		final boolean isRefined = refined != null;
		return new MemberNode(member, member.getName(), isLocal ? null : q, !ancestors.contains(q), isRefined,
				!isRefined ? null : createMemberNode(fgt, refined, gr));
	}

	public MemberNode createMemberNodeFromFlowImplementation(final ComponentImplementation ci, final FlowImplementation flowImpl) {
		final Classifier q = (Classifier) flowImpl.eContainer();
		final boolean isLocal = q.equals(ci);
		final FlowSpecification flowSpec = flowImpl.getSpecification();
		return new MemberNode(flowImpl, flowSpec.getName(), isLocal ? null : q, false,
				createMemberNode(ci, flowSpec, ClassifierInfoView::getRefinedFlowSpec));
	}

	private static final List<ModeFeature> getAllModesAndModeTransitions(final ComponentType ct) {
		final List<ModeFeature> modeFeatures = new ArrayList<>();
		modeFeatures.addAll(ct.getAllModes());
		modeFeatures.addAll(ct.getAllModeTransitions());
		return modeFeatures;
	}

	private static final List<ModeFeature> getAllModesAndModeTransitions(final ComponentImplementation ci) {
		final List<ModeFeature> modeFeatures = new ArrayList<>();
		modeFeatures.addAll(ci.getAllModes());
		modeFeatures.addAll(ci.getAllModeTransitions());
		return modeFeatures;
	}

	private static final Comparator<NamedElement> MEMBER_COMPARATOR = new MemberComparator();

	private static final class MemberComparator implements Comparator<NamedElement> {
		@Override
		public int compare(final NamedElement o1, final NamedElement o2) {
			return String.CASE_INSENSITIVE_ORDER.compare(o1.getName(), o2.getName());
		}
	}

	@FunctionalInterface
	private static interface GetRefined<M extends NamedElement> {
		public M getRefined(M member);
	}

	private static <X extends NamedElement> X cannotBeRefined(final X x) {
		// cannot be refined
		return null;
	}

	private static Prototype getRefinedPrototype(final Prototype p) {
		return p.getRefined();
	}

	private static Feature getRefinedFeature(final Feature f) {
		return f.getRefined();
	}

	private static FlowSpecification getRefinedFlowSpec(final FlowSpecification fs) {
		return fs.getRefined();
	}

	private static Subcomponent getRefinedSubcomponent(final Subcomponent sub) {
		return sub.getRefined();
	}

	private static Connection getRefinedConnection(final Connection c) {
		return c.getRefined();
	}

	private static EndToEndFlow getRefinedEndToEndFlow(final EndToEndFlow e) {
		return e.getRefined();
	}

	private void gotoElement(final Element gotoElement) {
		UiUtil.getInstance().openDeclarativeModelElementAsJob(getSite().getPage(), gotoElement);
	}
}
