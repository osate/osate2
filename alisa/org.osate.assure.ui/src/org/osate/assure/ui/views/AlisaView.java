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
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.core.runtime.jobs.MultiRule;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ContributionManager;
import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.menus.IMenuService;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.GlobalURIEditorOpener;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.IXtextModelListener;
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode;
import org.eclipse.xtext.ui.editor.utils.EditorUtils;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.osate.alisa.workbench.alisa.AlisaPackage;
import org.osate.alisa.workbench.alisa.AssuranceCase;
import org.osate.alisa.workbench.util.IAlisaGlobalReferenceFinder;
import org.osate.assure.assure.AssuranceCaseResult;
import org.osate.assure.assure.AssurePackage;
import org.osate.assure.assure.AssureResult;
import org.osate.assure.assure.ClaimResult;
import org.osate.assure.assure.Metrics;
import org.osate.assure.generator.IAssureConstructor;
import org.osate.assure.ui.handlers.AssureHandler;
import org.osate.assure.util.AssureUtilExtension;
import org.osate.categories.categories.CategoriesPackage;
import org.osate.categories.categories.CategoryFilter;
import org.osate.workspace.WorkspacePlugin;

import com.google.inject.Inject;

public class AlisaView extends ViewPart {

//	@Inject
//	Provider<XtextResourceSet> resourceSetProvider;

	public static final String ID = "org.osate.assure.ui.views.alisaView";
	private static final String FILTER_NONE = "None";
	private static final String BUTTON_READY = "Execute Assurance Case\nwith Selected Filter";
	private static final String BUTTON_WAITING = "Select Assurance Case to Execute";
	private TreeViewer treeViewer;

	private ResourceSet currentResourceSet;
	private ArrayList<String> filterNames = new ArrayList<String>();
	private Combo filterCombo;
	private Button alisaButton;
	private AssuranceCase selectedAssuranceCase;
	private URI assureDirURI, assureURI;
	private Map<String, CategoryFilter> globalFilterList = Collections
			.synchronizedMap(new HashMap<String, CategoryFilter>());
//	private NoClaimResultsFilter noClaimsResultFilter = new NoClaimResultsFilter();

	private ISchedulingRule msr;
	private WorkspaceJob loadAssuranceCaseJob;
	private ArrayList<AssuranceCase> loadAssuranceCaseResult = new ArrayList<AssuranceCase>();

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

//						treeViewer.setInput(assuranceCase);
					}

				}
			});
		}
	};

	@Inject
	GlobalURIEditorOpener globalURIEditorOpener;

	@Inject
	IAssureConstructor assureConstructor;

//	@Inject
//	ILabelProvider labelProvider;
	URI inputURI;

	IPartListener partListener = new IPartListener() {

		@Override
		public void partActivated(IWorkbenchPart part) {
			loadAssuranceCases();
		}

		@Override
		public void partBroughtToTop(IWorkbenchPart part) {
			// TODO Auto-generated method stub

		}

		@Override
		public void partClosed(IWorkbenchPart part) {
			// TODO Auto-generated method stub

		}

		@Override
		public void partDeactivated(IWorkbenchPart part) {
			// TODO Auto-generated method stub

		}

		@Override
		public void partOpened(IWorkbenchPart part) {
			loadAssuranceCases();

		};
	};

	@Override
	public void createPartControl(Composite parent) {

//		Tree resultTree = new Tree(parent, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
//		resultTree.setHeaderVisible(true);

//		Composite mainComposite = new Composite(parent, SWT.NONE);
//		mainComposite.setLayout(new GridLayout(3, false));

//		Composite mainComposite = new Composite(parent, SWT.NONE);
		parent.setLayout(new GridLayout(2, false));

		treeViewer = new AlisaTreeViewer(parent,
				SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.VIRTUAL);
		treeViewer.getTree().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		treeViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				if (event.getSelection().isEmpty()) {
					alisaButton.setEnabled(false);
					alisaButton.setText(BUTTON_WAITING);
					alisaButton.redraw();
					return;
				}
				if (event.getSelection() instanceof IStructuredSelection) {
					IStructuredSelection selection = (IStructuredSelection) event.getSelection();
					if (selection.getFirstElement() instanceof AssuranceCase) {
						selectedAssuranceCase = (AssuranceCase) selection.getFirstElement();
						System.out.println("selectedAssuranceCase: " + selectedAssuranceCase.getName());
						alisaButton.setEnabled(true);
						alisaButton.setText(BUTTON_READY);
						alisaButton.redraw();

					} else {
						alisaButton.setEnabled(false);
						alisaButton.setText(BUTTON_WAITING);
						alisaButton.redraw();
					}
				}

			}
		});
