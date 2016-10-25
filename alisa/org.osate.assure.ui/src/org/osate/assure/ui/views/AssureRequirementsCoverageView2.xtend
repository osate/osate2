package org.osate.assure.ui.views

import com.google.inject.Inject
import java.text.NumberFormat
import java.util.List
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.jface.layout.TreeColumnLayout
import org.eclipse.jface.resource.ImageDescriptor
import org.eclipse.jface.viewers.ColumnLabelProvider
import org.eclipse.jface.viewers.ColumnPixelData
import org.eclipse.jface.viewers.ITreeContentProvider
import org.eclipse.jface.viewers.TreeViewer
import org.eclipse.jface.viewers.TreeViewerColumn
import org.eclipse.jface.viewers.Viewer
import org.eclipse.swt.SWT
import org.eclipse.swt.widgets.Composite
import org.eclipse.ui.part.ViewPart
import org.osate.alisa.common.common.ResultIssue
import org.osate.assure.assure.AssuranceCaseResult
import org.osate.assure.assure.AssureResult
import org.osate.assure.assure.ClaimResult
import org.osate.assure.assure.ElseResult
import org.osate.assure.assure.Metrics
import org.osate.assure.assure.ModelResult
import org.osate.assure.assure.PreconditionResult
import org.osate.assure.assure.QualifiedClaimReference
import org.osate.assure.assure.QualifiedVAReference
import org.osate.assure.assure.SubsystemResult
import org.osate.assure.assure.ThenResult
import org.osate.assure.assure.ValidationResult
import org.osate.assure.assure.VerificationActivityResult
import org.osate.assure.evaluator.IAssureRequirementMetricsProcessor
import org.osate.assure.util.AssureUtilExtension
import org.osate.categories.categories.CategoryFilter
import org.osate.verify.util.VerifyUtilExtension

import static extension org.eclipse.emf.ecore.util.EcoreUtil.getURI
import static extension org.osate.assure.util.AssureUtilExtension.constructLabel
import static extension org.osate.assure.util.AssureUtilExtension.constructMessage
import static extension org.osate.assure.util.AssureUtilExtension.getName
import static extension org.osate.assure.util.AssureUtilExtension.isErrorTimeOut
import static extension org.osate.assure.util.AssureUtilExtension.isFail
import static extension org.osate.assure.util.AssureUtilExtension.isSuccessful
import static extension org.osate.assure.util.AssureUtilExtension.isZeroCount

class AssureRequirementsCoverageView2 extends ViewPart {
	val package static String ID = "org.osate.assure.ui.views.assure.requirements.coverage.view2"
	
	ResourceSet resourceSet
	val IAssureRequirementMetricsProcessor assureRequirementMetricsProcessor
	
	TreeViewer treeViewer
	
	@Inject
	new(IAssureRequirementMetricsProcessor assureRequirementMetricsProcessor) {
		this.assureRequirementMetricsProcessor = assureRequirementMetricsProcessor
	}
	
