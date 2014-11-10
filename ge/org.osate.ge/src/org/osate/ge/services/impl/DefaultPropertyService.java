/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.services.impl;

import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.osate.ge.services.PropertyService;

public class DefaultPropertyService implements PropertyService {
	private static final String NAME_KEY = "name";
	private static final String CONNECTION_TYPE_KEY = "connection_type";
	private static final String SIDE_KEY = "side"; // Which side the shape is on
	private static final String NESTING_DEPTH_KEY = "nesting_depth";
	private static final String LAYOUT_SIDE_KEY = "layout_side"; // Which side the shape is layed out as
	private static final String SELECTED_MODE_KEY = "selected_mode"; // The name of the mode the user has selected in the UI
	private static final String SELECTED_FLOW_KEY = "selected_flow"; // The name of the flow the user has selected in the UI
	private static final String IS_LAYED_OUT_KEY = "is_layed_out"; // Whether the shape has been layed out by the automatic layout algorithm
	private static final String IS_MANUALLY_POSITIONED_KEY = "is_manually_positioned"; // Whether the shape should be ignored by the automatic layout algorithm
	private static final String IS_GHOST_KEY = "is_ghost"; // Whether the pictogram element is a ghost. A ghost is an element that has been hidden because the corresponding business object is no longer valid.
	private static final String IS_INNER_SHAPE_KEY = "is_inner_shape"; // Inner shapes are shapes that are a child of an are considered part of another shape. They may be related to the same business object. They may be active for practical reasons 
	
	/* (non-Javadoc)
	 * @see org.osate.ge.diagrams.common.util.PropertyService#getName(org.eclipse.graphiti.mm.pictograms.PictogramElement)
	 */
	@Override
	public final String getName(final PictogramElement pe) {
		return Graphiti.getPeService().getPropertyValue(pe, NAME_KEY);
	}
	
	/* (non-Javadoc)
	 * @see org.osate.ge.diagrams.common.util.PropertyService#setName(org.eclipse.graphiti.mm.pictograms.PictogramElement, java.lang.String)
	 */
	@Override
	public final void setName(final PictogramElement pe, final String typeName) {
		Graphiti.getPeService().setPropertyValue(pe, NAME_KEY, typeName);
	}
	
	// Is on the left side of the container. Defaults to true if there isn't a value assigned to the property
	/* (non-Javadoc)
	 * @see org.osate.ge.diagrams.common.util.PropertyService#getIsLeft(org.eclipse.graphiti.mm.pictograms.PictogramElement)
	 */
	@Override
	public final boolean getIsLeft(final PictogramElement pe) {
		return !("right".equals(Graphiti.getPeService().getPropertyValue(pe, SIDE_KEY)));
	}
	
	/* (non-Javadoc)
	 * @see org.osate.ge.diagrams.common.util.PropertyService#setIsLeft(org.eclipse.graphiti.mm.pictograms.PictogramElement, boolean)
	 */
	@Override
	public final void setIsLeft(final PictogramElement pe, final boolean value) {
		Graphiti.getPeService().setPropertyValue(pe, SIDE_KEY, value ? "left" : "right");
	}
	
	// If it is layed out such that it is on the left side of the layout container. Defaults to true if there isn't a value assigned to the property
	/* (non-Javadoc)
	 * @see org.osate.ge.diagrams.common.util.PropertyService#getIsLeftLayout(org.eclipse.graphiti.mm.pictograms.PictogramElement)
	 */
	@Override
	public final boolean getIsLeftLayout(final PictogramElement pe) {
		return !("right".equals(Graphiti.getPeService().getPropertyValue(pe, LAYOUT_SIDE_KEY)));
	}
	
	/* (non-Javadoc)
	 * @see org.osate.ge.diagrams.common.util.PropertyService#setIsLeftLayout(org.eclipse.graphiti.mm.pictograms.PictogramElement, boolean)
	 */
	@Override
	public final void setIsLeftLayout(final PictogramElement pe, final boolean value) {
		Graphiti.getPeService().setPropertyValue(pe, LAYOUT_SIDE_KEY, value ? "left" : "right");
	}
	
	@Override
	public final int getNestingDepth(Diagram diagram) {
		final String nestingDepth = Graphiti.getPeService().getPropertyValue(diagram, NESTING_DEPTH_KEY);
		return (nestingDepth == null) ? 0 : Integer.parseInt(nestingDepth);
	}
	
	@Override
	public final void setNestingDepth(Diagram diagram, int depth) {
		Graphiti.getPeService().setPropertyValue(diagram, NESTING_DEPTH_KEY, Integer.toString(depth));
	}
	
