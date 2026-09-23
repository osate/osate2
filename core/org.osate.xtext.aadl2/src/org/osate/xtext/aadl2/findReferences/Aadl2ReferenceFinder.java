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
package org.osate.xtext.aadl2.findReferences;

import java.util.LinkedHashSet;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.findReferences.ReferenceFinder;
import org.eclipse.xtext.findReferences.TargetURIs;
import org.eclipse.xtext.resource.IResourceDescription;
import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.modelsupport.scoping.Aadl2IndexMetadata;
import org.osate.annexsupport.AnnexReferencePosition;
import org.osate.annexsupport.AnnexRegistry;
import org.osate.annexsupport.AnnexTextPositionResolverRegistry;
import org.osate.annexsupport.AnnexUtil;

import com.google.common.base.Predicate;
import com.google.inject.Inject;

@SuppressWarnings("restriction")
public class Aadl2ReferenceFinder extends ReferenceFinder {

	@Inject
	public Aadl2ReferenceFinder() {
		super();
	}

	@Override
	public void findReferences(Predicate<URI> targetURIs, EObject scope, Acceptor acceptor, IProgressMonitor monitor) {
		super.findReferences(targetURIs, scope, acceptor, monitor);
		findAnnexReferences(targetURIs, scope, acceptor, monitor == null ? new NullProgressMonitor() : monitor);
	}

	@Override
	protected void findReferencesInDescription(TargetURIs targetURIs, IResourceDescription description,
			IResourceAccess resourceAccess, Acceptor acceptor, IProgressMonitor monitor) {
		super.findReferencesInDescription(targetURIs, description, resourceAccess, acceptor, monitor);
		if (resourceAccess != null && requiresAnnexSearch(description)) {
			var effectiveMonitor = monitor == null ? new NullProgressMonitor() : monitor;
			if (effectiveMonitor.isCanceled()) {
				throw new OperationCanceledException();
			}
			resourceAccess.readOnly(description.getURI(), resourceSet -> {
				var resource = resourceSet.getResource(description.getURI(), true);
				if (resource != null) {
					for (var root : resource.getContents()) {
						findAnnexReferences(targetURIs, root, acceptor, effectiveMonitor);
					}
				}
				return null;
			});
		}
	}

	private static boolean requiresAnnexSearch(IResourceDescription description) {
		var registry = getResolverRegistry();
		if (registry == null) {
			return false;
		}
		boolean hasMetadata = false;
		for (var exported : description.getExportedObjects()) {
			var names = exported.getUserData(Aadl2IndexMetadata.ANNEX_NAMES);
			if (names != null) {
				hasMetadata = true;
				for (var name : names.split(",")) {
					if (!name.isEmpty() && registry.getTextPositionResolver(name) != null) {
						return true;
					}
				}
			}
		}
		return !hasMetadata && "aadl".equalsIgnoreCase(description.getURI().fileExtension());
	}

	private void findAnnexReferences(Predicate<URI> targetURIs, EObject scope, Acceptor acceptor,
			IProgressMonitor monitor) {
		var annexRoot = AnnexUtil.getAnnexRoot(scope);
		if (annexRoot != null) {
			findAnnexReferences(targetURIs, scope, annexRoot, acceptor, monitor);
			return;
		}
		var contents = EcoreUtil.<EObject>getAllContents(List.of(scope));
		while (contents.hasNext()) {
			if (monitor.isCanceled()) {
				throw new OperationCanceledException();
			}
			var element = contents.next();
			if (element instanceof AnnexSubclause || element instanceof AnnexLibrary) {
				contents.prune();
				var annex = AnnexUtil.getParsedAnnex(element);
				if (annex != null) {
					findAnnexReferences(targetURIs, scope, annex, acceptor, monitor);
				}
			}
		}
	}

