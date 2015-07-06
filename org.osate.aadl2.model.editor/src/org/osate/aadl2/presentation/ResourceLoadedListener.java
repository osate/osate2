/**
 * <copyright>
 *
 * Copyright (c) 2005, 2007 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 */

package org.osate.aadl2.presentation;

import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.DemultiplexingListener;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
import org.osate.emf.workspace.util.WorkspaceSynchronizer;

/**
 * Listens for the loading of resources, and creates editors on them when they
 * load.
 *
 * @author Christian W. Damus (cdamus)
 */
public class ResourceLoadedListener extends DemultiplexingListener {
	private static ResourceLoadedListener instance;

	private final Set<Resource> ignoredResources = new java.util.HashSet<Resource>();

	/**
	 * Initializes me with my filter.
	 */
	public ResourceLoadedListener() {
		super(NotificationFilter.createFeatureFilter(EcorePackage.eINSTANCE.getEResource(),
				Resource.RESOURCE__IS_LOADED));

		instance = this;
	}

	/**
	 * Returns the default listener instance.
	 *
	 * @return the instance associated with the editing domain that manages the
	 *     specified resource set, or <code>null</code> if none is found
	 */
	public static ResourceLoadedListener getDefault() {
		return instance;
	}

	/**
	 * Ignores any future load/unload notifications from the specified resource,
	 * until the next call to {@link #watch(Resource) watch(res)}.
	 *
	 * @param res the resource to ignore
	 */
	public void ignore(Resource res) {
		ignoredResources.add(res);
	}

	/**
	 * Ceases to {@link #ignore(Resource)} a previously ignored resource.
	 *
	 * @param res the resource
	 */
	public void watch(Resource res) {
		ignoredResources.remove(res);
	}

	@Override
	protected void handleNotification(TransactionalEditingDomain domain, Notification notification) {
		if (ignoredResources.contains(notification.getNotifier())) {
			// skip any resource that we are supposed to ignore
			return;
		}

		if (notification.getNewBooleanValue() && !notification.getOldBooleanValue()) {
			// a resource has been loaded that was not loaded before. Open an editor
			final IFile file = WorkspaceSynchronizer.getFile((Resource) notification.getNotifier());

//			if (file != null) {
//				Display.getDefault().asyncExec(new Runnable() {
//					public void run() {
//						try {
//							IWorkbenchPage page = getActivePage();
//
//							if (page != null) {
//								IEditorPart activeEditor = page.getActiveEditor();
//
//								page.openEditor(new FileEditorInput(file),
//										"org.osate.aadl2.instance.presentation.InstanceEditorID", //$NON-NLS-1$
//										false);
//
//								// restore the previously active editor to active
//								//    state
//								if (activeEditor != null) {
//									page.activate(activeEditor);
//								}
//							}
//						} catch (PartInitException e) {
//							Aadl2EditorPlugin.getPlugin().log(e.getStatus());
//						}
//					}
//				});
//			}
		} else if (!notification.getNewBooleanValue() && notification.getOldBooleanValue()) {
			// a resource has been unloaded that was loaded before. Close
			// the editor, if any
			final IFile file = WorkspaceSynchronizer.getFile((Resource) notification.getNotifier());

			if (file != null) {
				Display.getDefault().asyncExec(new Runnable() {
					@Override
					public void run() {
						IWorkbenchPage page = getActivePage();

						if (page != null) {
							IEditorReference[] editors = page.findEditors(new FileEditorInput(file),
									"org.osate.aadl2.presentation.Aadl2ModelEditorID",
//									"org.osate.aadl2.instance.presentation.InstanceEditorID", //$NON-NLS-1$
									IWorkbenchPage.MATCH_ID | IWorkbenchPage.MATCH_INPUT);

							page.closeEditors(editors, false);
						}
					}
				});
			}
		}
	}

	/**
	 * Obtains the currently active workbench page.
	 *
	 * @return the active page, or <code>null</code> if none is active
	 */
	private IWorkbenchPage getActivePage() {
		IWorkbenchPage result = null;

		IWorkbench bench = PlatformUI.getWorkbench();
		if (bench != null) {
			IWorkbenchWindow window = bench.getActiveWorkbenchWindow();

			if (window != null) {
				result = window.getActivePage();
			}
		}

		return result;
	}
}
