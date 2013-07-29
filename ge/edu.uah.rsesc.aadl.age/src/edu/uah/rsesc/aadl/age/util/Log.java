package edu.uah.rsesc.aadl.age.util;

import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import edu.uah.rsesc.aadl.age.Activator;

public class Log {
	// Logging convenience methods
	public static void ok(String msg) {
		log(IStatus.OK, msg, null);
	}
	
	public static void info(String msg) {
		log(IStatus.INFO, msg, null);
	}
	
	public static void warning(String msg) {
		log(IStatus.WARNING, msg, null);
	}
	
	public static void error(String msg) {
		log(IStatus.ERROR, msg, null);
	}
	
	public static void error(String msg, Throwable ex) {
		log(IStatus.ERROR, msg, ex);
	}
	
	private static void log(final int severity, final String msg, final Throwable ex) {
		final StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		final String msgPrefix = (stackTrace.length > 3) ? (stackTrace[3].getClassName() + "." + stackTrace[3].getMethodName() + "(): ") : "";
		getLog().log(new Status(severity, Activator.PLUGIN_ID, 0, msgPrefix + msg, ex));
	}
	
	private static ILog getLog() {
		return Activator.getDefault().getLog();
	}
}
