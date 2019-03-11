package org.osate.annexsupport;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
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

	private static Map<String, IParseResult> parseResults = Collections
			.synchronizedMap(new HashMap<String, IParseResult>());

	/* Use ThreadLocal in case we use parallel build in the future */
	private static ThreadLocal<IParseResult> lastParseResult = new ThreadLocal<IParseResult>();

	/**
	 * Parse an annex.
	 * Note: After parsing the returned element must be added to a default annex library/subclause
	 * object and saveParceResult must be called. Various functionality depends on being able to
	 * retrieve the parse result given an annex library/subclause.
	 *
	 * @param parser
	 * @param editString
	 * @param parserRule
	 * @param filename
	 * @param line
	 * @param offset
	 * @param err
	 * @return
	 */
	public static EObject parse(AbstractAntlrParser parser, String editString, ParserRule parserRule, String filename,
			int line, int offset, ParseErrorReporter err) {

		try {
			editString = genWhitespace(offset) + editString;
			IParseResult parseResult = parser.parse(parserRule, new StringReader(editString));

			if (parseResult.getRootASTElement() != null) {
				lastParseResult.set(parseResult);
				if (parseResult.hasSyntaxErrors()) {
					createDiagnostics(parseResult, filename, err);
				}
			}
			return parseResult.getRootASTElement();
		} catch (Exception exc) {
			return null;
		}
	}

	public static IParseResult getParseResult(EObject annexObject) {
		EObject defaultAnnexObject = annexObject.eContainer();
		URI uri = EcoreUtil.getURI(defaultAnnexObject);
		return parseResults.get(uri.toString());
	}

	/**
	 * This method must be called after parsing with the DefaultAnnexLibrary or
	 * DefaultAnnexSubclasue that contains the parsed annex library/subclause.
	 *
	 * @param defaultAnnexObject
	 * @return
	 */
	public static IParseResult saveParseResult(EObject defaultAnnexObject) {
		URI uri = EcoreUtil.getURI(defaultAnnexObject);
		return parseResults.put(uri.toString(), lastParseResult.get());
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
