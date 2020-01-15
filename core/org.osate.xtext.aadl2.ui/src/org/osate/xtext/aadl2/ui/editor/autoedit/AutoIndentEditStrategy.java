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
package org.osate.xtext.aadl2.ui.editor.autoedit;

import org.apache.log4j.Logger;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DocumentCommand;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.TextUtilities;
import org.eclipse.xtext.formatting.IIndentationInformation;
import org.eclipse.xtext.ui.editor.autoedit.AbstractTerminalsEditStrategy;
import org.eclipse.xtext.ui.editor.autoedit.CommandInfo;
import org.osate.core.OsateCorePlugin;

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

	private String indentationString;
	private IPreferenceStore store = OsateCorePlugin.getDefault().getPreferenceStore();

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
			IRegion startTerminal = util.searchBackwardsInSamePartition(getLeftTerminal(), document, command.offset);
			if (startTerminal == null || !atBeginningOfLineInput(document, startTerminal.getOffset())) {
				return;
			}
			if (util.isSameLine(document, startTerminal.getOffset(), command.offset)) {
				CommandInfo newC = handleCursorInFirstLine(document, command, startTerminal);
				if (newC != null) {
					newC.modifyCommand(command);
				}
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

	protected CommandInfo handleCursorInFirstLine(IDocument document, DocumentCommand command, IRegion startTerminal)
			throws BadLocationException {
		CommandInfo newC = new CommandInfo();
		newC.isChange = true;
		newC.offset = command.offset;
		newC.text += command.text + getAutoIndentString();
		newC.cursorOffset = command.offset + newC.text.length();
		return newC;
	}

	protected String getAutoIndentString() {
		if (store.getBoolean(OsateCorePlugin.AUTO_INDENT)) {
			return indentationString;
		}
		return "";
	}

	/**
	 * determines whether the given offset is at the beginning of the input in the line. leading whitespace is disregarded.
	 */
	private boolean atBeginningOfLineInput(IDocument document, int offset) throws BadLocationException {
		IRegion line = document.getLineInformation(document.getLineOfOffset(offset));
		return document.get(line.getOffset(), offset - line.getOffset()).trim().length() == 0;
	}

}