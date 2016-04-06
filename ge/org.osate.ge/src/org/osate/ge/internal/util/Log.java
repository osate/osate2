/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.internal.util;

import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.osate.ge.internal.Activator;

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
