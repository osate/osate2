package org.osate.ge.internal.businessObjectHandlers;

import java.awt.geom.Point2D;

import javax.inject.Named;

import org.osate.ge.GraphicalConfiguration;
import org.osate.ge.GraphicalConfigurationBuilder;
import org.osate.ge.di.GetGraphicalConfiguration;
import org.osate.ge.di.GetName;
import org.osate.ge.di.IsApplicable;
import org.osate.ge.di.Names;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.graphics.PolyBuilder;
import org.osate.ge.internal.graphics.LabelBuilder;
import org.osate.ge.internal.model.TaggedValue;

public class TaggedValueHandler {
	private final Graphic graphic = LabelBuilder.create().build();
	
	private static final Graphic altGraphic = PolyBuilder.create().polyline().points(
			new Point2D.Double(0.0, -10), 
			new Point2D.Double(10.0, 0.0), 
			new Point2D.Double(0, 10.0),
			
			new Point2D.Double(10.0, 0.0),
			new Point2D.Double(15.0, 0.0),
			
			new Point2D.Double(5.0, -10), 
			new Point2D.Double(15.0, 0.0), 
			new Point2D.Double(5, 10.0)
			
			).build();  // TODO: For testing
	
	@IsApplicable
	public boolean isApplicable(final @Named(Names.BUSINESS_OBJECT) TaggedValue tv) {
		return true;
	}
	
	@GetGraphicalConfiguration
	public GraphicalConfiguration getGraphicalConfiguration(final @Named(Names.BUSINESS_OBJECT) TaggedValue tv) {
		return GraphicalConfigurationBuilder.create().
				//graphic(graphic).
				graphic(tv.key.equals(TaggedValue.KEY_SUBCOMPONENT_TYPE) || tv.key.equals(TaggedValue.KEY_SUBPROGRAM_CALL_CALLED_SUBPROGRAM) ? graphic : altGraphic).
				decoration().
				build();
	}
	
	@GetName
	public String getName(final @Named(Names.BUSINESS_OBJECT) TaggedValue tv) {
		return tv.value;
	}
}
