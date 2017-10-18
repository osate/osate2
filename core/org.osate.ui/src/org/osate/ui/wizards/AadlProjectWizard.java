/**
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
 * @version $Id: AadlProjectWizard.java,v 1.11 2007-07-06 22:47:26 jseibel Exp $
 */
package org.osate.ui.wizards;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.MessageFormat;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResourceStatus;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.PreferenceStore;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;
import org.eclipse.ui.dialogs.WizardNewProjectReferencePage;
import org.eclipse.ui.wizards.newresource.BasicNewProjectResourceWizard;
import org.eclipse.ui.wizards.newresource.BasicNewResourceWizard;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.osate.core.AadlNature;
import org.osate.core.OsateCorePlugin;
import org.osate.ui.OsateUiPlugin;
import org.osate.workspace.WorkspacePlugin;

/**
 * This is a simple wizard for creating a new Aadl project.
 */
public class AadlProjectWizard extends BasicNewResourceWizard implements IExecutableExtension {

	public WizardNewProjectReferencePage getReferencePage() {
		return (referencePage);
	}

	protected WizardNewProjectReferencePage referencePage;

	/**
	 */
	public class WizardNewAadlProjectCreationPage extends WizardNewProjectCreationPage {
		/**
		 * the project to be created
		 */
		protected IProject aadlProject;

		/**
		 * Create the project creation page
		 */
		public WizardNewAadlProjectCreationPage(String pageId) {
			super(pageId);
		}

		/**
		 * The framework calls this to see if the project is correct.
		 */
		@Override
		protected boolean validatePage() {
			if (getProjectName().indexOf(' ') != -1) {
				setErrorMessage("The space is an invalid character in project name " + getProjectName() + '.');
				return false;
			} else {
				return super.validatePage();
			}
		}

	}

	/**
	 */
	public static final String copyright = "Copyright 2012 by Carnegie Mellon University, all rights reserved";

	/**
	 * The config element which declares this wizard.
	 */
	private IConfigurationElement configElement;

	// cache of newly-created project
	protected IProject newProject;

	/**
	 * This is the project creation page.
	 */
	protected WizardNewAadlProjectCreationPage newProjectCreationPage;

	/**
	 * Remember the workbench during initialization. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected IWorkbench workbench;

	protected IWorkspace workspace = ResourcesPlugin.getWorkspace();

	/**
	 * Creates a wizard for creating a new project resource in the workspace.
	 */
	public AadlProjectWizard() {
		IDialogSettings workbenchSettings = OsateUiPlugin.getDefault().getDialogSettings();
		IDialogSettings section = workbenchSettings.getSection("BasicNewProjectResourceWizard");//$NON-NLS-1$
		if (section == null) {
			section = workbenchSettings.addNewSection("BasicNewProjectResourceWizard");//$NON-NLS-1$
		}
		setDialogSettings(section);
	}

	/*
	 * (non-Javadoc) Method declared on IWizard.
	 */
	@Override
	public void addPages() {
		super.addPages();

		newProjectCreationPage = new WizardNewAadlProjectCreationPage("basicNewProjectPage");//$NON-NLS-1$
		newProjectCreationPage.setTitle("Aadl Project"); //$NON-NLS-1$
		newProjectCreationPage.setDescription("Create a new Aadl project resource."); //$NON-NLS-1$
		addPage(newProjectCreationPage);

		referencePage = new AadlWizardReferencePage("projectReferencePage");
		referencePage.setTitle("AADL Settings");
		referencePage.setDescription("Define the AADL Settings");

		addPage(referencePage);

	}

	/**
	 * Creates a new project resource with the selected name.
	 * <p>
	 * In normal usage, this method is invoked after the user has pressed Finish
	 * on the wizard; the enablement of the Finish button implies that all
	 * controls on the pages currently contain valid values.
	 * </p>
	 * <p>
	 * Note that this wizard caches the new project once it has been
	 * successfully created; subsequent invocations of this method will answer
	 * the same project resource without attempting to create it again.
	 * </p>
	 *
	 * @return the created project resource, or <code>null</code> if the
	 *         project was not created
	 */
	private IProject createNewProject() {
		if (newProject != null) {
			return newProject;
		}

		// get a project handle
		final IProject newProjectHandle = newProjectCreationPage.getProjectHandle();

		// get a project descriptor
		IPath newPath = null;
		if (!newProjectCreationPage.useDefaults()) {
			newPath = newProjectCreationPage.getLocationPath();
		}

		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		final IProjectDescription description = workspace.newProjectDescription(newProjectHandle.getName());
		description.setLocation(newPath);

		// create the new project operation
		WorkspaceModifyOperation op = new WorkspaceModifyOperation() {
			@Override
			protected void execute(IProgressMonitor monitor) throws CoreException {
				createProject(description, newProjectHandle, monitor);
			}
		};

		// run the new project creation operation
		try {
			getContainer().run(true, true, op);
		} catch (InterruptedException e) {
			return null;
		} catch (InvocationTargetException e) {
			// ie.- one of the steps resulted in a core exception
			Throwable t = e.getTargetException();
			if (t instanceof CoreException) {
				if (((CoreException) t).getStatus().getCode() == IResourceStatus.CASE_VARIANT_EXISTS) {
					MessageDialog.openError(getShell(), "Creation Problems", //$NON-NLS-1$
							MessageFormat.format(
									"The underlying file system is case insensitive. There is an existing project which conflicts with ''{0}''.", //$NON-NLS-1$
									newProjectHandle.getName()) // ,
					);
				} else {
					ErrorDialog.openError(getShell(), "Creation Problems", //$NON-NLS-1$
							null, // no special message
							((CoreException) t).getStatus());
				}
			} else {
				// CoreExceptions are handled above, but unexpected runtime
				// exceptions and errors may still occur.
				OsateUiPlugin.log(new Status(IStatus.ERROR, OsateUiPlugin.getPluginId(), 0, t.toString(), t));
				MessageDialog.openError(getShell(), "Creation Problems", //$NON-NLS-1$
						MessageFormat.format("Internal error: {0}", new Object[] { t.getMessage() })); //$NON-NLS-1$
			}
			return null;
		}

		newProject = newProjectHandle;

		return newProject;
	}

