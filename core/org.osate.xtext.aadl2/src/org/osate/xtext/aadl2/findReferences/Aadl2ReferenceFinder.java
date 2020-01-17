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
package org.osate.xtext.aadl2.findReferences;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.findReferences.ReferenceFinder;

import com.google.common.base.Predicate;
import com.google.inject.Inject;

@SuppressWarnings("restriction")
public class Aadl2ReferenceFinder extends ReferenceFinder {

	@Inject
	public Aadl2ReferenceFinder() {
		super();
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
