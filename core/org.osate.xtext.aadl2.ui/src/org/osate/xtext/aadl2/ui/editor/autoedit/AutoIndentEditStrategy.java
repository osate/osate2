/*
 * <copyright>
 * Copyright  2014 by Carnegie Mellon University, all rights reserved.
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
package org.osate.xtext.aadl2.ui.editor.autoedit;

import org.apache.log4j.Logger;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DocumentCommand;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.TextUtilities;
import org.eclipse.xtext.formatting.IIndentationInformation;
import org.eclipse.xtext.ui.editor.autoedit.AbstractTerminalsEditStrategy;
import org.eclipse.xtext.ui.editor.autoedit.CommandInfo;
import org.eclipse.xtext.util.Strings;

import com.google.inject.Inject;
import com.google.inject.MembersInjector;

/**
 * This strategy applies auto edits when typing a newline character after a keyword.
 * 
 * @author Lutz Wrage
 */
public class AutoIndentEditStrategy extends AbstractTerminalsEditStrategy {

	public static class Factory {
		@Inject
		private MembersInjector<AutoIndentEditStrategy> injector;
		@Inject
		private IIndentationInformation indentationInformation;;

		public AutoIndentEditStrategy newInstance(String terminal) {
			return newInstance(terminal, null);
		}

		public AutoIndentEditStrategy newInstance(String terminal, String indentationString) {
			indentationString = indentationString == null ? indentationInformation.getIndentString()
					: indentationString;
			AutoIndentEditStrategy strategy = new AutoIndentEditStrategy(terminal, indentationString);
			injector.injectMembers(strategy);
			return strategy;
		}
	}

	@SuppressWarnings("unused")
	private final static Logger log = Logger.getLogger(AutoIndentEditStrategy.class);

	/**	
	 * <p>Whether the pair of terminals can be nested or not.</p>
	 * */
	private final boolean nested = true;

	private String indentationString;

	public AutoIndentEditStrategy(String terminal) {
		this(terminal, null);
	}

	public AutoIndentEditStrategy(String terminal, String indentationString) {
		super(terminal, terminal);
		this.indentationString = indentationString;
	}

	@Override
	protected boolean allowsEqualTerminals() {
		return true;
	}

	@Override
	protected void internalCustomizeDocumentCommand(IDocument document, DocumentCommand command)
			throws BadLocationException {
		if (isLineDelimiter(document, command)) {
			IRegion startTerminal = findStartTerminal(document, command.offset);
			if (startTerminal == null)
				return;
			IRegion stopTerminal = findStopTerminal(document, command.offset);
			// check whether this is our stop terminal
			if (stopTerminal != null && nested) {
				IRegion previousStart = startTerminal;
				IRegion previousStop = stopTerminal;
				while (stopTerminal != null && previousStart != null && previousStop != null) {
					previousStart = findStartTerminal(document, previousStart.getOffset());
					if (previousStart != null) {
						previousStop = findStopTerminal(document, previousStop.getOffset() + 1);
						if (previousStop == null) {
							stopTerminal = null;
						}
					}
				}
			}
			if (util.isSameLine(document, startTerminal.getOffset(), command.offset)) {
				if (stopTerminal != null && stopTerminal.getLength() < getRightTerminal().length())
					stopTerminal = null;
				CommandInfo newC = handleCursorInFirstLine(document, command, startTerminal, stopTerminal);
				if (newC != null)
					newC.modifyCommand(command);
				return;
			} else if (stopTerminal == null) {
				CommandInfo newC = handleNoStopTerminal(document, command, startTerminal, stopTerminal);
				if (newC != null)
					newC.modifyCommand(command);
				return;
			} else if (!util.isSameLine(document, stopTerminal.getOffset(), command.offset)) {
				CommandInfo newC = handleCursorBetweenStartAndStopLine(document, command, startTerminal, stopTerminal);
				if (newC != null)
					newC.modifyCommand(command);
				return;
			} else {
				CommandInfo newC = handleCursorInStopLine(document, command, startTerminal, stopTerminal);
				if (newC != null)
					newC.modifyCommand(command);
				return;
			}
		}
	}

