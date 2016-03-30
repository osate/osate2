package org.osate.workspace;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.PreferenceStore;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The main plugin class to be used in the desktop.
 */
public class WorkspacePlugin extends AbstractUIPlugin {
	/**
	 * ID of the AADL core plugin (value
	 * <code>"org.osate.workspace"</code>)
	 */
	public static final String PLUGIN_ID = "org.osate.workspace";

	/**
	 * Name of file containing project's aadlpath
	 */
	public static final String AADLPATH_FILENAME = ".aadlsettings";

	/**
	 * File extension of AADL source text files
	 */
	public static final String SOURCE_FILE_EXT = "aadl";
	public static final String SOURCE_FILE_EXT2 = "aadl2";

	/**
	 * File extension of AADL model files
	 */
	public static final String MODEL_FILE_EXT = "aaxl2";

//	 Instance model extensions and naming
	// new naming convention is "aail2" and no need for name ending with "_instance"
	// Code for handling new convention is in place
	// Have not enabled until people depending on it are made aware of the change

	/**
	 * File extension of AADL instance model files
	 */
	public static final String INSTANCE_FILE_EXT = "aaxl2";

	/**
	 * Default Aadl instances directory.
	 */
	public static final String AADL_INSTANCES_DIR = "instances";

	/**
	 * Default Aadl instances directory.
	 */
	public static final String AADL_REPORTS_DIR = "reports";

	/**
	 * instance model name postfix
	 */
	public static final String INSTANCE_MODEL_POSTFIX = "_Instance";

	/**
	 * Package separator in AADL source files.
	 */
	public static final String AADL_PACKAGE_SEPARATOR = "::";

	/**
	 * Package separator in package file names.
	 */
	public static final String FILE_PACKAGE_SEPARATOR = "-";

	/**
	 * Name of preference for standard AADL property set file
	 */
	public static final String AADL_PROPERTIES_FILE = "aadlPropertiesFilePreference";

	/**
	 * Name of preference for standard AADL property set file
	 */
	public static final String AADL_PROJECT_FILE = "aadlProjectFilePreference";

	/**
	 * Name of source directory project property.
	 */
	public static final String PROJECT_SOURCE_DIR = "source.directory";

	/**
	 * Default source directory. In canonical
	 * {@link org.eclipse.core.runtime.IPath} format with "<code>/</code>" as
	 * the separator character.
	 */
	public static final String DEFAULT_SOURCE_DIR = "/aadl";

	/**
	 * Name of model directory project property.
	 */
	public static final String PROJECT_MODEL_DIR = "model.directory";

	/**
	 * Default model directory. In canonical
	 * {@link org.eclipse.core.runtime.IPath} format with "<code>/</code>" as
	 * the separator character.
	 */
	public static final String DEFAULT_MODEL_DIR = "/aaxl";

	/**
	 * Aadl pakcages directory.
	 */
	public static final String AADL_PACKAGES_DIR = "packages";

	/**
	 * Default model directory.
	 */
	public static final String PROPERTY_SETS_DIR = "propertysets";

	/**
	 * Name of preference for standard AADL property set file
	 */
	public static final String EXPAND_DEFAULT_FLAG = "expandXMLDefaults";

	public static final String AUTO_REINSTANTIATE = "autoReinstantiate";
	public static final String AUTO_INDENT = "AUTO_INDENT";
	public static final String AUTO_COMPLETE = "AUTO_COMPLETE";
	public static final String CAPITALIZE = "CAPITALIZE";
	public static final String INDENT_SECTIONS = "INDENT_SECTIONS";

	// The shared instance.
	private static WorkspacePlugin plugin;

	// Resource bundle.
	private ResourceBundle resourceBundle;

	/**
	 * The constructor.
	 */
	public WorkspacePlugin() {
		super();
		plugin = this;
		try {
			resourceBundle = ResourceBundle.getBundle("org.osate.workspace.WorkspacePluginResources");
		} catch (MissingResourceException x) {
			resourceBundle = null;
		}
	}

	/**
	 * This method is called upon plug-in activation
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
	}

	/**
	 * This method is called when the plug-in is stopped
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		super.stop(context);
	}

	/**
	 * Returns the shared instance.
	 */
	public static WorkspacePlugin getDefault() {
		return plugin;
	}

