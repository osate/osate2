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

package org.osate.ge.ba.ui.properties;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Stack;
import java.util.function.BiFunction;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ExtendedModifyEvent;
import org.eclipse.swt.custom.ExtendedModifyListener;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.IHandlerActivation;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.impl.ListBasedDiagnosticConsumer;
import org.osate.ba.aadlba.BehaviorTransition;
import org.osate.ge.swt.SwtUtil;

public class EditEmbeddedTextDialog extends MessageDialog {
	private static String WIDGET_ID = "org.osate.ge.ba.behaviortransition.editdialog";
	private static String MODIFIED_SOURCE_KEY = WIDGET_ID + ".modifiedsource";
	public static String WIDGET_ID_TEXT = WIDGET_ID + ".text";
	public static String WIDGET_ID_CONFIRM = WIDGET_ID + ".confirmation";
	private final EmbeddedXtextAdapter xtextAdapter;
	private final ExtendedModifyListener textValidator;
	private final IHandlerService service;
	private final int styledTextStyle;
	private final GridData styledTextLayoutData;
	private IHandlerActivation undoHandler;
	private IHandlerActivation redoHandler;
	private StyledText styledText;
	private Result result;

	public EditEmbeddedTextDialog(final Shell parentShell, final String title, final String dialogMessage,
			final EmbeddedXtextAdapter xtextAdapter,
			final int styledTextStyle,
			final GridData styledTextLayoutData,
			final BehaviorTransition behaviorTransition,
			final BiFunction<EObject, String, String> getModifiedSrc,
			final BiFunction<BehaviorTransition, String, Boolean> isValidModification) {
		super(parentShell, title, null, dialogMessage, MessageDialog.NONE, 0, "OK", "Cancel");
		this.xtextAdapter = Objects.requireNonNull(xtextAdapter, "xtextAdapter cannot be null");
		this.styledTextStyle = styledTextStyle;
		this.styledTextLayoutData = Objects.requireNonNull(styledTextLayoutData, "styledTextLayoutData cannot be null");
		this.textValidator = Objects.requireNonNull(
				createTextValidator(behaviorTransition, getModifiedSrc, isValidModification),
				"textValidator cannot be null");
		service = PlatformUI.getWorkbench().getService(IHandlerService.class);
		setShellStyle(SWT.CLOSE | SWT.PRIMARY_MODAL | SWT.BORDER | SWT.TITLE | SWT.RESIZE);
	}

	public EditEmbeddedTextDialog(final Shell parentShell, final String title, final String dialogMessage,
			final EmbeddedXtextAdapter xtextAdapter, final int styledTextStyle, final GridData styledTextLayoutData,
			final BehaviorTransition behaviorTransition,
			final BiFunction<BehaviorTransition, String, Boolean> isValidModification) {
		this(parentShell, title, dialogMessage, xtextAdapter, styledTextStyle, styledTextLayoutData, behaviorTransition,
				(rootElement, text) -> xtextAdapter.serialize(rootElement), isValidModification);
	}

	@Override
	protected Control createCustomArea(final Composite parent) {
		final Composite composite = new Composite(parent, SWT.NONE);
		final GridLayout layout = getGridLayout();
		composite.setLayout(layout);
		composite.setLayoutData(GridDataFactory.fillDefaults().grab(true, true).create());
		composite.setFont(parent.getFont());

		styledText = new StyledText(composite, styledTextStyle);
		styledText.setLayoutData(styledTextLayoutData);
		styledText.addExtendedModifyListener(textValidator);
		SwtUtil.setTestingId(styledText, WIDGET_ID_TEXT);
		xtextAdapter.adapt(styledText);

		final UndoRedoHelper undoRedoHelper = new UndoRedoHelper();
		undoHandler = service.activateHandler("org.eclipse.ui.edit.undo", new AbstractHandler() {
			@Override
			public Object execute(final ExecutionEvent event) throws ExecutionException {
				undoRedoHelper.undo();
				return null;
			}
		});

		redoHandler = service.activateHandler("org.eclipse.ui.edit.redo", new AbstractHandler() {
			@Override
			public Object execute(final ExecutionEvent event) throws ExecutionException {
				undoRedoHelper.redo();
				return null;
			}
		});

		return composite;
	}

	private GridLayout getGridLayout() {
		final GridLayout layout = new GridLayout();
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		layout.verticalSpacing = 0;
		layout.horizontalSpacing = 0;
		layout.numColumns = 2;
		return layout;
	}

	@Override
	public void create() {
		super.create();
		final Button okBtn = getButton(IDialogConstants.OK_ID);
		okBtn.setEnabled(false);
		SwtUtil.setTestingId(okBtn, WIDGET_ID_CONFIRM);
	}

