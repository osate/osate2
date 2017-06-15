package org.osate.ge.internal.wizards;

/*
 * <copyright>
 * Copyright  2009 by Carnegie Mellon University, all rights reserved.
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
 * </copyright>
 */
// Based on Osate 2's org.osate.ui.wizards.NewModelWizard
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.ContainerGenerator;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.ui.part.PageBook;
import org.eclipse.ui.statushandlers.StatusManager;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.modelsupport.Activator;
import org.osate.aadl2.modelsupport.resources.PredeclaredProperties;
import org.osate.ge.internal.services.DiagramService;
import org.osate.ge.internal.services.impl.DefaultNamingService;
import org.osate.ui.OsateUiPlugin;
import org.osate.workspace.IResourceUtility;
import org.osate.workspace.WorkspacePlugin;

/**
 * This is a simple wizard for creating a new model file.
 * It is based on edu.cmu.sei.aadl.model.core.presentation.CoreModelWizard from OSATE 1.
 * 
 */
public class NewPackageWizard extends Wizard implements INewWizard {
	/**
	 * This is the only page of the wizard.  Instantiated in addPages and accessed
	 * in performFinish.
	 */
	private NewPackageWizardNewPackageCreationPage newPackageCreationPage = null;

	/**
	 * Selected project in the package explorer.  This will become the selected project
	 * in the wizard's page.
	 */
	private IProject project = null;

