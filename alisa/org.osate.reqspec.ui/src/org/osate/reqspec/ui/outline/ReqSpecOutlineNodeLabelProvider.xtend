package org.osate.reqspec.ui.outline;

import com.google.inject.Inject
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode
import org.eclipse.xtext.ui.editor.outline.impl.OutlineNodeLabelProvider
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil
import static extension org.osate.alisa.common.util.CommonUtilExtension.*
import org.osate.reqspec.reqSpec.Goal
import org.osate.reqspec.reqSpec.ReqSpec
import org.osate.reqspec.reqSpec.Requirement
import org.osate.reqspec.reqSpec.StakeholderGoals
import org.osate.reqspec.reqSpec.SystemRequirements
import org.eclipse.jface.viewers.StyledString
import org.eclipse.xtext.ui.editor.outline.IOutlineNode
import org.eclipse.swt.graphics.Image
import org.eclipse.emf.ecore.EObject

class ReqSpecOutlineNodeLabelProvider extends OutlineNodeLabelProvider {

	@Inject
	new(Delegate delegate) {
		super(delegate)
	}
	
	override getToolTipText(Object element) {

		switch element{
			EObjectNode : {
				val elementText = "" + element.text
				val obj = OsateResourceUtil.resourceSet.getEObject(element.EObjectURI, true)
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
//						if (obj.description != null) {
//							desc = obj.description.description.join(System.lineSeparator + " - ", 
//															System.lineSeparator + " - ", "" , [text]) 
//						}
						if (obj.description != null) {
							desc = obj.description.toText(null)
							if (!desc.nullOrEmpty){
								desc = System.lineSeparator + " - " + desc
							}
						}
						titleName + desc 
					}
					SystemRequirements : {
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
		if (styledText != null) styledText.toString() 
		null
	}
	

}
