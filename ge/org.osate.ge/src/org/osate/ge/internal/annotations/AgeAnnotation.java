package org.osate.ge.internal.annotations;

import java.util.Objects;

public class AgeAnnotation implements Annotation {
	public final String text;

	public AgeAnnotation(final String text) {
		this.text = Objects.requireNonNull(text, "text must not be null");
	}
}
