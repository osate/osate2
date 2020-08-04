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

import java.util.Optional;

import org.osate.ge.BusinessObjectContext;
import org.osate.ge.CanonicalBusinessObjectReference;
import org.osate.ge.GraphicalConfiguration;
import org.osate.ge.GraphicalConfigurationBuilder;
import org.osate.ge.RelativeBusinessObjectReference;
import org.osate.ge.aadl2.internal.aadlproperties.PropertyValueFormatter;
import org.osate.ge.aadl2.internal.model.PropertyValueGroup;
import org.osate.ge.businessobjecthandling.GetGraphicalConfigurationContext;
import org.osate.ge.businessobjecthandling.GetNameContext;
import org.osate.ge.businessobjecthandling.GetNameForDiagramContext;
import org.osate.ge.businessobjecthandling.IsApplicableContext;
import org.osate.ge.businessobjecthandling.ReferenceContext;
import org.osate.ge.graphics.ArrowBuilder;
import org.osate.ge.graphics.Color;
import org.osate.ge.graphics.ConnectionBuilder;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.graphics.LabelBuilder;
import org.osate.ge.graphics.Style;
import org.osate.ge.graphics.StyleBuilder;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.util.BusinessObjectContextUtil;

public class PropertyValueGroupHandler extends AadlBusinessObjectHandler {
	private final Graphic labelGraphic = LabelBuilder.create().build();
	private static final Graphic graphic = ConnectionBuilder.create().
			destinationTerminator(ArrowBuilder.create().filled().small().build()).
			build();
	private static final Style referenceStyle = StyleBuilder.create().backgroundColor(Color.BLACK).dashed().build();
	private static final Style abstractStyle = StyleBuilder.create().backgroundColor(Color.BLACK).dotted().build();

	@Override
	public boolean isApplicable(final IsApplicableContext ctx) {
		return ctx.getBusinessObject(PropertyValueGroup.class).isPresent();
	}

	@Override
	public CanonicalBusinessObjectReference getCanonicalReference(final ReferenceContext ctx) {
		return null;
	}

	@Override
	public RelativeBusinessObjectReference getRelativeReference(final ReferenceContext ctx) {
		final PropertyValueGroup pvg = ctx.getBusinessObject(PropertyValueGroup.class).get();
		final String propertyName = pvg.getProperty().getQualifiedName();
		if (propertyName == null) {
			throw new RuntimeException("Unable to build reference. Property name is null");
		}

		if (pvg.getReferenceId() == null) {
			return new RelativeBusinessObjectReference(
					AadlReferenceUtil.PROPERTY_VALUE_GROUP_KEY,
					propertyName);
		} else {
			return new RelativeBusinessObjectReference(
					AadlReferenceUtil.PROPERTY_VALUE_GROUP_KEY,
					propertyName, pvg.getReferenceId().toString());
		}
	}

	@Override
	public Optional<GraphicalConfiguration> getGraphicalConfiguration(final GetGraphicalConfigurationContext ctx) {
		final BusinessObjectContext boc = ctx.getBusinessObjectContext();
		final PropertyValueGroup pvg = boc.getBusinessObject(PropertyValueGroup.class).get();

		if(pvg.getReferenceId() == null) {
			return Optional.of(createTextGraphicalConfiguration());
		} else {
			// Try to get the referenced element
			final DiagramElement referencedElement = ctx.getDiagram().findElementById(pvg.getReferenceId());
			if(referencedElement == null) {
				return Optional.empty();
			}

			// If the reference is from the child to an ancestor or from an ancestor to a child, show it as text if it is is based on a completely processed
			// property association. Otherwise, don't show it at all.
			final BusinessObjectContext parent = boc.getParent();
			if (BusinessObjectContextUtil.isAncestor(parent, referencedElement)
					|| BusinessObjectContextUtil.isAncestor(referencedElement, parent)) {
				if (pvg.getFirstValueBasedOnCompletelyProcessedAssociation() == null) {
					return Optional.empty();
				} else {
					return Optional.of(createTextGraphicalConfiguration());
				}
			}

			return Optional.of(GraphicalConfigurationBuilder.create().
					graphic(graphic).style(pvg.isAbstract() ? abstractStyle : referenceStyle)
					.
					source(boc.getParent()).
					destination(referencedElement).
					build());
		}
	}

	private GraphicalConfiguration createTextGraphicalConfiguration() {
		return GraphicalConfigurationBuilder.create().
				graphic(labelGraphic).
				decoration().
				build();
	}

	@Override
	public String getNameForDiagram(final GetNameForDiagramContext ctx) {
		return ctx.getBusinessObjectContext().getBusinessObject(PropertyValueGroup.class).map(pvg -> {
			final boolean includeOnlyValuesBasedOnCompletelyProcessedAssociations = pvg.getReferenceId() == null;
			final boolean includeValues = pvg.getReferenceId() == null;
			return PropertyValueFormatter.getUserString(ctx.getBusinessObjectContext(),
					true,
					includeOnlyValuesBasedOnCompletelyProcessedAssociations, includeValues, false, false);
		}).orElse("");
	}

	@Override
	public String getName(GetNameContext ctx) {
		return "";
	}
}
