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
import org.eclipse.jface.viewers.ColumnLabelProvider
import org.eclipse.swt.SWT
import org.eclipse.xtext.serializer.ISerializer
import org.eclipse.xtext.validation.IConcreteSyntaxValidator
import org.osate.aadl2.BasicPropertyAssociation
import org.osate.aadl2.Element
import org.osate.aadl2.ListValue
import org.osate.aadl2.ModalPropertyValue
import org.osate.aadl2.Property
import org.osate.aadl2.PropertyAssociation
import org.osate.aadl2.PropertyExpression
import org.osate.aadl2.instance.InstanceReferenceValue

class ValueColumnLabelProvider extends ColumnLabelProvider {
	val AadlPropertyView propertyView
	
	package new(AadlPropertyView propertyView) {
		this.propertyView = propertyView
	}
	
	override getText(Object element) {
		propertyView.safeRead[extension it | switch treeElement : (element as TreeEntry).treeElement {
			URI: switch treeElementEObject : treeElement.getEObject(true) {
				Property: {
					val associationURI = propertyView.cachedPropertyAssociations.get(((element as TreeEntry).parent as TreeEntry).treeElement).get(treeElement)
					if (associationURI === null) {
						treeElementEObject.defaultValue
					} else {
						val association = associationURI.getEObject(true) as PropertyAssociation
						if (!association.modal) {
							association.ownedValues.head.ownedValue
						}
					}
				}
				ModalPropertyValue: treeElementEObject.ownedValue
				BasicPropertyAssociation: treeElementEObject.value
			}
			RangeElement: treeElement.expressionURI.getEObject(true) as PropertyExpression
			ListElement: treeElement.expressionURI.getEObject(true) as PropertyExpression
		}?.getValueAsString(propertyView.serializer)]
	}
	
	override getForeground(Object element) {
		if (!propertyView.canEdit(element)) {
			propertyView.site.shell.display.getSystemColor(SWT.COLOR_DARK_GRAY)
		}
	}
	
	def static getValueAsString(Element expression, ISerializer serializer) {
		try {
			val unformatted = switch expression {
				InstanceReferenceValue: expression.referencedInstanceObject?.instanceObjectPath ?: "null"
				ListValue case expression.hasInstanceReferenceValue: expression.serializeListWithInstanceReferenceValue(serializer)
				default: serializer.serialize(expression).replaceAll("\n", "").replaceAll("\r", "").replaceAll("\t", "").trim
			}
			unformatted.replace("( ", "(").replace(" )", ")").replace("[ ", "[").replace(" ]", "]").replace(" ,", ",").replace(" ;", ";")
		} catch (IConcreteSyntaxValidator.InvalidConcreteSyntaxException e) {
			//Simply return null.  Expression could not be serialized because the model is invalid.
		} catch (RuntimeException e) {
			/*
			 * See https://github.com/osate/osate2/issues/1243
			 * 
			 * I don't know why the serializer throws a RuntimeException instead of an InvalidConcreteSyntaxException in
			 * this case. Does the serializer throw RuntimeException in some cases and InvalidConcreteSyntaxException in
			 * others? Could it be that the serializer used to throw InvalidConcreteSyntaxException, but now it throws
			 * RuntimeException?
			 */
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
}
