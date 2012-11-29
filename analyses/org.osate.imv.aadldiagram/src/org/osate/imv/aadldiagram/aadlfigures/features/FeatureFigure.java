/************************************************************************************
 * Copyright (c) 2012 Brandon Breuil. Contributions by Peter Feiler.                                               *
 *                                                                                  *
 * All rights reserved. This program and the accompanying materials are made        *
 * available under the terms of the Eclipse Public License v1.0 which accompanies   *
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html *
 *                                                                                  *
 * Use is subject to the terms of Eclipse Public License v1.0.                      *
 *                                                                                  *
 ************************************************************************************/

package org.osate.imv.aadldiagram.aadlfigures.features;

import org.eclipse.draw2d.Border;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.TextUtilities;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;
import org.osate.imv.aadldiagram.adapters.FeatureDirectionType;
import org.osate.imv.aadldiagram.draw2d.ResizableMevFigure;
import org.osate.imv.aadldiagram.draw2d.SelectableMevFigure;


public abstract class FeatureFigure extends SelectableMevFigure{

	public static final int H_LABEL_GAP = 5;
	public static final int V_LABEL_GAP = 2;

	public static enum FeatureLabelStyle {LABEL_STYLE1, LABEL_STYLE2};

	private static final Color DEFAULT_FOREGROUND_COLOR = ColorConstants.black;
	private static final Color DEFAULT_BACKGROUND_COLOR = ColorConstants.black;

	private static final Font DEFAULT_LBL_FONT = new Font(Display.getCurrent(), "Arial", 10, SWT.NORMAL);

	/*
	 * Size constants.
	 */
	protected  Dimension eastWestDimension;
	protected  Dimension northSouthDimension;

	private Dimension labelSize = null;

	private FeatureOrientation orientation;

	private FeatureDirectionType direction;

	protected String label;

	protected FeatureLabelStyle labelStyle;

	public FeatureFigure(String label, FeatureDirectionType direction, FeatureLabelStyle labelStyle) {
		this(DEFAULT_LBL_FONT, label, direction, labelStyle);
	}

	public FeatureFigure(Font labelFont, String label, FeatureDirectionType direction, FeatureLabelStyle labelStyle) {
		this.labelStyle = labelStyle;
		// Configure the client area.
		setupClientArea();
		this.label = label;
		setFont(labelFont);
		// Get the label's dimensions.
		labelSize = this.calculateTextSize();
		// Calculate dimensions.
		calculateDimensions();
		// Set the default orientation.
		setOrientation(FeatureOrientation.WEST);
		// Set direction.
		this.setDirection(direction);
		// Set default colors.
		this.setForegroundColor(DEFAULT_FOREGROUND_COLOR);
		this.setBackgroundColor(DEFAULT_BACKGROUND_COLOR);
	}

	@Override
	public void paintFigure(Graphics g) {
		super.paintFigure(g);

		// All features will be drawn using local coordinates.
		Rectangle bounds = this.getClientArea();
		g.translate(bounds.x, bounds.y);

		g.setAntialias(SWT.ON);

		// Draw the feature using local coordinates.
		drawFeature(g);
	}


	protected abstract int getSymbolHorizontalExtent();
	protected abstract int getSymbolVerticalExtent();

	protected void drawFeature(Graphics g) {
		// Save graphic context.
		g.pushState();
		// Draw label.
		drawLabel(g, getLabelSize());
		// Restore GC.
		g.restoreState();
		// Transform CTM based on current orientation.
		getFeatureTransform().applyTransform(g);
		// A subclass will draw the graphical symbol for the feature.
		drawSymbol(g);
		// Restore graphic context.
		g.popState();
	}

	protected abstract void drawSymbol(Graphics g);

	protected OrientationTransform getFeatureTransform() {
		OrientationTransform transform = null;

		switch(labelStyle){
		case LABEL_STYLE1:
			transform = getFeatureTrasformStyle1();
			break;
		case LABEL_STYLE2:
			transform = getFeatureTrasformStyle2();
			break;
		}

		return transform;
	}

	protected void drawLabel(Graphics g, Dimension labelSize) {
		switch(labelStyle){
		case LABEL_STYLE1:
			drawLabelStyle1(g, labelSize);
			break;
		case LABEL_STYLE2:
			drawLabelStyle2(g, labelSize);
			break;
		}
	}

	protected void drawLabelStyle1(Graphics g, Dimension labelSize) {
		// Get the client area's bounds.
		Rectangle bounds = this.getClientArea();
		int x = 0, y = 0; // Label coordinates
		int verticalExtent = this.getSymbolVerticalExtent();

		// Calculate coordinates.
		switch(getOrientation()){
		case NORTH:
			x = 0;
			y = (int)(0.5f * (verticalExtent - labelSize.height));
			break;
		case SOUTH:
			x = 0;
			y = (int)(0.5f * (verticalExtent - labelSize.height));
			break;
		case EAST:
			y = 0;
			x = 0;
			break;
		case WEST:
			y = 0;
			x = 0;
			break;
		}

		// Configure GC.
		g.setForegroundColor(ColorConstants.black);
		// Draw label.
		g.drawString(label, x, y);
	}

