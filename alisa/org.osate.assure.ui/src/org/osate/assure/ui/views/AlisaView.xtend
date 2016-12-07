package org.osate.assure.ui.views

import com.google.inject.Inject
import java.awt.Toolkit
import java.awt.datatransfer.StringSelection
import java.io.IOException
import java.util.List
import java.util.Optional
import java.util.concurrent.atomic.AtomicBoolean
import java.util.concurrent.atomic.AtomicReference
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.IResourceChangeEvent
import org.eclipse.core.resources.IResourceChangeListener
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.core.resources.WorkspaceJob
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.core.runtime.Path
import org.eclipse.core.runtime.Status
import org.eclipse.core.runtime.jobs.MultiRule
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.transaction.RecordingCommand
import org.eclipse.emf.transaction.TransactionalEditingDomain
import org.eclipse.jface.action.Action
import org.eclipse.jface.action.MenuManager
import org.eclipse.jface.dialogs.DialogSettings
import org.eclipse.jface.dialogs.IDialogSettings
import org.eclipse.jface.dialogs.MessageDialog
import org.eclipse.jface.layout.TreeColumnLayout
import org.eclipse.jface.resource.ImageDescriptor
import org.eclipse.jface.viewers.ArrayContentProvider
import org.eclipse.jface.viewers.ColumnLabelProvider
import org.eclipse.jface.viewers.ColumnPixelData
import org.eclipse.jface.viewers.ColumnViewerToolTipSupport
import org.eclipse.jface.viewers.ColumnWeightData
import org.eclipse.jface.viewers.ComboBoxViewerCellEditor
import org.eclipse.jface.viewers.EditingSupport
import org.eclipse.jface.viewers.ITreeContentProvider
import org.eclipse.jface.viewers.LabelProvider
import org.eclipse.jface.viewers.TreeViewer
import org.eclipse.jface.viewers.TreeViewerColumn
import org.eclipse.jface.viewers.Viewer
import org.eclipse.swt.SWT
import org.eclipse.swt.custom.SashForm
import org.eclipse.swt.graphics.Color
import org.eclipse.swt.widgets.Composite
import org.eclipse.ui.part.ViewPart
import org.eclipse.xtext.resource.IResourceDescriptions
import org.eclipse.xtext.ui.editor.GlobalURIEditorOpener
import org.eclipse.xtext.ui.resource.IResourceSetProvider
import org.osate.aadl2.util.Activator
import org.osate.alisa.common.common.ResultIssue
import org.osate.alisa.workbench.alisa.AlisaPackage
import org.osate.alisa.workbench.alisa.AssuranceCase
import org.osate.alisa.workbench.alisa.AssurancePlan
import org.osate.assure.assure.AssuranceCaseResult
import org.osate.assure.assure.AssurePackage
import org.osate.assure.assure.AssureResult
import org.osate.assure.assure.ClaimResult
import org.osate.assure.assure.ElseResult
import org.osate.assure.assure.Metrics
import org.osate.assure.assure.ModelResult
import org.osate.assure.assure.PreconditionResult
import org.osate.assure.assure.PredicateResult
import org.osate.assure.assure.QualifiedClaimReference
import org.osate.assure.assure.QualifiedVAReference
import org.osate.assure.assure.SubsystemResult
import org.osate.assure.assure.ThenResult
import org.osate.assure.assure.ValidationResult
import org.osate.assure.assure.VerificationActivityResult
import org.osate.assure.evaluator.IAssureProcessor
import org.osate.assure.generator.IAssureConstructor
import org.osate.assure.ui.labeling.AssureColorBlockCountHolder
import org.osate.assure.util.AssureUtilExtension
import org.osate.categories.categories.CategoriesPackage
import org.osate.categories.categories.CategoryFilter
import org.osate.verify.util.VerifyUtilExtension

