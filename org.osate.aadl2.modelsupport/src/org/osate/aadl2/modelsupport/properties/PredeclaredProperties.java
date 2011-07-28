package org.osate.aadl2.modelsupport.properties;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.ResourceAttributes;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.preference.PreferenceStore;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.osate.aadl2.modelsupport.Activator;
import org.osate.aadl2.modelsupport.eclipseinterface.OsateResourceSet;
import org.osate.pluginsupport.PluginSupportUtil;
import org.osate.workspace.WorkspacePlugin;
import org.osate.workspace.names.standard.AadlProject;
import org.osate.workspace.names.standard.CommunicationProperties;
import org.osate.workspace.names.standard.DeploymentProperties;
import org.osate.workspace.names.standard.MemoryProperties;
import org.osate.workspace.names.standard.ModelingProperties;
import org.osate.workspace.names.standard.ProgrammingProperties;
import org.osate.workspace.names.standard.ThreadProperties;
import org.osate.workspace.names.standard.TimingProperties;

public class PredeclaredProperties {

	private static final Set<String> PREDECLARED_PROPERTY_SET_UPPER_CASE_NAMES;
	
	private static boolean isInitialized = false;

	static {
		HashSet<String> predeclaredPropertySetUpperCaseNames = new HashSet<String>();
		predeclaredPropertySetUpperCaseNames.add(DeploymentProperties._NAME
				.toUpperCase());
		predeclaredPropertySetUpperCaseNames.add(ThreadProperties._NAME
				.toUpperCase());
		predeclaredPropertySetUpperCaseNames.add(TimingProperties._NAME
				.toUpperCase());
		predeclaredPropertySetUpperCaseNames.add(CommunicationProperties._NAME
				.toUpperCase());
		predeclaredPropertySetUpperCaseNames.add(MemoryProperties._NAME
				.toUpperCase());
		predeclaredPropertySetUpperCaseNames.add(ProgrammingProperties._NAME
				.toUpperCase());
		predeclaredPropertySetUpperCaseNames.add(ModelingProperties._NAME
				.toUpperCase());
		predeclaredPropertySetUpperCaseNames.add(AadlProject._NAME
				.toUpperCase());
		PREDECLARED_PROPERTY_SET_UPPER_CASE_NAMES = Collections
				.unmodifiableSet(predeclaredPropertySetUpperCaseNames);
	}


	public static final String PLUGIN_RESOURCES_DIRECTORY_NAME = "Plugin_Resources";

	public static void initPluginContributedAadl() {
		try {
			if (!existsPluginResourcesProject()){
			new WorkspaceModifyOperation() {
				protected void execute(IProgressMonitor monitor)
						throws CoreException, InvocationTargetException {
					try {
						IProject pluginResourcesProject = createPluginResourcesProject();
						if (pluginResourcesProject.isOpen()) {
							for (URI contributedResourceUri : PluginSupportUtil
									.getContributedAadl()) {
								String resourceName = contributedResourceUri
										.trimFileExtension()
										.appendFileExtension(
												WorkspacePlugin.SOURCE_FILE_EXT)
										.lastSegment();
								IFile contributedResourceInWorkspace = pluginResourcesProject.getFile(resourceName);
								if (!contributedResourceInWorkspace.exists()
										|| contributedResourceInWorkspace
												.getResourceAttributes()
												.isReadOnly())
									copyContributedResourceIntoWorkspace(
											contributedResourceUri,
											contributedResourceInWorkspace);
							}
						} else {
							Activator
									.logErrorMessage("Cannot access plugin property sets and packages.  The project '"
											+ PLUGIN_RESOURCES_DIRECTORY_NAME
											+ "' is closed.");
						}
						isInitialized = true;
					} catch (IOException e) {
						throw new InvocationTargetException(e);
					}
				}
			}.run(null);
			} else {
				if (!isOpenPluginResourcesProject()) {

				Activator
				.logErrorMessage("Cannot access plugin property sets predeclared properties. The project '"
						+ PLUGIN_RESOURCES_DIRECTORY_NAME
						+ "' is closed.");
				}
			}
		} catch (InvocationTargetException e) {
			Activator.logThrowable(e.getCause());
			Activator
					.logErrorMessage("Cannot load plugin property sets and packages.");
		} catch (InterruptedException e) {
			Activator.logThrowable(e);
			Activator
					.logErrorMessage("Cannot load plugin property sets and packages.");
		}
	}
	
