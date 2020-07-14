package org.osate.ui.wizards;

import java.io.File;
import java.net.URL;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.swt.browser.Browser;
import org.eclipse.ui.dialogs.IOverwriteQuery;
import org.eclipse.ui.statushandlers.StatusManager;
import org.eclipse.ui.wizards.datatransfer.FileSystemStructureProvider;
import org.eclipse.ui.wizards.datatransfer.ImportOperation;
import org.eclipse.ui.wizards.newresource.BasicNewResourceWizard;
import org.osate.ui.OsateUiPlugin;
import org.osgi.framework.Bundle;

/**
 * @since 4.0
 */
public class OsateExampleWizard extends BasicNewResourceWizard {
	public OsateExampleWizard() {
		super();
		IDialogSettings workbenchSettings = OsateUiPlugin.getDefault().getDialogSettings();
		IDialogSettings section = workbenchSettings.getSection("BasicNewProjectResourceWizard");//$NON-NLS-1$
		if (section == null) {
			section = workbenchSettings.addNewSection("BasicNewProjectResourceWizard");//$NON-NLS-1$
		}
		setDialogSettings(section);
	}

	protected PluginInfo selectedProject;
	protected Browser browser;
	public OsateExampleWizardPage mainPage;

	// cache of newly-created project
	protected IProject newProject;

	@Override
	public void addPages() {
		super.addPages();
		mainPage = new OsateExampleWizardPage("wizardOsateExamplePage"); //$NON-NLS-1$
		mainPage.setTitle("Aadl Project"); //$NON-NLS-1$
		mainPage.setDescription("Create a new Aadl project resource."); //$NON-NLS-1$
		addPage(mainPage);
		// PlatformUI.getWorkbench().getHelpSystem().setHelp(getShell(), "org.osate.ui.help_dialog");
//		PlatformUI.getWorkbench().getHelpSystem().displayHelp("org.osate.ui.help_dialog");
	}

	@Override
	public boolean performFinish() {
//		final HelpDialog d = new HelpDialog(getShell());
//		Display.getDefault().syncExec(() -> d.open());

		if (mainPage != null) {
			PluginInfo selected = mainPage.getSelectedProject();
			if (selected != null) {
				if (selected.exampleS != null && selected.projectPath != null) {
					try {
						Bundle bundle = Platform.getBundle(OsateUiPlugin.PLUGIN_ID);
						URL file_r_URL = org.eclipse.core.runtime.FileLocator
								.toFileURL(bundle.getEntry(selected.exampleS));
						if (file_r_URL != null) {
							selected.projectPath.forEach(s -> {
								try {
									importFiles(new File(file_r_URL.getPath(), s));
								} catch (Exception e) {
									IStatus status = new Status(IStatus.ERROR, OsateUiPlugin.PLUGIN_ID, e.getMessage(),
											e);
									StatusManager manager = StatusManager.getManager();
									manager.handle(status, StatusManager.LOG);
								}
							});
						}
					} catch (Exception e) {
						IStatus status = new Status(IStatus.ERROR, OsateUiPlugin.PLUGIN_ID, e.getMessage(), e);
						StatusManager manager = StatusManager.getManager();
						manager.handle(status, StatusManager.LOG | StatusManager.SHOW);
					}
				}
			}
		}

		return true;
	}

	protected void importFiles(File projectPath) throws Exception {
		ImportOperation importOperation = new ImportOperation(new Path(Path.ROOT + projectPath.getName()),
				projectPath,
				FileSystemStructureProvider.INSTANCE, OVERWRITE_ALL_QUERY);
		importOperation.setCreateContainerStructure(false);
		importOperation.run(null);
	}

	protected static final IOverwriteQuery OVERWRITE_ALL_QUERY = pathString -> IOverwriteQuery.ALL;
}