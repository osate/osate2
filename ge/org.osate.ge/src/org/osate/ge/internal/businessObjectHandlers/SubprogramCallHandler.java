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
package org.osate.ge.internal.businessObjectHandlers;

import java.util.Optional;

import javax.inject.Named;

import org.osate.aadl2.SubprogramCall;
import org.osate.aadl2.SubprogramCallSequence;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.GraphicalConfiguration;
import org.osate.ge.GraphicalConfigurationBuilder;
import org.osate.ge.aadl2.internal.AadlNamingUtil;
import org.osate.ge.businessObjectHandlers.BusinessObjectHandler;
import org.osate.ge.businessObjectHandlers.GetGraphicalConfigurationContext;
import org.osate.ge.businessObjectHandlers.IsApplicableContext;
import org.osate.ge.di.CanDelete;
import org.osate.ge.di.GetName;
import org.osate.ge.di.Names;
import org.osate.ge.di.ValidateName;
import org.osate.ge.graphics.EllipseBuilder;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.graphics.Style;
import org.osate.ge.graphics.StyleBuilder;
import org.osate.ge.services.QueryService;

public class SubprogramCallHandler implements BusinessObjectHandler {
	private Graphic graphic = EllipseBuilder.create().build();
	private Style style = StyleBuilder.create().dashed().labelsCenter().build();

	@Override
	public boolean isApplicable(final IsApplicableContext ctx) {
		return ctx.getBusinessObject(SubprogramCall.class).isPresent();
	}

	@Override
	public Optional<GraphicalConfiguration> getGraphicalConfiguration(final GetGraphicalConfigurationContext ctx) {
		return Optional.of(GraphicalConfigurationBuilder.create().graphic(graphic).style(style).build());
	}

	@GetName
	public String getName(final @Named(Names.BUSINESS_OBJECT) SubprogramCall call) {
		return call.getName();
	}

	@ValidateName
	public String validateName(final @Named(Names.BUSINESS_OBJECT) SubprogramCall call,
			final @Named(Names.NAME) String value) {
		return AadlNamingUtil.checkNameValidity(call, value);
	}

	@CanDelete
	public boolean canDelete(final @Named(Names.BUSINESS_OBJECT) SubprogramCall call,
			final @Named(Names.BUSINESS_OBJECT_CONTEXT) BusinessObjectContext boc, final QueryService queryService) {
		// Don't allow deleting the last subprogram call
		return call.eContainer() instanceof SubprogramCallSequence
				&& ((SubprogramCallSequence) call.eContainer()).getOwnedSubprogramCalls().size() > 1;
	}
}
