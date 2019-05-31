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
