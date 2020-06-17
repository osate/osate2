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
package org.osate.ge.aadl2.internal.businessObjectHandlers;

import java.util.Optional;

import org.osate.ge.GraphicalConfiguration;
import org.osate.ge.aadl2.internal.AadlImages;
import org.osate.ge.businessObjectHandlers.BusinessObjectHandler;
import org.osate.ge.businessObjectHandlers.GetGraphicalConfigurationContext;
import org.osate.ge.businessObjectHandlers.GetIconIdContext;
import org.osate.ge.businessObjectHandlers.GetNameContext;
import org.osate.ge.businessObjectHandlers.IsApplicableContext;
import org.osate.ge.internal.model.BusinessObjectProxy;
import org.osate.ge.internal.util.AgeAadlUtil;

/**
 * Business object handler for {@link BusinessObjectProxy} which reference AADL packages. Used to allow providing an icon. In most cases,
 * proxies are resolved before use so other functions do not provide functionality.
 */
public class PackageProxyHandler implements BusinessObjectHandler {
	@Override
	public boolean isApplicable(final IsApplicableContext ctx) {
		return ctx.getBusinessObject(BusinessObjectProxy.class)
				.filter(p -> p.getEClass() == AgeAadlUtil.getAadl2Factory().getAadl2Package().getAadlPackage())
				.isPresent();
	}

	@Override
	public Optional<GraphicalConfiguration> getGraphicalConfiguration(final GetGraphicalConfigurationContext ctx) {
		return Optional.empty();
	}

	@Override
	public String getName(final GetNameContext ctx) {
		return ctx.getBusinessObject(BusinessObjectProxy.class).map(p -> "Package Proxy " + p.getName()).orElse("");
	}

	@Override
	public final Optional<String> getIconId(final GetIconIdContext ctx) {
		return ctx.getBusinessObject(BusinessObjectProxy.class).map(p -> AadlImages.getImage(p.getEClass()));
	}

}
