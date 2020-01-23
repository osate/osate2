/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
 * All Rights Reserved.
 * 
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 * 
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
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
