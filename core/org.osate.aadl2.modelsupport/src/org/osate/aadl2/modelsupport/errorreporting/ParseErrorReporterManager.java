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

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;

/**
 * This class manages the creation and use of
 * {@link edu.cmu.sei.aadl.model.pluginsupport.ParseErrorReporter} instances
 * across a set of AADL text file resources. The manager indexes error reporters
 * using the OS specific path name of the file.
 *
 * <P>
 * The manager is supplied with a
 * {@link edu.cmu.sei.aadl.model.pluginsupport.ParseErrorReporterFactory}
 * instance that is used to create the error reporters.
 *
 * <p>
 * Primary purpose of this class is to serve as a cache of parse error reporters
 * that ensures each reporter is "cleared" only the first time it is retrieved.
 * Also coordinates errors counts across a set of parsed files. This class used
 * to have more functionality that is now rolled into
 * {@link edu.cmu.sei.aadl.model.pluginsupport.AnalysisToParseErrorReporterAdapter}.
 *
 * @see edu.cmu.sei.aadl.model.pluginsupport.ParseErrorReporter
 * @see edu.cmu.sei.aadl.model.pluginsupport.ParseErrorReporterFactory
 *
 * @author aarong
 */
public final class ParseErrorReporterManager extends AbstractErrorReporterManager {
	/** The factory to use. */
	private final ParseErrorReporterFactory factory;

	/** The mapping from Resources to error reporters. */
	private final Map<Resource, ParseErrorReporter> reportersMap;

	/**
	 * A list of all the reporters. Replicates {@link #reportersMap}, but it's
	 * simpler and faster to traverse this list than mess with the hashtable.
	 */
	private final List<ParseErrorReporter> reportersList;

	public ParseErrorReporterManager(final ParseErrorReporterFactory fact) {
		super();
		factory = fact;
		reportersMap = new HashMap<Resource, ParseErrorReporter>();
		reportersList = new LinkedList<ParseErrorReporter>();
	}

	/**
	 * Get the error reporter that is associated with AADL Text file named by
	 * the given filename.
	 *
	 * @param aadlRsrc
	 *            The EMF Resource associated with the AADL text file to get an
	 *            error reporter for. This may be <code>null</code> if the
	 *            Resource doesn't exist. This is the case when dealing with
	 *            standard property sets because they do not exist in the
	 *            Eclipse workspace and thus do not have IResources. But see
	 *            {@link ParseErrorReporterFactory} regarding <code>null</code>.
	 */
	public final ParseErrorReporter getReporter(final Resource aadlRsrc) {
		ParseErrorReporter errReporter = reportersMap.get(aadlRsrc);
		if (errReporter == null) {
			// don't have it, make a new one and clear it
			errReporter = factory.getReporterFor(aadlRsrc);
			if (errReporter == null) {
				throw new IllegalArgumentException("Could not find error reporter for the file.");
			}
			reportersMap.put(aadlRsrc, errReporter);
			reportersList.add(errReporter);
			errReporter.deleteMessages();
		}
		return errReporter;
	}

	/**
	 * Get the total number of errors across all the error reporters being
	 * managed.
	 */
	public final int getNumErrors() {
		int numErr = 0;
		for (final ParseErrorReporter err : reportersList) {
			numErr += err.getNumErrors();
		}
		return numErr;
	}

	/**
	 * Get the total number of warnings across all the error reporters being
	 * managed.
	 */
	public final int getNumWarnings() {
		int numErr = 0;
		for (final ParseErrorReporter err : reportersList) {
			numErr += err.getNumWarnings();
		}
		return numErr;
	}

	/**
	 * Get the total number of information messages across all the error
	 * reporters being managed.
	 */
	public final int getNumInfos() {
		int numErr = 0;
		for (final ParseErrorReporter err : reportersList) {
			numErr += err.getNumInfos();
		}
		return numErr;
	}

	/**
	 * Get the total number of errors and warnings across all the error reports
	 * being managed.
	 */
	@Override
	public final int getNumMessages() {
		int numErr = 0;
		for (final ParseErrorReporter err : reportersList) {
			numErr += err.getNumMessages();
		}
		return numErr;
	}

	/**
	* Remove all the stored reporters (list and map).
	*
	*/
	public void clean() {
		reportersList.clear();
		reportersMap.clear();
	}
}
