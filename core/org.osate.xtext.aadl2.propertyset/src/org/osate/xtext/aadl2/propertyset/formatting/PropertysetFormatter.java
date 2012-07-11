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
package org.osate.xtext.aadl2.propertyset.formatting;

import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.formatting.impl.AbstractDeclarativeFormatter;
import org.eclipse.xtext.formatting.impl.FormattingConfig;
import org.eclipse.xtext.util.Pair;

/**
 * This class contains custom formatting description.
 *
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#formatting
 * on how and when to use it
 *
 * Also see {@link org.eclipse.xtext.xtext.XtextFormattingTokenSerializer} as an example
 */
public class PropertysetFormatter extends AbstractDeclarativeFormatter {

	@Override
	protected void configureFormatting(FormattingConfig c) {
		org.osate.xtext.aadl2.propertyset.services.PropertysetGrammarAccess f = (org.osate.xtext.aadl2.propertyset.services.PropertysetGrammarAccess) getGrammarAccess();
	    c.setAutoLinewrap(120);

	    // find common keywords an specify formatting for them
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
	    for (Keyword is : f.findKeywords("is")) {
		      c.setIndentationIncrement().after(is);
		      c.setLinewrap().after(is);
		    }
	    for (Keyword applies : f.findKeywords("applies")) {
		      c.setIndentationIncrement().before(applies);
		      c.setLinewrap().before(applies);
		      c.setIndentationDecrement().after(applies);
		    }
		c.setLinewrap(0, 1, 2).before(f.getSL_COMMENTRule());
	}
}
