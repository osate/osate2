/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.ui.wizards;

import java.io.ByteArrayInputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.texteditor.ITextEditor;
import org.osate.ui.OsateUiPlugin;
import org.osate.xtext.aadl2.properties.parser.antlr.lexer.InternalPropertiesLexer;

/**
 * Abstract wizard for creating new files. Each wizard contains a tree for selecting the parent folder and
 * one or more fields for entering text. Subclasses must specify the fields in the wizard by calling addField
 * before the wizard page is created. This can best be done in the constructor of the subclass.
 */
public abstract class AbstractNewFileWizard extends Wizard implements INewWizard {
	private static final List<String> HIDE_FOLDERS = List.of("instances", "diagrams", "imv");

	protected IProject project = null;

	private final String titleFileType;
	private final String descriptionFileType;
	protected final String fileExtension;
	private final int tabIndex;
	private final ILog log;
	private final String pluginId;
	private final LinkedHashMap<String, Predicate<String>> fieldValidators = new LinkedHashMap<>();

	private IWorkbench workbench;
	private IContainer initialSelection;

	private TreeViewer folderViewer;
	private LinkedHashMap<String, Text> fields;

	public AbstractNewFileWizard(String titleFileType, String fileExtension, int tabIndex, ILog log, String pluginId) {
		this(titleFileType, titleFileType.toLowerCase(), fileExtension, tabIndex, log, pluginId);
	}

	public AbstractNewFileWizard(String titleFileType, String descriptionFileType, String fileExtension, int tabIndex,
			ILog log, String pluginId) {
		this.titleFileType = titleFileType;
		this.descriptionFileType = descriptionFileType;
		this.fileExtension = fileExtension;
		this.tabIndex = tabIndex;
		this.log = log;
		this.pluginId = pluginId;
	}

	public void addField(String fieldLabel, Predicate<String> fieldValidator) {
		fieldValidators.put(fieldLabel, fieldValidator);
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		var selectedElement = selection == null ? null : selection.getFirstElement();
		if (selectedElement instanceof IFile file) {
			initialSelection = file.getParent();
		} else if (selectedElement instanceof IContainer container) {
			initialSelection = container;
		} else {
			initialSelection = null;
		}
		project = initialSelection == null ? null : initialSelection.getProject();

		setWindowTitle("New " + titleFileType + " File");
		setDefaultPageImageDescriptor(OsateUiPlugin.getImageDescriptor("icons/NewAadl2.gif"));
	}

	@Override
	public boolean performFinish() {
		var newFile = getFile();
		var fieldValues = new HashMap<String, String>();
		fields.forEach((fieldLabel, field) -> fieldValues.put(fieldLabel, field.getText()));
		var contents = fileContents(fieldValues);
		var operation = new WorkspaceModifyOperation() {
			@Override
			protected void execute(IProgressMonitor monitor) throws CoreException {
				newFile.create(new ByteArrayInputStream(contents.getBytes()), false, monitor);
				if (monitor.isCanceled()) {
					throw new OperationCanceledException();
				}
			}
		};
		try {
			getContainer().run(true, true, operation);
			openEditor(newFile, contents);
			return true;
		} catch (InterruptedException e) {
			return false;
		} catch (InvocationTargetException e) {
			log.log(new Status(IStatus.ERROR, pluginId, e.getMessage(), e));
			MessageDialog.openError(getContainer().getShell(), "Creation Problems",
					e.getTargetException().getMessage());
			return false;
		}
	}

	public void openEditor(IFile newFile, String contents) {
		openDefaultEditor(newFile, contents);
	}

	protected final void openDefaultEditor(IFile newFile, String contents) {
		var activePage = workbench.getActiveWorkbenchWindow().getActivePage();
		var editorId = workbench.getEditorRegistry().getDefaultEditor(newFile.getName()).getId();
		try {
			var editor = (ITextEditor) activePage.openEditor(new FileEditorInput(newFile), editorId);
			editor.selectAndReveal(StringUtils.ordinalIndexOf(contents, "\t", tabIndex) + 1, 0);
		} catch (PartInitException e) {
			log.log(new Status(IStatus.WARNING, pluginId, e.getMessage(), e));
			MessageDialog.openWarning(getContainer().getShell(), "Open Editor", e.getMessage());
		}
	}

	/**
	 * fieldValues is a map from the field labels to the values in the text fields. The field labels are
	 * specified in the calls to addField.
	 */
	public abstract String fileContents(Map<String, String> fieldValues);

