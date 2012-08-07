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
import org.osate.annexsupport.AnnexParseResult;
import org.osate.annexsupport.AnnexRegistry;
import org.osate.annexsupport.AnnexTextPositionResolver;
import org.osate.annexsupport.AnnexTextPositionResolverRegistry;
import org.osate.annexsupport.AnnexUtil;
import org.osate.annexsupport.TextPositionInfo;

import com.google.inject.Inject;

public class Aadl2HyperlinkHelper extends HyperlinkHelper {

	AnnexTextPositionResolverRegistry textpositionresolverregistry ;
	
	protected Aadl2HyperlinkHelper(){
		initTextPositionResolverRegistry();
	}
	
	protected void initTextPositionResolverRegistry(){
		if (textpositionresolverregistry == null){
			textpositionresolverregistry = (AnnexTextPositionResolverRegistry) AnnexRegistry
					.getRegistry(AnnexRegistry.ANNEX_TEXTPOSITIONRESOLVER_EXT_ID);
		}
	}
	
	@Inject
	private EObjectAtOffsetHelper eObjectAtOffsetHelper;

	public void createHyperlinksByOffset(XtextResource resource, int offset, IHyperlinkAcceptor acceptor) {
		INode annexLeaf = findAnnexLeafNode(resource, offset);
		if (annexLeaf!= null){
			// handle extensionpoint based text position
			if (textpositionresolverregistry == null) initTextPositionResolverRegistry();
			if (textpositionresolverregistry != null){
				EObject obj = NodeModelUtils.findActualSemanticObjectFor(annexLeaf);
				if (obj instanceof NamedElement){
					AnnexParseResult apr = AnnexUtil.getAnnexParseResult(obj);
					EObject actualAnnexElement = apr.getParseResult().getRootASTElement();
					if (actualAnnexElement != null){
					String annexName = ((NamedElement)obj).getName();
					AnnexTextPositionResolver atpr = textpositionresolverregistry.getTextPositionResolver(annexName);
					if (atpr != null){
						TextPositionInfo tpo = atpr.resolveElementAt(actualAnnexElement, offset-apr.getAnnexOffset());
						if (tpo.getModelObject() != null && !tpo.getModelObject().eIsProxy()) {
							// TODO phf do the addition
							Region region = new Region(tpo.getOffset()+apr.getAnnexOffset(), tpo.getLength());
							createHyperlinksTo(resource, region, tpo.getModelObject(), acceptor);
						}
					}
					}
				}
			}
		}
		// xtext based position is getting resolved by Aadl2EObjectAtOffsetHelper
		INode crossRefNode = eObjectAtOffsetHelper.getCrossReferenceNode(resource, new TextRegion(offset, 0));
		if (crossRefNode == null)
			return;
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
	protected ILeafNode findAnnexLeafNode(XtextResource resource, int offset){
		IParseResult parseResult = resource.getParseResult();
		if (parseResult != null && parseResult.getRootNode() != null) {
			ILeafNode leaf = NodeModelUtils.findLeafNodeAtOffset(parseResult.getRootNode(), offset);
			if (isAnnexLeaf(leaf)){
				return leaf;
			}
		}
		return null;
	}

	protected boolean isAnnexLeaf(ILeafNode leaf){
		if (leaf == null) return false;
		EObject ge = leaf.getGrammarElement();
		if (ge instanceof RuleCall){
			AbstractRule rule = ((RuleCall)ge).getRule();
			if (rule.getName().equalsIgnoreCase("ANNEXTEXT")){
				return true;
			}
		}
		return false;
	}

}
