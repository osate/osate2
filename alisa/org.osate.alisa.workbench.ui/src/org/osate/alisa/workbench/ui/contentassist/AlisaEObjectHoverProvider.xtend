package org.osate.alisa.workbench.ui.contentassist

import org.eclipse.xtext.ui.editor.hover.html.DefaultEObjectHoverProvider
import org.eclipse.emf.ecore.EObject
import org.osate.alisa.workbench.alisa.AssurancePlan
import com.google.inject.Inject
import org.eclipse.xtext.scoping.IGlobalScopeProvider
import org.osate.verify.verify.VerificationPlan
import org.osate.alisa.common.scoping.CommonGlobalScopeProvider
import org.eclipse.emf.ecore.util.EcoreUtil
import org.osate.aadl2.ComponentClassifier
import static extension org.osate.alisa.common.util.CommonUtilExtension.*
import static org.osate.alisa.workbench.util.AlisaWorkbenchUtilExtension.*
import org.osate.verify.verify.VerifyPackage

class AlisaEObjectHoverProvider extends DefaultEObjectHoverProvider {
		override getHoverInfoAsHtml(EObject o){
		switch (o){
			AssurancePlan: {
				val rootsystem = o.target
		val z =  rootsystem.getVerificationPlans().map[vp|vp.name] 
				val res =  "VerificationPlans: " + z.fold("")[a,b| a+", "+b]
				return res
				}
		}
		return "No message!!"
	}
	
			
	@Inject
	var IGlobalScopeProvider scopeProvider

		def Iterable<VerificationPlan> getVerificationPlans(ComponentClassifier cc){
			val x = (scopeProvider as CommonGlobalScopeProvider).getGlobalEObjectDescriptions(cc,VerifyPackage.eINSTANCE.verificationPlan,null)
			val y = x.map[ied|EcoreUtil.resolve(ied.EObjectOrProxy, cc) as VerificationPlan]
			val z = y.filter [  vp | cc.isSameorExtends(getTargetComponentClassifier(vp))]
			return z
	}
	
}