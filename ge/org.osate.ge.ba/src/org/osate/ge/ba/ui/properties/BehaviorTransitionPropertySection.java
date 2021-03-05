package org.osate.ge.ba.ui.properties;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.Adapters;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.jface.viewers.IFilter;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.xtext.resource.SaveOptions;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.impl.ListBasedDiagnosticConsumer;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.ui.refactoring.ui.SyncUtil;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.util.concurrent.IUnitOfWork.Void;
import org.osate.ba.aadlba.BehaviorCondition;
import org.osate.ba.aadlba.BehaviorTransition;
import org.osate.ba.declarative.DeclarativeBehaviorTransition;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.BusinessObjectSelection;
import org.osate.ge.ProjectUtil;
import org.osate.ge.ba.util.BehaviorAnnexSelectionUtil;
import org.osate.ge.internal.services.ActionExecutor.ExecutionMode;
import org.osate.ge.internal.services.ActionService;
import org.osate.ge.internal.services.AgeAction;
import org.osate.ge.internal.services.ModelChangeNotifier;
import org.osate.ge.internal.services.ModelChangeNotifier.Lock;
import org.osate.ge.internal.ui.xtext.AgeXtextUtil;
import org.osate.ge.ui.PropertySectionUtil;
import org.osate.xtext.aadl2.ui.internal.Aadl2Activator;
import org.osate.xtext.aadl2.ui.propertyview.OsateStyledTextXtextAdapter;
import org.yakindu.base.xtext.utils.jface.viewers.context.IXtextFakeContextResourcesProvider;

import com.google.inject.Injector;

@SuppressWarnings("restriction")
public class BehaviorTransitionPropertySection extends AbstractPropertySection {
	public static class Filter implements IFilter {
		@Override
		public boolean select(final Object toTest) {
			return PropertySectionUtil.isBocCompatible(toTest, boc -> isBehaviorTransition(boc));
		}
	}

	private Composite composite;
	private BusinessObjectSelection selectedBos;
	private BehaviorAnnexStyledTextXtextAdapter xtextAdapter;

	@Override
	public void setInput(final IWorkbenchPart part, final ISelection selection) {
		super.setInput(part, selection);
		selectedBos = Adapters.adapt(selection, BusinessObjectSelection.class);
	}

