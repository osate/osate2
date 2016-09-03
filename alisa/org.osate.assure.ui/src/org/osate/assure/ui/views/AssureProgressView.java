/**
 * Copyright 2015 Carnegie Mellon University. All Rights Reserved.
 *
 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING INSTITUTE
 * MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO
 * WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY,
 * EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON
 * UNIVERSITY DOES NOT MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM
 * PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * Released under the Eclipse Public License (http://www.eclipse.org/org/documents/epl-v10.php)
 *
 * See COPYRIGHT file for full details.
 */

package org.osate.assure.ui.views;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ContributionManager;
import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.menus.IMenuService;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.GlobalURIEditorOpener;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.IXtextModelListener;
import org.eclipse.xtext.ui.editor.utils.EditorUtils;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.osate.assure.assure.AssuranceCaseResult;
import org.osate.assure.assure.AssureResult;
import org.osate.assure.assure.ClaimResult;
import org.osate.assure.assure.Metrics;
import org.osate.assure.assure.QualifiedClaimReference;
import org.osate.assure.assure.QualifiedVAReference;
import org.osate.assure.util.AssureUtilExtension;
import org.osate.categories.categories.CategoryFilter;

import com.google.inject.Inject;

public class AssureProgressView extends ViewPart {
	public static final String ID = "org.osate.assure.ui.views.assureProgressView";
	private TreeViewer treeViewer;
	public static String HIDE_CLAIMRESULTS_TOOL_TIP = "Hide Claim Results";
	public static String SHOW_CLAIMRESULTS_TOOL_TIP = "Show Claim Results";
	private NoClaimResultsFilter noClaimsResultFilter = new NoClaimResultsFilter();

	IXtextDocument xtextDoc;
	IXtextModelListener modelListener = new IXtextModelListener() {

		@Override
		public void modelChanged(XtextResource resource) {
//				System.out.println("model changed: " + resource);
			getSite().getShell().getDisplay().asyncExec(new Runnable() {

				@Override
				public void run() {
					if (inputURI != null) {
						AssuranceCaseResult assuranceCase = xtextDoc
								.readOnly(new IUnitOfWork<AssuranceCaseResult, XtextResource>() {
									@Override
									public AssuranceCaseResult exec(XtextResource state) throws Exception {
										return (AssuranceCaseResult) state.getResourceSet().getEObject(inputURI, true);
									}
								});
						// treeViewer.setInput(Arrays.asList(assuranceCase));
						treeViewer.setInput(assuranceCase);
					}

				}
			});
		}
	};

	@Inject
	GlobalURIEditorOpener globalURIEditorOpener;

//	@Inject
//	ILabelProvider labelProvider;
	URI inputURI;

	@Override
	public void createPartControl(Composite parent) {

//		Tree resultTree = new Tree(parent, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
//		resultTree.setHeaderVisible(true);

//		Composite mainComposite = new Composite(parent, SWT.NONE);
//		mainComposite.setLayout(new GridLayout(3, false));

		treeViewer = new AssureProgressTreeViewer(parent,
				SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.VIRTUAL);

//		resultTree.setLinesVisible(false);

//	        treeViewer = new TreeViewer(parent, SWT.SINGLE);
		getSite().setSelectionProvider(treeViewer);

		AssureTooltipListener.createAndRegister(treeViewer);
		treeViewer.addFilter(new NoMetricsRefObjectsFilter());

		// treeViewer.addFilter(noClaimsResultFilter);
//	        getSite().getPage().addSelectionListener("org.osate.assure.Assure",listener);
		MenuManager manager = new MenuManager();
		manager.setRemoveAllWhenShown(true);

		manager.addMenuListener(new IMenuListener() {
			@Override
			public void menuAboutToShow(IMenuManager manager) {
				IStructuredSelection selection = (IStructuredSelection) treeViewer.getSelection();
				if (!selection.isEmpty()) {
					final AssureResult ar = (AssureResult) selection.getFirstElement();

					if (ar instanceof ClaimResult) {
						final ClaimResult claim = (ClaimResult) ar;
						EObject location = AssureUtilExtension.getTarget(claim);
//	                    if (claim instanceof FailResult) {
//	                        manager.add(createHyperlinkAction("Open Failure Location", location));
//	                    } else if (location instanceof ProveStatement) { 
//	                        manager.add(createHyperlinkAction("Open Prove Statement", location));
//	                        manager.add(createExportSubmenu(claim));
//	                    } else {
						manager.add(createHyperlinkAction("Open Requirement", location));
//	                    }
//	                    Map<String, EObject> references = claim.getReferences();
//	                    for (String name : new TreeSet<String>(references.keySet())) {
//	                        manager.add(createHyperlinkAction("Go to '" + name + "'",
//	                                references.get(name)));
//	                    }

						manager.add(new Action("Copy Claim Text") {
							@Override
							public void run() {
								Transferable text = new StringSelection(
										AssureUtilExtension.constructDescription(claim));
								Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
								clipboard.setContents(text, null);
							}
						});
					}
				}

				manager.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
				IMenuService menuService = getViewSite().getWorkbenchWindow().getService(IMenuService.class);
				menuService.populateContributionManager((ContributionManager) manager, "popup:" + ID);
			}
		});
		getViewSite().getActionBars().getToolBarManager().add(createToggleShowClaimResultsAction());
		treeViewer.getControl().setMenu(manager.createContextMenu(treeViewer.getTree()));

	}

