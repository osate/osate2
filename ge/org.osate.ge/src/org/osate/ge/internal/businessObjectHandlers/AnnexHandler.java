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

import org.osate.aadl2.DefaultAnnexLibrary;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.aadl2.NamedElement;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.GraphicalConfiguration;
import org.osate.ge.GraphicalConfigurationBuilder;
import org.osate.ge.businessObjectHandlers.GetGraphicalConfigurationContext;
import org.osate.ge.businessObjectHandlers.GetNameContext;
import org.osate.ge.businessObjectHandlers.IsApplicableContext;
import org.osate.ge.di.CanDelete;
import org.osate.ge.di.Names;
import org.osate.ge.graphics.StyleBuilder;
import org.osate.ge.graphics.internal.FolderGraphicBuilder;
import org.osate.ge.query.StandaloneQuery;
import org.osate.ge.services.QueryService;

public class AnnexHandler extends AadlBusinessObjectHandler {
	private static final StandaloneQuery parentQuery = StandaloneQuery.create((root) -> root.ancestors().first());
	private static final GraphicalConfiguration graphicalConfig = GraphicalConfigurationBuilder.create().
			graphic(FolderGraphicBuilder.create().build())
			.style(StyleBuilder.create().labelsCenter().build()).
			build();

	@Override
	public boolean isApplicable(final IsApplicableContext ctx) {
		return ctx.getBusinessObject(DefaultAnnexLibrary.class).isPresent()
				|| ctx.getBusinessObject(DefaultAnnexSubclause.class).isPresent();
	}

	@CanDelete
	public boolean isApplicable(final @Named(Names.BUSINESS_OBJECT) DefaultAnnexLibrary bo) {
		return true;
	}

	@CanDelete
	public boolean isApplicable(final @Named(Names.BUSINESS_OBJECT) DefaultAnnexSubclause bo) {
		return true;
	}

	@CanDelete
	public boolean canDelete(final @Named(Names.BUSINESS_OBJECT) DefaultAnnexSubclause bo,
			final @Named(Names.BUSINESS_OBJECT_CONTEXT) BusinessObjectContext boc, final QueryService queryService) {
		return bo.getContainingClassifier() == queryService.getFirstBusinessObject(parentQuery, boc);
	}

	@Override
	public Optional<GraphicalConfiguration> getGraphicalConfiguration(final GetGraphicalConfigurationContext ctx) {
		return Optional.of(graphicalConfig);
	}

	@Override
	public String getName(final GetNameContext ctx) {
		return ctx.getBusinessObject(NamedElement.class)
				.map(annex -> "{**" + annex.getName() + "**}").orElse("");
	}
}
