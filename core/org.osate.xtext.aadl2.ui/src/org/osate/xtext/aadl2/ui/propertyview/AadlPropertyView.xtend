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
package org.osate.xtext.aadl2.ui.propertyview

import com.google.inject.Inject
import java.util.ArrayDeque
import java.util.ArrayList
import java.util.Collections
import java.util.List
import java.util.Map
import java.util.Set
import org.eclipse.core.runtime.Adapters
import org.eclipse.core.runtime.Status
import org.eclipse.core.runtime.jobs.Job
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain
import org.eclipse.emf.edit.domain.EditingDomain
import org.eclipse.emf.transaction.RecordingCommand
import org.eclipse.emf.transaction.RunnableWithResult
import org.eclipse.emf.transaction.TransactionalEditingDomain
import org.eclipse.emf.transaction.util.TransactionUtil
import org.eclipse.jface.action.Action
import org.eclipse.jface.action.GroupMarker
import org.eclipse.jface.action.IAction
import org.eclipse.jface.action.MenuManager
import org.eclipse.jface.layout.TreeColumnLayout
import org.eclipse.jface.text.ITextSelection
import org.eclipse.jface.viewers.ColumnLabelProvider
import org.eclipse.jface.viewers.ColumnPixelData
import org.eclipse.jface.viewers.ColumnWeightData
import org.eclipse.jface.viewers.IPostSelectionProvider
import org.eclipse.jface.viewers.ISelection
import org.eclipse.jface.viewers.ISelectionChangedListener
import org.eclipse.jface.viewers.IStructuredSelection
import org.eclipse.jface.viewers.ITreeContentProvider
import org.eclipse.jface.viewers.StructuredSelection
import org.eclipse.jface.viewers.TreeViewer
import org.eclipse.jface.viewers.TreeViewerColumn
import org.eclipse.jface.viewers.Viewer
import org.eclipse.jface.window.Window
import org.eclipse.swt.SWT
import org.eclipse.swt.graphics.GC
import org.eclipse.swt.layout.GridData
import org.eclipse.swt.layout.GridLayout
import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.widgets.Label
import org.eclipse.ui.IPartListener
import org.eclipse.ui.ISelectionListener
import org.eclipse.ui.IWorkbenchActionConstants
import org.eclipse.ui.IWorkbenchPart
import org.eclipse.ui.dialogs.FilteredTree
import org.eclipse.ui.dialogs.PatternFilter
import org.eclipse.ui.part.PageBook
import org.eclipse.ui.part.ViewPart
import org.eclipse.xtext.resource.EObjectAtOffsetHelper
import org.eclipse.xtext.resource.SaveOptions
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.scoping.IScopeProvider
import org.eclipse.xtext.serializer.ISerializer
import org.eclipse.xtext.ui.editor.IURIEditorOpener
import org.eclipse.xtext.ui.editor.XtextEditor
import org.eclipse.xtext.ui.editor.model.IXtextDocument
import org.eclipse.xtext.ui.editor.model.IXtextModelListener
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode
import org.eclipse.xtext.util.concurrent.IUnitOfWork
import org.osate.aadl2.Aadl2Factory
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.BasicProperty
import org.osate.aadl2.BasicPropertyAssociation
import org.osate.aadl2.BehavioralFeature
import org.osate.aadl2.Classifier
import org.osate.aadl2.ContainedNamedElement
import org.osate.aadl2.ContainmentPathElement
import org.osate.aadl2.Element
import org.osate.aadl2.Feature
import org.osate.aadl2.ListValue
import org.osate.aadl2.ModalPath
import org.osate.aadl2.ModalPropertyValue
import org.osate.aadl2.ModeFeature
import org.osate.aadl2.ModelUnit
import org.osate.aadl2.NamedElement
import org.osate.aadl2.PackageSection
import org.osate.aadl2.Property
import org.osate.aadl2.PropertyAssociation
import org.osate.aadl2.PropertyConstant
import org.osate.aadl2.PropertyExpression
import org.osate.aadl2.PropertySet
import org.osate.aadl2.PropertyType
import org.osate.aadl2.Prototype
import org.osate.aadl2.RangeValue
import org.osate.aadl2.RecordValue
import org.osate.aadl2.RefinableElement
import org.osate.aadl2.Subcomponent
import org.osate.aadl2.instance.PropertyAssociationInstance
import org.osate.aadl2.modelsupport.EObjectURIWrapper
import org.osate.xtext.aadl2.serializer.InstanceEnabledSerializerBinding
import org.osate.xtext.aadl2.ui.MyAadl2Activator

import static extension org.eclipse.emf.ecore.util.EcoreUtil.getURI
import static extension org.eclipse.xtext.EcoreUtil2.getContainerOfType
import static extension org.osate.aadl2.modelsupport.util.AadlUtil.isSameOrRefines

/**
 * View that displays the AADL property value associations within a given AADL
 * model element.
 */
class AadlPropertyView extends ViewPart {
	val static HIDE_UNDEFINED_TOOL_TIP = "Hide undefined properties"
	val static SHOW_UNDEFINED_TOOL_TIP = "Show undefined properties"
	val static COLLAPSE_ALL_TOOL_TIP = "Collapse All"
	val static SHOW_ONLY_IMPORTED_PROPERTIES = "Show imported properties only"
	val static SHOW_ALL_AVAILABLE_PROPERTIES = "Show all available properties"
	val static HIDE_DEFAULT_TOOL_TIP = "Hide default property values"
	val static SHOW_DEFAULT_TOOL_TIP = "Show default property values"
	
