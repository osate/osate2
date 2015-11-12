package org.osate.verify.ui.outline

import org.eclipse.xtext.ui.editor.hover.html.DefaultEObjectHoverProvider
import org.eclipse.emf.ecore.EObject
import org.osate.verify.verify.VerificationActivity
import static extension org.osate.alisa.common.util.CommonUtilExtension.*
import static extension org.osate.reqspec.util.ReqSpecUtilExtension.*
import static extension org.osate.verify.util.VerifyUtilExtension.*
import org.osate.reqspec.reqSpec.Requirement
import org.osate.verify.verify.Claim

class VerifyEObjectHoverProvider extends DefaultEObjectHoverProvider {
		override getHoverInfoAsHtml (EObject o){ 
		switch (o){
			VerificationActivity: {
				val Requirement req = o.containingClaim.requirement
				return reqText(req)
				}
			Claim: {
				val Requirement req = o.requirement
				return reqText(req)
				}
		}
		return "No message!!"
	}
	
	
	def reqText(Requirement req){
				val z =  (req.title?:"") 
				val zz = req.description?.toText(req.targetClassifier)
				val res = "Requirement "+req.name+": "+ z + ": " + zz
				return res
	}
	
}