package org.osate.ge.swt.check;

import org.osate.ge.swt.BaseObservableModel;

/**
 * Test view model for {@link CheckboxEditor}.
 *
 */
class TestCheckboxEditorModel extends BaseObservableModel implements CheckboxEditorModel {
	private Boolean value;

	@Override
	public String getLabel() {
		return "On";
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public Boolean getValue() {
		return value;
	}

	@Override
	public void setValue(boolean value) {
		this.value = value;
		triggerChangeEvent();
	}
}
