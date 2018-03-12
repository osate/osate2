package org.osate.verify.util

import java.lang.reflect.InvocationTargetException
import java.net.URL
import java.net.URLClassLoader
import java.util.ArrayList
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.emf.ecore.EObject
import org.eclipse.jdt.core.IClasspathEntry
import org.eclipse.jdt.core.JavaCore
import org.osate.aadl2.NamedElement
import java.lang.reflect.Method

class ExecuteJavaUtil {


	public static ExecuteJavaUtil eInstance = new ExecuteJavaUtil();

		// invoke method in workspace project
		// The method is assumed to have a single parameter of type EObject
	def Object invokeJavaMethod(String javaMethod, EObject target ) {
		val newClasses = newArrayList()
		newClasses.add(EObject)
		val objects = new ArrayList()
		objects.add(target)
		invokeJavaMethod(javaMethod,newClasses,objects)
	}

		// invoke method in workspace project
	def Object invokeJavaMethod(String javaMethod, ArrayList<Class<?>> paramClasses,ArrayList<Object> paramActuals ) {
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
			newClasses.add(NamedElement)
			val method = clazz.getMethod(methodName, paramClasses)
			method.invoke(instance, paramActuals.toArray)
		} catch (Exception e) {
			if (e instanceof InvocationTargetException) {
				throw e.targetException
			}
			throw e
		}
	}
	
		
	def Method getJavaMethod(String javaMethod, ArrayList<Class<?>> paramClasses) {
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
			var method = clazz.getMethod(methodName, paramClasses)
			return method
		} catch (Exception e) {
			return null
		}
	}
	
	def getJavaMethod(String javaMethod){
		val newClasses = newArrayList()
		newClasses.add(NamedElement)
		getJavaMethod(javaMethod,newClasses)
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
