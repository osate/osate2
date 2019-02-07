/*******************************************************************************
 * Copyright (c) 2012 CEA LIST and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     CEA LIST - initial API and implementation
 *******************************************************************************/

package org.eclipse.papyrus.infra.discovery.ui.wizards;

import org.eclipse.osgi.util.NLS;

/**
 * Internationalization messages
 */
public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.infra.discovery.ui.wizards.messages"; //$NON-NLS-1$

	public static String DiscoveryComponent_CannotConnectToSource_title;

	public static String DiscoveryComponent_CannotConnectToSource_label;

	public static String DiscoveryComponent_title;

	public static String DiscoveryComponent_description;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
