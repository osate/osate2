/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file).
 * All Rights Reserved.
 *
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 *
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 *
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.ge.swt.prototypes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import org.osate.ge.swt.BaseObservableModel;

/**
 * Test view model for {@link PrototypesEditor}. Requires prototype names to start with "P". Allows up to 6 prototypes.
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
	public boolean canAddPrototype() {
		return prototypes.size() < 6;
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