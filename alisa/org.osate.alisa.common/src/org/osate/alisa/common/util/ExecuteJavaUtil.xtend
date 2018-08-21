package org.osate.alisa.common.util

import java.lang.reflect.InvocationTargetException
import java.lang.reflect.Method
import java.net.URL
import java.net.URLClassLoader
import java.util.ArrayList
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.emf.ecore.EObject
import org.eclipse.jdt.core.IClasspathEntry
import org.eclipse.jdt.core.JavaCore
import org.osate.aadl2.NamedElement
import org.eclipse.core.runtime.IExtensionRegistry
import java.util.Map
import org.eclipse.core.runtime.IConfigurationElement
import java.util.HashMap
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.runtime.Platform
import java.lang.reflect.Method

class ExecuteJavaUtil {
	// generic reflective invocation of Java methods.
	// One set of methods assumes as single parameter - model target model element. The Java method is assumed to expect an EObject
	// The second set of methods gets both the method parameter classes and actual objects to be passed.

	public static ExecuteJavaUtil eInstance = new ExecuteJavaUtil();
	
	final private static String EXTENTION_ID = "org.osate.alisa.common.javaextensionpoint";
	private static Map<String, JavaExtensionPoint> analysisMap;

    def void init(IExtensionRegistry registry) {
        analysisMap = new HashMap;
        evaluate(registry);
    }

    def void evaluate(IExtensionRegistry registry) {
        try {
            for (IConfigurationElement e : registry.getConfigurationElementsFor(EXTENTION_ID)) {
				val name = e.getAttribute("class");
				val o = e.createExecutableExtension("class");
				val analysis = o as JavaExtensionPoint;
                analysisMap.put(name, analysis);
            }
        } catch (CoreException e) {
            throw new IllegalStateException(e);
        }
    }

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
		if (i == -1) {
			return null
		}
		val className = javaMethod.substring(0, i)
		val methodName = javaMethod.substring(i + 1)
		try {
			val clazz = getJavaClass(className);
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
	
	
	// returns the Java method or null. 	
	def Method getJavaMethod(String javaMethod, ArrayList<Class<?>> paramClasses) {
		val i = javaMethod.lastIndexOf('.')
		if (i == -1) {
			return null
		}
		val className = javaMethod.substring(0, i)
		val methodName = javaMethod.substring(i + 1)
	
		try {
			val clazz = getJavaClass(className);
			if (clazz === null) return null;
			val method = clazz.getMethod(methodName, paramClasses)
			return method
		} catch (Exception e) {
			return null
		}
	}
	
	// use in validation of when condition method
	def Method getJavaMethod(String javaMethod){
		val newClasses = newArrayList()
		newClasses.add(EObject)
		getJavaMethod(javaMethod,newClasses)
	}
	
	
	// get Java Class from extension point registry or from searching workspace
	def Class<?> getJavaClass(String className) {
		if (analysisMap === null) {
			val extensionRegistry = Platform.getExtensionRegistry();
			init(extensionRegistry);
		}
		val obj = analysisMap.get(className);
		if (obj !== null){
			return obj.getClass();
		}
		
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
