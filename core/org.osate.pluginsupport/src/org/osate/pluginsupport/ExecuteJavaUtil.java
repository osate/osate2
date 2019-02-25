package org.osate.pluginsupport;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.Conversions;

public class ExecuteJavaUtil {
	// generic reflective invocation of Java methods.
	// One set of methods assumes as single parameter - model target model element. The Java method is assumed to expect an EObject
	// The second set of methods gets both the method parameter classes and actual objects to be passed.

	public static ExecuteJavaUtil eInstance = new ExecuteJavaUtil();

	final private static String EXTENTION_ID = "org.osate.pluginsupport.registeredjavaclasses";
	private static Map<String, Object> analysisMap;

	public void init(IExtensionRegistry registry) {
		analysisMap = new HashMap<String, Object>();
		evaluate(registry);
	}

	private void evaluate(IExtensionRegistry registry) {
		try {
			for (IConfigurationElement e : registry.getConfigurationElementsFor(EXTENTION_ID)) {
				String name = e.getAttribute("path");
				Object o = e.createExecutableExtension("path");
				analysisMap.put(name, o);
			}
		} catch (CoreException e) {
			throw new IllegalStateException(e);
		}
	}

	// invoke method in workspace project
	// The method is assumed to have a single parameter of type EObject
	public Object invokeJavaMethod(String javaMethod, EObject target) {
		ArrayList<Class<?>> newClasses = new ArrayList<Class<?>>();
		newClasses.add(EObject.class);
		ArrayList<Object> objects = new ArrayList<Object>();
		objects.add(target);
		return invokeJavaMethod(javaMethod, newClasses, objects);
	}

	// invoke method in workspace project
	public Object invokeJavaMethod(String javaMethod, List<Class<?>> paramClasses, List<Object> paramActuals) {
		int i = javaMethod.lastIndexOf('.');
		if (i == -1) {
			return null;
		}
		String className = javaMethod.substring(0, i);
		String methodName = javaMethod.substring(i + 1);
		try {
			Class<?> clazz = getJavaClass(className);
			Object instance = clazz.newInstance();
			final Method method = clazz.getMethod(methodName,
					((Class<?>[]) Conversions.unwrapArray(paramClasses, Class.class)));
			return method.invoke(instance, paramActuals.toArray());
		} catch (Exception e) {
			return e;
		}
	}

	// returns the Java method or null.
	public Method getJavaMethod(String javaMethod, Collection<Class<?>> paramClasses) {
		int i = javaMethod.lastIndexOf('.');
		if (i == -1) {
			return null;
		}
		String className = javaMethod.substring(0, i);
		String methodName = javaMethod.substring(i + 1);

		try {
			Class<?> clazz = getJavaClass(className);
			if (clazz == null) {
				return null;
			}
			Method method = clazz.getMethod(methodName,
					((Class<?>[]) Conversions.unwrapArray(paramClasses, Class.class)));
			return method;
		} catch (Exception e) {
			return null;
		}
	}

	// use in validation of when condition method
	public Method getJavaMethod(String javaMethod) {
		ArrayList<Class<?>> newClasses = new ArrayList<Class<?>>();
		newClasses.add(EObject.class);
		return getJavaMethod(javaMethod, newClasses);
	}

	// get Java Class from extension point registry or from searching workspace
	public Class<?> getJavaClass(String className) throws Exception {
		if (analysisMap == null) {
			IExtensionRegistry extensionRegistry = Platform.getExtensionRegistry();
			init(extensionRegistry);
		}
		Object obj = analysisMap.get(className);
		if (obj != null) {
			return obj.getClass();
		}

		return null;
	}


}
