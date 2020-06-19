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
package org.osate.xtext.aadl2.parsing;

import java.util.Iterator;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.source.ICharacterPairMatcher;
import org.eclipse.xtext.ui.editor.doubleClicking.AbstractWordAwareDoubleClickStrategy;
import org.eclipse.xtext.ui.editor.model.ILexerTokenRegion;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.osate.xtext.aadl2.parser.antlr.lexer.InternalAadl2Lexer;

import com.google.inject.Inject;

// same as LexerTokenAndCharacterPairStrategy except that it does findword on ANNEXTEXT
public class Aadl2TokenStrategy extends AbstractWordAwareDoubleClickStrategy {

	@Inject
	private ICharacterPairMatcher characterPairMatcher;

	@Override
	protected IRegion findWord(IDocument document, int offset) {
		if (document instanceof XtextDocument) {
			Iterator<ILexerTokenRegion> tokenIterator = ((XtextDocument) document).getTokens().iterator();
			ILexerTokenRegion leadingToken = null;
			ILexerTokenRegion trailingToken = null;
			while (tokenIterator.hasNext()) {
				ILexerTokenRegion token = tokenIterator.next();
				if (token.getOffset() <= offset && token.getOffset() + token.getLength() >= offset) {
					if (leadingToken != null) {
						trailingToken = token;
					} else {
						leadingToken = token;
					}
				}
				if (token.getOffset() > offset) {
					break;
				}
			}
			if (leadingToken != null) {
				try {
					if (leadingToken.getLength() > 1
							&& leadingToken.getLexerTokenType() == InternalAadl2Lexer.RULE_ANNEXTEXT) {
						return super.findWord(document, offset);
					} else if (leadingToken.getLength() > 1 && (trailingToken == null
							|| !Character.isLetter(document.getChar(trailingToken.getOffset())))) {
						return new Region(leadingToken.getOffset(), leadingToken.getLength());
					} else if (trailingToken != null) {
						return new Region(trailingToken.getOffset(), trailingToken.getLength());
					}
				} catch (BadLocationException ignore) {
				}
			}
		}
		return super.findWord(document, offset);
	}

	@Override
	protected IRegion findExtendedDoubleClickSelection(IDocument document, int offset) {
		IRegion match = characterPairMatcher.match(document, offset);
		if (match != null && match.getLength() >= 2) {
			return new Region(match.getOffset() + 1, match.getLength() - 2);
		}
		return findWord(document, offset);
	}

	protected ICharacterPairMatcher getCharacterPairMatcher() {
		return characterPairMatcher;
	}

}
