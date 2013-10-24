package org.osate.xtext.aadl2.util;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.DefaultLocationInFileProvider;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.TextRegion;
import org.osate.aadl2.Element;
import org.osate.aadl2.parsesupport.AObject;
import org.osate.aadl2.parsesupport.LocationReference;

public class Aadl2LocationInFile extends DefaultLocationInFileProvider {

	@Override
	protected ITextRegion getTextRegion(EObject obj, boolean isSignificant) {
		ICompositeNode node = NodeModelUtils.findActualNodeFor(obj);
		
		/**
		 * This is an old code that was initially removed but
		 * added again to fix some bugs.
		 * See. https://github.com/osate/osate2-ba/issues/1
		 */
		if (node == null) {
			// it may be in annex
			if (obj instanceof AObject){
				LocationReference locref = ((AObject)obj).getLocationReference();
				if (locref != null){
					return new TextRegion(locref.getOffset(), locref.getLength());
				} else {
					//try AnnexSource adapter
				}
			}
			if (obj.eContainer() == null)
				return ITextRegion.EMPTY_REGION;
			return getTextRegion(obj.eContainer(), isSignificant);
		}
		/**
		 * end of handling error with the behavior annex
		 */
		
		List<INode> nodes = null;
		if (isSignificant)
			nodes = getLocationNodes(obj);
		if (nodes == null || nodes.isEmpty())
			nodes = Collections.<INode>singletonList(node);
		return createRegion(nodes);
	}
	
	public static LocationReference getLocationReference(Element obj) 
	{
		if (obj.getLocationReference() == null)
		{
			ICompositeNode node = NodeModelUtils.findActualNodeFor(obj);
			
			LocationReference locref = new LocationReference();
			locref.setLine(node.getTotalStartLine());
			locref.setFilename(obj.eResource().getURI().toString());
			locref.setOffset(node.getTotalOffset());
			locref.setLength(node.getTotalLength());
			return locref;
		}
		return obj.getLocationReference();

	}

}
