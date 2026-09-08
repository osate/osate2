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
package org.osate.xtext.aadl2.properties.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IStartup;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.osate.pluginsupport.PluginSupportUtil;
import org.osate.xtext.aadl2.properties.ui.internal.PropertiesActivator;

public class PropertiesUiStartup implements IStartup {
	@Override
	public void earlyStartup() {
		var pluginResourcesProject = ResourcesPlugin.getWorkspace().getRoot().getProject("Plugin_Resources");
		if (!pluginResourcesProject.exists()) {
			return;
		}

		var shouldMigrate = new AtomicBoolean(false);
		Display.getDefault().syncExec(() -> shouldMigrate.set(MessageDialog.openQuestion(null, "Workspace Migration",
				"AADL files contributed from plugins are no longer placed into the 'Plugin_Resources' project in the"
						+ " workspace. Migration of the workspace involves deleting all unmodified contributed AADL files from"
						+ " 'Plugin_Resources' and removing the 'Plugin_Resources' project if it is empty. Do you want the"
						+ " workspace to be migrated?")));
		if (!shouldMigrate.get()) {
			return;
		}

		var projectRemains = new AtomicBoolean(false);
		var operation = new WorkspaceModifyOperation() {
			@Override
			protected void execute(IProgressMonitor monitor) throws CoreException {
				setModifiable(pluginResourcesProject);
				deleteUnmodifiedContributed(pluginResourcesProject, PluginSupportUtil.getContributedAadl(),
						new ResourceSetImpl().getURIConverter(), monitor);
				if (hasVisibleMembers(pluginResourcesProject)) {
					projectRemains.set(true);
				} else {
					pluginResourcesProject.delete(true, true, monitor);
				}
			}
		};
		try {
			operation.run(null);
			if (projectRemains.get()) {
				Display.getDefault()
						.asyncExec(() -> MessageDialog.openError(null,
								"Custom Files in 'Plugin_Resources' Project",
								"All of the unmodified contributed AADL files in the 'Plugin_Resources' project have been"
										+ " deleted, however some custom files have remained. Please copy these files into a"
										+ " separate project and remove them from the 'Plugin_Resources' project."));
			}
		} catch (InvocationTargetException | InterruptedException e) {
			logCouldNotDelete(e);
		}
	}

	private static void setModifiable(IContainer container) throws CoreException {
		for (var member : container.members()) {
			var attributes = member.getResourceAttributes();
			if (attributes.isReadOnly()) {
				attributes.setReadOnly(false);
				member.setResourceAttributes(attributes);
			}

			if (member instanceof IContainer childContainer) {
				setModifiable(childContainer);
			}
		}
	}

	private static void deleteUnmodifiedContributed(IContainer container, List<URI> contributedURIs,
			URIConverter uriConverter, IProgressMonitor monitor) throws CoreException {
		for (var member : container.members()) {
			if (member instanceof IFile file && !file.getName().startsWith(".")
					&& "aadl".equals(file.getFileExtension())
					&& isUnmodifiedContributed(file, contributedURIs, uriConverter)) {
				file.delete(true, true, monitor);
			}
		}

		/* The members are read again so that the files deleted above are no longer seen. */
		for (var member : container.members()) {
			if (member instanceof IFolder folder && !folder.getName().startsWith(".")) {
				deleteUnmodifiedContributed(folder, contributedURIs, uriConverter, monitor);
				if (!hasVisibleMembers(folder)) {
					folder.delete(true, true, monitor);
				}
			}
		}
	}

	private static boolean isUnmodifiedContributed(IFile file, List<URI> contributedURIs, URIConverter uriConverter)
			throws CoreException {
		for (var contributedURI : contributedURIs) {
			try {
				if (readFully(uriConverter.createInputStream(contributedURI)).equals(readFully(file.getContents()))) {
					return true;
				}
			} catch (IOException e) {
				/*
				 * Thrown undeclared, as the Xtend compiler did. WorkspaceModifyOperation.execute may only declare
				 * CoreException, InvocationTargetException and InterruptedException, so wrapping the IOException here
				 * would change which exception escapes early startup.
				 */
				throw Exceptions.sneakyThrow(e);
			}
		}
		return false;
	}

	private static boolean hasVisibleMembers(IContainer container) throws CoreException {
		for (var member : container.members()) {
			if (!member.getName().startsWith(".")) {
				return true;
			}
		}
		return false;
	}

	private static String readFully(InputStream inputStream) throws IOException {
		try (var reader = new BufferedReader(new InputStreamReader(inputStream))) {
			return reader.lines().collect(Collectors.joining());
		}
	}

	private static void logCouldNotDelete(Exception e) {
		var status = new Status(IStatus.ERROR, PropertiesActivator.getInstance().getBundle().getSymbolicName(),
				"Could not delete 'Plugin_Resources' project.", e);
		PropertiesActivator.getInstance().getLog().log(status);
	}
}
