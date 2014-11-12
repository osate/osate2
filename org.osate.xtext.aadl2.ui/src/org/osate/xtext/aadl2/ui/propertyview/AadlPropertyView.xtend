package org.osate.xtext.aadl2.ui.propertyview;

import com.google.inject.Inject
import de.itemis.xtext.utils.jface.viewers.XtextStyledTextCellEditor
import java.util.Collections
import java.util.HashMap
import java.util.List
import java.util.Map
import org.eclipse.core.runtime.IAdaptable
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.Status
import org.eclipse.core.runtime.jobs.Job
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain
import org.eclipse.emf.edit.domain.EditingDomain
import org.eclipse.jface.action.Action
import org.eclipse.jface.action.IAction
import org.eclipse.jface.layout.TreeColumnLayout
import org.eclipse.jface.text.ITextSelection
import org.eclipse.jface.viewers.ColumnLabelProvider
import org.eclipse.jface.viewers.ColumnPixelData
import org.eclipse.jface.viewers.ColumnWeightData
import org.eclipse.jface.viewers.EditingSupport
import org.eclipse.jface.viewers.ILazyTreeContentProvider
import org.eclipse.jface.viewers.IPostSelectionProvider
import org.eclipse.jface.viewers.ISelection
import org.eclipse.jface.viewers.ISelectionChangedListener
import org.eclipse.jface.viewers.IStructuredSelection
import org.eclipse.jface.viewers.TreeViewer
import org.eclipse.jface.viewers.TreeViewerColumn
import org.eclipse.jface.viewers.Viewer
import org.eclipse.jface.window.Window
import org.eclipse.jface.wizard.WizardDialog
import org.eclipse.swt.SWT
import org.eclipse.swt.graphics.GC
import org.eclipse.swt.graphics.Image
import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.widgets.Label
import org.eclipse.ui.IPartListener
import org.eclipse.ui.ISelectionListener
import org.eclipse.ui.IWorkbenchPart
import org.eclipse.ui.part.PageBook
import org.eclipse.ui.part.ViewPart
import org.eclipse.xtext.linking.ILinker
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.resource.EObjectAtOffsetHelper
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.scoping.IScopeProvider
import org.eclipse.xtext.serializer.ISerializer
import org.eclipse.xtext.ui.editor.XtextEditor
import org.eclipse.xtext.ui.editor.model.IXtextDocument
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode
import org.eclipse.xtext.util.concurrent.IUnitOfWork
import org.eclipse.xtext.validation.IConcreteSyntaxValidator
import org.osate.aadl2.Aadl2Package
import org.osate.aadl2.BasicProperty
import org.osate.aadl2.BasicPropertyAssociation
import org.osate.aadl2.ComponentClassifier
import org.osate.aadl2.Element
import org.osate.aadl2.IntegerLiteral
import org.osate.aadl2.ListValue
import org.osate.aadl2.ModalPropertyValue
import org.osate.aadl2.NamedElement
import org.osate.aadl2.NumberValue
import org.osate.aadl2.Property
import org.osate.aadl2.PropertyAssociation
import org.osate.aadl2.PropertyExpression
import org.osate.aadl2.PropertySet
import org.osate.aadl2.PropertyType
import org.osate.aadl2.RangeValue
import org.osate.aadl2.RealLiteral
import org.osate.aadl2.RecordType
import org.osate.aadl2.RecordValue
import org.osate.aadl2.UnitLiteral
import org.osate.aadl2.instance.InstanceReferenceValue
import org.osate.xtext.aadl2.parser.antlr.Aadl2Parser
import org.osate.xtext.aadl2.ui.MyAadl2Activator
import org.osate.xtext.aadl2.ui.propertyview.associationwizard.PropertyAssociationWizard

