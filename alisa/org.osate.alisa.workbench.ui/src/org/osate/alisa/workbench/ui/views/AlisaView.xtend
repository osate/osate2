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
import java.util.Collections
import java.util.List
import java.util.Optional
import java.util.concurrent.atomic.AtomicBoolean
import java.util.concurrent.atomic.AtomicReference
import org.eclipse.core.resources.IResourceChangeEvent
import org.eclipse.core.resources.IResourceChangeListener
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.core.resources.WorkspaceJob
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.core.runtime.Path
import org.eclipse.core.runtime.Status
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.ecore.util.EcoreUtil
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
import org.eclipse.xtext.EcoreUtil2
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
import org.osate.assure.assure.VerificationResult
import org.osate.assure.evaluator.IAssureProcessor
import org.osate.assure.generator.IAssureConstructor
import org.osate.assure.util.AssureUtilExtension
import org.osate.categories.categories.CategoriesPackage
import org.osate.categories.categories.CategoryFilter
import org.osate.result.AnalysisResult
import org.osate.result.BooleanValue
import org.osate.result.Diagnostic
import org.osate.result.DiagnosticType
import org.osate.result.EObjectValue
import org.osate.result.IntegerValue
import org.osate.result.ObjectValue
import org.osate.result.RealValue
import org.osate.result.Result
import org.osate.result.ResultType
import org.osate.result.StringValue
import org.osate.result.Value
import org.osate.verify.util.VerifyUtilExtension

import static extension org.eclipse.emf.ecore.util.EcoreUtil.getURI
import static extension org.osate.assure.util.AssureUtilExtension.*
import org.osate.aadl2.NamedElement

class AlisaView extends ViewPart {
	val static ASSURANCE_CASE_URIS_KEY = "ASSURANCE_CASE_URIS_KEY"
	val static FILTER_URIS_KEY = "FILTER_URIS_KEY"
	val static ALISA_EXTENSION = "alisa"
	val static ASSURE_EXTENSION = "xassure"

	val IResourceSetProvider resourceSetProvider
	val ResourceSet resourceSetForUI
	val IResourceDescriptions rds
	val GlobalURIEditorOpener editorOpener
	val IAssureConstructor assureConstructor
	val IAssureProcessor assureProcessor
	val String settingsFileName
	val IDialogSettings dialogSettings

	// Map is from AssuranceCase to CategoryFilter
	val selectedFilters = <URI, URI>newHashMap
	Pair<URI, URI> displayedCaseAndFilter = null -> null

	val CategoryFilter selectedFilter = null

	TreeViewer alisaViewer
	TreeViewer assureViewer

	Color greenColor
	Color yellowColor
	Color orangeColor
	Color blueColor
	Color redColor

	val IResourceChangeListener resourceChangeListener
	
	var didGenerateAssure = false