	val static NO_PROPERTIES_TO_SHOW = "No properties to show: Please select a single AADL element that can have properties."
	val static POPULATING_VIEW = "Populating AADL Property Values view."

	/**
	 * Page book for switching between the tree viewer and the "no properties"
	 * message.
	 */
	var PageBook pageBook = null

	/**
	 * Tree for displaying properties. Underlying model is a
	 * {@link List} of {@link PropertySet} objects.
	 */
	var package TreeViewer treeViewer = null

	var Composite treeViewerComposite = null

	/**
	 * The label for the no results message.
	 */
	var Label noPropertiesLabel = null

	var Label populatingViewLabel = null

	/**
	 * Action for toggling the display of nonexistent properties
	 */
	var package Action showUndefinedAction = null

	var package Action showDefaultAction = null

	var Action removeElementAction = null

	var Action openDefinitionAction = null

	var Action openPropertyAssociationAction = null

	var Action makeLocalAction = null

	var Action makeLocalContainedAction = null

	var Action createLocalAssociationAction = null

	var package nextEditIsLocalCreation = false

	var Action createLocalContainedAssociationAction = null

	var package nextEditIsLocalContainedCreation = false

	var Action showOnlyImportedPropertiesAction;
	/**
	 * The editing domain for the viewer's input
	 */
	var EditingDomain editingDomain = null

	var package IXtextDocument xtextDocument = null

	var package Resource resourceFromSelection;
	
	/* Only show properties from this group (or all properties if empty) */
	var ArrayList<FilterCriterion> currentPropertyGroup = new ArrayList<FilterCriterion>

	@Inject
	@InstanceEnabledSerializerBinding
	var package ISerializer serializer

	@Inject
	var IScopeProvider scopeProvider

	@Inject
	var IURIEditorOpener editorOpener

	var URI previousSelectionURI = null

	var CachePropertyLookupJob cachePropertyLookupJob = null
	val jobLock = new Object

	//If the URIs were resolved to EObjects, then this would be a Map<PropertySet, Map<Property, PropertyAssociation>>
	val package Map<URI, Map<URI, URI>> cachedPropertyAssociations = Collections.synchronizedMap(newLinkedHashMap)

	var ArrayList<FilterCriterion> importedPropertyGroups = new ArrayList<FilterCriterion>
	
	Set<URI> filteredPropertySets
	
	val ISelectionListener selectionListener = [ part, selection |
		/*
		 * Change the view when the selection changes.
		 */
		updateSelection(part, selection)
	]

	val partListener = new IPartListener {
		override partOpened(IWorkbenchPart part) {
		}

		override partDeactivated(IWorkbenchPart part) {
			if (part instanceof XtextEditor) {
				val selectionProvider = part.internalSourceViewer.selectionProvider
				if (selectionProvider instanceof IPostSelectionProvider) {
					selectionProvider.removePostSelectionChangedListener(selectionChangedListener)
				}
			}
		}

		override partClosed(IWorkbenchPart part) {
			if (part instanceof XtextEditor && xtextDocument === (part as XtextEditor).document) {
				xtextDocument = null
			}
		}

		override partBroughtToTop(IWorkbenchPart part) {
		}

		override partActivated(IWorkbenchPart part) {
			if (part instanceof XtextEditor) {
				val selectionProvider = part.internalSourceViewer.selectionProvider
				if (selectionProvider instanceof IPostSelectionProvider) {
					selectionProvider.addPostSelectionChangedListener(selectionChangedListener)
				}
			}
		}
	}

	val ISelectionChangedListener selectionChangedListener = [
		val editor = site.workbenchWindow.activePage.activeEditor
		if (editor instanceof XtextEditor) {
			updateSelection(editor, selection)
		}
	]

	//This flag is necessary because calling IURIEditorOpener.open causes a model change event.  This event should be ignored when calling IURIEditorOpener.open
	var modelListenerEnabled = true

	val IXtextModelListener xtextModelListener = [
		if (modelListenerEnabled) {
			runCachePropertyLookupJob(input, null)
		}
	]

