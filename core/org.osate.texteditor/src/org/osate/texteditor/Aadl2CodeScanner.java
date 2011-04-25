/*
 * <copyright>
 * Copyright  2007 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/legal/cpl-v10.html.
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
 * Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 * </copyright>
 */
package org.osate.texteditor;

import java.util.ArrayList;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.EndOfLineRule;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IWordDetector;
import org.eclipse.jface.text.rules.MultiLineRule;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.SingleLineRule;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.rules.WordRule;
import org.eclipse.swt.SWT;

public class Aadl2CodeScanner extends RuleBasedScanner
{
	private final static String[] KEYWORDS = new String[] {
		"aadlboolean",
		"aadlinteger",
		"aadlreal",
		"aadlstring",
		"abstract",
		"access",
		"all",
		"and",
		"annex",
		"applies",
		"binding",
		"bus",
		"calls",
		"classifier",
		"compute",
		"connections",
		"constant",
		"data",
		"delta",
		"device",
		"end",
		"enumeration",
		"event",
		"extends",
		"false",
		"feature",
		"features",
		"flow",
		"flows",
		"group",
		"implementation",
		"in",
		"inherit",
		"initial",
		"inverse",
		"is",
		"list",
		"memory",
		"mode",
		"modes",
		"none",
		"not",
		"of",
		"or",
		"out",
		"package",
		"parameter",
		"path",
		"port",
		"private",
		"process",
		"processor",
		"properties",
		"property",
		"prototypes",
		"provides",
		"public",
		"range",
		"record",
		"reference",
		"refined",
		"renames",
		"requires",
		"self",
		"set",
		"sink",
		"source",
		"subcomponents",
		"subprogram",
		"system",
		"thread",
		"to",
		"true",
		"type",
		"units",
		"virtual",
		"with"
	};
	
	public Aadl2CodeScanner()
	{
		Aadl2ColorProvider colorProvider = Activator.getDefault().getAadl2ColorProvider();
		
		Token commentToken = new Token(new TextAttribute(colorProvider.getColor(Aadl2ColorProvider.COMMENT)));
		Token stringToken = new Token(new TextAttribute(colorProvider.getColor(Aadl2ColorProvider.STRING)));
		Token keywordToken = new Token(new TextAttribute(colorProvider.getColor(Aadl2ColorProvider.KEYWORD),
				colorProvider.getColor(Aadl2ColorProvider.BACKGROUND), SWT.BOLD));
		Token defaultToken = new Token(new TextAttribute(colorProvider.getColor(Aadl2ColorProvider.DEFAULT)));
		
		ArrayList<IRule> rules = new ArrayList<IRule>();
		
		rules.add(new MultiLineRule("{**", "**}", defaultToken));
		rules.add(new EndOfLineRule("--", commentToken));
		rules.add(new SingleLineRule("\"", "\"", stringToken));
		
		WordRule wordRule = new WordRule(new Aadl2WordDetector(), defaultToken, true);
		for (String keyword : KEYWORDS)
			wordRule.addWord(keyword, keywordToken);
		rules.add(wordRule);
		
		setRules(rules.toArray(new IRule[rules.size()]));
	}
	
	private static class Aadl2WordDetector implements IWordDetector
	{
		@Override
		public boolean isWordStart(char c)
		{
			return Character.isJavaIdentifierPart(c);
		}
		
		@Override
		public boolean isWordPart(char c)
		{
			return Character.isJavaIdentifierPart(c);
		}
	}
}