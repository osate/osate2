package org.osate.ge.internal.diagram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

// TODO: Move to another class
public class BusinessObjectReference {
	private List<String> segments;
	
	public BusinessObjectReference(final String[] reference) {
		this.segments = Collections.unmodifiableList(new ArrayList<>(Arrays.asList(Objects.requireNonNull(reference, "reference must not be null"))));
	}
}
