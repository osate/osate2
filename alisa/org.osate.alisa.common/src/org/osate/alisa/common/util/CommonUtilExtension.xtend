/**
 * Copyright 2015 Carnegie Mellon University. All Rights Reserved.
 * 
 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING INSTITUTE
 * MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO
 * WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY,
 * EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON
 * UNIVERSITY DOES NOT MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM
 * PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * Released under the Eclipse Public License (http://www.eclipse.org/org/documents/epl-v10.php)
 * 
 * See COPYRIGHT file for full details.
 */

package org.osate.alisa.common.util

import java.util.ArrayList
import java.util.List
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.internal.xtend.expression.ast.NullLiteral
import org.osate.aadl2.Classifier
import org.osate.aadl2.ComponentClassifier
import org.osate.aadl2.ComponentImplementation
import org.osate.aadl2.ComponentType
import org.osate.aadl2.EndToEndFlow
import org.osate.aadl2.Feature
import org.osate.aadl2.NamedElement
import org.osate.aadl2.Property
import org.osate.aadl2.PropertyConstant
import org.osate.aadl2.Subcomponent
import org.osate.aadl2.instance.ComponentInstance
import org.osate.aadl2.instance.ConnectionInstance
import org.osate.aadl2.instance.InstanceObject
import org.osate.aadl2.properties.PropertyLookupException
import org.osate.aadl2.util.Aadl2Util
import org.osate.alisa.common.common.AModelReference
import org.osate.alisa.common.common.APropertyReference
import org.osate.alisa.common.common.ComputeDeclaration
import org.osate.alisa.common.common.Description
import org.osate.alisa.common.common.DescriptionElement
import org.osate.alisa.common.common.ValDeclaration

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
		return s.replace("\t", " ").replaceAll("\t", "")
	}

	def static String toText(DescriptionElement de, NamedElement target) {
		if (de.text != null) {
			return de.text.stripNewlineTab
		}
		if (de.showValue != null) {
			val decl = de.showValue?.ref
			if (decl.eIsProxy) return "TBD"
			if (decl instanceof ComputeDeclaration) {
				return decl.name
			} else if (decl instanceof ValDeclaration) {
				val x = decl?.value
				if (x == null || x instanceof NullLiteral) return "TBD"
				if (x instanceof APropertyReference) {
					val pd = x.property
					if (pd instanceof Property) {
						try {
							val pval = target.getSimplePropertyValue(pd)
							return pval.toString
						} catch (PropertyLookupException e) {
							return pd.qualifiedName()
						}
					} else if (pd instanceof PropertyConstant) {
						val actual = pd.constantValue
						return actual.toString
					}

				}
			}
			if (decl.eIsProxy) return "TBD"
			if (decl instanceof ComputeDeclaration) {
				return decl.name
			} else if (decl instanceof ValDeclaration) {
				val x = decl?.value
				if (x == null || x instanceof NullLiteral) return "TBD"
				if (x instanceof APropertyReference) {
					val pd = x.property
					if (pd instanceof Property) {
						try {
							val pval = target.getSimplePropertyValue(pd)
							return pval.toString
						} catch (PropertyLookupException e) {
							return pd.qualifiedName()
						}
					}
				}
				return x?.toString ?: ""
			}
		}
		if (de.thisTarget && target != null) {
			var nm = target.name
			if (nm.endsWith("_Instance")) nm = nm.substring(0, nm.length - 9)
			return nm
		}
		""
	}

// from GetProperties: May need to use it for actual values from compute
//	def static String toStringScaled(double value, UnitLiteral unit) {
//		val targetliteral = scaleupUnit(value, unit);
//		var result = value;
//		if (targetliteral != unit) {
//			result = convertToScale(value, unit, targetliteral);
//		}
//		return String.format("%.3f " + targetliteral.getName(), result);
//	}
	def static boolean isSameorExtends(Classifier target, Classifier ancestor) {
		if (Aadl2Util.isNull(target) || Aadl2Util.isNull(ancestor)) return false
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

	def static boolean isSameorExtendsURI(ComponentClassifier target, URI ancestorURI) {
		if (target == null || ancestorURI == null) return false
		var Classifier ext = target
		while (ext != null) {
			if (ancestorURI == EcoreUtil.getURI(ext)) {
				return true;
			}
			ext = ext.getExtended();
		}
		if (target instanceof ComponentImplementation) {
			ext = target.getType();
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

	def static InstanceObject findElementInstanceInList(List<? extends InstanceObject> instancelist, String name) {
		for (ei : instancelist) {
			val n1 = ei.name
			if (name.equalsIgnoreCase(n1)) return ei
		}
		return null
	}

	def static ConnectionInstance findConnectionInstance(ComponentInstance ci, String name) {
		for (ei : ci.connectionInstances) {
			for (connref : ei.connectionReferences) {
				val conn = connref.connection
				if (conn.source.context instanceof Subcomponent && conn.destination.context instanceof Subcomponent &&
					name.equalsIgnoreCase(conn.name)) return ei
			}
		}
		return null
	}

	def static getCrossConnections(ComponentImplementation ci) {
		ci.allConnections.filter [ conn |
			conn.source.context instanceof Subcomponent && conn.destination.context instanceof Subcomponent
		]
	}

	def static findElementInstance(ComponentInstance io, String elementName) {
		val n = elementName
		var res = findElementInstanceInList(io.endToEndFlows, n)
		if (res == null) res = findElementInstanceInList(io.componentInstances, n)
		if (res == null) res = findElementInstanceInList(io.featureInstances, n)
		return res
	}

	/**
	 * Resolve a model element reference relative to an instance object
	 */
	static def InstanceObject resolve(AModelReference ref, InstanceObject root) {
		if (ref.prev == null)
			root
		else {
			val io = ref.prev.resolve(root)
			io.eContents.findFirst[
				if (it instanceof InstanceObject) it.name.equalsIgnoreCase(ref.modelElement.name) else false
			] as InstanceObject
		}
	}
	
	
}