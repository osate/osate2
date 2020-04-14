package org.osate.ge.swt.prototypeBindings;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// TODO

// TODO: Classifier may be null for feature prototype... More options are needed for feature prototypes.

public class PrototypeActual<P, C> {
	private final C classifier;
	private final List<PrototypeBinding<P, C>> bindings; // TODO; Consider whether to make this into a map?

	public PrototypeActual(final C classifier, final List<PrototypeBinding<P, C>> bindings) {
		this.classifier = Objects.requireNonNull(classifier, "classifier must not be null");
		this.bindings = new ArrayList<>(Objects.requireNonNull(bindings, "bindings must not be null"));
	}
}
