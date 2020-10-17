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
package org.osate.ge.errormodel.combined;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import org.osate.aadl2.Feature;
import org.osate.aadl2.NamedElement;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.errormodel.model.KeywordPropagationPoint;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.FeatureorPPReference;
import org.osate.xtext.aadl2.errormodel.errorModel.PropagationPoint;

/**
 * Class for storing propagations in a tree. The key for each node is the name of the feature or propagation point or the "kind"
 * of the propagation.
 *
 */
public class PropagationNode implements ReadonlyPropagationNode {
	final Map<String, PropagationNode> children = new HashMap<>();
	final Map<PropagationKey, ErrorPropagation> propagations = new HashMap<>();

	/**
	 * Adds a propagation to the node. Creates child nodes as necessary. Replaces node with the same propagation point, isNot flag,
	 * and direction.
	 * @param p the propagation to add.
	 */
	public void put(final ErrorPropagation p) {
		// Ignore invalid propagation
		if (p.getDirection() == null) {
			return;
		}

		// Ignore propagations unless they have a kind or a complete feature or propagation point
		final PropagationNode n;
		if (p.getKind() != null) {
			n = getOrCreateChild(p.getKind());
		} else if (p.getFeatureorPPRef() != null) {
			n = getOrCreateChild(p.getFeatureorPPRef()).orElse(null);
		} else {
			n = null;
		}

		if (n != null) {
			n.propagations.put(new PropagationKey(p.getDirection(), p.isNot()), p);
		}
	}

	private Optional<PropagationNode> getOrCreateChild(final FeatureorPPReference current) {
		final NamedElement element = current.getFeatureorPP();
		if (element == null || element.getName() == null) {
			// Invalid
			return Optional.empty();
		}

		final PropagationNode child = getOrCreateChild(element.getName());
		return current.getNext() == null ? Optional.of(child) : child.getOrCreateChild(current.getNext());
	}

	private PropagationNode getOrCreateChild(final String kindOrElementName) {
		return children.computeIfAbsent(kindOrElementName.toLowerCase(), k -> new PropagationNode());
	}

	@Override
	public Optional<ReadonlyPropagationNode> getChild(final String kindOrElementName) {
		if (kindOrElementName == null) {
			return Optional.empty();
		}

		return Optional.ofNullable(children.get(kindOrElementName.toLowerCase()));
	}

	@Override
	public Stream<ErrorPropagation> getPropagations() {
		return propagations.values().stream();
	}

	@Override
	public Stream<ErrorPropagation> getPropagationsForBusinessObjectContext(final BusinessObjectContext boc) {
		final Object bo = boc.getBusinessObject();
		if (bo instanceof Feature) {
			return getDescendantForFeaturePath(boc).map(ReadonlyPropagationNode::getPropagations)
					.orElse(Stream.empty());
		} else if (bo instanceof KeywordPropagationPoint) {
			final KeywordPropagationPoint kw = (KeywordPropagationPoint) bo;
			return getChild(kw.getType().getKind()).map(ReadonlyPropagationNode::getPropagations)
					.orElse(Stream.empty());
		} else if (bo instanceof PropagationPoint) {
			final PropagationPoint pp = (PropagationPoint) bo;
			return getChild(pp.getName()).map(ReadonlyPropagationNode::getPropagations).orElse(Stream.empty());
		} else {
			return Stream.empty();
		}
	}

	/**
	 * Finds the descendant containing propagations associated with a specified feature
	 * @param featureBoc the business object context of the feature for which to find the propagation node
	 * @return or empty if a propagation node for the feature was not found.
	 */
	private Optional<ReadonlyPropagationNode> getDescendantForFeaturePath(
			final BusinessObjectContext featureBoc) {
		final BusinessObjectContext parent = featureBoc.getParent();
		final Object parentBo = parent.getBusinessObject();
		final ReadonlyPropagationNode tmpNode = parentBo instanceof Feature
				? getDescendantForFeaturePath(parent).orElse(null)
				: this;
		return tmpNode == null ? Optional.empty()
				: tmpNode.getChild(featureBoc.getBusinessObject(Feature.class).get().getName());
	}
}