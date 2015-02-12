package org.osate.alisa.common.util

import org.osate.aadl2.NamedElement
import org.osate.alisa.common.common.Description
import org.osate.alisa.common.common.DescriptionElement
import org.osate.alisa.common.common.ComputeDeclaration
import org.osate.alisa.common.common.XNumberLiteralUnit

class CommonUtilExtension {
		
	def static String toText(Description desc, NamedElement target){
		desc.description.map[de|de.toText(target)].reduce[a,b| a+ b]
	}
	
	def static toText(DescriptionElement de, NamedElement target){
		if (de.text != null) return de.text
		if (de.showValue != null) {
			val decl = de.showValue?.ref
			if (decl instanceof ComputeDeclaration){
				// TODO convert scaled to unit specified, or to most appropriate unit without too many 999999999
			}
			// TODO handle unit specified at ShowValue level
			val x = decl?.right
			if (x instanceof XNumberLiteralUnit){
				return x.value + x.unit?.name?:""
			}
			return  x?.toString?:"" 
		}
		if (de.thisTarget && target != null) {
			var nm = target.name
			if (nm.endsWith("_Instance")) nm = nm.substring(0,nm.length-9)
			return nm
		}
		""
	}
// from GetProperties: May need to use it for actual values from compute
//	public static String toStringScaled(double value, UnitLiteral unit) {
//		UnitLiteral targetliteral = scaleupUnit(value, unit);
//		double result = value;
//		if (targetliteral != unit) {
//			result = convertToScale(value, unit, targetliteral);
//		}
//		return String.format("%.3f " + targetliteral.getName(), result);
//	}
	
}