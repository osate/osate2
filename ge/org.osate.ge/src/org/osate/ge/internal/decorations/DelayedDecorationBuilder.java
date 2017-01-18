package org.osate.ge.internal.decorations;

public class DelayedDecorationBuilder {
	private DelayedDecorationBuilder() {}

	/**
	 * Creates an delayed decoration builder.
	 * @return a delayed decoration builder
	 */
	public static DelayedDecorationBuilder create() {
		return new DelayedDecorationBuilder();
	}	
	
	public Decoration build() {
		return new DelayedDecoration();
	}
}
