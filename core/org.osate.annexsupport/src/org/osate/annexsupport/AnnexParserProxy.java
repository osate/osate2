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
package org.osate.annexsupport;

import org.eclipse.core.runtime.IConfigurationElement;
import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.modelsupport.errorreporting.ParseErrorReporter;

import antlr.RecognitionException;

/**
 * @author lwrage
 * @version $Id: AnnexParserProxy.java,v 1.7 2008-01-23 21:34:21 jseibel Exp $
 */
public class AnnexParserProxy extends AnnexProxy implements AnnexParser {

	/** The annex parser instance. */
	private AnnexParser parser = null;

	/**
	 * Create a new annex parser proxy.
	 */
	AnnexParserProxy(IConfigurationElement configElem) {
		super(configElem);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see edu.cmu.sei.aadl.parser.AnnexParser#parseAnnexLibrary(java.lang.String, java.lang.String)
	 */
	@Override
	public AnnexLibrary parseAnnexLibrary(String annexName, String source, String filename, int line, int column,
			ParseErrorReporter errReporter) throws RecognitionException {
		AnnexParser parser = getParser();

		if (parser == null) {
			return null;
		}
		AnnexParseUtil.reset();
		return parser.parseAnnexLibrary(annexName, source, filename, line, column, errReporter);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see edu.cmu.sei.aadl.parser.AnnexParser#parseAnnexSubclause(java.lang.String, java.lang.String)
	 */
	@Override
	public AnnexSubclause parseAnnexSubclause(String annexName, String source, String filename, int line, int column,
			ParseErrorReporter errReporter) throws RecognitionException {
		AnnexParser parser = getParser();

		if (parser == null) {
			return null;
		}
		AnnexParseUtil.reset();
		return parser.parseAnnexSubclause(annexName, source, filename, line, column, errReporter);
	}

	private AnnexParser getParser() {
		if (parser != null) {
			return parser;
		}
		try {
			parser = (AnnexParser) configElem.createExecutableExtension(ATT_CLASS);
		} catch (Exception e) {
			AnnexPlugin.logError("Failed to instantiate " + annexName + " parser " + className + " in type: " + id
					+ " in plugin " + configElem.getDeclaringExtension().getContributor().getName(), e);
		}
		return parser;
	}

	private String getAnnexNSURI() {
		try {
			String value = configElem.getAttribute(ATT_ANNEXNSURI);
			return value;
		} catch (Exception e) {
		}
		return null;
	}
}