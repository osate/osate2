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