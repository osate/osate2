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
package org.osate.xtext.aadl2.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.Region;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.hyperlinking.HyperlinkHelper;
import org.eclipse.xtext.ui.editor.hyperlinking.IHyperlinkAcceptor;
import org.eclipse.xtext.util.TextRegion;
import org.osate.aadl2.NamedElement;
import org.osate.annexsupport.AnnexRegistry;
import org.osate.annexsupport.AnnexTextPositionResolver;
import org.osate.annexsupport.AnnexTextPositionResolverRegistry;
import org.osate.annexsupport.AnnexUtil;
import org.osate.annexsupport.TextPositionInfo;

import com.google.inject.Inject;

public class Aadl2HyperlinkHelper extends HyperlinkHelper {

	AnnexTextPositionResolverRegistry textpositionresolverregistry;

	protected Aadl2HyperlinkHelper() {
		initTextPositionResolverRegistry();
	}

	protected void initTextPositionResolverRegistry() {
		if (textpositionresolverregistry == null) {
			textpositionresolverregistry = (AnnexTextPositionResolverRegistry) AnnexRegistry
					.getRegistry(AnnexRegistry.ANNEX_TEXTPOSITIONRESOLVER_EXT_ID);
		}
	}

	@Inject
	private EObjectAtOffsetHelper eObjectAtOffsetHelper;

	@Override
	public void createHyperlinksByOffset(XtextResource resource, int offset, IHyperlinkAcceptor acceptor) {
		INode annexLeaf = findAnnexTextLeafNode(resource, offset);
		if (annexLeaf != null) {
			// handle extensionpoint based text position
			EObject obj = NodeModelUtils.findActualSemanticObjectFor(annexLeaf);
			if (obj instanceof NamedElement) {
				EObject actualAnnexElement = AnnexUtil.getParsedAnnex(obj);
				if (actualAnnexElement != null) {
					String annexName = ((NamedElement) obj).getName();
					if (textpositionresolverregistry == null) {
						initTextPositionResolverRegistry();
					}
					if (textpositionresolverregistry != null) {
						AnnexTextPositionResolver atpr = textpositionresolverregistry
								.getTextPositionResolver(annexName);
						if (atpr != null) {
							TextPositionInfo tpo = atpr.resolveCrossReferencedElementAt(actualAnnexElement, offset);
							if (tpo.getModelObject() != null && !tpo.getModelObject().eIsProxy()) {
								Region region = new Region(tpo.getOffset(), tpo.getLength());
								createHyperlinksTo(resource, region, tpo.getModelObject(), acceptor);
							}
						}
					}
				}
			}
		}
		// xtext based position is getting resolved by Aadl2EObjectAtOffsetHelper
		INode crossRefNode = eObjectAtOffsetHelper.getCrossReferenceNode(resource, new TextRegion(offset, 0));
		if (crossRefNode == null) {
			return;
		}
		EObject crossLinkedEObject = eObjectAtOffsetHelper.getCrossReferencedElement(crossRefNode);
		if (crossLinkedEObject != null && !crossLinkedEObject.eIsProxy()) {
			Region region = new Region(crossRefNode.getOffset(), crossRefNode.getLength());
			createHyperlinksTo(resource, region, crossLinkedEObject, acceptor);
		}
	}

	/**
	 * return the ILeafNode for the ANNEXTEXT if the offset points into an annex
	 * @param resource
	 * @param offset
	 * @return
	 */
	protected ILeafNode findAnnexTextLeafNode(XtextResource resource, int offset) {
		IParseResult parseResult = resource.getParseResult();
		if (parseResult != null && parseResult.getRootNode() != null) {
			ILeafNode leaf = NodeModelUtils.findLeafNodeAtOffset(parseResult.getRootNode(), offset);
			if (isAnnexLeaf(leaf)) {
				return leaf;
			}
		}
		return null;
	}

	protected boolean isAnnexLeaf(ILeafNode leaf) {
		if (leaf == null) {
			return false;
		}
		EObject ge = leaf.getGrammarElement();
		if (ge instanceof RuleCall) {
			AbstractRule rule = ((RuleCall) ge).getRule();
			if (rule.getName().equalsIgnoreCase("ANNEXTEXT")) {
				return true;
			}
		}
		return false;
	}

}