	/**
	 * Returns the string from the plugin's resource bundle, or 'key' if not
	 * found.
	 */
	public static String getResourceString(String key) {
		ResourceBundle bundle = WorkspacePlugin.getDefault().getResourceBundle();
		try {
			return (bundle != null) ? bundle.getString(key) : key;
		} catch (MissingResourceException e) {
			return key;
		}
	}

	/**
	 * Returns the plugin's resource bundle,
	 */
	public ResourceBundle getResourceBundle() {
		return resourceBundle;
	}

	public static URL getInstallURL() {
		return plugin.getBundle().getEntry("/");
	}

	public static void log(IStatus status) {
		getDefault().getLog().log(status);
	}

	public static void log(Throwable t) {
		log(new Status(IStatus.ERROR, getPluginId(), IStatus.OK, "WorkspacePlugin internal error", t));
	}

	public static void logErrorMessage(String message) {
		log(new Status(IStatus.ERROR, getPluginId(), IStatus.OK, message, null));
	}

	public static String getPluginId() {
		return plugin.getBundle().getSymbolicName();
	}

	public static PreferenceStore getPreferenceStore(IProject project) {
		PreferenceStore projectProperties;
		String settingspath = project.getFile(AADLPATH_FILENAME).getRawLocation().toString();
		final String projectname = project.getName();
		/*
		 * Paths are stored using the canonical IPath format in the properties
		 * file. That is, we use "/" as the separator character.
		 */
		projectProperties = new PreferenceStore(settingspath);
		projectProperties.setDefault(PROJECT_SOURCE_DIR, DEFAULT_SOURCE_DIR);
		projectProperties.setDefault(PROJECT_MODEL_DIR, DEFAULT_MODEL_DIR);
		try {
			projectProperties.load();
		} catch (IOException e) {
			if (existsFolder(project, "aadl")) {
				projectProperties.setValue(PROJECT_SOURCE_DIR, "/aadl");
			} else if (existsFolder(project, "Aadl")) {
				projectProperties.setValue(PROJECT_SOURCE_DIR, "/Aadl");
			} else if (existsFolder(project, "src")) {
				projectProperties.setValue(PROJECT_SOURCE_DIR, "/src");
			} else if (existsFolder(project, "Src")) {
				projectProperties.setValue(PROJECT_SOURCE_DIR, "/Src");
			} else {
				projectProperties.setValue(PROJECT_SOURCE_DIR, "/");
			}
			if (existsFolder(project, "aaxl")) {
				projectProperties.setValue(PROJECT_MODEL_DIR, "/aaxl");
			} else if (existsFolder(project, "Aaxl")) {
				projectProperties.setValue(PROJECT_MODEL_DIR, "/Aaxl");
			} else if (existsFolder(project, "xml")) {
				projectProperties.setValue(PROJECT_MODEL_DIR, "/xml");
			} else if (existsFolder(project, "Xml")) {
				projectProperties.setValue(PROJECT_MODEL_DIR, "/Xml");
			} else if (existsFolder(project, "output")) {
				projectProperties.setValue(PROJECT_MODEL_DIR, "/output");
			} else {
				projectProperties.setValue(PROJECT_MODEL_DIR, "/");
			}
			try {
				projectProperties.save();
				project.refreshLocal(IResource.DEPTH_INFINITE, null);
			} catch (Exception e1) {
			}
			Display.getDefault().asyncExec(new Runnable() {
				@Override
				public void run() {
					MessageDialog.openInformation(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
							"Aadl and aaxl folders",
							"Could not find " + AADLPATH_FILENAME + " with AADL Build Path properties\n" + "Created "
									+ AADLPATH_FILENAME
									+ " with project (or best guess sub folder) as Aadl and Aaxl folders.\n"
									+ "To change the settings select Properties for project '" + projectname
									+ "' and change AADL Build Path properties.");
				}
			});
		}
		return projectProperties;
	}

	private static boolean existsFolder(IProject project, String foldername) {
		IResource folder = project.findMember(foldername);
		return folder != null && folder.exists();
	}

//	Creates directory if it doesn't exist.
	public static void ensureDirectoryExistance(File toCheck) {
		if (!toCheck.exists()) {
			ensureDirectoryExistance(toCheck.getParentFile());
			toCheck.mkdir();
		}
	}
}