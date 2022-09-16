/**
 * Copyright (c) 2004-2022 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.reqtrace;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import org.eclipse.birt.core.framework.IConfigurationElement;
import org.eclipse.birt.core.framework.IExtension;
import org.eclipse.birt.core.framework.Platform;
import org.eclipse.birt.report.engine.api.EngineConfig;
import org.eclipse.birt.report.engine.api.EngineConstants;
import org.eclipse.birt.report.engine.api.IReportEngine;
import org.eclipse.birt.report.engine.api.IReportEngineFactory;
import org.eclipse.birt.report.engine.api.IReportRunnable;
import org.eclipse.birt.report.engine.api.IRunAndRenderTask;
import org.eclipse.birt.report.engine.api.RenderOption;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.filesystem.IFileSystem;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.IJobFunction;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.ide.IDE;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class RequirementsTracingHandler extends AbstractHandler {
  private static final Set<String> EMITTERS_TO_IGNORE = Collections.<String>unmodifiableSet(CollectionLiterals.<String>newHashSet("uk.co.spudsoft.birt.emitters.excel.XlsEmitter", "org.eclipse.birt.report.engine.emitter.postscript", "org.eclipse.birt.report.engine.emitter.ppt", "org.eclipse.birt.report.engine.emitter.prototype.excel", "org.eclipse.birt.report.engine.emitter.word"));

  private static final HashMap<String, String> EMITTERS = CollectionLiterals.<String, String>newHashMap(
    ((Pair<? extends String, ? extends String>[])Conversions.unwrapArray(IterableExtensions.<Pair<String, String>>filter(Iterables.<Pair<String, String>>concat(ListExtensions.<IExtension, Iterable<Pair<String, String>>>map(((List<IExtension>)Conversions.doWrapArray(Platform.getExtensionRegistry().getExtensionPoint("org.eclipse.birt.report.engine.emitters").getExtensions())), 
      ((Function1<IExtension, Iterable<Pair<String, String>>>) (IExtension it) -> {
        final Function1<IConfigurationElement, Boolean> _function = (IConfigurationElement it_1) -> {
          String _name = it_1.getName();
          return Boolean.valueOf(Objects.equal(_name, "emitter"));
        };
        final Function1<IConfigurationElement, Pair<String, String>> _function_1 = (IConfigurationElement it_1) -> {
          String _attribute = it_1.getAttribute("format");
          String _attribute_1 = it_1.getAttribute("id");
          return Pair.<String, String>of(_attribute, _attribute_1);
        };
        return IterableExtensions.<IConfigurationElement, Pair<String, String>>map(IterableExtensions.<IConfigurationElement>filter(((Iterable<IConfigurationElement>)Conversions.doWrapArray(it.getConfigurationElements())), _function), _function_1);
      }))), ((Function1<Pair<String, String>, Boolean>) (Pair<String, String> it) -> {
      boolean _contains = RequirementsTracingHandler.EMITTERS_TO_IGNORE.contains(it.getValue());
      return Boolean.valueOf((!_contains));
    })), Pair.class)));

  @Override
  public Object execute(final ExecutionEvent event) throws ExecutionException {
    Object _xblockexpression = null;
    {
      ISelection _currentSelection = HandlerUtil.getCurrentSelection(event);
      Object _firstElement = ((IStructuredSelection) _currentSelection).getFirstElement();
      final IPath selectionPath = ((IFile) _firstElement).getFullPath();
      String _switchResult = null;
      String _fileExtension = selectionPath.getFileExtension();
      if (_fileExtension != null) {
        switch (_fileExtension) {
          case "aadl":
            _switchResult = "package";
            break;
          case "aaxl2":
          case "aail2":
            _switchResult = "instance";
            break;
          default:
            _switchResult = selectionPath.getFileExtension();
            break;
        }
      } else {
        _switchResult = selectionPath.getFileExtension();
      }
      final String fileType = _switchResult;
      Shell _activeShell = HandlerUtil.getActiveShell(event);
      List<String> _sort = IterableExtensions.<String>sort(RequirementsTracingHandler.EMITTERS.keySet());
      final ReqTraceConfigDialog dialog = new ReqTraceConfigDialog(_activeShell, _sort, fileType);
      int _open = dialog.open();
      boolean _equals = (_open == Window.OK);
      if (_equals) {
        final IJobFunction _function = (IProgressMonitor it) -> {
          IStatus _xblockexpression_1 = null;
          {
            Object _createFactoryObject = Platform.createFactoryObject(IReportEngineFactory.EXTENSION_REPORT_ENGINE_FACTORY);
            final IReportEngineFactory factory = ((IReportEngineFactory) _createFactoryObject);
            EngineConfig _engineConfig = new EngineConfig();
            final Procedure1<EngineConfig> _function_1 = (EngineConfig it_1) -> {
              it_1.getAppContext().put(EngineConstants.APPCONTEXT_CLASSLOADER_KEY, this.getClass().getClassLoader());
            };
            final EngineConfig config = ObjectExtensions.<EngineConfig>operator_doubleArrow(_engineConfig, _function_1);
            IReportEngine _createReportEngine = factory.createReportEngine(config);
            final Procedure1<IReportEngine> _function_2 = (IReportEngine it_1) -> {
              try {
                StringConcatenation _builder = new StringConcatenation();
                _builder.append("platform:/plugin/");
                _builder.append(Activator.PLUGIN_ID);
                _builder.append("/reqtrace.rptdesign");
                final String url = _builder.toString();
                final IReportRunnable report = it_1.openReportDesign(new URL(url).openConnection().getInputStream());
                IRunAndRenderTask _createRunAndRenderTask = it_1.createRunAndRenderTask(report);
                final Procedure1<IRunAndRenderTask> _function_3 = (IRunAndRenderTask it_2) -> {
                  try {
                    it_2.setParameterValue("ProjectName", IterableExtensions.<Object>head(((Iterable<Object>)Conversions.doWrapArray(selectionPath.segments()))));
                    it_2.setParameterValue("Directories", selectionPath.removeFirstSegments(1).removeLastSegments(1).toString());
                    it_2.setParameterValue("FileName", selectionPath.lastSegment());
                    it_2.setParameterValue("AADLFile", selectionPath.toString());
                    it_2.setParameterValue("FileType", fileType);
                    it_2.setParameterValue("ReportType", dialog.getReportType());
                    RenderOption _renderOption = new RenderOption();
                    final Procedure1<RenderOption> _function_4 = (RenderOption it_3) -> {
                      final String file = dialog.getOutputFile();
                      int _lastIndexOf = file.lastIndexOf(".");
                      int _plus = (_lastIndexOf + 1);
                      it_3.setEmitterID(RequirementsTracingHandler.EMITTERS.get(file.substring(_plus)));
                      it_3.setOutputFileName(file);
                    };
                    RenderOption _doubleArrow = ObjectExtensions.<RenderOption>operator_doubleArrow(_renderOption, _function_4);
                    it_2.setRenderOption(_doubleArrow);
                    it_2.run();
                    it_2.close();
                  } catch (Throwable _e) {
                    throw Exceptions.sneakyThrow(_e);
                  }
                };
                ObjectExtensions.<IRunAndRenderTask>operator_doubleArrow(_createRunAndRenderTask, _function_3);
                it_1.destroy();
              } catch (Throwable _e) {
                throw Exceptions.sneakyThrow(_e);
              }
            };
            ObjectExtensions.<IReportEngine>operator_doubleArrow(_createReportEngine, _function_2);
            if (((!it.isCanceled()) && dialog.isOpenFileAutomatically())) {
              IFileSystem _localFileSystem = EFS.getLocalFileSystem();
              String _outputFile = dialog.getOutputFile();
              Path _path = new Path(_outputFile);
              final IFileStore fileStore = _localFileSystem.getStore(_path);
              final Runnable _function_3 = () -> {
                try {
                  IDE.openEditorOnFileStore(HandlerUtil.getActiveWorkbenchWindow(event).getActivePage(), fileStore);
                } catch (Throwable _e) {
                  throw Exceptions.sneakyThrow(_e);
                }
              };
              HandlerUtil.getActiveShell(event).getDisplay().asyncExec(_function_3);
            }
            IStatus _xifexpression = null;
            boolean _isCanceled = it.isCanceled();
            if (_isCanceled) {
              _xifexpression = Status.CANCEL_STATUS;
            } else {
              _xifexpression = Status.OK_STATUS;
            }
            _xblockexpression_1 = _xifexpression;
          }
          return _xblockexpression_1;
        };
        Job.create("Generating Report", _function).schedule();
      }
      _xblockexpression = null;
    }
    return _xblockexpression;
  }
}
