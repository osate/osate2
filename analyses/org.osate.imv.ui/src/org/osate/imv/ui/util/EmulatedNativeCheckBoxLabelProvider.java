/************************************************************************************
 * Copyright (c) 2012 Brandon Breuil. Contributions by Peter Feiler.                                               *
 *                                                                                  *
 * All rights reserved. This program and the accompanying materials are made        *
 * available under the terms of the Eclipse Public License v1.0 which accompanies   *
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html *
 *                                                                                  *
 * Use is subject to the terms of Eclipse Public License v1.0.                      *
 *                                                                                  *
 ************************************************************************************/

package org.osate.imv.ui.util;

import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

public abstract class EmulatedNativeCheckBoxLabelProvider extends
    ColumnLabelProvider {
  private static final String CHECKED_KEY = "CHECKED";
  private static final String UNCHECK_KEY = "UNCHECKED";

  public EmulatedNativeCheckBoxLabelProvider(ColumnViewer viewer) {
    if (JFaceResources.getImageRegistry().getDescriptor(CHECKED_KEY) == null) {
      JFaceResources.getImageRegistry().put(UNCHECK_KEY,
          makeShot(viewer.getControl(), false));
      JFaceResources.getImageRegistry().put(CHECKED_KEY,
          makeShot(viewer.getControl(), true));
    }
  }

  private Image makeShot(Control control, boolean type)
  {
    // Hopefully no platform uses exactly this color because we'll make
    // it transparent in the image.
    Color greenScreen = new Color(control.getDisplay(), 222, 223, 224);

    Shell shell = new Shell(control.getShell(), SWT.NO_TRIM);

    // otherwise we have a default gray color
    shell.setBackground(greenScreen);

    Button button = new Button(shell, SWT.CHECK);
    button.setBackground(greenScreen);
    button.setSelection(type);

    // otherwise an image is located in a corner
    button.setLocation(1, 1);
    Point bsize = button.computeSize(SWT.DEFAULT, SWT.DEFAULT);

    // otherwise an image is stretched by width
    bsize.x = Math.max(bsize.x - 1, bsize.y - 1);
    bsize.y = Math.max(bsize.x - 1, bsize.y - 1);
    button.setSize(bsize);
    shell.setSize(bsize);

    shell.open();
    GC gc = new GC(shell);
    Image image = new Image(control.getDisplay(), bsize.x, bsize.y);
    gc.copyArea(image, 0, 0);
    gc.dispose();
    shell.close();

    ImageData imageData = image.getImageData();
    imageData.transparentPixel = imageData.palette.getPixel(greenScreen
        .getRGB());

    return new Image(control.getDisplay(), imageData);
  }

  public Image getImage(Object element) {
    if (isChecked(element)) {
      return JFaceResources.getImageRegistry().get(CHECKED_KEY);
    } else {
      return JFaceResources.getImageRegistry().get(UNCHECK_KEY);
    }
  }

  protected abstract boolean isChecked(Object element);
}