	private static boolean existsPluginResourcesProject()  {
		IProject pluginResourcesProject = ResourcesPlugin.getWorkspace()
				.getRoot().getProject(PLUGIN_RESOURCES_DIRECTORY_NAME);
		return pluginResourcesProject.exists();
	}
	
	private static boolean isOpenPluginResourcesProject()  {
		IProject pluginResourcesProject = ResourcesPlugin.getWorkspace()
				.getRoot().getProject(PLUGIN_RESOURCES_DIRECTORY_NAME);
		return pluginResourcesProject.exists() && pluginResourcesProject.isOpen();
	}


	private static IProject createPluginResourcesProject() throws CoreException,
			IOException {
		IProject pluginResourcesProject = ResourcesPlugin.getWorkspace()
				.getRoot().getProject(PLUGIN_RESOURCES_DIRECTORY_NAME);
		if (!pluginResourcesProject.exists()) {
			try {
				pluginResourcesProject.create(null);
				pluginResourcesProject.open(null);
				IFolder modelDirectory = pluginResourcesProject
						.getFolder(WorkspacePlugin.DEFAULT_MODEL_DIR);
				IFolder sourceDirectory = pluginResourcesProject
						.getFolder(WorkspacePlugin.DEFAULT_SOURCE_DIR);
				modelDirectory.create(true, true, null);
				sourceDirectory.create(true, true, null);
				PreferenceStore preferenceStore = new PreferenceStore(
						pluginResourcesProject.getFile(
								WorkspacePlugin.AADLPATH_FILENAME)
								.getRawLocation().toString());
				preferenceStore.setValue(WorkspacePlugin.PROJECT_SOURCE_DIR,
						WorkspacePlugin.DEFAULT_SOURCE_DIR);
				preferenceStore.setValue(WorkspacePlugin.PROJECT_MODEL_DIR,
						WorkspacePlugin.DEFAULT_MODEL_DIR);
				preferenceStore.save();
				pluginResourcesProject.refreshLocal(1, null);

				/*
				 * We really should just have the following line:
				 * AadlNature.addNature(pluginResourcesProject, null);
				 * 
				 * This cannot be done because it would introduce a cycle in the
				 * plugin dependencies. Perhaps this can be cleaned up at a
				 * later date, but this solution is good enough for now.
				 */
//				IProjectDescription pluginResourcesProjectDescription = pluginResourcesProject
//						.getDescription();
//				pluginResourcesProjectDescription
//						.setNatureIds(new String[] { "edu.cmu.sei.osate.core.aadlnature" });
//				pluginResourcesProject.setDescription(
//						pluginResourcesProjectDescription, null);
			} catch (CoreException e) {
				if (pluginResourcesProject.exists()) {
					try {
						pluginResourcesProject.delete(true, true, null);
					} catch (CoreException ex) {
						// Ignore this exception.
					}
				}
				throw e;
			} catch (IOException e) {
				if (pluginResourcesProject.exists()) {
					try {
						pluginResourcesProject.delete(true, true, null);
					} catch (CoreException ex) {
						// Ignore this exception.
					}
				}
				throw e;
			}
		}
		return pluginResourcesProject;
	}

	private static void copyContributedResourceIntoWorkspace(
			URI contributedResourceUri, IFile contributedResourceInWorkspace)
			throws IOException, CoreException {
		URIConverter uricvt = getResourceSet().getURIConverter();
		InputStream contributedResourceContentsAsStream = uricvt
				.createInputStream(contributedResourceUri.trimFileExtension()
						.appendFileExtension(WorkspacePlugin.OLD_SOURCE_FILE_EXT));
		if (contributedResourceInWorkspace.exists()) {
			// Temporarily make it read-write.
			ResourceAttributes attributes = contributedResourceInWorkspace
					.getResourceAttributes();
			attributes.setReadOnly(false);
			contributedResourceInWorkspace.setResourceAttributes(attributes);
			contributedResourceInWorkspace.setContents(
					contributedResourceContentsAsStream, false, true, null);
		} else
			contributedResourceInWorkspace.create(
					contributedResourceContentsAsStream, false, null);
		ResourceAttributes attributes = contributedResourceInWorkspace
				.getResourceAttributes();
		attributes.setReadOnly(true);
		contributedResourceInWorkspace.setResourceAttributes(attributes);
	}
	
	private static ResourceSet resourceSet;
	
	public static ResourceSet getResourceSet() {
		if (resourceSet == null) {
			resourceSet = new ResourceSetImpl();
		}
		return resourceSet;
	}

}
