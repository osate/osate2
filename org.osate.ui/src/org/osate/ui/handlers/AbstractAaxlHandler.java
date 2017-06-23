/**
 * <copyright>
 * Copyright 2016 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/legal/epl-v10.html.
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
 * of Defense under Contract FA8721-05-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 * </copyright>
 */
package org.osate.ui.handlers;

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
import org.eclipse.ui.handlers.HandlerUtil;
import org.osate.aadl2.Element;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.aadl2.modelsupport.AadlConstants;
import org.osate.aadl2.modelsupport.WriteToFile;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterFactory;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.errorreporting.MarkerAnalysisErrorReporter;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.ui.dialogs.Dialog;

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
	
	private String issuePrefix = "";
	
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
	 * Find out if there were any errors initializing the property references.
	 */
	protected final boolean hasPropertyLookupErrors() {
		return !notFound.isEmpty();
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
	
	/**
	 * Report an internal error in the operation of the action.
	 */
	protected final void internalError(final String msg) {
		errManager.internalError(msg);
	}
	
	/**
	 * Initialize the state of analysis.  For example,
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
	protected boolean initializeAnalysis(NamedElement object) {
		return true;
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
	protected boolean finalizeAnalysis() {
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
}