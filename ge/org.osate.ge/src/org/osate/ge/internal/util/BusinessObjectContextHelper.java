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
package org.osate.ge.internal.util;

import java.util.Objects;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.di.GetGraphicalConfiguration;
import org.osate.ge.di.GetName;
import org.osate.ge.di.GetNameForUserInterface;
import org.osate.ge.di.Names;
import org.osate.ge.graphics.internal.AgeGraphicalConfiguration;
import org.osate.ge.internal.services.ExtensionService;

/**
 * Helper class for invoking business object handler methods.
 * Only supports a subset of messages at this time.
 *
 */
public class BusinessObjectContextHelper implements AutoCloseable {
	private final IEclipseContext ctx;

	public BusinessObjectContextHelper(final ExtensionService extService) {
		this.ctx = Objects.requireNonNull(extService, "extService must not be null").createChildContext();
	}

	@Override
	public void close() {
		ctx.dispose();
	}

	/**
	 * Returns the name for the user interface provided by the business object handler. If it does not provide a name or provided null, then
	 * the label name is returned.
	 * @param boc
	 * @param boh
	 * @return
	 */
	public String getNameForUserInterface(final BusinessObjectContext boc, final Object boh) {
		try {
			updateContextArguments(boc);
			final String nameForUi = (String) ContextInjectionFactory.invoke(boh, GetNameForUserInterface.class, ctx,
					null);
			if (nameForUi != null) {
				return nameForUi;
			}
		} finally {
			clearContextArguments();
		}

		return getNameForLabel(boc, boh);
	}

	public String getNameForLabel(final BusinessObjectContext boc, final Object boh) {
		try {
			updateContextArguments(boc);
			return (String)ContextInjectionFactory.invoke(boh, GetName.class, ctx, null);
		} finally {
			clearContextArguments();
		}
	}

	public AgeGraphicalConfiguration getGraphicalConfiguration(final BusinessObjectContext boc, final Object boh) {
		try {
			updateContextArguments(boc);
			return (AgeGraphicalConfiguration)ContextInjectionFactory.invoke(boh, GetGraphicalConfiguration.class, ctx, null);
		} finally {
			clearContextArguments();
		}
	}

	private void updateContextArguments(final BusinessObjectContext boc) {
		Objects.requireNonNull(boc, "boc must not be null");
		ctx.set(Names.BUSINESS_OBJECT, boc.getBusinessObject());
		ctx.set(Names.BUSINESS_OBJECT_CONTEXT, boc);
	}

	private void clearContextArguments() {
		ctx.remove(Names.BUSINESS_OBJECT);
		ctx.remove(Names.BUSINESS_OBJECT_CONTEXT);
	}
}
