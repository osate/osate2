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
package org.osate.ge.services;

import java.util.Objects;
import java.util.Optional;

import org.osate.ge.GraphicalEditor;

/**
 * Global service for interacting with the graphical editor.
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
	 * @param object is the object for which to return information. This object is usually retrieved from the global selection and is
	 * not guaranteed to be a particular type.
	 * @return information retrieved from the specified object. If the details could not be determined or is not of the appropriate type,
	 * and empty optional will be returned.
	 * @since 2.0
	 */
	Optional<ObjectDetails> getObjectDetails(Object object);

	/**
	 * Used to return details of a specified object.
	 * @since 2.0
	 */
	class ObjectDetails {
		private final Object diagramBo;
		private final Object bo;

		/**
		 * Creates a new instance
		 * @param diagramBo the business object of the diagram's context.
		 * @param bo the business object associated with the specified object.
		 * @noreference This method is not intended to be referenced by clients.
		 */
		public ObjectDetails(final Object diagramBo, final Object bo) {
			this.diagramBo = diagramBo;
			this.bo = Objects.requireNonNull(bo, "bo must not be null");
		}

		/**
		 * Returns the diagram context of the diagram in which the object is located.
		 * @return the diagram context business object. Null if the diagram is a contextless diagram.
		 */
		public Optional<Object> getDiagramBusinessObject() {
			return Optional.ofNullable(diagramBo);
		}

		/**
		 * Returns the business object associated with the object
		 * @return the business object associated with the object
		 */
		public Object getBusinessObject() {
			return bo;
		}
	}
}
