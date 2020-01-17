/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
 * All Rights Reserved.
 * 
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 * 
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
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
