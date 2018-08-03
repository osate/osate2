package org.osate.alisa.common.typing;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaModel;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.NumberValue;
import org.osate.aadl2.RealLiteral;
import org.osate.aadl2.UnitLiteral;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.alisa.common.common.AModelReference;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;

public class InterpreterUtil {

	public static UnitLiteral smallerUnit(UnitLiteral unit1, UnitLiteral unit2) {
		if (unit1 == null || unit2 == null) {
			return null;
		} else if (unit1 == unit2) {
			return unit1;
		} else {
			RealLiteral tester = Aadl2Factory.eINSTANCE.createRealLiteral();
			tester.setValue(1.0);
			tester.setUnit(unit1);
			if (tester.getScaledValue(unit2) < 1.0) {
				return unit1;
			} else {
				return unit2;
			}
		}
	}

	public static int compareTo(NumberValue v1, NumberValue v2) {
		UnitLiteral minUnit = smallerUnit(v1.getUnit(), v2.getUnit());
		if (v1 instanceof IntegerLiteral && v2 instanceof IntegerLiteral) {
			Long s1 = (v1.getUnit() == null) ? ((IntegerLiteral) v1).getValue()
					: Math.round(v1.getScaledValue(minUnit));
			Long s2 = (v2.getUnit() == null) ? ((IntegerLiteral) v2).getValue()
					: Math.round(v2.getScaledValue(minUnit));
			return s1.compareTo(s2);
		} else {
			Double s1 = (v1.getUnit() == null)
					? (v1 instanceof IntegerLiteral) ? ((IntegerLiteral) v1).getValue() : ((RealLiteral) v1).getValue()
					: v1.getScaledValue(minUnit);
			Double s2 = (v2.getUnit() == null)
					? (v2 instanceof IntegerLiteral) ? ((IntegerLiteral) v2).getValue() : ((RealLiteral) v2).getValue()
					: v2.getScaledValue(minUnit);
			return s1.compareTo(s2);
		}
	}

	public static NumberValue add(NumberValue v1, NumberValue v2) {
		UnitLiteral minUnit = smallerUnit(v1.getUnit(), v2.getUnit());
		if (v1 instanceof IntegerLiteral && v2 instanceof IntegerLiteral) {
			long s1 = (v1.getUnit() == null) ? ((IntegerLiteral) v1).getValue()
					: Math.round(v1.getScaledValue(minUnit));
			long s2 = (v2.getUnit() == null) ? ((IntegerLiteral) v2).getValue()
					: Math.round(v2.getScaledValue(minUnit));
			IntegerLiteral result = Aadl2Factory.eINSTANCE.createIntegerLiteral();
			result.setValue(s1 + s2);
			result.setUnit(minUnit);
			return result;
		} else {
			double s1 = (v1.getUnit() == null)
					? (v1 instanceof IntegerLiteral) ? ((IntegerLiteral) v1).getValue() : ((RealLiteral) v1).getValue()
					: v1.getScaledValue(minUnit);
			double s2 = (v2.getUnit() == null)
					? (v2 instanceof IntegerLiteral) ? ((IntegerLiteral) v2).getValue() : ((RealLiteral) v2).getValue()
					: v2.getScaledValue(minUnit);
			RealLiteral result = Aadl2Factory.eINSTANCE.createRealLiteral();
			result.setValue(s1 + s2);
			result.setUnit(minUnit);
			return result;
		}
	}

	public static NumberValue subtract(NumberValue v1, NumberValue v2) {
		if (v2 instanceof IntegerLiteral) {
			IntegerLiteral neg = Aadl2Factory.eINSTANCE.createIntegerLiteral();
			neg.setValue(-((IntegerLiteral) v2).getValue());
			neg.setUnit(v2.getUnit());
			return add(v1, neg);
		} else {
			RealLiteral neg = Aadl2Factory.eINSTANCE.createRealLiteral();
			neg.setValue(-((RealLiteral) v2).getValue());
			neg.setUnit(v2.getUnit());
			return add(v1, neg);
		}
	}

	public static NumberValue multiply(NumberValue v1, NumberValue v2) {
		UnitLiteral unit = (v1.getUnit() != null) ? v1.getUnit() : v2.getUnit();
		if (v1 instanceof IntegerLiteral && v2 instanceof IntegerLiteral) {
			long s1 = ((IntegerLiteral) v1).getValue();
			long s2 = ((IntegerLiteral) v1).getValue();
			IntegerLiteral result = Aadl2Factory.eINSTANCE.createIntegerLiteral();
			result.setValue(s1 * s2);
			result.setUnit(unit);
			return result;
		} else {
			double s1 = (v1 instanceof IntegerLiteral) ? ((IntegerLiteral) v1).getValue()
					: ((RealLiteral) v1).getValue();
			double s2 = (v2 instanceof IntegerLiteral) ? ((IntegerLiteral) v2).getValue()
					: ((RealLiteral) v2).getValue();
			RealLiteral result = Aadl2Factory.eINSTANCE.createRealLiteral();
			result.setValue(s1 * s2);
			result.setUnit(unit);
			return result;
		}
	}

