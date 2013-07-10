/************************************************************************************
 * Copyright (c) 2012 Brandon Breuil. Contributions by Peter Feiler and J.Delange   *
 *                                                                                  *
 * All rights reserved. This program and the accompanying materials are made        *
 * available under the terms of the Eclipse Public License v1.0 which accompanies   *
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html *
 *                                                                                  *
 * Use is subject to the terms of Eclipse Public License v1.0.                      *
 *                                                                                  *
 ************************************************************************************/

package org.osate.imv.ui.editor;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Scale;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.osate.imv.aadldiagram.providers.IAadlAdapterProvider;
import org.osate.imv.aadldiagram.viewer.AadlPersistentDiagramViewer;
import org.osate.imv.providers.OsateAdapterProvider;
import org.osate.imv.ui.IImageKeys;
import org.osate.imv.ui.ImvUiPlugin;
import org.osate.imv.ui.util.GradientHelper;


public class ImvEditorToolbar extends Composite {

	private AadlPersistentDiagramViewer mevViewer;

	private Scale scaleSlider;

	private Label zoomLabel;

	public ImvEditorToolbar(Composite parent) {
		super(parent, SWT.NONE);
		createControl();
	}

	@Override
	public void dispose() {
		// Nothing to release.
		super.dispose();
	}

	public void setMevViewer(AadlPersistentDiagramViewer viewer) {
		this.mevViewer = viewer;
	}

	protected void createControl(){
		// We will use grid layout for this composite.
		GridLayout gridLayout = new GridLayout(2, false);
		gridLayout.marginHeight = 0;
		this.setLayout(gridLayout);

		// Apply gradient background.
		final Composite thisComposite = this;
		this.addListener(SWT.Resize,new Listener() {
			public void handleEvent(Event event) {
				GradientHelper.applyGradientBG(thisComposite);
			}
		});

		// Children widgets will inherit the gradient background of this composite.
		this.setBackgroundMode(SWT.INHERIT_DEFAULT);

		/* SWT Toolbar */
		createToolbar();

		/* Scale Slider Widget. */
		this.scaleSlider = createScaleSlider(); // Scale slider.
	}

	protected ToolBar createToolbar() {
		Composite container = new Composite(this, SWT.NONE);

		// Layout data.
		GridData gridLayoutData = new GridData(SWT.FILL, SWT.CENTER, true, true);
		container.setLayoutData(gridLayoutData);

		RowLayout rowLayout = new RowLayout(SWT.HORIZONTAL);
		rowLayout.marginTop = 0;
		rowLayout.marginBottom = 0;
		rowLayout.marginRight = 10;
		rowLayout.marginLeft = 10;
		rowLayout.spacing = 10;
		rowLayout.center = true;

		container.setLayout(rowLayout);

		ToolBar toolbar = new ToolBar(container, SWT.FLAT | SWT.WRAP);

		/* Add tool items to toolbar. */

		// Step into
		ToolItem itemStepIn = new ToolItem(toolbar, SWT.PUSH);
		itemStepIn.setImage(ImvUiPlugin.getDefault().getImageRegistry().get(IImageKeys.STEP_INTO_ICON));
		itemStepIn.setToolTipText("Step into component");
		itemStepIn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				mevViewer.stepInto();
			}
		});

		// Step out
		ToolItem itemStepOut = new ToolItem(toolbar, SWT.PUSH);
		itemStepOut.setImage(ImvUiPlugin.getDefault().getImageRegistry().get(IImageKeys.STEP_OUT_ICON));
		itemStepOut.setToolTipText("Step out of component");
		itemStepOut.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				mevViewer.stepOut();
			}
		});

		// Go to root.
		ToolItem goToRoot = new ToolItem(toolbar, SWT.PUSH);
		goToRoot.setImage(ImvUiPlugin.getDefault().getImageRegistry().get(IImageKeys.ARROW_STOP_ICON));
		goToRoot.setToolTipText("Goto to top level component");
		goToRoot.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				mevViewer.jumpToSystemInstance();
			}
		});

		// Separator.
		new ToolItem(toolbar, SWT.SEPARATOR);
		// Increase component nesting
		ToolItem itemIncreaseNesting = new ToolItem(toolbar, SWT.PUSH);
		itemIncreaseNesting.setImage(ImvUiPlugin.getDefault().getImageRegistry().get(IImageKeys.INCR_NESTING_ICON));
		itemIncreaseNesting.setToolTipText("Increase component nesting level");
		itemIncreaseNesting.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				mevViewer.incrementComponentNestingHandler();
			}
		});

		// Decrease component nesting
		ToolItem itemDecreaseNesting = new ToolItem(toolbar, SWT.PUSH);
		itemDecreaseNesting.setImage(ImvUiPlugin.getDefault().getImageRegistry().get(IImageKeys.DECR_NESTING_ICON));
		itemDecreaseNesting.setToolTipText("Decrease component nesting level");
		itemDecreaseNesting.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				mevViewer.decrementComponentNestingHandler();
			}
		});
