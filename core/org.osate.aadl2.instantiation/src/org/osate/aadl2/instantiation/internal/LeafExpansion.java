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
import java.util.Collections;
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
		if (!(source instanceof FeatureInstance sourceFeature)) {
			expanded.add(new Endpoints(source, reached(path, destination, true)));
			return;
		}
		if (!(destination instanceof FeatureInstance destinationFeature)) {
			expanded.add(new Endpoints(reached(path, source, false), destination));
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
	 * The feature at the source end of {@code path} that its destination pairs with.
	 *
	 * <p>
	 * A path that ends at a dead end is reported rather than materialized, and the report
	 * names both of its ends, so the member the source end covers has to be found without
	 * expanding the path. The destination is mapped back through every segment: a whole
	 * feature group is connected to a whole feature group, so a feature below one end
	 * corresponds to the feature reached by following the same member names, or positions
	 * where an inverse feature group type renames them, below the other.
	 * </p>
	 *
	 * <p>
	 * The unmapped source end is returned when no correspondence can be established, which
	 * keeps a diagnostic approximate rather than absent.
	 * </p>
	 */
	public static ConnectionInstanceEnd correspondingSource(SemanticConnectionPath path) {
		ConnectionInstanceEnd current = path.destination();
		for (int i = path.segments().size() - 1; i >= 0; i--) {
			ResolvedSegment segment = path.segments().get(i);
			current = mapAcrossSegment(segment.destination(), segment.source(), current);
			if (current == null) {
				return path.source();
			}
		}
		return current;
	}

	/**
	 * The endpoint a leg standing at {@code position} continues to when it leaves through a
	 * declaration that connects {@code from} to {@code to}.
	 *
	 * <p>
	 * A declaration may connect a whole feature group while the leg stands at a member of
	 * it. The connection then covers that member only, so it continues at the member of the
	 * far end that pairs with it rather than at the whole far end. Leaving the far end whole
	 * pairs a group against a group one level too high, which is only visible where the two
	 * have different numbers of members.
	 * </p>
	 *
	 * <p>
	 * {@code to} is returned unchanged when the leg stands at {@code from} itself or at a
	 * group containing it, which is the declaration reaching <em>into</em> a group, and when
	 * no member of the far end corresponds. Source-first narrows the same end afterwards,
	 * from the member chain it keeps in its {@code upFeature} and {@code downFeature} stacks.
	 * </p>
	 */
	static ConnectionInstanceEnd continuation(ConnectionInstanceEnd from, ConnectionInstanceEnd to,
			ConnectionInstanceEnd position) {
		ConnectionInstanceEnd mapped = mapAcrossSegment(from, to, position);
		return mapped == null ? to : mapped;
	}

	/**
	 * Map {@code end}, which sits at or below {@code from}, to the feature at or below
	 * {@code to} that it corresponds to, or {@code null} when it has none.
	 */
	private static ConnectionInstanceEnd mapAcrossSegment(ConnectionInstanceEnd from, ConnectionInstanceEnd to,
			ConnectionInstanceEnd end) {
		ConnectionInstanceEnd mapped = to;
		for (FeatureInstance member : membersBelow(from, end)) {
			if (!(mapped instanceof FeatureInstance group)) {
				return null;
			}
			mapped = matchingMember(group, member);
			if (mapped == null) {
				return null;
			}
		}
		return mapped;
	}

	/**
	 * The features from just below {@code outer} down to {@code inner}, or an empty list
	 * when {@code inner} is {@code outer} itself or sits above it.
	 */
	static List<FeatureInstance> membersBelow(ConnectionInstanceEnd outer, ConnectionInstanceEnd inner) {
		List<FeatureInstance> members = new ArrayList<>();
		for (Object current = inner; current instanceof FeatureInstance feature; current = feature.getOwner()) {
			if (feature == outer) {
				Collections.reverse(members);
				return members;
			}
			members.add(feature);
		}
		return List.of();
	}

	/**
	 * The member of {@code group} that {@code member} of the group connected to it pairs
	 * with: the one with the same name, or the one at the same position when an inverse
	 * feature group type renames its features.
	 */
	static FeatureInstance matchingMember(FeatureInstance group, FeatureInstance member) {
		for (FeatureInstance candidate : group.getFeatureInstances()) {
			if (candidate.getName().equalsIgnoreCase(member.getName())) {
				return candidate;
			}
		}
		int index = member.getOwner() instanceof FeatureInstance parent ? parent.getFeatureInstances().indexOf(member)
				: -1;
		return index >= 0 && index < group.getFeatureInstances().size() ? group.getFeatureInstances().get(index) : null;
	}

	/**
	 * The feature a path reaches at one end when the other end is a component.
	 *
	 * <p>
	 * An access connection ends at the component itself, so there is no opposite feature
	 * to pair a group against member by member. The group still has to be narrowed,
	 * because the connection reaches one member of it: the one the path stepped through
	 * on its way, mapped across as it would be for any other pair. Source-first narrows
	 * the same end with its feature stacks and only then notices that the other end is a
	 * component ({@code balanceFeatureGroupEnds()}), which is why leaving the group whole
	 * here produced a feature group connection where the baseline has an access
	 * connection.
	 * </p>
	 *
	 * <p>
	 * A group the path never stepped into is returned as it stands, matching the
	 * source-first case where neither feature stack has an entry to narrow with.
	 * </p>
	 */
	private static ConnectionInstanceEnd reached(SemanticConnectionPath path, ConnectionInstanceEnd end,
			boolean destinationSide) {
		if (!(end instanceof FeatureInstance group) || isLeaf(group)) {
			return end;
		}
		FeatureInstance member = destinationSide ? findDestinationFeature(path, group) : findSourceFeature(path, group);
		return member == null ? end : member;
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
