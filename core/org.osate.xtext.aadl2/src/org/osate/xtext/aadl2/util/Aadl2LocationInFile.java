package org.osate.xtext.aadl2.util;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.DefaultLocationInFileProvider;
import org.eclipse.xtext.util.ITextRegion;
import org.osate.aadl2.Element;
import org.osate.aadl2.parsesupport.LocationReference;

public class Aadl2LocationInFile extends DefaultLocationInFileProvider {

	@Override
	protected ITextRegion getTextRegion(EObject obj, boolean isSignificant) {
		ICompositeNode node = NodeModelUtils.findActualNodeFor(obj);
		List<INode> nodes = null;
		if (isSignificant)
			nodes = getLocationNodes(obj);
		if (nodes == null || nodes.isEmpty())
			nodes = Collections.<INode>singletonList(node);
		return createRegion(nodes);
	}
	
	public static LocationReference getLocationReference(Element obj) {
		ICompositeNode node = NodeModelUtils.findActualNodeFor(obj);
		LocationReference locref = new LocationReference();
		locref.setLine(node.getTotalStartLine());
		locref.setFilename(obj.eResource().getURI().toString());
		locref.setOffset(node.getTotalOffset());
		locref.setLength(node.getTotalLength());
		return locref;
	}

}
