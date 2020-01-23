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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DocumentCommand;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.TextUtilities;
import org.eclipse.xtext.formatting.IIndentationInformation;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.ui.editor.autoedit.AbstractTerminalsEditStrategy;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.NamedElement;
import org.osate.core.OsateCorePlugin;

import com.google.inject.Inject;
import com.google.inject.MembersInjector;

/**
 * This strategy applies auto edits when typing a newline character after a keyword.
 *
 * @author Lutz Wrage
 */
public class AutoUnindentEditStrategy extends AbstractTerminalsEditStrategy {

	public static class Factory {
		@Inject
		private MembersInjector<AutoUnindentEditStrategy> injector;
		@Inject
		private IIndentationInformation indentationInformation;

		public AutoUnindentEditStrategy newInstance(String terminal) {
			return newInstance(terminal, null);
		}

		public AutoUnindentEditStrategy newInstance(String terminal, String indentationString) {
			indentationString = indentationString == null ? indentationInformation.getIndentString()
					: indentationString;
			AutoUnindentEditStrategy strategy = new AutoUnindentEditStrategy(terminal, indentationString);
			injector.injectMembers(strategy);
			return strategy;
		}
	}

	@SuppressWarnings("unused")
	private final static Logger log = Logger.getLogger(AutoUnindentEditStrategy.class);

	private String indentationString;
	private IPreferenceStore store = OsateCorePlugin.getDefault().getPreferenceStore();

	public AutoUnindentEditStrategy(String terminal) {
		this(terminal, null);
	}

	public AutoUnindentEditStrategy(String terminal, String indentationString) {
		super(terminal, terminal);
		this.indentationString = indentationString;
	}

	@Override
	protected boolean allowsEqualTerminals() {
		return true;
	}

	private String findKeyWord(String[] tokens) {
		String keyword = "";
		if (tokens[0].equalsIgnoreCase("feature") && tokens[1].equalsIgnoreCase("group")) {
			keyword = tokens[0] + " " + tokens[1];
		} else if (tokens[0].equalsIgnoreCase("package")) {
			keyword = tokens[0];
		} else if (tokens[0].equalsIgnoreCase("property") && tokens[1].equalsIgnoreCase("set")) {
			keyword = "property set";
		} else if (ComponentCategory.getByName((tokens[0] + " " + tokens[1]).toLowerCase()) != null) {
			keyword = tokens[0] + " " + tokens[1];
		} else if (ComponentCategory.getByName(tokens[0].toLowerCase()) != null) {
			keyword = tokens[0];
		}
		return keyword;
	}

	private String findElementId(String[] tokens, String keyword) {
		String elementId = tokens[tokens.length - 1];
		for (int i = 0; i < tokens.length; i++) {
			if (tokens[i].equalsIgnoreCase("extends")) {
				elementId = tokens[i - 1];
			} else if (keyword.equalsIgnoreCase("property set") && tokens[i].equalsIgnoreCase("is")) {
				elementId = tokens[i - 1];
			}
		}
		return elementId;
	}

