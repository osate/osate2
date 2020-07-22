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
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0105.
 *******************************************************************************/
package org.osate.ge.services;

import java.util.Objects;
import java.util.Optional;

import org.osate.ge.GraphicalEditor;

/**
 * Service for interacting with the graphical editor.
 * @noextend
 * @noimplement
 * @see org.osate.ge.GraphicalEditor
 */
public interface GraphicalEditorService {
	/**
	 * Opens a diagram in a graphical editor which has the specified business object as its context. If a diagram is not found, one is created.
	 * @param bo is the business object which is the context business object of the diagram that diagram to be opened.
	 * @return the editor in which the diagram was open. Throws an exception if the editor could not be opened.
	 */
	GraphicalEditor openBusinessObject(Object bo);

	/**
	 * Returns an optional with information about a graphical editor selection.
	 * @param object is the object for which to return information. For the Graphiti based graphical editor EditPart instances should be supported.
	 * This object is usually retrieved from the global selection.
	 * @return information retrieved from the specified object. If the details could not be determined or is not of the appropriate type,
	 * and empty optional will be returned.
	 * @since 2.0
	 */
	Optional<ObjectDetails> getObjectDetails(Object object);

	/**
	 * Used to return details of a selected object.
	 * @since 2.0
	 */
	class ObjectDetails {
		private final Object diagramBo;
		private final Object bo;

		/**
		 * Creates a new instance
		 * @noreference This method is not intended to be referenced by clients.
		 */
		public ObjectDetails(final Object diagramBo, final Object bo) {
			this.diagramBo = diagramBo;
			this.bo = Objects.requireNonNull(bo, "bo must not be null");
		}

		public Optional<Object> getDiagramBusinessObject() {
			return Optional.ofNullable(diagramBo);
		}

		public Object getBusinessObject() {
			return bo;
		}
	}
}
