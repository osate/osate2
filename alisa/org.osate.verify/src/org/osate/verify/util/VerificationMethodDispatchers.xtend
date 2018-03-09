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

package org.osate.verify.util

import java.lang.reflect.InvocationTargetException
import java.net.URL
import java.net.URLClassLoader
import java.util.ArrayList
import java.util.List
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.emf.common.util.EList
import org.eclipse.jdt.core.IClasspathEntry
import org.eclipse.jdt.core.JavaCore
import org.osate.aadl2.AadlBoolean
import org.osate.aadl2.AadlInteger
import org.osate.aadl2.AadlReal
import org.osate.aadl2.AadlString
import org.osate.aadl2.BooleanLiteral
import org.osate.aadl2.IntegerLiteral
import org.osate.aadl2.PropertyExpression
import org.osate.aadl2.PropertyType
import org.osate.aadl2.RealLiteral
import org.osate.aadl2.StringLiteral
import org.osate.aadl2.instance.ComponentInstance
import org.osate.aadl2.instance.ConnectionInstance
import org.osate.aadl2.instance.EndToEndFlowInstance
import org.osate.aadl2.instance.FeatureInstance
import org.osate.aadl2.instance.InstanceObject
import org.osate.aadl2.instance.ModeInstance
import org.osate.verify.verify.FormalParameter
import org.osate.verify.verify.JavaMethod
import org.osate.verify.verify.PluginMethod
import org.osate.verify.verify.TargetType
import org.osate.verify.verify.VerificationMethod

import static extension org.osate.verify.analysisplugins.AnalysisPluginInterface.*
import org.osate.aadl2.Aadl2Package
import org.osate.aadl2.instance.InstancePackage
import org.osate.verify.verify.JavaParameter
import org.osate.aadl2.NamedElement

class VerificationMethodDispatchers {

	public static val eInstance = new VerificationMethodDispatchers

	/**
	 * this method calls the appropriate plugin method.
	 * If the target is null it just returns true.
	 * If the methodID does not match it returns null
	 * If the method is successful it returns the Eclipse Marker type as string
	 */
	def Object dispatchVerificationMethod(PluginMethod vm, InstanceObject target, List<PropertyExpression> parameters) {
		switch (vm.methodID) {
			case "FlowLatencyAnalysis",
			case "MaxFlowLatencyAnalysis",
			case "MinFlowLatencyAnalysis",
			case "FlowLatencyJitterAnalysis":
				if (target === null) true else target.flowLatencyAnalysis(parameters.map[p|(p as StringLiteral).value])
			case "A429Consistency":
				if (target === null) true else target.A429Consistency
			case "ConnectionBindingConsistency":
				if (target === null) true else target.ConnectionBindingConsistency
			case "PortDataConsistency":
				if (target === null) true else target.PortDataConsistency
			case "MassAnalysis":
				if (target === null) true else target.MassAnalysis
			case "BoundResourceAnalysis":
				if (target === null) true else target.BoundResourceAnalysis
			case "NetworkBandwidthAnalysis":
				if (target === null) true else target.NetworkBandWidthAnalysis
			case "PowerAnalysis":
				if (target === null) true else target.PowerAnalysis
			case "ResourceBudgets":
				if (target === null) true else target.ResourceBudget
			case "BinPack":
				if (target === null) true else target.Binpack
			case "CheckSafety":
				if (target === null) true else target.CheckSafety
			case "CheckSecurity":
				if (target === null) true else target.CheckSecurity
			default:
				null
		}
	}

	// invoke method in workspace project
	def Object workspaceInvoke(JavaMethod vm, InstanceObject target, List<PropertyExpression> parameters) {
		val i = vm.methodPath.lastIndexOf('.')
		if (i == -1)
			return null;
		val className = vm.methodPath.substring(0, i)
		val methodName = vm.methodPath.substring(i + 1)
		val EList<FormalParameter> formalparameters = (vm.eContainer as VerificationMethod).formals

		try {
			val workspaceRoot = ResourcesPlugin.workspace.root
			val model = JavaCore.create(workspaceRoot)

			val projects = model.javaProjects.filter[findType(className) !== null].toSet
			if (projects.isEmpty) {
				throw new IllegalArgumentException('No such method: ' + vm.methodPath)
			} else if (projects.size > 1) {
				throw new IllegalArgumentException('Multiple methods found for ' + vm.methodPath)
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
			val instance = clazz.newInstance

			val newClasses = newArrayList()
			newClasses.add(forTargetType((vm.eContainer as VerificationMethod)))
			for (par : formalparameters) {
				val cl = getJavaClass(par,vm);
				newClasses.add(cl);
			}

			val method = clazz.getMethod(methodName, newClasses)
			val objects = new ArrayList()
			objects.add(target)
			val fpiter = formalparameters.iterator
			for (o : parameters) {
				val fp = fpiter.next
				objects.add(toJavaActual(fp,o,vm))
			}
			method.invoke(instance, objects.toArray)
		} catch (Exception e) {
			if (e instanceof InvocationTargetException) {
				throw e.targetException
			}
			throw e
		}
	}

	// invoke method in workspace project
	def Object workspaceInvoke(String javaMethod, NamedElement target) {
		val i = javaMethod.lastIndexOf('.')
		if (i == -1)
			return null;
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
			val instance = clazz.newInstance

			val newClasses = newArrayList()
//			if (target instanceof ComponentInstance){
//				newClasses.add(ComponentInstance)
//			} else if (target instanceof InstanceObject){
//				newClasses.add(InstanceObject)
//			} else {
//				newClasses.add(NamedElement)
//			}
			newClasses.add(NamedElement)
			val method = clazz.getMethod(methodName, newClasses)
			val objects = new ArrayList()
			objects.add(target)
			method.invoke(instance, objects.toArray)
		} catch (Exception e) {
			if (e instanceof InvocationTargetException) {
				throw e.targetException
			}
			throw e
		}
	}

