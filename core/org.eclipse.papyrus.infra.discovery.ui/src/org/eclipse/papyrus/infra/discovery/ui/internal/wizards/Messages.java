/*******************************************************************************
 * Copyright (c) 2009 Tasktop Technologies and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tasktop Technologies - initial API and implementation
 *     Obeo - adaptation for Amalgamation, EMF based and no Mylyn dependency
 *     CEA LIST - adaptation to Papyrus
 *******************************************************************************/

package org.eclipse.papyrus.infra.discovery.ui.internal.wizards;

import org.eclipse.osgi.util.NLS;

/**
 * @author David Green
 */
public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.papyrus.infra.discovery.ui.internal.wizards.messages"; //$NON-NLS-1$

	public static String ConnectorDiscoveryWizardMainPage_filter_tool;

	public static String ConnectorDiscoveryWizardMainPage_filter_standard;

	public static String ConnectorDescriptorToolTip_detailsLink;

	public static String ConnectorDescriptorToolTip_detailsLink_tooltip;

	public static String ConnectorDiscoveryWizard_cannotInstall;

	public static String ConnectorDiscoveryWizard_connectorDiscovery;

	public static String ConnectorDiscoveryWizard_installProblems;

	public static String InstallConnectorsJob_commaSeparator;

	public static String InstallConnectorsJob_connectorsNotAvailable;

	public static String InstallConnectorsJob_profileProblem;

	public static String InstallConnectorsJob_questionProceed;

	public static String InstallConnectorsJob_questionProceed_long;

	public static String InstallConnectorsJob_task_configuring;

	public static String InstallConnectorsJob_unexpectedError_url;

	public static String ConnectorDiscoveryWizardMainPage_clearButton_accessibleListener;

	public static String ConnectorDiscoveryWizardMainPage_clearButton_toolTip;

	public static String ConnectorDiscoveryWizardMainPage_connectorDiscovery;

	public static String ConnectorDiscoveryWizardMainPage_errorTitle;

	public static String ConnectorDiscoveryWizardMainPage_filter_commercial;

	public static String ConnectorDiscoveryWizardMainPage_filter_framework;

	public static String ConnectorDiscoveryWizardMainPage_filter_incubation;

	public static String ConnectorDiscoveryWizardMainPage_filterLabel;

	public static String ConnectorDiscoveryWizardMainPage_message_with_cause;

	public static String ConnectorDiscoveryWizardMainPage_noConnectorsFound;

	public static String ConnectorDiscoveryWizardMainPage_noConnectorsFound_description;

	public static String ConnectorDiscoveryWizardMainPage_noMatchingItems_filteredType;

	public static String ConnectorDiscoveryWizardMainPage_noMatchingItems_noFilter;

	public static String ConnectorDiscoveryWizardMainPage_noMatchingItems_withFilterText;

	public static String ConnectorDiscoveryWizardMainPage_pageDescription;

	public static String ConnectorDiscoveryWizardMainPage_provider_and_license;

	public static String ConnectorDiscoveryWizardMainPage_tooltip_showOverview;

	public static String ConnectorDiscoveryWizardMainPage_unexpectedException;

	public static String ConnectorDiscoveryWizardMainPage_warningMessageConnectorUnavailable;

	public static String ConnectorDiscoveryWizardMainPage_warningTitleConnectorUnavailable;

	public static String PrepareInstallProfileJob_notFoundDescriptorDetail;

	public static String PrepareInstallProfileJob_calculatingRequirements;

	public static String PrepareInstallProfileJob_computeProfileChangeRequestFailed;

	public static String PrepareInstallProfileJob_errorResolvingHostname;

	public static String PrepareInstallProfileJob_ok;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
