/*
 *
 * <copyright>
 * Copyright  2012 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/org/documents/epl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE "DELIVERABLES") ARE ON AN "AS-IS" BASIS.
 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
 * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
 * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
 * MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
 * APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.
 *
 * Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
 * employees, and agents from all claims or demands made against them (and any related losses, expenses, or
 * attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
 * misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
 * assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
 * product liability, personal injury, death, damage to property, or violation of any laws or regulations.
 *
 * Carnegie Mellon Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 * </copyright>
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
