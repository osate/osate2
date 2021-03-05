/**
 * Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file). 
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
package org.osate.ui.handlers;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.osate.aadl2.Element;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyConstant;
import org.osate.aadl2.PropertyType;
import org.osate.aadl2.UnitLiteral;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.aadl2.modelsupport.AadlConstants;
import org.osate.aadl2.modelsupport.WriteToFile;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterFactory;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.errorreporting.MarkerAnalysisErrorReporter;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.aadl2.util.Aadl2Util;
import org.osate.ui.dialogs.Dialog;
import org.osate.xtext.aadl2.properties.util.GetProperties;

/**
 * Abstract superclass for {@link org.osate.ui.handlers.AaxlReadOnlyHandlerAsJob}.
 * Contains all the utility methods {@link #lookupPropertyDefinition(String, String)},
 * {@link #lookupPropertyType(String, String)}, etc.  Abstracts the Eclipse
 * job creation process.  Calls {@link #createJob(Element)} to get the
 * job to run.  It is expected that the job invoke {@link #actionBody(IProgressMonitor, Element)}.
 * This method initializes the OSATE action by creating the error reporter
 * manager, calling {@link #initPropertyReferences()}, etc., and finally
 * invokes {@link #doAaxlAction(IProgressMonitor, Element)} to run the
 * specific analysis action body.
 *
 * <p>Users should not extend this class directly, but should extend
 * {@link org.osate.ui.actions.AaxlReadOnlyHandlerAsJob}.
 *
 * @author aarong
 */
public abstract class AbstractAaxlHandler extends AbstractHandler {
	private static final String ERROR_SEPARATOR = ", ";
	private static final String ERROR_MESSAGE = "Unable to find ";
	private static final String PREDECLARED = "predeclared ";
	private static final String PROP_DEF = "property definition ";
	private static final String PROP_CONST = "property constant ";
	private static final String PROP_TYPE = "property type ";
	private static final String COLON_COLON = "::";
	private static final String ERROR_TITLE = "Plug-in Initialization Error";
	
	private ExecutionEvent event;
	
	/** Get the name of the action to display in the Job, etc. */
	protected abstract String getActionName();
	
	/**
	 * The manager of error reporters. Set by the run action to the resource of
	 * the selected item
	 */
	protected AnalysisErrorReporterManager errManager;
	
	protected WriteToFile csvlog = null;
	
	protected StringBuffer summaryReport;
	
	/**
	 * sets up a CSV log in the report folder using report type as subfolder
	 */
	public void setCSVLog(String reporttype, EObject root) {
		csvlog = new WriteToFile(reporttype, root);
	}
	
	/**
	 * sets up a CSV log in the report folder using report type as subfolder
	 */
	public void setTXTLog(String reporttype, EObject root) {
		csvlog = new WriteToFile(reporttype, root, "txt");
	}
	
	private String issuePrefix = "";
	
	public void setIssuePrefix(String prefix) {
		issuePrefix = prefix;
	}
	
	/**
	 * Use by the property reference initialization process to keep track
	 * of the property references that could not be found.
	 */
	private final List<String> notFound = new LinkedList<>();
	
	/**
	 * The model object that controls the property set name space.
	 * See {@link OsateResourceManager#findPropertySet(String, Element)}.
	 */
	private Element context;
	
