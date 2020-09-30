/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.ge.errormodel.ui.swt;

import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import java.util.function.Consumer;

import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.osate.ge.StringUtil;
import org.osate.ge.errormodel.ui.viewmodels.BasicTypeTokenListEditorModel;
import org.osate.ge.swt.ChangeEvent;
import org.osate.ge.swt.SwtUtil;
import org.osate.ge.swt.selectors.CollectionSingleSelectorModel;
import org.osate.ge.swt.selectors.FilteringListSelectorField;
import org.osate.ge.swt.selectors.LabelFilteringListSelectorModel;
import org.osate.ge.swt.selectors.RadioSelector;
import org.osate.ge.swt.selectors.SingleSelectorModel;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelFactory;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;

import com.google.common.base.Strings;

/**
 * Dialog for editing a {@link FaultSource} provided by a {@link FaultSourceEditorModel}
 *
 */
public class FaultSourceEditorDialog {
	private static final String WIDGET_ID_PREFIX = FaultSourceEditorDialog.class.getCanonicalName() + ".";
	public static final String WIDGET_ID_STATE_VALUE_LABEL = WIDGET_ID_PREFIX + "stateValue";
	public static final String WIDGET_ID_STATE_MODIFY_BUTTON = WIDGET_ID_PREFIX + "stateModify";
	public static final String WIDGET_ID_TYPE_SET_VALUE_LABEL = WIDGET_ID_PREFIX + "typeSetValue";
	public static final String WIDGET_ID_TYPE_SET_MODIFY_BUTTON = WIDGET_ID_PREFIX + "typeSetModify";
	public static final String WIDGET_ID_DESCRIPTION_TEXT = WIDGET_ID_PREFIX + "description";

	private static enum FaultSourceType {
		ErrorTypeSet, Description
	}

	private FaultSourceEditorDialog() {
	}

	/**
	 * Opens a dialog to edit a fault condition.
	 * @param parent the parent of the dialog
	 * @param title the dialog's title
	 * @param model is the model to use to edit the fault condition.
	 * Will call {@link FaultSourceEditorModel#setFaultSource(FaultSource)} if OK was selected.
	 */
	public static void open(final Shell parent, final String title, final FaultSourceEditorModel model) {
		Objects.requireNonNull(model, "model must not be null");

		final InnerDialog dlg = new InnerDialog(parent, title, model);
		if (dlg.open() == Window.OK) {
			model.setFaultSource(dlg.getValue());
		}
	}

	private static class InnerDialog extends TitleAreaDialog {
		private final Consumer<ChangeEvent> changeListener = e -> refresh();
		private final String title;
		private final SingleSelectorModel<FaultSourceType> typeSelectorModel;
		private final FaultSourceEditorModel model;
		private CollectionSingleSelectorModel<ErrorBehaviorState> stateModel;
		private Control stateLabel;
		private FilteringListSelectorField<ErrorBehaviorState> stateField;
		private BasicTypeTokenListEditorModel typeTokensModel;
		private Control typeTokensLabel;
		private TypeTokenListField typeTokensField;
		private Control descriptionLabel;
		private Text descriptionField;
		private String description;

		public InnerDialog(final Shell parentShell, final String title, final FaultSourceEditorModel model) {
			super(parentShell);
			this.title = Objects.requireNonNull(title, "title must not be null");
			this.model = Objects.requireNonNull(model, "mode must not be null");
			setShellStyle(getShellStyle() | SWT.RESIZE);

			typeSelectorModel = new CollectionSingleSelectorModel<FaultSourceType>(
					Arrays.asList(FaultSourceType.values())) {
				@Override
				public String getLabel(final FaultSourceType element) {
					return StringUtil.camelCaseToUser(element.name());
				}
			};

			final FaultSourceType type;
			if (model.getFaultSource().getFailureModeDescription() != null) {
				type = FaultSourceType.Description;
			} else {
				type = FaultSourceType.ErrorTypeSet;
			}
			typeSelectorModel.setSelectedElement(type);
			typeSelectorModel.changed().addListener(changeListener);
		}

		@Override
		public void create() {
			super.create();
			setTitle(getShell().getText());
			refresh();
		}

		@Override
		protected void configureShell(final Shell shell) {
			super.configureShell(shell);
			shell.setText(title);
		}