	protected void drawLabelStyle2(Graphics g, Dimension labelSize) {
		// Get the client area's bounds.
		Rectangle bounds = this.getClientArea();
		int x = 0, y = 0; // Label coordinates
		int verticalExtent = this.getSymbolVerticalExtent();
		int horizontalExtent = this.getSymbolHorizontalExtent();

		// Calculate coordinates.
		switch(getOrientation()){
		case NORTH:
			x = (int)(0.5f * (bounds.width - labelSize.width));
			y = (int)(verticalExtent + V_LABEL_GAP);
			break;
		case SOUTH:
			x = (int)(0.5f * (bounds.width - labelSize.width));
			break;
		case EAST:
			y = (int)(0.5f * (horizontalExtent - labelSize.height));
			break;
		case WEST:
			x = verticalExtent + H_LABEL_GAP;
			y = (int)(0.5f * (horizontalExtent - labelSize.height));
			break;
		}

		// Configure GC.
		g.setForegroundColor(ColorConstants.black);
		// Draw label.
		g.drawString(label, x, y);
	}

	protected OrientationTransform getFeatureTrasformStyle1(){
		Rectangle bounds = getClientArea();
		float dx = 0, dy = 0;
		float angle = 0;
		int verticalExtent = this.getSymbolVerticalExtent();
		int horizontalExtent = this.getSymbolHorizontalExtent();

		switch(getOrientation()){
		case NORTH:
			dx = bounds.width - horizontalExtent;
			break;
		case SOUTH:
			dx = bounds.width - horizontalExtent;
			dy = bounds.height - verticalExtent;
			break;
		case EAST:
			dx = bounds.width - verticalExtent;
			dy = bounds.height;
			angle = -90.0f;
			break;
		case WEST:
			dy = bounds.height;
			angle = -90.0f;
			break;
		}

		return new OrientationTransform(dx, dy, angle);
	}

	protected OrientationTransform getFeatureTrasformStyle2(){
		Rectangle bounds = getClientArea();
		float dx = 0, dy = 0;
		float angle = 0;
		int verticalExtent = this.getSymbolVerticalExtent();
		int horizontalExtent = this.getSymbolHorizontalExtent();

		switch(getOrientation()){
		case NORTH:
			dx = 0.5f * (bounds.width - horizontalExtent);
			break;
		case SOUTH:
			dx = 0.5f * (bounds.width - horizontalExtent);
			dy = bounds.height - verticalExtent;
			break;
		case EAST:
			dx = bounds.width - verticalExtent;
			dy = bounds.height - (0.5f * (bounds.height - horizontalExtent));
			angle = -90.0f;
			break;
		case WEST:
			dy = bounds.height - (0.5f * (bounds.height - horizontalExtent));
			angle = -90.0f;
			break;
		}

		return new OrientationTransform(dx, dy, angle);
	}

	private void setupClientArea(){
		// A MarginBorder will be used to insets the client area.
		int offset = (int)ResizableMevFigure.SELECTION_HANDLE_WIDTH;
		Border margins = new MarginBorder(new Insets(offset));
		this.setBorder(margins);
	}

	protected void calculateDimensions() {
		Dimension labelDimension  = getLabelSize();
		int verticalExtent = this.getSymbolVerticalExtent();
		int horizontalExtent = this.getSymbolHorizontalExtent();

		if(labelStyle.equals(FeatureLabelStyle.LABEL_STYLE1)){
			// Calculate east and west orientation dimension.
			int featureWidth = labelDimension.width >= verticalExtent ? labelDimension.width : verticalExtent;
			featureWidth += getInsets().getWidth();
			eastWestDimension = new Dimension(featureWidth, horizontalExtent + labelDimension.height + getInsets().getHeight());

			// Calculate north and south orientation dimension.
			northSouthDimension = new Dimension(labelDimension.width + horizontalExtent + H_LABEL_GAP + getInsets().getWidth(), verticalExtent + getInsets().getHeight());
		} else if(labelStyle.equals(FeatureLabelStyle.LABEL_STYLE2)){
			// Calculate east and west orientation dimension.
			eastWestDimension = new Dimension(labelDimension.width + verticalExtent + H_LABEL_GAP + getInsets().getWidth(), horizontalExtent + getInsets().getHeight());

			// Calculate north and south orientation dimension.
			int featureWidth = labelDimension.width >= horizontalExtent ? labelDimension.width : horizontalExtent;
			featureWidth += getInsets().getWidth();
			northSouthDimension = new Dimension(featureWidth, labelDimension.height + verticalExtent + V_LABEL_GAP + getInsets().getHeight());
		}
	}