	/**
	 * The action has been activated. Indirectly invokes the body of the
	 * action, {@link #doAaxlAction(IProgressMonitor, Element)}, by setting up a
	 * {@link org.eclipse.ui.progress.UIJob} that invokes
	 * (default visibility method) <code>processAaxlAction</code>.
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		this.event = event;
		Element root = null;
		root = AadlUtil.getElement(getCurrentSelection(event));
		if (root != null) {
			/*
			 * Here we create the job, and then do two very important things:
			 * (1) set the scheduling rule so that the job locks up the
			 * entire workspace so that nobody messes with it while run.
			 * (2) set the job to be a user job so that we get the
			 * nice progress dialog box AND the option to run the job in the
			 * background.
			 */
			final Job job = createJob(root);
			job.setRule(ResourcesPlugin.getWorkspace().getRoot());
			job.setUser(true); // important!
			job.schedule();
		}
		return null;
	}
	
	protected final void actionBody(final IProgressMonitor monitor, final Element root) {
		final Resource resource = root.eResource();
		errManager = new AnalysisErrorReporterManager(getAnalysisErrorReporterFactory());
		summaryReport = new StringBuffer();

		// Root cannot be null (see above)
		// init the context object. It is used by the lookup methods for initializing property references
		context = root instanceof SystemInstance ? ((SystemInstance) root).getComponentImplementation() : root;

		// Init the properties
		notFound.clear();
		initPropertyReferences();
		initializeAction((NamedElement) root);
		if (suppressErrorMessages() || !reportPropertyLookupErrors()) {
			// Run the command (indirectly)
			processAaxlAction(monitor, resource, root);
		}
		finalizeAction();
	}
	
	protected abstract Job createJob(Element root);
	
	// --- BEGIN: Property Reference management -------------------------------
	
	/**
	 * Plug-ins override this to initialize references to property
	 * definitions and constants that they use.  The default implementation
	 * does nothing
	 *
	 */
	protected void initPropertyReferences() {
		// Default implementation does nothing.
	}
	
	/**
	 * Lookup a particular property definition, updating the error list if it is
	 * not found.
	 *
	 * @return The property defintion, or <code>null</code> if it is not
	 *         found.
	 */
	protected final Property lookupPropertyDefinition(final String ps, final String name) {
		final Property pd = GetProperties.lookupPropertyDefinition(context, ps, name);
		if (Aadl2Util.isNull(pd)) {
			notFound.add(PROP_DEF + ps + COLON_COLON + name);
		}
		return pd;
	}
	
	/**
	 * Lookup a particular optional property definition. Does not update the
	 * error list if the definition is not found. It is assumed the plug-in is
	 * written in such a way that it works correctly even when the definition is
	 * absent.
	 *
	 * @return The property definition or <code>null</code> if it is not
	 *         found.
	 */
	protected final Property lookupOptionalPropertyDefinition(final String ps, final String name) {
		return GetProperties.lookupPropertyDefinition(context, ps, name);
	}
	
	/**
	 * Lookup a particular predeclared property definition, updating the error
	 * list if it is not found.
	 *
	 * @return The property defintion, or <code>null</code> if it is not
	 *         found.
	 */
	protected final Property lookupPropertyDefinition(final String name) {
		final Property pd = GetProperties.lookupPropertyDefinition(context, null, name);
		if (pd == null) {
			notFound.add(PREDECLARED + PROP_DEF + name);
		}
		return pd;
	}
	
	/**
	 * Lookup a particular property type, updating the error list if it is not
	 * found.
	 *
	 * @return The property type, or <code>null</code> if it is not found.
	 */
	protected final PropertyType lookupPropertyType(final String ps, final String name) {
		final PropertyType pt = GetProperties.lookupPropertyType(context, ps, name);
		if (pt == null) {
			notFound.add(PROP_TYPE + ps + COLON_COLON + name);
		}
		return pt;
	}
	
	/**
	 * Lookup a particular unit literal, updating the error list if it or its
	 * declaring unit type is not found.
	 *
	 * @return The unit literal, or <code>null</code> if it or it's
	 * declaring unit type is not found.
	 */
	protected final UnitLiteral lookupUnitLiteral(final String ps, final String unitType, final String literalName) {
		final UnitLiteral literal = GetProperties.findUnitLiteral(context, ps + "::" + unitType, literalName);
		if (literal == null) {
			notFound.add(MessageFormat.format("unit literal {0} in type {1}::{2}",
					new Object[] { literalName, ps, unitType }));
		}
		return literal;
	}
	
	/**
	 * Lookup a particular enumeration literal, updating the error list if it or its
	 * declaring enumeration type is not found.
	 *
	 * @return The enumeration literal, or <code>null</code> if it or it's
	 * declaring enumeration type is not found.
	 */
	protected final EnumerationLiteral lookupEnumerationLiteral(final String ps, final String enumType,
			final String literalName) {
		final EnumerationLiteral literal = GetProperties.findEnumerationLiteral(context, ps + "::" + enumType,
				literalName);
		if (literal == null) {
			notFound.add(MessageFormat.format("enumeration literal {0} in type {1}::{2}",
					new Object[] { literalName, ps, enumType }));
		}
		return literal;
	}
	
	/**
	 * Lookup a particular optional property type definition. Does not update
	 * the error list if the type is not found. It is assumed the plug-in is
	 * written in such a way that it works correctly even when the type is
	 * absent.
	 *
	 * @return The property type or <code>null</code> if it is not found.
	 */
	protected final PropertyType lookupOptionalPropertyType(final String ps, final String name) {
		return GetProperties.lookupPropertyType(context, ps, name);
	}
	
	/**
	 * Lookup a particular predeclared property type, updating the error list
	 * if it is not found.
	 *
	 * @return The property type or <code>null</code> if it is not found.
	 */
	protected final PropertyType lookupPropertyType(final String name) {
		final PropertyType pt = GetProperties.lookupPropertyType(context, name);
		if (pt == null) {
			notFound.add(PREDECLARED + PROP_TYPE + name);
		}
		return pt;
	}
	
	/**
	 * Lookup a particular unit literal from a predeclared property type,
	 * updating the error list if it or its declaring unit type is not found.
	 *
	 * @return The unit literal, or <code>null</code> if it or it's
	 * declaring unit type is not found.
	 */
	protected final UnitLiteral lookupUnitLiteral(final String unitType, final String literalName) {
		final UnitLiteral literal = GetProperties.findUnitLiteral(context, unitType, literalName);
		if (literal == null) {
			notFound.add(MessageFormat.format("unit literal {0} in predeclared type {1}",
					new Object[] { literalName, unitType }));
		}
		return literal;
	}
	
	/**
	 * Lookup a particular enumeration literal from a predeclared property type,
	 * updating the error list if it or its declaring enumeration type is not
	 * found.
	 *
	 * @return The enumeration literal, or <code>null</code> if it or it's
	 * declaring enumeration type is not found.
	 */
	protected final EnumerationLiteral lookupEnumerationLiteral(final String enumType, final String literalName) {
		final EnumerationLiteral literal = GetProperties.findEnumerationLiteral(context, enumType, literalName);
		if (literal == null) {
			notFound.add(MessageFormat.format("enumeration literal {0} in predeclared type {1}",
					new Object[] { literalName, enumType }));
		}
		return literal;
	}
	
	/**
	 * Lookup a particular property constant, updating the error list if it is
	 * not found.
	 *
	 * @return The property constant or <code>null</code> if it is not found.
	 */
	protected final PropertyConstant lookupPropertyConstant(final String name) {
		final PropertyConstant pc = GetProperties.lookupPropertyConstant(context, name);
		if (pc == null) {
			notFound.add(PREDECLARED + PROP_CONST + name);
		}
		return pc;
	}
	
	/**
	 * Lookup a particular predeclared property constant, updating the error
	 * list if it is not found.
	 *
	 * @return The property constant or <code>null</code> if it is not found.
	 */
	protected final PropertyConstant lookupPropertyConstant(final String ps, final String name) {
		final PropertyConstant pc = GetProperties.lookupPropertyConstant(context, ps, name);
		if (pc == null) {
			notFound.add(PROP_CONST + ps + COLON_COLON + name);
		}
		return pc;
	}
	
	/**
	 * Lookup a particular optional property constant definition. Does not
	 * update the error list if the type is not found. It is assumed the plug-in
	 * is written in such a way that it works correctly even when the constant
	 * is absent.
	 *
	 * @return The property constant or <code>null</code> if it is not found.
	 */
	protected final PropertyConstant lookupOptionalPropertyConstant(final String ps, final String name) {
		return GetProperties.lookupPropertyConstant(context, ps, name);
	}
	
	/**
	 * Find out if there were any errors initializing the property references.
	 */
	protected final boolean hasPropertyLookupErrors() {
		return !notFound.isEmpty();
	}
	
	/**
	 * Get the property lookup errors.
	 * @return A List of strings, where each string names the property
	 * refernece or property constant that could not be found.  Meant
	 * to be used to construct a larger error message.
	 */
	protected final List<String> getPropertyLookupErrors() {
		return Collections.unmodifiableList(new ArrayList<>(notFound));
	}
	
	/**
	 * Override this to return <code>true</code> if the default error
	 * reporting mechanism should not be used. By default the action will report
	 * those property references that could not be found and avoids invoking
	 * {@link #doAaxlAction(IProgressMonitor, Element)}. If this method returns
	 * <code>true</code> then the error reporting will be suppressed and
	 * {@link #doAaxlAction(IProgressMonitor, Element)}will be invoked. The
	 * intent here, however, is that the implementation of
	 * {@link #doAaxlAction(IProgressMonitor, Element)}will check whether there
	 * were errors and report them in its own way. This is useful if the plug-in
	 * has a more sophisticated initialziation process and could have additional
	 * start up errors that it needs to report. The lookup errors are available
	 * to the body of the action via {@link #getPropertyLookupErrors()}.
	 *
	 * @return The default implementation returns <code>false</code>.
	 */
	protected boolean suppressErrorMessages() {
		return false;
	}
	
	/**
	 * Check if there were property lookup errors and put up an
	 * error dialog box if there were.
	 * @return Whether there any lookup errors to be reported.
	 */
	protected final boolean reportPropertyLookupErrors() {
		if (hasPropertyLookupErrors()) {
			final StringBuffer sb = new StringBuffer();
			sb.append(ERROR_MESSAGE);
			for (final Iterator<String> i = notFound.iterator(); i.hasNext();) {
				final String s = i.next();
				sb.append(s);
				if (i.hasNext()) {
					sb.append(ERROR_SEPARATOR);
				}
			}
			Dialog.showError(ERROR_TITLE, sb.toString());
			return true;
		} else {
			return false;
		}
	}
	
	// --- END: Property Reference management ---------------------------------
	
	/**
	 * This method allows subclasses to wrap the call of
	 * {@link #doAaxlAction(Element)} with additional processing. For example,
	 * {@link AaxlModifyHandlerAsJob} wrap the call
	 * to make sure that the resource is saved if it was changed.
	 *
	 * <p>
	 * An implementation of this method must make sure that
	 * {@link #doAaxlAction(Element)} is invoked.
	 *
	 * <p>This initial implementation just invokes does nothing other than
	 * call {@link #doAaxlAction(Element)}.
	 *
	 * @param rsrc
	 *            The resource containing the Element to be processed.
	 * @param root
	 *            The Element to be processed by the action.
	 */
	// "default" visibility so that it cannot be used outside of the package
	void processAaxlAction(final IProgressMonitor monitor, final Resource rsrc, final Element root) {
		doAaxlAction(monitor, root);
	}
	
	/**
	 * This method will be defined by the ultimate subclass, and implements the
	 * true body of the action. It is invoked along a call chain from the
	 * {@link #execute(ExecutionEvent)} method, which first makes sure the OSATE
	 * environment is loaded and other house cleaning things.
	 *
	 * <p>
	 * It is a good idea, although not required, for the action to check to see
	 * if the {@link IProgressMonitor#isCanceled() action has been cancelled}.
	 * If cancellation is detected, this method should throw the unchecked
	 * exception {@link org.eclipse.core.runtime.OperationCanceledException}.
	 *
	 * @param monitor
	 *            The progress monitor to use to provide feedback about the
	 *            action and to check for cancellation.
	 * @param root
	 *            The currently selected Element in the workspace.
	 * @exception org.eclipse.core.runtime.OperationCanceledException
	 *                Thrown if the method detected that the action has been
	 *                cancelled.
	 */
	protected abstract void doAaxlAction(IProgressMonitor monitor, Element root);
	
	/** the current selection in the AADL model
	 *
	 */
	protected Object getCurrentSelection(ExecutionEvent event) {
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		if (selection instanceof IStructuredSelection && ((IStructuredSelection) selection).size() == 1) {
			Object object = ((IStructuredSelection) selection).getFirstElement();
			return object;
		} else {
			return null;
		}
	}
	
	protected final IWorkbenchWindow getWindow() {
		return HandlerUtil.getActiveWorkbenchWindow(event);
	}
	
	protected Shell getShell() {
		return HandlerUtil.getActiveShell(event);
	}
	
	/**
	 * Get the type of the markers that the action might create. This is used to
	 * create a new {@link MarkerAnalysisErrorReporter}for that marker type for
	 * the resource being analyzed. Any existing markers of that type on the
	 * resource will be removed.
	 *
	 * <p>
	 * Subclasses should override this method to change the marker type used by
	 * the action. The initial implementation returns the generic
	 * <code>"AadlObjectMarker"</code> marker type, and will therefore cause
	 * all existing OSATE markers to be removed from the resource.
	 *
	 * @see #getDefaultAnalysisErrorReporterFactory()
	 * @see #getAnalysisErrorReporterFactory()
	 *
	 * @return The marker type to use for the action's results. This initial
	 *         implementation specifically returns
	 *         <code>"AadlObjectMarker"</code>.
	 */
	protected String getMarkerType() {
		return AadlConstants.AADLOBJECTMARKER;
	}
	
	/**
	 * Generate an error reporter factory that creates the default error reporters
	 * used by the analysis.  The default
	 * error reporter is a {@link MarkerAnalysisErrorReporter} that generates
	 * markers with the marker type determined by {@link #getMarkerType()}.
	 *
	 * <p>This method exists so that subclasses can override
	 * {@link #getAnalysisErrorReporterFactory()} to create
	 * factories that return instances of
	 * {@link edu.cmu.sei.aadl.model.pluginsupport.ChainedAnalysisErrorReporter}
	 * where one of the delegate error reporters is the default error reporter.
	 *
	 * @see #getMarkerType()
	 * @see #getAnalysisErrorReporterFactory()
	 */
	protected final AnalysisErrorReporterFactory getDefaultAnalysisErrorReporterFactory() {
		return new MarkerAnalysisErrorReporter.Factory(getMarkerType());
	}
	
	/**
	 * Get the factory to be used to generate error reporters for this action.
	 *
	 * @see #getMarkerType()
	 * @see #getDefaultAnalysisErrorReporterFactory()
	 */
	protected AnalysisErrorReporterFactory getAnalysisErrorReporterFactory() {
		return getDefaultAnalysisErrorReporterFactory();
	}
	
	/**
	 * Get the error mananger used by the action.
	 * @return Error Reporter
	 */
	protected final AnalysisErrorReporterManager getErrorManager() {
		return errManager;
	}
	
	/**
	 * Get the error manager used by the action.
	 * @return Error Reporter
	 */
	protected final WriteToFile getCSVLog() {
		return csvlog;
	}
	
	/**
	 * Report error message on object as result of action as marker and in csv log.
	 * @param obj Element that has been processed by the action
	 * @param msg The error message
	 */

	public void error(final Element obj, final String msg) {
		errManager.error(obj, msg);
		logError(obj, msg);
	}
	
	/**
	 * log error message on object as result of action.
	 * @param msg The error message
	 */
	public final void logError(final String msg) {
		if (csvlog != null) {
			csvlog.addOutputNewline(issuePrefix + "ERROR: " + msg);
		}
	}
	
	public final void logError(Element ci, final String msg) {
		if (csvlog != null) {
			String name = ci instanceof NamedElement ? " " + ((NamedElement) ci).getName() + ": " : ": ";
			csvlog.addOutputNewline(issuePrefix + "ERROR: " + name + msg);
		}
	}
	
	/**
	 * Log warning message on object as result of action.
	 * @param msg The warning message
	 */
	public final void logWarning(final String msg) {
		if (csvlog != null) {
			csvlog.addOutputNewline(issuePrefix + "Warning! " + msg);
		}
	}
	
	public final void logWarning(final NamedElement e, final String msg) {
		if (csvlog != null) {
			csvlog.addOutputNewline(issuePrefix + "Warning! " + e.getName() + ": " + msg);
		}
	}
	
	/**
	 * Record warning message on object as result of action as marker and in csv log
	 * @param obj Element that has been processed by the action
	 * @param msg The warning message
	 */
	public final void warning(final Element obj, final String msg) {
		errManager.warning(obj, msg);
		if (obj instanceof NamedElement)
			logWarning((NamedElement) obj, msg);
		else
			logWarning(msg);
	}
	
	/**
	 * log an informative  message on object as result of action.
	 * @param msg The informative message
	 */
	public final void logInfoNoNewLine(final String msg) {
		if (csvlog != null) {
			csvlog.addOutput(msg);
		}
	}
	
	/**
	 * log an informative  message on object as result of action.
	 * @param msg The informative message
	 */
	public final void logInfo(final String msg) {
		if (csvlog != null) {
			csvlog.addOutputNewline(msg);
		}
	}
	
	public final void logInfo(final NamedElement e, final String msg) {
		if (csvlog != null) {
			csvlog.addOutputNewline(issuePrefix + e.getName() + ": " + msg);
		}
	}
	
	/**
	 * Record an informative  message on object as result of action as Marker and in CSV log
	 * @param obj Element that has been processed by the action
	 * @param msg The informative message
	 */
	public final void info(final Element obj, final String msg) {
		errManager.info(obj, msg);
		if (obj instanceof NamedElement)
			logInfo((NamedElement) obj, msg);
		else
			logInfo(msg);
	}
	
	public void errorSummary(final NamedElement obj, String somName, String msg) {
		if (somName != null && !somName.isEmpty() && !somName.equalsIgnoreCase("No Modes")) {
			msg = "In SystemMode " + somName + ": " + msg;
		}
		errManager.error(obj, msg);
		summaryReport.append("** " + msg + "\n");
	}
	
	public void warningSummary(final NamedElement obj, String somName, String msg) {
		if (somName != null && !somName.isEmpty() && !somName.equalsIgnoreCase("No Modes")) {
			msg = "In SystemMode " + somName + ": " + msg;
		}
		errManager.warning(obj, msg);
		summaryReport.append("* " + msg + "\n");
	}
	
	public void infoSummary(final NamedElement obj, String somName, String msg) {
		if (somName != null && !somName.isEmpty() && !somName.equalsIgnoreCase("No Modes")) {
			msg = " in SystemMode " + somName + ": " + msg;
		}
		errManager.info(obj, msg);
		summaryReport.append(msg + "\n");
	}
	
	public void infoSummaryReportOnly(Element obj, SystemOperationMode som, String msg) {
		if (som != null && !som.getName().equalsIgnoreCase("No Modes")) {
			msg = "In SystemMode " + som.getName() + ": " + msg;
		}
		summaryReport.append(msg + "\n");
	}
	
	public String getResultsMessages() {
		synchronized (summaryReport) {
			return summaryReport.toString();
		}
	}
	
	/**
	 * Report an internal error in the operation of the action.
	 */
	protected final void internalError(final String msg) {
		errManager.internalError(msg);
	}
	
	/**
	 * Report an internal error in the operation of the action.
	 */
	protected final void internalError(final Exception e) {
		errManager.internalError(e);
	}
	
	/**
	 * Initialize the state of the action.  For example,
	 * this can open a dialog box to get additional parameters to the
	 * analysis.  The analysis state should be initialized by setting
	 * fields that are then used by {@link #analyzeDeclarativeModel}
	 * and {@link #analyzeInstanceModel}.
	 *
	 * <p>The default implementation of this method simply returns
	 * <code>true</code>.
	 *
	 * @return <code>true</code> if the analysis should proceed or
	 * <code>false</code> if the user cancelled the analysis.
	 */
	protected boolean initializeAction(NamedElement object) {
		return true;
	}
	
	/**
	 * finalize the state of analysis.  For example,
	 * this can close a report being generated.
	 * <p>The default implementation of this method simply returns
	 * <code>true</code>.
	 *
	 * @return <code>true</code> if the analysis should proceed or
	 * <code>false</code> if the user cancelled the analysis.
	 */
	protected boolean finalizeAction() {
		if (csvlog != null) {
			csvlog.saveToFile(getActionName() + " Report\n\n" + summaryReport.toString());
		}
		return true;
	}
	
	public String getAnalysisMarkerType() {
		return getMarkerType();
	}
}