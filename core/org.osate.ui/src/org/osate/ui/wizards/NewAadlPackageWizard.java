/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.ui.wizards;

import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.statushandlers.StatusManager;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.modelsupport.Activator;
import org.osate.aadl2.modelsupport.FileNameConstants;
import org.osate.ge.internal.services.DiagramService;
import org.osate.xtext.aadl2.ui.util.Aadl2NameValidators;

public final class NewAadlPackageWizard extends AbstractNewModelUnitWizard {
	private static final String PACKAGE_LABEL = "AADL package name";

	private Button textButton;

	private Button graphicalButton;

	public NewAadlPackageWizard() {
		super("AADL Package", "AADL package");
		addField(PACKAGE_LABEL, Aadl2NameValidators.PACKAGE_NAME_VALIDATOR);
	}

	@Override
	public void addLocalControls(Composite parent) {
		var label = new Label(parent, SWT.NONE);
		label.setText("Open with");
		label.setLayoutData(new GridData(SWT.END, SWT.TOP, false, false));

		var radios = new Composite(parent, SWT.NONE);
		radios.setLayout(new GridLayout(1, false));

		textButton = new Button(radios, SWT.RADIO | SWT.LEFT);
		textButton.setLayoutData(new GridData(SWT.BEGINNING, SWT.TOP, false, false));
		textButton.setText("Text Editor");

		graphicalButton = new Button(radios, SWT.RADIO | SWT.LEFT);
		graphicalButton.setLayoutData(new GridData(SWT.BEGINNING, SWT.TOP, false, false));
		graphicalButton.setText("Diagram Editor");

		textButton.setSelection(true);
		graphicalButton.setSelection(false);
	}

	@Override
	public void openEditor(IFile newFile, String contents) {
		if (textButton.getSelection()) {
			openDefaultEditor(newFile, contents);
		} else if (graphicalButton.getSelection()) {
			openGraphicalEditor(newFile);
		}
	}

	private void openGraphicalEditor(IFile newFile) {
		if (project != null) {
			try {
				project.build(IncrementalProjectBuilder.INCREMENTAL_BUILD, new NullProgressMonitor());
			} catch (CoreException | RuntimeException ex) {
				var status = new Status(IStatus.ERROR, Activator.getPluginId(),
						"An error building the AADL project after creating a new AADL file.", ex);
				StatusManager.getManager().handle(status, StatusManager.SHOW | StatusManager.LOG);
			}
		}

		var uri = URI.createPlatformResourceURI(newFile.getFullPath().toString(), true);
		var resourceSet = new XtextResourceSet();
		var pkgResource = resourceSet.getResource(uri, true);
		var packageContents = pkgResource.getContents();
		if (!packageContents.isEmpty() && packageContents.getFirst() instanceof NamedElement aadlPackage) {
			var diagramService = PlatformUI.getWorkbench()
					.getActiveWorkbenchWindow()
					.getService(DiagramService.class);
			diagramService.openOrCreateDiagramForBusinessObject(aadlPackage, false, false);
		} else {
			var status = new Status(IStatus.ERROR, Activator.getPluginId(), "Unable to retrieve package from resource.",
					null);
			StatusManager.getManager().handle(status, StatusManager.LOG);
			ErrorDialog.openError(getContainer().getShell(), "Unable to Create Diagram", null, status);
		}
	}

	@Override
	public String fileContents(Map<String, String> fieldValues) {
		var packageName = fieldValues.get(PACKAGE_LABEL);
		/* The lone tab is the indented empty line where the first declaration goes. */
		return "package " + packageName + "\npublic\n\t\nend " + packageName + ";";
	}

	@Override
	protected String getFileName(String enteredName) {
		return super.getFileName(enteredName)
				.replaceAll(FileNameConstants.AADL_PACKAGE_SEPARATOR, FileNameConstants.FILE_PACKAGE_SEPARATOR);
	}
}
