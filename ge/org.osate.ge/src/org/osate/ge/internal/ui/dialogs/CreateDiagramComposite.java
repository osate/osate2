/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
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
package org.osate.ge.internal.ui.dialogs;

import java.util.Collection;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.osate.ge.internal.ui.editor.AgeDiagramEditor;
import org.osate.ge.internal.ui.util.UiUtil;

import com.google.common.collect.ImmutableCollection;

/**
 * Composite for prompting the user for a name and type for a diagram. Results in a filename and diagram type.
 */
public class CreateDiagramComposite<DiagramType> extends Composite {
	public static final String WIDGET_ID_NAME = "org.osate.ge.createDiagram.name";
	public static final String WIDGET_ID_TYPE = "org.osate.ge.createDiagram.type";

	public static interface Model<DiagramType> {
		ImmutableCollection<DiagramType> getDiagramTypes();

		String getDiagramTypeName(final DiagramType diagramType);

		IProject getProject();

		String getDefaultName();

		DiagramType getDefaultDiagramType();
	}

	public static class Value<DiagramType> {
		private final IFile file;
		private final DiagramType diagramType;

		Value(final IFile file, final DiagramType diagramType) {
			this.file = file;
			this.diagramType = diagramType;
		}

		public final IFile getFile() {
			return file;
		}

		public final DiagramType getDiagramType() {
			return diagramType;
		}

		public boolean isValid() {
			return file != null && diagramType != null;
		}
	}

	private final CopyOnWriteArrayList<SelectionListener> selectionListeners = new CopyOnWriteArrayList<>();
	private Model<DiagramType> model;
	private final Text nameField;
	private IFile file;
	private DiagramType diagramType;
	private String errorMessage;
	private final ComboViewer typeField;

	@SuppressWarnings("unchecked")
	public CreateDiagramComposite(final Composite parent, final Model<DiagramType> model) {
		super(parent, SWT.NONE);
		setLayoutData(GridDataFactory.fillDefaults().grab(true, true).create());
		setLayout(GridLayoutFactory.swtDefaults().numColumns(2).create());

		final Label nameLabel = new Label(this, SWT.NONE);
		nameLabel.setText("Name");

		nameField = new Text(this, SWT.SINGLE | SWT.BORDER);
		UiUtil.setTestingId(nameField, WIDGET_ID_NAME);
		nameField.setLayoutData(GridDataFactory.fillDefaults().grab(true, false).create());
		nameField.addModifyListener(e -> {
			if (CreateDiagramComposite.this.model != null) {
				updateFile();
			}
		});

		// Determine the initial name. A suffix will be added to the default name if the file already exists
		final IProject project = model.getProject();
		final String baseName = model.getDefaultName();
		if (baseName != null) {
			IFile tmpFile;
			int nameCount = 1;
			String name;
			do {
				final String suffix = nameCount == 1 ? "" : "(" + nameCount + ")";
				name = baseName + suffix;
				tmpFile = createFile(project, name);
				nameCount++;
			} while (tmpFile != null && tmpFile.exists());

			nameField.setText(name);
		}

		//
		// Create type field
		//
		final Label typeLabel = new Label(this, SWT.NONE);
		typeLabel.setText("Type:");

		typeField = new ComboViewer(this);
		UiUtil.setTestingId(typeField.getCombo(), WIDGET_ID_TYPE);
		typeField.getCombo().setLayoutData(GridDataFactory.fillDefaults().grab(true, false).create());
		typeField.setComparator(new ViewerComparator());
		typeField.setContentProvider(new ArrayContentProvider());
		typeField.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				return model.getDiagramTypeName((DiagramType) element);
			}
		});

		setModel(model);
	}

	@SuppressWarnings("unchecked")
	public void setModel(final Model<DiagramType> model) {
		this.model = Objects.requireNonNull(model, "model must not be null");

		final Collection<DiagramType> diagramTypes = model.getDiagramTypes();
		typeField.setInput(diagramTypes);
		typeField.addSelectionChangedListener(event -> {
			diagramType = (DiagramType) ((StructuredSelection) typeField.getSelection()).getFirstElement();
			validate();
			notifySelectionListeners();
		});

		// Reset the selected diagram type
		diagramType = model.getDefaultDiagramType();
		typeField.setSelection(diagramType == null ? StructuredSelection.EMPTY : new StructuredSelection(diagramType));

		// Update the initial value for the file and validate initial values
		updateFile();
	}


	private void updateFile() {
		file = createFile(model.getProject(), nameField.getText());
		validate();
		notifySelectionListeners();
	}

	/**
	 *
	 * @param project
	 * @param name
	 * @return null if project is null.
	 */
	private IFile createFile(final IProject project, final String name) {
		if (project == null) {
			return null;
		}

		final IFolder diagramFolder = project.getFolder("diagrams/");
		return diagramFolder.getFile(name + AgeDiagramEditor.EXTENSION);
	}

	/**
	 * Selection listeners are called when the value of the widget changes.
	 * @param listener
	 */
	public void addSelectionListener(final SelectionListener listener) {
		selectionListeners.add(listener);
	}

	private void notifySelectionListeners() {
		final Event e = new Event();
		e.widget = this;
		final SelectionEvent selectionEvent = new SelectionEvent(e);
		for (final SelectionListener l : selectionListeners) {
			l.widgetSelected(selectionEvent);
		}
	}

	private void validate() {
		// Check values and set error message
		if (model.getProject() == null) {
			setErrorMessage("Invalid project.");
		} else if (file == null) {
			setErrorMessage("Enter a name.");
		} else if (file.exists()) {
			setErrorMessage("File '" + file.getProjectRelativePath().makeAbsolute().toString() + "' already exists.");
		} else if (!nameField.getText().matches("\\S[\\w\\d \\(\\)-]*")) {
			setErrorMessage("Name is not valid.");
		} else if (diagramType == null) {
			setErrorMessage("Select a diagram type.");
		} else {
			setErrorMessage(null);
		}
	}

	private void setErrorMessage(final String value) {
		this.errorMessage = value;
	}

	public String getErrorMessage() {
		return this.errorMessage;
	}

	/**
	 * May return partial value. Use getErrorMessage() to determine if the value is complete.
	 * @return
	 */
	public Value<DiagramType> getValue() {
		return new Value<DiagramType>(file, diagramType);
	}
}