import static extension org.eclipse.emf.ecore.util.EcoreUtil.getURI
import static extension org.osate.assure.util.AssureUtilExtension.assureResultCounts
import static extension org.osate.assure.util.AssureUtilExtension.constructDescription
import static extension org.osate.assure.util.AssureUtilExtension.constructLabel
import static extension org.osate.assure.util.AssureUtilExtension.constructMessage
import static extension org.osate.assure.util.AssureUtilExtension.getName
import static extension org.osate.assure.util.AssureUtilExtension.getTarget
import static extension org.osate.assure.util.AssureUtilExtension.isErrorTimeOut
import static extension org.osate.assure.util.AssureUtilExtension.isFail
import static extension org.osate.assure.util.AssureUtilExtension.isSuccessful
import static extension org.osate.assure.util.AssureUtilExtension.isZeroCount
import static extension org.osate.assure.util.AssureUtilExtension.isZeroTotalCount
import static extension org.osate.assure.util.AssureUtilExtension.recomputeAllCounts
import static extension org.osate.assure.util.AssureUtilExtension.resetToTBD
import static extension org.osate.assure.util.AssureUtilExtension.toTextLabel

class AlisaView extends ViewPart {
	val static ASSURANCE_CASE_URIS_KEY = "ASSURANCE_CASE_URIS_KEY"
	val static FILTER_URIS_KEY = "FILTER_URIS_KEY"
	val static ALISA_EXTENSION = "alisa"
	val static ASSURE_EXTENSION = "assure"
	
	val IResourceSetProvider resourceSetProvider
	val ResourceSet resourceSetForUI
	val IResourceDescriptions rds
	val GlobalURIEditorOpener editorOpener
	val IAssureConstructor assureConstructor
	val IAssureProcessor assureProcessor
	val String settingsFileName
	val IDialogSettings dialogSettings
	
	//Map is from AssuranceCase to CategoryFilter
	val selectedFilters = <URI, URI>newHashMap
	Pair<URI, URI> displayedCaseAndFilter = null -> null
	
	TreeViewer alisaViewer
	TreeViewer assureViewer
	
	Color greenColor
	Color yellowColor
	Color orangeColor
	Color blueColor
	Color redColor
	
	val IResourceChangeListener resourceChangeListener = [
		val alisaFileChanged = new AtomicBoolean(false)
		val assureFileChanged = new AtomicBoolean(false)
		delta.accept[
			if (resource.fileExtension == ALISA_EXTENSION) {
				alisaFileChanged.set(true)
			} else if (resource.fileExtension == ASSURE_EXTENSION) {
				assureFileChanged.set(true)
			}
			true
		]
		resourceSetForUI.resources.forEach[unload]
		if (alisaFileChanged.get) {
			viewSite.workbenchWindow.workbench.display.asyncExec[
				val toRemove = selectedFilters.filter[assuranceCase, filter |
					resourceSetForUI.getEObject(assuranceCase, true) == null || resourceSetForUI.getEObject(filter, true) == null
				].keySet
				toRemove.forEach[selectedFilters.remove(it)]
				
				val expandedElements = alisaViewer.expandedElements
				alisaViewer.input = assuranceCaseURIsInWorkspace
				alisaViewer.expandedElements = expandedElements
				
				displayedCaseAndFilter = null -> null
				updateAssureViewer(alisaViewer.structuredSelection.firstElement as URI, true)
			]
		} else if (assureFileChanged.get) {
			viewSite.workbenchWindow.workbench.display.asyncExec[
				displayedCaseAndFilter = null -> null
				updateAssureViewer(alisaViewer.structuredSelection.firstElement as URI, false)
			]
		}
	]
	
	@Inject
	new(IResourceSetProvider resourceSetProvider, IResourceDescriptions rds, GlobalURIEditorOpener editorOpener, IAssureConstructor assureConstructor, IAssureProcessor assureProcessor) {
		this.resourceSetProvider = resourceSetProvider
		resourceSetForUI = resourceSetProvider.get(null)
		this.rds = rds
		this.editorOpener = editorOpener
		this.assureConstructor = assureConstructor
		this.assureProcessor = assureProcessor
		val pluginsDir = Activator.^default.stateLocation.removeLastSegments(1)
		settingsFileName = pluginsDir.append("org.osate.assure.ui").append("alisa_view_settings.xml").toOSString
		dialogSettings = new DialogSettings("alisa_view_settings")
		try {
			dialogSettings.load(settingsFileName)
			val assuranceCaseURIs = dialogSettings.getArray(ASSURANCE_CASE_URIS_KEY)
			val filterURIs = dialogSettings.getArray(FILTER_URIS_KEY)
			if (assuranceCaseURIs != null && filterURIs != null && assuranceCaseURIs.size == filterURIs.size) {
				for (var i = 0; i < filterURIs.size; i++) {
					val assuranceCaseURI = URI.createURI(assuranceCaseURIs.get(i))
					val filterURI = URI.createURI(filterURIs.get(i))
					if (resourceSetForUI.getEObject(assuranceCaseURI, true) != null && resourceSetForUI.getEObject(filterURI, true) != null) {
						selectedFilters.put(assuranceCaseURI, filterURI)
					}
				}
			}
		} catch (IOException e) {
			//Ignore exception
		}
	}
	
