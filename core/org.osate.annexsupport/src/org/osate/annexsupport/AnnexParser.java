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