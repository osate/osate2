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

import java.io.IOException;
import java.util.Objects;
import java.util.function.Supplier;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.statushandlers.StatusManager;
import org.eclipse.xtext.resource.SaveOptions;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.osate.aadl2.modelsupport.Activator;
import org.osate.ge.aadl2.AadlGraphicalEditorException;
import org.osate.ge.ba.util.BehaviorAnnexXtextUtil;
import org.osate.ge.internal.services.AgeAction;
import org.osate.ge.internal.services.ModelChangeNotifier;
import org.osate.ge.internal.services.ModelChangeNotifier.Lock;

/**
 * Modification process to be executed to update embedded text resources
 */
class EmbeddedTextModificationAction implements AgeAction {
	private final ModelChangeNotifier modelChangeNotifier;
	private final Supplier<EmbeddedTextModificationAction> embeddedEditingActionSupplier;

	/**
	 * Creates a new instance used for when the editor is open
	 * @param xtextDocument the document being modified
	 * @param modelChangeNotifier the notifier to use to lock the model
	 * @param project the project containing the document being modified
	 * @param newText the next text for the document.
	 */
	public EmbeddedTextModificationAction(final IXtextDocument xtextDocument,
			final ModelChangeNotifier modelChangeNotifier, final IProject project, final String newText) {
		this.modelChangeNotifier = Objects.requireNonNull(modelChangeNotifier, "modelChangeNotifier cannot be null");
		embeddedEditingActionSupplier = () -> {
			// Get original text for undo/redo
			final String originalText = BehaviorAnnexXtextUtil.getText(xtextDocument, null);

			// Modify the document
			prepareToEditDocument(xtextDocument);
			xtextDocument.set(newText);
			// Call readonly on the document. This will should cause Xtext's reconciler
			// to be called to ensure the document matches the model and trigger model change events.
			xtextDocument.readOnly(res -> null);

			buildProject(project);

			// Return the undo/redo action
			return new EmbeddedTextModificationAction(xtextDocument, modelChangeNotifier, project, originalText);
		};
	}

	/**
	 * Creates a new instance for when the editor is closed.
	 * @param editingDomain the editing domain to use to modify the resource.
	 * @param xtextResource the resource to modify
	 * @param modelChangeNotifier the notifier to use to lock the model
	 * @param project the project containing the resource being modified
	 * @param newText the new text for the resource
	 * @param textValue the portion of the resource being modified. If null, the entire resource is modified.
	 */
	public EmbeddedTextModificationAction(final TransactionalEditingDomain editingDomain,
			final XtextResource xtextResource, final ModelChangeNotifier modelChangeNotifier, final IProject project,
			final String newText, final EmbeddedTextValue textValue) {
		this.modelChangeNotifier = Objects.requireNonNull(modelChangeNotifier, "modelChangeNotifier cannot be null");
		embeddedEditingActionSupplier = () -> {
			// Get original text for undo
			final String originalText = BehaviorAnnexXtextUtil.getText(null, xtextResource);

			// Modify and save the xtext resource
			final IUnitOfWork.Void<XtextResource> work = createUpdateProcess(textValue, newText);
			final RecordingCommand cmd = createRecordingCommand(editingDomain, work, xtextResource);
			executeCommand(editingDomain, cmd, xtextResource);
			save(xtextResource);

			buildProject(project);

			// Return the undo/redo action
			return new EmbeddedTextModificationAction(editingDomain, xtextResource, modelChangeNotifier, project,
					originalText, null);
		};
	}

	/**
	 * Creates an update process for {@link XtextResource}.
	 * If the specified {@link EmbeddedTextValue} is not null, a section of the
	 * {@link XtextResource}'s source text will be updated with the specified sourceText value.
	 * If the specified {@link EmbeddedTextValue} is null, the {@link XtextResource}'s entire
	 * source text will be set to the specified sourceText value.
	 * @param textValue holds the values used to make a partial update to the {@link XtextResource}'s source text
	 * @param sourceText is the text to update the {@link XtextResource}'s source text with
	 */
	private IUnitOfWork.Void<XtextResource> createUpdateProcess(final EmbeddedTextValue textValue,
			final String sourceText) {
		return textValue != null
				? createPartialUpdateProcess(textValue.getUpdateOffset(), textValue.getUpdateLength(), sourceText)
				: createUndoRedoProcess(sourceText);
	}

