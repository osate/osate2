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
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.jface.dialogs.DialogSettings;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class ReqTraceConfigDialog extends TitleAreaDialog {
  public static final String G2S = "goal2stakeholders";

  public static final String R2G = "requirement2goals";

  private static final String OUTPUT_FILE_SETTING = "OUTPUT_FILE_SETTING";

  private static final String REPORT_TYPE_SETTING = "REPORT_TYPE_SETTING";

  private static final String OPEN_FILE_SETTING = "OPEN_FILE_SETTING";

  private final IDialogSettings dialogSettings = DialogSettings.getOrCreateSection(Activator.getDefault().getDialogSettings(), this.getClass().getName());

  private final List<String> formats;

  private final List<String> formatDescriptions;

  private final String fileType;

  private Button g2sButton;

  private Button r2gButton;

  private Text outputFileText;

  private Button openFileButton;

  @Accessors(AccessorType.PACKAGE_GETTER)
  private String outputFile;

  @Accessors(AccessorType.PACKAGE_GETTER)
  private String reportType;

  @Accessors(AccessorType.PACKAGE_GETTER)
  private boolean openFileAutomatically;

  public ReqTraceConfigDialog(final Shell parent, final List<String> formats, final String fileType) {
    super(parent);
    this.formats = formats;
    final Function1<String, String> _function = (String it) -> {
      String _switchResult = null;
      if (it != null) {
        switch (it) {
          case "docx":
            _switchResult = "Word Document";
            break;
          case "pptx":
            _switchResult = "PowerPoint Presentation";
            break;
          case "xlsx":
            _switchResult = "Excel Workbook";
            break;
          case "odt":
            _switchResult = "ODF Text Document";
            break;
          case "odp":
            _switchResult = "ODF Presentation";
            break;
          case "ods":
            _switchResult = "ODF Spreadsheet";
            break;
          case "html":
            _switchResult = "Web Page";
            break;
          case "pdf":
            _switchResult = "PDF";
            break;
          default:
            _switchResult = it;
            break;
        }
      } else {
        _switchResult = it;
      }
      return _switchResult;
    };
    List<String> _map = ListExtensions.<String, String>map(formats, _function);
    ArrayList<String> _arrayList = new ArrayList<String>(_map);
    this.formatDescriptions = _arrayList;
    this.fileType = fileType;
  }

  @Override
  protected boolean isResizable() {
    return true;
  }

  @Override
  public boolean isHelpAvailable() {
    return false;
  }

  @Override
  protected Point getInitialSize() {
    int _convertHorizontalDLUsToPixels = this.convertHorizontalDLUsToPixels(300);
    return new Point(_convertHorizontalDLUsToPixels, super.getInitialSize().y);
  }

  @Override
  protected IDialogSettings getDialogBoundsSettings() {
    return this.dialogSettings;
  }

  @Override
  protected void configureShell(final Shell newShell) {
    super.configureShell(newShell);
    newShell.setText("Requirements Traceability Report");
  }

  @Override
  public void create() {
    super.create();
    this.setTitle("Traceability Report");
    this.validateOutputFile();
  }

  @Override
  protected Control createDialogArea(final Composite parent) {
    Control _createDialogArea = super.createDialogArea(parent);
    final Procedure1<Composite> _function = (Composite it) -> {
      this.initializeDialogUnits(it);
      Group _group = new Group(it, SWT.NONE);
      final Procedure1<Group> _function_1 = (Group it_1) -> {
        it_1.setText("Report Options");
        GridData _gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
        it_1.setLayoutData(_gridData);
        GridLayout _gridLayout = new GridLayout();
        it_1.setLayout(_gridLayout);
        Button _button = new Button(it_1, SWT.RADIO);
        final Procedure1<Button> _function_2 = (Button it_2) -> {
          it_2.setText("Stakeholder Goal to Stakeholder");
          GridData _gridData_1 = new GridData(SWT.FILL, SWT.TOP, true, false);
          it_2.setLayoutData(_gridData_1);
        };
        Button _doubleArrow = ObjectExtensions.<Button>operator_doubleArrow(_button, _function_2);
        this.g2sButton = _doubleArrow;
        Button _button_1 = new Button(it_1, SWT.RADIO);
        final Procedure1<Button> _function_3 = (Button it_2) -> {
          it_2.setText("System Requirement to Stakeholder Goal");
          GridData _gridData_1 = new GridData(SWT.FILL, SWT.TOP, true, false);
          it_2.setLayoutData(_gridData_1);
        };
        Button _doubleArrow_1 = ObjectExtensions.<Button>operator_doubleArrow(_button_1, _function_3);
        this.r2gButton = _doubleArrow_1;
        final String fileType = this.fileType;
        if (fileType != null) {
          switch (fileType) {
            case "reqspec":
            case "reqdoc":
              this.g2sButton.setEnabled(false);
              this.r2gButton.setSelection(true);
              this.r2gButton.setEnabled(false);
              break;
            case "goals":
            case "goaldoc":
              this.g2sButton.setSelection(true);
              this.g2sButton.setEnabled(false);
              this.r2gButton.setEnabled(false);
              break;
            default:
              String _get = this.dialogSettings.get(ReqTraceConfigDialog.REPORT_TYPE_SETTING);
              boolean _matched = false;
              if (Objects.equal(_get, null)) {
                _matched=true;
              }
              if (!_matched) {
                if (Objects.equal(_get, ReqTraceConfigDialog.G2S)) {
                  _matched=true;
                }
              }
              if (_matched) {
                this.g2sButton.setSelection(true);
              }
              if (!_matched) {
                if (Objects.equal(_get, ReqTraceConfigDialog.R2G)) {
                  _matched=true;
                  this.r2gButton.setSelection(true);
                }
              }
              break;
          }
        } else {
          String _get = this.dialogSettings.get(ReqTraceConfigDialog.REPORT_TYPE_SETTING);
          boolean _matched = false;
          if (Objects.equal(_get, null)) {
            _matched=true;
          }
          if (!_matched) {
            if (Objects.equal(_get, ReqTraceConfigDialog.G2S)) {
              _matched=true;
            }
          }
          if (_matched) {
            this.g2sButton.setSelection(true);
          }
          if (!_matched) {
            if (Objects.equal(_get, ReqTraceConfigDialog.R2G)) {
              _matched=true;
              this.r2gButton.setSelection(true);
            }
          }
        }
      };
      ObjectExtensions.<Group>operator_doubleArrow(_group, _function_1);
      Composite _composite = new Composite(it, SWT.NONE);
      final Procedure1<Composite> _function_2 = (Composite it_1) -> {
        GridData _gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
        it_1.setLayoutData(_gridData);
        GridLayout _gridLayout = new GridLayout(3, false);
        it_1.setLayout(_gridLayout);
        Label _label = new Label(it_1, SWT.NONE);
        final Procedure1<Label> _function_3 = (Label it_2) -> {
          it_2.setText("Output File:");
          GridData _gridData_1 = new GridData(SWT.LEFT, SWT.CENTER, false, false);
          it_2.setLayoutData(_gridData_1);
        };
        ObjectExtensions.<Label>operator_doubleArrow(_label, _function_3);
        Text _text = new Text(it_1, ((SWT.SINGLE | SWT.LEFT) | SWT.BORDER));
        final Procedure1<Text> _function_4 = (Text it_2) -> {
          String _elvis = null;
          String _get = this.dialogSettings.get(ReqTraceConfigDialog.OUTPUT_FILE_SETTING);
          if (_get != null) {
            _elvis = _get;
          } else {
            _elvis = "";
          }
          it_2.setText(_elvis);
          GridData _gridData_1 = new GridData(SWT.FILL, SWT.CENTER, true, false);
          it_2.setLayoutData(_gridData_1);
          final ModifyListener _function_5 = (ModifyEvent it_3) -> {
            this.validateOutputFile();
          };
          it_2.addModifyListener(_function_5);
        };
        Text _doubleArrow = ObjectExtensions.<Text>operator_doubleArrow(_text, _function_4);
        this.outputFileText = _doubleArrow;
        Button _button = new Button(it_1, SWT.PUSH);
        final Procedure1<Button> _function_5 = (Button it_2) -> {
          it_2.setText("Browse...");
          GridData _gridData_1 = new GridData(SWT.RIGHT, SWT.CENTER, false, false);
          it_2.setLayoutData(_gridData_1);
          it_2.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(final SelectionEvent e) {
              Shell _shell = it_2.getShell();
              final FileDialog dialog = new FileDialog(_shell, (SWT.SAVE | SWT.SHEET));
              final Function1<String, String> _function = (String it_3) -> {
                return ("*." + it_3);
              };
              dialog.setFilterExtensions(((String[])Conversions.unwrapArray(ListExtensions.<String, String>map(ReqTraceConfigDialog.this.formats, _function), String.class)));
              dialog.setFilterNames(((String[])Conversions.unwrapArray(ReqTraceConfigDialog.this.formatDescriptions, String.class)));
              dialog.setText("Output File");
              final String selectedFileName = dialog.open();
              if ((selectedFileName != null)) {
                ReqTraceConfigDialog.this.outputFileText.setText(selectedFileName);
                ReqTraceConfigDialog.this.validateOutputFile();
              }
            }
          });
        };
        ObjectExtensions.<Button>operator_doubleArrow(_button, _function_5);
      };
      ObjectExtensions.<Composite>operator_doubleArrow(_composite, _function_2);
      Button _button = new Button(it, SWT.CHECK);
      final Procedure1<Button> _function_3 = (Button it_1) -> {
        it_1.setText("Open Generated Report");
        GridData _gridData = new GridData(SWT.LEFT, SWT.CENTER, false, false);
        it_1.setLayoutData(_gridData);
        final String preference = this.dialogSettings.get(ReqTraceConfigDialog.OPEN_FILE_SETTING);
        it_1.setSelection(((preference == null) || Boolean.parseBoolean(preference)));
      };
      Button _doubleArrow = ObjectExtensions.<Button>operator_doubleArrow(_button, _function_3);
      this.openFileButton = _doubleArrow;
    };
    return ObjectExtensions.<Composite>operator_doubleArrow(
      ((Composite) _createDialogArea), _function);
  }

  @Override
  protected void okPressed() {
    this.outputFile = this.outputFileText.getText().trim();
    String _xifexpression = null;
    boolean _selection = this.g2sButton.getSelection();
    if (_selection) {
      _xifexpression = ReqTraceConfigDialog.G2S;
    } else {
      String _xifexpression_1 = null;
      boolean _selection_1 = this.r2gButton.getSelection();
      if (_selection_1) {
        _xifexpression_1 = ReqTraceConfigDialog.R2G;
      }
      _xifexpression = _xifexpression_1;
    }
    this.reportType = _xifexpression;
    this.openFileAutomatically = this.openFileButton.getSelection();
    this.dialogSettings.put(ReqTraceConfigDialog.OUTPUT_FILE_SETTING, this.outputFile);
    this.dialogSettings.put(ReqTraceConfigDialog.REPORT_TYPE_SETTING, this.reportType);
    this.dialogSettings.put(ReqTraceConfigDialog.OPEN_FILE_SETTING, this.openFileAutomatically);
    super.okPressed();
  }

  private void validateOutputFile() {
    String _switchResult = null;
    String _trim = this.outputFileText.getText().trim();
    final String outputFile = _trim;
    boolean _matched = false;
    boolean _isEmpty = outputFile.isEmpty();
    if (_isEmpty) {
      _matched=true;
      _switchResult = "Missing Output File";
    }
    if (!_matched) {
      String _switchResult_1 = null;
      int _lastIndexOf = outputFile.lastIndexOf(".");
      final int dotLocation = _lastIndexOf;
      boolean _matched_1 = false;
      if (Objects.equal(dotLocation, (-1))) {
        _matched_1=true;
      }
      if (!_matched_1) {
        int _length = outputFile.length();
        int _minus = (_length - 1);
        if (Objects.equal(dotLocation, _minus)) {
          _matched_1=true;
        }
      }
      if (_matched_1) {
        _switchResult_1 = "No Format in Specified Output File";
      }
      if (!_matched_1) {
        String _switchResult_2 = null;
        String _substring = outputFile.substring((dotLocation + 1));
        final String fileExt = _substring;
        boolean _matched_2 = false;
        int _indexOf = fileExt.indexOf(File.separator);
        boolean _notEquals = (_indexOf != (-1));
        if (_notEquals) {
          _matched_2=true;
          _switchResult_2 = "No Format in Specified Output File";
        }
        if (!_matched_2) {
          boolean _contains = this.formats.contains(fileExt);
          boolean _not = (!_contains);
          if (_not) {
            _matched_2=true;
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("Invalid Format: \"");
            _builder.append(fileExt);
            _builder.append("\"");
            _switchResult_2 = _builder.toString();
          }
        }
        _switchResult_1 = _switchResult_2;
      }
      _switchResult = _switchResult_1;
    }
    this.setErrorMessage(_switchResult);
    Button _button = this.getButton(IDialogConstants.OK_ID);
    String _errorMessage = this.getErrorMessage();
    boolean _tripleEquals = (_errorMessage == null);
    _button.setEnabled(_tripleEquals);
  }

  @Pure
  String getOutputFile() {
    return this.outputFile;
  }

  @Pure
  String getReportType() {
    return this.reportType;
  }

  @Pure
  boolean isOpenFileAutomatically() {
    return this.openFileAutomatically;
  }
}