	private void findAnnexReferences(Predicate<URI> targetURIs, EObject scope, EObject annex, Acceptor acceptor,
			IProgressMonitor monitor) {
		var registry = getResolverRegistry();
		if (registry == null) {
			return;
		}
		var name = ((NamedElement) annex).getName();
		var resolver = name == null ? null : registry.getTextPositionResolver(name);
		if (resolver != null) {
			var relatedTargets = new LinkedHashSet<URI>();
			resolver.collectRelatedReferenceTargets(annex,
					target -> target != null && !target.eIsProxy()
							&& targetURIs.apply(EcoreUtil2.getPlatformResourceOrNormalizedURI(target)),
					target -> {
						if (target != null && !target.eIsProxy()) {
							var uri = EcoreUtil2.getPlatformResourceOrNormalizedURI(target);
							if (!targetURIs.apply(uri)) {
								relatedTargets.add(uri);
							}
						}
					}, monitor);
			if (!relatedTargets.isEmpty()) {
				super.findReferences(relatedTargets::contains, EcoreUtil.isAncestor(scope, annex) ? annex : scope,
						acceptor, monitor);
			}
			resolver.collectReferencePositions(annex, position -> {
				if (position instanceof AnnexReferencePosition reference) {
					var source = reference.getSourceObject();
					var target = reference.getModelObject();
					if (source != null && target != null && !target.eIsProxy() && EcoreUtil.isAncestor(scope, source)) {
						var targetURI = EcoreUtil2.getPlatformResourceOrNormalizedURI(target);
						if (targetURIs.apply(targetURI)) {
							acceptor.accept(source, EcoreUtil2.getPlatformResourceOrNormalizedURI(source), null, -1,
									target, targetURI);
						}
					}
				}
			}, monitor);
		}
	}

	private static AnnexTextPositionResolverRegistry getResolverRegistry() {
		return (AnnexTextPositionResolverRegistry) AnnexRegistry
				.getRegistry(AnnexRegistry.ANNEX_TEXTPOSITIONRESOLVER_EXT_ID);
	}

	@Override
	@SuppressWarnings("unchecked")
	protected void findLocalReferencesFromElement(Predicate<URI> targetURIs, EObject sourceCandidate,
			Resource localResource, Acceptor acceptor) {
		URI sourceURI = null;
		if (doProcess(sourceCandidate, targetURIs)) {
			for (EReference ref : sourceCandidate.eClass().getEAllReferences()) {
				if (ref.isDerived()) {
					// derived references are never occurrences
					continue;
				}
				if (sourceCandidate.eIsSet(ref)) {
					if (ref.isContainment()) {
						Object content = sourceCandidate.eGet(ref, false);
						if (ref.isMany()) {
							InternalEList<EObject> contentList = (InternalEList<EObject>) content;
							for (int i = 0; i < contentList.size(); ++i) {
								EObject childElement = contentList.basicGet(i);
								if (!childElement.eIsProxy()) {
									findLocalReferencesFromElement(targetURIs, childElement, localResource, acceptor);
								}
							}
						} else {
							EObject childElement = (EObject) content;
							if (!childElement.eIsProxy()) {
								findLocalReferencesFromElement(targetURIs, childElement, localResource, acceptor);
							}
						}
					} else if (!ref.isContainer()) {
						if (doProcess(ref, targetURIs)) {
							Object value = sourceCandidate.eGet(ref, false);
							if (ref.isMany()) {
								InternalEList<EObject> values = (InternalEList<EObject>) value;
								for (int i = 0; i < values.size(); ++i) {
									EObject instanceOrProxy = toValidInstanceOrNull(localResource, targetURIs,
											values.basicGet(i));
									if (instanceOrProxy != null) {
										URI refURI = EcoreUtil2.getPlatformResourceOrNormalizedURI(instanceOrProxy);
										if (targetURIs.apply(refURI)) {
											sourceURI = (sourceURI == null)
													? EcoreUtil2.getPlatformResourceOrNormalizedURI(sourceCandidate)
													: sourceURI;
											acceptor.accept(sourceCandidate, sourceURI, ref, i, instanceOrProxy,
													refURI);
										}
									}
								}
							} else {
								EObject instanceOrProxy = toValidInstanceOrNull(localResource, targetURIs,
										(EObject) value);
								if (instanceOrProxy != null) {
									URI refURI = EcoreUtil2.getPlatformResourceOrNormalizedURI(instanceOrProxy);
									if (targetURIs.apply(refURI)) {
										sourceURI = (sourceURI == null)
												? EcoreUtil2.getPlatformResourceOrNormalizedURI(sourceCandidate)
												: sourceURI;
										acceptor.accept(sourceCandidate, sourceURI, ref, -1, instanceOrProxy, refURI);
									}
								}
							}
						}
					}
				}
			}
		}
	}

}
