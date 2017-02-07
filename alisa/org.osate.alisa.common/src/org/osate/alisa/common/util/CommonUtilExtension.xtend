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

import it.xsemantics.runtime.RuleEnvironment
import java.lang.reflect.InvocationTargetException
import java.net.URL
import java.net.URLClassLoader
import java.util.HashMap
import java.util.List
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.internal.xtend.expression.ast.NullLiteral
import org.eclipse.jdt.core.IClasspathEntry
import org.eclipse.jdt.core.JavaCore
import org.eclipse.xtext.resource.IResourceServiceProvider
import org.osate.aadl2.Classifier
import org.osate.aadl2.ComponentClassifier
import org.osate.aadl2.ComponentImplementation
import org.osate.aadl2.ComponentType
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
import org.osate.alisa.common.common.AVariableReference
import org.osate.alisa.common.common.ComputeDeclaration
import org.osate.alisa.common.common.Description
import org.osate.alisa.common.common.DescriptionElement
import org.osate.alisa.common.common.ValDeclaration
import org.osate.alisa.common.typing.CommonInterpreter

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
						val RuleEnvironment env = new RuleEnvironment
						env.add('vals', new HashMap<String, PropertyExpression>)
						env.add('computes', new HashMap<String, Object>)
						val result = interpreter.interpretExpression(env, decl)

						if (result.failed) {
							return "Could not evaluate expression for " + variable.name + ": " +
								result.ruleFailedException
						}
						var x = result.value
						if (x === null || x instanceof NullLiteral)
							"TBD"
						else
							x.toString
					}
				}
			}
		} else {
			""
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
			EndToEndFlow: return findElementInstanceInList(io.endToEndFlows, n)
			Subcomponent: return findElementInstanceInList(io.componentInstances, n)
			Feature: return findElementInstanceInList(io.featureInstances, n)
			FlowSpecification: return findElementInstanceInList(io.flowSpecifications, n)
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
		if (res === null) res = findElementInstanceInList(io.componentInstances, n)
		if (res === null) res = findElementInstanceInList(io.featureInstances, n)
		return res
	}

	public static val eInstance = new CommonUtilExtension

	// Method returns null if Java class was found.
	// Otherwise it returns an error message
	def String methodExists(String javaMethod) {
		val i = javaMethod.lastIndexOf('.')
		if (i == -1) {
			throw new IllegalArgumentException("Java method '" + javaMethod + "' is missing Class")
		}
		val className = javaMethod.substring(0, i)
		val methodName = javaMethod.substring(i + 1)
		try {
			val workspaceRoot = ResourcesPlugin.workspace.root
			val model = JavaCore.create(workspaceRoot)

			val projects = model.javaProjects.filter[findType(className) !== null].toSet
			if (projects.isEmpty) {
				throw new IllegalArgumentException('No such method: ' + javaMethod)
			} else if (projects.size > 1) {
				throw new IllegalArgumentException('Multiple methods found for ' + javaMethod)
			}
			var changed = true
			while (changed) {
				val referenced = projects.map [ p |
					val cpes = p.getResolvedClasspath(true).filter[entryKind == IClasspathEntry.CPE_PROJECT]
					val paths = cpes.map[it.path]
					paths.map[model.getJavaProject(it.toString)]
				].flatten
				changed = projects += referenced
			}
			val urls = projects.map [ p |
				val file = workspaceRoot.getFile(p.outputLocation)
				new URL(file.locationURI + "/")
			]

			val parent = class.classLoader
			val loader = new URLClassLoader(urls, parent);
			val clazz = Class.forName(className, true, loader);
			val newClasses = newArrayList()
			newClasses.add(NamedElement)

			var method = clazz.getMethod(methodName, newClasses)
			if (method === null) {
				val altClasses = newArrayList()
				altClasses.add(InstanceObject)
				method = clazz.getMethod(methodName, newClasses)
			}
		} catch (Exception e) {
			if (e instanceof InvocationTargetException) {
				return e.targetException.toString
			}
			return e.toString
		}
		return null
	}

}