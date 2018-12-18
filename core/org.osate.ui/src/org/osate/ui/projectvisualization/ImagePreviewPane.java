/*******************************************************************************
 * Copyright 2005, 2009 CHISEL Group, University of Victoria, Victoria, BC,
 * Canada. All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: The Chisel Group, University of Victoria IBM CAS, IBM Toronto
 * Lab
 ******************************************************************************/
package org.osate.ui.projectvisualization;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.ScrollBar;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;


/**
 * An image preview pane to show a preview of the screenshot and allow the user to save
 * the image to a file.
 */
public class ImagePreviewPane extends Dialog {

	private Shell shell; 
	private Point size;
	private Image image;
	
	public ImagePreviewPane(Shell parent) {
		super(parent);
	}
	

	private void createImagePreviewPane() {
		
		shell.setLayout(new GridLayout());
		
		ToolBar toolBar = new ToolBar(shell, SWT.NONE);
		GridData data = new GridData(SWT.FILL, SWT.FILL, true, false);
		toolBar.setLayoutData(data);
		
		ToolItem saveItem = new ToolItem(toolBar, SWT.NONE);
		saveItem.setImage(PDEVizImages.get(PDEVizImages.IMG_SAVEEDIT));
		saveItem.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {
				FileDialog dialog = new FileDialog (shell, SWT.SAVE);
				dialog.setFilterNames (new String [] {"Image Files", "All Files (*.*)"});
				dialog.setFilterExtensions (new String [] {"*.png", "*.*"}); //Windows wild cards
				//dialog.setFilterPath ("c:\\"); //Windows path
				dialog.setFileName ("dependencies.png");
				String fileName = dialog.open();
				ImageLoader loader = new ImageLoader();
				loader.data = new ImageData[] {image.getImageData()};
				loader.save(fileName, SWT.IMAGE_PNG);
			}
			
		});
		
		final Canvas canvas = new Canvas(shell, SWT.BORDER | SWT.NO_BACKGROUND | SWT.NO_REDRAW_RESIZE | SWT.V_SCROLL | SWT.H_SCROLL);
		
		data = new GridData(SWT.FILL, SWT.FILL, true, true);
		canvas.setLayoutData(data);
		canvas.setBackground(canvas.getDisplay().getSystemColor(SWT.COLOR_WHITE));
		
		final Point origin = new Point (0, 0);
		canvas.setBounds(10, 10, size.x + 10, size.y + 10);
		
		final ScrollBar hBar = canvas.getHorizontalBar ();
		hBar.addListener (SWT.Selection, new Listener () {
			public void handleEvent (Event e) {
				int hSelection = hBar.getSelection ();
				int destX = -hSelection - origin.x;
				Rectangle rect = image.getBounds ();
				canvas.scroll (destX, 0, 0, 0, rect.width, rect.height, false);
				origin.x = -hSelection;
			}
		});
		
		final ScrollBar vBar = canvas.getVerticalBar ();
		vBar.addListener (SWT.Selection, new Listener () {
			public void handleEvent (Event e) {
				int vSelection = vBar.getSelection ();
				int destY = -vSelection - origin.y;
				Rectangle rect = image.getBounds ();
				canvas.scroll (0, destY, 0, 0, rect.width, rect.height, false);
				origin.y = -vSelection;
			}
		});
		canvas.addListener (SWT.Resize,  new Listener () {
			public void handleEvent (Event e) {
				Rectangle rect = image.getBounds ();
				Rectangle client = canvas.getClientArea ();
				hBar.setMaximum (rect.width);
				vBar.setMaximum (rect.height);
				hBar.setThumb (Math.min (rect.width, client.width));
				vBar.setThumb (Math.min (rect.height, client.height));
				int hPage = rect.width - client.width;
				int vPage = rect.height - client.height;
				int hSelection = hBar.getSelection ();
				int vSelection = vBar.getSelection ();
				if (hSelection >= hPage) {
					if (hPage <= 0) {
						hSelection = 0;
					}
					origin.x = -hSelection;
				}
				if (vSelection >= vPage) {
					if (vPage <= 0) {
						vSelection = 0;
					}
					origin.y = -vSelection;
				}
				canvas.redraw ();
			}
		});
		canvas.addListener (SWT.Paint, new Listener () {
			public void handleEvent (Event e) {
				GC gc = e.gc;
				gc.drawImage (image, origin.x, origin.y);
				Rectangle rect = image.getBounds ();
				Rectangle client = canvas.getClientArea ();
				int marginWidth = client.width - rect.width;
				if (marginWidth > 0) {
					gc.fillRectangle (rect.width, 0, marginWidth, client.height);
				}
				int marginHeight = client.height - rect.height;
				if (marginHeight > 0) {
					gc.fillRectangle (0, rect.height, client.width, marginHeight);
				}
			}
		});
	}
	
	private void freeResources() {
		image.dispose();
	}
	
	
	public void open (Image image, Point size) {
 		Shell parent = getParent();
 		shell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL | SWT.RESIZE | SWT.MAX);
 		shell.setText(getText());
 		shell.setImage(PDEVizImages.get(PDEVizImages.IMG_REQ_PLUGIN_OBJ));
 		
 		
 		
 		this.image = image;
 		this.size = size;
 		
 		createImagePreviewPane();
		shell.addListener(SWT.Close, new Listener() {
			public void handleEvent(Event e) {
				ImagePreviewPane.this.freeResources();
			}
		});	
 		shell.open();
 		shell.setSize(800, 600);
 		Display display = parent.getDisplay();
 		while (!shell.isDisposed()) {
 			if (!display.readAndDispatch()) {
				display.sleep();
			}
 		}
	 }

}
