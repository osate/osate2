package org.osate.alisa.workbench.util

import com.google.inject.ImplementedBy
import com.google.inject.Inject
import org.eclipse.emf.ecore.util.EcoreUtil
import org.osate.aadl2.ComponentClassifier
import org.osate.aadl2.ComponentImplementation
import org.osate.alisa.common.scoping.ICommonGlobalReferenceFinder
import org.osate.alisa.common.util.CommonUtilExtension
import org.osate.alisa.workbench.alisa.AlisaPackage
import org.osate.alisa.workbench.alisa.AssuranceCase
import org.osate.alisa.workbench.alisa.AssurancePlan

@ImplementedBy(AlisaGlobalReferenceFinder)
interface IAlisaGlobalReferenceFinder {
	/**
	 * these methods should not be used to construct scopes
	 */
	def Iterable<AssurancePlan> getAssurancePlans(ComponentImplementation ci);

	def Iterable<AssuranceCase> getAssuranceCases(ComponentClassifier ci);
}

class AlisaGlobalReferenceFinder implements IAlisaGlobalReferenceFinder {

	@Inject var ICommonGlobalReferenceFinder commonRefFinder

	override Iterable<AssurancePlan> getAssurancePlans(ComponentImplementation ci) {
		val listAccessiblePlans = commonRefFinder.getEObjectDescriptions(ci, AlisaPackage.Literals.ASSURANCE_CASE,
			"alisa").map [ eod |
			EcoreUtil.resolve(eod.EObjectOrProxy, ci) as AssuranceCase
		].map[ap|ap.assurancePlans].flatten.filter[mp|CommonUtilExtension.isSameorExtends(ci, mp.target)]
		return listAccessiblePlans

	}

	override getAssuranceCases(ComponentClassifier ci) {
		val cases = commonRefFinder.getEObjectDescriptions(ci, AlisaPackage.Literals.ASSURANCE_CASE, "alisa").map [ eod |
			EcoreUtil.resolve(eod.EObjectOrProxy, ci) as AssuranceCase
		].filter[mp|CommonUtilExtension.isSameorExtends(ci, mp.system)]
		return cases
	}

}