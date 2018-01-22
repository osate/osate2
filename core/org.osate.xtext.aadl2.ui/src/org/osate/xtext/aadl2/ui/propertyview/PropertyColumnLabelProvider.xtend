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
import org.eclipse.swt.graphics.Image
import org.osate.aadl2.BasicProperty
import org.osate.aadl2.BasicPropertyAssociation
import org.osate.aadl2.ComponentClassifier
import org.osate.aadl2.ModalPropertyValue
import org.osate.aadl2.Property
import org.osate.aadl2.PropertyAssociation
import org.osate.aadl2.PropertySet
import org.osate.xtext.aadl2.ui.MyAadl2Activator
import org.eclipse.emf.ecore.EObject
import org.osate.aadl2.Subcomponent
import org.osate.aadl2.modelsupport.util.AadlUtil
import org.osate.aadl2.instance.InstanceObject

package class PropertyColumnLabelProvider extends ColumnLabelProvider {
	val static MODE_ICON = "icons/propertyview/mode.gif"
	val static SCALAR_ICON = "icons/propertyview/scalar.gif"
	val static LIST_ICON = "icons/propertyview/list.gif"
	val static PROPERTY_SET_ICON = "icons/propertyview/property_set.gif"
	
	val AadlPropertyView propertyView
	
	/** Cached Icon for property set nodes */
	var Image propSetImage = null
	/** Cached Icon for list property value nodes */
	var Image listImage = null
	/** Cached Icon for scalar property value nodes */
	var Image scalarImage = null
	/** Cached Icon for modes */
	var Image modeImage = null
	
	package new(AadlPropertyView propertyView) {
		this.propertyView = propertyView
	}
	
	override getText(Object element) {
		if (!(element instanceof TreeEntry))
			null
		else {
			switch treeElement : (element as TreeEntry).treeElement {
				URI: propertyView.safeRead[extension it | switch treeElementEObject : treeElement.getEObject(true) {
					PropertySet,
					BasicProperty: treeElementEObject.name
					ModalPropertyValue: {
						val modes = if (treeElementEObject.allInModes.empty) {
							//This ModalPropertyValue exists in all modes that are not listed for other ModalPropertyValues
							getModesFromClassifierThatDeclaresModes(propertyView.input.getEObject(true)).filter[classifierMode |
								(treeElementEObject.owner as PropertyAssociation).ownedValues.forall[!allInModes.contains(classifierMode)]
							]
						} else {
							treeElementEObject.allInModes
						}
						'''in modes («modes.map[name].join(", ")»)'''
					}
					BasicPropertyAssociation: treeElementEObject.property.name
				}]
				RangeElement: treeElement.label
				ListElement: "# " + treeElement.index
			}
		}
	}
	
	/**
	 * Get the ComponentClassifier that declares the modes that may appear in "in modes" clauses
	 * property associations on this object.
	 */
	def private static getClassifierThatDeclaresModes(EObject propertySrc) {
		if (propertySrc instanceof Subcomponent) {
			// Subcomponent: use the classifier of the subcomponent
			(propertySrc as Subcomponent).classifier
		} else { // TODO: Check for instance model
			/* Find the nearest enclosing classifier.  The below method could return a FeatureGroup in theory, 
			 * but feature groups cannot have modes, so they wouldn't be encountered in this situation.
			 */
			AadlUtil.getContainingClassifier(propertySrc) as ComponentClassifier
		}
	}
	
	def private static getModesFromClassifierThatDeclaresModes(EObject propertySrc) {
		if (propertySrc instanceof InstanceObject) {
			(propertySrc as InstanceObject).systemInstance.systemOperationModes
		} else {
			getClassifierThatDeclaresModes(propertySrc).allModes
		}
	}
	
	override getForeground(Object element) {
		if (!(element instanceof TreeEntry))
			null
		else {
			val treeElement = (element as TreeEntry).treeElement
			if (treeElement instanceof URI) {
				propertyView.safeRead[extension it | switch treeElementEObject : treeElement.getEObject(true) {
					Property case propertyView.getPropertyStatus(((element as TreeEntry).parent as TreeEntry).treeElement as URI, treeElement) == PropertyStatus.UNDEFINED,
					BasicProperty case !(treeElementEObject instanceof Property): propertyView.site.shell.display.getSystemColor(SWT.COLOR_RED)
				}]
			}
		}
	}
	
	override getImage(Object element) {
		if (!(element instanceof TreeEntry))
			null
		else {
			val treeElement = (element as TreeEntry).treeElement
			if (treeElement instanceof URI) {
				propertyView.safeRead[extension it | switch treeElementEObject : treeElement.getEObject(true) {
					PropertySet: propSetImage ?: (propSetImage = MyAadl2Activator.getImageDescriptor(PROPERTY_SET_ICON).createImage)
					Property case treeElementEObject.list: listImage ?: (listImage = MyAadl2Activator.getImageDescriptor(LIST_ICON).createImage)
					Property case !treeElementEObject.list: scalarImage ?: (scalarImage = MyAadl2Activator.getImageDescriptor(SCALAR_ICON).createImage)
					ModalPropertyValue: modeImage ?: (modeImage = MyAadl2Activator.getImageDescriptor(MODE_ICON).createImage)
				}]
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