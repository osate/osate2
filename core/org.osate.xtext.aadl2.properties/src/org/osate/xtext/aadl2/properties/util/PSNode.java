package org.osate.xtext.aadl2.properties.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.BidiTreeIterable;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.SyntaxErrorMessage;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.ITextRegionWithLineInformation;

public class PSNode implements ILeafNode {

	private String name;

	public PSNode(String s) {
		name = s;
	}

	public PSNode() {
	}

	@Override
	public ICompositeNode getParent() {
		return null;
	}

	@Override
	public String getText() {
		return name;
	}

	public void setText(String s) {
		name = s;
	}

	@Override
	public int getTotalLength() {
		return 1;
	}

	@Override
	public int getTotalStartLine() {
		return 1;
	}

	@Override
	public int getStartLine() {
		return 1;
	}

	@Override
	public int getEndLine() {
		return 1;
	}

	@Override
	public int getTotalEndLine() {
		return 1;
	}

	@Override
	public int getOffset() {
		return 1;
	}

	@Override
	public int getLength() {
		return 1;
	}

	@Override
	public int getTotalEndOffset() {
		return 1;
	}

	@Override
	public ICompositeNode getRootNode() {
		return null;
	}

	@Override
	public EObject getSemanticElement() {
		return null;
	}

	@Override
	public boolean hasDirectSemanticElement() {
		return false;
	}

	@Override
	public EObject getGrammarElement() {
		return null;
	}

	@Override
	public SyntaxErrorMessage getSyntaxErrorMessage() {
		return null;
	}

	@Override
	public INode getPreviousSibling() {
		return null;
	}

	@Override
	public INode getNextSibling() {
		return null;
	}

	@Override
	public boolean hasPreviousSibling() {
		return basicHasPreviousSibling();
	}

	protected boolean basicHasPreviousSibling() {
		return false;
	}

	@Override
	public boolean hasNextSibling() {
		return false;
	}

	@Override
	public boolean hasSiblings() {
		return false;
	}

	@Override
	public Iterable<ILeafNode> getLeafNodes() {
		return null;
	}

	@Override
	public int getTotalOffset() {
		return 0;
	}

	@Override
	public BidiTreeIterable<INode> getAsTreeIterable() {
		return null;
	}

	@Override
	public boolean isHidden() {
		return false;
	}

	@Override
	public int getEndOffset() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ITextRegion getTextRegion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ITextRegion getTotalTextRegion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ITextRegionWithLineInformation getTextRegionWithLineInformation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ITextRegionWithLineInformation getTotalTextRegionWithLineInformation() {
		// TODO Auto-generated method stub
		return null;
	}

}
