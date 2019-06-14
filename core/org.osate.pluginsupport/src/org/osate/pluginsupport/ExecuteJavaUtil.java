package org.osate.pluginsupport;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.Pair;

public class ExecuteJavaUtil {
	// generic reflective invocation of Java methods.
	// One set of methods assumes as single parameter - model target model element. The Java method is assumed to expect an EObject
	// The second set of methods gets both the method parameter classes and actual objects to be passed.

	private final static String EXTENSION_POINT_ID = "org.osate.pluginsupport.registeredjavaclasses";
	private final static String PATH_ATTRIBUTE_NAME = "path";

	private static Map<String, IConfigurationElement> configElementCache;

	// The method is assumed to have a single parameter of type EObject
	public static Object invokeJavaMethod(String qualifiedMethodName, EObject argument) {
		return invokeJavaMethod(qualifiedMethodName, new Class[] { EObject.class }, new Object[] { argument });
	}

	public static Object invokeJavaMethod(String qualifiedMethodName, Class<?>[] parameterTypes, Object[] arguments) {
		Pair<String, String> names = splitClassAndMethodName(qualifiedMethodName);
		String className = names.getKey();
		String methodName = names.getValue();
		if (methodName == null) {
			return null;
		}
		try {
			Object instance = getInstance(className);
			if (instance == null) {
				return null;
			} else {
				return instance.getClass().getMethod(methodName, parameterTypes).invoke(instance, arguments);
			}
		} catch (CoreException | NoSuchMethodException | SecurityException | IllegalAccessException
				| InvocationTargetException e) {
			return e;
		}
	}

	// returns the Java method or null.
	public static Method getJavaMethod(String qualifiedMethodName, Class<?>[] parameterTypes) {
		Pair<String, String> names = splitClassAndMethodName(qualifiedMethodName);
		String className = names.getKey();
		String methodName = names.getValue();
		if (methodName == null) {
			return null;
		}
		try {
			Object instance = getInstance(className);
			if (instance == null) {
				return null;
			} else {
				return instance.getClass().getMethod(methodName, parameterTypes);
			}
		} catch (CoreException | NoSuchMethodException | SecurityException e) {
			return null;
		}
	}

	// use in validation of when condition method
	public static Method getJavaMethod(String qualifiedMethodName) {
		return getJavaMethod(qualifiedMethodName, new Class[] { EObject.class });
	}

	// get Java Class from extension point registry
	public static Class<?> getJavaClass(String className) {
		try {
			Object instance = getInstance(className);
			if (instance == null) {
				return null;
			} else {
				return instance.getClass();
			}
		} catch (CoreException e) {
			return null;
		}
	}

	/*
	 * Key is the class name and value is the method name. If qualifiedMethodName does not contain a dot, then the key
	 * is the same as qualifiedMethodName and the value is null.
	 */
	private static Pair<String, String> splitClassAndMethodName(String qualifiedMethodName) {
		int i = qualifiedMethodName.lastIndexOf('.');
		if (i == -1) {
			return new Pair<>(qualifiedMethodName, null);
		} else {
			return new Pair<>(qualifiedMethodName.substring(0, i), qualifiedMethodName.substring(i + 1));
		}
	}

	/*
	 * Returns an instance of the class specified by className. Returns null if the className could not be found in the
	 * extension registry. Throws a CoreException if the className was found, but an instance could not be created.
	 */
	private static Object getInstance(String className) throws CoreException {
		if (configElementCache == null) {
			configElementCache = new HashMap<>();
			IExtensionRegistry registry = Platform.getExtensionRegistry();
			for (IConfigurationElement element : registry.getConfigurationElementsFor(EXTENSION_POINT_ID)) {
				String path = element.getAttribute(PATH_ATTRIBUTE_NAME);
				if (path != null) {
					configElementCache.put(path, element);
				}
			}
		}
		IConfigurationElement element = configElementCache.get(className);
		if (element == null) {
			return null;
		} else {
			return element.createExecutableExtension(PATH_ATTRIBUTE_NAME);
		}
	}
}