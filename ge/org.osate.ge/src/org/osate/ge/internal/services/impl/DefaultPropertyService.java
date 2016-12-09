// Based on OSATE Graphical Editor. Modifications are: 
/*
Copyright (c) 2016, Rockwell Collins.
Developed with the sponsorship of Defense Advanced Research Projects Agency (DARPA).

Permission is hereby granted, free of charge, to any person obtaining a copy of this data, 
including any software or models in source or binary form, as well as any drawings, specifications, 
and documentation (collectively "the Data"), to deal in the Data without restriction, including
without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, 
and/or sell copies of the Data, and to permit persons to whom the Data is furnished to do so, 
subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or 
substantial portions of the Data.

THE DATA IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT 
LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. 
IN NO EVENT SHALL THE AUTHORS, SPONSORS, DEVELOPERS, CONTRIBUTORS, OR COPYRIGHT HOLDERS BE LIABLE 
FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, 
ARISING FROM, OUT OF OR IN CONNECTION WITH THE DATA OR THE USE OR OTHER DEALINGS IN THE DATA.
*/
/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.internal.services.impl;

import org.eclipse.graphiti.mm.PropertyContainer;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.osate.ge.internal.services.PropertyService;

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
	private static final String IS_UNSELECTABLE_KEY = "is_unselectable";
	private static final String IS_TRANSIENT_KEY = "is_transient";
	private static final String IS_LOGICAL_TREE_NODE = "is_lt_node";
	private static final String IS_BACKGROUND_KEY = "is_background";
	private static final String IS_COLORING_CONTAINER_KEY = "is_coloring_container";
	private static final String IS_COLORING_CHILD_KEY = "is_coloring_child";
	private static final String BINDING_TYPE_KEY = "binding_type";
	private static final String SHOW_BINDING_TYPE_KEY_BASE = "show_binding_type";

	@Override
	public final String getName(final PropertyContainer pc) {
		return Graphiti.getPeService().getPropertyValue(pc, NAME_KEY);
	}

	@Override
	public final void setName(final PropertyContainer pc, final String typeName) {
		Graphiti.getPeService().setPropertyValue(pc, NAME_KEY, typeName);
	}
	
	@Override
	public String getDockArea(final PictogramElement pe) {
		return Graphiti.getPeService().getPropertyValue(pe, SIDE_KEY);
	}
	
	@Override
	public void setDockArea(final PictogramElement pe, final String value) {
		if(value == null) {
			Graphiti.getPeService().removeProperty(pe, SIDE_KEY);
		} else {
			Graphiti.getPeService().setPropertyValue(pe, SIDE_KEY, value);
		}
	}
	
	// Is on the left side of the container. Defaults to true if there isn't a value assigned to the property
	/* (non-Javadoc)
	 * @see org.osate.ge.diagrams.common.util.PropertyService#getIsLeft(org.eclipse.graphiti.mm.pictograms.PictogramElement)
	 */
	@Override
	public final boolean getIsLeft(final PictogramElement pe) {
		return !("right".equals(getDockArea(pe)));
	}
	
	/* (non-Javadoc)
	 * @see org.osate.ge.diagrams.common.util.PropertyService#setIsLeft(org.eclipse.graphiti.mm.pictograms.PictogramElement, boolean)
	 */
	@Override
	public final void setIsLeft(final PictogramElement pe, final boolean value) {
		setDockArea(pe, value ? "left" : "right");
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
	
	@Override
	public final String getNestingDepthKey() {
		return NESTING_DEPTH_KEY;
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
	
	@Override
	public boolean isUnselectable(final PictogramElement pe) {
		return "true".equals(Graphiti.getPeService().getPropertyValue(pe, IS_UNSELECTABLE_KEY));
	}
	
	@Override
	public void setIsUnselectable(final PictogramElement pe, final boolean value) {
		Graphiti.getPeService().setPropertyValue(pe, IS_UNSELECTABLE_KEY, value ? "true" : "false");
	}
	
	@Override
	public boolean isTransient(final PictogramElement pe) {
		return "true".equals(Graphiti.getPeService().getPropertyValue(pe, IS_TRANSIENT_KEY));
	}
	
	@Override
	public void setIsTransient(final PictogramElement pe, final boolean value) {
		Graphiti.getPeService().setPropertyValue(pe, IS_TRANSIENT_KEY, value ? "true" : "false");
	}
	
	@Override
	public boolean isLogicalTreeNode(final PictogramElement pe) {
		return "true".equals(Graphiti.getPeService().getPropertyValue(pe, IS_LOGICAL_TREE_NODE));
	}
	
	@Override
	public void setIsLogicalTreeNode(final PictogramElement pe, final boolean value) {
		Graphiti.getPeService().setPropertyValue(pe, IS_LOGICAL_TREE_NODE, value ? "true" : "false");
	}
	
	@Override
	public boolean isBackground(PictogramElement pe) {
		return "true".equals(Graphiti.getPeService().getPropertyValue(pe, IS_BACKGROUND_KEY));
	}
	
	@Override
	public void setIsBackground(PictogramElement pe, boolean value) {
		Graphiti.getPeService().setPropertyValue(pe, IS_BACKGROUND_KEY, value ? "true" : "false");
	}
	
	// Coloring
	
	@Override
	public boolean isColoringContainer(PictogramElement pe) {
		return "true".equals(Graphiti.getPeService().getPropertyValue(pe, IS_COLORING_CONTAINER_KEY));
	}
	
	@Override
	public void setIsColoringContainer(PictogramElement pe, boolean value) {
		Graphiti.getPeService().setPropertyValue(pe, IS_COLORING_CONTAINER_KEY, value ? "true" : "false");
	}
    
	@Override
	public boolean isColoringChild(PictogramElement pe) {
		return "true".equals(Graphiti.getPeService().getPropertyValue(pe, IS_COLORING_CHILD_KEY));
		
	}
	
	@Override
	public void setIsColoringChild(PictogramElement pe, boolean value) {
		Graphiti.getPeService().setPropertyValue(pe, IS_COLORING_CHILD_KEY, value ? "true" : "false");
	}
    
	
	// Bindings
	@Override
	public BindingType getBindingType(final Connection c) {
		return BindingType.getByKey(Graphiti.getPeService().getPropertyValue(c, BINDING_TYPE_KEY));
	}
	
	@Override
	public void setBindingType(final Connection c, final BindingType value) {
		Graphiti.getPeService().setPropertyValue(c, BINDING_TYPE_KEY, value.key);
	}
	
	@Override
	public boolean getShowConnectionBindingType(final Diagram diagram, final BindingType type) {
		return !"false".equals(Graphiti.getPeService().getPropertyValue(diagram, buildShowBindingTypeKey(type)));
	}
	
	@Override
	public void setShowConnectionBindingType(final Diagram diagram, final BindingType type, final boolean value) {
		Graphiti.getPeService().setPropertyValue(diagram, buildShowBindingTypeKey(type), value ? "true" : "false");
	}
	
	private String buildShowBindingTypeKey(final BindingType type) {
		return SHOW_BINDING_TYPE_KEY_BASE + type.key;
	}

}
