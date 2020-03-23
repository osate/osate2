package org.osate.ge.swt.name;

import org.osate.ge.swt.BaseObservableModel;

/**
 * Test view model for {@link NameEditor}. Requires names to be exactly 4 characters.
 *
 */
class TestNameEditorModel extends BaseObservableModel implements NameEditorModel {
	private String name = "test";

	@Override
	public boolean isEnabled() {
		return name != null;
	};

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String value) {
		this.name = value;
		triggerChangeEvent();
	}

	@Override
	public String validateName(String newName) {
		if (newName.length() != 4) {
			return "Name must be exactly 4 characters";
		}

		return null;
	}
}
