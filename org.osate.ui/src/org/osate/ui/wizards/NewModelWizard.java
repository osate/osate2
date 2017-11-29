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

import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.ContainerGenerator;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.PageBook;
import org.eclipse.xtext.nodemodel.BidiIterable;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.impl.CompositeNode;
import org.eclipse.xtext.nodemodel.impl.LeafNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.osate.ui.OsateUiPlugin;
import org.osate.workspace.IResourceUtility;
import org.osate.workspace.WorkspacePlugin;

/**
 * This is a simple wizard for creating a new model file.
 * It is based on edu.cmu.sei.aadl.model.core.presentation.CoreModelWizard from OSATE 1.
 *
 * @author jseibel
 */
abstract class NewModelWizard extends Wizard implements INewWizard {
	private static final String[] HIDE_FOLDERS = { ".aadlbin-gen", ".settings", "instances", "diagrams", "imv" };

	private final String fileTypeLabel;

	/**
	 * This is the only page of the wizard.  Instantiated in addPages and accessed
	 * in performFinish.
	 */
	protected NewModelWizardNewObjectCreationPage newObjectCreationPage = null;

	/**
	 * Remember the workbench during initialization.
	 */
	private IWorkbench workbench;

	/**
	 * Selected project in the package explorer.  This will become the selected project
	 * in the wizard's page.
	 */
	private IContainer projectFolder = null;

	protected NewModelWizard(String fileTypeLabel) {
		this.fileTypeLabel = fileTypeLabel;
	}

