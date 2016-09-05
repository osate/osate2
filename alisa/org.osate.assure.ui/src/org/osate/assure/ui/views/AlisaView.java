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

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.core.runtime.jobs.MultiRule;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalCommandStack;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
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
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.GlobalURIEditorOpener;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode;
import org.eclipse.xtext.ui.editor.utils.EditorUtils;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.osate.alisa.workbench.alisa.AlisaPackage;
import org.osate.alisa.workbench.alisa.AssuranceCase;
import org.osate.alisa.workbench.util.IAlisaGlobalReferenceFinder;
import org.osate.assure.assure.AssuranceCaseResult;
import org.osate.assure.assure.AssurePackage;
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
	private AlisaTreeViewer treeViewer;

	private ResourceSet currentResourceSet;
	private ArrayList<String> filterNames = new ArrayList<String>();
	private Combo filterCombo;
	private Button verifyAllButton;

	private AssuranceCase selectedAssuranceCase;

	public AssuranceCase getSelectedAssuranceCase() {
		return selectedAssuranceCase;
	}

	private URI assureURI; // assureDirURI,
	private IProject assureProject;
	private Map<String, CategoryFilter> globalFilterList = Collections
			.synchronizedMap(new HashMap<String, CategoryFilter>());
//	private NoClaimResultsFilter noClaimsResultFilter = new NoClaimResultsFilter();

	private ISchedulingRule msr;
	private WorkspaceJob loadAssuranceCaseJob;
	private ArrayList<AssuranceCase> existingAssuranceCases = new ArrayList<AssuranceCase>();

	IXtextDocument xtextDoc;

	// This probably for when a save occurs to update the view. May need it or not.
//	IXtextModelListener modelListener = new IXtextModelListener() {
//
//		@Override
//		public void modelChanged(XtextResource resource) {
//				System.out.println("model changed: " + resource);
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
//					loadAssuranceCases();
//					}
//
//				}
//			});
//		}
//	};

	@Inject
	GlobalURIEditorOpener globalURIEditorOpener;

	@Inject
	IAssureConstructor assureConstructor;

//	@Inject
//	ILabelProvider labelProvider;
	URI inputURI;

	// To have tree in AlisaView refreshed whenever any editor is pressed
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

		parent.setLayout(new GridLayout(2, false));

		treeViewer = new AlisaTreeViewer(parent,
				SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.VIRTUAL | SWT.SINGLE);
		treeViewer.getTree().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		treeViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				if (event.getSelection().isEmpty()) {
					System.out.println(
							"selectedAssuranceCase: null. This happens if same name for AssuranceCase is not found in a tree reload.");

					selectedAssuranceCase = null;
					verifyAllButton.setEnabled(false);
					verifyAllButton.setText(BUTTON_WAITING);
					verifyAllButton.redraw();
					return;
				}
				if (event.getSelection() instanceof IStructuredSelection) {
					IStructuredSelection selection = (IStructuredSelection) event.getSelection();
					if (selection.getFirstElement() instanceof AssuranceCase) {
						selectedAssuranceCase = (AssuranceCase) selection.getFirstElement();
						System.out.println("selectedAssuranceCase: " + selectedAssuranceCase.getName());
						verifyAllButton.setEnabled(true);
						verifyAllButton.setText(BUTTON_READY);
						verifyAllButton.redraw();

					} else {
						System.out.println("selectedAssuranceCase: null. Please select parent AssuranceCase in Tree");
						selectedAssuranceCase = null;
						verifyAllButton.setEnabled(false);
						verifyAllButton.setText(BUTTON_WAITING);
						verifyAllButton.redraw();
					}
				}

			}
		});

		getSite().setSelectionProvider(treeViewer);
		AssureTooltipListener.createAndRegister(treeViewer);
