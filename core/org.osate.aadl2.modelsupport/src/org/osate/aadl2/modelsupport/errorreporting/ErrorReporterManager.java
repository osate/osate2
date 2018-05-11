/* Created on Sep 15, 2005
 */
package org.osate.aadl2.modelsupport.errorreporting;

/**
 * Generic interface for objects that manage error reporters. Not sure how
 * useful this interface is all by itself, but it abstracts out the
 * commonalities of
 * {@link edu.cmu.sei.aadl.model.pluginsupport.ParseErrorReporterManager} and
 * {@link edu.cmu.sei.aadl.model.pluginsupport.AnalysisErrorReporterManager}.
 *
 * @author aarong
 */
public interface ErrorReporterManager extends InternalErrorReporter {
	/**
	 * Get the total number of messages (errors, warnings, etc.) reported
	 * on the items managed by this error manager.  Does not include
	 * internal errors reported with {@link #internalError(Exception)} and
	 * {@link #internalError(String)}.
	 *
	 * @see #getNumInternalErrors()
	 */
	public int getNumMessages();
}
