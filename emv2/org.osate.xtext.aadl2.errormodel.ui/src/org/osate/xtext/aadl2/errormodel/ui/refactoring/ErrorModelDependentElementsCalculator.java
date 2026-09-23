/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
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
 * conditions contained in any such Third Party Software or separate license file distributed with this program. The
 * parties who own the Third Party Software ("Third Party Licensors") are intended third party beneficiaries to this
 * license with respect to the terms applicable to their Third Party Software. Third Party Software licenses only apply
 * to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.xtext.aadl2.errormodel.ui.refactoring;

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.findReferences.IReferenceFinder;
import org.eclipse.xtext.findReferences.TargetURIConverter;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.ui.editor.findrefs.ResourceAccess;
import org.eclipse.xtext.ui.refactoring.impl.DefaultDependentElementsCalculator;
import org.osate.aadl2.Feature;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.FeatureorPPReference;
import org.osate.xtext.aadl2.errormodel.errorModel.PropagationPoint;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * Tracks error propagations whose synthetic names change when a core feature or propagation point is renamed.
 */
@SuppressWarnings("restriction")
public class ErrorModelDependentElementsCalculator extends DefaultDependentElementsCalculator {
	@Inject
	private IResourceServiceProvider.Registry registry;
	@Inject
	private IResourceDescriptions descriptions;
	@Inject
	private TargetURIConverter targetURIConverter;
	@Inject
	private Provider<ResourceAccess> resourceAccessProvider;

	@Override
	public List<URI> getDependentElementURIs(EObject baseElement, IProgressMonitor monitor) {
		List<URI> dependentElementURIs = super.getDependentElementURIs(baseElement, monitor);
		if (baseElement instanceof Feature || baseElement instanceof PropagationPoint) {
			var resource = baseElement.eResource();
			var finder = registry.getResourceServiceProvider(resource.getURI()).get(IReferenceFinder.class);
			var targets = targetURIConverter.fromIterable(List.of(EcoreUtil2.getPlatformResourceOrNormalizedURI(baseElement)));
			var access = resourceAccessProvider.get();
			access.registerResourceSet(resource.getResourceSet());
			var acceptor = new IReferenceFinder.Acceptor() {
				@Override
				public void accept(IReferenceDescription description) {
					access.readOnly(description.getSourceEObjectUri(), resourceSet -> {
						addPropagation(resourceSet.getEObject(description.getSourceEObjectUri(), true));
						return null;
					});
				}

				@Override
				public void accept(EObject source, URI sourceURI, EReference reference, int index, EObject target,
						URI targetURI) {
					addPropagation(source);
				}

				private void addPropagation(EObject source) {
					if (source instanceof FeatureorPPReference) {
						var propagation = EcoreUtil2.getContainerOfType(source, ErrorPropagation.class);
						if (propagation != null) {
							var uri = EcoreUtil.getURI(propagation);
							if (!dependentElementURIs.contains(uri)) {
								dependentElementURIs.add(uri);
							}
						}
					}
				}
			};
			finder.findReferences(targets, resource, acceptor, monitor);
			finder.findAllReferences(targets, access, descriptions, acceptor, monitor);
		}
		return dependentElementURIs;
	}
}
