/**
 * Copyright (c) 2004-2024 Carnegie Mellon University and others. (see Contributors file).
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

import org.osate.aadl2.Connection;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.CanonicalBusinessObjectReference;
import org.osate.ge.GraphicalConfiguration;
import org.osate.ge.GraphicalConfigurationBuilder;
import org.osate.ge.RelativeBusinessObjectReference;
import org.osate.ge.aadl2.internal.model.AgePropertyValue;
import org.osate.ge.aadl2.internal.model.PropertyValueGroup;
import org.osate.ge.businessobjecthandling.BusinessObjectHandler;
import org.osate.ge.businessobjecthandling.GetGraphicalConfigurationContext;
import org.osate.ge.businessobjecthandling.GetNameContext;
import org.osate.ge.businessobjecthandling.IsApplicableContext;
import org.osate.ge.businessobjecthandling.ReferenceContext;
import org.osate.ge.graphics.Dimension;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.graphics.Point;
import org.osate.ge.graphics.PolyBuilder;
import org.osate.xtext.aadl2.properties.util.CommunicationProperties;

/**
 * {@link BusinessObjectHandler} implementation for Communication_Properties::Timing property values
 */
public class TimingPropertyValueHandler extends AadlBusinessObjectHandler {
	private static final String TIMING_PROPERTY_QUALIFIED_NAME = CommunicationProperties._NAME + "::" + CommunicationProperties.TIMING;

	private static final Graphic IMMEDIATE_GRAPHIC = PolyBuilder.create().
			polyline().
			points(
					new Point(0.5, 0.0), new Point(0.0, 0.5), new Point(0.5, 1.0), new Point(0.0, 0.5),
					new Point(0.5, 0.5), new Point(1.0, 0.0), new Point(0.5, 0.5), new Point(1.0, 1.0))
			.fixedSize(new Dimension(16.0, 12.0))
			.build();

	private static final Graphic DELAYED_GRAPHIC = PolyBuilder.create().
			polyline().
			points(
					new Point(0.0, 0.0), new Point(0.0, 1.0), new Point(0.0, 0.5), new Point(1.0, 0.5),
					new Point(1.0, 0.0), new Point(1.0, 1.0))
			.fixedSize(new Dimension(5.0, 20.0))
			.build();

	private final PropertyValueGroupHandler pvgBoh = new PropertyValueGroupHandler();

	@Override
	public boolean isApplicable(final IsApplicableContext ctx) {
		return ctx.getBusinessObject(PropertyValueGroup.class).filter(pvg -> getNamedValue(pvg) != null).isPresent();
	}

	@Override
	public CanonicalBusinessObjectReference getCanonicalReference(final ReferenceContext ctx) {
		return pvgBoh.getCanonicalReference(ctx);
	}

	@Override
	public RelativeBusinessObjectReference getRelativeReference(final ReferenceContext ctx) {
		return pvgBoh.getRelativeReference(ctx);
	}

	@Override
	public Optional<GraphicalConfiguration> getGraphicalConfiguration(final GetGraphicalConfigurationContext ctx) {
		final BusinessObjectContext boc = ctx.getBusinessObjectContext();
		final PropertyValueGroup pvg = boc.getBusinessObject(PropertyValueGroup.class).orElseThrow();

		final Object parentBo = boc.getParent() == null ? null : boc.getParent().getBusinessObject();

		// Use default property handler if the BO isn't a connection or connection reference.
		if(!(parentBo instanceof Connection || parentBo instanceof ConnectionReference)) {
			return pvgBoh.getGraphicalConfiguration(ctx);
		}

		final NamedValue namedValue = (NamedValue)pvg.getFirstValueBasedOnCompletelyProcessedAssociation().getValue();
		Graphic graphic = null;
		if(namedValue.getNamedValue() instanceof NamedElement) {
			final NamedElement ne = (NamedElement)namedValue.getNamedValue();
			if(CommunicationProperties.IMMEDIATE.equalsIgnoreCase(ne.getName())) {
				graphic = IMMEDIATE_GRAPHIC;
			} else if(CommunicationProperties.DELAYED.equalsIgnoreCase(ne.getName())) {
				graphic = DELAYED_GRAPHIC;
			}
		}

		if(graphic == null) {
			return Optional.empty();
		}

		return Optional.of(GraphicalConfigurationBuilder.create().
				graphic(graphic).
				build());
	}

	@Override
	public String getName(final GetNameContext ctx) {
		return pvgBoh.getName(ctx);
	}

	/**
	 * Returns whether the specified business object is an immediate timing property value group which will be handled by this handler
	 * @param bo is the business object to check
	 * @return whether the business object is an immediate timing property value.
	 */
	public static boolean isImmediateTimingProperty(final Object bo) {
		if (!(bo instanceof PropertyValueGroup)) {
			return false;
		}

		final PropertyValueGroup pvg = (PropertyValueGroup) bo;
		final NamedValue namedValue = getNamedValue(pvg);
		if (namedValue != null && namedValue.getNamedValue() instanceof NamedElement) {
			final NamedElement ne = (NamedElement) namedValue.getNamedValue();
			return CommunicationProperties.IMMEDIATE.equalsIgnoreCase(ne.getName());
		}

		return false;
	}

	/**
	 * Returns the {@link NamedValue} instance for a timing property value group.
	 * @param pvg the property value group for which to get the value
	 * @return the {@link NamedValue} instance for the timing property value group. Returns null if such a value is unavailable.
	 */
	private static NamedValue getNamedValue(final PropertyValueGroup pvg) {
		if (TIMING_PROPERTY_QUALIFIED_NAME.equalsIgnoreCase(pvg.getProperty().getQualifiedName())) {
			AgePropertyValue pv = pvg.getFirstValueBasedOnCompletelyProcessedAssociation();
			if (pv != null && pv.getValue() instanceof NamedValue) {
				return (NamedValue) pv.getValue();
			}
		}
		return null;
	}
}
