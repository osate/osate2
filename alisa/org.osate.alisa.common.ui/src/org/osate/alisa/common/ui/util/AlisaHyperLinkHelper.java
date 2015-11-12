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
