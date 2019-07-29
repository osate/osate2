package org.osate.pluginsupport;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.preference.IPreferenceStore;

public final class PredeclaredProperties {
//	private final static Logger log = Logger.getLogger(PredeclaredProperties.class);
//
//	public static void setAadlProject(final IResource newAadlProject) throws ExecutionException {
//		IEclipsePreferences prefs = InstanceScope.INSTANCE.getNode(Activator.PLUGIN_ID);
//		final String oldAadlProjectPath = prefs.get(AADL_PROJECT_KEY, AADL_PROJECT_DEFAULT);
//		String newAadlProjectPath = newAadlProject.getFullPath().toString();
//		prefs.put(AADL_PROJECT_KEY, newAadlProjectPath);
//		try {
//			prefs.flush();
//		} catch (BackingStoreException e) {
//			log.error(e.getMessage(), e);
//			throw new ExecutionException("Could not save preference " + Activator.PLUGIN_ID + " - " + AADL_PROJECT_KEY,
//					e);
//		}
//		// make a change to the project description to force Xtext to rebuild
//		new WorkspaceJob("") {
//			@Override
//			public IStatus runInWorkspace(IProgressMonitor monitor) throws CoreException {
//				// This build approach seems to work OK.
//				try {
//					IProject project = newAadlProject.getProject();
//					IProjectDescription description = project.getDescription();
//					description.setComment("aadl-project:" + newAadlProject.getFullPath().toString() + "-"
//							+ System.currentTimeMillis());
//					project.setDescription(description, null);
//
//					String projectName = new Path(oldAadlProjectPath).segment(0);
//					project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
//					if (project.exists()) {
//						description = project.getDescription();
//						String oldComment = description.getComment();
//						description.setComment(oldComment.replaceFirst("aadl-project:" + oldAadlProjectPath, ""));
//						project.setDescription(description, null);
//					}
//					return new Status(IStatus.OK, Activator.PLUGIN_ID, "");
//				} catch (CoreException e) {
//					log.error(e.getMessage());
//					return new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Could not change project description", e);
//				}
//			};
//		}.schedule();
//	}
//
//	public static void resetAadlProject() throws ExecutionException {
//		IEclipsePreferences prefs = InstanceScope.INSTANCE.getNode(Activator.PLUGIN_ID);
//		prefs.put(AADL_PROJECT_KEY, AADL_PROJECT_DEFAULT);
//		try {
//			prefs.flush();
//		} catch (BackingStoreException e) {
//			log.error(e.getMessage(), e);
//			throw new ExecutionException("Could not save preference " + Activator.PLUGIN_ID + " - " + AADL_PROJECT_KEY,
//					e);
//		}
//	}
//
//	public static String getAADLProjectPreference() {
//		return InstanceScope.INSTANCE.getNode(Activator.PLUGIN_ID).get(AADL_PROJECT_KEY, AADL_PROJECT_DEFAULT);
//	}

	private static String PREFERENCE_NAME_PREFIX = "contributed.resource.isVisible.";

	public static IPreferenceStore getPreferenceStore() {
		return PluginSupportPlugin.getDefault().getPreferenceStore();
	}

	public static String getPreferenceNameForURI(final URI resourceURI) {
		return PREFERENCE_NAME_PREFIX + resourceURI.toString();
	}

	public static final List<URI> getVisibleContributedResources() {
		final IPreferenceStore prefStore = getPreferenceStore();
		final List<URI> collect = PluginSupportUtil.getContributedAadl().stream()
				.filter(uri -> prefStore.getBoolean(getPreferenceNameForURI(uri))).collect(Collectors.toList());
		return collect;
	}
}