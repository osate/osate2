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
package org.osate.ge.ba.ui;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.Adapters;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Caret;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.osate.aadl2.NamedElement;
import org.osate.ge.ProjectUtil;
import org.osate.ge.aadl2.AadlGraphicalEditorException;
import org.osate.ge.ba.ui.properties.EditableEmbeddedTextValue;
import org.osate.ge.ba.util.BehaviorAnnexSelectionUtil;
import org.osate.ge.ba.util.BehaviorAnnexXtextUtil;
import org.osate.ge.internal.services.ActionExecutor.ExecutionMode;
import org.osate.ge.internal.services.ActionService;
import org.osate.ge.internal.services.ModelChangeNotifier;
import org.osate.ge.internal.ui.xtext.AgeXtextUtil;
import org.osate.ge.swt.SwtUtil;

/**
 * Composite for editing AADL source that is embedded in a StyledText
 * @since 2.0
 */
public class EmbeddedTextEditor extends Composite {
	private StyledText styledText;
	private Button editBtn;
	private EmbeddedStyledTextXtextAdapter xtextAdapter;
	private final int styledTextStyle;

	private EmbeddedTextEditor(final Composite parent, final int styledTextStyle,
			final GridData layoutData) {
		super(parent, SWT.NONE);
		this.setBackground(parent.getBackground());
		this.setLayout(GridLayoutFactory.swtDefaults().numColumns(2).create());
		this.styledTextStyle = styledTextStyle;
		createControls(layoutData);
		setLayoutData(layoutData);
	}

	/**
	 * Creates a single line EmbeddedTextEditor
	 * @param parent the parent composite
	 * @return the new EmbeddedTextEditor
	 * @since 2.0
	 */
	public static EmbeddedTextEditor createSingleline(
			final Composite parent) {
		return new EmbeddedTextEditor(parent, SWT.BORDER | SWT.SINGLE,
				GridDataFactory.swtDefaults()
						.align(SWT.FILL, SWT.FILL)
						.grab(true, true)
						.hint(SWT.DEFAULT, SWT.DEFAULT)
						.create());
	}

	/**
	 * Creates a multi line EmbeddedTextEditor
	 * @param parent the parent composite
	 * @return the new EmbeddedTextEditor
	 * @since 2.0
	 */
	public static EmbeddedTextEditor createMultiline(
			final Composite parent) {
		return new EmbeddedTextEditor(parent, SWT.BORDER | SWT.V_SCROLL | SWT.WRAP | SWT.MULTI,
				GridDataFactory.swtDefaults()
						.align(SWT.FILL, SWT.FILL)
						.grab(true, true)
						.hint(SWT.DEFAULT, 100)
						.create());
	}

