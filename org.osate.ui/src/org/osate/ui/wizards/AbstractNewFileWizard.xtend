package org.osate.ui.wizards

import java.io.ByteArrayInputStream
import java.lang.reflect.InvocationTargetException
import java.util.HashMap
import java.util.LinkedHashMap
import java.util.Map
import org.antlr.runtime.ANTLRStringStream
import org.antlr.runtime.RecognitionException
import org.antlr.runtime.Token
import org.eclipse.core.resources.IContainer
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IWorkspace
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.runtime.ILog
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
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.osate.ui.OsateUiPlugin
import org.osate.xtext.aadl2.properties.parser.antlr.lexer.InternalPropertiesLexer

import static extension org.apache.commons.lang.StringUtils.ordinalIndexOf

/**
 * Abstract wizard for creating new files. Each wizard contains a tree for selecting the parent folder and
 * one or more fields for entering text. Subclasses must specify the fields in the wizard by calling addField
 * before the wizard page is created. This can best be done in the constructor of the subclass.
 */
@FinalFieldsConstructor
abstract class AbstractNewFileWizard extends Wizard implements INewWizard {
	val static HIDE_FOLDERS = #["instances", "diagrams", "imv"]
	
	val String titleFileType
	val String descriptionFileType
	val protected String fileExtension
	val int tabIndex
	val ILog log
	val String pluginId
	val fieldValidators = <String, (String)=>boolean>newLinkedHashMap
	
	IWorkbench workbench
	IContainer initialSelection
	
	TreeViewer folderViewer
	LinkedHashMap<String, Text> fields
	
	new(String titleFileType, String fileExtension, int tabIndex, ILog log, String pluginId) {
		this(titleFileType, titleFileType.toLowerCase, fileExtension, tabIndex, log, pluginId)
	}
	
	def void addField(String fieldLabel, (String)=>boolean fieldValidator) {
		fieldValidators.put(fieldLabel, fieldValidator)
	}
	
	override init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench
		initialSelection = switch selectedElement : selection?.firstElement {
			IFile: selectedElement.parent
			IContainer: selectedElement
		}
		windowTitle = '''New «titleFileType» Fle'''
		defaultPageImageDescriptor = OsateUiPlugin.getImageDescriptor("icons/NewAadl2.gif")
	}
	
	override performFinish() {
		val newFile = file
		val contents = fileContents(new HashMap(fields.mapValues[field | field.text]))
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
				editor.selectAndReveal(contents.ordinalIndexOf("\t", tabIndex) + 1, 0)
			} catch (PartInitException e) {
				log.log(new Status(IStatus.WARNING, pluginId, e.message, e))
				MessageDialog.openWarning(container.shell, "Open Editor", e.message)
			}
			true
		} catch (InterruptedException e) {
			false
		} catch (InvocationTargetException e) {
			log.log(new Status(IStatus.ERROR, pluginId, e.message, e))
			MessageDialog.openError(container.shell, "Creation Problems", e.targetException.message)
			false
		}
	}
	
	/**
	 * fieldValues is a map from the field labels to the values in the text fields. The field labels are
	 * specified in the calls to addField.
	 */
	def String fileContents(Map<String, String> fieldValues)
	
	override addPages() {
		addPage(new WizardPage("New Object", '''New «titleFileType» File''', null) {
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
										element.members.filter(IContainer).filter[resource |
											!resource.name.startsWith(".") && !HIDE_FOLDERS.contains(resource.name)
										]
									} catch (CoreException e) {
										log.log(new Status(IStatus.WARNING, pluginId, e.message, e))
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
					
					fields = newLinkedHashMap(fieldValidators.keySet.map[fieldLabel |
						new Label(composite, SWT.NONE) => [label |
							label.text = fieldLabel + ":"
							label.layoutData = new GridData(SWT.BEGINNING, SWT.CENTER, false, false)
						]
						
						val field = new Text(composite, SWT.BORDER) => [field |
							field.layoutData = new GridData(SWT.FILL, SWT.CENTER, true, false)
							field.addModifyListener[validate]
						]
						
						fieldLabel -> field
					])
					
					addLocalControls(composite)
				]
			}
			
			override setVisible(boolean visible) {
				super.visible = visible
				if (visible) {
					fields.values.head.setFocus
				}
			}
			
			/*
			 * The following conditions must be true for the wizard page to be valid:
			 * -A parent project or folder must be selected.
			 * -For each field:
			 *   -Must not be empty.
			 *   -Must pass the field's validator
			 * -For the first field:
			 *   -Must not already exist as a file in the selected project or folder.
			 */
			def private void validate() {
				errorMessage = if (folderViewer.structuredSelection.empty) {
					"No folder specified."
				} else {
					fields.entrySet.map[entry |
						val fieldLabel = entry.key
						val field = entry.value
						
						if (field.text.empty) {
							fieldLabel + " cannot be empty."
						} else if (!fieldValidators.get(fieldLabel).apply(field.text)) {
							'''The «fieldLabel» '«field.text»' is not valid.'''
						} else if (fieldLabel == fields.keySet.head && file.exists) {
							"'" + getFileName(fields.values.head.text) + "' already exists."
						}
					].filterNull.head
				}
				pageComplete = errorMessage === null
			}
		} => [wizardPage |
			wizardPage.description = '''Create a new «descriptionFileType» file.'''
			wizardPage.pageComplete = false
		])
	}
			
	/**
	 * A wizard may add more controls to the pane.  They will appear below the widgets created by the
	 * {@link #addFields} functionality.  Keep in mind that the layout manager for the pane is a Grid with 
	 * 2 columns. 
	 */
	def protected void addLocalControls(Composite parent) {
		// by default does nothing
	}
	
	def protected static boolean isValidId(String id) {
		try {
			val lexer = new InternalPropertiesLexer(new ANTLRStringStream(id))
			lexer.mRULE_ID
			lexer.nextToken == Token.EOF_TOKEN
		} catch (RecognitionException e) {
			false
		}
	}
	
	def private IFile getFile() {
		val parentContainer = folderViewer.structuredSelection.firstElement as IContainer
		parentContainer.getFile(new Path(getFileName(fields.values.head.text)))
	}
	
	def protected String getFileName(String enteredName) {
		enteredName + "." + fileExtension
	}
}
		