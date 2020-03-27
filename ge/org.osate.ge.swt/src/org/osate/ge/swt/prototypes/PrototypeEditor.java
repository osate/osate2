package org.osate.ge.swt.prototypes;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Stream;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.osate.ge.swt.ChangeEvent;
import org.osate.ge.swt.EventSource;
import org.osate.ge.swt.check.CheckboxEditor;
import org.osate.ge.swt.check.CheckboxEditorModel;
import org.osate.ge.swt.name.NameEditor;
import org.osate.ge.swt.name.NameEditorModel;
import org.osate.ge.swt.selectors.ComboSelector;
import org.osate.ge.swt.selectors.FilteringListSelectorField;
import org.osate.ge.swt.selectors.LabelFilteringListSelectorModel;
import org.osate.ge.swt.selectors.RadioSelector;
import org.osate.ge.swt.selectors.SelectorModel;

/**
 * View for editing a prototype.
 *
 */
final class PrototypeEditor<C> extends Composite {
	private final PrototypeEditorModel<C> model;
	private final CheckboxEditor refinedEditor;
	private final CLabel directionLabel;
	private final RadioSelector<PrototypeDirection> directionEditor;
	private final CheckboxEditor arrayFlagEditor;
	private final Consumer<ChangeEvent> changeListener = e -> refresh();

	public PrototypeEditor(final Composite parent, final PrototypeEditorModel<C> model) {
		super(parent, SWT.NONE);
		this.model = Objects.requireNonNull(model, "model must not be null");
		this.setBackground(parent.getBackground());
		this.setLayout(GridLayoutFactory.fillDefaults().numColumns(2).create());

		//
		// Refinement
		//
		refinedEditor = new CheckboxEditor(this, new CheckboxEditorModel() {
			@Override
			public EventSource<ChangeEvent> changed() {
				return model.changed();
			}

			@Override
			public String getLabel() {
				final String refineableElementLabel = model.getRefineableElementLabel();
				return "Refine " + (refineableElementLabel == null ? "" : refineableElementLabel);
			}

			@Override
			public boolean isEnabled() {
				return model.isEnabled() && model.getRefineableElementLabel() != null;
			}

			@Override
			public Boolean getValue() {
				return model.isRefined();
			}

			@Override
			public void setValue(final boolean value) {
				model.setRefined(value);
			}

		});
		refinedEditor.setLayoutData(
				GridDataFactory.swtDefaults().span(2, 1).grab(true, false).align(SWT.FILL, SWT.CENTER).create());

		//
		// Name
		//
		addLabel("Name:");
		final NameEditor nameEditor = new NameEditor(this, new NameEditorModel() {
			@Override
			public boolean isEnabled() {
				return model.isEnabled();
			};

			@Override
			public EventSource<ChangeEvent> changed() {
				return model.changed();
			}

			@Override
			public String getName() {
				return model.getName();
			}

			@Override
			public void setName(String value) {
				model.setName(value);
			}

			@Override
			public String validateName(String newName) {
				return model.validateName(newName);
			}

		});
		nameEditor
				.setLayoutData(GridDataFactory.swtDefaults().grab(true, false).align(SWT.FILL, SWT.BEGINNING).create());

		//
		// Type
		//
		addLabel("Type:");
		final ComboSelector<PrototypeType> typeSelector = new ComboSelector<>(this, new SelectorModel<PrototypeType>() {
			@Override
			public EventSource<ChangeEvent> changed() {
				return model.changed();
			}

			@Override
			public boolean isEnabled() {
				return model.isEnabled();
			}

			@Override
			public Stream<PrototypeType> getElements() {
				return Stream.of(PrototypeType.values());
			}

			@Override
			public PrototypeType getSelectedElement() {
				return model.getType();
			}

			@Override
			public void setSelectedElement(PrototypeType element) {
				model.setType(element);
			}

			@Override
			public String getLabel(final PrototypeType element) {
				return element.toString();
			}
		});
		typeSelector
				.setLayoutData(GridDataFactory.swtDefaults().grab(true, false).align(SWT.FILL, SWT.CENTER).create());

		//
		// Classifier
		//
		addLabel("Classifier:");
		final FilteringListSelectorField<C> classifierSelector = new FilteringListSelectorField<>(this,
				new LabelFilteringListSelectorModel<>(new SelectorModel<C>() {

					@Override
					public EventSource<ChangeEvent> changed() {
						return model.changed();
					}

					@Override
					public Stream<C> getElements() {
						return model.getConstrainingClassifierOptions();
					}

					@Override
					public C getSelectedElement() {
						return model.getConstrainingClassifier();
					}

					@Override
					public void setSelectedElement(C value) {
						model.setConstrainingClassifier(value);
					}

					@Override
					public String getLabel(C value) {
						return model.getClassifierLabel(value);
					}

				}));
		classifierSelector
				.setLayoutData(GridDataFactory.swtDefaults().grab(true, false).align(SWT.FILL, SWT.CENTER).create());

		//
		// Direction
		//
		this.directionLabel = addLabel("Direction:");
		this.directionEditor = new RadioSelector<>(this, new SelectorModel<PrototypeDirection>() {
			@Override
			public EventSource<ChangeEvent> changed() {
				return model.changed();
			}

			@Override
			public boolean isEnabled() {
				return model.isEnabled();
			}

			@Override
			public Stream<PrototypeDirection> getElements() {
				return Stream.of(PrototypeDirection.values());
			}

			@Override
			public PrototypeDirection getSelectedElement() {
				return model.getDirection();
			}

			@Override
			public void setSelectedElement(final PrototypeDirection element) {
				model.setDirection(element);
			}

			@Override
			public String getLabel(final PrototypeDirection element) {
				return element.toString();
			}
		});

		directionEditor
				.setLayoutData(GridDataFactory.swtDefaults().grab(true, false).align(SWT.FILL, SWT.CENTER).create());

		//
		// Array
		//
		arrayFlagEditor = new CheckboxEditor(this, new CheckboxEditorModel() {
			@Override
			public EventSource<ChangeEvent> changed() {
				return model.changed();
			}

			@Override
			public boolean isEnabled() {
				return model.isEnabled();
			}

			@Override
			public String getLabel() {
				return "Array";
			}

			@Override
			public Boolean getValue() {
				return model.isArray();
			}

			@Override
			public void setValue(final boolean value) {
				model.setArray(value);
			}
		});
		arrayFlagEditor.setLayoutData(
				GridDataFactory.swtDefaults().span(2, 1).grab(true, false).align(SWT.FILL, SWT.CENTER).create());

		model.changed().addListener(changeListener);
		refresh();
	}

