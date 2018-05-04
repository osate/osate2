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
