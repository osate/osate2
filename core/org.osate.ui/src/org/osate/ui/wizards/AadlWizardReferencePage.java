package org.osate.ui.wizards;

import java.text.MessageFormat;
import java.util.ArrayList;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.ui.dialogs.WizardNewProjectReferencePage;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.xtext.ui.XtextProjectHelper;

public class AadlWizardReferencePage extends WizardNewProjectReferencePage {

	public AadlWizardReferencePage(String pageName) {
		super(pageName);
	}

	@Override
	protected IStructuredContentProvider getContentProvider() {

		return new WorkbenchContentProvider() {
			@Override
			public Object[] getChildren(Object element) {
				if (!(element instanceof IWorkspace)) {
					return new Object[0];
				}
				IProject[] projects = ((IWorkspace) element).getRoot().getProjects();

				IProject project;
				ArrayList<IProject> projectsWithNatures = new ArrayList<IProject>();
				for (int i = 0; i < projects.length; i++) {
					project = projects[i];
					try {
						if (project.isOpen()) {
							if (project.hasNature(XtextProjectHelper.NATURE_ID)) {
								projectsWithNatures.add(project);
							}
						}
					} catch (CoreException e) {
						MessageDialog.openError(getShell(), "Project Problems", //$NON-NLS-1$
								MessageFormat.format("Project does not exist or is not open",
										e.getStackTrace().toString()));
					}
				}

				return projectsWithNatures.toArray();

				// return projects == null ? new Object[0] : projects;
			}
		};
	}

}