package org.osate.ge.internal.ui.dialogs;

import java.util.Objects;

import org.eclipse.core.internal.resources.Workspace;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;

@SuppressWarnings("restriction")
public class CreateDiagramDialog<DiagramType> {
	public static interface Model<DiagramType> extends CreateDiagramComposite.Model<DiagramType> {
	}

	public static class Result<DiagramType> {
		private final IFile diagramFile;
		private final DiagramType diagramType;

		public Result(final CreateDiagramComposite.Value<DiagramType> value) {
			this.diagramFile = Objects.requireNonNull(value.getFile(), "diagramFile must not be null");
			this.diagramType = Objects.requireNonNull(value.getDiagramType(), "diagramType must not be null");
		}

		public final IFile getDiagramFile() {
			return diagramFile;
		}

		public final DiagramType getDiagramType() {
			return diagramType;
		}
	}

	private class InnerDialog extends TitleAreaDialog {
		private CreateDiagramComposite<DiagramType> composite;

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

		@Override
		protected Control createDialogArea(final Composite parent) {
			final Composite area = (Composite) super.createDialogArea(parent);
			composite = new CreateDiagramComposite<DiagramType>(area, model);
			validate();

			// Validate when the selection of the underlying composite changes
			composite.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					validate();
				}
			});

			return area;
		}

		private void validate() {
			setErrorMessage(composite.getErrorMessage());

			// Update the OK button state
			final Button okButton = getButton(IDialogConstants.OK_ID);
			if (okButton != null) {
				okButton.setEnabled(getErrorMessage() == null);
			}
		}

		public CreateDiagramComposite.Value<DiagramType> getValue() {
			return composite.getValue();
		}
	}

	private final Model<DiagramType> model;
	private final InnerDialog dlg;

	protected CreateDiagramDialog(final Shell parentShell, final Model<DiagramType> model) {
		this.model = Objects.requireNonNull(model, "model must not be null");
		this.dlg = new InnerDialog(parentShell);
	}

	private Result<DiagramType> open() {
		return dlg.open() == Window.OK ? new Result<>(dlg.getValue()) : null;
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
