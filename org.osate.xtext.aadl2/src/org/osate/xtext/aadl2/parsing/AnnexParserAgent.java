package org.osate.xtext.aadl2.parsing;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.diagnostics.IDiagnosticConsumer;
import org.eclipse.xtext.linking.lazy.LazyLinker;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.DefaultAnnexLibrary;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.aadl2.PackageSection;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisToParseErrorReporterAdapter;
import org.osate.aadl2.modelsupport.errorreporting.InternalErrorReporter;
import org.osate.aadl2.modelsupport.errorreporting.LogInternalErrorReporter;
import org.osate.aadl2.modelsupport.errorreporting.LogParseErrorReporter;
import org.osate.aadl2.modelsupport.errorreporting.MarkerParseErrorReporter;
import org.osate.aadl2.modelsupport.errorreporting.ParseErrorReporter;
import org.osate.aadl2.modelsupport.errorreporting.ParseErrorReporterFactory;
import org.osate.aadl2.modelsupport.errorreporting.ParseErrorReporterManager;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.annexsupport.AnnexParser;
import org.osate.annexsupport.AnnexParserRegistry;
import org.osate.annexsupport.AnnexRegistry;
import org.osate.annexsupport.AnnexResolver;
import org.osate.annexsupport.AnnexResolverRegistry;
import org.osate.core.OsateCorePlugin;

import antlr.RecognitionException;


public class AnnexParserAgent  extends LazyLinker {


