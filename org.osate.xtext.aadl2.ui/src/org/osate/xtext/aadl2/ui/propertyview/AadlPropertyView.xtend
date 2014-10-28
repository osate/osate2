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
import org.osate.aadl2.RangeValue
import org.osate.aadl2.RecordValue
import org.osate.aadl2.BasicPropertyAssociation
import org.osate.aadl2.Element
import org.eclipse.xtext.validation.IConcreteSyntaxValidator
import org.osate.aadl2.RecordType
import org.osate.aadl2.BasicProperty
import org.eclipse.xtext.util.Wrapper

import static extension org.osate.aadl2.modelsupport.util.AadlUtil.getBasePropertyType

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
			if (currentSelectionUri != null) {
				cachePropertyLookupJob = (resourceSet.getEObject(currentSelectionUri, true) as NamedElement)?.createCachePropertyLookupJob
				cachePropertyLookupJob?.schedule
			}
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
				Pair<String, PropertyExpression>: {
					element.key
				}
				BasicPropertyAssociation: {
					element.property.name
				}
				BasicProperty case !(element instanceof Property): {
					element.name
				}
			}
		}
		
		override getForeground(Object element) {
			switch element {
				Property case cachedPropertyAssociations.get(element.owner).get(element) == null && element.defaultValue == null,
				BasicProperty case !(element instanceof Property): {
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
				Pair<String, PropertyExpression>: {
					resolvedElement.value.resolveIfProxy.getValueAsString(serializer)
				}
				BasicPropertyAssociation: {
					resolvedElement.value.getValueAsString(serializer)
				}
				Wrapper<PropertyExpression>: {
					resolvedElement.get.resolveIfProxy.getValueAsString(serializer)
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
				BasicPropertyAssociation: {
					val containingAssociation = element.getContainerOfType(PropertyAssociation)
					if (containingAssociation == null) {
						STATUS_DEFAULT
					} else if (containingAssociation.owner == input) {
						STATUS_LOCAL
					} else {
						STATUS_INHERITED
					}
				}
				BasicProperty case !(element instanceof Property): {
					STATUS_UNDEFINED
				}
			}
		}
		
		override getForeground(Object element) {
			switch element {
				Property case cachedPropertyAssociations.get(element.owner).get(element) == null && element.defaultValue == null,
				BasicProperty case !(element instanceof Property): {
					site.shell.display.getSystemColor(SWT.COLOR_RED)
				}
			}
		}
	}
	
	//TODO: Consider using an ILazyTreeContentProvider
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
					(association == null &&
						((lastSegment.defaultValue instanceof NumberValue && (lastSegment.defaultValue as NumberValue).unit != null) || lastSegment.defaultValue instanceof RangeValue ||
							(lastSegment.defaultValue instanceof RecordValue && lastSegment.propertyType instanceof RecordType &&
								if (showUndefinedAction.checked) {
									!(lastSegment.propertyType as RecordType).ownedFields.empty
								} else {
									(lastSegment.propertyType as RecordType).ownedFields.exists[fieldInType | (lastSegment.defaultValue as RecordValue).ownedFieldValues.exists[property == fieldInType]]
								}
							) || (lastSegment.defaultValue instanceof ListValue && !(lastSegment.defaultValue as ListValue).ownedListElements.empty)
						)
					) || (association != null &&
						(association.modal || (association.ownedValues.head.ownedValue instanceof NumberValue && (association.ownedValues.head.ownedValue as NumberValue).unit != null) ||
							association.ownedValues.head.ownedValue instanceof RangeValue ||
							(association.ownedValues.head.ownedValue instanceof RecordValue && lastSegment.propertyType instanceof RecordType &&
								if (showUndefinedAction.checked) {
									!(lastSegment.propertyType as RecordType).ownedFields.empty
								} else {
									(lastSegment.propertyType as RecordType).ownedFields.exists[fieldInType |
										(association.ownedValues.head.ownedValue as RecordValue).ownedFieldValues.exists[property == fieldInType] ||
											(lastSegment.defaultValue instanceof RecordValue && (lastSegment.defaultValue as RecordValue).ownedFieldValues.exists[property == fieldInType])
									]
								}
							) || (association.ownedValues.head.ownedValue instanceof ListValue && !(association.ownedValues.head.ownedValue as ListValue).ownedListElements.empty)
						)
					)
				}
				ModalPropertyValue: {
					(lastSegment.ownedValue instanceof NumberValue && (lastSegment.ownedValue as NumberValue).unit != null) || lastSegment.ownedValue instanceof RangeValue ||
						(lastSegment.ownedValue instanceof RecordValue && lastSegment.getContainerOfType(PropertyAssociation).property.propertyType instanceof RecordType &&
							if (showUndefinedAction.checked) {
								!(lastSegment.getContainerOfType(PropertyAssociation).property.propertyType as RecordType).ownedFields.empty
							} else {
								(lastSegment.getContainerOfType(PropertyAssociation).property.propertyType as RecordType).ownedFields.exists[fieldInType |
									(lastSegment.ownedValue as RecordValue).ownedFieldValues.exists[property == fieldInType] ||
										(lastSegment.getContainerOfType(PropertyAssociation).property.defaultValue instanceof RecordValue &&
											(lastSegment.getContainerOfType(PropertyAssociation).property.defaultValue as RecordValue).ownedFieldValues.exists[property == fieldInType]
										)
								]
							}
						) || (lastSegment.ownedValue instanceof ListValue && !(lastSegment.ownedValue as ListValue).ownedListElements.empty)
				}
				NumberValue: {
					false
				}
				UnitLiteral: {
					false
				}
				Wrapper<PropertyExpression>: {
					(lastSegment.get instanceof NumberValue && (lastSegment.get as NumberValue).unit != null) || lastSegment.get instanceof RangeValue ||
						(lastSegment.get instanceof RecordValue && {
							val propertyType = (lastSegment.get.getContainerOfType(BasicPropertyAssociation)?.property ?:
								lastSegment.get.getContainerOfType(PropertyAssociation)?.property ?:
								lastSegment.get.getContainerOfType(Property)
							).propertyType.basePropertyType
							propertyType instanceof RecordType && if (showUndefinedAction.checked) {
								!(propertyType as RecordType).ownedFields.empty
							} else {
								(propertyType as RecordType).ownedFields.exists[fieldInType | (lastSegment.get as RecordValue).ownedFieldValues.exists[property == fieldInType]]
							}
						}) || (lastSegment.get instanceof ListValue && !(lastSegment.get as ListValue).ownedListElements.empty)
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
						} else if (association.ownedValues.head.ownedValue instanceof RangeValue) {
							if ((association.ownedValues.head.ownedValue as RangeValue).delta == null) {
								2
							} else {
								3
							}
						} else if (association.ownedValues.head.ownedValue instanceof RecordValue && lastSegment.propertyType instanceof RecordType) {
							val recordType = lastSegment.propertyType as RecordType
							if (showUndefinedAction.checked) {
								recordType.ownedFields.size
							} else {
								recordType.ownedFields.filter[fieldInType |
									(association.ownedValues.head.ownedValue as RecordValue).ownedFieldValues.exists[property == fieldInType] ||
										(lastSegment.defaultValue instanceof RecordValue && (lastSegment.defaultValue as RecordValue).ownedFieldValues.exists[property == fieldInType])
								].size
							}
						} else if (association.ownedValues.head.ownedValue instanceof ListValue) {
							(association.ownedValues.head.ownedValue as ListValue).ownedListElements.size
						} else {
							0
						}
					} else if (lastSegment.defaultValue instanceof NumberValue && (lastSegment.defaultValue as NumberValue).unit != null) {
						2
					} else if (lastSegment.defaultValue instanceof RangeValue) {
						if ((lastSegment.defaultValue as RangeValue).delta == null) {
							2
						} else {
							3
						}
					} else if (lastSegment.defaultValue instanceof RecordValue && lastSegment.propertyType instanceof RecordType) {
						if (showUndefinedAction.checked) {
							(lastSegment.propertyType as RecordType).ownedFields.size
						} else {
							(lastSegment.propertyType as RecordType).ownedFields.filter[fieldInType | (lastSegment.defaultValue as RecordValue).ownedFieldValues.exists[property == fieldInType]].size
						}
					} else if (lastSegment.defaultValue instanceof ListValue) {
						(lastSegment.defaultValue as ListValue).ownedListElements.size
					} else {
						0
					}
				}
				ModalPropertyValue: {
					if (lastSegment.ownedValue instanceof NumberValue && (lastSegment.ownedValue as NumberValue).unit != null) {
						2
					} else if (lastSegment.ownedValue instanceof RangeValue) {
						if ((lastSegment.ownedValue as RangeValue).delta == null) {
							2
						} else {
							3
						}
					} else if (lastSegment.ownedValue instanceof RecordValue && lastSegment.getContainerOfType(PropertyAssociation).property.propertyType instanceof RecordType) {
						val property = lastSegment.getContainerOfType(PropertyAssociation).property;
						if (showUndefinedAction.checked) {
							(property.propertyType as RecordType).ownedFields.size
						} else {
							(property.propertyType as RecordType).ownedFields.filter[fieldInType |
								(lastSegment.ownedValue as RecordValue).ownedFieldValues.exists[it.property == fieldInType] ||
									(property.defaultValue instanceof RecordValue && (property.defaultValue as RecordValue).ownedFieldValues.exists[it.property == fieldInType])
							].size
						}
					} else if (lastSegment.ownedValue instanceof ListValue) {
						(lastSegment.ownedValue as ListValue).ownedListElements.size
					} else {
						0
					}
				}
				Pair<String, PropertyExpression>: {
					if (lastSegment.value instanceof NumberValue && (lastSegment.value as NumberValue).unit != null) {
						2
					} else {
						0
					}
				}
				BasicPropertyAssociation: {
					if (lastSegment.value instanceof NumberValue && (lastSegment.value as NumberValue).unit != null) {
						2
					} else if (lastSegment.value instanceof RangeValue) {
						if ((lastSegment.value as RangeValue).delta == null) {
							2
						} else {
							3
						}
					} else if (lastSegment.value instanceof RecordValue && lastSegment.property.propertyType instanceof RecordType) {
						if (showUndefinedAction.checked) {
							(lastSegment.property.propertyType as RecordType).ownedFields.size
						} else {
							(lastSegment.property.propertyType as RecordType).ownedFields.filter[fieldInType | (lastSegment.value as RecordValue).ownedFieldValues.exists[property == fieldInType]].size
						}
					} else if (lastSegment.value instanceof ListValue) {
						(lastSegment.value as ListValue).ownedListElements.size
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
				BasicProperty case !(lastSegment instanceof Property): {
					0
				}
				Wrapper<PropertyExpression>: {
					if (lastSegment.get instanceof NumberValue && (lastSegment.get as NumberValue).unit != null) {
						2
					} else if (lastSegment.get instanceof RangeValue) {
						if ((lastSegment.get as RangeValue).delta == null) {
							2
						} else {
							3
						}
					} else if (lastSegment.get instanceof RecordValue) {
						val propertyType = (lastSegment.get.getContainerOfType(BasicPropertyAssociation)?.property ?:
							lastSegment.get.getContainerOfType(PropertyAssociation)?.property ?:
							lastSegment.get.getContainerOfType(Property)
						).propertyType.basePropertyType
						if (propertyType instanceof RecordType) {
							if (showUndefinedAction.checked) {
								propertyType.ownedFields.size
							} else {
								propertyType.ownedFields.filter[fieldInType | (lastSegment.get as RecordValue).ownedFieldValues.exists[property == fieldInType]].size
							}
						} else {
							0
						}
					} else if (lastSegment.get instanceof ListValue) {
						(lastSegment.get as ListValue).ownedListElements.size
					} else {
						0
					}
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
						if (lastSegment.defaultValue instanceof NumberValue) {
							//Default NumberValue with units
							if (index == 0) {
								lastSegment.defaultValue
							} else { //index is 1
								(lastSegment.defaultValue as NumberValue).unit
							}
						} else if (lastSegment.defaultValue instanceof RangeValue) {
							val rangeValue = lastSegment.defaultValue as RangeValue
							if (index == 0) {
								"minimum" -> rangeValue.minimum
							} else if (index == 1) {
								"maximum" -> rangeValue.maximum
							} else {
								"delta" -> rangeValue.delta
							}
						} else if (lastSegment.defaultValue instanceof RecordValue) {
							if (showUndefinedAction.checked) {
								val fieldInType = (lastSegment.propertyType as RecordType).ownedFields.get(index)
								(lastSegment.defaultValue as RecordValue).ownedFieldValues.findFirst[property == fieldInType] ?: fieldInType
							} else {
								(lastSegment.propertyType as RecordType).ownedFields.map[fieldInType |
									(lastSegment.defaultValue as RecordValue).ownedFieldValues.findFirst[property == fieldInType]
								].filterNull.get(index)
							}
						} else if (lastSegment.defaultValue instanceof ListValue) {
							new Wrapper((lastSegment.defaultValue as ListValue).ownedListElements.get(index))
						}
					} else if (association.modal) {
						association.ownedValues.get(index)
					} else if (association.ownedValues.head.ownedValue instanceof NumberValue) {
						//NumberValue with units
						if (index == 0) {
							association.ownedValues.head.ownedValue
						} else { //index is 1
							(association.ownedValues.head.ownedValue as NumberValue).unit
						}
					} else if (association.ownedValues.head.ownedValue instanceof RangeValue) {
						val rangeValue = association.ownedValues.head.ownedValue as RangeValue
						if (index == 0) {
							"minimum" -> rangeValue.minimum
						} else if (index == 1) {
							"maximum" -> rangeValue.maximum
						} else {
							"delta" -> rangeValue.delta
						}
					} else if (association.ownedValues.head.ownedValue instanceof RecordValue) {
						val recordType = lastSegment.propertyType as RecordType
						if (showUndefinedAction.checked) {
							val fieldInType = recordType.ownedFields.get(index)
							(association.ownedValues.head.ownedValue as RecordValue).ownedFieldValues.findFirst[property == fieldInType] ?:
								(if (lastSegment.defaultValue instanceof RecordValue) {
									lastSegment.defaultValue as RecordValue
								})?.ownedFieldValues?.findFirst[property == fieldInType] ?: fieldInType
						} else {
							recordType.ownedFields.map[fieldInType |
								(association.ownedValues.head.ownedValue as RecordValue).ownedFieldValues.findFirst[property == fieldInType] ?:
									(lastSegment.defaultValue as RecordValue)?.ownedFieldValues?.findFirst[property == fieldInType]
							].filterNull.get(index)
						}
					} else if (association.ownedValues.head.ownedValue instanceof ListValue) {
						new Wrapper((association.ownedValues.head.ownedValue as ListValue).ownedListElements.get(index))
					}
				}
				ModalPropertyValue: {
					if (lastSegment.ownedValue instanceof NumberValue) {
						//NumberValue with units
						if (index == 0) {
							lastSegment.ownedValue
						} else { //index is 1
							(lastSegment.ownedValue as NumberValue).unit
						}
					} else if (lastSegment.ownedValue instanceof RangeValue) {
						val rangeValue = lastSegment.ownedValue as RangeValue
						if (index == 0) {
							"minimum" -> rangeValue.minimum
						} else if (index == 1) {
							"maximum" -> rangeValue.maximum
						} else {
							"delta" -> rangeValue.delta
						}
					} else if (lastSegment.ownedValue instanceof RecordValue) {
						val property = lastSegment.getContainerOfType(PropertyAssociation).property;
						if (showUndefinedAction.checked) {
							val fieldInType = (property.propertyType as RecordType).ownedFields.get(index)
							(lastSegment.ownedValue as RecordValue).ownedFieldValues.findFirst[it.property == fieldInType] ?:
								(if (property.defaultValue instanceof RecordValue) {
									property.defaultValue as RecordValue
								})?.ownedFieldValues?.findFirst[it.property == fieldInType] ?: fieldInType
						} else {
							(property.propertyType as RecordType).ownedFields.map[fieldInType |
								(lastSegment.ownedValue as RecordValue).ownedFieldValues.findFirst[it.property == fieldInType] ?:
									(property.defaultValue as RecordValue)?.ownedFieldValues?.findFirst[it.property == fieldInType]
							].filterNull.get(index)
						}
					} else if (lastSegment.ownedValue instanceof ListValue) {
						new Wrapper((lastSegment.ownedValue as ListValue).ownedListElements.get(index))
					}
				}
				Pair<String, PropertyExpression>: {
					if (index == 0) {
						lastSegment.value
					} else {
						(lastSegment.value as NumberValue).unit
					}
				}
				Wrapper<PropertyExpression>: {
					if (lastSegment.get instanceof NumberValue) {
						//NumberValue with units
						if (index == 0) {
							lastSegment.get
						} else { //index is 1
							(lastSegment.get as NumberValue).unit
						}
					} else if (lastSegment.get instanceof RangeValue) {
						val rangeValue = lastSegment.get as RangeValue
						if (index == 0) {
							"minimum" -> rangeValue.minimum
						} else if (index == 1) {
							"maximum" -> rangeValue.maximum
						} else {
							"delta" -> rangeValue.delta
						}
					} else if (lastSegment.get instanceof RecordValue) {
						val propertyType = (lastSegment.get.getContainerOfType(BasicPropertyAssociation)?.property ?:
							lastSegment.get.getContainerOfType(PropertyAssociation)?.property ?:
							lastSegment.get.getContainerOfType(Property)
						).propertyType.basePropertyType
						if (showUndefinedAction.checked) {
							val fieldInType = (propertyType as RecordType).ownedFields.get(index)
							(lastSegment.get as RecordValue).ownedFieldValues.findFirst[property == fieldInType] ?: fieldInType
						} else {
							(propertyType as RecordType).ownedFields.map[fieldInType | (lastSegment.get as RecordValue).ownedFieldValues.findFirst[property == fieldInType]].filterNull.get(index)
						}
					} else if (lastSegment.get instanceof ListValue) {
						new Wrapper((lastSegment.get as ListValue).ownedListElements.get(index))
					}
				}
				BasicPropertyAssociation: {
					if (lastSegment.value instanceof NumberValue) {
						//NumberValue with units
						if (index == 0) {
							lastSegment.value
						} else { //index is 1
							(lastSegment.value as NumberValue).unit
						}
					} else if (lastSegment.value instanceof RangeValue) {
						val rangeValue = lastSegment.value as RangeValue
						if (index == 0) {
							"minimum" -> rangeValue.minimum
						} else if (index == 1) {
							"maximum" -> rangeValue.maximum
						} else {
							"delta" -> rangeValue.delta
						}
					} else if (lastSegment.value instanceof RecordValue) {
						if (showUndefinedAction.checked) {
							val fieldInType = (lastSegment.property as RecordType).ownedFields.get(index)
							(lastSegment.value as RecordValue).ownedFieldValues.findFirst[property == fieldInType] ?: fieldInType
						} else {
							(lastSegment.property.propertyType as RecordType).ownedFields.map[
								fieldInType | (lastSegment.value as RecordValue).ownedFieldValues.findFirst[property == fieldInType]
							].filterNull.get(index)
						}
					} else if (lastSegment.value instanceof ListValue) {
						new Wrapper((lastSegment.value as ListValue).ownedListElements.get(index))
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
			//TODO: Write this method after we are finished with RecordValues and ListValues
			#[]
//			switch element {
//				PropertySet: {
//					#[TreePath.EMPTY]
//				}
//				Property: {
//					//Parent path: PropertySet
//					#[new TreePath(#[element.owner])]
//				}
//				ModalPropertyValue: {
//					//Parent path: PropertySet -> Property
//					val property = (element.owner as PropertyAssociation).property
//					#[new TreePath(#[property.owner, property])]
//				}
//				NumberValue: {
//					if (element.owner instanceof RangeValue) {
//						val rangeValue = element.owner as RangeValue
//						val label = if (rangeValue.minimum == element) {
//								"minimum"
//							} else if (rangeValue.maximum == element) {
//								"maximum"
//							} else {
//								"delta"
//							}
//						if (element.owner.owner instanceof ModalPropertyValue) {
//							//Parent path: PropertySet -> Property -> ModalPropertyValue -> Pair<String, PropertyExpression>
//							val property = element.getContainerOfType(PropertyAssociation).property
//							#[new TreePath(#[property.owner, property, element.owner.owner, label -> element])]
//						} else {
//							//Parent path: PropertySet -> Property -> Pair<String, PropertyExpression>
//							//There will be a containing PropertyAssociation if the viewer is showing a non-modal property value.  Otherwise, the viewer is showing a default value
//							val property = element.getContainerOfType(PropertyAssociation)?.property ?: element.getContainerOfType(Property)
//							#[new TreePath(#[property.owner, property, label -> element])]
//						}
//					} else if (element.owner instanceof ModalPropertyValue) {
//						//Parent path: PropertySet -> Property -> ModalPropertyValue
//						val property = element.getContainerOfType(PropertyAssociation).property
//						#[new TreePath(#[property.owner, property, element.owner])]
//					} else {
//						//Parent path: PropertySet -> Property
//						//There will be a containing PropertyAssociation if the viewer is showing a non-modal property value.  Otherwise, the viewer is showing a default value
//						val property = element.getContainerOfType(PropertyAssociation)?.property ?: element.getContainerOfType(Property)
//						#[new TreePath(#[property.owner, property])]
//					}
//				}
//				UnitLiteral: {
//					/*
//					 * Parent path: PropertySet -> Property
//					 * Unable to retrieve Property from UnitLiteral
//					 * 
//					 * Parent path: PropertySet -> Property -> ModalPropertyValue
//					 * Unable to retrieve ModalPropertyValue from UnitLiteral
//					 * 
//					 * Parent path: PropertySet -> Property -> Pair<String, PropertyExpression>
//					 * Unable to retrieve Pair<String, PropertyExpression> from UnitLiteral
//					 * 
//					 * Parent path: PropertySet -> Property -> ModalPropertyValue -> Pair<String, PropertyExpression>
//					 * Unable to retrieve Pair<String, PropertyExpression> from UnitLiteral
//					 */
//					 #[]
//				}
//				Pair<String, PropertyExpression>: {
//					if (element.value.owner.owner instanceof ModalPropertyValue) {
//						//Parent path: PropertySet -> Property -> ModalPropertyValue
//						val property = element.value.getContainerOfType(PropertyAssociation).property
//						#[new TreePath(#[property.owner, property, element.value.owner])]
//					} else {
//						//Parent path: PropertySet -> Property
//						//There will be a containing PropertyAssociation if the viewer is showing a non-modal property value.  Otherwise, the viewer is showing a default value
//						val property = element.value.getContainerOfType(PropertyAssociation)?.property ?: element.value.getContainerOfType(Property)
//						#[new TreePath(#[property.owner, property])]
//					}
//				}
//				default: {
//					println("getParents: " + element)
//					throw new UnsupportedOperationException("TODO: auto-generated method stub")
//				}
//			}
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
	
	def private static getValueAsString(Element expression, ISerializer serializer) {
		try {
			switch expression {
				InstanceReferenceValue:
					expression.referencedInstanceObject?.instanceObjectPath ?: "null"
				ListValue case expression.hasInstanceReferenceValue:
					expression.serializeListWithInstanceReferenceValue(serializer)
				default: {
					serializer.serialize(expression).replaceAll("\n", "").replaceAll("\r", "").replaceAll("\t", "").trim
					// TODO: Test this to see what cleanup is truly necessary.
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