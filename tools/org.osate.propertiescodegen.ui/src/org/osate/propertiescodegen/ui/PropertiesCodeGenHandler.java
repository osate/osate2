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
package org.osate.propertiescodegen.ui;

import java.io.ByteArrayInputStream;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.ContainerGenerator;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.statushandlers.StatusManager;
import org.osate.aadl2.PropertySet;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.propertiescodegen.PropertiesCodeGen;
import org.osate.xtext.aadl2.ui.resource.ContributedAadlStorage;

public class PropertiesCodeGenHandler extends AbstractHandler {
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		try {
			switch (HandlerUtil.getCurrentStructuredSelection(event).getFirstElement()) {
			case ContributedAadlStorage storage -> generate(storage.getUri(), storage.getProject(), event);
			case IFile file -> {
				var markers = file.findMarkers(null, true, IResource.DEPTH_ONE);
				if (!hasErrors(markers)) {
					generate(OsateResourceUtil.toResourceURI(file), file.getProject(), event);
				} else {
					MessageDialog.openError(HandlerUtil.getActiveShell(event), "Errors in Property Set",
							"Cannot generate Java property getters for \"" + file.getName()
									+ "\" because it has errors.");
				}
			}
			case null, default -> {
			}
			}
		} catch (CoreException e) {
			throw new ExecutionException("Error while reading property set markers.", e);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			throw new ExecutionException("Java property generation was interrupted.", e);
		}
		return null;
	}

	private static boolean hasErrors(IMarker[] markers) throws CoreException {
		for (var marker : markers) {
			if (Integer.valueOf(IMarker.SEVERITY_ERROR).equals(marker.getAttribute(IMarker.SEVERITY))) {
				return true;
			}
		}
		return false;
	}

	private static void generate(URI propertySetURI, IProject project, ExecutionEvent event)
			throws InterruptedException {
		var resource = new ResourceSetImpl().getResource(propertySetURI, true);
		var propertySet = (PropertySet) resource.getContents().getFirst();
		var generatedPackage = PropertiesCodeGen.generateJava(propertySet);
		var javaFiles = generatedPackage.getClasses();
		var operation = new WorkspaceModifyOperation() {
			@Override
			protected void execute(IProgressMonitor monitor) throws CoreException {
				var subMonitor = SubMonitor.convert(monitor, "Generating Java Property Getters",
						javaFiles.size() * 2 + 1);
				var folderPath = project.getFullPath().append(generatedPackage.getPackagePath());
				var folder = new ContainerGenerator(folderPath).generateContainer(subMonitor.split(1));
				subMonitor.setWorkRemaining(folder.members().length + javaFiles.size());
				for (var javaFile : javaFiles) {
					var stream = new ByteArrayInputStream(javaFile.getContents().getBytes());
					var file = folder.getFile(new Path(javaFile.getFileName()));
					if (file.exists()) {
						file.setContents(stream, false, true, subMonitor.split(1));
					} else {
						file.create(stream, false, subMonitor.split(1));
					}
				}
			}
		};
		try {
			HandlerUtil.getActiveWorkbenchWindow(event).run(true, true, operation);
		} catch (InvocationTargetException e) {
			var status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Error while generating Java property getters.",
					e.getTargetException());
			StatusManager.getManager().handle(status, StatusManager.LOG | StatusManager.SHOW);
		}
	}
}