	public static NumberValue divide(NumberValue v1, NumberValue v2) {
		UnitLiteral minUnit = smallerUnit(v1.getUnit(), v2.getUnit());
		boolean twoUnits = v1.getUnit() != null && v2.getUnit() != null;
		UnitLiteral unit = (v1.getUnit() != null) ? v1.getUnit() : v2.getUnit();

		double s1 = (!twoUnits)
				? (v1 instanceof IntegerLiteral) ? ((IntegerLiteral) v1).getValue() : ((RealLiteral) v1).getValue()
				: v1.getScaledValue(minUnit);
		double s2 = (!twoUnits)
				? (v2 instanceof IntegerLiteral) ? ((IntegerLiteral) v2).getValue() : ((RealLiteral) v2).getValue()
				: v2.getScaledValue(minUnit);
		RealLiteral result = Aadl2Factory.eINSTANCE.createRealLiteral();
		result.setValue(s1 / s2);
		result.setUnit(twoUnits ? minUnit : unit);
		return result;
	}

	public static NumberValue divideInt(IntegerLiteral v1, IntegerLiteral v2) {
		UnitLiteral minUnit = smallerUnit(v1.getUnit(), v2.getUnit());
		boolean twoUnits = v1.getUnit() != null && v2.getUnit() != null;
		UnitLiteral unit = (v1.getUnit() != null) ? v1.getUnit() : v2.getUnit();

		long s1 = (!twoUnits) ? v1.getValue() : Math.round(v1.getScaledValue(minUnit));
		long s2 = (!twoUnits) ? v2.getValue() : Math.round(v2.getScaledValue(minUnit));
		IntegerLiteral result = Aadl2Factory.eINSTANCE.createIntegerLiteral();
		result.setValue(s1 / s2);
		result.setUnit(twoUnits ? minUnit : unit);
		return result;
	}

	public static NumberValue mod(IntegerLiteral v1, IntegerLiteral v2) {
		UnitLiteral minUnit = smallerUnit(v1.getUnit(), v2.getUnit());
		boolean twoUnits = v1.getUnit() != null && v2.getUnit() != null;
		UnitLiteral unit = (v1.getUnit() != null) ? v1.getUnit() : v2.getUnit();

		long s1 = (!twoUnits) ? v1.getValue() : Math.round(v1.getScaledValue(minUnit));
		long s2 = (!twoUnits) ? v2.getValue() : Math.round(v2.getScaledValue(minUnit));
		IntegerLiteral result = Aadl2Factory.eINSTANCE.createIntegerLiteral();
		result.setValue(s1 % s2);
		result.setUnit(twoUnits ? minUnit : unit);
		return result;
	}

	/**
	 * Resolve a model element reference relative to an instance object
	 */
	static InstanceObject resolve(AModelReference ref, InstanceObject root) {
		if (ref.getPrev() == null)
			return root;
		else {
			InstanceObject io = resolve(ref.getPrev(), root);
			EObject result = io.eContents().stream()
					.filter(it -> (it instanceof InstanceObject)
							? ((InstanceObject) it).getName().equalsIgnoreCase(ref.getModelElement().getName()) : false)
					.findFirst().get();
			return (InstanceObject) result;
		}
	}

	public static InterpreterUtil instance = new InterpreterUtil();

