package org.osate.aadl2.errormodel.PropagationGraph.util;

import com.google.common.collect.Iterables;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Set;
import org.eclipse.core.resources.IFile;
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
import org.osate.aadl2.NamedElement;

@SuppressWarnings("all")
public class ExecuteJavaUtil {
  public static ExecuteJavaUtil eInstance = new ExecuteJavaUtil();
  
  public Object invokeJavaMethod(final String javaMethod, final EObject target) {
    Object _xblockexpression = null;
    {
      final ArrayList<Class<?>> newClasses = CollectionLiterals.<Class<?>>newArrayList();
      newClasses.add(EObject.class);
      final ArrayList<Object> objects = new ArrayList<Object>();
      objects.add(target);
      _xblockexpression = this.invokeJavaMethod(javaMethod, newClasses, objects);
    }
    return _xblockexpression;
  }
  
  public Object invokeJavaMethod(final String javaMethod, final ArrayList<Class<?>> paramClasses, final ArrayList<Object> paramActuals) {
    try {
      Object _xblockexpression = null;
      {
        final int i = javaMethod.lastIndexOf(".");
        if ((i == (-1))) {
          return null;
        }
        final String className = javaMethod.substring(0, i);
        final String methodName = javaMethod.substring((i + 1));
        Object _xtrycatchfinallyexpression = null;
        try {
          Object _xblockexpression_1 = null;
          {
            final IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
            final IJavaModel model = JavaCore.create(workspaceRoot);
            final Function1<IJavaProject, Boolean> _function = (IJavaProject it) -> {
              try {
                IType _findType = it.findType(className);
                return Boolean.valueOf((_findType != null));
              } catch (Throwable _e) {
                throw Exceptions.sneakyThrow(_e);
              }
            };
            final Set<IJavaProject> projects = IterableExtensions.<IJavaProject>toSet(IterableExtensions.<IJavaProject>filter(((Iterable<IJavaProject>)Conversions.doWrapArray(model.getJavaProjects())), _function));
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
                    Iterable<IJavaProject> _xblockexpression_2 = null;
                    {
                      final Function1<IClasspathEntry, Boolean> _function_2 = (IClasspathEntry it) -> {
                        int _entryKind = it.getEntryKind();
                        return Boolean.valueOf((_entryKind == IClasspathEntry.CPE_PROJECT));
                      };
                      final Iterable<IClasspathEntry> cpes = IterableExtensions.<IClasspathEntry>filter(((Iterable<IClasspathEntry>)Conversions.doWrapArray(p.getResolvedClasspath(true))), _function_2);
                      final Function1<IClasspathEntry, IPath> _function_3 = (IClasspathEntry it) -> {
                        return it.getPath();
                      };
                      final Iterable<IPath> paths = IterableExtensions.<IClasspathEntry, IPath>map(cpes, _function_3);
                      final Function1<IPath, IJavaProject> _function_4 = (IPath it) -> {
                        return model.getJavaProject(it.toString());
                      };
                      _xblockexpression_2 = IterableExtensions.<IPath, IJavaProject>map(paths, _function_4);
                    }
                    return _xblockexpression_2;
                  } catch (Throwable _e) {
                    throw Exceptions.sneakyThrow(_e);
                  }
                };
                final Iterable<IJavaProject> referenced = Iterables.<IJavaProject>concat(IterableExtensions.<IJavaProject, Iterable<IJavaProject>>map(projects, _function_1));
                boolean _add = Iterables.<IJavaProject>addAll(projects, referenced);
                changed = _add;
              }
            }
            final Function1<IJavaProject, URL> _function_1 = (IJavaProject p) -> {
              try {
                URL _xblockexpression_2 = null;
                {
                  final IFile file = workspaceRoot.getFile(p.getOutputLocation());
                  URI _locationURI = file.getLocationURI();
                  String _plus = (_locationURI + "/");
                  _xblockexpression_2 = new URL(_plus);
                }
                return _xblockexpression_2;
              } catch (Throwable _e) {
                throw Exceptions.sneakyThrow(_e);
              }
            };
            final Iterable<URL> urls = IterableExtensions.<IJavaProject, URL>map(projects, _function_1);
            final ClassLoader parent = this.getClass().getClassLoader();
            final URLClassLoader loader = new URLClassLoader(((URL[])Conversions.unwrapArray(urls, URL.class)), parent);
            final Class<?> clazz = Class.forName(className, true, loader);
            final Object instance = clazz.newInstance();
            final ArrayList<Class<NamedElement>> newClasses = CollectionLiterals.<Class<NamedElement>>newArrayList();
            newClasses.add(NamedElement.class);
            final Method method = clazz.getMethod(methodName, ((Class<?>[])Conversions.unwrapArray(paramClasses, Class.class)));
            _xblockexpression_1 = method.invoke(instance, paramActuals.toArray());
          }
          _xtrycatchfinallyexpression = _xblockexpression_1;
        } catch (final Throwable _t) {
          if (_t instanceof Exception) {
            final Exception e = (Exception)_t;
            if ((e instanceof InvocationTargetException)) {
              throw ((InvocationTargetException)e).getTargetException();
            }
            throw e;
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
        _xblockexpression = _xtrycatchfinallyexpression;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public Method getJavaMethod(final String javaMethod, final ArrayList<Class<?>> paramClasses) {
    final int i = javaMethod.lastIndexOf(".");
    if ((i == (-1))) {
      return null;
    }
    final String className = javaMethod.substring(0, i);
    final String methodName = javaMethod.substring((i + 1));
    try {
      final IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
      final IJavaModel model = JavaCore.create(workspaceRoot);
      final Function1<IJavaProject, Boolean> _function = (IJavaProject it) -> {
        try {
          IType _findType = it.findType(className);
          return Boolean.valueOf((_findType != null));
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      };
      final Set<IJavaProject> projects = IterableExtensions.<IJavaProject>toSet(IterableExtensions.<IJavaProject>filter(((Iterable<IJavaProject>)Conversions.doWrapArray(model.getJavaProjects())), _function));
      boolean _isEmpty = projects.isEmpty();
      if (_isEmpty) {
        return null;
      } else {
        int _size = projects.size();
        boolean _greaterThan = (_size > 1);
        if (_greaterThan) {
          return null;
        }
      }
      boolean changed = true;
      while (changed) {
        {
          final Function1<IJavaProject, Iterable<IJavaProject>> _function_1 = (IJavaProject p) -> {
            try {
              Iterable<IJavaProject> _xblockexpression = null;
              {
                final Function1<IClasspathEntry, Boolean> _function_2 = (IClasspathEntry it) -> {
                  int _entryKind = it.getEntryKind();
                  return Boolean.valueOf((_entryKind == IClasspathEntry.CPE_PROJECT));
                };
                final Iterable<IClasspathEntry> cpes = IterableExtensions.<IClasspathEntry>filter(((Iterable<IClasspathEntry>)Conversions.doWrapArray(p.getResolvedClasspath(true))), _function_2);
                final Function1<IClasspathEntry, IPath> _function_3 = (IClasspathEntry it) -> {
                  return it.getPath();
                };
                final Iterable<IPath> paths = IterableExtensions.<IClasspathEntry, IPath>map(cpes, _function_3);
                final Function1<IPath, IJavaProject> _function_4 = (IPath it) -> {
                  return model.getJavaProject(it.toString());
                };
                _xblockexpression = IterableExtensions.<IPath, IJavaProject>map(paths, _function_4);
              }
              return _xblockexpression;
            } catch (Throwable _e) {
              throw Exceptions.sneakyThrow(_e);
            }
          };
          final Iterable<IJavaProject> referenced = Iterables.<IJavaProject>concat(IterableExtensions.<IJavaProject, Iterable<IJavaProject>>map(projects, _function_1));
          boolean _add = Iterables.<IJavaProject>addAll(projects, referenced);
          changed = _add;
        }
      }
      final Function1<IJavaProject, URL> _function_1 = (IJavaProject p) -> {
        try {
          URL _xblockexpression = null;
          {
            final IFile file = workspaceRoot.getFile(p.getOutputLocation());
            URI _locationURI = file.getLocationURI();
            String _plus = (_locationURI + "/");
            _xblockexpression = new URL(_plus);
          }
          return _xblockexpression;
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      };
      final Iterable<URL> urls = IterableExtensions.<IJavaProject, URL>map(projects, _function_1);
      final ClassLoader parent = this.getClass().getClassLoader();
      final URLClassLoader loader = new URLClassLoader(((URL[])Conversions.unwrapArray(urls, URL.class)), parent);
      final Class<?> clazz = Class.forName(className, true, loader);
      Method method = clazz.getMethod(methodName, ((Class<?>[])Conversions.unwrapArray(paramClasses, Class.class)));
      return method;
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception e = (Exception)_t;
        return null;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  public Method getJavaMethod(final String javaMethod) {
    Method _xblockexpression = null;
    {
      final ArrayList<Class<?>> newClasses = CollectionLiterals.<Class<?>>newArrayList();
      newClasses.add(EObject.class);
      _xblockexpression = this.getJavaMethod(javaMethod, newClasses);
    }
    return _xblockexpression;
  }
  
  public Class<?> findClass(final String className) {
    try {
      final IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
      final IJavaModel model = JavaCore.create(workspaceRoot);
      final Function1<IJavaProject, Boolean> _function = (IJavaProject it) -> {
        try {
          IType _findType = it.findType(className);
          return Boolean.valueOf((_findType != null));
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      };
      final Set<IJavaProject> projects = IterableExtensions.<IJavaProject>toSet(IterableExtensions.<IJavaProject>filter(((Iterable<IJavaProject>)Conversions.doWrapArray(model.getJavaProjects())), _function));
      boolean _isEmpty = projects.isEmpty();
      if (_isEmpty) {
        throw new IllegalArgumentException(("No such class: " + className));
      } else {
        int _size = projects.size();
        boolean _greaterThan = (_size > 1);
        if (_greaterThan) {
          throw new IllegalArgumentException(("Multiple methods found for " + className));
        }
      }
      boolean changed = true;
      while (changed) {
        {
          final Function1<IJavaProject, Iterable<IJavaProject>> _function_1 = (IJavaProject p) -> {
            try {
              Iterable<IJavaProject> _xblockexpression = null;
              {
                final Function1<IClasspathEntry, Boolean> _function_2 = (IClasspathEntry it) -> {
                  int _entryKind = it.getEntryKind();
                  return Boolean.valueOf((_entryKind == IClasspathEntry.CPE_PROJECT));
                };
                final Iterable<IClasspathEntry> cpes = IterableExtensions.<IClasspathEntry>filter(((Iterable<IClasspathEntry>)Conversions.doWrapArray(p.getResolvedClasspath(true))), _function_2);
                final Function1<IClasspathEntry, IPath> _function_3 = (IClasspathEntry it) -> {
                  return it.getPath();
                };
                final Iterable<IPath> paths = IterableExtensions.<IClasspathEntry, IPath>map(cpes, _function_3);
                final Function1<IPath, IJavaProject> _function_4 = (IPath it) -> {
                  return model.getJavaProject(it.toString());
                };
                _xblockexpression = IterableExtensions.<IPath, IJavaProject>map(paths, _function_4);
              }
              return _xblockexpression;
            } catch (Throwable _e) {
              throw Exceptions.sneakyThrow(_e);
            }
          };
          final Iterable<IJavaProject> referenced = Iterables.<IJavaProject>concat(IterableExtensions.<IJavaProject, Iterable<IJavaProject>>map(projects, _function_1));
          boolean _add = Iterables.<IJavaProject>addAll(projects, referenced);
          changed = _add;
        }
      }
      final Function1<IJavaProject, URL> _function_1 = (IJavaProject p) -> {
        try {
          URL _xblockexpression = null;
          {
            final IFile file = workspaceRoot.getFile(p.getOutputLocation());
            URI _locationURI = file.getLocationURI();
            String _plus = (_locationURI + "/");
            _xblockexpression = new URL(_plus);
          }
          return _xblockexpression;
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      };
      final Iterable<URL> urls = IterableExtensions.<IJavaProject, URL>map(projects, _function_1);
      final ClassLoader parent = this.getClass().getClassLoader();
      final URLClassLoader loader = new URLClassLoader(((URL[])Conversions.unwrapArray(urls, URL.class)), parent);
      final Class<?> clazz = Class.forName(className, true, loader);
      return clazz;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
