package org.osate.alisa.workbench.util

import com.google.inject.ImplementedBy
import org.osate.aadl2.ComponentClassifier
import org.osate.aadl2.ComponentImplementation
import org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil
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

	override Iterable<AssurancePlan> getAssurancePlans(ComponentImplementation ci) {
		val listAccessiblePlans = Aadl2GlobalScopeUtil.getAll(ci,  
			AlisaPackage.Literals.ASSURANCE_PLAN).map[ape| ape as AssurancePlan].filter[mp|CommonUtilExtension.isSameorExtends(ci, mp.target)]
		return listAccessiblePlans

	}

	override getAssuranceCases(ComponentClassifier ci) {
		val cases = Aadl2GlobalScopeUtil.getAll(ci, AlisaPackage.Literals.ASSURANCE_CASE)
		.map [ eod |eod as AssuranceCase]
		.filter[mp|CommonUtilExtension.isSameorExtends(ci, mp.system)]
		return cases
	}

}