/* Created on Sep 15, 2005
 */
package org.osate.aadl2.modelsupport.errorreporting;

/**
 * Interface for reporting internal errors. An internal error that occures
 * during the operation of an analysis or other operation, the prevents the
 * operation from completing normally. It is distinct from an error in the AADL
 * textfile or AADL object model that prevent the correct execution of the
 * analysis, etc. Of course, such an error might <em>cause</em> an internal
 * error, e.g., a {@link java.lang.NullPointerException} or
 * {@link java.lang.IndexOutOfBoundsException}.
 *
 * @author aarong
 */
public interface InternalErrorReporter {
	/**
	 * Report an error in the operation of the client task itself.
	 *
	 * @param message The error message.
	 */
	public void internalError(String message);

	/**
	 * Report an error in the operation of the client task itself.
	 *
	 * @param e The exception that caused the error.
	 */
	public void internalError(Exception e);

	/**
	 * Get the number of internal errors reported with this error manager
	 * since it was created.  Currently there is no way to clear the count
	 * of internal errors because this can be done by simply creating a new
	 * {@link InternalErrorReporter}.
	 */
	public int getNumInternalErrors();
}
