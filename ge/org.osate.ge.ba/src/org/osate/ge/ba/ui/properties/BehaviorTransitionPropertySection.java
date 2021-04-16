package org.osate.ge.ba.ui.properties;

import java.util.Objects;
import java.util.Optional;
import java.util.function.BiFunction;

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
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.xtext.resource.XtextResource;
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
import org.osate.ge.ba.util.BehaviorAnnexXtextUtil;
import org.osate.ge.internal.services.ActionExecutor.ExecutionMode;
import org.osate.ge.internal.services.ActionService;
import org.osate.ge.internal.services.ModelChangeNotifier;
import org.osate.ge.internal.ui.xtext.AgeXtextUtil;
import org.osate.ge.swt.SwtUtil;
import org.osate.ge.ui.PropertySectionUtil;

/**
 * Property section for {@link BehaviorTransition}
 */
public class BehaviorTransitionPropertySection extends AbstractPropertySection {
	public static class Filter implements IFilter {
		@Override
		public boolean select(final Object toTest) {
			return PropertySectionUtil.isBocCompatible(toTest, boc -> isBehaviorTransition(boc));
		}
	}

	public static String WIDGET_ID_CONDITION = "org.osate.ge.ba.behaviortransition.dispatchcondition";
	public static String WIDGET_ID_EDIT_CONDITION = WIDGET_ID_CONDITION + ".edit";
	public static String WIDGET_ID_ACTION_BLOCK = "org.osate.ge.ba.behaviortransition.actionblock";
	public static String WIDGET_ID_EDIT_ACTION_BLOCK = WIDGET_ID_ACTION_BLOCK + ".edit";
	private Composite container;
	private EmbeddedTextControls conditionEditingControls;
	private EmbeddedTextControls actionBlockEditingControls;
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

		conditionEditingControls = new EmbeddedTextControls(container, SWT.NONE, SWT.BORDER | SWT.SINGLE, SWT.PUSH,
				"Edit...");

		final Label actionBlockLabel = new Label(container, SWT.NONE);
		actionBlockLabel.setText("Action: ");
		SwtUtil.setColorsToMatchParent(actionBlockLabel);

