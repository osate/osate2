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