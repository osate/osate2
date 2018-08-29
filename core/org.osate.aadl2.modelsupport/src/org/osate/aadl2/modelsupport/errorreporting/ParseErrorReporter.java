/**
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
package org.osate.aadl2.modelsupport.errorreporting;

import org.osate.aadl2.parsesupport.LocationReference;

/**
 * Interface defining the abstract operations required to report errors during
 * the parsing and interpretation of an AADL text file. Meant to be used during
 * the creation of an AAXL object model from an AADL text file. There are no
 * methods in this interface that are appropriate for reporting errors on an
 * object model; for that use
 * {@link edu.cmu.sei.aadl.model.pluginsupport.AnalysisErrorReporter}.
 *
 * <p>
 * In general, objects of classes that implement this interface are meant to be
 * obtained using implementations of
 * {@link edu.cmu.sei.aadl.model.pluginsupport.ParseErrorReporterFactory}.
 *
 * @see edu.cmu.sei.aadl.model.pluginsupport.ParseErrorReporterFactory
 * @see edu.cmu.sei.aadl.model.pluginsupport.ParseErrorReporterManager
 *
 * @author aarong
 */
public interface ParseErrorReporter extends ErrorReporter {
	/**
	 * Report an error.
	 *
	 * @param loc
	 *            The location on which the warning is located.
	 * @param message
	 *            the error message
	 */
	public void error(LocationReference loc, String message);

	/**
	 * Report an error.
	 *
	 * @param filename
	 *            The file in which the error is located.
	 * @param line
	 *            The line on which the error occured.
	 * @param message
	 *            the error message
	 */
	public void error(String filename, int line, String message);

	/**
	 * Report a warning about an AADL text file.
	 *
	 * @param loc
	 *            The location on which the warning is located.
	 * @param message
	 *            the warning message
	 */
	public void warning(LocationReference loc, String message);

	/**
	 * Report a warning about an AADL text file..
	 *
	 * @param filename
	 *            The file in which the warning is located.
	 * @param line
	 *            The line on which the warning is located.
	 * @param message
	 *            the warning message
	 */
	public void warning(String filename, int line, String message);

	/**
	 * Report information about an AADL text file.
	 *
	 * @param loc
	 *            The location on which the information is located.
	 * @param message
	 *            the information message
	 */
	public void info(LocationReference loc, String message);

	/**
	 * Report information about an AADL text file..
	 *
	 * @param filename
	 *            The file in which the information is located.
	 * @param line
	 *            The line on which the information is located.
	 * @param message
	 *            the information message
	 */
	public void info(String filename, int line, String message);
}
