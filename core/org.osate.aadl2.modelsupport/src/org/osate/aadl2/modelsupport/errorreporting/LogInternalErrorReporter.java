/* Created on Sep 15, 2005
 */
package org.osate.aadl2.modelsupport.errorreporting;

import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.Bundle;

/**
 * An internal error reporter to sends internal error messages to the
 * Eclipse "Error" view/log.
 *
 * @author aarong
 */
public final class LogInternalErrorReporter extends AbstractInternalErrorReporter {
	private final Bundle bundle;
	private final ILog log;

	/**
	 * Private constructor to enforce singleton pattern.
	 */
	public LogInternalErrorReporter(final Bundle bundle) {
		this.bundle = bundle;
		log = Platform.getLog(bundle);
	}

	@Override
	public void internalErrorImpl(final String message) {
		log.log(new Status(IStatus.ERROR, bundle.getSymbolicName(), IStatus.OK, message, null));
	}

	@Override
	public void internalErrorImpl(final Exception e) {
		final String msg = e.getMessage();
		final String logMsg;
		if (msg != null) {
			logMsg = msg;
		} else {
			logMsg = "Exception " + e.getClass().getName();
		}
		log.log(new Status(IStatus.ERROR, bundle.getSymbolicName(), IStatus.OK, logMsg, e));

	}

//	/**
//	 * TODO compatibility for Topcased 0.7: it uses the 01162006 interface
//	 */
//	public static LogInternalErrorReporter prototype = 		new LogInternalErrorReporter(null);
//
}