	override createPartControl(Composite parent) {
		pageBook = new PageBook(parent, SWT.NULL)

		noPropertiesLabel = new Label(pageBook, SWT.LEFT) => [
			text = NO_PROPERTIES_TO_SHOW
			alignment = SWT.CENTER
			background = parent.display.getSystemColor(SWT.COLOR_LIST_BACKGROUND)
		]

		populatingViewLabel = new Label(pageBook, SWT.LEFT) => [
			text = POPULATING_VIEW
			alignment = SWT.CENTER
			background = parent.display.getSystemColor(SWT.COLOR_LIST_BACKGROUND)
		]

		treeViewerComposite = new Composite(pageBook, SWT.NULL) => [
			val patternFilter = new PatternFilter {
				override protected isLeafMatch(Viewer viewer, Object element) {
					var thisTree = viewer as TreeViewer
					val labelProvider = thisTree.getLabelProvider(0) as ColumnLabelProvider
				    val contentProvider = thisTree.getContentProvider() as ITreeContentProvider
				    
				    // first go up to propertyset / property name 
					// see https://github.com/osate/osate2/issues/605)
				    var current = element
				    var parent = contentProvider.getParent(element)
				    while (contentProvider.getParent(parent) instanceof TreeEntry) {
				    	current = parent
				    	parent = contentProvider.getParent(parent)
				    }
				    
				    val propertysetName = labelProvider.getText(parent)?:''
					var propertyName = labelProvider.getText(current)
				    
					return wordMatches(propertyName) &&
						(currentPropertyGroup.size == 0 || isMatch(propertyName, propertysetName))
				}

				// Check all children to see if there is a match before hiding this parent
				override protected isParentMatch(Viewer viewer, Object element) {
					return anyChildrenMatch(viewer as TreeViewer, element)
				}

				// Recursive function for isParentMatch
				def boolean anyChildrenMatch(TreeViewer thisTree, Object element) {
					val contentProvider = thisTree.getContentProvider() as ITreeContentProvider
					val children = contentProvider.getChildren(element)
					var match = false

					if ((children !== null) && (children.length > 0)) {

						for (var i = 0; i < children.length && !match; i++) {
							match = anyChildrenMatch(thisTree, children.get(i))
						}
					} else {
						match = isLeafMatch(thisTree, element)
					}

					return match
				}
				
				def isMatch(String elementName, String parentName) {
					for (e: currentPropertyGroup) {
						if (e.parent === null && elementName == (e.element as String)) {
							return true
						}
						else if (parentName == (e.parent as String) && elementName == (e.element as String)) {
							return true
						}
					}
					
					return false
				}	
			}
			// Hack to kill optimization that disables filter when text is empty
			patternFilter.setPattern("org.eclipse.ui.keys.optimization.false")
			val treeColumnLayout = new TreeColumnLayout
			val filteredTree = new FilteredTree(it, SWT.BORDER.bitwiseOr(SWT.FULL_SELECTION), patternFilter, true) {
				override doCreateTreeViewer(Composite parent, int style) {
					val c = super.doCreateTreeViewer(parent, style)
					c.getControl().setLayoutData(null)
					parent.setLayout(treeColumnLayout)
					return c
				}
			}
			layout = new GridLayout
			val gd = new GridData(SWT.FILL, SWT.FILL, true, true);
			filteredTree.setLayoutData(gd);
			treeViewer = filteredTree.getViewer();
			treeViewer => [ treeViewer |
				new TreeViewerColumn(treeViewer, SWT.LEFT) => [
					column.text = "Property"
					treeColumnLayout.setColumnData(column, new ColumnWeightData(1, true))
					labelProvider = new PropertyColumnLabelProvider(this)
				]
				new TreeViewerColumn(treeViewer, SWT.LEFT) => [
					column.text = "Value"
					treeColumnLayout.setColumnData(column, new ColumnWeightData(2, true))
					labelProvider = new ValueColumnLabelProvider(this)
					editingSupport = new ValueColumnEditingSupport(treeViewer, this)
				]
				new TreeViewerColumn(treeViewer, SWT.LEFT) => [
					column.text = "Status"
					val gc = new GC(column.parent)
					treeColumnLayout.setColumnData(column,
						new ColumnPixelData(PropertyStatus.values.map[gc.stringExtent(toString).x].max + 5, true, true))
					gc.dispose
					labelProvider = new StatusColumnLabelProvider(this)
				]
				treeViewer.tree.linesVisible = true
				treeViewer.tree.headerVisible = true
				treeViewer.useHashlookup = true
				treeViewer.contentProvider = new PropertyViewContentProvider(this)
				treeViewer.addFilter[viewer, parentElement, element |
					if (filteredPropertySets === null) {
						true
					} else if (element instanceof TreeEntry) {
						switch treeElement : element.treeElement {
							URI: safeRead[
								switch eObject : it.getEObject(treeElement, true) {
									PropertySet: filteredPropertySets.contains(eObject.eResource.URI)
									default: true
								}
							]
							default: true
						}
					} else {
						true
					}
				]
			]
		]

		// Show the "nothing to show" page by default
		pageBook.showPage(noPropertiesLabel)
		site.page.addSelectionListener(selectionListener)
		site.page.addPartListener(partListener)
		val editor = site.page.activeEditor
		if (editor instanceof XtextEditor) {
			val editorSelectionProvider = editor.internalSourceViewer.selectionProvider
			if (editorSelectionProvider instanceof IPostSelectionProvider) {
				editorSelectionProvider.addPostSelectionChangedListener(selectionChangedListener)
			}
		}
		createActions
		createContextMenu
	}

	override dispose() {

		synchronized (jobLock) {
			if (cachePropertyLookupJob !== null) {
				cachePropertyLookupJob.cancel
				cachePropertyLookupJob = null
			}
		}
		site.page.removeSelectionListener(selectionListener)
		site.page.removePartListener(partListener)
		val editor = site.page.activeEditor
		if (editor instanceof XtextEditor) {
			val editorSelectionProvider = editor.internalSourceViewer.selectionProvider
			if (editorSelectionProvider instanceof IPostSelectionProvider) {
				editorSelectionProvider.removePostSelectionChangedListener(selectionChangedListener)
			}
		}
		xtextDocument?.removeModelListener(xtextModelListener)
		super.dispose
	}

	override setFocus() {
		treeViewer.tree.setFocus
	}

	def package boolean canEdit(Object element) {
		if (xtextDocument === null && !(resourceFromSelection instanceof XtextResource)) {
			false
		} else {
			safeRead[ extension it |
				switch treeElement : (element as TreeEntry).treeElement {
					URI:
						switch treeElementEObject : treeElement.getEObject(true) {
							Property: {
								val associationURI = cachedPropertyAssociations.get(
									((element as TreeEntry).parent as TreeEntry).treeElement).get(treeElement)
								getPropertyStatusNeverUndefined(associationURI).editable &&
									!(associationURI.getEObject(true) as PropertyAssociation).modal
							}
							BasicPropertyAssociation: {
								val containingAssociation = treeElementEObject.getContainerOfType(PropertyAssociation)
								getPropertyStatusNeverUndefined(containingAssociation).editable &&
									!containingAssociation.modal
							}
							default:
								false
						}
					RangeElement: {
						val containingAssociation = (treeElement.expressionURI.getEObject(true) as PropertyExpression).
							getContainerOfType(PropertyAssociation)
						getPropertyStatusNeverUndefined(containingAssociation).editable &&
							!containingAssociation.modal
					}
					ListElement: {
						val containingAssociation = (treeElement.expressionURI.getEObject(true) as PropertyExpression).
							getContainerOfType(PropertyAssociation)
						getPropertyStatusNeverUndefined(containingAssociation).editable &&
							!containingAssociation.modal
					}
					default:
						false
				}
			]
		}
	}

