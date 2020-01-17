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

import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.modelsupport.errorreporting.ParseErrorReporter;
import org.osate.aadl2.parsesupport.LocationReference;

import antlr.RecognitionException;

/**
 * Annex parsers must implement this interface. Each time the AADL parser finds
 * either an annex library or an annex subclause it calls the corresponding
 * annex parser method. Exceptions in an annex parser must be thrown as class
 * antlr.RecognitionException to work with the core AADL parser that is based on
 * the ANTLR parser generator.
 * <p>
 * Each annex parser will be called for annexes for which it provides an
 * extension as specified in the annexName attribute in the extension point
 * org.osate.annexsupport.parser.
 *
 * @author lwrage
 * @version $Id: AnnexParser.java,v 1.9 2008-01-23 21:34:21 jseibel Exp $
 */
public interface AnnexParser {
	/**
	 * Parse the content of an annex library element found in an AADL
	 * specification or package section.
	 *
	 * @param annexName
	 *            the name of the annex.
	 * @param source
	 *            the source text string in the annex library.
	 * @param filename
	 *            the name of the currently parsed file.
	 * @param line
	 *            the line where the annex library starts.
	 * @param column
	 *            the column where the annex library starts.
	 * @param errReporter
	 *            The parse error reporter associated with the source AADL file
	 *            being parsed. Call
	 *            {@link ParseErrorReporter#error(String, int, String)} or
	 *            {@link ParseErrorReporter#error(LocationReference, String)} to report
	 *            errors in parsing the annex text.
	 * @return An instance of a subclass of AnnexLibrary. The specific class
	 *         returned will depend on the annex model.
	 * @throws RecognitionException
	 *             in case of a syntax error.
	 */
	AnnexLibrary parseAnnexLibrary(String annexName, String source, String filename, int line, int column,
			ParseErrorReporter errReporter) throws RecognitionException;

	/**
	 * Parse the content of an annex subclause element found in an AADL
	 * classifier.
	 *
	 * @param annexName
	 *            the name of the annex.
	 * @param source
	 *            the source text string in the annex subclause.
	 * @param filename
	 *            the name of the currently parsed file.
	 * @param line
	 *            the line where the annex subclause starts.
	 * @param column
	 *            the column where the annex subclause starts.
	 * @param errReporter
	 *            The parse error reporter associated with the source AADL file
	 *            being parsed. Call
	 *            {@link ParseErrorReporter#error(String, int, String)} or
	 *            {@link ParseErrorReporter#error(LocationReference, String)} to report
	 *            errors in parsing the annex text.
	 * @return An instance of a subclass of AnnexSubclause. The specific class
	 *         returned will depend on the annex model.
	 * @throws RecognitionException
	 *             in case of a syntax error.
	 */
	AnnexSubclause parseAnnexSubclause(String annexName, String source, String filename, int line, int column,
			ParseErrorReporter errReporter) throws RecognitionException;
}