import static extension org.eclipse.xtext.EcoreUtil2.getContainerOfType
import static extension org.osate.aadl2.modelsupport.util.AadlUtil.getBasePropertyType
import static extension org.osate.xtext.aadl2.ui.propertyview.AadlPropertyView.*

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
			switch treeElement : (element as Pair<Object, Object>).value {
				PropertySet: treeElement.name
				Property: treeElement.name
				ModalPropertyValue: {
					val modes = if (treeElement.allInModes.empty) {
						//This ModalPropertyValue exists in all modes that are not listed for other ModalPropertyValues
						(input as ComponentClassifier).allModes.filter[classifierMode | (treeElement.owner as PropertyAssociation).ownedValues.forall[!allInModes.contains(classifierMode)]]
					} else {
						treeElement.allInModes
					}
					'''in modes («modes.map[name].join(", ")»)'''
				}
				IntegerLiteral: "aadlinteger"
				RealLiteral: "aadlreal"
				UnitLiteral: "unit"
				Pair<Object, PropertyExpression>: {
					switch key : treeElement.key {
						String: key
						Integer: "# " + key
					}
				}
				BasicPropertyAssociation: treeElement.property.name
				BasicProperty case !(treeElement instanceof Property): treeElement.name
			}
		}
		
		override getForeground(Object element) {
			switch treeElement : (element as Pair<Object, Object>).value {
				Property case cachedPropertyAssociations.get(treeElement.owner).get(treeElement) == null && treeElement.defaultValue == null,
				BasicProperty case !(treeElement instanceof Property): site.shell.display.getSystemColor(SWT.COLOR_RED)
			}
		}
		
		override getImage(Object element) {
			switch treeElement : (element as Pair<Object, Object>).value {
				PropertySet: propSetImage ?: (propSetImage = MyAadl2Activator.getImageDescriptor(PROPERTY_SET_ICON).createImage)
				Property case treeElement.list: listImage ?: (listImage = MyAadl2Activator.getImageDescriptor(LIST_ICON).createImage)
				Property case !treeElement.list: scalarImage ?: (scalarImage = MyAadl2Activator.getImageDescriptor(SCALAR_ICON).createImage)
				ModalPropertyValue: modeImage ?: (modeImage = MyAadl2Activator.getImageDescriptor(MODE_ICON).createImage)
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
			switch resolvedElement : (element as Pair<Object, Object>).value.resolveIfProxy {
				Property: {
					val association = cachedPropertyAssociations.get(resolvedElement.owner).get(resolvedElement)
					if (association == null) {
						resolvedElement.defaultValue?.getValueAsString(serializer)
					} else if (!association.modal) {
						association.ownedValues.head.ownedValue.getValueAsString(serializer)
					}
				}
				ModalPropertyValue: resolvedElement.ownedValue.getValueAsString(serializer)
				NumberValue: {
					val serializedNumberValue = resolvedElement.getValueAsString(serializer)
					serializedNumberValue.substring(0, serializedNumberValue.toUpperCase.lastIndexOf(resolvedElement.unit.name.toUpperCase)).trim
				}
				UnitLiteral: resolvedElement.name
				Pair<Object, PropertyExpression>: resolvedElement.value.resolveIfProxy.getValueAsString(serializer)
				BasicPropertyAssociation: resolvedElement.value.getValueAsString(serializer)
			}
		}
	}
	
	val statusColumnLabelProvider = new ColumnLabelProvider {
		override getText(Object element) {
			switch treeElement : (element as Pair<Object, Object>).value {
				Property: {
					val association = cachedPropertyAssociations.get(treeElement.owner).get(treeElement)
					if (association != null) {
						if (input == association.owner) {
							STATUS_LOCAL
						} else {
							STATUS_INHERITED
						}
					} else {
						if (treeElement.defaultValue != null) {
							STATUS_DEFAULT
						} else {
							STATUS_UNDEFINED
						}
					}
				}
				BasicPropertyAssociation: {
					switch containingAssociation : treeElement.getContainerOfType(PropertyAssociation) {
						case null: STATUS_DEFAULT
						case containingAssociation.owner == input: STATUS_LOCAL
						default: STATUS_INHERITED
					}
				}
				BasicProperty case !(treeElement instanceof Property): STATUS_UNDEFINED
			}
		}
		
		override getForeground(Object element) {
			switch treeElement : element {
				Property case cachedPropertyAssociations.get(treeElement.owner).get(treeElement) == null && treeElement.defaultValue == null,
				BasicProperty case !(treeElement instanceof Property): site.shell.display.getSystemColor(SWT.COLOR_RED)
			}
		}
	}
	
	val propertyViewContentProvider = new ILazyTreeContentProvider {
		override inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}
		
		override updateChildCount(Object element, int currentChildCount) {
			val castedElement = element as Pair<Object, Object>
			val childCount = if (castedElement.key == null) {
				if (showUndefinedAction.checked) {
					cachedPropertyAssociations.size
				} else {
					cachedPropertyAssociations.values.filter[entrySet.exists[value != null || key.defaultValue != null]].size
				}
			} else {
				switch treeElement : castedElement.value {
					PropertySet: {
						if (showUndefinedAction.checked) {
							cachedPropertyAssociations.get(treeElement).size
						} else {
							cachedPropertyAssociations.get(treeElement).filter[property, propertyAssociation | propertyAssociation != null || property.defaultValue != null].size
						}
					}
					Property: {
						val association = cachedPropertyAssociations.get(treeElement.owner).get(treeElement)
						if (association == null) {
							getChildCount(treeElement.defaultValue, treeElement.propertyType, null)
						} else if (association.modal) {
							association.ownedValues.size
						} else {
							getChildCount(association.ownedValues.head.ownedValue, treeElement.propertyType, treeElement.defaultValue)
						}
					}
					ModalPropertyValue: {
						getChildCount(treeElement.ownedValue, treeElement.getContainerOfType(PropertyAssociation).property.propertyType,
							treeElement.getContainerOfType(PropertyAssociation).property.defaultValue
						)
					}
					Pair<Object, PropertyExpression>: {
						switch treeElement.key {
							String: {
								switch value : treeElement.value {
									NumberValue case value.unit != null: 2
									default: 0
								}
							}
							Integer: {
								getChildCount(treeElement.value, (treeElement.value.getContainerOfType(BasicPropertyAssociation)?.property ?:
									treeElement.value.getContainerOfType(PropertyAssociation)?.property ?:
									treeElement.value.getContainerOfType(Property)
								).propertyType.basePropertyType, null)
							}
						}
					}
					BasicPropertyAssociation: getChildCount(treeElement.value, treeElement.property.propertyType, null)
					default: 0
				}
			}
			if (currentChildCount != childCount) {
				treeViewer.setChildCount(element, childCount)
			}
		}
		
		def private getChildCount(PropertyExpression expression, PropertyType propertyType, PropertyExpression defaultValue) {
			switch expression {
				NumberValue case expression.unit != null: 2
				RangeValue case expression.delta == null: 2
				RangeValue case expression.delta != null: 3
				RecordValue: {
					switch propertyType {
						RecordType case showUndefinedAction.checked: propertyType.ownedFields.size
						RecordType case !showUndefinedAction.checked: {
							if (defaultValue instanceof RecordValue) {
								propertyType.ownedFields.filter[fieldInType |
									expression.ownedFieldValues.exists[property == fieldInType] || defaultValue.ownedFieldValues.exists[property == fieldInType]
								].size
							} else {
								propertyType.ownedFields.filter[fieldInType | expression.ownedFieldValues.exists[property == fieldInType]].size
							}
						}
						default: 0
					}
				}
				ListValue: expression.ownedListElements.size
				default: 0
			}
		}
		
		override updateElement(Object parent, int index) {
			val castedParent = parent as Pair<Object, Object>
			val childElement = castedParent -> if (castedParent.key == null) {
				val filteredAssociations = if (showUndefinedAction.checked) {
					cachedPropertyAssociations
				} else {
					cachedPropertyAssociations.filter[propertySet, associationsForPropertySet | associationsForPropertySet.entrySet.exists[value != null || key.defaultValue != null]]
				}
				filteredAssociations.keySet.sortBy[name.toUpperCase].get(index)
			} else {
				switch treeElement : castedParent.value {
					PropertySet: {
						val filteredAssociations = if (showUndefinedAction.checked) {
							cachedPropertyAssociations.get(treeElement)
						} else {
							cachedPropertyAssociations.get(treeElement).filter[property, propertyAssociation | propertyAssociation != null || property.defaultValue != null]
						}
						filteredAssociations.keySet.sortBy[name.toUpperCase].get(index)
					}
					Property: {
						val association = cachedPropertyAssociations.get(treeElement.owner).get(treeElement)
						if (association == null) {
							getElement(treeElement.defaultValue, index, treeElement.propertyType, null)
						} else if (association.modal) {
							association.ownedValues.get(index)
						} else {
							getElement(association.ownedValues.head.ownedValue, index, treeElement.propertyType, treeElement.defaultValue)
						}
					}
					ModalPropertyValue: {
						val property = treeElement.getContainerOfType(PropertyAssociation).property
						getElement(treeElement.ownedValue, index, property.propertyType, property.defaultValue)
					}
					Pair<Object, PropertyExpression>: {
						switch treeElement.key {
							String: {
								switch index {
									case 0: treeElement.value
									case 1: (treeElement.value as NumberValue).unit
								}
							}
							Integer: {
								getElement(treeElement.value, index, (treeElement.value.getContainerOfType(BasicPropertyAssociation)?.property ?:
									treeElement.value.getContainerOfType(PropertyAssociation)?.property ?:
									treeElement.value.getContainerOfType(Property)
								).propertyType.basePropertyType, null)
							}
						}
					}
					BasicPropertyAssociation: getElement(treeElement.value, index, treeElement.property.propertyType, null)
				}
			}
			treeViewer.replace(parent, index, childElement)
			updateChildCount(childElement, -1)
		}
		
		def private getElement(PropertyExpression expression, int index, PropertyType propertyType, PropertyExpression defaultValue) {
			switch expression {
				NumberValue: {
					switch index {
						case 0: expression
						case 1: expression.unit
					}
				}
				RangeValue: {
					switch index {
						case 0: "minimum" -> expression.minimum
						case 1: "maximum" -> expression.maximum
						case 2: "delta" -> expression.delta
					}
				}
				RecordValue: {
					val recordType = propertyType as RecordType
					if (showUndefinedAction.checked) {
						val fieldInType = recordType.ownedFields.get(index)
						if (defaultValue instanceof RecordValue) {
							expression.ownedFieldValues.findFirst[property == fieldInType] ?: defaultValue.ownedFieldValues.findFirst[property == fieldInType] ?: fieldInType
						} else {
							expression.ownedFieldValues.findFirst[property == fieldInType] ?: fieldInType
						}
					} else {
						if (defaultValue instanceof RecordValue) {
							recordType.ownedFields.map[fieldInType |
								expression.ownedFieldValues.findFirst[property == fieldInType] ?: defaultValue?.ownedFieldValues?.findFirst[property == fieldInType]
							].filterNull.get(index)
						} else {
							recordType.ownedFields.map[fieldInType | expression.ownedFieldValues.findFirst[property == fieldInType]].filterNull.get(index)
						}
					}
				}
				ListValue: index -> expression.ownedListElements.get(index)
			}
		}
		
		override getParent(Object element) {
			(element as Pair<Object, Object>).key
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
			treeViewer = new TreeViewer(it, SWT.VIRTUAL.bitwiseOr(SWT.H_SCROLL).bitwiseOr(SWT.V_SCROLL).bitwiseOr(SWT.FULL_SELECTION)) => [treeViewer |
				new TreeViewerColumn(treeViewer, SWT.LEFT) => [
					column.text = "Property"
					treeColumnLayout.setColumnData(column, new ColumnWeightData(1, true))
					labelProvider = propertyColumnLabelProvider
				]
				new TreeViewerColumn(treeViewer, SWT.LEFT) => [
					column.text = "Value"
					treeColumnLayout.setColumnData(column, new ColumnWeightData(2, true))
					labelProvider = valueColumnLabelProvider
					editingSupport = createValueColumnEditingSupport(treeViewer)
				]
				new TreeViewerColumn(treeViewer, SWT.LEFT) => [
					column.text = "Status"
					val gc = new GC(column.parent)
					treeColumnLayout.setColumnData(column, new ColumnPixelData(#[STATUS_LOCAL, STATUS_INHERITED, STATUS_DEFAULT, STATUS_UNDEFINED].map[gc.stringExtent(it).x].max + 5, true, true))
					gc.dispose
					labelProvider = statusColumnLabelProvider
				]
				treeViewer.tree.linesVisible = true
				treeViewer.tree.headerVisible = true
				treeViewer.useHashlookup = true
				treeViewer.contentProvider = propertyViewContentProvider
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
		if (cachePropertyLookupJob != null) {
			cachePropertyLookupJob.cancel
			cachePropertyLookupJob = null
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
	
	def private createValueColumnEditingSupport(TreeViewer treeViewer) {
		new EditingSupport(treeViewer) {
			override protected canEdit(Object element) {
				switch treeElement : (element as Pair<Object, Object>).value {
					PropertySet: false
					Property: {
						val association = cachedPropertyAssociations.get(treeElement.owner).get(treeElement)
						association != null && input == association.owner && !association.modal
					}
					default: {
						println("canEdit: " + treeElement)
						throw new UnsupportedOperationException("TODO: auto-generated method stub")
					}
				}
			}
			
			override protected getCellEditor(Object element) {
				switch treeElement : (element as Pair<Object, Object>).value {
					Property: {
						val association = cachedPropertyAssociations.get(treeElement.owner).get(treeElement)
						if (association != null && input == association.owner && !association.modal) {
							new XtextStyledTextCellEditor(SWT.SINGLE, MyAadl2Activator.getInstance.getInjector(MyAadl2Activator.ORG_OSATE_XTEXT_AADL2_AADL2)) => [
								create(treeViewer.tree)
							]
						} else {
							throw new UnsupportedOperationException("TODO: auto-generated method stub")
						}
					}
					default: {
						println("getCellEditor: " + treeElement)
						throw new UnsupportedOperationException("TODO: auto-generated method stub")
					}
				}
			}
			
			override protected getValue(Object element) {
				switch treeElement : (element as Pair<Object, Object>).value {
					Property: {
						val association = cachedPropertyAssociations.get(treeElement.owner).get(treeElement)
						if (association != null && input == association.owner && !association.modal) {
							val node = NodeModelUtils.getNode(association.ownedValues.head.ownedValue)
							new CellEditorPartialValue(xtextDocument.get(0, node.offset),
								serializer.serialize(association.ownedValues.head.ownedValue).replaceAll("\n", "").replaceAll("\r", "").replaceAll("\t", "").trim,
								xtextDocument.get(node.endOffset, xtextDocument.length - node.endOffset)
							)
						} else {
							throw new UnsupportedOperationException("TODO: auto-generated method stub")
						}
					}
					default: {
						println("getValue: " + treeElement)
						throw new UnsupportedOperationException("TODO: auto-generated method stub")
					}
				}
			}
			
			override protected setValue(Object element, Object value) {
				switch treeElement : (element as Pair<Object, Object>).value {
					Property: {
						val association = cachedPropertyAssociations.get(treeElement.owner).get(treeElement)
						if (association != null && input == association.owner && !association.modal) {
							val associationUri = EcoreUtil.getURI(association)
							val node = NodeModelUtils.getNode(association.ownedValues.head.ownedValue)
							xtextDocument.modify(new IUnitOfWork.Void<XtextResource> {
								override process(XtextResource state) throws Exception {
									state.update(node.offset, node.length, value as String)
								}
							})
							cachedPropertyAssociations.get(treeElement.owner).put(treeElement, input.eResource.resourceSet.getEObject(associationUri, false) as PropertyAssociation)
							treeViewer.refresh(element)
						} else {
							throw new UnsupportedOperationException("TODO: auto-generated method stub")
						}
					}
					default: {
						println("setValue: " + treeElement)
						throw new UnsupportedOperationException("TODO: auto-generated method stub")
					}
				}
			}
		}
	}
	
	def private getInput() {
		(treeViewer.input as Pair<Object, NamedElement>)?.value
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
					if (cachePropertyLookupJob != null && cachePropertyLookupJob.state != Job.NONE) {
						cachePropertyLookupJob.cancel
					}
					cachePropertyLookupJob = createCachePropertyLookupJob(input)
					cachePropertyLookupJob.schedule
				}
			}
		} => [
			toolTipText = "New Property Association"
			imageDescriptor = MyAadl2Activator.getImageDescriptor("icons/propertyview/new_pa.gif")
			enabled = false
			viewSite.actionBars.toolBarManager.add(it)
		]
	}

	def private <T> resolveIfProxy(T possibleProxy) {
		switch possibleProxy {
			EObject case possibleProxy.eIsProxy: {
				EcoreUtil.resolve(possibleProxy, input) as T
			}
			default: {
				possibleProxy
			}
		}
	}

	def private updateSelection(IWorkbenchPart part, ISelection selection) {
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
		if (currentSelection instanceof NamedElement) {
			editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(currentSelection)
			if (currentSelection == previousSelection) {
				pageBook.showPage(treeViewerComposite)
			} else {
				previousSelection = currentSelection
				if (cachePropertyLookupJob != null && cachePropertyLookupJob.state != Job.NONE) {
					cachePropertyLookupJob.cancel
				}
				cachePropertyLookupJob = createCachePropertyLookupJob(currentSelection)
				cachePropertyLookupJob.schedule
			}
		} else {
			if (cachePropertyLookupJob != null) {
				cachePropertyLookupJob.cancel
				cachePropertyLookupJob = null
			}
			pageBook.showPage(noPropertiesLabel)
			addNewPropertyAssociationToolbarAction.enabled = false
			editingDomain = null
			previousSelection = null
		}
	}
	
	def private createCachePropertyLookupJob(NamedElement element) {
		currentSelectionUri = EcoreUtil.getURI(element)
		new CachePropertyLookupJob(element, this, [|
			pageBook.showPage(populatingViewLabel)
			addNewPropertyAssociationToolbarAction.enabled = false
		], [|
			treeViewer.input = null -> element
			pageBook.showPage(treeViewerComposite)
			addNewPropertyAssociationToolbarAction.enabled = true
		])
	}
	
	def private static getValueAsString(Element expression, ISerializer serializer) {
		try {
			switch expression {
				InstanceReferenceValue:
					expression.referencedInstanceObject?.instanceObjectPath ?: "null"
				ListValue case expression.hasInstanceReferenceValue:
					expression.serializeListWithInstanceReferenceValue(serializer)
				default: {
					serializer.serialize(expression).replaceAll("\n", "").replaceAll("\r", "").replaceAll("\t", "").trim
				}
			}
		} catch (IConcreteSyntaxValidator.InvalidConcreteSyntaxException e) {
			//Simply return null.  Expression could not be serialized because the model is invalid.
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
					serializer.serialize(it).replaceAll("\n", "").replaceAll("\r", "").replaceAll("\t", "").trim
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
			val propertyAssociations = if (element.eResource == null) {
				emptyMap
			} else {
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
				new HashMap(properties.mapValues[
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
			}
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
}