	def package getInput() {
		treeViewer.input as URI
	}

	def private createActions() {
		new Action("Collapse All") {
			override run() {
				treeViewer.collapseAll()
			}
		} => [
			imageDescriptor = MyAadl2Activator.getImageDescriptor("icons/propertyview/collapseall.gif")
			viewSite.actionBars.toolBarManager.add(it)
			toolTipText = COLLAPSE_ALL_TOOL_TIP
		]
		
		// Show only property groups defined with the with clause
		showOnlyImportedPropertiesAction = new Action("Show Only Imported Property Groups", IAction.AS_CHECK_BOX) {
			override run() {
				showOnlyImportedPropertiesAction.toolTipText = if(showOnlyImportedPropertiesAction.checked) {
					SHOW_ONLY_IMPORTED_PROPERTIES					
				} else {
					SHOW_ALL_AVAILABLE_PROPERTIES
				}
				
				if(showOnlyImportedPropertiesAction.checked) {
					currentPropertyGroup = new ArrayList<FilterCriterion>(importedPropertyGroups)
				} else {
					currentPropertyGroup.clear()
				}
				
				treeViewer.refresh()
			}		
		} => [
				enabled = false
				imageDescriptor = MyAadl2Activator.getImageDescriptor("icons/propertyview/filter_ps.png")
				toolTipText = SHOW_ONLY_IMPORTED_PROPERTIES
				viewSite.actionBars.toolBarManager.add(it)
		]

		showUndefinedAction = new Action(null, IAction.AS_CHECK_BOX) {
			override run() {
				showUndefinedAction.toolTipText = if (showUndefinedAction.checked) {
					HIDE_UNDEFINED_TOOL_TIP
				} else {
					SHOW_UNDEFINED_TOOL_TIP
				}
				
				treeViewer.refresh
			}
		} => [
			imageDescriptor = MyAadl2Activator.getImageDescriptor("icons/propertyview/nonexistent_property.gif")
			viewSite.actionBars.toolBarManager.add(it)
			toolTipText = SHOW_UNDEFINED_TOOL_TIP
		]

		showDefaultAction = new Action(null, IAction.AS_CHECK_BOX) {
			override run() {
				showDefaultAction.toolTipText = if (showDefaultAction.checked) {
					HIDE_DEFAULT_TOOL_TIP
				} else {
					SHOW_DEFAULT_TOOL_TIP
				}
				
				treeViewer.refresh
			}
		} => [
			imageDescriptor = MyAadl2Activator.getImageDescriptor("icons/propertyview/filter_properties.gif")
			viewSite.actionBars.toolBarManager.add(it)
			toolTipText = SHOW_DEFAULT_TOOL_TIP
		]
		
		new Action("Property Set Filters...") {
			override run() {
				val dialog = if (filteredPropertySets === null) {
					new PropertySetFilterDialog(viewSite.shell)
				} else {
					new PropertySetFilterDialog(viewSite.shell, filteredPropertySets)
				}
				if (dialog.open == Window.OK) {
					filteredPropertySets = dialog.selectedPropertySets
					treeViewer.refresh
				}
			}
		} => [
			viewSite.actionBars.menuManager.add(it)
		]

		removeElementAction = new Action("Remove") {
			override run() {
				val selectedElement = (treeViewer.selection as IStructuredSelection).firstElement as TreeEntry
				switch treeElement : selectedElement.treeElement {
					URI: {
						val postModificationUpdate = modify[
							switch treeElementObject : resourceSet.getEObject(treeElement, true) {
								Property: {
									val associationURI = cachedPropertyAssociations.get(
										(selectedElement.parent as TreeEntry).treeElement).get(selectedElement.treeElement)
									val association = resourceSet.getEObject(associationURI, true) as PropertyAssociation
									(association.owner as NamedElement).ownedPropertyAssociations.remove(association);
									[|runCachePropertyLookupJob(input, null)]
								}
								BasicPropertyAssociation: {
									(treeElementObject.owner as RecordValue).ownedFieldValues.remove(treeElementObject);
									[|treeViewer.refresh(selectedElement.parent)]
								}
							}]
						postModificationUpdate.apply
					}
					RangeElement: {
						modify(
							new IUnitOfWork.Void<XtextResource> {
								override process(XtextResource state) throws Exception {
									((state.resourceSet.getEObject((treeElement as RangeElement).expressionURI, true) as PropertyExpression).
										owner as RangeValue).delta = null
								}
							})
						treeViewer.refresh(selectedElement.parent)
					}
					ListElement: {
						modify(
							new IUnitOfWork.Void<XtextResource> {
								override process(XtextResource state) throws Exception {
									((state.resourceSet.getEObject((treeElement as ListElement).expressionURI, true) as PropertyExpression).
										owner as ListValue).ownedListElements.remove(
										(treeElement as ListElement).index
									)
								}
							})
						treeViewer.refresh(selectedElement.parent)
					}
				}
			}
		}

		openDefinitionAction = new Action("Open Property Definition") {
			override run() {
				val selectedElementURI = ((treeViewer.selection as IStructuredSelection).firstElement as TreeEntry).
					treeElement as URI
				val uriToOpen = safeRead[extension it|
					switch selectedElement : selectedElementURI.getEObject(true) {
						PropertySet,
						Property,
						BasicProperty: selectedElementURI
						BasicPropertyAssociation: selectedElement.property.URI
					}]
				modelListenerEnabled = false
				editorOpener.open(uriToOpen, true)
				modelListenerEnabled = true
			}
		}

		openPropertyAssociationAction = new Action("Open Property Association") {
			override run() {
				val selectedElement = (treeViewer.selection as IStructuredSelection).firstElement as TreeEntry
				val uriToOpen = safeRead[ extension it |

					val associationTemp = cachedPropertyAssociations.get((selectedElement.parent as TreeEntry).treeElement).
						get(selectedElement.treeElement).getEObject(true) 
					
					val association = 
						switch associationTemp {
							PropertyAssociationInstance : { 
								associationTemp.getPropertyAssociation();
							}
							PropertyAssociation : associationTemp
							default : null
						}
								
					val inputElement = input.getEObject(true)
					(if (inputElement instanceof RefinableElement) {
						association.appliesTos.map[containmentPathElements.last].filter [
							namedElement instanceof RefinableElement &&
								(namedElement as RefinableElement).isSameOrRefines(inputElement)
						].head ?: association
					} else {
						association
					}).URI
				]
				modelListenerEnabled = false
				editorOpener.open(uriToOpen, true)
				modelListenerEnabled = true
			}
		}

		makeLocalAction = new Action("Make Local") {
			override run() {
				// assumes PA is inherited, local contained, or default
				val selectedElement = (treeViewer.selection as IStructuredSelection).firstElement as TreeEntry
				val propertyURI = selectedElement.treeElement as URI
				val associationURI = cachedPropertyAssociations.get((selectedElement.parent as TreeEntry).treeElement).
					get(propertyURI)
				val postModificationUpdate = modify [
					var ()=>void update = [|]
					val inputElement = resourceSet.getEObject(input, true) as NamedElement
					resolveProperties(inputElement)
					if (associationURI !== null) {
						val oldPA = resourceSet.getEObject(associationURI, true) as PropertyAssociation
						val newPA = EcoreUtil.copy(oldPA)
						newPA.appliesTos.clear
						if (oldPA.appliesTos.size == 1) {
							// non-shared local contained => remove the PA
							(oldPA.owner as NamedElement).ownedPropertyAssociations.remove(oldPA)
							update = [|runCachePropertyLookupJob(input, null)]
						} else if (oldPA.appliesTos.size > 1) {
							// shared local contained => remove from applies to list
							val toRemove = oldPA.appliesTos.findFirst[
								path.namedElement === inputElement
							]
							oldPA.appliesTos.remove(toRemove)
						}
						inputElement.ownedPropertyAssociations.add(newPA)
					} else {
						// copy property's default value
						val property = resourceSet.getEObject(propertyURI, true) as Property
						inputElement.createOwnedPropertyAssociation => [
							it.property = property
							createOwnedValue => [
								ownedValue = EcoreUtil.copy(property.defaultValue)
							]
						]
					}
					update
				]
				postModificationUpdate.apply
			}
		}

		makeLocalContainedAction = new Action("Make Local Contained") {
			override run() {
				// assumes PA is inherited, local, shared local contained, or default
				val selectedElement = (treeViewer.selection as IStructuredSelection).firstElement as TreeEntry
				val propertyURI = selectedElement.treeElement as URI
				val associationURI = cachedPropertyAssociations.get((selectedElement.parent as TreeEntry).treeElement).
					get(propertyURI)
				val postModificationUpdate = modify [
					var ()=>void update = [|]
					val inputElement = resourceSet.getEObject(input, true) as NamedElement
					resolveProperties(inputElement)
					if (associationURI !== null) {
						val oldPA = resourceSet.getEObject(associationURI, true) as PropertyAssociation
						val newPA = EcoreUtil.copy(oldPA)
						newPA.appliesTos.clear
						newPA.appliesTos.add(
							Aadl2Factory.eINSTANCE.createContainedNamedElement => [
								createPath => [
									namedElement = inputElement
								]
							]
						)
						if (oldPA.appliesTos.size == 0 && oldPA.owner === inputElement) {
							// local PA
							inputElement.ownedPropertyAssociations.remove(oldPA)
							update = [|runCachePropertyLookupJob(input, null)]
						} else if (oldPA.appliesTos.size > 1) {
							// shared local contained => remove from applies to list
							val toRemove = oldPA.appliesTos.findFirst[
								path.namedElement === inputElement
							]
							oldPA.appliesTos.remove(toRemove)
						}
						(inputElement.owner as NamedElement).ownedPropertyAssociations.add(newPA)
					} else {
						// copy property's default value
						val property = resourceSet.getEObject(propertyURI, true) as Property
						(inputElement.owner as NamedElement).createOwnedPropertyAssociation => [
							it.property = property
							createOwnedValue => [
								ownedValue = EcoreUtil.copy(property.defaultValue)
							]
							appliesTos.add(Aadl2Factory.eINSTANCE.createContainedNamedElement => [
								createPath => [
									namedElement = inputElement
								]
							])
						]
					}
					update
				]
				postModificationUpdate.apply
			}
		}

		createLocalAssociationAction = new Action("Create Local Property Association") {
			override run() {
				val selectedElement = (treeViewer.selection as IStructuredSelection).firstElement as TreeEntry
				nextEditIsLocalCreation = true
				treeViewer.editElement(selectedElement, 1)
			}
		}

		createLocalContainedAssociationAction = new Action("Create Local Contained Property Association") {
			override run() {
				val selectedElement = (treeViewer.selection as IStructuredSelection).firstElement as TreeEntry
				nextEditIsLocalContainedCreation = true
				treeViewer.editElement(selectedElement, 1)
			}
		}
	}
	
