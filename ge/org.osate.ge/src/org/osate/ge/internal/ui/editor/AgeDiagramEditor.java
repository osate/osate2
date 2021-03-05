/**
 * Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file).
 * All Rights Reserved.
 *
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 *
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 *
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
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

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import org.eclipse.core.runtime.Adapters;
import org.eclipse.emf.common.util.URI;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.ui.editor.DiagramBehavior;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.graphiti.ui.editor.IDiagramEditorInput;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.osate.ge.GraphicalEditor;
import org.osate.ge.internal.diagram.runtime.AgeDiagram;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.graphiti.diagram.GraphitiAgeDiagram;
import org.osate.ge.internal.services.ActionExecutor;
import org.osate.ge.internal.services.ActionService;
import org.osate.ge.internal.services.ExtensionRegistryService;
import org.osate.ge.internal.services.ProjectProvider;
import org.osate.ge.internal.services.ProjectReferenceService;
import org.osate.ge.internal.ui.tools.Tool;

import com.google.common.base.Predicates;
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
	public void setDiagramElementsForSelection(final DiagramElement[] diagramElements) {
		((AgeDiagramBehavior) getDiagramBehavior())
		.setDiagramElementsForSelection(ImmutableList.copyOf(diagramElements));
	}

	public void selectDiagramElements(final Collection<DiagramElement> diagramElements) {
		final PictogramElement[] pictogramElements = diagramElements.stream()
				.map(
						de -> getGraphitiAgeDiagram()
						.getPictogramElement(de))
				.filter(Predicates.notNull()).toArray(PictogramElement[]::new);

		getDiagramBehavior().getDiagramContainer().selectPictogramElements(pictogramElements);
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
						Adapters.adapt(this, ExtensionRegistryService.class),
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

	public AgeDiagram getDiagram() {
		return ((AgeDiagramBehavior)getDiagramBehavior()).getAgeDiagram();
	}

	public void activateTool(final Tool tool) {
		((AgeDiagramBehavior) getDiagramBehavior()).activateTool(tool);
	}

	public void deactivateActiveTool() {
		((AgeDiagramBehavior)getDiagramBehavior()).deactivateActiveTool();
	}

	public void clearSelection() {
		selectPictogramElements(new PictogramElement[0]);
		if (outlinePage != null) {
			// Clear outline selection
			outlinePage.setSelection(null);
		}
	}

	public void setDiagramContextIsValid(final boolean value) {
		((AgeDiagramBehavior) getDiagramBehavior()).setDiagramContextIsValid(value);
	}

	public boolean isEditable() {
		return ((AgeDiagramBehavior) getDiagramBehavior()).isEditable();
	}

	/**
	 * Will return null if it is unable to determine the diagram elements for all the selected pictogram elements.
	 * @return
	 */
	public Set<DiagramElement> getSelectedDiagramElements() {
		final PictogramElement[] selectedPes = getSelectedPictogramElements();
		final Set<DiagramElement> selectedDiagramElements = new HashSet<>();
		final GraphitiAgeDiagram graphitiAgeDiagram = getGraphitiAgeDiagram();
		for (final PictogramElement selectedPe : selectedPes) {
			if (selectedPe == null) {
				return null;
			}

			final DiagramElement diagramElement = graphitiAgeDiagram.getClosestDiagramElement(selectedPe);
			if (diagramElement == null) {
				return null;
			}

			selectedDiagramElements.add(diagramElement);
		}

		return selectedDiagramElements;
	}
}
