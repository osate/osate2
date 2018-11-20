package org.osate.ge.internal.businessObjectHandlers;

import java.util.Objects;

import javax.inject.Named;

import org.osate.ge.BusinessObjectContext;
import org.osate.ge.GraphicalConfiguration;
import org.osate.ge.GraphicalConfigurationBuilder;
import org.osate.ge.di.GetGraphicalConfiguration;
import org.osate.ge.di.GetName;
import org.osate.ge.di.IsApplicable;
import org.osate.ge.di.Names;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.graphics.LabelBuilder;
import org.osate.ge.graphics.Point;
import org.osate.ge.graphics.PolyBuilder;
import org.osate.ge.internal.model.Tag;
import org.osate.ge.internal.query.Queryable;

public class TagHandler {
	private final Graphic defaultGraphic = LabelBuilder.create().build();
	private static final Graphic directionIndicator = PolyBuilder.create().polyline()
			.points(new Point(8.0, 6.0), new Point(0.0, 0.0), new Point(8.0, -6.0)).build();

	@IsApplicable
	public boolean isApplicable(final @Named(Names.BUSINESS_OBJECT) Tag tv) {
		return true;
	}

	@GetGraphicalConfiguration
	public GraphicalConfiguration getGraphicalConfiguration(final @Named(Names.BUSINESS_OBJECT_CONTEXT) BusinessObjectContext boc,
			final @Named(Names.BUSINESS_OBJECT) Tag tv) {
		final Graphic graphic;
		switch(tv.key) {
		case Tag.KEY_UNIDIRECTIONAL:
			// Don't show the directional indicator if there is a timing property value which is delayed or immediate
			for(final Queryable sibling : boc.getParent().getChildren()) {
				if(TimingPropertyValueHandler.isImmediateTimingProperty(sibling.getBusinessObject())) {
					return null;
				}
			}

			graphic = directionIndicator;
			break;

		default:
			graphic = defaultGraphic;
		}

		return GraphicalConfigurationBuilder.create().
				graphic(graphic).
				decoration().
				build();
	}

	@GetName
	public String getName(final @Named(Names.BUSINESS_OBJECT) Tag tv) {
		return Objects.toString(tv.value, null);
	}
}
