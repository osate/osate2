/**
 * Copyright 2015 Carnegie Mellon University. All Rights Reserved.
 *
 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING INSTITUTE
 * MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO
 * WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY,
 * EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON
 * UNIVERSITY DOES NOT MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM
 * PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * Released under the Eclipse Public License (http://www.eclipse.org/org/documents/epl-v10.php)
 *
 * See COPYRIGHT file for full details.
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
