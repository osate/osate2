package org.osate.alisa.common.util

import org.osate.aadl2.NamedElement
import org.osate.alisa.common.common.Description
import org.osate.alisa.common.common.DescriptionElement
import org.osate.alisa.common.common.ComputeDeclaration
import org.osate.alisa.common.common.XNumberLiteralUnit
import org.osate.alisa.common.common.APropertyReference
import org.osate.aadl2.properties.PropertyLookupException
import org.osate.aadl2.ComponentType
import org.osate.aadl2.ComponentImplementation
import org.osate.aadl2.Classifier
import org.osate.aadl2.ComponentClassifier
import org.osate.aadl2.instance.ComponentInstance
import org.osate.aadl2.instance.InstanceObject
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.util.EcoreUtil

class CommonUtilExtension {

	def static String toText(Description desc, NamedElement target) {
		desc.description.map[de|de.toText(target)].reduce[a, b|a + b]
	}

	def static toText(DescriptionElement de, NamedElement target) {
		if(de.text != null) return de.text
		if (de.showValue != null) {
			val decl = de.showValue?.ref
			if (decl instanceof ComputeDeclaration) {
				// TODO convert scaled to unit specified, or to most appropriate unit without too many 999999999
			}
			// TODO handle unit specified at ShowValue level
			val x = decl?.right
			if (x instanceof APropertyReference) {
				val pd = x.property
				try {
					val pval = target.getSimplePropertyValue(pd)
					return pval.toString
				} catch (PropertyLookupException e) {
					return pd.qualifiedName()
				}
			}
			if (x instanceof XNumberLiteralUnit) {
				return x.value + x.unit?.name ?: ""
			}
			return x?.toString ?: ""
		}
		if (de.thisTarget && target != null) {
			var nm = target.name
			if(nm.endsWith("_Instance")) nm = nm.substring(0, nm.length - 9)
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
	def static boolean isSameorExtends(ComponentClassifier target, ComponentClassifier ancestor) {
		var Classifier ext = target
		if (target instanceof ComponentImplementation && ancestor instanceof ComponentType) {
			ext = (target as ComponentImplementation).getType();
		}
		while (ext != null) {
			if (ancestor.name.equalsIgnoreCase(ext.name) ) {
				return true;
			}
			ext = ext.getExtended();
		}

		return false;
	}

	def static boolean isSameorExtends(ComponentClassifier target, URI ancestorURI) {
		var Classifier ext = target
		while (ext != null) {
			EcoreUtil.getURI(ext);
			if (ancestorURI == EcoreUtil.getURI(ext) ) {
				return true;
			}
			ext = ext.getExtended();
		}
		if (target instanceof ComponentImplementation) {
			ext = (target as ComponentImplementation).getType();
		}
		while (ext != null) {
			EcoreUtil.getURI(ext);
			if (ancestorURI == EcoreUtil.getURI(ext) ) {
				return true;
			}
			ext = ext.getExtended();
		}
		return false;
	}



	def static findElementInstance(ComponentInstance io, NamedElement element) {
		switch io {
			ComponentInstance: io.allOwnedElements.findFirst[ei|
				(ei as InstanceObject).name.equalsIgnoreCase(element.name)] as InstanceObject
			default: io
		}
	}

	def static findElementInstance(ComponentInstance io, String elementName) {
		switch io {
			ComponentInstance: io.allOwnedElements.findFirst[ei|
				(ei as InstanceObject).name.equalsIgnoreCase(elementName)] as InstanceObject
			default: io
		}
	}

}