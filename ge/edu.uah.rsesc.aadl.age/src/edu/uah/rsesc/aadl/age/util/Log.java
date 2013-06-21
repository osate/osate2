package edu.uah.rsesc.aadl.age.util;

import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import edu.uah.rsesc.aadl.age.Activator;


public class Log {
	// Logging convenience methods
	public static void ok(String msg) {
		getLog().log(new Status(IStatus.OK, Activator.PLUGIN_ID, 0, msg, null));
	}
	
	public static void info(String msg) {
		getLog().log(new Status(IStatus.INFO, Activator.PLUGIN_ID, 0, msg, null));
	}
	
	public static void warning(String msg) {
		getLog().log(new Status(IStatus.WARNING, Activator.PLUGIN_ID, 0, msg, null));
	}
	
	public static void error(String msg) {
		getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, 0, msg, null));
	}
	
	public static void error(String msg, Throwable ex) {
		getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, 0, msg, ex));
	}
	
	private static ILog getLog() {
		return Activator.getDefault().getLog();
	}
}