	final DefaultNamingService defaultNamingService = new DefaultNamingService();
	/**
	 * This just records the information.
	 */
	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		if (selection != null) {
			Object selectedElement = selection.getFirstElement();
			if (selectedElement instanceof IResource) {
				IProject project = ((IResource) selectedElement).getProject();
				if (!project.getName().equals(PredeclaredProperties.PLUGIN_RESOURCES_PROJECT_NAME))
					this.project = project;
				else
					this.project = null;
			}
		}
		setWindowTitle("New Aadl Package");
		setDefaultPageImageDescriptor(OsateUiPlugin.getImageDescriptor("icons/NewAadl2.gif"));
	}

	/**
	 * Do the work after everything is specified.
	 * Generates the appropriate files with the appropriate code within.
	 */
	@Override
	public boolean performFinish() {
		return addAadlSource(newObjectRelativePath());
	}

	/**
	 * Generates a path to the object to create.  The path is based on the settings of
	 * newObjectCreationPage and dependent on the workspace.  An example: "/MyProject/aadl/NewSourceFile.aadl".
	 */
	private IPath newObjectRelativePath() {
		IProject selectedProject = newPackageCreationPage.getSelectedProject();
		IPath filePath = new Path("/" + selectedProject.getName());
		String fileExtension = "." + WorkspacePlugin.SOURCE_FILE_EXT;
		filePath = new Path(filePath.addTrailingSeparator() + WorkspacePlugin.AADL_PACKAGES_DIR);
		return new Path(filePath.addTrailingSeparator()
				+ newPackageCreationPage.getNewObjectName().replaceAll(WorkspacePlugin.AADL_PACKAGE_SEPARATOR,
						WorkspacePlugin.FILE_PACKAGE_SEPARATOR) + fileExtension);
	}

	/**
	 * Generates a path to the object to create.  The path is based on the settings of
	 * newObjectCreationPage and is a full system dependent path.  An example:
	 * "C:\projects\aadlProjects\MyProject\aadl\NewSourceFile.aadl".
	 */
	private IPath newObjectAbsolutePath() {
		IProject selectedProject = newPackageCreationPage.getSelectedProject();
		IPath filePath = selectedProject.getLocation();
		String fileExtension = "." + WorkspacePlugin.SOURCE_FILE_EXT;
		filePath = new Path(filePath.addTrailingSeparator() + WorkspacePlugin.AADL_PACKAGES_DIR);
		return new Path(filePath.addTrailingSeparator()
				+ newPackageCreationPage.getNewObjectName().replaceAll(WorkspacePlugin.AADL_PACKAGE_SEPARATOR,
						WorkspacePlugin.FILE_PACKAGE_SEPARATOR) + fileExtension);
	}

	private boolean addAadlSource(final IPath sourcePath) {
		final IFile newFile = ResourcesPlugin.getWorkspace().getRoot().getFile(sourcePath);
		final InputStream initialContents = getInitialSourceContents();
		WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {
			@Override
			protected void execute(IProgressMonitor monitor) throws CoreException {
				try {
					monitor.beginTask("Creating", 2000);
					ContainerGenerator generator = new ContainerGenerator(sourcePath.removeLastSegments(1));
					generator.generateContainer(new SubProgressMonitor(monitor, 1000));
					newFile.create(initialContents, false, monitor);
					IResourceUtility.setGenerated(newFile, false);
					if (monitor.isCanceled())
						throw new OperationCanceledException();
				} finally {
					monitor.done();
				}
			}
		};
		try {
			getContainer().run(true, true, operation);

			// Build the project so that the index will be updated
			if (project != null) {
				try {
					project.build(IncrementalProjectBuilder.INCREMENTAL_BUILD, new NullProgressMonitor());
				} catch (CoreException ex) {
					final Status status = new Status(IStatus.ERROR, Activator.getPluginId(),
							"An error building the AADL project after creating a new AADL file.", ex);
					StatusManager.getManager().handle(status, StatusManager.SHOW | StatusManager.LOG);
				} catch (RuntimeException ex) {
					final Status status = new Status(IStatus.ERROR, Activator.getPluginId(),
							"An error building the AADL project after creating a new AADL file.", ex);
					StatusManager.getManager().handle(status, StatusManager.SHOW | StatusManager.LOG);
				}
			}

			// Get the element from the newly created AADL package
			final URI uri = URI.createPlatformResourceURI(newFile.getFullPath().toString(), true);
			final XtextResourceSet resourceSet = new XtextResourceSet();
			final Resource pkgResource = resourceSet.getResource(uri, true);
			if (pkgResource.getContents().size() > 0 && pkgResource.getContents().get(0) instanceof NamedElement) {
				// Open the diagram
				final DiagramService diagramService = (DiagramService) PlatformUI.getWorkbench()
						.getActiveWorkbenchWindow().getService(DiagramService.class);
				diagramService
						.openOrCreateDiagramForBusinessObject((NamedElement) pkgResource.getContents().get(0), false, false);
			} else {
				final Status status = new Status(IStatus.ERROR, Activator.getPluginId(),
						"Unable to retrieve package from resource.", null);
				StatusManager.getManager().handle(status, StatusManager.LOG);
				ErrorDialog.openError(getContainer().getShell(), "Unable to Create Diagram", null, status);
			}
			return true;
		} catch (InterruptedException e) {
			return false;
		} catch (InvocationTargetException e) {
			if (e.getTargetException() instanceof CoreException) {
				ErrorDialog.openError(getContainer().getShell(), "Creation Problems", null,
						((CoreException) e.getTargetException()).getStatus());
			} else {
				OsateUiPlugin.log(e.getTargetException());
				MessageDialog.openError(getContainer().getShell(), "Creation Problems", e.getTargetException()
						.getMessage());
			}
			return false;
		}
	}

	private InputStream getInitialSourceContents() {
		String contents = null;
		contents = "package " + newPackageCreationPage.getNewObjectName() + "\n" + "public\n" + "end "
				+ newPackageCreationPage.getNewObjectName() + ";";
		return new ByteArrayInputStream(contents.getBytes());
	}

	/**
	 * Allows the user to select options for the new aadl file.  The user can specify which
	 * project the new file should be in, the name of the new file, whether the new file is
	 * text or object, and whether the new file is a package or property set.
	 */
	private class NewPackageWizardNewPackageCreationPage extends WizardPage {
		// All buttons are radio buttons.
		private Text nameTextField = null;
		private TableViewer projectViewer = null;

		public NewPackageWizardNewPackageCreationPage(String pageName) {
			super(pageName, "New Aadl Package", null);
			setDescription("Create a new Aadl package.");
		}

		@Override
		public void createControl(Composite parent) {
			createAndLayoutWidgets(parent);
			ButtonAndTextListener listener = new ButtonAndTextListener(this);
			nameTextField.addModifyListener(listener);
		}

		private void createAndLayoutWidgets(Composite parent) {
			PageBook pageBook = new PageBook(parent, SWT.NONE);

			Composite composite = new Composite(pageBook, SWT.NONE);
			composite.setSize(parent.getSize());
			composite.setLayout(new GridLayout());

			GridData layoutData = new GridData(SWT.FILL, SWT.CENTER, true, false);
			Label nameFieldLabel = new Label(composite, SWT.NONE);
			nameFieldLabel.setText("Enter the new package's name:");
			layoutData = new GridData(SWT.LEFT, SWT.CENTER, false, false);
			layoutData.verticalIndent = 15;
			nameFieldLabel.setLayoutData(layoutData);

			nameTextField = new Text(composite, SWT.BORDER);
			nameTextField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
			nameTextField.setFocus();

			Label projectViewerLabel = new Label(composite, SWT.NONE);
			projectViewerLabel.setText("Create in project:");
			layoutData = new GridData(SWT.LEFT, SWT.CENTER, false, false);

			projectViewer = new TableViewer(composite, SWT.BORDER);
			projectViewer.setLabelProvider(WorkbenchLabelProvider.getDecoratingWorkbenchLabelProvider());
			projectViewer.setContentProvider(new WorkbenchContentProvider() {
				@Override
				public Object[] getChildren(Object element) {
					if (!(element instanceof IWorkspace))
						return new Object[0];
					IProject[] projects = ((IWorkspace) element).getRoot().getProjects();
					ArrayList<IProject> openProjects = new ArrayList<IProject>();
					for (IProject project : projects)
						if (project.isOpen()
								&& !project.getName().equals(PredeclaredProperties.PLUGIN_RESOURCES_PROJECT_NAME))
							openProjects.add(project);
					return openProjects.size() == 0 ? new Object[0] : openProjects.toArray();
				}
			});
			projectViewer.setInput(ResourcesPlugin.getWorkspace());
			int projectItemCount = projectViewer.getTable().getItemCount();
			boolean selectedProjectInList = false;
			for (int i = 0; i < projectItemCount; i++) {
				if (projectViewer.getElementAt(i).equals(project)) {
					selectedProjectInList = true;
					break;
				}
			}
			if ((project != null) && selectedProjectInList)
				projectViewer.setSelection(new StructuredSelection(project), true);
			else if (projectItemCount > 0) {
				projectViewer.getTable().setSelection(0);
			}
			projectViewer.getTable().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

			Composite noProjectComposite = new Composite(pageBook, SWT.NONE);
			noProjectComposite.setSize(parent.getSize());
			noProjectComposite.setLayout(new GridLayout());
			Label noProjectLabel = new Label(noProjectComposite, SWT.NONE);
			noProjectLabel
					.setText("The workspace contains no projects. Before an Aadl Package can be created you must first create a project.");
			if (projectItemCount < 1) {
				pageBook.showPage(noProjectComposite);
			} else {
				pageBook.showPage(composite);
			}
			setControl(pageBook);
		}

		@Override
		public boolean isPageComplete() {
			if (validateEnteredName() && !fileExists()) {
				setErrorMessage(null);
				return true;
			} else
				return false;
		}

		public IProject getSelectedProject() {
			return (IProject) ((IStructuredSelection) projectViewer.getSelection()).getFirstElement();
		}

		public String getNewObjectName() {
			return nameTextField.getText();
		}

		/**
		 * Generates an error message if the name is invalid.
		 */
		private boolean validateEnteredName() {
			if (nameTextField.getText().length() == 0) {
				// No error message is specified. We assume that the user knows that
				// a new Aadl file must have a name.
				setErrorMessage(null);
				return false;
			} else {
				if (nameTextField.getText().startsWith(":")) {
					setErrorMessage("Package path must start with an identifier.");
					return false;
				}
				else if (!defaultNamingService.isValidIdentifier(nameTextField.getText()))
				{
					setErrorMessage("Package name must be a valid AADL identifier");
					return false;
				}
				else if (nameTextField.getText().endsWith(":"))
				{
					setErrorMessage("Package path must end with an identifier.");
					return false;
				}
				int startingIndex = 0;
				for (int i = 1; i < nameTextField.getText().length() - 1; i++) {
					if ((nameTextField.getText().charAt(i) == ':') && (nameTextField.getText().charAt(i - 1) != ':'))
						startingIndex = i;
					if ((nameTextField.getText().charAt(i) == ':') && (nameTextField.getText().charAt(i + 1) != ':')
							&& (i - startingIndex != 1)) {
						setErrorMessage("Use two colons(::) to separate identifiers in the package path.");
						return false;
					}
				}
				StringTokenizer tokenizer = new StringTokenizer(nameTextField.getText(), "::");
				while (tokenizer.hasMoreTokens()) {
					if (!validateIdentifier(tokenizer.nextToken()))
						return false;
				}
				return true;
			}
		}

		private boolean validateIdentifier(String identifier) {
			if (!Character.isLetter(identifier.charAt(0))) {
				setErrorMessage("Identifier must start with a letter.");
				return false;
			}
			for (int i = 1; i < identifier.length(); i++) {
				if (!(Character.isLetterOrDigit(identifier.charAt(i)) || identifier.charAt(i) == '_')) {
					setErrorMessage("Identifier can only contain letters, digits, and the underscore character.");
					return false;
				}
			}
			return true;
		}

		private boolean fileExists() {
			if (newObjectAbsolutePath().toFile().exists()) {
				setErrorMessage(nameTextField.getText() + " already exists.");
				return true;
			} else
				return false;
		}
	}

	private static class ButtonAndTextListener extends SelectionAdapter implements ModifyListener {
		private final WizardPage wizardPage;

		public ButtonAndTextListener(final WizardPage wp) {
			wizardPage = wp;
		}

		@Override
		public void widgetSelected(SelectionEvent e) {
			wizardPage.setPageComplete(wizardPage.isPageComplete());
		}

//		@Override
		@Override
		public void modifyText(ModifyEvent e) {
			wizardPage.setPageComplete(wizardPage.isPageComplete());
		}
	}

	/**
	 * The framework calls this to create the contents of the wizard.
	 */
	@Override
	public void addPages() {
		newPackageCreationPage = new NewPackageWizardNewPackageCreationPage("New Package");
		addPage(newPackageCreationPage);
	}
}
