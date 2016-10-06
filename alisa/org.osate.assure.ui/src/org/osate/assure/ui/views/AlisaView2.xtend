package org.osate.assure.ui.views

import com.google.inject.Inject
import java.util.List
import java.util.concurrent.atomic.AtomicBoolean
import org.eclipse.core.resources.IResourceChangeEvent
import org.eclipse.core.resources.IResourceChangeListener
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.jface.layout.TreeColumnLayout
import org.eclipse.jface.resource.ImageDescriptor
import org.eclipse.jface.viewers.ColumnLabelProvider
import org.eclipse.jface.viewers.ColumnPixelData
import org.eclipse.jface.viewers.ColumnWeightData
import org.eclipse.jface.viewers.ITreeContentProvider
import org.eclipse.jface.viewers.TreeViewer
import org.eclipse.jface.viewers.TreeViewerColumn
import org.eclipse.jface.viewers.Viewer
import org.eclipse.swt.SWT
import org.eclipse.swt.custom.SashForm
import org.eclipse.swt.widgets.Composite
import org.eclipse.ui.part.ViewPart
import org.eclipse.xtext.resource.IResourceDescriptions
import org.eclipse.xtext.ui.resource.IResourceSetProvider
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
import org.osate.assure.ui.labeling.AssureColorBlockCountHolder

import static extension org.eclipse.emf.ecore.util.EcoreUtil.getURI
import static extension org.osate.assure.util.AssureUtilExtension.assureResultCounts
import static extension org.osate.assure.util.AssureUtilExtension.constructLabel
import static extension org.osate.assure.util.AssureUtilExtension.constructMessage
import static extension org.osate.assure.util.AssureUtilExtension.getName
import static extension org.osate.assure.util.AssureUtilExtension.isErrorTimeOut
import static extension org.osate.assure.util.AssureUtilExtension.isFail
import static extension org.osate.assure.util.AssureUtilExtension.isSuccessful
import static extension org.osate.assure.util.AssureUtilExtension.isZeroCount
import static extension org.osate.assure.util.AssureUtilExtension.isZeroTotalCount
import static extension org.osate.assure.util.AssureUtilExtension.recomputeAllCounts
import static extension org.osate.assure.util.AssureUtilExtension.toTextLabel

class AlisaView2 extends ViewPart {
	val static ALISA_EXTENSION = "alisa"
	val static ASSURE_EXTENSION = "assure"
	val ResourceSet resourceSet
	val IResourceDescriptions rds
	URI selectedAssuranceCaseURI
	
	val IResourceChangeListener resourceChangeListener = [
		val alisaFileChanged = new AtomicBoolean(false)
		val assureFileChanged = new AtomicBoolean(false)
		delta.accept[
			if (resource.fileExtension == ALISA_EXTENSION) {
				alisaFileChanged.set(true)
				val resourceURI = URI.createPlatformResourceURI(resource.fullPath.toString, false)
				resourceSet.getResource(resourceURI, false)?.unload
			} else if (resource.fileExtension == ASSURE_EXTENSION) {
				assureFileChanged.set(true)
				val resourceURI = URI.createPlatformResourceURI(resource.fullPath.toString, false)
				resourceSet.getResource(resourceURI, false)?.unload
			}
			true
		]
		if (alisaFileChanged.get) {
			viewSite.shell.display.asyncExec[
				val expandedElements = alisaViewer.expandedElements
				alisaViewer.input = assuranceCaseURIsInWorkspace
				alisaViewer.expandedElements = expandedElements
			]
		}
		if (assureFileChanged.get) {
			viewSite.shell.display.asyncExec[
				val expandedElements = assureViewer.expandedElements
				assureViewer.refresh
				assureViewer.expandedElements = expandedElements
			]
		}
	]
	
	TreeViewer alisaViewer
	TreeViewer assureViewer
	
	@Inject
	new(IResourceSetProvider resourceSetProvider, IResourceDescriptions rds) {
		resourceSet = resourceSetProvider.get(null)
		this.rds = rds
	}
	
	override createPartControl(Composite parent) {
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
		super.dispose
	}
	
	def private createAlisaViewer(Composite parent, TreeColumnLayout columnLayout) {
		new TreeViewer(parent, SWT.BORDER.bitwiseOr(SWT.H_SCROLL).bitwiseOr(SWT.V_SCROLL).bitwiseOr(SWT.SINGLE)) => [
			tree.headerVisible = true
			contentProvider = new ITreeContentProvider {
				override dispose() {
				}
				
				override getChildren(Object parentElement) {
					switch parentEObject : resourceSet.getEObject(parentElement as URI, true) {
						AssuranceCase: parentEObject.assurancePlans.map[URI]
						default: #[]
					}
				}
				
				override getElements(Object inputElement) {
					inputElement as List<URI>
				}
				
				override getParent(Object element) {
					switch elementEObject : resourceSet.getEObject(element as URI, true) {
						AssuranceCase: input
						AssurancePlan: elementEObject.eContainer.URI
					}
				}
				
				override hasChildren(Object element) {
					switch elementEObject : resourceSet.getEObject(element as URI, true) {
						AssuranceCase: !elementEObject.assurancePlans.empty
						default: false
					}
				}
				
				override inputChanged(Viewer viewer, Object oldInput, Object newInput) {
				}
			}
			new TreeViewerColumn(it, SWT.LEFT) => [
				columnLayout.setColumnData(column, new ColumnWeightData(1))
				column.text = "Assurance Cases and Plans"
				column.width = 200
				labelProvider = new ColumnLabelProvider {
					override getText(Object element) {
						switch eObject : resourceSet.getEObject(element as URI, true) {
							AssuranceCase: "Assurance Case: " + eObject.name
							AssurancePlan: "Assurance Plan: " + eObject.name
						}
					}
				}
			]
			addSelectionChangedListener[event |
				val selectedURI = structuredSelection.firstElement as URI
				if (selectedAssuranceCaseURI != selectedURI) {
					selectedAssuranceCaseURI = selectedURI
					assureViewer.input = if (selectedURI != null) {
						val selectedAlisaObject = resourceSet.getEObject(selectedURI, true)
						if (selectedAlisaObject instanceof AssuranceCase) {
							val resultDescriptions = rds.getExportedObjectsByType(AssurePackage.Literals.ASSURANCE_CASE_RESULT)
							val results = resultDescriptions.map[resourceSet.getEObject(EObjectURI, true) as AssuranceCaseResult]
							val result = results.findFirst[name == selectedAlisaObject.name]
							if (result != null) {
								result.recomputeAllCounts(null)
								#[result.URI]
							}
						}
					}
				}
			]
			input = assuranceCaseURIsInWorkspace
		]
	}
	
