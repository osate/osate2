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
package org.osate.aadl2.instantiation.internal;

import static org.osate.aadl2.instance.ConnectionKind.ACCESS_CONNECTION;
import static org.osate.aadl2.instance.ConnectionKind.FEATURE_CONNECTION;
import static org.osate.aadl2.instance.ConnectionKind.FEATURE_GROUP_CONNECTION;
import static org.osate.aadl2.instance.ConnectionKind.PARAMETER_CONNECTION;
import static org.osate.aadl2.instance.ConnectionKind.PORT_CONNECTION;
import static org.osate.aadl2.instance.FeatureCategory.ABSTRACT_FEATURE;
import static org.osate.aadl2.instance.FeatureCategory.BUS_ACCESS;
import static org.osate.aadl2.instance.FeatureCategory.DATA_ACCESS;
import static org.osate.aadl2.instance.FeatureCategory.FEATURE_GROUP;
import static org.osate.aadl2.instance.FeatureCategory.PARAMETER;
import static org.osate.aadl2.instance.FeatureCategory.SUBPROGRAM_ACCESS;
import static org.osate.aadl2.instance.FeatureCategory.SUBPROGRAM_GROUP_ACCESS;

import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.aadl2.instance.ConnectionKind;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.aadl2.instance.FeatureCategory;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.InstanceFactory;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.util.Aadl2InstanceUtil;

/**
 * Turns a path and one pair of expanded endpoints into a connection instance.
 *
 * <p>
 * The result has to be indistinguishable from what source-first materializes: the
 * same name, kind, completeness, and the same ordered connection references with the
 * same contexts and reverse flags. Names are built from the container-relative
 * endpoint paths, as {@code addConnectionInstance()} does, and the reference chain is
 * built the way source-first built it from the path it had grown, with each
 * intermediate destination narrowed to the member matching the source it came from.
 * </p>
 *
 * <p>
 * The connection is not attached here, and modes are not filled in. The caller does
 * both, so that attachment and the mode and system operation mode pipeline stay in
 * one place.
 * </p>
 */
public final class PathMaterializer {

	private PathMaterializer() {
	}

	/**
	 * Create the connection instance for one expanded endpoint pair of {@code path}.
	 *
	 * @param systemInstance the system instance, used as the container when the path has
	 *            none
	 * @param path the enumerated path
	 * @param endpoints one pair of leaves the path expanded to
	 */
	public static ConnectionInstance materialize(SystemInstance systemInstance, SemanticConnectionPath path,
			LeafExpansion.Endpoints endpoints) {
		ComponentInstance container = container(systemInstance, path);
		ConnectionInstance connection = InstanceFactory.eINSTANCE.createConnectionInstance();
		connection.setName(name(container, systemInstance, path, endpoints));

		ConnectionInstanceEnd source = endpoints.source();
		for (int i = 0; i < path.segments().size(); i++) {
			ResolvedSegment segment = path.segments().get(i);
			ConnectionReference reference = connection.createConnectionReference();
			reference.setConnection(segment.declaration());
			reference.setContext(segment.context());
			reference.setSource(source);
			boolean last = i == path.segments().size() - 1;
			ConnectionInstanceEnd destination = last ? endpoints.destination()
					: narrow(source, segment.destination());
			reference.setDestination(destination);
			reference.setReverse(segment.reverse());
			source = destination;
		}
		connection.setSource(endpoints.source());
		connection.setDestination(endpoints.destination());
		connection.setComplete(path.complete());
		connection.setKind(kind(endpoints.source(), endpoints.destination()));
		return connection;
	}

	/** The component instance that contains the connection. */
	public static ComponentInstance container(SystemInstance systemInstance, SemanticConnectionPath path) {
		ComponentInstance container = path.container();
		return container == null ? systemInstance : container;
	}

	/**
	 * The connection name: the endpoint paths relative to the container, separated by an
	 * arrow. This is presentation data and must stay byte-for-byte compatible.
	 */
	private static String name(ComponentInstance container, SystemInstance systemInstance, SemanticConnectionPath path,
			LeafExpansion.Endpoints endpoints) {
		String containerPath = path.container() != null ? container.getInstanceObjectPath()
				: systemInstance.getName();
		int prefix = containerPath.length() + 1;
		return relative(endpoints.source().getInstanceObjectPath(), containerPath, prefix) + " -> "
				+ relative(endpoints.destination().getInstanceObjectPath(), containerPath, prefix);
	}

	private static String relative(String path, String containerPath, int prefix) {
		return path.substring(path.startsWith(containerPath) ? prefix : 0);
	}

	/**
	 * Narrow an intermediate destination to the member that matches the source it is
	 * reached from, so a reference chain through nested feature groups stays continuous.
	 */
	private static ConnectionInstanceEnd narrow(ConnectionInstanceEnd source, ConnectionInstanceEnd destination) {
		if (destination == null || source instanceof ComponentInstance || destination instanceof ComponentInstance) {
			return destination;
		}
		FeatureInstance destinationFeature = (FeatureInstance) destination;
		if (destinationFeature.getFeatureInstances().isEmpty()) {
			return destination;
		}
		FeatureInstance parent = destinationFeature;
		FeatureInstance sourceFeature = (FeatureInstance) source;
		if (sourceFeature.getOwner() instanceof FeatureInstance sourceParent
				&& sourceParent.getOwner() instanceof FeatureInstance) {
			ConnectionInstanceEnd resolved = narrow(sourceParent, destinationFeature);
			if (resolved instanceof FeatureInstance resolvedFeature) {
				parent = resolvedFeature;
			}
		}
		if (sourceFeature.getOwner() instanceof FeatureInstance) {
			for (FeatureInstance member : parent.getFeatureInstances()) {
				if (Aadl2InstanceUtil.isSame(sourceFeature, member)) {
					return member;
				}
			}
		}
		return destinationFeature;
	}

	/** The connection kind, from the categories of the two endpoints. */
	private static ConnectionKind kind(ConnectionInstanceEnd source, ConnectionInstanceEnd destination) {
		if (isComponent(source) && isAccess(destination) || isAccess(source) && isComponent(destination)
				|| isAccess(source) && isAccess(destination)) {
			return ACCESS_CONNECTION;
		}
		if (isParameter(source) || isParameter(destination)) {
			return PARAMETER_CONNECTION;
		}
		if (isFeatureGroup(source) || isFeatureGroup(destination)) {
			return FEATURE_GROUP_CONNECTION;
		}
		if (isAbstract(source) || isAbstract(destination)) {
			return FEATURE_CONNECTION;
		}
		return PORT_CONNECTION;
	}

	private static boolean isComponent(ConnectionInstanceEnd end) {
		return end instanceof ComponentInstance;
	}

	private static boolean isAbstract(ConnectionInstanceEnd end) {
		return category(end) == ABSTRACT_FEATURE;
	}

	private static boolean isFeatureGroup(ConnectionInstanceEnd end) {
		return category(end) == FEATURE_GROUP;
	}

	private static boolean isParameter(ConnectionInstanceEnd end) {
		return category(end) == PARAMETER;
	}

	private static boolean isAccess(ConnectionInstanceEnd end) {
		FeatureCategory category = category(end);
		return category == BUS_ACCESS || category == DATA_ACCESS || category == SUBPROGRAM_ACCESS
				|| category == SUBPROGRAM_GROUP_ACCESS;
	}

	private static FeatureCategory category(ConnectionInstanceEnd end) {
		return end instanceof FeatureInstance feature ? feature.getCategory() : null;
	}
}