	// Text modification listener that sets the OK button as enabled
	// or disabled based on if the new text is valid
	private ExtendedModifyListener createTextValidator(final BehaviorTransition behaviorTransition,
			final BiFunction<EObject, String, String> getModifiedSrc,
			final BiFunction<BehaviorTransition, String, Boolean> isValidModification) {
		final String originalText = xtextAdapter.getEditableText();
		return event -> {
			final Button okBtn = getButton(IDialogConstants.OK_ID);
			final String newText = styledText.getText().trim();
			// Disable if text has not changed
			if (newText.equals(originalText)) {
				okBtn.setEnabled(false);
				return;
			}

			// Update save button based on whether the text entered into the
			// styled text is a serializable condition
			final EObject rootElement = xtextAdapter.getXtextParseResult().getRootASTElement();
			final XtextResource fakeResource = xtextAdapter.getFakeResource();
			// Link model
			fakeResource.getLinker().linkModel(rootElement, new ListBasedDiagnosticConsumer());

			// Original source text
			final String originalSrc = xtextAdapter.getText();

			try {
				// Modified source text
				final String modifiedSrc = getModifiedSrc.apply(rootElement, styledText.getText().trim());
				// Set modified source text data
				styledText.setData(MODIFIED_SOURCE_KEY, modifiedSrc);

				// Load for error checking
				loadResource(fakeResource, modifiedSrc);
				boolean isEnabled = false;
				// Check if BehaviorTransition still exists, meaning the modification did not break serialization
				final BehaviorTransition tmpBehaviorTransition = (BehaviorTransition) fakeResource
						.getEObject(EcoreUtil.getURI(behaviorTransition).fragment());
				if (tmpBehaviorTransition != null) {
					isEnabled = isValidModification.apply(tmpBehaviorTransition, newText);
				}

				okBtn.setEnabled(isEnabled);
			} catch (final Exception ex) {
				okBtn.setEnabled(false);
			} finally {
				// Load original source
				loadResource(fakeResource, originalSrc);
			}
		};
	}

	private void loadResource(final XtextResource resource, final String src) {
		try {
			resource.unload();
			resource.load(new ByteArrayInputStream(src.getBytes()), null);
		} catch (final IOException e) {
			throw new RuntimeException("Serialized source cannot be loaded");
		}
	}

	@Override
	protected void buttonPressed(final int buttonId) {
		if (buttonId == IDialogConstants.OK_ID) {
			// Set return result
			result = new Result(styledText.getData(MODIFIED_SOURCE_KEY).toString(),
					styledText.getText().trim());
		}

		super.buttonPressed(buttonId);
	}

	@Override
	public boolean close() {
		xtextAdapter.dispose();
		service.deactivateHandler(undoHandler);
		service.deactivateHandler(redoHandler);
		return super.close();
	}

	public Result getResult() {
		return result;
	}

	public class Result {
		private final String fullSource;
		private final String partialSource;

		public Result(final String fullSource, final String partialSource) {
			this.fullSource = fullSource;
			this.partialSource = partialSource;
		}

		/**
		 * Returns the modified source for the full AADL resource/document.
		 */
		public String getFullSource() {
			return fullSource;
		}

		/**
		 * Returns the modified source for the region of the AADL resource edited by the dialog.
		 */
		public String getPartialSource() {
			return partialSource;
		}
	}

	private class UndoRedoHelper implements ExtendedModifyListener {
		private final UndoRedoStack undoRedoStack = new UndoRedoStack();
		private boolean isUndo;
		private boolean isRedo;

		private UndoRedoHelper() {
			styledText.addExtendedModifyListener(this);
		}

		/**
		 * Creates a corresponding Undo or Redo step from the given event and pushes
		 * it to the stack. The Redo stack is emptied if the event comes
		 * from key input.
		 */
		@Override
		public void modifyText(final ExtendedModifyEvent event) {
			if (isUndo) {
				undoRedoStack.pushRedo(event);
			} else { // is redo or key input
				undoRedoStack.pushUndo(event);
				if (!isRedo) {
					undoRedoStack.clearRedo();
				}
			}
		}

		private void undo() {
			if (undoRedoStack.hasUndo()) {
				isUndo = true;
				revertEvent(undoRedoStack.popUndo());
				isUndo = false;
			}
		}

		private void redo() {
			if (undoRedoStack.hasRedo()) {
				isRedo = true;
				revertEvent(undoRedoStack.popRedo());
				isRedo = false;
			}
		}

		/**
		 * Reverts the given modify event
		 */
		private void revertEvent(final ExtendedModifyEvent event) {
			styledText.replaceTextRange(event.start, event.length, event.replacedText);
			styledText.setSelectionRange(event.start, event.replacedText.length());
		}

		private class UndoRedoStack {
			private final static int MAX_STACK_SIZE = 50;
			private final Stack<ExtendedModifyEvent> undo;
			private final Stack<ExtendedModifyEvent> redo;

			public UndoRedoStack() {
				undo = new Stack<ExtendedModifyEvent>();
				redo = new Stack<ExtendedModifyEvent>();
			}

			public void pushUndo(final ExtendedModifyEvent undoEvent) {
				if (undo.size() > MAX_STACK_SIZE) {
					undo.remove(0);
				}
				undo.add(undoEvent);
			}

			public void pushRedo(final ExtendedModifyEvent redoEvent) {
				if (redo.size() > MAX_STACK_SIZE) {
					redo.remove(0);
				}
				redo.add(redoEvent);
			}

			public ExtendedModifyEvent popUndo() {
				return undo.pop();
			}

			public ExtendedModifyEvent popRedo() {
				return redo.pop();
			}

			public void clearRedo() {
				redo.clear();
			}

			public boolean hasUndo() {
				return !undo.isEmpty();
			}

			public boolean hasRedo() {
				return !redo.isEmpty();
			}
		}
	}
}