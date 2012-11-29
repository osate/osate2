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

package org.osate.imv.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.swt.graphics.Color;
import org.osate.aadl2.EndToEndFlow;
import org.osate.aadl2.FlowImplementation;

public class FlowHighlighter {

	/** Highlight property name. */
	public static final String HIGHLIGHT_PROPERTY = "highlight";

	/** Color property name. */
	public static final String COLOR_PROPERTY = "color";

	/** Default highlighter color. */
	private static final Color DEFAULT_COLOR = ColorConstants.yellow; // Yellow.

	private final FlowImplementation flowImpl;
	// phf: added handling of ETEF
	private final EndToEndFlow etefImpl;
	private Color color;
	boolean highlight;

	private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

	public FlowHighlighter(FlowImplementation flowImpl) {
		this(flowImpl, DEFAULT_COLOR, false);
	}

	public FlowHighlighter(FlowImplementation flowImpl, Color color) {
		this(flowImpl, color, false);
	}

	public FlowHighlighter(FlowImplementation flowImpl, Color color, boolean highlight) {
		this.flowImpl = flowImpl;
		this.etefImpl = null;
		this.color = color;
		this.highlight = highlight;
	}

	public FlowHighlighter(EndToEndFlow etefImpl) {
		this(etefImpl, DEFAULT_COLOR, false);
	}

	public FlowHighlighter(EndToEndFlow etefImpl, Color color) {
		this(etefImpl, color, false);
	}

	public FlowHighlighter(EndToEndFlow etefImpl, Color color, boolean highlight) {
		this.etefImpl = etefImpl;
		this.flowImpl = null;
		this.color = color;
		this.highlight = highlight;
	}

	public void dispose() {
		if(this.color != null) {
			this.color.dispose();
			this.color = null;
		}
	}

	public FlowImplementation getFlowImpl() {
		return flowImpl;
	}

	public EndToEndFlow getETEF() {
		return etefImpl;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		propertyChangeSupport.firePropertyChange(COLOR_PROPERTY, this.color, this.color = color);
	}

	public boolean isHighlight() {
		return highlight;
	}

	public void setHighlight(boolean highlight) {
		propertyChangeSupport.firePropertyChange(HIGHLIGHT_PROPERTY, this.highlight, this.highlight = highlight);
	}

	public void addPropertyChangeListener(String propertyName,
			PropertyChangeListener listener) {
		propertyChangeSupport.addPropertyChangeListener(propertyName, listener);
	}

	public void removePropertyChangeListener(String propertyName, PropertyChangeListener listener) {
		propertyChangeSupport.removePropertyChangeListener(propertyName, listener);
	}
}
