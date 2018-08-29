/* Created on Sep 14, 2005
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