		actionBlockEditingControls = new EmbeddedTextControls(container, SWT.NONE,
				SWT.BORDER | SWT.V_SCROLL | SWT.WRAP | SWT.MULTI, SWT.PUSH, "Edit...");
	}

	@Override
	public void refresh() {
		selectedBos.bocStream().filter(
				boc -> isBehaviorTransition(boc) && ProjectUtil.getProjectForBo(boc.getBusinessObject()).isPresent())
				.findAny().ifPresent(selectedBoc -> {
					disposeControls();

					conditionEditingControls = new EmbeddedTextControls(container, SWT.NONE, SWT.BORDER | SWT.SINGLE,
							SWT.PUSH, "Edit...");
					conditionEditingControls.setStyledTextLayoutData(GridDataFactory.swtDefaults()
							.align(SWT.FILL, SWT.FILL).grab(true, true).hint(SWT.DEFAULT, SWT.DEFAULT).create());
					conditionEditingControls.setStyledTextTestId(WIDGET_ID_CONDITION);
					conditionEditingControls.setButtonTestId(WIDGET_ID_EDIT_CONDITION);

					actionBlockEditingControls = new EmbeddedTextControls(container, SWT.NONE,
							SWT.BORDER | SWT.V_SCROLL | SWT.WRAP | SWT.MULTI,
							SWT.PUSH, "Edit...");
					actionBlockEditingControls.setStyledTextLayoutData(GridDataFactory.swtDefaults()
							.align(SWT.FILL, SWT.FILL).grab(true, false).hint(SWT.DEFAULT, SWT.DEFAULT).create());
					actionBlockEditingControls.setStyledTextTestId(WIDGET_ID_ACTION_BLOCK);
					actionBlockEditingControls.setButtonTestId(WIDGET_ID_EDIT_ACTION_BLOCK);

					final boolean isSingleSelection = selectedBos.bocStream().limit(2).count() == 1;
					if (!isSingleSelection) {
						setControlsToMultipleSelected();
					} else {
						final BehaviorTransition behaviorTransition = (BehaviorTransition) selectedBoc
								.getBusinessObject();
						final TransactionalEditingDomain editingDomain = (TransactionalEditingDomain) AdapterFactoryEditingDomain
								.getEditingDomainFor(behaviorTransition);
						final IProject project = ProjectUtil.getProjectForBoOrThrow(behaviorTransition);
						final XtextResource xtextResource = getXtextResource(behaviorTransition)
								.orElseThrow(() -> new RuntimeException("resource must be XtextResource"));
						final IXtextDocument xtextDocument = getXtextDocument(behaviorTransition).orElse(null);
						final String sourceText = BehaviorAnnexXtextUtil.getText(xtextDocument, xtextResource);
						// Value
						final EmbeddedTextValue conditionTextValue = getConditionTextValue(behaviorTransition,
								sourceText);
						final SelectionAdapter editConditionSelectionAdapter = getEditConditionSelectionAdapter(project,
								conditionTextValue, behaviorTransition, editingDomain, xtextDocument, xtextResource);
						conditionEditingControls.addSelectionListener(editConditionSelectionAdapter);
						// Create xtext adapter for property view
						conditionEditingControls.createXtextAdapter(project, conditionTextValue);

						final EmbeddedTextValue actionTextValue = getActionBlockTextValue(behaviorTransition,
								sourceText);
						final SelectionAdapter editActionSelectionAdapter = getEditActionSelectionAdapter(project,
								conditionTextValue, behaviorTransition, editingDomain, xtextDocument, xtextResource);
						actionBlockEditingControls.createXtextAdapter(project, actionTextValue);
					}
				});

		// Layout controls for refresh
		layout();
	}

	private SelectionAdapter getEditActionSelectionAdapter(final IProject project,
			final EmbeddedTextValue conditionTextValue, final BehaviorTransition behaviorTransition,
			final TransactionalEditingDomain editingDomain, final IXtextDocument xtextDocument,
			final XtextResource xtextResource) {
		// TODO Auto-generated method stub
		return null;
	}

	private void setControlsToMultipleSelected() {
		final String msg = "<Multiple>";
		conditionEditingControls.setEnabled(false);
		conditionEditingControls.setStyledTextText(msg);

		actionBlockEditingControls.setEnabled(false);
		actionBlockEditingControls.setStyledTextText(msg);
	}

	private void disposeControls() {
		if (conditionEditingControls != null) {
			conditionEditingControls.dispose1();
		}

		if (actionBlockEditingControls != null) {
			actionBlockEditingControls.dispose1();
		}
	}

	private void layout() {
		conditionEditingControls.requestLayout();
		actionBlockEditingControls.requestLayout();
	}

	private SelectionAdapter getEditConditionSelectionAdapter(final IProject project,
			final EmbeddedTextValue conditionTextValue, final BehaviorTransition behaviorTransition,
			final TransactionalEditingDomain editingDomain, final IXtextDocument xtextDocument,
			final XtextResource xtextResource) {
		return new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				final EmbeddedXtextAdapter xtextAdapter = new EmbeddedXtextAdapter(project, conditionTextValue);
				final BiFunction<BehaviorTransition, String, Boolean> isValidModification = (bt, newText) -> {
					final BehaviorCondition condition = bt.getCondition();
					// Calculate enabled based on if condition should exist and if it exists
					return newText.isEmpty() ? condition == null : condition != null;
				};

				final EditEmbeddedTextDialog dlg = new EditEmbeddedTextDialog(Display.getCurrent().getActiveShell(),
						"Edit Transition Condition", "Enter new dispatch condition.", xtextAdapter, behaviorTransition,
						isValidModification);
				if (dlg.open() == Window.OK) {
					// Edit condition
					BehaviorAnnexSelectionUtil.getActiveEditor().ifPresent(editorPart -> {
						final ActionService actionService = Adapters.adapt(editorPart, ActionService.class);
						final ModelChangeNotifier modelChangeNotifier = Objects.requireNonNull(
								editorPart.getAdapter(ModelChangeNotifier.class),
								"Unable to get model change notifier");
						actionService.execute("Modifying Behavior Transition Condition", ExecutionMode.NORMAL,
								new EmbeddedTextModificationAction(editingDomain, xtextDocument, xtextResource,
										modelChangeNotifier, project, dlg.getText(), conditionTextValue));
					});
				}
			}
		};
	}

	private EmbeddedTextValue getConditionTextValue(final BehaviorTransition behaviorTransition, final String sourceText) {
		final int conditionOffset = getConditionOffset(behaviorTransition, sourceText);

		// Text before condition text
		final String prefix = sourceText.substring(0, conditionOffset);

		// Find condition text and suffix
		final String afterPrefix = sourceText.substring(conditionOffset);

		// Note: condition.getAadlBaLocationReference().getLength() only counts until the first space (assuming).
		// For example, when dispatch condition is "on dispatch" length is 2.
		// Find closing "]", to get condition text
		final int conditionEnd = BehaviorAnnexXtextUtil.findUncommentedChar(afterPrefix, ']');

		// Condition text
		final String conditionText = afterPrefix.substring(0, conditionEnd).trim();

		// Text after transition condition
		final String suffix = afterPrefix.substring(conditionEnd);

		// Create condition value
		return new EmbeddedTextValue(sourceText, prefix, conditionText, suffix);
	}

	private int getConditionOffset(final BehaviorTransition behaviorTransition, final String sourceText) {
		final BehaviorCondition condition = behaviorTransition.getCondition();
		final int conditionOffset;
		if (condition == null) {
			// Transition offset
			final int transitionOffset = behaviorTransition.getAadlBaLocationReference().getOffset();
			final Pair<Character, Character> charsToMatch = new Pair<Character, Character>('-', '[');
			// Find index for beginning of condition text "-["
			conditionOffset = BehaviorAnnexXtextUtil.findUncommentedCharPair(sourceText.substring(transitionOffset),
					charsToMatch) + transitionOffset;
		} else {
			// Condition offset
			conditionOffset = condition.getAadlBaLocationReference().getOffset();
		}

		return conditionOffset;
	}

	private static Optional<IXtextDocument> getXtextDocument(final BehaviorTransition behaviorTransition) {
		return Optional.ofNullable(AgeXtextUtil.getDocumentByRootElement(behaviorTransition.getElementRoot()));
	}

	private static boolean isBehaviorTransition(final BusinessObjectContext boc) {
		final Object bo = boc.getBusinessObject();
		return bo instanceof BehaviorTransition || bo instanceof DeclarativeBehaviorTransition;
	}

	private static Optional<XtextResource> getXtextResource(final BehaviorTransition behaviorTransition) {
		final Resource resource = behaviorTransition.eResource();
		return Optional.ofNullable(resource instanceof XtextResource ? (XtextResource) resource : null);
	}

	private EmbeddedTextValue getActionBlockTextValue(final BehaviorTransition behaviorTransition,
			final String src) {
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
			final String transitionText = src.substring(transitionOffset);
			// Find transition terminating semicolon offset
			final int terminationOffset = BehaviorAnnexXtextUtil.findUncommentedChar(transitionText, ';')
					+ transitionOffset;

			// Transition action prefix and add open bracket for action
			prefix = src.substring(0, terminationOffset) + "{";
			// Empty condition text
			actionText = "";
			// Add bracket to close action text
			suffix = "}" + src.substring(terminationOffset);
		} else {
			// Condition offset
			final int updateOffset = actionBlock.getAadlBaLocationReference().getOffset() + 1;
			prefix = src.substring(0, updateOffset);

			// Note: Condition length only counts until the first space (assuming).
			// For example, when dispatch condition is "on dispatch" length is 2.
			// Find closing "]", to get condition text
			final String afterTransitionText = src.substring(updateOffset);
			// Find action ending offset
			final int terminationOffset = BehaviorAnnexXtextUtil.findUncommentedChar(afterTransitionText, '}')
					+ updateOffset;

			// Split action at new line character for formatting in styled text
			final String[] actionTextSplit = src.substring(updateOffset, terminationOffset).split("\\n");
			actionText = getTrimmedActionText(actionTextSplit);

			suffix = src.substring(terminationOffset);
		}

		// Create condition value
		return new EmbeddedTextValue(src, prefix, actionText, suffix);
	}

	private String getTrimmedActionText(final String[] actionTextSplit) {
		// Trim each line in action block
		final StringBuilder actionTextBuilder = new StringBuilder();
		for (final String actionText : actionTextSplit) {
			actionTextBuilder.append(actionText.trim());
		}

		return actionTextBuilder.toString();
	}
}