	override createPartControl(Composite parent) {
		greenColor = new Color(viewSite.workbenchWindow.workbench.display, 171, 221, 164)
		yellowColor = new Color(viewSite.workbenchWindow.workbench.display, 255, 255, 191)
		orangeColor = new Color(viewSite.workbenchWindow.workbench.display, 253, 174, 97)
		blueColor = new Color(viewSite.workbenchWindow.workbench.display, 43, 131, 186)
		redColor = new Color(viewSite.workbenchWindow.workbench.display, 215, 25, 28)
		
		new SashForm(parent, SWT.HORIZONTAL) => [
			new Composite(it, SWT.NONE) => [
				val columnLayout = new TreeColumnLayout
				layout = columnLayout
				alisaViewer = createAlisaViewer(it, columnLayout)
			]
			new Composite(it, SWT.NONE) => [
				val columnLayout = new TreeColumnLayout
				layout = columnLayout
				assureViewer = createAssureViewer(it, columnLayout)
			]
			weights = #[1, 3]
		]
		
		ResourcesPlugin.workspace.addResourceChangeListener(resourceChangeListener, IResourceChangeEvent.POST_CHANGE)
	}
	
	override setFocus() {
		alisaViewer.tree.setFocus
	}
	
	override dispose() {
		ResourcesPlugin.workspace.removeResourceChangeListener(resourceChangeListener)
		
		val caseURIs = selectedFilters.keySet.toList
		val filterURIs = caseURIs.map[selectedFilters.get(it)]
		dialogSettings.put(ASSURANCE_CASE_URIS_KEY, caseURIs.map[toString])
		dialogSettings.put(FILTER_URIS_KEY, filterURIs.map[toString])
		dialogSettings.save(settingsFileName)
		
		greenColor.dispose
		yellowColor.dispose
		orangeColor.dispose
		blueColor.dispose
		redColor.dispose
		
		super.dispose
	}
	
