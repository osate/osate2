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

package org.osate.reqspec.ui.outline;

import com.google.inject.Inject
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.jface.viewers.StyledString
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode
import org.eclipse.xtext.ui.editor.outline.impl.OutlineNodeLabelProvider
import org.osate.reqspec.reqSpec.Goal
import org.osate.reqspec.reqSpec.ReqSpec
import org.osate.reqspec.reqSpec.Requirement
import org.osate.reqspec.reqSpec.StakeholderGoals
import org.osate.reqspec.reqSpec.SystemRequirementSet

import static extension org.osate.alisa.common.util.CommonUtilExtension.*

class ReqSpecOutlineNodeLabelProvider extends OutlineNodeLabelProvider {

	@Inject
	new(Delegate delegate) {
		super(delegate)
	}
	
	override getToolTipText(Object element) {

		switch element{
			EObjectNode : {
				val elementText = "" + element.text
				val obj = new ResourceSetImpl().getEObject(element.EObjectURI, true)
				switch obj{
					ReqSpec :{
						elementText
					}
					StakeholderGoals : {
						obj.name
					}
					Goal : {
						var titleName = obj.name 
						!obj.title.nullOrEmpty{
							titleName = titleName + " - " + obj.title 
						}  
						var desc = ""
//						if (obj.description !== null) {
//							desc = obj.description.description.join(System.lineSeparator + " - ", 
//															System.lineSeparator + " - ", "" , [text]) 
//						}
						if (obj.description !== null) {
							desc = obj.description.toText(null)
							if (!desc.nullOrEmpty){
								desc = System.lineSeparator + " - " + desc
							}
						}
						titleName + desc 
					}
					SystemRequirementSet : {
						obj.name
					}
					Requirement : {
						obj.name + " - " + obj.title
					}
					default : elementText
				}
			}
			default: ""
		}
		
	}


	override String getText(Object element) {
		println("element = " + element)
		val StyledString styledText = getStyledText(element)
		if (styledText !== null) styledText.toString() 
		null
	}
	

}
