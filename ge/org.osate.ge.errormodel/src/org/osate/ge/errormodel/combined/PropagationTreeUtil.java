/**
 * Copyright (c) 2004-2023 Carnegie Mellon University and others. (see Contributors file).
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

import java.util.Optional;
import java.util.stream.Stream;

import org.osate.aadl2.Feature;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.errormodel.model.KeywordPropagationPoint;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.PropagationPoint;

/**
 * Utility class for working with propagation trees
 */
public final class PropagationTreeUtil {
	/**
	 * Private constructor to prevent instantiation.
	 */
	private PropagationTreeUtil() {
	}

	/**
	 * Returns a stream of error propagations associated from the descendant node found using the specified target business object context.
	 * @param rootNode the root of the propagation tree which contains the propagations to retrieve
	 * @param propagationOwnerBoc the business object context of a feature, propagation point or keyword propagation point. The ancestor of this
	 * business object context should be a classifier or subcomponent for which the root node contains propagations.
	 * @return a stream containing propagations
	 */
	public static Stream<ErrorPropagation> getPropagationsForBusinessObjectContext(
			final ReadonlyPropagationNode rootNode,
			final BusinessObjectContext propagationOwnerBoc) {
		final Object bo = propagationOwnerBoc.getBusinessObject();
		if (bo instanceof Feature) {
			return getDescendantForFeaturePath(rootNode, propagationOwnerBoc).map(ReadonlyPropagationNode::getPropagations)
					.orElse(Stream.empty());
		} else if (bo instanceof KeywordPropagationPoint) {
			final KeywordPropagationPoint kw = (KeywordPropagationPoint) bo;
			return rootNode.getChild(kw.getType().getKind())
					.map(ReadonlyPropagationNode::getPropagations)
					.orElse(Stream.empty());
		} else if (bo instanceof PropagationPoint) {
			final PropagationPoint pp = (PropagationPoint) bo;
			return rootNode.getChild(pp.getName()).map(ReadonlyPropagationNode::getPropagations).orElse(Stream.empty());
		} else {
			return Stream.empty();
		}
	}

	/**
	 * Finds the descendant containing propagations associated with a specified feature
	 * @param rootNode the root of the propagation tree which contains the propagations to retrieve
	 * @param featureBoc the business object context of the feature for which to find the propagation node
	 * @return or empty if a propagation node for the feature was not found.
	 */
	private static Optional<ReadonlyPropagationNode> getDescendantForFeaturePath(final ReadonlyPropagationNode rootNode,
			final BusinessObjectContext featureBoc) {
		final BusinessObjectContext parent = featureBoc.getParent();
		final Object parentBo = parent.getBusinessObject();
		final ReadonlyPropagationNode tmpNode = parentBo instanceof Feature
				? getDescendantForFeaturePath(rootNode, parent).orElse(null)
				: rootNode;
		return tmpNode == null ? Optional.empty()
				: tmpNode.getChild(featureBoc.getBusinessObject(Feature.class).get().getName());
	}
}
