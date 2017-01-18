package org.osate.ge.internal.decorations;

public class ImmediateDecorationBuilder {
	private ImmediateDecorationBuilder() {}

	/**
	 * Creates an immediate decoration builder.
	 * @return an immediate decoration builder
	 */
	public static ImmediateDecorationBuilder create() {
		return new ImmediateDecorationBuilder();
	}	
	
	public Decoration build() {
		return new ImmediateDecoration();
	}
}
