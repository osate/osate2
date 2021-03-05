/**
 * Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file).
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

import org.osate.aadl2.DirectionType;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.ge.CanonicalBusinessObjectReference;
import org.osate.ge.DockingPosition;
import org.osate.ge.GraphicalConfiguration;
import org.osate.ge.GraphicalConfigurationBuilder;
import org.osate.ge.RelativeBusinessObjectReference;
import org.osate.ge.businessobjecthandling.GetGraphicalConfigurationContext;
import org.osate.ge.businessobjecthandling.GetNameContext;
import org.osate.ge.businessobjecthandling.IsApplicableContext;
import org.osate.ge.businessobjecthandling.ReferenceContext;
import org.osate.ge.graphics.StyleBuilder;
import org.osate.ge.graphics.internal.FeatureGraphic;

public class FeatureInstanceHandler extends AadlBusinessObjectHandler {
	@Override
	public boolean isApplicable(final IsApplicableContext ctx) {
		return ctx.getBusinessObject(FeatureInstance.class).isPresent();
	}

	@Override
	public CanonicalBusinessObjectReference getCanonicalReference(final ReferenceContext ctx) {
		final FeatureInstance bo = ctx.getBusinessObject(FeatureInstance.class).get();
		return new CanonicalBusinessObjectReference(AadlReferenceUtil.INSTANCE_ID,
				AadlReferenceUtil.FEATURE_INSTANCE_KEY, AadlReferenceUtil.getSystemInstanceKey(bo),
				bo.getInstanceObjectPath());
	}

	@Override
	public RelativeBusinessObjectReference getRelativeReference(final ReferenceContext ctx) {
		return new RelativeBusinessObjectReference(AadlReferenceUtil.INSTANCE_ID,
				AadlReferenceUtil.FEATURE_INSTANCE_KEY,
				ctx.getBusinessObject(FeatureInstance.class).get().getFullName());
	}

	@Override
	public Optional<GraphicalConfiguration> getGraphicalConfiguration(final GetGraphicalConfigurationContext ctx) {
		final FeatureInstance fi = ctx.getBusinessObjectContext().getBusinessObject(FeatureInstance.class).get();
		final FeatureGraphic graphic = getGraphicalRepresentation(fi);
		return Optional.of(GraphicalConfigurationBuilder.create().
				graphic(graphic).
				annotation(AadlGraphics.getFeatureAnnotation(fi.getFeature().eClass())).
				style(StyleBuilder.create().backgroundColor(AadlGraphics.getDefaultBackgroundColor(graphic.featureType))
						.labelsAboveTop().labelsLeft().build())
				.
				defaultDockingPosition(getDefaultDockingPosition(fi)).
				build());
	}

	private FeatureGraphic getGraphicalRepresentation(final FeatureInstance fi) {
		final DirectionType direction = getDirection(fi);
		return AadlGraphics.getFeatureGraphic(fi.getFeature().eClass(), direction);
	}

	private DockingPosition getDefaultDockingPosition(final FeatureInstance fi) {
		return getDirection(fi) == DirectionType.OUT ? DockingPosition.RIGHT : DockingPosition.LEFT;
	}

	@Override
	public String getName(final GetNameContext ctx) {
		return ctx.getBusinessObject(FeatureInstance.class).map(fi -> fi.getName())
				.orElse("");
	}

	private DirectionType getDirection(final FeatureInstance fi) {
		return fi.getDirection();
	}
}
