/*
 *
 * <copyright>
 * Copyright  2004 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/legal/cpl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE "DELIVERABLES") ARE ON AN "AS-IS" BASIS.
 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
 * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
 * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
 * MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
 * APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.
 *
 * Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
 * employees, and agents from all claims or demands made against them (and any related losses, expenses, or
 * attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
 * misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
 * assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
 * product liability, personal injury, death, damage to property, or violation of any laws or regulations.
 *
 * Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 *
 * </copyright>
 *
 *
 * %W%
 * @version %I% %H%
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
