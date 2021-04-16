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

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtext.resource.SaveOptions;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.refactoring.ui.SyncUtil;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.util.concurrent.IUnitOfWork.Void;
import org.osate.ge.ba.util.BehaviorAnnexXtextUtil;
import org.osate.ge.internal.services.AgeAction;
import org.osate.ge.internal.services.ModelChangeNotifier;
import org.osate.ge.internal.services.ModelChangeNotifier.Lock;

import com.google.inject.Injector;

/**
 * Modification process to be executed to update the action text
 */
@SuppressWarnings("restriction")
class EmbeddedTextModificationAction implements AgeAction {
	private final TransactionalEditingDomain editingDomain;
	private final IXtextDocument xtextDocument;
	private final XtextResource xtextResource;
	private final ModelChangeNotifier modelChangeNotifier;
	private final IProject project;
	private final Void<XtextResource> work;
	private final RecordingCommand cmd;
	private final EmbeddedTextValue textValue;

	public EmbeddedTextModificationAction(final TransactionalEditingDomain editingDomain,
			final IXtextDocument xtextDocument, final XtextResource xtextResource,
			final ModelChangeNotifier modelChangeNotifier, final IProject project, final String newText,
			final EmbeddedTextValue textValue) {
		this.editingDomain = Objects.requireNonNull(editingDomain, "editingDomain cannot be null");
		this.xtextResource = Objects.requireNonNull(xtextResource, "xtextResource cannot be null");
		this.modelChangeNotifier = Objects.requireNonNull(modelChangeNotifier, "modelChangeNotifier cannot be null");
		this.project = Objects.requireNonNull(project, "project cannot be null");
		this.work = Objects.requireNonNull(
				createUpdateProcess(Objects.requireNonNull(newText, "newText cannot be null")), "work cannot be null");
		this.cmd = Objects.requireNonNull(createRecordingCommand(editingDomain, xtextResource), "cmd cannot be null");
		this.xtextDocument = xtextDocument;
		this.textValue = textValue;
	}

	private EmbeddedTextModificationAction(final TransactionalEditingDomain editingDomain,
			final IXtextDocument xtextDocument, final XtextResource xtextResource,
			final ModelChangeNotifier modelChangeNotifier, final IProject project, final String originalSource) {
		this(editingDomain, xtextDocument, xtextResource, modelChangeNotifier, project, originalSource, null);
	}

	/**
	 * Create the modification for updating source text
	 * @param newText is the new source text to replace in old source text
	 */
	private Void<XtextResource> createUpdateProcess(final String newText) {
		return new IUnitOfWork.Void<XtextResource>() {
			@Override
			public void process(final XtextResource resource) throws Exception {
				if (textValue != null) { // Replace text at specified index and length with new text value
					resource.update(textValue.getPrefix().length(), textValue.getUpdateLength(), newText);
				} else { // Replace text back to original state for undo
					resource.reparse(newText);
				}
			}
		};
	}

	// Command to be executed
	private RecordingCommand createRecordingCommand(final TransactionalEditingDomain editingDomain,
			final XtextResource xtextResource) {
		return new RecordingCommand(editingDomain) {
			@Override
			protected void doExecute() {
				try {
					work.exec(xtextResource);
				} catch (final Exception e) {
					throw new RuntimeException(e.getMessage());
				}
			}
		};
	}

	@Override
	public AgeAction execute() {
		final String originalText = BehaviorAnnexXtextUtil.getText(xtextDocument, xtextResource);
		try (final Lock lock = modelChangeNotifier.lock()) {
			if (xtextDocument != null) {
				xtextDocument.modify(work);
				reconcile();
			} else if (xtextResource instanceof XtextResource) {
				executeCommand();
				save();
			} else {
				throw new RuntimeException(
						"Unsupported case. Cannot modify model without an Xtext Document or an Xtext resource");
			}

			buildProject();
		}

		// Set action to restore original source text upon undo
		return new EmbeddedTextModificationAction(editingDomain, xtextDocument, xtextResource, modelChangeNotifier, project,
				originalText);

	}

	private void save() {
		try {
			xtextResource.save(SaveOptions.newBuilder().format().getOptions().toOptionsMap());
		} catch (final IOException e) {
			throw new RuntimeException(e);
		}
	}

	private void buildProject() {
		// Build the project to prevent reference resolver from using old objects.
		try {
			project.build(IncrementalProjectBuilder.INCREMENTAL_BUILD, new NullProgressMonitor());
		} catch (final CoreException e) {
			// Ignore any errors that occur while building the project
			e.printStackTrace();
		}
	}

	private void executeCommand() {
		editingDomain.getCommandStack().execute(cmd);

		// Run the serializer. Otherwise if an invalid modification is made, the resource could be erased.
		// Sanity check to ensure that we don't save if the modification caused serialization to fail.
		// We need to undo to restore the resource to a valid state because the resource may still in use by the owner of the resource(such as the graphical
		// editor)
		final String serializedSrc = xtextResource.getSerializer().serialize(xtextResource.getContents().get(0));
		final boolean modificationSuccessful = serializedSrc != null && !serializedSrc.trim().isEmpty();
		if (!modificationSuccessful) {
			if (!editingDomain.getCommandStack().canUndo() || editingDomain.getCommandStack().getUndoCommand() != cmd) {
				throw new RuntimeException("Property modification failed and unable to undo. Unexpected state.");
			}

			editingDomain.getCommandStack().undo();
		}
	}

	private void reconcile() {
		for (final IEditorReference editorRef : PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
				.getEditorReferences()) {
			final IEditorPart editor = editorRef.getEditor(false);
			if (editor instanceof XtextEditor) {
				final XtextEditor xtextEditor = (XtextEditor) editor;
				final Injector injector = EmbeddedXtextAdapter.injector;
				final String languageName = getLanguageName(injector);

				// Only force reconciliation for AADL editors
				if (Objects.equals(xtextEditor.getLanguageName(), languageName)) {
					final SyncUtil syncUtil = injector.getInstance(SyncUtil.class);

					// Only waiting once will result in the reconciler processing a change outside the lock.
					// Doing it twice appears to wait for pending runs of the reconciler.
					syncUtil.waitForReconciler(xtextEditor);
					syncUtil.waitForReconciler(xtextEditor);
				}
			}
		}
	}

	private static class LanguageNameRetriever {
		@Inject
		@Named(org.eclipse.xtext.Constants.LANGUAGE_NAME)
		public String languageName;
	}

	/**
	 * Retrieves the language name by injecting it into a new object.
	 * @return
	 */
	private String getLanguageName(final Injector injector) {
		final LanguageNameRetriever obj = injector.getInstance(LanguageNameRetriever.class);
		return obj.languageName;
	}
}