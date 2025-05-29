/**
 * Copyright (c) 2004-2025 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.aadl2.instance.ui;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.statushandlers.StatusManager;
import org.eclipse.xtext.resource.FileExtensionProvider;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.textual.ui.internal.TextualActivator;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class GenerateTextualInstanceHandler extends AbstractHandler {
	@Inject
	private Provider<XtextResourceSet> resourceSetProvider;

	@Inject
	private FileExtensionProvider fileExtensionProvider;

	public GenerateTextualInstanceHandler() {
		var injector = TextualActivator.getInstance()
				.getInjector(TextualActivator.ORG_OSATE_AADL2_INSTANCE_TEXTUAL_INSTANCE);
		injector.injectMembers(this);
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		try {
			new ProgressMonitorDialog(HandlerUtil.getActiveShell(event)).run(true, true, monitor -> {
				monitor.beginTask("Generating Text", 2);
				var sourceFile = (IFile) HandlerUtil.getCurrentStructuredSelection(event).getFirstElement();
				var sourceUri = URI.createPlatformResourceURI(sourceFile.getFullPath().toString(), false);
				var sourceResource = resourceSetProvider.get().getResource(sourceUri, true);

				var destUri = sourceUri.trimFileExtension()
						.appendFileExtension(fileExtensionProvider.getPrimaryFileExtension());
				var destResource = resourceSetProvider.get().createResource(destUri);
				destResource.getContents().add(EcoreUtil.copy(sourceResource.getContents().get(0)));
				if (destResource.getContents().get(0) instanceof SystemInstance root) {
					root.setClassifier(null);
				}
				destResource.getAllContents().forEachRemaining(eObject -> {
					if (eObject instanceof ComponentInstance component && !(component instanceof SystemInstance)
							&& component.getIndices().size() == 1 && component.getIndices().get(0) == 0L) {
						component.getIndices().clear();
					} else if (eObject instanceof FeatureInstance fi) {
						fi.setType(null);
					}
					if (eObject instanceof InstanceObject instanceObject) {
						instanceObject.getAnnexInstances().clear();
					}
				});
				try {
					destResource.save(null);
				} catch (IOException e) {
					throw new InvocationTargetException(e);
				}
				monitor.worked(1);

				if (!monitor.isCanceled()) {
					var destFile = sourceFile.getWorkspace()
							.getRoot()
							.getFile(new Path(destUri.toPlatformString(false)));
					HandlerUtil.getActiveShell(event).getDisplay().syncExec(() -> {
						try {
							IDE.openEditor(HandlerUtil.getActiveWorkbenchWindow(event).getActivePage(), destFile);
						} catch (PartInitException e) {
							throw new RuntimeException(e);
						}
					});
					monitor.worked(1);
				}
				monitor.done();
			});
		} catch (InvocationTargetException e) {
			var status = new Status(IStatus.ERROR, Activator.PLUGIN_ID,
					"Problem generating textual instance: " + e.getMessage(), e);
			StatusManager.getManager().handle(status, StatusManager.LOG | StatusManager.SHOW);
		} catch (InterruptedException e) {
			// Do nothing.
		}

		return null;
	}
}