	/**
	 * When editing a raw XtextResouce, this calls the getProperty() method for all property associations owned by a specified named element.
	 * This is needed because under certain conditions the property reference is not updated and this can result in a broken proxy.
	 * An exception is thrown when resolving the proxy. Resolving the property before making a modification prevents this from happening.
	 */
	def resolveProperties(NamedElement element) {
		if(xtextDocument === null) {
			for(PropertyAssociation pa : element.ownedPropertyAssociations) {
				pa.property
			}		
		}
	}

	def package <T> modify(IUnitOfWork<T, XtextResource> work) {
		if (xtextDocument !== null) {
			xtextDocument.modify(work);
		} else if(resourceFromSelection instanceof XtextResource) {
			val resource = resourceFromSelection as XtextResource;
			var cmd = new RecordingCommand(editingDomain as TransactionalEditingDomain) {
				T result;
				
				override protected doExecute() {
					result = work.exec(resource)
				}
			}
		
			editingDomain.commandStack.execute(cmd)
			
			// Run the serializer. Otherwise if an invalid modification is made, the resource could be erased.
			// Sanity check to ensure that we don't save if the modification caused serialization to fail. 
			// We need to undo to restore the resource to a valid state because the resource may still in use by the owner of the resource(such as the graphical editor)
			val serializedSrc = resource.getSerializer().serialize(resource.getContents().get(0));
			val modificationSuccessful = serializedSrc !== null && !serializedSrc.trim().isEmpty();			
			if (!modificationSuccessful) {
				if(!editingDomain.getCommandStack().canUndo() || editingDomain.getCommandStack.getUndoCommand() != cmd) {
					throw new RuntimeException("Property modification failed and unable to undo. Unexpected state.")
				}
				
				editingDomain.getCommandStack().undo()
			}
			
			resourceFromSelection.save(SaveOptions.newBuilder().format().getOptions().toOptionsMap())
							
			cmd.result
		} else {
			throw new RuntimeException("Unsupported case. Cannot modify model without an Xtext Document or an Xtext resource")
		}
	}

