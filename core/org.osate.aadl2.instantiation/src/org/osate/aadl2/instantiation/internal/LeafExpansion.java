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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.Connection;
import org.osate.aadl2.Element;
import org.osate.aadl2.contrib.modeling.ClassifierMatchingRule;
import org.osate.aadl2.contrib.modeling.ModelingProperties;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.aadl2.instance.FeatureCategory;
import org.osate.aadl2.instance.FeatureInstance;

/**
 * Narrows the endpoints of a path down to the leaf features that become connection
 * instances.
 *
 * <p>
 * A path may end at a feature group, because a leg stops where declarations stop and
 * a declaration can connect a whole group. One connection instance is created per
 * pair of connected leaves, so the group has to be paired member by member first.
 * </p>
 *
 * <p>
 * The rules mirror {@code CreateConnectionsSwitch.expandFeatureGroupConnection()},
 * including its direction filtering, its name-then-index matching for inverse feature
 * groups, and its positional pairing when neither side is a leaf. They are AADL
 * feature group semantics rather than an artifact of source-first traversal, so
 * across-first has to reproduce them.
 * </p>
 */
public final class LeafExpansion {

	/**
	 * One pair of leaves that becomes a connection instance.
	 *
	 * @param source the ultimate source leaf
	 * @param destination the ultimate destination leaf
	 */
	public record Endpoints(ConnectionInstanceEnd source, ConnectionInstanceEnd destination) {

		public String key() {
			return PathKeys.instance(source) + " -> " + PathKeys.instance(destination);
		}
	}

	private LeafExpansion() {
	}

	/**
	 * The leaf pairs {@code path} expands to. A path whose endpoints are already leaves
	 * expands to itself when its directions allow, and to nothing when they do not.
	 */
	public static List<Endpoints> expand(SemanticConnectionPath path) {
		List<Endpoints> expanded = new ArrayList<>();
		expand(path, path.source(), path.destination(), expanded);
		return List.copyOf(expanded);
	}

	private static void expand(SemanticConnectionPath path, ConnectionInstanceEnd source,
			ConnectionInstanceEnd destination, List<Endpoints> expanded) {
		if (!(source instanceof FeatureInstance sourceFeature)
				|| !(destination instanceof FeatureInstance destinationFeature)) {
			// An access connection ending at a component has nothing to expand.
			expanded.add(new Endpoints(source, destination));
			return;
		}

		if (isLeaf(sourceFeature) && isLeaf(destinationFeature)) {
			if (directionsAllow(path, sourceFeature, destinationFeature)) {
				expanded.add(new Endpoints(sourceFeature, destinationFeature));
			}
		} else if (isLeaf(sourceFeature)) {
			expandAgainstLeafSource(path, sourceFeature, destinationFeature, expanded);
		} else if (isLeaf(destinationFeature)) {
			expandAgainstLeafDestination(path, sourceFeature, destinationFeature, expanded);
		} else {
			expandGroupToGroup(path, sourceFeature, destinationFeature, expanded);
		}
	}

	/**
	 * Whether two leaves may be connected.
	 *
	 * <p>
	 * A path leaves its ultimate source travelling away from it: outgoing for a complete
	 * path and for one that only travels up, incoming for one that only travels down.
	 * That much always holds, because it is what makes the feature a source at all.
	 * Source-first enforces it as its start rule, by beginning enumeration only at a
	 * feature {@code AadlUtil.hasOutgoingFeatures()} accepts and only at a boundary
	 * feature that is incoming.
	 * </p>
	 *
	 * <p>
	 * The arriving direction is only decided here inside a feature group. Pairing the
	 * members of two connected feature groups is a choice between candidates, and
	 * direction is what makes it, so a member that faces the wrong way is not the member
	 * this path connects. Two features named directly by declarations are not a choice:
	 * the connection exists whatever they face, and
	 * {@code ValidateConnectionsSwitch.checkSegmentDirections()} reports it since issue
	 * #3042. Source-first draws the same line, reaching its member-by-member direction
	 * filtering only from {@code balanceFeatureGroupEnds()} and materializing two
	 * directly named leaves without consulting direction at all.
	 * </p>
	 */
	private static boolean directionsAllow(SemanticConnectionPath path, FeatureInstance source,
			FeatureInstance destination) {
		boolean downOnly = !path.complete() && !isUpOnly(path, source, destination);
		if (!(downOnly ? source.getFlowDirection().incoming() : source.getFlowDirection().outgoing())) {
			return false;
		}
		if (!(source.getOwner() instanceof FeatureInstance || destination.getOwner() instanceof FeatureInstance)) {
			return true;
		}
		return path.complete() || downOnly ? destination.getFlowDirection().incoming()
				: destination.getFlowDirection().outgoing();
	}

	/** Whether an incomplete path only travels up, that is, the source sits inside the destination. */
	private static boolean isUpOnly(SemanticConnectionPath path, FeatureInstance source, FeatureInstance destination) {
		if (path.complete()) {
			return false;
		}
		ComponentInstance destinationComponent = destination.getContainingComponentInstance();
		for (Element component = source.getContainingComponentInstance(); component != null; component = component
				.getOwner()) {
			if (component == destinationComponent) {
				return true;
			}
		}
		return false;
	}