//		resultTree.setLinesVisible(false);

//	        treeViewer = new TreeViewer(parent, SWT.SINGLE);
		getSite().setSelectionProvider(treeViewer);

		AssureTooltipListener.createAndRegister(treeViewer);

//		treeViewer.addFilter(new NoMetricsFilter());

		// treeViewer.addFilter(noClaimsResultFilter);
//	        getSite().getPage().addSelectionListener("org.osate.assure.Assure",listener);

		// Not sure we need this.
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
		// getViewSite().getActionBars().getToolBarManager().add(createToggleShowClaimResultsAction());
		treeViewer.getControl().setMenu(manager.createContextMenu(treeViewer.getTree()));

		Composite rightSide = new Composite(parent, SWT.NONE);
		rightSide.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true));
		rightSide.setLayout(new GridLayout(1, false));

		Label filterLabel = new Label(rightSide, SWT.CENTER);
		filterLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false));
		filterLabel.setText("Select Filter:                                        ");

		filterCombo = new Combo(rightSide, SWT.BORDER | SWT.DROP_DOWN | SWT.READ_ONLY);
		GridData filterComboGridData = new GridData(SWT.FILL, SWT.FILL, false, false);
		filterComboGridData.minimumWidth = 500;
		filterCombo.setLayoutData(filterComboGridData);

		updateFilterCombo(null);

		filterCombo.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		alisaButton = new Button(rightSide, SWT.CENTER | SWT.WRAP);
		alisaButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		alisaButton.setText(BUTTON_WAITING);
		alisaButton.setEnabled(false);

		alisaButton.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				if (selectedAssuranceCase != null) {

					AssureHandler ah = new AssureHandler();

					ah.prepare();

					// Doesn't seem to always find it.
					AssuranceCaseResult assuranceCaseResult = findCaseResult(selectedAssuranceCase.getName());
					if (assuranceCaseResult == null) {
						System.err.println("AlisaView.createPartControl() matching assure resource not found.");

						assuranceCaseResult = createCaseResult(selectedAssuranceCase.getName());
					} else {
						System.out.println("  >>>>>>>>>>>>Found existing assure resource");

						// Just for now to have assureDirURI
						URI uri = null;
						if (selectedAssuranceCase instanceof EObjectNode) {
							uri = ((EObjectNode) selectedAssuranceCase).getEObjectURI();
						} else if (selectedAssuranceCase instanceof EObject) {
							uri = EcoreUtil.getURI((EObject) selectedAssuranceCase);
						}
						URI file_uri = uri;
						IWorkspaceRoot myWorkspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
						for (int i = 0; i < myWorkspaceRoot.getProjects().length; i++) {
							IProject tempProject = myWorkspaceRoot.getProjects()[i];
							if (tempProject.isAccessible()) {
								System.out.println("Project paths: " + tempProject.getFullPath());
								if (file_uri.toString().contains(tempProject.getFullPath().toString())) {

									System.out.println(
											"Found Project, creating String for assure: " + tempProject.getFullPath()
													+ "/assure/" + selectedAssuranceCase.getName() + ".assure");

									assureDirURI = URI.createPlatformResourceURI(tempProject.getFullPath() + "/assure",
											false);
								}
							}
						}
					}

					// TODO: should send filter

					Resource res = selectedAssuranceCase.getSystem().eResource();
					URI modeluri = res.getURI();
//					String last = modeluri.lastSegment();
//					String filename = last.substring(0, last.indexOf('.'));
					URI path = modeluri.trimSegments(1);
					if (path.lastSegment().equalsIgnoreCase(WorkspacePlugin.AADL_PACKAGES_DIR)) {
						path = path.trimSegments(1);
					}
					URI instanceDirURI = path.appendSegment(WorkspacePlugin.AADL_INSTANCES_DIR);
					System.out.println("  >>>>>>>>>>>>instanceDirURI: " + instanceDirURI.toString());
					System.out.println("  >>>>>>>>>>>>assureDirURI: " + assureDirURI.toString());

					msr = MultiRule.combine(
							ResourcesPlugin.getWorkspace().getRoot()
									.getFolder(new Path(instanceDirURI.toPlatformString(true))),
							ResourcesPlugin.getWorkspace().getRoot()
									.getFolder(new Path(assureDirURI.toPlatformString(true))));

					ah.execute2(assuranceCaseResult, getSelectedCategoryFilter(), msr);

				}

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				if (selectedAssuranceCase != null) {

					AssuranceCaseResult assuranceCaseResult = findCaseResult(selectedAssuranceCase.getName());
					if (assuranceCaseResult == null) {
						// TODO: generate assure file. Until assure file is auto-generated this should not be a problem.
						System.err.println("2AlisaView.createPartControl() matching assure resource not found.");

						assuranceCaseResult = createCaseResult(selectedAssuranceCase.getName());
					} else {
						System.out.println("2  >>>>>>>>>>>>Found assure resource");
						// Just for now to have assureDirURI
						URI uri = null;
						if (selectedAssuranceCase instanceof EObjectNode) {
							uri = ((EObjectNode) selectedAssuranceCase).getEObjectURI();
						} else if (selectedAssuranceCase instanceof EObject) {
							uri = EcoreUtil.getURI((EObject) selectedAssuranceCase);
						}
						URI file_uri = uri;
						IWorkspaceRoot myWorkspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
						for (int i = 0; i < myWorkspaceRoot.getProjects().length; i++) {
							IProject tempProject = myWorkspaceRoot.getProjects()[i];
							if (tempProject.isAccessible()) {
								System.out.println("Project paths: " + tempProject.getFullPath());
								if (file_uri.toString().contains(tempProject.getFullPath().toString())) {

									System.out.println(
											"Found Project, creating String for assure: " + tempProject.getFullPath()
													+ "/assure/" + selectedAssuranceCase.getName() + ".assure");

									assureDirURI = URI.createPlatformResourceURI(tempProject.getFullPath() + "/assure",
											false);
								}
							}
						}
					}

					// assuranceCaseResult does not have filter applied.

//					if (uri != null) {
					AssureHandler ah = new AssureHandler();
					ah.prepare();

					Resource res = selectedAssuranceCase.getSystem().eResource();
					URI modeluri = res.getURI();
//					String last = modeluri.lastSegment();
//					String filename = last.substring(0, last.indexOf('.'));
					URI path = modeluri.trimSegments(1);
					if (path.lastSegment().equalsIgnoreCase(WorkspacePlugin.AADL_PACKAGES_DIR)) {
						path = path.trimSegments(1);
					}
					URI instanceDirURI = path.appendSegment(WorkspacePlugin.AADL_INSTANCES_DIR);
					System.out.println("  >>>>>>>>>>>>instanceDirURI: " + instanceDirURI.toString());
					System.out.println("  >>>>>>>>>>>>assureDirURI: " + assureDirURI.toString());

//					if (instanceDirURI.isPlatform()) {
//						System.out.println("  >>>>>>>>>>>>0000: " + instanceDirURI.toString());
					msr = MultiRule.combine(
							ResourcesPlugin.getWorkspace().getRoot()
									.getFolder(new Path(instanceDirURI.toPlatformString(true))),
							ResourcesPlugin.getWorkspace().getRoot()
									.getFolder(new Path(assureDirURI.toPlatformString(true))));
//					} else if (instanceDirURI.isFile()) {
//						System.out.println("  >>>>>>>>>>>>1111: " + instanceDirURI.toString());
//						msr = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(instanceDirURI.toFileString()));
//					}

					ah.execute2(assuranceCaseResult, getSelectedCategoryFilter(), msr);
//					}

				}

			}
		});

		getSite().getPage().addPartListener(partListener);

		loadAssuranceCases();
	}

	protected AssuranceCaseResult findCaseResult(String name) {
		for (Iterator iterator = rds.getExportedObjectsByType(AssurePackage.Literals.ASSURANCE_CASE_RESULT)
				.iterator(); iterator.hasNext();) {
			IEObjectDescription eod = (IEObjectDescription) iterator.next();
			System.out.println("findCaseResult11111 eod    " + eod.toString());
			System.out.println("findCaseResult22222    " + eod.getEObjectOrProxy());
			System.out.println("findCaseResult33333    " + eod.getEObjectOrProxy().eResource());

			// result.add((AssuranceCase) EcoreUtil.resolve(eod.getEObjectOrProxy(), eod.getEObjectOrProxy().eResource()));
			AssuranceCaseResult temp = (AssuranceCaseResult) EcoreUtil.resolve(eod.getEObjectOrProxy(),
					currentResourceSet);

			if (temp != null && temp.getName().equals(name)) {
				return temp;
			}
		}
		return null;
	}

	protected AssuranceCaseResult createCaseResult(String name) {

		// If not loaded use assurance case to guess uri
		URI uri = null;
		if (selectedAssuranceCase instanceof EObjectNode) {
			System.out.println("createCaseResult selectedAssuranceCase ----");
			uri = ((EObjectNode) selectedAssuranceCase).getEObjectURI();
		} else if (selectedAssuranceCase instanceof EObject) {
			System.out.println("createCaseResult selectedAssuranceCase +++++");
			uri = EcoreUtil.getURI((EObject) selectedAssuranceCase);
		}

		System.out.println("\n\ncreateCaseResult selectedAssuranceCase URI: " + uri.toString());

		// URI file_uri = selectedAssuranceCase.eResource().getURI();

		URI file_uri = uri; // trimFileExtension();
		System.out.println("createCaseResult selectedAssuranceCase file_uri: " + file_uri.toString());

		String file_name = file_uri.toPlatformString(true);
		System.out.println("createCaseResult selectedAssuranceCase file_name: " + file_uri.toString());

		file_name = file_name.replace("/", File.separator);

		String projectPath = Platform.getLocation().toOSString();
		System.out.println("createCaseResult projectPath 111: " + projectPath.toString());

		projectPath = projectPath.replace("/", File.separator);

		projectPath = projectPath + file_name;
		System.out.println("createCaseResult projectPath 222: " + projectPath.toString());

		// String[] pathsplit= projectPath.split(File.separator);

//		projectPath = projectPath.substring(0, projectPath.lastIndexOf(File.separator));
//		System.out.println("createCaseResult projectPath 333: " + projectPath.toString());
		// currentResourceSet.getResource(uri, true);

		AssuranceCaseResult acr = null;

		IWorkspaceRoot myWorkspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
		for (int i = 0; i < myWorkspaceRoot.getProjects().length; i++) {
			IProject tempProject = myWorkspaceRoot.getProjects()[i];
			if (tempProject.isAccessible()) {
				System.out.println("Project paths: " + tempProject.getFullPath());
				if (file_uri.toString().contains(tempProject.getFullPath().toString())) {

					System.out.println("Found Project, creating String for assure: " + tempProject.getFullPath()
							+ "/assure/" + selectedAssuranceCase.getName() + ".assure");

					assureDirURI = URI.createPlatformResourceURI(tempProject.getFullPath() + "/assure", false);

					assureURI = URI.createPlatformResourceURI(
							tempProject.getFullPath() + "/assure/" + selectedAssuranceCase.getName() + ".assure",
							false);

					ResourceSet rs = selectedAssuranceCase.eResource().getResourceSet();
					Resource rrr = rs.getResource(assureURI, false);

					if (rrr == null) {
						System.out.println(">>>>> Creating resource");
						rrr = rs.createResource(assureURI);
					}

					acr = assureConstructor.generateFullAssuranceCase(selectedAssuranceCase);
					AssureUtilExtension.resetToTBD(acr);
					AssureUtilExtension.recomputeAllCounts(acr);

					rrr.getContents().add(acr);

					// Going to save later from the job
//					try {
//						rrr.save(null);
//					} catch (IOException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}

					System.out.println("Resource saved: " + rrr.toString());

					break;
				}
			}
		}

		return acr;
	}

	private void updateFilterCombo(Collection<CategoryFilter> collection) {
		filterNames.clear();
		filterNames.add(FILTER_NONE);
		if (collection != null) {
			for (Iterator iterator = collection.iterator(); iterator.hasNext();) {
				CategoryFilter categoryFilter = (CategoryFilter) iterator.next();

				// In case there exist a filter named None
				if (categoryFilter.getName().equals(FILTER_NONE)) {
					filterNames.add("User defined:" + categoryFilter.getName());
				} else {
					filterNames.add(categoryFilter.getName());
				}
			}
		}

		String selectedOldFilterName = null;
		if (filterCombo.getSelectionIndex() > 0) {
			selectedOldFilterName = filterCombo.getItem(filterCombo.getSelectionIndex());
		}

		filterCombo.setItems(filterNames.toArray(new String[] {}));

		if (filterNames.contains(selectedOldFilterName)) { // Could be None
			filterCombo.select(filterNames.indexOf(selectedOldFilterName));
		} else {
			filterCombo.select(0); // Select None by default
		}
	}

	/**
	 * Return currently selected Category Filter.
	 * 
	 * @return null when no filter is selected
	 */
	public synchronized CategoryFilter getSelectedCategoryFilter() {
		if (treeViewer.getTree().isDisposed()) {
			return null;
		}

		if (filterCombo.getSelectionIndex() == 0) {
			return null;
		} else if (filterCombo.getItem(filterCombo.getSelectionIndex()).contains("User defined:")) {
			// In case there exist a filter named None
			return globalFilterList.get(FILTER_NONE);
		} else {
			return globalFilterList.get(filterCombo.getItem(filterCombo.getSelectionIndex()));
		}

	}

	@Inject
	IAlisaGlobalReferenceFinder refFinder;

	@Inject
	protected IResourceDescriptions rds;

	private synchronized void loadAssuranceCases() {
		// getSite().getWorkbenchWindow().getActivePage().getActivePart();
		// activeEditor as XtextEditor

		if (EditorUtils.getActiveXtextEditor() == null) {
			// leave it as is
			return;
		}

		xtextDoc = EditorUtils.getActiveXtextEditor().getDocument();

//		ArrayList<AssuranceCase> result = new ArrayList<AssuranceCase>();

//		result.addAll((Collection<? extends AssuranceCase>) refFinder.getAssuranceCases(null));
		if (loadAssuranceCaseJob == null) { // to make sure loading job is at max only once scheduled
			loadAssuranceCaseJob = new WorkspaceJob("Alisa View") {
				@Override
				public IStatus runInWorkspace(final IProgressMonitor monitor) {
					return xtextDoc.readOnly(new IUnitOfWork<IStatus, XtextResource>() {
						@Override
						public IStatus exec(XtextResource resource) throws Exception {
							currentResourceSet = resource.getResourceSet();
							loadAssuranceCaseResult.clear();

							for (Iterator iterator = rds.getExportedObjectsByType(AlisaPackage.Literals.ASSURANCE_CASE)
									.iterator(); iterator.hasNext();) {
								IEObjectDescription eod = (IEObjectDescription) iterator.next();

								// result.add((AssuranceCase) EcoreUtil.resolve(eod.getEObjectOrProxy(), eod.getEObjectOrProxy().eResource()));
								loadAssuranceCaseResult.add(
										(AssuranceCase) EcoreUtil.resolve(eod.getEObjectOrProxy(), currentResourceSet));

							}
//							System.out.println("AlisaView.loadAssuranceCases()   loadAssuranceCaseResult size: "
//									+ loadAssuranceCaseResult.size());
							globalFilterList.clear();

							for (Iterator iterator = rds
									.getExportedObjectsByType(CategoriesPackage.Literals.CATEGORY_FILTER)
									.iterator(); iterator.hasNext();) {
								IEObjectDescription eod = (IEObjectDescription) iterator.next();

								// result.add((AssuranceCase) EcoreUtil.resolve(eod.getEObjectOrProxy(), eod.getEObjectOrProxy().eResource()));
								CategoryFilter cf = (CategoryFilter) EcoreUtil.resolve(eod.getEObjectOrProxy(),
										currentResourceSet);
								globalFilterList.put(cf.getName(), cf);

							}

							Display.getDefault().asyncExec(new Runnable() {
								@Override
								public void run() {
									if (treeViewer.getTree().isDisposed()) {
										return;
									}
									treeViewer.setInput(loadAssuranceCaseResult);

									updateFilterCombo(globalFilterList.values());

								}
							});

							return Status.OK_STATUS;
						}
					});
				}
			};
		}

		// If an analysis is going on, msr will make it wait for the analysis job to finish.
//		loadAssuranceCaseJob.setRule(msr);
		loadAssuranceCaseJob.schedule();
//		try {
//			loadAssuranceCaseJob.join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

//		if (treeViewer.getTree().isDisposed()) {
//			return;
//		}
//
//		treeViewer.setInput(loadAssuranceCaseResult);

//		updateFilterCombo(globalFilterList.values());
		// Watch out for synchronized if we fire to other views to load filter

	}

	public void dispose() {
		// xtextDoc.removeModelListener(modelListener);
		// getSite().getPage().removePartListener(partListener);
	}

	private IAction createHyperlinkAction(String text, final EObject eObject) {
		return new Action(text) {
			@Override
			public void run() {
				globalURIEditorOpener.open(EcoreUtil.getURI(eObject), true);
			}
		};
	}

