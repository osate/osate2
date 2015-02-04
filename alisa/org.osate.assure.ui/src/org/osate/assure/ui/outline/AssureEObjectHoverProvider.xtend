package org.osate.assure.ui.outline

import org.eclipse.xtext.ui.editor.hover.html.DefaultEObjectHoverProvider
import org.eclipse.emf.ecore.EObject
import org.osate.assure.assure.CaseResult
import org.osate.assure.assure.ClaimResult
import org.osate.assure.assure.VerificationActivityResult
import org.osate.assure.assure.AssumptionResult
import org.osate.assure.assure.PreconditionResult
import org.osate.assure.assure.ResultIssue

class AssureEObjectHoverProvider extends DefaultEObjectHoverProvider {
	override getHoverInfoAsHtml(EObject o){
		switch (o){
			CaseResult: return o.message?:"No message"
			ClaimResult: return o.message?:"No message"
			VerificationActivityResult: return o.message?:"No message"
			AssumptionResult: return o.message?:"No message"
			PreconditionResult: return o.message?:"No message"
			ResultIssue: return o.message?:"No message"
		}
		return "No message!!"
	}
}