	private boolean isLineDelimiter(IDocument document, DocumentCommand command) {
		if (command.length != 0) {
			return false;
		}
		String originalText = command.text;
		String[] lineDelimiters = document.getLegalLineDelimiters();
		int delimiterIndex = TextUtilities.startsWith(lineDelimiters, originalText);
		return delimiterIndex != -1 && originalText.trim().length() == 0;
	}

	/**
	 * Expects the cursor to be in the same line as the start terminal
	 * puts any text between start terminal and cursor into a separate newline before the cursor.
	 * puts any text between cursor and end terminal into a separate newline after the cursor.
	 * puts the closing terminal into a separate line at the end.
	 * adds a closing terminal if not existent.
	 */
	protected CommandInfo handleCursorInFirstLine(IDocument document, DocumentCommand command, IRegion startTerminal,
			IRegion stopTerminal) throws BadLocationException {
		CommandInfo newC = new CommandInfo();
		newC.isChange = true;
		newC.offset = command.offset;
		newC.text += command.text + indentationString;
		newC.cursorOffset = command.offset + newC.text.length();
		if (stopTerminal == null && atEndOfLineInput(document, command.offset)) {
			newC.text += command.text + getRightTerminal();
		}
		if (stopTerminal != null && stopTerminal.getOffset() >= command.offset
				&& util.isSameLine(document, stopTerminal.getOffset(), command.offset)) {
			String string = document.get(command.offset, stopTerminal.getOffset() - command.offset);
			if (string.trim().length() > 0)
				newC.text += string.trim();
			newC.text += command.text;
			newC.length += string.length();
		}
		return newC;
	}

	/**
	 * Expects the cursor not to be in the first line of the block
	 * inserts a closing terminal if not existent.
	 */
	protected CommandInfo handleNoStopTerminal(IDocument document, DocumentCommand command, IRegion startTerminal,
			IRegion stopTerminal) throws BadLocationException {
		if (atEndOfLineInput(document, command.offset)) {
			CommandInfo newC = new CommandInfo();
			newC.isChange = true;
			String textPartBeforeCursor = command.text + Strings.removeLeadingWhitespace(indentationString);
			newC.cursorOffset = command.offset + textPartBeforeCursor.length();
			newC.text = textPartBeforeCursor + command.text + Strings.removeLeadingWhitespace(getRightTerminal());
			return newC;
		}
		return null;
	}

	/**
	 * adds a new line with required indentation after the cursor.
	 */
	protected CommandInfo handleCursorBetweenStartAndStopLine(IDocument document, DocumentCommand command,
			IRegion startTerminal, IRegion stopTerminal) throws BadLocationException {
		if (indentationString.trim().length() > 0 && !atBeginningOfLineInput(document, command.offset)) {
			CommandInfo newC = new CommandInfo();
			newC.isChange = true;
			newC.text += command.text + Strings.removeLeadingWhitespace(indentationString);
			return newC;
		}
		return null;
	}

	/**
	 * delegates to {@link #handleCursorBetweenStartAndStopLine(IDocument, DocumentCommand, IRegion, IRegion)}.
	 */
	protected CommandInfo handleCursorInStopLine(IDocument document, DocumentCommand command, IRegion startTerminal,
			IRegion stopTerminal) throws BadLocationException {
		return handleCursorBetweenStartAndStopLine(document, command, startTerminal, stopTerminal);
	}

	/**
	 * determines whether the given offset is at the beginning of the input in the line. leading whitespace is disregarded.
	 */
	private boolean atBeginningOfLineInput(IDocument document, int offset) throws BadLocationException {
		IRegion line = document.getLineInformation(document.getLineOfOffset(offset));
		return document.get(line.getOffset(), offset - line.getOffset()).trim().length() == 0;
	}

	/**
	 * determines whether the given offset is at the end of the input in the line. trailing whitespace is disregarded.
	 */
	protected boolean atEndOfLineInput(IDocument document, int offset) throws BadLocationException {
		IRegion line = document.getLineInformation(document.getLineOfOffset(offset));
		return document.get(offset, line.getOffset() + line.getLength() - offset).trim().length() == 0;
	}

}