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
package org.osate.ge.internal.ui.xtext;

import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IPageListener;
import org.eclipse.ui.IWindowListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.osate.aadl2.NamedElement;

public class AgeXtextUtil {
	private static final OpenAadlResources openAadlResources = new OpenAadlResources();
	private static final AtomicBoolean initialized = new AtomicBoolean(false);

	/**
	 * Registers listeners to listen to model changes from all Xtext editors and to be notified of newly opened xtext editors.
	 *
	 */
	private static void ensureInitialized() {
		if (!initialized.getAndSet(true)) {
			Display.getDefault().asyncExec(() -> {
				// Listen for the opening of new windows
				PlatformUI.getWorkbench().addWindowListener(new IWindowListener() {
					@Override
					public void windowActivated(IWorkbenchWindow window) {
					}

					@Override
					public void windowDeactivated(IWorkbenchWindow window) {
					}

					@Override
					public void windowClosed(IWorkbenchWindow window) {
					}

					@Override
					public void windowOpened(IWorkbenchWindow window) {
						registerListenersForWindow(window);
					}
				});

				// Register existing windows
				for (final IWorkbenchWindow window : PlatformUI.getWorkbench().getWorkbenchWindows()) {
					registerListenersForWindow(window);
				}
			});
		}
	}

	/**
	 * Register listeners for the window
	 * @param window
	 */
	private static void registerListenersForWindow(final IWorkbenchWindow window) {
		window.addPageListener(new IPageListener() {
			@Override
			public void pageActivated(IWorkbenchPage page) {
			}

			@Override
			public void pageClosed(IWorkbenchPage page) {
			}

			@Override
			public void pageOpened(IWorkbenchPage page) {
				registerListenerForPage(page);
			}
		});

		for(final IWorkbenchPage page : window.getPages()) {
			registerListenerForPage(page);
		}
	}

	/**
	 * Register part listeners for a page
	 * @param page
	 */
	private static void registerListenerForPage(final IWorkbenchPage page) {
		page.addPartListener(new EditorListener(page, openAadlResources));
	}

	/**
	 * Returns the Xtext document with a root element which has a qualified name and resource that matches the specified element
	 * @return the last document updated for the qualified name and resource or null if one does not exist
	 */
	public static IXtextDocument getDocumentByRootElement(final NamedElement element) {
		ensureInitialized();

		final Resource elementResource = element.eResource();
		if (elementResource == null) {
			return null;
		}

		return getDocumentByRootElement(element.getQualifiedName(), elementResource.getURI());
	}

	public static IXtextDocument getDocumentByRootElement(final String elementQualifiedName, final URI resourceUri) {
		ensureInitialized();
		return openAadlResources.getDocument(elementQualifiedName, resourceUri);
	}

	public static void addModelListener(final XtextDocumentChangeListener listener) {
		ensureInitialized();
		openAadlResources.addModelListener(listener);
	}

	public static void removeModelListener(final XtextDocumentChangeListener listener) {
		ensureInitialized();
		openAadlResources.removeModelListener(listener);
	}

	public static Set<IXtextDocument> getOpenXtextDocuments() {
		return openAadlResources.getOpenXtextDocuments();
	}
}