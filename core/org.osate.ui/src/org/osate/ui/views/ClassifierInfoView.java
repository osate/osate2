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
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
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
import org.osate.aadl2.GroupExtension;
import org.osate.aadl2.ImplementationExtension;
import org.osate.aadl2.ModeFeature;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Prototype;
import org.osate.aadl2.Realization;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.TypeExtension;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.search.AadlFinder;
import org.osate.ui.OsateUiPlugin;
import org.osate.ui.UiUtil;

public final class ClassifierInfoView extends ViewPart {
	private static final String UNNAMED = "<unnamed>";

	private static final String CONNECTIONS_SECTION = "Connections";
	private static final String CALLS_SECTION = "Calls";
	private static final String PROCESSOR_FEATURES_SECTION = "Processor features";
	private static final String INTERNAL_FEATURES_SECTION = "Internal features";
	private static final String SUBCOMPONENTS_SECTION = "Subcomponents";
	private static final String MODES_SECTION = "Modes";
	private static final String FLOWS_SECTION = "Flows";
	private static final String FEATURES_SECTION = "Features";
	private static final String PROTOTYPES_SECTION = "Prototypes";

	private static final String NO_PREFIX = "";
	private static final String INVERSE_OF = "inverse of ";
	private static final String IMPLEMENTS = "implements ";
	private static final String EXTENDS = "extends ";
	private static final String INVERTED_BY = "inverted by ";
	private static final String IMPLEMENTED_BY = "implemented by ";
	private static final String EXTENDED_BY = "extended by ";

	private static final String AADL_ICON = "/icons/aadl.gif";
	private static final String LINK_ICON = "icons/link_to_editor.png";

	private static final String LINK_WITH_EDITOR_ACTION_NAME = "Link with Editor";

	public static final String VIEW_ID = "org.osate.ui.classifier_info_view";

	/**
	 * The most recently selected element in the view, or <code>null</code> is there is no
	 * selection.  Remembered so that if we toggle from DONT_SYNC to SYNC, we know where to
	 * jump to.
	 */
	private URI lastSelectedURI = null;

	private TreeViewer ancestorTree;
	private TreeViewer descendantTree;
	private TreeViewer memberTree;

	private final ILabelProvider modelElementLabelProvider;
	private Image aadlImage;

	private volatile boolean syncWithEditor = true;

	/*
	 * Keep track of the URI of the classifier being viewed so that we can refresh if
	 * the workspace changes. Need to keep the URI and not the classifier object
	 * itself so that we can reparse it and pick up the changes.
	 */
	private URI viewedClassifierURI = null;
	/*
	 * Synchronized because it is used by the dispaly thread and whatever thread exeuctes
	 * the resource change listener.
	 */
	private final Set<IResource> classifierResources = Collections.synchronizedSet(new HashSet<>());
	private IResourceChangeListener rsrcListener = null;

	public ClassifierInfoView() {
		modelElementLabelProvider = UiUtil.getModelElementLabelProvider();
	}

	// ======================================================================
	// == Static helper methods
	// ======================================================================

