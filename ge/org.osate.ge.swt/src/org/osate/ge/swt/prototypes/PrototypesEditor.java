package org.osate.ge.swt.prototypes;

import java.util.Objects;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.osate.ge.swt.ChangeEvent;
import org.osate.ge.swt.EventSource;
import org.osate.ge.swt.direction.Direction;
import org.osate.ge.swt.list.ListEditor;
import org.osate.ge.swt.list.ListEditorModel;
import org.osate.ge.swt.util.SwtTestUtil;

/**
 * View for editing a list of prototypes and their details.
 * Combination of {@link org.osate.ge.swt.list.ListEditor} and {@link PrototypeEditor}.
 *
 */
public class PrototypesEditor extends Composite {
	private final ListEditor listView;
	private final PrototypeEditor detailsView;

	public PrototypesEditor(final Composite parent, final PrototypesEditorModel model) {
		super(parent, SWT.NONE);
		Objects.requireNonNull(model, "model must not be null");
		this.setBackground(parent.getBackground());

		this.setLayout(GridLayoutFactory.swtDefaults().numColumns(3).create());
		this.listView = new ListEditor(this, new ListEditorModel() {
			@Override
			public EventSource<ChangeEvent> changed() {
				return model.changed();
			}

			@Override
			public Object[] getElements() {
				return model.getPrototypes();
			}

			@Override
			public void addElement() {
				model.addPrototype();
			}

			@Override
			public void removeElement(Object element) {
				model.removePrototype(element);
			}

			@Override
			public Object getSelectedElement() {
				return model.getSelectedPrototype();
			}

			@Override
			public void setSelectedElement(Object value) {
				model.setSelectedPrototype(value);
			}

			@Override
			public String getLabel(Object prototype) {
				return model.getPrototypeName(prototype);
			}

		});
		this.listView
		.setLayoutData(GridDataFactory.swtDefaults().grab(true, true).align(SWT.FILL, SWT.FILL).create());

		final Label separator = new Label(this, SWT.SEPARATOR | SWT.VERTICAL);
		separator.setLayoutData(GridDataFactory.swtDefaults().grab(false, true).align(SWT.CENTER, SWT.FILL).create());

		this.detailsView = new PrototypeEditor(this, new PrototypeEditorModel() {
			@Override
			public EventSource<ChangeEvent> changed() {
				return model.changed();
			}

			@Override
			public boolean isEnabled() {
				return model.getSelectedPrototype() != null;
			}

			@Override
			public String getName() {
				return model.getSelectedPrototype() == null ? "" : model.getPrototypeName(model.getSelectedPrototype());
			}

			@Override
			public String validateName(final String newName) {
				return model.getSelectedPrototype() == null ? null : model.validatePrototypeName(model.getSelectedPrototype(), newName);
			}

			@Override
			public void setName(final String value) {
				if (model.getSelectedPrototype() != null) {
					model.setPrototypeName(model.getSelectedPrototype(), value);
				}
			}

			@Override
			public Direction getDirection() {
				return model.getSelectedPrototype() == null ? null : model.getPrototypeDirection(model.getSelectedPrototype());
			}

			@Override
			public void setDirection(final Direction value) {
				if (model.getSelectedPrototype() != null) {
					model.setPrototypeDirection(model.getSelectedPrototype(), value);
				}
			}

			@Override
			public PrototypeType getType() {
				return model.getSelectedPrototype() == null ? null
						: model.getPrototypeType(model.getSelectedPrototype());
			}

			@Override
			public void setType(final PrototypeType value) {
				if (model.getSelectedPrototype() != null) {
					model.setPrototypeType(model.getSelectedPrototype(), value);
				}
			}
		});
		this.detailsView
		.setLayoutData(GridDataFactory.swtDefaults().grab(true, true).align(SWT.FILL, SWT.FILL).create());
	}

	public static void main(String[] args) {
		SwtTestUtil.run(shell -> {
			new PrototypesEditor(shell, new TestPrototypesEditorModel());
		});
	}
}