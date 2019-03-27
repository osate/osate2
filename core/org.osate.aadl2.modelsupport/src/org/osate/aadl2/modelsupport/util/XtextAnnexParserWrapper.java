/*******************************************************************************
 * Copyright (c) 2011 SEI (http://www.sei.cmu.edu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.osate.aadl2.modelsupport.util;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.diagnostics.Diagnostic;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.linking.ILinker;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.parser.ParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextSyntaxDiagnostic;
import org.eclipse.xtext.resource.impl.ListBasedDiagnosticConsumer;
import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.PackageSection;

/**
 * Wraps a (partial) Xtext parser in a Osate Annex {@link IParser}.
 *
 * @author Peter Feiler
 * @deprecated Unused, will be removed in 2.5.0
 */
@Deprecated
public class XtextAnnexParserWrapper {

	private ParserRule libraryParserRule;
	private ParserRule subclauseParserRule;
	private IParser xtextParser;

	public XtextAnnexParserWrapper(IParser parser, ParserRule libraryRule, ParserRule subclauseRule) {
		xtextParser = parser;
		libraryParserRule = libraryRule;
		subclauseParserRule = subclauseRule;
	}

	public EObject parseLibrary(EObject element, String editString, int line, int offset) {
		return parse(element, editString, libraryParserRule, line, offset);
	}

	public EObject parseSubclause(EObject element, String editString, int line, int offset) {
		return parse(element, editString, subclauseParserRule, line, offset);
	}

	public EObject resolveAnnex(EObject element) {
		final ListBasedDiagnosticConsumer consumer = new ListBasedDiagnosticConsumer();
		ILinker linker = ((XtextResource) element.eResource()).getLinker();
		linker.linkModel(element, consumer);
		element.eResource().getErrors().addAll(consumer.getResult(Severity.ERROR));
		element.eResource().getWarnings().addAll(consumer.getResult(Severity.WARNING));
		return element;
	}

	public EObject parse(EObject element, String editString, ParserRule parserRule, int line, int offset) {

		try {
			final ListBasedDiagnosticConsumer consumer = new ListBasedDiagnosticConsumer();
			// add lines in front to get right offset
//			editString = prependLines(editString, line);
			editString = genWhitespace(offset) + editString + "\n\r";
			IParseResult parseResult = xtextParser.parse(parserRule, new StringReader(editString));
			EObject result = null;
			Resource res = null;
			if (isValidParseResult(parseResult, element)) {
				if (element instanceof AnnexLibrary) {
					PackageSection pack = (PackageSection) element.eContainer();
					EList<AnnexLibrary> al = pack.getOwnedAnnexLibraries();
					AnnexLibrary resal = (AnnexLibrary) parseResult.getRootASTElement();
					resal.setName(((NamedElement) element).getName());
					al.add(al.indexOf(element), resal);
					al.remove(element);
					res = resal.eResource();
					result = resal;
				} else if (element instanceof AnnexSubclause) {
					Classifier cl = (Classifier) element.eContainer();
					EList<AnnexSubclause> al = cl.getOwnedAnnexSubclauses();
					AnnexSubclause resal = (AnnexSubclause) parseResult.getRootASTElement();
					resal.setName(((NamedElement) element).getName());
					al.add(al.indexOf(element), resal);
					al.remove(element);
					res = resal.eResource();
					result = resal;
				}

				EObject rootASTElement = parseResult.getRootASTElement();
				ILinker linker = ((XtextResource) res).getLinker();
				linker.linkModel(parseResult.getRootASTElement(), consumer);
				res.getErrors().addAll(consumer.getResult(Severity.ERROR));
				res.getWarnings().addAll(consumer.getResult(Severity.WARNING));
				return result;
			} else {
				element.eResource().getErrors().addAll(createDiagnostics(parseResult));
				return null;
			}
		} catch (Exception exc) {
			return null;
		}
	}

	/**
	 * Creates {@link Diagnostic diagnostics} from {@link SyntaxError syntax errors} in {@link ParseResult}.
	 * No diagnostics will be created if {@link #isValidationDisabled() validation is disabled} for this
	 * resource.
	 *
	 * @param parseResult the parse result that provides the syntax errors.
	 * @return list of {@link Diagnostic}. Never <code>null</code>.
	 */
	private List<Diagnostic> createDiagnostics(IParseResult parseResult) {
		List<Diagnostic> diagnostics = new ArrayList<Diagnostic>();
		for (INode error : parseResult.getSyntaxErrors()) {
			diagnostics.add(new XtextSyntaxDiagnostic(error));
		}
		return diagnostics;
	}

	private boolean isValidParseResult(IParseResult parseResult, EObject semanticElement) {
		EObject rootASTElement = parseResult.getRootASTElement();
		if (rootASTElement != null && semanticElement != null && !parseResult.hasSyntaxErrors()) {
			return true;
		}
		return false;
	}

	protected String prependLines(String s, int lines) {
		for (int i = 0; i < lines; i++) {
			s = "\n\r" + s;
		}
		return s;
	}

	protected String genWhitespace(int length) {
		char[] array = new char[length];
		Arrays.fill(array, ' ');
		return new String(array);
	}

}
