package org.osate.ge.swt.direction;

import org.osate.ge.swt.BaseObservableModel;

/**
 * Test view model for {@link DirectionEditor}
 *
 */
class TestDirectionEditorModel extends BaseObservableModel implements DirectionEditorModel {
	private Direction direction = Direction.IN_OUT;
	private boolean enabled = true;

	@Override
	public Direction getDirection() {
		return direction;
	}

	@Override
	public void setDirection(Direction value) {
		this.direction = value;
		triggerChangeEvent();
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean value) {
		this.enabled = value;
		triggerChangeEvent();
	}
}
