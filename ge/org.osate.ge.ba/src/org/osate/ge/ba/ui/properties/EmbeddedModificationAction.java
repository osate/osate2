package org.osate.ge.ba.ui.properties;

import java.io.ByteArrayInputStream;
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
import org.osate.ge.internal.services.AgeAction;
import org.osate.ge.internal.services.ModelChangeNotifier;
import org.osate.ge.internal.services.ModelChangeNotifier.Lock;

/**
 * Modification process to be executed to update the action text
 */
@SuppressWarnings("restriction")
class EmbeddedModificationAction implements AgeAction {
	private final TransactionalEditingDomain editingDomain;
	private final IXtextDocument xtextDocument;
	private final XtextResource xtextResource;
	private final ModelChangeNotifier modelChangeNotifier;
	private final IProject project;
	private final Void<XtextResource> work;
	private final RecordingCommand cmd;
	private final String originalSource;

	public EmbeddedModificationAction(final TransactionalEditingDomain editingDomain,
			final IXtextDocument xtextDocument, final XtextResource xtextResource,
			final ModelChangeNotifier modelChangeNotifier, final IProject project, final String originalSource,
			final String modifiedSource) {
		this.xtextDocument = xtextDocument;
		this.editingDomain = Objects.requireNonNull(editingDomain, "editingDomain cannot be null");
		this.xtextResource = Objects.requireNonNull(xtextResource, "xtextResource cannot be null");
		this.modelChangeNotifier = Objects.requireNonNull(modelChangeNotifier, "modelChangeNotifier cannot be null");
		this.project = Objects.requireNonNull(project, "project cannot be null");
		this.work = Objects.requireNonNull(
				createUpdateProcess(Objects.requireNonNull(modifiedSource, "modifiedSource cannot be null")),
				"work cannot be null");
		this.cmd = Objects.requireNonNull(createRecordingCommand(editingDomain, xtextResource), "cmd cannot be null");
		this.originalSource = Objects.requireNonNull(originalSource, "originalSource cannot be null");
	}

	public EmbeddedModificationAction(final TransactionalEditingDomain editingDomain, final IXtextDocument xtextDocument,
			final XtextResource xtextResource, final ModelChangeNotifier modelChangeNotifier, final IProject project,
			final String originalSource) {
		this(editingDomain, xtextDocument, xtextResource, modelChangeNotifier, project, originalSource, originalSource);
	}

	/**
	 * Create the modification for updating source text
	 * @param modifiedSource is the new source text to replace old source text
	 */
	private Void<XtextResource> createUpdateProcess(final String modifiedSrc) {
		return new IUnitOfWork.Void<XtextResource>() {
			@Override
			public void process(final XtextResource state) throws Exception {
				loadResource(state, modifiedSrc);
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
		return new EmbeddedModificationAction(editingDomain, xtextDocument, xtextResource, modelChangeNotifier, project,
				originalSource);
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
				final String languageName = getLanguageName();

				// Only force reconciliation for AADL editors
				if (Objects.equals(xtextEditor.getLanguageName(), languageName)) {
					final SyncUtil syncUtil = BehaviorTransitionPropertySection.injector.getInstance(SyncUtil.class);

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
	private static String getLanguageName() {
		final LanguageNameRetriever obj = BehaviorTransitionPropertySection.injector
				.getInstance(LanguageNameRetriever.class);
		return obj.languageName;
	}
}
