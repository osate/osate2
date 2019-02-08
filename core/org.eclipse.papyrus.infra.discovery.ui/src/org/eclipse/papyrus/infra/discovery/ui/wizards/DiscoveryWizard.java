/*******************************************************************************
 * Copyright (c) 2009 Tasktop Technologies and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tasktop Technologies - initial API and implementation
 *      Obeo - adaptation for Amalgamation, EMF based and no Mylyn dependency
 *      CEA LIST - adaptation to Papyrus
 *******************************************************************************/
package org.eclipse.papyrus.infra.discovery.ui.wizards;

import org.eclipse.jface.wizard.Wizard;
import org.eclipse.papyrus.infra.discovery.ui.internal.common.CommonImages;
import org.eclipse.papyrus.infra.discovery.ui.internal.common.Installer;
import org.eclipse.papyrus.infra.discovery.ui.internal.common.PrepareInstallProfileJob;
import org.eclipse.papyrus.infra.discovery.ui.internal.wizards.DiscoveryWizardMainPage;
import org.eclipse.papyrus.infra.discovery.ui.viewer.DiscoveryContentProvider;

/**
 * A wizard for performing discovery of connectors and selecting connectors to
 * install. When finish is pressed, selected connectors are downloaded and
 * installed.
 *
 * @see PrepareInstallProfileJob
 * @see ConnectorDiscoveryWizardMainPage
 * @author David Green
 */
public class DiscoveryWizard extends Wizard {

	private DiscoveryWizardMainPage mainPage;

	private boolean showConnectorDescriptorKindFilter = true;

	private boolean showConnectorDescriptorTextFilter = true;

	private DiscoveryContentProvider provider;

	public DiscoveryWizard(DiscoveryContentProvider provider) {
		this.provider = provider;
		setWindowTitle(provider.getTitle());
		setNeedsProgressMonitor(true);
		setDefaultPageImageDescriptor(CommonImages.BANNER_DISCOVERY);
	}

	@Override
	public void addPages() {
		addPage(mainPage = new DiscoveryWizardMainPage(this.provider));
	}

	@Override
	public boolean performFinish() {
		return Installer.install(mainPage.getInstallableConnectors(), getContainer());
	}

	/**
	 * indicate if the connector descriptor filters should be shown in the UI.
	 * Changing this setting only has an effect before the UI is presented.
	 */
	public boolean isShowConnectorDescriptorKindFilter() {
		return showConnectorDescriptorKindFilter;
	}

	/**
	 * indicate if the connector descriptor filters should be shown in the UI.
	 * Changing this setting only has an effect before the UI is presented.
	 */
	public void setShowConnectorDescriptorKindFilter(boolean showConnectorDescriptorKindFilter) {
		this.showConnectorDescriptorKindFilter = showConnectorDescriptorKindFilter;
	}

	/**
	 * indicate if a text field should be provided to allow the user to filter
	 * connector descriptors
	 */
	public boolean isShowConnectorDescriptorTextFilter() {
		return showConnectorDescriptorTextFilter;
	}

	/**
	 * indicate if a text field should be provided to allow the user to filter
	 * connector descriptors
	 */
	public void setShowConnectorDescriptorTextFilter(boolean showConnectorDescriptorTextFilter) {
		this.showConnectorDescriptorTextFilter = showConnectorDescriptorTextFilter;
	}

}
