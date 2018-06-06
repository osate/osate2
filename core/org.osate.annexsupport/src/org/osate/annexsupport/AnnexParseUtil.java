package org.osate.annexsupport;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.diagnostics.Diagnostic;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.SyntaxErrorMessage;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.ParseResult;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;
import org.eclipse.xtext.resource.XtextSyntaxDiagnostic;
import org.osate.aadl2.modelsupport.errorreporting.AbstractParseErrorReporter;
import org.osate.aadl2.modelsupport.errorreporting.ParseErrorReporter;

public class AnnexParseUtil {

	private static Map<EObject, IParseResult> parseResults = new WeakHashMap<EObject, IParseResult>();

	public static EObject parse(AbstractAntlrParser parser, String editString, ParserRule parserRule, String filename,
			int line, int offset, ParseErrorReporter err) {

		try {
			editString = genWhitespace(offset) + editString;
			IParseResult parseResult = parser.parse(parserRule, new StringReader(editString));

			if (parseResult.getRootASTElement() != null) {
				parseResults.put(parseResult.getRootASTElement(), parseResult);
			}
			EObject result = null;
			if (isValidParseResult(parseResult)) {
				result = parseResult.getRootASTElement();
				return result;
			} else {
				createDiagnostics(parseResult, filename, err);
				result = parseResult.getRootASTElement();
				if (result != null) {
					return result;
				} else {
					return null;
				}
			}
		} catch (Exception exc) {
			return null;
		}
	}

	public static IParseResult getParseResult(EObject annexObject) {
		return parseResults.get(annexObject);
	}

	public static String genWhitespace(int length) {
		char[] array = new char[length];
		Arrays.fill(array, ' ');
		return new String(array);
	}

	public static boolean isValidParseResult(IParseResult parseResult) {
		EObject rootASTElement = parseResult.getRootASTElement();
		if (rootASTElement != null && !parseResult.hasSyntaxErrors()) {
			return true;
		}
		return false;
	}

	/**
	 * Creates {@link Diagnostic diagnostics} from {@link SyntaxError syntax errors} in {@link ParseResult}.
	 * No diagnostics will be created if {@link #isValidationDisabled() validation is disabled} for this
	 * resource.
	 *
	 * @param parseResult the parse result that provides the syntax errors.
	 * @return list of {@link Diagnostic}. Never <code>null</code>.
	 */
	public static void createDiagnostics(IParseResult parseResult, String filename, ParseErrorReporter err) {
		Resource res = null;
		if (err instanceof AbstractParseErrorReporter) {
			res = ((AbstractParseErrorReporter) err).getContextResource();
		}
		if (res != null) {
			List<Diagnostic> diagnostics = new ArrayList<Diagnostic>();
			for (INode error : parseResult.getSyntaxErrors()) {
				if (res == null) {
					SyntaxErrorMessage errormsg = error.getSyntaxErrorMessage();
					String msg = errormsg.getMessage();
					err.error(filename, error.getStartLine(), msg);
				} else {
					diagnostics.add(new XtextSyntaxDiagnostic(error));
				}
			}
			if (res != null) {
				res.getErrors().addAll(diagnostics);
			}
		} else {
			for (INode error : parseResult.getSyntaxErrors()) {
				SyntaxErrorMessage errormsg = error.getSyntaxErrorMessage();
				String msg = errormsg.getMessage();
				err.error(filename, error.getStartLine(), msg);
			}

		}
	}

}
