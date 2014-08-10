package org.osate.xtext.aadl2.ui.editor.findrefs;

import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceServiceProvider.Registry;
import org.eclipse.xtext.resource.impl.DefaultReferenceDescription;
import org.eclipse.xtext.ui.editor.findrefs.DefaultReferenceFinder;
import org.eclipse.xtext.util.IAcceptor;

import com.google.inject.Inject;

@SuppressWarnings("restriction")
public class Aadl2ReferenceFinder extends DefaultReferenceFinder {

	@Inject
	public Aadl2ReferenceFinder(IResourceDescriptions indexData, Registry serviceProviderRegistry) {
		super(indexData, serviceProviderRegistry);
	}

	@Override
	@SuppressWarnings("unchecked")
	protected void findLocalReferencesFromElement(final Set<URI> targetURISet, EObject sourceCandidate,
			Resource localResource, final IAcceptor<IReferenceDescription> acceptor, URI currentExportedContainerURI,
			Map<EObject, URI> exportedElementsMap) {
		URI sourceURI = null;
		if (exportedElementsMap.containsKey(sourceCandidate)) {
			currentExportedContainerURI = exportedElementsMap.get(sourceCandidate);
			sourceURI = currentExportedContainerURI;
		}
		for (EReference ref : sourceCandidate.eClass().getEAllReferences()) {
			if (!ref.isDerived() && sourceCandidate.eIsSet(ref)) {
				if (ref.isContainment()) {
					Object content = sourceCandidate.eGet(ref, false);
					if (ref.isMany()) {
						InternalEList<EObject> contentList = (InternalEList<EObject>) content;
						for (int i = 0; i < contentList.size(); ++i) {
							EObject childElement = contentList.basicGet(i);
							if (!childElement.eIsProxy()) {
								findLocalReferencesFromElement(targetURISet, childElement, localResource, acceptor,
										currentExportedContainerURI, exportedElementsMap);
							}
						}
					} else {
						EObject childElement = (EObject) content;
						if (!childElement.eIsProxy()) {
							findLocalReferencesFromElement(targetURISet, childElement, localResource, acceptor,
									currentExportedContainerURI, exportedElementsMap);
						}
					}
				} else if (!ref.isContainer()) {
					Object value = sourceCandidate.eGet(ref, false);
					if (ref.isMany()) {
						InternalEList<EObject> values = (InternalEList<EObject>) value;
						for (int i = 0; i < values.size(); ++i) {
							EObject refElement = resolveInternalProxy(values.basicGet(i), localResource);
							URI refURI = EcoreUtil2.getPlatformResourceOrNormalizedURI(refElement);
							if (targetURISet.contains(refURI)) {
								sourceURI = (sourceURI == null) ? EcoreUtil2
										.getPlatformResourceOrNormalizedURI(sourceCandidate) : sourceURI;
								acceptor.accept(new DefaultReferenceDescription(sourceURI, refURI, ref, i,
										currentExportedContainerURI));
							}
						}
					} else {
						EObject refElement = resolveInternalProxy((EObject) value, localResource);
						URI refURI = EcoreUtil2.getPlatformResourceOrNormalizedURI(refElement);
						if (targetURISet.contains(refURI)) {
							sourceURI = (sourceURI == null) ? EcoreUtil2
									.getPlatformResourceOrNormalizedURI(sourceCandidate) : sourceURI;
							acceptor.accept(new DefaultReferenceDescription(sourceURI, refURI, ref, -1,
									currentExportedContainerURI));
						}
					}
				}
			}
		}
	}

}
