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
package org.osate.xtext.aadl2.ba.services;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.osate.aadl2.ComponentClassifier;
import org.osate.annexsupport.AnnexTextPositionResolver;
import org.osate.annexsupport.TextPositionInfo;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnex;
import org.osate.xtext.aadl2.ba.behaviorAnnex.ReferenceSegment;
import org.osate.xtext.aadl2.ba.behaviorAnnex.UnindexedReferenceSegment;
import org.osate.xtext.aadl2.ba.translation.DeclarativeToStrictTranslator;

/**
 * Resolves the symbolic BA reference segments that intentionally remain attributes in the Xtext model. Ordinary Xtext
 * cross-references fall through to the generic nested-annex offset support.
 */
public final class BehaviorAnnexTextPositionResolver implements AnnexTextPositionResolver {
	private final DeclarativeToStrictTranslator translator = new DeclarativeToStrictTranslator();

	@Override
	public TextPositionInfo resolveElementAt(final EObject annexRoot, final int offset) {
		return resolveSymbolicReference(annexRoot, offset);
	}

	@Override
	public TextPositionInfo resolveCrossReferencedElementAt(final EObject annexRoot, final int offset) {
		return resolveSymbolicReference(annexRoot, offset);
	}

	private TextPositionInfo resolveSymbolicReference(final EObject annexRoot, final int offset) {
		if (!(annexRoot instanceof BehaviorAnnex annex)
				|| !(annex.getContainingClassifier() instanceof ComponentClassifier owner)) {
			return new TextPositionInfo(null, offset, 0);
		}
		var segment = findSegment(annex, offset);
		if (segment == null) {
			return new TextPositionInfo(null, offset, 0);
		}
		var nameNode = getNameNode(segment);
		if (nameNode == null || offset < nameNode.getOffset() || offset >= nameNode.getEndOffset()) {
			return new TextPositionInfo(null, offset, 0);
		}
		var target = translator.translate(annex, owner).getResolvedReference(segment);
		return new TextPositionInfo(target, nameNode.getOffset(), nameNode.getLength());
	}

	private static EObject findSegment(final BehaviorAnnex annex, final int offset) {
		var root = NodeModelUtils.getNode(annex);
		if (root == null) {
			return null;
		}
		INode node = NodeModelUtils.findLeafNodeAtOffset(root.getRootNode(), offset);
		while (node != null) {
			var semantic = NodeModelUtils.findActualSemanticObjectFor(node);
			if (semantic instanceof ReferenceSegment || semantic instanceof UnindexedReferenceSegment) {
				return semantic;
			}
			node = node.getParent();
		}
		return null;
	}

	private static INode getNameNode(final EObject segment) {
		var name = segment.eClass().getEStructuralFeature("name");
		var nodes = NodeModelUtils.findNodesForFeature(segment, name);
		return nodes.isEmpty() ? null : nodes.get(0);
	}
}
