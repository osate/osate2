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
package org.osate.xtext.aadl2.formatting2.regionaccess;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.formatting2.regionaccess.TextRegionAccessBuilder;
import org.eclipse.xtext.formatting2.regionaccess.internal.NodeModelBasedRegionAccessBuilder;
import org.eclipse.xtext.formatting2.regionaccess.internal.TextRegionAccessBuildingSequencer;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.ISequenceAcceptor;

/**
 * Created to allow formatting for keyword only parser rules:
 * https://www.eclipse.org/forums/index.php/t/1088231/
 */
@SuppressWarnings("restriction")
public class Aadl2TextRegionAccessBuilder extends TextRegionAccessBuilder {
	private TextRegionAccessBuildingSequencer fromSequencer;
	private NodeModelBasedRegionAccessBuilder fromNodeModel;
	
	@Override
	public TextRegionAccessBuilder forNodeModel(XtextResource resource) {
		fromNodeModel = new NodeModelBasedRegionAccessBuilder() {
			@Override
			protected boolean include(INode node) {
				if (node.getGrammarElement() instanceof RuleCall) {
					AbstractRule rule = ((RuleCall) node.getGrammarElement()).getRule();
					if (GrammarUtil.isDatatypeRule(rule) && rule.getAlternatives() instanceof Group
							&& ((Group) rule.getAlternatives()).getElements().stream()
									.allMatch(element -> element instanceof Keyword)) {
						return false;
					}
				}
				return super.include(node);
			}
		}.withResource(resource);
		return this;
	}
	
	@Override
	public ISequenceAcceptor forSequence(ISerializationContext ctx, EObject root) {
		return this.fromSequencer = new TextRegionAccessBuildingSequencer().withRoot(ctx, root);
	}
	
	@Override
	public ITextRegionAccess create() {
		if (fromNodeModel != null)
			return fromNodeModel.create();
		if (fromSequencer != null)
			return fromSequencer.getRegionAccess();
		throw new IllegalStateException();
	}
}