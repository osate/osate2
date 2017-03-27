package org.osate.ge.internal.diagram;

import java.util.Objects;

/**
 * Immutable point type
 *
 */
public class Point {
	public Point(final int x, final int y) {
		this.x = x;
		this.y = y;
	}
	
	public Point(final Point p) {
		Objects.requireNonNull(p, "p must not be null");
		this.x = p.x;
		this.y = p.y;
	}
	
	public final int x;
	public final int y;
}
