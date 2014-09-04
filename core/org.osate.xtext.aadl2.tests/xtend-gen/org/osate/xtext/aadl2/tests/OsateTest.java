package org.osate.xtext.aadl2.tests;

import java.io.ByteArrayInputStream;
import org.apache.log4j.Logger;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.jobs.IJobManager;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.URI;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipselabs.xtext.utils.unittesting.XtextTest;
import org.osate.aadl2.modelsupport.resources.PredeclaredProperties;
import org.osate.core.AadlNature;

/**
 * Add a couple of utility methods for managing files in the test workspace
 */
@SuppressWarnings("all")
public class OsateTest extends XtextTest {
  private final static Logger LOGGER = Logger.getLogger(OsateTest.class);
  
  protected final IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
  
  /**
   * Create a project with subdirectories in the current workspace.
   */
  public IProject createProject(final String projectName, final String... srcDirs) {
    try {
      IProject _xblockexpression = null;
      {
        final IProject project = this.workspaceRoot.getProject(projectName);
        final WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {
          public void execute(final IProgressMonitor monitor) {
            try {
              PredeclaredProperties.initPluginContributedAadl();
              final IProject plugin_resources = OsateTest.this.workspaceRoot.getProject("Plugin_Resources");
              boolean _exists = plugin_resources.exists();
              Assert.isTrue(_exists, "Plugin_Resources project does not exist");
              boolean _exists_1 = project.exists();
              boolean _not = (!_exists_1);
              if (_not) {
                project.create(monitor);
                project.open(monitor);
                final IProjectDescription description = project.getDescription();
                description.setNatureIds(new String[] { "org.eclipse.xtext.ui.shared.xtextNature", AadlNature.ID });
                description.setReferencedProjects(new IProject[] { plugin_resources });
                project.setDescription(description, monitor);
                for (final String srcDir : srcDirs) {
                  {
                    final IFolder src = project.getFolder(srcDir);
                    src.create(true, true, monitor);
                  }
                }
              }
            } catch (Throwable _e) {
              throw Exceptions.sneakyThrow(_e);
            }
          }
        };
        operation.run(null);
        _xblockexpression = project;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void deleteProject(final String projectName) {
    try {
      final WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {
        public void execute(final IProgressMonitor monitor) {
          try {
            IProject _project = OsateTest.this.workspaceRoot.getProject(projectName);
            _project.delete(true, true, null);
          } catch (Throwable _e) {
            throw Exceptions.sneakyThrow(_e);
          }
        }
      };
      operation.run(null);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Build the named project. Optionally wait until the build is done.
   */
  public Object buildProject(final String name, final boolean wait) {
    Object _xblockexpression = null;
    {
      final IProject project = this.workspaceRoot.getProject(name);
      boolean _exists = project.exists();
      Assert.isTrue(_exists, (("Project " + name) + " does not exist in the workspace"));
      _xblockexpression = this.buildProject(project, wait);
    }
    return _xblockexpression;
  }
  
  /**
   * Build a given project. Optionally wait until the build is done.
   */
  public Object buildProject(final IProject project, final boolean wait) {
    Object _xblockexpression = null;
    {
      try {
        project.build(IncrementalProjectBuilder.CLEAN_BUILD, null);
      } catch (final Throwable _t) {
        if (_t instanceof CoreException) {
          final CoreException e = (CoreException)_t;
          e.printStackTrace();
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      Object _xifexpression = null;
      if (wait) {
        _xifexpression = this.waitForBuild();
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  /**
   * Create a set of files in the workspace given as filename -> text pairs
   */
  protected Object createFiles(final Pair<String, String>... models) {
    try {
      Object _xblockexpression = null;
      {
        final WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {
          public void execute(final IProgressMonitor monitor) {
            for (final Pair<String, String> model : models) {
              {
                String _key = model.getKey();
                String _plus = ((OsateTest.this.resourceRoot + "/") + _key);
                final URI uri = URI.createURI(_plus);
                String _value = model.getValue();
                OsateTest.this.createFile(uri, _value);
              }
            }
          }
        };
        operation.run(null);
        _xblockexpression = this.waitForBuild();
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public IFile createFile(final URI uri, final String content) {
    IFile _xblockexpression = null;
    {
      String _platformString = uri.toPlatformString(true);
      Path _path = new Path(_platformString);
      final IFile file = this.workspaceRoot.getFile(_path);
      IContainer _parent = file.getParent();
      boolean _exists = _parent.exists();
      Assert.isTrue(_exists);
      Class<? extends OsateTest> _class = this.getClass();
      String _simpleName = _class.getSimpleName();
      String _plus = ((("creating " + uri) + " in test method ") + _simpleName);
      String _plus_1 = (_plus + ".");
      Throwable _throwable = new Throwable();
      Throwable _fillInStackTrace = _throwable.fillInStackTrace();
      StackTraceElement[] _stackTrace = _fillInStackTrace.getStackTrace();
      StackTraceElement _get = _stackTrace[1];
      String _methodName = _get.getMethodName();
      String _plus_2 = (_plus_1 + _methodName);
      OsateTest.LOGGER.info(_plus_2);
      try {
        String _charset = file.getCharset();
        byte[] _bytes = content.getBytes(_charset);
        final ByteArrayInputStream stream = new ByteArrayInputStream(_bytes);
        boolean _exists_1 = file.exists();
        if (_exists_1) {
          file.setContents(stream, true, true, null);
        } else {
          file.create(stream, true, null);
        }
        stream.close();
      } catch (final Throwable _t) {
        if (_t instanceof Exception) {
          final Exception e = (Exception)_t;
          OsateTest.LOGGER.error(e);
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      _xblockexpression = file;
    }
    return _xblockexpression;
  }
  
  public Object waitForBuild() {
    Object _xblockexpression = null;
    {
      final IJobManager jobManager = Job.getJobManager();
      Object _xtrycatchfinallyexpression = null;
      try {
        jobManager.join(ResourcesPlugin.FAMILY_AUTO_BUILD, null);
        jobManager.join(ResourcesPlugin.FAMILY_MANUAL_BUILD, null);
      } catch (final Throwable _t) {
        if (_t instanceof InterruptedException) {
          final InterruptedException e = (InterruptedException)_t;
          _xtrycatchfinallyexpression = null;
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      _xblockexpression = _xtrycatchfinallyexpression;
    }
    return _xblockexpression;
  }
}
