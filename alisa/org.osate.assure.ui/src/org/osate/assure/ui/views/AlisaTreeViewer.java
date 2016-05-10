package org.osate.assure.ui.views;

import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ColumnViewerEditor;
import org.eclipse.jface.viewers.ColumnViewerEditorActivationEvent;
import org.eclipse.jface.viewers.ColumnViewerEditorActivationStrategy;
import org.eclipse.jface.viewers.ColumnViewerToolTipSupport;
import org.eclipse.jface.viewers.FocusCellOwnerDrawHighlighter;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.viewers.TreeViewerEditor;
import org.eclipse.jface.viewers.TreeViewerFocusCellManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Composite;
import org.osate.alisa.workbench.alisa.AssuranceCase;
import org.osate.alisa.workbench.alisa.AssurancePlan;

public class AlisaTreeViewer extends TreeViewer {

	public static final int COLUMN_NAME = 0;

	// Should be the max column index available
	public static final int COLUMN_INDEX_MAX = 0;

	public AlisaTreeViewer(Composite parent, int style) {
		super(parent, style);
		buildViewer();
		setUseHashlookup(true);
	}

	private void buildViewer() {
		// NEED this to activate tooltip
		ColumnViewerToolTipSupport.enableFor(this);

		setContentProvider(new AlisaTreeContentProvider());

		// Set up the table 3.3 version way with editors

		TreeViewerFocusCellManager focusCellManager = new TreeViewerFocusCellManager(this,
				new FocusCellOwnerDrawHighlighter(this));
		ColumnViewerEditorActivationStrategy actSupport = new ColumnViewerEditorActivationStrategy(this) {
			protected boolean isEditorActivationEvent(ColumnViewerEditorActivationEvent event) {
				return event.eventType == ColumnViewerEditorActivationEvent.TRAVERSAL
						|| event.eventType == ColumnViewerEditorActivationEvent.MOUSE_DOUBLE_CLICK_SELECTION
						|| (event.eventType == ColumnViewerEditorActivationEvent.KEY_PRESSED && event.keyCode == SWT.CR)
						|| event.eventType == ColumnViewerEditorActivationEvent.PROGRAMMATIC;
			}
		};

		TreeViewerEditor.create(this, focusCellManager, actSupport,
				ColumnViewerEditor.TABBING_HORIZONTAL | ColumnViewerEditor.TABBING_MOVE_TO_ROW_NEIGHBOR
						| ColumnViewerEditor.TABBING_VERTICAL | ColumnViewerEditor.KEYBOARD_ACTIVATION);

		// Making Columns adding sequence must be dynamic depending on the column index value
		for (int i = 0; i <= COLUMN_INDEX_MAX; i++) {
			// This depend on the sequence of enum
			// ColumnInfo columnSetting = ColumnInfo.values()[i];
			ColumnInfo columnSetting = null;
			for (ColumnInfo tempColumnSetting : ColumnInfo.values()) {
				if (tempColumnSetting.getColumnIndex() == i) {
					columnSetting = tempColumnSetting;
					break;
				}
			}

			if (columnSetting != null) {
				TreeViewerColumn viewerColumn = new TreeViewerColumn(this, SWT.NONE);

				if (columnSetting.getWidth() < 0) {
					// This is giving a bad size, so wont be using -1
					viewerColumn.getColumn().pack();
				} else {
					viewerColumn.getColumn().setWidth(columnSetting.getWidth());
				}
				viewerColumn.getColumn().setMoveable(false);
				viewerColumn.getColumn().setText(columnSetting.getString());
				viewerColumn.getColumn().setResizable(true);

				// viewerColumn.getColumn().addControlListener(new BusTreeColumnControl());
				// Setting the right sorter
				viewerColumn.getColumn().addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent e) {
						System.out.println("Column SelectionListener: widgetSelected");
					}
				});

				configureColumn(i, viewerColumn);
			}

		}

		// Turn on the header and the lines
		getTree().setHeaderVisible(true);
		getTree().setLinesVisible(true);
	}

	private void configureColumn(int columnIndex, final TreeViewerColumn column) {

		switch (columnIndex) {

		// AssureNameColumnLabelProvider
		case COLUMN_NAME:
//			column.setLabelProvider(new AssureNameColumnLabelProvider());
			column.setLabelProvider(new ColumnLabelProvider() {
				public String getText(Object element) {
					String text = "";
					if (element instanceof AssuranceCase) {
						text = getLabel(((AssuranceCase) element));
					} else if (element instanceof AssurancePlan) {
						text = getLabel(((AssurancePlan) element));
					}
					return text;
				}

				public Color getBackground(Object element) {
					return null;
				}

			});
			break;

		}

	}

	protected String getLabel(AssurancePlan assurancePlan) {
		return "Assurance Plan: " + assurancePlan.getName();
	}

	protected String getLabel(AssuranceCase assuranceCase) {
		return "Assurance Case: " + assuranceCase.getName();
	}

//	protected String getTypeLabel(VerificationResult element) {
//		return AssureUtilExtension.getMethod(element).getMethodKind().getClass().getName();
//	}
//
//	protected String getExecutionTimeLabel(Metrics metrics) {
//		if (metrics != null && metrics.getExecutionTime() > 0)
//			return String.valueOf(metrics.getExecutionTime());
//		else
//			return "";
//	}
//
//	protected String getLabel(EList<ResultIssue> issues) {
//		StringBuffer returnString = new StringBuffer();
//		for (Iterator iterator = issues.iterator(); iterator.hasNext();) {
//			ResultIssue resultIssue = (ResultIssue) iterator.next();
//			if (resultIssue.getMessage() != null) {
//				returnString.append(resultIssue.getMessage() + "\n");
//			}
//		}
//		return returnString.toString();
//	}
//
//	protected String getLabel(VerificationResultState resultState) {
//		return resultState.getLiteral();
//	}
//
//	protected String getLabel(VerificationExecutionState executionState) {
//		return executionState.getLiteral();
//	}

	public enum ColumnInfo {
		NAME("Name", COLUMN_NAME, SWT.LEFT, 500);

		private String stringRep;
		private int columnIndex;
		private int style;
		private int width;

		ColumnInfo(String stringRep, int columnIndex, int style, int width) {
			this.stringRep = stringRep;
			this.columnIndex = columnIndex;
			this.style = style;
			this.width = width;
		}

		public String getString() {
			return stringRep;
		}

		int getColumnIndex() {
			return columnIndex;
		}

		int getStyle() {
			return style;
		}

		int getWidth() {
			return width;
		}

	}
}
