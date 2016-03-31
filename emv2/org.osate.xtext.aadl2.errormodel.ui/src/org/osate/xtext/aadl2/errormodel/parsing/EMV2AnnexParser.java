package org.osate.xtext.aadl2.errormodel.parsing;

import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.modelsupport.errorreporting.ParseErrorReporter;
import org.osate.annexsupport.AnnexParseUtil;
import org.osate.annexsupport.AnnexParser;
import org.osate.core.OsateCorePlugin;
import org.osate.xtext.aadl2.errormodel.parser.antlr.ErrorModelParser;
import org.osate.xtext.aadl2.errormodel.services.ErrorModelGrammarAccess;

import com.google.inject.Injector;

public class EMV2AnnexParser implements AnnexParser {
	// Need to get aadl resources for resolving components
	// For resolving package names etc

	private Injector injector = OsateCorePlugin.getDefault().getInjector("org.osate.xtext.aadl2.errormodel.ErrorModel");

	private ErrorModelParser emv2Parser;

	protected ErrorModelParser getParser() {
		if (emv2Parser == null) {
			if (injector == null) {

				injector = OsateCorePlugin.getDefault().getInjector("org.osate.xtext.aadl2.errormodel.ErrorModel");
			}
			emv2Parser = injector.getInstance(ErrorModelParser.class);
		}
		return emv2Parser;
	}

	protected ErrorModelGrammarAccess getGrammarAccess() {
		return getParser().getGrammarAccess();
	}

	@Override
	public AnnexLibrary parseAnnexLibrary(String annexName, String source, String filename, int line, int column,
			ParseErrorReporter errReporter) {
		AnnexLibrary eal = (AnnexLibrary) AnnexParseUtil.parse(getParser(), source,
				getGrammarAccess().getErrorModelLibraryRule(), filename, line, column, errReporter);
		return eal;

	}

	@Override
	public AnnexSubclause parseAnnexSubclause(String annexName, String source, String filename, int line, int column,
			ParseErrorReporter errReporter) {
		AnnexSubclause eas = (AnnexSubclause) AnnexParseUtil.parse(getParser(), source,
				getGrammarAccess().getErrorModelSubclauseRule(), filename, line, column, errReporter);
		return eas;
	}

}