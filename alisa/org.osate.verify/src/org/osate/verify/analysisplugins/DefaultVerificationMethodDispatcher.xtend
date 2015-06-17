package org.osate.verify.analysisplugins

import java.net.URL
import java.net.URLClassLoader
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.jdt.core.IClasspathEntry
import org.eclipse.jdt.core.JavaCore
import org.osate.aadl2.instance.ComponentInstance
import org.osate.aadl2.instance.InstanceObject
import org.osate.verify.util.IVerificationMethodDispatcher
import org.osate.verify.verify.VerificationMethod

import static extension org.osate.verify.analysisplugins.AnalysisPluginInterface.*
import java.util.ArrayList

class DefaultVerificationMethodDispatcher implements IVerificationMethodDispatcher {

	override Object dispatchVerificationMethod(VerificationMethod vm, InstanceObject target, Object[] parameters) {
		switch (vm.methodPath) {
			//				case "org.osate.verify.analysisplugins.AnalysisPluginInterface.assertSumSubBudgets" : {
			//					if ( target instanceof ComponentInstance) return target.assertSumSubBudgets
			//				}
			//				case "org.osate.verify.analysisplugins.AnalysisPluginInterface.sumSubBudgets": {
			//					if ( target instanceof ComponentInstance) return target.sumSubBudgets
			//				}
			case "org.osate.verify.analysisplugins.AnalysisPluginInterface.flowLatencyAnalysis": {
				target.flowLatencyAnalysis
			}
			case "org.osate.verify.analysisplugins.AnalysisPluginInterface.A429Consistency": {
				target.A429Consistency
			}
			case "org.osate.verify.analysisplugins.AnalysisPluginInterface.ConnectionBindingConsistency": {
				target.ConnectionBindingConsistency
			}
			case "org.osate.verify.analysisplugins.AnalysisPluginInterface.PortDataConsistency": {
				target.PortDataConsistency
			}
			case "org.osate.verify.analysisplugins.AnalysisPluginInterface.MassAnalysis": {
				target.MassAnalysis
			}
			case "org.osate.verify.analysisplugins.AnalysisPluginInterface.BoundResourceAnalysis": {
				target.BoundResourceAnalysis
			}
			case "org.osate.verify.analysisplugins.AnalysisPluginInterface.PowerAnalysis": {
				target.PowerAnalysis
			}
			case "org.osate.verify.analysisplugins.AnalysisPluginInterface.ResourceBudget": {
				target.ResourceBudget
			}
			
			case "org.osate.verify.analysisplugins.AnalysisPluginInterface.Binpack": {
				target.Binpack
			}
			case "org.osate.verify.analysisplugins.AnalysisPluginInterface.CheckSafety": {
				target.CheckSafety
			}
			case "org.osate.verify.analysisplugins.AnalysisPluginInterface.CheckSecurity": {
				target.CheckSecurity
			}
			//priority inversion
			default: workspaceInvoke(vm, target, parameters)
			
		}
		
	}

	// invoke method in workspace project
	def Object workspaceInvoke(VerificationMethod vm, InstanceObject target, Object[] parameters) {
		val i = vm.methodPath.lastIndexOf('.')
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
			e.printStackTrace
			throw e
		}
	}

}
