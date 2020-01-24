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
