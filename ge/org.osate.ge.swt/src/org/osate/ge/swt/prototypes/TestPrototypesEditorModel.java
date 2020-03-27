package org.osate.ge.swt.prototypes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import org.osate.ge.swt.BaseObservableModel;

/**
 * Test view model for {@link PrototypesEditor}. Requires prototype names to start with "P".
 * Does not provide any potential constraining classifiers for systems.
 */
final class TestPrototypesEditorModel extends BaseObservableModel
		implements PrototypesEditorModel<TestPrototype, TestClassifier> {
	private final List<TestPrototype> prototypes = new ArrayList<>();
	private final List<TestClassifier> classifiers = new ArrayList<>();
	private TestPrototype selectedPrototype;

	public TestPrototypesEditorModel() {
		// Add initial prototypes to the list
		for (int i = 0; i < 5; i++) {
			addPrototype();
		}

		// Add initial classifiers to the list
		classifiers.add(null);
		for (int i = 0; i < 100; i++) {
			classifiers.add(new TestClassifier("Classifier " + classifiers.size()));
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
	public Stream<TestPrototype> getPrototypes() {
		return prototypes.stream();
	}

	@Override
	public String getPrototypeLabel(final TestPrototype prototype) {
		String refineLabel = "";
		if (prototype.refined == null) {
			refineLabel = "U";
		} else if (prototype.refined == Boolean.TRUE) {
			refineLabel = "R";
		} else if (prototype.refined == Boolean.FALSE) {
			refineLabel = "N";
		}

		return prototype.name + " [" + refineLabel + "]";
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

	@Override
	public Stream<TestClassifier> getConstrainingClassifierOptions(final TestPrototype prototype) {
		return getPrototypeType(prototype) == PrototypeType.SYSTEM ? Stream.empty() : classifiers.stream();
	}

	@Override
	public String getClassifierLabel(final TestClassifier classifier) {
		return classifier == null ? "<None>" : classifier.name;
	}

	@Override
	public TestClassifier getConstrainingClassifier(final TestPrototype prototype) {
		return prototype.classifier;
	}

	@Override
	public void setConstrainingClassifier(final TestPrototype prototype, final TestClassifier value) {
		prototype.classifier = value;
		triggerChangeEvent();
	}

	@Override
	public Boolean isArray(TestPrototype prototype) {
		return prototype.array;
	}

	@Override
	public void setArray(TestPrototype prototype, boolean value) {
		prototype.array = value;
		triggerChangeEvent();
	}

	@Override
	public String getRefineableElementLabel(TestPrototype prototype) {
		return prototype.refineableElementLabel;
	}

	@Override
	public Boolean isRefined(TestPrototype prototype) {
		return prototype.refined;
	}

	@Override
	public void setRefined(TestPrototype prototype, boolean value) {
		prototype.refined = value;
		triggerChangeEvent();
	}
}

class TestPrototype {
	String name;
	PrototypeDirection direction;
	PrototypeType type;
	TestClassifier classifier;
	Boolean array;
	String refineableElementLabel = "SomeElement";
	Boolean refined;

	public TestPrototype(final String name) {
		this.name = name;
	}
}

class TestClassifier {
	String name;

	public TestClassifier(final String name) {
		this.name = name;
	}
}