//	private IAction createToggleShowClaimResultsAction() {
//
//		IAction result = new Action("Show Claim Results", IAction.AS_CHECK_BOX) {
//			public void run() {
//				if (isChecked()) {
//					setToolTipText(HIDE_CLAIMRESULTS_TOOL_TIP);
//					treeViewer.removeFilter(noClaimsResultFilter);
//				} else {
//					setToolTipText(SHOW_CLAIMRESULTS_TOOL_TIP);
//					treeViewer.addFilter(noClaimsResultFilter);
//				}
//				treeViewer.refresh();
//			}
//		};
//		result.setChecked(true);
//		result.setImageDescriptor(ImageDescriptor.createFromFile(AlisaView.class, "/icons/claims.png"));
//		return result;
//	}

//	public void setProofs(AssuranceCaseResult proofTrees) {
//		if (xtextDoc != null) {
//			xtextDoc.removeModelListener(modelListener);
//		}
//		xtextDoc = EditorUtils.getActiveXtextEditor().getDocument();
//		xtextDoc.addModelListener(modelListener);
////		Object[] expandedElements = treeViewer.getExpandedElements();
////		TreePath[] expandedTreePaths = treeViewer.getExpandedTreePaths();
//		if (proofTrees != null) {
//			inputURI = EcoreUtil.getURI(proofTrees);
//			// treeViewer.setInput(Arrays.asList(proofTrees));
//			treeViewer.setInput(proofTrees);
//		} else {
//			inputURI = null;
//			// treeViewer.setInput(Collections.emptyList());
//			treeViewer.setInput(null);
//		}
////		treeViewer.setExpandedElements(expandedElements);
////		treeViewer.setExpandedTreePaths(expandedTreePaths);
//	}

	@Override
	public void setFocus() {
		treeViewer.getControl().setFocus();
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

	public TreeViewer getTreeViewer() {
		return treeViewer;
	}

}
