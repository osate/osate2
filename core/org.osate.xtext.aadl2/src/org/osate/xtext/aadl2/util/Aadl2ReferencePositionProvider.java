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
package org.osate.xtext.aadl2.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.SimpleAttributeResolver;
import org.eclipse.xtext.util.TextRegion;
import org.osate.aadl2.NamedElement;
import org.osate.annexsupport.AnnexRegistry;
import org.osate.annexsupport.AnnexTextPositionResolverRegistry;
import org.osate.annexsupport.AnnexUtil;
import org.osate.annexsupport.TextPositionInfo;

import com.google.inject.Inject;

/**
 * Shares target-aware annex token locations between Eclipse and language-server
 * services.
 */
public class Aadl2ReferencePositionProvider {
	@Inject
	private ILocationInFileProvider locations;
	@Inject
	private EObjectAtOffsetHelper offsets;

	public ITextRegion getReferenceRegion(EObject source, EReference reference, int index, EObject target) {
		if (AnnexUtil.getAnnexRoot(source) instanceof NamedElement annex && annex.getName() != null) {
			var registry = (AnnexTextPositionResolverRegistry) AnnexRegistry
					.getRegistry(AnnexRegistry.ANNEX_TEXTPOSITIONRESOLVER_EXT_ID);
			var resolver = registry == null ? null : registry.getTextPositionResolver(annex.getName());
			if (resolver != null) {
				var position = resolver.getReferencePosition(source, reference, index, target);
				if (position != null && position.getLength() > 0) {
					return new TextRegion(position.getOffset(), position.getLength());
				}
			}
		}
		return locations.getSignificantTextRegion(source, reference, index);
	}

	/**
	 * Locates a name within a qualified reference, preserving its namespace and
	 * other path segments.
	 */
	public ITextRegion getNameRegion(ITextRegion region, String text, String name) {
		if (name == null || name.isEmpty()) {
			return null;
		}
		for (int start = text.length() - name.length(); start >= 0; start--) {
			int end = start + name.length();
			if (text.regionMatches(true, start, name, 0, name.length())
					&& (start == 0 || !isIdentifierCharacter(text.charAt(start - 1)))
					&& (end == text.length() || !isIdentifierCharacter(text.charAt(end)))) {
				return new TextRegion(region.getOffset() + start, name.length());
			}
		}
		return null;
	}

	private static boolean isIdentifierCharacter(char character) {
		return Character.isLetterOrDigit(character) || character == '_';
	}

	/**
	 * Returns the selected declaration and the identifier inside an embedded annex,
	 * never its outer text token.
	 */
	public TextPositionInfo getAnnexIdentifierAt(XtextResource resource, int offset) {
		if (resource == null || resource.getParseResult() == null || offset < 0) {
			return null;
		}
		var outerLeaf = AnnexUtil.findAnnexLeafNode(resource, offset);
		if (outerLeaf == null) {
			return null;
		}
		var annex = AnnexUtil.getParsedAnnex(NodeModelUtils.findActualSemanticObjectFor(outerLeaf));
		var node = annex == null ? null : NodeModelUtils.getNode(annex);
		var leaf = node == null ? null : NodeModelUtils.findLeafNodeAtOffset(node, offset);
		if (leaf == null || leaf.isHidden() || offset < leaf.getOffset() || offset >= leaf.getEndOffset()) {
			return null;
		}
		var target = offsets.resolveElementAt(resource, offset);
		var name = target == null || target.eIsProxy() ? null : SimpleAttributeResolver.NAME_RESOLVER.apply(target);
		return name != null && name.equalsIgnoreCase(leaf.getText())
				? new TextPositionInfo(target, leaf.getOffset(), leaf.getLength())
				: null;
	}
}
