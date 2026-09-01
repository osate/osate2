/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
 * All Rights Reserved.
 *
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 */
package org.osate.xtext.aadl2.ba.parsing;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.modelsupport.errorreporting.ParseErrorReporter;
import org.osate.annexsupport.AnnexParseUtil;
import org.osate.annexsupport.AnnexParser;
import org.osate.xtext.aadl2.ba.BehaviorAnnexStandaloneSetup;
import org.osate.xtext.aadl2.ba.parser.antlr.BehaviorAnnexParser;

import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * Parses the temporary embedded BA subclause through {@link AnnexParseUtil}; BA intentionally has no library form.
 */
public final class BehaviorAnnexAnnexParser implements AnnexParser {
	@Inject
	private BehaviorAnnexParser parser;

	public BehaviorAnnexAnnexParser() {
		Injector injector = IResourceServiceProvider.Registry.INSTANCE
				.getResourceServiceProvider(URI.createFileURI("dummy." + BehaviorAnnexStandaloneSetup.FILE_EXTENSION))
				.get(Injector.class);
		injector.injectMembers(this);
	}

	@Override
	public AnnexLibrary parseAnnexLibrary(String annexName, String source, String filename, int line, int column,
			ParseErrorReporter errorReporter) {
		return null;
	}

	@Override
	public AnnexSubclause parseAnnexSubclause(String annexName, String source, String filename, int line, int column,
			ParseErrorReporter errorReporter) {
		return (AnnexSubclause) AnnexParseUtil.parse(parser, source, parser.getGrammarAccess().getAnnexSubclauseRule(),
				filename, line, column, errorReporter);
	}

	@Override
	public String getFileExtension() {
		return BehaviorAnnexStandaloneSetup.FILE_EXTENSION;
	}
}
