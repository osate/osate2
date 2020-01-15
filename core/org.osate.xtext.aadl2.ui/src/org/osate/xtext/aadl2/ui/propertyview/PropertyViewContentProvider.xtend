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

import org.eclipse.emf.common.util.URI
import org.eclipse.jface.viewers.ITreeContentProvider
import org.eclipse.jface.viewers.Viewer
import org.osate.aadl2.BasicPropertyAssociation
import org.osate.aadl2.ListValue
import org.osate.aadl2.ModalPropertyValue
import org.osate.aadl2.Property
import org.osate.aadl2.PropertyAssociation
import org.osate.aadl2.PropertyExpression
import org.osate.aadl2.PropertySet
import org.osate.aadl2.PropertyType
import org.osate.aadl2.RangeValue
import org.osate.aadl2.RecordType
import org.osate.aadl2.RecordValue

import static extension org.eclipse.emf.ecore.util.EcoreUtil.getURI
import static extension org.eclipse.xtext.EcoreUtil2.getContainerOfType
import static extension org.osate.aadl2.modelsupport.util.AadlUtil.getBasePropertyType

package class PropertyViewContentProvider implements ITreeContentProvider {
	val AadlPropertyView propertyView
	
	package new(AadlPropertyView propertyView) {
		this.propertyView = propertyView
	}
	
	override inputChanged(Viewer viewer, Object oldInput, Object newInput) {
	}

	override getElements(Object inputElement) {
		getChildren(inputElement)
	}

	override hasChildren(Object element) {
		currentChildCount(element) > 0
	}

	override getChildren(Object parentElement) {
		(0..<currentChildCount(parentElement)).map[index | 
			new TreeEntry( parentElement, getChildElement(parentElement, index))
		]
	}

	def updateChildCount(Object element, int currentChildCount) {
		val childCount = currentChildCount(element)
		if (currentChildCount != childCount) {
			propertyView.treeViewer.setChildCount(element, childCount)
		}
	}

	def private currentChildCount(Object element) {
		switch element {
			URI: {
				switch propertyView {
					case propertyView.showUndefinedAction.checked && propertyView.showDefaultAction.checked: {
						propertyView.cachedPropertyAssociations.size
					}
					case !propertyView.showUndefinedAction.checked && !propertyView.showDefaultAction.checked: {
							propertyView.cachedPropertyAssociations.values.filter[entrySet.exists[value !== null]].size
							
					}
					case !propertyView.showUndefinedAction.checked && propertyView.showDefaultAction.checked : {
						propertyView.cachedPropertyAssociations.values.filter[entrySet.exists[
								value !== null || (value === null && propertyView.safeRead[extension resourceSet |
										(key.getEObject(true) as Property).defaultValue !== null])]].size
					}
					case propertyView.showUndefinedAction.checked && !propertyView.showDefaultAction.checked : {
						propertyView.cachedPropertyAssociations.values.filter[entrySet.exists[
								value !== null || (value === null && propertyView.safeRead[extension resourceSet |
										(key.getEObject(true) as Property).defaultValue === null])]].size
					}
					default : 0
				}
			}
			TreeEntry: switch treeElement : element.treeElement {
				URI: propertyView.safeRead[extension it | switch treeElementEObject : treeElement.getEObject(true) {
					PropertySet: {
						switch propertyView {
							case propertyView.showUndefinedAction.checked && propertyView.showDefaultAction.checked: {
								propertyView.cachedPropertyAssociations.get(treeElement).size
							}
							case !propertyView.showUndefinedAction.checked && !propertyView.showDefaultAction.checked: {
								propertyView.cachedPropertyAssociations.get(treeElement).filter[propertyURI, propertyAssociationURI |
									propertyAssociationURI !== null].size
							}
							case !propertyView.showUndefinedAction.checked && propertyView.showDefaultAction.checked: {
								propertyView.cachedPropertyAssociations.get(treeElement).filter[propertyURI, propertyAssociationURI |
									propertyAssociationURI !== null ||
									(propertyAssociationURI === null && (propertyURI.getEObject(true) as Property).defaultValue !== null)].size
							}
							case propertyView.showUndefinedAction.checked && !propertyView.showDefaultAction.checked: {
								propertyView.cachedPropertyAssociations.get(treeElement).filter[propertyURI, propertyAssociationURI |
									propertyAssociationURI !== null ||
									(propertyAssociationURI === null && (propertyURI.getEObject(true) as Property).defaultValue === null)].size
							}
							default : 0
						}
					}
					Property: {
						val associationURI = propertyView.cachedPropertyAssociations.get((element.parent as TreeEntry).treeElement).get(treeElement)
						if (associationURI === null) {
							getChildCount(treeElementEObject.defaultValue, treeElementEObject.propertyType, null)
						} else {
							val association = associationURI.getEObject(true) as PropertyAssociation
							if (association.modal) {
								association.ownedValues.size
							} else {
								getChildCount(association.ownedValues.head.ownedValue, treeElementEObject.propertyType, treeElementEObject.defaultValue)
							}
						}
					}
					ModalPropertyValue: {
						val property = treeElementEObject.getContainerOfType(PropertyAssociation).property
						getChildCount(treeElementEObject.ownedValue, property.propertyType, property.defaultValue)
					}
					BasicPropertyAssociation: getChildCount(treeElementEObject.value, treeElementEObject.property.propertyType, null)
					default: 0
				}]
				RangeElement: 0
				ListElement: propertyView.safeRead[extension it |
					val expression = treeElement.expressionURI.getEObject(true) as PropertyExpression
					getChildCount(expression, (
						expression.getContainerOfType(BasicPropertyAssociation)?.property ?: expression.getContainerOfType(PropertyAssociation)?.property ?: expression.getContainerOfType(Property)
					).propertyType.basePropertyType, null)
						]
				}
		}
	}
	
	def private getChildCount(PropertyExpression expression, PropertyType propertyType, PropertyExpression defaultValue) {
		switch expression {
			RangeValue case expression.delta === null: 2
			RangeValue case expression.delta !== null: 3
			RecordValue: switch propertyType {
				RecordType case propertyView.showUndefinedAction.checked && propertyView.showDefaultAction.checked: {
					propertyType.ownedFields.size
				}
				RecordType case !propertyView.showUndefinedAction.checked && !propertyView.showDefaultAction.checked: {
					propertyType.ownedFields.filter[fieldInType | expression.ownedFieldValues.exists[property == fieldInType]].size
				}
				RecordType case !propertyView.showUndefinedAction.checked && propertyView.showDefaultAction.checked: {
					if (defaultValue instanceof RecordValue) {
						propertyType.ownedFields.filter[fieldInType | expression.ownedFieldValues.exists[property == fieldInType] || defaultValue.ownedFieldValues.exists[property == fieldInType]].size
					} else {
						propertyType.ownedFields.filter[fieldInType | expression.ownedFieldValues.exists[property == fieldInType]].size
					}
				}
				RecordType case propertyView.showUndefinedAction.checked && !propertyView.showDefaultAction.checked: {
					if (defaultValue instanceof RecordValue) {
						propertyType.ownedFields.filter[fieldInType | expression.ownedFieldValues.exists[property == fieldInType] && !defaultValue.ownedFieldValues.exists[property == fieldInType]].size
					} else {
						propertyType.ownedFields.size
					}
				}
				default: 0
			}
			ListValue: expression.ownedListElements.size
			default: 0
		}
	}

	def updateElement(Object parent, int index) {
		val childElement = new TreeEntry(parent, getChildElement(parent, index))
		propertyView.treeViewer.replace(parent, index, childElement)
		updateChildCount(childElement, -1)
	}

	def private getChildElement(Object parent, int index) {
		switch parent {
			URI: {
				val filteredAssociations = 
					switch propertyView {
						case propertyView.showUndefinedAction.checked && propertyView.showDefaultAction.checked : {
								propertyView.cachedPropertyAssociations
						}
						case !propertyView.showUndefinedAction.checked && !propertyView.showDefaultAction.checked : {
							propertyView.cachedPropertyAssociations.filter[propertySetURI, associationsForPropertySet |
								associationsForPropertySet.entrySet.exists[value !== null]
							]
						}
						case !propertyView.showUndefinedAction.checked && propertyView.showDefaultAction.checked : {
							propertyView.cachedPropertyAssociations.filter[propertyURI, associationsForPropertySet |
								associationsForPropertySet.entrySet.exists[
									value !== null ||
									(value === null && propertyView.safeRead[extension resourceSet | (key.getEObject(true) as Property).defaultValue !== null])	
								]
							]
						}
						case propertyView.showUndefinedAction.checked && !propertyView.showDefaultAction.checked : {
							propertyView.cachedPropertyAssociations.filter[propertySetURI, associationsForPropertySet |
								associationsForPropertySet.entrySet.exists[
									value !== null || 
									(value === null && propertyView.safeRead[extension resourceSet | (key.getEObject(true) as Property).defaultValue === null])
								]
							]
						}
					}
				filteredAssociations.keySet.sortBy[propertyView.safeRead[extension resourceSet | (getEObject(true) as PropertySet).name.toUpperCase]].get(index)
			}
			TreeEntry: switch treeElement : parent.treeElement {
				URI: propertyView.safeRead[extension resourceSet | switch treeElementEObject : treeElement.getEObject(true) {
					PropertySet: {
						val filteredAssociations = 
						switch propertyView {
							case propertyView.showUndefinedAction.checked && propertyView.showDefaultAction.checked : {
									propertyView.cachedPropertyAssociations.get(treeElement)
							}
							case !propertyView.showUndefinedAction.checked && !propertyView.showDefaultAction.checked : {
								propertyView.cachedPropertyAssociations.get(treeElement).filter[propertyURI, propertyAssociationURI |
									propertyAssociationURI !== null 
								]
							}
							case !propertyView.showUndefinedAction.checked && propertyView.showDefaultAction.checked : {
								propertyView.cachedPropertyAssociations.get(treeElement).filter[propertyURI, propertyAssociationURI |
									propertyAssociationURI !== null || 
									(propertyAssociationURI === null && (propertyURI.getEObject(true) as Property).defaultValue !== null)
								]
							}
							case propertyView.showUndefinedAction.checked && !propertyView.showDefaultAction.checked : {
								propertyView.cachedPropertyAssociations.get(treeElement).filter[propertyURI, propertyAssociationURI |
									propertyAssociationURI !== null || 
									(propertyAssociationURI === null && (propertyURI.getEObject(true) as Property).defaultValue === null)
								]
							}
						}
						filteredAssociations.keySet.sortBy[(getEObject(true) as Property).name.toUpperCase].get(index)
					}
					Property: {
						val associationURI = propertyView.cachedPropertyAssociations.get((parent.parent as TreeEntry).treeElement).get(treeElement)
						if (associationURI === null) {
							getElement(treeElementEObject.defaultValue, index, treeElementEObject.propertyType, null)
						} else {
							val association = associationURI.getEObject(true) as PropertyAssociation
							if (association.modal) {
								association.ownedValues.get(index).URI
							} else {
								getElement(association.ownedValues.head.ownedValue, index, treeElementEObject.propertyType, treeElementEObject.defaultValue)
							}
						}
					}
					ModalPropertyValue: {
						val property = treeElementEObject.getContainerOfType(PropertyAssociation).property
						getElement(treeElementEObject.ownedValue, index, property.propertyType, property.defaultValue)
					}
					BasicPropertyAssociation: getElement(treeElementEObject.value, index, treeElementEObject.property.propertyType, null)
				}]
				ListElement: propertyView.safeRead[extension it |
					val expression = treeElement.expressionURI.getEObject(true) as PropertyExpression
					getElement(expression, index, (
						expression.getContainerOfType(BasicPropertyAssociation)?.property ?: expression.getContainerOfType(PropertyAssociation)?.property ?: expression.getContainerOfType(Property)
					).propertyType.basePropertyType, null)
				]
			}
		}
	}
	def private getElement(PropertyExpression expression, int index, PropertyType propertyType, PropertyExpression defaultValue) {
		switch expression {
			RangeValue: switch index {
				case 0: new RangeElement(RangeElement.MINIMUM_LABEL, expression.minimum.URI)
				case 1: new RangeElement(RangeElement.MAXIMUM_LABEL, expression.maximum.URI)
				case 2: new RangeElement(RangeElement.DELTA_LABEL, expression.delta.URI)
			}
			RecordValue: {
				val recordType = propertyType as RecordType
				(if (propertyView.showUndefinedAction.checked) {
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
				}).URI
			}
			ListValue: new ListElement(index, expression.ownedListElements.get(index).URI)
		}
	}
	
	override getParent(Object element) {
		if (element instanceof TreeEntry) {
			element.parent
		}
	}
	
	override dispose() {
	}
}