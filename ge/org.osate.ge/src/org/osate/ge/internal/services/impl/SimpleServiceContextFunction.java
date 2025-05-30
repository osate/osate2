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
package org.osate.ge.internal.services.impl;

import org.eclipse.e4.core.contexts.ContextFunction;
import org.eclipse.e4.core.contexts.IEclipseContext;

/**
 * ContextFunction for use with global services. Delegates creation of the service to the child class.
 *
 * @param <S> the interface implemented by the service
 */
public abstract class SimpleServiceContextFunction<S> extends ContextFunction {
	private S service = null;

	@Override
	public Object compute(IEclipseContext context, String contextKey) {
		if (service == null) {
			service = createService(context);
			context.set(contextKey, service);
		}

		return service;
	}

	/**
	 * Instantiates the service
	 * @param context the context which provides access to other services
	 * @return the new service
	 */
	protected abstract S createService(final IEclipseContext context);

	/**
	 * Returns the service previously instantiated by {@link #createService(IEclipseContext)}
	 * @return the previously instantiated service
	 * @see #createService(IEclipseContext)
	 */
	protected S getService() {
		return service;
	}

	/**
	 * Releases the reference to the service. Once this is called, {@link #getService()} will return null.
	 * Although this doesn't override a function. This is automatically called by Eclipse.
	 */
	protected void deactivate() {
		this.service = null;
	}
}
