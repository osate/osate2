package org.osate.ui.model;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.ui.IMarkerResolution;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.PackageSection;
import org.osate.aadl2.modelsupport.AadlConstants;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;

public final class UnusedClassifierMarkerResolution implements IMarkerResolution {

	public UnusedClassifierMarkerResolution() {
		super();
	}

	@Override
	public String getLabel() {
		return "Remove unused classifier";
	}

	@Override
	public void run(final IMarker marker) {
		final Job job = new RemoveUnusedClassifierJob(marker);
		job.setRule(marker.getResource());
		job.setUser(true); // important!
		job.schedule();
	}

	private static final class RemoveUnusedClassifierJob extends WorkspaceJob {
		private final IMarker marker;

		public RemoveUnusedClassifierJob(final IMarker marker) {
			super("Remove unused classifier");
			this.marker = marker;
		}

		@Override
		public IStatus runInWorkspace(final IProgressMonitor monitor) throws CoreException {
			monitor.beginTask("Remove unused classifier", 1);
			final IResource iRsrc = marker.getResource();
			final Resource rsrc = OsateResourceUtil.getResource(iRsrc);
			// should never get 'null' here
			final URI uri = URI.createURI(marker.getAttribute(AadlConstants.AADLURI, null));

			try {
				final TransactionalEditingDomain editingDomain = TransactionalEditingDomain.Registry.INSTANCE
						.getEditingDomain("org.osate.aadl2.ModelEditingDomain");
				editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
					@Override
					protected void doExecute() {
//						final Classifier classifierDecl = (Classifier) OsateResourceUtil.getResourceSet()
//								.getEObject(uri, true);
						final Classifier classifierDecl = (Classifier) rsrc.getEObject(uri.fragment());
						final PackageSection packageSection = (PackageSection) classifierDecl.getOwner();
						packageSection.getOwnedClassifiers().remove(classifierDecl);
						monitor.worked(1);
					}
				});
				OsateResourceUtil.save(rsrc);
				marker.delete();
			} finally {
				monitor.done();
			}

			return Status.OK_STATUS;
		}

	}
}
