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

import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.Subcomponent;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.CanonicalBusinessObjectReference;
import org.osate.ge.GraphicalConfiguration;
import org.osate.ge.GraphicalConfigurationBuilder;
import org.osate.ge.RelativeBusinessObjectReference;
import org.osate.ge.businessObjectHandlers.CanDeleteContext;
import org.osate.ge.businessObjectHandlers.CanRenameContext;
import org.osate.ge.businessObjectHandlers.GetGraphicalConfigurationContext;
import org.osate.ge.businessObjectHandlers.GetNameContext;
import org.osate.ge.businessObjectHandlers.IsApplicableContext;
import org.osate.ge.businessObjectHandlers.ReferenceContext;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.graphics.Style;
import org.osate.ge.graphics.StyleBuilder;
import org.osate.ge.internal.services.impl.DeclarativeReferenceType;
import org.osate.ge.internal.util.AadlArrayUtil;
import org.osate.ge.internal.util.AadlInheritanceUtil;
import org.osate.ge.internal.util.AadlSubcomponentUtil;

public class SubcomponentHandler extends AadlBusinessObjectHandler {
	@Override
	public boolean isApplicable(final IsApplicableContext ctx) {
		return ctx.getBusinessObject(Subcomponent.class).isPresent();
	}

	@Override
	public CanonicalBusinessObjectReference getCanonicalReference(final ReferenceContext ctx) {
		return new CanonicalBusinessObjectReference(
				DeclarativeReferenceType.SUBCOMPONENT
						.getId(),
				ctx.getBusinessObject(Subcomponent.class).get().getQualifiedName());
	}

	@Override
	public RelativeBusinessObjectReference getRelativeReference(final ReferenceContext ctx) {
		return AadlReferenceUtil
				.getSubcomponentRelativeReference(ctx.getBusinessObject(Subcomponent.class).get().getName());
	}

	@Override
	public boolean canDelete(final CanDeleteContext ctx) {
		return true;
	}

	@Override
	public Optional<GraphicalConfiguration> getGraphicalConfiguration(final GetGraphicalConfigurationContext ctx) {
		final BusinessObjectContext scBoc = ctx.getBusinessObjectContext();
		final Subcomponent sc = scBoc.getBusinessObject(Subcomponent.class).get();
		return Optional.of(GraphicalConfigurationBuilder.create().
				graphic(getGraphicalRepresentation(sc, scBoc)).
				style(StyleBuilder.create(
						AadlInheritanceUtil.isInherited(scBoc) ? Styles.INHERITED_ELEMENT : Style.EMPTY,
								getClassifierStyle(sc, scBoc))
						.labelsTop().labelsHorizontalCenter()
						.build())
				.
				build());
	}

	private Graphic getGraphicalRepresentation(final Subcomponent sc,
			final BusinessObjectContext scBoc) {
		final ComponentClassifier cc = AadlSubcomponentUtil.getComponentClassifier(scBoc, sc);
		if(cc == null) {
			return AadlGraphics.getGraphic(sc.getCategory());
		} else {
			return AadlGraphics.getGraphic(cc);
		}
	}

	private Style getClassifierStyle(final Subcomponent sc, final BusinessObjectContext scBoc) {
		final ComponentClassifier cc = AadlSubcomponentUtil.getComponentClassifier(scBoc, sc);
		if (cc == null) {
			return AadlGraphics.getStyle(sc.getCategory(), false);
		} else {
			return AadlGraphics.getStyle(cc);
		}
	}

	// Labels
	@Override
	public String getName(final GetNameContext ctx) {
		return ctx.getBusinessObject(
				Subcomponent.class)
				.map(sc -> getSubcomponentName(sc) + AadlArrayUtil.getDimensionUserString(sc)).orElse("");
	}

	@Override
	public String getNameForRenaming(final GetNameContext ctx) {
		return ctx.getBusinessObject(Subcomponent.class)
				.map(this::getSubcomponentName)
				.orElse("");
	}

	private String getSubcomponentName(final Subcomponent sc) {
		return sc.getName() == null ? "" : sc.getName();
	}

	@Override
	public boolean canRename(final CanRenameContext ctx) {
		return true;
	}
}
