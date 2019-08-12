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

import java.util.Objects;

import org.eclipse.core.runtime.Adapters;
import org.eclipse.emf.common.util.URI;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.ui.editor.DiagramBehavior;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.graphiti.ui.editor.IDiagramEditorInput;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.osate.ge.GraphicalEditor;
import org.osate.ge.internal.diagram.runtime.AgeDiagram;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.graphiti.diagram.GraphitiAgeDiagram;
import org.osate.ge.internal.services.ActionExecutor;
import org.osate.ge.internal.services.ActionService;
import org.osate.ge.internal.services.ExtensionService;
import org.osate.ge.internal.services.ProjectProvider;
import org.osate.ge.internal.services.ProjectReferenceService;
import org.osate.ge.internal.ui.util.ContextHelpUtil;

import com.google.common.collect.ImmutableList;

public class AgeDiagramEditor extends DiagramEditor implements GraphicalEditor {
	public static final String DIAGRAM_EDITOR_ID = "org.osate.ge.editor.AgeDiagramEditor";
	public static final String EXTENSION_NO_DOT = "aadl_diagram";
	public static final String EXTENSION = "." + EXTENSION_NO_DOT;
	private AgeContentOutlinePage outlinePage = null;
	private boolean disposed = false;

	@Override
	public void dispose() {
		try {
			super.dispose();
		} finally {
			disposed = true;

			// Remove invalidated actions from the action service.
			final ActionService actionService = Objects.requireNonNull(
					PlatformUI.getWorkbench().getService(ActionService.class), "Unable to retrieve action service");
			actionService.removeInvalidActions();
		}
	}

	@Override
	public void createPartControl(final Composite parent) {
		super.createPartControl(parent);
		ContextHelpUtil.setHelp(getGraphicalViewer().getControl(), ContextHelpUtil.DIAGRAM_EDITOR);
	}

	public boolean isDisposed() {
		return disposed;
	}

	@Override
	protected DiagramBehavior createDiagramBehavior() {
		return new AgeDiagramBehavior(this);
	}

	// Update the diagram. This call is synchronous and will switch to display thread as necessary.
	public void updateNowIfModelHasChanged() {
		((AgeDiagramBehavior)getDiagramBehavior()).updateNowIfModelHasChanged();
	}

	/*
	 * Calls the Update feature to update the diagram from the model if the editor is visible. If it is not, it will do so the next time the editor is made visible.
	 */
	public void updateDiagramWhenVisible() {
		((AgeDiagramBehavior)getDiagramBehavior()).updateDiagramWhenVisible();
	}

	public void forceDiagramUpdateOnNextModelChange() {
		((AgeDiagramBehavior)getDiagramBehavior()).forceDiagramUpdateOnNextModelChange();
	}

	/**
	 * Selects the diagram elements after the next refresh.
	 * @param diagramElements
	 */
	public void selectDiagramElements(final DiagramElement[] diagramElements) {
		((AgeDiagramBehavior) getDiagramBehavior())
		.setDiagramElementsForSelection(ImmutableList.copyOf(diagramElements));
	}

	@Override
	public void selectDiagramElementsForBusinessObject(final Object bo) {
		// Select all pictogram elements associated with the business object
		selectPictogramElements(getDiagramTypeProvider().getFeatureProvider().getAllPictogramElementsForBusinessObject(bo));
	}

	public ActionExecutor getActionExecutor() {
		return getDiagramBehavior().getActionExecutor();
	}

	@Override
	public AgeDiagramBehavior getDiagramBehavior() {
		return (AgeDiagramBehavior) super.getDiagramBehavior();
	}

	@Override
	public Object getAdapter(@SuppressWarnings("rawtypes") Class required) {
		if(IContentOutlinePage.class.equals(required)) {
			if(outlinePage == null) {
				outlinePage = new AgeContentOutlinePage(this, Adapters.adapt(this, ProjectProvider.class),
						Adapters.adapt(this, ExtensionService.class),
						Adapters.adapt(this, ProjectReferenceService.class));
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

	public AgeDiagram getAgeDiagram() {
		return ((AgeDiagramBehavior)getDiagramBehavior()).getAgeDiagram();
	}

	public void activateTool(final Object tool) {
		((AgeDiagramBehavior) getDiagramBehavior()).activateTool(tool);
	}

	public void deactivateActiveTool() {
		((AgeDiagramBehavior)getDiagramBehavior()).deactivateActiveTool();
	}

	public void clearSelection() {
		selectPictogramElements(new PictogramElement[0]);
	}

	public void setDiagramContextIsValid(final boolean value) {
		((AgeDiagramBehavior) getDiagramBehavior()).setDiagramContextIsValid(value);
	}

	public boolean isEditable() {
		return ((AgeDiagramBehavior) getDiagramBehavior()).isEditable();
	}
}
