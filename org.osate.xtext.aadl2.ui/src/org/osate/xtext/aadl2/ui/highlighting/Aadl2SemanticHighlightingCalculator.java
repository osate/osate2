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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.AnnexSubclause;
import org.osate.annexsupport.AnnexHighlighter;
import org.osate.annexsupport.AnnexHighlighterPositionAcceptor;
import org.osate.annexsupport.AnnexHighlighterRegistry;
import org.osate.annexsupport.AnnexParseResult;
import org.osate.annexsupport.AnnexRegistry;
import org.osate.annexsupport.AnnexSource;
import org.osate.annexsupport.AnnexUtil;

public class Aadl2SemanticHighlightingCalculator implements ISemanticHighlightingCalculator {
	private final String ANNEXTEXTKEYWORD = "annex";
	private final String SEMICOLONKEYWORD = ";";
	@Override
	public void provideHighlightingFor(XtextResource resource, final IHighlightedPositionAcceptor acceptor) {
		if (resource == null) return;
		final AnnexHighlighterRegistry registry = (AnnexHighlighterRegistry)AnnexRegistry.getRegistry(AnnexRegistry.ANNEX_HIGHLIGHTER_EXT_ID);
		
		for(EObject obj : resource.getContents()) {
			for(AnnexSubclause subclause : EcoreUtil2.eAllOfType(obj, AnnexSubclause.class)) {				
				AnnexHighlighterPositionAcceptor annexAcceptor = createAcceptor(subclause, acceptor);

				if(annexAcceptor != null) {
					AnnexHighlighter highlighter = registry.getAnnexHighlighter(subclause.getName());
					if(highlighter != null)    {
					    highlighter.highlightAnnexSubclause(subclause, annexAcceptor);
					}
					else
					{
					    AnnexParseResult apr = AnnexUtil.getAnnexParseResult(subclause);
					    if (apr != null){
					        addHighlight(apr, annexAcceptor);
					    }
					}
				}
			}

			for(AnnexLibrary library : EcoreUtil2.eAllOfType(obj, AnnexLibrary.class)) {
				AnnexHighlighterPositionAcceptor annexAcceptor = createAcceptor(library, acceptor);
				if(annexAcceptor != null) {
					AnnexParseResult apr = AnnexUtil.getAnnexParseResult(library);
					if (apr != null){
						addHighlight(apr, annexAcceptor);
					} else {
						AnnexHighlighter highlighter = registry.getAnnexHighlighter(library.getName());
						if(highlighter != null)	{
							highlighter.highlightAnnexLibrary(library, annexAcceptor);
						}
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
	private AnnexHighlighterPositionAcceptor createAcceptor(EObject semanticObj, final IHighlightedPositionAcceptor acceptor) {
		final AnnexSource annexSource = getAnnexSource(semanticObj);
		
		if(annexSource == null) {
			return null;
//			throw new RuntimeException("Unable to find AnnexSource for object: " + semanticObj);
		}
		
		return new AnnexHighlighterPositionAcceptor() {
			@Override
			public void addPosition(int offset, int length, String... id) {
				if(offset < 0) {
					throw new RuntimeException("Offset is less than 0");
				}
				
				if(offset > annexSource.getSourceText().length()) {
					throw new RuntimeException("Offset is greater than source text length");
				}
				
				// Calculate the absolute offset
				int absOffset = annexSource.getSourceTextOffset() + offset;
				acceptor.addPosition(absOffset, length, id);
			}
		};
	}
	
	private AnnexSource getAnnexSource(EObject obj)	{
		// Find the Annex source information
		for(Adapter adapter : obj.eAdapters()) {
			if(adapter instanceof AnnexSource) {
				return (AnnexSource)adapter;
			}
		}
		
		return null;
	}
	

	
	private void addHighlight(AnnexParseResult annexParseResult, AnnexHighlighterPositionAcceptor acceptor){
		if (annexParseResult == null) return ;
		IParseResult parseResult = annexParseResult.getParseResult();
		if (parseResult == null)
			return;

		INode root = parseResult.getRootNode();
		for (INode node : root.getAsTreeIterable()) {
			EObject ge = node.getGrammarElement();
			if (ge instanceof Keyword)
			{
				String keywordValue = ((Keyword) ge).getValue();
				int offset = node.getOffset()-annexParseResult.getAnnexOffset();
				if(offset < 0 && keywordValue.equalsIgnoreCase(ANNEXTEXTKEYWORD))
					continue;
				int annexLength = getAnnexSource(parseResult.getRootASTElement()).getSourceText().length();
				if(offset > annexLength && keywordValue.equalsIgnoreCase(SEMICOLONKEYWORD))
					continue;
				// adjust for added whitespace in front of annex text
				acceptor.addPosition(offset, node.getLength(), 
							AnnexHighlighterPositionAcceptor.KEYWORD_ID);
			} else if (ge instanceof TerminalRule) {
				if (((TerminalRule)ge).getName().equalsIgnoreCase("SL_COMMENT")){
					// adjust for added whitespace in front of annex text
					acceptor.addPosition(node.getOffset()-annexParseResult.getAnnexOffset(), node.getLength(), 
							AnnexHighlighterPositionAcceptor.COMMENT_ID);
				} else if (((TerminalRule)ge).getName().equalsIgnoreCase("STRING")){
					// adjust for added whitespace in front of annex text
					acceptor.addPosition(node.getOffset()-annexParseResult.getAnnexOffset(), node.getLength(), 
							AnnexHighlighterPositionAcceptor.STRING_ID);
				}
			} 
		}
	}


}