	/**
	 * Make sure the view is open and in front.
	 */
	public static ClassifierInfoView open(final IWorkbenchWindow window) {
		/* I basically stole this from org.eclipse.jdt.internal.ui.util.OpenTypeHiearchyUtil.openInViewPart() */
		final IWorkbenchPage page = window.getActivePage();
		try {
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
		descendantTree = createDescendantTree(sash);
		memberTree = createMemberTree(sash);

		final IAction syncWithEditorAction = new Action(LINK_WITH_EDITOR_ACTION_NAME, SWT.TOGGLE) {
			{
				setToolTipText(LINK_WITH_EDITOR_ACTION_NAME);
				setImageDescriptor(OsateUiPlugin.getImageDescriptor(LINK_ICON));
				setChecked(syncWithEditor);
			}

			@Override
			public void run() {
				syncWithEditor = !syncWithEditor;
				if (syncWithEditor) {
					gotoURI(lastSelectedURI);
				}
			}
		};
		getViewSite().getActionBars().getToolBarManager().add(syncWithEditorAction);
	}

	@Override
	public void init(final IViewSite site) throws PartInitException {
		aadlImage = new Image(site.getShell().getDisplay(),
				ClassifierInfoView.class.getResourceAsStream(AADL_ICON));
		super.init(site);

		rsrcListener = new Listener();
		ResourcesPlugin.getWorkspace().addResourceChangeListener(rsrcListener);
	}

	@Override
	public void dispose() {
		if (rsrcListener != null) {
			ResourcesPlugin.getWorkspace().removeResourceChangeListener(rsrcListener);
		}
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
			URI selectedURI = null;
			final ISelection selection = event.getSelection();
			if (selection instanceof IStructuredSelection) {
				final IStructuredSelection structuredSelection = (IStructuredSelection) selection;
				if (structuredSelection.size() == 1) {
					final AncestorTreeNode selectedNode = (AncestorTreeNode) structuredSelection.getFirstElement();
					selectedURI = selectedNode.getClassifierURI();
					if (syncWithEditor) {
						gotoURI(selectedURI);
					}
				}
			}
			lastSelectedURI = selectedURI;
		});
		treeViewer.addDoubleClickListener(event -> {
			final IStructuredSelection selected = (IStructuredSelection) event.getSelection();
			final AncestorTreeNode selectedNode = (AncestorTreeNode) selected.getFirstElement();
			final URI selectedURI = selectedNode.getClassifierURI();
			gotoURI(selectedURI);
			lastSelectedURI = selectedURI;
		});

		return treeViewer;
	}

	private TreeViewer createDescendantTree(final Composite parent) {
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
				return ((DescendantTreeNode) element).getImage();
			}

			@Override
			public String getText(final Object element) {
				return ((DescendantTreeNode) element).getText();
			}
		});
		treeViewer.setContentProvider(new ITreeContentProvider() {
			@Override
			public boolean hasChildren(final Object element) {
				return ((DescendantTreeNode) element).hasChildren();
			}

			@Override
			public Object getParent(final Object element) {
				return ((DescendantTreeNode) element).getParent();
			}

			@Override
			public Object[] getElements(final Object inputElement) {
				if (inputElement != null) {
					return ((DescendantTree) inputElement).getChildren();
				} else {
					return new Object[0];
				}
			}

			@Override
			public Object[] getChildren(final Object parentElement) {
				return ((DescendantTreeNode) parentElement).getChildren();
			}
		});

		// TODO: Update this
//		treeViewer.addSelectionChangedListener(event -> {
//			Element selectedElement = null;
//			final ISelection selection = event.getSelection();
//			if (selection instanceof IStructuredSelection) {
//				final IStructuredSelection structuredSelection = (IStructuredSelection) selection;
//				if (structuredSelection.size() == 1) {
//					final AncestorTreeNode selectedNode = (AncestorTreeNode) structuredSelection.getFirstElement();
//					selectedElement = selectedNode.getClassifier();
//					if (syncWithEditor) {
//						gotoElement(selectedElement);
//					}
//				}
//			}
//			lastSelectedElement = selectedElement;
//		});

		// TODO: Update this