	def private createAlisaViewer(Composite parent, TreeColumnLayout columnLayout) {
		new TreeViewer(parent, SWT.BORDER.bitwiseOr(SWT.H_SCROLL).bitwiseOr(SWT.V_SCROLL).bitwiseOr(SWT.SINGLE)) => [treeViewer |
			treeViewer.tree.headerVisible = true
			treeViewer.contentProvider = new ITreeContentProvider {
				override dispose() {
				}
				
				override getChildren(Object parentElement) {
					switch parentEObject : resourceSetForUI.getEObject(parentElement as URI, true) {
						AssuranceCase: parentEObject.assurancePlans.map[URI]
						default: #[]
					}
				}
				
				override getElements(Object inputElement) {
					inputElement as List<URI>
				}
				
				override getParent(Object element) {
					switch elementEObject : resourceSetForUI.getEObject(element as URI, true) {
						AssuranceCase: treeViewer.input
						AssurancePlan: elementEObject.eContainer.URI
					}
				}
				
				override hasChildren(Object element) {
					switch elementEObject : resourceSetForUI.getEObject(element as URI, true) {
						AssuranceCase: !elementEObject.assurancePlans.empty
						default: false
					}
				}
				
				override inputChanged(Viewer viewer, Object oldInput, Object newInput) {
				}
			}
			new TreeViewerColumn(treeViewer, SWT.LEFT) => [
				columnLayout.setColumnData(column, new ColumnWeightData(1))
				column.text = "Assurance Cases and Plans"
				labelProvider = new ColumnLabelProvider {
					override getText(Object element) {
						switch eObject : resourceSetForUI.getEObject(element as URI, true) {
							AssuranceCase: eObject.name
							AssurancePlan: eObject.name
						}
					}
				}
			]
			new TreeViewerColumn(treeViewer, SWT.LEFT) => [
				columnLayout.setColumnData(column, new ColumnWeightData(1))
				column.text = "Filter"
				labelProvider = new ColumnLabelProvider {
					override getText(Object element) {
						val eObject = resourceSetForUI.getEObject(element as URI, true)
						if (eObject instanceof AssuranceCase) {
							val filter = selectedFilters.get(element)
							if (filter != null) {
								(resourceSetForUI.getEObject(filter, true) as CategoryFilter).name 
							}
						}
					}
				}
				editingSupport = new EditingSupport(treeViewer) {
					override protected canEdit(Object element) {
						resourceSetForUI.getEObject(element as URI, true) instanceof AssuranceCase
					}
					
					override protected getCellEditor(Object element) {
						new ComboBoxViewerCellEditor(treeViewer.tree, SWT.READ_ONLY) => [
							contentProvider = ArrayContentProvider.instance
							labelProvider = new LabelProvider {
								override getText(Object element) {
									val filterURI = element as Optional<URI>
									if (filterURI.present) {
										(resourceSetForUI.getEObject(filterURI.get, true) as CategoryFilter).name
									}
								}
							}
							input = (#[Optional.empty] + rds.getExportedObjectsByType(CategoriesPackage.Literals.CATEGORY_FILTER).map[Optional.of(EObjectURI)]).toList
						]
					}
					
					override protected getValue(Object element) {
						Optional.ofNullable(selectedFilters.get(element))
					}
					
					override protected setValue(Object element, Object value) {
						val assuranceCase = element as URI
						val filter = value as Optional<URI>
						if (filter.present) {
							selectedFilters.put(assuranceCase, filter.get)
						} else {
							selectedFilters.remove(assuranceCase)
						}
						treeViewer.update(assuranceCase, null)
						updateAssureViewer(assuranceCase, true)
					}
				}
			]
			treeViewer.addSelectionChangedListener[updateAssureViewer(treeViewer.structuredSelection.firstElement as URI, true)]
			
			val manager = new MenuManager
			manager.removeAllWhenShown = true
			manager.addMenuListener[
				val uri = treeViewer.structuredSelection.firstElement as URI
				if (uri != null) {
					val eObject = resourceSetForUI.getEObject(uri, true)
					if (eObject instanceof AssuranceCase) {
						add(new Action("Verify All") {
							override run() {
								verifyAll(eObject as AssuranceCase, uri)
							}
						})
						add(new Action("Verify TBD") {
							override run() {
								verifyTBD(eObject as AssuranceCase, uri)
							}
						})
					}
				}
			]
			treeViewer.control.menu = manager.createContextMenu(treeViewer.tree)
			
			treeViewer.input = assuranceCaseURIsInWorkspace
		]
	}
	
	def private createAssureViewer(Composite parent, TreeColumnLayout columnLayout) {
		new TreeViewer(parent, SWT.BORDER.bitwiseOr(SWT.H_SCROLL).bitwiseOr(SWT.V_SCROLL)) => [treeViewer |
			treeViewer.tree.headerVisible = true
			ColumnViewerToolTipSupport.enableFor(treeViewer)
			treeViewer.contentProvider = new ITreeContentProvider {
				override dispose() {
				}
				
				override getChildren(Object parentElement) {
					resourceSetForUI.getEObject(parentElement as URI, true).eContents.map[URI]
				}
				
				override getElements(Object inputElement) {
					inputElement as List<URI>
				}
				
				override getParent(Object element) {
					resourceSetForUI.getEObject(element as URI, true).eContainer?.URI ?: treeViewer.input
				}
				
				override hasChildren(Object element) {
					!resourceSetForUI.getEObject(element as URI, true).eContents.empty
				}
				
				override inputChanged(Viewer viewer, Object oldInput, Object newInput) {
				}
			}
			treeViewer.addFilter[viewer, parentElement, element |
				switch eObject : resourceSetForUI.getEObject(element as URI, true) {
					Metrics,
					QualifiedClaimReference,
					QualifiedVAReference: false
					AssureResult: !eObject.zeroTotalCount
					default: true
				}
			]
			new TreeViewerColumn(treeViewer, SWT.LEFT) => [
				column.alignment = SWT.LEFT
				column.text = "Evidence"
				columnLayout.setColumnData(column, new ColumnWeightData(6))
				labelProvider = new ColumnLabelProvider {
					override getText(Object element) {
						switch eObject : resourceSetForUI.getEObject(element as URI, true) {
							AssuranceCaseResult: "Case " + eObject.name
							ModelResult: '''Plan «eObject.plan.name»(«eObject.target.name»)'''
							SubsystemResult: "Subsystem " + eObject.name
							ClaimResult: "Claim " + eObject.name
							VerificationActivityResult: "Evidence " + eObject.name
							ValidationResult: "Validation " + eObject.name
							PreconditionResult: "Precondition " + eObject.name
							ResultIssue: "Issue " + (eObject.target?.constructLabel ?: eObject.constructMessage)
							ElseResult: "else"
							ThenResult: "then"
							PredicateResult: "Predicate"
							default: "?"
						}
					}
					
					override getToolTipText(Object element) {
						val eObject = resourceSetForUI.getEObject(element as URI, true)
						if (eObject instanceof ClaimResult) {
							eObject.target.title
						}
					}
					
					override getImage(Object element) {
						val imageFileName = switch eObject : resourceSetForUI.getEObject(element as URI, true) {
							ResultIssue: switch eObject.issueType {
								case ERROR: "error.png"
								case SUCCESS: "valid.png"
								case WARNING: "warning.png"
								case INFO: "info.png"
								case FAIL: "invalid.png"
								case TBD: "questionmark.png"
							}
							AssureResult case eObject.successful: "valid.png"
							AssureResult case eObject.fail: "invalid.png"
							AssureResult case eObject.errorTimeOut: "error.png"
							AssureResult case eObject.zeroCount: "info.png"
							default: "questionmark.png"
						}
						if (imageFileName != null) {
							ImageDescriptor.createFromFile(class, "/icons/" + imageFileName).createImage
						}
					}
				}
			]
			(0 ..< 10).forEach[columnIndex | new TreeViewerColumn(treeViewer, SWT.RIGHT) => [
				column.alignment = switch columnIndex {
					case 0,
					case 5: SWT.LEFT
					case columnIndex <= 4: SWT.CENTER
					default: SWT.RIGHT
				}
				column.text = switch columnIndex {
					case 0: "0%"
					case 5: "50%   -"
					case 9: "100%"
					default: "-"
				}
				columnLayout.setColumnData(column, new ColumnPixelData(45))
				labelProvider = getColorColumnLabelProvider(columnIndex)
			]]
			new TreeViewerColumn(treeViewer, SWT.RIGHT) => [
				column.alignment = SWT.LEFT
				column.text = "Description"
				columnLayout.setColumnData(column, new ColumnWeightData(9))
				labelProvider = new ColumnLabelProvider {
					override getText(Object element) {
						switch eObject : resourceSetForUI.getEObject(element as URI, true) {
							ClaimResult: eObject.constructMessage
							VerificationActivityResult: eObject.constructMessage + eObject.resultState.toTextLabel
							AssuranceCaseResult: eObject.constructMessage
							ModelResult: eObject.constructMessage
							SubsystemResult: eObject.constructMessage
							ResultIssue: eObject.constructMessage
							ElseResult: "else"
							ThenResult: "then"
						}
					}
				}
			]
			new TreeViewerColumn(treeViewer, SWT.RIGHT) => [
				column.alignment = SWT.LEFT
				column.text = "results count"
				columnLayout.setColumnData(column, new ColumnWeightData(4))
				labelProvider = new ColumnLabelProvider {
					override getText(Object element) {
						switch eObject : resourceSetForUI.getEObject(element as URI, true) {
							AssureResult: eObject.assureResultCounts
						}
					}
				}
			]
			
			val manager = new MenuManager
			manager.removeAllWhenShown = true
			manager.addMenuListener[
				val uri = treeViewer.structuredSelection.firstElement as URI
				if (uri != null) {
					val eObject = resourceSetForUI.getEObject(uri, true)
					if (eObject instanceof ClaimResult) {
						val requirementURI = eObject.target.URI
						add(new Action("Open Requirement") {
							override run() {
								editorOpener.open(requirementURI, true)
							}
						})
						val descriptionText = new StringSelection(eObject.constructDescription)
						add(new Action("Copy Claim Text") {
							override run() {
								Toolkit.defaultToolkit.systemClipboard.setContents(descriptionText, null)
							}
						})
					}
				}
			]
			treeViewer.control.menu = manager.createContextMenu(treeViewer.tree)
		]
	}
	
	def private getAssuranceCaseURIsInWorkspace() {
		rds.getExportedObjectsByType(AlisaPackage.Literals.ASSURANCE_CASE).map[EObjectURI].toList
	}
	
	def private getColorColumnLabelProvider(int columnIndex) {
		new ColumnLabelProvider {
			override getText(Object element) {
				""
			}
			
			override getBackground(Object element) {
				switch eObject : resourceSetForUI.getEObject(element as URI, true) {
					ResultIssue: switch eObject.issueType {
						case ERROR: null
						case SUCCESS: greenColor
						case WARNING: yellowColor
						case INFO: orangeColor
						default: blueColor
					}
					
					AssureResult case eObject.successful: greenColor
					AssureResult case eObject.zeroCount: orangeColor
					
					ClaimResult,
					AssuranceCaseResult,
					ModelResult,
					SubsystemResult: AssureColorBlockCountHolder.createAssureColorBlockCountHolder(eObject, blueColor, greenColor, redColor).colorValues.get(columnIndex)
					
					AssureResult case eObject.fail: redColor
					AssureResult case eObject.errorTimeOut: null
					
					VerificationActivityResult,
					ValidationResult,
					ThenResult,
					ElseResult: blueColor
					
					default: redColor
				}
			}
		}
	}
	
	def private updateAssureViewer(URI assuranceCaseURI, boolean updateRequirementsCoverageView) {
		val newURIs = assuranceCaseURI -> selectedFilters.get(assuranceCaseURI)
		if (displayedCaseAndFilter != newURIs) {
			displayedCaseAndFilter = newURIs
			
			val result = if (assuranceCaseURI != null) {
				val selectedAlisaObject = resourceSetForUI.getEObject(assuranceCaseURI, true)
				if (selectedAlisaObject instanceof AssuranceCase) {
					val resultDescriptions = rds.getExportedObjectsByType(AssurePackage.Literals.ASSURANCE_CASE_RESULT)
					val results = resultDescriptions.map[resourceSetForUI.getEObject(EObjectURI, true) as AssuranceCaseResult]
					results.findFirst[name == selectedAlisaObject.name]
				}
			}
			val filter = if (result != null && displayedCaseAndFilter.value != null) {
				resourceSetForUI.getEObject(displayedCaseAndFilter.value, true) as CategoryFilter
			}
			
			val expandedElements = assureViewer.expandedElements
			assureViewer.input = if (result != null) {
				result.recomputeAllCounts(filter)
				#[result.URI]
			}
			assureViewer.expandedElements = expandedElements
			if (updateRequirementsCoverageView) {
				val coverageView = viewSite.page.findView(AssureRequirementsCoverageView.ID) as AssureRequirementsCoverageView
				if (coverageView != null) {
					if (result != null) {
						coverageView.setAssuranceCaseResult(result, filter)
					} else {
						coverageView.clear
					}
				}
			}
		}
	}
	
	def private verifyAll(AssuranceCase assuranceCase, URI assuranceCaseURI) {
		verifyCommon(assuranceCase, assuranceCaseURI, [resourceSetForProcessing |
			createCaseResult(assuranceCase, assuranceCaseURI, resourceSetForProcessing)
		])
	}
	
	def private verifyTBD(AssuranceCase assuranceCase, URI assuranceCaseURI) {
		verifyCommon(assuranceCase, assuranceCaseURI, [resourceSetForProcessing |
			val resultDescriptions = rds.getExportedObjectsByType(AssurePackage.Literals.ASSURANCE_CASE_RESULT)
			val results = resultDescriptions.map[resourceSetForProcessing.getEObject(EObjectURI, true) as AssuranceCaseResult]
			val findResult = results.findFirst[name == assuranceCase.name]
			if (findResult == null) {
				createCaseResult(assuranceCase, assuranceCaseURI, resourceSetForProcessing)
			} else {
				ResourcesPlugin.workspace.root.getFile(new Path(assuranceCaseURI.toPlatformString(true))).project -> findResult
			}
		])
	}
	
	def private verifyCommon(AssuranceCase assuranceCase, URI assuranceCaseURI, (ResourceSet)=>Pair<IProject, AssuranceCaseResult> getProjectAndResult) {
		val dirtyEditors = viewSite.page.dirtyEditors
		if (!dirtyEditors.empty && MessageDialog.openConfirm(viewSite.shell, "Save editors", "Save editors and continue?")) {
			val monitor = new NullProgressMonitor
			dirtyEditors.forEach[doSave(monitor)]
		}
		val resourceSetForProcessing = resourceSetProvider.get(null)
		val assureProjectAndResult = getProjectAndResult.apply(resourceSetForProcessing)
		val assureProject = assureProjectAndResult.key
		val assuranceCaseResult = assureProjectAndResult.value
		val filterURI = selectedFilters.get(assuranceCaseURI)
		val filter = if (filterURI != null) {
			resourceSetForProcessing.getEObject(filterURI, true) as CategoryFilter
		}
		val job = new WorkspaceJob("ASSURE verification") {
			override runInWorkspace(IProgressMonitor monitor) throws CoreException {
				VerifyUtilExtension.clearAllHasRunRecords
				AssureUtilExtension.clearAllInstanceModels
				val progressViewHolder = new AtomicReference
				viewSite.workbenchWindow.workbench.display.syncExec[
					val coverageView = viewSite.page.showView(AssureRequirementsCoverageView.ID) as AssureRequirementsCoverageView
					coverageView.setAssuranceCaseResult(assuranceCaseResult, filter)
					assureProcessor.requirementsCoverageUpdater = [
						viewSite.workbenchWindow.workbench.display.asyncExec[coverageView.refresh]
					]
					
					val progressView = viewSite.page.showView(AssureProgressView.ID) as AssureProgressView
					progressView.setAssuranceCaseResult(assuranceCaseResult, filter)
					progressView.setFocus
					assureProcessor.progressUpdater = [vaResultURI |
						viewSite.workbenchWindow.workbench.display.asyncExec[progressView.update(vaResultURI)]
					]
					progressViewHolder.set(progressView)
				]
				try {
					assureProcessor.processCase(assuranceCaseResult, filter, monitor)
					viewSite.workbenchWindow.workbench.display.asyncExec[progressViewHolder.get.refresh]
					Status.OK_STATUS
				} catch (NoSuchMethodException e) {
					Status.CANCEL_STATUS
				}
			}
		}
		val aadlProject = ResourcesPlugin.workspace.root.getFile(new Path(assuranceCase.system.URI.toPlatformString(true))).project
		job.rule = new MultiRule(#[assureProject, aadlProject])
		job.schedule
	}
	
	def private createCaseResult(AssuranceCase assuranceCase, URI assuranceCaseURI, ResourceSet resourceSetForProcessing) {
		val assureProject = ResourcesPlugin.workspace.root.getFile(new Path(assuranceCaseURI.toPlatformString(true))).project
		val assureURI = URI.createPlatformResourceURI('''«assureProject.fullPath»/assure/«assuranceCase.name».assure''', false)
		val assuranceCaseResultHolder = new AtomicReference
		val domain = TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain("org.osate.aadl2.ModelEditingDomain")
		domain.commandStack.execute(new RecordingCommand(domain) {
			override protected doExecute() {
				val assuranceCaseResult = assureConstructor.generateFullAssuranceCase(assuranceCase)
				assuranceCaseResult.resetToTBD(null)
				assuranceCaseResult.recomputeAllCounts(null)
				val resource = resourceSetForProcessing.getResource(assureURI, false) ?: resourceSetForProcessing.createResource(assureURI)
				resource.contents.clear
				resource.contents += assuranceCaseResult
				try {
					resource.save(null)
				} catch (IOException e) {
					//Do nothing.
				}
				assuranceCaseResultHolder.set(assuranceCaseResult)
			}
		})
		assureProject -> assuranceCaseResultHolder.get
	}
}