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
