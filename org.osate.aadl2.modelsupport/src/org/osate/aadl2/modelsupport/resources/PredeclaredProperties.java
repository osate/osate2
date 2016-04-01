package org.osate.aadl2.modelsupport.resources;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourceAttributes;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.osgi.util.NLS;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.internal.ide.IDEWorkbenchMessages;
import org.eclipse.ui.internal.ide.IDEWorkbenchPlugin;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.osate.aadl2.modelsupport.Activator;
import org.osate.core.AadlNature;
import org.osate.pluginsupport.PluginSupportUtil;
import org.osgi.service.prefs.BackingStoreException;

@SuppressWarnings("restriction")
public class PredeclaredProperties {

	private static boolean isInitialized = false;

	public static final String PLUGIN_RESOURCES_PROJECT_NAME = "Plugin_Resources";
	public static final String AADL_PROJECT = "AADL_Project.aadl";
	public static final String AADL_PROJECT_HANDLE = "$aadl_project$";
	public static final String AADL_PROJECT_KEY = "aadl.project.properties";
	public static final String AADL_PROJECT_RELPATH = "Predeclared_Property_Sets/" + AADL_PROJECT;
	public static final String AADL_PROJECT_DEFAULT = "/" + PLUGIN_RESOURCES_PROJECT_NAME + "/" + AADL_PROJECT_RELPATH;

	private final static Logger log = Logger.getLogger(PredeclaredProperties.class);

	/**
	 * update unmodified plugin resources. If not present, create them.
	 */
	public static void updatePluginContributedAadl() {
		isInitialized = false;
		doInitPluginContributedAadl(false);
	}

	/**
	 * reset plugin resources to originals. If not present, create them.
	 */
	public static void resetPluginContributedAadl() {
		isInitialized = false;
		doInitPluginContributedAadl(true);
		try {
			setAadlProject(getPluginResourcesProject().findMember(AADL_PROJECT_RELPATH));
		} catch (ExecutionException e) {
			Activator.logThrowable(e);
			Activator.logErrorMessage("Cannot set AADL_Project preference.");
		}
	}

	/**
	 * force plugin resources to be the original ones.
	 */
	public static void initPluginContributedAadl() {
		if (isInitialized) {
			return;
		}
		doInitPluginContributedAadl(false);
	}

	public static void doInitPluginContributedAadl(final boolean forceOriginal) {

		try {
			if (existsPluginResourcesProject() && !isOpenPluginResourcesProject()) {

				Activator.logErrorMessage("Cannot access plugin property sets predeclared properties. The project '"
						+ PLUGIN_RESOURCES_PROJECT_NAME + "' is closed.");
				isInitialized = true;
				return;
			}
			new WorkspaceModifyOperation() {
				@Override
				protected void execute(IProgressMonitor monitor) throws CoreException, InvocationTargetException {
					try {
						if (forceOriginal) {
							deletePluginResourcesProject();
						}
						IProject pluginResourcesProject = createPluginResourcesProject();
						if (pluginResourcesProject.isOpen()) {
							for (URI contributedResourceUri : PluginSupportUtil.getContributedAadl()) {
								StringBuilder resourceName = new StringBuilder(50);
								String[] segs = contributedResourceUri.segments();
								int i = 2;
								while (true) {
									String seg = segs[i].toLowerCase();
									if (seg.startsWith("resource") || seg.startsWith("package")
											|| seg.startsWith("propert")) {
										i++;
									} else {
										break;
									}
								}
								for (; i < segs.length - 1; i++) {
									resourceName.append(segs[i]);
									resourceName.append("/");
								}
								resourceName.append(segs[i]);
								IFile contributedResourceInWorkspace = pluginResourcesProject
										.getFile(resourceName.toString());
								// exists() is true even though the file doesn't exist!
								if (!contributedResourceInWorkspace.exists()
										|| contributedResourceInWorkspace.getResourceAttributes() == null
										|| forceOriginal
										|| contributedResourceInWorkspace.getResourceAttributes().isReadOnly()) {
									try {
										copyContributedResourceIntoWorkspace(contributedResourceUri,
												contributedResourceInWorkspace);
										// delete obsolete old file in project root
										if (contributedResourceInWorkspace.getParent() != pluginResourcesProject) {
											String oldName = contributedResourceUri.lastSegment();
											IFile oldFile = pluginResourcesProject.getFile(oldName);
											if (oldFile.exists()) {
												ResourceAttributes attributes = contributedResourceInWorkspace
														.getResourceAttributes();
												attributes.setReadOnly(false);
												oldFile.delete(true, monitor);
											}
										}
									} catch (Exception e) {
									}
								}
							}
						}

						// DB Avoid removing the project's current natures.
						final IProjectDescription pluginResourcesProjectDescription = pluginResourcesProject
								.getDescription();
						final Set<String> newNatures = new HashSet<String>(
								Arrays.asList(pluginResourcesProjectDescription.getNatureIds()));
						newNatures.add(XtextProjectHelper.NATURE_ID);
						newNatures.add(AadlNature.ID);
						pluginResourcesProjectDescription
								.setNatureIds(newNatures.toArray(new String[newNatures.size()]));
						pluginResourcesProject.setDescription(pluginResourcesProjectDescription, null);
					} catch (IOException e) {
						throw new InvocationTargetException(e);
					}
				}
			}.run(null);
			isInitialized = true;
		} catch (InvocationTargetException e) {
			Activator.logThrowable(e.getCause());
			Activator.logErrorMessage("Cannot load plugin property sets and packages.");
		} catch (InterruptedException e) {
			Activator.logThrowable(e);
			Activator.logErrorMessage("Cannot load plugin property sets and packages.");
		}
	}

