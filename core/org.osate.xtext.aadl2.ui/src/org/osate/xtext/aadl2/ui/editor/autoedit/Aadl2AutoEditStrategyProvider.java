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

import org.eclipse.jface.text.IDocument;
import org.eclipse.xtext.ui.editor.autoedit.DefaultAutoEditStrategyProvider;

import com.google.inject.Inject;

public class Aadl2AutoEditStrategyProvider extends DefaultAutoEditStrategyProvider {

	@Inject
	protected AutoIndentEditStrategy.Factory autoIndent;

	@Inject
	protected AutoUnindentEditStrategy.Factory autoUnindent;

	@Inject
	protected AutoUnindentComponentContentsEditStrategy.Factory autoIndentSection;

	@Override
	protected void configure(IEditStrategyAcceptor acceptor) {
		configureIndentationEditStrategy(acceptor);
		configureEndUnindent(acceptor);
		configureStringLiteral(acceptor);
		configureParenthesis(acceptor);
		configureSquareBrackets(acceptor);
//		configureAnnexBracesBlock(acceptor);
		configureCurlyBracesBlock(acceptor);
		configureMultilineComments(acceptor);
		configureCompoundBracesBlocks(acceptor);
		configureKeywordIndent(acceptor);
		configureSectionIndent(acceptor);
	}

	@Override
	protected void configureCompoundBracesBlocks(IEditStrategyAcceptor acceptor) {
		acceptor.accept(
				compoundMultiLineTerminals.newInstanceFor("{**", "**}").and("{ ", "}").and("[", "]").and("(", ")"),
				IDocument.DEFAULT_CONTENT_TYPE);
	}

	@Override
	protected void configureCurlyBracesBlock(IEditStrategyAcceptor acceptor) {
		acceptor.accept(singleLineTerminals.newInstance("{ ", "}"), IDocument.DEFAULT_CONTENT_TYPE);
	}

//	protected void configureAnnexBracesBlock(IEditStrategyAcceptor acceptor) {
//		acceptor.accept(singleLineTerminals.newInstance("{**", "**};"), IDocument.DEFAULT_CONTENT_TYPE);
//	}

	protected void configureKeywordIndent(IEditStrategyAcceptor acceptor) {
		String[] keywords = { "public", "private", "abstract", "bus", "data", "device", "feature" /* , "features" */,
				"memory", "subprogram", "system", "thread", "process", "processor", "calls", "connections", "flows",
				"modes", "properties", "prototypes", "subcomponents", "annex", "virtual" };
		for (String keyword : keywords) {
			acceptor.accept(autoIndent.newInstance(keyword), IDocument.DEFAULT_CONTENT_TYPE);
		}
	}

	protected void configureEndUnindent(IEditStrategyAcceptor acceptor) {
		acceptor.accept(autoUnindent.newInstance(System.lineSeparator()), IDocument.DEFAULT_CONTENT_TYPE);
	}

	protected void configureSectionIndent(IEditStrategyAcceptor acceptor) {
		acceptor.accept(autoIndentSection.newInstance(System.lineSeparator()), IDocument.DEFAULT_CONTENT_TYPE);
	}

}
