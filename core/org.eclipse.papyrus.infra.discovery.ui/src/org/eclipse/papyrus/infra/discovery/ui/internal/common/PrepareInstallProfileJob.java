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
package org.eclipse.papyrus.infra.discovery.ui.internal.common;

import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.equinox.internal.p2.ui.IProvHelpContextIds;
import org.eclipse.equinox.internal.p2.ui.dialogs.PreselectedIUInstallWizard;
import org.eclipse.equinox.internal.p2.ui.dialogs.ProvisioningWizardDialog;
import org.eclipse.equinox.p2.core.ProvisionException;
import org.eclipse.equinox.p2.metadata.IInstallableUnit;
import org.eclipse.equinox.p2.metadata.Version;
import org.eclipse.equinox.p2.operations.InstallOperation;
import org.eclipse.equinox.p2.operations.ProvisioningSession;
import org.eclipse.equinox.p2.operations.RepositoryTracker;
import org.eclipse.equinox.p2.query.IQuery;
import org.eclipse.equinox.p2.query.IQueryResult;
import org.eclipse.equinox.p2.query.QueryUtil;
import org.eclipse.equinox.p2.repository.metadata.IMetadataRepository;
import org.eclipse.equinox.p2.repository.metadata.IMetadataRepositoryManager;
import org.eclipse.equinox.p2.ui.ProvisioningUI;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.infra.discovery.InstallableComponent;
import org.eclipse.papyrus.infra.discovery.ui.Activator;
import org.eclipse.papyrus.infra.discovery.ui.internal.wizards.Messages;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

/**
 * A job that configures a p2 {@link #getInstallAction() install action} for
 * installing one or more {@link ConnectorDescriptor connectors}. The bulk of
 * the installation work is done by p2; this class just sets up the p2
 * repository metadata and selects the appropriate features to install. After
 * running the job the {@link #getInstallAction() install action} must be run to
 * perform the installation.
 *
 * @author David Green
 * @author Steffen Pingel
 */
public class PrepareInstallProfileJob implements IRunnableWithProgress {

	private static final String P2_FEATURE_GROUP_SUFFIX = ".feature.group"; //$NON-NLS-1$

	private final List<InstallableComponent> installableConnectors;

	private final ProvisioningUI provisioningUI;

	private Set<URI> repositoryLocations;

	private boolean headless = false;

	public PrepareInstallProfileJob(
			Collection<InstallableComponent> installableConnectors) {
		if (installableConnectors == null || installableConnectors.isEmpty()) {
			throw new IllegalArgumentException();
		}
		this.installableConnectors = new ArrayList<InstallableComponent>(
				installableConnectors);
		this.provisioningUI = ProvisioningUI.getDefaultUI();
	}

	public void setHeadlessMode(boolean isHeadless) {
		this.headless = isHeadless;
	}

	public void run(IProgressMonitor progressMonitor)
			throws InvocationTargetException, InterruptedException {
		try {
			SubMonitor monitor = SubMonitor.convert(progressMonitor,
					Messages.InstallConnectorsJob_task_configuring, 100);
			try {
				final Collection<IInstallableUnit> ius = computeInstallableUnits(monitor
						.newChild(50));

				checkCancelled(monitor);

				final InstallOperation installOperation = resolve(
						monitor.newChild(50), ius,
						repositoryLocations.toArray(new URI[0]));

				checkCancelled(monitor);

				if (!headless) {
					Display.getDefault().asyncExec(new Runnable() {
						public void run() {
							openInstallWizard(provisioningUI, ius,
									installOperation);
						}
					});
				}
			} finally {
				monitor.done();
			}
		} catch (OperationCanceledException e) {
			throw new InterruptedException();
		} catch (Exception e) {
			throw new InvocationTargetException(e);
		}
	}

	private static int openInstallWizard(ProvisioningUI ui, Collection<IInstallableUnit> initialSelections, InstallOperation operation) {
		PreselectedIUInstallWizard wizard = new PreselectedIUInstallWizard(ui, operation, initialSelections, null);
		wizard.setRemediationOperation(null);
		Shell defaultParentShell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();

		WizardDialog dialog = new ProvisioningWizardDialog(defaultParentShell, wizard);
		dialog.create();
		PlatformUI.getWorkbench().getHelpSystem().setHelp(dialog.getShell(), IProvHelpContextIds.INSTALL_WIZARD);
		return dialog.open();
	}

	private void checkCancelled(IProgressMonitor monitor) {
		if (monitor.isCanceled()) {
			throw new OperationCanceledException();
		}
	}