	// Method returns null if Java class was found.
	// Otherwise it returns an error message
	public String methodExists(final String javaMethod) {
		final int i = javaMethod.lastIndexOf(".");
		if ((i == (-1))) {
			throw new IllegalArgumentException((("Java method \'" + javaMethod) + "\' is missing Class"));
		}
		final String className = javaMethod.substring(0, i);
		final String methodName = javaMethod.substring((i + 1));
		try {
			IWorkspace _workspace = ResourcesPlugin.getWorkspace();
			final IWorkspaceRoot workspaceRoot = _workspace.getRoot();
			final IJavaModel model = JavaCore.create(workspaceRoot);
			IJavaProject[] _javaProjects = model.getJavaProjects();
			final Function1<IJavaProject, Boolean> _function = (IJavaProject it) -> {
				try {
					IType _findType = it.findType(className);
					return Boolean.valueOf((!Objects.equal(_findType, null)));
				} catch (Throwable _e) {
					throw Exceptions.sneakyThrow(_e);
				}
			};
			Iterable<IJavaProject> _filter = IterableExtensions.<IJavaProject> filter(
					((Iterable<IJavaProject>) Conversions.doWrapArray(_javaProjects)), _function);
			final Set<IJavaProject> projects = IterableExtensions.<IJavaProject> toSet(_filter);
			boolean _isEmpty = projects.isEmpty();
			if (_isEmpty) {
				throw new IllegalArgumentException(("No such method: " + javaMethod));
			} else {
				int _size = projects.size();
				boolean _greaterThan = (_size > 1);
				if (_greaterThan) {
					throw new IllegalArgumentException(("Multiple methods found for " + javaMethod));
				}
			}
			boolean changed = true;
			while (changed) {
				{
					final Function1<IJavaProject, Iterable<IJavaProject>> _function_1 = (IJavaProject p) -> {
						try {
							Iterable<IJavaProject> _xblockexpression = null;
							{
								IClasspathEntry[] _resolvedClasspath = p.getResolvedClasspath(true);
								final Function1<IClasspathEntry, Boolean> _function_2 = (IClasspathEntry it) -> {
									int _entryKind = it.getEntryKind();
									return Boolean.valueOf((_entryKind == IClasspathEntry.CPE_PROJECT));
								};
								final Iterable<IClasspathEntry> cpes = IterableExtensions.<IClasspathEntry> filter(
										((Iterable<IClasspathEntry>) Conversions.doWrapArray(_resolvedClasspath)),
										_function_2);
								final Function1<IClasspathEntry, IPath> _function_3 = (IClasspathEntry it) -> {
									return it.getPath();
								};
								final Iterable<IPath> paths = IterableExtensions.<IClasspathEntry, IPath> map(cpes,
										_function_3);
								final Function1<IPath, IJavaProject> _function_4 = (IPath it) -> {
									String _string = it.toString();
									return model.getJavaProject(_string);
								};
								_xblockexpression = IterableExtensions.<IPath, IJavaProject> map(paths, _function_4);
							}
							return _xblockexpression;
						} catch (Throwable _e) {
							throw Exceptions.sneakyThrow(_e);
						}
					};
					Iterable<Iterable<IJavaProject>> _map = IterableExtensions
							.<IJavaProject, Iterable<IJavaProject>> map(projects, _function_1);
					final Iterable<IJavaProject> referenced = Iterables.<IJavaProject> concat(_map);
					boolean _add = Iterables.<IJavaProject> addAll(projects, referenced);
					changed = _add;
				}
			}
			final Function1<IJavaProject, URL> _function_1 = (IJavaProject p) -> {
				try {
					URL _xblockexpression = null;
					{
						IPath _outputLocation = p.getOutputLocation();
						final IFile file = workspaceRoot.getFile(_outputLocation);
						java.net.URI _locationURI = file.getLocationURI();
						String _plus = (_locationURI + "/");
						_xblockexpression = new URL(_plus);
					}
					return _xblockexpression;
				} catch (Throwable _e) {
					throw Exceptions.sneakyThrow(_e);
				}
			};
			final Iterable<URL> urls = IterableExtensions.<IJavaProject, URL> map(projects, _function_1);
			Class<? extends InterpreterUtil> _class = this.getClass();
			final ClassLoader parent = _class.getClassLoader();
			final URLClassLoader loader = new URLClassLoader(((URL[]) Conversions.unwrapArray(urls, URL.class)),
					parent);
			final Class<?> clazz = Class.forName(className, true, loader);
			final ArrayList<Class<?>> newClasses = CollectionLiterals.<Class<?>> newArrayList();
			newClasses.add(NamedElement.class);
			Method method = clazz.getMethod(methodName,
					((Class<?>[]) Conversions.unwrapArray(newClasses, Class.class)));
			boolean _equals = Objects.equal(method, null);
			if (_equals) {
				final ArrayList<Class<InstanceObject>> altClasses = CollectionLiterals
						.<Class<InstanceObject>> newArrayList();
				altClasses.add(InstanceObject.class);
				Method _method = clazz.getMethod(methodName,
						((Class<?>[]) Conversions.unwrapArray(newClasses, Class.class)));
				method = _method;
			}
		} catch (final Throwable _t) {
			if (_t instanceof Exception) {
				final Exception e = (Exception) _t;
				if ((e instanceof InvocationTargetException)) {
					Throwable _targetException = ((InvocationTargetException) e).getTargetException();
					return _targetException.toString();
				}
				return e.toString();
			} else {
				throw Exceptions.sneakyThrow(_t);
			}
		}
		return null;
	}

}