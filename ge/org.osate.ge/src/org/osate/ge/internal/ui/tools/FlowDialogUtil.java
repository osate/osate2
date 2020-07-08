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
package org.osate.ge.internal.ui.tools;

import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.RowLayoutFactory;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.ScrollBar;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.internal.Activator;
import org.osate.ge.internal.diagram.runtime.DiagramElement;

public class FlowDialogUtil {
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

	public static Composite createFlowArea(final Composite parent, final int style) {
		final Composite composite = new Composite(parent, style);
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

	static void createInModeText(final Composite parent) {
		final StyledText inModesText = new StyledText(parent, SWT.NONE);
		inModesText.setText("in modes ");
		inModesText.setStyleRange(
				new StyleRange(0, 8, Display.getCurrent().getSystemColor(SWT.COLOR_DARK_RED), null, SWT.BOLD));
		inModesText.setBackground(parent.getBackground());
	}

	static void createArrowText(final Composite parent) {
		final StyledText arrow = new StyledText(parent, SWT.NONE);
		arrow.setLayoutData(new RowData());
		arrow.setText("->");
		arrow.setBackground(parent.getBackground());
	}

	/**
	 * Represents flow segments and in mode feature elements for editing flows
	 */
	static class SegmentData {
		private final BusinessObjectContext boc;
		// Highlightable elements owned by the segment
		private final List<DiagramElement> ownedSegments;

		public SegmentData(final BusinessObjectContext boc) {
			this(boc, null);
		}

		public SegmentData(final BusinessObjectContext boc, final List<DiagramElement> ownedSegments) {
			this.boc = boc;
			this.ownedSegments = ownedSegments;
		}

		public BusinessObjectContext getBoc() {
			return boc;
		}

		public List<DiagramElement> getOwnedSegments() {
			return ownedSegments;
		}
	}

	public static Composite createFlowComposite(final Composite parent) {
		final ScrolledComposite scrollComposite = new ScrolledComposite(parent, SWT.V_SCROLL | SWT.BORDER);
		final Composite flowComposite = new Composite(scrollComposite, SWT.NONE);
		final RowLayout flowCompLayout = RowLayoutFactory.fillDefaults().type(SWT.HORIZONTAL).create();
		flowCompLayout.center = true;
		flowComposite.setLayout(flowCompLayout);

		scrollComposite.setAlwaysShowScrollBars(false);
		scrollComposite.setLayoutData(new GridData(GridData.FILL_BOTH));
		scrollComposite.setContent(flowComposite);
		scrollComposite.setExpandVertical(true);
		scrollComposite.setExpandHorizontal(true);

		flowComposite.addPaintListener(e -> {
			// Compute size to show vertical scroll
			final Rectangle r = scrollComposite.getClientArea();
			scrollComposite.setMinSize(flowComposite.computeSize(r.width, SWT.DEFAULT));
		});

		return flowComposite;
	}
}
