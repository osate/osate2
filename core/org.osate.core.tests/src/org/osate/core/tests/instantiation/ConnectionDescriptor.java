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
package org.osate.core.tests.instantiation;

import java.util.ArrayList;
import java.util.List;

import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.aadl2.instance.SystemOperationMode;

/**
 * Normalized description of one materialized {@link ConnectionInstance}.
 *
 * <p>
 * Identity is carried by {@link Key} and is built from structure rather than from
 * the display name. Connection names are derived only from the container-relative
 * source and destination paths, so two distinct semantic paths with the same
 * endpoint pair share a name. The name is a compared value, not a lookup key.
 * </p>
 *
 * <p>
 * Position within the containing component's connection list is not a field here.
 * Collection order is an approved intended difference for across-first traversal,
 * so it is recorded separately by {@link InstanceSnapshot}, which keeps its
 * per-container lists in collection order.
 * </p>
 */
public record ConnectionDescriptor(Key key, String name, String kind, boolean complete, boolean bidirectional,
		List<String> systemOperationModes, List<String> properties) {

	public ConnectionDescriptor {
		systemOperationModes = List.copyOf(systemOperationModes);
		properties = List.copyOf(properties);
	}

	/**
	 * Structured identity of a connection instance: where it lives, what it
	 * connects, which declarations it traverses in which contexts, and in which
	 * orientation each of those declarations is used.
	 */
	public record Key(String containerKey, String sourceKey, String destinationKey, List<String> declarationKeys,
			List<String> contextKeys, List<Boolean> reverseFlags) {

		public Key {
			declarationKeys = List.copyOf(declarationKeys);
			contextKeys = List.copyOf(contextKeys);
			reverseFlags = List.copyOf(reverseFlags);
		}
	}

	/** Describe a materialized connection instance contained in {@code container}. */
	public static ConnectionDescriptor of(ComponentInstance container, ConnectionInstance connection) {
		var declarationKeys = new ArrayList<String>();
		var contextKeys = new ArrayList<String>();
		var reverseFlags = new ArrayList<Boolean>();
		for (var reference : connection.getConnectionReferences()) {
			declarationKeys.add(InstanceKeys.declarative(reference.getConnection()));
			contextKeys.add(InstanceKeys.instance(reference.getContext()));
			reverseFlags.add(reference.isReverse());
		}
		var key = new Key(InstanceKeys.instance(container), InstanceKeys.instance(connection.getSource()),
				InstanceKeys.instance(connection.getDestination()), declarationKeys, contextKeys, reverseFlags);

		var modes = new ArrayList<String>();
		for (var som : connection.getInSystemOperationModes()) {
			modes.add(som.getName());
		}
		var properties = new ArrayList<String>();
		connection.getOwnedPropertyAssociations()
				.forEach(association -> properties.add(InstanceKeys.structural(association)));

		return new ConnectionDescriptor(key, connection.getName(), String.valueOf(connection.getKind()),
				connection.isComplete(), connection.isBidirectional(), InstanceKeys.sorted(modes),
				InstanceKeys.sorted(properties));
	}
}
