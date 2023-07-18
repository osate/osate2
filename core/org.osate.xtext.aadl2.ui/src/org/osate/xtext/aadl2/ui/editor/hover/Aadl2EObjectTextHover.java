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
package org.osate.xtext.aadl2.ui.editor.hover;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.TextUtilities;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.hover.DispatchingEObjectTextHover;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;
import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.AnnexSubclause;
import org.osate.annexsupport.AnnexUtil;

import com.google.inject.Inject;

public class Aadl2EObjectTextHover extends DispatchingEObjectTextHover {

	@Inject
	private EObjectAtOffsetHelper eObjectAtOffsetHelper;

	@Inject
	private ILocationInFileProvider locationInFileProvider;

	/**
	 * Call this method only from within an IUnitOfWork
	 */
	@Override
	protected Pair<EObject, IRegion> getXtextElementAt(XtextResource resource, final int offset) {
		// check for cross reference
		EObject crossLinkedEObject = eObjectAtOffsetHelper.resolveCrossReferencedElementAt(resource, offset);
		if (crossLinkedEObject != null) {
			if (!crossLinkedEObject.eIsProxy()) {
				IParseResult parseResult = resource.getParseResult();
				if (parseResult != null) {
					ILeafNode leafNode = NodeModelUtils.findLeafNodeAtOffset(parseResult.getRootNode(), offset);
					if (leafNode != null && leafNode.isHidden() && leafNode.getOffset() == offset) {
						leafNode = NodeModelUtils.findLeafNodeAtOffset(parseResult.getRootNode(), offset - 1);
					}
					if (AnnexUtil.isAnnexLeaf(leafNode)) {
						leafNode = getLeafInParsedAnnex(leafNode, offset);
					}
					if (leafNode != null) {
						ITextRegion leafRegion = leafNode.getTextRegion();
						return Tuples.create(crossLinkedEObject,
								(IRegion) new Region(leafRegion.getOffset(), leafRegion.getLength()));
					}
				}
			}
		} else {
			EObject o = eObjectAtOffsetHelper.resolveElementAt(resource, offset);
			if (o != null) {
				ITextRegion region = locationInFileProvider.getSignificantTextRegion(o);
				final IRegion region2 = new Region(region.getOffset(), region.getLength());
				if (TextUtilities.overlaps(region2, new Region(offset, 0))) {
					return Tuples.create(o, region2);
				}
			}
		}
		return null;
	}

	/**
	 * find the leaf node inside the annex using the Xtext annex produced parsetree
	 * @param leaf INode Original leaf
	 * @param offset int
	 * @return INode in parsed annex
	 */
	protected ILeafNode getLeafInParsedAnnex(ILeafNode leaf, int offset) {
		if (leaf == null) {
			return null;
		}
		EObject semobj = NodeModelUtils.findActualSemanticObjectFor(leaf);
		if (semobj instanceof AnnexSubclause || semobj instanceof AnnexLibrary) {
			EObject parsedAnnex = AnnexUtil.getParsedAnnex(semobj);
			if (parsedAnnex != null) {
				ICompositeNode annexRoot = NodeModelUtils.findActualNodeFor(parsedAnnex);
				if (annexRoot != null) {
					leaf = NodeModelUtils.findLeafNodeAtOffset(annexRoot, offset);
					if (leaf != null && leaf.isHidden() && leaf.getOffset() == offset) {
						leaf = NodeModelUtils.findLeafNodeAtOffset(annexRoot, offset - 1);
					}
				}
			}
		}
		return leaf;
	}

}