//		treeViewer.addDoubleClickListener(event -> {
//			final IStructuredSelection selected = (IStructuredSelection) event.getSelection();
//			final AncestorTreeNode selectedNode = (AncestorTreeNode) selected.getFirstElement();
//			final Classifier selectedElement = selectedNode.getClassifier();
//			gotoElement(selectedElement);
//			lastSelectedElement = selectedElement;
//		});

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
			URI selectedURI = null;
			final ISelection selection = event.getSelection();
			if (selection instanceof IStructuredSelection) {
				final IStructuredSelection structuredSelection = (IStructuredSelection) selection;
				if (structuredSelection.size() == 1) {
					final MemberTreeNode selectedNode = (MemberTreeNode) structuredSelection.getFirstElement();
					if (selectedNode instanceof MemberNode) {
						selectedURI = ((MemberNode) selectedNode).getMemberURI();
						if (syncWithEditor) {
							gotoURI(selectedURI);
						}
					}
				}
			}
			lastSelectedURI = selectedURI;
		});
		treeViewer.addDoubleClickListener(event -> {
			final IStructuredSelection selected = (IStructuredSelection) event.getSelection();
			final MemberTreeNode selectedNode = (MemberTreeNode) selected.getFirstElement();
			if (selectedNode instanceof MemberNode) {
				final URI selectedURI = ((MemberNode) selectedNode).getMemberURI();
				gotoURI(selectedURI);
				lastSelectedURI = selectedURI;
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

	public void setInput(final URI classifierURI) {
		if (classifierURI != null) {
			viewedClassifierURI = classifierURI;
			final Classifier classifier = (Classifier) new ResourceSetImpl().getEObject(classifierURI, true);
			updateDisplay(classifier);
		}
	}

	private void refresh() {
		if (viewedClassifierURI != null) {
			final Classifier classifier = (Classifier) new ResourceSetImpl().getEObject(viewedClassifierURI, true);
			updateDisplay(classifier);
		}
	}

	private void updateDisplay(final Classifier input) {
		getViewSite().getShell().getDisplay().asyncExec(() -> {
			classifierResources.clear();
			ancestorTree.setInput(createAncestorTree(input));
			ancestorTree.expandToLevel(2);

			descendantTree.setInput(createDescendantTree(input));
			descendantTree.expandToLevel(2);

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
		});
	}

	// ======================================================================
	// == Helper classes
	// ======================================================================

	// ----------------------------------------------------------------------
	// -- Resource Listener
	// ----------------------------------------------------------------------

	/**
	 * When a resource in the workspace is moved or deleted we check to see if it is overrides a
	 * plug-in contributed resource.  If so, we need to update the global preferences.
	 */
	private class Listener implements IResourceChangeListener {
		@Override
		public void resourceChanged(final IResourceChangeEvent event) {
			/*
			 * Going to be quite dumb about this. If any of the resources we care
			 * about change in any way, then we update the view.
			 */
			final AtomicBoolean changed = new AtomicBoolean(false);
			if (event.getType() == IResourceChangeEvent.POST_CHANGE) {
				final IResourceDelta docDelta = event.getDelta();
				if (docDelta != null) {
					try {
						docDelta.accept(delta -> {
							final IResource resource = delta.getResource();
							if (classifierResources.contains(resource)) {
								changed.set(true);
							}
							return true;
						});
					} catch (final CoreException e) {
						OsateUiPlugin.log(e);
					}
				}
			}

			if (changed.get()) {
				refresh();
			}
		}
	}

	// ----------------------------------------------------------------------
	// -- Generic hierarchy tree
	// ----------------------------------------------------------------------

	private abstract static class HierarchyTree<X extends HierarchyTreeNode<?>> {
		private final X[] children;

		private HierarchyTree(final X root) {
			children = createChildren(root);
		}

		protected abstract X[] createChildren(final X root);

		public final X[] getChildren() {
			return children;
		}
	}

	private abstract class HierarchyTreeNode<SELF extends HierarchyTreeNode<?>> {
		protected SELF parent;
		private final URI classifierURI;
		private final String label;
		private final Image image;

		private HierarchyTreeNode(final EObject classifier, final String prefix) {
			this.classifierURI = EcoreUtil.getURI(classifier);
			this.label = prefix + modelElementLabelProvider.getText(classifier);
			this.image = modelElementLabelProvider.getImage(classifier);
		}

		public final URI getClassifierURI() {
			return classifierURI;
		}

		public final Image getImage() {
			return image;
		}

		public final String getText() {
			return label;
		}

		public abstract boolean hasChildren();

		public abstract HierarchyTreeNode<SELF>[] getChildren();

		public final SELF getParent() {
			return parent;
		}
	}


	// ----------------------------------------------------------------------
	// -- Ancestor tree
	// ----------------------------------------------------------------------

	private final static class AncestorTree extends HierarchyTree<AncestorTreeNode> {
		private AncestorTree(final AncestorTreeNode root) {
			super(root);
		}

		@Override
		protected final AncestorTreeNode[] createChildren(final AncestorTreeNode root) {
			return new AncestorTreeNode[] { root };
		}
	}

	private AncestorTree createAncestorTree(final Classifier classifier) {
		return new AncestorTree(createAncestorTreeNode(classifier, NO_PREFIX));
	}

	private final class AncestorTreeNode extends HierarchyTreeNode<AncestorTreeNode> {
		private final AncestorTreeNode[] children;

		private AncestorTreeNode(final Classifier classifier, final String prefix, final AncestorTreeNode[] children) {
			super(classifier, prefix);
			this.children = children;
			for (final AncestorTreeNode child : children) {
				child.parent = this;
			}
		}

		@Override
		public final boolean hasChildren() {
			return children.length > 0;
		}

		@Override
		public final AncestorTreeNode[] getChildren() {
			return children;
		}
	}

	private AncestorTreeNode createAncestorTreeNode(final Classifier classifier, final String prefix) {
		final Resource eResource = classifier.eResource();
		// If the AADL file has parse errors then we may get a null result here
		if (eResource != null) {
			final URI uri = eResource.getURI();
			classifierResources.add(OsateResourceUtil.toIFile(uri));
		}

		AncestorTreeNode[] children = new AncestorTreeNode[0];
		if (classifier instanceof ComponentType) {
			final ComponentType extended = ((ComponentType) classifier.getExtended());
			if (extended != null) {
				children = new AncestorTreeNode[] { createAncestorTreeNode(extended, EXTENDS) };
			}
		} else if (classifier instanceof ComponentImplementation) {
			final ComponentImplementation asCompImpl = (ComponentImplementation) classifier;
			final ComponentType implemented = asCompImpl.getType();
			final ComponentImplementation extended = asCompImpl.getExtended();
			if (extended == null) {
				children = new AncestorTreeNode[] { createAncestorTreeNode(implemented, IMPLEMENTS) };
			} else {
				children = new AncestorTreeNode[] { createAncestorTreeNode(implemented, IMPLEMENTS),
						createAncestorTreeNode(extended, EXTENDS) };
			}
		} else if (classifier instanceof FeatureGroupType) {
			final FeatureGroupType asFeatureGroup = (FeatureGroupType) classifier;
			final FeatureGroupType inverseOf = asFeatureGroup.getInverse();
			final FeatureGroupType extended = asFeatureGroup.getExtended();
			final List<AncestorTreeNode> childrenList = new ArrayList<>(2);
			if (inverseOf != null) {
				childrenList.add(createAncestorTreeNode(inverseOf, INVERSE_OF));
			}
			if (extended != null) {
				childrenList.add(createAncestorTreeNode(extended, EXTENDS));
			}
			children = childrenList.toArray(children);
		}
		return new AncestorTreeNode(classifier, prefix, children);
	}

	// ----------------------------------------------------------------------
	// -- Descendant tree
	// ----------------------------------------------------------------------


	private final static class DescendantTree extends HierarchyTree<DescendantTreeNode> {
		private DescendantTree(final DescendantTreeNode root) {
			super(root);
		}

		@Override
		protected final DescendantTreeNode[] createChildren(final DescendantTreeNode root) {
			return new DescendantTreeNode[] { root };
		}
	}

	private final class DescendantTreeNode extends HierarchyTreeNode<DescendantTreeNode> {
		private final List<DescendantTreeNode> children = new LinkedList<>();

		private DescendantTreeNode(final EObject classifier, final String prefix) {
			super(classifier, prefix);
		}

		private void addChild(final DescendantTreeNode child) {
			child.parent = this;
			children.add(child);
		}

		@Override
		public boolean hasChildren() {
			return children.size() > 0;
		}

		@Override
		public DescendantTreeNode[] getChildren() {
			return children.toArray(new DescendantTreeNode[children.size()]);
		}
	}

	private DescendantTree createDescendantTree(final Classifier rootClassifier) {
		/*
		 * Find all the projects that depend on the project that declares the
		 * root classifier. Use them to build a constraining search scope.
		 */
		final Set<IProject> projects = getDependantProjects(rootClassifier);
		final AadlFinder.Scope scope = new AadlFinder.ResourceSetScope(projects);

		final Deque<DescendantTreeNode> deque = new LinkedList<>();
		final DescendantTreeNode root = new DescendantTreeNode(rootClassifier, NO_PREFIX);
		deque.addLast(root);

		/* We maintain a queue of classifiers to search for, starting with our root classifier. For each
		 * one, we look for all references to it, and then process all references that appear in a context
		 * where it is being implemented/extended/inverted.
		 */
		while (!deque.isEmpty()) {
			final DescendantTreeNode current = deque.removeFirst();

			/* Find all the references to the current classifier */
			AadlFinder.getInstance().getAllReferencesToTypeInScope(scope, refDesc -> {
				if (refDesc.getTargetEObjectUri().equals(current.getClassifierURI())) {
					final URI sourceEObjectUri = refDesc.getSourceEObjectUri();
					final EObject eObj = new ResourceSetImpl().getEObject(sourceEObjectUri, true);

					EObject childObject = null;
					String childPrefix = null;
					if (eObj instanceof TypeExtension) {
						childObject = ((TypeExtension) eObj).eContainer();
						childPrefix = EXTENDED_BY;
					} else if (eObj instanceof Realization) {
						childObject = ((Realization) eObj).eContainer();
						childPrefix = IMPLEMENTED_BY;
					} else if (eObj instanceof ImplementationExtension) {
						childObject = ((ImplementationExtension) eObj).eContainer();
						childPrefix = EXTENDED_BY;
					} else if (eObj instanceof GroupExtension) {
						childObject = ((GroupExtension) eObj).eContainer();
						childPrefix = EXTENDED_BY;
					} else if (eObj instanceof FeatureGroupType) {
						childObject = eObj;
						childPrefix = INVERTED_BY;
					}

					/* Add the referencing node to the tree */
					if (childObject != null) {
						final DescendantTreeNode child = new DescendantTreeNode(childObject, childPrefix);
						current.addChild(child);
						deque.addLast(child);

						/*
						 * XXX
						 * This is not enough, because they can add new uses to files
						 * that we aren't watching.
						 */
						classifierResources.add(OsateResourceUtil.toIFile(eObj.eResource().getURI()));
					}
				}
			});
		}

		return new DescendantTree(root);
	}

	private static final Set<IProject> getDependantProjects(final Classifier rootClassifier) {
		final Set<IProject> projects = new HashSet<>();
		final IProject rootProject = OsateResourceUtil.toIFile(rootClassifier.eResource().getURI()).getProject();
		getDependantProjects(rootProject, projects);
		return Collections.unmodifiableSet(projects);
	}

	private static final void getDependantProjects(final IProject project, final Set<IProject> projects) {
		projects.add(project);
		for (final IProject child : project.getReferencingProjects()) {
			getDependantProjects(child, projects);
		}
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
		addSection(sections, PROTOTYPES_SECTION, fgt, fgt.getAllPrototypes(), ClassifierInfoView::getRefinedPrototype);
		final EList<Feature> allFeatures = fgt.getAllFeatures();
		addFeatureGroupFeaturesSection(sections, fgt, allFeatures);
		return new MemberTree(sections);
	}

	private MemberTree createMemberTree(final ComponentType ct) {
		final List<SectionNode> sections = new ArrayList<>();
		addSection(sections, PROTOTYPES_SECTION, ct, ct.getAllPrototypes(), ClassifierInfoView::getRefinedPrototype);
		addSection(sections, FEATURES_SECTION, ct, ct.getAllFeatures(), ClassifierInfoView::getRefinedFeature);
		addSection(sections, FLOWS_SECTION, ct, ct.getAllFlowSpecifications(), ClassifierInfoView::getRefinedFlowSpec);
		addSection(sections, MODES_SECTION, ct, getAllModesAndModeTransitions(ct), ClassifierInfoView::cannotBeRefined);
		return new MemberTree(sections);
	}

	private MemberTree createMemberTree(final ComponentImplementation ci) {
		final List<SectionNode> sections = new ArrayList<>();
		addSection(sections, PROTOTYPES_SECTION, ci, ci.getAllPrototypes(), ClassifierInfoView::getRefinedPrototype);
		addSection(sections, FEATURES_SECTION, ci, ci.getType().getAllFeatures(), ClassifierInfoView::getRefinedFeature);
		addSection(sections, SUBCOMPONENTS_SECTION, ci, ci.getAllSubcomponents(), ClassifierInfoView::getRefinedSubcomponent);
		addSection(sections, INTERNAL_FEATURES_SECTION, ci, ci.getAllInternalFeatures(), ClassifierInfoView::cannotBeRefined);
		addSection(sections, PROCESSOR_FEATURES_SECTION, ci, ci.getAllProcessorFeatures(),
				ClassifierInfoView::cannotBeRefined);
		if (ci instanceof BehavioredImplementation) {
			addSection(sections, CALLS_SECTION, ci, ((BehavioredImplementation) ci).getAllSubprogramCallSequences(),
					ClassifierInfoView::cannotBeRefined);
		}
		addSection(sections, CONNECTIONS_SECTION, ci, ci.getAllConnections(), ClassifierInfoView::getRefinedConnection);
		addFlowImplementationSection(sections, ci);
		addSection(sections, MODES_SECTION, ci, getAllModesAndModeTransitions(ci), ClassifierInfoView::cannotBeRefined);
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
		return new SectionNode(FEATURES_SECTION, memberNodes);
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
		return new SectionNode(FLOWS_SECTION, memberNodes);
	}

	private final class MemberNode implements MemberTreeNode {
		private static final String FROM_CLOSE = "]";
		private static final String FROM_OPEN = " [from ";
		private static final String REFINED = "refined ";

		private final URI memberURI;
		private final String label;
		private final Image image;
		private final MemberNode[] ancestorMember;

		private MemberNode(final NamedElement member, final Classifier inheritedFrom, final boolean isInverted,
				final boolean isRefined, final MemberNode ancestor) {
			memberURI = EcoreUtil.getURI(member);

			final String name = getName(member);
			label = (isInverted ? INVERSE_OF : NO_PREFIX) + (isRefined ? REFINED : NO_PREFIX)
					+ unparseMember(member, name)
					+ (inheritedFrom != null ? (FROM_OPEN + inheritedFrom.getName() + FROM_CLOSE) : NO_PREFIX);
			image = modelElementLabelProvider.getImage(member);
			ancestorMember = ancestor == null ? new MemberNode[0] : new MemberNode[] { ancestor };
		}

		private MemberNode(final NamedElement m, final Classifier from, final boolean refined,
				final MemberNode ancestor) {
			this(m, from, false, refined, ancestor);
		}

		public URI getMemberURI() {
			return memberURI;
		}

		@Override
		public String getText() {
			return label;
		}

		@Override
		public Image getImage() {
			return image;
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
		return new MemberNode(member, isLocal ? null : q, isRefined,
				!isRefined ? null : createMemberNode(classifier, refined, gr));
	}

	public <M extends NamedElement> MemberNode createMemberNode(final FeatureGroupType fgt,
			final Collection<Classifier> ancestors, final M member, final GetRefined<M> gr) {
		final Classifier q = (Classifier) member.eContainer();
		final boolean isLocal = q.equals(fgt);
		final M refined = gr.getRefined(member);
		final boolean isRefined = refined != null;
		return new MemberNode(member, isLocal ? null : q, !ancestors.contains(q), isRefined,
				!isRefined ? null : createMemberNode(fgt, refined, gr));
	}

	public MemberNode createMemberNodeFromFlowImplementation(final ComponentImplementation ci,
			final FlowImplementation flowImpl) {
		final Classifier q = (Classifier) flowImpl.eContainer();
		final boolean isLocal = q.equals(ci);
		final FlowSpecification flowSpec = flowImpl.getSpecification();
		return new MemberNode(flowImpl, isLocal ? null : q, false,
				flowSpec.eIsProxy() ? null : createMemberNode(ci, flowSpec, ClassifierInfoView::getRefinedFlowSpec));
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
			return String.CASE_INSENSITIVE_ORDER.compare(getName(o1), getName(o2));
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

	private void gotoURI(final URI gotoURI) {
		UiUtil.getInstance().openDeclarativeModelElementAsJob(getSite().getPage(), (Element) (new ResourceSetImpl()).getEObject(gotoURI, true));
	}

	private static String getName(NamedElement ne) {
		return (ne != null && !ne.eIsProxy() && ne.getName() != null) ? ne.getName() : UNNAMED;
	}
}
