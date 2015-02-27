/*
 *
 * <copyright>
 * Copyright  2012 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/org/documents/epl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE "DELIVERABLES") ARE ON AN "AS-IS" BASIS.
 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
 * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
 * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
 * MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
 * APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.
 *
 * Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
 * employees, and agents from all claims or demands made against them (and any related losses, expenses, or
 * attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
 * misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
 * assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
 * product liability, personal injury, death, damage to property, or violation of any laws or regulations.
 *
 * Carnegie Mellon Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 * </copyright>
 */
package org.osate.xtext.aadl2.parsing;

import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.diagnostics.IDiagnosticConsumer;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.linking.ILinker;
import org.eclipse.xtext.linking.lazy.LazyLinker;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.impl.ListBasedDiagnosticConsumer;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.DefaultAnnexLibrary;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.aadl2.Mode;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisToParseErrorReporterAdapter;
import org.osate.aadl2.modelsupport.errorreporting.LogParseErrorReporter;
import org.osate.aadl2.modelsupport.errorreporting.MarkerParseErrorReporter;
import org.osate.aadl2.modelsupport.errorreporting.ParseErrorReporter;
import org.osate.aadl2.modelsupport.errorreporting.ParseErrorReporterFactory;
import org.osate.aadl2.modelsupport.errorreporting.ParseErrorReporterManager;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.aadl2.util.OsateDebug;
import org.osate.annexsupport.AnnexLinkingService;
import org.osate.annexsupport.AnnexLinkingServiceRegistry;
import org.osate.annexsupport.AnnexParser;
import org.osate.annexsupport.AnnexParserRegistry;
import org.osate.annexsupport.AnnexRegistry;
import org.osate.annexsupport.AnnexResolver;
import org.osate.annexsupport.AnnexResolverRegistry;
import org.osate.annexsupport.AnnexUtil;
import org.osate.core.OsateCorePlugin;

import org.osate.aadl2.modelsupport.errorreporting.MarkerParseErrorReporter.Factory ;

import antlr.RecognitionException;

public class AnnexParserAgent extends LazyLinker {
  
  private final ParseErrorReporterFactory parseErrorLoggerFactory = 
      new LogParseErrorReporter.Factory(OsateCorePlugin.getDefault().
                                                        getBundle());
  private Factory factory = new MarkerParseErrorReporter.Factory(
                     "org.osate.aadl2.modelsupport.ParseErrorMarker",
                                           parseErrorLoggerFactory) ;

  // Instantiating parseErrManager when afterModelLinked is recursively called
  // (see l244) deletes the error markers (see ParseErrorReporterManager at l120) 
  // of the annexes not built with xtext(for example BA).
  // That why parseErrManager is an class attribut.
  private final ParseErrorReporterManager parseErrManager = new 
                                  ParseErrorReporterManager(factory);

  // Control flag for cleaning the error markers from the previous stack of recursive
  // calls of afterModelLinked.  
  private boolean hasToClean = true ;
  
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
		
		boolean hasToRestoreCleanFlag = false ;
    
    if(hasToClean) // Don't clean the error markers after the first recursive call of this method.
    {
      parseErrManager.clean();
      hasToRestoreCleanFlag = true ;
      hasToClean = false ;
    }
		
		final ParseErrorReporter errReporter = parseErrManager.getReporter(file);
		if (errReporter instanceof MarkerParseErrorReporter) {
			((MarkerParseErrorReporter) errReporter).setContextResource(model.eResource());
		}
		final AnalysisErrorReporterManager resolveErrManager = new AnalysisErrorReporterManager(
				new AnalysisToParseErrorReporterAdapter.Factory(new MarkerParseErrorReporter.Factory(
						"org.osate.aadl2.modelsupport.ParseErrorMarker", parseErrorLoggerFactory)));

		AnnexParserRegistry registry = (AnnexParserRegistry) AnnexRegistry
				.getRegistry(AnnexRegistry.ANNEX_PARSER_EXT_ID);
		AnnexResolverRegistry resolverregistry = (AnnexResolverRegistry) AnnexRegistry
				.getRegistry(AnnexRegistry.ANNEX_RESOLVER_EXT_ID);
		AnnexLinkingServiceRegistry linkingserviceregistry = (AnnexLinkingServiceRegistry) AnnexRegistry
				.getRegistry(AnnexRegistry.ANNEX_LINKINGSERVICE_EXT_ID);