	/**
	 * Creates a project resource given the project handle and description.
	 *
	 * @param description
	 *            the project description to create a project resource for
	 * @param projectHandle
	 *            the project handle to create a project resource for
	 * @param monitor
	 *            the progress monitor to show visual progress with
	 *
	 * @exception CoreException
	 *                if the operation fails
	 * @exception OperationCanceledException
	 *                if the operation is canceled
	 */
	protected void createProject(IProjectDescription description, IProject projectHandle, IProgressMonitor monitor)
			throws CoreException, OperationCanceledException {
		try {
			monitor.beginTask("", 2000);//$NON-NLS-1$

			projectHandle.create(description, new SubProgressMonitor(monitor, 1000));

			if (monitor.isCanceled()) {
				throw new OperationCanceledException();
			}

			projectHandle.open(new SubProgressMonitor(monitor, 1000));

		} finally {
			monitor.done();
		}
	}

	/**
	 * Returns the newly created project.
	 *
	 * @return the created project, or <code>null</code> if project not
	 *         created
	 */
	public IProject getNewProject() {
		return newProject;
	}

	/**
	 * This just records the information. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		super.init(workbench, selection);
		this.workbench = workbench;
		setWindowTitle("New");
	}

	/**
	 * Do the work after everything is specified. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public boolean performFinish() {
		createNewProject();
		if (newProject == null) {
			return false;
		}
		updatePerspective();
		selectAndReveal(newProject);
		final IProject p = getNewProject();

		String filepath = p.getFile(WorkspacePlugin.AADLPATH_FILENAME).getRawLocation().toString();

		PreferenceStore ps = new PreferenceStore(filepath);
		ps.setValue(WorkspacePlugin.PROJECT_SOURCE_DIR, WorkspacePlugin.DEFAULT_SOURCE_DIR);
		ps.setValue(WorkspacePlugin.PROJECT_MODEL_DIR, WorkspacePlugin.DEFAULT_MODEL_DIR);
		try {
			ps.save();
		} catch (IOException e1) {
			MessageDialog.openError(getShell(), "Save Problem", //$NON-NLS-1$
					MessageFormat.format("Problem saving Preference Store", e1.getStackTrace().toString()));
		}
		try {
			p.refreshLocal(1, null);
		} catch (CoreException e2) {
			MessageDialog.openError(getShell(), "Refresh Problems Problems", //$NON-NLS-1$
					MessageFormat.format(
							"Resource changes are disallowed during certain types of resource change event notification",
							e2.getStackTrace().toString()));
		}
		try {
			if (!p.hasNature(XtextProjectHelper.NATURE_ID)) {
				IProjectDescription desc = p.getDescription();
				String[] oldNatures = desc.getNatureIds();
				String[] newNatures = new String[oldNatures.length + 1];
				System.arraycopy(oldNatures, 0, newNatures, 0, oldNatures.length);
				newNatures[oldNatures.length] = XtextProjectHelper.NATURE_ID;
				desc.setNatureIds(newNatures);
				p.setDescription(desc, null);
			}
		} catch (CoreException e) {
			OsateCorePlugin.log(e);
		}
		AadlNature.addNature(p, null);
		return true;
	}

	/**
	 * Stores the configuration element for the wizard. The config element will
	 * be used in <code>performFinish</code> to set the result perspective.
	 */
	@Override
	public void setInitializationData(IConfigurationElement cfig, String propertyName, Object data) {
		configElement = cfig;
	}

	/**
	 * Updates the perspective for the active page within the window.
	 */
	protected void updatePerspective() {
		BasicNewProjectResourceWizard.updatePerspective(configElement);
	}

}