	private void createControls(
			final GridData styledTextLayoutData) {
		// Create styled text
		styledText = new StyledText(this, styledTextStyle);
		styledText.setEditable(false);
		// Set empty caret so that the caret will not show.
		// Makes sure users know it is not editable.
		// Note: If caret is set to null, exception may occur
		// when used with the StyledTextXtextAdapter.
		final Caret emptyCaret = new Caret(getShell(), SWT.NONE);
		styledText.setCaret(emptyCaret);
		styledText.setLayoutData(styledTextLayoutData);
		styledText.addDisposeListener(e -> emptyCaret.dispose());

		editBtn = new Button(this, SWT.PUSH);
		editBtn.setText("Edit...");
		editBtn.addSelectionListener(SelectionListener.widgetSelectedAdapter(e -> {
			final EditableEmbeddedTextValue editableTextValue = xtextAdapter.getEmbeddedTextValue();
			final NamedElement ne = editableTextValue.getElementToModify();
			final EditEmbeddedTextDialog dlg = new EditEmbeddedTextDialog(Display.getCurrent().getActiveShell(),
					xtextAdapter.getProject(), editableTextValue, styledTextStyle,
					styledTextLayoutData);
			if (dlg.open() == Window.OK) {
				// Edit condition
				BehaviorAnnexSelectionUtil.getActiveEditor().ifPresent(editorPart -> {
					final ActionService actionService = Adapters.adapt(editorPart, ActionService.class);
					final ModelChangeNotifier modelChangeNotifier = Objects.requireNonNull(
							editorPart.getAdapter(ModelChangeNotifier.class), "Unable to get model change notifier");
					final IXtextDocument xtextDocument = getXtextDocument(ne).orElse(null);
					if (xtextDocument != null) {
						// Execute modification with xtext document
						actionService.execute(editableTextValue.getModificationLabel(),
								ExecutionMode.NORMAL,
								new EmbeddedTextModificationAction(xtextDocument, modelChangeNotifier,
										dlg.getResult().getFullSource()));
					} else {
						final XtextResource xtextResource = getXtextResource(ne).orElseThrow();
						final TransactionalEditingDomain editingDomain = TransactionalEditingDomain.Factory.INSTANCE
								.getEditingDomain(xtextResource.getResourceSet());
						editableTextValue.setEditableText(dlg.getResult().getPartialSource());
						// Execute modification with xtext resource
						actionService.execute(editableTextValue.getModificationLabel(), ExecutionMode.NORMAL,
								new EmbeddedTextModificationAction(editingDomain, xtextResource, modelChangeNotifier,
										editableTextValue));
					}
				});
			}
		}));
	}

	private static Optional<IXtextDocument> getXtextDocument(final NamedElement behaviorTransition) {
		return Optional.ofNullable(AgeXtextUtil.getDocumentByRootElement(behaviorTransition.getElementRoot()));
	}

	private static Optional<XtextResource> getXtextResource(final NamedElement behaviorTransition) {
		final Resource resource = behaviorTransition.eResource();
		return Optional.ofNullable(resource instanceof XtextResource ? (XtextResource) resource : null);
	}

	/**
	 * Sets the {@link EditableEmbeddedTextValue} for the EmbeddedTextEditor
	 * @param selectedElement the selected {@link NamedElement} to get AADL source text from
	 * @param createTextValue creates an {@link EditableEmbeddedTextValue} from AADL source text
	 * @since 2.0
	 */
	public void setEditorTextValue(final NamedElement selectedElement,
			final Function<String, EditableEmbeddedTextValue> createTextValue) {
		disposeXtextAdapter();
		final IProject project = ProjectUtil.getProjectForBoOrThrow(selectedElement);
		final XtextResource xtextResource = getXtextResource(selectedElement)
				.orElseThrow(() -> new AadlGraphicalEditorException("resource must be XtextResource"));
		final IXtextDocument xtextDocument = getXtextDocument(selectedElement).orElse(null);
		final String sourceText = BehaviorAnnexXtextUtil.getText(xtextDocument, xtextResource);
		xtextAdapter = new EmbeddedStyledTextXtextAdapter(project, createTextValue.apply(sourceText));
		xtextAdapter.adapt(styledText);
	}

	/**
	 * Sets the test id for the styled text
	 */
	public void setStyledTextTestId(final String styledTextTestId) {
		SwtUtil.setTestingId(styledText, styledTextTestId);
	}

	/**
	 * Sets test id for the edit button
	 */
	public void setEditButtonTestId(final String editBtnTestId) {
		SwtUtil.setTestingId(editBtn, editBtnTestId);
	}

	private void disposeXtextAdapter() {
		if (xtextAdapter != null) {
			xtextAdapter.dispose();
			xtextAdapter = null;
		}
	}

	@Override
	public void setEnabled(boolean isEnabled) {
		super.setEnabled(isEnabled);
		styledText.setEnabled(isEnabled);
		editBtn.setEnabled(isEnabled);
	}

	/**
	 * Sets the text for the styled text
	 * @param text the text for the styled text
	 */
	public void setStyledTextText(final String text) {
		styledText.setText(text);
	}
}
