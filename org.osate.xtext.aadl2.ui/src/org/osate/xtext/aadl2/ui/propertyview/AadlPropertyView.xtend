package org.osate.xtext.aadl2.ui.propertyview;

import com.google.inject.Inject
import java.util.List
import org.eclipse.core.runtime.IAdaptable
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain
import org.eclipse.emf.edit.domain.EditingDomain
import org.eclipse.jface.action.Action
import org.eclipse.jface.layout.TreeColumnLayout
import org.eclipse.jface.text.ITextSelection
import org.eclipse.jface.viewers.ColumnPixelData
import org.eclipse.jface.viewers.ColumnWeightData
import org.eclipse.jface.viewers.IPostSelectionProvider
import org.eclipse.jface.viewers.ISelection
import org.eclipse.jface.viewers.ISelectionChangedListener
import org.eclipse.jface.viewers.IStructuredSelection
import org.eclipse.jface.viewers.TreeViewer
import org.eclipse.jface.viewers.TreeViewerColumn
import org.eclipse.jface.window.Window
import org.eclipse.jface.wizard.WizardDialog
import org.eclipse.swt.SWT
import org.eclipse.swt.graphics.GC
import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.widgets.Label
import org.eclipse.ui.IPartListener
import org.eclipse.ui.ISelectionListener
import org.eclipse.ui.IWorkbenchPart
import org.eclipse.ui.part.PageBook
import org.eclipse.ui.part.ViewPart
import org.eclipse.xtext.linking.ILinker
import org.eclipse.xtext.resource.EObjectAtOffsetHelper
import org.eclipse.xtext.scoping.IScopeProvider
import org.eclipse.xtext.serializer.ISerializer
import org.eclipse.xtext.ui.editor.XtextEditor
import org.eclipse.xtext.ui.editor.model.IXtextDocument
import org.eclipse.xtext.ui.editor.model.IXtextModelListener
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode
import org.osate.aadl2.NamedElement
import org.osate.aadl2.PropertySet
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil
import org.osate.xtext.aadl2.parser.antlr.Aadl2Parser
import org.osate.xtext.aadl2.ui.MyAadl2Activator
import org.osate.xtext.aadl2.ui.propertyview.associationwizard.PropertyAssociationWizard

/**
 * View that displays the AADL property value associations within a given AADL
 * model element.
 *
 * @author aarong
 */
class AadlPropertyView extends ViewPart {
	val static SHOW_UNDEFINED_TRUE_TOOL_TIP = "Click to hide undefined properties"
	val static SHOW_UNDEFINED_FALSE_TOOL_TIP = "Click to show undefined properties"

	val static NO_PROPERTIES_TO_SHOW = "No properties to show: Please select a single object that is an AADL Property Holder."

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

	/**
	 * Action for toggling the display of nonexistent properties
	 */
	var Action showUndefinedAction = null

	/**
	 * Action for creating a new Property Association without using any information
	 * from this view's selection
	 */
	var Action addNewPropertyAssociationToolbarAction = null

	/**
	 * Model
	 */
	var PropertyViewModel model = null

	/**
	 * The currently viewed model element
	 */
	/*
	 * This variable is used to carry the current selection across reloads
	 */
	var URI currentSelectionUri = null

