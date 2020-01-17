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
