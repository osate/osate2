package org.osate.ui.model;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;

public final class FindUnusedClassifiersAnalysis {

	public FindUnusedClassifiersAnalysis() {
		// TODO Auto-generated constructor stub
	}

	public static void doIt(final Object[] array) {
		final IFile[] packages = new IFile[array.length];
		System.arraycopy(array, 0, packages, 0, array.length);
		doIt(packages);
	}

	public static void doIt(final IFile[] packages) {
		final Job job = new FindUnusedClassifiersJob(OsateResourceUtil.getResourceSet(), packages);
		// XXX Make the rule based on the contents of the resource set
		job.setRule(ResourcesPlugin.getWorkspace().getRoot());
		job.setUser(true); // important!
		job.schedule();

	}

	private final static class FindUnusedClassifiersJob extends WorkspaceJob {
		private final ResourceSet resourceSet;
		private final IFile[] packageFiles;

		public FindUnusedClassifiersJob(final ResourceSet resourceSet, final IFile[] packageFiles) {
			super("Find unused classifiers");
			this.resourceSet = resourceSet;
			this.packageFiles = packageFiles;
		}

		@Override
		public IStatus runInWorkspace(IProgressMonitor monitor) throws CoreException {
			if (monitor == null) {
				monitor = new NullProgressMonitor();
			}

			monitor.beginTask("Scanning", packageFiles.length);
			try {
				for (final IFile packageFile : packageFiles) {
					final String packageName = getPackageName(packageFile);
					monitor.subTask(packageName);

					System.out.println(packageName);

					try {
						Thread.sleep(2000L);
					} catch (final InterruptedException e) {
						// who cares
					}

					if (monitor.isCanceled()) {
						throw new OperationCanceledException();
					}

					monitor.worked(1);
				}
			} finally {
				monitor.done();
			}
			// TODO Auto-generated method stub
			return Status.OK_STATUS;
		}

		private String getPackageName(final IFile packageFile) {
			final Resource resource = OsateResourceUtil.getResource(packageFile, resourceSet);
			final AadlPackage root = (AadlPackage) resource.getContents().get(0);
			return root.getName();
		}

	}
}
