package org.osate.xtext.aadl2.findReferences;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.findReferences.ReferenceFinder;
import org.eclipse.xtext.findReferences.TargetURIs;

import com.google.inject.Inject;

@SuppressWarnings("restriction")
public class Aadl2ReferenceFinder extends ReferenceFinder {

	@Inject
	public Aadl2ReferenceFinder() {
		super();
	}

	@Override
	@SuppressWarnings("unchecked")
	protected void findLocalReferencesFromElement(TargetURIs targetURIs, EObject sourceCandidate,
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
										if (targetURIs.contains(refURI)) {
											sourceURI = (sourceURI == null) ? EcoreUtil2
													.getPlatformResourceOrNormalizedURI(sourceCandidate) : sourceURI;
											acceptor.accept(sourceCandidate, sourceURI, ref, i, instanceOrProxy, refURI);
										}
									}
								}
							} else {
								EObject instanceOrProxy = toValidInstanceOrNull(localResource, targetURIs,
										(EObject) value);
								if (instanceOrProxy != null) {
									URI refURI = EcoreUtil2.getPlatformResourceOrNormalizedURI(instanceOrProxy);
									if (targetURIs.contains(refURI)) {
										sourceURI = (sourceURI == null) ? EcoreUtil2
												.getPlatformResourceOrNormalizedURI(sourceCandidate) : sourceURI;
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
