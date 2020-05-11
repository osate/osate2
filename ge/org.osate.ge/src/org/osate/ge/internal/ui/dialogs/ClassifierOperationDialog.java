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
package org.osate.ge.internal.ui.dialogs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.List;
import java.util.Objects;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;
import org.osate.aadl2.ComponentCategory;
import org.osate.ge.internal.util.classifiers.ClassifierOperation;
import org.osate.ge.internal.util.classifiers.ClassifierOperationPart;
import org.osate.ge.internal.util.classifiers.ClassifierOperationPartType;

import com.google.common.collect.ImmutableList;

/**
 * Dialog used for creating or selecting a classifier.
 * If a new implementation is being created, the dialog can also prompt to create a new type.
 *
 */
public class ClassifierOperationDialog {
	public static final String primaryPartIdentifier = "org.osate.ge.PrimaryPartIdentifier";
	public static final String baseValueIdentifier = "org.osate.ge.BaseValueIdentifier";
	static String NOT_SELECTED_LABEL = "<Not Selected>";

	public static interface Model {
		String getTitle();

		String getMessage(final ClassifierOperation value);

		Collection<?> getPackageOptions();

		String getPrimarySelectTitle();

		String getPrimarySelectMessage();

		Collection<?> getPrimarySelectOptions();

		Collection<?> getUnfilteredPrimarySelectOptions();

		Collection<?> getBaseSelectOptions(final ClassifierOperationPartType primaryOperation);

		Collection<?> getUnfilteredBaseSelectOptions(final ClassifierOperationPartType primaryOperation);

		String validate(ClassifierOperation value);
	}

	private static class Arguments {
		private Arguments(final Model model, final EnumSet<ClassifierOperationPartType> allowedOperations, final Object defaultPackage,
				final Object defaultSelection, final boolean showPrimaryPackageSelector,
				final ImmutableList<ComponentCategory> componentCategories) {
			this.model = Objects.requireNonNull(model, "model must not be null");
			this.allowedOperations = Objects.requireNonNull(allowedOperations, "allowedOperations must not be null");
			this.defaultPackage = defaultPackage;
			this.defaultSelection = defaultSelection;
			this.showPrimaryPackageSelector = showPrimaryPackageSelector;
			this.componentCategories = componentCategories;

			if ((componentCategories == null || componentCategories.isEmpty())
					&& allowedOperations.stream().anyMatch(op -> op == ClassifierOperationPartType.NEW_COMPONENT_TYPE
					|| op == ClassifierOperationPartType.NEW_COMPONENT_IMPLEMENTATION)) {
				throw new RuntimeException(
						"Component category must not be null or empty if new component type or component implementation is allowed.");
			}
		}

		public final Model model;
		public final EnumSet<ClassifierOperationPartType> allowedOperations;
		public final Object defaultPackage;
		public final Object defaultSelection;
		public final boolean showPrimaryPackageSelector;
		public final ImmutableList<ComponentCategory> componentCategories; // For create component operations
	}

	public static class ArgumentBuilder {
		private Model model;
		private EnumSet<ClassifierOperationPartType> allowedOperations;
		private Object defaultPackage;
		private Object defaultSelection;
		private boolean showPrimaryPackageSelector = true;
		private ImmutableList<ComponentCategory> componentCategories = ImmutableList.of();

		public ArgumentBuilder(final Model model, final EnumSet<ClassifierOperationPartType> allowedOperations) {
			this.model = Objects.requireNonNull(model, "model must not be null");
			this.allowedOperations = Objects.requireNonNull(allowedOperations, "allowedOperations must not be null");
		}

		public ArgumentBuilder defaultPackage(final Object value) {
			this.defaultPackage = value;
			return this;
		}

		public ArgumentBuilder defaultSelection(final Object value) {
			this.defaultSelection = value;
			return this;
		}

		public ArgumentBuilder showPrimaryPackageSelector(final boolean value) {
			this.showPrimaryPackageSelector = value;
			return this;
		}

