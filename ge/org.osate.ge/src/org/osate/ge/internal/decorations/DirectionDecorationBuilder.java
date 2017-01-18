package org.osate.ge.internal.decorations;

public class DirectionDecorationBuilder {
	private DirectionDecorationBuilder() {}

	/**
	 * Creates a direction decoration builder.
	 * @return a direction decoration builder
	 */
	public static DirectionDecorationBuilder create() {
		return new DirectionDecorationBuilder();
	}	
	
	public Decoration build() {
		return new DirectionDecoration();
	}
}
