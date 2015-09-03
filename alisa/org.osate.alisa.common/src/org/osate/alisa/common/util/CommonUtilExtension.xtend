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
import org.eclipse.emf.common.util.EList
import org.osate.aadl2.EndToEndFlow
import org.osate.aadl2.Subcomponent
import org.osate.aadl2.Feature
import org.osate.aadl2.util.Aadl2Util
import org.eclipse.xtext.xbase.XFeatureCall
import org.eclipse.xtext.xbase.impl.XFeatureCallImplCustom

class CommonUtilExtension {

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
		if (de.showValue != null) {
			val decl = de.showValue?.ref
			if (decl.eIsProxy) return "TBD"
			if (decl instanceof ComputeDeclaration) {
				// TODO convert scaled to unit specified, or to most appropriate unit without too many 999999999
			}
			// TODO handle unit specified at ShowValue level
			val x = decl?.right
			if (x == null) return "TBD"
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
				if (x.unit != null)
					return x.value + x.unit?.name
				else
					return x.value
			}
			if (x instanceof XFeatureCall) {
				val y = x.concreteSyntaxFeatureName
				return y
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
		if(Aadl2Util.isNull(target) || Aadl2Util.isNull(ancestor)) return false
		var Classifier ext = target
		if (target instanceof ComponentImplementation && ancestor instanceof ComponentType) {
			ext = (target as ComponentImplementation).getType();
		}
		while (!Aadl2Util.isNull(ext)) {
			if (ancestor.name.equalsIgnoreCase(ext.name)) {
				return true;
			}
			ext = ext.getExtended();
		}

		return false;
	}

	def static boolean isSameorExtends(ComponentClassifier target, URI ancestorURI) {
		if(target == null || ancestorURI == null) return false
		var Classifier ext = target
		while (ext != null) {
			if (ancestorURI == EcoreUtil.getURI(ext)) {
				return true;
			}
			ext = ext.getExtended();
		}
		if (target instanceof ComponentImplementation) {
			ext = (target as ComponentImplementation).getType();
			while (ext != null) {
				if (ancestorURI == EcoreUtil.getURI(ext)) {
					return true;
				}
				ext = ext.getExtended();
			}
		}
		return false;
	}

	def static InstanceObject findElementInstance(ComponentInstance io, NamedElement element) {
		val n = element.name
		switch (element) {
			EndToEndFlow: return findElementInstanceInList(io.endToEndFlows, n)
			Subcomponent: return findElementInstanceInList(io.componentInstances, n)
			Feature: return findElementInstanceInList(io.featureInstances, n)
		}
		return null
	}

	def static InstanceObject findElementInstanceInList(EList<? extends InstanceObject> instancelist, String name) {
		for (ei : instancelist) {
			val n1 = ei.name
			if(name.equalsIgnoreCase(n1)) return ei
		}
		return null
	}

	def static findElementInstance(ComponentInstance io, String elementName) {
		val n = elementName
		var res = findElementInstanceInList(io.endToEndFlows, n)
		if(res == null) res = findElementInstanceInList(io.componentInstances, n)
		if(res == null) res = findElementInstanceInList(io.featureInstances, n)
		return res
	}

}