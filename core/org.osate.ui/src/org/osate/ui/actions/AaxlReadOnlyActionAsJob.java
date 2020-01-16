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
package org.osate.ui.actions;

import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.osate.aadl2.Element;
import org.osate.xtext.aadl2.properties.ui.internal.PropertiesActivator;

/**
 * Abstract class for actions button/menu and context menu menu actions that
 * operate on AAXL models. The body of the action is implemented in the
 * {@link #doAaxlAction(IProgressMonitor, Element)} method. The
 * {@link #getMarkerType()} method should also be overridden to return the name
 * of the marker type the analysis should use to report errors. The method
 * {@link #getActionName()} must be implemented to return the name of the
 * analysis job. This name is used by the Eclipse UI when the showing
 * information about the current job, or the list of active jobs, etc.
 *
 * <p>
 * The action is invoked in a {@link org.eclipse.core.resources.WorkspaceJob}.
 * As an workspace job, a single workspace event (if any) is sent at the end of
 * the action, and, more importantly, the workspace is locked from the root
 * object. Thus the action has exclusive access to all the models in the
 * workspace. <em>The job is <b>not</b>
 * guaranteed to run in the SWT/UI thread.</em>
 * The user must use
 * {@link org.eclipse.swt.widgets.Display#asyncExec(java.lang.Runnable)} or
 * {@link org.eclipse.swt.widgets.Display#syncExec(java.lang.Runnable)} to
 * ensure that dialog boxes (if any) are manipulated in the SWT/UI thread. OSATE
 * provides the convenience class
 * {@link org.osate.ui.dialogs.Dialog} that opens up
 * {@link org.osate.ui.dialogs.Dialog#showInfo(String, String) informative},
 * {@link org.osate.ui.dialogs.Dialog#showWarning(String, String) warning},
 * {@link org.osate.ui.dialogs.Dialog#showError(String, String) error},
 * and
 * {@link org.osate.ui.dialogs.Dialog#askQuestion(String, String) question}
 * dialog boxes using the SWT/UI thread.
 *
 * <p>
 * The body of the action,
 * {@link org.osate.ui.actions.AbstractAaxlAction#doAaxlAction(IProgressMonitor, Element)}
 * is passed the Eclipse progress monitor and the currently selected Element in
 * the workspace. It is the responsibility of the subclass to initialize and use
 * the progress monitor. That is, at the minimum, the subclass is expected to
 * call
 * {@link org.eclipse.core.runtime.IProgressMonitor#beginTask(java.lang.String, int)}
 * and {@link org.eclipse.core.runtime.IProgressMonitor#done()} on the progress
 * monitor.
 *
 * <p>A long-running analysis should also periodically check if the user
 * has cancelled the operation by polling
 * method. This is best used via the
 * {@link edu.cmu.sei.aadl.model.util.AadlProcessingSwitchWithProgress} subclass
 * that takes a reference to the progress monitor when it is constructed.
 * Traversals can then poll the progress monitor and cancel the traversal if needed within "case" methods by
 * using the method <code>checkIfCancelled</code>. Traversals
 * can also update the progress monitor via
 * {@link org.eclipse.core.runtime.IProgressMonitor#subTask(java.lang.String)}
 * and {@link org.eclipse.core.runtime.IProgressMonitor#worked(int)} from within
 * "case" methods.
 *
 * <p>
 * If the action ends prematurely becuase it is responding to a cancellation
 * request, <code>doAaxlAction</code> should throw an
 * {@link org.eclipse.core.runtime.OperationCanceledException}.
 *
 * @author aarong
 * 
 * @deprecated Usage of this class should be replaced with
 * {@link org.osate.ui.handlers.AaxlReadOnlyHandlerAsJob}. Will be removed in 2.7.
 */
@Deprecated
public abstract class AaxlReadOnlyActionAsJob extends AbstractAaxlAction {
	public AaxlReadOnlyActionAsJob() {
		super();
		PropertiesActivator act = org.osate.xtext.aadl2.properties.ui.internal.PropertiesActivator.getInstance();
	}

	@Override
	protected Job createJob(final Element root) {
		String name = getActionName();
		if (name == null) {
			name = "<nullActionName>";
		}
		return new ActionAsJob(getActionName(), root);
	}

	private final class ActionAsJob extends WorkspaceJob {
		private final Element root;

		public ActionAsJob(final String name, final Element root) {
			super(name);
			this.root = root;
		}

		@Override
		public IStatus runInWorkspace(final IProgressMonitor monitor) {
			try {
				actionBody(monitor, root);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return Status.OK_STATUS;
		}
	}
}
