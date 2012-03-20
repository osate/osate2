package org.osate.aadl2.modelsupport.resources;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.ResourceAttributes;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.osate.aadl2.Element;
import org.osate.aadl2.PropertySet;
import org.osate.aadl2.modelsupport.Activator;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.pluginsupport.PluginSupportUtil;
import org.osate.workspace.WorkspacePlugin;

public class PredeclaredProperties {

	
	private static boolean isInitialized = false;



	public static final String PLUGIN_RESOURCES_DIRECTORY_NAME = "Plugin_Resources";

	public static void initPluginContributedAadl() {
		if (isInitialized) return;
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
						IProjectDescription pluginResourcesProjectDescription = pluginResourcesProject
						.getDescription();
				pluginResourcesProjectDescription
						.setNatureIds(new String[] { //"edu.cmu.sei.osate.core.aadlnature" , 
								XtextProjectHelper.NATURE_ID});
				pluginResourcesProject.setDescription(
						pluginResourcesProjectDescription, null);
						
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
			isInitialized = true;
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
//						.setNatureIds(new String[] { "edu.cmu.sei.osate.core.aadlnature" , XtextProjectHelper.NATURE_ID});
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
			}
		}
		return pluginResourcesProject;
	}

	private static void copyContributedResourceIntoWorkspace(
			URI contributedResourceUri, IFile contributedResourceInWorkspace)
			throws IOException, CoreException {
		URIConverter uricvt = OsateResourceUtil.getResourceSet().getURIConverter();
		InputStream contributedResourceContentsAsStream = uricvt
				.createInputStream(contributedResourceUri.trimFileExtension()
						.appendFileExtension(WorkspacePlugin.SOURCE_FILE_EXT));
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

	public static void revertToContributed(
			final IFile contributedResourceInWorkspace) throws IOException,
			CoreException {
		if (!contributedResourceInWorkspace.getProject().getName().equals(
				PLUGIN_RESOURCES_DIRECTORY_NAME))
			throw new IllegalArgumentException(
					"contributedResourceInWorkspace is not in the project "
							+ PLUGIN_RESOURCES_DIRECTORY_NAME);
		for (final URI contributedResourceUri : PluginSupportUtil
				.getContributedAadl()) {
			if (contributedResourceUri.trimFileExtension().appendFileExtension(
					WorkspacePlugin.SOURCE_FILE_EXT).lastSegment().equals(
					contributedResourceInWorkspace.getName())) {
				try {
					new WorkspaceModifyOperation() {
						@Override
						protected void execute(IProgressMonitor monitor)
								throws CoreException, InvocationTargetException {
							try {
								copyContributedResourceIntoWorkspace(
										contributedResourceUri,
										contributedResourceInWorkspace);
							} catch (IOException e) {
								throw new InvocationTargetException(e);
							}
						}
					}.run(null);
				} catch (InvocationTargetException e) {
					if (e.getCause() instanceof IOException)
						throw (IOException) e.getCause();
					else if (e.getCause() instanceof CoreException)
						throw (CoreException) e.getCause();
					else
						Activator.logThrowable(e);
				} catch (InterruptedException e) {
					Activator.logThrowable(e);
				}
				break;
			}
		}
	}
	
	
	
}
