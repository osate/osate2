/**
 * Copyright (c) 2004-2022 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.ge.aadl2.internal;

import java.util.Optional;

import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.NamedElement;
import org.osate.ge.businessobjecthandling.BusinessObjectHandler;
import org.osate.ge.businessobjecthandling.GetIconIdContext;
import org.osate.ge.businessobjecthandling.RenameContext;

/**
 * Base class for business object handlers for AADL model elements
 */
public abstract class AadlBusinessObjectHandler implements BusinessObjectHandler {
	/**
	 * Returns the image ID based on EClass of the EObject. Returns an empty optional if the business object was not an EObject.
	 * This method assumes there is an image referenced for the AADL EClass of the EObject.
	 */
	@Override
	public Optional<String> getIconId(final GetIconIdContext ctx) {
		return ctx.getBusinessObject(EObject.class).map(o -> AadlImages.getImage(o.eClass()));
	}

	/**
	 * Implementation which used {@link AadlNamingUtil} to check name validity. Handlers must override if this is not the desired behavior.
	 * {@link #canRename(org.osate.ge.businessobjecthandling.CanRenameContext)} must also be implemented.
	 */
	@Override
	public Optional<String> validateName(final RenameContext ctx) {
		return ctx.getBusinessObject(
				NamedElement.class)
				.map(namedElement -> AadlNamingUtil.checkNameValidity(namedElement, ctx.getNewName()));
	}
}