	/**
	 * Creates a process to replace a specific section the existing source text of the {@link XtextResource} with the specified source text.
	 * @param updateOffset is the offset of the text to be replaced
	 * @param updateLength is the length of text to be replaced
	 * @param partialSrcText is the source text to update the section with
	 */
	private IUnitOfWork.Void<XtextResource> createPartialUpdateProcess(final int updateOffset, final int updateLength,
			final String partialSrcText) {
		return new IUnitOfWork.Void<XtextResource>() {
			@Override
			public void process(final XtextResource resource) throws Exception {
				// Replace text at specified index and length with new text value
				resource.update(updateOffset, updateLength, partialSrcText);
			}
		};
	}

	/**
	 * Creates a process to replace the existing source text of the {@link XtextResource} with the specified source text.
	 * Used for Undo/Redo functionality.
	 */
	private IUnitOfWork.Void<XtextResource> createUndoRedoProcess(final String srcText) {
		return new IUnitOfWork.Void<XtextResource>() {
			@Override
			public void process(final XtextResource resource) throws Exception {
				resource.reparse(srcText);
			}
		};
	}

	// Command to be executed
	private RecordingCommand createRecordingCommand(final TransactionalEditingDomain editingDomain,
			final IUnitOfWork.Void<XtextResource> work, final XtextResource xtextResource) {
		return new RecordingCommand(editingDomain) {
			@Override
			protected void doExecute() {
				try {
					work.exec(xtextResource);
				} catch (final Exception e) {
					throw new AadlGraphicalEditorException(e);
				}
			}
		};
	}

	@Override
	public AgeAction execute() {
		EmbeddedTextModificationAction undoRedoAction;
		try (final Lock lock = modelChangeNotifier.lock()) {
			undoRedoAction = embeddedEditingActionSupplier.get();
		}

		// Return action to restore original source text upon undo or redo
		return undoRedoAction;
	}

	private void save(final XtextResource xtextResource) {
		try {
			xtextResource.save(SaveOptions.newBuilder().format().getOptions().toOptionsMap());
		} catch (final IOException e) {
			throw new AadlGraphicalEditorException("Unable to save resource", e);
		}
	}

	private void buildProject(final IProject project) {
		// Build the project to prevent reference resolver from using old objects.
		try {
			project.build(IncrementalProjectBuilder.INCREMENTAL_BUILD, new NullProgressMonitor());
		} catch (final CoreException e) {
			// Ignore any errors that occur while building the project
			StatusManager.getManager().handle(e, Activator.PLUGIN_ID);
		}
	}

	private void executeCommand(final TransactionalEditingDomain editingDomain, final RecordingCommand cmd,
			final XtextResource xtextResource) {
		editingDomain.getCommandStack().execute(cmd);

		// Run the serializer. Otherwise if an invalid modification is made, the resource could be erased.
		// Sanity check to ensure that we don't save if the modification caused serialization to fail.
		// We need to undo to restore the resource to a valid state because the resource may still in use by the owner of the resource(such as the graphical
		// editor)
		final String serializedSrc = xtextResource.getSerializer().serialize(xtextResource.getContents().get(0));
		final boolean modificationSuccessful = serializedSrc != null && !serializedSrc.trim().isEmpty();
		if (!modificationSuccessful) {
			if (!editingDomain.getCommandStack().canUndo() || editingDomain.getCommandStack().getUndoCommand() != cmd) {
				throw new AadlGraphicalEditorException(
						"Property modification failed and unable to undo. Unexpected state.");
			}

			editingDomain.getCommandStack().undo();
		}
	}

	/**
	 * It is important to validate the Xtext editor input state to ensure the document can be edited before editing the document.
	 * The editor may change its internal state to prepare for editing as part of validation.
	 * Otherwise, the document may not be properly changed or notifications
	 * may not be received.
	 * @param doc the xtext document to prepare to edit.
	 */
	private static void prepareToEditDocument(final IXtextDocument xtextDocument) {
		for (final IEditorReference editorRef : PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
				.getEditorReferences()) {
			final IEditorPart editor = editorRef.getEditor(false);
			if (editor instanceof XtextEditor) {
				final XtextEditor xtextEditor = (XtextEditor) editor;
				if (xtextEditor.getDocument() == xtextDocument) {
					if (!xtextEditor.validateEditorInputState()) {
						throw new AadlGraphicalEditorException(
								"Unable to edit Xtext document. Editor input validation failed.");
					}
					break;
				}
			}
		}
	}
}