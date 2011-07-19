/* Created on Sep 15, 2005
 */
package org.osate.aadl2.modelsupport.errorreporting;

/**
 * Abstract implementation of
 * {@link edu.cmu.sei.aadl.model.pluginsupport.ErrorReporterManager} that
 * delegates The implementation of the methods {@link #internalError(Exception)},
 * {@link #internalError(String)}, and {@link #getNumInternalErrors()} to
 * another {@link edu.cmu.sei.aadl.model.pluginsupport.InternalErrorReporter}
 * object. This is done to acheive a sort of "mix-in" implementation, because
 * the {@link edu.cmu.sei.aadl.model.pluginsupport.ParseErrorReporterManager}
 * and {@link edu.cmu.sei.aadl.model.pluginsupport.AnalysisErrorReporterManager}
 * in general have quite different (although similar) implementations, although
 * it is likely that in any given environment they will want to share the
 * implementation of the internal error reporter (e.g., to log events to the
 * Eclipse "error" view).
 * 
 * @author aarong
 */
public abstract class AbstractErrorReporterManager implements ErrorReporterManager {
	private final InternalErrorReporter internalErrDelegate;
	
	protected AbstractErrorReporterManager(final InternalErrorReporter ier) {
		internalErrDelegate = ier;
	}

	public void internalError(final String message) {
		internalErrDelegate.internalError(message);
	}

	public void internalError(final Exception e) {
		internalErrDelegate.internalError(e);
	}

	public int getNumInternalErrors() {
		return internalErrDelegate.getNumInternalErrors();
	}
}
