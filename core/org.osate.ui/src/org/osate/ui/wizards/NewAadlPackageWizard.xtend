package org.osate.ui.wizards

import com.google.inject.Inject
import java.io.StringReader
import java.util.Map
import org.eclipse.xtext.parser.IParser
import org.osate.ui.OsateUiPlugin
import org.osate.workspace.WorkspacePlugin
import org.osate.xtext.aadl2.services.Aadl2GrammarAccess
import org.osate.xtext.aadl2.ui.MyAadl2Activator
import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.widgets.Label
import org.eclipse.swt.layout.GridData
import org.eclipse.swt.SWT
import org.eclipse.swt.layout.GridLayout
import org.eclipse.swt.widgets.Button
import org.eclipse.xtext.scoping.IGlobalScopeProvider
import org.eclipse.core.resources.IFile
import org.eclipse.emf.common.util.URI
import org.eclipse.core.runtime.CoreException
import org.eclipse.jface.dialogs.ErrorDialog
import org.eclipse.core.resources.IncrementalProjectBuilder
import org.eclipse.core.runtime.IStatus
import org.osate.aadl2.modelsupport.Activator
import org.eclipse.ui.statushandlers.StatusManager
import org.osate.ge.internal.services.DiagramService
import org.eclipse.ui.PlatformUI
import org.eclipse.core.runtime.Status
import org.eclipse.core.runtime.NullProgressMonitor
import org.osate.aadl2.NamedElement
import org.eclipse.xtext.resource.XtextResourceSet
import org.osate.aadl2.Aadl2Package
import org.eclipse.core.resources.IContainer
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.core.runtime.Path
import org.eclipse.core.resources.IFolder
import org.eclipse.xtext.naming.IQualifiedNameConverter
import org.eclipse.xtext.resource.IEObjectDescription

class NewAadlPackageWizard extends AbstractNewFileWizard {
	val PACKAGE_LABEL = "AADL package name"
	
	@Inject IParser parser
	@Inject Aadl2GrammarAccess grammarAccess
	
	private Button textButton;
	private Button graphicalButton;

	@Inject
	IGlobalScopeProvider globalScopeProvider
	@Inject
	IQualifiedNameConverter qNameConverter;
	
	new() {
		super("AADL Package", "AADL package", "aadl", 1, OsateUiPlugin.^default.log, OsateUiPlugin.PLUGIN_ID)
		MyAadl2Activator.instance.getInjector(MyAadl2Activator.ORG_OSATE_XTEXT_AADL2_AADL2).injectMembers(this)
		addField(PACKAGE_LABEL, [fieldValue | fieldValue.matches("\\S+") &&
			!parser.parse(grammarAccess.PNAMERule, new StringReader(fieldValue)).hasSyntaxErrors
		])
	}
	
	override addLocalControls(Composite parent) {
		new Label(parent, SWT.NONE) => [label |
			label.text = "Open with"
			label.layoutData = new GridData(SWT.END, SWT.TOP, false, false)
		]
		
		new Composite(parent, SWT.NONE) => [radios |
			radios.layout = new GridLayout(1, false)
			
			textButton = new Button(radios, SWT.RADIO.bitwiseOr(SWT.LEFT)) => [button |
				button.layoutData = new GridData(SWT.BEGINNING, SWT.TOP, false, false)
				button.setText("Text Editor")
			]
			graphicalButton = new Button(radios, SWT.RADIO.bitwiseOr(SWT.LEFT)) => [button |
				button.layoutData = new GridData(SWT.BEGINNING, SWT.TOP, false, false)
				button.setText("Diagram Editor")
			]
			textButton.setSelection(true)
			graphicalButton.setSelection(false)
		]
	}
	
	def private IEObjectDescription findPackageInScope(IContainer parent, String packageName) {
		/* Parent might be a Project, which causes problems below, so let's append
		 * a bogus folder to it.
		 */
		val IFolder fakeFolder = parent.getFolder(Path.forPosix(".fake"))
		val Resource rsrc = OsateResourceUtil.getResource(fakeFolder)
		val scope = globalScopeProvider.getScope(rsrc, Aadl2Package.eINSTANCE.getPackageRename_RenamedPackage(), null)
		val qualifiedName = qNameConverter.toQualifiedName(packageName);
		scope.getSingleElement(qualifiedName)
	}
		
