package org.osate.ge.ba.ui.properties;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.Adapters;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.IFilter;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.impl.ListBasedDiagnosticConsumer;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.xbase.lib.Pair;
import org.osate.ba.aadlba.BehaviorActionBlock;
import org.osate.ba.aadlba.BehaviorCondition;
import org.osate.ba.aadlba.BehaviorTransition;
import org.osate.ba.declarative.DeclarativeBehaviorTransition;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.BusinessObjectSelection;
import org.osate.ge.ProjectUtil;
import org.osate.ge.ba.util.BehaviorAnnexSelectionUtil;
import org.osate.ge.internal.services.ActionExecutor.ExecutionMode;
import org.osate.ge.internal.services.ActionService;
import org.osate.ge.internal.services.ModelChangeNotifier;
import org.osate.ge.internal.ui.xtext.AgeXtextUtil;
import org.osate.ge.swt.SwtUtil;
import org.osate.ge.ui.PropertySectionUtil;
import org.osate.xtext.aadl2.ui.internal.Aadl2Activator;

import com.google.common.collect.Iterators;
import com.google.common.collect.PeekingIterator;
import com.google.inject.Injector;

public class BehaviorTransitionPropertySection extends AbstractPropertySection {
	public static class Filter implements IFilter {
		@Override
		public boolean select(final Object toTest) {
			return PropertySectionUtil.isBocCompatible(toTest, boc -> isBehaviorTransition(boc));
		}
	}

	public static String WIDGET_ID_CONDITION = "org.osate.ge.ba.behaviortransition.condition";
	public static String WIDGET_ID_ACTION_BLOCK = "org.osate.ge.ba.behaviortransition.action";
	final static Injector injector = Aadl2Activator.getInstance()
			.getInjector(Aadl2Activator.ORG_OSATE_XTEXT_AADL2_AADL2);
	private Composite container;
	private EmbeddedEditingControls conditionEditingControls;
	private EmbeddedEditingControls actionBlockEditingControls;
	private BusinessObjectSelection selectedBos;

	@Override
	public void setInput(final IWorkbenchPart part, final ISelection selection) {
		super.setInput(part, selection);
		selectedBos = Adapters.adapt(selection, BusinessObjectSelection.class);
	}

	@Override
	public void createControls(final Composite parent, final TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);
		// Create composite for widgets
		container = getWidgetFactory().createPlainComposite(parent, SWT.NONE);
		container.setLayout(GridLayoutFactory.swtDefaults().numColumns(2).create());

		final Label conditionLabel = new Label(container, SWT.NONE);
		conditionLabel.setText("Condition: ");
		// createComposite(composite);
		SwtUtil.setColorsToMatchParent(conditionLabel);

		final Composite conditionComposite = createComposite(container);
		// Create container for styled text and save button
		conditionEditingControls = new EmbeddedEditingControls(conditionComposite);

		final Label actionBlockLabel = new Label(container, SWT.NONE);
		actionBlockLabel.setText("Action: ");
		SwtUtil.setColorsToMatchParent(actionBlockLabel);