	private static void expandAgainstLeafSource(SemanticConnectionPath path, FeatureInstance source,
			FeatureInstance destinationGroup, List<Endpoints> expanded) {
		FeatureInstance destination = findDestinationFeature(path, destinationGroup);
		if (destination != null && (path.complete() ? destination.getFlowDirection().incoming()
				: destination.getFlowDirection().outgoing())) {
			expand(path, source, destination, expanded);
		} else if (source.getCategory() == FeatureCategory.FEATURE_GROUP) {
			// A feature group with no type, or an empty one, pairs with every member.
			boolean upOnly = isUpOnly(path, source, destinationGroup);
			for (FeatureInstance member : destinationGroup.getFeatureInstances()) {
				if (upOnly ? member.getFlowDirection().outgoing() : member.getFlowDirection().incoming()) {
					expand(path, source, member, expanded);
				}
			}
		} else {
			expanded.add(new Endpoints(source, destinationGroup));
		}
	}

	private static void expandAgainstLeafDestination(SemanticConnectionPath path, FeatureInstance sourceGroup,
			FeatureInstance destination, List<Endpoints> expanded) {
		FeatureInstance source = findSourceFeature(path, sourceGroup);
		if (source != null && (path.complete() ? source.getFlowDirection().outgoing()
				: source.getFlowDirection().incoming())) {
			expand(path, source, destination, expanded);
		} else if (destination.getCategory() == FeatureCategory.FEATURE_GROUP) {
			boolean downOnly = !path.complete() && !isUpOnly(path, sourceGroup, destination);
			for (FeatureInstance member : sourceGroup.getFeatureInstances()) {
				if (downOnly ? member.getFlowDirection().incoming() : member.getFlowDirection().outgoing()) {
					expand(path, member, destination, expanded);
				}
			}
		} else {
			expanded.add(new Endpoints(sourceGroup, destination));
		}
	}

	/**
	 * Two feature groups pair member by member. Subset matching pairs by name and skips
	 * members the other side does not have; otherwise the two groups have the same
	 * internal structure and pair positionally.
	 */
	private static void expandGroupToGroup(SemanticConnectionPath path, FeatureInstance sourceGroup,
			FeatureInstance destinationGroup, List<Endpoints> expanded) {
		if (isSubsetMatch(path)) {
			for (FeatureInstance destination : destinationGroup.getFeatureInstances()) {
				if (path.complete() ? destination.getFlowDirection().incoming()
						: destination.getFlowDirection().outgoing()) {
					FeatureInstance source = findLeafNamed(sourceGroup, destination.getName());
					if (source != null) {
						expand(path, source, destination, expanded);
					}
				}
			}
			return;
		}
		Iterator<FeatureInstance> sources = sourceGroup.getFeatureInstances().iterator();
		Iterator<FeatureInstance> destinations = destinationGroup.getFeatureInstances().iterator();
		while (sources.hasNext() && destinations.hasNext()) {
			expand(path, sources.next(), destinations.next(), expanded);
		}
		if (sources.hasNext() || destinations.hasNext()) {
			throw new IllegalStateException("Connected feature groups do not have the same number of features: "
					+ PathKeys.instance(sourceGroup) + " and " + PathKeys.instance(destinationGroup));
		}
	}

	private static boolean isSubsetMatch(SemanticConnectionPath path) {
		for (ResolvedSegment segment : path.segments()) {
			Connection declaration = segment.declaration();
			if (ModelingProperties.getClassifierMatchingRule(declaration)
					.orElse(null) == ClassifierMatchingRule.SUBSET) {
				return true;
			}
		}
		return false;
	}

	/**
	 * The member of {@code group} that the path reaches, found by looking for the point
	 * where the path stepped from a feature group into one of its members and mapping
	 * that member across by name, or by index when an inverse feature group type renames
	 * its features.
	 */
	private static FeatureInstance findDestinationFeature(SemanticConnectionPath path, FeatureInstance group) {
		ConnectionInstanceEnd target = null;
		for (ResolvedSegment segment : path.segments()) {
			if (target != null && target != segment.source()) {
				if (segment.source() == target.eContainer()) {
					return mapAcross(group, (FeatureInstance) segment.source(), target);
				}
			}
			target = segment.destination();
		}
		return null;
	}

	/** The mirror of {@link #findDestinationFeature}, walking the path backwards. */
	private static FeatureInstance findSourceFeature(SemanticConnectionPath path, FeatureInstance group) {
		ConnectionInstanceEnd target = null;
		List<ResolvedSegment> segments = path.segments();
		for (int i = segments.size() - 1; i >= 0; i--) {
			ResolvedSegment segment = segments.get(i);
			if (target != null && target != segment.destination()) {
				if (segment.destination() == target.eContainer()) {
					return mapAcross(group, (FeatureInstance) segment.destination(), target);
				}
			}
			target = segment.source();
		}
		return null;
	}

	private static FeatureInstance mapAcross(FeatureInstance group, FeatureInstance otherGroup,
			ConnectionInstanceEnd member) {
		FeatureInstance matched = findLeafNamed(group, member.getName());
		if (matched != null) {
			return matched;
		}
		int index = otherGroup.getFeatureInstances().indexOf(member);
		return index >= 0 && index < group.getFeatureInstances().size() ? group.getFeatureInstances().get(index) : null;
	}

	/** The first leaf under {@code group} with this name. */
	private static FeatureInstance findLeafNamed(FeatureInstance group, String name) {
		for (TreeIterator<EObject> contents = group.eAllContents(); contents.hasNext();) {
			EObject next = contents.next();
			if (next instanceof FeatureInstance feature && isLeaf(feature) && feature.getName().equalsIgnoreCase(name)) {
				return feature;
			}
		}
		return null;
	}

	private static boolean isLeaf(FeatureInstance feature) {
		return feature.getFeatureInstances().isEmpty();
	}
}
