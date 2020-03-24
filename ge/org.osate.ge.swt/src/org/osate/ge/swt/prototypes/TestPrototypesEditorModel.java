package org.osate.ge.swt.prototypes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.osate.ge.swt.BaseObservableModel;

/**
 * Test view model for {@link PrototypesEditor}. Requires prototype names to start with "P".
 *
 */
class TestPrototypesEditorModel extends BaseObservableModel implements PrototypesEditorModel<TestPrototype> {
	private final List<TestPrototype> prototypes = new ArrayList<>();
	private TestPrototype selectedPrototype;

	public TestPrototypesEditorModel() {
		// Add initial prototypes to the list
		for (int i = 0; i < 5; i++) {
			addPrototype();
		}
	}

	@Override
	public void addPrototype() {
		final TestPrototype newPrototype = new TestPrototype("Prototype " + prototypes.size());
		prototypes.add(newPrototype);
		selectedPrototype = newPrototype;
		triggerChangeEvent();
	}

	@Override
	public TestPrototype[] getPrototypes() {
		return prototypes.toArray(new TestPrototype[prototypes.size()]);
	}

	@Override
	public String getPrototypeName(TestPrototype prototype) {
		return prototype.name;
	}

	@Override
	public String validatePrototypeName(TestPrototype prototype, String newName) {
		if (!newName.startsWith("P")) {
			return "Name must start with 'P'";
		}

		return null;
	}

	@Override
	public void setPrototypeName(TestPrototype prototype, String value) {
		prototype.name = Objects.requireNonNull(value);
		triggerChangeEvent();
	}

	@Override
	public PrototypeDirection getPrototypeDirection(TestPrototype prototype) {
		return prototype.direction;
	}

	@Override
	public void setPrototypeDirection(TestPrototype prototype, PrototypeDirection value) {
		prototype.direction = Objects.requireNonNull(value);
		triggerChangeEvent();
	}

	@Override
	public TestPrototype getSelectedPrototype() {
		return selectedPrototype;
	}

	@Override
	public void setSelectedPrototype(TestPrototype value) {
		selectedPrototype = value;
		triggerChangeEvent();
	}

	@Override
	public void removePrototype(TestPrototype prototype) {
		if (prototypes.remove(prototype)) {

			if (selectedPrototype == prototype) {
				selectedPrototype = null;
			}

			triggerChangeEvent();
		}
	}

	@Override
	public PrototypeType getPrototypeType(final TestPrototype prototype) {
		return prototype.type;
	}

	@Override
	public void setPrototypeType(final TestPrototype prototype, final PrototypeType value) {
		prototype.type = Objects.requireNonNull(value);
		triggerChangeEvent();
	}
}

class TestPrototype {
	String name;
	PrototypeDirection direction;
	PrototypeType type;

	public TestPrototype(final String name) {
		this.name = name;
	}
}