	@Inject
	new(IResourceSetProvider resourceSetProvider, IResourceDescriptions rds, GlobalURIEditorOpener editorOpener,
		IAssureConstructor assureConstructor, IAssureProcessor assureProcessor) {
		this.resourceSetProvider = resourceSetProvider
		resourceSetForUI = resourceSetProvider.get(null)
		this.rds = rds
		this.editorOpener = editorOpener
		this.assureConstructor = assureConstructor
		this.assureProcessor = assureProcessor
		val pluginsDir = Activator.^default.stateLocation.removeLastSegments(1)
		settingsFileName = pluginsDir.append("org.osate.alisa.workbench.ui").append("alisa_view_settings.xml").toOSString
		dialogSettings = new DialogSettings("alisa_view_settings")
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
		greenColor = new Color(viewSite.workbenchWindow.workbench.display, 0, 153, 0) // 171, 221, 164)
		yellowColor = new Color(viewSite.workbenchWindow.workbench.display, 255, 255, 191)
		orangeColor = new Color(viewSite.workbenchWindow.workbench.display, 255, 128, 0) // 253, 174, 97)
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

				val manager = new MenuManager
				manager.removeAllWhenShown = true
				manager.addMenuListener [
					val uri = treeViewer.structuredSelection.firstElement as URI
					if (uri !== null) {
						val eObject = resourceSetForUI.getEObject(uri, true)
						if (eObject instanceof AssuranceCase) {
							add(new Action("Verify All") {
								override run() {
									verifyAll(eObject, uri)
								}
							})
							add(new Action("Verify Remaining") {
								override run() {
									verifyTBD(eObject, uri)
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
		new TreeViewer(parent, SWT.BORDER.bitwiseOr(SWT.H_SCROLL).bitwiseOr(SWT.V_SCROLL)) => [ treeViewer |
			treeViewer.tree.headerVisible = true
			ColumnViewerToolTipSupport.enableFor(treeViewer)
			treeViewer.contentProvider = new ITreeContentProvider {
				override dispose() {
				}

				override getChildren(Object parentElement) {
					val eo = resourceSetForUI.getEObject(parentElement as URI, true)
					if (eo instanceof VerificationResult && !(eo as VerificationResult).analysisresult.empty){
						(eo as VerificationResult).analysisresult.map[URI] //+ eo.eContents.map[URI]
					} else {
						eo.eContents.map[URI]
					}
				}

				override getElements(Object inputElement) {
					inputElement as List<URI>
				}

				override getParent(Object element) {
					resourceSetForUI.getEObject(element as URI, true)?.eContainer?.URI ?: treeViewer.input
				}

				override hasChildren(Object element) {
					val eo = resourceSetForUI.getEObject(element as URI, true)
					if (eo instanceof VerificationResult ){
						!(eo as VerificationResult).analysisresult.empty
					}
					!(eo?.eContents ?: Collections.EMPTY_LIST as EList<EObject>).empty
				}

				override inputChanged(Viewer viewer, Object oldInput, Object newInput) {
				}
			}
			treeViewer.addFilter [ viewer, parentElement, element |
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
						if(!(element instanceof URI)) return "??"
						switch eObject : resourceSetForUI.getEObject(element as URI, true) {
							AssuranceCaseResult:
								"Case " + eObject.name
							ModelResult: '''Plan «eObject.plan.name»(«eObject.target.name»)'''
							SubsystemResult: {
								val label = eObject.targetSystem.category.getName 
								label.substring(0, 1).toUpperCase() + label.substring(1) +" "+ eObject.name
								}
							ClaimResult:
								"Claim " + eObject.name
							VerificationActivityResult:
								"Evidence " + eObject.name
							ValidationResult:
								"Validation " + eObject.name
							PreconditionResult:
								"Precondition " + eObject.name
							AnalysisResult: {
								 eObject.analysis +" analysis: "+ (eObject.modelElement as NamedElement).name
							}
							Result: {
								if (eObject.resultType == ResultType.TBD){
									"Result: "+ (eObject.modelElement?.constructLabel ?: "" ) 
								} else {
									eObject.resultType.getName.toLowerCase.toFirstUpper +": "+ (eObject.modelElement?.constructLabel ?: "" ) 
								}
							}
								
							Diagnostic:
								eObject.diagnosticType.getName.toLowerCase.toFirstUpper +" "+ (eObject.modelElement?.constructLabel ?: "" ) 
							ElseResult:
								"else"
							ThenResult:
								"then"
							PredicateResult:
								"Predicate"
							RealValue:
								"Value: "+eObject.value
							IntegerValue:
								"Value: "+eObject.value
							StringValue:
								"Value: "+eObject.value
							BooleanValue:
								"Value: "+eObject.value
							EObjectValue:
								"Value: "+eObject.value
							ObjectValue:
								"Value: "+eObject.value
							default:
								"?"
						}
					}

					override getToolTipText(Object element) {
						val eObject = resourceSetForUI.getEObject(element as URI, true)
						if (eObject instanceof ClaimResult) {
							eObject.constructMessage
						}
					}

					override getImage(Object element) {
						val imageFileName = switch eObject : resourceSetForUI.getEObject(element as URI, true) {
							Value: "info.png"
							AnalysisResult:
								switch eObject.resultType {
									case ERROR:  "error.png"
									case SUCCESS: "valid.png"
									case FAILURE: "invalid.png"
									case TBD: "info.png"
								}
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
							AssureResult case eObject.successful:
								"valid.png"
							AssureResult case eObject.fail:
								"invalid.png"
							AssureResult case eObject.error:
								"error.png"
							AssureResult case eObject.zeroCount:
								"info.png"
							default:
								"questionmark.png"
						}
						if (imageFileName !== null) {
							ImageDescriptor.createFromFile(class, "/icons/" + imageFileName).createImage
						}
					}
				}
			]
			new TreeViewerColumn(treeViewer, SWT.RIGHT) => [
				column.alignment = SWT.LEFT
				column.text = "Pass"
				columnLayout.setColumnData(column, new ColumnWeightData(1, 24))
				labelProvider = new ColumnLabelProvider {
					override getText(Object element) {
						switch eObject : resourceSetForUI.getEObject(element as URI, true) {
							AssureResult: eObject.successToString
						}
					}

					override getForeground(Object element) {
						greenColor
					}
				}
			]
			new TreeViewerColumn(treeViewer, SWT.RIGHT) => [
				column.alignment = SWT.LEFT
				column.text = "Fail"
				columnLayout.setColumnData(column, new ColumnWeightData(1, 24))
				labelProvider = new ColumnLabelProvider {
					override getText(Object element) {
						switch eObject : resourceSetForUI.getEObject(element as URI, true) {
							AssureResult: eObject.failToString
						}
					}

					override getForeground(Object element) {
						redColor
					}
				}
			]
			new TreeViewerColumn(treeViewer, SWT.RIGHT) => [
				column.alignment = SWT.LEFT
				column.text = "Error"
				columnLayout.setColumnData(column, new ColumnWeightData(1, 24))
				labelProvider = new ColumnLabelProvider {
					override getText(Object element) {
						switch eObject : resourceSetForUI.getEObject(element as URI, true) {
							AssureResult: eObject.errorToString
						}
					}

					override getForeground(Object element) {
						orangeColor
					}
				}
			]
			new TreeViewerColumn(treeViewer, SWT.RIGHT) => [
				column.alignment = SWT.LEFT
				column.text = "Todo"
				columnLayout.setColumnData(column, new ColumnWeightData(1, 24))
				labelProvider = new ColumnLabelProvider {
					override getText(Object element) {
						switch eObject : resourceSetForUI.getEObject(element as URI, true) {
							AssureResult: eObject.tbdToString
						}
					}

					override getForeground(Object element) {
						blueColor
					}
				}
			]

			new TreeViewerColumn(treeViewer, SWT.RIGHT) => [
				column.alignment = SWT.LEFT
				column.text = "Description"
				columnLayout.setColumnData(column, new ColumnWeightData(9))
				labelProvider = new ColumnLabelProvider {
					override getText(Object element) {
						switch eObject : resourceSetForUI.getEObject(element as URI, true) {
							ClaimResult: eObject.constructMessage
							VerificationActivityResult: eObject.constructMessage
							AssuranceCaseResult: eObject.constructMessage
							ModelResult: eObject.constructMessage
							SubsystemResult: eObject.constructMessage
							Diagnostic: eObject.constructMessage
							ElseResult: "else"
							ThenResult: "then"
							PredicateResult: eObject.constructMessage
							Result: eObject.constructMessage
							AnalysisResult: eObject.constructMessage
						}
					}
				}
			]

			val manager = new MenuManager
			manager.removeAllWhenShown = true
			manager.addMenuListener [
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
			]
			treeViewer.control.menu = manager.createContextMenu(treeViewer.tree)
		]
	}

	def private getAssuranceCaseURIsInWorkspace() {
		rds.getExportedObjectsByType(AlisaPackage.Literals.ASSURANCE_CASE).map[EObjectURI].toList
	}

	def private updateAssureViewer(URI assuranceCaseURI, boolean updateAssuranceView) {
		val newURIs = assuranceCaseURI -> selectedFilters.get(assuranceCaseURI)
		if (displayedCaseAndFilter != newURIs) {
			displayedCaseAndFilter = newURIs

			val result = if (assuranceCaseURI !== null) {
					val selectedAlisaObject = resourceSetForUI.getEObject(assuranceCaseURI, true)
					if (selectedAlisaObject instanceof AssuranceCase) {
						val AssuranceCaseResultURI = assuranceCaseURI.trimFileExtension.trimSegments(assuranceCaseURI.segmentCount-2).
						appendSegment("assure").appendSegment(selectedAlisaObject.name).appendFileExtension(ASSURE_EXTENSION)
						try {
							resourceSetForUI.getEObject(AssuranceCaseResultURI, true) as AssuranceCaseResult
						} catch (Exception e){
							null
						}
					}
				}
			if (result === null ) return
			val expandedElements = assureViewer.expandedElements
			val resourceSetForProcessing = resourceSetProvider.get(null)
			val filterURI = selectedFilters.get(assuranceCaseURI)
			val filter = if (filterURI !== null) {
				resourceSetForProcessing.getEObject(filterURI, true) as CategoryFilter
			}
			result.recomputeAllCounts(filter)
			if (updateAssuranceView || didGenerateAssure) {
				assureViewer.input = if (result !== null) {
					didGenerateAssure = false
					#[result.URI]
				}
			} else {
				updateAllAssureResult(result)
			}
			assureViewer.expandedElements = expandedElements
		}
	}

	private def void updateAllAssureResult(AssuranceCaseResult caseResult) {
		EcoreUtil2.eAllOfType(caseResult, AssureResult).forEach[ao|update(ao.URI)]
	}

	def private verifyAll(AssuranceCase assuranceCase, URI assuranceCaseURI) {
		verifyCommon(assuranceCase, assuranceCaseURI, true)
	}

	def private verifyTBD(AssuranceCase assuranceCase, URI assuranceCaseURI) {
		verifyCommon(assuranceCase, assuranceCaseURI, false)
	}

	def private verifyCommon(AssuranceCase assuranceCase, URI assuranceCaseURI, boolean doAll) {
		val dirtyEditors = viewSite.page.dirtyEditors
		if (!dirtyEditors.empty &&
			MessageDialog.openConfirm(viewSite.shell, "Save editors", "Save editors and continue?")) {
			val monitor = new NullProgressMonitor
			dirtyEditors.forEach[doSave(monitor)]
		}
		val resourceSetForProcessing = resourceSetProvider.get(null)
		val filterURI = selectedFilters.get(assuranceCaseURI)
		val filter = if (filterURI !== null) {
				resourceSetForProcessing.getEObject(filterURI, true) as CategoryFilter
		}
		val resultDescriptions = rds.getExportedObjectsByType(AssurePackage.Literals.ASSURANCE_CASE_RESULT)
		val results = resultDescriptions.map [
			resourceSetForProcessing.getEObject(EObjectURI, true) as AssuranceCaseResult
		]
		var findResult = results.findFirst[name == assuranceCase.name]
		if (findResult === null) {
			findResult = createCaseResult(assuranceCase, assuranceCaseURI, resourceSetForProcessing, filter)
		}
		val assuranceCaseResult = findResult
		val job = new WorkspaceJob("ASSURE verification") {
			override runInWorkspace(IProgressMonitor monitor) throws CoreException {
				VerifyUtilExtension.clearAllHasRunRecords
				AssureUtilExtension.clearAllInstanceModels
				try {
					assureProcessor.processCase(assuranceCaseResult, filter, monitor,true)
					Status.OK_STATUS
				} catch (NoSuchMethodException e) {
					Status.CANCEL_STATUS
				}
			}
		}
		job.rule = null
		job.schedule
	}

	def private createCaseResult(AssuranceCase assuranceCase, URI assuranceCaseURI,
		ResourceSet resourceSetForProcessing, CategoryFilter filter) {
		val assureProject = ResourcesPlugin.workspace.root.getFile(new Path(assuranceCaseURI.toPlatformString(true))).
			project
		val assureURI = URI.createPlatformResourceURI('''«assureProject.fullPath»/assure/«assuranceCase.name».xassure''',
			false)
		val assuranceCaseResultHolder = new AtomicReference
		val domain = TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain("org.osate.aadl2.ModelEditingDomain")
		domain.commandStack.execute(new RecordingCommand(domain) {
			override protected doExecute() {
				val assuranceCaseResult = assureConstructor.generateFullAssuranceCase(assuranceCase)
				didGenerateAssure = true
				assuranceCaseResult.resetToTBD(filter)
				assuranceCaseResult.recomputeAllCounts(filter)
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
			}
		})
		assuranceCaseResultHolder.get
	}

	def package void update(URI verificationResultURI) {
		assureViewer.refresh(verificationResultURI, true)
	}

}
