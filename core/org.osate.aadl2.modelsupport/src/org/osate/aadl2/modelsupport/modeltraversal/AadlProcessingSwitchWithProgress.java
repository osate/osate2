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
package org.osate.aadl2.modelsupport.modeltraversal;

import org.eclipse.core.runtime.IProgressMonitor;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;

/**
 * An extension of {@link AadlProcessingSwitch} that includes a field
 * for referencing an {@link org.eclipse.core.runtime.IProgressMonitor}.
 * In addition, it adds a new method {@link #checkIfCancelled} that checks
 * to see if the monitor has been set to cancelled and, if so, cancels
 * the traversal via {@link ForAllElement#cancelTraversal}.
 *
 * @author aarong
 */
public abstract class AadlProcessingSwitchWithProgress extends AadlProcessingSwitch {
	/** The progress monitor */
	protected final IProgressMonitor monitor;

	protected AadlProcessingSwitchWithProgress(final IProgressMonitor pm, final int defTraversal,
			final AnalysisErrorReporterManager errMgr) {
		super(defTraversal, errMgr);
		monitor = pm;
	}

	protected AadlProcessingSwitchWithProgress(final IProgressMonitor pm, final int defTraversal) {
		super(defTraversal);
		monitor = pm;
	}

	protected AadlProcessingSwitchWithProgress(final IProgressMonitor pm, final AnalysisErrorReporterManager errMgr) {
		super(errMgr);
		monitor = pm;
	}

	protected AadlProcessingSwitchWithProgress(final IProgressMonitor pm) {
		monitor = pm;
	}

	/**
	 * Check the progress monitor to see if the user has requested a
	 * cancellation.  Cancel the traversal if so.
	 */
	protected final void checkIfCancelled() {
		if (monitor.isCanceled()) {
			cancelTraversal();
		}
	}
}