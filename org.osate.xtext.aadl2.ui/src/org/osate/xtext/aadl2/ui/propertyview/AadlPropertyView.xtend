package org.osate.xtext.aadl2.ui.propertyview;

import java.util.List
import org.eclipse.jface.layout.TreeColumnLayout
import org.eclipse.jface.viewers.ColumnPixelData
import org.eclipse.jface.viewers.ColumnWeightData
import org.eclipse.jface.viewers.IPostSelectionProvider
import org.eclipse.jface.viewers.ISelectionChangedListener
import org.eclipse.jface.viewers.TreeViewer
import org.eclipse.jface.viewers.TreeViewerColumn
import org.eclipse.swt.SWT
import org.eclipse.swt.graphics.GC
import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.widgets.Label
import org.eclipse.ui.IPartListener
import org.eclipse.ui.ISelectionListener
import org.eclipse.ui.IWorkbenchPart
import org.eclipse.ui.part.PageBook
import org.eclipse.ui.part.ViewPart
import org.eclipse.xtext.ui.editor.XtextEditor
import org.osate.aadl2.NamedElement
import org.osate.aadl2.PropertySet
import org.eclipse.jface.viewers.ISelection
import org.eclipse.jface.text.ITextSelection
import org.eclipse.xtext.resource.EObjectAtOffsetHelper
import org.eclipse.jface.viewers.IStructuredSelection
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode
import org.eclipse.core.runtime.IAdaptable
import org.eclipse.core.runtime.jobs.Job
import org.eclipse.core.runtime.IProgressMonitor
import org.osate.aadl2.Aadl2Package
import com.google.inject.Inject
import org.eclipse.xtext.scoping.IScopeProvider
import org.eclipse.emf.ecore.util.EcoreUtil
import org.osate.aadl2.PropertyAssociation
import org.osate.aadl2.Property
import java.util.Map
import org.eclipse.core.runtime.Status
import java.util.Collections
import java.util.HashMap
import org.eclipse.jface.viewers.ILazyTreePathContentProvider
import org.eclipse.jface.viewers.Viewer
import org.eclipse.jface.viewers.TreePath
import org.eclipse.jface.viewers.ColumnLabelProvider
import org.eclipse.swt.graphics.Image
import org.osate.xtext.aadl2.ui.MyAadl2Activator
import org.eclipse.xtext.serializer.ISerializer
import org.osate.aadl2.ModalPropertyValue
import org.osate.aadl2.ComponentClassifier
import java.util.ArrayList
import org.eclipse.jface.action.Action
import org.eclipse.emf.edit.domain.EditingDomain
import org.eclipse.xtext.ui.editor.model.IXtextDocument
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain
import org.eclipse.jface.wizard.WizardDialog
import org.osate.xtext.aadl2.ui.propertyview.associationwizard.PropertyAssociationWizard
import org.eclipse.jface.window.Window
import org.osate.xtext.aadl2.parser.antlr.Aadl2Parser
import org.eclipse.xtext.linking.ILinker
import org.osate.aadl2.PropertyExpression
import org.osate.aadl2.instance.InstanceReferenceValue
import org.osate.aadl2.ListValue
import org.eclipse.jface.action.IAction
import org.osate.aadl2.NumberValue
import org.osate.aadl2.UnitLiteral
import org.osate.aadl2.IntegerLiteral
import org.osate.aadl2.RealLiteral

import static extension org.eclipse.xtext.EcoreUtil2.getContainerOfType
import org.eclipse.xtext.ui.editor.model.IXtextModelListener
import org.eclipse.emf.common.util.URI

/**
 * View that displays the AADL property value associations within a given AADL
 * model element.
 *
 * @author aarong
 */
class AadlPropertyView extends ViewPart {
	val static HIDE_UNDEFINED_TOOL_TIP = "Click to hide undefined properties"
	val static SHOW_UNDEFINED_TOOL_TIP = "Click to show undefined properties"

