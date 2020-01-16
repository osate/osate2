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
package org.osate.alisa.workbench.ui.views

import com.google.inject.Inject
import java.io.IOException
import java.text.NumberFormat
import java.util.List
import java.util.Optional
import java.util.concurrent.atomic.AtomicBoolean
import java.util.concurrent.atomic.AtomicReference
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.IResourceChangeEvent
import org.eclipse.core.resources.IResourceChangeListener
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.core.runtime.Path
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.ResourceSet
//import org.eclipse.emf.transaction.RecordingCommand
//import org.eclipse.emf.transaction.TransactionalEditingDomain
import org.eclipse.jface.dialogs.DialogSettings
import org.eclipse.jface.dialogs.IDialogSettings
import org.eclipse.jface.layout.TreeColumnLayout
import org.eclipse.jface.resource.ImageDescriptor
import org.eclipse.jface.viewers.ArrayContentProvider
import org.eclipse.jface.viewers.ColumnLabelProvider
import org.eclipse.jface.viewers.ColumnPixelData
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
import org.eclipse.swt.widgets.Composite
import org.eclipse.ui.part.ViewPart
import org.eclipse.xtext.resource.IResourceDescriptions
import org.eclipse.xtext.ui.editor.GlobalURIEditorOpener
import org.eclipse.xtext.ui.resource.IResourceSetProvider
import org.osate.aadl2.util.Activator
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
import org.osate.assure.evaluator.IAssureRequirementMetricsProcessor
import org.osate.assure.generator.IAssureConstructor
import org.osate.categories.categories.CategoriesPackage
import org.osate.categories.categories.CategoryFilter
import org.osate.result.Diagnostic

import static extension org.eclipse.emf.ecore.util.EcoreUtil.getURI
import static extension org.osate.assure.util.AssureUtilExtension.*
import org.osate.result.Result

class AssureRequirementsCoverageView extends ViewPart {
	val static ASSURANCE_CASE_URIS_KEY = "ASSURANCE_CASE_URIS_KEY"
	val static FILTER_URIS_KEY = "FILTER_URIS_KEY"
	val static ALISA_EXTENSION = "alisa"
	val static ASSURE_EXTENSION = "assure"

	val IResourceSetProvider resourceSetProvider
	val ResourceSet resourceSetForUI
	val IResourceDescriptions rds
	val GlobalURIEditorOpener editorOpener
	val IAssureConstructor assureConstructor
	val String settingsFileName
	val IDialogSettings dialogSettings

	@Inject
	IAssureRequirementMetricsProcessor assureRequirementMetricsProcessor

	// Map is from AssuranceCase to CategoryFilter
	val selectedFilters = <URI, URI>newHashMap
	Pair<URI, URI> displayedCaseAndFilter = null -> null

	TreeViewer alisaViewer
	TreeViewer assureCoverageViewer

	val IResourceChangeListener resourceChangeListener

	@Inject
	new(IResourceSetProvider resourceSetProvider, IResourceDescriptions rds, GlobalURIEditorOpener editorOpener,
		IAssureConstructor assureConstructor, IAssureProcessor assureProcessor) {
		this.resourceSetProvider = resourceSetProvider
		resourceSetForUI = resourceSetProvider.get(null)
		this.rds = rds
		this.editorOpener = editorOpener
		this.assureConstructor = assureConstructor
		val pluginsDir = Activator.^default.stateLocation.removeLastSegments(1)
		settingsFileName = pluginsDir.append("org.osate.assure").append("assure_view_settings.xml").toOSString
		dialogSettings = new DialogSettings("assure_view_settings")
		try {
			dialogSettings.load(settingsFileName)
			val assuranceCaseURIs = dialogSettings.getArray(ASSURANCE_CASE_URIS_KEY)
			val filterURIs = dialogSettings.getArray(FILTER_URIS_KEY)
			if (assuranceCaseURIs !== null && filterURIs !== null && assuranceCaseURIs.size == filterURIs.size) {
				for (var i = 0; i < filterURIs.size; i++) {
					val assuranceCaseURI = URI.createURI(assuranceCaseURIs.get(i))
					val filterURI = URI.createURI(filterURIs.get(i))
					if (resourceSetForUI.getEObject(assuranceCaseURI, true) !== null &&
						resourceSetForUI.getEObject(filterURI, true) !== null) {
						selectedFilters.put(assuranceCaseURI, filterURI)
					}
				}
			}
		} catch (IOException e) {
			// Ignore exception
		}
		resourceChangeListener = [
			val alisaFileChanged = new AtomicBoolean(false)
			val assureFileChanged = new AtomicBoolean(false)
			delta.accept [
				if (resource.fileExtension == ALISA_EXTENSION) {
					alisaFileChanged.set(true)
				} else if (resource.fileExtension == ASSURE_EXTENSION) {
					assureFileChanged.set(true)
				}
				true
			]
			resourceSetForUI.resources.forEach[unload]
			if (alisaFileChanged.get) {
				viewSite.workbenchWindow.workbench.display.asyncExec [
					val toRemove = selectedFilters.filter [ assuranceCase, filter |
						resourceSetForUI.getEObject(assuranceCase, true) === null ||
							resourceSetForUI.getEObject(filter, true) === null
					].keySet
					toRemove.forEach[selectedFilters.remove(it)]

					val expandedElements = alisaViewer.expandedElements
					alisaViewer.input = assuranceCaseURIsInWorkspace
					alisaViewer.expandedElements = expandedElements

					displayedCaseAndFilter = null -> null
					updateAssureViewer(alisaViewer.structuredSelection.firstElement as URI, true)
				]
			} else if (assureFileChanged.get) {
				viewSite.workbenchWindow.workbench.display.asyncExec [
					displayedCaseAndFilter = null -> null
					updateAssureViewer(alisaViewer.structuredSelection.firstElement as URI, false)
				]
			}
		]
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
				assureCoverageViewer = createAssureCoverageViewer(it, columnLayout)
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

		super.dispose
	}

