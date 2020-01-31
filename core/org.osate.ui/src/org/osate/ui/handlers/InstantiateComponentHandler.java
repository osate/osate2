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
package org.osate.ui.handlers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode;
import org.eclipse.xtext.ui.resource.XtextResourceSetProvider;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.aadl2.modelsupport.EObjectURIWrapper;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.xtext.aadl2.ui.internal.Aadl2Activator;

import com.google.inject.Inject;

public class InstantiateComponentHandler extends AbstractHandler {
	@Inject
	private XtextResourceSetProvider resourceSetProvider;

	public InstantiateComponentHandler() {
		Aadl2Activator.getInstance().getInjector(Aadl2Activator.ORG_OSATE_XTEXT_AADL2_AADL2).injectMembers(this);
	}

	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		final List<URI> selectedURIs = new ArrayList<>();
		for (final Object selection : HandlerUtil.getCurrentStructuredSelection(event).toList()) {
			URI uri;
			if (selection instanceof EObjectNode) {
				uri = ((EObjectNode) selection).getEObjectURI();
			} else if (selection instanceof EObjectURIWrapper) {
				uri = ((EObjectURIWrapper) selection).getUri();
			} else {
				throw new AssertionError("Unexpected selection: " + selection);
			}
			selectedURIs.add(uri);
		}

		final Job job = new InstantiationJob(selectedURIs);
		job.setRule(ResourcesPlugin.getWorkspace().getRoot());
		job.setUser(true);
		job.schedule();

		return null;
	}

	private final class InstantiationJob extends WorkspaceJob {
		private final List<URI> componentURIs;

		public InstantiationJob(final List<URI> uris) {
			super("Instantiate component");
			componentURIs = uris;
		}

		@Override
		public IStatus runInWorkspace(final IProgressMonitor monitor) {
			final int size = componentURIs.size();
			final SubMonitor subMonitor = SubMonitor.convert(monitor, size);

			/*
			 * Error handling in buildIntanceModel is complicated and probably should not be handled the
			 * way it is, but I don't want to fix that right now, so we are going to capture all the information
			 * we can from it and display it to the user at the end of the operation.
			 */
			boolean allGood = true;
			final ComponentImplementation[] compImpl = new ComponentImplementation[size];
			final boolean[] successful = new boolean[size];
			final String[] errorMessages = new String[size];
			final Exception[] exceptions = new Exception[size];
			boolean cancelled = false;

			/* Init compImpl first so that we have all the components for enumeration errors later. */
			for (int i = 0; i < size; i++) {
				final URI uri = componentURIs.get(i);
				final IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(uri.segment(1));
				final ResourceSet resourceSet = resourceSetProvider.get(project);
				final ComponentImplementation impl = (ComponentImplementation) resourceSet.getEObject(uri, true);
				compImpl[i] = impl;
			}

			/*
			 * Start at -1 because this is indexed at the START of the loop so that when we exit the loop
			 * either normally or because of cancellation this is always the most recent index value
			 * of the URI we tried to instantiate.
			 */
			int lastTried = -1;
			for (final ComponentImplementation impl : compImpl) {
				lastTried += 1;
				boolean delete = false;
				boolean breakOut = false;
				try {
					final SystemInstance instance = InstantiateModel.buildInstanceModelFile(impl, subMonitor.split(1));
					final boolean success = instance != null;
					allGood &= success;
					successful[lastTried] = success;
					errorMessages[lastTried] = InstantiateModel.getErrorMessage();
					delete = !success;
				} catch (final InterruptedException e) {
					// Instantiation was canceled by the user.
					cancelled = true;
					allGood = false;
					delete = true;
					breakOut = true; // jump out of the for-loop
				} catch (final Exception e) {
					allGood = false;
					// save for later
					successful[lastTried] = false;
					exceptions[lastTried] = e;
					delete = true;
					// We try the next instantiation
				}

				if (delete) {
					// Remove the partially instantiated resource
					try {
						final IFile instanceFile = OsateResourceUtil
								.toIFile(InstantiateModel.getInstanceModelURI(impl));
						if (instanceFile.exists()) {
							instanceFile.delete(0, null);
						}
					} catch (final CoreException ce) {
						// eat it
					}
				}

				if (breakOut) {
					break;
				}
			}

			/*
			 * Best case: alLGood is true and cancelled is false. Otherwise, we have to
			 * show a dialog that tells the user what did or didn't happen.
			 */

			/*
			 * Do we always show the results, or only when it was cancelled or there was an error? Control by
			 * a workspace setting?
			 */

			if (true) { // !allGood) {
				final StringBuilder sb = new StringBuilder();
				if (cancelled) {
					sb.append(cancelled ? "Instantiation cancelled by the user:" : "Errors during instantiation:");
				}
				sb.append(System.lineSeparator());
				for (int i = 0; i < size; i++) {
					sb.append("- ");
					sb.append(compImpl[i].getQualifiedName());
					sb.append(": ");
					if (!cancelled || i < lastTried) {
						if (successful[i]) {
							sb.append("Successfully instantiated");
						} else {
							if (errorMessages[i] != null) {
								sb.append(errorMessages[i]);
							} else if (exceptions[i] != null) {
								final Exception e = exceptions[i];
								if (e instanceof UnsupportedOperationException) {
									sb.append("Operation is not supported: ");
									sb.append(e.getMessage());
								} else {
									sb.append(e.getClass().getCanonicalName());
									sb.append(" during instantiation");
								}
							}
						}
					} else {
						sb.append("Not instantiated");
					}
					sb.append(System.lineSeparator());
				}

				final String errMessage = sb.toString(); // string builder isn't threadsafe
				PlatformUI.getWorkbench().getDisplay().asyncExec(() -> {
					MessageDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
							"Errors during model Instantiation", errMessage);

//					final InstantiationResultsDialog d = new InstantiationResultsDialog(
//							PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell());
//					d.open();
				});
			}

			return cancelled ? Status.CANCEL_STATUS : Status.OK_STATUS;
		}
	}
}
