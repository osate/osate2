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
package org.osate.aadl2.modelsupport;

/**
 * This class provides a text buffer into which text can be placed that is formatted with indentation.
 * Appropriate methods are provided for increasing and decreasing indentation.
 * Indentation is automatically taken into account by the addOutput and addOutputNewline methods.
 */
public class UnparseText {
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