	def private createAlisaViewer(Composite parent, TreeColumnLayout columnLayout) {
		new TreeViewer(parent, SWT.BORDER.bitwiseOr(SWT.H_SCROLL).bitwiseOr(SWT.V_SCROLL).bitwiseOr(SWT.SINGLE)) =>
			[ treeViewer |
				treeViewer.tree.headerVisible = true
				treeViewer.contentProvider = new ITreeContentProvider {
					override dispose() {
					}

					override getChildren(Object parentElement) {
						switch parentEObject : resourceSetForUI.getEObject(parentElement as URI, true) {
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
							default: false
						}
					}

					override inputChanged(Viewer viewer, Object oldInput, Object newInput) {
					}
				}
				new TreeViewerColumn(treeViewer, SWT.LEFT) => [
					columnLayout.setColumnData(column, new ColumnWeightData(1))
					column.text = "Assurance Cases"
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
								if (filter !== null) {
									(resourceSetForUI.getEObject(filter, true) as CategoryFilter).name
								} else {
									"<all>"
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
										} else {
											"<all>"
										}
									}
								}
								input = (#[Optional.empty] +
									rds.getExportedObjectsByType(CategoriesPackage.Literals.CATEGORY_FILTER).map [
										Optional.of(EObjectURI)
									]).toList
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
				treeViewer.addSelectionChangedListener [
					updateAssureViewer(treeViewer.structuredSelection.firstElement as URI, true)
				]
//
//				val manager = new MenuManager
//				manager.removeAllWhenShown = true
//				manager.addMenuListener [
//					val uri = treeViewer.structuredSelection.firstElement as URI
//					if (uri !== null) {
//						val eObject = resourceSetForUI.getEObject(uri, true)
//						if (eObject instanceof AssuranceCase) {
//							add(new Action("Verify All") {
//								override run() {
//									verifyAll(eObject, uri)
//								}
//							})
//							add(new Action("Verify TBD") {
//								override run() {
//									verifyTBD(eObject, uri)
//								}
//							})
//						}
//					}
//				]
//				treeViewer.control.menu = manager.createContextMenu(treeViewer.tree)
				treeViewer.input = assuranceCaseURIsInWorkspace
			]
	}

	def private createAssureCoverageViewer(Composite parent, TreeColumnLayout columnLayout) {
		new TreeViewer(parent, SWT.BORDER.bitwiseOr(SWT.H_SCROLL).bitwiseOr(SWT.V_SCROLL)) => [
			site.selectionProvider = it
			addFilter[ viewer, parentElement, element |
				switch resourceSetForUI.getEObject(element as URI, true) {
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
						switch eObject : resourceSetForUI.getEObject(element as URI, true) {
							AssuranceCaseResult: "Assurance case " + eObject.name
							ModelResult: "Assurance plan " + eObject.name
							SubsystemResult: "Subsystem verification " + eObject.name
							ClaimResult: "Claim " + eObject.name
							VerificationActivityResult: "Evidence " + eObject.name
							ValidationResult: "Validation " + eObject.name
							PreconditionResult: "Precondition " + eObject.name
							Diagnostic: "Issue " + (eObject.modelElement?.constructLabel ?: eObject.constructMessage)
							ElseResult: "else"
							ThenResult: "then"
							default: "?"
						}
					}

					override getImage(Object element) {
						val fileName = switch eObject : resourceSetForUI.getEObject(element as URI, true) {
							Result:
								switch eObject.resultType {
									case ERROR:  "error.png"
									case SUCCESS: "valid.png"
									case FAILURE: "invalid.png"
									case TBD: "info.png"
								}
							Diagnostic:
								switch eObject.diagnosticType {
									case ERROR: "invalid.png"
									case WARNING: "warning.png"
									case INFO: "info.png"
									case TBD: "questionmark.png"
								}
							AssuranceCaseResult:
								"assure.png"
							ClaimResult:
								"claim.png"
							VerificationActivityResult:
								"evidence.png"
							ValidationResult:
								"validation.png"
							PreconditionResult:
								"precondition.png"
							ModelResult:
								"precondition.png"
							SubsystemResult:
								"claims.png"
							PredicateResult:
								"precondition.png"
							default:
								"info.png"
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
						switch eObject : resourceSetForUI.getEObject(element as URI, true) {
							AssuranceCaseResult:
								eObject.cumulativeRequirementsWithoutPlanClaimCount + " of " +
									eObject.cumulativeRequirementsCount
							ModelResult,
							SubsystemResult: {
								val noPlan = eObject.metrics.requirementsWithoutPlanClaimCount
								val reqs = eObject.metrics.requirementsCount
								val cumulativeNoPlan = eObject.cumulativeRequirementsWithoutPlanClaimCount
								'''«noPlan» of «reqs» | Cume: «cumulativeNoPlan» of «eObject.cumulativeRequirementsCount»'''
							}
							Diagnostic:
								eObject.modelElement?.constructLabel ?: eObject.constructMessage
							ElseResult:
								"else"
							ThenResult:
								"then"
							default:
								"?"
						}
					}

					def int getCumulativeRequirementsWithoutPlanClaimCount(AssureResult ele) {
						val results = switch ele {
							AssuranceCaseResult: ele.modelResult
							ModelResult: ele.subsystemResult
							SubsystemResult: ele.subsystemResult
						}
						ele.metrics.requirementsWithoutPlanClaimCount + results.fold(0, [ sum, res |
							sum + res.cumulativeRequirementsWithoutPlanClaimCount
						])
					}

					def int getCumulativeRequirementsCount(AssureResult ele) {
						val results = switch ele {
							AssuranceCaseResult: ele.modelResult
							ModelResult: ele.subsystemResult
							SubsystemResult: ele.subsystemResult
						}
						ele.metrics.requirementsCount + results.fold(0, [ sum, res |
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
						switch eObject : resourceSetForUI.getEObject(element as URI, true) {
							AssuranceCaseResult:
								format.format(eObject.cumulativeQualityCategoryRequirementsCount as double /
									eObject.cumulativeTotalQualityCategorysCount)
							ModelResult,
							SubsystemResult: {
								val qualityReqs = eObject.metrics.qualityCategoryRequirementsCount
								val totalQuality = eObject.metrics.totalQualityCategoryCount
								val percent = format.format(
									eObject.cumulativeQualityCategoryRequirementsCount as double /
										eObject.cumulativeTotalQualityCategorysCount)
										'''«qualityReqs» of «totalQuality» | Cume: «percent»'''
									}
									Diagnostic:
										eObject.modelElement?.constructLabel ?: eObject.constructMessage
									ElseResult:
										"else"
									ThenResult:
										"then"
									default:
										"?"
								}
							}

							def int getCumulativeQualityCategoryRequirementsCount(AssureResult ele) {
								val results = switch ele {
									AssuranceCaseResult: ele.modelResult
									ModelResult: ele.subsystemResult
									SubsystemResult: ele.subsystemResult
								}
								ele.metrics.qualityCategoryRequirementsCount + results.fold(0, [ sum, res |
									sum + res.cumulativeQualityCategoryRequirementsCount
								])
							}

							def int getCumulativeTotalQualityCategorysCount(AssureResult ele) {
								val results = switch ele {
									AssuranceCaseResult: ele.modelResult
									ModelResult: ele.subsystemResult
									SubsystemResult: ele.subsystemResult
								}
								ele.metrics.totalQualityCategoryCount + results.fold(0, [ sum, res |
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
								switch eObject : resourceSetForUI.getEObject(element as URI, true) {
									AssuranceCaseResult:
										eObject.cumulativeFeaturesRequirementsCount + " for " +
											eObject.cumulativeFeaturesCount
									ModelResult,
									SubsystemResult: {
										val featuresReqs = eObject.metrics.featuresRequirementsCount
										val features = eObject.metrics.featuresCount
										val cumulativeFeaturesReqs = eObject.cumulativeFeaturesRequirementsCount
										val cumulativeFeatures = eObject.cumulativeFeaturesCount
										'''«featuresReqs» for «features» | Cume: «cumulativeFeaturesReqs» for «cumulativeFeatures»'''
									}
									Diagnostic:
										eObject.modelElement?.constructLabel ?: eObject.constructMessage
									ElseResult:
										"else"
									ThenResult:
										"then"
									default:
										"?"
								}
							}

							def int getCumulativeFeaturesRequirementsCount(AssureResult ele) {
								val results = switch ele {
									AssuranceCaseResult: ele.modelResult
									ModelResult: ele.subsystemResult
									SubsystemResult: ele.subsystemResult
								}
								ele.metrics.featuresRequirementsCount + results.fold(0, [ sum, res |
									sum + res.cumulativeFeaturesRequirementsCount
								])
							}

							def int getCumulativeFeaturesCount(AssureResult ele) {
								val results = switch ele {
									AssuranceCaseResult: ele.modelResult
									ModelResult: ele.subsystemResult
									SubsystemResult: ele.subsystemResult
								}
								ele.metrics.featuresCount +
									results.fold(0, [sum, res|sum + res.cumulativeFeaturesCount])
							}
						}
					]
					new TreeViewerColumn(it, SWT.RIGHT) => [
						column.alignment = SWT.LEFT
						column.text = "No Verify Plans"
						columnLayout.setColumnData(column, new ColumnPixelData(120))
						labelProvider = new ColumnLabelProvider {
							override getText(Object element) {
								switch eObject : resourceSetForUI.getEObject(element as URI, true) {
									AssuranceCaseResult: eObject.cumulativeNoVerificationPlansCount.toString
									ModelResult,
									SubsystemResult: eObject.metrics.noVerificationPlansCount + " | Cume: " +
										eObject.cumulativeNoVerificationPlansCount
									Diagnostic: eObject.modelElement?.constructLabel ?: eObject.constructMessage
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
								ele.metrics.noVerificationPlansCount + results.fold(0, [ sum, res |
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
								switch eObject : resourceSetForUI.getEObject(element as URI, true) {
									AssuranceCaseResult:
										eObject.cumulativeExceptionsCount + " of " + eObject.cumulativeRequirementsCount
									ModelResult,
									SubsystemResult: {
										val exceptions = eObject.metrics.exceptionsCount
										val reqs = eObject.metrics.requirementsCount
										val cumulativeExceptions = eObject.cumulativeExceptionsCount
										val cumulativeReqs = eObject.cumulativeRequirementsCount
										'''«exceptions» of «reqs» | Cume: «cumulativeExceptions» of «cumulativeReqs»'''
									}
									default:
										"?"
								}
							}

							def int getCumulativeExceptionsCount(AssureResult ele) {
								val results = switch ele {
									AssuranceCaseResult: ele.modelResult
									ModelResult: ele.subsystemResult
									SubsystemResult: ele.subsystemResult
								}
								ele.metrics.exceptionsCount + results.fold(0, [ sum, res |
									sum + res.cumulativeExceptionsCount
								])
							}

							def int getCumulativeRequirementsCount(AssureResult ele) {
								val results = switch ele {
									AssuranceCaseResult: ele.modelResult
									ModelResult: ele.subsystemResult
									SubsystemResult: ele.subsystemResult
								}
								ele.metrics.requirementsCount + results.fold(0, [ sum, res |
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
								switch eObject : resourceSetForUI.getEObject(element as URI, true) {
									AssuranceCaseResult:
										eObject.cumulativeReqTargetHasEMV2SubclauseCount + " of " +
											eObject.cumulativeRequirementsCount
									ModelResult,
									SubsystemResult: {
										val cumulativeSubclauses = eObject.cumulativeReqTargetHasEMV2SubclauseCount
										val reqs = eObject.metrics.requirementsCount
										val cumulativeReqs = eObject.cumulativeRequirementsCount
										'''«cumulativeSubclauses» of «reqs» | Cume: «cumulativeSubclauses» of «cumulativeReqs»'''
									}
									default:
										"?"
								}
							}

							def int getCumulativeReqTargetHasEMV2SubclauseCount(AssureResult ele) {
								val results = switch ele {
									AssuranceCaseResult: ele.modelResult
									ModelResult: ele.subsystemResult
									SubsystemResult: ele.subsystemResult
								}
								ele.metrics.reqTargetHasEMV2SubclauseCount + results.fold(0, [ sum, res |
									sum + res.cumulativeReqTargetHasEMV2SubclauseCount
								])
							}

							def int getCumulativeRequirementsCount(AssureResult ele) {
								val results = switch ele {
									AssuranceCaseResult: ele.modelResult
									ModelResult: ele.subsystemResult
									SubsystemResult: ele.subsystemResult
								}
								ele.metrics.requirementsCount + results.fold(0, [ sum, res |
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
								switch eObject : resourceSetForUI.getEObject(element as URI, true) {
									AssuranceCaseResult: {
										val cumulativeFeaturesWith = eObject.
											cumulativeFeaturesWithRequiredClassifierCount
										val cumulativeFeaturesRequiring = eObject.
											cumulativeFeaturesRequiringClassifierCount
										cumulativeFeaturesWith + " of " + cumulativeFeaturesRequiring
									}
									ModelResult,
									SubsystemResult: {
										val featuresWith = eObject.metrics.featuresWithRequiredClassifierCount
										val featuresRequiring = eObject.metrics.featuresRequiringClassifierCount
										val cumulativeFeaturesWith = eObject.
											cumulativeFeaturesWithRequiredClassifierCount
										val cumulativeFeaturesRequiring = eObject.
											cumulativeFeaturesRequiringClassifierCount
										'''«featuresWith» of «featuresRequiring» | Cume: «cumulativeFeaturesWith» of «cumulativeFeaturesRequiring»'''
									}
									default:
										"?"
								}
							}

							def int getCumulativeFeaturesWithRequiredClassifierCount(AssureResult ele) {
								val results = switch ele {
									AssuranceCaseResult: ele.modelResult
									ModelResult: ele.subsystemResult
									SubsystemResult: ele.subsystemResult
								}
								ele.metrics.featuresWithRequiredClassifierCount + results.fold(0, [ sum, res |
									sum + res.cumulativeFeaturesWithRequiredClassifierCount
								])
							}

							def int getCumulativeFeaturesRequiringClassifierCount(AssureResult ele) {
								val results = switch ele {
									AssuranceCaseResult: ele.modelResult
									ModelResult: ele.subsystemResult
									SubsystemResult: ele.subsystemResult
								}
								ele.metrics.featuresRequiringClassifierCount + results.fold(0, [ sum, res |
									sum + res.cumulativeFeaturesRequiringClassifierCount
								])
							}
						}
					]
					contentProvider = new ITreeContentProvider {
						override dispose() {
						}

						override getChildren(Object parentElement) {
							resourceSetForUI.getEObject(parentElement as URI, true).eContents.map[URI]
						}

						override getElements(Object inputElement) {
							inputElement as List<URI>
						}

						override getParent(Object element) {
							resourceSetForUI.getEObject(element as URI, true).eContainer?.URI ?: it.input
						}

						override hasChildren(Object element) {
							!resourceSetForUI.getEObject(element as URI, true).eContents.empty
						}

						override inputChanged(Viewer viewer, Object oldInput, Object newInput) {
						}
					}
					tree.headerVisible = true
					tree.linesVisible = true
				]

//			val manager = new MenuManager
//			manager.removeAllWhenShown = true
//			manager.addMenuListener [
//				val uri = treeViewer.structuredSelection.firstElement as URI
//				if (uri !== null) {
//					val eObject = resourceSetForUI.getEObject(uri, true)
//					if (eObject instanceof ClaimResult) {
//						val requirementURI = eObject.target.URI
//						add(new Action("Open Requirement") {
//							override run() {
//								editorOpener.open(requirementURI, true)
//							}
//						})
//						val descriptionText = new StringSelection(eObject.constructDescription)
//						add(new Action("Copy Claim Text") {
//							override run() {
//								Toolkit.defaultToolkit.systemClipboard.setContents(descriptionText, null)
//							}
//						})
//					}
//				}
//			]
//			treeViewer.control.menu = manager.createContextMenu(treeViewer.tree)
			}

			def private getAssuranceCaseURIsInWorkspace() {
				rds.getExportedObjectsByType(AlisaPackage.Literals.ASSURANCE_CASE).map[EObjectURI].toList
			}

			def private updateAssureViewer(URI assuranceCaseURI, boolean updateRequirementsCoverageView) {
				val newURIs = assuranceCaseURI -> selectedFilters.get(assuranceCaseURI)
				if (displayedCaseAndFilter != newURIs) {
					displayedCaseAndFilter = newURIs

					val selectedAlisaObject = resourceSetForUI.getEObject(assuranceCaseURI, true)
					var result = if (assuranceCaseURI !== null) {
							if (selectedAlisaObject instanceof AssuranceCase) {
								val resultDescriptions = rds.getExportedObjectsByType(
									AssurePackage.Literals.ASSURANCE_CASE_RESULT)
								val results = resultDescriptions.map [
									resourceSetForUI.getEObject(EObjectURI, true) as AssuranceCaseResult
								]
								results.findFirst[name == selectedAlisaObject.name]
							}
						}
					val filter = if (result !== null && displayedCaseAndFilter.value !== null) {
							resourceSetForUI.getEObject(displayedCaseAndFilter.value, true) as CategoryFilter
						}
					if (result === null) {
						if (selectedAlisaObject instanceof AssuranceCase) {
							result = computeCoverage(selectedAlisaObject, assuranceCaseURI, filter)
						}
					}

					setAssuranceCaseResult(result, filter)
				}
			}

			def private createAndComputeCoverage(AssuranceCase assuranceCase, URI assuranceCaseURI,
				(ResourceSet)=>Pair<IProject, AssuranceCaseResult> getProjectAndResult, CategoryFilter filter) {
				val dirtyEditors = viewSite.page.dirtyEditors
				if (!dirtyEditors.empty) {
					val monitor = new NullProgressMonitor
					dirtyEditors.forEach[doSave(monitor)]
				}
				val resourceSetForProcessing = resourceSetProvider.get(null)
				val assureProjectAndResult = getProjectAndResult.apply(resourceSetForProcessing)
				val assuranceCaseResult = assureProjectAndResult.value
				assureRequirementMetricsProcessor.processCase(assuranceCaseResult, filter, null)
				assuranceCaseResult
			}

			def private computeCoverage(AssuranceCase assuranceCase, URI assuranceCaseURI, CategoryFilter filter) {
				createAndComputeCoverage(assuranceCase, assuranceCaseURI, [ resourceSetForProcessing |
					createCaseResult(assuranceCase, assuranceCaseURI, resourceSetForProcessing)
				], filter)
			}

			def private createCaseResult(AssuranceCase assuranceCase, URI assuranceCaseURI,
				ResourceSet resourceSetForProcessing) {
				val assureProject = ResourcesPlugin.workspace.root.getFile(
					new Path(assuranceCaseURI.toPlatformString(true))).project
				val assureURI = URI.
					createPlatformResourceURI('''«assureProject.fullPath»/assure/«assuranceCase.name».assure''', false)
				val assuranceCaseResultHolder = new AtomicReference
//				val domain = TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain(
//					"org.osate.aadl2.ModelEditingDomain")
//				domain.commandStack.execute(new RecordingCommand(domain) {
//					override protected doExecute() {
						val assuranceCaseResult = assureConstructor.generateFullAssuranceCase(assuranceCase)
						assuranceCaseResult.resetToTBD(null)
						assuranceCaseResult.recomputeAllCounts(null)
						val resource = resourceSetForProcessing.getResource(assureURI, false) ?:
							resourceSetForProcessing.createResource(assureURI)
						resource.contents.clear
						resource.contents += assuranceCaseResult
						try {
							resource.save(null)
						} catch (IOException e) {
							// Do nothing.
						}
						assuranceCaseResultHolder.set(assuranceCaseResult)
//					}
//				})
				assureProject -> assuranceCaseResultHolder.get
			}

			def package void setAssuranceCaseResult(AssuranceCaseResult assuranceCaseResult, CategoryFilter filter) {
				val expandedElements = assureCoverageViewer.expandedElements
				assureRequirementMetricsProcessor.processCase(assuranceCaseResult, filter, null)
				assureCoverageViewer.input = #[assuranceCaseResult.URI]
				assureCoverageViewer.expandedElements = expandedElements
			}

		}
		