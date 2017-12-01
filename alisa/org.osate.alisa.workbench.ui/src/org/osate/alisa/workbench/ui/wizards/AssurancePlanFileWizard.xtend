package org.osate.alisa.workbench.ui.wizards

import com.google.inject.Inject
import java.io.ByteArrayInputStream
import java.io.StringReader
import java.lang.reflect.InvocationTargetException
import org.antlr.runtime.ANTLRStringStream
import org.antlr.runtime.RecognitionException
import org.antlr.runtime.Token
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
import org.eclipse.ui.texteditor.ITextEditor
import org.eclipse.xtext.parser.IParser
import org.osate.alisa.workbench.parser.antlr.internal.InternalAlisaLexer
import org.osate.alisa.workbench.services.AlisaGrammarAccess
import org.osate.alisa.workbench.ui.internal.AlisaActivator

import static extension org.apache.commons.lang.StringUtils.ordinalIndexOf

class AssurancePlanFileWizard extends Wizard implements INewWizard {
	val static HIDE_FOLDERS = #[".aadlbin-gen", ".settings", "instances", "diagrams", "imv"]
	
	@Inject IParser parser
	@Inject AlisaGrammarAccess grammarAccess
	
	IWorkbench workbench
	IContainer initialSelection
	
	TreeViewer folderViewer
	Text caseNameField
	Text planNameField
	Text implementationField
	
	override init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench
		initialSelection = switch selectedElement : selection?.firstElement {
			IFile: selectedElement.parent
			IContainer: selectedElement
		}
		windowTitle = "New Assurance Plan File"
	}
	
	override performFinish() {
		val newFile = alisaFile
		val implementationName = implementationField.text
		val typeName = implementationName.substring(0, implementationName.indexOf("."))
		val contents = '''
			assurance case «caseNameField.text» for «typeName» [
				assurance plan «planNameField.text» for «implementationName» [
					
				]
			]'''
		val WorkspaceModifyOperation operation = [monitor |
			newFile.create(new ByteArrayInputStream(contents.bytes), false, monitor)
			if (monitor.canceled) {
				throw new OperationCanceledException
			}
		]
		try {
			container.run(true, true, operation)
			val activePage = workbench.activeWorkbenchWindow.activePage
			val editorId = workbench.editorRegistry.getDefaultEditor(newFile.name).id
			try {
				val editor = activePage.openEditor(new FileEditorInput(newFile), editorId) as ITextEditor
				editor.selectAndReveal(contents.ordinalIndexOf("\n", 3), 0)
			} catch (PartInitException e) {
				AlisaActivator.instance.log.log(new Status(IStatus.WARNING, "org.osate.alisa.workbench.ui", e.message, e))
				MessageDialog.openError(container.shell, "Open Editor", e.message)
			}
			true
		} catch (InterruptedException e) {
			false
		} catch (InvocationTargetException e) {
			AlisaActivator.instance.log.log(new Status(IStatus.ERROR, "org.osate.alisa.workbench.ui", e.message, e))
			MessageDialog.openError(container.shell, "Creation Problems", e.targetException.message)
			false
		}
	}
	
	override addPages() {
		addPage(new WizardPage("New Object", "New Assurance Plan File", null) {
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
										AlisaActivator.instance.log.log(new Status(IStatus.WARNING, "org.osate.alisa.workbench.ui", e.message, e))
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
						label.text = "Assurance Case Name:"
						label.layoutData = new GridData(SWT.BEGINNING, SWT.CENTER, false, false)
					]
					
					caseNameField = new Text(composite, SWT.BORDER) => [caseNameField |
						caseNameField.layoutData = new GridData(SWT.FILL, SWT.CENTER, true, false)
						caseNameField.setFocus
						caseNameField.addModifyListener[validate]
					]
					
					new Label(composite, SWT.NONE) => [label |
						label.text = "Assurance Plan Name:"
						label.layoutData = new GridData(SWT.BEGINNING, SWT.CENTER, false, false)
					]
					
					planNameField = new Text(composite, SWT.BORDER) => [planNameField |
						planNameField.layoutData = new GridData(SWT.FILL, SWT.CENTER, true, false)
						planNameField.addModifyListener[validate]
					]
					
					new Label(composite, SWT.NONE) => [label |
						label.text = "Component Implementation:"
						label.layoutData = new GridData(SWT.BEGINNING, SWT.CENTER, false, false)
					]
					
					implementationField = new Text(composite, SWT.BORDER) => [implementationField |
						implementationField.layoutData = new GridData(SWT.FILL, SWT.CENTER, true, false)
						implementationField.addModifyListener[validate]
					]
				]
			}
			
			/*
			 * The following conditions must be true for the wizard page to be valid:
			 * -A parent project or folder must be selected.
			 * -The Assurance Case Name must be valid:
			 *   -Must not be empty.
			 *   -Must be a valid QualifiedName.
			 *   -Must not contain any whitespace.
			 *   -Must not already exist as an alisa file in the selected project or folder.
			 * -The Assurance Plan Name must be valid:
			 *   -Must not be empty.
			 *   -Must be a valid ID.
			 * -The Component Implementation must be valid:
			 *   -Must not be empty.
			 *   -Must be a valid AadlClassifierReference.
			 *   -Must not contain any whitespace.
			 *   -Must be an implementation name and not simply a type name
			 */
			def private void validate() {
				errorMessage = if (folderViewer.structuredSelection.empty) {
					"No folder specified."
				} else if (caseNameField.text.empty) {
					"Assurance Case Name cannot be empty."
				} else if (!caseNameField.text.matches("\\S+") ||
					parser.parse(grammarAccess.qualifiedNameRule, new StringReader(caseNameField.text)).hasSyntaxErrors
				) {
					'''The Assurance Case Name '«caseNameField.text»' is not valid.'''
				} else if (alisaFile.exists) {
					"'" + caseNameField.text + ".alisa' already exists."
				} else if (planNameField.text.empty) {
					"Assurance Plan Name cannot be empty."
				} else if (!isValidId(planNameField.text)) {
					'''The Assurance Plan Name '«planNameField.text»' is not valid.'''
				} else if (implementationField.text.empty) {
					"Component Implementation cannot be empty."
				} else if (!implementationField.text.matches("\\S+") ||
					parser.parse(grammarAccess.aadlClassifierReferenceRule, new StringReader(implementationField.text)).hasSyntaxErrors ||
					!implementationField.text.contains(".")
				) {
					'''The Component Implementation '«implementationField.text»' is not valid.'''
				}
				pageComplete = errorMessage === null
			}
			
			def private boolean isValidId(String id) {
				try {
					val lexer = new InternalAlisaLexer(new ANTLRStringStream(id))
					lexer.mRULE_ID
					lexer.nextToken == Token.EOF_TOKEN
				} catch (RecognitionException e) {
					false
				}
			}
		} => [wizardPage |
			wizardPage.description = "Create a new Assurance Plan file."
			wizardPage.pageComplete = false
		])
	}
	
	def private IFile getAlisaFile() {
		val parentContainer = folderViewer.structuredSelection.firstElement as IContainer
		parentContainer.getFile(new Path(caseNameField.text + ".alisa"))
	}
}