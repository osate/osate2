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
package org.osate.xtext.aadl2.util;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IFragmentProvider;
import org.eclipse.xtext.util.OnChangeEvictingCache;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

@Singleton
public class Aadl2QualifiedNameFragmentProvider implements IFragmentProvider {

	private IQualifiedNameProvider qualifiedNameProvider;

	@Inject
	private OnChangeEvictingCache cache;

	@Inject
	public Aadl2QualifiedNameFragmentProvider(final IQualifiedNameProvider qualifiedNameProvider) {
		super();

		this.qualifiedNameProvider = qualifiedNameProvider;
	}

	@Override
	public String getFragment(EObject obj, Fallback fallback) {
		final QualifiedName qualifiedName = qualifiedNameProvider.getFullyQualifiedName(obj);

		if (qualifiedName != null) {
			return qualifiedName.toString();
		}
		return fallback.getFragment(obj);
	}

	@Override
	public EObject getEObject(final Resource resource, final String fragment, final Fallback fallback) {
		return cache.get(fragment, resource, new Provider<EObject>() {
			@Override
			public EObject get() {
				return doGetEObject(resource, fragment, fallback);
			}
		});
	}

	private EObject doGetEObject(Resource resource, String fragment, Fallback fallback) {
		if (fragment != null) {
			Iterator<EObject> i = EcoreUtil.getAllContents(resource, false);

			while (i.hasNext()) {
				EObject eObject = i.next();
				String candidateFragment = (eObject.eIsProxy()) ? ((InternalEObject) eObject).eProxyURI().fragment()
						: getFragment(eObject, fallback);

				if (fragment.equals(candidateFragment)) {
					return eObject;
				}
			}
		}

		return fallback.getEObject(fragment);
	}
}
