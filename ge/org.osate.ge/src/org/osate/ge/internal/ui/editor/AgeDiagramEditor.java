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
package org.osate.ge.internal.ui.editor;

import org.eclipse.emf.common.util.URI;
import org.eclipse.graphiti.ui.editor.DiagramBehavior;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.graphiti.ui.editor.IDiagramEditorInput;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.osate.ge.GraphicalEditor;
import org.osate.ge.internal.graphiti.diagram.GraphitiAgeDiagram;

public class AgeDiagramEditor extends DiagramEditor implements GraphicalEditor {
	public static final String DIAGRAM_EDITOR_ID = "org.osate.ge.editor.AgeDiagramEditor";
	public static final String EXTENSION_NO_DOT = "aadl_diagram";
	public static final String EXTENSION = "." + EXTENSION_NO_DOT;
	private AgeContentOutlinePage outlinePage = null;
	
	public AgeDiagramEditor() {
	}
	
	protected DiagramBehavior createDiagramBehavior() {
		return new AgeDiagramBehavior(this);
	}
	
	/*
	 * Calls the Update feature to update the diagram from the model if the editor is visible. If it is not, it will do so the next time the editor is made visible.
	 */
	public void updateDiagramWhenVisible() {
		((AgeDiagramBehavior)getDiagramBehavior()).updateDiagramWhenVisible();
	}
	
	@Override
	public void selectDiagramElementsForBusinessObject(final Object bo) {
		// Select all pictogram elements associated with the business object
		selectPictogramElements(getDiagramTypeProvider().getFeatureProvider().getAllPictogramElementsForBusinessObject(bo));
	}
	
	@Override
	public Object getAdapter(@SuppressWarnings("rawtypes") Class required) {
		if(IContentOutlinePage.class.equals(required)) {
			if(outlinePage == null) {
				outlinePage = new AgeContentOutlinePage(this);
			}
			return outlinePage;
		} else if(required == org.eclipse.ui.views.properties.IPropertySheetPage.class) {
			// Return null if initialization failed. This is a workaround for an exception being thrown by the super implementation of getAdapter() in cases where initialization isn't completed
			if(((AgeDiagramBehavior)getDiagramBehavior()).initializationFailed()) {
				return null;
			}
		};
		
		return super.getAdapter(required);
	}
	
	@Override
	public void refreshTitle() {
		final IDiagramEditorInput input = getDiagramEditorInput();
		String name = null;
		if(input != null) {
			final URI uri = input.getUri();
			if(uri != null) {
				name = URI.decode(uri.lastSegment());
			}
		}
		
		if(name == null) {
			name = "";
		}

		setPartName(name);
	}
	
	public GraphitiAgeDiagram getGraphitiAgeDiagram() {
		return ((AgeDiagramBehavior)getDiagramBehavior()).getGraphitiAgeDiagram();
	}
}