	override createPartControl(Composite parent) {
		new Composite(parent, SWT.NONE) => [
			val columnLayout = new TreeColumnLayout
			layout = columnLayout
			treeViewer = new TreeViewer(it, SWT.BORDER.bitwiseOr(SWT.H_SCROLL).bitwiseOr(SWT.V_SCROLL)) => [
				site.selectionProvider = it
				addFilter[viewer, parentElement, element |
					switch resourceSet.getEObject(element as URI, true) {
						Metrics,
						QualifiedClaimReference,
						QualifiedVAReference,
						ClaimResult: false
						default: true
					}
				]
				new TreeViewerColumn(it, SWT.LEFT) => [
					column.alignment = SWT.LEFT
					column.text = ""
					columnLayout.setColumnData(column, new ColumnPixelData(300))
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
								default: "?"
							}
						}
						
						override getImage(Object element) {
							val fileName = switch eObject : resourceSet.getEObject(element as URI, true) {
								ResultIssue: switch eObject.issueType {
									case ERROR: "error.png"
									case SUCCESS: "valid.png"
									case WARNING: "warning.png"
									case INFO: "info.png"
									case FAIL: "invalid.png"
									case TBD: "questionmark.png"
								}
								AssuranceCaseResult: "assure.png"
								AssureResult case eObject.successful: "valid.png"
								AssureResult case eObject.fail: "invalid.png"
								AssureResult case eObject.errorTimeOut: "error.png"
								AssureResult case eObject.zeroCount: "info.png"
								AssureResult: "questionmark.png"
							}
							ImageDescriptor.createFromFile(class, "/icons/" + fileName).createImage
						}
					}
				]
				new TreeViewerColumn(it, SWT.RIGHT) => [
					column.alignment = SWT.LEFT
					column.text = "Reqs w/no plan claim"
					columnLayout.setColumnData(column, new ColumnPixelData(160))
					labelProvider = new ColumnLabelProvider {
						override getText(Object element) {
							switch eObject : resourceSet.getEObject(element as URI, true) {
								AssuranceCaseResult: eObject.cumulativeRequirementsWithoutPlanClaimCount + " of " + eObject.cumulativeRequirementsCount
								ModelResult,
								SubsystemResult: {
									val noPlan = eObject.metrics.requirementsWithoutPlanClaimCount
									val reqs = eObject.metrics.requirementsCount
									val cumulativeNoPlan = eObject.cumulativeRequirementsWithoutPlanClaimCount
									'''«noPlan» of «reqs» | Cume: «cumulativeNoPlan» of «eObject.cumulativeRequirementsCount»'''
								}
								ResultIssue: eObject.target?.constructLabel ?: eObject.constructMessage
								ElseResult: "else"
								ThenResult: "then"
								default: "?"
							}
						}
						
						def int getCumulativeRequirementsWithoutPlanClaimCount(AssureResult ele) {
							val results = switch ele {
								AssuranceCaseResult: ele.modelResult
								ModelResult: ele.subsystemResult
								SubsystemResult: ele.subsystemResult
							}
							ele.metrics.requirementsWithoutPlanClaimCount + results.fold(0, [sum, res |
								sum + res.cumulativeRequirementsWithoutPlanClaimCount
							])
						}
						
						def int getCumulativeRequirementsCount(AssureResult ele) {
							val results = switch ele {
								AssuranceCaseResult: ele.modelResult
								ModelResult: ele.subsystemResult
								SubsystemResult: ele.subsystemResult
							}
							ele.metrics.requirementsCount + results.fold(0, [sum, res |
								sum + res.cumulativeRequirementsCount
							])
						}
					}
				]
				new TreeViewerColumn(it, SWT.RIGHT) => [
					column.alignment = SWT.LEFT
					column.text = "Quality Categories Cvrg"
					columnLayout.setColumnData(column, new ColumnPixelData(180))
					labelProvider = new ColumnLabelProvider {
						val format = NumberFormat.percentInstance => [minimumFractionDigits = 2]
						
						override getText(Object element) {
							switch eObject : resourceSet.getEObject(element as URI, true) {
								AssuranceCaseResult: format.format(eObject.cumulativeQualityCategoryRequirementsCount as double / eObject.cumulativeTotalQualityCategorysCount)
								ModelResult,
								SubsystemResult: {
									val qualityReqs = eObject.metrics.qualityCategoryRequirementsCount
									val totalQuality = eObject.metrics.totalQualityCategoryCount
									val percent = format.format(eObject.cumulativeQualityCategoryRequirementsCount as double / eObject.cumulativeTotalQualityCategorysCount)
									'''«qualityReqs» of «totalQuality» | Cume: «percent»'''
								}
								ResultIssue: eObject.target?.constructLabel ?: eObject.constructMessage
								ElseResult: "else"
								ThenResult: "then"
								default: "?"
							}
						}
						
						def int getCumulativeQualityCategoryRequirementsCount(AssureResult ele) {
							val results = switch ele {
								AssuranceCaseResult: ele.modelResult
								ModelResult: ele.subsystemResult
								SubsystemResult: ele.subsystemResult
							}
							ele.metrics.qualityCategoryRequirementsCount + results.fold(0, [sum, res |
								sum + res.cumulativeQualityCategoryRequirementsCount
							])
						}
						
						def int getCumulativeTotalQualityCategorysCount(AssureResult ele) {
							val results = switch ele {
								AssuranceCaseResult: ele.modelResult
								ModelResult: ele.subsystemResult
								SubsystemResult: ele.subsystemResult
							}
							ele.metrics.totalQualityCategoryCount + results.fold(0, [sum, res |
								sum + res.cumulativeTotalQualityCategorysCount
							])
						}
					}
				]
				new TreeViewerColumn(it, SWT.RIGHT) => [
					column.alignment = SWT.LEFT
					column.text = "Requirement for Features"
					columnLayout.setColumnData(column, new ColumnPixelData(180))
					labelProvider = new ColumnLabelProvider {
						override getText(Object element) {
							switch eObject : resourceSet.getEObject(element as URI, true) {
								AssuranceCaseResult: eObject.cumulativeFeaturesRequirementsCount + " for "  + eObject.cumulativeFeaturesCount
								ModelResult,
								SubsystemResult: {
									val featuresReqs = eObject.metrics.featuresRequirementsCount
									val features = eObject.metrics.featuresCount
									val cumulativeFeaturesReqs = eObject.cumulativeFeaturesRequirementsCount
									val cumulativeFeatures = eObject.cumulativeFeaturesCount
									'''«featuresReqs» for «features» | Cume: «cumulativeFeaturesReqs» for «cumulativeFeatures»'''
								}
								ResultIssue: eObject.target?.constructLabel ?: eObject.constructMessage
								ElseResult: "else"
								ThenResult: "then"
								default: "?"
							}
						}
						
						def int getCumulativeFeaturesRequirementsCount(AssureResult ele) {
							val results = switch ele {
								AssuranceCaseResult: ele.modelResult
								ModelResult: ele.subsystemResult
								SubsystemResult: ele.subsystemResult
							}
							ele.metrics.featuresRequirementsCount + results.fold(0, [sum, res |
								sum + res.cumulativeFeaturesRequirementsCount
							])
						}
						
						def int getCumulativeFeaturesCount(AssureResult ele) {
							val results = switch ele {
								AssuranceCaseResult: ele.modelResult
								ModelResult: ele.subsystemResult
								SubsystemResult: ele.subsystemResult
							}
							ele.metrics.featuresCount + results.fold(0, [sum, res | sum + res.cumulativeFeaturesCount])
						}
					}
				]
				new TreeViewerColumn(it, SWT.RIGHT) => [
					column.alignment = SWT.LEFT
					column.text = "No Verify Plans"
					columnLayout.setColumnData(column, new ColumnPixelData(120))
					labelProvider = new ColumnLabelProvider {
						override getText(Object element) {
							switch eObject : resourceSet.getEObject(element as URI, true) {
								AssuranceCaseResult: eObject.cumulativeNoVerificationPlansCount.toString
								ModelResult,
								SubsystemResult: eObject.metrics.noVerificationPlansCount + " | Cume: " + eObject.cumulativeNoVerificationPlansCount
								ResultIssue: eObject.target?.constructLabel ?: eObject.constructMessage
								ElseResult: "else"
								ThenResult: "then"
								default: "?"
							}
						}
						
						def int getCumulativeNoVerificationPlansCount(AssureResult ele) {
							val results = switch ele {
								AssuranceCaseResult: ele.modelResult
								ModelResult: ele.subsystemResult
								SubsystemResult: ele.subsystemResult
							}
							ele.metrics.noVerificationPlansCount + results.fold(0, [sum, res |
								sum + res.cumulativeNoVerificationPlansCount
							])
						}
					}
				]
				new TreeViewerColumn(it, SWT.RIGHT) => [
					column.alignment = SWT.LEFT
					column.text = "Reqs w/Exception"
					columnLayout.setColumnData(column, new ColumnPixelData(150))
					labelProvider = new ColumnLabelProvider {
						override getText(Object element) {
							switch eObject : resourceSet.getEObject(element as URI, true) {
								AssuranceCaseResult: eObject.cumulativeExceptionsCount + " of " + eObject.cumulativeRequirementsCount
								ModelResult,
								SubsystemResult: {
									val exceptions = eObject.metrics.exceptionsCount
									val reqs = eObject.metrics.requirementsCount
									val cumulativeExceptions = eObject.cumulativeExceptionsCount
									val cumulativeReqs = eObject.cumulativeRequirementsCount
									'''«exceptions» of «reqs» | Cume: «cumulativeExceptions» of «cumulativeReqs»'''
								}
								default: "?"
							}
						}
						
						def int getCumulativeExceptionsCount(AssureResult ele) {
							val results = switch ele {
								AssuranceCaseResult: ele.modelResult
								ModelResult: ele.subsystemResult
								SubsystemResult: ele.subsystemResult
							}
							ele.metrics.exceptionsCount + results.fold(0, [sum, res |
								sum + res.cumulativeExceptionsCount
							])
						}
						
						def int getCumulativeRequirementsCount(AssureResult ele) {
							val results = switch ele {
								AssuranceCaseResult: ele.modelResult
								ModelResult: ele.subsystemResult
								SubsystemResult: ele.subsystemResult
							}
							ele.metrics.requirementsCount + results.fold(0, [sum, res |
								sum + res.cumulativeRequirementsCount
							])
						}
					}
				]
				new TreeViewerColumn(it, SWT.RIGHT) => [
					column.alignment = SWT.LEFT
					column.text = "Req Target w/EMV2"
					columnLayout.setColumnData(column, new ColumnPixelData(150))
					labelProvider = new ColumnLabelProvider {
						override getText(Object element) {
							switch eObject : resourceSet.getEObject(element as URI, true) {
								AssuranceCaseResult: eObject.cumulativeReqTargetHasEMV2SubclauseCount + " of " + eObject.cumulativeRequirementsCount
								ModelResult,
								SubsystemResult: {
									val cumulativeSubclauses = eObject.cumulativeReqTargetHasEMV2SubclauseCount
									val reqs = eObject.metrics.requirementsCount
									val cumulativeReqs = eObject.cumulativeRequirementsCount
									'''«cumulativeSubclauses» of «reqs» | Cume: «cumulativeSubclauses» of «cumulativeReqs»'''
								}
								default: "?"
							}
						}
						
						def int getCumulativeReqTargetHasEMV2SubclauseCount(AssureResult ele) {
							val results = switch ele {
								AssuranceCaseResult: ele.modelResult
								ModelResult: ele.subsystemResult
								SubsystemResult: ele.subsystemResult
							}
							ele.metrics.reqTargetHasEMV2SubclauseCount + results.fold(0, [sum, res |
								sum + res.cumulativeReqTargetHasEMV2SubclauseCount
							])
						}
						
						def int getCumulativeRequirementsCount(AssureResult ele) {
							val results = switch ele {
								AssuranceCaseResult: ele.modelResult
								ModelResult: ele.subsystemResult
								SubsystemResult: ele.subsystemResult
							}
							ele.metrics.requirementsCount + results.fold(0, [sum, res |
								sum + res.cumulativeRequirementsCount
							])
						}
					}
				]
				new TreeViewerColumn(it, SWT.RIGHT) => [
					column.alignment = SWT.LEFT
					column.text = "Classifiers for Features Requiring"
					columnLayout.setColumnData(column, new ColumnPixelData(150))
					labelProvider = new ColumnLabelProvider {
						override getText(Object element) {
							switch eObject : resourceSet.getEObject(element as URI, true) {
								AssuranceCaseResult: {
									val cumulativeFeaturesWith = eObject.cumulativeFeaturesWithRequiredClassifierCount
									val cumulativeFeaturesRequiring = eObject.cumulativeFeaturesRequiringClassifierCount
									cumulativeFeaturesWith + " of " + cumulativeFeaturesRequiring
								}
								ModelResult,
								SubsystemResult: {
									val featuresWith = eObject.metrics.featuresWithRequiredClassifierCount
									val featuresRequiring = eObject.metrics.featuresRequiringClassifierCount
									val cumulativeFeaturesWith = eObject.cumulativeFeaturesWithRequiredClassifierCount
									val cumulativeFeaturesRequiring = eObject.cumulativeFeaturesRequiringClassifierCount
									'''«featuresWith» of «featuresRequiring» | Cume: «cumulativeFeaturesWith» of «cumulativeFeaturesRequiring»'''
								}
								default: "?"
							}
						}
						
						def int getCumulativeFeaturesWithRequiredClassifierCount(AssureResult ele) {
							val results = switch ele {
								AssuranceCaseResult: ele.modelResult
								ModelResult: ele.subsystemResult
								SubsystemResult: ele.subsystemResult
							}
							ele.metrics.featuresWithRequiredClassifierCount + results.fold(0, [sum, res |
								sum + res.cumulativeFeaturesWithRequiredClassifierCount
							])
						}
						
						def int getCumulativeFeaturesRequiringClassifierCount(AssureResult ele) {
							val results = switch ele {
								AssuranceCaseResult: ele.modelResult
								ModelResult: ele.subsystemResult
								SubsystemResult: ele.subsystemResult
							}
							ele.metrics.featuresRequiringClassifierCount + results.fold(0, [sum, res |
								sum + res.cumulativeFeaturesRequiringClassifierCount
							])
						}
					}
				]
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
						resourceSet.getEObject(element as URI, true).eContainer?.URI ?: treeViewer.input
					}
					
					override hasChildren(Object element) {
						!resourceSet.getEObject(element as URI, true).eContents.empty
					}
					
					override inputChanged(Viewer viewer, Object oldInput, Object newInput) {
					}
				}
				tree.headerVisible = true
				tree.linesVisible = true
			]
		]
	}
	
	override setFocus() {
		treeViewer.tree.setFocus
	}
	
	def package void setAssuranceCaseResult(AssuranceCaseResult assuranceCaseResult, CategoryFilter filter) {
		val expandedElements = treeViewer.expandedElements
		resourceSet = assuranceCaseResult.eResource.resourceSet
		VerifyUtilExtension.clearAllHasRunRecords
		AssureUtilExtension.clearAllInstanceModels
		assureRequirementMetricsProcessor.processCase(assuranceCaseResult, filter, null)
		treeViewer.input = #[assuranceCaseResult.URI]
		treeViewer.expandedElements = expandedElements
	}
	
	def package void refresh() {
		treeViewer.refresh
	}
}