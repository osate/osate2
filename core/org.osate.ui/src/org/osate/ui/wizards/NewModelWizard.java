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
package org.osate.ui.wizards;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
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
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.ContainerGenerator;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.ISetSelectionTarget;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.modelsupport.eclipseinterface.OsateResourceManager;
import org.osate.ui.OsateUiPlugin;
import org.osate.workspace.IResourceUtility;
import org.osate.workspace.WorkspacePlugin;


/**
 * This is a simple wizard for creating a new model file.
 * It is based on edu.cmu.sei.aadl.model.core.presentation.CoreModelWizard from OSATE 1.
 * 
 * @author jseibel
 */
public class NewModelWizard extends Wizard implements INewWizard
{
	public static enum ObjectType {AADL_PACKAGE, AADL_PROPERTY_SET}
	private static enum FileType {TEXT_FILE, OBJECT_FILE}
	
	/**
	 * This caches an instance of the model package.
	 */
	private Aadl2Package aadl2Package = Aadl2Package.eINSTANCE;
	
	/**
	 * This caches an instance of the model factory.
	 */
	private Aadl2Factory aadl2Factory = aadl2Package.getAadl2Factory();
	
	/**
	 * This is the only page of the wizard.  Instantiated in addPages and accessed
	 * in performFinish.
	 */
	private NewModelWizardNewObjectCreationPage newObjectCreationPage = null;
	
	/**
	 * Remember the workbench during initialization.
	 */
	private IWorkbench workbench;
	
	/**
	 * Selected project in the package explorer.  This will become the selected project
	 * in the wizard's page.
	 */
	private IProject project = null;
	
	private ObjectType initialObjectType = ObjectType.AADL_PACKAGE;
	
	/**
	 * This just records the information.
	 */
//	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection)
	{
		this.workbench = workbench;
		if (selection != null)
		{
			Object selectedElement = selection.getFirstElement();
			if (selectedElement instanceof IResource)
			{
				IProject project = ((IResource)selectedElement).getProject();
				if (!project.getName().equals(OsateResourceManager.PLUGIN_RESOURCES_DIRECTORY_NAME))
					this.project = project;
				else
					this.project = null;
			}
		}
		setWindowTitle("New Aadl Object");
		setDefaultPageImageDescriptor(OsateUiPlugin.getImageDescriptor("icons/NewAadl2.gif"));
	}
	
	/**
	 * Specifies which radio button should be selected when the wizard page is displayed.
	 */
	public void setInitialObjectType(ObjectType initialObjectType)
	{
		this.initialObjectType = initialObjectType;
	}
	
	/**
	 * Create a new model.
	 * Creates a new package or property set based on newObjectCreationPage.getObjectType
	 */
	private NamedElement createInitialModel()
	{
		if (newObjectCreationPage.getObjectType().equals(ObjectType.AADL_PACKAGE))
			return aadl2Factory.createAadlPackage();
		else
			return aadl2Factory.createPropertySet();
	}
	
	/**
	 * Do the work after everything is specified.
	 * Generates the appropriate files with the appropriate code within.
	 */
	@Override
	public boolean performFinish()
	{
			return addAadlSource(newObjectRelativePath());
	}
	
	/**
	 * Generates a path to the object to create.  The path is based on the settings of
	 * newObjectCreationPage and dependent on the workspace.  An example: "/MyProject/aadl/NewSourceFile.aadl".
	 */
	private IPath newObjectRelativePath()
	{
		IProject selectedProject = newObjectCreationPage.getSelectedProject();
		IPath filePath = new Path("/" + selectedProject.getName());
		String fileExtension = null;
		if (newObjectCreationPage.getFileType().equals(FileType.OBJECT_FILE))
		{
			filePath = new Path(filePath + WorkspacePlugin.getPreferenceStore(selectedProject).getString(WorkspacePlugin.PROJECT_MODEL_DIR));
			fileExtension = "." + WorkspacePlugin.MODEL_FILE_EXT;
		}
		else
		{
			filePath = new Path(filePath + WorkspacePlugin.getPreferenceStore(selectedProject).getString(WorkspacePlugin.PROJECT_SOURCE_DIR));
			fileExtension = "." + WorkspacePlugin.SOURCE_FILE_EXT;
		}
		if (newObjectCreationPage.getObjectType().equals(ObjectType.AADL_PACKAGE))
			filePath = new Path(filePath.addTrailingSeparator() + WorkspacePlugin.AADL_PACKAGES_DIR);
		else
			filePath = new Path(filePath.addTrailingSeparator() + WorkspacePlugin.PROPERTY_SETS_DIR);
		return new Path(filePath.addTrailingSeparator() + newObjectCreationPage.getNewObjectName().replaceAll(
				WorkspacePlugin.AADL_PACKAGE_SEPARATOR, WorkspacePlugin.FILE_PACKAGE_SEPARATOR) + fileExtension);
	}
	
