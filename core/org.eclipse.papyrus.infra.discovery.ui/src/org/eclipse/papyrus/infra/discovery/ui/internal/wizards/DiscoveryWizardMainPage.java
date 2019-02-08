/*******************************************************************************
 * Copyright (c) 2009 Tasktop Technologies and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tasktop Technologies - initial API and implementation
 *     David Green
 *     Shawn Minto bug 275513
 *     Steffen Pingel bug 276012 code review, bug 277191 gradient canvas
 *      Obeo - adaptation for Amalgamation, EMF based and no Mylyn dependency
 *      CEA LIST - adaptation to Papyrus
 *******************************************************************************/
package org.eclipse.papyrus.infra.discovery.ui.internal.wizards;

import java.util.Collection;
import java.util.List;

import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.window.IShellProvider;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.papyrus.infra.discovery.InstallableComponent;
import org.eclipse.papyrus.infra.discovery.ui.viewer.DiscoveryContentProvider;
import org.eclipse.papyrus.infra.discovery.ui.viewer.DiscoveryViewer;
import org.eclipse.papyrus.infra.discovery.ui.wizards.DiscoveryWizard;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;

/**
 * The main wizard page that allows users to select connectors that they wish to
 * install.
 *
 * @author David Green
 */
public class DiscoveryWizardMainPage extends WizardPage implements IShellProvider {

	private static final int MINIMUM_HEIGHT = 480;

	private DiscoveryViewer viewer;

	private DiscoveryContentProvider provider;

	public DiscoveryWizardMainPage(DiscoveryContentProvider provider) {
		super(DiscoveryWizardMainPage.class.getSimpleName());
		this.provider = provider;
		setTitle(provider.getTitle());
		// setImageDescriptor(image);
		setDescription(provider.getDescription());
		setPageComplete(false);

	}

	public void createControl(Composite parent) {
		viewer = new DiscoveryViewer(this, getContainer(), this.provider);
		viewer.setShowConnectorDescriptorKindFilter(getWizard().isShowConnectorDescriptorKindFilter());
		viewer.setShowConnectorDescriptorTextFilter(getWizard().isShowConnectorDescriptorTextFilter());
		viewer.setVerifyUpdateSiteAvailability(true);
		viewer.setMinimumHeight(MINIMUM_HEIGHT);
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				setPageComplete(!viewer.getInstallableConnectors().isEmpty());
			}
		});
		viewer.createControl(parent);

		setControl(viewer.getControl());
	}

	@Override
	public DiscoveryWizard getWizard() {
		return (DiscoveryWizard) super.getWizard();
	}

	public List<InstallableComponent> getInstallableConnectors() {
		return viewer.getInstallableConnectors();
	}

	private void maybeUpdateDiscovery() {
		if (!getControl().isDisposed() && isCurrentPage()) {
			viewer.updateDiscovery();
		}
	}

	@Override
	public void setVisible(boolean visible) {
		super.setVisible(visible);
		if (visible) {
			Display.getCurrent().asyncExec(new Runnable() {
				public void run() {
					maybeUpdateDiscovery();
				}
			});
		}
	}

	public void setModelingComponents(Collection<InstallableComponent> components) {

	}

}
