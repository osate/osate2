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
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;
import org.osate.aadl2.Element;

/**
 * TODO: Fix this
 *
 * This class manages the creation and use of
 * {@link edu.cmu.sei.aadl.model.pluginsupport.AnalysisErrorReporter} instances
 * across a set of AADL text file resources. The manager keeps track of EMF
 * {@link org.eclipse.emf.ecore.resource.Resource} objects and not Eclipse
 * {@link org.eclipse.core.resources.IResource} objects because the primary
 * purpose of this class is to provide the correct error reporter when trying to
 * interpret and resolve an already parsed model. So the errors are going to be
 * found when using {@link Element} instances, but
 * the errors reported on the AADL text file. This class solves the problem of
 * mapping from the Element to the text file.
 *
 * <p>
 * It's probably redundant to have the methods take the filename as a parameter
 * as they do, because the error reporters could already have the filename
 * information, but the parser is already written to work that way. Also, I
 * suppose we could have the situation where many files are used to create a
 * single resource, in which case the filename would not be redundant.
 *
 * <P>
 * The manager is supplied with a
 * {@link edu.cmu.sei.aadl.model.pluginsupport.ParseErrorReporterFactory}
 * instance that is used to create the error reporters.
 *
 * <p>
 * <em>This class purposely only depends on EMF, and not on Eclipse</em>.
 * That is, while it would be convienent to make explicit use of IResources
 * here, we have chosen not to. Specific {@link ParseErrorReporter} may, of
 * course, have whatever dependencies they like.
 *
 * @see edu.cmu.sei.aadl.model.pluginsupport.ParseErrorReporter
 * @see edu.cmu.sei.aadl.model.pluginsupport.ParseErrorReporterFactory
 *
 * @author aarong
 */
public final class AnalysisErrorReporterManager extends AbstractErrorReporterManager {
	private static final String[] emptyAttributes = new String[0];
	private static final Object[] emptyValues = new Object[0];

	/** Singleton reference to an error manager that ignores all messages. */
	public static final AnalysisErrorReporterManager NULL_ERROR_MANANGER = new AnalysisErrorReporterManager(
			NullAnalysisErrorReporter.factory);

	/** The factory to use. */
	private final AnalysisErrorReporterFactory factory;

	/** The mapping from Resources to error reporters. */
	private final Map reportersMap;

	/**
	 * A list of all the reporters. Replicates {@link #reportersMap}, but it's
	 * simpler and faster to traverse this list than mess with the hashtable.
	 */
	private final List reportersList;

	/**
	 * The prefix to append to the beginning of each message.  This is
	 * derived from the stack of prefixes {@link #prefixStack}.
	 */
	private String thePrefix = "";

	/**
	 * That stack of prefixes.  The actual prefix is the inorder concatination
	 * of the contents of this list.
	 */
	private LinkedList prefixStack = new LinkedList();

	public AnalysisErrorReporterManager(final AnalysisErrorReporterFactory fact) {
		super();
		factory = fact;
		reportersMap = new HashMap();
		reportersList = new LinkedList();
	}

	/**
	 * Stop managing the given Resource.
	 * @param rsrc The resource to forget about.
	 */
	public final void removeResource(final Resource rsrc) {
		reportersList.remove(reportersMap.remove(rsrc));
	}

	/**
	 * Get the error reporter that is associated with the given {@link Resource}.
	 * If the manager has not yet used the error reporter for the given
	 * resource, the {@link ErrorReporter#deleteMessages()} method is called on
	 * the reporter.
	 *
	 * @exception IllegalArgumentException
	 *                Thrown if a reporter cannot be found or created for the
	 *                given Resource.
	 * @exception NullPointerException
	 *                Thrown if <code>rsrc</code> is <code>null</code>.
	 */
	public final AnalysisErrorReporter getReporter(final Resource rsrc) {
		if (rsrc == null) {
			throw new NullPointerException("Resource is null");
		}
		// Do we have a reporter already?
		AnalysisErrorReporter errReporter = (AnalysisErrorReporter) reportersMap.get(rsrc);
		if (errReporter == null) {
			// don't have it, make a new one and clear it
			errReporter = factory.getReporterFor(rsrc);
			if (errReporter == null) {
				throw new IllegalArgumentException("Could not find error reporter for the resource.");
			}
			reportersMap.put(rsrc, errReporter);
			reportersList.add(errReporter);
			errReporter.deleteMessages();
		}
		return errReporter;
	}

