/* Created on Sep 15, 2005
 */
package org.osate.aadl2.modelsupport.errorreporting;

/**
 * Abstract implementation of
 * {@link edu.cmu.sei.aadl.model.pluginsupport.InternalErrorReporter} that
 * manages the error count.  The methods {@link #internalError(Exception)}
 * and {@link #internalError(String)} increment the error count and then
 * delegate to the abstract methods {@link #internalErrorImpl(Exception)}
 * and {@link #internalErrorImpl(String)}}, respectively.
 *
 * @author aarong
 */
public abstract class AbstractInternalErrorReporter implements InternalErrorReporter {
	private int numErrs;

	public AbstractInternalErrorReporter() {
		numErrs = 0;
	}

	@Override
	public final void internalError(final String message) {
		numErrs += 1;
		internalErrorImpl(message);

	}

	@Override
	public void internalError(final Exception e) {
		numErrs += 1;
		internalErrorImpl(e);
	}

	@Override
	public final int getNumInternalErrors() {
		return numErrs;
	}

	public abstract void internalErrorImpl(String message);

	public abstract void internalErrorImpl(Exception e);
}