	/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.xtext.linking.impl.AbstractCleaningLinker#afterModelLinked(org.eclipse.emf.ecore.EObject,
		 * org.eclipse.xtext.diagnostics.IDiagnosticConsumer)
		 */
		@Override
		protected void afterModelLinked(EObject model, IDiagnosticConsumer diagnosticsConsumer) {
			
			String filename = model.eResource().getURI().lastSegment();
			// set up reporter for ParseErrors
			IResource file = OsateResourceUtil.convertToIResource(model.eResource());
			final InternalErrorReporter internalErrorLogger = new LogInternalErrorReporter(OsateCorePlugin
					.getDefault().getBundle());
			final ParseErrorReporterFactory parseErrorLoggerFactory = new LogParseErrorReporter.Factory(
					OsateCorePlugin.getDefault().getBundle());

			final ParseErrorReporterManager parseErrManager = new ParseErrorReporterManager(internalErrorLogger,
					new MarkerParseErrorReporter.Factory("org.osate.aadl2.modelsupport.ParseErrorMarker",
							parseErrorLoggerFactory));
			final ParseErrorReporter errReporter = parseErrManager.getReporter(file);
			final AnalysisErrorReporterManager resolveErrManager = 
					new AnalysisErrorReporterManager(
							internalErrorLogger,
							new AnalysisToParseErrorReporterAdapter.Factory(
									new MarkerParseErrorReporter.Factory(
											"org.osate.aadl2.modelsupport.ParseErrorMarker",
											parseErrorLoggerFactory)));
			
			AnnexParserRegistry registry = (AnnexParserRegistry) AnnexRegistry.getRegistry(AnnexRegistry.ANNEX_PARSER_EXT_ID);
			AnnexResolverRegistry resolverregistry = (AnnexResolverRegistry) AnnexRegistry
					.getRegistry(AnnexRegistry.ANNEX_RESOLVER_EXT_ID);


			List<DefaultAnnexLibrary> all=EcoreUtil2.eAllOfType(model, DefaultAnnexLibrary.class);
			for (DefaultAnnexLibrary defaultAnnexLibrary : all) {
				INode node = NodeModelUtils.findActualNodeFor(defaultAnnexLibrary);
				int offset = node.getOffset();
				int line = node.getStartLine();
				String sourceText = defaultAnnexLibrary.getSourceText();
				if (sourceText == null) break;
				int nlength = node.getLength();
				int sourcelength = sourceText.length();
				offset = offset + (nlength-sourcelength-1);
				AnnexLibrary al = null;
				// call the new error annex as a XText generated frontend
				if (defaultAnnexLibrary.getName().equalsIgnoreCase("emv2")){

//					final AnnexLanguageServices empr = new ErrorModelLanguageServices()  ;
//					al = (AnnexLibrary) empr.getParser().parseLibrary(defaultAnnexLibrary,sourceText,line,offset);
					// error annex object is already linked in
				} else 
				{
					// look for plug-in parser
					String annexText = defaultAnnexLibrary.getSourceText();
					String annexName = defaultAnnexLibrary.getName();
					if (annexText != null && annexName != null){
						if (annexText.length() > 6) {
							annexText = annexText.substring(3, annexText.length() - 3);
						}
						AnnexParser ap = registry.getAnnexParser(annexName);
						try {
							int errs = errReporter.getNumErrors();
							al = ap.parseAnnexLibrary(annexName, annexText, filename, line, offset, errReporter);
							if (al != null && errReporter.getNumErrors() == errs) 
							{ 
								al.setName(annexName);
								// replace default annex library with the new one. 
								EList<AnnexLibrary> ael= ((PackageSection)defaultAnnexLibrary.eContainer()).getOwnedAnnexLibraries();
								int idx = ael.indexOf(defaultAnnexLibrary);
								ael.add(idx, al);
								ael.remove(defaultAnnexLibrary);

								AnnexResolver resolver = resolverregistry.getAnnexResolver(annexName);
								if (resolver != null)
									resolver.resolveAnnex(annexName, Collections.singletonList(al), resolveErrManager);
							}
						} catch (RecognitionException e) {
							errReporter.error(filename, line, "Major parsing error");
						}
					}
				}
			}
			List<DefaultAnnexSubclause> asl=EcoreUtil2.eAllOfType(model, DefaultAnnexSubclause.class);
			for (DefaultAnnexSubclause defaultAnnexSubclause : asl) {
				INode node = NodeModelUtils.findActualNodeFor(defaultAnnexSubclause);
				int offset = node.getOffset();
				int line = node.getStartLine();
				String sourceText = defaultAnnexSubclause.getSourceText();
				if (sourceText == null) break;
				int nlength = node.getLength();
				int sourcelength = sourceText.length();
				offset = offset + (nlength-sourcelength-1);
				// call the new error annex as a XText generated frontend
				if (defaultAnnexSubclause.getName().equalsIgnoreCase("emv2")){
//					final AnnexLanguageServices empr = new ErrorModelLanguageServices()  ;
//					AnnexSubclause al = (AnnexSubclause) empr.getParser().parseSubclause(defaultAnnexSubclause,defaultAnnexSubclause.getSourceText(),line,offset);
				} else
				{
					// look for plug-in parser
					String annexText = defaultAnnexSubclause.getSourceText();
					String annexName = defaultAnnexSubclause.getName();
					if (annexText != null && annexName != null){
						if (annexText.length() > 6) {
							annexText = annexText.substring(3, annexText.length() - 3);
						}
						AnnexParser ap = registry.getAnnexParser(annexName);
						try {
							int errs = errReporter.getNumErrors();
							AnnexSubclause al = ap.parseAnnexSubclause(annexName, annexText, filename, line, offset, errReporter);
							if (al != null && errReporter.getNumErrors() == errs) 
							{
								al.setName(annexName);
								// replace default annex library with the new one. 
								EList<AnnexSubclause> ael= ((Classifier)defaultAnnexSubclause.eContainer()).getOwnedAnnexSubclauses();
								int idx = ael.indexOf(defaultAnnexSubclause);
								ael.add(idx, al);
								ael.remove(defaultAnnexSubclause);
								AnnexResolver resolver = resolverregistry.getAnnexResolver(annexName);
								if (resolver != null) resolver.resolveAnnex(annexName, Collections.singletonList(al), resolveErrManager);
							}
						} catch (RecognitionException e) {
							errReporter.error(filename, line, "Major uncaught parsing error");
						} 
					}
					
				}
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


		
}
