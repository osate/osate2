/*
 * <copyright>
 * Copyright  2005 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/legal/cpl-v10.html.
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
 * Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 * </copyright>
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