package org.osate.xtext.aadl2.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.ITextRegion;
import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.AnnexSubclause;
import org.osate.annexsupport.AnnexParseResult;
import org.osate.annexsupport.AnnexUtil;

public class MyEObjectAtOffsetHelper extends
		org.eclipse.xtext.resource.EObjectAtOffsetHelper {

	@Override
	public INode getCrossReferenceNode(XtextResource resource, ITextRegion region) {
		IParseResult parseResult = resource.getParseResult();
		if (parseResult != null && parseResult.getRootNode() != null) {
			ILeafNode leaf = NodeModelUtils.findLeafNodeAtOffset(parseResult.getRootNode(), region.getOffset());
//			EObject ge = leaf.getGrammarElement();
//			if (ge instanceof RuleCall){
//				AbstractRule rule = ((RuleCall)ge).getRule();
//				if (rule.getName().equalsIgnoreCase("ANNEXTEXT")){
//					EObject semobj = NodeModelUtils.findActualSemanticObjectFor(leaf);
//					if (semobj instanceof AnnexSubclause || semobj instanceof AnnexLibrary){
//						AnnexParseResult apr =AnnexUtil.getAnnexParseResult(semobj);
//						IParseResult aParseResult = apr.getParseResult();
//						if (aParseResult != null && aParseResult.getRootNode() != null) {
//							leaf = NodeModelUtils.findLeafNodeAtOffset(aParseResult.getRootNode(), region.getOffset());
//						}
//					}
//				}
//			}
			leaf = getAnnexLeaf(leaf, region.getOffset());
			INode crossRefNode = findCrossReferenceNode(leaf);
			// if not a cross reference position and the cursor is at the beginning of a node try the previous one.
			if (crossRefNode == null && leaf != null && region.getLength()==0 && leaf.getOffset() == region.getOffset()) {
				leaf = NodeModelUtils.findLeafNodeAtOffset(parseResult.getRootNode(), region.getOffset() - 1);
				return findCrossReferenceNode(leaf);
			} else if (crossRefNode != null && crossRefNode.getOffset()+crossRefNode.getLength() >= region.getOffset() + region.getLength()) {
				return crossRefNode;
			}
		}
		return null;
	}
	
@Override
	protected EObject internalResolveElementAt(XtextResource resource, int offset, boolean containment) {
		EObject crossRef = resolveCrossReferencedElementAt(resource, offset);
		if (crossRef != null)
			return crossRef;
		IParseResult parseResult = resource.getParseResult();
		if (parseResult != null && parseResult.getRootNode() != null) {
			ILeafNode leaf = NodeModelUtils.findLeafNodeAtOffset(parseResult.getRootNode(), offset);
			leaf = getAnnexLeaf(leaf, offset);
			if (leaf != null && leaf.isHidden() && leaf.getOffset() == offset) {
				leaf = NodeModelUtils.findLeafNodeAtOffset(parseResult.getRootNode(), offset - 1);
			}
			if (leaf != null) {
				return NodeModelUtils.findActualSemanticObjectFor(leaf);
			}
		}
		return null;
	}
	
	protected ILeafNode getAnnexLeaf(ILeafNode leaf, int offset){
		EObject ge = leaf.getGrammarElement();
		if (ge instanceof RuleCall){
			AbstractRule rule = ((RuleCall)ge).getRule();
			if (rule.getName().equalsIgnoreCase("ANNEXTEXT")){
				EObject semobj = NodeModelUtils.findActualSemanticObjectFor(leaf);
				if (semobj instanceof AnnexSubclause || semobj instanceof AnnexLibrary){
					AnnexParseResult apr =AnnexUtil.getAnnexParseResult(semobj);
					IParseResult aParseResult = apr.getParseResult();
					if (aParseResult != null && aParseResult.getRootNode() != null) {
						leaf = NodeModelUtils.findLeafNodeAtOffset(aParseResult.getRootNode(), offset);
					}
				}
			}
		}
		return leaf;

	}


}
