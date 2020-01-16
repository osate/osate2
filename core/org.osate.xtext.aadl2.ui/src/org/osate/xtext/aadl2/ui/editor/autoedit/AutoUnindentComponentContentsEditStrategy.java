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
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.FeatureGroupType;
import org.osate.core.OsateCorePlugin;

import com.google.inject.Inject;
import com.google.inject.MembersInjector;

public class AutoUnindentComponentContentsEditStrategy extends AbstractTerminalsEditStrategy {

	@SuppressWarnings("unused")
	private final static Logger log = Logger.getLogger(AutoUnindentComponentContentsEditStrategy.class);

	private String indentationString;
	private IPreferenceStore store = OsateCorePlugin.getDefault().getPreferenceStore();

	private String[] contentCategories = { "prototypes", "features", "flows", "modes", "properties", "subcomponents",
			"connections", "calls" }; // , "annex" };
	private String[] containerStartingWords = { "abstract ", "bus ", "data ", "device ", "memory ", "process ",
			"processor ", "subprogram ", "system ", "thread ", "virtual ", "public ", "private " };

	public static class Factory {
		@Inject
		private MembersInjector<AutoUnindentComponentContentsEditStrategy> injector;
		@Inject
		private IIndentationInformation indentationInformation;

		public AutoUnindentComponentContentsEditStrategy newInstance(String terminal) {
			return newInstance(terminal, null);
		}

		public AutoUnindentComponentContentsEditStrategy newInstance(String terminal, String indentationString) {
			indentationString = indentationString == null ? indentationInformation.getIndentString()
					: indentationString;
			AutoUnindentComponentContentsEditStrategy strategy = new AutoUnindentComponentContentsEditStrategy(terminal,
					indentationString);
			injector.injectMembers(strategy);
			return strategy;
		}
	}

	public AutoUnindentComponentContentsEditStrategy(String terminal) {
		this(terminal, null);
	}

	public AutoUnindentComponentContentsEditStrategy(String terminal, String indentationString) {
		super(terminal, indentationString);
		this.indentationString = indentationString;
	}

	@Override
	protected void internalCustomizeDocumentCommand(IDocument document, DocumentCommand command)
			throws BadLocationException {

		if (!isLineDelimiter(document, command)) {
			return;
		}

		int lineNr = document.getLineOfOffset(command.offset);
		int firstOffsetOfLine = document.getLineOffset(lineNr);
		int lineLength = document.getLineLength(lineNr);
		String lineText = document.get(firstOffsetOfLine, lineLength);
		if (lineText.endsWith(System.lineSeparator())) {
			lineText = lineText.substring(0, lineText.indexOf(System.lineSeparator()));
		}
		String[] tokens = lineText.trim().split("\\s+");
		if (tokens.length < 1) {
			return;
		}

		boolean isContentWord = false;
		for (String nextContent : contentCategories) {
			if (nextContent.equalsIgnoreCase(tokens[0])) {
				isContentWord = true;
				break;
			}
		}
		if (!isContentWord) {
			return;
		}
		Classifier containingClassifier = null;
		if (document instanceof IXtextDocument) {
			IXtextDocument xDoc = (IXtextDocument) document;
			containingClassifier = xDoc.readOnly(resource -> {
				EObjectAtOffsetHelper helper = new EObjectAtOffsetHelper();
				EObject eobj = helper.resolveElementAt(resource, command.offset);
				if (eobj == null) {
					return null;
				} else if (eobj instanceof Classifier) {
					return (Classifier) eobj;
				}
				return null;
			});
		}
		if (containingClassifier == null) {
			return;
		}

		String textInLine = tokens[0];
		// Too many complications need figured out to handle annex at this point
//		if ("annex".equalsIgnoreCase(tokens[0])) {
//			textInLine = lineText.trim();
//		}

		String leadingString = getLeadingString(document, containingClassifier, lineNr);
		String targetString = leadingString + textInLine;
		document.replace(firstOffsetOfLine, document.getLineLength(lineNr), targetString);
		command.text = System.lineSeparator() + leadingString + (isAutoIndent() ? "\t" : "") + System.lineSeparator();
		command.caretOffset = firstOffsetOfLine + leadingString.length() + textInLine.length() + command.text.length()
				- System.lineSeparator().length();
		command.offset = firstOffsetOfLine + (leadingString + textInLine).length();
	}

	private String getLeadingString(IDocument document, Classifier containingClassifier, int lineNr)
			throws BadLocationException {
		String indent = "";
		if (isAutoIndentSections()) {
			indent = "\t";
		}
		for (int i = lineNr; i > -1; i--) {
			int nextLineOffset = document.getLineOffset(i);
			int nextLineLength = document.getLineLength(i);
			String line = document.get(nextLineOffset, nextLineLength);
			String trimmed = line.trim();
			String classifierType = "";

			if (containingClassifier == null) {
				for (int j = 0; j < containerStartingWords.length; j++) {
					if (trimmed.toLowerCase().startsWith(containerStartingWords[j])) {
						return line.substring(0, line.indexOf(trimmed)) + indent;
					}
				}
			}

			if (containingClassifier instanceof ComponentClassifier) {
				classifierType = ((ComponentClassifier) containingClassifier).getCategory().getName();
			} else if (containingClassifier instanceof FeatureGroupType) {
				classifierType = "feature group";
			}
			if (!classifierType.trim().equals("")) {
				if (line.trim().toLowerCase().startsWith(classifierType.toLowerCase())) {
					return line.substring(0, line.indexOf(trimmed)) + indent;
				}
			}
		}
		return "";
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

	protected boolean isAutoIndentSections() {
		return store.getBoolean(OsateCorePlugin.INDENT_SECTIONS);
	}

}
