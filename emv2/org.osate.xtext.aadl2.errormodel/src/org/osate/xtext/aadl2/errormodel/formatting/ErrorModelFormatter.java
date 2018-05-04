/*
 * <copyright>
 * Copyright  2012 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/org/documents/epl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE ''DELIVERABLES'') ARE ON AN ''AS-IS'' BASIS.
 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
 * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
 * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE
 */
package org.osate.xtext.aadl2.errormodel.formatting;

import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.formatting.impl.AbstractDeclarativeFormatter;
import org.eclipse.xtext.formatting.impl.FormattingConfig;
import org.eclipse.xtext.util.Pair;
import org.osate.xtext.aadl2.errormodel.services.ErrorModelGrammarAccess;

/**
 * This class contains custom formatting description.
 *
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#formatting
 * on how and when to use it
 *
 * Also see {@link org.eclipse.xtext.xtext.XtextFormattingTokenSerializer} as an example
 */
public class ErrorModelFormatter extends AbstractDeclarativeFormatter {

	@Override
	protected void configureFormatting(FormattingConfig c) {

		ErrorModelGrammarAccess f = (ErrorModelGrammarAccess) getGrammarAccess();
		c.setAutoLinewrap(120);
		for (Pair<Keyword, Keyword> pair : f.findKeywordPairs("(", ")")) {
			c.setNoSpace().after(pair.getFirst());
			c.setNoSpace().before(pair.getSecond());
		}
		for (Pair<Keyword, Keyword> pair : f.findKeywordPairs("[", "]")) {
			c.setNoSpace().after(pair.getFirst());
			c.setNoSpace().before(pair.getSecond());
		}
		for (Pair<Keyword, Keyword> pair : f.findKeywordPairs("{", "}")) {
			c.setIndentationIncrement().after(pair.getFirst());
			c.setLinewrap().after(pair.getFirst());
			c.setIndentationDecrement().before(pair.getSecond());
			c.setLinewrap().before(pair.getSecond());
		}
		for (Pair<Keyword, Keyword> pair : f.findKeywordPairs("error_model {**", "**}")) {
			c.setIndentationIncrement().after(pair.getFirst());
			c.setLinewrap().after(pair.getFirst());
			c.setIndentationDecrement().before(pair.getSecond());
			c.setLinewrap().before(pair.getSecond());
		}

		for (Keyword comma : f.findKeywords(",")) {
			c.setNoSpace().before(comma);
		}
		for (Keyword semi : f.findKeywords(";")) {
			c.setLinewrap().after(semi);
		}
		for (Keyword dot : f.findKeywords(".")) {
			c.setNoSpace().around(dot);
		}
		for (Keyword doublecolon : f.findKeywords("::")) {
			c.setNoSpace().around(doublecolon);
		}
		for (Keyword fea : f.findKeywords("conditions")) {
			c.setLinewrap().after(fea);
			c.setIndentationDecrement().before(fea);
			c.setIndentationIncrement().after(fea);
		}
		for (Keyword fea : f.findKeywords("states")) {
			c.setLinewrap().around(fea);
			c.setIndentationDecrement().before(fea);
			c.setIndentationIncrement().after(fea);
		}
		for (Keyword fea : f.findKeywords("events")) {
			c.setLinewrap().around(fea);
			c.setIndentationDecrement().before(fea);
			c.setIndentationIncrement().after(fea);
		}
		for (Keyword fea : f.findKeywords("transitions")) {
			c.setLinewrap().around(fea);
			c.setIndentationDecrement().before(fea);
			c.setIndentationIncrement().after(fea);
		}
		for (Keyword fea : f.findKeywords("properties")) {
			c.setLinewrap().around(fea);
			c.setIndentationDecrement().before(fea);
			c.setIndentationIncrement().after(fea);
		}
		for (Keyword end : f.findKeywords("end")) {
			c.setIndentationDecrement().before(end);
			c.setLinewrap().before(end);
		}
		c.setIndentationIncrement().after(f.getErrorTypesKeywordsAccess().getTypesKeyword_1());
		c.setLinewrap().after(f.getErrorTypesKeywordsAccess().getTypesKeyword_1());
		c.setIndentationIncrement().after(f.getErrorBehaviorKeywordsAccess().getBehaviorKeyword_1());
//	      c.setLinewrap().after(f.getErrorBehaviorStateMachineAccess().getBehaviorKeyword_1());

//	      c.setLinewrap().after(f.getErrorPropagationsAccess().getPropagationsKeyword_1());
//	      c.setIndentationIncrement().after(f.getErrorPropagationsAccess().getPropagationsKeyword_1());
//	      c.setLinewrap().after(f.getComponentErrorBehaviorAccess().getBehaviorKeyword_2());
//	      c.setIndentationIncrement().after(f.getComponentErrorBehaviorAccess().getBehaviorKeyword_2());
//	      c.setLinewrap().after(f.getCompositeErrorBehaviorAccess().getBehaviorKeyword_2());
//	      c.setIndentationIncrement().after(f.getCompositeErrorBehaviorAccess().getBehaviorKeyword_2());

		// It's usually a good idea to activate the following three statements.
// They will add and preserve newlines around comments
//		c.setLinewrap(0, 1, 2).before(getGrammarAccess().getSL_COMMENTRule());
//		c.setLinewrap(0, 1, 2).before(getGrammarAccess().getML_COMMENTRule());
//		c.setLinewrap(0, 1, 1).after(getGrammarAccess().getML_COMMENTRule());
	}
}
