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
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.xtext.aadl2.ide.refactoring;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.findReferences.IReferenceFinder;
import org.eclipse.xtext.findReferences.TargetURIConverter;
import org.eclipse.xtext.ide.refactoring.RefactoringIssueAcceptor.Severity;
import org.eclipse.xtext.ide.refactoring.RenameContext;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescriptionsProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.Exceptions;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.SimpleAttributeResolver;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.DefaultAnnexLibrary;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.annexsupport.AnnexUtil;
import org.osate.xtext.aadl2.util.Aadl2ReferencePositionProvider;

import com.google.inject.Inject;

/**
 * Collects semantic references before a rename and batches edits to each
 * containing annex text token.
 */
public class Aadl2AnnexRenameSupport {
	@Inject
	private IReferenceFinder references;
	@Inject
	private TargetURIConverter targets;
	@Inject
	private IResourceDescriptionsProvider descriptions;
	@Inject
	private ILocationInFileProvider locations;
	@Inject
	private Aadl2ReferencePositionProvider positions;

	public boolean addModifications(EObject target, String newName, RenameContext context, IProgressMonitor monitor) {
		var edits = new LinkedHashMap<EObject, Set<ITextRegion>>();
		var resourceSet = context.getResourceSet();
		String oldName = target instanceof ComponentImplementation implementation && !newName.contains(".")
				? implementation.getImplementationName()
				: SimpleAttributeResolver.NAME_RESOLVER.apply(target);
		boolean embedded = AnnexUtil.getAnnexRoot(target) != null;
		if (embedded) {
			add(edits, target, locations.getSignificantTextRegion(target));
		}
		var access = new IReferenceFinder.IResourceAccess() {
			@Override
			public <T> T readOnly(URI uri, IUnitOfWork<T, ResourceSet> work) {
				checkCanceled(monitor);
				resourceSet.getResource(uri.trimFragment(), true);
				try {
					return work.exec(resourceSet);
				} catch (Exception exception) {
					return Exceptions.throwUncheckedException(exception);
				}
			}
		};
		var acceptor = new IReferenceFinder.Acceptor() {
			@Override
			public void accept(IReferenceDescription reference) {
				access.readOnly(reference.getSourceEObjectUri(), set -> {
					var source = set.getEObject(reference.getSourceEObjectUri(), true);
					collect(source, reference.getEReference(), reference.getIndexInList());
					return null;
				});
			}
			@Override
			public void accept(EObject source, URI sourceURI, EReference reference, int index, EObject actualTarget,
					URI targetURI) {
				collect(source, reference, index);
			}
			private void collect(EObject source, EReference reference, int index) {
				checkCanceled(monitor);
				if (source != null && AnnexUtil.getAnnexRoot(source) != null
						&& source.eResource() instanceof XtextResource resource) {
					var region = positions.getReferenceRegion(source, reference, index, target);
					var text = resource.getParseResult().getRootNode().getText();
					var nameRegion = region == null
							? null
							: positions.getNameRegion(region,
									text.substring(region.getOffset(), region.getOffset() + region.getLength()),
									oldName);
					if (nameRegion == null) {
						context.getIssues().add(Severity.ERROR, "Unable to locate the referenced name.", source);
					} else {
						add(edits, source, nameRegion);
					}
				}
			}
		};
		var targetURIs = targets.fromIterable(List.of(EcoreUtil2.getPlatformResourceOrNormalizedURI(target)));
		var index = descriptions.getResourceDescriptions(resourceSet);
		references.findAllReferences(targetURIs, access, index, acceptor, monitor);
		// Include current contents even if the resource has not yet been exported to
		// the index.
		for (var resource : List.copyOf(resourceSet.getResources())) {
			checkCanceled(monitor);
			if (resource.isLoaded() && index.getResourceDescription(resource.getURI()) == null) {
				references.findReferences(targetURIs, resource, acceptor, monitor);
			}
		}
		for (var entry : edits.entrySet()) {
			context.getChangeSerializer().addModification(entry.getKey(), annex -> {
				checkCanceled(monitor);
				var document = context.getChangeSerializer().getModifiableDocument(annex.eResource());
				var annexRegion = document.getOriginalTextRegionAccess().regionForEObject(annex);
				var source = annexRegion == null
						? null
						: annexRegion.getRegionFor().feature(annex.eClass().getEStructuralFeature("sourceText"));
				if (source == null) {
					context.getIssues().add(Severity.ERROR, "Unable to locate the containing annex text.", annex);
					return;
				}
				var text = new StringBuilder(source.getText());
				int previousStart = source.getEndOffset();
				for (var region : entry.getValue().stream()
						.sorted(Comparator.comparingInt(ITextRegion::getOffset).reversed()).toList()) {
					checkCanceled(monitor);
					int end = region.getOffset() + region.getLength();
					if (region.getOffset() < source.getOffset() || end > previousStart) {
						context.getIssues().add(Severity.ERROR, "Invalid or overlapping annex rename regions.", annex);
						return;
					}
					text.replace(region.getOffset() - source.getOffset(), end - source.getOffset(), newName);
					previousStart = region.getOffset();
				}
				document.replace(source, text.toString());
			});
		}
		return embedded;
	}

	private static void add(Map<EObject, Set<ITextRegion>> edits, EObject source, ITextRegion region) {
		var annex = EcoreUtil2.getContainerOfType(source, DefaultAnnexSubclause.class);
		EObject owner = annex != null ? annex : EcoreUtil2.getContainerOfType(source, DefaultAnnexLibrary.class);
		if (owner != null && region != null && region.getLength() > 0) {
			edits.computeIfAbsent(owner, key -> new LinkedHashSet<>()).add(region);
		}
	}

	private static void checkCanceled(IProgressMonitor monitor) {
		if (monitor.isCanceled())
			throw new OperationCanceledException();
	}
}
