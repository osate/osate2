package org.osate.ge.internal.businessObjectHandlers;

import javax.inject.Named;

import org.osate.aadl2.Access;
import org.osate.aadl2.AccessType;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.ge.GraphicalConfiguration;
import org.osate.ge.GraphicalConfigurationBuilder;
import org.osate.ge.di.GetGraphicalConfiguration;
import org.osate.ge.di.GetName;
import org.osate.ge.di.IsApplicable;
import org.osate.ge.di.Names;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.graphics.Style;
import org.osate.ge.graphics.StyleBuilder;
import org.osate.ge.internal.DockingPosition;
import org.osate.ge.internal.graphics.AadlGraphics;

public class FeatureInstanceHandler {
	private static final Style style = StyleBuilder.create().labelsAboveTop().labelsLeft().build();

	@IsApplicable
	public boolean isApplicable(final @Named(Names.BUSINESS_OBJECT) FeatureInstance fi) {
		return true;
	}

	@GetGraphicalConfiguration
	public GraphicalConfiguration getGraphicalConfiguration(final @Named(Names.BUSINESS_OBJECT) FeatureInstance fi) {
		return GraphicalConfigurationBuilder.create().
				graphic(getGraphicalRepresentation(fi)).
				style(style).
				defaultDockingPosition(getDefaultDockingPosition(fi)).
				build();
	}

	private Graphic getGraphicalRepresentation(final FeatureInstance fi) {
		// Determine the direction of access feature instances using the type of the feature.
		// This is needed because as of 2016-12-09 access feature instances have a direction of IN OUT. The AccessType may not be reliable because it could be inverted
		// by being inside an inverse of feature group.
		// TODO: Fix when/if OSATE provides direction.
		final DirectionType direction;
		if(fi.getFeature() instanceof Access) {
			direction = ((Access)fi.getFeature()).getKind() == AccessType.PROVIDES ? DirectionType.OUT : DirectionType.IN;
		} else {
			direction = fi.getDirection();
		}
		return AadlGraphics.getFeatureGraphic(fi.getFeature().eClass(), direction);
	}

	private DockingPosition getDefaultDockingPosition(final FeatureInstance fi) {
		return fi.getDirection() == DirectionType.OUT ? DockingPosition.RIGHT : DockingPosition.LEFT;
	}

	@GetName
	public String getName(final @Named(Names.BUSINESS_OBJECT) FeatureInstance fi) {
		return fi.getName();
	}
}
