package org.osate.expr.annex;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.modelsupport.errorreporting.ParseErrorReporter;
import org.osate.annexsupport.AnnexParseUtil;
import org.osate.annexsupport.AnnexParser;
import org.osate.expr.parser.antlr.ExprParser;
import org.osate.expr.services.ExprGrammarAccess;

import com.google.inject.Inject;
import com.google.inject.Injector;

public class ExprAnnexParser implements AnnexParser {

	@Inject
	private ExprParser parser;

	public ExprAnnexParser() {
		Injector injector = IResourceServiceProvider.Registry.INSTANCE
				.getResourceServiceProvider(URI.createFileURI("dummy.expr")).get(Injector.class);
		injector.injectMembers(this);
	}

	protected ExprGrammarAccess getGrammarAccess() {
		return parser.getGrammarAccess();
	}

	@Override
	public AnnexLibrary parseAnnexLibrary(String annexName, String source, String filename, int line, int column,
			ParseErrorReporter errReporter) {
		AnnexLibrary eal = (AnnexLibrary) AnnexParseUtil.parse(parser, source, getGrammarAccess().getExprLibraryRule(),
				filename, line, column, errReporter);
		return eal;

	}

	@Override
	public AnnexSubclause parseAnnexSubclause(String annexName, String source, String filename, int line, int column,
			ParseErrorReporter errReporter) {
		AnnexSubclause eas = (AnnexSubclause) AnnexParseUtil.parse(parser, source,
				getGrammarAccess().getExprSubclauseRule(), filename, line, column, errReporter);
		return eas;
	}

}
