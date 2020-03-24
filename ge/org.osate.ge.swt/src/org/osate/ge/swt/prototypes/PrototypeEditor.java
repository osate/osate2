package org.osate.ge.swt.prototypes;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

import org.apache.commons.lang.StringUtils;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.Composite;
import org.osate.ge.swt.ChangeEvent;
import org.osate.ge.swt.EventSource;
import org.osate.ge.swt.direction.Direction;
import org.osate.ge.swt.direction.DirectionEditor;
import org.osate.ge.swt.list.ComboViewer;
import org.osate.ge.swt.list.ListViewerModel;
import org.osate.ge.swt.name.NameEditor;
import org.osate.ge.swt.name.NameEditorModel;

/**
 * View for editing a prototype.
 *
 */
class PrototypeEditor extends Composite {
	private final PrototypeEditorModel model;
	private final CLabel directionLabel;
	private final DirectionEditor directionEditor;

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

		// TODO: Rename
		// TODO: Create component that can be reused.
		final ComboViewer typeEditor = new ComboViewer(this, new ListViewerModel() {

			@Override
			public EventSource<ChangeEvent> changed() {
				return model.changed();
			}

			@Override
			public Object[] getElements() {
				return PrototypeType.values();
			}

			@Override
			public Object getSelectedElement() {
				return model.getType();
			}

			@Override
			public void setSelectedElement(Object element) {
				// TODO: Wouldn't need to cast if things were type safe
				model.setType((PrototypeType) element);
			}

			@Override
			public String getLabel(Object element) {
				// TODO; Move to utility?
				return Arrays.stream(element.toString().split("_")).map(String::toLowerCase)
						.map(StringUtils::capitalize).collect(Collectors.joining(" "));
			}
		});
		typeEditor
				.setLayoutData(GridDataFactory.swtDefaults().grab(true, false).align(SWT.FILL, SWT.CENTER).create());

		// TODO: Binding

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
		this.directionEditor = new DirectionEditor(this,
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

		model.changed().addListener(e -> refresh());
		refresh();
	}

	private void refresh() {
		// TODO; Is this the appropriate place for this... Seems that way. Could be in view model though... Don't want everythign there.
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