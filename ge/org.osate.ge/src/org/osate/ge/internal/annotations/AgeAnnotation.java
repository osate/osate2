package org.osate.ge.internal.annotations;

import java.util.Objects;

public class AgeAnnotation implements Annotation {
	public final String text;
	public final String name;

	public AgeAnnotation(final String text, final String name) {
		this.text = Objects.requireNonNull(text, "text must not be null");
		this.name = name;
	}
}
