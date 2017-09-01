/*******************************************************************************
 * Copyright (C) 2015 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.osate.ge.internal.layout;

import java.util.ArrayList;
import java.util.List;

/**
 * Positions are relative to parent unless otherwise stated.
 *
 */
public final class Shape
{
	private Shape parent;
	private double x;
	private double y;
	private double width;
	private double height;
	private boolean minimumSizeIsSet = false;
	private double minimumWidth;
	private double minimumHeight;
	private final boolean resizable;
	private final boolean locked; // Whether the shape is locked
	private final boolean positionOnEdge; // Whether the shape should be positioned on the edge of the parent.
	private final List<Shape> children = new ArrayList<Shape>();

	/**
	 * The constructor automatically adds the shape the the parent's list of children
	 * @param parent
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param positionMode
	 */
	public Shape(final Shape parent, final double x, final double y, final double width, final double height,
			final boolean resizable, final boolean locked, final boolean positionOnEdge)
	{
		this.parent = parent;
		this.setX(x);
		this.setY(y);
		this.width = width;
		this.height = height;
		this.locked = locked;
		this.resizable = resizable;
		this.positionOnEdge = positionOnEdge;

		if(parent != null) {
			parent.children.add(this);
		}
	}

	public final boolean isLocked()
	{
		return locked;
	}

	public final boolean isUnlocked()
	{
		return !locked;
	}

	public final Shape getParent() {
		return parent;
	}

	public final double getHeight() {
		return height;
	}

	public final void setWidth(double value) {
		this.width = value;
	}

	public final double getWidth() {
		return width;
	}

	public final void setHeight(double value) {
		this.height = value;
	}

	public final double getX() {
		return x;
	}

	public final void setX(double x) {
		this.x = x;
	}

	public final double getY() {
		return y;
	}

	public final void setY(double y) {
		this.y = y;
	}

	public final boolean isResizable() {
		return this.resizable;
	}

	public final boolean hasMinimumSize() {
		return this.minimumSizeIsSet;
	}

	public final double getMinimumWidth() {
		return minimumWidth;
	}

	public final double getMinimumHeight() {
		return minimumHeight;
	}

	public final void setMinimumSize(final double width, final double height) {
		this.minimumWidth = width;
		this.minimumHeight = height;
		this.minimumSizeIsSet = true;
	}

	public final List<Shape> getChildren() {
		return children;
	}

	public final double getAbsoluteX() {
		return ((parent == null) ? 0 : parent.getAbsoluteX()) + x;
	}

	public final double getAbsoluteY() {
		return ((parent == null) ? 0 : parent.getAbsoluteY()) + y;
	}

	public final boolean positionOnEdge() {
		return positionOnEdge;
	}
}