	@Override
	public void createControls(final Composite parent, final TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);
		xtextAdapter = new BehaviorAnnexStyledTextXtextAdapter();
		// Create composite for widgets
		createComposite(parent);
	}

	private void createComposite(final Composite parent) {
		composite = getWidgetFactory().createPlainComposite(parent, SWT.NONE);
		composite.setLayout(GridLayoutFactory.swtDefaults().numColumns(2).create());
	}

	private Button createSaveButton(final boolean isSingleSelection,
			TransactionalEditingDomain editingDomain, final StyledText styledText, TextValue conditionTextValue, IProject project, XtextResource xtextResource,
			IXtextDocument xtextDocument) {
		final Button saveBtn = new Button(composite, SWT.PUSH);
		saveBtn.setText("Save");
		saveBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				BehaviorAnnexSelectionUtil.getActiveEditor().ifPresent(editorPart -> {
					final ActionService actionService = Adapters.adapt(editorPart, ActionService.class);
					final ModelChangeNotifier modelChangeNotifier = Objects.requireNonNull(
							editorPart.getAdapter(ModelChangeNotifier.class), "Unable to get model change notifier");

					actionService.execute("Modifying BehaviorTranistion Condition", ExecutionMode.NORMAL,
							new ConditionModification(styledText.getText(), editingDomain, xtextDocument, xtextResource,
									modelChangeNotifier, project, conditionTextValue));
				});
			}
		});

		saveBtn.setEnabled(isSingleSelection);
		return saveBtn;
	}

	private StyledText getConditionText(final boolean isSingleSelection) {
		// Create styled text
		final StyledText transitionText = new StyledText(composite, SWT.BORDER | SWT.SINGLE);
		// Disable on multiple selection
		transitionText.setEnabled(isSingleSelection);
		transitionText.setLayoutData(
				GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).hint(SWT.DEFAULT, SWT.DEFAULT)
						.create());
		return transitionText;
	}

	@Override
	public void refresh() {
		final boolean isSingleSelection = selectedBos.bocStream().limit(2).count() == 1;
		selectedBos.bocStream().filter(
				boc -> isBehaviorTransition(boc) && ProjectUtil.getProjectForBo(boc.getBusinessObject()).isPresent())
				.findAny().ifPresent(selectedBoc -> {
					final BehaviorTransition behaviorTransition = (BehaviorTransition) selectedBoc.getBusinessObject();
					final TransactionalEditingDomain editingDomain = (TransactionalEditingDomain) AdapterFactoryEditingDomain
							.getEditingDomainFor(behaviorTransition);
					final IProject project = ProjectUtil.getProjectForBoOrThrow(behaviorTransition);
					final XtextResource xtextResource = getXtextResource(behaviorTransition)
							.orElseThrow(() -> new RuntimeException("resource must be XtextResource"));
					final IXtextDocument xtextDocument = getXtextDocument(behaviorTransition).orElse(null);

					// Source text
					final String text = getText(xtextDocument, xtextResource);
					// Create condition text value
					final TextValue conditionTextValue = getConditionTextValue(behaviorTransition, text);

					// Styled text to enter the new condition text
					final StyledText conditionStyledText = getConditionText(isSingleSelection);
					// Button to execute the condition modification
					final Button saveBtn = createSaveButton(isSingleSelection, editingDomain, conditionStyledText,
							conditionTextValue, project, xtextResource, xtextDocument);
					conditionStyledText
							.addKeyListener(new ConditionModificationKeyAdapter(behaviorTransition, saveBtn,
									conditionStyledText));

					// Dispose of current adapter and create new one
					setXtextAdapter(project, conditionStyledText, saveBtn);
					updateAdapterDocument(conditionTextValue);

				});

		// Layout composite
		composite.requestLayout();
	}

	private class ConditionModificationKeyAdapter extends KeyAdapter {
		private final BehaviorTransition behaviorTransition;
		private final Button saveBtn;
		private final XtextResource fakeResource;
		private final StyledText conditionStyledText;

		public ConditionModificationKeyAdapter(final BehaviorTransition behaviorTransition, final Button saveBtn,
				final StyledText conditionStyledText) {
			this.behaviorTransition = behaviorTransition;
			this.saveBtn = saveBtn;
			this.fakeResource = xtextAdapter.getFakeResourceContext().getFakeResource();
			this.conditionStyledText = conditionStyledText;
		}

		@Override
		public void keyReleased(final KeyEvent e) {
			System.err.println(e + " KEYEVENT");
			// Link model
			final EObject rootElement = xtextAdapter.getXtextParseResult().getRootASTElement();
			fakeResource.getLinker().linkModel(rootElement, new ListBasedDiagnosticConsumer());

			// Original source text
			final String originalSrc = getText(null, fakeResource);

			// Modified source text
			final String modifiedSrc = fakeResource.getSerializer().serialize(rootElement);
			// Load for error checking
			loadResource(fakeResource, modifiedSrc);

			boolean isEnabled = false;
			// Check if BehaviorTransition still exists, meaning the modification did not break serialization
			final BehaviorTransition behaviorTransition = (BehaviorTransition) fakeResource
					.getEObject(EcoreUtil.getURI(this.behaviorTransition).fragment());

			if (behaviorTransition != null) {
				final BehaviorCondition condition = behaviorTransition.getCondition();
				// Calculate enabled based on if condition should exist and if it exists
				isEnabled = conditionStyledText.getText().isEmpty() ? condition == null : condition != null;
			}

			// Enable if modification was allowed
			saveBtn.setEnabled(isEnabled);

			// Load original source
			loadResource(fakeResource, originalSrc);
		}

		private void loadResource(final XtextResource resource, final String src) {
			try {
				resource.unload();
				resource.load(new ByteArrayInputStream(src.getBytes()), null);
			} catch (final IOException e) {
				throw new RuntimeException("Serialized source cannot be loaded");
			}
		}
	}

	private TextValue getConditionTextValue(final BehaviorTransition behaviorTransition, final String text) {
		final BehaviorCondition condition = behaviorTransition.getCondition();

		// Xtext offset location reference for condition or transition if condition is null
		final int updateOffset;

		// Text before transition condition
		final String prefix;

		final String conditionText;
		if (condition == null) {
			// Transition offset
			final int transitionOffset = behaviorTransition.getAadlBaLocationReference().getOffset();

			// Find condition offset
			final String updatePrefix = text.substring(transitionOffset).split("-\\[", 2)[0] + "-[";

			// Update prefix and offset
			prefix = new StringBuilder(text.substring(0, transitionOffset)).append(updatePrefix).toString();

			// Update offset
			updateOffset = transitionOffset + updatePrefix.length();

			// Empty condition text
			conditionText = "";
		} else {
			// Condition offset
			updateOffset = condition.getAadlBaLocationReference().getOffset();
			prefix = text.substring(0, updateOffset);

			// Note: Condition length only counts until the first space (assuming).
			// For example, when dispatch condition is "on dispatch" length is 2.
			// Find closing "]", to get condition text
			conditionText = text.substring(updateOffset).split("]")[0];
		}

		// Text after transition condition
		final String suffix = getSuffix(text, updateOffset);
		// Create condition value
		return new TextValue(prefix, conditionText, suffix, updateOffset);
	}

	private static Optional<IXtextDocument> getXtextDocument(final BehaviorTransition behaviorTransition) {
		return Optional.ofNullable(AgeXtextUtil.getDocumentByRootElement(behaviorTransition.getElementRoot()));
	}

	private void updateAdapterDocument(final TextValue val) {
		final XtextDocument xtextDoc = xtextAdapter.getXtextDocument();
		final SourceViewer srcViewer = xtextAdapter.getSourceviewer();
		xtextDoc.set(val.wholeText);
		srcViewer.setDocument(xtextDoc, srcViewer.getAnnotationModel(), val.offset, val.length);
	}

	// All source text
	private static String getText(final IXtextDocument xtextDocument, final XtextResource xtextResource) {
		if (xtextDocument == null) {
			return xtextResource.getParseResult().getRootNode().getText();
		}

		return xtextDocument.get();
	}

	// Source text after condition
	private static String getSuffix(final String text, final int updateOffset) {
		final String suffix = text.substring(updateOffset, text.length());
		return new StringBuilder(suffix).substring(suffix.indexOf("]"));
	}

	private static boolean isBehaviorTransition(final BusinessObjectContext boc) {
		final Object bo = boc.getBusinessObject();
		return bo instanceof BehaviorTransition || bo instanceof DeclarativeBehaviorTransition;
	}

	private static Optional<XtextResource> getXtextResource(final BehaviorTransition behaviorTransition) {
		final Resource resource = behaviorTransition.eResource();
		return Optional.ofNullable(resource instanceof XtextResource ? (XtextResource) resource : null);
	}

	private void setXtextAdapter(final IProject project, final StyledText transitionText, final Button saveBtn) {
		xtextAdapter.dispose();
		xtextAdapter = new BehaviorAnnexStyledTextXtextAdapter(project, transitionText, saveBtn);
		xtextAdapter.adapt(transitionText);
	}

	private static class BehaviorAnnexStyledTextXtextAdapter extends OsateStyledTextXtextAdapter {
		private static final Injector injector = Aadl2Activator.getInstance()
				.getInjector(Aadl2Activator.ORG_OSATE_XTEXT_AADL2_AADL2);
		private static final IXtextFakeContextResourcesProvider contextFakeResourceProvider = IXtextFakeContextResourcesProvider.NULL_CONTEXT_PROVIDER;
		private final StyledText conditionStyledText;
		private final Button saveBtn;

		public BehaviorAnnexStyledTextXtextAdapter() {
			super(injector, contextFakeResourceProvider, null);
			this.conditionStyledText = null;
			this.saveBtn = null;
		}

		public BehaviorAnnexStyledTextXtextAdapter(final IProject project, final StyledText transitionText,
				final Button saveBtn) {
			super(injector, contextFakeResourceProvider, project);
			this.conditionStyledText = transitionText;
			this.saveBtn = saveBtn;
		}

		public SourceViewer getSourceviewer() {
			return super.getXtextSourceviewer();
		}

		@Override
		public XtextDocument getXtextDocument() {
			return super.getXtextDocument();
		}

		@Override
		public void dispose() {
			super.dispose();
			disposeWidgets();
		}

		private void disposeWidgets() {
			// Dispose widgets for next selection
			disposeControl(conditionStyledText);
			disposeControl(saveBtn);
		}

		private void disposeControl(final Control control) {
			// Dispose widgets for next selection
			if (control != null && !control.isDisposed()) {
				control.dispose();
			}
		}
	}

	/**
	 * Modification process to be executed to update the condition text
	 */
	private class ConditionModification implements AgeAction {
		private final TransactionalEditingDomain editingDomain;
		private final IXtextDocument xtextDocument;
		private final XtextResource xtextResource;
		private final ModelChangeNotifier modelChangeNotifier;
		private final IProject project;
		private final Void<XtextResource> work;
		private final RecordingCommand cmd;

		public ConditionModification(final String newText, final TransactionalEditingDomain editingDomain,
				final IXtextDocument xtextDocument,
				final XtextResource xtextResource, final ModelChangeNotifier modelChangeNotifier,
				final IProject project, final TextValue textVal) {
			this.editingDomain = editingDomain;
			this.xtextDocument = xtextDocument;
			this.xtextResource = xtextResource;
			this.modelChangeNotifier = modelChangeNotifier;
			this.project = project;
			this.work = createUpdateProcess(textVal.offset - 1, textVal.length, newText);
			this.cmd = createRecordingCommand(editingDomain, xtextResource);
		}

		/**
		 * Create the modification for updating source text
		 * @param updateOffset is the offset in the text to update
		 * @param prevLength is the previous length of text to replace
		 * @param newText is the new text to replace old text
		 */
		private Void<XtextResource> createUpdateProcess(final int updateOffset, final int prevLength,
				final String newText) {
			return new IUnitOfWork.Void<XtextResource>() {
				@Override
				public void process(final XtextResource state) throws Exception {
					state.update(updateOffset, prevLength, newText);
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
			final String originalText = getText(xtextDocument, xtextResource);
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
			return new ConditionModification(originalText, editingDomain, xtextDocument, xtextResource,
					modelChangeNotifier, project, new TextValue(originalText));
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
				if (!editingDomain.getCommandStack().canUndo()
						|| editingDomain.getCommandStack().getUndoCommand() != cmd) {
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
						final SyncUtil syncUtil = Aadl2Activator.getInstance()
								.getInjector(Aadl2Activator.ORG_OSATE_XTEXT_AADL2_AADL2).getInstance(SyncUtil.class);

						// Only waiting once will result in the reconciler processing a change outside the lock.
						// Doing it twice appears to wait for pending runs of the reconciler.
						syncUtil.waitForReconciler(xtextEditor);
						syncUtil.waitForReconciler(xtextEditor);
					}
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
		final Injector injector = Objects.requireNonNull(
				Aadl2Activator.getInstance().getInjector(Aadl2Activator.ORG_OSATE_XTEXT_AADL2_AADL2),
				"Unable to retrieve injector");

		final LanguageNameRetriever obj = injector.getInstance(LanguageNameRetriever.class);
		return obj.languageName;
	}

	/**
	 * Holds whole source text for the model and offset and length for editing
	 */
	private static class TextValue {
		private final String wholeText;
		private final int offset;
		private final int length;

		public TextValue(final String wholeText) {
			this.wholeText = wholeText;
			offset = 1;
			length = wholeText.length();
		}

		public TextValue(final String prefix, final String conditionText, final String suffix,
				final int updateOffset) {
			final String prefixWithLineEnding = prefix + "\n";
			wholeText = prefixWithLineEnding + conditionText + "\n" + suffix;

			offset = prefixWithLineEnding.length();
			length = conditionText.length();
		}
	}

}
