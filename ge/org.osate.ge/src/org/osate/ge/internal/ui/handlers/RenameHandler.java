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
package org.osate.ge.internal.ui.handlers;

import java.util.List;
import java.util.Objects;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.graphiti.features.IDirectEditingFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.impl.DirectEditingContext;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.graphiti.diagram.GraphitiAgeDiagram;
import org.osate.ge.internal.graphiti.features.BoHandlerDirectEditFeature;
import org.osate.ge.internal.ui.editor.AgeDiagramEditor;
import org.osate.ge.internal.ui.util.ContextHelpUtil;

public class RenameHandler extends AbstractHandler {
	@Override
	public void setEnabled(final Object evaluationContext) {
		final boolean enabled = calculateEnabled(evaluationContext);
		setBaseEnabled(enabled);
	}

	private boolean calculateEnabled(final Object evaluationContext) {
		final IEditorPart activeEditor = AgeHandlerUtil.getActiveEditorFromContext(evaluationContext);
		if (!(activeEditor instanceof AgeDiagramEditor)) {
			return false;
		}

		final AgeDiagramEditor ageEditor = (AgeDiagramEditor) activeEditor;
		final GraphitiAgeDiagram graphitiAgeDiagram = ageEditor.getGraphitiAgeDiagram();
		if (graphitiAgeDiagram == null) {
			return false;
		}

		final List<DiagramElement> selectedDiagramElements = AgeHandlerUtil
				.getSelectedDiagramElements();
		if (selectedDiagramElements.size() != 1) {
			return false;
		}

		final IFeatureProvider fp = ageEditor.getDiagramTypeProvider().getFeatureProvider();
		if (fp == null) {
			return false;
		}

		for (final DiagramElement de : selectedDiagramElements) {
			final PictogramElement pe = graphitiAgeDiagram.getPictogramElement(de);
			if (pe == null) {
				return false;
			}

			final DirectEditingContext directEditingContext = getDirectEditingContext(pe);
			final IDirectEditingFeature feature = fp.getDirectEditingFeature(directEditingContext);
			if (feature == null) {
				return false;
			}

			if (!feature.canDirectEdit(directEditingContext)) {
				return false;
			}
		}

		return true;
	}

	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		final IEditorPart activeEditor = HandlerUtil.getActiveEditor(event);
		if (!(activeEditor instanceof AgeDiagramEditor)) {
			throw new RuntimeException("Unexpected editor: " + activeEditor);
		}

		// Get diagram and selected elements
		final List<DiagramElement> selectedDiagramElements = AgeHandlerUtil.getSelectedDiagramElements();
		if (selectedDiagramElements.size() == 0) {
			throw new RuntimeException("No element selected");
		}

		final DiagramElement selectedElement = selectedDiagramElements.get(0);
		final AgeDiagramEditor ageEditor = (AgeDiagramEditor) activeEditor;
		final GraphitiAgeDiagram graphitiAgeDiagram = Objects.requireNonNull(ageEditor.getGraphitiAgeDiagram(),
				"Unable to retrieve graphiti diagram");

		final IFeatureProvider fp = Objects.requireNonNull(ageEditor.getDiagramTypeProvider().getFeatureProvider(),
				"Unable to retrieve feature provider");

		final PictogramElement pe = Objects.requireNonNull(graphitiAgeDiagram.getPictogramElement(selectedElement),
				"Unable to retrieve pictogram element");
		final DirectEditingContext directEditingContext = getDirectEditingContext(pe);
		final IDirectEditingFeature feature = Objects.requireNonNull(fp.getDirectEditingFeature(directEditingContext),
				"Unable to retrieve direct editing feature");

		if (!feature.canDirectEdit(directEditingContext)) {
			throw new RuntimeException("Direct Editing feature's canDirectEdit() returned false");
		}

		final RenameDialog nameDialog = new RenameDialog(Display.getCurrent().getActiveShell(), feature,
				directEditingContext);
		if (nameDialog.open() == Window.OK) {
			feature.setValue(nameDialog.getValue(), directEditingContext);
			feature.execute(directEditingContext);
		}

		return null;
	}

	private static DirectEditingContext getDirectEditingContext(final PictogramElement pe) {
		final DirectEditingContext ctx = new DirectEditingContext(pe, pe.getGraphicsAlgorithm());
		ctx.putProperty(BoHandlerDirectEditFeature.PROPERTY_REQUIRE_PRIMARY_LABEL, Boolean.FALSE);
		return ctx;
	}

	// Rename Dialog
	private static class RenameDialog extends InputDialog {
		public RenameDialog(final Shell parentShell, final IDirectEditingFeature directEditingFeature,
				final DirectEditingContext directEditingContext) {
			super(parentShell, "Rename", "Enter Name", directEditingFeature.getInitialValue(directEditingContext),
					newName -> directEditingFeature.checkValueValid(newName, directEditingContext));

			setShellStyle(getShellStyle() | SWT.RESIZE);
		}

		@Override
		protected void configureShell(final Shell shell) {
			super.configureShell(shell);
			shell.setMinimumSize(225, 185);
			ContextHelpUtil.setHelp(shell, ContextHelpUtil.RENAMING_ELEMENTS);
		}
	}
}