	private InstallOperation resolve(IProgressMonitor monitor,
			final Collection<IInstallableUnit> ius, URI[] repositories)
			throws CoreException {
		final InstallOperation installOperation = provisioningUI
				.getInstallOperation(ius, repositories);
		SubMonitor subMonitor = SubMonitor.convert(monitor, installableConnectors.size());
		IStatus operationStatus = installOperation
				.resolveModal(subMonitor);
		if (operationStatus.getSeverity() > IStatus.WARNING) {
			throw new RuntimeException(operationStatus.getMessage());
		}
		return installOperation;
	}

	public Collection<IInstallableUnit> computeInstallableUnits(
			SubMonitor monitor) throws CoreException {
		try {
			monitor.setWorkRemaining(100);
			// add repository urls and load meta data
			List<IMetadataRepository> repositories = addRepositories(monitor
					.newChild(50));
			final List<IInstallableUnit> installableUnits = queryInstallableUnits(
					monitor.newChild(50), repositories);
			removeOldVersions(installableUnits);
			checkForUnavailable(installableUnits);
			return installableUnits;

		} catch (URISyntaxException e) {
			// should never happen, since we already validated URLs.
			throw new CoreException(new Status(IStatus.ERROR,
					Activator.PLUGIN_ID,
					Messages.InstallConnectorsJob_unexpectedError_url, e));
		} catch (MalformedURLException e) {
			// should never happen, since we already validated URLs.
			throw new CoreException(new Status(IStatus.ERROR,
					Activator.PLUGIN_ID,
					Messages.InstallConnectorsJob_unexpectedError_url, e));
		} finally {
			monitor.done();
		}
	}

	/**
	 * Verifies that we found what we were looking for: it's possible that we
	 * have connector descriptors that are no longer available on their
	 * respective sites. In that case we must inform the user. Unfortunately
	 * this is the earliest point at which we can know.
	 */
	private void checkForUnavailable(
			final List<IInstallableUnit> installableUnits) throws CoreException {
		// at least one selected connector could not be found in a repository
		Set<String> foundIds = new HashSet<String>();
		for (IInstallableUnit unit : installableUnits) {
			String id = unit.getId();
			if (id.endsWith(P2_FEATURE_GROUP_SUFFIX)) {
				id = id.substring(0, id.indexOf(P2_FEATURE_GROUP_SUFFIX));
			}
			foundIds.add(id);
		}

		String message = ""; //$NON-NLS-1$
		String detailedMessage = ""; //$NON-NLS-1$
		for (InstallableComponent descriptor : installableConnectors) {
			StringBuilder unavailableIds = null;
			for (String id : descriptor.getId()) {
				if (!foundIds.contains(id)) {
					if (unavailableIds == null) {
						unavailableIds = new StringBuilder();
					} else {
						unavailableIds
								.append(Messages.InstallConnectorsJob_commaSeparator);
					}
					unavailableIds.append(id);
				}
			}
			if (unavailableIds != null) {
				if (message.length() > 0) {
					message += Messages.InstallConnectorsJob_commaSeparator;
				}
				message += descriptor.getName();

				if (detailedMessage.length() > 0) {
					detailedMessage += Messages.InstallConnectorsJob_commaSeparator;
				}
				detailedMessage += NLS
						.bind(Messages.PrepareInstallProfileJob_notFoundDescriptorDetail,
								new Object[] { descriptor.getName(),
										unavailableIds.toString(),
										descriptor.getSitesURLS() });
			}
		}

		if (message.length() > 0) {
			// instead of aborting here we ask the user if they wish to proceed
			// anyways
			final boolean[] okayToProceed = new boolean[1];
			final String finalMessage = message;

			if (headless) {
				throw new RuntimeException(detailedMessage);
			} else {
				Display.getDefault().syncExec(new Runnable() {
					public void run() {
						okayToProceed[0] = MessageDialog.openQuestion(
								DiscoveryUiUtil.getShell(),
								Messages.InstallConnectorsJob_questionProceed,
								NLS.bind(
										Messages.InstallConnectorsJob_questionProceed_long,
										new Object[] { finalMessage }));
					}
				});
				if (!okayToProceed[0]) {
					throw new CoreException(
							new Status(
									IStatus.ERROR,
									Activator.PLUGIN_ID,
									NLS.bind(
											Messages.InstallConnectorsJob_connectorsNotAvailable,
											detailedMessage),
									null));
				}
			}
		}
	}

	/**
	 * Filters those installable units that have a duplicate in the list with a
	 * higher version number. it's possible that some repositories will host
	 * multiple versions of a particular feature. we assume that the user wants
	 * the highest version.
	 */
	private void removeOldVersions(final List<IInstallableUnit> installableUnits) {
		Map<String, Version> symbolicNameToVersion = new HashMap<String, Version>();
		for (IInstallableUnit unit : installableUnits) {
			Version version = symbolicNameToVersion.get(unit.getId());
			if (version == null || version.compareTo(unit.getVersion()) == -1) {
				symbolicNameToVersion.put(unit.getId(), unit.getVersion());
			}
		}
		if (symbolicNameToVersion.size() != installableUnits.size()) {
			for (IInstallableUnit unit : new ArrayList<IInstallableUnit>(
					installableUnits)) {
				Version version = symbolicNameToVersion.get(unit.getId());
				if (!version.equals(unit.getVersion())) {
					installableUnits.remove(unit);
				}
			}
		}
	}

