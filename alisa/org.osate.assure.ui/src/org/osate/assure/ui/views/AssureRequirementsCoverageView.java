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

import java.util.Arrays;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.xtext.ui.editor.GlobalURIEditorOpener;
import org.osate.assure.assure.AssuranceCaseResult;
import org.osate.assure.assure.ClaimResult;
import org.osate.assure.assure.Metrics;
import org.osate.assure.evaluator.IAssureRequirementMetricsProcessor;
import org.osate.assure.ui.labeling.AssureFeaturesRequirementsColumnLabelProvider;
import org.osate.assure.ui.labeling.AssureNoVerificationPlansColumnLabelProvider;
import org.osate.assure.ui.labeling.AssureQualityCategoryRequirementsColumnLabelProvider;
import org.osate.assure.ui.labeling.AssureRequirementsCoverageMetricsEMV2ColumnLabelProvider;
import org.osate.assure.ui.labeling.AssureRequirementsCoverageMetricsExceptionColumnLabelProvider;
import org.osate.assure.ui.labeling.AssureRequirementsCoverageMetricsFeaturesRequiringClassifierLabelProvider;
import org.osate.assure.ui.labeling.AssureRequirementsCoverageNameColumnLabelProvider;
import org.osate.assure.ui.labeling.AssureRequirementsWithNoPlanClaimColumnLabelProvider;
import org.osate.assure.util.AssureUtilExtension;
import org.osate.categories.categories.CategoryFilter;
import org.osate.verify.util.VerifyUtilExtension;

import com.google.inject.Inject;

public class AssureRequirementsCoverageView extends ViewPart {
	public static final String ID = "org.osate.assure.ui.views.assure.requirements.coverage.view";
	private TreeViewer treeViewer;
	public static String HIDE_CLAIMRESULTS_TOOL_TIP = "Hide Claim Results";
	public static String SHOW_CLAIMRESULTS_TOOL_TIP = "Show Claim Results";
	private NoClaimResultsFilter noClaimsResultFilter = new NoClaimResultsFilter();

	private AlisaView alisaView;
	private CategoryFilter selectedCategoryFilter;
	private AssuranceCaseResult recentProofTrees;

	@Inject
	private IAssureRequirementMetricsProcessor assureRequirementMetricsProcessor;

//	IXtextDocument xtextDoc;
//	IXtextModelListener modelListener = new IXtextModelListener() {
//
//		@Override
//		public void modelChanged(XtextResource resource) {
////				System.out.println("model changed: " + resource);
//			getSite().getShell().getDisplay().asyncExec(new Runnable() {
//
//				@Override
//				public void run() {
//					if (inputURI != null) {
//						AssuranceCaseResult assuranceCase = xtextDoc
//								.readOnly(new IUnitOfWork<AssuranceCaseResult, XtextResource>() {
//									@Override
//									public AssuranceCaseResult exec(XtextResource state) throws Exception {
//										return (AssuranceCaseResult) state.getResourceSet().getEObject(inputURI, true);
//									}
//								});
//						treeViewer.setInput(Arrays.asList(assuranceCase));
//					}
//
//				}
//			});
//		}
//	};

	@Inject
	GlobalURIEditorOpener globalURIEditorOpener;

	@Inject
	ILabelProvider labelProvider;
	URI inputURI;

	protected void updateSelectedFilter() {
		if (alisaView == null) {
			try {
				IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
				alisaView = (AlisaView) page.showView(AlisaView.ID);
			} catch (PartInitException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				selectedCategoryFilter = null;
				return;
			}
		}
		selectedCategoryFilter = alisaView.getSelectedCategoryFilter();
		if (selectedCategoryFilter == null) {
			System.out.println("AssureRequirementsCoverageView.updateSelectedFilter() null");
		} else {
			System.out.println(
					"AssureRequirementsCoverageView.updateSelectedFilter() " + selectedCategoryFilter.getName());
		}
	}

