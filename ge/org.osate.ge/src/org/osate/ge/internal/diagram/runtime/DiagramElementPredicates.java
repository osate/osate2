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

import org.osate.ge.graphics.Graphic;
import org.osate.ge.graphics.internal.AgeConnection;
import org.osate.ge.graphics.internal.AgeShape;
import org.osate.ge.graphics.internal.Label;

/**
 * Utility class containing predicates related to {@link DiagramElement}
 *
 */
public final class DiagramElementPredicates {
	/**
	 * Private constructor to prevent instantiation.
	 */
	public DiagramElementPredicates() {
	}

	/**
	 * Returns true if the specified diagram element's graphic is a resizable shape
	 * @param de the diagram element to check
	 * @return true if the specified diagram element's graphic is a resizable shape
	 */
	public static boolean isResizeable(final DiagramElement de) {
		final Graphic graphic = de.getGraphic();
		return graphic instanceof AgeShape && ((AgeShape)graphic).isResizeable();
	}

	/**
	 * Returns true if the specified diagram element is a moveable shape or a flow indicator
	 * @param de the diagram element to check
	 * @return true if the specified diagram element is a moveable shape or a flow indicator
	 * @see #isMoveableShape(DiagramElement)
	 */
	public static boolean isMoveable(final DiagramElement de) {
		return isMoveableShape(de) || isFlowIndicator(de);
	}

	/**
	 * Returns true if the specified diagram element is a shape that can be moved. This includes regular shapes and secondary labels for
	 * connections and flow indicators.
	 * @param de the diagram element to check
	 * @return true if the specified diagram element is a shape that can be moved.
	 */
	public static boolean isMoveableShape(final DiagramElement de) {
		final Graphic graphic = de.getGraphic();
		final boolean shapeSecondaryLabel = graphic instanceof Label && de.getParent() instanceof DiagramElement
				&& ((DiagramElement) de.getParent()).getGraphic() instanceof AgeShape;
		return graphic instanceof AgeShape && !shapeSecondaryLabel;
	}

	/**
	 * Returns true if the specified diagram element has a non-null dock area
	 * @param de the diagram element to check
	 * @return true if the specified diagram element has a non-null dock area
	 */
	public static boolean isDocked(final DiagramElement de) {
		return de.getDockArea() != null;
	}

	/**
	 * Returns true if the specified diagram element has a null dock area
	 * @param de the diagram element to check
	 * @return true if the specified diagram element has a null dock area
	 */
	public static boolean isUndocked(final DiagramElement de) {
		return de.getDockArea() == null;
	}

	/**
	 * Returns true if the specified diagram element's graphic is a shape
	 * @param de the diagram element to check
	 * @return true if the specified diagram element's graphic is a shape
	 */
	public static boolean isShape(final DiagramElement de) {
		return de.getGraphic() instanceof AgeShape;
	}

	/**
	 * Returns true if the specified diagram element's graphic is a regular connection or flow indicator
	 * @param de the diagram element to check
	 * @return true if the specified diagram element's graphic is a regular connection or flow indicator
	 * @see #isFlowIndicator(DiagramElement)
	 * @see #isRegularConnection(DiagramElement)
	 */
	public static boolean isConnection(final DiagramElement de) {
		return de.getGraphic() instanceof AgeConnection;
	}

	/**
	 * Returns true if the specified diagram element's graphic is a flow indicator
	 * @param de the diagram element to check
	 * @return true if the specified diagram element's graphic is a flow indicator
	 */
	public static boolean isFlowIndicator(final DiagramElement de) {
		return de.getGraphic() instanceof AgeConnection && ((AgeConnection) de.getGraphic()).isFlowIndicator;
	}

	/**
	 * Returns true if the specified diagram element's graphic is a connection which is not a flow indicator
	 * @param de the diagram element to check
	 * @return true if the specified diagram element's graphic is a connection which is not a flow indicator.
	 */
	public static boolean isRegularConnection(final DiagramElement de) {
		return de.getGraphic() instanceof AgeConnection && !((AgeConnection) de.getGraphic()).isFlowIndicator;
	}

	/**
	 * Returns true if the specified diagram element supports being shown as an image. Such diagram elements are
	 * undocked shapes which are not labels.
	 * @param de the diagram element to check
	 * @return true if the specified diagram element supports being shown as an image
	 */
	public static boolean supportsImage(final DiagramElement de) {
		return !(de.getGraphic() instanceof Label) && de.getGraphic() instanceof AgeShape && isUndocked(de);
	}
}