	/**
	 * The editing domain for {@link #getCurrentElement()}.
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

		override public void partClosed(IWorkbenchPart part) {
		}

		override public void partBroughtToTop(IWorkbenchPart part) {
		}

		override public void partActivated(IWorkbenchPart part) {
			if (part instanceof XtextEditor) {
				val selectionProvider = part.internalSourceViewer.selectionProvider
				if (selectionProvider instanceof IPostSelectionProvider) {
					selectionProvider.addPostSelectionChangedListener(selectionChangedListener)
					activeEditor = part
				}
			}
		}
	}

	val ISelectionChangedListener selectionChangedListener = [updateSelection(activeEditor, selection)]

	val IXtextModelListener xtextModelListener = [resourceSetFromModelListener = resourceSet]

	var ResourceSet resourceSetFromModelListener = null
	
	var XtextEditor activeEditor = null

	
	override createPartControl(Composite parent) {
		pageBook = new PageBook(parent, SWT.NULL)

		noPropertiesLabel = new Label(pageBook, SWT.LEFT) => [
			text = NO_PROPERTIES_TO_SHOW
			alignment = SWT.CENTER
			background = parent.display.getSystemColor(SWT.COLOR_LIST_BACKGROUND)
		]

		model = new PropertyViewModel(serializer, scopeProvider) => [
			showUndefined = false
		]
		
		treeViewerComposite = new Composite(pageBook, SWT.NULL) => [
			val treeColumnLayout = new TreeColumnLayout
			layout = treeColumnLayout
			treeViewer = new TreeViewer(it, SWT.H_SCROLL.bitwiseOr(SWT.V_SCROLL).bitwiseOr(SWT.FULL_SELECTION)) => [
				new TreeViewerColumn(it, SWT.LEFT) => [
					column.text = "Property"
					column.moveable = true
					labelProvider = PropertyViewModel.getPropertyColumnLabelProvider
					treeColumnLayout.setColumnData(column, new ColumnWeightData(1, true))
				]
				new TreeViewerColumn(it, SWT.LEFT) => [
					column.text = "Value"
					column.moveable = true
					labelProvider = PropertyViewModel.getValueColumnLabelProvider
					treeColumnLayout.setColumnData(column, new ColumnWeightData(2, true))
//					tvColumn.editingSupport = PropertyViewModel.getValueEditingSupport(treeViewer)
				]
				new TreeViewerColumn(it, SWT.LEFT) => [
					column.text = "Status"
					column.moveable = true
					labelProvider = PropertyViewModel.getStatusColumnLabelProvider
					val gc = new GC(column.parent)
					treeColumnLayout.setColumnData(column, new ColumnPixelData(#[
						PropertyViewModel.STATUS_LOCAL, PropertyViewModel.STATUS_INHERITED, PropertyViewModel.STATUS_DEFAULT, PropertyViewModel.UNDEFINED
					].map[gc.stringExtent(it).x].max + 5, true, true))
					gc.dispose
				]
				tree.linesVisible = true
				tree.headerVisible = true
				contentProvider = PropertyViewModel.getContentProvider(model)
			]
		]
		
		// Show the "nothing to show" page by default
		pageBook.showPage(noPropertiesLabel)
		site.page.addSelectionListener(selectionListener)
		site.page.addPartListener(partListener)
		createActions
		fillToolbar
	}

	override dispose() {
		site.page.removeSelectionListener(selectionListener)
		site.page.removePartListener(partListener)
		val editorSelectionProvider = activeEditor?.internalSourceViewer?.selectionProvider
		if (editorSelectionProvider instanceof IPostSelectionProvider) {
			editorSelectionProvider.removePostSelectionChangedListener(selectionChangedListener);
		}
	}

	def private createActions() {
		showUndefinedAction = new Action {
			override run() {
				model.toggleShowUndefined
				updateActionStates
				treeViewer.input = model.input
				treeViewer.expandAll
			}
		} => [
			imageDescriptor = MyAadl2Activator.getImageDescriptor("icons/propertyview/nonexistent_property.gif")
		]

		addNewPropertyAssociationToolbarAction = new Action {
			override run() {
				if (new WizardDialog(viewSite.workbenchWindow.shell,
					new PropertyAssociationWizard(xtextDocument, editingDomain?.commandStack, currentSelectionUri, serializer, aadl2Parser, linker)
				).open == Window.OK) {
					updateView
				}
			}
		} => [
			toolTipText = "New Property Association"
			imageDescriptor = MyAadl2Activator.getImageDescriptor("icons/propertyview/new_pa.gif")
			enabled = currentSelectionUri != null
		]

		updateActionStates
	}

	def private updateActionStates() {
		val flag = model.showUndefined
		showUndefinedAction.checked = flag
		showUndefinedAction.toolTipText = if (flag) {
			SHOW_UNDEFINED_TRUE_TOOL_TIP
		} else {
			SHOW_UNDEFINED_FALSE_TOOL_TIP
		}
	}

	def private fillToolbar() {
		viewSite.actionBars.toolBarManager => [
			add(showUndefinedAction)
			add(addNewPropertyAssociationToolbarAction)
		]
	}

	override setFocus() {
		treeViewer.tree.setFocus
	}

	def private getCurrentElement() {
		if (currentSelectionUri != null) {
			(if (xtextDocument == null || resourceSetFromModelListener == null) {
				OsateResourceUtil.getResourceSet
			} else {
				resourceSetFromModelListener
			}).getEObject(currentSelectionUri, true) as NamedElement
		}
	}

	/**
	 * Update the view's contents.
	 */
	def private updateView() {
		if (currentSelectionUri != null) {
			buildNewModel(currentElement)
			pageBook.showPage(treeViewerComposite)
			addNewPropertyAssociationToolbarAction.enabled = true
		} else {
			pageBook.showPage(noPropertiesLabel)
			addNewPropertyAssociationToolbarAction.enabled = false
		}
	}

	def private buildNewModel(NamedElement element) {
		if (element != null && element.eResource != null) {
			model.rebuildModel(element, [|
				if (!treeViewer.tree.disposed) {
					treeViewer.input = model.input
					treeViewer.expandAll
				}
			])
		}
	}

	def private updateSelection(IWorkbenchPart part, ISelection selection) {
		xtextDocument?.removeModelListener(xtextModelListener)
		val currentSelection = switch selection {
			case selection.isEmpty: {
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
		if (currentSelection instanceof NamedElement && currentSelection.eResource != null) {
			currentSelectionUri = EcoreUtil.getURI(currentSelection)
			editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(currentSelection)
		} else {
			currentSelectionUri = null
			editingDomain = null
		}
		xtextDocument?.addModelListener(xtextModelListener)

		// Update the view page
		updateView
	}
}