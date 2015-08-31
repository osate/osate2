package org.osate.verify.util

import java.lang.reflect.InvocationTargetException
import java.net.URL
import java.net.URLClassLoader
import java.util.ArrayList
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.jdt.core.IClasspathEntry
import org.eclipse.jdt.core.JavaCore
import org.osate.aadl2.instance.ComponentInstance
import org.osate.aadl2.instance.InstanceObject
import org.osate.verify.verify.JavaMethod
import org.osate.verify.verify.PluginMethod

import static extension org.osate.verify.analysisplugins.AnalysisPluginInterface.*
import org.eclipse.emf.common.util.EList
import org.eclipse.xtext.common.types.JvmFormalParameter
import java.util.Map
import java.util.concurrent.ConcurrentHashMap

class VerificationMethodDispatchers  {

 public static val eInstance = new VerificationMethodDispatchers

	
	/**
	 * this method calls the appropriate plugin method.
	 * If the target is null it just returns true.
	 * If the methodID does not match it returns null
	 * If the method is successful it returns the Eclipse Marker type as string
	 */
	 def Object dispatchVerificationMethod(PluginMethod vm, InstanceObject target, Object[] parameters) {
		switch (vm.methodID) {
			case "FlowLatencyAnalysis" : {
				if (target == null) return true
				return target?.flowLatencyAnalysis
			}
			case "MaxFlowLatencyAnalysis" : {
				if (target == null) return true
				return target?.flowLatencyAnalysis
			}
			case "MinFlowLatencyAnalysis" : {
				if (target == null) return true
				return target?.flowLatencyAnalysis
			}
			case "FlowLatencyJitterAnalysis" : {
				if (target == null) return true
				return target?.flowLatencyAnalysis
			}
			case "A429Consistency": {
				if (target == null) return true
				return target.A429Consistency
			}
			case "ConnectionBindingConsistency": {
				if (target == null) return true
				return target.ConnectionBindingConsistency
			}
			case "PortDataConsistency": {
				if (target == null) return true
				return target.PortDataConsistency
			}
			case "MassAnalysis": {
				if (target == null) return true
				return target.MassAnalysis
			}
			case "BoundResourceAnalysis": {
				if (target == null) return true
				return target.BoundResourceAnalysis
			}
			case "NetworkBandwidthAnalysis": {
				if (target == null) return true
				return target.NetworkBandWidthAnalysis
			}
			case "PowerAnalysis": {
				if (target == null) return true
				return target.PowerAnalysis
			}
			case "ResourceBudgets": {
				if (target == null) return true
				return target.ResourceBudget
			}
			case "BinPack": {
				if (target == null) return true
				return target.Binpack
			}
			case "CheckSafety": {
				if (target == null) return true
				return target.CheckSafety
			}
			case "CheckSecurity": {
				if (target == null) return true
				return target.CheckSecurity
			}
		}
		return null
	}

	// invoke method in workspace project
	def Object workspaceInvoke(JavaMethod vm, InstanceObject target, Object[] parameters) {
		val i = vm.methodPath.lastIndexOf('.')
		if ( i == -1)
		return null;
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
			val instance = clazz.newInstance
			
		
			
			val newClasses = newArrayList()
			newClasses.add(ComponentInstance)
			
			for (o : parameters)
			{
				newClasses.add(o.class as Class)
				println ("has to load class " + o.class.name)
			}	
			val method = clazz.getMethod(methodName, newClasses)
			val objects = new ArrayList ()
			objects.add(target)
			for (o : parameters)
			{
				objects.add (o)
			}	
			method.invoke(instance, objects.toArray)
		} catch (Exception e) {
			if (e instanceof InvocationTargetException){
				throw e.targetException
			}
			throw e
		}
	}
	
		// invoke method in workspace project
	def String methodExists(JavaMethod vm, EList<JvmFormalParameter> parameters){
		val i = vm.methodPath.lastIndexOf('.')
		if ( i == -1)
		return null;
		val className = vm.methodPath.substring(0, i)
		val methodName = vm.methodPath.substring(i + 1)
		try {
			val workspaceRoot = ResourcesPlugin.workspace.root
			val model = JavaCore.create(workspaceRoot)

			val projects = model.javaProjects.filter[findType(className) != null].toSet
			if (projects.isEmpty) {
				return 'No such method: ' + vm.methodPath
			} else if (projects.size > 1) {
				return'Multiple methods found for ' + vm.methodPath
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
			for (o : parameters)
			{
				val pt = o.parameterType
				val x = pt.type
				val cl = fastForName(x.simpleName)
				newClasses.add(cl)
				println ("has to load class " + x.class.name)
			}	
			
			val method = clazz.getMethod(methodName, newClasses)
			if (method == null) return "Method "+methodName+" not found in class instance"
		} catch (Exception e) {
			if (e instanceof InvocationTargetException){
				return e.targetException.toString
			}
			return e.toString
		}
		return null
	}

	private static final Map<String, Class> BUILT_IN_MAP = 
    	new ConcurrentHashMap<String, Class>();


	def Class forName(String name) throws ClassNotFoundException {
		switch (name){
			case typeof(void).name: return typeof(void)
			case typeof(boolean).name: return typeof(boolean)
			case typeof(byte).name: return typeof(byte)
			case typeof(char).name: return typeof(char)
			case typeof(short).name: return typeof(short)
			case typeof(int).name: return typeof(int)
			case typeof(float).name: return typeof(float)
			case typeof(long).name: return typeof(long)
			case typeof(double).name: return typeof(double)
			default: return Class.forName(name)
		}
	}	
	
	def Class fastForName(String name) throws ClassNotFoundException {
		var Class c = BUILT_IN_MAP.get(name);
		if (c == null)
			// assumes you have only one class loader!
			BUILT_IN_MAP.put(name, c = forName(name));
		return c;
		
	}

}
