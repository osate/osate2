/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
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
 * Copyright (C) 2016 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0105
 *******************************************************************************/
package org.osate.ge.services.impl;

import java.util.Objects;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.EditDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.ui.IEditorPart;
import org.osate.ge.GraphicalEditor;
import org.osate.ge.di.Activate;
import org.osate.ge.di.Names;
import org.osate.ge.internal.diagram.runtime.AgeDiagramUtil;
import org.osate.ge.internal.diagram.runtime.DiagramNode;
import org.osate.ge.internal.graphiti.GraphitiAgeDiagramProvider;
import org.osate.ge.internal.services.DiagramService;
import org.osate.ge.internal.services.ExtensionService;
import org.osate.ge.internal.services.ProjectReferenceService;
import org.osate.ge.internal.services.impl.SimpleServiceContextFunction;
import org.osate.ge.internal.ui.editor.AgeDiagramEditor;
import org.osate.ge.services.GraphicalEditorService;

public class DefaultGraphicalEditorService implements GraphicalEditorService {
	private static interface ValueGenerator<T> {
		T generateValue(ExtensionService extService, Object bo, Object diagramBo);
	}

	private final DiagramService diagramService;
	private final ValueGenerator<IEclipseContext> contextBuilder = (extService, bo, diagramBo) -> {
		final IEclipseContext ctx = extService.createChildContext();
		try {
			ctx.set(Names.BUSINESS_OBJECT, bo);
			ctx.set(Names.DIAGRAM_BO, diagramBo);
			return ctx;
		} catch(Exception e) {
			ctx.dispose();
			return null;
		}
	};

	public static class ContextFunction extends SimpleServiceContextFunction<GraphicalEditorService> {
		@Override
		public GraphicalEditorService createService(final IEclipseContext context) {
			return new DefaultGraphicalEditorService(context.get(DiagramService.class));
		}
	}

	public DefaultGraphicalEditorService(final DiagramService diagramService) {
		this.diagramService = Objects.requireNonNull(diagramService, "diagramService must not be null");
	}

	@Override
	public GraphicalEditor openBusinessObject(final Object bo) {
		return diagramService.openOrCreateDiagramForBusinessObject(bo);
	}

	@Override
	public boolean canOperateOn(final Object potentialOperand) {
		Object result = performOperation(potentialOperand, (extService, bo, diagramBo) -> true);
		return result != null;
	}

	@Override
	public Object operateOn(final Object operand, final Object operation) {
		// Activate the operation
		final IEclipseContext context = performOperation(operand, contextBuilder);
		try {
			return ContextInjectionFactory.invoke(operation, Activate.class, context);
		} finally {
			context.dispose();
		}
	}

	/**
	 * Retrieves services and business objects from the operand and generates a value
	 * @param operand
	 * @param valueGenerator
	 * @return null if a value could not be executed. Otherwise, the result of the specified value generator.
	 */
	private <T> T performOperation(final Object operand, final ValueGenerator<T> valueGenerator) {
		if (!(operand instanceof EditPart)) {
			return null;
		}

		final EditPart editPart = (EditPart) operand;
		if (!(editPart.getModel() instanceof PictogramElement)) {
			return null;
		}

		if (editPart.getViewer() == null) {
			return null;
		}

		final PictogramElement pe = (PictogramElement) editPart.getModel();

		// Get services
		final EditDomain editDomain = editPart.getViewer().getEditDomain();
		if (!(editDomain instanceof DefaultEditDomain)) {
			return null;
		}

		final DefaultEditDomain defaultEditDomain = (DefaultEditDomain) editDomain;
		final IEditorPart editorPart = defaultEditDomain.getEditorPart();
		if (!(editorPart instanceof AgeDiagramEditor)) {
			return null;
		}

		final ExtensionService extService = editorPart.getAdapter(ExtensionService.class);
		final GraphitiAgeDiagramProvider graphitiAgeDiagramProvider = editorPart
				.getAdapter(GraphitiAgeDiagramProvider.class);
		final ProjectReferenceService referenceService = editorPart
				.getAdapter(ProjectReferenceService.class);

		// Services may be null if the pictogram element doesn't belong to an OSATE GE Diagram.
		if (extService == null || graphitiAgeDiagramProvider == null
				|| graphitiAgeDiagramProvider.getGraphitiAgeDiagram() == null) {
			return null;
		}

		final DiagramNode dn = graphitiAgeDiagramProvider.getGraphitiAgeDiagram().getClosestDiagramNode(pe);
		if (dn == null) {
			return null;
		}

		final Object bo = dn.getBusinessObject();
		if(bo == null) {
			return null;
		}

		// Diagrams are no longer directly associated with a business object. Use the diagram configuration to determine the diagram business object.
		final Object diagramBo = AgeDiagramUtil.getConfigurationContextBusinessObject(graphitiAgeDiagramProvider.getGraphitiAgeDiagram().getAgeDiagram(), referenceService);
		return valueGenerator.generateValue(extService, bo, diagramBo);
	}
}