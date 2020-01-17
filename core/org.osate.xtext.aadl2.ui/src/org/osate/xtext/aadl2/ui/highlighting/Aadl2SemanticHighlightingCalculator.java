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
package org.osate.xtext.aadl2.ui.highlighting;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.annexsupport.AnnexHighlighter;
import org.osate.annexsupport.AnnexHighlighterPositionAcceptor;
import org.osate.annexsupport.AnnexHighlighterRegistry;
import org.osate.annexsupport.AnnexRegistry;
import org.osate.annexsupport.AnnexUtil;

public class Aadl2SemanticHighlightingCalculator implements ISemanticHighlightingCalculator {
	private final String ANNEXTEXTKEYWORD = "annex";
	private final String SEMICOLONKEYWORD = ";";

	@Override
	public void provideHighlightingFor(XtextResource resource, final IHighlightedPositionAcceptor acceptor) {
		if (resource == null) {
			return;
		}
		final AnnexHighlighterRegistry registry = (AnnexHighlighterRegistry) AnnexRegistry
				.getRegistry(AnnexRegistry.ANNEX_HIGHLIGHTER_EXT_ID);

		for (EObject obj : resource.getContents()) {
			for (DefaultAnnexSubclause subclause : EcoreUtil2.eAllOfType(obj, DefaultAnnexSubclause.class)) {
				AnnexHighlighterPositionAcceptor annexAcceptor = createAcceptor(subclause, acceptor);

				if (annexAcceptor != null) {
					AnnexHighlighter highlighter = registry.getAnnexHighlighter(subclause.getName());
					if (highlighter != null) {
						highlighter.highlightAnnexSubclause(subclause, annexAcceptor);
					} else {
						addHighlight(subclause, annexAcceptor);
					}
				}
			}

			for (AnnexLibrary library : EcoreUtil2.eAllOfType(obj, AnnexLibrary.class)) {
				AnnexHighlighterPositionAcceptor annexAcceptor = createAcceptor(library, acceptor);

				if (annexAcceptor != null) {
					AnnexHighlighter highlighter = registry.getAnnexHighlighter(library.getName());
					if (highlighter != null) {
						highlighter.highlightAnnexLibrary(library, annexAcceptor);
					} else {
						addHighlight(library, annexAcceptor);
					}
				}
			}
		}
	}

	/**
	 * Creates an AnnexHighlighterPositionAcceptor specific to a annex source block
	 * @param semanticObj the AnnexLibrary or AnnexSubclause to build the acceptor for
	 * @param acceptor the xtext Acceptor that is wraps
	 * @return the new AnnexHighlighterPositionAcceptor or null if one could not be created
	 */
	private AnnexHighlighterPositionAcceptor createAcceptor(EObject semanticObj,
			final IHighlightedPositionAcceptor acceptor) {
		final int annexTextLength = AnnexUtil.getSourceText(semanticObj).length();
		final int annexTextOffset = AnnexUtil.getAnnexOffset(semanticObj);

		return new AnnexHighlighterPositionAcceptor() {
			@Override
			public void addPosition(int offset, int length, String... id) {
				if (offset < 0) {
					return;// throw new RuntimeException("Offset is less than 0");
				}

				if (offset > annexTextLength) {
					return;// throw new RuntimeException("Offset is greater than source text length");
				}

				// Calculate the absolute offset
				int absOffset = annexTextOffset + offset;
				acceptor.addPosition(absOffset, length, id);
			}
		};
	}

	private void addHighlight(EObject annexObject, AnnexHighlighterPositionAcceptor acceptor) {
		EObject parsedAnnexObject = AnnexUtil.getParsedAnnex(annexObject);
		if (parsedAnnexObject == null) {
			return;
		}
		INode annexnode = NodeModelUtils.getNode(parsedAnnexObject);
		if (annexnode == null) {
			return;
		}
		INode root = annexnode.getRootNode();
		final int annexTextLength = AnnexUtil.getSourceText(annexObject).length();
		final int annexTextOffset = AnnexUtil.getAnnexOffset(annexObject);
		for (INode node : root.getAsTreeIterable()) {
			EObject ge = node.getGrammarElement();
			if (ge instanceof RuleCall) {
				ge = ((RuleCall) ge).getRule();
			}

			if (ge instanceof Keyword) {
				String keywordValue = ((Keyword) ge).getValue();
				int offset = node.getOffset() - annexTextOffset;
				if (offset < 0 && keywordValue.equalsIgnoreCase(ANNEXTEXTKEYWORD)) {
					continue;
				}
				if (offset > annexTextLength && keywordValue.equalsIgnoreCase(SEMICOLONKEYWORD)) {
					continue;
				}
				// adjust for added whitespace in front of annex text
				acceptor.addPosition(offset, node.getLength(), AnnexHighlighterPositionAcceptor.KEYWORD_ID);
			} else if (ge instanceof TerminalRule) {
				if (((TerminalRule) ge).getName().equalsIgnoreCase("SL_COMMENT")) {
					// adjust for added whitespace in front of annex text
					acceptor.addPosition(node.getOffset() - annexTextOffset, node.getLength(),
							AnnexHighlighterPositionAcceptor.COMMENT_ID);
				} else if (((TerminalRule) ge).getName().equalsIgnoreCase("STRING")) {
					// adjust for added whitespace in front of annex text
					acceptor.addPosition(node.getOffset() - annexTextOffset, node.getLength(),
							AnnexHighlighterPositionAcceptor.STRING_ID);
				}
			}
		}
	}
}
