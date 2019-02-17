/* Created on Sep 15, 2005
 */
package org.osate.aadl2.modelsupport.errorreporting;

import org.eclipse.core.runtime.Platform;
import org.osate.core.OsateCorePlugin;

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
	private static InternalErrorReporter internalErrDelegate = Platform.isRunning()
			? new LogInternalErrorReporter(OsateCorePlugin.getDefault().getBundle())
			: WriterInternalErrorReporter.SYSTEM_ERR;

	protected AbstractErrorReporterManager() {
	}

	@Override
	public void internalError(final String message) {
		internalErrDelegate.internalError(message);
	}

	@Override
	public void internalError(final Exception e) {
		internalErrDelegate.internalError(e);
	}

	@Override
	public int getNumInternalErrors() {
		return internalErrDelegate.getNumInternalErrors();
	}
}