	/**
	 * Get the total number of errors reported across all the error reporters
	 * being managed.
	 */
	public final int getNumErrors() {
		int numErr = 0;
		for (final Iterator i = reportersList.iterator(); i.hasNext();) {
			final AnalysisErrorReporter err = (AnalysisErrorReporter) i.next();
			numErr += err.getNumErrors();
		}
		return numErr;
	}

	/**
	 * Get the total number of warnings reported across all the error reporters
	 * being managed.
	 */
	public final int getNumWarnings() {
		int numWarn = 0;
		for (final Iterator i = reportersList.iterator(); i.hasNext();) {
			final AnalysisErrorReporter err = (AnalysisErrorReporter) i.next();
			numWarn += err.getNumWarnings();
		}
		return numWarn;
	}

	/**
	 * Get the total number of errors reported across all the error reporters
	 * being managed.
	 */
	public final int getNumInfos() {
		int numInfo = 0;
		for (final Iterator i = reportersList.iterator(); i.hasNext();) {
			final AnalysisErrorReporter err = (AnalysisErrorReporter) i.next();
			numInfo += err.getNumInfos();
		}
		return numInfo;
	}

	/**
	 * Get the total number of errors and warnings across all the error reports
	 * being managed.
	 */
	@Override
	public final int getNumMessages() {
		int numMsg = 0;
		for (final Iterator i = reportersList.iterator(); i.hasNext();) {
			final AnalysisErrorReporter err = (AnalysisErrorReporter) i.next();
			numMsg += err.getNumMessages();
		}
		return numMsg;
	}

//	public final void addPrefix(final SystemOperationMode som) {
//		if (!som.getName().equalsIgnoreCase("No Modes")){
//		addPrefix("In SystemMode " + som.getName() + ": ");
//		} else {
//			addPrefix("");
//		}
//	}

	public final void addPrefix(final String pre) {
		prefixStack.addFirst(pre);
		recomputePrefix();
	}

	public final void removePrefix() {
		prefixStack.removeFirst();
		recomputePrefix();
	}

	private void recomputePrefix() {
		final StringBuffer sb = new StringBuffer();
		for (final Iterator i = prefixStack.iterator(); i.hasNext();) {
			sb.append((String) i.next());
		}
		thePrefix = sb.toString();
	}

	/**
	 * Report an error on an Element (AADL object model object) using the error
	 * reporter associated with that object's {@link Resource}.
	 *
	 * @param obj
	 *            the object to which the marker is pointing
	 * @param msg
	 *            the message as string
	 */
	public void error(final Element obj, final String msg) {
		final AnalysisErrorReporter errReporter = getReporter(obj.eResource());
		errReporter.error(obj, thePrefix + msg, emptyAttributes, emptyValues);
	}

	public void error(final Element obj, final String msg, final String[] attrs, final Object[] values) {
		final AnalysisErrorReporter errReporter = getReporter(obj.eResource());
		errReporter.error(obj, thePrefix + msg, attrs, values);
	}

	/**
	 * Report a warning on an Element (AADL object model object) using the error
	 * reporter associated with that object's {@link Resource}.
	 *
	 * @param obj
	 *            the object to which the marker is pointing
	 * @param msg
	 *            the message as string
	 */
	public void warning(final Element obj, final String msg) {
		final AnalysisErrorReporter errReporter = getReporter(obj.eResource());
		errReporter.warning(obj, thePrefix + msg, emptyAttributes, emptyValues);
	}

	public void warning(final Element obj, final String msg, final String[] attrs, final Object[] values) {
		final AnalysisErrorReporter errReporter = getReporter(obj.eResource());
		errReporter.warning(obj, thePrefix + msg, attrs, values);
	}

	/**
	 * Report an information message on an Element (AADL object model object)
	 * using the error reporter associated with that object's {@link Resource}.
	 *
	 * @param obj
	 *            the object to which the marker is pointing
	 * @param msg
	 *            the message as string
	 */
	public void info(final Element obj, final String msg) {
		final AnalysisErrorReporter errReporter = getReporter(obj.eResource());
		errReporter.info(obj, thePrefix + msg, emptyAttributes, emptyValues);
	}

	public void info(final Element obj, final String msg, final String[] attrs, final Object[] values) {
		final AnalysisErrorReporter errReporter = getReporter(obj.eResource());
		errReporter.info(obj, thePrefix + msg, attrs, values);
	}
}
