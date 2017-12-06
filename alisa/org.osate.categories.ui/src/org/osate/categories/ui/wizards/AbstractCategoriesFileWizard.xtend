package org.osate.categories.ui.wizards

import java.io.ByteArrayInputStream
import java.lang.reflect.InvocationTargetException
import org.eclipse.core.resources.IContainer
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IWorkspace
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.runtime.IStatus
import org.eclipse.core.runtime.OperationCanceledException
import org.eclipse.core.runtime.Path
import org.eclipse.core.runtime.Status
import org.eclipse.jface.dialogs.MessageDialog
import org.eclipse.jface.viewers.IStructuredSelection
import org.eclipse.jface.viewers.StructuredSelection
import org.eclipse.jface.viewers.TreeViewer
import org.eclipse.jface.wizard.Wizard
import org.eclipse.jface.wizard.WizardPage
import org.eclipse.swt.SWT
import org.eclipse.swt.layout.GridData
import org.eclipse.swt.layout.GridLayout
import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.widgets.Label
import org.eclipse.swt.widgets.Text
import org.eclipse.ui.INewWizard
import org.eclipse.ui.IWorkbench
import org.eclipse.ui.PartInitException
import org.eclipse.ui.actions.WorkspaceModifyOperation
import org.eclipse.ui.model.WorkbenchContentProvider
import org.eclipse.ui.model.WorkbenchLabelProvider
import org.eclipse.ui.part.FileEditorInput
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.osate.categories.ui.internal.CategoriesActivator

@FinalFieldsConstructor
package abstract class AbstractCategoriesFileWizard extends Wizard implements INewWizard {
	val static HIDE_FOLDERS = #[".aadlbin-gen", ".settings", "instances", "diagrams", "imv"]
	
	val String fileType
	val String fileExtension
	
	IWorkbench workbench
	IContainer initialSelection
	
	TreeViewer folderViewer
	Text fileNameField
	
	override init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench
		initialSelection = switch selectedElement : selection?.firstElement {
			IFile: selectedElement.parent
			IContainer: selectedElement
		}
		windowTitle = '''New «fileType» File'''
	}
	
	override performFinish() {
		val newFile = file
		val WorkspaceModifyOperation operation = [monitor |
			newFile.create(new ByteArrayInputStream(#[]), false, monitor)
			if (monitor.canceled) {
				throw new OperationCanceledException
			}
		]
		try {
			container.run(true, true, operation)
			val activePage = workbench.activeWorkbenchWindow.activePage
			val editorId = workbench.editorRegistry.getDefaultEditor(newFile.name).id
			try {
				activePage.openEditor(new FileEditorInput(newFile), editorId)
			} catch (PartInitException e) {
				CategoriesActivator.instance.log.log(new Status(IStatus.WARNING, "org.osate.categories.ui", e.message, e))
				MessageDialog.openWarning(container.shell, "Open Editor", e.message)
			}
			true
		} catch (InterruptedException e) {
			false
		} catch (InvocationTargetException e) {
			CategoriesActivator.instance.log.log(new Status(IStatus.ERROR, "org.osate.categories.ui", e.message, e))
			MessageDialog.openError(container.shell, "Creation Problems", e.targetException.message)
			false
		}
	}
	
	override addPages() {
		addPage(new WizardPage("New Object", '''New «fileType» File''', null) {
			override createControl(Composite parent) {
				control = new Composite(parent, SWT.NONE) => [composite |
					composite.size = parent.size
					composite.layout = new GridLayout(2, false)
					
					new Label(composite, SWT.NONE) => [label |
						label.text = "Create in project/folder:"
						label.layoutData = new GridData(SWT.BEGINNING, SWT.CENTER, true, false, 2, 1)
					]
					
					folderViewer = new TreeViewer(composite, SWT.BORDER.bitwiseOr(SWT.SINGLE)) => [folderViewer |
						folderViewer.tree.layoutData = new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1)
						folderViewer.contentProvider = new WorkbenchContentProvider {
							override getChildren(Object element) {
								switch element {
									IWorkspace: element.root.projects.filter[project | project.open]
									IContainer: try {
										element.members.filter(IContainer).filter[resource | !HIDE_FOLDERS.contains(resource.name)]
									} catch (CoreException e) {
										CategoriesActivator.instance.log.log(new Status(IStatus.WARNING, "org.osate.categories.ui", e.message, e))
										#[]
									}
									default: #[]
								}
							}
						}
						folderViewer.labelProvider = WorkbenchLabelProvider.decoratingWorkbenchLabelProvider
						folderViewer.input = ResourcesPlugin.workspace
						if (initialSelection !== null) {
							folderViewer.setSelection(new StructuredSelection(initialSelection), true)
						}
						folderViewer.addSelectionChangedListener[validate]
					]
					
					new Label(composite, SWT.NONE) => [label |
						label.text = fileType + " File Name:"
						label.layoutData = new GridData(SWT.BEGINNING, SWT.CENTER, false, false)
					]
					
					fileNameField = new Text(composite, SWT.BORDER) => [fileNameField |
						fileNameField.layoutData = new GridData(SWT.FILL, SWT.CENTER, true, false)
						fileNameField.addModifyListener[validate]
					]
				]
			}
			
			override setVisible(boolean visible) {
				super.visible = visible
				if (visible) {
					fileNameField.setFocus
				}
			}
			
			/*
			 * The following conditions must be true for the wizard page to be valid:
			 * -A parent project or folder must be selected.
			 * -The File Name must be valid:
			 *   -Must not be empty.
			 *   -Must not be a hidden filename.
			 *   -Must not already exist as a file in the selected project or folder.
			 */
			def private void validate() {
				errorMessage = if (folderViewer.structuredSelection.empty) {
					"No folder specified."
				} else if (fileNameField.text.empty) {
					fileType + " File Name cannot be empty."
				} else if (fileNameField.text.startsWith(".")) {
					'''The «fileType» File Name '«fileNameField.text»' is not valid.'''
				} else if (file.exists) {
					"'" + fileName + "' already exists."
				}
				pageComplete = errorMessage === null
			}
		} => [wizardPage |
			wizardPage.description = '''Create a new «fileType» file.'''
			wizardPage.pageComplete = false
		])
	}
	
	def private IFile getFile() {
		val parentContainer = folderViewer.structuredSelection.firstElement as IContainer
		parentContainer.getFile(new Path(fileName))
	}
	
	def private String getFileName() {
		val enteredName = fileNameField.text
		if (enteredName.endsWith("." + fileExtension)) {
			enteredName
		} else {
			enteredName + "." +  fileExtension
		}
	}
}