	/* Not going to get here if no project is selected, so parent will never be null */
	override String validateFileName(IContainer parent, String packageName) {
		/*
		 * This method checks for 4 different error conditions.  Consider three projects:
		 * A, B, and C.  Assume project C depends on both A and B, and the neither A nor B 
		 * depend on any other projects.
		 * 
		 * (1) We are trying to create package x::y::z in a project X (could be A, B, or C)
		 * and X already directly contains package x::y::z.
		 * 
		 * (2) We are trying to create package x::y::z in project C and the package already 
		 * exists in A or C.
		 * 
		 * These first two cases are true errors: We are trying to introduce a package into a namespace
		 * where the package already exists.  The next two cases aren't really errors, but they create
		 * errors elsewhere.
		 * 
		 * (3) We are trying to create package x::y::z in project A or B and the package already 
		 * exists in project C.  This is not really an error because the fact that C already 
		 * contains the package does not affect the namespace of A or B.  But adding the package to 
		 * A or B will mess up C, so we disallow it.  Ideally we should use a WARNING here and 
		 * not an ERROR, but the wizards don't really give us this option.
		 * 
		 * (4) We are trying to create package x::y::z in project A and the package already 
		 * exists in project B.  Because C depends on both A and B, it will have two versions
		 * of the package in its namespace.  Again, this does not break project A, but will mess up C,
		 * so we disallow it.  Ideally we should use a WARNING here and  not an ERROR, but the
		 * wizards don't really give us this option.
		 */
		var String errorMsg = null
		val foundInScope = findPackageInScope(parent, packageName)
		if (foundInScope !== null) {
			val foundFile = OsateResourceUtil.getOsateIFile(foundInScope.EObjectURI)
			val foundProject = foundFile.getProject()
			if (foundProject === parent.getProject()) {
				// Case (1)
				errorMsg = "Package '" + packageName + "' already exists in the selected project: '" + foundFile.projectRelativePath + "'"
			} else {
				// Case (2)
				errorMsg = "Package '" + packageName + "' already exists in project '" + foundProject.name + "' that the selected project depends on: '" + foundFile.projectRelativePath + "'"
			}
		} else {
			/* See if the package exists in scope in any project that depends on the current project.
			 * This isn't an error for the current project, but it will mess up other projects.
			 */
			for (referencer : parent.getProject().referencingProjects) {
				val foundInScopeOfReferencer = findPackageInScope(referencer, packageName)
				if (foundInScopeOfReferencer !== null) {
					val foundFile = OsateResourceUtil.getOsateIFile(foundInScopeOfReferencer.EObjectURI)
					val foundProject = foundFile.getProject()
					if (foundProject === referencer) {
						// Case (3)
						errorMsg = "Package '" + packageName + "' already exists in project '" + referencer.name + "' that depends on the selected project: '" + foundFile.projectRelativePath + "'"
					} else {
						// Case (4)
						errorMsg = "Package '" + packageName + "' already exists in project '" + foundProject.name + "' that is depended on by project '" + referencer.name + "' that depends on the selected project: '" + foundFile.projectRelativePath + "'"
					}
				}
			}
		}
		
		errorMsg
	}
	
	
	override void openEditor(IFile newFile, String contents) {
		if (textButton.getSelection()) {
			openDefaultEditor(newFile, contents)
		} else if (graphicalButton.getSelection()) {
			openGraphicalEditor(newFile)
		}
	}
	
	def private void openGraphicalEditor(IFile newFile) {
		// Build the project so that the index will be updated
		if (project !== null) {
			try {
				project.build(IncrementalProjectBuilder.INCREMENTAL_BUILD, new NullProgressMonitor());
			} catch (CoreException ex) {
				val status = new Status(IStatus.ERROR, Activator.getPluginId(),
						"An error building the AADL project after creating a new AADL file.", ex);
				StatusManager.getManager().handle(status, StatusManager.SHOW.bitwiseOr(StatusManager.LOG));
			} catch (RuntimeException ex) {
				val status = new Status(IStatus.ERROR, Activator.getPluginId(),
						"An error building the AADL project after creating a new AADL file.", ex);
				StatusManager.getManager().handle(status, StatusManager.SHOW.bitwiseOr(StatusManager.LOG));
			}
		}

		// Get the element from the newly created AADL package
		val uri = URI.createPlatformResourceURI(newFile.getFullPath().toString(), true);
		val resourceSet = new XtextResourceSet();
		val pkgResource = resourceSet.getResource(uri, true);
		if (pkgResource.getContents().size() > 0 && pkgResource.getContents().get(0) instanceof NamedElement) {
			// Open the diagram
			val diagramService = PlatformUI.getWorkbench()
					.getActiveWorkbenchWindow().getService(typeof(DiagramService));
			diagramService.openOrCreateDiagramForBusinessObject(pkgResource.getContents().get(0), false, false);
		} else {
			val status = new Status(IStatus.ERROR, Activator.getPluginId(),
					"Unable to retrieve package from resource.", null);
			StatusManager.getManager().handle(status, StatusManager.LOG);
			ErrorDialog.openError(getContainer().getShell(), "Unable to Create Diagram", null, status);
		}
	}
	
	override fileContents(Map<String, String> fieldValues) {
		val packageName = fieldValues.get(PACKAGE_LABEL)
		'''
			package «packageName»
			public
				
			end «packageName»;'''
	}
	
	override protected getFileName(String enteredName) {
		super.getFileName(enteredName).replaceAll(WorkspacePlugin.AADL_PACKAGE_SEPARATOR,
			WorkspacePlugin.FILE_PACKAGE_SEPARATOR
		)
	}
}