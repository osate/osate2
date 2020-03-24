package org.osate.ge.swt.prototypes;

import java.util.Objects;
import java.util.function.Consumer;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.Composite;
import org.osate.ge.swt.ChangeEvent;
import org.osate.ge.swt.EventSource;
import org.osate.ge.swt.list.ComboSelector;
import org.osate.ge.swt.list.ListSelectorModel;
import org.osate.ge.swt.list.RadioSelector;
import org.osate.ge.swt.name.NameEditor;
import org.osate.ge.swt.name.NameEditorModel;

/**
 * View for editing a prototype.
 *
 */
class PrototypeEditor extends Composite {
	private final PrototypeEditorModel model;
	private final CLabel directionLabel;
	private final RadioSelector<PrototypeDirection> directionEditor;
	private final Consumer<ChangeEvent> changeListener = e -> refresh();

	public PrototypeEditor(final Composite parent, final PrototypeEditorModel model) {
		super(parent, SWT.NONE);
		this.model = Objects.requireNonNull(model, "model must not be null");
		this.setBackground(parent.getBackground());
		this.setLayout(GridLayoutFactory.fillDefaults().numColumns(2).create());

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
		final ComboSelector<PrototypeType> typeSelector = new ComboSelector<>(this, new ListSelectorModel<PrototypeType>() {
			@Override
			public EventSource<ChangeEvent> changed() {
				return model.changed();
			}

			@Override
			public boolean isEnabled() {
				return model.isEnabled();
			}

			@Override
			public PrototypeType[] getElements() {
				return PrototypeType.values();
			}

			@Override
			public PrototypeType getSelectedElement() {
				return model.getType();
			}

			@Override
			public void setSelectedElement(PrototypeType element) {
				model.setType(element);
			}
		});
		typeSelector.setLayoutData(GridDataFactory.swtDefaults().grab(true, false).align(SWT.FILL, SWT.CENTER).create());

		//
		// Classifier
		//
		addLabel("Classifier:");
		addLabel("TODO");
		// TODO: Create component that can be reused.

		//
		// Direction
		//
		this.directionLabel = addLabel("Direction:");
		this.directionEditor = new RadioSelector<>(this, new ListSelectorModel<PrototypeDirection>() {
			@Override
			public EventSource<ChangeEvent> changed() {
				return model.changed();
			}

			@Override
			public boolean isEnabled() {
				return model.isEnabled();
			}

			@Override
			public PrototypeDirection[] getElements() {
				return PrototypeDirection.values();
			}

			@Override
			public PrototypeDirection getSelectedElement() {
				return model.getDirection();
			}

			@Override
			public void setSelectedElement(PrototypeDirection element) {
				model.setDirection(element);
			}
		});

		directionEditor
				.setLayoutData(GridDataFactory.swtDefaults().grab(true, false).align(SWT.FILL, SWT.CENTER).create());

		model.changed().addListener(changeListener);
		refresh();
	}

	private void refresh() {
		// Update visibility of direction editor and label
		final boolean directionVisible = model.getType() == PrototypeType.FEATURE;
		directionLabel.setVisible(directionVisible);
		directionEditor.setVisible(directionVisible);
	}

	private CLabel addLabel(final String txt) {
		final CLabel label = new CLabel(this, SWT.NONE);
		label.setBackground(getBackground());
		label.setText(txt);
		label.setLayoutData(GridDataFactory.swtDefaults().grab(false, false).align(SWT.FILL, SWT.CENTER).create());
		return label;
	}
}