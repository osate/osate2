/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
 * All Rights Reserved.
 * 
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 * 
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.analysis.architecture.unusedclassifiers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.statushandlers.StatusManager;
import org.eclipse.ui.views.markers.WorkbenchMarkerResolution;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.PackageSection;
import org.osate.aadl2.modelsupport.AadlConstants;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;

public final class UnusedClassifierMarkerResolution extends WorkbenchMarkerResolution {

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
			final Resource rsrc = new ResourceSetImpl().getResource(OsateResourceUtil.toResourceURI(iRsrc), true);
			// should never get 'null' here
			final URI uri = URI.createURI(marker.getAttribute(AadlConstants.AADLURI, null));

			try {
				final TransactionalEditingDomain editingDomain = TransactionalEditingDomain.Registry.INSTANCE
						.getEditingDomain("org.osate.aadl2.ModelEditingDomain");
				editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
					@Override
					protected void doExecute() {
						final Classifier classifierDecl = (Classifier) rsrc.getEObject(uri.fragment());
						final PackageSection packageSection = (PackageSection) classifierDecl.getOwner();
						packageSection.getOwnedClassifiers().remove(classifierDecl);
						monitor.worked(1);
					}
				});
				try {
					rsrc.save(null);
				} catch (IOException e) {
					IStatus status = new Status(IStatus.ERROR, "org.osate.analysis.architecture", e.getMessage(), e);
					StatusManager.getManager().handle(status);
				}
				marker.delete();
			} finally {
				monitor.done();
			}

			return Status.OK_STATUS;
		}

	}

	@Override
	public String getDescription() {
		return null;
	}

	@Override
	public Image getImage() {
		return null;
	}

	@Override
	public IMarker[] findOtherMarkers(final IMarker[] markers) {
		final List<IMarker> alsoGood = new ArrayList<>();
		for (final IMarker test : markers) {
			try {
				if (test.getType().equals(FindUnusedClassifiersAnalysis.MARKER_TYPE)) {
					alsoGood.add(test);
				}
			} catch (final CoreException e) {
				// eat it
			}
		}
		return alsoGood.toArray(new IMarker[alsoGood.size()]);
	}
}
