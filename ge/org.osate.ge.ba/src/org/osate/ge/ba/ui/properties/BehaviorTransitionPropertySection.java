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

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BiFunction;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.Adapters;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.IFilter;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.osate.ba.aadlba.BehaviorActionBlock;
import org.osate.ba.aadlba.BehaviorCondition;
import org.osate.ba.aadlba.BehaviorTransition;
import org.osate.ba.declarative.DeclarativeBehaviorTransition;
import org.osate.ba.unparser.AadlBaUnparser;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.BusinessObjectSelection;
import org.osate.ge.ProjectUtil;
import org.osate.ge.aadl2.AadlGraphicalEditorException;
import org.osate.ge.ba.businessobjecthandlers.BehaviorConditionUtil;
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
	private EmbeddedTextEditor conditionEditingControls;
	private EmbeddedTextEditor actionBlockEditingControls;
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
		conditionLabel.setText("Condition:");
		SwtUtil.setColorsToMatchParent(conditionLabel);

		conditionEditingControls = EmbeddedTextEditor.createSingleline(container, () -> {
			final BehaviorTransition behaviorTransition = selectedBos.boStream(BehaviorTransition.class)
					.findAny()
					.orElseThrow();
			final EmbeddedXtextAdapter xtextAdapter = new EmbeddedXtextAdapter(
					ProjectUtil.getProjectForBoOrThrow(behaviorTransition),
					conditionEditingControls.getAdapter().getTextValue());
			final BiFunction<EObject, String, Boolean> isValidModification = (bt, newText) -> {
				final BehaviorCondition condition = ((BehaviorTransition) bt).getCondition();
				// Calculate enabled based on if condition should exist and if it exists
				return newText.isEmpty() ? condition == null : condition != null;
			};

			final EditEmbeddedTextDialog dlg = new EditEmbeddedTextDialog(Display.getCurrent().getActiveShell(),
					"Edit Transition Condition", "Enter new dispatch condition.", xtextAdapter, SWT.BORDER | SWT.SINGLE,
					GridDataFactory.fillDefaults().indent(10, 0).grab(true, true).create(), behaviorTransition,
					isValidModification);
			if (dlg.open() == Window.OK) {
				// Edit condition
				BehaviorAnnexSelectionUtil.getActiveEditor().ifPresent(editorPart -> {
					final ActionService actionService = Adapters.adapt(editorPart, ActionService.class);
					final ModelChangeNotifier modelChangeNotifier = Objects.requireNonNull(
							editorPart.getAdapter(ModelChangeNotifier.class), "Unable to get model change notifier");
					final XtextResource xtextResource = getXtextResource(behaviorTransition)
							.orElseThrow(() -> new AadlGraphicalEditorException("resource must be XtextResource"));
					final IXtextDocument xtextDocument = getXtextDocument(behaviorTransition).orElse(null);
					if (xtextDocument != null) {
						// Execute modification with xtext document
						actionService.execute("Modifying Behavior Transition Condition", ExecutionMode.NORMAL,
								new EmbeddedTextModificationAction(xtextDocument, modelChangeNotifier,
										dlg.getResult().getFullSource()));
					} else {
						final TransactionalEditingDomain editingDomain = TransactionalEditingDomain.Factory.INSTANCE
								.getEditingDomain(behaviorTransition.eResource().getResourceSet());
						// Execute modification with xtext resource
						actionService.execute("Modifying Behavior Transition Condition", ExecutionMode.NORMAL,
								new EmbeddedTextModificationAction(editingDomain, xtextResource, modelChangeNotifier, dlg.getResult().getPartialSource(), xtextAdapter.getTextValue()));
					}
				});
			}
		});

		// Set layout data for the composite
		conditionEditingControls.setLayoutData(GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true)
				.hint(SWT.DEFAULT, SWT.DEFAULT).create());
		conditionEditingControls.setStyledTextTestId(WIDGET_ID_CONDITION);
		conditionEditingControls.setEditButtonTestId(WIDGET_ID_EDIT_CONDITION);

		final Label actionLabel = new Label(container, SWT.NONE);
		actionLabel.setText("Action:");
		SwtUtil.setColorsToMatchParent(actionLabel);

		actionBlockEditingControls = EmbeddedTextEditor.createMultiLine(container, () -> {
			final BehaviorTransition behaviorTransition = selectedBos.boStream(BehaviorTransition.class)
					.findAny()
					.orElseThrow();
			final EmbeddedXtextAdapter xtextAdapter = new EmbeddedXtextAdapter(
					ProjectUtil.getProjectForBoOrThrow(behaviorTransition),
					actionBlockEditingControls.getAdapter().getTextValue());
			final BiFunction<EObject, String, String> getModifiedSrc = (rootElement, newActionBlock) -> {
				String modifiedSrc = actionBlockEditingControls.getModifiedSource(rootElement);
				if (newActionBlock.isEmpty()) {
					// Remove brackets for empty action block
					final String prefix = actionBlockEditingControls.getValue().getPrefix();
					modifiedSrc = prefix.substring(0, prefix.length() - 1)
							+ actionBlockEditingControls.getValue().getSuffix().substring(1);
				}

				return modifiedSrc;
			};

			final BiFunction<EObject, String, Boolean> isValidModification = (bt, newText) -> {
				final BehaviorActionBlock actionBlock = ((BehaviorTransition) bt).getActionBlock();
				// Calculate enabled based on if action should exist and if it exists
				return newText.isEmpty() ? actionBlock == null : actionBlock != null;
			};

			final EditEmbeddedTextDialog dlg = new EditEmbeddedTextDialog(Display.getCurrent().getActiveShell(),
					"Edit Transition Action", "Enter new action block.", xtextAdapter,
					SWT.BORDER | SWT.V_SCROLL | SWT.WRAP | SWT.MULTI,
					GridDataFactory.fillDefaults().indent(10, 0).grab(true, true).hint(SWT.DEFAULT, 100).create(),
					behaviorTransition, getModifiedSrc, isValidModification);
			if (dlg.open() == Window.OK) {
				// Edit action
				BehaviorAnnexSelectionUtil.getActiveEditor().ifPresent(editorPart -> {
					final ActionService actionService = Adapters.adapt(editorPart, ActionService.class);
					final ModelChangeNotifier modelChangeNotifier = Objects.requireNonNull(
							editorPart.getAdapter(ModelChangeNotifier.class),
							"Unable to get model change notifier");
					final IXtextDocument xtextDocument = xtextAdapter.getXtextDocument();
					final XtextResource xtextResource = getXtextResource(behaviorTransition)
							.orElseThrow(() -> new AadlGraphicalEditorException("resource must be XtextResource"));
					if (xtextDocument != null) {
						// Get source text for xtext document
						final String srcText = dlg.getResult().getFullSource();
						// Execute modification with xtext document
						actionService.execute("Modifying Behavior Transition Action Block", ExecutionMode.NORMAL,
								new EmbeddedTextModificationAction(xtextDocument, modelChangeNotifier,
										srcText));
					} else {
						final TransactionalEditingDomain editingDomain = TransactionalEditingDomain.Factory.INSTANCE
								.getEditingDomain(behaviorTransition.eResource().getResourceSet());
						final EmbeddedTextValue actionTextValue = xtextAdapter.getTextValue();

						// Execute modification with xtext resource
						final boolean actionExists = !actionTextValue.getEditableText().isEmpty();
						String newText = dlg.getResult().getPartialSource();
						if (actionExists && newText.isEmpty()) {
							// If removing action, remove brackets by updating offset and length
							actionTextValue.setUpdateOffset(actionTextValue.getUpdateOffset() - 1);
							actionTextValue.setUpdateLength(actionTextValue.getUpdateLength() + 2);
						} else if (!actionExists && !newText.isEmpty()) {
							actionTextValue.setUpdateOffset(actionTextValue.getUpdateOffset() - 1);
							newText = "{" + newText + "}";
						}

						actionService.execute("Modifying Behavior Transition Action Block", ExecutionMode.NORMAL,
								new EmbeddedTextModificationAction(editingDomain, xtextResource,
										modelChangeNotifier, newText, actionTextValue));
					}
				});
			}
		});

		// Set layout data for the composite. Set the vertical hint
		// because action blocks are multi-line StyledText
		actionBlockEditingControls.setLayoutData(GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL)
				.grab(true, true).hint(SWT.DEFAULT, 100).create());
		actionBlockEditingControls.setStyledTextTestId(WIDGET_ID_ACTION_BLOCK);
		actionBlockEditingControls.setEditButtonTestId(WIDGET_ID_EDIT_ACTION_BLOCK);
	}

	// This method removes or adds brackets for action blocks based on
	// the desired action block modification
