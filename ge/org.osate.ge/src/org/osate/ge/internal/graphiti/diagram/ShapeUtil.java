package org.osate.ge.internal.graphiti.diagram;

import java.util.Collection;

import org.eclipse.graphiti.mm.pictograms.Shape;

public class ShapeUtil {
	public static Shape getShapeByName(final Collection<? extends Shape> shapes, final String name) {
		for (final Shape child : shapes) {
			if (name.equals(PropertyUtil.getName(child))) {
				return child;
			}
		}

		return null;
	}
}
