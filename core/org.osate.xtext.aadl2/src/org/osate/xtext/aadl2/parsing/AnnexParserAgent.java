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
package org.osate.xtext.aadl2.parsing;

import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.diagnostics.Diagnostic;
import org.eclipse.xtext.diagnostics.IDiagnosticConsumer;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.linking.ILinker;
import org.eclipse.xtext.linking.lazy.LazyLinker;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.DefaultAnnexLibrary;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisToParseErrorReporterAdapter;
import org.osate.aadl2.modelsupport.errorreporting.ParseErrorReporter;
import org.osate.aadl2.modelsupport.errorreporting.QueuingParseErrorReporter;
import org.osate.aadl2.modelsupport.errorreporting.QueuingParseErrorReporter.Message;
import org.osate.annexsupport.AnnexLinkingService;
import org.osate.annexsupport.AnnexLinkingServiceRegistry;
import org.osate.annexsupport.AnnexParseUtil;
import org.osate.annexsupport.AnnexParser;
import org.osate.annexsupport.AnnexParserRegistry;
import org.osate.annexsupport.AnnexRegistry;
import org.osate.annexsupport.AnnexResolver;
import org.osate.annexsupport.AnnexResolverRegistry;
import org.osate.annexsupport.AnnexUtil;
import org.osate.xtext.aadl2.Activator;

import antlr.RecognitionException;

public class AnnexParserAgent extends LazyLinker {
	private static final boolean STANDALONE;
	private static final AnnexParserRegistry PARSER_REGISTRY;
	private static final AnnexResolverRegistry RESOLVER_REGISTRY;
	private static final AnnexLinkingServiceRegistry LINKING_SERVICE_REGISTRY;

	static {
		boolean standalone = false;
		AnnexParserRegistry parserRegistry = null;
		AnnexResolverRegistry resolverRegistry = null;
		AnnexLinkingServiceRegistry linkingServiceRegistry = null;
		try {
			parserRegistry = (AnnexParserRegistry) AnnexRegistry.getRegistry(AnnexRegistry.ANNEX_PARSER_EXT_ID);
			resolverRegistry = (AnnexResolverRegistry) AnnexRegistry.getRegistry(AnnexRegistry.ANNEX_RESOLVER_EXT_ID);
			linkingServiceRegistry = (AnnexLinkingServiceRegistry) AnnexRegistry
					.getRegistry(AnnexRegistry.ANNEX_LINKINGSERVICE_EXT_ID);
		} catch (NoClassDefFoundError e) {
			// we're running without osgi
			standalone = true;
		}
		STANDALONE = standalone;
		PARSER_REGISTRY = parserRegistry;
		RESOLVER_REGISTRY = resolverRegistry;
		LINKING_SERVICE_REGISTRY = linkingServiceRegistry;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.xtext.linking.impl.AbstractCleaningLinker#afterModelLinked(org.eclipse.emf.ecore.EObject,
	 * org.eclipse.xtext.diagnostics.IDiagnosticConsumer)
	 */
	@Override
	protected void afterModelLinked(EObject model, IDiagnosticConsumer diagnosticsConsumer) {
		// we can't process annexes in standalone mode yet
		if (STANDALONE) {
			return;
		}

		String filename = model.eResource().getURI().lastSegment();

		if (model instanceof AadlPackage) {
			// do this only for packages
			List<DefaultAnnexLibrary> all = AnnexUtil.getAllDefaultAnnexLibraries((AadlPackage) model);
			for (DefaultAnnexLibrary defaultAnnexLibrary : all) {
				ParserFunction<AnnexLibrary> parserFunction = AnnexParser::parseAnnexLibrary;
				Consumer<AnnexLibrary> setParsedAnnexLibrary = defaultAnnexLibrary::setParsedAnnexLibrary;
				Consumer<AnnexLibrary> copyModes = annexLibrary -> {
				};

				processAnnexSection(defaultAnnexLibrary, defaultAnnexLibrary.getSourceText(), filename,
						diagnosticsConsumer, parserFunction, setParsedAnnexLibrary, copyModes);
			}
		}
		// do this for both packages and property sets
		List<DefaultAnnexSubclause> asl = AnnexUtil.getAllDefaultAnnexSubclauses(model);
		for (DefaultAnnexSubclause defaultAnnexSubclause : asl) {
			ParserFunction<AnnexSubclause> parserFunction = AnnexParser::parseAnnexSubclause;
			Consumer<AnnexSubclause> setParsedAnnexSubclause = defaultAnnexSubclause::setParsedAnnexSubclause;
			Consumer<AnnexSubclause> copyModes = annexSubclause -> annexSubclause.getInModes()
					.addAll(defaultAnnexSubclause.getInModes());

			processAnnexSection(defaultAnnexSubclause, defaultAnnexSubclause.getSourceText(), filename,
					diagnosticsConsumer, parserFunction, setParsedAnnexSubclause, copyModes);
		}
	}