		public ArgumentBuilder componentCategories(final ImmutableList<ComponentCategory> value) {
			this.componentCategories = value;
			return this;
		}

		public Arguments create() {
			return new Arguments(model, allowedOperations, defaultPackage, defaultSelection,
					showPrimaryPackageSelector, componentCategories);
		}
	}

	private static class InnerDialog extends TitleAreaDialog {
		private final Arguments args;
		private ClassifierOperationPartEditor primaryPartEditor;
		private ClassifierOperationPartEditor baseValueWidget;
		private Group baseGroup;

		protected InnerDialog(final Shell parentShell, final Arguments args) {
			super(parentShell);
			this.args = Objects.requireNonNull(args, "args must not be null");
			setShellStyle(getShellStyle() | SWT.RESIZE);
			this.setHelpAvailable(false);
		}

		@Override
		protected void configureShell(final Shell newShell) {
			super.configureShell(newShell);
			newShell.setText(args.model.getTitle());
			newShell.setMinimumSize(250, 50);
		}

		@Override
		protected Point getInitialSize() {
			final Point initialSize = super.getInitialSize();
			return new Point(initialSize.x, Math.max(initialSize.y, 550));
		}

		@Override
		public void create() {
			super.create();
			setTitle(args.model.getTitle());
			updateMessage();
		}

		@Override
		protected Control createDialogArea(final Composite parent) {
			final Composite area = (Composite) super.createDialogArea(parent);

			// Scrollable
			final ScrolledComposite scrolled = new ScrolledComposite(area, SWT.H_SCROLL | SWT.V_SCROLL);
			scrolled.setLayoutData(GridDataFactory.fillDefaults().grab(true, true).create());
			scrolled.setExpandVertical(true);
			scrolled.setExpandHorizontal(true);

			final Composite container = new Composite(scrolled, SWT.NONE);
			container.setLayout(GridLayoutFactory.swtDefaults().numColumns(2).create());

			// Determine initial component category selection. Set it if there is only one valid option.
			final ComponentCategory initialComponentCategory = args.componentCategories.size() == 1
					? args.componentCategories.get(0)
							: null;

					// Editor for the primary operation part
					primaryPartEditor = new ClassifierOperationPartEditor(container, args.allowedOperations,
							args.showPrimaryPackageSelector, args.componentCategories,
							new ClassifierOperationPartEditor.Model() {
						@Override
						public Collection<?> getPackageOptions() {
							return args.model.getPackageOptions();
						}

						@Override
						public String getSelectTitle() {
							return args.model.getPrimarySelectTitle();
						}

						@Override
						public String getSelectMessage() {
							return args.model.getPrimarySelectMessage();
						}

						@Override
						public Collection<?> getSelectOptions() {
							return args.model.getPrimarySelectOptions();
						}

						@Override
						public Collection<?> getUnfilteredSelectOptions() {
							return args.model.getUnfilteredPrimarySelectOptions();
						}
					});
					primaryPartEditor.setIdentifierFieldTestingId(primaryPartIdentifier);
					primaryPartEditor.setSelectedElement(args.defaultSelection);
					primaryPartEditor.setSelectedComponentCategory(initialComponentCategory);
					primaryPartEditor.setSelectedPackage(args.defaultPackage);
					primaryPartEditor.setLayoutData(GridDataFactory.fillDefaults().span(2, 1).grab(true, false).create());

					baseGroup = new Group(container, SWT.NONE);
					baseGroup.setText("Base");
					baseGroup.setLayout(GridLayoutFactory.swtDefaults().create());
					baseGroup.setLayoutData(GridDataFactory.fillDefaults().span(2, 1).grab(true, false).create());

					baseValueWidget = new ClassifierOperationPartEditor(baseGroup,
							EnumSet.allOf(ClassifierOperationPartType.class), true, args.componentCategories,
							new ClassifierOperationPartEditor.Model() {
						@Override
						public Collection<?> getPackageOptions() {
							return args.model.getPackageOptions();
						}

						@Override
						public String getSelectTitle() {
							return "Select Base Classifier";
						}

						@Override
						public String getSelectMessage() {
							return "Select a base classifier.";
						}

						@Override
						public Collection<?> getSelectOptions() {
							return args.model
									.getBaseSelectOptions(primaryPartEditor.getConfiguredOperation().getType());
						}

						@Override
						public Collection<?> getUnfilteredSelectOptions() {
							return args.model.getUnfilteredBaseSelectOptions(
									primaryPartEditor.getConfiguredOperation().getType());
						}
					});
					baseValueWidget.setIdentifierFieldTestingId(baseValueIdentifier);
					baseValueWidget.setSelectedElement(args.defaultSelection);
					baseValueWidget.setSelectedComponentCategory(initialComponentCategory);
					baseValueWidget.setSelectedPackage(args.defaultPackage);
					baseValueWidget.setLayoutData(GridDataFactory.fillDefaults().grab(true, false).create());

					// Update the base whenever the primary widget is updated
					primaryPartEditor.addSelectionListener(new SelectionAdapter() {
						@Override
						public void widgetSelected(final SelectionEvent e) {
							updateBase();
							validate();
						}
					});

					baseValueWidget.addSelectionListener(new SelectionAdapter() {
						@Override
						public void widgetSelected(final SelectionEvent e) {
							validate();
						}
					});

					updateBase();

					// The set scrolled composite' content
					scrolled.setContent(container);
					scrolled.setMinSize(container.computeSize(SWT.DEFAULT, SWT.DEFAULT));

					// Update the min size of the scrolled composite whenever the the size of the widgets change.
					final ControlListener resizeListener = new ControlAdapter() {
						@Override
						public void controlResized(ControlEvent e) {
							scrolled.setMinSize(container.computeSize(SWT.DEFAULT, SWT.DEFAULT));
						}
					};

					primaryPartEditor.addControlListener(resizeListener);
					baseGroup.addControlListener(resizeListener);

					return area;
		}

