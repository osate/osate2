/**
 * Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.ge.internal.ui.handlers;

import java.awt.image.BufferedImage;
import java.awt.image.DirectColorModel;
import java.util.Objects;
import java.util.Optional;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.PaletteData;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.printing.PrintDialog;
import org.eclipse.swt.printing.Printer;
import org.eclipse.swt.printing.PrinterData;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.osate.ge.graphics.Dimension;
import org.osate.ge.internal.services.InternalDiagramExportService;
import org.osate.ge.internal.ui.editor.InternalDiagramEditor;
import org.osate.ge.services.DiagramExportService;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

public class PrintDiagramHandler extends AbstractHandler {
	private final static int IMAGE_PADDING = 10;

	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		final IEditorPart activeEditor = HandlerUtil.getActiveEditor(event);
		if (!(activeEditor instanceof InternalDiagramEditor)) {
			throw new RuntimeException("Unexpected editor: " + activeEditor);
		}

		final InternalDiagramEditor editor = (InternalDiagramEditor) activeEditor;
		// Choose printer dialog
		final PrintDialog dialog = new PrintDialog(Display.getDefault().getActiveShell(), SWT.NULL);
		final PrinterData printerData = dialog.open();

		final InternalDiagramExportService diagramExportService = getDiagramExportService().orElseThrow();
		// Get original diagram dimensions
		final Dimension dim = diagramExportService.getDimensions(editor, editor.getDiagram());
		final Printer printer = new Printer(printerData);
		try {
			final Rectangle clientArea = printer.getClientArea();
			final double scale = Math.min((clientArea.width - IMAGE_PADDING * 2) / dim.width,
					(clientArea.height - IMAGE_PADDING * 2) / dim.height);
			final BufferedImage bufferedImage = diagramExportService.export(editor, editor.getDiagram(), scale);
			final ImageData imageData = convertToImageData(bufferedImage);
			final Rectangle trim = printer.computeTrim(0, 0, 0, 0);
			if (printer.startJob("OSATE: '" + editor.getTitle() + "'")) {
				if (printer.startPage()) {
					final GC gc = new GC(printer);
					final Image printerImage = new Image(printer, imageData);
					// Draw image
					gc.drawImage(printerImage, 0, 0, imageData.width, imageData.height, -trim.x, -trim.y,
							imageData.width, imageData.height);
					// Cleanup
					printerImage.dispose();
					gc.dispose();
					printer.endPage();
				}
			} else {
				throw new RuntimeException("Print job could not be started.");
			}
		} catch (final Exception e) {
			throw new RuntimeException("Cannot print diagram: '" + e.getMessage() + "'.");
		} finally {
			// End the job and dispose the printer
			printer.endJob();
			printer.dispose();
		}

		return null;
	}

	public ImageData convertToImageData(final BufferedImage bufferedImage) {
		if (bufferedImage.getColorModel() instanceof DirectColorModel) {
			final ImageHelper imageHelper = new ImageHelper(bufferedImage);
			imageHelper.createImagePadding();
			imageHelper.createImage();
			return imageHelper.getImageData();
		}

		throw new RuntimeException("Unsupported color model: '" + bufferedImage.getColorModel() + "'.");
	}

	private class ImageHelper {
		private final PaletteData palette;
		private final ImageData imageData;
		private final BufferedImage bufferedImage;
		private final int paddedWidth;
		private final int paddedHeight;

		public ImageHelper(final BufferedImage bufferedImage) {
			this.bufferedImage = Objects.requireNonNull(bufferedImage, "bufferedImage must not be null");
			final DirectColorModel colorModel = (DirectColorModel) bufferedImage.getColorModel();
			this.palette = new PaletteData(colorModel.getRedMask(), colorModel.getGreenMask(),
					colorModel.getBlueMask());
			this.imageData = new ImageData(bufferedImage.getWidth() + IMAGE_PADDING * 2,
					bufferedImage.getHeight() + IMAGE_PADDING * 2, colorModel.getPixelSize(), palette);
			this.paddedWidth = bufferedImage.getWidth() + IMAGE_PADDING;
			this.paddedHeight = bufferedImage.getHeight() + IMAGE_PADDING;
		}

		public ImageData getImageData() {
			return imageData;
		}

		public void createImage() {
			int bufferedImageY = 0;
			for (int imageDataY = IMAGE_PADDING; imageDataY < paddedHeight; imageDataY++) {
				int bufferedImageX = 0;
				for (int imageDataX = IMAGE_PADDING; imageDataX < paddedWidth; imageDataX++) {
					final int rgb = bufferedImage.getRGB(bufferedImageX++, bufferedImageY);
					setPixel(imageDataX, imageDataY, new RGB((rgb >> 16) & 0xFF, (rgb >> 8) & 0xFF, rgb & 0xFF));
				}
				bufferedImageY++;
			}
		}

		public void createImagePadding() {
			final RGB white = new RGB(255, 255, 255);
			// Top border
			for (int y = 0; y < IMAGE_PADDING; y++) {
				for (int x = IMAGE_PADDING; x < paddedWidth; x++) {
					setPixel(x, y, white);
				}
			}

			// Right border
			for (int x = paddedWidth; x < paddedWidth + IMAGE_PADDING; x++) {
				for (int y = 0; y < paddedHeight + IMAGE_PADDING; y++) {
					setPixel(x, y, white);
				}
			}

			// Bottom border
			for (int y = paddedHeight; y < paddedHeight + IMAGE_PADDING; y++) {
				for (int x = IMAGE_PADDING; x < paddedWidth + IMAGE_PADDING; x++) {
					setPixel(x, y, white);
				}
			}

			// Left border
			for (int x = 0; x < IMAGE_PADDING; x++) {
				for (int y = 0; y < paddedHeight + IMAGE_PADDING; y++) {
					setPixel(x, y, white);
				}
			}
		}

		private void setPixel(final int x, final int y, final RGB rgb) {
			final int pixel = palette.getPixel(rgb);
			imageData.setPixel(x, y, pixel);
		}
	}

	private Optional<InternalDiagramExportService> getDiagramExportService() {
		final Bundle bundle = FrameworkUtil.getBundle(getClass());
		return Optional
				.ofNullable(EclipseContextFactory.getServiceContext(bundle.getBundleContext())
						.get(DiagramExportService.class))
				.filter(InternalDiagramExportService.class::isInstance)
				.map(InternalDiagramExportService.class::cast);
	}
}
