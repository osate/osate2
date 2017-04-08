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
package org.osate.ge.internal.services;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.graphiti.mm.PropertyContainer;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

/**
 * Contains methods to access the properties of pictogram elements. Unless otherwise specified, setting a property value does not update the diagram shapes to reflect changes visually.
 *
 */
public interface PropertyService {
	String getName(PropertyContainer pc);
	void setName(PropertyContainer pc, String typeName);

	boolean isConnectionAnchor(Anchor anchor);
	void setIsConnectionAnchor(Anchor anchor, boolean value);
	
	String getSelectedMode(Diagram diagram);

	void setSelectedMode(Diagram diagram, String modeName);

	String getSelectedFlow(Diagram diagram);

	void setSelectedFlow(Diagram diagram, String flowName);
	
	String getConnectionType(Connection c);
	void setConnectionType(Connection c, String type);
	
	// Inner objects may have parents with the same business object as themselves. It is best to get the business object from the parent.
	boolean isInnerShape(PictogramElement pe);
	void setIsInnerShape(PictogramElement pe, boolean value);
	
	boolean isUnselectable(PictogramElement pe);
	void setIsUnselectable(PictogramElement pe, boolean value);
	
	// Sets whether a pictogram element is transient. A transient pictogram element is a pictogram element that is recreated whenever its owner is updated. Transient shapes
	// should not be referenced.
	boolean isTransient(PictogramElement pe);
	void setIsTransient(PictogramElement pe, boolean value);
	
	// A logical tree node is one that is used as the basis for navigating the diagram when when using queries.
	// Each business object which appears in the diagram should have one pictogram element which is a logical tree node.
	boolean isLogicalTreeNode(PictogramElement pe);
	void setIsLogicalTreeNode(PictogramElement pe, boolean value);
	
	/**
	 * Sets whether the shape is a "background" shape. Background shapes are inner shape that are used when a non-selectable inner shape that will be behind other features is needed. Disables overlap checks.
	 * @param pe
	 * @return
	 */
	boolean isBackground(PictogramElement pe);
	void setIsBackground(PictogramElement pe, boolean value);  
	
	boolean isUnresizable(PictogramElement pe);
	void setIsUnresizable(PictogramElement pe, boolean value);
	
	// Bindings
	BindingType getBindingType(Connection c);
	void setBindingType(Connection c, BindingType value);
	boolean getShowConnectionBindingType(Diagram diagram, BindingType type);
	void setShowConnectionBindingType(Diagram diagram, BindingType type, boolean value);
	
	static enum BindingType {
		ACTUAL_CONNECTION("actual_connection"),
		ACTUAL_FUNCTION("actual_function"),
		ACTUAL_MEMORY("actual_memory"),
		ACTUAL_PROCESSOR("actual_processor"),
		ALLOWED_CONNECTION("allowed_connection"),
		ALLOWED_MEMORY("allowed_memory"),
		ALLOWED_PROCESSOR("allowed_processor");
		
		private static Map<String, BindingType> keyToBindingTypeMap = new HashMap<String, BindingType>();
		public final String key;

		static {
			for(final BindingType bindingType : values()) {
				keyToBindingTypeMap.put(bindingType.key, bindingType);
			}
		}
		
		BindingType(final String key) {
			this.key = key;
		}
		
		/**
		 * Returns the binding type with the specified key.
		 * @param key the key of the binding type to be returned. A null value will result in a null binding type being returned.
		 * @return the appropriate binding type. Returns null if it is not found or if key is null.
		 */
		public static BindingType getByKey(final String key) {
			return keyToBindingTypeMap.get(key);
		}
	};
}