		@Override
		protected void createButtonsForButtonBar(Composite parent) {
			super.createButtonsForButtonBar(parent);

			// Disable the OK button. Afterwards it will be updated based on validation results
			getButton(IDialogConstants.OK_ID).setEnabled(false);
		}

		private void updateBase() {
			final ClassifierOperationPart primaryPart = primaryPartEditor.getConfiguredOperation();
			final ClassifierOperationPartType primaryOp = primaryPart.getType();
			baseGroup.setVisible(ClassifierOperationPartType.isCreate(primaryOp));

			// Set allowed component categories and selected component category for the base widget
			final ComponentCategory cc = primaryPart.getComponentCategory();
			baseValueWidget
			.setAllowedComponentCategories(cc == null ? ImmutableList.of() : ImmutableList.of(cc));
			baseValueWidget.setSelectedComponentCategory(cc);

			if (baseGroup.getVisible()) {
				switch (primaryOp) {
				case NEW_COMPONENT_TYPE:
					baseValueWidget
					.setAllowedOperations(EnumSet.of(ClassifierOperationPartType.NONE, ClassifierOperationPartType.EXISTING));

					// Set default value for base operation
					if (baseValueWidget.getConfiguredOperation().getType() == null) {
						baseValueWidget.setCurrentOperationPartType(ClassifierOperationPartType.NONE);
					}

					break;

				case NEW_COMPONENT_IMPLEMENTATION:
					baseValueWidget.setAllowedOperations(
							EnumSet.of(ClassifierOperationPartType.NEW_COMPONENT_TYPE, ClassifierOperationPartType.EXISTING));

					// Set default value for base operation
					if (baseValueWidget.getConfiguredOperation().getType() == null) {
						baseValueWidget.setCurrentOperationPartType(ClassifierOperationPartType.NEW_COMPONENT_TYPE);
					}

					break;

				case NEW_FEATURE_GROUP_TYPE:
					baseValueWidget
					.setAllowedOperations(EnumSet.of(ClassifierOperationPartType.NONE, ClassifierOperationPartType.EXISTING));

					// Set default value for base operation
					if (baseValueWidget.getConfiguredOperation().getType() == null) {
						baseValueWidget.setCurrentOperationPartType(ClassifierOperationPartType.NONE);
					}
					break;

				default:

				}
			}
		}

