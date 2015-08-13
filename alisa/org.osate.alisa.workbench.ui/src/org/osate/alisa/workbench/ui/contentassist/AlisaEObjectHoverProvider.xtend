package org.osate.alisa.workbench.ui.contentassist

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.ui.editor.hover.html.DefaultEObjectHoverProvider
import org.osate.alisa.workbench.alisa.AssurancePlan
import org.osate.verify.util.IVerifyGlobalReferenceFinder
import org.osate.verify.verify.VerificationPlan

class AlisaEObjectHoverProvider extends DefaultEObjectHoverProvider {

	@Inject extension IVerifyGlobalReferenceFinder referenceFinder

	override getHoverInfoAsHtml(EObject o) {
		switch (o) {
			AssurancePlan: {
				val rootsystem = o.target
				val z = rootsystem.getVerificationPlans(o).map[vp|(vp as VerificationPlan).name]
				val res = "VerificationPlans:" + z.fold("")[a, b|a + " " + b]
				return res
			}
		}
		return "No message!!"
	}

}