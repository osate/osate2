package org.osate.ge.internal.businessObjectHandlers;

import javax.inject.Named;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.ge.GraphicalConfiguration;
import org.osate.ge.GraphicalConfigurationBuilder;
import org.osate.ge.di.GetGraphicalConfiguration;
import org.osate.ge.di.GetName;
import org.osate.ge.di.IsApplicable;
import org.osate.ge.di.Names;
import org.osate.ge.internal.graphics.AadlGraphics;
import org.osate.ge.internal.labels.LabelConfiguration;
import org.osate.ge.internal.labels.LabelConfigurationBuilder;

public class ComponentInstanceHandler {	
	private static final LabelConfiguration labelConfiguration = LabelConfigurationBuilder.create().top().horizontalCenter().build();
	
	@IsApplicable
	public boolean isApplicable(final @Named(Names.BUSINESS_OBJECT) ComponentInstance ci) {
		return true;
	}
		
	@GetGraphicalConfiguration
	public GraphicalConfiguration getGraphicalConGraphic(final @Named(Names.BUSINESS_OBJECT) ComponentInstance ci) {
		return GraphicalConfigurationBuilder.create().
				graphic(AadlGraphics.getGraphic(ci.getComponentClassifier())).
				defaultLabelConfiguration(labelConfiguration).
				build();
	}	
	
	@GetName
	public String getName(final @Named(Names.BUSINESS_OBJECT) ComponentInstance ci) {
		return ci.getFullName();
	}
}
