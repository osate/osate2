package org.osate.ge.internal.annotations;

public class AnnotationBuilder {
	private String text;
	
	/**
	 * Creates the builder.
	 * @return a new annotation builder
	 */
	public static AnnotationBuilder create() {
		return new AnnotationBuilder();
	}	
	
	/**
	 * Sets the text to use to create the Annotation
	 * @param value the new value for the text.
	 * @return this builder to allow method chaining.
	 */
	public AnnotationBuilder text(final String text) {
		this.text = text;
		return this;
	}
	
	/**
	 * Creates a annotation based on the current state of the builder.
	 * @return the newly created annotation
	 */
	public Annotation build() {
		return new AgeAnnotation(text);
	}
}
