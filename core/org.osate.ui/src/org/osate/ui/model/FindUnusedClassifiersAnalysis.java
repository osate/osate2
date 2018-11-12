package org.osate.ui.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.IResourceDescription;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.search.AadlFinder;
import org.osate.search.AadlFinder.ResourceConsumer;

public final class FindUnusedClassifiersAnalysis {

	public FindUnusedClassifiersAnalysis() {
		// TODO Auto-generated constructor stub
	}

	public static void doIt(final Object[] array) {
		final List<IFile> packages = new ArrayList<>(array.length);
		for (final Object file : array) {
			packages.add((IFile) file);
		}
		doIt(packages);
	}

	public static void doIt(final Collection<IFile> packages) {
		final Job job = new FindUnusedClassifiersJob(OsateResourceUtil.getResourceSet(), packages);
		// XXX Make the rule based on the contents of the resource set
		job.setRule(ResourcesPlugin.getWorkspace().getRoot());
		job.setUser(true); // important!
		job.schedule();

	}

	private final static class FindUnusedClassifiersJob extends WorkspaceJob {
		private final ResourceSet resourceSet;
		private final Collection<IFile> packageFiles;

		public FindUnusedClassifiersJob(final ResourceSet resourceSet, final Collection<IFile> packageFiles) {
			super("Find unused classifiers");
			this.resourceSet = resourceSet;
			this.packageFiles = packageFiles;
		}

		@Override
		public IStatus runInWorkspace(final IProgressMonitor monitor) throws CoreException {
			final SubMonitor subMonitor = SubMonitor.convert(monitor, 3);

			// (1) Get all the declarations in the packages
			final List<URI> declarationURIs = new ArrayList<>();
			AadlFinder.getInstance().getAllObjectsOfTypeInCollection(Aadl2Package.eINSTANCE.getClassifier(),
					packageFiles, objDesc -> declarationURIs.add(objDesc.getEObjectURI()));

			subMonitor.worked(1);
			if (subMonitor.isCanceled()) {
				throw new OperationCanceledException();
			}

			// (2) Find all the uses in the workspace
			final Set<URI> referencedThings = new HashSet<>();
			AadlFinder.getInstance().getAllReferencesToTypeInWorkspace(
				new ResourceConsumer<IResourceDescription>() {
						private SubMonitor subMon;

						@Override
						protected void begin(final int count) {
							subMon = subMonitor.split(1);
							subMon.beginTask("Scanning references", count);
						}

						@Override
						protected void inScope(final IResourceDescription rsrcDesc) {
							subMon.worked(1);
							if (subMon.isCanceled()) {
								throw new OperationCanceledException();
							}
						}

						@Override
						protected void skipped(final IResourceDescription rsrcDesc) {
							subMon.worked(1);
						}
					},

					refDesc -> referencedThings.add(refDesc.getTargetEObjectUri()));

			// (3) See if the declarations in the set of referenced things
			final SubMonitor lastMonitor = subMonitor.split(1);
			lastMonitor.beginTask("Looking for uses", declarationURIs.size());
			for (final URI classifierDecl : declarationURIs) {
				if (lastMonitor.isCanceled()) {
					throw new OperationCanceledException();
				}

				if (!referencedThings.contains(classifierDecl)) {
					System.out.println("UNUSED: " + classifierDecl);
				}

				lastMonitor.internalWorked(1);
			}

			return Status.OK_STATUS;
		}

		private String getPackageName(final IFile packageFile) {
			final Resource resource = OsateResourceUtil.getResource(packageFile, resourceSet);
			final AadlPackage root = (AadlPackage) resource.getContents().get(0);
			return root.getName();
		}

	}
}