// XXX TODO		
		// Separator.
		new ToolItem(toolbar, SWT.SEPARATOR);
		// direct connection in nested component view
		ToolItem directConnection = new ToolItem(toolbar, SWT.PUSH);
		directConnection.setImage(ImvUiPlugin.getDefault().getImageRegistry().get(IImageKeys.DIRECT_CONNECTION_ICON));
		directConnection.setToolTipText("Direct connections");
		directConnection.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				mevViewer.directConnectionHandler();
			}
		});

		// Hierarchical connection in nested component view
		ToolItem hierarchicalConnection = new ToolItem(toolbar, SWT.PUSH);
		hierarchicalConnection.setImage(ImvUiPlugin.getDefault().getImageRegistry().get(IImageKeys.HIERARCHICAL_CONNECTION_ICON));
		hierarchicalConnection.setToolTipText("Hierarchial connections");
		hierarchicalConnection.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				mevViewer.hierarchicalConnectionHandler();
			}
		});
		
		// Separator.
		new ToolItem(toolbar, SWT.SEPARATOR);
		// Show errors propagation
		ToolItem showErrorModel = new ToolItem(toolbar, SWT.PUSH);
		showErrorModel.setImage(ImvUiPlugin.getDefault().getImageRegistry().get(IImageKeys.SHOW_ERROR_ICON));
		showErrorModel.setToolTipText("Show errors");
		showErrorModel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				mevViewer.showErrors();
			}
		});
		ToolItem hideErrorModel = new ToolItem(toolbar, SWT.PUSH);
		hideErrorModel.setImage(ImvUiPlugin.getDefault().getImageRegistry().get(IImageKeys.HIDE_ERROR_ICON));
		hideErrorModel.setToolTipText("Hide errors");
		hideErrorModel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				mevViewer.hideErrors();
			}
		});
	

		// Separator.
		new ToolItem(toolbar, SWT.SEPARATOR);

		// Zoom out
		ToolItem itemZoomOut = new ToolItem(toolbar, SWT.PUSH);
		itemZoomOut.setImage(ImvUiPlugin.getDefault().getImageRegistry().get(IImageKeys.ZOOM_OUT_ICON));
		itemZoomOut.setToolTipText("Zoom out");
		itemZoomOut.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				decrementZoomHandler();
			}

		});

		// Zoom in
		ToolItem itemZoomIn = new ToolItem(toolbar, SWT.PUSH);
		itemZoomIn.setImage(ImvUiPlugin.getDefault().getImageRegistry().get(IImageKeys.ZOOM_IN_ICON));
		itemZoomIn.setToolTipText("Zoom in");
		itemZoomIn.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				incrementZoomHandler();
			}

		});

		// Separator.
		new ToolItem(toolbar, SWT.SEPARATOR);

		// Resize item.
		ToolItem resizeItem = new ToolItem(toolbar, SWT.PUSH);
		resizeItem.setImage(ImvUiPlugin.getDefault().getImageRegistry().get(IImageKeys.RESIZE_ICON));
		resizeItem.setToolTipText("Scale to fit diagram");
		resizeItem.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				scaleToFitHandler();
			}

		});

		// Auto-fit item.
		ToolItem autoFitItem = new ToolItem(toolbar, SWT.PUSH);
		autoFitItem.setImage(ImvUiPlugin.getDefault().getImageRegistry().get(IImageKeys.RESIZE_ACTUAL_ICON));
		autoFitItem.setToolTipText("Resize to fit diagram");
		autoFitItem.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				mevViewer.getAadlDiagram().resizeToFit();
			}

		});

		// Separator.
		new ToolItem(toolbar, SWT.SEPARATOR);

		// Auto-layout button
		ToolItem autoLayoutItem = new ToolItem(toolbar, SWT.PUSH);
		autoLayoutItem.setImage(ImvUiPlugin.getDefault().getImageRegistry().get(IImageKeys.AUTO_LAYOUT_ICON));
		autoLayoutItem.setToolTipText("Auto layout diagram");
		autoLayoutItem.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				performAutoLayout();
			}

		});

		toolbar.pack();

		return toolbar;
	}

	protected Scale createScaleSlider(){
		Composite container = new Composite(this, SWT.RIGHT_TO_LEFT);

		// Layout data.
		GridData gridLayoutData = new GridData(SWT.END, SWT.CENTER, true, true);
		container.setLayoutData(gridLayoutData);

		// We will use row layout to layout toolbar widgets.
		RowLayout rowLayout = new RowLayout(SWT.HORIZONTAL);
		rowLayout.marginTop = 1;
		rowLayout.marginBottom = 1;
		rowLayout.marginRight = 30;
		rowLayout.marginLeft = 10;
		rowLayout.spacing = 10;
		rowLayout.center = true;

		container.setLayout(rowLayout);

		// Create slider.
		final Scale slider = new Scale(container, SWT.HORIZONTAL | SWT.LEFT_TO_RIGHT); // Horizontal slider.
		slider.setMinimum(50);
		slider.setMaximum(200);
		slider.setIncrement(1);
		slider.setPageIncrement(10);
		slider.setSelection(100);
		slider.setSize(100, 18);

		// Layout data.
		RowData layoutData = new RowData(150, 18);
		slider.setLayoutData(layoutData);

		this.zoomLabel = new Label(container, SWT.NONE);
		updateZoomLevel();


		// Add listener.
		slider.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {
				int zoomLevel = slider.getSelection();
				if(mevViewer != null)
					mevViewer.getAadlDiagram().setScale(zoomLevel / 100.0f);

				updateZoomLevel();
			}

		});

		container.pack();

		return slider;
	}

	protected void scaleToFitHandler() {
		if(mevViewer != null) {
			mevViewer.getAadlDiagram().scaleToFit();
			updateZoomLevel();
		}
	}

	protected void incrementZoomHandler() {
		if(mevViewer != null) {
			mevViewer.getAadlDiagram().incrementScale();
			updateZoomLevel();
		}
	}

	protected void decrementZoomHandler() {
		if(mevViewer != null) {
			mevViewer.getAadlDiagram().decrementScale();
			updateZoomLevel();
		}
	}

	protected void updateZoomLevel() {
		int zoomLevel = 100;

		if(this.mevViewer != null)
			zoomLevel = (int)(this.mevViewer.getAadlDiagram().getScale() * 100);

		if(this.zoomLabel != null)
			this.zoomLabel.setText(zoomLevel + "%");

		if(this.scaleSlider != null)
			this.scaleSlider.setSelection(zoomLevel);
	}


	public Scale getScaleSlider() {
		return this.scaleSlider;
	}

	protected void performAutoLayout() {
		this.mevViewer.getAadlDiagram().performAutoLayout();
	}



}