	val static NO_PROPERTIES_TO_SHOW = "No properties to show: Please select a single object that is an AADL Property Holder."
	val static POPULATING_VIEW = "Populating AADL Property Values view."
	
	val static MODE_ICON = "icons/propertyview/mode.gif"
	val static SCALAR_ICON = "icons/propertyview/scalar.gif"
	val static LIST_ICON = "icons/propertyview/list.gif"
	val static PROPERTY_SET_ICON = "icons/propertyview/property_set.gif"
	
	val static STATUS_UNDEFINED = "undefined"
	val static STATUS_LOCAL = "local"
	val static STATUS_INHERITED = "inherited"
	val static STATUS_DEFAULT = "default"
	
	/**
	 * Page book for switching between the tree viewer and the "no properties"
	 * message.
	 */
	var PageBook pageBook = null

	/**
	 * Tree for displaying properties. Underlying model is a
	 * {@link List} of {@link PropertySet} objects.
	 */
	var TreeViewer treeViewer = null
	
	var Composite treeViewerComposite = null

	/**
	 * The label for the no results message.
	 */
	var Label noPropertiesLabel = null
	
	var Label populatingViewLabel = null

	/**
	 * Action for toggling the display of nonexistent properties
	 */
	var Action showUndefinedAction = null

	/**
	 * Action for creating a new Property Association without using any information
	 * from this view's selection
	 */
	var Action addNewPropertyAssociationToolbarAction = null
	
	var URI currentSelectionUri = null

	/**
	 * The editing domain for the viewer's input
	 */
	var EditingDomain editingDomain = null

	var IXtextDocument xtextDocument = null

	@Inject
	var ISerializer serializer

	@Inject
	var Aadl2Parser aadl2Parser

	@Inject
	var ILinker linker

	@Inject
	var IScopeProvider scopeProvider
	
	var NamedElement previousSelection = null
	
	var CachePropertyLookupJob cachePropertyLookupJob = null
	val jobLock = new Object
	
	val Map<PropertySet, HashMap<Property, PropertyAssociation>> cachedPropertyAssociations = Collections.synchronizedMap(newHashMap)
	
