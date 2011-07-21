package org.osate.xtext.aadl2.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.BidiTreeIterable;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.SyntaxErrorMessage;

public class PSNode implements ILeafNode{
	
	private String name;

	public PSNode(String s) {
		name = s;
	}
	public PSNode() {
	}
	
	public ICompositeNode getParent() {
		return null;
	}

	public String getText() {
		return name;
	}

	public void setText(String s) {
		name = s;
	}
	
	public int getTotalLength() {
		return 1;
	}
	
	public int getTotalStartLine() {
		return 1;
	}

	public int getStartLine() {
		return 1;
	}
	
	public int getEndLine() {
		return 1;
	}
	
	public int getTotalEndLine() {
		return 1;
	}
	
	public int getOffset() {
		return 1;
	}
	
	public int getLength() {
		return 1;
	}
	
	public int getTotalEndOffset() {
		return 1;
	}

	public ICompositeNode getRootNode() {
		return null;
	}
	
	public EObject getSemanticElement() {
		return null;
	}
	
	public boolean hasDirectSemanticElement() {
		return false;
	}
	
	public EObject getGrammarElement() {
		return null;
	}

	public SyntaxErrorMessage getSyntaxErrorMessage() {
		return null;
	}
	
	public INode getPreviousSibling() {
		return null;
	}
	
	public INode getNextSibling() {
		return null;
	}
	
	
	public boolean hasPreviousSibling() {
		return basicHasPreviousSibling();
	}
	
	protected boolean basicHasPreviousSibling() {
			return false;
	}
	
	public boolean hasNextSibling() {
		return false;
	}
	
	
	public boolean hasSiblings() {
		return false;
	}

	public Iterable<ILeafNode> getLeafNodes() {
		return null;
	}

	public int getTotalOffset() {
		return 0;
	}

	public BidiTreeIterable<INode> getAsTreeIterable() {
		return null;
	}

	public boolean isHidden() {
		return false;
	}
	

}
