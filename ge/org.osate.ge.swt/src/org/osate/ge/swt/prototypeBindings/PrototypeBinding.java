package org.osate.ge.swt.prototypeBindings;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// TODO:
public class PrototypeBinding<P, C> {

	// TODO; Should this stuff be final.. immutable is nice but will be a pain to chain.. think recursively...

	private final P prototype;
	private final List<PrototypeActual<P, C>> actuals;

	public PrototypeBinding(final P prototype, final List<PrototypeActual<P, C>> actuals) {
		this.prototype = Objects.requireNonNull(prototype, "prototype must not be null");
		this.actuals = new ArrayList<>(Objects.requireNonNull(actuals, "actuals must not be null"));
	}

	// TODO: Prototype
	// TODO: Actual(s) Actual<C, P>

}
