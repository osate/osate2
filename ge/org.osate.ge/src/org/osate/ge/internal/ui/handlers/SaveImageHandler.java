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

import java.io.FileOutputStream;
import java.util.Optional;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.statushandlers.StatusManager;
import org.osate.ge.graphics.Dimension;
import org.osate.ge.internal.diagram.runtime.DiagramElementPredicates;
import org.osate.ge.internal.diagram.runtime.DiagramNode;
import org.osate.ge.internal.services.InternalDiagramExportService;
import org.osate.ge.internal.ui.dialogs.ExportDiagramDialog;
import org.osate.ge.internal.ui.editor.InternalDiagramEditor;
import org.osate.ge.services.DiagramExportService;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

/**
 * Displays the export dialog and creates an image based on user selection
 */
public class SaveImageHandler extends AbstractHandler {
	@Override
	public void setEnabled(final Object evaluationContext) {
		final boolean enabled = calculateEnabled(evaluationContext);
		setBaseEnabled(enabled);
	}

	private boolean calculateEnabled(final Object evaluationContext) {
		final IEditorPart activeEditor = AgeHandlerUtil.getActiveEditorFromContext(evaluationContext);
		return Display.getCurrent().getActiveShell() != null && activeEditor instanceof InternalDiagramEditor
				&& getDiagramExportService().isPresent();
	}

	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		final IEditorPart activeEditor = HandlerUtil.getActiveEditor(event);
		if (!(activeEditor instanceof InternalDiagramEditor)) {
			throw new RuntimeException("Unexpected editor: " + activeEditor);
		}

		final InternalDiagramEditor editor = (InternalDiagramEditor) activeEditor;
		final InternalDiagramExportService diagramExportService = getDiagramExportService().orElseThrow();
		final DiagramNode selectionOnlyExportNode = editor.getSelectedDiagramElements()
				.stream()
				.findFirst()
				.filter(DiagramElementPredicates::isShape)
				.orElse(null);

		// Get the dimensions of the diagram and the current selection
		final Dimension diagramDimension = diagramExportService.getDimensions(editor, editor.getDiagram());
		final Dimension selectionDimension = selectionOnlyExportNode == null ? null
				: diagramExportService.getDimensions(editor, selectionOnlyExportNode);

		final Shell parentShell = Display.getCurrent().getActiveShell();

		// Display the export diagram dialog
		ExportDiagramDialog.open(parentShell, diagramDimension, selectionDimension).ifPresent(r -> {
			final FileDialog saveDialog = new FileDialog(parentShell, SWT.SAVE);
			saveDialog.setOverwrite(true);
			saveDialog.setFilterExtensions(new String[] { "*" + r.getFormat().getDotExtension() }); // TOOD; Based on format
			final String filepath = saveDialog.open();
			if (filepath != null) {
				// Export the image
				try (FileOutputStream s = new FileOutputStream(filepath, false)) {
					final DiagramNode exportNode = r.getAll() ? editor.getDiagram() : selectionOnlyExportNode;
					diagramExportService.export(editor, s, r.getFormat().getExporterFormat(), exportNode,
							r.getScaling());
				} catch (final Exception ex) {
					final Status status = new Status(IStatus.ERROR,
							FrameworkUtil.getBundle(getClass()).getSymbolicName(), "Error Exporting Diagram", ex);
					StatusManager.getManager().handle(status, StatusManager.LOG | StatusManager.SHOW);
				}
			}
		});

		return null;
	}

	private Optional<InternalDiagramExportService> getDiagramExportService() {
		final Bundle bundle = FrameworkUtil.getBundle(getClass());
		return Optional.ofNullable(
				EclipseContextFactory.getServiceContext(bundle.getBundleContext()).get(DiagramExportService.class))
				.filter(InternalDiagramExportService.class::isInstance)
				.map(InternalDiagramExportService.class::cast);
	}
}