		// Create container for styled text and save button
		final Composite actionBlockComposite = createComposite(container);
		actionBlockEditingControls = new EmbeddedEditingControls(actionBlockComposite);
	}

	private Composite createComposite(final Composite parent) {
		final Composite container = getWidgetFactory().createPlainComposite(parent, SWT.NONE);
		container.setLayout(GridLayoutFactory.swtDefaults().numColumns(2).create());
		container.setLayoutData(GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true)
				.hint(SWT.DEFAULT, SWT.DEFAULT).create());
		return container;
	}

	@Override
	public void refresh() {
		final boolean isSingleSelection = selectedBos.bocStream().limit(2).count() == 1;
		selectedBos.bocStream().filter(
				boc -> isBehaviorTransition(boc) && ProjectUtil.getProjectForBo(boc.getBusinessObject()).isPresent())
				.findAny().ifPresent(selectedBoc -> {
					disposeControls();
					final BehaviorTransition behaviorTransition = (BehaviorTransition) selectedBoc.getBusinessObject();
					final TransactionalEditingDomain editingDomain = (TransactionalEditingDomain) AdapterFactoryEditingDomain
							.getEditingDomainFor(behaviorTransition);
					final IProject project = ProjectUtil.getProjectForBoOrThrow(behaviorTransition);
					final XtextResource xtextResource = getXtextResource(behaviorTransition)
							.orElseThrow(() -> new RuntimeException("resource must be XtextResource"));
					final IXtextDocument xtextDocument = getXtextDocument(behaviorTransition).orElse(null);
					// Source text
					final String sourceText = getText(xtextDocument, xtextResource);
					createConditionControls(behaviorTransition, sourceText, isSingleSelection, editingDomain, xtextDocument,
							xtextResource, project);
					createActionBlockControls(behaviorTransition, sourceText, isSingleSelection, editingDomain, xtextDocument,
							xtextResource, project);
				});

		// Layout controls
		conditionEditingControls.requestLayout();
		actionBlockEditingControls.requestLayout();
	}

	private void disposeControls() {
		conditionEditingControls.dispose();
		actionBlockEditingControls.dispose();
	}

	private void createConditionControls(final BehaviorTransition behaviorTransition, final String text,
			final boolean isSingleSelection, final TransactionalEditingDomain editingDomain,
			final IXtextDocument xtextDocument, final XtextResource xtextResource, final IProject project) {
		// Create condition text value
		final TextValue conditionTextValue = getConditionTextValue(behaviorTransition, text);

		// Styled text to enter the new condition text
		conditionEditingControls.createStyledText(SWT.BORDER | SWT.SINGLE, isSingleSelection,
				new ConditionModificationKeyAdapter(behaviorTransition, conditionEditingControls, conditionTextValue.getEditableText()));
		SwtUtil.setTestingId(conditionEditingControls.getStyledText(), WIDGET_ID_CONDITION);

		// Button to execute the modification
		conditionEditingControls.createSaveButton(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				final String modifiedSrc = conditionEditingControls.getXtextAdapter().getModifiedSource();
				if (modifiedSrc != null) {
					BehaviorAnnexSelectionUtil.getActiveEditor().ifPresent(editorPart -> {
						final ActionService actionService = Adapters.adapt(editorPart, ActionService.class);
						final ModelChangeNotifier modelChangeNotifier = Objects.requireNonNull(
								editorPart.getAdapter(ModelChangeNotifier.class),
								"Unable to get model change notifier");
						actionService.execute("Modifying BehaviorTranistion Condition", ExecutionMode.NORMAL,
								new EmbeddedModificationAction(editingDomain, xtextDocument, xtextResource, modelChangeNotifier,
										project, text, modifiedSrc));
					});
				}
			}
		});

		// Dispose of current adapter and create new one
		conditionEditingControls.setXtextAdapter(project);
		conditionEditingControls.updateAdapterDocument(conditionTextValue);
	}

	private void createActionBlockControls(final BehaviorTransition behaviorTransition, final String text,
			final boolean isSingleSelection, final TransactionalEditingDomain editingDomain,
			final IXtextDocument xtextDocument, final XtextResource xtextResource, final IProject project) {
		// Create condition text value
		final TextValue actionBlockTextValue = getActionBlockTextValue(behaviorTransition, text);

		// Styled text to enter the new condition text
		actionBlockEditingControls.createStyledText(SWT.BORDER | SWT.V_SCROLL | SWT.WRAP | SWT.MULTI, isSingleSelection,
				GridDataFactory.swtDefaults().hint(SWT.DEFAULT, 100).grab(true, false).align(SWT.FILL, SWT.CENTER)
						.create(),
				new ActionModificationKeyAdapter(behaviorTransition, actionBlockEditingControls, actionBlockTextValue));
		SwtUtil.setTestingId(actionBlockEditingControls.getStyledText(), WIDGET_ID_ACTION_BLOCK);

		// Button to execute the modification
		actionBlockEditingControls.createSaveButton(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				final String modifiedSrc = actionBlockEditingControls.getXtextAdapter().getModifiedSource();
				if (modifiedSrc != null) {
					BehaviorAnnexSelectionUtil.getActiveEditor().ifPresent(editorPart -> {
						final ActionService actionService = Adapters.adapt(editorPart, ActionService.class);
						final ModelChangeNotifier modelChangeNotifier = Objects.requireNonNull(
								editorPart.getAdapter(ModelChangeNotifier.class),
								"Unable to get model change notifier");
						actionService.execute("Modifying BehaviorTranistion Action Block", ExecutionMode.NORMAL,
								new EmbeddedModificationAction(editingDomain, xtextDocument, xtextResource, modelChangeNotifier,
										project, text, modifiedSrc));
					});
				}
			}
		});

		// Dispose of current adapter and create new one
		actionBlockEditingControls.setXtextAdapter(project);
		actionBlockEditingControls.updateAdapterDocument(actionBlockTextValue);
	}

	private TextValue getActionBlockTextValue(final BehaviorTransition behaviorTransition, final String text) {
		final BehaviorActionBlock actionBlock = behaviorTransition.getActionBlock();

		// Text before action block
		final String prefix;
		// Action block text
		final String actionText;
		// Text after action block
		final String suffix;
		if (actionBlock == null) {
			// Transition offset
			final int transitionOffset = behaviorTransition.getAadlBaLocationReference().getOffset();
			final String transitionText = text.substring(transitionOffset);
			// Find transition terminating semicolon offset
			final int terminationOffset = findUncommentedChar(transitionText, ';') + transitionOffset;

			// Transition action prefix and add open bracket for action
			prefix = text.substring(0, terminationOffset)
					+ " {";
			// Empty condition text
			actionText = "";
			// Add bracket to close action text
			suffix = "}" + text.substring(terminationOffset);
		} else {
			// Condition offset
			final int updateOffset = actionBlock.getAadlBaLocationReference().getOffset() + 1;
			prefix = text.substring(0, updateOffset);

			// Note: Condition length only counts until the first space (assuming).
			// For example, when dispatch condition is "on dispatch" length is 2.
			// Find closing "]", to get condition text
			final String afterTransitionText = text.substring(updateOffset);
			// Find action ending offset
			final int terminationOffset = findUncommentedChar(afterTransitionText, '}') + updateOffset;

			// Split action at new line character for formatting in styled text
			final String[] actionTextSplit = text.substring(updateOffset, terminationOffset)
					.split("\\n");
			actionText = getTrimmedActionText(actionTextSplit);
			suffix = text.substring(terminationOffset);
		}

		// Create condition value
		return new TextValue(prefix, actionText, suffix);
	}

	private String getTrimmedActionText(final String[] actionTextSplit) {
		// Strip starting text from each text line
		final String regex = "^\\s+";
		final StringBuilder actionTextBuilder = new StringBuilder();
		for (final String s : actionTextSplit) {
			actionTextBuilder.append(s.replaceAll(regex, ""));
		}
		return actionTextBuilder.toString();
	}

	/**
	 * Find offset of character in string that is not commented out
	 */
	private int findUncommentedChar(final String str, final char delim) {
		final PeekingIterator<Character> charPeekingIt = Iterators
				.peekingIterator(str.chars().mapToObj(e -> (char) e).collect(Collectors.toList()).iterator());
		for (int offset = 0; charPeekingIt.hasNext(); offset++) {
			final Character c = charPeekingIt.next();
			if (c == delim) {
				return offset;
			} else if (c == '-' && charPeekingIt.peek() == '-') {
				for (offset = offset + 1; charPeekingIt.hasNext(); offset++) {
					final Character tmp = charPeekingIt.next();
					if (tmp == '\n') {
						break;
					}
				}
			}
		}

		throw new RuntimeException("Cannot find terminating character");
	}

	/**
	 * Find offset of a pair characters in string that is not commented out
	 */
	private int findUncommentedCharPair(final String str,
			final Pair<Character, Character> charsToMatch) {
		final PeekingIterator<Character> charPeekingIt = Iterators
				.peekingIterator(str.chars().mapToObj(e -> (char) e).collect(Collectors.toList()).iterator());
		for (int offset = 0; charPeekingIt.hasNext(); offset++) {
			final Character c = charPeekingIt.next();
			if (c == charsToMatch.getKey() && charPeekingIt.peek() == charsToMatch.getValue()) {
				return offset + 2;
			} else if (c == '-' && charPeekingIt.peek() == '-') {
				for (offset = offset + 1; charPeekingIt.hasNext(); offset++) {
					final Character tmp = charPeekingIt.next();
					if (tmp == '\n') {
						break;
					}
				}
			}
		}

		throw new RuntimeException("Cannot find character sequence " + charsToMatch.toString());
	}

	private class ActionModificationKeyAdapter extends KeyAdapter {
		private final BehaviorTransition behaviorTransition;
		private final EmbeddedEditingControls embeddedControls;
		private final TextValue textValue;

		public ActionModificationKeyAdapter(final BehaviorTransition behaviorTransition,
				final EmbeddedEditingControls controls, final TextValue textValue) {
			this.behaviorTransition = behaviorTransition;
			this.embeddedControls = controls;
			this.textValue = textValue;
		}

		@Override
		public void keyReleased(final KeyEvent e) {
			// Return if no changes were made
			final String newText = embeddedControls.getStyledText().getText().trim();
			if (newText.equals(textValue.getEditableText())) {
				embeddedControls.setModificationState(null);
				return;
			}
			// Update save button based on whether the text entered into the
			// styled text is a serializable condition
			final EObject rootElement = embeddedControls.getXtextAdapter().getXtextParseResult().getRootASTElement();
			final XtextResource fakeResource = embeddedControls.getXtextAdapter().getFakeResourceContext()
					.getFakeResource();
			// Link model
			fakeResource.getLinker().linkModel(rootElement, new ListBasedDiagnosticConsumer());

			// Original source text
			String originalSrc = embeddedControls.getXtextAdapter().getText();
			try {
				// Serialized/Modified source text
				String modifiedSrc = embeddedControls.getXtextAdapter().serialize();
				if (newText.isEmpty()) {
					// Remove brackets for empty action block
					modifiedSrc = textValue.getPrefix().substring(0, textValue.getPrefix().lastIndexOf("{"))
							+ textValue.getSuffix().split("}", 2)[1];
				}

				// Load for error checking
				loadResource(fakeResource, modifiedSrc);

				boolean isValid = false;
				// Check if BehaviorTransition still exists, meaning the modification did not break serialization
				final BehaviorTransition behaviorTransition = (BehaviorTransition) fakeResource
						.getEObject(EcoreUtil.getURI(this.behaviorTransition).fragment());

				if (behaviorTransition != null) {
					final BehaviorActionBlock actionBlock = behaviorTransition.getActionBlock();
					// Calculate enabled based on if action should exist and if it exists
					isValid = newText.isEmpty() ? actionBlock == null
							: actionBlock != null;
				}

				embeddedControls.setModificationState(isValid ? modifiedSrc : null);
			} catch (final Exception ex) {
				embeddedControls.setModificationState(null);
			} finally {
				// Load original source
				loadResource(fakeResource, originalSrc);
			}
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

	private class ConditionModificationKeyAdapter extends KeyAdapter {
		private final BehaviorTransition behaviorTransition;
		private final EmbeddedEditingControls embeddedControls;
		private final String editableText;

		public ConditionModificationKeyAdapter(final BehaviorTransition behaviorTransition,
				final EmbeddedEditingControls controls, final String editableText) {
			this.behaviorTransition = behaviorTransition;
			this.embeddedControls = controls;
			this.editableText = editableText;
		}

		@Override
		public void keyReleased(final KeyEvent e) {
			// Return if no changes were made
			final String newText = embeddedControls.getStyledText().getText().trim();
			if (newText.equals(editableText)) {
				embeddedControls.setModificationState(null);
				return;
			}
			// Update save button based on whether the text entered into the
			// styled text is a serializable condition
			final EObject rootElement = embeddedControls.getXtextAdapter().getXtextParseResult().getRootASTElement();
			final XtextResource fakeResource = embeddedControls.getXtextAdapter().getFakeResourceContext().getFakeResource();
			// Link model
			fakeResource.getLinker().linkModel(rootElement, new ListBasedDiagnosticConsumer());

			// Original source text
			String originalSrc = embeddedControls.getXtextAdapter().getText();

			try {
				// Modified source text
				final String modifiedSrc = fakeResource.getSerializer().serialize(rootElement);
				// Load for error checking
				loadResource(fakeResource, modifiedSrc);

				boolean isValid = false;
				// Check if BehaviorTransition still exists, meaning the modification did not break serialization
				final BehaviorTransition behaviorTransition = (BehaviorTransition) fakeResource
						.getEObject(EcoreUtil.getURI(this.behaviorTransition).fragment());

				if (behaviorTransition != null) {
					final BehaviorCondition condition = behaviorTransition.getCondition();
					// Calculate enabled based on if condition should exist and if it exists
					isValid = newText.isEmpty() ? condition == null : condition != null;
				}

				embeddedControls.setModificationState(isValid ? modifiedSrc : null);
			} catch (final Exception ex) {
				embeddedControls.setModificationState(null);
			} finally {
				// Load original source
				loadResource(fakeResource, originalSrc);
			}
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

		// Text before condition
		final String prefix;
		// Condition text
		final String conditionText;
		// Text after condition
		final String suffix;
		if (condition == null) {
			// Transition offset
			final int transitionOffset = behaviorTransition.getAadlBaLocationReference().getOffset();
			final Pair<Character, Character> charsToMatch = new Pair<Character, Character>(
					'-', '[');
			// Find index for beginning of condition text "-["
			final int conditionOffset = findUncommentedCharPair(text.substring(transitionOffset),
					charsToMatch) + transitionOffset;

			// Prefix is text before condition text
			prefix = text.substring(0, conditionOffset);

			// Find condition text and suffix
			final String afterPrefix = text.substring(conditionOffset);

			// Find closing "]", to get condition text
			final int endingConditionOffset = findUncommentedChar(afterPrefix, ']');
			conditionText = afterPrefix.substring(0, endingConditionOffset).trim();

			// Suffix is text after condition text
			suffix = afterPrefix.substring(endingConditionOffset);
		} else {
			// Condition offset
			final int updateOffset = condition.getAadlBaLocationReference().getOffset();

			// Prefix is text before condition text
			prefix = text.substring(0, condition.getAadlBaLocationReference().getOffset());

			// Note: condition.getAadlBaLocationReference().getLength() only counts until the first space (assuming).
			// For example, when dispatch condition is "on dispatch" length is 2.
			// Find closing "]", to get condition text
			final int conditionEnd = findUncommentedChar(text.substring(updateOffset), ']') + updateOffset;
			// Condition text
			conditionText = text.substring(updateOffset, conditionEnd).trim();

			// Text after transition condition
			suffix = text.substring(conditionEnd);
		}

		// Create condition value
		return new TextValue(prefix, conditionText, suffix);
	}

	private static Optional<IXtextDocument> getXtextDocument(final BehaviorTransition behaviorTransition) {
		return Optional.ofNullable(AgeXtextUtil.getDocumentByRootElement(behaviorTransition.getElementRoot()));
	}

	// All source text
	private static String getText(final IXtextDocument xtextDocument, final XtextResource xtextResource) {
		if (xtextDocument == null) {
			return xtextResource.getParseResult().getRootNode().getText();
		}

		return xtextDocument.get();
	}

	private static boolean isBehaviorTransition(final BusinessObjectContext boc) {
		final Object bo = boc.getBusinessObject();
		return bo instanceof BehaviorTransition || bo instanceof DeclarativeBehaviorTransition;
	}

	private static Optional<XtextResource> getXtextResource(final BehaviorTransition behaviorTransition) {
		final Resource resource = behaviorTransition.eResource();
		return Optional.ofNullable(resource instanceof XtextResource ? (XtextResource) resource : null);
	}
}
