package org.osate.ge.swt.name;

import java.util.Objects;

/**
 * {@link RenameDialogModel} implementation that delegates to a {@link NameEditorModel}
 *
 */
public class NameEditorRenameDialogModel implements RenameDialogModel {
	private final NameEditorModel innerModel;

	public NameEditorRenameDialogModel(final NameEditorModel innerModel) {
		this.innerModel = Objects.requireNonNull(innerModel, "innerModel must not be null");
	}

	@Override
	public String getName() {
		return innerModel.getName();
	}

	@Override
	public String validateName(String newName) {
		return innerModel.validateName(newName);
	}

	@Override
	public void setName(String value) {
		innerModel.setName(value);
	}
}
