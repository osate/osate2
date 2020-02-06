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

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
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
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.util.ITextRegion;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.modelsupport.AadlConstants;
import org.osate.aadl2.modelsupport.Activator;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.search.AadlFinder;
import org.osate.search.AadlFinder.ResourceConsumer;

import com.google.inject.Inject;
import com.google.inject.Injector;

public final class FindUnusedClassifiersAnalysis {
	public static final String MARKER_TYPE = "org.osate.analysis.architecture.UnusedClassifierMarker";

	public static final FindUnusedClassifiersAnalysis INSTANCE = new FindUnusedClassifiersAnalysis();

	@Inject
	private ILocationInFileProvider locationProvider;

	private FindUnusedClassifiersAnalysis() {
		final Injector injector = IResourceServiceProvider.Registry.INSTANCE
				.getResourceServiceProvider(URI.createFileURI("dummy.aadl")).get(Injector.class);
		injector.injectMembers(this);
	}

	public void doIt(final Object[] array) {
		final List<IFile> packages = new ArrayList<>(array.length);
		for (final Object file : array) {
			packages.add((IFile) file);
		}
		doIt(packages);
	}

	public void doIt(final Collection<IFile> packages) {
		final Job job = new FindUnusedClassifiersJob(new ResourceSetImpl(), packages);
		// TODO Make the rule based on the contents of the resource set
		job.setRule(ResourcesPlugin.getWorkspace().getRoot());
		job.setUser(true); // important!
		job.schedule();

	}

	private final class FindUnusedClassifiersJob extends WorkspaceJob {
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

			// Clear out the old warning markers
			for (final IFile packageFile : packageFiles) {
				packageFile.deleteMarkers(MARKER_TYPE, true, IResource.DEPTH_ZERO);
			}

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
					final Classifier classifier = (Classifier) resourceSet.getEObject(classifierDecl, true);
					final IFile iRsrc = OsateResourceUtil.toIFile(classifier.eResource().getURI());
					try {
						final IMarker marker = iRsrc.createMarker(MARKER_TYPE);
						marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_WARNING);
						marker.setAttribute(IMarker.MESSAGE,
								"Classifier " + classifier.getQualifiedName() + " is never referenced");

						final String uriString = classifierDecl.toString();
						marker.setAttribute(AadlConstants.AADLURI, uriString);
						marker.setAttribute(EValidator.URI_ATTRIBUTE, uriString);

						final ITextRegion where = locationProvider.getSignificantTextRegion(classifier);
						final int start = where.getOffset();
						final int end = start + where.getLength();
						marker.setAttribute(IMarker.CHAR_START, start);
						marker.setAttribute(IMarker.CHAR_END, end);
					} catch (final CoreException e) {
						Activator.logThrowable(e);
					}
				}

				lastMonitor.internalWorked(1);
			}

			return Status.OK_STATUS;
		}
	}
}
