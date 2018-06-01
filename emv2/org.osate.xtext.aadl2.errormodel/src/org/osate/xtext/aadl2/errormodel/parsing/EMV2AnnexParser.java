package org.osate.xtext.aadl2.errormodel.parsing;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.modelsupport.errorreporting.ParseErrorReporter;
import org.osate.annexsupport.AnnexParseUtil;
import org.osate.annexsupport.AnnexParser;
import org.osate.xtext.aadl2.errormodel.parser.antlr.ErrorModelParser;
import org.osate.xtext.aadl2.errormodel.services.ErrorModelGrammarAccess;

import com.google.inject.Inject;
import com.google.inject.Injector;

public class EMV2AnnexParser implements AnnexParser {

	@Inject
	private ErrorModelParser emv2Parser;

	public EMV2AnnexParser() {
		Injector injector = IResourceServiceProvider.Registry.INSTANCE
				.getResourceServiceProvider(URI.createFileURI("dummy.emv2")).get(Injector.class);
		injector.injectMembers(this);
	}

	protected ErrorModelGrammarAccess getGrammarAccess() {
		return emv2Parser.getGrammarAccess();
	}

	@Override
	public AnnexLibrary parseAnnexLibrary(String annexName, String source, String filename, int line, int column,
			ParseErrorReporter errReporter) {
		AnnexLibrary eal = (AnnexLibrary) AnnexParseUtil.parse(emv2Parser, source,
				getGrammarAccess().getErrorModelLibraryRule(), filename, line, column, errReporter);
		return eal;

	}

	@Override
	public AnnexSubclause parseAnnexSubclause(String annexName, String source, String filename, int line, int column,
			ParseErrorReporter errReporter) {
		AnnexSubclause eas = (AnnexSubclause) AnnexParseUtil.parse(emv2Parser, source,
				getGrammarAccess().getErrorModelSubclauseRule(), filename, line, column, errReporter);
		return eas;
	}

}