	private static boolean existsPluginResourcesProject() {
		IProject pluginResourcesProject = getPluginResourcesProject();
		return pluginResourcesProject.exists();
	}

	private static boolean isOpenPluginResourcesProject() {
		IProject pluginResourcesProject = getPluginResourcesProject();
		return pluginResourcesProject.exists() && pluginResourcesProject.isOpen();
	}

	private static IProject createPluginResourcesProject() throws CoreException, IOException {
		IProject pluginResourcesProject = getPluginResourcesProject();
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

	private static void deletePluginResourcesProject() {
		IProject pluginResourcesProject = getPluginResourcesProject();
		if (pluginResourcesProject.exists()) {
			try {
				pluginResourcesProject.delete(true, true, null);
			} catch (Exception ex) {
				// Ignore this exception.
			}
		}
	}

	private static void copyContributedResourceIntoWorkspace(URI contributedResourceUri,
			IFile contributedResourceInWorkspace) {
		try {
			URIConverter uricvt = OsateResourceUtil.createResourceSet().getURIConverter();
			InputStream contributedResourceContentsAsStream = uricvt.createInputStream(contributedResourceUri);
			if (contributedResourceInWorkspace.exists()) {
				// Temporarily make it read-write.
				ResourceAttributes attributes = contributedResourceInWorkspace.getResourceAttributes();
				attributes.setReadOnly(false);
				contributedResourceInWorkspace.setResourceAttributes(attributes);
				contributedResourceInWorkspace.setContents(contributedResourceContentsAsStream, false, true, null);
			} else {
				// create folders
				IContainer container = contributedResourceInWorkspace.getProject();
				IPath path = contributedResourceInWorkspace.getProjectRelativePath();
				for (int i = 0; i < path.segmentCount() - 1; i++) {
					String currentSegment = path.segment(i);
					IResource resource = container.findMember(currentSegment);
					if (resource != null) {
						if (resource.getType() == IResource.FILE) {
							String msg = NLS.bind(IDEWorkbenchMessages.ContainerGenerator_pathOccupied,
									resource.getFullPath().makeRelative());
							throw new CoreException(
									new Status(IStatus.ERROR, IDEWorkbenchPlugin.IDE_WORKBENCH, 1, msg, null));
						}
						container = (IContainer) resource;
					} else {
						IFolder folder = container.getFolder(new Path(currentSegment));
						folder.create(false, true, null);
						container = folder;
					}
				}
				// create file
				contributedResourceInWorkspace.create(contributedResourceContentsAsStream, false, null);
			}
			ResourceAttributes attributes = contributedResourceInWorkspace.getResourceAttributes();
			attributes.setReadOnly(true);
			contributedResourceInWorkspace.setResourceAttributes(attributes);
		} catch (Exception e) {
			Activator.logErrorMessage("Plugin contributor file does not exist: " + contributedResourceUri.toString());
		}
	}

	public static void revertToContributed(final IFile contributedResourceInWorkspace)
			throws IOException, CoreException {
		if (!contributedResourceInWorkspace.getProject().getName().equals(PLUGIN_RESOURCES_PROJECT_NAME)) {
			throw new IllegalArgumentException(
					"contributedResourceInWorkspace is not in the project " + PLUGIN_RESOURCES_PROJECT_NAME);
		}
		for (final URI contributedResourceUri : PluginSupportUtil.getContributedAadl()) {
			if (contributedResourceUri.lastSegment().equals(contributedResourceInWorkspace.getName())) { // FIXME: compare path!
				try {
					new WorkspaceModifyOperation() {
						@Override
						protected void execute(IProgressMonitor monitor)
								throws CoreException, InvocationTargetException {
							copyContributedResourceIntoWorkspace(contributedResourceUri,
									contributedResourceInWorkspace);
						}
					}.run(null);
				} catch (InvocationTargetException e) {
					if (e.getCause() instanceof IOException) {
						throw (IOException) e.getCause();
					} else if (e.getCause() instanceof CoreException) {
						throw (CoreException) e.getCause();
					} else {
						Activator.logThrowable(e);
					}
				} catch (InterruptedException e) {
					Activator.logThrowable(e);
				}
				break;
			}
		}
	}

	public static void setAadlProject(final IResource newAadlProject) throws ExecutionException {
		IEclipsePreferences prefs = InstanceScope.INSTANCE.getNode(Activator.PLUGIN_ID);
		final String oldAadlProjectPath = prefs.get(AADL_PROJECT_KEY, AADL_PROJECT_DEFAULT);
		String newAadlProjectPath = newAadlProject.getFullPath().toString();
		prefs.put(AADL_PROJECT_KEY, newAadlProjectPath);
		try {
			prefs.flush();
		} catch (BackingStoreException e) {
			log.error(e.getMessage(), e);
			throw new ExecutionException("Could not save preference " + Activator.PLUGIN_ID + " - " + AADL_PROJECT_KEY,
					e);
		}
		// make a change to the project description to force Xtext to rebuild
		new WorkspaceJob("") {

			@Override
			public IStatus runInWorkspace(IProgressMonitor monitor) throws CoreException {
				// This build approach seems to work OK.
				try {
					IProject project = newAadlProject.getProject();
					IProjectDescription description = project.getDescription();
					description.setComment("aadl-project:" + newAadlProject.getFullPath().toString() + "-"
							+ System.currentTimeMillis());
					project.setDescription(description, null);

					String projectName = new Path(oldAadlProjectPath).segment(0);
					project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
					if (project.exists()) {
						description = project.getDescription();
						String oldComment = description.getComment();
						description.setComment(oldComment.replaceFirst("aadl-project:" + oldAadlProjectPath, ""));
						project.setDescription(description, null);
					}
					return new Status(IStatus.OK, Activator.PLUGIN_ID, "");
				} catch (CoreException e) {
					log.error(e.getMessage());
					return new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Could not change project description", e);
				}
// The following code should work, but it doesn't! There will be references that point to the previous AADL_Project property set
//				try {
//					IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
//					for (IProject project : root.getProjects()) {
//						if (project.isAccessible()) {
//							project.build(IncrementalProjectBuilder.CLEAN_BUILD, monitor);
//						}
//					}
//					return new Status(IStatus.OK, Activator.PLUGIN_ID, "");
//				} catch (CoreException e) {
//					log.error(e.getMessage());
//					return new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Error when rebuilding workspace", e);
//				}
			}

		}.schedule();
	}

	public static IProject getPluginResourcesProject() {
		return ResourcesPlugin.getWorkspace().getRoot().getProject(PLUGIN_RESOURCES_PROJECT_NAME);
	}

}