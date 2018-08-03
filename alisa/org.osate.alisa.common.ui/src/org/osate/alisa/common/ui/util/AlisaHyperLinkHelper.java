/**
 * Copyright 2015 Carnegie Mellon University. All Rights Reserved.
 *
 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING INSTITUTE
 * MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO
 * WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY,
 * EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON
 * UNIVERSITY DOES NOT MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM
 * PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * Released under the Eclipse Public License (http://www.eclipse.org/org/documents/epl-v10.php)
 *
 * See COPYRIGHT file for full details.
 */

package org.osate.alisa.common.ui.util;


@SuppressWarnings("restriction")
public class AlisaHyperLinkHelper {
//extends HyperLinkHelper {
//	@Override
//	public IHyperlink[] createHyperlinksByOffset(XtextResource resource, int offset, boolean createMultipleHyperlinks) {
//		if (!createMultipleHyperlinks) {
//			return super.createHyperlinksByOffset(resource, offset, createMultipleHyperlinks);
//		}
//		List<IHyperlink> links = Lists.newArrayList();
//		IHyperlinkAcceptor acceptor = new HyperlinkAcceptor(links);
//		INode crossRefNode = getEObjectAtOffsetHelper().getCrossReferenceNode(resource, new TextRegion(offset, 0));
//		if (crossRefNode == null) {
//			this.createHyperlinksByOffset(resource, offset, acceptor);
//		} else {
//			EObject containedElementAt = getEObjectAtOffsetHelper().resolveContainedElementAt(resource,
//					crossRefNode.getOffset());
//			if (containedElementAt instanceof XAbstractFeatureCall) {
//				this.createHyperlinksForCrossRef(resource, crossRefNode, acceptor);
//			} else {
//				this.createHyperlinksByOffset(resource, offset, acceptor);
//			}
//		}
//		if (!links.isEmpty())
//			return Iterables.toArray(links, IHyperlink.class);
//		return null;
//	}

}
