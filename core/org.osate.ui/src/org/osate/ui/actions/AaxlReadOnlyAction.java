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

import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ui.progress.UIJob;
import org.osate.aadl2.Element;
import org.osate.ui.OsateUiPlugin;

/**
 * Abstract class for actions button/menu and context menu menu actions that
 * operate on AAXL models. The body of the action is implemented in the
 * {@link #doAaxlAction(Element)} method. The {@link #getMarkerType()} method
 * should also be overridden to return the name of the marker type the analysis
 * should use to report errors.
 *
 * <p>
 * The action is invoked in a {@link org.eclipse.ui.progress.UIJob} that also
 * wraps the action as a {@link org.eclipse.core.resources.IWorkspaceRunnable}.
 * In this way, the action runs in the UI/SWT thread and is thus able to create
 * dialog boxes without worry. The downside is that the action locks up
 * Eclipse's user interface. As an workspace runnable, a single workspace event
 * (if any) is sent at the end of the action, and, more importantly, the
 * workspace is locked from the root object. Thus the action has exclusive
 * access to all the models in the workspace.
 *
 * <p>This actions puts up a generic progress bar.  Subclasses do not have
 * access to the progress bar, and thus cannot update its status.  (This class
 * exists to be an API-compatible replacement to the original AaxlReadOnlyAction
 * class.  The new preferred class is {@link org.osate.ui.actions.AaxlReadOnlyActionAsJob}
 * that does provide access to the progress bar.)
 *
 * @author aarong
 *
 * @deprecated Usage of this class should be replaced with
 * {@link org.osate.ui.actions.AaxlReadOnlyActionAsJob}. Will be removed in 2.7.
 */
@Deprecated
public abstract class AaxlReadOnlyAction extends AbstractAaxlAction {
	private static final String DEFAULT_NAME = "Analysis";

	/** The constructor. */
	public AaxlReadOnlyAction() {
		super();
	}

	@Override
	protected Job createJob(final Element root) {
		return new UIWorkspaceJob(root);
	}

	private final class UIWorkspaceJob extends UIJob {
		private final Element root;

		public UIWorkspaceJob(final Element root) {
			super(DEFAULT_NAME);
			this.root = root;
		}

		@Override
		public IStatus runInUIThread(final IProgressMonitor monitor) {
			try {
				ResourcesPlugin.getWorkspace().run(new IWorkspaceRunnable() {
					@Override
					public void run(final IProgressMonitor monitor) {
						monitor.beginTask(DEFAULT_NAME, IProgressMonitor.UNKNOWN);
						actionBody(monitor, root);
						monitor.done();
					}
				}, monitor);
			} catch (CoreException e) {
				OsateUiPlugin.log(e);
				e.printStackTrace();
			}
			return Status.OK_STATUS;
		}
	}

	// "default" visibility so that it cannot be used outside of the package
	@Override
	final void processAaxlAction(final IProgressMonitor monitor, final Resource rsrc, final Element root) {
		processAaxlAction(rsrc, root);
	}

	@Override
	protected final void doAaxlAction(final IProgressMonitor monitor, final Element root) {
		doAaxlAction(root);
	}

	// --------------------- Old style methods ---------------

	/**
	 * This method allows subclasses to wrap the call of
	 * {@link #doAaxlAction(Element)} with additional processing. For example,
	 * {@link AaxlModifyAction} wraps the call to make sure that the resources
	 * is saved if it was changed.
	 *
	 * <p>
	 * An implementation of this method must make sure that
	 * {@link #doAaxlAction(Element)} is invoked.
	 *
	 * <p>This initial implementation just invokes does nothing other than
	 * call {@link #doAaxlAction(Element)}.
	 *
	 * @param rsrc
	 *            The resource containing the Element to be processed.
	 * @param root
	 *            The Element to be processed by the action.
	 */
	// "default" visibility so that it cannot be used outside of the package
	void processAaxlAction(final Resource rsrc, final Element root) {
		doAaxlAction(root);
	}

	/**
	 * This method will be defined by the plugin.  This should really be
	 * <code>protected</code> and not <code>public</code>, but we have external
	 * clients now so it's too late to change it.
	 * @param root
	 */
	public abstract void doAaxlAction(Element root);
}
