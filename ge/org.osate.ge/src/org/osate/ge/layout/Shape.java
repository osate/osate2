/*******************************************************************************
 * Copyright (C) 2015 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.osate.ge.layout;

import java.util.ArrayList;
import java.util.List;

/**
 * Positions are relative to parent unless otherwise stated.
 * @author philip.alldredge
 *
 */
public final class Shape 
{
	public enum PositionMode 
	{
		SNAP_LEFT_RIGHT, // Snapped to the left or right side of the container 
		LOCKED, 
		FREE
	}
	
	private Shape parent;
	private int x;
	private int y;
	private int width;
	private int height;
	private boolean minimumSizeIsSet = false;
	private int minimumWidth;
	private int minimumHeight;
	private boolean resizable;
	private PositionMode positionMode;
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
	public Shape(final Shape parent, final int x, final int y, final int width, final int height, final boolean resizable, final PositionMode positionMode) 
	{
		this.parent = parent;
		this.setX(x);
		this.setY(y);
		this.width = width;
		this.height = height;
		this.positionMode = positionMode;
		this.resizable = resizable;

		if(parent != null) {
			parent.children.add(this);
		}
	}

	public final PositionMode getPositionMode()
	{
		return positionMode;
	}
	
	public final Shape getParent() {
		return parent;
	}
	
	public final int getHeight() {
		return height;
	}
	
	public final void setWidth(int value) {
		this.width = value;
	}

	public final int getWidth() {
		return width;
	}
	
	public final void setHeight(int value) {
		this.height = value;
	}

	public final int getX() {
		return x;
	}

	public final void setX(int x) {
		this.x = x;
	}

	public final int getY() {
		return y;
	}

	public final void setY(int y) {
		this.y = y;
	}
	
	public final boolean isResizable() {
		return this.resizable;
	}
	
	public final boolean hasMinimumSize() {
		return this.minimumSizeIsSet;
	}
	
	public final int getMinimumWidth() {
		return minimumWidth;
	}
	
	public final int getMinimumHeight() {
		return minimumHeight;
	}
	
	public final void setMinimumSize(final int width, final int height) {
		this.minimumWidth = width;
		this.minimumHeight = height;
		this.minimumSizeIsSet = true;
	}
	
	public final List<Shape> getChildren() {
		return children;
	}
	
	public final int getAbsoluteX() {
		return ((parent == null) ? 0 : parent.getAbsoluteX()) + x;		
	}
	
	public final int getAbsoluteY() {
		return ((parent == null) ? 0 : parent.getAbsoluteY()) + y;		
	}
}