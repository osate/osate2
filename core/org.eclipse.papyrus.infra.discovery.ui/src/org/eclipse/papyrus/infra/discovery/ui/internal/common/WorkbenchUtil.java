/*******************************************************************************
 * Copyright (c) 2004, 2009 Tasktop Technologies and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tasktop Technologies - initial API and implementation
 *     IBM Corporation - helper methods from
 *       org.eclipse.wst.common.frameworks.internal.ui.WTPActivityHelper
 *     Obeo - adaptation for Amalgamation, EMF based and no Mylyn dependency
 *     CEA LIST - adaptation to Papyrus
 *******************************************************************************/

package org.eclipse.papyrus.infra.discovery.ui.internal.common;

import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.swt.SWT;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.browser.IWorkbenchBrowserSupport;

/**
 * @author Mik Kersten
 * @author Steffen Pingel
 */
public class WorkbenchUtil {

	/**
	 * Opens <code>location</code> in a web-browser according to the Eclipse
	 * workbench preferences.
	 *
	 * @param location
	 *            the url to open
	 * @see #openUrl(String, int)
	 */
	public static void openUrl(String location) {
		openUrl(location, SWT.NONE);
	}

	/**
	 * Opens <code>location</code> in a web-browser according to the Eclipse
	 * workbench preferences.
	 *
	 * @param location
	 *            the url to open
	 * @param customFlags
	 *            additional flags that are passed to {@link IWorkbenchBrowserSupport}, pass {@link IWorkbenchBrowserSupport#AS_EXTERNAL} to force opening
	 *            external browser
	 */
	public static void openUrl(String location, int customFlags) {
		try {
			URL url = null;
			if (location != null) {
				url = new URL(location);
			}
			IWorkbenchBrowserSupport support = PlatformUI.getWorkbench().getBrowserSupport();
			support.getExternalBrowser().openURL(url);

		} catch (PartInitException e) {
		} catch (MalformedURLException e) {

		}
	}

}
