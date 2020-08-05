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
package org.osate.ge.aadl2.internal;

import java.util.Objects;
import java.util.Optional;

import org.osate.ge.BusinessObjectContext;
import org.osate.ge.CanonicalBusinessObjectReference;
import org.osate.ge.GraphicalConfiguration;
import org.osate.ge.GraphicalConfigurationBuilder;
import org.osate.ge.RelativeBusinessObjectReference;
import org.osate.ge.aadl2.internal.model.Tag;
import org.osate.ge.businessobjecthandling.GetGraphicalConfigurationContext;
import org.osate.ge.businessobjecthandling.GetNameContext;
import org.osate.ge.businessobjecthandling.GetNameForDiagramContext;
import org.osate.ge.businessobjecthandling.IsApplicableContext;
import org.osate.ge.businessobjecthandling.ReferenceContext;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.graphics.LabelBuilder;
import org.osate.ge.graphics.Point;
import org.osate.ge.graphics.PolyBuilder;

public class TagHandler extends AadlBusinessObjectHandler {
	private final Graphic defaultGraphic = LabelBuilder.create().build();
	private static final Graphic directionIndicator = PolyBuilder.create().polyline()
			.points(new Point(8.0, 6.0), new Point(0.0, 0.0), new Point(8.0, -6.0)).build();

	@Override
	public boolean isApplicable(final IsApplicableContext ctx) {
		return ctx.getBusinessObject(Tag.class).isPresent();
	}

	@Override
	public CanonicalBusinessObjectReference getCanonicalReference(final ReferenceContext ctx) {
		return null;
	}

	@Override
	public RelativeBusinessObjectReference getRelativeReference(final ReferenceContext ctx) {
		return new RelativeBusinessObjectReference(
				AadlReferenceUtil.TAG_KEY,
				ctx.getBusinessObject(Tag.class).get().key);
	}

	@Override
	public Optional<GraphicalConfiguration> getGraphicalConfiguration(final GetGraphicalConfigurationContext ctx) {
		final BusinessObjectContext boc = ctx.getBusinessObjectContext();
		final Tag tv = boc.getBusinessObject(Tag.class).get();
		final Graphic graphic;
		switch(tv.key) {
		case Tag.KEY_UNIDIRECTIONAL:
			// Don't show the directional indicator if there is a timing property value which is delayed or immediate
			for (final BusinessObjectContext sibling : boc.getParent().getChildren()) {
				if(TimingPropertyValueHandler.isImmediateTimingProperty(sibling.getBusinessObject())) {
					return Optional.empty();
				}
			}

			graphic = directionIndicator;
			break;

		default:
			graphic = defaultGraphic;
		}

		return Optional.of(GraphicalConfigurationBuilder.create().
				graphic(graphic).
				decoration().
				build());
	}

	@Override
	public String getName(final GetNameContext ctx) {
		return ctx.getBusinessObject(Tag.class).map(tv -> Objects.toString(tv.value, null))
				.map(n -> "Misc " + n)
				.orElse("");
	}

	@Override
	public String getNameForDiagram(final GetNameForDiagramContext ctx) {
		return ctx.getBusinessObjectContext().getBusinessObject(Tag.class).map(tv -> Objects.toString(tv.value, null))
				.orElse("");
	}
}
