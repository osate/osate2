package org.osate.alisa.common.ui.util;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.hyperlinking.IHyperlinkAcceptor;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.ui.navigation.XbaseHyperLinkHelper;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

@SuppressWarnings("restriction")
public class AlisaHyperLinkHelper extends XbaseHyperLinkHelper {
	@Override
	public IHyperlink[] createHyperlinksByOffset(XtextResource resource, int offset, boolean createMultipleHyperlinks) {
		if (!createMultipleHyperlinks) {
			return super.createHyperlinksByOffset(resource, offset, createMultipleHyperlinks);
		}
		List<IHyperlink> links = Lists.newArrayList();
		IHyperlinkAcceptor acceptor = new HyperlinkAcceptor(links);
		INode crossRefNode = getEObjectAtOffsetHelper().getCrossReferenceNode(resource, new TextRegion(offset, 0));
		if (crossRefNode == null) {
			this.createHyperlinksByOffset(resource, offset, acceptor);
		} else {
			EObject containedElementAt = getEObjectAtOffsetHelper().resolveContainedElementAt(resource,
					crossRefNode.getOffset());
			if (containedElementAt instanceof XAbstractFeatureCall) {
				this.createHyperlinksForCrossRef(resource, crossRefNode, acceptor);
			} else {
				this.createHyperlinksByOffset(resource, offset, acceptor);
			}
		}
		if (!links.isEmpty())
			return Iterables.toArray(links, IHyperlink.class);
		return null;
	}

}
