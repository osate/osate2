package org.osate.xtext.aadl2.ui.editor.autoedit;

import org.eclipse.jface.text.IDocument;
import org.eclipse.xtext.ui.editor.autoedit.DefaultAutoEditStrategyProvider;

public class Aadl2AutoEditStrategyPprovider extends
		DefaultAutoEditStrategyProvider {

	@Override
	protected void configure(IEditStrategyAcceptor acceptor) {
		configureIndentationEditStrategy(acceptor);
		configureStringLiteral(acceptor);
		configureParenthesis(acceptor);
		configureSquareBrackets(acceptor);
		configureCurlyBracesBlock(acceptor);
		configureAnnexBracesBlock(acceptor);
		configureMultilineComments(acceptor);
		configureCompoundBracesBlocks(acceptor);
	}

	@Override
	protected void configureCompoundBracesBlocks(IEditStrategyAcceptor acceptor) {
		acceptor.accept(compoundMultiLineTerminals.newInstanceFor("{ ", "}").and("{**", "**}").and("[", "]").and("(", ")"), IDocument.DEFAULT_CONTENT_TYPE);
	}  
	
@Override
	protected void configureCurlyBracesBlock(IEditStrategyAcceptor acceptor) {
	acceptor.accept(singleLineTerminals.newInstance("{ ", "}"),IDocument.DEFAULT_CONTENT_TYPE);
	}


	protected void configureAnnexBracesBlock(IEditStrategyAcceptor acceptor) {
		acceptor.accept(singleLineTerminals.newInstance("{**", "**}"),IDocument.DEFAULT_CONTENT_TYPE);
	}

}

