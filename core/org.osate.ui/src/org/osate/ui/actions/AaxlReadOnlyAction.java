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
