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
package org.osate.ge.ba.handlers;

import java.util.Objects;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.ge.DiagramCreationUtil;
import org.osate.ge.ProjectUtil;
import org.osate.ge.ba.diagram.diagramType.BehaviorAnnexDiagramType;
import org.osate.ge.ba.util.BehaviorAnnexHandlerUtil;
import org.osate.ge.ba.util.SelectionUtil;
import org.osate.ge.swt.name.DiagramNameDialog;
import org.osate.ge.swt.name.NameEditorDialogModel;

public class CreateBehaviorAnnexDiagramHandler extends AbstractHandler {
	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		final IEditorPart activeEditor = HandlerUtil.getActiveEditor(event);
		SelectionUtil.getDiagramContext(SelectionUtil.getCurrentSelection(), activeEditor);
		final DefaultAnnexSubclause diagramContext = BehaviorAnnexHandlerUtil
				.getBehaviorAnnexDiagramContext(activeEditor)
				.orElseThrow(() -> new RuntimeException("diagram context cannot be null"));
		final Classifier classifier = Objects.requireNonNull(diagramContext.getContainingClassifier(),
				"Classifier cannot be null");

		final NameEditorDialogModel model = getDialogModel(activeEditor, classifier, diagramContext);
		DiagramNameDialog.open(Display.getCurrent().getActiveShell(), model);

		return null;
	}

	private static NameEditorDialogModel getDialogModel(final IEditorPart activeEditor, final Classifier classifier,
			final DefaultAnnexSubclause diagramContext) {
		final IProject project = ProjectUtil.getProjectForBoOrThrow(classifier);
		final String initialFilename = getFileName(project, classifier, diagramContext);
		return createNameDialogModel(initialFilename, project, activeEditor, diagramContext);
	}

	private static NameEditorDialogModel createNameDialogModel(final String initialFilename, final IProject project,
			final IEditorPart activeEditor, final Object diagramContext) {
		return new NameEditorDialogModel() {
			@Override
			public String validateName(final String name) {
				// Invalid name if filename already exists
				final IFile tmpFile = DiagramCreationUtil.createDiagramFile(project, name);
				if (tmpFile.exists()) {
					return "File " + name + " already exists";
				}

				return null;
			}

			@Override
			public void setName(final String filename) {
				// Create new diagram
				DiagramCreationUtil.createDiagram(activeEditor, filename, new BehaviorAnnexDiagramType(), diagramContext);
			}

			@Override
			public String getName() {
				return initialFilename;
			}
		};
	}

	private static String getFileName(final IProject project, final Classifier classifier,
			final DefaultAnnexSubclause diagramContext) {
		final String baseName = BehaviorAnnexHandlerUtil.getFileName(classifier, diagramContext);
		int nameCount = 1;
		String name;
		IFile tmpFile;
		do {
			final String suffix = nameCount == 1 ? "" : "(" + nameCount + ")";
			name = baseName + suffix;
			tmpFile = DiagramCreationUtil.createDiagramFile(project, name);
			nameCount++;
		} while (tmpFile != null && tmpFile.exists());

		return name;
	}

	@Override
	public void setEnabled(final Object evaluationContext) {
		final IEditorPart activeEditor = SelectionUtil.getActiveEditorFromContext(evaluationContext);
		setBaseEnabled(
				BehaviorAnnexHandlerUtil.getBehaviorAnnexDiagramContext(activeEditor).isPresent());
	}
}
