/**
 * Copyright (c) 2004-2022 Carnegie Mellon University and others. (see Contributors file).
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

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.GraphicalEditor;
import org.osate.ge.internal.diagram.runtime.AgeDiagram;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.model.EmbeddedBusinessObject;
import org.osate.ge.internal.services.DiagramService;
import org.osate.ge.internal.services.impl.SimpleServiceContextFunction;
import org.osate.ge.internal.util.DiagramElementUtil;
import org.osate.ge.services.GraphicalEditorService;

/**
 * {@link GraphicalEditorService} implementation
 *
 */
public class DefaultGraphicalEditorService implements GraphicalEditorService {
	private final DiagramService diagramService;

	/**
	 * Context function which instantiates this service
	 *
	 */
	public static class ContextFunction extends SimpleServiceContextFunction<GraphicalEditorService> {
		@Override
		public GraphicalEditorService createService(final IEclipseContext context) {
			return new DefaultGraphicalEditorService(context.get(DiagramService.class));
		}
	}

	/**
	 * Creates a new instance
	 * @param diagramService the diagram service
	 */
	public DefaultGraphicalEditorService(final DiagramService diagramService) {
		this.diagramService = Objects.requireNonNull(diagramService, "diagramService must not be null");
	}

	@Override
	public GraphicalEditor openBusinessObject(final Object bo) {
		return diagramService.openOrCreateDiagramForBusinessObject(bo);
	}

	@Override
	public Optional<ObjectDetails> getObjectDetails(Object selectedObject) {
		if (!(selectedObject instanceof DiagramElement)) {
			return Optional.empty();
		}

		final DiagramElement selectedDiagramElement = (DiagramElement) selectedObject;
		final Object bo = selectedDiagramElement.getBusinessObject();
		if (bo == null) {
			return Optional.empty();
		}

		// Diagrams do not have a reference to the context business object. It is non-trivial to resolve the context business object using the diagram
		// configuration. Instead, return the business object associated with the only root child which is is associated with a non-embedded business object.
		// If there are multiple such root children then the diagram is a contextless diagram and null will be returned.
		final AgeDiagram diagram = DiagramElementUtil.getDiagram(selectedDiagramElement);
		Object diagramBo = null;
		if (diagram != null) {
			final List<BusinessObjectContext> rootChildren = diagram.getChildren()
					.stream()
					.filter(boc -> boc.getBusinessObject() != null
					&& !(boc.getBusinessObject() instanceof EmbeddedBusinessObject))
					.collect(Collectors.toUnmodifiableList());
			if (rootChildren.size() == 1) {
				diagramBo = rootChildren.get(0).getBusinessObject();
			}
		}

		return Optional.of(new ObjectDetails(diagramBo, bo));
	}
}