package org.osate.ge.ba.ui.properties;

import java.util.Objects;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.Adapters;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.IFilter;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.xbase.lib.Pair;
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

import com.google.common.collect.Iterators;
import com.google.common.collect.PeekingIterator;

public class BehaviorTransitionPropertySection extends AbstractPropertySection {
	public static class Filter implements IFilter {
		@Override
		public boolean select(final Object toTest) {
			return PropertySectionUtil.isBocCompatible(toTest, boc -> isBehaviorTransition(boc));
		}
	}

	public static String WIDGET_ID_CONDITION = "org.osate.ge.ba.behaviortransition.dispatchcondition";
	public static String WIDGET_ID_EDIT_CONDITION = "org.osate.ge.ba.behaviortransition.dispatchcondition.edit";
	private Composite container;
	private EmbeddedEditingControls conditionEditingControls;
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
		SwtUtil.setColorsToMatchParent(conditionLabel);

		final Composite conditionComposite = createComposite(container);
		// Create container for styled text and edit button
		conditionEditingControls = new EmbeddedEditingControls(conditionComposite);
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
		selectedBos.bocStream().filter(
				boc -> isBehaviorTransition(boc) && ProjectUtil.getProjectForBo(boc.getBusinessObject()).isPresent())
				.findAny().ifPresent(selectedBoc -> {
					conditionEditingControls.dispose();

					final BehaviorTransition behaviorTransition = (BehaviorTransition) selectedBoc.getBusinessObject();
					final TransactionalEditingDomain editingDomain = (TransactionalEditingDomain) AdapterFactoryEditingDomain
							.getEditingDomainFor(behaviorTransition);
					final IProject project = ProjectUtil.getProjectForBoOrThrow(behaviorTransition);
					final XtextResource xtextResource = getXtextResource(behaviorTransition)
							.orElseThrow(() -> new RuntimeException("resource must be XtextResource"));
					final IXtextDocument xtextDocument = getXtextDocument(behaviorTransition).orElse(null);
					// Source text
					final String sourceText = getText(xtextDocument, xtextResource);
					final boolean isSingleSelection = selectedBos.bocStream().limit(2).count() == 1;
					createConditionControls(behaviorTransition, sourceText, isSingleSelection, editingDomain,
							xtextDocument, xtextResource, project);
				});

		// Layout controls for refresh
		conditionEditingControls.requestLayout();
	}

	private void createConditionControls(final BehaviorTransition behaviorTransition, final String sourceText,
			final boolean isSingleSelection, final TransactionalEditingDomain editingDomain,
			final IXtextDocument xtextDocument, final XtextResource xtextResource, final IProject project) {
		// Create condition text value
		final EmbeddedTextValue conditionTextValue = getConditionTextValue(behaviorTransition, sourceText);

		// Styled text to enter the new condition text
		conditionEditingControls.createStyledText(SWT.BORDER | SWT.SINGLE, isSingleSelection);
		final StyledText styledText = conditionEditingControls.getStyledText();
		SwtUtil.setTestingId(styledText, WIDGET_ID_CONDITION);

		// Button to execute the modification
		conditionEditingControls.createEditButton(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				final EmbeddedXtextAdapter xtextAdapter = new EmbeddedXtextAdapter(project, conditionTextValue);
				final BiFunction<BehaviorTransition, String, Boolean> isValidModification = (bt, newText) -> {
					final BehaviorCondition condition = bt.getCondition();
					// Calculate enabled based on if condition should exist and if it exists
					return newText.isEmpty() ? condition == null : condition != null;
				};

				final EditEmbeddedDialog dlg = new EditEmbeddedDialog(Display.getCurrent().getActiveShell(),
						"Enter new dispatch condition.", "Condition: ", xtextAdapter,
						behaviorTransition, isValidModification);
				if (dlg.open() == Window.OK) {
					// Edit condition
					BehaviorAnnexSelectionUtil.getActiveEditor().ifPresent(editorPart -> {
						final ActionService actionService = Adapters.adapt(editorPart, ActionService.class);
						final ModelChangeNotifier modelChangeNotifier = Objects.requireNonNull(
								editorPart.getAdapter(ModelChangeNotifier.class),
								"Unable to get model change notifier");
						actionService.execute("Modifying Behavior Transition Condition", ExecutionMode.NORMAL,
								new EmbeddedModificationAction(editingDomain, xtextDocument, xtextResource,
										modelChangeNotifier, project,
										dlg.getText(), conditionTextValue));
					});
				}
			}
		}, isSingleSelection);

		final Button editBtn = conditionEditingControls.getEditButton();
		SwtUtil.setTestingId(editBtn, WIDGET_ID_EDIT_CONDITION);

		// Create xtext adapter for property view
		conditionEditingControls.createXtextAdapter(project, conditionTextValue);
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
	private int findUncommentedCharPair(final String str, final Pair<Character, Character> charsToMatch) {
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

	private EmbeddedTextValue getConditionTextValue(final BehaviorTransition behaviorTransition, final String text) {
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
			final Pair<Character, Character> charsToMatch = new Pair<Character, Character>('-', '[');
			// Find index for beginning of condition text "-["
			final int conditionOffset = findUncommentedCharPair(text.substring(transitionOffset), charsToMatch)
					+ transitionOffset;

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
		return new EmbeddedTextValue(text, prefix, conditionText, suffix);
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
