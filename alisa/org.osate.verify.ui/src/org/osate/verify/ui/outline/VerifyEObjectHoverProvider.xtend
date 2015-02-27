package org.osate.verify.ui.outline

import org.eclipse.xtext.ui.editor.hover.html.DefaultEObjectHoverProvider
import org.eclipse.emf.ecore.EObject
import org.osate.verify.verify.VerificationActivity
import static extension org.osate.alisa.common.util.CommonUtilExtension.*
import static extension org.osate.reqspec.util.ReqSpecUtilExtension.*
import org.osate.reqspec.reqSpec.Requirement


class VerifyEObjectHoverProvider extends DefaultEObjectHoverProvider {
		override getHoverInfoAsHtml(EObject o){
		switch (o){
			VerificationActivity: {
				val Requirement req = o.requirement
		val z =  (req.title?:"") 
		val zz = req.description?.toText(req.requirementTarget)
				val res =  z + ": " + zz
				return res
				}
		}
		return "No message!!"
	}
	
	
}