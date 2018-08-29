package org.osate.ui.wizards

import java.util.Map
import org.osate.workspace.WorkspacePlugin
import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.widgets.Label
import org.eclipse.swt.layout.GridData
import org.eclipse.swt.SWT
import org.eclipse.swt.layout.GridLayout
import org.eclipse.swt.widgets.Button
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
import org.osate.xtext.aadl2.ui.util.Aadl2NameValidators

final class NewAadlPackageWizard extends AbstractNewModelUnitWizard {
	val static PACKAGE_LABEL = "AADL package name"
	
	private Button textButton;
	private Button graphicalButton;
	
	new() {
		super("AADL Package", "AADL package")
		addField(PACKAGE_LABEL, Aadl2NameValidators.PACKAGE_NAME_VALIDATOR)
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