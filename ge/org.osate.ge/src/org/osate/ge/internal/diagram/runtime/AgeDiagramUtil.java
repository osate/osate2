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
package org.osate.ge.internal.diagram.runtime;

import org.osate.ge.DockingPosition;
import org.osate.ge.internal.services.ProjectReferenceService;

public class AgeDiagramUtil {
	public static DockingPosition determineDockingPosition(final DiagramNode container, final double x, final double y,
			final double width, final double height) {
		if(!(container instanceof DiagramElement)) {
			return DockingPosition.ANY;
		}

		final DiagramElement containerElement = (DiagramElement)container;

		final double minCompareDistanceToTopAndBottom = 20.0; // Gives greater preference to left and right when deciding docking position.
		final double distanceToLeft = Math.max(0, x);
		final double distanceToRight = containerElement.getWidth() - Math.min(x + width, containerElement.getWidth());
		final double distanceToTop = Math.max(minCompareDistanceToTopAndBottom, y);
		final double distanceToBottom = Math.max(minCompareDistanceToTopAndBottom,
				containerElement.getHeight() - Math.min(y + height, containerElement.getHeight()));

		// Find the closest dock area while giving priority to the left, right, top, and bottom.
		if(distanceToLeft <= distanceToRight && distanceToLeft <= distanceToTop && distanceToLeft <= distanceToBottom) {
			return DockingPosition.LEFT;
		} else if(distanceToRight <= distanceToTop && distanceToRight <= distanceToBottom) {
			return DockingPosition.RIGHT;
		} else if(distanceToTop <= distanceToBottom) {
			return DockingPosition.TOP;
		} else {
			return DockingPosition.BOTTOM;
		}
	}

	// Diagrams are no longer directly associated with a business object. However, diagram configurations have an optional business object which
	// provides a context for the diagram.
	// This function returns the context business object referenced by the diagram's configuration. Will return null if the object cannot be found
	// or if the configuration does not reference a business object.
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