		private void validate() {
			final Button okBtn = getButton(IDialogConstants.OK_ID);

			if(okBtn != null) {
				final String errorMsg = args.model.validate(createResult());
				setErrorMessage(errorMsg);
				okBtn.setEnabled(errorMsg == null);
				updateMessage();
			}
		}

		private void updateMessage() {
			setMessage(args.model.getMessage(createResult()), IMessageProvider.INFORMATION);
		}

		private ClassifierOperation createResult() {
			return new ClassifierOperation(primaryPartEditor.getConfiguredOperation(),
					baseValueWidget.getConfiguredOperation());
		}

	}

	private final InnerDialog dlg;

	private ClassifierOperationDialog(final Shell parentShell, final Arguments args) {
		this.dlg = new InnerDialog(parentShell, args);
	}

	/**
	 * Returns if the user did not select OK.
	 * @return
	 */
	private ClassifierOperation open() {
		if (dlg.open() == Window.OK) {
			return dlg.createResult();
		} else {
			return null;
		}
	}

	public static ClassifierOperation show(final Shell parentShell, final Arguments args) {
		final ClassifierOperationDialog dlg = new ClassifierOperationDialog(parentShell, args);

		return dlg.open();
	}

	public static void main(final String[] args) {
		final Model testModel = new Model() {
			@Override
			public String getTitle() {
				return "Select Element";
			}

			@Override
			public String getMessage(final ClassifierOperation value) {
				return "Select an element.";
			}

			@Override
			public Collection<?> getPackageOptions() {
				final List<Object> result = new ArrayList<>();
				result.add("A");
				result.add("B");
				return result;
			}

			@Override
			public String getPrimarySelectTitle() {
				return "Select Element";
			}

			@Override
			public String getPrimarySelectMessage() {
				return "Select an element.";
			}

			@Override
			public List<Object> getPrimarySelectOptions() {
				final List<Object> result = new ArrayList<>();
				result.add("C");
				result.add("D");
				return result;
			}

			@Override
			public List<Object> getUnfilteredPrimarySelectOptions() {
				final List<Object> result = getPrimarySelectOptions();
				result.add("E");
				result.add("F");
				return result;
			}

			@Override
			public List<Object> getBaseSelectOptions(final ClassifierOperationPartType primaryOperation) {
				final List<Object> result = new ArrayList<>();
				result.add("G");
				result.add("H");
				return result;
			}

			@Override
			public Collection<?> getUnfilteredBaseSelectOptions(final ClassifierOperationPartType primaryOperation) {
				final List<Object> result = getBaseSelectOptions(primaryOperation);
				result.add("I");
				result.add("J");
				return result;
			}

			@Override
			public String validate(final ClassifierOperation value) {
				return (value.getPrimaryPart().getType() == ClassifierOperationPartType.NEW_COMPONENT_IMPLEMENTATION
						&& value.getPrimaryPart().getIdentifier().isEmpty())
						? "Primary identifier must not be empty."
								: null;
			}
		};

		Display.getDefault().syncExec(() -> {
			final ClassifierOperation result = show(new Shell(),
					new ArgumentBuilder(testModel,
							EnumSet.complementOf(EnumSet.of(ClassifierOperationPartType.NONE)))
					.componentCategories(ImmutableList.of(ComponentCategory.ABSTRACT)).create());
			System.out.println("Result: " + result);
		});

	}
}
