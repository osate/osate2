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

import org.osate.aadl2.AbstractFeature;
import org.osate.aadl2.Access;
import org.osate.aadl2.AccessSpecification;
import org.osate.aadl2.AccessType;
import org.osate.aadl2.ArrayableElement;
import org.osate.aadl2.DirectedFeature;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.Element;
import org.osate.aadl2.EventDataSource;
import org.osate.aadl2.EventSource;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeaturePrototypeActual;
import org.osate.aadl2.FeaturePrototypeBinding;
import org.osate.aadl2.InternalFeature;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.PortSpecification;
import org.osate.aadl2.ProcessorFeature;
import org.osate.aadl2.PrototypeBinding;
import org.osate.aadl2.SubprogramProxy;
import org.osate.aadl2.modelsupport.util.ResolvePrototypeUtil;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.CanonicalBusinessObjectReference;
import org.osate.ge.DockingPosition;
import org.osate.ge.GraphicalConfiguration;
import org.osate.ge.GraphicalConfigurationBuilder;
import org.osate.ge.RelativeBusinessObjectReference;
import org.osate.ge.aadl2.internal.util.AadlArrayUtil;
import org.osate.ge.aadl2.internal.util.AadlFeatureUtil;
import org.osate.ge.aadl2.internal.util.AadlInheritanceUtil;
import org.osate.ge.aadl2.internal.util.AadlPrototypeUtil;
import org.osate.ge.aadl2.internal.util.AgeAadlUtil;
import org.osate.ge.businessobjecthandling.CanDeleteContext;
import org.osate.ge.businessobjecthandling.CanRenameContext;
import org.osate.ge.businessobjecthandling.GetGraphicalConfigurationContext;
import org.osate.ge.businessobjecthandling.GetNameContext;
import org.osate.ge.businessobjecthandling.IsApplicableContext;
import org.osate.ge.businessobjecthandling.ReferenceContext;
import org.osate.ge.graphics.Style;
import org.osate.ge.graphics.StyleBuilder;
import org.osate.ge.graphics.internal.FeatureGraphic;
import org.osate.ge.internal.services.impl.DeclarativeReferenceType;

public class FeatureHandler extends AadlBusinessObjectHandler {
	@Override
	public boolean isApplicable(final IsApplicableContext ctx) {
		return ctx.getBusinessObject(Feature.class).isPresent()
				|| ctx.getBusinessObject(InternalFeature.class).isPresent()
				|| ctx.getBusinessObject(ProcessorFeature.class).isPresent();
	}

	@Override
	public CanonicalBusinessObjectReference getCanonicalReference(final ReferenceContext ctx) {
		final Object bo = ctx.getBusinessObject();
		if (bo instanceof Feature) {
			return new CanonicalBusinessObjectReference(DeclarativeReferenceType.FEATURE.getId(),
					((Feature) bo).getQualifiedName());
		} else if (bo instanceof InternalFeature) {
			return new CanonicalBusinessObjectReference(DeclarativeReferenceType.INTERNAL_FEATURE.getId(),
					((InternalFeature) bo).getQualifiedName());
		} else if (bo instanceof ProcessorFeature) {
			return new CanonicalBusinessObjectReference(DeclarativeReferenceType.PROCESSOR_FEATURE.getId(),
					((ProcessorFeature) bo).getQualifiedName());
		}

		throw new RuntimeException("Unsupported business object " + bo);
	}

	@Override
	public RelativeBusinessObjectReference getRelativeReference(final ReferenceContext ctx) {
		final Object bo = ctx.getBusinessObject();
		if (bo instanceof Feature) {
			return AadlReferenceUtil.getFeatureRelativeReference(AgeAadlUtil.getRootName((Feature) bo));
		} else if (bo instanceof InternalFeature) {
			return AadlReferenceUtil.buildSimpleRelativeReference(DeclarativeReferenceType.INTERNAL_FEATURE
					.getId(),
					((InternalFeature) bo));
		} else if (bo instanceof ProcessorFeature) {
			return AadlReferenceUtil.buildSimpleRelativeReference(
					DeclarativeReferenceType.PROCESSOR_FEATURE.getId(),
					((ProcessorFeature) bo));
		}

		throw new RuntimeException("Unsupported business object " + bo);
	}

	@Override
	public boolean canDelete(final CanDeleteContext ctx) {
		return true;
	}

