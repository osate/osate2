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
package org.osate.ge.internal.graphiti;

import org.eclipse.core.runtime.IPath;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.graphiti.platform.ga.IGraphicsAlgorithmRenderer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.widgets.Display;
import org.osate.ge.internal.util.ImageHelper;

public class ImageFigure extends RectangleFigure
implements IGraphicsAlgorithmRenderer {
	private final Image image;

	public ImageFigure(final IPath imagePath) {
		this.image = ImageHelper.findImage(imagePath);
	}

	@Override
	protected void fillShape(final Graphics g) {
		if (image != null && !image.isDisposed()) {
			super.fillShape(g);
			g.setAntialias(SWT.ON);
			g.setInterpolation(SWT.HIGH);

			// Get image data
			final ImageData originalImageData = image.getImageData();
			final int imageWidth = originalImageData.width;
			final int imageHeight = originalImageData.height;
			final double imageAspectRatio = imageWidth / (double) imageHeight;

			// Scaling
			final Rectangle bounds = getBounds();
			final double figureAspectRatio = bounds.preciseWidth() / bounds.preciseHeight();

			// Find dimension used to make proportional image
			final int scaledWidth;
			final int scaledHeight;
			if (imageAspectRatio > figureAspectRatio) {
				// Image will be centered vertically
				scaledWidth = (int) bounds.width;
				scaledHeight = (int) (bounds.width / imageAspectRatio);
			} else {
				// Image will be centered horizontally
				scaledWidth = (int) (bounds.height * imageAspectRatio);
				scaledHeight = (int) bounds.height;
			}

			final Point imagePoint = new Point(bounds.x() + (bounds.width - scaledWidth) / 2,
					bounds.y() + (bounds.height - scaledHeight) / 2);

			// Draw scaled image
			g.drawImage(image, 0, 0, imageWidth, imageHeight, imagePoint.x(), imagePoint.y(),
					scaledWidth, scaledHeight);
		} else {
			// Fill shape white
			g.setBackgroundColor(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
			super.fillShape(g);

			// Draw a red dashed X through the element symbolizing an error
			g.setForegroundColor(Display.getDefault().getSystemColor(SWT.COLOR_RED));
			g.setLineWidth(5);
			g.setLineStyle(Graphics.LINE_DASH);
			final Rectangle bounds = getBounds();
			final int borderIndent = 5;
			// Get points to draw image error lines
			final int x = bounds.x + borderIndent;
			final int y = bounds.y + borderIndent;
			final int width = bounds.x + bounds.width - borderIndent;
			final int height = bounds.y + bounds.height - borderIndent;
			g.drawLine(x, y, width, height);
			g.drawLine(width, y, x, height);
		}
	}

	@Override
	protected void outlineShape(final Graphics g) {
		g.setLineWidth(8);
		// Draw outline
		super.outlineShape(g);
	}
}
