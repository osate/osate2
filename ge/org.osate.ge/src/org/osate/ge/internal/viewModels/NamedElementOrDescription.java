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
package org.osate.ge.internal.viewModels;

import java.util.Objects;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.osate.aadl2.NamedElement;

import com.google.common.base.Strings;

/**
 * Class that stores a {@link NamedElement} or an {@link IEObjectDescription}. Supports comparison between the two using qualified names. Intended to be used as a view model
 * object when selecting named elements.
 */
class NamedElementOrDescription {
	private final Object value;
	private final String qualifiedName;
	private final String lcQualifiedName;

	public NamedElementOrDescription(final NamedElement namedElement) {
		this.value = Objects.requireNonNull(namedElement, "eobj must not be null");
		this.qualifiedName = Strings.nullToEmpty(namedElement.getQualifiedName());
		this.lcQualifiedName = qualifiedName.toLowerCase();
	}

	public NamedElementOrDescription(final IEObjectDescription desc) {
		this.value = Objects.requireNonNull(desc, "desc must not be null");
		this.qualifiedName = Strings.nullToEmpty(desc.getQualifiedName().toString("::"));
		this.lcQualifiedName = qualifiedName.toLowerCase();
	}

	/**
	 * Gets the value as an EObject. Resolves it if is a proxy.
	 * @param resourceSet the resource set to use to resolve proxies.
	 * @return the EObject
	 */
	public EObject getResolvedValue(final ResourceSet resourceSet) {
		// We need to get an actual EObject to determine children.
		EObject eobj;
		if (value instanceof IEObjectDescription) {
			eobj = ((IEObjectDescription) value).getEObjectOrProxy();
		} else {
			eobj = (EObject) value;
		}

		// Resolve the EObject if it is a proxy
		if (eobj != null && eobj.eIsProxy()) {
			eobj = EcoreUtil.resolve(eobj, resourceSet);
		}

		return eobj;
	}

	public String getQualifiedName() {
		return qualifiedName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(lcQualifiedName);
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		NamedElementOrDescription other = (NamedElementOrDescription) obj;
		return Objects.equals(lcQualifiedName, other.lcQualifiedName);
	}
}
