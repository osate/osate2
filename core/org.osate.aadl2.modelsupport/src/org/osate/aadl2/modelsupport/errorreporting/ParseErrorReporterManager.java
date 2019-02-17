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
