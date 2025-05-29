/**
 * Copyright (c) 2004-2025 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.ge.services.impl;

import java.util.Objects;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.osate.ge.CanonicalBusinessObjectReference;
import org.osate.ge.RelativeBusinessObjectReference;
import org.osate.ge.internal.services.ReferenceService;
import org.osate.ge.internal.services.impl.SimpleServiceContextFunction;
import org.osate.ge.services.ReferenceBuilderService;

/**
 * {@link ReferenceBuilderService} implementation. It exposes a subset of the functionality provided
 * by the internal {@link ReferenceService}
 *
 */
public class DefaultReferenceBuilderService implements ReferenceBuilderService {
	private final ReferenceService internalService;

	/**
	 * Context function which instantiates this service
	 *
	 */
	public static class ContextFunction extends SimpleServiceContextFunction<ReferenceBuilderService> {
		@Override
		public ReferenceBuilderService createService(final IEclipseContext context) {
			return new DefaultReferenceBuilderService(context.get(ReferenceService.class));
		}
	}

	/**
	 * Creates a new instance
	 * @param internalService the internal reference service.
	 */
	public DefaultReferenceBuilderService(final ReferenceService internalService) {
		this.internalService = Objects.requireNonNull(internalService, "internalService must not be null");
	}

	@Override
	public CanonicalBusinessObjectReference getCanonicalReference(final Object bo) {
		return this.internalService.getCanonicalReference(bo);
	}

	@Override
	public RelativeBusinessObjectReference getRelativeReference(final Object bo) {
		return this.internalService.getRelativeReference(bo);
	}
}
