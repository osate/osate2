package org.osate.ui.dialogs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;
import org.osate.ui.OsateUiPlugin;
import org.osate.ui.rerun.Runner;

/**
 * @since 6.0
 */
public final class AnalysisRunsDialog extends Dialog {
	private static final int BORDER = 5;

	private static final int RUN_ID = 100;
	private static final String RUN_LABEL = "Run";

	private static final Point minimumPageSize = new Point(300, 300);

	/* Taken from PreferenceDialog */
	private class PageLayout extends Layout {
		@Override
		public Point computeSize(Composite composite, int wHint, int hHint, boolean force) {
			if (wHint != SWT.DEFAULT && hHint != SWT.DEFAULT) {
				return new Point(wHint, hHint);
			}
			int x = minimumPageSize.x;
			int y = minimumPageSize.y;
			Control[] children = composite.getChildren();
			for (Control element : children) {
				Point size = element.computeSize(SWT.DEFAULT, SWT.DEFAULT, force);
				x = Math.max(x, size.x);
				y = Math.max(y, size.y);
			}

//			// As pages can implement thier own computeSize
//			// take it into account
//			if (currentPage != null) {
//				Point size = currentPage.computeSize();
//				x = Math.max(x, size.x);
//				y = Math.max(y, size.y);
//			}

			if (wHint != SWT.DEFAULT) {
				x = wHint;
			}
			if (hHint != SWT.DEFAULT) {
				y = hHint;
			}
			return new Point(x, y);
		}

		@Override
		public void layout(Composite composite, boolean force) {
			Rectangle rect = composite.getClientArea();
			Control[] children = composite.getChildren();
			for (Control element : children) {
				element.setSize(rect.width, rect.height);
			}
		}
	}

	private final class MyLabelProvider extends ColumnLabelProvider {
		@Override
		public String getText(final Object element) {
			return ((Runner) element).getName();
		}

		@Override
		public Image getImage(final Object element) {
			final ImageDescriptor id = ((Runner) element).getImageDescriptor();
			if (id == null) {
				return null;
			} else {
				if (!images.containsKey(id)) {
					final Image i = id.createImage();
					images.put(id, i);
					return i;
				} else {
					return images.get(id);
				}
			}
		}
	}

	private final List<Runner> runners;
	private final Map<ImageDescriptor, Image> images = new HashMap<>();

	private Text uriText;
	private TableViewer analysisListView;
	private ScrolledComposite scrolled;
	private Composite pageContainer;

	public AnalysisRunsDialog(final Shell shell) {
		super(shell);
		setShellStyle(getShellStyle() | SWT.RESIZE);
		runners = OsateUiPlugin.getRerunManager().getPastRuns();
	}


	@Override
	protected void createButtonsForButtonBar(final Composite parent) {
		createButton(parent, RUN_ID, RUN_LABEL, false);
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
	}

	@Override
	protected Control createDialogArea(final Composite parent) {
		final Composite composite = (Composite) super.createDialogArea(parent);
		composite.setLayout(new FormLayout());

		analysisListView = new TableViewer(composite, SWT.BORDER | SWT.V_SCROLL);
		final Table table = analysisListView.getTable();
		table.setHeaderVisible(false);
		table.setLinesVisible(false);

		final TableViewerColumn col1 = new TableViewerColumn(analysisListView, SWT.NONE);
//		col1.getColumn().setWidth(225);
		col1.setLabelProvider(new MyLabelProvider());
		analysisListView.setContentProvider(ArrayContentProvider.getInstance());
		analysisListView.setInput(runners);

		final Label uriLabel = new Label(composite, SWT.LEFT);
		uriLabel.setText("Model URI:");

		uriText = new Text(composite, SWT.SINGLE | SWT.READ_ONLY);
		uriText.setText("blah blah blah blah");

		final Composite outerPageContainer = new Composite(composite, SWT.NONE);
		createPageContainer(outerPageContainer);

		FormData data = new FormData();
		data.top = new FormAttachment(0, BORDER);
		data.bottom = new FormAttachment(100, -BORDER);
		data.left = new FormAttachment(0, BORDER);
		data.right = new FormAttachment(30);
		analysisListView.getControl().setLayoutData(data);

		data = new FormData();
		data.top = new FormAttachment(0, BORDER);
		data.left = new FormAttachment(analysisListView.getControl(), BORDER);
		uriLabel.setLayoutData(data);

		data = new FormData();
		data.top = new FormAttachment(0, BORDER);
		data.left = new FormAttachment(uriLabel);
		data.right = new FormAttachment(100, -BORDER);
		uriText.setLayoutData(data);

		data = new FormData();
		data.left = new FormAttachment(analysisListView.getControl(), BORDER);
		data.right = new FormAttachment(100, -BORDER);
		data.top = new FormAttachment(uriLabel, BORDER);
		data.bottom = new FormAttachment(100, -BORDER);
		outerPageContainer.setLayoutData(data);

		return composite;
	}

	/* This is taken from PreferenceDialog.createPageContainer() */
	private void createPageContainer(final Composite parent) {
		// Create an outer composite for spacing
		scrolled = new ScrolledComposite(parent, SWT.V_SCROLL | SWT.H_SCROLL);

		// always show the focus control
		scrolled.setShowFocusedControl(true);
		scrolled.setExpandHorizontal(true);
		scrolled.setExpandVertical(true);

		final GridData scrolledData = new GridData(
				GridData.FILL_BOTH | GridData.GRAB_HORIZONTAL | GridData.GRAB_VERTICAL);
		scrolled.setLayoutData(scrolledData);

		pageContainer = new Composite(scrolled, SWT.NONE);
		final GridData pageContainerData = new GridData(
				GridData.FILL_BOTH | GridData.GRAB_HORIZONTAL | GridData.GRAB_VERTICAL);
		pageContainer.setLayout(new PageLayout());
		pageContainer.setLayoutData(pageContainerData);

		scrolled.setContent(pageContainer);
	}

	@Override
	public boolean close() {
		// dispose all images
		for (final Image image : images.values()) {
			image.dispose();
		}
		return super.close();
	}
}
