/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Adapted by P. Feiler, SEI 2011
 *******************************************************************************/
package org.osate.aadl2.modelsupport.util;

import java.io.StringReader;
import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.IParser;

/**
 * Wraps a (partial) Xtext parser in a GMF {@link IParser}.
 * 
 * @author Jan Koehnlein/Peter Feiler
 */
public class AntlrParserWrapper  {

	private final ParserRule parserRule;

	private final IParser originalParser;

	public AntlrParserWrapper(ParserRule parserRule, IParser originalParser) {
		this.parserRule = parserRule;
		this.originalParser = originalParser;
	}


	public void parse(EObject element, String editString) {
		try {
			editString = "annex error_model "+editString+";";
			IParseResult parseResult = originalParser.parse(parserRule, new StringReader(editString));
			if (isValidParseResult(parseResult, element)) {
				return ;
			} else {
				Iterator<INode> pe = parseResult.getSyntaxErrors().iterator();
				while (pe.hasNext()) {
					INode syntaxError = pe.next();
					System.out.println(syntaxError.getSyntaxErrorMessage().getMessage());
				}
				return;
			}
		} catch (Exception exc) {
			return ;
		}
	}

	private boolean isValidParseResult(IParseResult parseResult, EObject semanticElement) {
		EObject rootASTElement = parseResult.getRootASTElement();
		return !parseResult.hasSyntaxErrors() && rootASTElement != null && semanticElement != null
//				&& semanticElement.eClass() == rootASTElement.eClass()
				;
	}

}