	/**
	 * Generates a path to the object to create.  The path is based on the settings of
	 * newObjectCreationPage and is a full system dependent path.  An example:
	 * "C:\projects\aadlProjects\MyProject\aadl\NewSourceFile.aadl".
	 */
	private IPath newObjectAbsolutePath()
	{
		IProject selectedProject = newObjectCreationPage.getSelectedProject();
		IPath filePath = selectedProject.getLocation();
		String fileExtension = null;
		if (newObjectCreationPage.getFileType().equals(FileType.OBJECT_FILE))
		{
			filePath = new Path(filePath + WorkspacePlugin.getPreferenceStore(selectedProject).getString(WorkspacePlugin.PROJECT_MODEL_DIR));
			fileExtension = "." + WorkspacePlugin.MODEL_FILE_EXT;
		}
		else
		{
			filePath = new Path(filePath + WorkspacePlugin.getPreferenceStore(selectedProject).getString(WorkspacePlugin.PROJECT_SOURCE_DIR));
			fileExtension = "." + WorkspacePlugin.SOURCE_FILE_EXT;
		}
		if (newObjectCreationPage.getObjectType().equals(ObjectType.AADL_PACKAGE))
			filePath = new Path(filePath.addTrailingSeparator() + WorkspacePlugin.AADL_PACKAGES_DIR);
		else
			filePath = new Path(filePath.addTrailingSeparator() + WorkspacePlugin.PROPERTY_SETS_DIR);
		return new Path(filePath.addTrailingSeparator() + newObjectCreationPage.getNewObjectName().replaceAll(
				WorkspacePlugin.AADL_PACKAGE_SEPARATOR, WorkspacePlugin.FILE_PACKAGE_SEPARATOR) + fileExtension);
	}
	
	
	private boolean addAadlSource(final IPath sourcePath)
	{
		final IFile newFile = ResourcesPlugin.getWorkspace().getRoot().getFile(sourcePath);
		final InputStream initialContents = getInitialSourceContents();
		WorkspaceModifyOperation operation = new WorkspaceModifyOperation()
		{
			@Override
			protected void execute(IProgressMonitor monitor) throws CoreException
			{
				try
				{
					monitor.beginTask("Creating", 2000);
					ContainerGenerator generator = new ContainerGenerator(sourcePath.removeLastSegments(1));
					generator.generateContainer(new SubProgressMonitor(monitor, 1000));
					newFile.create(initialContents, false, monitor);
					IResourceUtility.setGenerated(newFile, false);
					if (monitor.isCanceled())
						throw new OperationCanceledException();
				}
				finally
				{
					monitor.done();
				}
			}
		};
		try
		{
			getContainer().run(true, true, operation);
			try
			{
				workbench.getActiveWorkbenchWindow().getActivePage().openEditor(new FileEditorInput(newFile),
						workbench.getEditorRegistry().getDefaultEditor(sourcePath.toString()).getId());
			}
			catch (PartInitException e)
			{
				MessageDialog.openError(null, "Open Editor", e.getMessage());
			}
			return true;
		}
		catch (InterruptedException e)
		{
			return false;
		}
		catch (InvocationTargetException e)
		{
			if (e.getTargetException() instanceof CoreException)
			{
				ErrorDialog.openError(getContainer().getShell(), "Creation Problems", null,
						((CoreException)e.getTargetException()).getStatus());
			}
			else
			{
				OsateUiPlugin.log(e.getTargetException());
				MessageDialog.openError(getContainer().getShell(), "Creation Problems", e.getTargetException().getMessage());
			}
			return false;
		}
	}
	
	private InputStream getInitialSourceContents()
	{
		String contents = null;
		if (newObjectCreationPage.getObjectType().equals(ObjectType.AADL_PACKAGE))
		{
			contents = "package " + newObjectCreationPage.getNewObjectName() + "\n" +
					"public\n" +
					"end " + newObjectCreationPage.getNewObjectName() + ";";
		}
		else
		{
			contents = "property set " + newObjectCreationPage.getNewObjectName() + " is\n" +
					"end " + newObjectCreationPage.getNewObjectName() + ";";
		}
		return new ByteArrayInputStream(contents.getBytes());
	}
	
