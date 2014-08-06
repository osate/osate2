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
package org.osate.xtext.aadl2.unparsing;

import org.osate.aadl2.modelsupport.AadlConstants;

/**
 * This class provides a text buffer into which text can be placed that is formatted with indentation.
 * Appropriate methods are provided for increasing and decreasing indentation.
 * Indentation is automatically taken into account by the addOutput and addOutputNewline methods.
 */
public class UnparseText {
	public static final String copyright = "Copyright 2004 by Carnegie Mellon University, all rights reserved";

	/**
	 * Indentation count & string
	 * didIndent indicates whether indentation needs to be added
	 */
	private int indentCount = 0;
	private String indentString = "";
	private boolean didIndent = true;
	private boolean DEBUG = false;

	private static final String indentIncrement = "  ";

	private StringBuffer textOutput;

	private int lineCount = 1;

	private boolean countOnly = false;

	/**
	 * constructor for an UnparseText object
	 *
	 */
	public UnparseText() {
		indentCount = 0;
		indentString = "";
		textOutput = new StringBuffer();
		lineCount = 1;
		countOnly = false;
	}

	/**
	 * constructor for an UnparseText object
	 * The doCount parameter indicates whether to only keep track of line numbers or actually build up a string buffer
	 * @param doCountOnly boolean
	 */
	public UnparseText(boolean doCountOnly) {
		indentCount = 0;
		indentString = "";
		textOutput = new StringBuffer();
		lineCount = 1;
		countOnly = doCountOnly;
	}

	/**
	 * constructor for an UnparseText object
	 * The doCount parameter indicates whether to only keep track of line numbers or actually build up a string buffer
	 * @param tab initial white space
	 */
	public UnparseText(String tab) {
		indentCount = 0;
		indentString = tab;
		textOutput = new StringBuffer();
		lineCount = 1;
		countOnly = false;
	}

	/**
	 * Set debug to true. Results in printing of output as it is generated
	 *
	 */
	public void setDebug() {
		DEBUG = true;
	}

	/**
	 * increment indentation
	 */
	public void incrementIndent() {
		indentCount++;
		indentString = indentString + indentIncrement;
	}

	/**
	 * decrement indentation
	 */
	public void decrementIndent() {
		if (indentCount > 0) {
			indentCount--;
			indentString = indentString.substring(0, indentString.length() - indentIncrement.length());
		}
	}

	/**
	 * @return Returns the indentString.
	 */
	public String getIndentString() {
		return indentString;
	}

	/**
	 * returns the generated unparse string
	 * @return String
	 */
	public String getParseOutput() {
		return textOutput.toString();
	}

	/**
	 * return the line count
	 * @return int
	 */
	public int getLineCount() {
		return lineCount;
	}

	/**
	 * add a string to the current line of the output
	 * @param more String to be added
	 */
	public void addOutput(String more) {
		if (more == null || countOnly) {
			return;
		}
		if (!didIndent) {
			textOutput.append(indentString + more);
			didIndent = true;
		} else {
			textOutput.append(more);
		}
		if (DEBUG) {
			System.out.println(more);
		}
	}

	/**
	 * Add string to output and end with a new line
	 * @param more String to be added
	 */
	public void addOutputNewline(String more) {
		if (more == null) {
			return;
		}
		lineCount++;
		if (countOnly) {
			return;
		}
		if (!didIndent) {
			textOutput.append(indentString);
		}
		textOutput = textOutput.append(more + AadlConstants.newlineChar);
		didIndent = false;
		if (DEBUG) {
			System.out.println(more);
		}
	}

}
