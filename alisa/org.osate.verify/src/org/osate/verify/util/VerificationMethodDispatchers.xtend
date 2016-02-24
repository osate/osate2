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
import org.osate.aadl2.instance.ComponentInstance
import org.osate.aadl2.instance.InstanceObject
import org.osate.verify.verify.FormalParameter
import org.osate.verify.verify.JavaMethod
import org.osate.verify.verify.PluginMethod
import org.osate.aadl2.RealLiteral;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.BooleanLiteral;
import org.osate.aadl2.StringLiteral;

import static extension org.osate.verify.analysisplugins.AnalysisPluginInterface.*
import org.osate.aadl2.StringLiteral
import org.eclipse.emf.ecore.EObject
import org.osate.verify.verify.VerificationMethod

class VerificationMethodDispatchers {

	public static val eInstance = new VerificationMethodDispatchers

	/**
	 * this method calls the appropriate plugin method.
	 * If the target is null it just returns true.
	 * If the methodID does not match it returns null
	 * If the method is successful it returns the Eclipse Marker type as string
	 */
	def Object dispatchVerificationMethod(PluginMethod vm, InstanceObject target, List<Object> parameters) {
		switch (vm.methodID) {
			case "FlowLatencyAnalysis",
			case "MaxFlowLatencyAnalysis",
			case "MinFlowLatencyAnalysis",
			case "FlowLatencyJitterAnalysis":
				if(target == null) true else target.flowLatencyAnalysis(parameters.map[p|(p as StringLiteral).value])
			case "A429Consistency":
				if(target == null) true else target.A429Consistency
			case "ConnectionBindingConsistency":
				if(target == null) true else target.ConnectionBindingConsistency
			case "PortDataConsistency":
				if(target == null) true else target.PortDataConsistency
			case "MassAnalysis":
				if(target == null) true else target.MassAnalysis
			case "BoundResourceAnalysis":
				if(target == null) true else target.BoundResourceAnalysis
			case "NetworkBandwidthAnalysis":
				if(target == null) true else target.NetworkBandWidthAnalysis
			case "PowerAnalysis":
				if(target == null) true else target.PowerAnalysis
			case "ResourceBudgets":
				if(target == null) true else target.ResourceBudget
			case "BinPack":
				if(target == null) true else target.Binpack
			case "CheckSafety":
				if(target == null) true else target.CheckSafety
			case "CheckSecurity":
				if(target == null) true else target.CheckSecurity
			default:
				null
		}
	}

	// invoke method in workspace project
	def Object workspaceInvoke(JavaMethod vm, InstanceObject target, List<Object> parameters) {
		val i = vm.methodPath.lastIndexOf('.')
		if (i == -1)
			return null;
		val className = vm.methodPath.substring(0, i)
		val methodName = vm.methodPath.substring(i + 1)
		val EList<FormalParameter> formalparameters = (vm.eContainer as VerificationMethod).params

		try {
			val workspaceRoot = ResourcesPlugin.workspace.root
			val model = JavaCore.create(workspaceRoot)

			val projects = model.javaProjects.filter[findType(className) != null].toSet
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
			newClasses.add(ComponentInstance)
			for (par : formalparameters) {
				val pt = par.parameterType
				val cl = forName(pt);
				newClasses.add(cl);
			}

//			for (o : parameters) {
//				newClasses.add(o.class as Class<?>)
//			}
			val method = clazz.getMethod(methodName, newClasses)
			val objects = new ArrayList()
			objects.add(target)
			for (o : parameters) {
				objects.add(o)
			}
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
		 val EList<FormalParameter> parameters = (vm.eContainer as VerificationMethod).params
		val i = vm.methodPath.lastIndexOf('.')
		if (i == -1){
			throw new IllegalArgumentException("Java method '"+vm.methodPath+"' is missing Class")
		}
		val className = vm.methodPath.substring(0, i)
		val methodName = vm.methodPath.substring(i + 1)
		try {
			val workspaceRoot = ResourcesPlugin.workspace.root
			val model = JavaCore.create(workspaceRoot)

			val projects = model.javaProjects.filter[findType(className) != null].toSet
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
			newClasses.add(ComponentInstance)
			for (par : parameters) {
				val pt = par.parameterType
				val cl = forName(pt);
				newClasses.add(cl);
			}

			val method = clazz.getMethod(methodName, newClasses)
			if(method == null) throw new IllegalArgumentException( "Method " + methodName + " not found in class instance")
		} catch (Exception e) {
			if (e instanceof InvocationTargetException) {
				return e.targetException.toString
			}
			return e.toString
		}
		return null
	}

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
			case "String": return typeof(String)
			case "Double": return typeof(Double)
			case "Long": return typeof(Long)
			case "aadlreal": return typeof(RealLiteral)
			case "RealLiteral": return typeof(RealLiteral)
			case "aadlinteger": return typeof(IntegerLiteral)
			case "IntegerLiteral": return typeof(IntegerLiteral)
			case "aadlstring": return typeof(StringLiteral)
			case "StringLIteral": return typeof(StringLiteral)
			case "aadlboolean": return typeof(BooleanLiteral)
			case "BooleanLiteral": return typeof(BooleanLiteral)
			default: return Class.forName(name)
		}
	}
	
		def String classExists(String className) {
		try {
			val workspaceRoot = ResourcesPlugin.workspace.root
			val model = JavaCore.create(workspaceRoot)

			val projects = model.javaProjects.filter[findType(className) != null].toSet
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
		} catch (Exception e) {
			if (e instanceof InvocationTargetException) {
				return e.targetException.toString
			}
			return e.toString
		}
		return null
	}
	

}