	/* (non-Javadoc)
	 * @see org.osate.ge.diagrams.common.util.PropertyService#getSelectedMode(org.eclipse.graphiti.mm.pictograms.Diagram)
	 */
	@Override
	public final String getSelectedMode(final Diagram diagram) {
		final String modeName = Graphiti.getPeService().getPropertyValue(diagram, SELECTED_MODE_KEY);
		return (modeName == null) ? "" : modeName;
	}
	
	/* (non-Javadoc)
	 * @see org.osate.ge.diagrams.common.util.PropertyService#setSelectedMode(org.eclipse.graphiti.mm.pictograms.Diagram, java.lang.String)
	 */
	@Override
	public final void setSelectedMode(final Diagram diagram, final String modeName) {
		Graphiti.getPeService().setPropertyValue(diagram, SELECTED_MODE_KEY, modeName);
	}
	
	/* (non-Javadoc)
	 * @see org.osate.ge.diagrams.common.util.PropertyService#getSelectedFlow(org.eclipse.graphiti.mm.pictograms.Diagram)
	 */
	@Override
	public final String getSelectedFlow(final Diagram diagram) {
		final String modeName = Graphiti.getPeService().getPropertyValue(diagram, SELECTED_FLOW_KEY);
		return (modeName == null) ? "" : modeName;
	}
	
	/* (non-Javadoc)
	 * @see org.osate.ge.diagrams.common.util.PropertyService#setSelectedFlow(org.eclipse.graphiti.mm.pictograms.Diagram, java.lang.String)
	 */
	@Override
	public final void setSelectedFlow(final Diagram diagram, final String flowName) {
		Graphiti.getPeService().setPropertyValue(diagram, SELECTED_FLOW_KEY, flowName);
	}

	/* (non-Javadoc)
	 * @see org.osate.ge.diagrams.common.util.PropertyService#isLayedOut(org.eclipse.graphiti.mm.pictograms.PictogramElement)
	 */
	@Override
	public final boolean isLayedOut(final PictogramElement pe) {
		return "true".equals(Graphiti.getPeService().getPropertyValue(pe, IS_LAYED_OUT_KEY));
	}
	
	/* (non-Javadoc)
	 * @see org.osate.ge.diagrams.common.util.PropertyService#setIsLayedOut(org.eclipse.graphiti.mm.pictograms.PictogramElement, boolean)
	 */
	@Override
	public final void setIsLayedOut(final PictogramElement pe, final boolean value) {
		Graphiti.getPeService().setPropertyValue(pe, IS_LAYED_OUT_KEY, value ? "true" : "false");
	}
	
	@Override
	public boolean isManuallyPositioned(PictogramElement pe) {
		return "true".equals(Graphiti.getPeService().getPropertyValue(pe, IS_MANUALLY_POSITIONED_KEY));
	}
	
	@Override
	public void setIsManuallyPositioned(PictogramElement pe, boolean value) {
		Graphiti.getPeService().setPropertyValue(pe, IS_MANUALLY_POSITIONED_KEY, value ? "true" : "false");
	}	
	
	/* (non-Javadoc)
	 * @see org.osate.ge.diagrams.common.util.PropertyService#isGhost(org.eclipse.graphiti.mm.pictograms.PictogramElement)
	 */
	@Override
	public final boolean isGhost(final PictogramElement pe) {
		return "true".equals(Graphiti.getPeService().getPropertyValue(pe, IS_GHOST_KEY));
	}
	
	/* (non-Javadoc)
	 * @see org.osate.ge.diagrams.common.util.PropertyService#setIsGhost(org.eclipse.graphiti.mm.pictograms.PictogramElement, boolean)
	 */
	@Override
	public final void setIsGhost(final PictogramElement pe, final boolean value) {
		Graphiti.getPeService().setPropertyValue(pe, IS_GHOST_KEY, value ? "true" : "false");
	}
	
	@Override
	public String getConnectionType(Connection c) {
		return Graphiti.getPeService().getPropertyValue(c, CONNECTION_TYPE_KEY);
	}
	
	@Override
	public void setConnectionType(final Connection c, final String value) {
		Graphiti.getPeService().setPropertyValue(c, CONNECTION_TYPE_KEY, value);
	}
	
	@Override
	public boolean isInnerShape(final PictogramElement pe) {
		return "true".equals(Graphiti.getPeService().getPropertyValue(pe, IS_INNER_SHAPE_KEY));
	}
	
	@Override
	public void setIsInnerShape(final PictogramElement pe, final boolean value) {
		Graphiti.getPeService().setPropertyValue(pe, IS_INNER_SHAPE_KEY, value ? "true" : "false");
	}
}
