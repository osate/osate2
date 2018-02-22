package org.osate.ge.internal.ui.dialogs;

import java.util.Objects;

import org.eclipse.core.internal.resources.Workspace;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.osate.ge.internal.ui.editor.AgeDiagramEditor;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;

@SuppressWarnings("restriction")
public class CreateDiagramDialog<DiagramType> {
	public static interface Model<DiagramType> {
		ImmutableCollection<DiagramType> getDiagramTypes();

		String getDiagramTypeName(final DiagramType diagramType);

		IProject getProject();

		String getDefaultName();

		DiagramType getDefaultDiagramType();
	}

	public static class Result<DiagramType> {
		private final IFile diagramFile;
		private final DiagramType diagramType;

		public Result(final IFile diagramFile, final DiagramType diagramType) {
			this.diagramFile = Objects.requireNonNull(diagramFile, "diagramFile must not be null");
			this.diagramType = Objects.requireNonNull(diagramType, "diagramType must not be null");
		}

		public final IFile getDiagramFile() {
			return diagramFile;
		}

		public final DiagramType getDiagramType() {
			return diagramType;
		}
	}

	private class InnerDialog extends TitleAreaDialog {
		private Text nameField;
		private IFile file;
		private DiagramType diagramType;

		public InnerDialog(final Shell parentShell) {
			super(parentShell);
			setShellStyle(getShellStyle() | SWT.RESIZE);
			this.setHelpAvailable(false);
		}

		@Override
		protected void configureShell(final Shell newShell) {
			super.configureShell(newShell);
			newShell.setText("Create Diagram");
			newShell.setMinimumSize(500, 200);
		}

		@Override
		public void create() {
			super.create();
			setTitle("Create New Diagram");
			setMessage("Create a new diagram.", IMessageProvider.INFORMATION);
			validate();
		}

		@Override
		protected Point getInitialLocation(final Point initialSize) {
			return super.getInitialLocation(initialSize);
		}

		@SuppressWarnings("unchecked")
		@Override
		protected Control createDialogArea(final Composite parent) {
			final Composite area = (Composite) super.createDialogArea(parent);

			final Composite container = new Composite(area, SWT.NONE);
			container.setLayoutData(GridDataFactory.fillDefaults().grab(true, true).create());
			container.setLayout(GridLayoutFactory.swtDefaults().numColumns(2).create());

			final Label nameLabel = new Label(container, SWT.NONE);
			nameLabel.setText("Name");

			nameField = new Text(container, SWT.SINGLE | SWT.BORDER);
			nameField.setLayoutData(GridDataFactory.fillDefaults().grab(true, false).create());
			nameField.addModifyListener(e -> {
				updateFile();
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
				} while (tmpFile.exists());


				nameField.setText(name);
			}

			//
			// Create type field
			//
			final Label typeLabel = new Label(container, SWT.NONE);
			typeLabel.setText("Type:");

			final ComboViewer typeField = new ComboViewer(container);
			typeField.getCombo().setLayoutData(GridDataFactory.fillDefaults().grab(true, false).create());
			typeField.setComparator(new ViewerComparator());
			typeField.setContentProvider(new ArrayContentProvider());
			typeField.setLabelProvider(new LabelProvider() {
				@Override
				public String getText(Object element) {
					return model.getDiagramTypeName((DiagramType) element);
				}
			});
			typeField.setInput(model.getDiagramTypes());
			typeField.addSelectionChangedListener(event -> {
				diagramType = (DiagramType) ((StructuredSelection) typeField.getSelection()).getFirstElement();
				validate();
			});

			diagramType = model.getDefaultDiagramType();
			if (diagramType != null) {
				typeField.setSelection(new StructuredSelection(diagramType));
			}

			// Update the initial value for the file and validate initial values
			updateFile();
			validate();

			return area;
		}

		private void updateFile() {
			file = createFile(model.getProject(), nameField.getText());
			validate();
		}

		private IFile createFile(final IProject project, final String name) {
			final IFolder diagramFolder = project.getFolder("diagrams/");
			return diagramFolder.getFile(name + AgeDiagramEditor.EXTENSION);
		}

		private void validate() {
			// Check values and set error message
			if (file == null) {
				setErrorMessage("Enter a name.");
			} else if (file.exists()) {
				setErrorMessage(
						"File '" + file.getProjectRelativePath().makeAbsolute().toString() + "' already exists.");
			} else if (!nameField.getText().matches("\\S[\\w\\d \\(\\)-]*")) {
				setErrorMessage(
						"Name is not valid.");
			} else if (diagramType == null) {
				setErrorMessage("Select a diagram type.");
			} else {
				setErrorMessage(null);
			}

			// Update the OK button state
			final Button okButton = getButton(IDialogConstants.OK_ID);
			if (okButton != null) {
				okButton.setEnabled(getErrorMessage() == null);
			}
		}

		public DiagramType getSelectedDiagramType() {
			return diagramType;
		}

		public IFile getFile() {
			return file;
		}
	}

	private final Model<DiagramType> model;
	private final InnerDialog dlg;

	protected CreateDiagramDialog(final Shell parentShell, final Model<DiagramType> model) {
		this.model = Objects.requireNonNull(model, "model must not be null");
		this.dlg = new InnerDialog(parentShell);
	}

	private Result<DiagramType> open() {
		return dlg.open() == Window.OK ? new Result<>(dlg.getFile(), dlg.getSelectedDiagramType()) : null;
	}

	/**
	 * A null return value indicates that the dialog was canceled.
	 * @param initialSelectionBoPath is an array of business objects which form a path to the node that should be selected. May be null
	 * @return
	 */
	public static <DiagramType> Result<DiagramType> show(final Shell parentShell, final Model<DiagramType> model) {
		final CreateDiagramDialog<DiagramType> dlg = new CreateDiagramDialog<>(parentShell, model);
		return dlg.open();
	}

	public static void main(String[] args) {
		final Model<String> model = new Model<String>() {
			private IProject project = new Workspace().getRoot().getProject("test");

			@Override
			public ImmutableCollection<String> getDiagramTypes() {
				return ImmutableList.of("D", "A", "B", "C");
			}

			@Override
			public String getDiagramTypeName(String diagramType) {
				return diagramType + " Name";
			}

			@Override
			public IProject getProject() {
				return project;
			}

			@Override
			public String getDefaultName() {
				return "New Diagram";
			}

			@Override
			public String getDefaultDiagramType() {
				return "A";
			}
		};

		// Show the dialog
		Display.getDefault().syncExec(() -> {
			final Result<String> result = show(null, model);
			if (result == null) {
				System.out.println("Dialog was canceled.");
			} else {
				System.out.println(result.getDiagramFile());
				System.out.println(result.getDiagramType());
			}
		});
	}
}