	/**
	 * Used to indicate to
	 * {@link AnnexParserAgent#processAnnexSection(NamedElement, String, String, IDiagnosticConsumer, ParserFunction, Consumer, Consumer)}
	 * which of {@code parser}'s methods to call. Expected to be either
	 * {@link AnnexParser#parseAnnexLibrary(String, String, String, int, int, ParseErrorReporter)} or
	 * {@link AnnexParser#parseAnnexSubclause(String, String, String, int, int, ParseErrorReporter)}.
	 * 
	 * @param <A> The annex section type, either {@link AnnexLibrary} or {@link AnnexSubclause}.
	 */
	@FunctionalInterface
	private interface ParserFunction<A extends NamedElement> {
		A parse(AnnexParser parser, String annexName, String source, String filename, int line, int offset,
				ParseErrorReporter errReporter) throws RecognitionException;
	}

	/**
	 * Common functionality for processing either a {@link DefaultAnnexLibrary} or a {@link DefaultAnnexSubclause}.
	 * Processing involves parsing the text, attaching the resulting {@link AnnexLibrary} or {@link AnnexSubclause} to
	 * the {@link DefaultAnnexLibrary} or {@link DefaultAnnexSubclause}, setting the modes for the resulting
	 * {@link AnnexSubclause}, and either running the resolver or the linking service, depending upon which one if
	 * available. If the resolver produces errors, then the {@link AnnexLibrary} or {@link AnnexSubclause} will be
	 * detached from the {@link DefaultAnnexLibrary} or {@link DefaultAnnexSubclause}. All error, warning, and info
	 * messages that are produced from the parser, resolver, or linker will be passed along to
	 * {@code diagnosticsConsumer}.
	 * 
	 * @param <A> Type of the resulting annex section. Expected to be {@link AnnexLibrary} or {@link AnnexSubclause}.
	 * @param <D> Type of the default annex section. Expected to be {@link DefaultAnnexLibrary} or
	 *            {@link DefaultAnnexSubclause}.
	 * @param defaultAnnexSection Either the {@link DefaultAnnexLibrary} or {@link DefaultAnnexSubclause}.
	 * @param annexText Either the value of {@link DefaultAnnexLibrary#getSourceText()} or
	 *                  {@link DefaultAnnexSubclause#getSourceText()}.
	 * @param filename Name of the AADL file containing the annex section.
	 * @param diagnosticsConsumer Used for handling error, warning, and info messages.
	 * @param parserFunction Either
	 *                       {@link AnnexParser#parseAnnexLibrary(String, String, String, int, int, ParseErrorReporter)}
	 *                       or
	 *                       {@link AnnexParser#parseAnnexSubclause(String, String, String, int, int, ParseErrorReporter)}.
	 * @param setParsedAnnexSection Either {@link DefaultAnnexLibrary#setSourceText(String)} or
	 *                              {@link DefaultAnnexSubclause#setSourceText(String)}.
	 * @param copyModes Function for copying modes from the {@link DefaultAnnexSubclause} into the newly created
	 *                  {@link AnnexSubclause}. When processing an annex library, {@code copyModes} is expected to be a
	 *                  no-op {@link Consumer}.
	 */
	private <A extends NamedElement, D extends A> void processAnnexSection(D defaultAnnexSection, String annexText,
			String filename, IDiagnosticConsumer diagnosticsConsumer, ParserFunction<A> parserFunction,
			Consumer<A> setParsedAnnexSection, Consumer<A> copyModes) {
		INode node = NodeModelUtils.findActualNodeFor(defaultAnnexSection);
		int line = node.getStartLine() + computeLineOffset(node);
		int offset = AnnexUtil.getAnnexOffset(defaultAnnexSection);
		// look for plug-in parser
		String annexName = defaultAnnexSection.getName();
		if (annexText != null && annexText.length() > 6 && annexName != null) {
			// strip {** **}
			if (annexText.startsWith("{**")) {
				annexText = annexText.substring(3, annexText.length() - 3);
			}
			AnnexParser ap = PARSER_REGISTRY.getAnnexParser(annexName);
			try {
				QueuingParseErrorReporter parseErrReporter = new QueuingParseErrorReporter();
				parseErrReporter.setContextResource(defaultAnnexSection.eResource());
				if(defaultAnnexSection instanceof AnnexSubclause)
					AnnexUtil.setCurrentAnnexSubclause((AnnexSubclause) defaultAnnexSection);
				A annexSection = parserFunction.parse(ap, annexName, annexText, filename, line, offset,
						parseErrReporter);
				if(defaultAnnexSection instanceof AnnexSubclause)
					AnnexUtil.setCurrentAnnexSubclause(null);
				if (AnnexParseUtil.saveParseResult(defaultAnnexSection) == null) {
					// Only consume messages for non-Xtext annexes
					consumeMessages(parseErrReporter, diagnosticsConsumer, annexText, line, offset);
				}
				if (annexSection != null) {
					annexSection.setName(annexName);
					setParsedAnnexSection.accept(annexSection);
					// copy in modes list
					copyModes.accept(annexSection);

					// now resolve reference so we get messages if we have references to undefined items
					AnnexResolver resolver = RESOLVER_REGISTRY.getAnnexResolver(annexName);
					AnnexLinkingService linkingService = LINKING_SERVICE_REGISTRY.getAnnexLinkingService(annexName);
					if (resolver != null && parseErrReporter.getNumErrors() == 0) {// Don't resolve any annex with parsing errors.
						QueuingParseErrorReporter resolveErrReporter = new QueuingParseErrorReporter();
						AnalysisErrorReporterManager resolveErrManager = new AnalysisErrorReporterManager(
								new AnalysisToParseErrorReporterAdapter.Factory(aadlRsrc -> resolveErrReporter));
						resolver.resolveAnnex(annexName, Collections.singletonList(annexSection), resolveErrManager);
						consumeMessages(resolveErrReporter, diagnosticsConsumer, annexText, line, offset);
						if (resolveErrReporter.getNumErrors() != 0) {
							setParsedAnnexSection.accept(null);
						}
					} else if (linkingService != null) {
						try {
							XtextResource res = (XtextResource) defaultAnnexSection.eResource();
							ILinker linker = res.getLinker();
							linker.linkModel(annexSection, diagnosticsConsumer);
						} catch (Exception e) {
							String message = "Linking Service error in " + filename + " at line " + line;
							IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, message, e);
							Activator.getDefault().getLog().log(status);
						}
					}
				}
				if(parseErrReporter.getNumErrors()>0)
					setParsedAnnexSection.accept(null);
			} catch (RecognitionException e) {
				String message = "Major parsing error in " + filename + " at line " + line;
				IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, message, e);
				Activator.getDefault().getLog().log(status);
			}
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

