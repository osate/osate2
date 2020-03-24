package org.osate.ge.swt.prototypes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.osate.ge.swt.BaseObservableModel;
import org.osate.ge.swt.direction.Direction;

// TODO: Make internal once no logner used in org.osate.ge.
/**
 * Test view model for {@link PrototypesEditor}. Requires prototype names to start with "P".
 *
 */
public class TestPrototypesEditorModel extends BaseObservableModel implements PrototypesEditorModel {
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
	public Object[] getPrototypes() {
		return prototypes.toArray();
	}

	@Override
	public String getPrototypeName(Object prototype) {
		return ((TestPrototype) prototype).name;
	}

	@Override
	public String validatePrototypeName(Object prototype, String newName) {
		// TODO: Delegate to other if possible?
		if (!newName.startsWith("P")) {
			return "Name must start with 'P'";
		}

		return null;
	}

	@Override
	public void setPrototypeName(Object prototype, String value) {
		selectedPrototype.name = Objects.requireNonNull(value);
		triggerChangeEvent();
	}

	@Override
	public Direction getPrototypeDirection(Object prototype) {
		return ((TestPrototype) prototype).direction;
	}

	@Override
	public void setPrototypeDirection(Object prototype, Direction value) {
		selectedPrototype.direction = Objects.requireNonNull(value);
		triggerChangeEvent();
	}

	@Override
	public Object getSelectedPrototype() {
		return selectedPrototype;
	}

	@Override
	public void setSelectedPrototype(Object value) {
		selectedPrototype = (TestPrototype) value;
		triggerChangeEvent();
	}

	@Override
	public void removePrototype(Object prototype) {
		if (prototypes.remove(selectedPrototype)) {

			if (selectedPrototype == prototypes) {
				selectedPrototype = null;
			}

			triggerChangeEvent();
		}
	}

	@Override
	public PrototypeType getPrototypeType(final Object prototype) {
		return ((TestPrototype) prototype).type;
	}

	@Override
	public void setPrototypeType(final Object prototype, final PrototypeType value) {
		selectedPrototype.type = Objects.requireNonNull(value);
		triggerChangeEvent();
	}
}

class TestPrototype {
	String name;
	Direction direction;
	PrototypeType type;

	public TestPrototype(final String name) {
		this.name = name;
	}
}
