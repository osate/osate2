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