	/**
	 * 
	 * @return Whether prooftree has been changed. 
	 */
	protected boolean updateRecentProofTrees() {

		AssuranceCaseResult oldProofTrees = recentProofTrees;

		if (alisaView == null) {
			try {
				IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
				alisaView = (AlisaView) page.showView(AlisaView.ID);
			} catch (PartInitException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				recentProofTrees = null;
				return true;
			}
		}
		if (alisaView.getSelectedAssuranceCase() == null) {
			System.out.println(
					"AssureRequirementsCoverageView.updateRecentProofTrees() null -- Assurance case is not selected in Alisaview");
		} else {
			recentProofTrees = alisaView.findCaseResult(alisaView.getSelectedAssuranceCase().getName());
			if (recentProofTrees == null) {
				System.out.println(
						"AssureRequirementsCoverageView.updateRecentProofTrees() null -- Failed to find assure file or never been generated.");
			} else {
				System.out.println(
						"AssureRequirementsCoverageView.updateRecentProofTrees() " + recentProofTrees.getName());
			}
		}

		return oldProofTrees != recentProofTrees;
	}

	@Override
	public void createPartControl(Composite parent) {

		Tree resultTree = new Tree(parent, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		resultTree.setHeaderVisible(true);

		treeViewer = new TreeViewer(resultTree);
		treeViewer.addFilter(noClaimsResultFilter);
		resultTree.setLinesVisible(true);
		TreeViewerColumn column0 = new TreeViewerColumn(treeViewer, SWT.LEFT);
		column0.getColumn().setAlignment(SWT.LEFT);
		column0.getColumn().setText("");
		column0.getColumn().setWidth(300);
		column0.getColumn().setResizable(true);
		column0.setLabelProvider(new AssureRequirementsCoverageNameColumnLabelProvider());

//	        List<TreeViewerColumn> indicatorColumns = new ArrayList<TreeViewerColumn>();
//	        for (int i=0; i<10; i++){
//	        	indicatorColumns.add(new TreeViewerColumn(treeViewer, SWT.RIGHT));
//	        	indicatorColumns.get(i).getColumn().setAlignment(SWT.LEFT);
//	        	indicatorColumns.get(i).getColumn().setWidth(45);
//	        	indicatorColumns.get(i).getColumn().setResizable(false);
//        		indicatorColumns.get(i).getColumn().setText("");
//	        	if (i==0){
//	        		indicatorColumns.get(i).getColumn().setText("0");
//		        	indicatorColumns.get(i).getColumn().setAlignment(SWT.LEFT);
//	        	} else if (i==5){
//	        		indicatorColumns.get(i).getColumn().setText(".5    -");
//		        	indicatorColumns.get(i).getColumn().setAlignment(SWT.LEFT );
//	        	} else if (i==9){
//	        		indicatorColumns.get(i).getColumn().setText("1");
//		        	indicatorColumns.get(i).getColumn().setAlignment(SWT.RIGHT);
//	        	} else {
//	        		indicatorColumns.get(i).getColumn().setText("-");
//	        		if (i > 4) 
//	        			indicatorColumns.get(i).getColumn().setAlignment(SWT.RIGHT);
//	        		else 
//	        			indicatorColumns.get(i).getColumn().setAlignment(SWT.CENTER);
//	        	}
//	        	indicatorColumns.get(i).setLabelProvider(new AssureColorColumnLabelProvider(i));
//	        }

//	        TreeViewerColumn column2 = new TreeViewerColumn(treeViewer, SWT.RIGHT);
//	        column2.getColumn().setAlignment(SWT.LEFT);
//	        column2.getColumn().setText("Description");
//	        column2.getColumn().setWidth(450);
//	        column2.getColumn().setResizable(true);
//	        column2.setLabelProvider(new AssureDescriptionColumnLabelProvider());

		TreeViewerColumn column1 = new TreeViewerColumn(treeViewer, SWT.RIGHT);
		column1.getColumn().setAlignment(SWT.LEFT);
		column1.getColumn().setText("Reqs w/no plan claim");
		column1.getColumn().setWidth(160);
		column1.getColumn().setResizable(true);
		column1.setLabelProvider(new AssureRequirementsWithNoPlanClaimColumnLabelProvider());

		TreeViewerColumn column2 = new TreeViewerColumn(treeViewer, SWT.RIGHT);
		column2.getColumn().setAlignment(SWT.LEFT);
		column2.getColumn().setText("Quality Categories Cvrg");
		column2.getColumn().setWidth(180);
		column2.getColumn().setResizable(true);
		column2.setLabelProvider(new AssureQualityCategoryRequirementsColumnLabelProvider());

		TreeViewerColumn column3 = new TreeViewerColumn(treeViewer, SWT.RIGHT);
		column3.getColumn().setAlignment(SWT.LEFT);
		column3.getColumn().setText("Requirement for Features");
		column3.getColumn().setWidth(180);
		column3.getColumn().setResizable(true);
		column3.setLabelProvider(new AssureFeaturesRequirementsColumnLabelProvider());

		TreeViewerColumn column4 = new TreeViewerColumn(treeViewer, SWT.RIGHT);
		column4.getColumn().setAlignment(SWT.LEFT);
		column4.getColumn().setText("No Verify Plans");
		column4.getColumn().setWidth(120);
		column4.getColumn().setResizable(true);
		column4.setLabelProvider(new AssureNoVerificationPlansColumnLabelProvider());

		TreeViewerColumn column5 = new TreeViewerColumn(treeViewer, SWT.RIGHT);
		column5.getColumn().setAlignment(SWT.LEFT);
		column5.getColumn().setText("Reqs w/Exception");
		column5.getColumn().setWidth(150);
		column5.getColumn().setResizable(true);
		column5.setLabelProvider(new AssureRequirementsCoverageMetricsExceptionColumnLabelProvider());

		TreeViewerColumn column6 = new TreeViewerColumn(treeViewer, SWT.RIGHT);
		column6.getColumn().setAlignment(SWT.LEFT);
		column6.getColumn().setText("Req Target w/EMV2");
		column6.getColumn().setWidth(150);
		column6.getColumn().setResizable(true);
		column6.setLabelProvider(new AssureRequirementsCoverageMetricsEMV2ColumnLabelProvider());

		TreeViewerColumn column7 = new TreeViewerColumn(treeViewer, SWT.RIGHT);
		column7.getColumn().setAlignment(SWT.LEFT);
		column7.getColumn().setText("Classifiers for Features Requiring");
		column7.getColumn().setWidth(150);
		column7.getColumn().setResizable(true);
		column7.setLabelProvider(new AssureRequirementsCoverageMetricsFeaturesRequiringClassifierLabelProvider());

//	        treeViewer = new TreeViewer(parent, SWT.SINGLE);
		getSite().setSelectionProvider(treeViewer);
		treeViewer.setContentProvider(new AssureContentProvider());
//	        treeViewer.setLabelProvider(labelProvider);//new AssureLabelProvider(null));
		AssureTooltipListener.createAndRegister(treeViewer);
		treeViewer.addFilter(new NoMetricsFilter());
		// treeViewer.addFilter(noClaimsResultFilter);
//	        getSite().getPage().addSelectionListener("org.osate.assure.Assure",listener);
		/*
		 * MenuManager manager = new MenuManager();
		 * manager.setRemoveAllWhenShown(true);
		 * 
		 * 
		 * manager.addMenuListener(new IMenuListener() {
		 * 
		 * @Override
		 * public void menuAboutToShow(IMenuManager manager) {
		 * IStructuredSelection selection = (IStructuredSelection) treeViewer.getSelection();
		 * if (!selection.isEmpty()) {
		 * final AssureResult ar = (AssureResult) selection.getFirstElement();
		 * 
		 * if (ar instanceof ClaimResult){
		 * final ClaimResult claim = (ClaimResult) ar;
		 * EObject location = AssureUtilExtension.getTarget(claim);
		 * // if (claim instanceof FailResult) {
		 * // manager.add(createHyperlinkAction("Open Failure Location", location));
		 * // } else if (location instanceof ProveStatement) {
		 * // manager.add(createHyperlinkAction("Open Prove Statement", location));
		 * // manager.add(createExportSubmenu(claim));
		 * // } else {
		 * manager.add(createHyperlinkAction("Open Requirement", location));
		 * // }
		 * // Map<String, EObject> references = claim.getReferences();
		 * // for (String name : new TreeSet<String>(references.keySet())) {
		 * // manager.add(createHyperlinkAction("Go to '" + name + "'",
		 * // references.get(name)));
		 * // }
		 * 
		 * manager.add(new Action("Copy Claim Text") {
		 * 
		 * @Override
		 * public void run() {
		 * Transferable text = new StringSelection(AssureUtilExtension.constructDescription(claim));
		 * Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		 * clipboard.setContents(text, null);
		 * }
		 * });
		 * }
		 * }
		 * 
		 * manager.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
		 * IMenuService menuService = getViewSite().getWorkbenchWindow().getService(IMenuService.class);
		 * menuService.populateContributionManager((ContributionManager) manager, "popup:" + ID);
		 * }
		 * });
		 */
		// getViewSite().getActionBars().getToolBarManager().add(createToggleShowClaimResultsAction());
		// treeViewer.getControl().setMenu(manager.createContextMenu(treeViewer.getTree()));

		resultTree.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void focusGained(FocusEvent e) {

				// Updates recentProofTrees based on selection from AlisaView
				boolean changed = updateRecentProofTrees();

				if (recentProofTrees != null) {
					CategoryFilter oldfilter = selectedCategoryFilter;
					updateSelectedFilter();

					if (changed || oldfilter != selectedCategoryFilter) {
						setProofs(recentProofTrees, selectedCategoryFilter);
					}
				}

			}
		});

	}

	public void dispose() {
//		if (xtextDoc != null)
//			xtextDoc.removeModelListener(modelListener);
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
		result.setImageDescriptor(
				ImageDescriptor.createFromFile(AssureRequirementsCoverageView.class, "/icons/claims.png"));
		return result;
	}

	public void setProofs(AssuranceCaseResult proofTrees, CategoryFilter filter) {
//		if (xtextDoc != null) {
//			xtextDoc.removeModelListener(modelListener);
//		}
//
//		xtextDoc = EditorUtils.getActiveXtextEditor().getDocument();
//		xtextDoc.addModelListener(modelListener);
		Object[] expandedElements = treeViewer.getExpandedElements();
		TreePath[] expandedTreePaths = treeViewer.getExpandedTreePaths();
		if (proofTrees != null) {
			recentProofTrees = proofTrees;
			inputURI = EcoreUtil.getURI(proofTrees);

			VerifyUtilExtension.clearAllHasRunRecords();
			AssureUtilExtension.clearAllInstanceModels();
			assureRequirementMetricsProcessor.processCase(recentProofTrees, filter, null);
			AssureContentProvider contentProvider = (AssureContentProvider) treeViewer.getContentProvider();
			contentProvider.setFilter(filter);
			treeViewer.setInput(Arrays.asList(recentProofTrees));
		} else {
			inputURI = null;
			treeViewer.setInput(Collections.emptyList());
		}
		treeViewer.setExpandedElements(expandedElements);
		treeViewer.setExpandedTreePaths(expandedTreePaths);
	}

	@Override
	public void setFocus() {
		treeViewer.getControl().setFocus();
	}

	public TreeViewer getTreeViewer() {
		return treeViewer;
	}

	/**
	 * Viewer Filter class.
	 */
	private class NoMetricsFilter extends ViewerFilter {

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
			if (element instanceof Metrics) {
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

}
