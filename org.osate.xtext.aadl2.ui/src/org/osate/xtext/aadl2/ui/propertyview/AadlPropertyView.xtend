/*
 *
 * <copyright>
 * Copyright  2014 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/org/documents/epl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE "DELIVERABLES") ARE ON AN "AS-IS" BASIS.
 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
 * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
 * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
 * MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
 * APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.
 *
 * Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
 * employees, and agents from all claims or demands made against them (and any related losses, expenses, or
 * attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
 * misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
 * assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
 * product liability, personal injury, death, damage to property, or violation of any laws or regulations.
 *
 * Carnegie Mellon Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 * </copyright>
 */
package org.osate.xtext.aadl2.ui.propertyview

import com.google.inject.Inject
import de.itemis.xtext.utils.jface.viewers.XtextStyledTextCellEditor
import java.util.Collections
import java.util.List
import java.util.Map
import org.eclipse.core.runtime.IAdaptable
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.Status
import org.eclipse.core.runtime.jobs.Job
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain
import org.eclipse.emf.edit.domain.EditingDomain
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
import org.eclipse.swt.widgets.Display
import org.eclipse.swt.widgets.Label
import org.eclipse.ui.IPartListener
import org.eclipse.ui.ISelectionListener
import org.eclipse.ui.IWorkbenchActionConstants
import org.eclipse.ui.IWorkbenchPart
import org.eclipse.ui.part.PageBook
import org.eclipse.ui.part.ViewPart
import org.eclipse.xtext.linking.ILinker
import org.eclipse.xtext.nodemodel.ICompositeNode
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.xtext.nodemodel.impl.HiddenLeafNode
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.resource.EObjectAtOffsetHelper
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.scoping.IScopeProvider
import org.eclipse.xtext.serializer.ISerializer
import org.eclipse.xtext.ui.editor.XtextEditor
import org.eclipse.xtext.ui.editor.model.IXtextDocument
import org.eclipse.xtext.ui.editor.model.IXtextModelListener
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode
import org.eclipse.xtext.util.concurrent.IUnitOfWork
import org.eclipse.xtext.validation.IConcreteSyntaxValidator
import org.osate.aadl2.Aadl2Package
import org.osate.aadl2.BasicProperty
import org.osate.aadl2.BasicPropertyAssociation
import org.osate.aadl2.ComponentClassifier
import org.osate.aadl2.Element
import org.osate.aadl2.ListValue
import org.osate.aadl2.ModalPropertyValue
import org.osate.aadl2.NamedElement
import org.osate.aadl2.Property
import org.osate.aadl2.PropertyAssociation
import org.osate.aadl2.PropertyExpression
import org.osate.aadl2.PropertySet
import org.osate.aadl2.PropertyType
import org.osate.aadl2.RangeValue
import org.osate.aadl2.RecordType
import org.osate.aadl2.RecordValue
import org.osate.aadl2.instance.InstanceReferenceValue
import org.osate.xtext.aadl2.parser.antlr.Aadl2Parser
import org.osate.xtext.aadl2.ui.MyAadl2Activator
import org.osate.xtext.aadl2.ui.propertyview.associationwizard.PropertyAssociationWizard

import static extension org.eclipse.emf.ecore.util.EcoreUtil.getURI
import static extension org.eclipse.xtext.EcoreUtil2.getContainerOfType
import static extension org.eclipse.xtext.nodemodel.util.NodeModelUtils.getNode
import static extension org.osate.aadl2.modelsupport.util.AadlUtil.getBasePropertyType
import static extension org.osate.xtext.aadl2.ui.propertyview.AadlPropertyView.*

/**
 * View that displays the AADL property value associations within a given AADL
 * model element.
 *
 * @author aarong
 */
class AadlPropertyView extends ViewPart {
	val static EMBEDDED_RESOURCE_NAME_SUFFIX = "_embedded_for_property_view_cell_editor"
	
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
	val static STATUS_LOCAL_CONTAINED = "local contained"
	val static STATUS_INHERITED = "inherited"
	val static STATUS_DEFAULT = "default"
	
	val static MINIMUM_LABEL = "minimum"
	val static MAXIMUM_LABEL = "maximum"
	val static DELTA_LABEL = "delta"
	
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
	
