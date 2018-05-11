package org.osate.annexsupport;

import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration;

public interface AnnexHighlighterPositionAcceptor {
	/**
	 * Assigns style(s) to a range of annex source
	 * @param offset the offset from the start of the source text to the start of the range
	 * @param length the length of the range
	 * @param id the id's of the style(s) to assign to the range
	 */
	void addPosition(int offset, int length, String... id);

	// Built-in styles
	public final static String COMMENT_ID = DefaultHighlightingConfiguration.COMMENT_ID;
	public final static String DEFAULT_ID = DefaultHighlightingConfiguration.DEFAULT_ID;
	public final static String INVALID_TOKEN_ID = DefaultHighlightingConfiguration.INVALID_TOKEN_ID;
	public final static String KEYWORD_ID = DefaultHighlightingConfiguration.KEYWORD_ID;
	public final static String NUMBER_ID = DefaultHighlightingConfiguration.NUMBER_ID;
	public final static String PUNCTUATION_ID = DefaultHighlightingConfiguration.PUNCTUATION_ID;
	public final static String STRING_ID = DefaultHighlightingConfiguration.STRING_ID;
}