	public Point getConnectionAnchorPoint() {
		Point point = null;
		Rectangle bounds = getClientArea();
		int verticalExtent = this.getSymbolVerticalExtent();
		int horizontalExtent = this.getSymbolHorizontalExtent();

		switch(labelStyle){
		case LABEL_STYLE1:
			int baseCenter = (int)Math.ceil(0.5f * horizontalExtent);
			// Set the connection point based on the feature's orientation.
			switch(getOrientation()){
			case NORTH:
				point = new Point(bounds.right() - baseCenter, bounds.y + verticalExtent - 1);
				break;
			case SOUTH:
				point = new Point(bounds.right() - baseCenter, bounds.bottom() - verticalExtent + 1);
				break;
			case EAST:
				point = new Point(bounds.right() - verticalExtent + 1, bounds.bottom() - baseCenter);
				break;
			case WEST:
				point = new Point(bounds.x + verticalExtent - 1, bounds.bottom() - baseCenter);
				break;
			default:
				// This should never occur.
				point = bounds.getCenter();
				break;
			}
			break;
		case LABEL_STYLE2:
			// Set the connection point based on the feature's orientation.
			switch(getOrientation()){
			case NORTH:
				point = bounds.getTop();
				break;
			case SOUTH:
				point = bounds.getBottom();
				break;
			case EAST:
				point = bounds.getRight();
				break;
			case WEST:
				point = bounds.getLeft();
				break;
			default:
				// This should never occur.
				point = bounds.getCenter();
				break;
			}
			break;
		}

		return point;
	}


	/**
	 * Calculates and returns the size of the Label's text. Note that this
	 * Dimension is calculated using the Label's full text, regardless of
	 * whether or not its text is currently truncated. If text size considering
	 * current truncation is desired, use {@link #calculateSubStringTextSize()}.
	 *
	 * @return the size of the label's text, ignoring truncation
	 */
	protected Dimension calculateTextSize() {
		return TextUtilities.INSTANCE.getTextExtents(label, getFont());
	}

	/**
	 * @see IFigure#setPreferredSize(Dimension)
	 */
	@Override
	public void setPreferredSize(Dimension size) {
		if (prefSize != null && prefSize.equals(size))
			return;
		prefSize = size;
	}

	private void setDimensions(){
		switch(orientation){
		case NORTH:
		case SOUTH:
			setPreferredSize(northSouthDimension);
			break;
		case EAST:
		case WEST:
			setPreferredSize(eastWestDimension);
			break;
		}
	}

	public void setOrientation(FeatureOrientation orientation){
		if(this.orientation != null && this.orientation.equals(orientation))
			return;

		this.orientation = orientation;
		// Set dimensions based on orientation.
		setDimensions();
	}

	public FeatureOrientation getOrientation(){
		return this.orientation;
	}

	protected Dimension getEastWestDimension() {
		return eastWestDimension;
	}

	protected void setEastWestDimension(Dimension eastWestDimension) {
		this.eastWestDimension = eastWestDimension;
	}

	protected Dimension getNorthSouthDimension() {
		return northSouthDimension;
	}

	protected void setNorthSouthDimension(Dimension northSouthDimension) {
		this.northSouthDimension = northSouthDimension;
	}

	protected Dimension getLabelSize(){
		// Never return a dimension that is null.
		return (labelSize != null ? labelSize : new Dimension());
	}

	public FeatureDirectionType getDirection() {
		return direction;
	}

	public void setDirection(FeatureDirectionType direction) {
		this.direction = direction;
	}


	/**
	 * Inner class that stores the transform parameters for a particular feature orientation.
	 * Intended to be used by subclasses to transform a symbol's coordinates based on the feature's
	 * current orientation.
	 */
	protected class OrientationTransform {
		private float dx;
		private float dy;
		private float rotationAngle;

		public OrientationTransform(){
			this(0, 0);
		}

		public OrientationTransform(float dx, float dy){
			this(dx, dy, 0);
		}

		public OrientationTransform(float dx, float dy, float rotationAngle){
			this.dx = dx;
			this.dy = dy;
			this.rotationAngle = rotationAngle;
		}

		public float getDx() {
			return dx;
		}

		public float getDy() {
			return dy;
		}

		public float getRotationAngle() {
			return rotationAngle;
		}

		public void applyTransform(Graphics g)  {
			g.translate(dx, dy);

			// Due to a bug in the SWT graphics. A translate must be performed to force the sharedclipping
			// variable to be set to false before a rotation transform is performed.
			g.translate(1, 1);
			g.translate(-1, -1);

			g.rotate(rotationAngle);
		}

	}

}
