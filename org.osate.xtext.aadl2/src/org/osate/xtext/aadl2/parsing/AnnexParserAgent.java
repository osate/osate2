package org.osate.xtext.aadl2.parsing;
import java.util.List;

import org.antlr.runtime.RecognitionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.diagnostics.IDiagnosticConsumer;
import org.eclipse.xtext.linking.lazy.LazyLinker;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.DefaultAnnexLibrary;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.aadl2.modelsupport.util.AnnexLanguageServices;
import org.osate.annexsupport.AnnexParser;
import org.osate.annexsupport.AnnexParserRegistry;
import org.osate.annexsupport.AnnexRegistry;
//import org.osate.xtext.aadl2.errormodel.parsing.ErrorModelLanguageServices;


public class AnnexParserAgent  extends LazyLinker {


	/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.xtext.linking.impl.AbstractCleaningLinker#afterModelLinked(org.eclipse.emf.ecore.EObject,
		 * org.eclipse.xtext.diagnostics.IDiagnosticConsumer)
		 */
		@Override
		protected void afterModelLinked(EObject model, IDiagnosticConsumer diagnosticsConsumer) {
			
			INode node = NodeModelUtils.findActualNodeFor(model);
			int offset = node.getTotalOffset();
			int line = node.getTotalStartLine();
			String filename = model.eResource().getURI().lastSegment();
			List<DefaultAnnexLibrary> all=EcoreUtil2.eAllOfType(model, DefaultAnnexLibrary.class);
			for (DefaultAnnexLibrary defaultAnnexLibrary : all) {
//				if (defaultAnnexLibrary.getName().equalsIgnoreCase("error_model")){
//
//					final AnnexLanguageServices empr = new ErrorModelLanguageServices()  ;
//					EObject res = empr.getParser().parseLibrary(defaultAnnexLibrary,defaultAnnexLibrary.getSourceText(),line,offset);
//					if (res != null){
//					}
//				} else
				{
					// look for plug-in parser
					String annexText = defaultAnnexLibrary.getSourceText();
					String annexName = defaultAnnexLibrary.getName();
					if (annexText.length() > 6) {
						annexText = annexText.substring(3, annexText.length() - 3);
					}
					AnnexParserRegistry registry = (AnnexParserRegistry) AnnexRegistry.getRegistry(AnnexRegistry.ANNEX_PARSER_EXT_ID);
					AnnexParser ap = registry.getAnnexParser(annexName);

					//				protected static final InternalErrorReporter internalErrorLogger = new LogInternalErrorReporter(OsateCorePlugin
					//						.getDefault().getBundle());
					//				protected static final ParseErrorReporterFactory parseErrorLoggerFactory = new LogParseErrorReporter.Factory(
					//						OsateCorePlugin.getDefault().getBundle());
					//
					//				final ParseErrorReporterManager parseErrManager = new ParseErrorReporterManager(internalErrorLogger,
					//						new MarkerParseErrorReporter.Factory("edu.cmu.sei.aadl.parser.ParseErrorMarker",
					//								parseErrorLoggerFactory));
					//				final ParseErrorReporter errReporter = parseErrManager.getReporter(file);
					//
					//				ParserErrorReporter errReporter
					AnnexLibrary al = null;
					try {
						al = ap.parseAnnexLibrary(annexName, annexText, filename, line, offset, null);
						if (al != null) al.setName(annexName);
					} catch (RecognitionException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} // TODO: errReporter);
				}
			}
			List<DefaultAnnexSubclause> asl=EcoreUtil2.eAllOfType(model, DefaultAnnexSubclause.class);
			for (DefaultAnnexSubclause defaultAnnexSubclause : asl) {
//				final AnnexLanguageServices empr = new ErrorModelLanguageServices()  ;
//				EObject res = empr.getParser().parseSubclause(defaultAnnexSubclause,defaultAnnexSubclause.getSourceText(),line,offset);
//				if (res != null){
//
//				}
			}
		}
		// from XtextResource:
//		if (parseResult == null || parseResult.getRootASTElement() == null)
//			return;
//
//		final ListBasedDiagnosticConsumer consumer = new ListBasedDiagnosticConsumer();
//		linker.linkModel(parseResult.getRootASTElement(), consumer);
//		if (!validationDisabled) {
//			getErrors().addAll(consumer.getResult(Severity.ERROR));
//			getWarnings().addAll(consumer.getResult(Severity.WARNING));
//		}

// Calling annex plug-in parsers		
//		String annexName = id.getText();
//		String annexText = at.getText();
//		if (annexText.length() > 6) {
//	        annexText = annexText.substring(3, annexText.length() - 3);
//		}
//		AnnexParserRegistry registry = (AnnexParserRegistry) AnnexRegistry.getRegistry(AnnexRegistry.ANNEX_PARSER_EXT_ID);
//		AnnexParser ap = registry.getAnnexParser(annexName);
//		al = ap.parseAnnexLibrary(id.getText(), annexText, getFilename(), at.getLine(), at.getCharPositionInLine() + 3, errReporter);
//		al.setName(id.getText());

		
}
