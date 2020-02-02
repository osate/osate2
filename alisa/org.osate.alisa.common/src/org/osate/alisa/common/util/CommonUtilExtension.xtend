/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
 * All Rights Reserved.
 * 
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 * 
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */

package org.osate.alisa.common.util

import org.eclipse.xsemantics.runtime.RuleEnvironment
import java.util.Collection
import java.util.HashMap
import java.util.List
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.internal.xtend.expression.ast.NullLiteral
import org.eclipse.xtext.resource.IResourceServiceProvider
import org.osate.aadl2.Classifier
import org.osate.aadl2.ComponentClassifier
import org.osate.aadl2.ComponentImplementation
import org.osate.aadl2.ComponentType
import org.osate.aadl2.Connection
import org.osate.aadl2.EndToEndFlow
import org.osate.aadl2.Feature
import org.osate.aadl2.FlowSpecification
import org.osate.aadl2.NamedElement
import org.osate.aadl2.PropertyExpression
import org.osate.aadl2.Subcomponent
import org.osate.aadl2.instance.ComponentInstance
import org.osate.aadl2.instance.ConnectionInstance
import org.osate.aadl2.instance.InstanceObject
import org.osate.aadl2.util.Aadl2Util
import org.osate.alisa.common.common.AModelReference
import org.osate.alisa.common.common.AVariableReference
import org.osate.alisa.common.common.ComputeDeclaration
import org.osate.alisa.common.common.Description
import org.osate.alisa.common.common.DescriptionElement
import org.osate.alisa.common.common.ValDeclaration
import org.osate.alisa.common.typing.CommonInterpreter
import org.osate.aadl2.instance.EndToEndFlowInstance

class CommonUtilExtension {

	static var CommonInterpreter interpreter = IResourceServiceProvider.Registry.INSTANCE.getResourceServiceProvider(
		URI.createFileURI("dummy.___common___")).get(CommonInterpreter)

	def static String toText(Description desc, NamedElement target) {
		desc.description.map[it.toText(target)].join
	}

	private def static stripNewlineTab(String s) {
		if (s.contains('\n'))
			return s.replaceAll("\n", " ").replaceAll("\r", "").replaceAll("\t", "")
		if (s.contains('\r'))
			return s.replaceAll("\r", " ").replaceAll("\t", "")
		return s.replace("\t", " ").replaceAll("\t", "")
	}

	def static String toText(DescriptionElement de, NamedElement target) {
		if (de.text !== null) {
			de.text.stripNewlineTab
		} else if (de.thisTarget && target !== null) {
			target.getQualifiedName()
		} else if (de.showValue !== null) {
			val decl = de.showValue
			if (decl.eIsProxy) {
				"TBD"
			} else {
				val variable = (decl.expression as AVariableReference).variable
				switch (variable) {
					ComputeDeclaration:
						variable.name
					ValDeclaration: {
						val expr = variable.value
						if (expr instanceof AModelReference){
							return toText(expr)
						}
						if (target instanceof InstanceObject) {
							val RuleEnvironment env = new RuleEnvironment
							env.add('vals', new HashMap<String, PropertyExpression>)
							env.add('computes', new HashMap<String, Object>)
							env.add('target', target)
							val result = interpreter.interpretExpression(env, decl)

							if (result.failed) {
								return "Could not evaluate expression for " + variable.name + ": " +
									getFailedMsg(result.ruleFailedException)
							}
							var x = result.value
							if (x === null || x instanceof NullLiteral)
								"TBD"
							else
								x.toString
						} else {
							"value of '"+variable.name+"'"
						}
					}
				}
			}
		} else {
			""
		}
	}


	def static String getFailedMsg(Throwable e) {
		var tmp = e;
		while (tmp.cause !== null && tmp.cause != tmp) {
			tmp = tmp.cause ;
		}
		return tmp.message
	}
	
	def static String toText(AModelReference aref){
		if (aref.prev === null){
			return "this"
		} else {
			return toText(aref.prev)+"."+aref.modelElement?.name
		}
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
		if (target === null || ancestorURI === null) return false
		var Classifier ext = target
		while (ext !== null) {
			if (ancestorURI == EcoreUtil.getURI(ext)) {
				return true;
			}
			ext = ext.getExtended();
		}
		if (target instanceof ComponentImplementation) {
			ext = target.getType();
			while (ext !== null) {
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
			EndToEndFlow: return findETEFInstance(io.endToEndFlows, n)
			Subcomponent: return findElementInstanceInList(io.componentInstances, n)
			Feature: return findElementInstanceInList(io.featureInstances, n)
			FlowSpecification: return findElementInstanceInList(io.flowSpecifications, n)
			Connection: {
				val conn= findConnectionInstance(io.connectionInstances,n)
				return conn
			}
		}
		return null
	}

	def static InstanceObject findElementInstanceInList(List<? extends InstanceObject> instancelist, String name) {
		for (ei : instancelist) {
			val n1 = ei.name
			if (n1.equalsIgnoreCase(name)) return ei
		}
		return null
	}
	
	def static ConnectionInstance findConnectionInstance(Collection<ConnectionInstance> connilist, String name) {
		for (ei : connilist) {
			val conn = getCrossConnection(ei)
			if (conn !== null && name.equalsIgnoreCase(conn.name)) {
				return ei
			}
		}
		return null
	}
	
	/**
	 * @since 2.0
	 */
	def static EndToEndFlowInstance findETEFInstance(Collection<EndToEndFlowInstance> etefilist, String name) {
		for (ei : etefilist) {
			val etef = ei.endToEndFlow
			if (etef !== null && name.equalsIgnoreCase(etef.name)) {
				return ei
			}
		}
		return null
	}

	def static Collection<ConnectionInstance> findConnectionInstances(Collection<ConnectionInstance> connilist, ConnectionInstance conni) {
		val Collection<ConnectionInstance> result = newArrayList()
		val targetconn = getCrossConnection(conni)
		for (ei : connilist) {
			val conn = getCrossConnection(ei)
			if (targetconn == conn) {
				result.add(ei)
			}
		}
		return result
	}
	
	def static Connection getCrossConnection(ConnectionInstance conni){
		for (connref : conni.connectionReferences) {
			val conn = connref.connection
			if (conn.isAcross){
				return conn
			} 
		}
		return null
	}

	def static getCrossConnections(ComponentImplementation ci) {
		ci.allConnections.filter [ conn | conn.isAcross	]
	}

	public static val eInstance = new CommonUtilExtension

	/**
	 * @since 2.0
	 */
	def static Collection<EndToEndFlowInstance> findETEFInstances(Collection<EndToEndFlowInstance> etefilist, EndToEndFlowInstance etefi) {
		val Collection<EndToEndFlowInstance> result = newArrayList()
		val tetef = etefi.endToEndFlow
		for (ei : etefilist) {
			if (tetef == ei.endToEndFlow) {
				result.add(ei)
			}
		}
		return result
	}

}