	private static void consumeMessages(QueuingParseErrorReporter errReporter, IDiagnosticConsumer diagnosticsConsumer,
			String annexText, int annexLine, int annexOffset) {
		for (Message message : errReporter.getErrors()) {
			int lineOffset = StringUtils.ordinalIndexOf(annexText, "\n", message.line - annexLine) + 1;
			int endOfLine = annexText.indexOf('\n', lineOffset);
			if (endOfLine == -1) {
				endOfLine = annexText.length();
			} else if (annexText.charAt(endOfLine - 1) == '\r') {
				endOfLine--;
			}

			int diagnosticOffset = annexOffset + lineOffset;
			int diagnosticLength = endOfLine - lineOffset;

			Diagnostic diagnostic = new Diagnostic() {
				@Override
				public String getMessage() {
					return message.message;
				}

				@Override
				public String getLocation() {
					return null;
				}

				@Override
				public int getLine() {
					return message.line;
				}

				@Override
				public int getColumn() {
					return 1;
				}

				@Override
				public int getOffset() {
					return diagnosticOffset;
				}

				@Override
				public int getLength() {
					return diagnosticLength;
				}
			};

			Severity severity;
			if (QueuingParseErrorReporter.ERROR.equals(message.kind)) {
				severity = Severity.ERROR;
			} else if (QueuingParseErrorReporter.WARNING.equals(message.kind)) {
				severity = Severity.WARNING;
			} else if (QueuingParseErrorReporter.INFO.equals(message.kind)) {
				severity = Severity.INFO;
			} else {
				severity = null;
			}

			diagnosticsConsumer.consume(diagnostic, severity);
		}
	}
}
