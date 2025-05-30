/**
 * Copyright (c) 2004-2025 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.ge.internal.diagram.runtime;

import java.util.Collection;
import java.util.stream.Stream;

import org.osate.ge.BusinessObjectContext;
import org.osate.ge.RelativeBusinessObjectReference;

/**
 * A node in a diagram. {@link AgeDiagram} is expected to be the root of the diagram. Other nodes are expected to be
 * instances of {@link DiagramElement}.
 */
public abstract class DiagramNode implements BusinessObjectContext {
	@Override
	public abstract DiagramNode getParent();

	@Override
	public abstract Collection<DiagramElement> getChildren();

	/**
	 * Returns the child which has the specified relative reference
	 * @param ref the relative reference of the requested child
	 * @return the child diagram element which has the specified relative reference
	 */
	public abstract DiagramElement getChildByRelativeReference(final RelativeBusinessObjectReference ref);

	/**
	 * Returns this node and all of its descendants
	 * @return a stream containing this and all descendant nodes.
	 */
	public Stream<DiagramNode> getAllDiagramNodes() {
		return Stream.concat(Stream.of(this), getChildren().stream().flatMap(DiagramNode::getAllDiagramNodes));
	}

	/**
	 * Returns a modifiable collection containing the diagram node's children
	 * @return a modifiable collection containing the diagram node's children
	 * @see DiagramModification#addElement(DiagramElement)
	 * @see DiagramModification#removeElement(DiagramElement)
	 */
	abstract DiagramElementCollection getModifiableChildren();
}