		@Override
		protected Control createDialogArea(final Composite parent) {
			final Composite dialogArea = (Composite) super.createDialogArea(parent);

			final Composite container = new Composite(dialogArea, SWT.NONE);
			container.setLayoutData(GridDataFactory.swtDefaults().grab(true, true).align(SWT.FILL, SWT.FILL).create());
			container.setLayout(GridLayoutFactory.swtDefaults().numColumns(2).create());

			final RadioSelector<FaultSourceType> typeSelector = new RadioSelector<>(container, typeSelectorModel);
			typeSelector.setLayoutData(
					GridDataFactory.swtDefaults().span(2, 1).grab(true, false).align(SWT.FILL, SWT.FILL).create());

			//
			// Error Behavior State
			//
			stateLabel = createLabel(container, "Error Behavior State:");
			stateModel = new CollectionSingleSelectorModel<ErrorBehaviorState>(
					model.getStateOptions()) {
				@Override
				public String getLabel(final ErrorBehaviorState element) {
					return element == null ? "<None>" : element.getName();
				}
			};
			stateModel.setSelectedElement(model.getFaultSource().getErrorBehaviorState());
			stateField = new FilteringListSelectorField<>(container,
					new LabelFilteringListSelectorModel<>(stateModel));
			stateField.setValueLabelTestingId(WIDGET_ID_STATE_VALUE_LABEL);
			stateField.setModifyButtonTestingId(WIDGET_ID_STATE_MODIFY_BUTTON);
			stateField
					.setLayoutData(GridDataFactory.swtDefaults().grab(true, false).align(SWT.FILL, SWT.FILL).create());

			//
			// Type Tokens
			//
			typeTokensLabel = createLabel(container, "Type Set:");
			typeTokensModel = new BasicTypeTokenListEditorModel(model.getErrorTypeOptions(),
					model.getFaultSource().getErrorTypeSet() == null ? Collections.emptyList()
							: model.getFaultSource().getErrorTypeSet().getTypeTokens(),
					true);
			typeTokensField = new TypeTokenListField(container, typeTokensModel);
			typeTokensField.setValueLabelTestingId(WIDGET_ID_TYPE_SET_VALUE_LABEL);
			typeTokensField.setModifyButtonTestingId(WIDGET_ID_TYPE_SET_MODIFY_BUTTON);
			typeTokensField
					.setLayoutData(GridDataFactory.swtDefaults().grab(true, false).align(SWT.FILL, SWT.FILL).create());

			//
			// Failure Mode Description
			//
			descriptionLabel = createLabel(container, "Description:");
			descriptionField = new Text(container, SWT.SINGLE | SWT.BORDER);
			SwtUtil.setTestingId(descriptionField, WIDGET_ID_DESCRIPTION_TEXT);
			descriptionField
					.setLayoutData(GridDataFactory.swtDefaults().grab(true, false).align(SWT.FILL, SWT.FILL).create());
			description = model.getFaultSource().getFailureModeDescription();
			descriptionField.setText(Strings.nullToEmpty(description));
			descriptionField.addModifyListener((e) -> {
				description = descriptionField.getText();
				refresh();
			});

			refresh();

			return dialogArea;
		}

		private Control createLabel(final Composite container, final String txt) {
			final Label label = new Label(container, SWT.NONE);
			label.setText(txt);
			label.setLayoutData(GridDataFactory.swtDefaults().grab(false, false).align(SWT.FILL, SWT.CENTER).create());
			return label;

		}

		private void refresh() {
			// Refresh error message and state of buttons
			if (this.getShell() != null && !this.getShell().isDisposed()) {
				final FaultSourceType type = typeSelectorModel.getSelectedElement();

				final boolean showState = type == FaultSourceType.ErrorTypeSet;
				SwtUtil.setVisibilityAndExclusion(stateLabel, showState);
				SwtUtil.setVisibilityAndExclusion(stateField, showState);

				final boolean showTypeTokens = type == FaultSourceType.ErrorTypeSet;
				SwtUtil.setVisibilityAndExclusion(typeTokensLabel, showTypeTokens);
				SwtUtil.setVisibilityAndExclusion(typeTokensField, showTypeTokens);

				final boolean showDescription = type == FaultSourceType.Description;
				SwtUtil.setVisibilityAndExclusion(descriptionLabel, showDescription);
				SwtUtil.setVisibilityAndExclusion(descriptionField, showDescription);
			}
		}

		public FaultSource getValue() {
			final TypeSet typeSet = ErrorModelFactory.eINSTANCE.createTypeSet();
			typeTokensModel.getTypeTokens().forEachOrdered(typeSet.getTypeTokens()::add);
			if (typeSelectorModel.getSelectedElement() == FaultSourceType.Description) {
				return new FaultSource(description);
			} else {
				return new FaultSource(stateModel.getSelectedElement(), typeSet);
			}
		}
	}

	public static void main(String[] args) {
		SwtUtil.runDialog(() -> {
			FaultSourceEditorDialog.open(null, "Edit Fault Source", new TestFaultSourceEditorModel());
		});
	}
}