	@Override
	public void addPages() {
		var wizardPage = new WizardPage("New Object", "New " + titleFileType + " File", null) {
			@Override
			public void createControl(Composite parent) {
				var composite = new Composite(parent, SWT.NONE);
				composite.setSize(parent.getSize());
				composite.setLayout(new GridLayout(2, false));

				var folderLabel = new Label(composite, SWT.NONE);
				folderLabel.setText("Create in project/folder:");
				folderLabel.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, true, false, 2, 1));

				folderViewer = new TreeViewer(composite, SWT.BORDER | SWT.SINGLE);
				folderViewer.getTree().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
				folderViewer.setContentProvider(new WorkbenchContentProvider() {
					@Override
					public Object[] getChildren(Object element) {
						if (element instanceof IWorkspace workspace) {
							return Arrays.stream(workspace.getRoot().getProjects()).filter(IProject::isOpen).toArray();
						}
						if (element instanceof IContainer container) {
							try {
								return Arrays.stream(container.members())
										.filter(IContainer.class::isInstance)
										.map(IContainer.class::cast)
										.filter(resource -> !resource.getName().startsWith(".")
												&& !HIDE_FOLDERS.contains(resource.getName()))
										.toArray();
							} catch (CoreException e) {
								log.log(new Status(IStatus.WARNING, pluginId, e.getMessage(), e));
								return new Object[0];
							}
						}
						return new Object[0];
					}
				});
				folderViewer.setLabelProvider(WorkbenchLabelProvider.getDecoratingWorkbenchLabelProvider());
				folderViewer.setInput(ResourcesPlugin.getWorkspace());
				if (initialSelection != null) {
					folderViewer.setSelection(new StructuredSelection(initialSelection), true);
				}
				folderViewer.addSelectionChangedListener(event -> validate());

				var newFields = new LinkedHashMap<String, Text>();
				for (var fieldLabel : fieldValidators.keySet()) {
					var label = new Label(composite, SWT.NONE);
					label.setText(fieldLabel + ":");
					label.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));

					var field = new Text(composite, SWT.BORDER);
					field.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
					field.addModifyListener(event -> validate());

					newFields.put(fieldLabel, field);
				}
				fields = newFields;

				addLocalControls(composite);
				setControl(composite);
			}

			@Override
			public void setVisible(boolean visible) {
				super.setVisible(visible);
				if (visible) {
					getFirstField().setFocus();
				}
			}

			private void validate() {
				setErrorMessage(findErrorMessage());
				setPageComplete(getErrorMessage() == null);
			}

			/*
			 * The following conditions must be true for the wizard page to be valid:
			 * -A parent project or folder must be selected.
			 * -For each field:
			 *   -Must not be empty.
			 *   -Must pass the field's validator
			 * -For the first field:
			 *   -Must not already exist as a file in the selected project or folder.
			 */
			private String findErrorMessage() {
				if (folderViewer.getStructuredSelection().isEmpty()) {
					return "No folder specified.";
				}
				var firstEntry = true;
				for (var entry : fields.entrySet()) {
					var fieldLabel = entry.getKey();
					var fieldText = entry.getValue().getText();
					if (fieldText.isEmpty()) {
						return fieldLabel + " cannot be empty.";
					}
					if (!fieldValidators.get(fieldLabel).test(fieldText)) {
						return "The " + fieldLabel + " '" + fieldText + "' is not valid.";
					}
					if (firstEntry) {
						var parentContainer = (IContainer) folderViewer.getStructuredSelection().getFirstElement();
						var fileNameError = validateFileName(parentContainer, fieldText);
						if (fileNameError != null) {
							return fileNameError;
						}
					}
					firstEntry = false;
				}
				return null;
			}
		};
		wizardPage.setDescription("Create a new " + descriptionFileType + " file.");
		wizardPage.setPageComplete(false);
		addPage(wizardPage);
	}

	protected String validateFileName(IContainer parent, String name) {
		if (getFile().exists()) {
			return "'" + getFileName(name) + "' already exists.";
		}
		return null; // No error message
	}

	/**
	 * A wizard may add more controls to the pane.  They will appear below the widgets created by the
	 * {@link #addField(String, Predicate)} functionality.  Keep in mind that the layout manager for the pane is a Grid
	 * with 2 columns.
	 */
	protected void addLocalControls(Composite parent) {
		// by default does nothing
	}

	protected static boolean isValidId(String id) {
		try {
			var lexer = new InternalPropertiesLexer(new ANTLRStringStream(id));
			lexer.mRULE_ID();
			return lexer.nextToken() == Token.EOF_TOKEN;
		} catch (RecognitionException e) {
			return false;
		}
	}

	private Text getFirstField() {
		return fields.values().iterator().next();
	}

	private IFile getFile() {
		var parentContainer = (IContainer) folderViewer.getStructuredSelection().getFirstElement();
		return parentContainer.getFile(new Path(getFileName(getFirstField().getText())));
	}

	protected String getFileName(String enteredName) {
		return enteredName + "." + fileExtension;
	}
}
