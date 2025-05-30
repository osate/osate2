/**
 * Copyright (c) 2004-2025 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.annexsupport;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
			editString = genWhitespace(line, offset) + editString;
			IParseResult parseResult = parser.parse(parserRule, new StringReader(editString));
			ParseResultHolder parseResultHolder = ParseResultHolder.Factory.INSTANCE
					.adapt(parseResult.getRootASTElement());
			parseResultHolder.setParseResult(parseResult);

			if (parseResult.getRootASTElement() != null) {
				if (parseResult.hasSyntaxErrors()) {
					createDiagnostics(parseResult, filename, err);
				}
			}
			return parseResult.getRootASTElement();
		} catch (Exception exc) {
			AnnexPlugin.logError(exc);
			return null;
		}
	}

	private static String genWhitespace(int line, int length) {
		char[] array = new char[length];
		Arrays.fill(array, ' ');
		if (line > 0) {
			if (line > length) {
				line = length;
			}
			Arrays.fill(array, 0, line - 1, '\n');
		}
		return new String(array);
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
				diagnostics.add(new XtextSyntaxDiagnostic(error));
			}

			res.getErrors().addAll(diagnostics);
		} else {
			for (INode error : parseResult.getSyntaxErrors()) {
				SyntaxErrorMessage errormsg = error.getSyntaxErrorMessage();
				String msg = errormsg.getMessage();
				err.error(filename, error.getStartLine(), msg);
			}

		}
	}

}
