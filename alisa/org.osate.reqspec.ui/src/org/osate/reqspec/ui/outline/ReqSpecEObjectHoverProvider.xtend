package org.osate.reqspec.ui.outline

import org.eclipse.xtext.ui.editor.hover.html.DefaultEObjectHoverProvider
import org.eclipse.emf.ecore.EObject
import static extension org.osate.alisa.common.util.CommonUtilExtension.*
import static extension org.osate.reqspec.util.ReqSpecUtilExtension.*
import org.osate.reqspec.reqSpec.Requirement
import org.osate.reqspec.reqSpec.Goal
import org.osate.reqspec.reqSpec.ContractualElement

class ReqSpecEObjectHoverProvider extends DefaultEObjectHoverProvider {
		override getHoverInfoAsHtml (EObject o){ 
		switch (o){
			Requirement: {
				return reqText(o)
				}
			Goal: {
				return reqText(o)
				}
		}
		return "No message!!"
	}
	
	
	def reqText(ContractualElement req){
				val z =  (req.title?:"") 
				val zz = req.description?.toText(req.targetClassifier)
				val res = req.eClass.name+" "+req.name+": "+ z + ": " + zz
				return res
	}
	
}