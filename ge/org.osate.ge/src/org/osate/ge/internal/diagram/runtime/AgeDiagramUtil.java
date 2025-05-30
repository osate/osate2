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

import org.osate.ge.CanonicalBusinessObjectReference;
import org.osate.ge.DockingPosition;
import org.osate.ge.internal.services.ProjectReferenceService;

/**
 * Contains utility functions related to diagrams
 *
 */
public final class AgeDiagramUtil {
	/**
	 * Private constructor to prevent instantiation.
	 */
	private AgeDiagramUtil() {
	}

	/**
	 * Returns the appropriate {@link DockingPosition} for a child with the specified container, position, and size
	 * @param container the container to which the child will be docked
	 * @param x the X component of the child's position relative to the container
	 * @param y the Y component of the child's position relative to the container
	 * @param width the width of the child
	 * @param height the height of child
	 * @return the calculated docking position
	 */
	public static DockingPosition determineDockingPosition(final DiagramNode container, final double x, final double y,
			final double width, final double height) {
		if(!(container instanceof DiagramElement)) {
			return DockingPosition.ANY;
		}

		final DiagramElement containerElement = (DiagramElement)container;
		return determineDockingPosition(containerElement.getWidth(), containerElement.getHeight(), x, y, width, height);
	}

	/**
	 * Returns the appropriate {@link DockingPosition} for a child based on the specified container size and child position, and size
	 * @param containerWidth the width of the container to which the child will be docked
	 * @param containerHeight the height of the container to which the child will be docked
	 * @param x the X component of the child's position relative to the container
	 * @param y the Y component of the child's position relative to the container
	 * @param width the width of the child
	 * @param height the height of child
	 * @return the calculated docking position
	 */
	public static DockingPosition determineDockingPosition(final double containerWidth, final double containerHeight,
			final double x, final double y,
			final double width, final double height) {
		final double minCompareDistanceToTopAndBottom = 20.0; // Gives greater preference to left and right when deciding docking position.
		final double distanceToLeft = Math.max(0, x);
		final double distanceToRight = containerWidth - Math.min(x + width, containerWidth);
		final double distanceToTop = Math.max(minCompareDistanceToTopAndBottom, y);
		final double distanceToBottom = Math.max(minCompareDistanceToTopAndBottom,
				containerHeight - Math.min(y + height, containerHeight));

		// Find the closest dock area while giving priority to the left, right, top, and bottom.
		if (distanceToLeft <= distanceToRight && distanceToLeft <= distanceToTop
				&& distanceToLeft <= distanceToBottom) {
			return DockingPosition.LEFT;
		} else if (distanceToRight <= distanceToTop && distanceToRight <= distanceToBottom) {
			return DockingPosition.RIGHT;
		} else if (distanceToTop <= distanceToBottom) {
			return DockingPosition.TOP;
		} else {
			return DockingPosition.BOTTOM;
		}
	}

	/**
	 * Resolves and returns the diagram's context
	 * Diagram configurations have an optional business object which provides a context for the diagram.
	 * This function returns the context business object referenced by the diagram's configuration.
	 * @param diagram the diagram for which to retrieve the context
	 * @param referenceService the service to use to resolve the context reference
	 * @return the diagram's context. Will return null if the object cannot be found or if the configuration does not reference a business object.
	 */
	public static Object getConfigurationContextBusinessObject(final AgeDiagram diagram, final ProjectReferenceService referenceService) {
		final CanonicalBusinessObjectReference contextBoReference = diagram.getConfiguration().getContextBoReference();
		final Object diagramBo;
		if(contextBoReference == null) {
			diagramBo = null;
		} else {
			diagramBo = referenceService.resolve(contextBoReference);
		}

		return diagramBo;
	}
}
