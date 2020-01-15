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
package org.osate.ui.wizards;

import java.io.ByteArrayInputStream;
import java.lang.reflect.InvocationTargetException;
import java.text.MessageFormat;

import org.eclipse.core.resources.IFile;
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
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.dialogs.MessageDialog;
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
		description.setReferencedProjects(referencePage.getReferencedProjects());

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
		SubMonitor subMonitor = SubMonitor.convert(monitor, 2000);
		projectHandle.create(description, subMonitor.split(1000));
		projectHandle.open(subMonitor.split(1000));
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

		IFile gitIgnoreFile = p.getFile(".gitignore");
		String ignoreContents = "/.aadlbin-gen/" + System.lineSeparator();
		WorkspaceModifyOperation op = new WorkspaceModifyOperation() {
			@Override
			protected void execute(IProgressMonitor monitor)
					throws CoreException, InvocationTargetException, InterruptedException {
				gitIgnoreFile.create(new ByteArrayInputStream(ignoreContents.getBytes()), false, monitor);
			}
		};
		try {
			getContainer().run(false, true, op);
		} catch (InterruptedException e) {
		} catch (InvocationTargetException e) {
			OsateUiPlugin.log(new Status(IStatus.ERROR, OsateUiPlugin.getPluginId(), e.getMessage(), e));
			MessageDialog.openError(getShell(), "Creation Problems", "Internal error: " + e.getMessage());
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
