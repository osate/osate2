package org.osate.xtext.aadl2.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.TextRegion;
import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.NamedElement;
import org.osate.annexsupport.AnnexRegistry;
import org.osate.annexsupport.AnnexTextPositionResolver;
import org.osate.annexsupport.AnnexTextPositionResolverRegistry;
import org.osate.annexsupport.AnnexUtil;
import org.osate.annexsupport.TextPositionInfo;

public class Aadl2EObjectAtOffsetHelper extends org.eclipse.xtext.resource.EObjectAtOffsetHelper {

	AnnexTextPositionResolverRegistry textpositionresolverregistry;

	protected Aadl2EObjectAtOffsetHelper() {
		initTextPositionResolverRegistry();
	}

	protected void initTextPositionResolverRegistry() {
		if (textpositionresolverregistry == null) {
			textpositionresolverregistry = (AnnexTextPositionResolverRegistry) AnnexRegistry
					.getRegistry(AnnexRegistry.ANNEX_TEXTPOSITIONRESOLVER_EXT_ID);
		}
	}

	/*
	 * resolve the element, first by attempting as CrossReference and then as element itself
	 * 
	 * @see org.eclipse.xtext.resource.EObjectAtOffsetHelper#resolveElementAt(org.eclipse.xtext.resource.XtextResource, int)
	 */
	@Override
	public EObject resolveElementAt(XtextResource resource, int offset) {
		INode annexLeaf = AnnexUtil.findAnnexLeafNode(resource, offset);
		if (annexLeaf != null) {
			EObject obj = NodeModelUtils.findActualSemanticObjectFor(annexLeaf);
			if (textpositionresolverregistry == null) {
				initTextPositionResolverRegistry();
			}
			if (textpositionresolverregistry != null) {
				if (obj instanceof NamedElement) {
					String annexName = ((NamedElement) obj).getName();
					// find the actual subclause or library instead of the default one found from the NodeModel
					if (obj instanceof AnnexSubclause || obj instanceof AnnexLibrary) {
						AnnexTextPositionResolver atpr = textpositionresolverregistry
								.getTextPositionResolver(annexName);
						EObject actualAnnexElement = AnnexUtil.getParsedAnnex(obj);
						if (atpr != null && actualAnnexElement != null) {
							TextPositionInfo tpo = atpr.resolveElementAt(actualAnnexElement, offset);
							return tpo.getModelObject();
						}
					}
				}
			}
			// now try xtext based annexes via adapted ParseResult
			annexLeaf = getLeafInParsedAnnex((ILeafNode) annexLeaf, offset);
			if (annexLeaf != null) {
				return NodeModelUtils.findActualSemanticObjectFor(annexLeaf);
			} else {
				return obj;

			}
		}
		INode node = getCrossReferenceNode(resource, new TextRegion(offset, 0));
		if (node != null) {
			return getCrossReferencedElement(node);
		}
		IParseResult parseResult = resource.getParseResult();
		if (parseResult != null && parseResult.getRootNode() != null) {
			ILeafNode leaf = NodeModelUtils.findLeafNodeAtOffset(parseResult.getRootNode(), offset);
			if (leaf != null && leaf.isHidden() && leaf.getOffset() == offset) {
				leaf = NodeModelUtils.findLeafNodeAtOffset(parseResult.getRootNode(), offset - 1);
			}
			if (leaf != null) {
				return NodeModelUtils.findActualSemanticObjectFor(leaf);
			}
		}
		return null;
//		return internalResolveElementAt(resource, offset, true);
	}