	/**
	 * Allows the user to select options for the new aadl file.  The user can specify which
	 * project the new file should be in, the name of the new file, whether the new file is
	 * text or object, and whether the new file is a package or property set.
	 */
	private class NewModelWizardNewObjectCreationPage extends WizardPage
	{
		/**
		 * Specifies which radio button should be selected when the page is shown.
		 */
		private ObjectType initialObjectType = ObjectType.AADL_PACKAGE;
		
		//All buttons are radio buttons.
		private Button aadlPackageButton = null;
		private Button aadlPropertySetButton = null;
		private Button textFileButton = null;
		private Button objectFileButton = null;
		private Text nameTextField = null;
		private TableViewer projectViewer = null;
		
		/**
		 * initialObjectType specifies which radio button will be selected when the page is shown.
		 */
		public NewModelWizardNewObjectCreationPage(String pageName, ObjectType initialObjectType)
		{
			super(pageName, "New Aadl Object", null);
			setDescription("Create a new Aadl package or property set.");
			this.initialObjectType = initialObjectType;
		}
		
//		@Override
		public void createControl(Composite parent)
		{
			createAndLayoutWidgets(parent);
			ButtonAndTextListener listener = new ButtonAndTextListener(this);
			aadlPackageButton.addSelectionListener(listener);
			aadlPropertySetButton.addSelectionListener(listener);
			textFileButton.addSelectionListener(listener);
			objectFileButton.addSelectionListener(listener);
			nameTextField.addModifyListener(listener);
		}
		
		private void createAndLayoutWidgets(Composite parent)
		{
			Composite composite = new Composite(parent, SWT.NONE);
			composite.setSize(parent.getSize());
			composite.setLayout(new GridLayout());
			
			Group objectTypeGroup = new Group(composite, SWT.NONE);
			objectTypeGroup.setLayout(new GridLayout());
			objectTypeGroup.setText("Aadl Object Type");
			objectTypeGroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
			
			aadlPackageButton = new Button(objectTypeGroup, SWT.RADIO);
			aadlPackageButton.setText("Aadl Package");
			aadlPackageButton.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
			
			aadlPropertySetButton = new Button(objectTypeGroup, SWT.RADIO);
			aadlPropertySetButton.setText("Aadl Property Set");
			aadlPropertySetButton.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
			
			Group fileTypeGroup = new Group(composite, SWT.NONE);
			fileTypeGroup.setLayout(new GridLayout());
			fileTypeGroup.setText("File Type");
			GridData layoutData = new GridData(SWT.FILL, SWT.CENTER, true, false);
			layoutData.verticalIndent = 15;
			fileTypeGroup.setLayoutData(layoutData);
			
			textFileButton = new Button(fileTypeGroup, SWT.RADIO);
			textFileButton.setText("Text File");
			textFileButton.setSelection(true);
			textFileButton.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
			
			objectFileButton = new Button(fileTypeGroup, SWT.RADIO);
			objectFileButton.setText("Object File");
			objectFileButton.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
			
			Label nameFieldLabel = new Label(composite, SWT.NONE);
			nameFieldLabel.setText("Enter the new object's name:");
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
			projectViewer.setContentProvider(
					new WorkbenchContentProvider()
					{
						@Override
						public Object[] getChildren(Object element)
						{
							if (!(element instanceof IWorkspace))
								return new Object[0];
							IProject[] projects = ((IWorkspace)element).getRoot().getProjects();
							ArrayList<IProject> openProjects = new ArrayList<IProject>();
							for (IProject project : projects)
								if (project.isOpen() && !project.getName().equals(OsateResourceManager.PLUGIN_RESOURCES_DIRECTORY_NAME))
									openProjects.add(project);
							return openProjects.size() == 0 ? new Object[0] : openProjects.toArray();
						}
					});
			projectViewer.setInput(ResourcesPlugin.getWorkspace());
			boolean selectedProjectInList = false;
			for (int i = 0; i < projectViewer.getTable().getItemCount(); i++)
			{
				if (projectViewer.getElementAt(i).equals(project))
				{
					selectedProjectInList = true;
					break;
				}
			}
			if ((project != null) && selectedProjectInList)
				projectViewer.setSelection(new StructuredSelection(project), true);
			else
				projectViewer.getTable().setSelection(0);
			projectViewer.getTable().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
			
			switch (initialObjectType)
			{
				case AADL_PACKAGE:
					aadlPackageButton.setSelection(true);
					break;
				case AADL_PROPERTY_SET:
					aadlPropertySetButton.setSelection(true);
					break;
				default:
					throw new AssertionError(initialObjectType.name() + " is not a recognized enum literal.");
			}
			
			setControl(composite);
		}
		
