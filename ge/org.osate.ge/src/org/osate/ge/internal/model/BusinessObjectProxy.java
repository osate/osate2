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
package org.osate.ge.internal.model;

import java.util.Objects;

import org.osate.ge.CanonicalBusinessObjectReference;
import org.osate.ge.RelativeBusinessObjectReference;
import org.osate.ge.businessobjecthandling.BusinessObjectHandler;
import org.osate.ge.internal.services.ProjectReferenceService;

/**
 * Object which may be provided by a business object provider in place of another object which make be expensive to return. The intended use is for cases like packages
 * in contextless diagrams where returning the package requires loading the source. This object is handled specially by the graphical editor. However,
 * any business objects that use this class must have a {@link BusinessObjectHandler} which is applicable for the proxy version of the object which
 * provides references, name, and icon for the proxy.
 * The business object tree updater will replace it with the resolved object in the business object tree.
 * The result of which is that most of the code-base can safely assume that the business object is not a proxy.
 * */
public class BusinessObjectProxy {
	private final String name;
	private final String typeId;
	private final CanonicalBusinessObjectReference canonicalReference;
	private final RelativeBusinessObjectReference relativeReference;

	public BusinessObjectProxy(final String name,
			final String typeId,
			final CanonicalBusinessObjectReference canonicalReference,
			final RelativeBusinessObjectReference relativeReference) {
		this.name = Objects.requireNonNull(name, "name must not be null");
		this.typeId = Objects.requireNonNull(typeId, "typeId must not be null");
		this.canonicalReference = Objects.requireNonNull(canonicalReference, "canonicalReference must not be null");
		this.relativeReference = Objects.requireNonNull(relativeReference, "relativeReference must not be null");
	}

	public final String getName() {
		return name;
	}

	public final String getTypeId() {
		return typeId;
	}

	public final CanonicalBusinessObjectReference getCanonicalReference() {
		return canonicalReference;
	}

	public final RelativeBusinessObjectReference getRelativeReference() {
		return relativeReference;
	}

	public Object resolve(final ProjectReferenceService projectReferenceService) {
		return projectReferenceService.resolve(canonicalReference);
	}
}