	val ISelectionListener selectionListener = [part, selection |
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

	val ISelectionChangedListener selectionChangedListener = [updateSelection(site.workbenchWindow.activePage.activeEditor as XtextEditor, selection)]
	
	val IXtextModelListener xtextModelListener = [
		synchronized (jobLock) {
			if (cachePropertyLookupJob != null && cachePropertyLookupJob.state != Job.NONE) {
				cachePropertyLookupJob.cancel
			}
			cachePropertyLookupJob = createCachePropertyLookupJob(resourceSet.getEObject(currentSelectionUri, true) as NamedElement)
			cachePropertyLookupJob.schedule
		}
	]

	val propertyColumnLabelProvider = new ColumnLabelProvider {
		/** Cached Icon for property set nodes */
		var Image propSetImage = null
		/** Cached Icon for list property value nodes */
		var Image listImage = null
		/** Cached Icon for scalar property value nodes */
		var Image scalarImage = null
		/** Cached Icon for modes */
		var Image modeImage = null
		
		override getText(Object element) {
			switch element {
				PropertySet: {
					element.name
				}
				Property: {
					element.name
				}
				ModalPropertyValue: {
					val modes = if (element.allInModes.empty) {
						//This ModalPropertyValue exists in all modes that are not listed for other ModalPropertyValues
						val selectedClassifierModes = new ArrayList((input as ComponentClassifier).allModes)
						selectedClassifierModes.removeAll((element.owner as PropertyAssociation).ownedValues.map[allInModes].flatten)
						selectedClassifierModes
					} else {
						element.allInModes
					}
					'''in modes («modes.map[name].join(", ")»)'''
				}
				IntegerLiteral: {
					"aadlinteger"
				}
				RealLiteral: {
					"aadlreal"
				}
				UnitLiteral: {
					"unit"
				}
			}
		}
		
		override getForeground(Object element) {
			switch element {
				Property case cachedPropertyAssociations.get(element.owner).get(element) == null && element.defaultValue == null: {
					site.shell.display.getSystemColor(SWT.COLOR_RED)
				}
			}
		}
		
		override getImage(Object element) {
			switch element {
				PropertySet: {
					propSetImage ?: (propSetImage = MyAadl2Activator.getImageDescriptor(PROPERTY_SET_ICON).createImage)
				}
				Property case element.list: {
					listImage ?: (listImage = MyAadl2Activator.getImageDescriptor(LIST_ICON).createImage)
				}
				Property case !element.list: {
					scalarImage ?: (scalarImage = MyAadl2Activator.getImageDescriptor(SCALAR_ICON).createImage)
				}
				ModalPropertyValue: {
					modeImage ?: (modeImage = MyAadl2Activator.getImageDescriptor(MODE_ICON).createImage)
				}
			}
		}
		
		override dispose() {
			propSetImage?.dispose
			propSetImage = null
			listImage?.dispose
			listImage = null
			scalarImage?.dispose
			scalarImage = null
			modeImage?.dispose
			modeImage = null
			super.dispose
		}
	}
	
	val valueColumnLabelProvider = new ColumnLabelProvider {
		override getText(Object element) {
			switch resolvedElement : element.resolveIfProxy {
				Property: {
					val association = cachedPropertyAssociations.get(resolvedElement.owner).get(resolvedElement)
					if (association != null) {
						if (!association.modal) {
							association.ownedValues.head.ownedValue.getValueAsString(serializer)
						}
					} else if(resolvedElement.defaultValue != null) {
						resolvedElement.defaultValue.getValueAsString(serializer)
					}
				}
				ModalPropertyValue: {
					resolvedElement.ownedValue.getValueAsString(serializer)
				}
				NumberValue: {
					val serializedNumberValue = resolvedElement.getValueAsString(serializer)
					serializedNumberValue.substring(0, serializedNumberValue.toUpperCase.lastIndexOf(resolvedElement.unit.name.toUpperCase)).trim
				}
				UnitLiteral: {
					resolvedElement.name
				}
			}
		}
	}
	
	val statusColumnLabelProvider = new ColumnLabelProvider {
		override getText(Object element) {
			switch element {
				Property: {
					val association = cachedPropertyAssociations.get(element.owner).get(element)
					if (association != null) {
						if (input == association.owner) {
							STATUS_LOCAL
						} else {
							STATUS_INHERITED
						}
					} else {
						if (element.defaultValue != null) {
							STATUS_DEFAULT
						} else {
							STATUS_UNDEFINED
						}
					}
				}
			}
		}
		
		override getForeground(Object element) {
			switch element {
				Property case cachedPropertyAssociations.get(element.owner).get(element) == null && element.defaultValue == null: {
					site.shell.display.getSystemColor(SWT.COLOR_RED)
				}
			}
		}
	}
	
	val propertyViewContentProvider = new ILazyTreePathContentProvider {
		override inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}
		
		override updateHasChildren(TreePath path) {
			val hasChildren = switch lastSegment : path.lastSegment {
				case null: {
					if (showUndefinedAction.checked) {
						!cachedPropertyAssociations.empty
					} else {
						!cachedPropertyAssociations.filter[propertySet, associationsForPropertySet | associationsForPropertySet.entrySet.exists[value != null || key.defaultValue != null]].empty
					}
				}
				PropertySet: {
					if (showUndefinedAction.checked) {
						!cachedPropertyAssociations.get(lastSegment).empty
					} else {
						!cachedPropertyAssociations.get(lastSegment).filter[property, propertyAssociation | propertyAssociation != null || property.defaultValue != null].empty
					}
				}
				Property: {
					val association = cachedPropertyAssociations.get(lastSegment.owner).get(lastSegment)
					(association == null && lastSegment.defaultValue instanceof NumberValue && (lastSegment.defaultValue as NumberValue).unit != null) ||
							(association != null &&
								(association.modal || (association.ownedValues.head.ownedValue instanceof NumberValue && (association.ownedValues.head.ownedValue as NumberValue).unit != null))
							)
					
				}
				ModalPropertyValue: {
					lastSegment.ownedValue instanceof NumberValue && (lastSegment.ownedValue as NumberValue).unit != null
				}
				NumberValue: {
					false
				}
				UnitLiteral: {
					false
				}
				default: {
					println("updateHasChildren: " + path)
					throw new UnsupportedOperationException("TODO: auto-generated method stub")
				}
			}
			treeViewer.setHasChildren(path, hasChildren)
		}
		
		override updateChildCount(TreePath treePath, int currentChildCount) {
			val childCount = switch lastSegment : treePath.lastSegment {
				case null: {
					if (showUndefinedAction.checked) {
						cachedPropertyAssociations.size
					} else {
						cachedPropertyAssociations.filter[propertySet, associationsForPropertySet | associationsForPropertySet.entrySet.exists[value != null || key.defaultValue != null]].size
					}
				}
				PropertySet: {
					if (showUndefinedAction.checked) {
						cachedPropertyAssociations.get(lastSegment).size
					} else {
						cachedPropertyAssociations.get(lastSegment).filter[property, propertyAssociation | propertyAssociation != null || property.defaultValue != null].size
					}
				}
				Property: {
					val association = cachedPropertyAssociations.get(lastSegment.owner).get(lastSegment)
					if (association != null) {
						if (association.modal) {
							association.ownedValues.size
						} else if (association.ownedValues.head.ownedValue instanceof NumberValue && (association.ownedValues.head.ownedValue as NumberValue).unit != null) {
							2
						} else {
							0
						}
					} else if (lastSegment.defaultValue instanceof NumberValue && (lastSegment.defaultValue as NumberValue).unit != null) {
						2
					} else {
						0
					}
				}
				ModalPropertyValue: {
					if (lastSegment.ownedValue instanceof NumberValue && (lastSegment.ownedValue as NumberValue).unit != null) {
						2
					} else {
						0
					}
				}
				NumberValue: {
					0
				}
				UnitLiteral: {
					0
				}
				default: {
					println("updateChildCount: " + treePath + " currentCount: " + currentChildCount + " treePathSegmentCount: " + treePath.segmentCount + " lastSegment: " + lastSegment)
					throw new UnsupportedOperationException("TODO: auto-generated method stub")
				}
			}
			if (currentChildCount != childCount) {
				treeViewer.setChildCount(treePath, childCount)
			}
		}
		
		override updateElement(TreePath parentPath, int index) {
			val childElement = switch lastSegment : parentPath.lastSegment {
				case null: {
					val filteredAssociations = if (showUndefinedAction.checked) {
						cachedPropertyAssociations
					} else {
						cachedPropertyAssociations.filter[propertySet, associationsForPropertySet | associationsForPropertySet.entrySet.exists[value != null || key.defaultValue != null]]
					}
					filteredAssociations.keySet.sortBy[name.toUpperCase].get(index)
				}
				PropertySet: {
					val filteredAssociations = if (showUndefinedAction.checked) {
						cachedPropertyAssociations.get(lastSegment)
					} else {
						cachedPropertyAssociations.get(lastSegment).filter[property, propertyAssociation | propertyAssociation != null || property.defaultValue != null]
					}
					filteredAssociations.keySet.sortBy[name.toUpperCase].get(index)
				}
				Property: {
					val association = cachedPropertyAssociations.get(lastSegment.owner).get(lastSegment)
					if (association == null) {
						//Default NumberValue with units
						if (index == 0) {
							lastSegment.defaultValue
						} else { //index is 1
							(lastSegment.defaultValue as NumberValue).unit
						}
					} else if (association.modal) {
						association.ownedValues.get(index)
					} else {
						//NumberValue with units
						if (index == 0) {
							association.ownedValues.head.ownedValue
						} else { //index is 1
							(association.ownedValues.head.ownedValue as NumberValue).unit
						}
					}
				}
				ModalPropertyValue: {
					//NumberValue with units
					if (index == 0) {
						lastSegment.ownedValue
					} else { //index is 1
						(lastSegment.ownedValue as NumberValue).unit
					}
				}
				default: {
					println("updateElement: " + parentPath + " pathCount: " + parentPath.segmentCount + " index: " + index + " lastSegment: " + lastSegment)
					throw new UnsupportedOperationException("TODO: auto-generated method stub")
				}
			}
			treeViewer.replace(parentPath, index, childElement)
			updateChildCount(parentPath.createChildPath(childElement), -1)
		}
		
		override getParents(Object element) {
			switch element {
				PropertySet: {
					#[TreePath.EMPTY]
				}
				Property: {
					//Parent path: PropertySet
					#[new TreePath(#[element.owner])]
				}
				ModalPropertyValue: {
					//Parent path: PropertySet -> Property
					val property = (element.owner as PropertyAssociation).property
					#[new TreePath(#[property.owner, property])]
				}
				NumberValue: {
					if (element.owner instanceof ModalPropertyValue) {
						//Parent path: PropertySet -> Property -> ModalPropertyValue
						val property = element.getContainerOfType(PropertyAssociation)?.property
						#[new TreePath(#[property.owner, property, element.owner])]
					} else {
						//Parent path: PropertySet -> Property
						//There will be a containing PropertyAssociation if the viewer is showing a non-modal property value.  Otherwise, the viewer is showing a default value
						val property = element.getContainerOfType(PropertyAssociation)?.property ?: element.getContainerOfType(Property)
						#[new TreePath(#[property.owner, property])]
					}
				}
				UnitLiteral: {
					/*
					 * Parent path: PropertySet -> Property
					 * Unable to retrieve Property from UnitLiteral
					 * 
					 * Parent path: PropertySet -> Property -> ModalPropertyValue
					 * Unable to retrieve ModalPropertyValue from UnitLiteral
					 */
					 #[]
				}
				default: {
					println("getParents: " + element)
					throw new UnsupportedOperationException("TODO: auto-generated method stub")
				}
			}
		}
		
		override dispose() {
		}
	}
	
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
			val treeColumnLayout = new TreeColumnLayout
			layout = treeColumnLayout
			treeViewer = new TreeViewer(it, SWT.VIRTUAL.bitwiseOr(SWT.H_SCROLL).bitwiseOr(SWT.V_SCROLL).bitwiseOr(SWT.FULL_SELECTION)) => [
				new TreeViewerColumn(it, SWT.LEFT) => [
					column.text = "Property"
					treeColumnLayout.setColumnData(column, new ColumnWeightData(1, true))
					labelProvider = propertyColumnLabelProvider
				]
				new TreeViewerColumn(it, SWT.LEFT) => [
					column.text = "Value"
					treeColumnLayout.setColumnData(column, new ColumnWeightData(2, true))
					labelProvider = valueColumnLabelProvider
				]
				new TreeViewerColumn(it, SWT.LEFT) => [
					column.text = "Status"
					val gc = new GC(column.parent)
					treeColumnLayout.setColumnData(column, new ColumnPixelData(#[STATUS_LOCAL, STATUS_INHERITED, STATUS_DEFAULT, STATUS_UNDEFINED].map[gc.stringExtent(it).x].max + 5, true, true))
					gc.dispose
					labelProvider = statusColumnLabelProvider
				]
				tree.linesVisible = true
				tree.headerVisible = true
				useHashlookup = true
				contentProvider = propertyViewContentProvider
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
	}

	override dispose() {
		synchronized (jobLock) {
			if (cachePropertyLookupJob != null) {
				cachePropertyLookupJob.cancel
				cachePropertyLookupJob = null;
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
		super.dispose
	}
	
	override setFocus() {
		treeViewer.tree.setFocus
	}
	
	def private getInput() {
		(treeViewer.input as NamedElementHolder)?.namedElement
	}

	def private createActions() {
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

		addNewPropertyAssociationToolbarAction = new Action {
			override run() {
				if (new WizardDialog(viewSite.workbenchWindow.shell, new PropertyAssociationWizard(xtextDocument, editingDomain?.commandStack, input, serializer, aadl2Parser, linker)).open == Window.OK) {
					synchronized (jobLock) {
						if (cachePropertyLookupJob != null && cachePropertyLookupJob.state != Job.NONE) {
							cachePropertyLookupJob.cancel
						}
						cachePropertyLookupJob = createCachePropertyLookupJob(input)
						cachePropertyLookupJob.schedule
					}
				}
			}
		} => [
			toolTipText = "New Property Association"
			imageDescriptor = MyAadl2Activator.getImageDescriptor("icons/propertyview/new_pa.gif")
			enabled = false
			viewSite.actionBars.toolBarManager.add(it)
		]
	}

	def private resolveIfProxy(Object possibleProxy) {
		switch possibleProxy {
			EObject case possibleProxy.eIsProxy: {
				EcoreUtil.resolve(possibleProxy, input)
			}
			default: {
				possibleProxy
			}
		}
	}

	def private updateSelection(IWorkbenchPart part, ISelection selection) {
		xtextDocument?.removeModelListener(xtextModelListener)
		val currentSelection = switch selection {
			case selection.empty: {
				null
			}
			ITextSelection case part instanceof XtextEditor: {
				xtextDocument = (part as XtextEditor).document;
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
					IAdaptable: {
						val propertySource = selectedObject.getAdapter(IAadlPropertySource) as IAadlPropertySource
						if (propertySource != null) {
							xtextDocument = propertySource.document
							propertySource.namedElement
						}
					}
				}
			}
		}
		xtextDocument?.addModelListener(xtextModelListener)
		if (currentSelection instanceof NamedElement) {
			editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(currentSelection)
			if (currentSelection == previousSelection) {
				pageBook.showPage(treeViewerComposite)
			} else {
				previousSelection = currentSelection
				synchronized (jobLock) {
					if (cachePropertyLookupJob != null && cachePropertyLookupJob.state != Job.NONE) {
						cachePropertyLookupJob.cancel
					}
					cachePropertyLookupJob = createCachePropertyLookupJob(currentSelection)
					cachePropertyLookupJob.schedule
				}
			}
		} else {
			synchronized (jobLock) {
				if (cachePropertyLookupJob != null) {
					cachePropertyLookupJob.cancel
					cachePropertyLookupJob = null;
				}
			}
			pageBook.showPage(noPropertiesLabel)
			addNewPropertyAssociationToolbarAction.enabled = false
			editingDomain = null
		}
	}
	
	def private createCachePropertyLookupJob(NamedElement element) {
		currentSelectionUri = EcoreUtil.getURI(element)
		new CachePropertyLookupJob(element, this, [|
			pageBook.showPage(populatingViewLabel)
			addNewPropertyAssociationToolbarAction.enabled = false
		], [|
			treeViewer.input = new NamedElementHolder(element)
			pageBook.showPage(treeViewerComposite)
			addNewPropertyAssociationToolbarAction.enabled = true
		])
	}
	
	def private static getValueAsString(PropertyExpression expression, ISerializer serializer) {
		switch expression {
			InstanceReferenceValue:
				expression.referencedInstanceObject?.instanceObjectPath ?: "null"
			ListValue case expression.hasInstanceReferenceValue:
				expression.serializeListWithInstanceReferenceValue(serializer)
			default: {
				serializer.serialize(expression).replaceAll("\n", "").replaceAll("\t", "").trim
				// TODO: Test this to see what cleanup is truly necessary.
			}
		}
	}
	
	def private static boolean hasInstanceReferenceValue(ListValue topList) {
		topList.ownedListElements.exists[it instanceof InstanceReferenceValue || (it instanceof ListValue && (it as ListValue).hasInstanceReferenceValue)]
	}
	
	def private static String serializeListWithInstanceReferenceValue(ListValue topList, ISerializer serializer) {
		topList.ownedListElements.join("(", ", ", ")", [
			switch it {
				InstanceReferenceValue:
					referencedInstanceObject?.instanceObjectPath ?: "null"
				ListValue:
					serializeListWithInstanceReferenceValue(serializer)
				default: {
					serializer.serialize(it).replaceAll("\n", "").replaceAll("\t", "")
				}
			}
		])
	}
	
	private static class CachePropertyLookupJob extends Job {
		val NamedElement element
		val AadlPropertyView propertyView
		val Runnable preUiUpdate
		val Runnable postUiUpdate
		
		new(NamedElement element, AadlPropertyView propertyView, Runnable preUiUpdate, Runnable postUiUpdate) {
			super("Updating Property View")
			this.element = element
			this.propertyView = propertyView
			this.preUiUpdate = preUiUpdate
			this.postUiUpdate = postUiUpdate
			priority = SHORT
		}
		
		override protected run(IProgressMonitor monitor) {
			propertyView.site.shell.display.syncExec(preUiUpdate)
			val extension scopeProvider = propertyView.scopeProvider
			//Build a collection of PropertySets that are visible from the selected element.  Unresolvable proxies are filtered out.
			val propertySets = element.getScope(Aadl2Package.eINSTANCE.packageSection_ImportedUnit).allElements.map[
				if (EObjectOrProxy.eIsProxy) {
					EcoreUtil.resolve(EObjectOrProxy, element)
				} else {
					EObjectOrProxy
				}
			].filter[!eIsProxy].filter(PropertySet)
			/* 
			 * Build a map from PropertySets to a collection of their owned Properties.  Properties that do not apply to the selected element are filtered out.
			 * PropertySets without any applicable properties are filtered out.
			 */
			val properties = propertySets.toInvertedMap[ownedProperties.filter[element.acceptsProperty(it)]].filter[propertySet, acceptableProperties | !acceptableProperties.empty]
			/*
			 * Build a map from PropertySets to a map from Properties to PropertyAssociations (Map<PropertySet, Map<Property, PropertyAssociation>>).  This is
			 * where the property lookup actually happens.  Entries for the PropertyAssociation could be null which means that the Property is undefined,
			 * taking the default value, or the model is incomplete.  In the case that the model is incomplete, we treat the property like it is undefined or
			 * taking the default value.  This whole expression is wrapped in a construction of a new HashMap so that all of the lazy parts of the expression
			 * will be evaluated before we check if the monitor is canceled.  
			 */
			val propertyAssociations = new HashMap(properties.mapValues[
				/*
				 * This whole expression is wrapped in a construction of a new HashMap so that all of the lazy parts of the expression will be evaluated before
				 * we check if the monitor is canceled.
				 */
				new HashMap(toInvertedMap[element.getPropertyValue(it).first].mapValues[
					//This check is for incomplete models which may occur while the user is typing a PropertyAssociation
					if (it != null && (ownedValues.empty || ownedValues.exists[ownedValue == null])) {
						null
					} else {
						it
					}
				])
			])
			if (monitor.canceled) {
				Status.CANCEL_STATUS
			} else {
				propertyView.cachedPropertyAssociations.clear
				propertyView.cachedPropertyAssociations.putAll(propertyAssociations)
				propertyView.site.shell.display.syncExec(postUiUpdate)
				Status.OK_STATUS
			}
		}
	}
	
	/*
	 * This class is here to make sure that the treeViewer's input is not a NamedElement.  This is necessary because a TreeViewer does not work if its input is
	 * also one of the child elements of the tree.
	 */
	private static class NamedElementHolder {
		val NamedElement namedElement
		
		new(NamedElement namedElement) {
			this.namedElement = namedElement
		}
		
		override hashCode() {
			namedElement.hashCode
		}
		
		override equals(Object obj) {
			obj instanceof NamedElementHolder && namedElement == (obj as NamedElementHolder).namedElement
		}
		
		override toString() {
			namedElement.toString
		}
	}
}