//	        getSite().getPage().addSelectionListener("org.osate.assure.Assure",listener);

		// Not sure we need this. Maybe for future when we need right clickmenus
		MenuManager manager = new MenuManager();
		manager.setRemoveAllWhenShown(true);

		manager.addMenuListener(new IMenuListener() {
			@Override
			public void menuAboutToShow(IMenuManager manager) {
				IStructuredSelection selection = (IStructuredSelection) treeViewer.getSelection();
				if (!selection.isEmpty()) {
//					final AssureResult ar = (AssureResult) selection.getFirstElement();
//
//					if (ar instanceof ClaimResult) {
//						final ClaimResult claim = (ClaimResult) ar;
//						EObject location = AssureUtilExtension.getTarget(claim);
//	                    if (claim instanceof FailResult) {
//	                        manager.add(createHyperlinkAction("Open Failure Location", location));
//	                    } else if (location instanceof ProveStatement) { 
//	                        manager.add(createHyperlinkAction("Open Prove Statement", location));
//	                        manager.add(createExportSubmenu(claim));
//	                    } else {
//						manager.add(createHyperlinkAction("Open Requirement", location));
//	                    }
//	                    Map<String, EObject> references = claim.getReferences();
//	                    for (String name : new TreeSet<String>(references.keySet())) {
//	                        manager.add(createHyperlinkAction("Go to '" + name + "'",
//	                                references.get(name)));
//	                    }
//
//						manager.add(new Action("Copy Claim Text") {
//							@Override
//							public void run() {
//								Transferable text = new StringSelection(
//										AssureUtilExtension.constructDescription(claim));
//								Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
//								clipboard.setContents(text, null);
//							}
//						});
//					}
				}
//
//				manager.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
//				IMenuService menuService = getViewSite().getWorkbenchWindow().getService(IMenuService.class);
//				menuService.populateContributionManager((ContributionManager) manager, "popup:" + ID);
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

		verifyAllButton = new Button(rightSide, SWT.CENTER | SWT.WRAP);
		verifyAllButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		verifyAllButton.setText(BUTTON_WAITING);
		verifyAllButton.setEnabled(false);

		verifyAllButton.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				verifyAllButtonSelected();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				verifyAllButtonSelected();
			}
		});

		treeViewer.setInput(existingAssuranceCases);

		getSite().getPage().addPartListener(partListener);

		loadAssuranceCases();

	}

	private void verifyAllButtonSelected() {
		if (selectedAssuranceCase != null) {

			AssureHandler ah = new AssureHandler();

			ah.prepare();

			// Doesn't seem to always find it.
			AssuranceCaseResult assuranceCaseResult = null;// recreate it. findCaseResult(selectedAssuranceCase.getName());
			if (assuranceCaseResult == null) {

				try {
					assuranceCaseResult = createCaseResult(selectedAssuranceCase.getName());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
//			} else {
//				System.out.println("  >>>>>>>>>>>>Found existing assure resource");
//
//				// Need assureDirURI to be set at least. Same is done in createCaseResult
//
//				URI uri = null;
//				if (selectedAssuranceCase instanceof EObjectNode) {
//					uri = ((EObjectNode) selectedAssuranceCase).getEObjectURI();
//				} else if (selectedAssuranceCase instanceof EObject) {
//					uri = EcoreUtil.getURI((EObject) selectedAssuranceCase);
//				}
//
//				// IF something changes here, likely it should be applied to createCaseResult as well
//				URI file_uri = uri;
//				String projectNameFromURI = "/" + file_uri.segment(1);
//
//				System.out.println("projectNameFromURI   " + projectNameFromURI);
//				IWorkspaceRoot myWorkspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
//				for (int i = 0; i < myWorkspaceRoot.getProjects().length; i++) {
//					IProject tempProject = myWorkspaceRoot.getProjects()[i];
//					if (tempProject.isAccessible()) {
//						System.out.println("Checking Project paths: " + tempProject.getFullPath());
//						if (projectNameFromURI.equals(tempProject.getFullPath().toString())) {
//
//							System.out.println("Found Project, creating String for assure: " + tempProject.getFullPath()
//									+ "/assure/" + selectedAssuranceCase.getName() + ".assure");
//							assureProject = tempProject;
//
//							// Should not include assure subdirectory because in some cases assure directory does not preexist
//							// Eventually, need rule to have the whole project
//							// assureDirURI = URI.createPlatformResourceURI(tempProject.getFullPath() + "/assure", false);
////							assureDirURI = URI.createPlatformResourceURI(assureProject.getFullPath().toString(), false);
//							break;
//						}
//					}
//				}
			}

			Resource res = selectedAssuranceCase.getSystem().eResource();
			URI modeluri = res.getURI();
//			String last = modeluri.lastSegment();
//			String filename = last.substring(0, last.indexOf('.'));
			URI path = modeluri.trimSegments(1);
			if (path.lastSegment().equalsIgnoreCase(WorkspacePlugin.AADL_PACKAGES_DIR)) {
				path = path.trimSegments(1);
			}
//			URI instanceDirURI = path.appendSegment(WorkspacePlugin.AADL_INSTANCES_DIR);
//			System.out.println("  MultiRule>>>>>No longer used>>>>>>>instanceDirURI: " + instanceDirURI.toString());
//			System.out.println("  MultiRule>>>>>>>>>>>>assureDirURI: " + assureDirURI.toString());

			// Intersection of instance directory and assure directory
//			msr = MultiRule.combine(
//					ResourcesPlugin.getWorkspace().getRoot().getFolder(new Path(instanceDirURI.toPlatformString(true))),
//					ResourcesPlugin.getWorkspace().getRoot().getFolder(new Path(assureDirURI.toPlatformString(true))));

			// Only the assure directory
//			msr = new MultiRule(new ISchedulingRule[] { ResourcesPlugin.getWorkspace().getRoot()
//					.getFolder(new Path(assureDirURI.toPlatformString(true))) });

			// Only the assure project
//			msr = new MultiRule(new ISchedulingRule[] { assureProject });

			IProject aadlProject = null;
			String projectNameFromAADL = "/" + path.segment(1);
			IWorkspaceRoot myWorkspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
			for (int i = 0; i < myWorkspaceRoot.getProjects().length; i++) {
				IProject tempProject = myWorkspaceRoot.getProjects()[i];
				if (tempProject.isAccessible()) {
					System.out.println("Checking Project paths AADL: " + tempProject.getFullPath());
					if (projectNameFromAADL.equals(tempProject.getFullPath().toString())) {

						System.out.println("Found AADL Project: " + tempProject.getFullPath().toString());
						aadlProject = tempProject;
						break;
					}
				}
			}

			// Using combination of assureProject and aadlProject. Has to be project because if subdirectories
			// such as instances or assure may be created.
			msr = new MultiRule(new ISchedulingRule[] { assureProject, aadlProject });
			ah.execute2(assuranceCaseResult, getSelectedCategoryFilter(), msr);

		}
	}

	/**
	 * Finds assure file based on name of assurance case from alisa file.
	 * 
	 * @param name
	 * @return
	 */
	public AssuranceCaseResult findCaseResult(String name) {
		for (Iterator iterator = rds.getExportedObjectsByType(AssurePackage.Literals.ASSURANCE_CASE_RESULT)
				.iterator(); iterator.hasNext();) {
			IEObjectDescription eod = (IEObjectDescription) iterator.next();
			System.out.println("findCaseResult11111 eod    " + eod.toString());
			System.out.println("findCaseResult22222    " + eod.getEObjectOrProxy());
			System.out.println("findCaseResult33333    " + eod.getEObjectOrProxy().eResource());

			// result.add((AssuranceCase) EcoreUtil.resolve(eod.getEObjectOrProxy(), eod.getEObjectOrProxy().eResource()));
			AssuranceCaseResult temp = (AssuranceCaseResult) EcoreUtil.resolve(eod.getEObjectOrProxy(),
					currentResourceSet);

			// Can a AssuranceCaseResult exist without a name? Getting nulls for temp.getName()
			// Probably if there is a empty assure file in the workspace.
			if (temp != null && temp.getName() != null && temp.getName().equals(name)) {
				return temp;
			}
		}
		return null;
	}

	protected AssuranceCaseResult createCaseResult(String name) throws Exception {

		// If not loaded use assurance case to guess uri
		URI uri = null;
		if (selectedAssuranceCase instanceof EObjectNode) {
			uri = ((EObjectNode) selectedAssuranceCase).getEObjectURI();
		} else if (selectedAssuranceCase instanceof EObject) {
			uri = EcoreUtil.getURI((EObject) selectedAssuranceCase);
		}

		// URI file_uri = selectedAssuranceCase.eResource().getURI();
		URI file_uri = uri; // trimFileExtension();
		System.out.println("\ncreateCaseResult selectedAssuranceCase file_uri: " + file_uri.toString());

		List<AssuranceCaseResult> resultList = null;
		IWorkspaceRoot myWorkspaceRoot = ResourcesPlugin.getWorkspace().getRoot();

		String projectNameFromURI = "/" + file_uri.segment(1);
		System.out.println("projectNameFromURI   " + projectNameFromURI);

		for (int i = 0; i < myWorkspaceRoot.getProjects().length; i++) {
			IProject tempProject = myWorkspaceRoot.getProjects()[i];
			if (tempProject.isAccessible()) {
				System.out.println("Checking Project paths: " + tempProject.getFullPath());
				if (projectNameFromURI.equals(tempProject.getFullPath().toString())) {

					System.out.println("Found Project that holds selected alisa file, creating String for assure file: "
							+ tempProject.getFullPath() + "/assure/" + selectedAssuranceCase.getName() + ".assure");

					assureProject = tempProject;

					// Should not include assure subdirectory because in some cases assure directory does not preexist
					// Eventually, need rule to have the whole project
					// assureDirURI = URI.createPlatformResourceURI(tempProject.getFullPath() + "/assure", false);
//					assureDirURI = URI.createPlatformResourceURI(assureProject.getFullPath().toString(), false);

					assureURI = URI.createPlatformResourceURI(
							assureProject.getFullPath() + "/assure/" + selectedAssuranceCase.getName() + ".assure",
							false);

					ResourceSet rs = selectedAssuranceCase.eResource().getResourceSet();
					Resource rrr = rs.getResource(assureURI, false);

					/////////////////////////// Using same domain as in InstatiateModel
					final TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
							.getEditingDomain("org.osate.aadl2.ModelEditingDomain");
					// We execute this command on the command stack because otherwise, we will not
					// have write permissions on the editing domain.
					Command cmd = new RecordingCommand(domain) {
						public Resource temprrr;
						public AssuranceCaseResult acr;

						@Override
						protected void doExecute() {
							if (rrr == null) {
								System.out.println(
										">>>>> Creating resource since assure file doesn't exist in resource set.");
								temprrr = rs.createResource(assureURI);
							} else {
								temprrr = rrr;
								temprrr.getContents().clear();
							}
							acr = assureConstructor.generateFullAssuranceCase(selectedAssuranceCase);
							// When initially creating the assure file, we use no filter to reset.
							AssureUtilExtension.resetToTBD(acr, null);
							AssureUtilExtension.recomputeAllCounts(acr, null);

							temprrr.getContents().add(acr);
							try {
								temprrr.save(null);
								System.out.println(
										"Assure Resource added to Resource Set and saved " + temprrr.toString());
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}

						@Override
						public List<AssuranceCaseResult> getResult() {
							return Collections.singletonList(acr);
						}
					};

					((TransactionalCommandStack) domain.getCommandStack()).execute(cmd, null);
					// This waits for the completion.
					resultList = (List<AssuranceCaseResult>) cmd.getResult();

					break;
				}
			}
		}

		if (resultList != null && resultList.size() > 0) {
			return resultList.get(0);
		} else {
			return null;
		}
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

		// Need an editor to be opened to get resource set
		if (EditorUtils.getActiveXtextEditor() == null) {
			// leave it as is
			return;
		}
		xtextDoc = EditorUtils.getActiveXtextEditor().getDocument();

		if (loadAssuranceCaseJob == null) { // to make sure loading job is at max only once scheduled, we use a single instance
			loadAssuranceCaseJob = new WorkspaceJob("Alisa View") {
				@Override
				public IStatus runInWorkspace(final IProgressMonitor monitor) {
					return xtextDoc.readOnly(new IUnitOfWork<IStatus, XtextResource>() {
						@Override
						public IStatus exec(XtextResource resource) throws Exception {
							currentResourceSet = resource.getResourceSet();
							// System.out.println("Updating currentResourceSet");

							existingAssuranceCases.clear();
							for (Iterator iterator = rds.getExportedObjectsByType(AlisaPackage.Literals.ASSURANCE_CASE)
									.iterator(); iterator.hasNext();) {
								IEObjectDescription eod = (IEObjectDescription) iterator.next();

								// result.add((AssuranceCase) EcoreUtil.resolve(eod.getEObjectOrProxy(), eod.getEObjectOrProxy().eResource()));
								existingAssuranceCases.add(
										(AssuranceCase) EcoreUtil.resolve(eod.getEObjectOrProxy(), currentResourceSet));

							}

							// If there is an existing selection
							// Find the alisa with the same name if there is a selection
							if (selectedAssuranceCase != null) {
								AssuranceCase tempAssuranceCase = selectedAssuranceCase;
								selectedAssuranceCase = null;
								for (Iterator iterator = existingAssuranceCases.iterator(); iterator.hasNext();) {
									AssuranceCase assuranceCase = (AssuranceCase) iterator.next();
									if (assuranceCase.getName().equals(tempAssuranceCase.getName())) {
										selectedAssuranceCase = assuranceCase;
										break;
									}
								}
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

									if (selectedAssuranceCase != null) {
										StructuredSelection selection = new StructuredSelection(selectedAssuranceCase);
										treeViewer.setSelection(selection, true);
										// treeViewer.refresh();
										// treeViewer.reveal(selectedAssuranceCase);
										// treeViewer.ssshow(selectedAssuranceCase);

									}

									treeViewer.refresh(true);

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

	}

	public void dispose() {
		// xtextDoc.removeModelListener(modelListener);
		// getSite().getPage().removePartListener(partListener);
	}

	@Override
	public void setFocus() {
		treeViewer.getControl().setFocus();
	}

//	public TreeViewer getTreeViewer() {
//		return treeViewer;
//	}

}
