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

/**
 * Currently there isn't any real useful purpose to interface other than to
 * abstract the commonalities of
 * {@link edu.cmu.sei.aadl.model.pluginsupport.ParseErrorReporter} and
 * {@link edu.cmu.sei.aadl.model.pluginsupport.AnalysisErrorReporter}.
 *
 * @author aarong
 */
public interface ErrorReporter {
	/**
	 * Clear the record of the messages.  The error reporter should (if possible)
	 * remove any messages, for example by deleting output log files, or removing
	 * markers.  This is not always possible, for example, if the messages are sent
	 * to a console.  The messages counts are also reset to zero.
	 */
	public void deleteMessages();

	/**
	 * Get the number of parse errors reported using this reporter object since
	 * it was created or since the last call to {@link #deleteMessages()}.
	 */
	public int getNumErrors();

	/**
	 * Get the number of warnings reported using this reporter object since it
	 * was created or since the last call to {@link #deleteMessages()}.
	 */
	public int getNumWarnings();

	/**
	 * Get the number of infos reported using this reporter object since it
	 * was created or since the last call to {@link #deleteMessages()}.
	 */
	public int getNumInfos();

	/**
	 * Get the number of messages, that is errors, warnings, and information
	 * messages, reported using this reporter object since it was created or
	 * since the last call to {@link #deleteMessages()}.
	 */
	public int getNumMessages();
}
