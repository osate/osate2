package org.osate.ui.wizards;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

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

/**
 * @since 5.0
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
		mainPage.setTitle("Import AADL Example Project"); //$NON-NLS-1$
		mainPage.setDescription("Import an Example Project into your workspace."); //$NON-NLS-1$
		addPage(mainPage);
	}

	@Override
	public boolean performFinish() {
		if (mainPage != null) {
			PluginInfo selected = mainPage.getSelectedProject();
			if (selected != null) {
				if (selected.exampleS != null && selected.projectPath != null) {
					try {
						selected.projectPath.forEach(s -> {
							try {
								importFiles(new File(org.eclipse.core.runtime.FileLocator
										.toFileURL(Platform.getBundle(selected.bundle).getEntry(selected.exampleS))
										.getPath(), s));
							} catch (InvocationTargetException | InterruptedException | IOException e) {
								catchError(e, e.getMessage(), false);
							}
						});
					} catch (Exception e) {
						catchError(e, "Unexpected error occurred. Please try again", false);
					}
				}
			}
		}

		return true;
	}

	protected void importFiles(File projectPath) throws InvocationTargetException, InterruptedException {
		ImportOperation importOperation = new ImportOperation(new Path(Path.ROOT + projectPath.getName()),
				projectPath,
				FileSystemStructureProvider.INSTANCE, OVERWRITE_ALL_QUERY);
		importOperation.setCreateContainerStructure(false);
		importOperation.run(null);
	}

	protected void catchError(Exception e, String message, Boolean logOnly) {
		IStatus status = new Status(IStatus.ERROR, OsateUiPlugin.PLUGIN_ID, message, e);
		StatusManager manager = StatusManager.getManager();
		manager.handle(status, logOnly ? StatusManager.LOG : StatusManager.SHOW | StatusManager.LOG);
	}

	protected static final IOverwriteQuery OVERWRITE_ALL_QUERY = pathString -> IOverwriteQuery.ALL;
}