	private void refresh() {
		if (!this.isDisposed()) {
			final PrototypeType type = model.getType();

			// Make the refine checkbox visible when the refinement status can be adjusted or the refinement status is not false.
			setVisibilityAndExclusion(refinedEditor, model.isEnabled()
					&& (model.getRefineableElementLabel() != null || model.isRefined() != Boolean.FALSE));

			// Update visibility of direction editor and label
			final boolean directionVisible = type == PrototypeType.FEATURE;
			setVisibilityAndExclusion(directionLabel, directionVisible);
			setVisibilityAndExclusion(directionEditor, directionVisible);

			// Hide the array checkbox unless the component is an array.
			setVisibilityAndExclusion(arrayFlagEditor, model.isEnabled() && type != null && type.isComponent());

			// Update enabled state
			setEnabled(model.isEnabled());
		}
	}

	/**
	 * Sets the visibility of a control and the exclude field of its layout data. Assumes the layout data is a GridData
	 * @param c
	 * @param visible
	 */
	private void setVisibilityAndExclusion(final Control c, final boolean visible) {
		c.setVisible(visible);
		((GridData) c.getLayoutData()).exclude = !visible;
	}

	private CLabel addLabel(final String txt) {
		final CLabel label = new CLabel(this, SWT.NONE);
		label.setBackground(getBackground());
		label.setText(txt);
		label.setLayoutData(GridDataFactory.swtDefaults().grab(false, false).align(SWT.FILL, SWT.CENTER).create());
		return label;
	}
}