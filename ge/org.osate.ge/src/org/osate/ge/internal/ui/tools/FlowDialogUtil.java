package org.osate.ge.internal.ui.tools;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.ScrollBar;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.osate.ge.internal.Activator;

class FlowDialogUtil {
	private FlowDialogUtil() {
	}

	private final static Image errorImage = PlatformUI.getWorkbench().getSharedImages()
			.getImage(ISharedImages.IMG_OBJS_ERROR_TSK);
	private final static Image warningImage = PlatformUI.getWorkbench().getSharedImages()
			.getImage(ISharedImages.IMG_OBJS_WARN_TSK);

	public static TableViewer createErrorTableViewer(final Composite container) {
		final TableViewer errorTableViewer = getErrorTableViewer(container);
		final Table errorTable = errorTableViewer.getTable();
		setTableData(errorTable);

		final TableColumnLayout layout = getColumnLayout(errorTable);
		container.setLayout(layout);
		container.setLayoutData(GridDataFactory.fillDefaults().grab(true, true).create());

		return errorTableViewer;
	}

	public static Composite createFlowArea(final Composite parent) {
		final Composite composite = new Composite(parent, SWT.NONE);
		final GridLayout layout = new GridLayout();
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		layout.verticalSpacing = 0;
		layout.horizontalSpacing = 0;
		composite.setLayout(layout);

		composite.setLayoutData(GridDataFactory.fillDefaults().grab(true, true).create());
		composite.setFont(parent.getFont());

		return composite;
	}

	public static Composite createSegmentComposite(final Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		layout.verticalSpacing = 0;
		layout.horizontalSpacing = 0;
		composite.setLayout(layout);

		composite.setLayoutData(GridDataFactory.fillDefaults().hint(SWT.DEFAULT, 65).grab(true, false).create());
		composite.setFont(parent.getFont());
		return composite;
	}

	private static TableColumnLayout getColumnLayout(final Table errorTable) {
		// Create column
		final TableColumn tableColumn = new TableColumn(errorTable, SWT.NONE);
		tableColumn.setText("Model Errors");

		// Create column layout
		final TableColumnLayout layout = new TableColumnLayout();
		layout.setColumnData(tableColumn, new ColumnWeightData(1, true));
		return layout;
	}

	private static void setTableData(final Table errorTable) {
		errorTable.setLayout(new GridLayout());
		errorTable.setLayoutData(GridDataFactory.fillDefaults().grab(true, true).create());
		errorTable.setHeaderVisible(true);
		errorTable.setLinesVisible(true);
	}

	public static void setInput(final TableViewer errorTableViewer, final Object input) {
		errorTableViewer.setInput(input);

		final Table table = errorTableViewer.getTable();
		// Set column width to account for vertical scroll
		final ScrollBar verticalBar = table.getVerticalBar();
		if (verticalBar.isVisible()) {
			final int tableWidth = table.getSize().x;
			final int columnWidth = tableWidth - verticalBar.getSize().x - 5;
			if (tableWidth > columnWidth) {
				final TableColumn tableColumn = table.getColumn(0);
				tableColumn.setWidth(columnWidth);
			}
		} else {
			final int tableWidth = table.getSize().x;
			final int columnWidth = tableWidth - verticalBar.getSize().x - 5;
			if (tableWidth > columnWidth) {
				final TableColumn tableColumn = table.getColumn(0);
				tableColumn.setWidth(tableWidth - 5);
			}
		}

		errorTableViewer.getTable().layout(true, true);
	}

	private static TableViewer getErrorTableViewer(final Composite container) {
		final TableViewer errorTableViewer = new TableViewer(container,
				SWT.V_SCROLL | SWT.H_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);
		errorTableViewer.setContentProvider(ArrayContentProvider.getInstance());
		setLabelProvider(errorTableViewer);
		return errorTableViewer;
	}

	private static void setLabelProvider(final TableViewer errorTableViewer) {
		errorTableViewer.setLabelProvider(new CellLabelProvider() {
			@Override
			public void update(final ViewerCell cell) {
				final Diagnostic diagnostic = (Diagnostic) cell.getElement();
				cell.setText(diagnostic.getMessage());
				cell.setImage(diagnostic.getSeverity() == Diagnostic.ERROR ? errorImage : warningImage);
			}
		});
	}

	static class ErrorDialog extends org.eclipse.jface.dialogs.ErrorDialog {
		private final Object input;

		public ErrorDialog(final String message, final Object input) {
			super(Display.getDefault().getActiveShell(), "Flow Tool Error",
					message + " Tool cannot be used until errors have been resolved.  Resolve errors and try again.",
					new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Errors detected in the model."), IStatus.ERROR);
			this.input = input;
		}

		@Override
		public void create() {
			super.create();
			final Point size = new Point(500, 300);
			getShell().setSize(size);
			getShell().setMinimumSize(size);
		}

		@Override
		protected Control createDialogArea(final Composite parent) {
			final Composite area = (Composite) super.createDialogArea(parent);
			final GridData areaGridData = (GridData) area.getLayoutData();
			areaGridData.grabExcessVerticalSpace = true;

			final Composite container = new Composite(area, SWT.NONE);
			final TableViewer errorTableViewer = FlowDialogUtil.createErrorTableViewer(container);
			final GridData containerGridData = (GridData) container.getLayoutData();
			containerGridData.horizontalSpan = 2;

			errorTableViewer.setInput(input);
			return area;
		}
	}

	public static StyledText createFlowSegmentLabel(final Composite flowSegmentComposite) {
		final StyledText flowSegmentLabel = new StyledText(flowSegmentComposite,
				SWT.BORDER | SWT.WRAP | SWT.V_SCROLL | SWT.MULTI);
		flowSegmentLabel.setEditable(false);
		flowSegmentLabel.setEnabled(false);
		flowSegmentLabel.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));
		flowSegmentLabel.setMargins(5, 5, 5, 5);
		flowSegmentLabel.setLayoutData(GridDataFactory.fillDefaults().grab(true, true).create());
		return flowSegmentLabel;
	}
}
