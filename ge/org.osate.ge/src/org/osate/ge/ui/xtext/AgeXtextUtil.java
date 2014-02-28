/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.ui.xtext;

import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IPageListener;
import org.eclipse.ui.IStartup;
import org.eclipse.ui.IWindowListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.IXtextModelListener;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.ge.util.StringUtil;

public class AgeXtextUtil {
	private static final ModelListener modelListener = new ModelListener();
	
	/**
	 * Registers listeners to listen to model changes from all Xtext editors and to be notified of newly opened xtext editors.
	 * @author philip.alldredge
	 *
	 */
	public static class Initializer  implements IStartup {		
		public void earlyStartup() {
			Display.getDefault().asyncExec(new Runnable() {
				public void run() {
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
					for(final IWorkbenchWindow window : PlatformUI.getWorkbench().getWorkbenchWindows()) {
						registerListenersForWindow(window);		
					}
				}
			});
		}
		
		/**
		 * Register listeners for the window
		 * @param window
		 */
		private void registerListenersForWindow(final IWorkbenchWindow window) {
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
		private void registerListenerForPage(final IWorkbenchPage page) {
			page.addPartListener(new EditorListener(page, modelListener));	
		}
	}
	
	// TODO: Handle private vs public sections
	/**
	 * Returns the resource set that contains the resource with the package of the element with the specified qualified name
	 * @param qualifiedName
	 * @return
	 */
	public static XtextResourceSet getResourceSetByQualifiedName(final String qualifiedName) {
		// First check if the qualified name corresponds to a package
		XtextResourceSet rs = modelListener.getResourceSet(qualifiedName);
		if(rs != null) {
			return rs;
		}
		
		final String segs[] = qualifiedName.split("::");
		final String packageName = StringUtil.join(segs, 0, segs.length-1, "::");
		rs = modelListener.getResourceSet(packageName);
		return rs == null ? OsateResourceUtil.getResourceSet() : rs;
	}
	
	/**
	 * Returns the resource set that contains the resource with the package of the element with the specified qualified name
	 * @param qualifiedName
	 * @return the last document updated for the qualified name or null if one does not exist
	 */
	public static IXtextDocument getDocumentByQualifiedName(final String qualifiedName) {
		// Check if the qualified name is a package
		IXtextDocument document = modelListener.getDocument(qualifiedName);
		if(document != null) {
			return document;
		}
		
		// Assume it was not
		final String segs[] = qualifiedName.split("::");
		final String packageName = StringUtil.join(segs, 0, segs.length-1, "::");
		return modelListener.getDocument(packageName);
	}
	
	public static void addModelListener(final IXtextModelListener listener) {
		modelListener.addListener(listener);
	}
	
	public static void removeModelListener(final IXtextModelListener listener) {
		modelListener.removeListener(listener);
	}
}