	// Method returns null if Java class was found.
	// Otherwise it returns an error message
	def String methodExists(JavaMethod vm) {
		val EList<FormalParameter> parameters = (vm.eContainer as VerificationMethod).formals
		val i = vm.methodPath.lastIndexOf('.')
		if (i == -1) {
			throw new IllegalArgumentException("Java method '" + vm.methodPath + "' is missing Class")
		}
		val className = vm.methodPath.substring(0, i)
		val methodName = vm.methodPath.substring(i + 1)
		try {
			val workspaceRoot = ResourcesPlugin.workspace.root
			val model = JavaCore.create(workspaceRoot)

			val projects = model.javaProjects.filter[findType(className) !== null].toSet
			if (projects.isEmpty) {
				throw new IllegalArgumentException('No such method: ' + vm.methodPath)
			} else if (projects.size > 1) {
				throw new IllegalArgumentException('Multiple methods found for ' + vm.methodPath)
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
			newClasses.add(forTargetType((vm.eContainer as VerificationMethod)))
			for (par : parameters) {
				val cl = getJavaClass(par,vm);
				newClasses.add(cl);
			}

			val method = clazz.getMethod(methodName, newClasses)
			if (method === null)
				throw new IllegalArgumentException("Method " + methodName + " not found in class instance")
		} catch (Exception e) {
			if (e instanceof InvocationTargetException) {
				return e.targetException.toString
			}
			return e.toString
		}
		return null
	}

	
	def Class<?> forTargetType(VerificationMethod vm){
		switch (vm.targetType){
			case TargetType.FEATURE: typeof(FeatureInstance)
			case COMPONENT: { typeof(ComponentInstance)
			}
			case CONNECTION: {typeof(ConnectionInstance)
			}
			case ELEMENT: { typeof(InstanceObject)
			}
			case FLOW: {typeof(EndToEndFlowInstance)
			}
			case MODE: {typeof(ModeInstance)
			}
		}
	}
	
	def Class<?> getJavaClass(FormalParameter fp, JavaMethod vm){
		val jparameters = vm.params
		for (jp : jparameters){
			if (fp.name.equalsIgnoreCase(jp.name)){
				return forName(jp.parameterType)
			}
		}
		forName(fp.type)
	}

	/**
	 * return Java Class for PropertyType
	 */
	def Class<?> forName(PropertyType type) throws ClassNotFoundException {
		switch (type) {
			AadlString: return typeof(String)
			AadlReal: return typeof(RealLiteral)
			AadlInteger: return typeof(IntegerLiteral)
			AadlBoolean: return typeof(BooleanLiteral)
		}
	}

	/**
	 * return Java Class for class specified by name in JavaParameter
	 */
	def Class<?> forName(String name) throws ClassNotFoundException {
		switch (name) {
			case void.name: return typeof(void)
			case boolean.name: return typeof(boolean)
			case byte.name: return typeof(byte)
			case char.name: return typeof(char)
			case short.name: return typeof(short)
			case int.name: return typeof(int)
			case float.name: return typeof(float)
			case long.name: return typeof(long)
			case double.name: return typeof(double)
			case String.name: return typeof(String)
			case "Double": return typeof(Double)
			case "Long": return typeof(Long)
			case AadlReal.name: return typeof(RealLiteral)
			case AadlInteger.name: return typeof(IntegerLiteral)
			case AadlBoolean.name: return typeof(BooleanLiteral)
			default: {
				var ecl = Aadl2Package.eINSTANCE.getEClassifier(name);
				if (ecl === null){
					InstancePackage.eINSTANCE.getEClassifier(name)
				}
				if (ecl !== null) return ecl.instanceClass
				return Class.forName(name)
			}
		}
	}
	
	def Object toJavaActual(FormalParameter formal, PropertyExpression actual, JavaMethod vm){
		val jparameters = vm.params
		for (jp : jparameters){
			if (formal.name.equalsIgnoreCase(jp.name)){
				return convertToJavaObject(jp,actual)
			}
		}
		actual
	}

	def Object convertToJavaObject(JavaParameter formalParam, PropertyExpression actual) {
		var Object result = actual
		switch (actual) {
			RealLiteral: if (formalParam.parameterType.equalsIgnoreCase("double") ||
				formalParam.parameterType.equalsIgnoreCase("real")) result = actual.value
			IntegerLiteral: {
				if (formalParam.parameterType.equalsIgnoreCase("long")) {
					result = actual.value
				} else if (formalParam.parameterType.equalsIgnoreCase("int")) {
					result = actual.value.intValue
				}
			}
			StringLiteral: if (formalParam.parameterType.equalsIgnoreCase("string")) result = actual.value
			BooleanLiteral: if (formalParam.parameterType.equalsIgnoreCase("boolean")) result = actual.isValue
		}
		return result
	}

	def String classExists(String className) {
		try {
			findClass(className);
		} catch (Exception e) {
			if (e instanceof InvocationTargetException) {
				return e.targetException.toString
			}
			return e.toString
		}
		return null
	}

	def Class<?> findClass(String className) {
		val workspaceRoot = ResourcesPlugin.workspace.root
		val model = JavaCore.create(workspaceRoot)

		val projects = model.javaProjects.filter[findType(className) !== null].toSet
		if (projects.isEmpty) {
			throw new IllegalArgumentException('No such class: ' + className)
		} else if (projects.size > 1) {
			throw new IllegalArgumentException('Multiple methods found for ' + className)
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
		return clazz
	}

}
