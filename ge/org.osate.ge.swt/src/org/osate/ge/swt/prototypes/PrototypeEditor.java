package org.osate.ge.swt.prototypes;

import java.util.Objects;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.Composite;
import org.osate.ge.swt.ChangeEvent;
import org.osate.ge.swt.EventSource;
import org.osate.ge.swt.direction.Direction;
import org.osate.ge.swt.direction.DirectionEditor;
import org.osate.ge.swt.name.NameEditor;
import org.osate.ge.swt.name.NameEditorModel;

/**
 * View for editing a prototype.
 *
 */
class PrototypeEditor extends Composite {
	public PrototypeEditor(final Composite parent, final PrototypeEditorModel model) {
		super(parent, SWT.NONE);
		Objects.requireNonNull(model, "model must not be null");
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
		addLabel("TODO");
		// TODO: Create component that can be reused.

		//
		// Classifier
		//
		addLabel("Classifier:");
		addLabel("TODO");
		// TODO: Create component that can be reused.

		//
		// Direction
		//
		addLabel("Direction:");
		final DirectionEditor directionEditor = new DirectionEditor(this,
				new org.osate.ge.swt.direction.DirectionEditorModel() {
					@Override
					public boolean isEnabled() {
						return model.isEnabled();
					};

					@Override
					public Direction getDirection() {
						return model.getDirection();
					}

					@Override
					public void setDirection(final Direction value) {
						model.setDirection(value);
					}

					@Override
					public EventSource<ChangeEvent> changed() {
						return model.changed();
					}
				});
		directionEditor
				.setLayoutData(GridDataFactory.swtDefaults().grab(true, false).align(SWT.FILL, SWT.CENTER).create());
	}

	private void addLabel(final String txt) {
		final CLabel label = new CLabel(this, SWT.NONE);
		label.setBackground(getBackground());
		label.setText(txt);
		label.setLayoutData(GridDataFactory.swtDefaults().grab(false, false).align(SWT.FILL, SWT.CENTER).create());
	}
}