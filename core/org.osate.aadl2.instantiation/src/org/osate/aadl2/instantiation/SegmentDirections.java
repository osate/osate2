/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.aadl2.instantiation;

import org.osate.aadl2.Connection;
import org.osate.aadl2.ConnectionEnd;
import org.osate.aadl2.Context;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.aadl2.instance.FeatureCategory;
import org.osate.aadl2.instance.FeatureInstance;

/**
 * The direction rules that decide whether one segment of a semantic connection is
 * legal.
 *
 * <p>
 * These are applied to materialized connection instances during connection
 * validation, so that a connection whose direction does not work out is reported
 * against the connection instance itself rather than against a partial path that
 * only the traversal can see.
 * </p>
 */
class SegmentDirections {

	private SegmentDirections() {
	}

	/**
	 * Whether one segment is legal, read from source to destination.
	 *
	 * @param declaration the traversed connection declaration
	 * @param reverse whether the declaration is traversed opposite its declared
	 *            direction
	 * @param source the endpoint the segment is entered from
	 * @param destination the endpoint the segment leaves at
	 */
	static boolean isValid(Connection declaration, boolean reverse, ConnectionInstanceEnd source,
			ConnectionInstanceEnd destination) {
		Connection root = declaration.getRootConnection();
		Context sourceContext = reverse ? root.getAllDestinationContext() : root.getAllSourceContext();
		Context destinationContext = reverse ? root.getAllSourceContext() : root.getAllDestinationContext();
		ConnectionEnd sourceEnd = reverse ? root.getAllDestination() : root.getAllSource();
		ConnectionEnd destinationEnd = reverse ? root.getAllSource() : root.getAllDestination();
		boolean goingUp = !(destinationContext instanceof Subcomponent)
				&& (sourceEnd instanceof Subcomponent || sourceContext instanceof Subcomponent);
		boolean goingDown = !(sourceContext instanceof Subcomponent)
				&& (destinationEnd instanceof Subcomponent || destinationContext instanceof Subcomponent);

		/*
		 * Travelling up, a segment leaves an outgoing feature and arrives at an outgoing
		 * one, because the outer feature carries the flow further out. Travelling down,
		 * both are incoming. Crossing between peers, the source is outgoing and the
		 * destination incoming.
		 */
		if (source instanceof FeatureInstance sourceFeature) {
			DirectionType direction = sourceFeature.getFlowDirection();
			if (!(goingDown ? direction.incoming() : direction.outgoing())) {
				return false;
			}
		}
		if (destination instanceof FeatureInstance destinationFeature) {
			DirectionType direction = destinationFeature.getFlowDirection();
			if (!(goingUp ? direction.outgoing() : direction.incoming())) {
				return false;
			}
		}
		return accessDirectionsAgree(goingUp, goingDown, source, destination);
	}

	/**
	 * Whether two connected data accesses face compatible ways.
	 *
	 * <p>
	 * Between peers they must face opposite ways, one providing and one requiring. Up or
	 * down the hierarchy they must face the same way, because the outer feature passes
	 * the inner one along rather than consuming it. Access features all report
	 * {@code in out} as their flow direction, so this distinction is only visible in the
	 * declared direction.
	 * </p>
	 */
	private static boolean accessDirectionsAgree(boolean goingUp, boolean goingDown, ConnectionInstanceEnd source,
			ConnectionInstanceEnd destination) {
		if (!(source instanceof FeatureInstance sourceFeature)
				|| !(destination instanceof FeatureInstance destinationFeature)) {
			return true;
		}
		if (sourceFeature.getCategory() != FeatureCategory.DATA_ACCESS
				|| destinationFeature.getCategory() != FeatureCategory.DATA_ACCESS) {
			return true;
		}
		DirectionType sourceDirection = sourceFeature.getDirection();
		DirectionType destinationDirection = destinationFeature.getDirection();
		return goingUp || goingDown ? sourceDirection == destinationDirection
				: sourceDirection.getInverseDirection() == destinationDirection;
	}
}
