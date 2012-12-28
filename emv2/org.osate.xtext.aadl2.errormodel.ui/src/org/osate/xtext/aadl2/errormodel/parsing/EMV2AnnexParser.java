package org.osate.xtext.aadl2.errormodel.parsing;

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
import org.eclipse.xtext.resource.XtextSyntaxDiagnostic;
import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.modelsupport.errorreporting.MarkerParseErrorReporter;
import org.osate.aadl2.modelsupport.errorreporting.ParseErrorReporter;
import org.osate.annexsupport.AnnexParseResultImpl;
import org.osate.core.OsateCorePlugin;
import org.osate.xtext.aadl2.errormodel.parser.antlr.ErrorModelParser;
import org.osate.xtext.aadl2.errormodel.services.ErrorModelGrammarAccess;

import com.google.inject.Injector;

public class EMV2AnnexParser implements org.osate.annexsupport.AnnexParser { 
	// Need to get aadl resources for resolving components
	// For resolving package names etc
	
	
    private Injector injector = OsateCorePlugin.getDefault().getInjector("org.osate.xtext.aadl2.errormodel.ErrorModel");

	private ErrorModelParser emv2Parser ;

	protected  ErrorModelParser getParser() {
			if (emv2Parser == null) {
				if (injector == null){
					
					injector = OsateCorePlugin.getDefault().getInjector("org.osate.xtext.aadl2.errormodel.ErrorModel");
				}
				emv2Parser = injector.getInstance(ErrorModelParser.class);
			}
		return emv2Parser;
	}

	protected  ErrorModelGrammarAccess getGrammarAccess() {
		return getParser().getGrammarAccess();
	}
	
	public AnnexLibrary parseAnnexLibrary
			(
				String annexName, String source,
				String filename, int line, int column, ParseErrorReporter errReporter
			) {
		AnnexLibrary eal = (AnnexLibrary) parse(source,getGrammarAccess().getErrorModelLibraryRule(),filename,line,column, errReporter);
		 return eal;

	 }

	public AnnexSubclause parseAnnexSubclause
			(
				String annexName, String source, String filename, 
				int line, int column, ParseErrorReporter errReporter
			) {
		AnnexSubclause eas = (AnnexSubclause) parse(source,getGrammarAccess().getErrorModelSubclauseRule(),filename,line,column, errReporter);
		 return eas;
	 }


	public EObject parse(String editString, ParserRule parserRule, String filename,int line, int offset, ParseErrorReporter err) {
		
		try {
			// add lines in front to get right offset for diagnostic highlighting
//			editString = prependLines(editString, line);
			editString = genWhitespace(offset)+editString+"\n\r";
			IParseResult parseResult = getParser().parse(parserRule, new StringReader(editString));
			
			EObject result = null;
			if (isValidParseResult(parseResult)) {
				result = parseResult.getRootASTElement();
				result.eAdapters().add(new AnnexParseResultImpl(parseResult,offset));
				return result;
			} else {
				createDiagnostics(parseResult,filename,err);
				result = parseResult.getRootASTElement();
				if (result != null){
					result.eAdapters().add(new AnnexParseResultImpl(parseResult,offset));
					return result;
				} else {
					return null;
				}
			}
		} catch (Exception exc) {
			return null;
		}
	}
	
	
	protected String genWhitespace(int length){
		char [] array = new char[length];
		Arrays.fill(array,' ');
		return new String(array);
	}
	
	protected String prependLines(String s, int lines){
		for (int i = 0; i < lines; i++) {
			s = "\n\r"+s;
		}
		return s;
	}

	private boolean isValidParseResult(IParseResult parseResult) {
		EObject rootASTElement = parseResult.getRootASTElement();
		if (rootASTElement != null  && !parseResult.hasSyntaxErrors()){
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
	private void createDiagnostics(IParseResult parseResult,String filename,ParseErrorReporter err) {
		if (err instanceof MarkerParseErrorReporter){
			List<Diagnostic> diagnostics = new ArrayList<Diagnostic>();
			Resource res = ((MarkerParseErrorReporter)err).getContextResource();
			for (INode error : parseResult.getSyntaxErrors()) {
				if (res == null){
				SyntaxErrorMessage errormsg = error.getSyntaxErrorMessage();
				String msg = errormsg.getMessage();
				err.error(filename, error.getStartLine(), msg);
				} else {
				diagnostics.add(new XtextSyntaxDiagnostic(error));
				}
			}
			if (res != null)
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