	private boolean checkForExistingEnd(String endWord, boolean hasExtends, String docText, String elementId,
			NamedElement namedElement, String keyword, String[] tokens, int lineOffset) {

		docText = docText.substring(lineOffset);
		String endName = " " + endWord + " ";
		if (hasExtends) {
			endName = endName + elementId;
		} else if (namedElement != null) {
			endName = endName + namedElement.getName().toLowerCase();
		} else {
			if (keyword.equals("property set")) {
				endName = endName + tokens[tokens.length - 2];
			} else {
				endName = endName + tokens[tokens.length - 1];
			}
		}
		docText = docText.replaceAll("--.*?" + System.lineSeparator(), System.lineSeparator());
		docText = docText.toLowerCase().replaceAll("\\s+", " ");
		int possibleEndIndex = docText.toLowerCase().indexOf(endName.toLowerCase());

		if (possibleEndIndex > -1) {
			int possibleEndEnd = possibleEndIndex + endName.length();
			for (int i = 0; possibleEndEnd + i < docText.length(); i++) {
				String possibleEnd = docText.toLowerCase().substring(possibleEndIndex, possibleEndEnd + i);
				if (possibleEnd.endsWith(";") || Character.isWhitespace(possibleEnd.charAt(possibleEnd.length() - 1))) {
					return true;
				} else if (!possibleEnd.equalsIgnoreCase(endName)) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	@Override
	protected void internalCustomizeDocumentCommand(IDocument document, DocumentCommand command)
			throws BadLocationException {

		if (!isAutoComplete() || !isLineDelimiter(document, command)) {
			return;
		}
		String publicWord = isUseCapitalization() ? "PUBLIC" + System.lineSeparator() + "\t" : "public";
		String endWord = isUseCapitalization() ? "END" : "end";
		int lineNr = document.getLineOfOffset(command.offset);
		int firstOffsetOfLine = document.getLineOffset(lineNr);
		int lineLength = document.getLineLength(lineNr);
		String lineText = document.get(firstOffsetOfLine, lineLength);
		String[] tokens = lineText.trim().split("\\s+");
		if (tokens.length < 2) {
			return;
		}
		String keyword = findKeyWord(tokens);
		boolean hasExtends = false;
		for (int i = 0; i < tokens.length; i++) {
			if (tokens[i].equalsIgnoreCase("extends")) {
				hasExtends = true;
			}
		}

		NamedElement namedElement = null;
		if (keyword.equals("")) {
			namedElement = null;
			if (document instanceof IXtextDocument) {
				IXtextDocument xDoc = (IXtextDocument) document;
				namedElement = xDoc.readOnly(resource -> {
					EObjectAtOffsetHelper helper = new EObjectAtOffsetHelper();
					EObject eobj = helper.resolveElementAt(resource, command.offset);
					if (eobj == null) {
						return null;
					} else if (eobj instanceof Classifier || eobj instanceof AadlPackage) {
						return (NamedElement) eobj;
					}
					return null;
				});
			}
		}
		String elementId = findElementId(tokens, keyword);

		if (namedElement == null && keyword.equals("") && !hasExtends) {
			return;
		} else if (checkForExistingEnd(endWord, hasExtends, document.get(), elementId, namedElement, keyword, tokens,
				firstOffsetOfLine)) {
			return;
		}

		if (ComponentCategory.getByName(elementId.toLowerCase()) != null) {
			return;
		}
		if (keyword == null || keyword.equals("") || elementId == null || elementId.equals("")) {
			return;
		}

		int firstTokenIndex = lineText.indexOf(tokens[0]);
		String leadingString = lineText.substring(0, firstTokenIndex);
		String indent = "";
		String targetString = "";
		if (keyword.equalsIgnoreCase("package")) {
			if (lineText.endsWith(System.lineSeparator())) {
				lineText = lineText.substring(0, lineText.indexOf(System.lineSeparator()));
			}
		} else if (keyword.equalsIgnoreCase("property set")) {
			if (lineText.endsWith(System.lineSeparator())) {
				lineText = lineText.substring(0, lineText.indexOf(System.lineSeparator()));
			}
			if (isAutoIndent()) {
				indent = "\t";
			}
		}

		targetString = buildTargetString(lineText, leadingString, endWord, elementId, keyword, publicWord, indent);

		if (keyword.equalsIgnoreCase("package")) {
			if (isUseCapitalization()) {
				command.text = "";
			}
			command.offset = command.offset + (System.lineSeparator() + leadingString + publicWord).length();
		} else if (keyword.equalsIgnoreCase("property set")) {
			command.offset = command.offset + (System.lineSeparator() + leadingString + indent).length();
			command.text = "";
		}
		document.replace(firstOffsetOfLine, lineText.length(), targetString);
	}

	private String buildTargetString(String lineText, String leadingString, String endWord, String elementId,
			String keyword, String publicWord, String indent) {
		StringBuilder targetStringBuilder = new StringBuilder();

		targetStringBuilder.append(lineText);

		if (keyword.equalsIgnoreCase("package")) {
			targetStringBuilder.append(System.lineSeparator());
			targetStringBuilder.append(leadingString);
			targetStringBuilder.append(publicWord);
			targetStringBuilder.append(System.lineSeparator());
		} else if (keyword.equalsIgnoreCase("property set")) {
			targetStringBuilder.append(System.lineSeparator());
			targetStringBuilder.append(leadingString);
			targetStringBuilder.append(indent);
			targetStringBuilder.append(System.lineSeparator());
		}

		targetStringBuilder.append(leadingString);
		targetStringBuilder.append(endWord);
		targetStringBuilder.append(" ");
		targetStringBuilder.append(elementId);
		targetStringBuilder.append(";");
		if ((!keyword.equalsIgnoreCase("package") && !keyword.equalsIgnoreCase("property set"))
				|| (keyword.equalsIgnoreCase("package") && (!isUseCapitalization()))) {
			targetStringBuilder.append(System.lineSeparator());
		}
		return targetStringBuilder.toString();
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

	protected boolean isAutoComplete() {
		return store.getBoolean(OsateCorePlugin.AUTO_COMPLETE);
	}

	protected boolean isAutoIndent() {
		return store.getBoolean(OsateCorePlugin.AUTO_INDENT);
	}

	protected boolean isUseCapitalization() {
		return store.getBoolean(OsateCorePlugin.CAPITALIZE);
	}

}