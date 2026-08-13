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

import org.osate.aadl2.ConnectedElement;
import org.osate.aadl2.ConnectionEnd;
import org.osate.aadl2.Context;
import org.osate.aadl2.Element;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.aadl2.instance.FeatureInstance;

/**
 * Resolves one side of a declarative connection to an instance endpoint and the
 * feature chain it reaches through.
 *
 * <p>
 * A connection side is a {@link ConnectedElement} chain: {@code sub.fg.port} has the
 * subcomponent as its context, the feature group as its first connection end, and
 * the port as the next link. Reaching into a feature group of the enclosing
 * component instead puts the feature group itself in the context position. Both
 * shapes are resolved here, in one place, so that a leg resolver never has to
 * rediscover how a side is encoded.
 * </p>
 *
 * <p>
 * Source-first traversal spreads this over {@code appendSegment()}, where the
 * outcome is signalled by {@code null} and the feature chain accumulates in two
 * stacks shared by every path under enumeration. Here the outcome is an explicit
 * {@link Resolution} and the chain belongs to the returned value.
 * </p>
 */
public final class EndpointResolver {

	private EndpointResolver() {
	}

	/**
	 * One resolved connection side.
	 *
	 * @param endpoint the instance object the side denotes
	 * @param path the features traversed to reach it, outermost first; empty when the
	 *            side is a component or an unnested feature
	 */
	public record ResolvedEnd(ConnectionInstanceEnd endpoint, FeaturePath path) {
		public ResolvedEnd {
			if (endpoint == null || path == null) {
				throw new IllegalArgumentException("A resolved end needs an endpoint and a path");
			}
		}
	}

	/**
	 * Resolve {@code side} in {@code container}.
	 *
	 * @param container the component instance the declaration belongs to
	 * @param side the source or destination chain of the declaration
	 * @param diagnosticTarget where to report a failure
	 */
	public static Resolution<ResolvedEnd> resolve(ComponentInstance container, ConnectedElement side,
			Element diagnosticTarget) {
		if (side == null) {
			return Resolution.notApplicable("the declaration has no connected element on this side");
		}
		ConnectionEnd end = side.getConnectionEnd();
		Context context = side.getContext();

		// A side that is a component: an access connection ending at a shared component.
		if (end instanceof Subcomponent subcomponent) {
			ComponentInstance instance = container.findSubcomponentInstance(subcomponent);
			return instance == null
					? Resolution.failed(diagnosticTarget,
							"No component instance for subcomponent " + subcomponent.getName())
					: Resolution.resolved(new ResolvedEnd(instance, FeaturePath.EMPTY));
		}
		if (!(end instanceof Feature)) {
			return Resolution.notApplicable(
					"connection end " + end.getClass().getSimpleName() + " is neither a feature nor a subcomponent");
		}

		ComponentInstance owner = container;
		FeaturePath path = FeaturePath.EMPTY;
		FeatureInstance current = null;

		if (context instanceof Subcomponent subcomponent) {
			owner = container.findSubcomponentInstance(subcomponent);
			if (owner == null) {
				return Resolution.failed(diagnosticTarget,
						"No component instance for subcomponent " + subcomponent.getName());
			}
		} else if (context instanceof FeatureGroup featureGroup) {
			// Reaching into a feature group of the enclosing component.
			FeatureInstance group = owner.findFeatureInstance(featureGroup);
			if (group == null) {
				return Resolution.failed(diagnosticTarget,
						"No feature instance for feature group " + featureGroup.getName() + " of "
								+ owner.getInstanceObjectPath());
			}
			path = path.append(FeaturePathElement.of(group));
			current = group;
		} else if (context != null) {
			return Resolution.notApplicable("context " + context.getClass().getSimpleName() + " is not traversed here");
		}

		// The first feature, then every deeper link of the chain.
		for (ConnectedElement link = side; link != null; link = link.getNext()) {
			if (!(link.getConnectionEnd() instanceof Feature feature)) {
				return Resolution.notApplicable("connection end " + link.getConnectionEnd().getClass().getSimpleName()
						+ " is neither a feature nor a subcomponent");
			}
			FeatureInstance resolved = current == null ? owner.findFeatureInstance(feature) : child(current, feature);
			if (resolved == null) {
				return Resolution.failed(diagnosticTarget, "Feature " + feature.getName() + " not found in "
						+ (current == null ? owner.getInstanceObjectPath() : current.getInstanceObjectPath()));
			}
			path = path.append(FeaturePathElement.of(resolved));
			current = resolved;
		}
		return Resolution.resolved(new ResolvedEnd(current, path));
	}

	/**
	 * The child feature instance of {@code parent} that {@code feature} denotes.
	 * Refinements are followed, and the name is used as the fallback, which is what
	 * source-first traversal does when it descends a feature group.
	 */
	private static FeatureInstance child(FeatureInstance parent, Feature feature) {
		for (FeatureInstance candidate : parent.getFeatureInstances()) {
			if (candidate.getFeature() == feature) {
				return candidate;
			}
		}
		for (FeatureInstance candidate : parent.getFeatureInstances()) {
			if (feature.getAllFeatureRefinements().contains(candidate.getFeature())) {
				return candidate;
			}
		}
		for (FeatureInstance candidate : parent.getFeatureInstances()) {
			if (candidate.getName().equalsIgnoreCase(feature.getName())) {
				return candidate;
			}
		}
		return null;
	}
}
