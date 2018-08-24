package org.osate.pluginsupport;

import java.lang.reflect.Method;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaModel;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

import com.google.common.collect.Iterables;

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
	public Object invokeJavaMethod(String javaMethod, ArrayList<Class<?>> paramClasses,
			ArrayList<Object> paramActuals) {
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
			return null;
		}
	}

	// returns the Java method or null.
	public Method getJavaMethod(String javaMethod, ArrayList<Class<?>> paramClasses) {
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

		return getJavaClassFromProjects(className);
	}

	// get Java Class from from searching projects in workspace
	private Class<?> getJavaClassFromProjects(String className) throws Exception {
		final IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
		final IJavaModel model = JavaCore.create(workspaceRoot);
		// filter condition: findType(className) !== null]
		final Function1<IJavaProject, Boolean> filterProjects = (IJavaProject it) -> {
			try {
				IType _findType = it.findType(className);
				return Boolean.valueOf((_findType != null));
			} catch (Throwable _e) {
				throw Exceptions.sneakyThrow(_e);
			}
		};
		// projects = model.javaProjects.filter[findType(className) !== null].toSet
		@SuppressWarnings("unchecked")
		final Set<IJavaProject> projects = IterableExtensions
				.<IJavaProject> toSet(IterableExtensions.<IJavaProject> filter(
						((Iterable<IJavaProject>) Conversions.doWrapArray(model.getJavaProjects())), filterProjects));
		if (projects.isEmpty()) {
			throw new IllegalArgumentException("No such class: " + className);
		} else if (projects.size() > 1) {
			throw new IllegalArgumentException("Multiple methods found for " + className);
		}
		boolean changed = true;
		while (changed) {
			final Function1<IJavaProject, Iterable<IJavaProject>> collectReferencedProjects = (IJavaProject p) -> {
				try {
					// filter condition: [entryKind == IClasspathEntry.CPE_PROJECT]
					final Function1<IClasspathEntry, Boolean> filterCPE = (IClasspathEntry it) -> {
						return Boolean.valueOf((it.getEntryKind() == IClasspathEntry.CPE_PROJECT));
					};
					// cpes = p.getResolvedClasspath(true).filter[entryKind == IClasspathEntry.CPE_PROJECT]
					@SuppressWarnings("unchecked")
					final Iterable<IClasspathEntry> cpes = IterableExtensions.<IClasspathEntry> filter(
							((Iterable<IClasspathEntry>) Conversions.doWrapArray(p.getResolvedClasspath(true))),
							filterCPE);
					// map[it.path]
					final Function1<IClasspathEntry, IPath> MapCPEToPath = (IClasspathEntry it) -> {
						return it.getPath();
					};
					// paths = cpes.map[it.path]
					final Iterable<IPath> paths = IterableExtensions.<IClasspathEntry, IPath> map(cpes, MapCPEToPath);
					final Function1<IPath, IJavaProject> MapToJavaProject = (IPath it) -> {
						return model.getJavaProject(it.toString());
					};
					// paths.map[model.getJavaProject(it.toString)]
					return IterableExtensions.<IPath, IJavaProject> map(paths, MapToJavaProject);
				} catch (Throwable _e) {
					throw Exceptions.sneakyThrow(_e);
				}
			};
			// val referenced = projects.map [ p |
			// val cpes = p.getResolvedClasspath(true).filter[entryKind == IClasspathEntry.CPE_PROJECT]
			// val paths = cpes.map[it.path]
			// paths.map[model.getJavaProject(it.toString)]
			// ].flatten
			// changed = projects += referenced
			final Iterable<IJavaProject> referenced = Iterables.<IJavaProject> concat(
					IterableExtensions.<IJavaProject, Iterable<IJavaProject>> map(projects, collectReferencedProjects));
			changed = Iterables.<IJavaProject> addAll(projects, referenced);
		}
		// map [ p | val file = workspaceRoot.getFile(p.outputLocation); new URL(file.locationURI + "/")]
		final Function1<IJavaProject, URL> mapProjectToURL = (IJavaProject p) -> {
			try {
				URL url = null;
				{
					final IFile file = workspaceRoot.getFile(p.getOutputLocation());
					URI _locationURI = file.getLocationURI();
					String _plus = (_locationURI + "/");
					url = new URL(_plus);
				}
				return url;
			} catch (Throwable _e) {
				throw Exceptions.sneakyThrow(_e);
			}
		};
		// urls = projects.map [ p | val file = workspaceRoot.getFile(p.outputLocation); new URL(file.locationURI + "/")]
		final Iterable<URL> urls = IterableExtensions.<IJavaProject, URL> map(projects, mapProjectToURL);

		final ClassLoader parent = this.getClass().getClassLoader();
		final URLClassLoader loader = new URLClassLoader(((URL[]) Conversions.unwrapArray(urls, URL.class)), parent);
		Class<?> clazz = Class.forName(className, true, loader);
		return clazz;
	}

}