//	private String checkActionBlockSyntax(final EmbeddedTextValue actionTextValue, final String newText,
//			final boolean actionExists) {
//		if (actionExists && newText.isEmpty()) {
//			// If removing action, remove brackets by updating offset and length
//			actionTextValue.setUpdateOffset(actionTextValue.getUpdateOffset() - 1);
//			actionTextValue.setUpdateLength(actionTextValue.getUpdateLength() + 2);
//		} else if (!actionExists && !newText.isEmpty()) {
//			// Add brackets for creating new action block
//			actionTextValue.setUpdateOffset(actionTextValue.getUpdateOffset() - 1);
//			return "{" + newText + "}";
//		}
//
//		return newText;
//	}

	@Override
	public void refresh() {
		final Optional<BusinessObjectContext> optSelectedBoc = selectedBos.bocStream().filter(
				boc -> isBehaviorTransition(boc) && ProjectUtil.getProjectForBo(boc.getBusinessObject()).isPresent())
				.findAny();
		if (optSelectedBoc.isPresent()) {
			final BusinessObjectContext selectedBoc = optSelectedBoc.orElseThrow();
			final boolean isSingleSelection = selectedBos.bocStream().limit(2).count() == 1;
			if (!isSingleSelection) {
				setControlsToMultipleSelected();
			} else {
				final BehaviorTransition behaviorTransition = (BehaviorTransition) selectedBoc.getBusinessObject();
				final IProject project = ProjectUtil.getProjectForBoOrThrow(behaviorTransition);
				final XtextResource xtextResource = getXtextResource(behaviorTransition)
						.orElseThrow(() -> new AadlGraphicalEditorException("resource must be XtextResource"));
				final IXtextDocument xtextDocument = getXtextDocument(behaviorTransition).orElse(null);
				final String sourceText = BehaviorAnnexXtextUtil.getText(xtextDocument, xtextResource);

				final EmbeddedTextValue conditionTextValue = BehaviorConditionUtil.createTextValue(behaviorTransition,
						sourceText);
				conditionEditingControls.setEditorTextValue(project, conditionTextValue);

				final EmbeddedTextValue actionTextValue = getActionBlockTextValue(behaviorTransition, sourceText);
				actionBlockEditingControls.setEditorTextValue(project, actionTextValue);
			}
		}

		// Layout controls for refresh
		conditionEditingControls.requestLayout();
		actionBlockEditingControls.requestLayout();
	}

	private void setControlsToMultipleSelected() {
		final String msg = "<Multiple>";
		conditionEditingControls.setEnabled(false);
		conditionEditingControls.setStyledTextText(msg);

		actionBlockEditingControls.setEnabled(false);
		actionBlockEditingControls.setStyledTextText(msg);
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

	private static EmbeddedTextValue getActionBlockTextValue(final BehaviorTransition behaviorTransition,
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
			final int terminationOffset = BehaviorAnnexXtextUtil.findUncommentedTerminationChar(transitionText, ';')
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
			final int terminationOffset = BehaviorAnnexXtextUtil.findUncommentedTerminationChar(afterTransitionText,
					'}')
					+ updateOffset;

			// Get formatted action block text
			final AadlBaUnparser baUnparser = new AadlBaUnparser();
			// Throw exception if first and last char is not a bracket
			// to know when formatter has changed
			final String formattedActionBlock = baUnparser.process(actionBlock);
			final int lastIndex = formattedActionBlock.length() - 1;
			if (!Objects.equals('{', formattedActionBlock.charAt(0)) || !Objects.equals('}',
					formattedActionBlock.charAt(lastIndex))) {
				throw new AadlGraphicalEditorException(
						"Unexpected action block format '" + formattedActionBlock + "'.");
			}

			// Split action at new line character and throw out action block brackets
			final List<String> actionBlockText = getInnerActionBlockText(formattedActionBlock.split("\n"));

			// Get whitespace to trim from each line after removing opening bracket
			final int whitespace = getWhiteSpace(actionBlockText.get(0));
			actionText = String.join("",
					actionBlockText.stream()
					.map(ss -> ss.substring(whitespace))
					.toArray(String[]::new)).trim();

			suffix = src.substring(terminationOffset);
		}

		// Create condition value
		return new EmbeddedTextValue(src.length(), prefix, actionText, suffix);
	}

	private static int getWhiteSpace(final String s) {
		for (int i = 0; i < s.length(); i++) {
			if (!Character.isWhitespace(s.charAt(i))) {
				return i;
			}
		}

		return 0;
	}

	private static List<String> getInnerActionBlockText(final String[] splitActionBlockText) {
		return Arrays.asList(splitActionBlockText).subList(1, splitActionBlockText.length - 1);
	}
}