	def private createAssureViewer(Composite parent, TreeColumnLayout columnLayout) {
		new TreeViewer(parent, SWT.BORDER.bitwiseOr(SWT.H_SCROLL).bitwiseOr(SWT.V_SCROLL)) => [
			tree.headerVisible = true
			contentProvider = new ITreeContentProvider {
				override dispose() {
				}
				
				override getChildren(Object parentElement) {
					resourceSet.getEObject(parentElement as URI, true).eContents.map[URI]
				}
				
				override getElements(Object inputElement) {
					inputElement as List<URI>
				}
				
				override getParent(Object element) {
					resourceSet.getEObject(element as URI, true).eContainer?.URI ?: input
				}
				
				override hasChildren(Object element) {
					!resourceSet.getEObject(element as URI, true).eContents.empty
				}
				
				override inputChanged(Viewer viewer, Object oldInput, Object newInput) {
				}
			}
			addFilter[viewer, parentElement, element |
				switch resourceSet.getEObject(element as URI, true) {
					Metrics,
					QualifiedClaimReference,
					QualifiedVAReference: false
					default: true
				}
			]
			addFilter[viewer, parentElement, element |
				switch eObject : resourceSet.getEObject(element as URI, true) {
					AssureResult: !eObject.zeroTotalCount
					default: true
				}
			]
			new TreeViewerColumn(it, SWT.LEFT) => [
				column.alignment = SWT.LEFT
				column.text = "Evidence"
				columnLayout.setColumnData(column, new ColumnWeightData(6))
				labelProvider = new ColumnLabelProvider {
					override getText(Object element) {
						switch eObject : resourceSet.getEObject(element as URI, true) {
							AssuranceCaseResult: "Assurance case " + eObject.name
							ModelResult: "Assurance plan " + eObject.name
							SubsystemResult: "Subsystem verification " + eObject.name
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
					
					override getImage(Object element) {
						val imageFileName = switch eObject : resourceSet.getEObject(element as URI, true) {
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
			(0 ..< 10).forEach[columnIndex | new TreeViewerColumn(it, SWT.RIGHT) => [
				column.alignment = switch columnIndex {
					case 0,
					case 5: SWT.LEFT
					case columnIndex <= 4: SWT.CENTER
					default: SWT.RIGHT
				}
				column.text = switch columnIndex {
					case 0: "0"
					case 5: ".5    -"
					case 9: "1"
					default: "-"
				}
				columnLayout.setColumnData(column, new ColumnPixelData(45))
				labelProvider = getColorColumnLabelProvider(columnIndex)
			]]
			new TreeViewerColumn(it, SWT.RIGHT) => [
				column.alignment = SWT.LEFT
				column.text = "Description"
				columnLayout.setColumnData(column, new ColumnWeightData(9))
				labelProvider = new ColumnLabelProvider {
					override getText(Object element) {
						switch eObject : resourceSet.getEObject(element as URI, true) {
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
			new TreeViewerColumn(it, SWT.RIGHT) => [
				column.alignment = SWT.LEFT
				column.text = "results count"
				columnLayout.setColumnData(column, new ColumnWeightData(4))
				labelProvider = new ColumnLabelProvider {
					override getText(Object element) {
						switch eObject : resourceSet.getEObject(element as URI, true) {
							AssureResult: eObject.assureResultCounts
						}
					}
				}
			]
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
				viewSite.shell.display.getSystemColor(switch eObject : resourceSet.getEObject(element as URI, true) {
					ResultIssue: switch eObject.issueType {
						case ERROR: SWT.COLOR_DARK_GRAY
						case SUCCESS: SWT.COLOR_GREEN
						case WARNING: SWT.COLOR_YELLOW
						case INFO: SWT.COLOR_DARK_BLUE
						default: SWT.COLOR_BLUE
					}
					
					AssureResult case eObject.successful: SWT.COLOR_GREEN
					AssureResult case eObject.zeroCount: SWT.COLOR_DARK_BLUE
					
					ClaimResult,
					AssuranceCaseResult,
					ModelResult,
					SubsystemResult: AssureColorBlockCountHolder.createAssureColorBlockCountHolder(eObject).colorValues.get(columnIndex)
					
					AssureResult case eObject.fail: SWT.COLOR_RED
					AssureResult case eObject.errorTimeOut: SWT.COLOR_DARK_GRAY
					
					VerificationActivityResult,
					ValidationResult,
					ThenResult,
					ElseResult: SWT.COLOR_BLUE
					
					default: SWT.COLOR_RED
				})
			}
		}
	}
}