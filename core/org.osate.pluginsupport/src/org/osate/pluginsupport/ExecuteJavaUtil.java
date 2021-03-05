/**
 * Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file).
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

/**
 * @since 6.0
 */
public final class ExecuteJavaUtil {
	private ExecuteJavaUtil() {
		// no instances please
	}

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