package org.osate.alisa.workbench.util

import org.eclipse.emf.ecore.EObject
import org.osate.alisa.workbench.alisa.AssurancePlan
import org.osate.verify.verify.VerificationPlan
import org.osate.aadl2.ComponentClassifier
import java.util.List
import org.osate.categories.categories.SelectionCategory
import org.osate.categories.util.CategoriesUtil
import org.osate.alisa.workbench.alisa.Description
import org.osate.aadl2.NamedElement
import org.osate.alisa.workbench.alisa.DescriptionElement

class AlisaWorkbenchUtilExtension {
		
def static AssurancePlan getEnclosingAssurancePlan(EObject eo){
	var result = eo
	while (result != null){
		if (result instanceof AssurancePlan) return result
		result = result.eContainer
	}
	return null
}
	def static String toText(Description desc, NamedElement target) {
		var String res = "";
		for (de : desc.description) {
			res = res + de.toText(target)
		}
		return res
//		desc.description.map[de|de.toText(target)].reduce[a, b|a + b]
	}

	private def static stripNewlineTab(String s) {
		if (s.contains('\n'))
			return s.replaceAll("\n", " ").replaceAll("\r", "").replaceAll("\t", "")
		if (s.contains('\r'))
			return s.replaceAll("\r", " ").replaceAll("\t", "")
		return s.replace("\t"," ").replaceAll("\t","")
	}

	def static String toText(DescriptionElement de, NamedElement target) {
		if (de.text != null) {
			return de.text.stripNewlineTab
		}
		if (de.thisTarget && target != null) {
			var nm = target.name
			if(nm.endsWith("_Instance")) nm = nm.substring(0, nm.length - 9)
			return nm
		}
		""
	}
	
}