	def private createContextMenu() {
		new MenuManager => [
			removeAllWhenShown = true
			addMenuListener[
				add(openDefinitionAction)
				add(openPropertyAssociationAction)
				add(createLocalAssociationAction)
				add(createLocalContainedAssociationAction)
				add(makeLocalAction)
				add(makeLocalContainedAction)
				add(removeElementAction)
				openDefinitionAction.enabled = false
				openPropertyAssociationAction.enabled = false
				createLocalAssociationAction.enabled = false
				createLocalContainedAssociationAction.enabled = false
				makeLocalAction.enabled = false
				makeLocalContainedAction.enabled = false
				removeElementAction.enabled = false
				
				val selection = treeViewer.selection as IStructuredSelection
				if (selection.size == 1) {
					val firstSelectedElement = selection.firstElement as TreeEntry

					if (firstSelectedElement.treeElement instanceof URI) {
						openDefinitionAction.enabled = safeRead[ extension it |
							val treeElementEObject = (firstSelectedElement.treeElement as URI).getEObject(true)
							treeElementEObject instanceof PropertySet || treeElementEObject instanceof Property ||
									treeElementEObject instanceof BasicPropertyAssociation ||
									treeElementEObject instanceof BasicProperty
						]
						if (safeRead[extension it|
							(firstSelectedElement.treeElement as URI).getEObject(true) instanceof Property]) {
							val propertyStatus = getPropertyStatus(
									(firstSelectedElement.parent as TreeEntry).treeElement as URI,
									firstSelectedElement.treeElement as URI)
							openPropertyAssociationAction.enabled = #[PropertyStatus.INHERITED, PropertyStatus.LOCAL, 
								PropertyStatus.LOCAL_CONTAINED
							].contains(propertyStatus)
							createLocalAssociationAction.enabled = (propertyStatus ==
								PropertyStatus.INHERITED || propertyStatus == PropertyStatus.DEFAULT ||
								propertyStatus == PropertyStatus.UNDEFINED) && safeRead[ extension it |
								val inputElement = input.getEObject(true)
								inputElement instanceof AadlPackage || inputElement instanceof Classifier ||
										inputElement instanceof Subcomponent || inputElement instanceof ModalPath ||
										inputElement instanceof BehavioralFeature || inputElement instanceof Prototype ||
										inputElement instanceof Feature ||inputElement instanceof ModeFeature
							]
							createLocalContainedAssociationAction.enabled = (propertyStatus ==
								PropertyStatus.INHERITED || propertyStatus == PropertyStatus.DEFAULT ||
								propertyStatus == PropertyStatus.UNDEFINED) && safeRead[ extension it |
								val inputElement = input.getEObject(true)
								inputElement instanceof Subcomponent || inputElement instanceof ModalPath ||
										inputElement instanceof BehavioralFeature || inputElement instanceof Prototype ||
										inputElement instanceof Feature || inputElement instanceof ModeFeature
							]
							makeLocalAction.enabled = #[
								PropertyStatus.INHERITED,
								PropertyStatus.LOCAL_CONTAINED,
								PropertyStatus.LOCAL_SHARED,
								PropertyStatus.DEFAULT
							].contains(propertyStatus)
							makeLocalContainedAction.enabled = #[
								PropertyStatus.INHERITED,
								PropertyStatus.LOCAL,
								PropertyStatus.LOCAL_SHARED,
								PropertyStatus.DEFAULT
							].contains(propertyStatus) && safeRead[ extension it |
								val inputElement = input.getEObject(true)
								inputElement instanceof Subcomponent || inputElement instanceof ModalPath ||
										inputElement instanceof BehavioralFeature ||inputElement instanceof Prototype ||
										inputElement instanceof Feature || inputElement instanceof ModeFeature
							]	
						}
					}

					removeElementAction.enabled = canEdit(firstSelectedElement) &&
						switch treeElement : firstSelectedElement.treeElement {
							URI:
								safeRead[ extension it |
									switch treeElementEObject : treeElement.getEObject(true) {
										Property:
											true
										BasicPropertyAssociation:
											(treeElementEObject.owner as RecordValue).ownedFieldValues.size >= 2
										default:
											false
									}]
							RangeElement:
								treeElement.label == RangeElement.DELTA_LABEL
							ListElement:
								true
							default:
								false
						}
				}
				add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS))
			]
			treeViewer.control.menu = createContextMenu(treeViewer.control)
			site.registerContextMenu(it, treeViewer)
		]
	}

	def private updateSelection(IWorkbenchPart part, ISelection selection) {
		xtextDocument?.removeModelListener(xtextModelListener)
		val currentSelection = switch selection {
			case selection.empty: {
				null
			}
			ITextSelection case part instanceof XtextEditor: {
				xtextDocument = (part as XtextEditor).document
				xtextDocument.readOnly[new EObjectAtOffsetHelper().resolveContainedElementAt(it, selection.offset)]
			}
			IStructuredSelection case selection.size == 1: {
				switch selectedObject : selection.firstElement {
					EObject: {
						xtextDocument = null
						selectedObject
					}
					EObjectNode: {
						xtextDocument = selectedObject.document
						selectedObject.readOnly[it]
					}
					EObjectURIWrapper: {
						xtextDocument = null
						new ResourceSetImpl().getEObject(selectedObject.uri, true)
					}
					default: {
						val propertySource = Adapters.adapt(selectedObject, IAadlPropertySource) ?:
								Adapters.adapt(selection, IAadlPropertySource)
						if (propertySource !== null) {
							xtextDocument = propertySource.document
							propertySource.namedElement
						}
					}
				}
			}
		}
		xtextDocument?.addModelListener(xtextModelListener)
		var Object treeElementToSelect
		val currentSelectionURI = try {
			switch currentSelection {
				PropertySet,
				Property,
				PropertyType,
				PropertyConstant,
				PackageSection:
					null
				NamedElement:
					currentSelection.URI
				PropertyAssociation case currentSelection.appliesTos.empty: {
					treeElementToSelect = new TreeEntry(
						new TreeEntry(currentSelection.owner.URI,
							currentSelection.property.getContainerOfType(PropertySet).URI), currentSelection.property.URI)
					currentSelection.owner.URI
				}
				PropertyAssociation case currentSelection.appliesTos.size == 1 &&
					currentSelection.appliesTos.head.containmentPathElements.size == 1: {
					treeElementToSelect = new TreeEntry(
						new TreeEntry(
							currentSelection.appliesTos.head.containmentPathElements.head.namedElement.URI,
							currentSelection.property.getContainerOfType(PropertySet).URI
						), currentSelection.property.URI)
					currentSelection.appliesTos.head.containmentPathElements.head.namedElement.URI
				}
				ContainmentPathElement case currentSelection.path === null &&
					currentSelection.owner instanceof ContainedNamedElement: {
					treeElementToSelect = new TreeEntry(
						new TreeEntry(
							currentSelection.namedElement.URI,
							currentSelection.getContainerOfType(PropertyAssociation).property.
								getContainerOfType(PropertySet).URI
						), currentSelection.getContainerOfType(PropertyAssociation).property.URI)
					currentSelection.namedElement.URI
				}
				BasicPropertyAssociation,
				PropertyExpression: {
					val path = new ArrayDeque
					if (currentSelection instanceof BasicPropertyAssociation) {
						path.push(currentSelection.URI)
					}
					var currentElement = currentSelection.owner
					var Element previousElement = currentSelection
					while (currentElement !== null && !(currentElement instanceof PropertyAssociation)) {
						switch currentElement {
							ModalPropertyValue case (currentElement.owner as PropertyAssociation).modal,
							BasicPropertyAssociation:
								path.push(currentElement.URI)
							ListValue:
								path.push(
									new ListElement(currentElement.ownedListElements.indexOf(previousElement),
										previousElement.URI))
							RangeValue:
								path.push(
									new RangeElement(
										switch previousElement {
											case currentElement.minimum: RangeElement.MINIMUM_LABEL
											case currentElement.maximum: RangeElement.MAXIMUM_LABEL
											case currentElement.delta: RangeElement.DELTA_LABEL
										}, previousElement.URI))
						}
						previousElement = currentElement
						currentElement = currentElement.owner
					}
					if (currentElement instanceof PropertyAssociation) {
						path.push(currentElement.property.URI)
						val root = if (currentElement.appliesTos.empty) {
								currentElement.owner.URI
							} else if (currentElement.appliesTos.size == 1 &&
								currentElement.appliesTos.head.containmentPathElements.size == 1) {
								currentElement.appliesTos.head.containmentPathElements.head.namedElement.URI
							}
						treeElementToSelect = path.fold(
							new TreeEntry(root, currentElement.property.getContainerOfType(PropertySet).URI),
							[new TreeEntry($0, $1)])
						root
					}
				}
			}
		} catch (NullPointerException e) {
		}
		if (currentSelectionURI !== null) {
			editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(currentSelection)
			resourceFromSelection = currentSelection.eResource
			if (currentSelectionURI == previousSelectionURI) {
				if (treeElementToSelect !== null) {
					treeViewer.setSelection(new StructuredSelection(treeElementToSelect), true)
				}
				pageBook.showPage(treeViewerComposite)
			} else {
				previousSelectionURI = currentSelectionURI
				runCachePropertyLookupJob(currentSelectionURI, treeElementToSelect)
			}
		} else {

			synchronized (jobLock) {
				if (cachePropertyLookupJob !== null) {
					cachePropertyLookupJob.cancel
					cachePropertyLookupJob = null
				}
			}
			pageBook.showPage(noPropertiesLabel)
			editingDomain = null
			resourceFromSelection = null
			previousSelectionURI = null
		}
		
		// Build list of imported properties for "Show only imported properties" filter button to use
		var package = getPackageSection(currentSelection)
		importedPropertyGroups.clear
		if (package !== null) {
			val units = (package as PackageSection).getImportedUnits()
			
			for (ModelUnit unit: units) {
				if (unit instanceof PropertySet) {
					for (prop: unit.ownedProperties) {
						importedPropertyGroups.add(new FilterCriterion(unit.name, prop.name))
					}
				}
			}
			showOnlyImportedPropertiesAction.enabled = true
		} else {
			showOnlyImportedPropertiesAction.enabled = false
		}
	}

	// Recursive function to get the package section related to a node if it exists
	def private EObject getPackageSection(EObject selection) {
		
		if (selection === null ) {
			return null
		}
		
		if (selection instanceof PackageSection) {
			return selection
		} 
		else if (selection instanceof Element){
			var owner = selection.owner
			if (owner !== null) {
				getPackageSection(owner)
			}
		}
	}
	
	def package <T> safeRead((ResourceSet)=>T operation) {
		safeReadResource [resource | 
			operation.apply(resource.resourceSet);
		]
	}
	
	def package <T> safeReadResource((Resource)=>T operation) {
		if (xtextDocument !== null) {
			xtextDocument.readOnly(operation)
		} else if (editingDomain instanceof TransactionalEditingDomain) {
			try {
				TransactionUtil.runExclusive(editingDomain,
					new RunnableWithResult.Impl<T> {
						override run() {
							result = operation.apply(resourceFromSelection)
							status = Status.OK_STATUS
						}
					})
			} catch (InterruptedException e) {

				//Allow the operation to determine what the result should be
				operation.apply(null)
			}
		} else {
			operation.apply(resourceFromSelection)
		}
	}

	def private createCachePropertyLookupJob(URI elementURI, Object objectToSelect) {
		new CachePropertyLookupJob(elementURI, this, site.shell.display, scopeProvider,
			[|
				pageBook.showPage(populatingViewLabel)
			],
			[|
				treeViewer.input = elementURI
				if (objectToSelect !== null) {
					treeViewer.setSelection(new StructuredSelection(objectToSelect), true)
				}
				pageBook.showPage(treeViewerComposite)
			])
	}
	
	def package getPropertyStatus(URI propertySetURI, URI propertyURI) {
		safeRead[ extension it |
			val associationURI = cachedPropertyAssociations.get(propertySetURI).get(propertyURI)
			if (associationURI !== null) {
				val association = associationURI.getEObject(true) as PropertyAssociation
				val inputElement = input.getEObject(true)
				if (inputElement == association.owner) {
					PropertyStatus.LOCAL
				} else if (association.appliesTos.exists[inputElement == containmentPathElements.last.namedElement]) {
					if (association.appliesTos.size > 1) {
						PropertyStatus.LOCAL_SHARED
					} else {
						PropertyStatus.LOCAL_CONTAINED
					}
				} else {
					PropertyStatus.INHERITED
				}
			} else if ((propertyURI.getEObject(true) as Property).defaultValue !== null) {
				PropertyStatus.DEFAULT
			} else {
				PropertyStatus.UNDEFINED
			}
		]
	}

	def private getPropertyStatusNeverUndefined(URI associationURI) {
		if (associationURI !== null) {
			safeRead[ extension it |
				val association = associationURI.getEObject(true) as PropertyAssociation
				val inputElement = input.getEObject(true)
				if (inputElement == association.owner) {
					PropertyStatus.LOCAL
				} else if (association.appliesTos.exists[inputElement == containmentPathElements.last.namedElement]) {
					PropertyStatus.LOCAL_CONTAINED
				} else {
					PropertyStatus.INHERITED
				}
			]
		} else {
			PropertyStatus.DEFAULT
		}
	}

	def package getPropertyStatusNeverUndefined(extension ResourceSet resourceSet, PropertyAssociation association) {
		if (association === null) {
			PropertyStatus.DEFAULT
		} else {
			val inputElement = input.getEObject(true)
			if (inputElement == association.owner) {
				PropertyStatus.LOCAL
			} else if (association.appliesTos.exists[inputElement == containmentPathElements.last.namedElement]) {
				PropertyStatus.LOCAL_CONTAINED
			} else {
				PropertyStatus.INHERITED
			}
		}
	}
	
	def package runCachePropertyLookupJob(URI elementURI, Object objectToSelect) {
		synchronized (jobLock) {
			if (cachePropertyLookupJob !== null &&
				cachePropertyLookupJob.state != Job.NONE) {
				cachePropertyLookupJob.cancel
			}
			cachePropertyLookupJob = createCachePropertyLookupJob(elementURI, objectToSelect)
			cachePropertyLookupJob.schedule
		}
	}

}
