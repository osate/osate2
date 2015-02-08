package org.osate.alisa.common.util

import org.osate.alisa.common.common.Description
import org.osate.alisa.common.common.DescriptionElement
import org.osate.aadl2.NamedElement

class CommonUtilExtension {
		
	def static String toText(Description desc, NamedElement target){
		desc.description.map[de|de.toText(target)].reduce[a,b| a+ b]
	}
	
	def static toText(DescriptionElement de, NamedElement target){
		if (de.text != null) return de.text
		if (de.value != null) {
			return ""// XXX de.value.ref?.constantvalue?.toText?:"" 
		}
		if (de.thisTarget && target != null) {
			var nm = target.name
			if (nm.endsWith("_Instance")) nm = nm.substring(0,nm.length-9)
			return nm
		}
		""
	}
//	
//	def static String toText(ConstantValue cv){
//		switch (cv){
//			StringTerm: return cv.value
//			RealTerm: return cv.value +cv.unit?:""
//			IntegerTerm: return cv.value.toString + cv.unit?:""
//		}
//	}
	
}