	public void dispose() {
		if (xtextDoc != null)
			xtextDoc.removeModelListener(modelListener);
	}

	private IAction createHyperlinkAction(String text, final EObject eObject) {
		return new Action(text) {
			@Override
			public void run() {
				globalURIEditorOpener.open(EcoreUtil.getURI(eObject), true);
			}
		};
	}

	private IAction createToggleShowClaimResultsAction() {

		IAction result = new Action("Show Claim Results", IAction.AS_CHECK_BOX) {
			public void run() {
				if (isChecked()) {
					setToolTipText(HIDE_CLAIMRESULTS_TOOL_TIP);
					treeViewer.removeFilter(noClaimsResultFilter);
				} else {
					setToolTipText(SHOW_CLAIMRESULTS_TOOL_TIP);
					treeViewer.addFilter(noClaimsResultFilter);
				}
				treeViewer.refresh();
			}
		};
		result.setChecked(true);
		result.setImageDescriptor(ImageDescriptor.createFromFile(AssureProgressView.class, "/icons/claims.png"));
		return result;
	}

	public void setProofs(AssuranceCaseResult proofTrees, CategoryFilter filter) {
		if (xtextDoc != null) {
			xtextDoc.removeModelListener(modelListener);
		}
		xtextDoc = EditorUtils.getActiveXtextEditor().getDocument();
		xtextDoc.addModelListener(modelListener);
//		Object[] expandedElements = treeViewer.getExpandedElements();
//		TreePath[] expandedTreePaths = treeViewer.getExpandedTreePaths();

		treeViewer.setContentProvider(new AssureProgressContentProvider(filter));

		if (proofTrees != null) {
			inputURI = EcoreUtil.getURI(proofTrees);
			// treeViewer.setInput(Arrays.asList(proofTrees));
			treeViewer.setInput(proofTrees);
		} else {
			inputURI = null;
			// treeViewer.setInput(Collections.emptyList());
			treeViewer.setInput(null);
		}
//		treeViewer.setExpandedElements(expandedElements);
//		treeViewer.setExpandedTreePaths(expandedTreePaths);
	}

	@Override
	public void setFocus() {
		treeViewer.getControl().setFocus();
	}

	/**
	 * Viewer Filter class.
	 */
	private class NoMetricsRefObjectsFilter extends ViewerFilter {

		/**
		 * @param viewer the viewer
		 * @param parentElement the parent element
		 * @param element the element
		 * @return if the element is to display: true
		 * @see org.eclipse.jface.viewers.ViewerFilter
		 *      #select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
		 */
		@Override
		public boolean select(Viewer viewer, Object parentElement, Object element) {
			if (element instanceof Metrics|| element instanceof QualifiedClaimReference
					|| element instanceof QualifiedVAReference) {
				return false;
			}
			return true;
		}
	}

	private class NoClaimResultsFilter extends ViewerFilter {
		/**
		 * @param viewer the viewer
		 * @param parentElement the parent element
		 * @param element the element
		 * @return if the element is to display: true
		 * @see org.eclipse.jface.viewers.ViewerFilter
		 *      #select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
		 */
		@Override
		public boolean select(Viewer viewer, Object parentElement, Object element) {
			if (element instanceof ClaimResult) {
				return false;
			}
			return true;
		}
	}

	public TreeViewer getTreeViewer() {
		return treeViewer;
	}
}