	/**
	 * This just records the information.
	 */
	@Override
	public final void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		if (selection != null) {
			Object selectedElement = selection.getFirstElement();
			if (selectedElement instanceof IResource) {

				if (selectedElement instanceof IProject) {
					projectFolder = (IProject) selectedElement;
				} else if (selectedElement instanceof IFolder) {
					projectFolder = (IContainer) selectedElement;
				} else if (selectedElement instanceof IFile) {
					projectFolder = ((IFile) selectedElement).getParent();
				}
			}
		}
		setWindowTitle("New AADL " + fileTypeLabel);
		setDefaultPageImageDescriptor(OsateUiPlugin.getImageDescriptor("icons/NewAadl2.gif"));
	}

	/**
	 * Do the work after everything is specified.
	 * Generates the appropriate files with the appropriate code within.
	 */
	@Override
	public final boolean performFinish() {
		return addAadlSource(newObjectRelativePath());
	}

	/**
	 * Generates a path to the object to create.  The path is based on the settings of
	 * newObjectCreationPage and dependent on the workspace.  An example: "/MyProject/aadl/NewSourceFile.aadl".
	 */
	private IPath newObjectRelativePath() {
		IContainer selectedProjectOrFolder = newObjectCreationPage.getSelectedProjectOrFolder();
		String fileExtension = "." + WorkspacePlugin.SOURCE_FILE_EXT;
		IPath filePath = null;
		if (selectedProjectOrFolder instanceof IProject) {
			filePath = new Path("/" + ((IProject) selectedProjectOrFolder).getName());
		} else if (selectedProjectOrFolder instanceof IFolder) {
			filePath = ((IFolder) selectedProjectOrFolder).getFullPath();
		}
		return new Path(filePath.addTrailingSeparator() + newObjectCreationPage.getNewObjectName().replaceAll(
				WorkspacePlugin.AADL_PACKAGE_SEPARATOR, WorkspacePlugin.FILE_PACKAGE_SEPARATOR) + fileExtension);
	}

	/**
	 * Generates a path to the object to create.  The path is based on the settings of
	 * newObjectCreationPage and is a full system dependent path.  An example:
	 * "C:\projects\aadlProjects\MyProject\aadl\NewSourceFile.aadl".
	 */
	private IPath newObjectAbsolutePath() {
		IContainer selectedProjectOrFolder = newObjectCreationPage.getSelectedProjectOrFolder();
		IPath filePath = selectedProjectOrFolder.getLocation();
		String fileExtension = "." + WorkspacePlugin.SOURCE_FILE_EXT;
		return new Path(filePath.addTrailingSeparator() + newObjectCreationPage.getNewObjectName().replaceAll(
				WorkspacePlugin.AADL_PACKAGE_SEPARATOR, WorkspacePlugin.FILE_PACKAGE_SEPARATOR) + fileExtension);
	}

	private boolean addAadlSource(final IPath sourcePath) {
		final IFile newFile = ResourcesPlugin.getWorkspace().getRoot().getFile(sourcePath);
		final InputStream initialContents = getInitialSourceContents();
		WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {
			@Override
			protected void execute(IProgressMonitor monitor) throws CoreException {
				SubMonitor subMonitor = SubMonitor.convert(monitor, "Creating", 2000);
				ContainerGenerator generator = new ContainerGenerator(sourcePath.removeLastSegments(1));
				generator.generateContainer(subMonitor.split(1000));
				newFile.create(initialContents, false, subMonitor);
				IResourceUtility.setGenerated(newFile, false);
				if (subMonitor.isCanceled()) {
					throw new OperationCanceledException();
				}
			}
		};
		try {
			getContainer().run(true, true, operation);
			try {
				XtextEditor editor = (XtextEditor) workbench.getActiveWorkbenchWindow().getActivePage().openEditor(
						new FileEditorInput(newFile),
						workbench.getEditorRegistry().getDefaultEditor(sourcePath.toString()).getId());
				int offset = firstTabOffset(editor);
				if (offset > -1) {
					editor.selectAndReveal(offset, 0);
				}
			} catch (PartInitException e) {
				MessageDialog.openError(null, "Open Editor", e.getMessage());
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
				MessageDialog.openError(getContainer().getShell(), "Creation Problems",
						e.getTargetException().getMessage());
			}
			return false;
		}
	}

	private int firstTabOffset(XtextEditor editor) {
		int offset = -1;

		offset = editor.getDocument().readOnly(new IUnitOfWork<Integer, XtextResource>() {
			@Override
			public Integer exec(XtextResource state) {
				int tabOffset = -1;
				EObject rootObject = state.getContents().get(0);
				ICompositeNode cNode = NodeModelUtils.findActualNodeFor(rootObject);
				INode tabNode = findTabNode(cNode);
				if (null != tabNode) {
					tabOffset = tabNode.getOffset() + 1;
					String tabNodeText = tabNode.getText();
					tabOffset = tabOffset + tabNodeText.indexOf('\t');
				}
				return tabOffset;
			}
		});

		return offset;
	}

	private INode findTabNode(ICompositeNode cNode) {
		INode result = null;
		BidiIterable<INode> iterable = cNode.getChildren();
		Iterator<INode> iter = iterable.iterator();
		while (iter.hasNext()) {
			INode iterNode = iter.next();
			if (iterNode instanceof LeafNode) {
				if (iterNode.getText().contains("\t")) {
					return iterNode;
				}
			} else if (iterNode instanceof CompositeNode) {
				result = findTabNode((CompositeNode) iterNode);
				if (null != result)
					return result;
			}
		}
		return result;
	}

	protected abstract InputStream getInitialSourceContents();

	/**
	 * Allows the user to select options for the new aadl file.  The user can specify which
	 * project the new file should be in and the name of the new file.
	 */
	protected class NewModelWizardNewObjectCreationPage extends WizardPage {
		private Text nameTextField = null;
		private TreeViewer folderViewer = null;

		public NewModelWizardNewObjectCreationPage(String pageName) {
			super(pageName, "New AADL " + fileTypeLabel, null);
			setDescription("Create a new AADL " + fileTypeLabel + '.');
		}

		@Override
		public void createControl(Composite parent) {
			PageBook pageBook = new PageBook(parent, SWT.NONE);

			Composite composite = new Composite(pageBook, SWT.NONE);
			composite.setSize(parent.getSize());
			composite.setLayout(new GridLayout());

			GridData layoutData = new GridData(SWT.FILL, SWT.CENTER, true, false);

			Label folderViewerLabel = new Label(composite, SWT.NONE);
			folderViewerLabel.setText("Create in project/folder:");
			folderViewer = new TreeViewer(composite, SWT.BORDER);
			folderViewer.getTree().setLayoutData(layoutData);
			folderViewer.setLabelProvider(WorkbenchLabelProvider.getDecoratingWorkbenchLabelProvider());
			folderViewer.setContentProvider(new WorkbenchContentProvider() {
				@Override
				public Object[] getChildren(Object element) {
					if (element instanceof IWorkspace) {
						IProject[] projects = ((IWorkspace) element).getRoot().getProjects();
						ArrayList<IProject> openProjects = new ArrayList<IProject>();
						for (IProject project : projects) {
							if (project.isOpen()) {
								openProjects.add(project);
							}
						}
						return openProjects.size() == 0 ? new Object[0] : openProjects.toArray();
					} else if (element instanceof IProject || element instanceof IFolder) {
						IResource[] resources = null;
						try {
							resources = ((IContainer) element).members();
						} catch (CoreException e) {
							e.printStackTrace();
							return new Object[0];
						}
						ArrayList<IFolder> folders = new ArrayList<IFolder>();
						for (IResource resource : resources) {
							if (resource instanceof IFolder) {
								if (((IFolder) resource).exists()) {
									boolean add = true;
									for (String hideFolder : HIDE_FOLDERS) {
										if (resource.getName().equalsIgnoreCase(hideFolder)) {
											add = false;
										}
									}
									if (add) {
										folders.add((IFolder) resource);
									}
								}
							}
						}
						return folders.size() == 0 ? new Object[0] : folders.toArray();
					}
					return new Object[0];
				}
			});

			folderViewer.setInput(ResourcesPlugin.getWorkspace());
			TreeItem[] treeItems = folderViewer.getTree().getItems();
			int treeItemsLength = treeItems.length;
			Label nameFieldLabel = new Label(composite, SWT.NONE);
			nameFieldLabel.setText("Enter the new Aadl " + fileTypeLabel + " name:");
			layoutData = new GridData(SWT.LEFT, SWT.CENTER, false, false);
			layoutData.verticalIndent = 15;
			nameFieldLabel.setLayoutData(layoutData);

			nameTextField = new Text(composite, SWT.BORDER);
			nameTextField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
			nameTextField.setFocus();
			nameTextField.addModifyListener(e -> setPageComplete(isPageComplete()));

			if (projectFolder != null) {
				folderViewer.setSelection(new StructuredSelection(projectFolder), true);
				if (folderViewer.getSelection().isEmpty()) {
					folderViewer.getTree().select(treeItems[0]);
				}
			} else {
				if (treeItemsLength > 0) {
					folderViewer.getTree().select(treeItems[0]);
				}
			}
			folderViewer.getTree().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

			Composite noProjectComposite = new Composite(pageBook, SWT.NONE);
			noProjectComposite.setSize(parent.getSize());
			noProjectComposite.setLayout(new GridLayout());
			Label noProjectLabel = new Label(noProjectComposite, SWT.NONE);
			noProjectLabel.setText("The workspace contains no projects. Before an Aadl " + fileTypeLabel
					+ " can be created you must first create a project.");
			if (treeItemsLength < 1) {
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
			} else {
				return false;
			}
		}

		private IContainer getSelectedProjectOrFolder() {
			return (IContainer) ((IStructuredSelection) folderViewer.getSelection()).getFirstElement();
		}

		protected String getNewObjectName() {
			return nameTextField.getText();
		}

		/**
		 * Generates an error message if the name is invalid.
		 */
		private boolean validateEnteredName() {
			if (nameTextField == null)
				return false;
			if (nameTextField.getText().length() == 0) {
				// No error message is specified. We assume that the user knows that
				// a new Aadl file must have a name.
				setErrorMessage(null);
				return false;
			} else {
				return validateName(nameTextField.getText());
			}
		}

		private boolean fileExists() {
			if (newObjectAbsolutePath().toFile().exists()) {
				setErrorMessage(nameTextField.getText() + " already exists.");
				return true;
			} else {
				return false;
			}
		}
	}

	protected abstract boolean validateName(String name);

	protected final boolean validateIdentifier(String identifier) {
		if (!Character.isLetter(identifier.charAt(0))) {
			newObjectCreationPage.setErrorMessage("Identifier must start with a letter.");
			return false;
		}
		for (int i = 1; i < identifier.length(); i++) {
			if (!(Character.isLetterOrDigit(identifier.charAt(i)) || identifier.charAt(i) == '_')) {
				newObjectCreationPage
						.setErrorMessage("Identifier can only contain letters, digits, and the underscore character.");
				return false;
			}
		}
		return true;
	}

	/**
	 * The framework calls this to create the contents of the wizard.
	 */
	@Override
	public final void addPages() {
		newObjectCreationPage = new NewModelWizardNewObjectCreationPage("New Object");
		addPage(newObjectCreationPage);
	}
}