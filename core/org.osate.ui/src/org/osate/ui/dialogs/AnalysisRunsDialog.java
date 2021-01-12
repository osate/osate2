package org.osate.ui.dialogs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.util.SafeRunnable;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
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
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.ui.OsateUiPlugin;
import org.osate.ui.rerun.RerunManager;
import org.osate.ui.rerun.Runner;

/**
 * @since 6.0
 */
public final class AnalysisRunsDialog extends Dialog {
	private static final int BORDER = 5;

	private static final int RUN_ID = 100;
	private static final String RUN_LABEL = "Run";
	private static final int DELETE_ID = 101;
	private static final String DELETE_LABEL = "Remove";

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

	private final RerunManager rerunManager;
	private final List<Runner> runners;
	private final Map<ImageDescriptor, Image> images = new HashMap<>();
	private final Map<Runner, Control> runnerToControl = new HashMap<>();
	private Runner lastRunner = null;

	private Text uriText;
	private TableViewer analysisListView;
	private ScrolledComposite scrolled;
	private Composite pageContainer;

	public AnalysisRunsDialog(final Shell shell) {
		super(shell);
		setShellStyle(getShellStyle() | SWT.RESIZE);
		rerunManager = OsateUiPlugin.getRerunManager();
		runners = rerunManager.getPastRuns(new ArrayList<>());
	}


	@Override
	protected void createButtonsForButtonBar(final Composite parent) {
		createButton(parent, RUN_ID, RUN_LABEL, false);
		createButton(parent, DELETE_ID, DELETE_LABEL, false);
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
		analysisListView.addSelectionChangedListener(event -> {
			final IStructuredSelection selection = (IStructuredSelection) event.getSelection();
			if (!selection.isEmpty()) {
				final Runner runner = (Runner) selection.getFirstElement();
				showRunner(runner);
			}
		});

		final TableViewerColumn col1 = new TableViewerColumn(analysisListView, SWT.NONE);
		col1.getColumn().setWidth(175);
		col1.setLabelProvider(new MyLabelProvider());
		analysisListView.setContentProvider(ArrayContentProvider.getInstance());
		analysisListView.setInput(runners);

		final Label uriLabel = new Label(composite, SWT.LEFT);
		uriLabel.setText("Model:");

		uriText = new Text(composite, SWT.SINGLE | SWT.READ_ONLY);

		final Composite outerPageContainer = new Composite(composite, SWT.NONE);
		createPageContainer(outerPageContainer);
		final GridLayout gl = new GridLayout();
		gl.marginWidth = 0;
		gl.marginHeight = 0;
		outerPageContainer.setLayout(gl);
		outerPageContainer.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_CYAN));

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

		// Select the first runner record
		if (!runners.isEmpty()) {
			analysisListView.setSelection(new StructuredSelection(runners.get(0)));
		}

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
		scrolled.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_RED));

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

	/* inspired by PreferenceDialog.showPage() */
	private void showRunner(final Runner runner) {
		final IPath ipath = OsateResourceUtil.toIFile(runner.getInstanceURI()).getFullPath();
		uriText.setText(ipath.toString());

		final Control[] result = { runnerToControl.get(runner) };
		if (result[0] == null) {
			final boolean[] failed = { false };
			SafeRunnable.run(new ISafeRunnable() {
				@Override
				public void handleException(Throwable e) {
					failed[0] = true;
				}

				@Override
				public void run() {
					result[0] = runner.createContents(pageContainer);
				}
			});
			if (failed[0]) {
				// Couldn't create the components, silently fail
				return;
			}
			runnerToControl.put(runner, result[0]);
		}
		final Control currentControl = result[0];

		/* Resize */
		final Point[] size = new Point[1];
		final Point failed = new Point(-1, -1);
		SafeRunnable.run(new ISafeRunnable() {
			@Override
			public void handleException(Throwable e) {
				size[0] = failed;
			}

			@Override
			public void run() {
				size[0] = currentControl.computeSize(SWT.DEFAULT, SWT.DEFAULT, true);
			}
		});
		if (size[0].equals(failed)) {
			// Failed, do nothing
			return;
		}
		final Point contentSize = size[0];

		// Do we need resizing. Computation not needed if the
		// first page is inserted since computing the dialog's
		// size is done by calling dialog.open().
		// Also prevent auto resize if the user has manually resized
		final Point shellSize = getShell().getSize();
		if (lastRunner != null) {
			final Rectangle rect = pageContainer.getClientArea();
			final Point containerSize = new Point(rect.width, rect.height);
			int hdiff = contentSize.x - containerSize.x;
			int vdiff = contentSize.y - containerSize.y;
			if ((hdiff > 0 || vdiff > 0)) {
				hdiff = Math.max(0, hdiff);
				vdiff = Math.max(0, vdiff);
				setShellSize(shellSize.x + hdiff, shellSize.y + vdiff);
				if (currentControl.getSize().x == 0) {
					currentControl.setSize(containerSize);
				}

			} else {
				currentControl.setSize(containerSize);
			}
		}
		lastRunner = runner;

		scrolled.setMinSize(contentSize);

		/*
		 * Ensure that all other pages are invisible.
		 * (including ones that triggered an exception during
		 * their creation).
		 */
		final Control[] children = pageContainer.getChildren();
		for (final Control element : children) {
			if (element != currentControl) {
				element.setVisible(false);
			}
		}
		// Make the new page visible
		currentControl.setVisible(true);
	}

	/* From PreferenceDialong */
	private void setShellSize(int width, int height) {
		final Shell shell = getShell();
		final Rectangle preferred = shell.getBounds();
		preferred.width = width;
		preferred.height = height;
		shell.setBounds(getConstrainedShellBounds(preferred));
	}

	@Override
	public boolean close() {
		// dispose all images
		for (final Image image : images.values()) {
			image.dispose();
		}
		return super.close();
	}

	@Override
	protected void buttonPressed(final int buttonId) {
		if (buttonId == DELETE_ID) {
			deletePressed();
		} else {
			super.buttonPressed(buttonId);
		}
	}

	private void deletePressed() {
		final IStructuredSelection selection = (IStructuredSelection) analysisListView.getSelection();
		// weed out nonsense cases (shouldn't happen)
		if (selection.size() == 1) {
			final Runner current = (Runner) selection.getFirstElement();
			runners.remove(current);
			rerunManager.remove(current);
			analysisListView.refresh();
		}
	}
}