		// Don't resolve annexes if there are parsing errors.
		boolean hasToResolveAnnex = errReporter.getNumErrors() <= 0;
		if (model instanceof AadlPackage) {
			// do this only for packages
			List<DefaultAnnexLibrary> all = AnnexUtil.getAllDefaultAnnexLibraries((AadlPackage) model);
			for (DefaultAnnexLibrary defaultAnnexLibrary : all) {
				INode node = NodeModelUtils.findActualNodeFor(defaultAnnexLibrary);
				int line = node.getStartLine() + computeLineOffset(node);
				int offset = AnnexUtil.getAnnexOffset(defaultAnnexLibrary);
				AnnexLibrary al = null;
				// look for plug-in parser
				String annexText = defaultAnnexLibrary.getSourceText();
				String annexName = defaultAnnexLibrary.getName();
				if (annexText != null && annexText.length() > 6 && annexName != null) {
					// strip {** **}
					if (annexText.startsWith("{**")) {
						annexText = annexText.substring(3, annexText.length() - 3);
					}
					AnnexParser ap = registry.getAnnexParser(annexName);
					try {
						int errs = errReporter.getNumErrors();
						al = ap.parseAnnexLibrary(annexName, annexText, filename, line, offset, errReporter);
						if (al != null)// && errReporter.getNumErrors() == errs)
						{
							al.setName(annexName);
							defaultAnnexLibrary.setParsedAnnexLibrary(al);

							AnnexResolver resolver = resolverregistry.getAnnexResolver(annexName);
							AnnexLinkingService linkingservice = linkingserviceregistry
									.getAnnexLinkingService(annexName);
							if (resolver != null && hasToResolveAnnex && errReporter.getNumErrors() == errs) {
								errs = resolveErrManager.getNumErrors();
								resolver.resolveAnnex(annexName, Collections.singletonList(al), resolveErrManager);
								if (errs != resolveErrManager.getNumErrors()) {
									defaultAnnexLibrary.setParsedAnnexLibrary(null);
								}
							} else if (linkingservice != null) {
								try {
									final ListBasedDiagnosticConsumer consumer = new ListBasedDiagnosticConsumer();
									Resource res = model.eResource();
									ILinker linker = ((XtextResource) res).getLinker();
									linker.linkModel(al, consumer);
									res.getErrors().addAll(consumer.getResult(Severity.ERROR));
									res.getWarnings().addAll(consumer.getResult(Severity.WARNING));
								} catch (Exception e) {
									errReporter.error(filename, line, "Linking Service error");
								}
							}
						}
					} catch (RecognitionException e) {
						errReporter.error(filename, line, "Major parsing error");
					}
				}
			}
		}
		// do this for both packages and property sets
		List<DefaultAnnexSubclause> asl = AnnexUtil.getAllDefaultAnnexSubclauses(model);
		for (DefaultAnnexSubclause defaultAnnexSubclause : asl) {

			INode node = NodeModelUtils.findActualNodeFor(defaultAnnexSubclause);

			if (node == null) {
				OsateDebug.osateDebug("Annex not found for code: " + defaultAnnexSubclause.getSourceText());
				continue;
			}
			int offset = node.getOffset();
			int line = node.getStartLine() + computeLineOffset(node);
			offset = AnnexUtil.getAnnexOffset(defaultAnnexSubclause);
			// look for plug-in parser
			String annexText = defaultAnnexSubclause.getSourceText();
			String annexName = defaultAnnexSubclause.getName();
			if (annexText != null && annexText.length() > 6 && annexName != null) {
				// strip {** **}
				if (annexText.startsWith("{**")) {
					annexText = annexText.substring(3, annexText.length() - 3);
				}
				AnnexParser ap = registry.getAnnexParser(annexName);
				try {
					int errs = errReporter.getNumErrors();
					AnnexSubclause asc = ap.parseAnnexSubclause(annexName, annexText, filename, line, offset,
							errReporter);
					if (asc != null)// && errReporter.getNumErrors() == errs)
					{
						asc.setName(annexName);
						defaultAnnexSubclause.setParsedAnnexSubclause(asc);
						// copy in modes list
						EList<Mode> inmodelist = defaultAnnexSubclause.getInModes();
						for (Mode mode : inmodelist) {
							asc.getInModes().add(mode);
						}

						// now resolve reference so we messages if we have references to undefined items
						AnnexResolver resolver = resolverregistry.getAnnexResolver(annexName);
						AnnexLinkingService linkingservice = linkingserviceregistry.getAnnexLinkingService(annexName);
						if (resolver != null && hasToResolveAnnex && errReporter.getNumErrors() == errs) {// Don't resolve any annex with parsing error.)
							errs = resolveErrManager.getNumErrors();
							resolver.resolveAnnex(annexName, Collections.singletonList(asc), resolveErrManager);
							if (errs != resolveErrManager.getNumErrors()) {
								defaultAnnexSubclause.setParsedAnnexSubclause(null);
							}
						} else if (linkingservice != null) {
							try {
								final ListBasedDiagnosticConsumer consumer = new ListBasedDiagnosticConsumer();
								Resource res = model.eResource();
								ILinker linker = ((XtextResource) res).getLinker();
								linker.linkModel(asc, consumer);
								res.getErrors().addAll(consumer.getResult(Severity.ERROR));
								res.getWarnings().addAll(consumer.getResult(Severity.WARNING));
							} catch (Exception e) {
								errReporter.error(filename, line, "Linking Service error");
							}
						}
					}
				} catch (RecognitionException e) {
					errReporter.error(filename, line, "Major uncaught parsing error");
				}
			}
		}
		
		// The first recursive call of this method reset the flag for others
    // stacks of recursive calls of this method.
    if(hasToRestoreCleanFlag)
    {
      hasToClean = true ;
      hasToRestoreCleanFlag = false ;
    }
	}

	// Compute the number of line between the token "annex" and the token "{**".
	// TODO test under windows.
	private int computeLineOffset(INode node) {
		int result = 0;
		boolean next = true;
		char c;
		int index = 0;
		String text = node.getText();

		// Trim the space or new line before the keyword "annex".
		while (text.charAt(index++) != 'a' && index < text.length()) {
			continue;
		}

		index += 4; // Complete the word "annex".

		while (next && index < text.length()) {
			c = text.charAt(index);

			if (c == '\n') {
				result++;
			} else if (c == '{') {
				next = false;
			}

			index++;
		}

		return result;
	}
}