	/**
	 * Perform a query to get the installable units. This causes p2 to determine
	 * what features are available in each repository. We select installable
	 * units by matching both the feature id and the repository; it is possible
	 * though unlikely that the same feature id is available from more than one
	 * of the selected repositories, and we must ensure that the user gets the
	 * one that they asked for.
	 */
	private List<IInstallableUnit> queryInstallableUnits(SubMonitor monitor,
			List<IMetadataRepository> repositories) throws URISyntaxException {
		final List<IInstallableUnit> installableUnits = new ArrayList<IInstallableUnit>();

		monitor.setWorkRemaining(repositories.size());
		for (final IMetadataRepository repository : repositories) {
			checkCancelled(monitor);
			final Set<String> installableUnitIdsThisRepository = getDescriptorIds(repository);
			IQuery<IInstallableUnit> query = QueryUtil.createMatchQuery( //
					"id ~= /*.feature.group/ && " + //$NON-NLS-1$
							"properties['org.eclipse.equinox.p2.type.group'] == true ");//$NON-NLS-1$
			IQueryResult<IInstallableUnit> result = repository.query(query,
					monitor.newChild(1));
			for (Iterator<IInstallableUnit> iter = result.iterator(); iter
					.hasNext();) {
				IInstallableUnit iu = iter.next();
				String id = iu.getId();
				if (installableUnitIdsThisRepository.contains(id.substring(0,
						id.indexOf(P2_FEATURE_GROUP_SUFFIX)))) {
					installableUnits.add(iu);
				}
			}
		}
		return installableUnits;
	}

	private List<IMetadataRepository> addRepositories(SubMonitor monitor)
			throws MalformedURLException, URISyntaxException,
			ProvisionException {
		// tell p2 that it's okay to use these repositories
		ProvisioningSession session = ProvisioningUI.getDefaultUI()
				.getSession();
		RepositoryTracker repositoryTracker = ProvisioningUI.getDefaultUI()
				.getRepositoryTracker();
		repositoryLocations = new HashSet<URI>();
		monitor.setWorkRemaining(installableConnectors.size() * 5);
		for (InstallableComponent descriptor : installableConnectors) {
			for (String url : descriptor.getSitesURLS()) {
				addASiteURL(monitor, session, repositoryTracker, url);
			}
		}

		// fetch meta-data for these repositories
		ArrayList<IMetadataRepository> repositories = new ArrayList<IMetadataRepository>();
		monitor.setWorkRemaining(repositories.size());
		IMetadataRepositoryManager manager = (IMetadataRepositoryManager) session
				.getProvisioningAgent().getService(
						IMetadataRepositoryManager.SERVICE_NAME);
		for (URI uri : repositoryLocations) {
			checkCancelled(monitor);
			IMetadataRepository repository = manager.loadRepository(uri,
					monitor.newChild(1));
			repositories.add(repository);
		}
		return repositories;
	}

	private void addASiteURL(SubMonitor monitor, ProvisioningSession session,
			RepositoryTracker repositoryTracker, String url)
			throws URISyntaxException, MalformedURLException {
		URI uri = new URL(url).toURI();
		if (repositoryLocations.add(uri)) {
			checkCancelled(monitor);
			repositoryTracker.addRepository(uri, null, session);
			// ProvisioningUtil.addMetaDataRepository(url.toURI(), true);
			// ProvisioningUtil.addArtifactRepository(url.toURI(), true);
			// ProvisioningUtil.setColocatedRepositoryEnablement(url.toURI(),
			// true);
		}
		monitor.worked(1);
	}

	private Set<String> getDescriptorIds(final IMetadataRepository repository)
			throws URISyntaxException {
		final Set<String> installableUnitIdsThisRepository = new HashSet<String>();
		// determine all installable units for this repository
		for (InstallableComponent descriptor : installableConnectors) {
			try {
				if (hasThisUpdateSite(repository.getLocation(), descriptor)) {
					installableUnitIdsThisRepository.addAll(descriptor.getId());
				}

			} catch (MalformedURLException e) {
				// will never happen, ignore
			}
		}
		return installableUnitIdsThisRepository;
	}

	private boolean hasThisUpdateSite(URI location,
			InstallableComponent descriptor) throws MalformedURLException {
		boolean found = false;
		Iterator<String> it = descriptor.getSitesURLS().iterator();
		while (it.hasNext() && !found) {
			String url = it.next();
			if (location.toString().equals(url))
				found = true;
		}
		return found;
	}

}
