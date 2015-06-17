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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DocumentCommand;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.TextUtilities;
import org.eclipse.xtext.formatting.IIndentationInformation;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.autoedit.AbstractTerminalsEditStrategy;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.NamedElement;
import org.osate.workspace.WorkspacePlugin;

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
	private IPreferenceStore store = WorkspacePlugin.getDefault().getPreferenceStore();

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
		String keyword = "";
		if (tokens.length < 2) {
			return;
		}
		if (tokens[0].equalsIgnoreCase("package")) {
			keyword = "package";
		}

		NamedElement namedElement = null;
		if (keyword.equals("")) {
			namedElement = null;
			if (document instanceof IXtextDocument) {
				IXtextDocument xDoc = (IXtextDocument) document;
				namedElement = xDoc.readOnly(new IUnitOfWork<NamedElement, XtextResource>() {
					@Override
					public NamedElement exec(XtextResource resource) throws Exception {
						EObjectAtOffsetHelper helper = new EObjectAtOffsetHelper();
						EObject eobj = helper.resolveElementAt(resource, command.offset);
						if (eobj == null) {
							return null;
						} else if (eobj instanceof Classifier || eobj instanceof AadlPackage) {
							return (NamedElement) eobj;
						}
						return null;
					}
				});
			}
		}
		if (namedElement == null && keyword.equals("")) {
			return;
		} else {
			String endName = " " + endWord + " ";
			if (namedElement != null) {
				endName = endName + namedElement.getName().toLowerCase();
			} else {
				endName = endName + tokens[tokens.length - 1];
			}

			String docText = document.get();
			docText = docText.replaceAll("--.*?" + System.lineSeparator(), System.lineSeparator());
			docText = docText.toLowerCase().replaceAll("\\s+", " ");
			if (docText.toLowerCase().indexOf(endName.toLowerCase()) > -1) {
				return;
			}
		}

		String elementId = tokens[tokens.length - 1];
		if (ComponentCategory.getByName(elementId.toLowerCase()) != null) {
			return;
		}

		if (tokens[0].equalsIgnoreCase("feature") && tokens[1].equalsIgnoreCase("group")) {
			keyword = tokens[0] + " " + tokens[1];
		} else if (tokens[0].equalsIgnoreCase("package")) {
			keyword = tokens[0];
		} else if (ComponentCategory.getByName((tokens[0] + " " + tokens[1]).toLowerCase()) != null) {
			keyword = tokens[0] + " " + tokens[1];
		} else if (ComponentCategory.getByName(tokens[0].toLowerCase()) != null) {
			keyword = tokens[0];
		}

		if (keyword == null || keyword.equals("") || elementId == null || elementId.equals("")) {
			return;
		}

		int firstTokenIndex = lineText.indexOf(tokens[0]);
		String leadingString = lineText.substring(0, firstTokenIndex);
		String targetString = lineText + leadingString + endWord + " " + elementId + ";" + System.lineSeparator();
		if (keyword.equalsIgnoreCase("package")) {
			if (lineText.endsWith(System.lineSeparator())) {
				lineText = lineText.substring(0, lineText.indexOf(System.lineSeparator()));
			}

			if (isUseCapitalization()) {
				targetString = lineText + System.lineSeparator() + leadingString + publicWord + System.lineSeparator()
						+ leadingString + endWord + " " + elementId + ";";
				document.replace(firstOffsetOfLine, lineText.length(), targetString);
				command.text = "";
				command.offset = command.offset + (System.lineSeparator() + leadingString + publicWord).length();
			} else {
				targetString = lineText + System.lineSeparator() + leadingString + publicWord + System.lineSeparator()
						+ leadingString + endWord + " " + elementId + ";" + System.lineSeparator();
				document.replace(firstOffsetOfLine, lineText.length(), targetString);
				command.offset = command.offset + (System.lineSeparator() + leadingString + publicWord).length();
			}
			return;
		}
		document.replace(firstOffsetOfLine, lineText.length(), targetString);
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
		return store.getBoolean(WorkspacePlugin.AUTO_COMPLETE);
	}

	protected boolean isUseCapitalization() {
		return store.getBoolean(WorkspacePlugin.CAPITALIZE);
	}

}