		@Override
		public boolean isPageComplete()
		{
			if (validateEnteredName() && !fileExists())
			{
				setErrorMessage(null);
				return true;
			}
			else
				return false;
		}
		
		public IProject getSelectedProject()
		{
			return (IProject)((IStructuredSelection)projectViewer.getSelection()).getFirstElement();
		}
		
		public String getNewObjectName()
		{
			return nameTextField.getText();
		}
		
		public ObjectType getObjectType()
		{
			if (aadlPackageButton.getSelection())
				return ObjectType.AADL_PACKAGE;
			else
				return ObjectType.AADL_PROPERTY_SET;
		}
		
		public FileType getFileType()
		{
			if (textFileButton.getSelection())
				return FileType.TEXT_FILE;
			else
				return FileType.OBJECT_FILE;
		}
		
		/**
		 * Generates an error message if the name is invalid.
		 */
		private boolean validateEnteredName()
		{
			if (nameTextField.getText().length() == 0)
			{
				//No error message is specified.  We assume that the user knows that
				//a new Aadl file must have a name.
				setErrorMessage(null);
				return false;
			}
			else if (aadlPackageButton.getSelection())
			{
				if (nameTextField.getText().startsWith(":"))
				{
					setErrorMessage("Package path must start with an identifier.");
					return false;
				}
				else if (nameTextField.getText().endsWith(":"))
				{
					setErrorMessage("Package path must end with an identifier.");
					return false;
				}
				int startingIndex = 0;
				for (int i = 1; i < nameTextField.getText().length() - 1; i++)
				{
					if ((nameTextField.getText().charAt(i) == ':') && (nameTextField.getText().charAt(i - 1) != ':'))
						startingIndex = i;
					if ((nameTextField.getText().charAt(i) == ':') && (nameTextField.getText().charAt(i + 1) != ':') &&
							(i - startingIndex != 1))
					{
						setErrorMessage("Use two colons(::) to separate identifiers in the package path.");
						return false;
					}
				}
				StringTokenizer tokenizer = new StringTokenizer(nameTextField.getText(), "::");
				while (tokenizer.hasMoreTokens())
				{
					if (!validateIdentifier(tokenizer.nextToken()))
						return false;
				}
				return true;
			}
			else
				return validateIdentifier(nameTextField.getText());
		}
		
		private boolean validateIdentifier(String identifier)
		{
			if (!Character.isLetter(identifier.charAt(0)))
			{
				setErrorMessage("Identifier must start with a letter.");
				return false;
			}
			for (int i = 1; i < identifier.length(); i++)
			{
				if (!(Character.isLetterOrDigit(identifier.charAt(i)) || identifier.charAt(i) == '_'))
				{
					setErrorMessage("Identifier can only contain letters, digits, and the underscore character.");
					return false;
				}
			}
			return true;
		}
		
		private boolean fileExists()
		{
			if (newObjectAbsolutePath().toFile().exists())
			{
				setErrorMessage(nameTextField.getText() + " already exists.");
				return true;
			}
			else
				return false;
		}
	}
	
	private static class ButtonAndTextListener extends SelectionAdapter implements ModifyListener
	{
		private final WizardPage wizardPage;
		
		public ButtonAndTextListener(final WizardPage wp)
		{
			wizardPage = wp;
		}
		
		@Override
		public void widgetSelected(SelectionEvent e)
		{
			wizardPage.setPageComplete(wizardPage.isPageComplete());
		}
		
//		@Override
		public void modifyText(ModifyEvent e)
		{
			wizardPage.setPageComplete(wizardPage.isPageComplete());
		}
	}
	
	/**
	 * The framework calls this to create the contents of the wizard.
	 */
	@Override
	public void addPages()
	{
		newObjectCreationPage = new NewModelWizardNewObjectCreationPage("New Object", initialObjectType);
		addPage(newObjectCreationPage);
	}
}