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

import javax.inject.Named;

import org.osate.aadl2.Connection;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.GraphicalConfiguration;
import org.osate.ge.GraphicalConfigurationBuilder;
import org.osate.ge.di.GetGraphicalConfiguration;
import org.osate.ge.di.GetName;
import org.osate.ge.di.IsApplicable;
import org.osate.ge.di.Names;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.graphics.Point;
import org.osate.ge.graphics.PolyBuilder;
import org.osate.ge.internal.AgeDiagramProvider;
import org.osate.ge.internal.model.AgePropertyValue;
import org.osate.ge.internal.model.PropertyValueGroup;
import org.osate.ge.services.QueryService;
import org.osate.xtext.aadl2.properties.util.CommunicationProperties;
public class TimingPropertyValueHandler {
	private static final String qualifiedTimingPropertyName = CommunicationProperties._NAME + "::" + CommunicationProperties.TIMING;

	private static final Graphic immediateGraphic = PolyBuilder.create().
			polyline().
			points(
					new Point(8.0, -6), new Point(0.0, 0.0), new Point(8.0, 6.0),

					new Point(0.0, 0.0), new Point(8.0, 0.0),

					new Point(16.0, -6), new Point(8.0, 0.0), new Point(16.0, 6.0))
			.build();

	private static final Graphic delayedGraphic = PolyBuilder.create().
			polyline().
			points(
					new Point(0.0, -10), new Point(0.0, 10.0),

					new Point(0.0, 0.0), new Point(5.0, 0.0),

					new Point(5.0, -10), new Point(5.0, 10.0))
			.build();

	private final PropertyValueGroupHandler fallbackBoh = new PropertyValueGroupHandler();

	@IsApplicable
	public boolean isApplicable(final @Named(Names.BUSINESS_OBJECT) PropertyValueGroup pvg) {
		if (qualifiedTimingPropertyName.equalsIgnoreCase(pvg.getProperty().getQualifiedName())) {
			AgePropertyValue pv = pvg.getFirstValueBasedOnCompletelyProcessedAssociation();
			if(pv != null && pv.getValue() instanceof NamedValue) {
				return true;
			}
		}

		return false;
	}

	public static boolean isImmediateTimingProperty(final Object bo) {
		if(!(bo instanceof PropertyValueGroup)) {
			return false;
		}

		final PropertyValueGroup pvg = (PropertyValueGroup)bo;
		if(qualifiedTimingPropertyName.equalsIgnoreCase(pvg.getProperty().getQualifiedName())) {
			AgePropertyValue pv = pvg.getFirstValueBasedOnCompletelyProcessedAssociation();
			if(pv != null && pv.getValue() instanceof NamedValue) {
				final NamedValue namedValue = (NamedValue)pv.getValue();
				if(namedValue.getNamedValue() instanceof NamedElement) {
					final NamedElement ne = (NamedElement)namedValue.getNamedValue();
					return CommunicationProperties.IMMEDIATE.equalsIgnoreCase(ne.getName());
				}
			}
		}

		return false;
	}

	@GetGraphicalConfiguration
	public GraphicalConfiguration getGraphicalConfiguration(final @Named(Names.BUSINESS_OBJECT_CONTEXT) BusinessObjectContext boc,
			final @Named(Names.BUSINESS_OBJECT) PropertyValueGroup pvg,
			final QueryService queryService,
			final AgeDiagramProvider diagramProvider) {
		final Object parentBo = boc.getParent() == null ? null : boc.getParent().getBusinessObject();

		// Use default property handler if the BO isn't a connection or connection reference.
		if(!(parentBo instanceof Connection || parentBo instanceof ConnectionReference)) {
			return fallbackBoh.getGraphicalConfiguration(boc, pvg, diagramProvider);
		}

		final NamedValue namedValue = (NamedValue)pvg.getFirstValueBasedOnCompletelyProcessedAssociation().getValue();
		Graphic graphic = null;
		if(namedValue.getNamedValue() instanceof NamedElement) {
			final NamedElement ne = (NamedElement)namedValue.getNamedValue();
			if(CommunicationProperties.IMMEDIATE.equalsIgnoreCase(ne.getName())) {
				graphic = immediateGraphic;
			} else if(CommunicationProperties.DELAYED.equalsIgnoreCase(ne.getName())) {
				graphic = delayedGraphic;
			}
		}

		if(graphic == null) {
			return null;
		}

		return GraphicalConfigurationBuilder.create().
				graphic(graphic).
				decoration().
				build();
	}

	@GetName
	public String getName(final @Named(Names.BUSINESS_OBJECT_CONTEXT) BusinessObjectContext boc,
			final @Named(Names.BUSINESS_OBJECT) PropertyValueGroup pvg,
			final QueryService queryService) {
		// Only used for the fallback handler
		return fallbackBoh.getName(boc, pvg, queryService);
	}
}
