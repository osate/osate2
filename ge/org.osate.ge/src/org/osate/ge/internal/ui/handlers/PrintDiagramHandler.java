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
import java.util.Optional;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.PaletteData;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.printing.PrintDialog;
import org.eclipse.swt.printing.Printer;
import org.eclipse.swt.printing.PrinterData;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.statushandlers.StatusManager;
import org.osate.ge.graphics.Dimension;
import org.osate.ge.internal.services.InternalDiagramExportService;
import org.osate.ge.internal.ui.editor.InternalDiagramEditor;
import org.osate.ge.services.DiagramExportService;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

/**
 * Handler for the print diagram command
 */
public class PrintDiagramHandler extends AbstractHandler {
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
		if (printerData == null) {
			return null;
		}

		try {
			final InternalDiagramExportService diagramExportService = getDiagramExportService().orElseThrow();

			// Get unscaled diagram dimensions
			final Dimension dim = diagramExportService.getDimensions(editor, editor.getDiagram());
			final Printer printer = new Printer(printerData);

			try {
				final Rectangle clientArea = printer.getClientArea();
				final double scale = Math.min(clientArea.width / dim.width, clientArea.height / dim.height);
				final BufferedImage bufferedImage = diagramExportService.export(editor, editor.getDiagram(), scale);
				final ImageData imageData = convertToImageData(bufferedImage);
				if (!printer.startJob("OSATE: '" + editor.getTitle() + "'")) {
					throw new RuntimeException("Print job could not be started.");
				}

				try {
					if (printer.startPage()) {
						final GC gc = new GC(printer);
						gc.setAntialias(SWT.ON);
						gc.setInterpolation(SWT.HIGH);
						try {
							final Image printerImage = new Image(printer, imageData);
							try {
								gc.drawImage(printerImage, clientArea.x, clientArea.y);
							} finally {
								printerImage.dispose();
							}
						} finally {
							gc.dispose();
							printer.endPage();
						}
					}

					// End the job
					printer.endJob();
				} catch (final RuntimeException ex) {
					printer.cancelJob();
					throw ex;
				}
			} finally {
				printer.dispose();
			}
		} catch (final Exception ex) {
			final Status status = new Status(IStatus.ERROR, FrameworkUtil.getBundle(getClass()).getSymbolicName(),
					"Error Printing Diagram", ex);
			StatusManager.getManager().handle(status, StatusManager.LOG | StatusManager.SHOW);
		}

		return null;
	}

	private static ImageData convertToImageData(final BufferedImage bufferedImage) {
		final ImageData imageData = new ImageData(bufferedImage.getWidth(), bufferedImage.getHeight(), 24,
				new PaletteData(0xFF0000, 0x00FF00, 0x0000FF));
		for (int y = 0; y < bufferedImage.getHeight(); y++) {
			for (int x = 0; x < bufferedImage.getWidth(); x++) {
				final int rgb = bufferedImage.getRGB(x, y);
				imageData.setPixel(x, y, rgb);
			}
		}

		return imageData;
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
