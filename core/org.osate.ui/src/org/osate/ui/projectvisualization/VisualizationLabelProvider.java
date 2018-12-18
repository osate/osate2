/*******************************************************************************
 * Copyright 2005-2006, CHISEL Group, University of Victoria, Victoria, BC,
 * Canada. All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: The Chisel Group, University of Victoria IBM CAS, IBM Toronto
 * Lab
 ******************************************************************************/
package org.osate.ui.projectvisualization;

import org.eclipse.core.resources.IProject;
import org.eclipse.draw2d.IFigure;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;
import org.eclipse.zest.core.viewers.EntityConnectionData;
import org.eclipse.zest.core.viewers.GraphViewer;
import org.eclipse.zest.core.viewers.IConnectionStyleProvider;
import org.eclipse.zest.core.viewers.IEntityStyleProvider;
import org.eclipse.zest.core.widgets.ZestStyles;
import org.osate.ui.OsateUiPlugin;

/**
 * Computes the colour of the labels and connections. This is subclassed
 * depending on the view style used.
 * 
 * @author Ian Bull
 */
class VisualizationLabelProvider implements ILabelProvider, IConnectionStyleProvider, IEntityStyleProvider {

	public Color GRAY = new Color(Display.getDefault(), 128, 128, 128);
	public Color LIGHT_GRAY = new Color(Display.getDefault(), 220, 220, 220);
	public Color BLACK = new Color(Display.getDefault(), 0, 0, 0);
	public Color DARK_RED = new Color(Display.getDefault(), 127, 0, 0);
	public Color LIGHT_GREEN = new Color(Display.getDefault(), 96, 255, 96);

	private Object selected = null;
	protected Object rootNode = null;
	private Color disabledColor = null;
	private GraphViewer viewer;
	
	private Color rootColor = null;
	private Color rootSelectedColor = null;
	private boolean reverseBundleDependencies = false;

	/**
	 * Create a new Abstract Visualization Label Provider
	 * 
	 * @param viewer
	 */
	public VisualizationLabelProvider(GraphViewer viewer) {
		this.viewer = viewer;
	}

	public Image getImage(Object element) {
		/*
		 * PDELabelProvider fSharedProvider =
		 * PDEPlugin.getDefault().getLabelProvider(); return
		 * fSharedProvider.get(PDEPluginImages.DESC_PLUGIN_OBJ, 0);
		 */
		if (element.getClass() == EntityConnectionData.class) {
			return null;
		}
		
		return OsateUiPlugin.getDefault().getImageRegistry().get("plugin_obj");
	}

	public String getText(Object element) {
		if (element instanceof IProject) {
			return ((IProject) element).getName();
		}
		return "";
	}

	public void addListener(ILabelProviderListener listener) {

	}

	public boolean isLabelProperty(Object element, String property) {

		return false;
	}

	public void removeListener(ILabelProviderListener listener) {

	}

	public Color getColor(Object rel) {
		return LIGHT_GRAY;
	}

	public int getConnectionStyle(Object rel) {
		return ZestStyles.CONNECTIONS_DIRECTED;
	}

	public Color getHighlightColor(Object rel) {
		return DARK_RED;
	}

	public Color getNodeHighlightColor(Object entity) {
		return null;
	}

	public int getLineWidth(Object rel) {
		return 1;
	}

	public Color getBorderColor(Object entity) {
		if (this.selected != null) {
			if (entity == this.selected) {
				// If this is the selected node return no colour. The default
				// selected colour is fine.
				return BLACK;
			} else {
				return LIGHT_GRAY;
			}

		}

		return BLACK;
	}

	public Color getBorderHighlightColor(Object entity) {
		return null;
	}

	public int getBorderWidth(Object entity) {
		return 0;
	}

	public Color getBackgroundColour(Object entity) {

		if ( entity == this.rootNode ) {
			if ( rootColor == null ) {
				rootColor = LIGHT_GREEN;
			}
			return rootColor;
		}
		if (entity == this.selected) {
			return viewer.getGraphControl().DEFAULT_NODE_COLOR;
		} else {
			return getDisabledColor();
		}
	}

	public Color getForegroundColour(Object entity) {
		if (this.selected != null) {
			if (entity == this.selected) {
				// If this is the selected node return no colour. The default
				// selected colour is fine.
				return BLACK;
			} else {
				return GRAY;
			}

		}
		return BLACK;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.mylyn.zest.core.viewers.IEntityStyleProvider#fisheyeNode(java.lang.Object)
	 */
	public boolean fisheyeNode(Object entity) {
		return true;
	}
	
	/**
	 * Sets the current selection
	 * 
	 * @param root
	 * @param currentSelection
	 */
	public void setCurrentSelection(Object root, Object currentSelection) {
		this.rootNode = root;
		this.selected = null;

		this.selected = currentSelection;

		Object[] connections = viewer.getConnectionElements();
		for (int i = 0; i < connections.length; i++) {
			viewer.update(connections[i], null);
		}
	}

	/**
	 * Creates a colour for disabled lines.
	 * 
	 * @return
	 */
	private Color getDisabledColor() {
		if (disabledColor == null) {
			disabledColor = new Color(Display.getDefault(), new RGB(225, 238, 255));
		}
		return disabledColor;
	}

	public IFigure getTooltip(Object entity) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#dispose()
	 */
	public void dispose() {
		if (this.disabledColor != null) {
			this.disabledColor.dispose();
			this.disabledColor = null;
		}
		if ( this.rootColor != null) {
			this.rootColor.dispose();
			this.rootColor = null;
		}
		if ( this.rootSelectedColor != null) {
			this.rootSelectedColor.dispose();
			this.rootSelectedColor = null;
		}
	}

	public void setReverseBundleDependencies(boolean reverseBundleDependencies) {
		this.reverseBundleDependencies  = reverseBundleDependencies;
	}

	public boolean isReverseBundleDependencies() {
		return reverseBundleDependencies;
	}
	
}