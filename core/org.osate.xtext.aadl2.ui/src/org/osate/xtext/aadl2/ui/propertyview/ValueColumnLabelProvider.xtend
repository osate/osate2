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
