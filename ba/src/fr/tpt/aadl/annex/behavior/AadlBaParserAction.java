package fr.tpt.aadl.annex.behavior;

import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;

import edu.cmu.sei.aadl.aadl2.AnnexLibrary;
import edu.cmu.sei.aadl.aadl2.AnnexSubclause;
import edu.cmu.sei.aadl.modelsupport.errorreporting.ParseErrorReporter;
import fr.tpt.aadl.annex.behavior.utils.CaseInsensitiveCharStream;


public class AadlBaParserAction implements edu.cmu.sei.aadl.annex.AnnexParser {

	public AnnexLibrary parseAnnexLibrary
	(String 			annexName, 
			String 			source,
			String 			filename, 
			int     			line, 
			int    			column,
			ParseErrorReporter errReporter)
	throws org.antlr.runtime.RecognitionException {
		// TODO Auto-generated method stub
		return null;
	}

	public AnnexSubclause parseAnnexSubclause(String annexName, String source,

			String filename, int line, int column,

			ParseErrorReporter errReporter)

	throws org.antlr.runtime.RecognitionException {

		ParseErrorReporter reporter = errReporter;

		CharStream cs = new CaseInsensitiveCharStream(source);
		
		cs.setLine(line);

		cs.setCharPositionInLine(column);

		AadlBaLexer lexer = new AadlBaLexer(cs);

		lexer.setParseErrorReporter(reporter);

		lexer.setFilename(filename);

		CommonTokenStream tokens = new CommonTokenStream(lexer);
		System.out.println(tokens.toString());
		AadlBaParser parser = new AadlBaParser(tokens);

		parser.setParseErrorReporter(reporter);

		return parser.behavior_annex();

        // Todo : remove comment in behavior specification
		//final SplitStreamFilter filter = new SplitStreamFilter(lexer);
		//filter.splitOut(AadlBaParser.SL_COMMENT);   

		//return null;

	}

}