	var Action removeElementAction = null
	
	/**
	 * The editing domain for the viewer's input
	 */
	var EditingDomain editingDomain = null

	var IXtextDocument xtextDocument = null

	var ResourceSet resourceSet = null
	
	@Inject
	var ISerializer serializer

	@Inject
	var Aadl2Parser aadl2Parser

	@Inject
	var ILinker linker

	@Inject
	var IScopeProvider scopeProvider
	
	var URI previousSelectionURI = null
	
	var String initialEditablePart
	
	var CachePropertyLookupJob cachePropertyLookupJob = null
	val jobLock = new Object
	
	//If the URIs were resolved to EObjects, then this would be a Map<PropertySet, Map<Property, PropertyAssociation>>
	val Map<URI, Map<URI, URI>> cachedPropertyAssociations = Collections.synchronizedMap(newLinkedHashMap)
	
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
	
	val IXtextModelListener xtextModelListener = [synchronized (jobLock) {
		if (cachePropertyLookupJob != null && cachePropertyLookupJob.state != Job.NONE) {
			cachePropertyLookupJob.cancel
		}
		if (input != null) {
			cachePropertyLookupJob = createCachePropertyLookupJob(input)
			cachePropertyLookupJob.schedule
		}
	}]
	
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
				URI: treeElement.getEObjectAndRun[switch it {
					PropertySet: name
					Property: name
					ModalPropertyValue: {
						val modes = if (allInModes.empty) {
							//This ModalPropertyValue exists in all modes that are not listed for other ModalPropertyValues
							input.getEObjectAndRun[ComponentClassifier classifier |
								classifier.allModes.filter[classifierMode | (owner as PropertyAssociation).ownedValues.forall[!allInModes.contains(classifierMode)]]
							]
						} else {
							allInModes
						}
						'''in modes («modes.map[name].join(", ")»)'''
					}
					BasicPropertyAssociation: property.name
					BasicProperty case !(it instanceof Property): name
				}]
				Pair<?, URI>: switch key : treeElement.key {
					String: key
					Integer: "# " + key
				}
			}
		}
		
		override getForeground(Object element) {
			val treeElement = (element as Pair<Object, Object>).value
			if (treeElement instanceof URI) {
				treeElement.getEObjectAndRun[switch it {
					Property case cachedPropertyAssociations.get((element as Pair<Pair<Object, URI>, Object>).key.value).get(treeElement) == null && defaultValue == null,
					BasicProperty case !(it instanceof Property): site.shell.display.getSystemColor(SWT.COLOR_RED)
				}]
			}
		}
		
		override getImage(Object element) {
			val treeElement = (element as Pair<Object, Object>).value
			if (treeElement instanceof URI) {
				treeElement.getEObjectAndRun[switch it {
					PropertySet: propSetImage ?: (propSetImage = MyAadl2Activator.getImageDescriptor(PROPERTY_SET_ICON).createImage)
					Property case list: listImage ?: (listImage = MyAadl2Activator.getImageDescriptor(LIST_ICON).createImage)
					Property case !list: scalarImage ?: (scalarImage = MyAadl2Activator.getImageDescriptor(SCALAR_ICON).createImage)
					ModalPropertyValue: modeImage ?: (modeImage = MyAadl2Activator.getImageDescriptor(MODE_ICON).createImage)
				}]
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
			switch treeElement : (element as Pair<Object, Object>).value {
				URI: treeElement.getEObjectAndRun[switch it {
					Property: {
						val associationURI = cachedPropertyAssociations.get((element as Pair<Pair<Object, URI>, Object>).key.value).get(treeElement)
						if (associationURI == null) {
							defaultValue?.getValueAsString(serializer)
						} else {
							associationURI.getEObjectAndRun[PropertyAssociation association |
								if (!association.modal) {
									association.ownedValues.head.ownedValue.getValueAsString(serializer)
								}
							]
						}
					}
					ModalPropertyValue: ownedValue.getValueAsString(serializer)
					BasicPropertyAssociation: value.getValueAsString(serializer)
				}]
				Pair<Object, URI>: treeElement.value.getEObjectAndRun[PropertyExpression it | getValueAsString(serializer)]
			}
		}
		
		override getForeground(Object element) {
			if (!canEdit(element)) {
				site.shell.display.getSystemColor(SWT.COLOR_GRAY)
			}
		}
	}
	
	val statusColumnLabelProvider = new ColumnLabelProvider {
		override getText(Object element) {
			val treeElement = (element as Pair<Object, Object>).value
			if (treeElement instanceof URI) {
				treeElement.getEObjectAndRun[switch it {
					Property: {
						cachedPropertyAssociations.get((element as Pair<Pair<Object, URI>, Object>).key.value).get(treeElement)?.getEObjectAndRun[PropertyAssociation association |
							input.getEObjectAndRun[inputElement |
								if (inputElement == association.owner) {
									STATUS_LOCAL
								} else if (association.appliesTos.exists[inputElement == containmentPathElements.last.namedElement]) {
									STATUS_LOCAL_CONTAINED
								} else {
									STATUS_INHERITED
								}
							]
						] ?: if (defaultValue != null) {
							STATUS_DEFAULT
						} else {
							STATUS_UNDEFINED
						}
					}
					BasicPropertyAssociation: {
						val containingAssociation = getContainerOfType(PropertyAssociation)
						if (containingAssociation == null) {
							STATUS_DEFAULT
						} else {
							input.getEObjectAndRun[inputElement | if (inputElement == containingAssociation.owner) {
								STATUS_LOCAL
							} else if (containingAssociation.appliesTos.exists[inputElement == containmentPathElements.last.namedElement]) {
								STATUS_LOCAL_CONTAINED
							} else {
								STATUS_INHERITED
							}]
						}
					}
					BasicProperty case !(it instanceof Property): STATUS_UNDEFINED
				}]
			}
		}
		
		override getForeground(Object element) {
			val treeElement = (element as Pair<Object, Object>).value
			if (treeElement instanceof URI) {
				treeElement.getEObjectAndRun[switch it {
					Property case cachedPropertyAssociations.get((element as Pair<Pair<Object, URI>, Object>).key.value).get(treeElement) == null && defaultValue == null,
					BasicProperty case !(it instanceof Property): site.shell.display.getSystemColor(SWT.COLOR_RED)
				}]
			}
		}
	}
	
	val propertyViewContentProvider = new ILazyTreeContentProvider {
		override inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}
		
		override updateChildCount(Object element, int currentChildCount) {
			val childCount = switch element {
				URI: {
					if (showUndefinedAction.checked) {
						cachedPropertyAssociations.size
					} else {
						cachedPropertyAssociations.values.filter[entrySet.exists[value != null || key.getEObjectAndRun[Property it | defaultValue != null]]].size
					}
				}
				Pair<Object, Object>: switch treeElement : element.value {
					URI: treeElement.getEObjectAndRun[switch it {
						PropertySet: {
							if (showUndefinedAction.checked) {
								cachedPropertyAssociations.get(treeElement).size
							} else {
								cachedPropertyAssociations.get(treeElement).filter[propertyURI, propertyAssociationURI |
									propertyAssociationURI != null || propertyURI.getEObjectAndRun[Property it | defaultValue != null]
								].size
							}
						}
						Property: {
							val associationURI = cachedPropertyAssociations.get((element.key as Pair<URI, URI>).value).get(treeElement)
							if (associationURI == null) {
								getChildCount(defaultValue, propertyType, null)
							} else {
								associationURI.getEObjectAndRun[PropertyAssociation association |
									if (association.modal) {
										association.ownedValues.size
									} else {
										getChildCount(association.ownedValues.head.ownedValue, propertyType, defaultValue)
									}
								]
							}
						}
						ModalPropertyValue: getChildCount(ownedValue, getContainerOfType(PropertyAssociation).property.propertyType, getContainerOfType(PropertyAssociation).property.defaultValue)
						BasicPropertyAssociation: getChildCount(value, property.propertyType, null)
						default: 0
					}]
					Pair<Object, URI>: switch treeElement.key {
						String: 0
						Integer: treeElement.value.getEObjectAndRun[PropertyExpression it |
							getChildCount(it, (
								getContainerOfType(BasicPropertyAssociation)?.property ?: getContainerOfType(PropertyAssociation)?.property ?: getContainerOfType(Property)
							).propertyType.basePropertyType, null)
						]
					}
				}
			}
			if (currentChildCount != childCount) {
				treeViewer.setChildCount(element, childCount)
			}
		}
		
		def private getChildCount(PropertyExpression expression, PropertyType propertyType, PropertyExpression defaultValue) {
			switch expression {
				RangeValue case expression.delta == null: 2
				RangeValue case expression.delta != null: 3
				RecordValue: switch propertyType {
					RecordType case showUndefinedAction.checked: propertyType.ownedFields.size
					RecordType case !showUndefinedAction.checked: {
						if (defaultValue instanceof RecordValue) {
							propertyType.ownedFields.filter[fieldInType | expression.ownedFieldValues.exists[property == fieldInType] || defaultValue.ownedFieldValues.exists[property == fieldInType]].size
						} else {
							propertyType.ownedFields.filter[fieldInType | expression.ownedFieldValues.exists[property == fieldInType]].size
						}
					}
					default: 0
				}
				ListValue: expression.ownedListElements.size
				default: 0
			}
		}
		
		override updateElement(Object parent, int index) {
			val Pair<Object, Object> childElement = parent -> switch parent {
				URI: {
					val filteredAssociations = if (showUndefinedAction.checked) {
						cachedPropertyAssociations
					} else {
						cachedPropertyAssociations.filter[propertySetURI, associationsForPropertySet |
							associationsForPropertySet.entrySet.exists[value != null || key.getEObjectAndRun[Property it | defaultValue != null]]
						]
					}
					filteredAssociations.keySet.sortBy[getEObjectAndRun[PropertySet it | name.toUpperCase]].get(index)
				}
				Pair<?, ?>: switch treeElement : parent.value {
					URI: treeElement.getEObjectAndRun[switch it {
						PropertySet: {
							val filteredAssociations = if (showUndefinedAction.checked) {
								cachedPropertyAssociations.get(treeElement)
							} else {
								cachedPropertyAssociations.get(treeElement).filter[propertyURI, propertyAssociationURI |
									propertyAssociationURI != null || propertyURI.getEObjectAndRun[Property it | defaultValue != null]
								]
							}
							filteredAssociations.keySet.sortBy[getEObjectAndRun[Property it | name.toUpperCase]].get(index)
						}
						Property: {
							val associationURI = cachedPropertyAssociations.get((parent.key as Pair<URI, URI>).value).get(treeElement)
							if (associationURI == null) {
								getElement(defaultValue, index, propertyType, null)
							} else {
								associationURI.getEObjectAndRun[PropertyAssociation association |
									if (association.modal) {
										association.ownedValues.get(index).getURI
									} else {
										getElement(association.ownedValues.head.ownedValue, index, propertyType, defaultValue)
									}
								]
							}
						}
						ModalPropertyValue: {
							val property = getContainerOfType(PropertyAssociation).property
							getElement(ownedValue, index, property.propertyType, property.defaultValue)
						}
						BasicPropertyAssociation: getElement(value, index, property.propertyType, null)
					}]
					Pair<Integer, URI>: treeElement.value.getEObjectAndRun[PropertyExpression it |
						getElement(it, index, (
							getContainerOfType(BasicPropertyAssociation)?.property ?: getContainerOfType(PropertyAssociation)?.property ?: getContainerOfType(Property)
						).propertyType.basePropertyType, null)
					]
				}
			}
			treeViewer.replace(parent, index, childElement)
			updateChildCount(childElement, -1)
		}
		
		def private getElement(PropertyExpression expression, int index, PropertyType propertyType, PropertyExpression defaultValue) {
			switch expression {
				RangeValue: switch index {
					case 0: MINIMUM_LABEL -> expression.minimum.getURI
					case 1: MAXIMUM_LABEL -> expression.maximum.getURI
					case 2: DELTA_LABEL -> expression.delta.getURI
				}
				RecordValue: {
					val recordType = propertyType as RecordType
					(if (showUndefinedAction.checked) {
						val fieldInType = recordType.ownedFields.get(index)
						if (defaultValue instanceof RecordValue) {
							expression.ownedFieldValues.findFirst[property == fieldInType] ?: defaultValue.ownedFieldValues.findFirst[property == fieldInType] ?: fieldInType
						} else {
							expression.ownedFieldValues.findFirst[property == fieldInType] ?: fieldInType
						}
					} else {
						if (defaultValue instanceof RecordValue) {
							recordType.ownedFields.map[fieldInType |
								expression.ownedFieldValues.findFirst[property == fieldInType] ?: defaultValue.ownedFieldValues.findFirst[property == fieldInType]
							].filterNull.get(index)
						} else {
							recordType.ownedFields.map[fieldInType | expression.ownedFieldValues.findFirst[property == fieldInType]].filterNull.get(index)
						}
					}).getURI
				}
				ListValue: index -> expression.ownedListElements.get(index).getURI
			}
		}
		
		override getParent(Object element) {
			if (element instanceof Pair<?, ?>) {
				element.key
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
					treeColumnLayout.setColumnData(column,
						new ColumnPixelData(#[STATUS_LOCAL, STATUS_LOCAL_CONTAINED, STATUS_INHERITED, STATUS_DEFAULT, STATUS_UNDEFINED].map[gc.stringExtent(it).x].max + 5, true, true)
					)
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
		createContextMenu
	}

	override dispose() {
		synchronized (jobLock) {
			if (cachePropertyLookupJob != null) {
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
	
	def private static getLastLeaf(ICompositeNode node) {
		var INode result = node
		while (result instanceof ICompositeNode) {
			result = result.lastChild
		}
		result ?: node
	}
	
	def private static getPreviousNode(INode node) {
		var lln = node.previousSibling
		while (lln instanceof HiddenLeafNode) {
			lln = lln.previousSibling
		}
		lln
	}
	
	def private Pair<?, ?> getPropertyParent(Pair<?, ?> element) {
		if (element.value instanceof URI && (element.value as URI).getEObjectAndRun[it instanceof Property]) {
			element
		} else {
			(element.key as Pair<Object, Object>).propertyParent
		}
	}
	
	def private canEdit(Object element) {
		switch treeElement : (element as Pair<Object, Object>).value {
			URI: treeElement.getEObjectAndRun[switch it {
				Property: {
					val associationURI = cachedPropertyAssociations.get((element as Pair<Pair<Object, URI>, Object>).key.value).get(treeElement)
					associationURI != null && associationURI.getEObjectAndRun[PropertyAssociation association | input.getEObjectAndRun[it == association.owner] && !association.modal]
				}
				BasicPropertyAssociation: {
					val containingAssociation = getContainerOfType(PropertyAssociation)
					containingAssociation != null && input.getEObjectAndRun[it == containingAssociation.owner] && !containingAssociation.modal
				}
				default: false
			}]
			Pair<Object, URI>: treeElement.value.getEObjectAndRun[PropertyExpression it |
				val containingAssociation = getContainerOfType(PropertyAssociation)
				containingAssociation != null && input.getEObjectAndRun[it == containingAssociation.owner] && !containingAssociation.modal
			]
			default: false
		}
	}
	
	def private createValueColumnEditingSupport(TreeViewer treeViewer) {
		new EditingSupport(treeViewer) {
			override protected canEdit(Object element) {
				AadlPropertyView.this.canEdit(element)
			}
			
			override protected getCellEditor(Object element) {
				new XtextStyledTextCellEditor(SWT.SINGLE, MyAadl2Activator.getInstance.getInjector(MyAadl2Activator.ORG_OSATE_XTEXT_AADL2_AADL2)) => [
					create(treeViewer.tree)
				]
			}
			
			override protected getValue(Object element) {
				xtextDocument.readOnly[
					val expression = switch treeElement: (element as Pair<Object, Object>).value {
						URI: treeElement.getEObjectAndRun[switch it {
							Property: cachedPropertyAssociations.get((element as Pair<Pair<Object, URI>, Object>).key.value).get(treeElement).getEObjectAndRun[PropertyAssociation it |
								ownedValues.head.ownedValue
							]
							BasicPropertyAssociation: value
						}]
						Pair<Object, URI>: treeElement.value.getEObjectAndRun[PropertyExpression it | it]
					}
					val expressionNode = expression.node
					
					val modelUnitNameNode = NodeModelUtils.findNodesForFeature(contents.head, Aadl2Package.eINSTANCE.namedElement_Name).head
					val prefix = xtextDocument.get(0, expressionNode.offset)
					val newPrefix = new StringBuilder(prefix).insert(modelUnitNameNode.endOffset, EMBEDDED_RESOURCE_NAME_SUFFIX)
					
					initialEditablePart = serializer.serialize(expression).replaceAll("\n", "").replaceAll("\r", "").replaceAll("\t", "").trim
					
					val endNameNode = contents.head.node.lastLeaf.previousNode
					val suffix = xtextDocument.get(expressionNode.endOffset, xtextDocument.length - expressionNode.endOffset)
					val newSuffix = new StringBuilder(suffix).insert(endNameNode.endOffset - expressionNode.endOffset, EMBEDDED_RESOURCE_NAME_SUFFIX)
					
					new CellEditorPartialValue(newPrefix.toString, initialEditablePart, newSuffix.toString)
				]
			}
			
			override protected setValue(Object element, Object value) {
				if (initialEditablePart != value  && !(value as String).empty) {
					val node = switch treeElement : (element as Pair<Object, Object>).value {
						URI: treeElement.getEObjectAndRun[switch it {
							Property: cachedPropertyAssociations.get((element as Pair<Pair<Object, URI>, Object>).key.value).get(treeElement).getEObjectAndRun[PropertyAssociation it |
								ownedValues.head.ownedValue
							]
							BasicPropertyAssociation: it.value
						}.node]
						Pair<Object, URI>: treeElement.value.getEObjectAndRun[node]
					}
					if (node != null) {
						xtextDocument.modify(new IUnitOfWork.Void<XtextResource> {
							override process(XtextResource state) throws Exception {
								state.update(node.offset, node.length, value as String)
							}
						})
						treeViewer.refresh((element as Pair<Object, Object>).propertyParent)
					}
				}
			}
		}
	}
	
	def private getInput() {
		treeViewer.input as URI
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
				if (new WizardDialog(viewSite.workbenchWindow.shell,
					new PropertyAssociationWizard(xtextDocument, editingDomain?.commandStack, input.getEObjectAndRun[NamedElement it | it], serializer, aadl2Parser, linker)
				).open == Window.OK) {
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
		
		removeElementAction = new Action("Remove") {
			override run() {
				val selectedElement = (treeViewer.selection as IStructuredSelection).firstElement as Pair<Object, Object>
				switch treeElement : selectedElement.value {
					URI: {
						val postModificationUpdate = xtextDocument.modify[switch treeElementObject : it.resourceSet.getEObject(treeElement, true) {
							Property: {
								val associationURI = cachedPropertyAssociations.get((selectedElement.key as Pair<Object, Object>).value).get(selectedElement.value)
								val association = it.resourceSet.getEObject(associationURI, true) as PropertyAssociation
								(association.owner as NamedElement).ownedPropertyAssociations.remove(association);
								[|synchronized (jobLock) {
									if (cachePropertyLookupJob != null && cachePropertyLookupJob.state != Job.NONE) {
										cachePropertyLookupJob.cancel
									}
									cachePropertyLookupJob = createCachePropertyLookupJob(input)
									cachePropertyLookupJob.schedule
								}]
							}
							BasicPropertyAssociation: {
								(treeElementObject.owner as RecordValue).ownedFieldValues.remove(treeElementObject);
								[|treeViewer.refresh(selectedElement.key)]
							}
						}]
						postModificationUpdate.apply
					}
					Pair<Object, URI>: switch key : treeElement.key {
						String: {
							xtextDocument.modify(new IUnitOfWork.Void<XtextResource> {
								override process(XtextResource state) throws Exception {
									((state.resourceSet.getEObject((treeElement as Pair<String, URI>).value, true) as PropertyExpression).owner as RangeValue).delta = null
								}
							})
							treeViewer.refresh(selectedElement.key)
						}
						Integer: {
							xtextDocument.modify(new IUnitOfWork.Void<XtextResource> {
								override process(XtextResource state) throws Exception {
									((state.resourceSet.getEObject((treeElement as Pair<Integer, URI>).value, true) as PropertyExpression).owner as ListValue).ownedListElements.remove(
										(key as Integer).intValue
									)
								}
							})
							treeViewer.refresh(selectedElement.key)
						}
					}
				}
			}
		}
	}
	
	def private createContextMenu() {
		new MenuManager => [
			removeAllWhenShown = true
			addMenuListener[
				add(removeElementAction)
				val selection = treeViewer.selection as IStructuredSelection
				removeElementAction.enabled = xtextDocument != null && selection.size == 1 && canEdit(selection.firstElement) && switch treeElement : (selection.firstElement as Pair<?, ?>).value {
					URI: treeElement.getEObjectAndRun[switch it {
						Property: true
						BasicPropertyAssociation: (owner as RecordValue).ownedFieldValues.size >= 2
						default: false
					}]
					Pair<Object, Object>: treeElement.key == DELTA_LABEL || treeElement.key instanceof Integer
					default: false
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
			resourceSet = currentSelection.eResource.resourceSet
			val currentSelectionURI = EcoreUtil.getURI(currentSelection)
			if (currentSelectionURI == previousSelectionURI) {
				pageBook.showPage(treeViewerComposite)
			} else {
				previousSelectionURI = currentSelectionURI
				synchronized (jobLock) {
					if (cachePropertyLookupJob != null && cachePropertyLookupJob.state != Job.NONE) {
						cachePropertyLookupJob.cancel
					}
					cachePropertyLookupJob = createCachePropertyLookupJob(currentSelectionURI)
					cachePropertyLookupJob.schedule
				}
			}
		} else {
			synchronized (jobLock) {
				if (cachePropertyLookupJob != null) {
					cachePropertyLookupJob.cancel
					cachePropertyLookupJob = null
				}
			}
			pageBook.showPage(noPropertiesLabel)
			addNewPropertyAssociationToolbarAction.enabled = false
			editingDomain = null
			resourceSet = null
			previousSelectionURI = null
		}
	}
	
	def private <E extends EObject, T> getEObjectAndRun(URI elementURI, (E)=>T operation) {
		if (xtextDocument != null) {
			xtextDocument.readOnly[operation.apply(it.resourceSet.getEObject(elementURI, true) as E)]
		} else if (editingDomain instanceof TransactionalEditingDomain) {
			try {
				TransactionUtil.runExclusive(editingDomain, new RunnableWithResult.Impl<T> {
					override run() {
						setResult(operation.apply(editingDomain.resourceSet.getEObject(elementURI, true) as E))
						setStatus(Status.OK_STATUS)
					}
				})
			} catch (InterruptedException e) {
				//Allow the operation to determine what the result should be if we cannot retrieve the EObject
				operation.apply(null)
			}
		} else if (resourceSet != null) {
			operation.apply(resourceSet.getEObject(elementURI, true) as E)
		} else {
			//Allow the operation to determine what the result should be if we cannot retrieve the EObject
			operation.apply(null)
		}
	}
	
	def private createCachePropertyLookupJob(URI elementURI) {
		new CachePropertyLookupJob(elementURI, this, site.shell.display, scopeProvider, [|
			pageBook.showPage(populatingViewLabel)
			addNewPropertyAssociationToolbarAction.enabled = false
		], [|
			treeViewer.input = elementURI
			pageBook.showPage(treeViewerComposite)
			addNewPropertyAssociationToolbarAction.enabled = true
		])
	}
	
	def private static getValueAsString(Element expression, ISerializer serializer) {
		try {
			switch expression {
				InstanceReferenceValue: expression.referencedInstanceObject?.instanceObjectPath ?: "null"
				ListValue case expression.hasInstanceReferenceValue: expression.serializeListWithInstanceReferenceValue(serializer)
				default: serializer.serialize(expression).replaceAll("\n", "").replaceAll("\r", "").replaceAll("\t", "").trim
			}
		} catch (IConcreteSyntaxValidator.InvalidConcreteSyntaxException e) {
			//Simply return null.  Expression could not be serialized because the model is invalid.
		}
	}
	
	def private static boolean hasInstanceReferenceValue(ListValue topList) {
		topList.ownedListElements.exists[it instanceof InstanceReferenceValue || (it instanceof ListValue && (it as ListValue).hasInstanceReferenceValue)]
	}
	
	def private static String serializeListWithInstanceReferenceValue(ListValue topList, ISerializer serializer) {
		topList.ownedListElements.join("(", ", ", ")", [switch it {
			InstanceReferenceValue: referencedInstanceObject?.instanceObjectPath ?: "null"
			ListValue: serializeListWithInstanceReferenceValue(serializer)
			default: serializer.serialize(it).replaceAll("\n", "").replaceAll("\r", "").replaceAll("\t", "").trim
		}])
	}
	
	private static class CachePropertyLookupJob extends Job {
		val URI elementURI
		val AadlPropertyView propertyView
		val Display display
		val extension IScopeProvider scopeProvider
		val Runnable preUiUpdate
		val Runnable postUiUpdate
		
		new(URI elementURI, AadlPropertyView propertyView, Display display, IScopeProvider scopeProvider, Runnable preUiUpdate, Runnable postUiUpdate) {
			super("Updating Property View")
			this.elementURI = elementURI
			this.propertyView = propertyView
			this.display = display
			this.scopeProvider = scopeProvider
			this.preUiUpdate = preUiUpdate
			this.postUiUpdate = postUiUpdate
			priority = SHORT
		}
		
		override protected run(IProgressMonitor monitor) {
			display.syncExec(preUiUpdate)
			val propertyAssociations = propertyView.getEObjectAndRun(elementURI, [NamedElement element |
				//Build a collection of PropertySets that are visible from the selected element.  Unresolvable proxies are filtered out.
				val propertySets = element.getScope(Aadl2Package.eINSTANCE.packageSection_ImportedUnit).allElements.map[
					if (EObjectOrProxy.eIsProxy) {
						EcoreUtil.resolve(EObjectOrProxy, element)
					} else {
						EObjectOrProxy
					}
				].filter[!eIsProxy].filter(PropertySet)
				/*
				 * Build a map from PropertySets to a collection of their owned Properties.  Properties that do not apply to the selected element are filtered
				 * out.  PropertySets without any applicable properties are filtered out.
				 */
				val properties = propertySets.toInvertedMap[ownedProperties.filter[element.acceptsProperty(it)]].filter[propertySet, acceptableProperties | !acceptableProperties.empty]
				/*
				 * Build a map from URIs of PropertySets to a map from URIs of Properties to URIs of PropertyAssociations(Map<URI, Map<URI, URI>>, derived from
				 * Map<PropertySet, Map<Property, PropertyAssociation>>).  This is where the property lookup actually happens.  Entries for the
				 * PropertyAssociation URI could be null which means that the Property is undefined, taking the default value, or the model is incomplete.  In
				 * the case that the model is incomplete, we treat the property like it is undefined or taking the default value.  This whole expression is
				 * wrapped in a construction of a new LinkedHashMap so that all of the lazy parts of the expression will be evaluated before we check if the
				 * monitor is canceled.
				 */
				newLinkedHashMap(properties.mapValues[
					/*
					 * This whole expression is wrapped in a construction of a new LinkedHashMap so that all of the lazy parts of the expression will be
					 * evaluated before we check if the monitor is canceled.
					 */
					newLinkedHashMap(toInvertedMap[element.getPropertyValue(it).first].mapValues[
						//This check is for incomplete models which may occur while the user is typing a PropertyAssociation
						if (it != null && (ownedValues.empty || ownedValues.exists[ownedValue == null])) {
							null
						} else {
							it?.getURI
						}
					].entrySet.map[key.getURI -> value]).unmodifiableView
				].entrySet.map[key.getURI -> value]).unmodifiableView
			])
			if (monitor.canceled) {
				Status.CANCEL_STATUS
			} else {
				propertyView.cachedPropertyAssociations.clear
				if (propertyAssociations != null) {
					propertyView.cachedPropertyAssociations.putAll(propertyAssociations)
				}
				display.syncExec(postUiUpdate)
				Status.OK_STATUS
			}
		}
	}
}