	@Override
	public Optional<GraphicalConfiguration> getGraphicalConfiguration(final GetGraphicalConfigurationContext ctx) {
		final BusinessObjectContext featureBoc = ctx.getBusinessObjectContext();
		final NamedElement feature = featureBoc.getBusinessObject(NamedElement.class).get();
		final FeatureGraphic graphic = getGraphicalRepresentation(feature, featureBoc);
		return Optional.of(GraphicalConfigurationBuilder.create().graphic(
				graphic)
				.annotation(AadlGraphics.getFeatureAnnotation(feature.eClass()))
				.style(StyleBuilder
						.create(AadlInheritanceUtil.isInherited(featureBoc) ? Styles.INHERITED_ELEMENT : Style.EMPTY)
						.backgroundColor(AadlGraphics.getDefaultBackgroundColor(graphic.featureType)).labelsAboveTop()
						.labelsLeft()
						.build())
				.defaultDockingPosition(getDefaultDockingPosition(feature, featureBoc)).build());
	}

	private FeatureGraphic getGraphicalRepresentation(NamedElement feature, BusinessObjectContext featureBoc) {
		// Check to see if it is a prototype feature
		if (feature instanceof AbstractFeature) {
			final AbstractFeature af = (AbstractFeature) feature;
			if (af.getFeaturePrototype() != null) {
				// Lookup the binding
				// Get the proper context (FeatureGroupType or ComponentClassifier) - May be indirectly for example from Subcomponent...
				final Element bindingContext = AadlPrototypeUtil.getPrototypeBindingContext(featureBoc);
				if (bindingContext != null) {
					final PrototypeBinding binding = ResolvePrototypeUtil
							.resolveFeaturePrototype(af.getFeaturePrototype(), bindingContext);
					if (binding instanceof FeaturePrototypeBinding) {
						FeaturePrototypeActual actual = ((FeaturePrototypeBinding) binding).getActual();
						if (actual instanceof PortSpecification) {
							final DirectionType direction = getDirection(actual, featureBoc);
							return AadlGraphics.getFeatureGraphic(((PortSpecification) actual).getCategory(),
									direction);
						} else if (actual instanceof AccessSpecification) {
							final DirectionType direction = getDirection(actual, featureBoc);
							return AadlGraphics.getFeatureGraphic(((AccessSpecification) actual).getCategory(),
									direction);
						}
					}
				}
			}
		}

		final DirectionType direction = getDirection(feature, featureBoc);
		return AadlGraphics.getFeatureGraphic(feature.eClass(), direction);
	}

	private DockingPosition getDefaultDockingPosition(NamedElement feature, BusinessObjectContext featureBoc) {
		final DirectionType direction = getDirection(feature, featureBoc);
		if (direction == DirectionType.IN) {
			return DockingPosition.LEFT;
		} else if (direction == DirectionType.OUT) {
			return DockingPosition.RIGHT;
		} else {
			return DockingPosition.ANY;
		}
	}

	/**
	 *
	 * @param feature a feature or feature specification
	 * @return
	 */
	private DirectionType getDirection(final Element feature, final BusinessObjectContext featureBoc) {
		DirectionType direction;
		if (feature instanceof DirectedFeature) {
			direction = ((DirectedFeature) feature).getDirection();
		} else if (feature instanceof PortSpecification) {
			direction = ((PortSpecification) feature).getDirection();
		} else if (feature instanceof Access) {
			direction = ((Access) feature).getKind() == AccessType.PROVIDES ? DirectionType.OUT : DirectionType.IN;
		} else if (feature instanceof AccessSpecification) {
			direction = ((AccessSpecification) feature).getKind() == AccessType.PROVIDES ? DirectionType.OUT
					: DirectionType.IN;
		} else if (feature instanceof EventSource || feature instanceof EventDataSource
				|| feature instanceof SubprogramProxy) {
			direction = DirectionType.IN;
		} else {
			direction = DirectionType.IN_OUT;
		}

		// Invert the feature as appropriate
		if (AadlFeatureUtil.isFeatureInverted(featureBoc)) {
			if (direction == DirectionType.IN) {
				direction = DirectionType.OUT;
			} else if (direction == DirectionType.OUT) {
				direction = DirectionType.IN;
			}
		}

		return direction;
	}

	@Override
	public String getName(final GetNameContext ctx) {
		return ctx.getBusinessObject(NamedElement.class).map(feature -> {
			String name = feature.getName() == null ? "" : feature.getName();

			if (feature instanceof ArrayableElement) {
				name += AadlArrayUtil.getDimensionUserString((ArrayableElement) feature);
			}

			return name;
		}).orElse("");

	}

	@Override
	public String getNameForRenaming(GetNameContext ctx) {
		return ctx.getBusinessObject(NamedElement.class).map(feature -> feature.getName())
				.orElse("");
	}

	@Override
	public boolean canRename(final CanRenameContext ctx) {
		return true;
	}
}
