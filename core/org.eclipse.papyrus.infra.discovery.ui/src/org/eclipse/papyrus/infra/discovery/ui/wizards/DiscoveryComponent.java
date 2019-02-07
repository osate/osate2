/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.discovery.ui.wizards;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.papyrus.infra.discovery.DiscoveryDefinition;
import org.eclipse.papyrus.infra.discovery.ui.viewer.DiscoveryContentProvider;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;


/**
 * Execution class for the execution of the discovery component
 */
public class DiscoveryComponent {

	/** 
	* URI of the model where all extra component features to be installed are referenced. Can be set via the system property 'papyrus.discovery.uri'.
	*/
	public static final String DISCOVERY_PAPYRUS_URI = System.getProperty("papyrus.discovery.uri", "http://www.eclipse.org/modeling/mdt/papyrus/downloads/discovery/oxygen/papyrus-extra.xmi"); //$NON-NLS-1$ //$NON-NLS-2$
	
	public static final Object execute() {
		final IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();

		DiscoveryContentProvider provider = new DiscoveryContentProvider() {

			/**
			 * {@inheritDoc}
			 */
			@Override
			protected DiscoveryDefinition load() {
				Resource res = new XMIResourceImpl(URI.createURI(DISCOVERY_PAPYRUS_URI));
				try {
					res.load(Collections.emptyMap());
				} catch (IOException e) {
					MessageDialog.openError(window.getShell(), Messages.DiscoveryComponent_CannotConnectToSource_title, Messages.DiscoveryComponent_CannotConnectToSource_label);
					throw new RuntimeException(e);
				}
				return (DiscoveryDefinition) res.getContents().get(0);
			}

			/**
			 * {@inheritDoc}
			 */
			@Override
			public String getDescription() {
				return Messages.DiscoveryComponent_description;
			}

			/**
			 * {@inheritDoc}
			 */
			@Override
			public String getTitle() {
				return Messages.DiscoveryComponent_title;
			}

		};


		DiscoveryWizard wizard = new DiscoveryWizard(provider);
		WizardDialog dialog = new WizardDialog(window.getShell(), wizard);
		return dialog.open();
	}

}
