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
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.layout.TreeColumnLayout;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.PageBook;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.progress.IWorkbenchSiteProgressService;
import org.osate.aadl2.BehavioredImplementation;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.Connection;
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
	private static final String CLEAR_ICON = "icons/delete.png";
	private static final String REFRESH_ICON = "icons/refresh.png";
	private static final String ANCESTORS_ICON = "icons/super_co.png";
	private static final String DESCENDANTS_ICON = "icons/sub_co.png";

	private static final String LINK_WITH_EDITOR_ACTION_NAME = "Link with Editor";
	private static final String CLEAR_ACTION_NAME = "Clear View";
	private static final String REFRESH_ACTION_NAME = "Refresh View";
	private static final String REFRESH_TOOL_TOP = "Refreshes the view.  Only enabled when a refresh is required.";
	private static final String ANCESTORS_ACTION_NAME = "Ancestors Tree";
	private static final String DESCENDANTS_ACTION_NAME = "Descendants Tree";

	public static final String VIEW_ID = "org.osate.ui.classifier_info_view";

	/**
	 * The most recently selected element in the view, or <code>null</code> is there is no
	 * selection.  Remembered so that if we toggle from DONT_SYNC to SYNC, we know where to
	 * jump to.
	 */
	private URI lastSelectedURI = null;

	private PageBook treePages;
	private Composite ancestorTreeComposite;
	private TreeViewer ancestorTreeViewer;
	private Composite descendantTreeComposite;
	private TreeViewer descendantTreeViewer;
	private TreeViewer memberTreeViewer;

	private Action ancestorAction;
	private Action descendantAction;
	private Action refreshAction;

	private final ILabelProvider modelElementLabelProvider;
	private Image aadlImage;

	/* Mark these all as volatile because they are touched by UI and work threads. */

	// Does clicking on a tree element automatically jump the editor location
	private volatile boolean syncWithEditor = true;

	private volatile Trees<?> whichTree;

	/*
	 * The Job (if any currently running to refresh the view. If another refresh occurs, we need to cancel
	 * this job first. Protected by synchronizing on the view object.
	 */
	private Job currentRefreshJob = null;
	/*
	 * Do not set directly. Use the setNeedsRefresh() method so that the refresh button is properly
	 * enabled.
	 */
	private volatile boolean needsRefresh = false;
	private volatile boolean autoRefresh = true;

	/*
	 * Keep track of the URI of the classifier being viewed so that we can refresh if
	 * the workspace changes. Need to keep the URI and not the classifier object
	 * itself so that we can reparse it and pick up the changes.
	 */
	private URI hierarchyClassifierURI = null;
	private URI memberClassifierURI = null;

	/*
	 * Synchronized because it is used by the display thread and whatever thread executes
	 * the resource change listener.
	 */
	private final Set<IResource> projectDependancies = Collections.synchronizedSet(new HashSet<>());
	private IResourceChangeListener rsrcListener = null;

	// ======================================================================
	// == Constructor
	// ======================================================================

	public ClassifierInfoView() {
		modelElementLabelProvider = UiUtil.getModelElementLabelProvider();
		/*
		 * Init this here in the constructor and not in the field declaration because the instance field
		 * ANCESTOR_TREE needs to be initialized first. It is declared later in the class because it makes more sense logically.
		 */
		whichTree = ANCESTOR_TREE;
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

		// Create the trees
		final SelectionAndDoubleClickHandler handler = new SelectionAndDoubleClickHandler();
		treePages = new PageBook(sash, SWT.NULL);
		createAncestorTree(treePages, handler);
		createDescendantTree(treePages, handler);
		createMemberTree(sash, handler);
		whichTree.switchTo();

		final IActionBars actionBars = getViewSite().getActionBars();
		final IToolBarManager toolBarManager = actionBars.getToolBarManager();
		final IMenuManager menuManager = actionBars.getMenuManager();

		// Tree selection radio buttons
		ancestorAction = new Action(ANCESTORS_ACTION_NAME, IAction.AS_RADIO_BUTTON) {
			{
				setToolTipText(ANCESTORS_ACTION_NAME);
				setImageDescriptor(OsateUiPlugin.getImageDescriptor(ANCESTORS_ICON));
			}

			@Override
			public void run() {
				whichTree = ANCESTOR_TREE;
				whichTree.switchTo();
				clearMembers(true);
			}
		};
		toolBarManager.add(ancestorAction);
		descendantAction = new Action(DESCENDANTS_ACTION_NAME, IAction.AS_RADIO_BUTTON) {
			{
				setToolTipText(DESCENDANTS_ACTION_NAME);
				setImageDescriptor(OsateUiPlugin.getImageDescriptor(DESCENDANTS_ICON));
				setChecked(false);
				clearMembers(true);
			}

			@Override
			public void run() {
				whichTree = DESCENDANT_TREE;
				whichTree.switchTo();
			}
		};
		toolBarManager.add(descendantAction);
		whichTree.setChecked();

		// Refresh button
		refreshAction = new Action(REFRESH_ACTION_NAME, IAction.AS_PUSH_BUTTON) {
			{
				setToolTipText(REFRESH_TOOL_TOP);
				setImageDescriptor(OsateUiPlugin.getImageDescriptor(REFRESH_ICON));
				setEnabled(false);
			}

			@Override
			public void run() {
				refresh();
			}
		};
		toolBarManager.add(refreshAction);

		// Clear view button
		toolBarManager.add(new Action(CLEAR_ACTION_NAME, IAction.AS_PUSH_BUTTON) {
			{
				setToolTipText(CLEAR_ACTION_NAME);
				setImageDescriptor(OsateUiPlugin.getImageDescriptor(CLEAR_ICON));
			}

			@Override
			public void run() {
				clearDisplay(true);
			}
		});

		// Link button
		toolBarManager.add(new Action(LINK_WITH_EDITOR_ACTION_NAME, IAction.AS_CHECK_BOX) {
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
		});

		// Create the view menu
		menuManager.add(new Action("Auto refresh", IAction.AS_CHECK_BOX) {
			{
				setToolTipText("When checked, the view will automatically refresh");
				setChecked(autoRefresh);
			}

			@Override
			public void run() {
				final boolean isChecked = isChecked();
				autoRefresh = isChecked;
				// force the refresh action to update its state
				setNeedsRefresh(needsRefresh);

				// If we just now checked to "auto refresh" and a refresh is necessary, do the refresh
				if (isChecked && needsRefresh) {
					refresh();
				}
			}
		});
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
		memberTreeViewer.getControl().setFocus();
	}

	// ======================================================================
	// == Manage the refresh button
	// ======================================================================

	private void setNeedsRefresh(final boolean value) {
		needsRefresh = value;
		refreshAction.setEnabled(!autoRefresh && value);
	}

	// ======================================================================
	// == Trees
	// ======================================================================

	/*
	 * Cannot use a proper Java enum here because I need the enum instances to read local state of the view and enums
	 * are always static.
	 */
	private abstract class Trees<T extends HierarchyTree<?>> {
		public final void switchTo() {
			treePages.showPage(getPage());
		}
		public final void setChecked() {
			getAction().setChecked(true);
		}

		protected abstract Action getAction();

		protected abstract Composite getPage();
	}

	private final Trees<AncestorTree> ANCESTOR_TREE = new Trees<AncestorTree>() {
		@Override
		protected Action getAction() {
			return ancestorAction;
		}

		@Override
		protected Composite getPage() {
			return ancestorTreeComposite;
		}
	};

	private final Trees<DescendantTree> DESCENDANT_TREE = new Trees<DescendantTree>() {
		@Override
		protected Action getAction() {
			return descendantAction;
		}

		@Override
		protected Composite getPage() {
			return descendantTreeComposite;
		}
	};

	private void createAncestorTree(final Composite parent, final SelectionAndDoubleClickHandler handler) {
		ancestorTreeComposite = new Composite(parent, SWT.NONE);
		final TreeColumnLayout treeColumnLayout = new TreeColumnLayout();
		ancestorTreeComposite.setLayout(treeColumnLayout);

		ancestorTreeViewer = new TreeViewer(ancestorTreeComposite, SWT.H_SCROLL | SWT.V_SCROLL);
		ancestorTreeViewer.getTree().setLinesVisible(false);
		ancestorTreeViewer.getTree().setHeaderVisible(false);
		ancestorTreeViewer.getTree().setFont(parent.getFont());

		final TreeViewerColumn treeViewerCol = new TreeViewerColumn(ancestorTreeViewer, SWT.LEFT);
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
		ancestorTreeViewer.setContentProvider(new ITreeContentProvider() {
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
		ancestorTreeViewer.addSelectionChangedListener(handler);
		ancestorTreeViewer.addDoubleClickListener(handler);
	}

	private void createDescendantTree(final Composite parent, final SelectionAndDoubleClickHandler handler) {
		descendantTreeComposite = new Composite(parent, SWT.NONE);
		final TreeColumnLayout treeColumnLayout = new TreeColumnLayout();
		descendantTreeComposite.setLayout(treeColumnLayout);

		descendantTreeViewer = new TreeViewer(descendantTreeComposite, SWT.H_SCROLL | SWT.V_SCROLL);
		descendantTreeViewer.getTree().setLinesVisible(false);
		descendantTreeViewer.getTree().setHeaderVisible(false);
		descendantTreeViewer.getTree().setFont(parent.getFont());

		final TreeViewerColumn treeViewerCol = new TreeViewerColumn(descendantTreeViewer, SWT.LEFT);
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
		descendantTreeViewer.setContentProvider(new ITreeContentProvider() {
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
		descendantTreeViewer.addSelectionChangedListener(handler);
		descendantTreeViewer.addDoubleClickListener(handler);
	}

	private void createMemberTree(final Composite parent, final SelectionAndDoubleClickHandler handler) {
		final Composite treeComposite = new Composite(parent, SWT.NONE);
		final TreeColumnLayout treeColumnLayout = new TreeColumnLayout();
		treeComposite.setLayout(treeColumnLayout);

		memberTreeViewer = new TreeViewer(treeComposite, SWT.H_SCROLL | SWT.V_SCROLL);
		memberTreeViewer.getTree().setLinesVisible(false);
		memberTreeViewer.getTree().setHeaderVisible(false);
		memberTreeViewer.getTree().setFont(parent.getFont());

		final TreeViewerColumn treeViewerCol = new TreeViewerColumn(memberTreeViewer, SWT.LEFT);
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
		memberTreeViewer.setContentProvider(new ITreeContentProvider() {
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
		memberTreeViewer.addSelectionChangedListener(handler);
		memberTreeViewer.addDoubleClickListener(handler);
	}

	// ======================================================================
	// == Set the view input
	// ======================================================================

	public void setInput(final URI classifierURI) {
		if (classifierURI != null) {
			hierarchyClassifierURI = classifierURI;
			memberClassifierURI = classifierURI;
			final Classifier classifier = (Classifier) new ResourceSetImpl().getEObject(classifierURI, true);
			updateDisplay(classifier, classifier);
		}
	}

	public void setMember(final URI memberURI) {
		if (memberURI != null) {
			memberClassifierURI = memberURI;
			final Classifier classifier = (Classifier) new ResourceSetImpl().getEObject(memberURI, true);
			updateDisplay(null, classifier);
		}
	}

	private void refresh() {
		/*
		 * NB. If hierarhcyClassiferURI is null, then the memberClassifierURI is null. It may be the case
		 * that hierarhcyClassiferURI is non-null and memberClassifierURI is null.
		 */
		if (hierarchyClassifierURI != null) {
			final Classifier hierarchyClassifier = getClassifierFromURI(hierarchyClassifierURI);
			if (hierarchyClassifier != null) {
				// Reset the member classifier to the hierarchy root
				memberClassifierURI = hierarchyClassifierURI;
				updateDisplay(hierarchyClassifier, hierarchyClassifier);
			} else {
				// root node no longer exists, reset the display
				clearDisplay(true);
			}
		}
	}

	/**
	 * Get the Classifier from the URI.  Return {@code null} if the resource
	 * no longer exits, or the resource no longer contains the classifier.
	 */
	private static Classifier getClassifierFromURI(final URI uri) {
		final IFile rsrc = OsateResourceUtil.toIFile(uri);
		if (rsrc.exists()) {
			return (Classifier) new ResourceSetImpl().getEObject(uri, true);
		} else {
			return null;
		}
	}

	private void clearDisplay(final boolean resetURI) {
		clearHierarchy(resetURI);
		clearMembers(resetURI);
	}

	private void clearHierarchy(final boolean resetURI) {
		if (resetURI) {
			hierarchyClassifierURI = null;
			projectDependancies.clear();
		}
		getViewSite().getShell().getDisplay().asyncExec(() -> {
			ancestorTreeViewer.setInput(AncestorTree.EMTPY_TREE);
			descendantTreeViewer.setInput(DescendantTree.EMPTY_TREE);
		});
	}

	private void clearMembers(final boolean resetURI) {
		if (resetURI) {
			memberClassifierURI = null;
		}
		getViewSite().getShell().getDisplay().asyncExec(() -> {
			memberTreeViewer.setInput(MemberTree.EMPTY_TREE);
		});
	}

	// Synchronized to make manipulation of the currentRefreshJob atomic
	private synchronized void updateDisplay(final Classifier inputHierarchy, final Classifier inputMember) {
		// Stop any current refresh job
		if (currentRefreshJob != null) {
			currentRefreshJob.cancel();
		}
		final Job waitForJob = currentRefreshJob;

		// Compute the tree in a separate job and then update the view on the display thread.
		final IWorkbenchSiteProgressService service = getSite().getService(IWorkbenchSiteProgressService.class);
		final Job refreshJob = new Job("Classifier Info View Refresh") {
			@Override
			protected IStatus run(final IProgressMonitor monitor) {
				// Wait for the current refresh to finish (it should have been cancelled)
				if (waitForJob != null) {
					try {
						waitForJob.join();
					} catch (final OperationCanceledException | InterruptedException e) {
						/*
						 * We were interrupted while waiting. Not sure this should be possible, but
						 * if it happens, we clear the display.
						 */
						clearDisplay(false);
						return Status.CANCEL_STATUS;
					}
				}

				boolean needsRefresh = false;
				boolean skipMember = false;
				final SubMonitor subMonitor = SubMonitor.convert(monitor, 2);
				if (inputHierarchy != null) {
					subMonitor.subTask("Buidling classifier hiearchy");
					final Set<IProject> projects = getDependantProjects(inputHierarchy);
					projectDependancies.addAll(projects);

					try {
						final AncestorTree ancestorTreeModel = createAncestorTree(inputHierarchy, subMonitor);
						subMonitor.worked(1);
						final DescendantTree descendantTreeModel = createDescendantTree(inputHierarchy, projects,
								subMonitor.split(1));
						// Update the view contents in the UI thread
						getViewSite().getShell().getDisplay().asyncExec(() -> {
							ancestorTreeViewer.setInput(ancestorTreeModel);
							ancestorTreeViewer.expandToLevel(2);
							ancestorTreeViewer
									.setSelection(new TreeSelection(new TreePath(ancestorTreeModel.getChildren())));

							descendantTreeViewer.setInput(descendantTreeModel);
							descendantTreeViewer.expandToLevel(2);
							descendantTreeViewer
									.setSelection(new TreeSelection(new TreePath(descendantTreeModel.getChildren())));
						});
					} catch (final OperationCanceledException | InterruptedException e) {
						/*
						 * Hierarchy build cancelled-- clear both panes. Originally we just cleared the
						 * hierarchy pane, but then it is confusing what is being shown in the member pane.
						 * Set the 'skip' flag so we don't readd the member pane below.
						 */
						clearDisplay(false);
						// Update incomplete, so we still need to refresh later
						needsRefresh = true;
						skipMember = true;
					}
					subMonitor.done();
				} else {
					subMonitor.worked(2);
				}

				if (inputMember != null && !skipMember) {
					final MemberTree memberTree;
					if (inputMember instanceof ComponentType) {
						memberTree = createMemberTree((ComponentType) inputMember);
					} else if (inputMember instanceof ComponentImplementation) {
						memberTree = createMemberTree((ComponentImplementation) inputMember);
					} else if (inputMember instanceof FeatureGroupType) {
						memberTree = createMemberTree((FeatureGroupType) inputMember);
					} else {
						// Shouldn't get here
						memberTree = null;
					}

					if (memberTree != null) {
						// Update the view contents in the UI thread
						getViewSite().getShell().getDisplay().asyncExec(() -> {
							memberTreeViewer.setInput(memberTree);
							memberTreeViewer.expandToLevel(2);
						});
					} else {
						clearMembers(false);
					}
				}

				setNeedsRefresh(needsRefresh);

				// Mark the view as changed (should show up with a bold title)
				service.warnOfContentChange();
				return Status.OK_STATUS;
			}
		};
		refreshJob.setRule(null); // doesn't write resources
		refreshJob.setUser(true);
		refreshJob.setSystem(false);

		// Run the job using the progress service so that the view is marked as busy (italics)
		currentRefreshJob = refreshJob;
		service.schedule(refreshJob, 0, true);
	}

	// ======================================================================
	// == Helper classes
	// ======================================================================

	// ----------------------------------------------------------------------
	// -- Selection and Double-click Listener
	// ----------------------------------------------------------------------

	private class SelectionAndDoubleClickHandler implements ISelectionChangedListener, IDoubleClickListener {
		@Override
		public void selectionChanged(final SelectionChangedEvent event) {
			URI selectedURI = null;
			final ISelection selection = event.getSelection();
			if (selection instanceof IStructuredSelection) {
				final IStructuredSelection structuredSelection = (IStructuredSelection) selection;
				if (structuredSelection.size() == 1) {
					final URIProvider selectedNode = (URIProvider) structuredSelection.getFirstElement();
					if (selectedNode != null) {
						selectedURI = selectedNode.getURI();
						if (selectedURI != null) {
							// Update the member view if the selection is NOT from the member view
							if (event.getSource() != memberTreeViewer) {
								setMember(selectedURI);
							}
							// Jump in the text editor if we are synchronizing
							if (syncWithEditor) {
								gotoURI(selectedURI);
							}
						}
					}
				}
			}
			lastSelectedURI = selectedURI;
		}

		@Override
		public void doubleClick(final DoubleClickEvent event) {
			final IStructuredSelection selected = (IStructuredSelection) event.getSelection();
			final URIProvider selectedNode = (URIProvider) selected.getFirstElement();
			if (selectedNode != null) {
				final URI selectedURI = selectedNode.getURI();
				if (selectedURI != null) {
					gotoURI(selectedURI);
				}
				lastSelectedURI = selectedURI;
			}
		}
	}

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
			 * See Issue #2436. Need to check for changes to .aadlbin files in the projects that
			 * we care about.
			 */
			final AtomicBoolean changed = new AtomicBoolean(false);
			if (event.getType() == IResourceChangeEvent.POST_CHANGE) {
				final IResourceDelta docDelta = event.getDelta();
				if (docDelta != null) {
					try {
						docDelta.accept(delta -> {
							/*
							 * Must be an ".aadlbin" file in one the projects we care about to be interesting.
							 */
							final IResource resource = delta.getResource();
							if (resource instanceof IFile && resource.getFileExtension().equalsIgnoreCase("aadlbin")
									&& projectDependancies.contains(resource.getProject())) {
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
				if (autoRefresh) {
					refresh();
				} else {
					setNeedsRefresh(true);
				}
			}
		}
	}

	// ----------------------------------------------------------------------
	// -- Generic hierarchy tree
	// ----------------------------------------------------------------------

	private interface URIProvider {
		public URI getURI();
	}

	private abstract static class HierarchyTree<X extends HierarchyTreeNode<?>> {
		private final X[] children;

		private HierarchyTree() {
			children = emptyChildren();
		}

		private HierarchyTree(final X root) {
			children = createChildren(root);
		}

		protected abstract X[] emptyChildren();
		protected abstract X[] createChildren(final X root);

		public final X[] getChildren() {
			return children;
		}
	}

	private abstract class HierarchyTreeNode<SELF extends HierarchyTreeNode<?>> implements URIProvider {
		protected SELF parent;
		private final URI classifierURI;
		private final String label;
		private final Image image;

		private HierarchyTreeNode(final EObject classifier, final String prefix) {
			this.classifierURI = EcoreUtil.getURI(classifier);
			this.label = prefix + modelElementLabelProvider.getText(classifier);
			this.image = modelElementLabelProvider.getImage(classifier);
		}

		@Override
		public final URI getURI() {
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
		private final static AncestorTreeNode[] EMPTY_CHILDREN = new AncestorTreeNode[0];
		public final static AncestorTree EMTPY_TREE = new AncestorTree();

		private AncestorTree() {
			super();
		}

		private AncestorTree(final AncestorTreeNode root) {
			super(root);
		}

		@Override
		protected final AncestorTreeNode[] emptyChildren() {
			return EMPTY_CHILDREN;
		}
		@Override
		protected final AncestorTreeNode[] createChildren(final AncestorTreeNode root) {
			return new AncestorTreeNode[] { root };
		}
	}

	private AncestorTree createAncestorTree(final Classifier classifier, final IProgressMonitor progressMonitor)
			throws InterruptedException {
		return new AncestorTree(createAncestorTreeNode(classifier, NO_PREFIX, progressMonitor));
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

	private AncestorTreeNode createAncestorTreeNode(final Classifier classifier, final String prefix,
			final IProgressMonitor progressMonitor) throws InterruptedException {
		if (progressMonitor.isCanceled()) {
			throw new InterruptedException();
		}

		AncestorTreeNode[] children = new AncestorTreeNode[0];
		if (classifier instanceof ComponentType) {
			final ComponentType extended = ((ComponentType) classifier.getExtended());
			if (extended != null) {
				children = new AncestorTreeNode[] { createAncestorTreeNode(extended, EXTENDS, progressMonitor) };
			}
		} else if (classifier instanceof ComponentImplementation) {
			final ComponentImplementation asCompImpl = (ComponentImplementation) classifier;
			final ComponentType implemented = asCompImpl.getType();
			final ComponentImplementation extended = asCompImpl.getExtended();
			if (extended == null) {
				children = new AncestorTreeNode[] { createAncestorTreeNode(implemented, IMPLEMENTS, progressMonitor) };
			} else {
				children = new AncestorTreeNode[] { createAncestorTreeNode(implemented, IMPLEMENTS, progressMonitor),
						createAncestorTreeNode(extended, EXTENDS, progressMonitor) };
			}
		} else if (classifier instanceof FeatureGroupType) {
			final FeatureGroupType asFeatureGroup = (FeatureGroupType) classifier;
			final FeatureGroupType inverseOf = asFeatureGroup.getInverse();
			final FeatureGroupType extended = asFeatureGroup.getExtended();
			final List<AncestorTreeNode> childrenList = new ArrayList<>(2);
			if (inverseOf != null) {
				childrenList.add(createAncestorTreeNode(inverseOf, INVERSE_OF, progressMonitor));
			}
			if (extended != null) {
				childrenList.add(createAncestorTreeNode(extended, EXTENDS, progressMonitor));
			}
			children = childrenList.toArray(children);
		}
		return new AncestorTreeNode(classifier, prefix, children);
	}

	// ----------------------------------------------------------------------
	// -- Descendant tree
	// ----------------------------------------------------------------------


	private final static class DescendantTree extends HierarchyTree<DescendantTreeNode> {
		private static final DescendantTreeNode[] EMPTY_CHILDREN = new DescendantTreeNode[0];
		public static final DescendantTree EMPTY_TREE = new DescendantTree();

		private DescendantTree() {
			super();
		}

		private DescendantTree(final DescendantTreeNode root) {
			super(root);
		}

		@Override
		protected final DescendantTreeNode[] emptyChildren() {
			return EMPTY_CHILDREN;
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

	private DescendantTree createDescendantTree(final Classifier rootClassifier, final Set<IProject> projects,
			final IProgressMonitor progressMonitor) throws InterruptedException {
		final SubMonitor subMonitor = SubMonitor.convert(progressMonitor);

		final Deque<DescendantTreeNode> deque = new LinkedList<>();
		final DescendantTreeNode root = new DescendantTreeNode(rootClassifier, NO_PREFIX);
		deque.addLast(root);

		/* We maintain a queue of classifiers to search for, starting with our root classifier. For each
		 * one, we look for all references to it, and then process all references that appear in a context
		 * where it is being implemented/extended/inverted.
		 */
		final AadlFinder.Scope scope = new AadlFinder.ResourceSetScope(projects);
		while (!deque.isEmpty()) {
			if (subMonitor.isCanceled()) {
				throw new InterruptedException();
			}

			final DescendantTreeNode current = deque.removeFirst();

			/* Find all the references to the current classifier */
			// Use the "logarithmic progress pattern described in SubMonitor JavaDoc
			subMonitor.subTask(current.getText());
			subMonitor.setWorkRemaining(10);
			final AtomicBoolean cancelled = new AtomicBoolean(false);
			AadlFinder.getInstance().getAllReferencesToTypeInScope(scope, (resourceSet, refDesc) -> {
				if (subMonitor.isCanceled()) {
					cancelled.set(true);
				}
				if (refDesc.getTargetEObjectUri().equals(current.getURI())) {
					subMonitor.setWorkRemaining(10);
					subMonitor.split(1);
					final URI sourceEObjectUri = refDesc.getSourceEObjectUri();
					final EObject eObj = resourceSet.getEObject(sourceEObjectUri, true);

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
					}
				}
			}, subMonitor.split(1));
			if (cancelled.get()) {
				throw new InterruptedException();
			}
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
		private static final SectionNode[] EMPTY_SECTIONS = new SectionNode[0];
		private static final MemberTree EMPTY_TREE = new MemberTree();

		private final SectionNode[] sections;

		private MemberTree() {
			sections = EMPTY_SECTIONS;
		}

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
		List<FlowSpecification> flowSpecs = ci.getType().getAllFlowSpecifications();
		if (flowSpecs == null) {
			flowSpecs = Collections.emptyList();
		}
		List<FlowImplementation> flowImpls = ci.getAllFlowImplementations();
		if (flowImpls == null) {
			flowImpls = Collections.emptyList();
		}
		List<EndToEndFlow> end2endFlows = ci.getAllEndToEndFlows();
		if (end2endFlows == null) {
			end2endFlows = Collections.emptyList();
		}
		if (!flowSpecs.isEmpty() || !flowImpls.isEmpty() || !end2endFlows.isEmpty()) {
			sections.add(createSectionFromFlowImplementations(ci, flowSpecs, flowImpls, end2endFlows));
		}
	}

	private static interface MemberTreeNode extends URIProvider {
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
		public URI getURI() {
			return null;
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
			List<FlowSpecification> flowSpecs, List<FlowImplementation> flowImpls, List<EndToEndFlow> end2endFlows) {
		/*
		 * Get all the flow specifications from the type. Overlay on top of them the flow implementations
		 * from the implementation. That is, anything that is implemented in the implementation will be
		 * replaced by the Flow implementation in the map.
		 */
		final Map<String, NamedElement> flowSpecsAndImplsMap = new HashMap<>();
		flowSpecs.forEach(fs -> flowSpecsAndImplsMap.put(fs.getName(), fs));
		flowImpls.forEach(fi -> flowSpecsAndImplsMap.put(fi.getSpecification().getFullName(), fi));
		final List<NamedElement> flowSpecsAndImpls = new ArrayList<>(flowSpecsAndImplsMap.values());

		final List<MemberNode> memberNodes = new ArrayList<>();

		Collections.sort(flowSpecsAndImpls, MEMBER_COMPARATOR);
		flowSpecsAndImpls.forEach(f -> {
			if (f instanceof FlowSpecification) {
				memberNodes.add(createMemberNode(ci, (FlowSpecification) f, ClassifierInfoView::getRefinedFlowSpec));
			} else {
				memberNodes.add(createMemberNodeFromFlowImplementation(ci, (FlowImplementation) f));
			}
		});

		Collections.sort(end2endFlows, MEMBER_COMPARATOR);
		end2endFlows
				.forEach(e2e -> memberNodes.add(createMemberNode(ci, e2e, ClassifierInfoView::getRefinedEndToEndFlow)));
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

		@Override
		public URI getURI() {
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

	private static void gotoURI(final URI gotoURI) {
		UiUtil.getInstance().openDeclarativeModelElement(gotoURI);
	}

	private static String getName(NamedElement ne) {
		return (ne != null && !ne.eIsProxy() && ne.getName() != null) ? ne.getName() : UNNAMED;
	}
}
