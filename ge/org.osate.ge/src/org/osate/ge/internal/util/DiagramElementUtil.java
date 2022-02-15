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
package org.osate.ge.internal.util;

import java.util.Collection;

import org.osate.ge.internal.diagram.runtime.AgeDiagram;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.DiagramNode;

/**
 * Contains utility functions for {@link DiagramElement} objects
 *
 */
public class DiagramElementUtil {
	/**
	 * Private constructor to prevent instantiation.
	 */
	private DiagramElementUtil() {
	}

	/**
	 * Returns true if the specified diagram elements have the same parent
	 * @param diagramElements the diagram elements to check
	 * @return true if the specified diagram elements have the same parent. Returns true if the collection is empty.
	 */
	public static boolean allHaveSameParent(final Collection<DiagramElement> diagramElements) {
		if (diagramElements.size() == 0) {
			return true;
		}

		final DiagramNode parent = diagramElements.iterator().next().getParent();
		return diagramElements.stream().allMatch(de -> de.getParent() == parent);
	}

	/**
	 * Returns the diagram in which the node is contained.
	 * @param initialDiagramNode the node for which to retrieve the diagram
	 * @return returns the diagram in which the node is contained or null if the node was not contained in a diagram.
	 */
	public static AgeDiagram getDiagram(final DiagramNode initialDiagramNode) {
		for (DiagramNode dn = initialDiagramNode; dn != null; dn = dn.getParent()) {
			if (dn instanceof AgeDiagram) {
				return (AgeDiagram) dn;
			}
		}
		return null;
	}

	/**
	 * Finds the first undocked diagram element by checking the specified node and then its ancestors
	 * @param n the diagram node which is the first node to check.
	 * @return the first diagram element without a specified dock area. Returns null if a {@link DiagramNode} which is not a {@link DiagramElement} is encountered.
	 * @see DiagramElement#getDockArea()
	 */
	public static DiagramElement getUndockedDiagramElement(DiagramNode n) {
		while (n instanceof DiagramElement) {
			final DiagramElement e = ((DiagramElement) n);
			if (e.getDockArea() == null) {
				return e;
			}

			n = e.getParent();
		}
		return null;
	}
}