	/**
	 * @return the cross referenced EObject under, right or left to the cursor (in that order) or
	 *         <code>null</code> if there is no cross referenced object next to the offset.
	 */
	@Override
	public EObject resolveCrossReferencedElementAt(XtextResource resource, int offset) {
		INode annexLeaf = AnnexUtil.findAnnexLeafNode(resource, offset);
		if (annexLeaf != null) {
			if (textpositionresolverregistry == null) {
				initTextPositionResolverRegistry();
			}
			if (textpositionresolverregistry != null) {
				EObject obj = NodeModelUtils.findActualSemanticObjectFor(annexLeaf);
				if (obj instanceof NamedElement) {
					String annexName = ((NamedElement) obj).getName();
					// find the actual subclause or library instead of the default one found from the NodeModel
					if (obj instanceof AnnexSubclause || obj instanceof AnnexLibrary) {
						AnnexTextPositionResolver atpr = textpositionresolverregistry
								.getTextPositionResolver(annexName);
						EObject actualAnnexElement = AnnexUtil.getParsedAnnex(obj);
						if (atpr != null && actualAnnexElement != null) {
							TextPositionInfo tpo = atpr.resolveCrossReferencedElementAt(actualAnnexElement, offset);
							return tpo.getModelObject();
						}
					}
				}
			}
			// now try xtext based annexes via adapted ParseResult
			annexLeaf = getLeafInParsedAnnex((ILeafNode) annexLeaf, offset);
			annexLeaf = findCrossReferenceNode(annexLeaf);
			if (annexLeaf != null) {
				return getCrossReferencedElement(annexLeaf);
			}
		}
		INode node = getCrossReferenceNode(resource, new TextRegion(offset, 0));
		if (node != null) {
			return getCrossReferencedElement(node);
		}
		return null;
	}

	/**
	 * method handles xtext based annex text positions via adapted ParseResult
	 */
	@Override
	public INode getCrossReferenceNode(XtextResource resource, ITextRegion region) {
		IParseResult parseResult = resource.getParseResult();
		if (parseResult != null && parseResult.getRootNode() != null) {
			ILeafNode leaf = NodeModelUtils.findLeafNodeAtOffset(parseResult.getRootNode(), region.getOffset());
			// getAnnexleaf is the addition.
			if (AnnexUtil.isAnnexLeaf(leaf)) {
				leaf = getLeafInParsedAnnex(leaf, region.getOffset());
			}
			INode crossRefNode = findCrossReferenceNode(leaf);
			// if not a cross reference position and the cursor is at the beginning of a node try the previous one.
			if (crossRefNode == null && leaf != null && region.getLength() == 0
					&& leaf.getOffset() == region.getOffset()) {
				leaf = NodeModelUtils.findLeafNodeAtOffset(parseResult.getRootNode(), region.getOffset() - 1);
				return findCrossReferenceNode(leaf);
			} else if (crossRefNode != null
					&& crossRefNode.getOffset() + crossRefNode.getLength() >= region.getOffset() + region.getLength()) {
				return crossRefNode;
			}
		}
		return null;
	}

	@Override
	protected EObject internalResolveElementAt(XtextResource resource, int offset, boolean containment) {
		if (!containment) {
			EObject crossRef = resolveCrossReferencedElementAt(resource, offset);
			if (crossRef != null) {
				return crossRef;
			}
		}
		IParseResult parseResult = resource.getParseResult();
		if (parseResult != null && parseResult.getRootNode() != null) {
			ILeafNode leaf = NodeModelUtils.findLeafNodeAtOffset(parseResult.getRootNode(), offset);
			// we look up annex leaf in the annex specific parse tree
			if (AnnexUtil.isAnnexLeaf(leaf)) {
				leaf = getLeafInParsedAnnex(leaf, offset);
			}
			if (leaf != null && leaf.isHidden() && leaf.getOffset() == offset) {
				leaf = NodeModelUtils.findLeafNodeAtOffset(parseResult.getRootNode(), offset - 1);
			}
			if (leaf != null) {
				return NodeModelUtils.findActualSemanticObjectFor(leaf);
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
				ICompositeNode pLeaf = NodeModelUtils.findActualNodeFor(parsedAnnex);
				if (pLeaf != null) {
					leaf = NodeModelUtils.findLeafNodeAtOffset(pLeaf, offset);
				}
			}
		}
		return leaf;
	}

}
