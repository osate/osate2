package org.osate.ge.internal.businessObjectHandlers;

import javax.inject.Named;

import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.ge.GraphicalConfiguration;
import org.osate.ge.GraphicalConfigurationBuilder;
import org.osate.ge.di.GetGraphicalConfiguration;
import org.osate.ge.di.GetName;
import org.osate.ge.di.IsApplicable;
import org.osate.ge.di.Names;
import org.osate.ge.internal.graphics.AadlGraphics;

public class ComponentInstanceHandler {
	@IsApplicable
	public boolean isApplicable(final @Named(Names.BUSINESS_OBJECT) ComponentInstance ci) {
		return true;
	}

	@GetGraphicalConfiguration
	public GraphicalConfiguration getGraphicalConGraphic(final @Named(Names.BUSINESS_OBJECT) ComponentInstance ci) {
		return GraphicalConfigurationBuilder.create().
				graphic(AadlGraphics.getGraphic(ci.getCategory()))
				.
				style(AadlGraphics.getStyle(ci.getCategory(),
						ci.getComponentClassifier() instanceof ComponentImplementation))
				.
				build();
	}

	@GetName
	public String getName(final @Named(Names.BUSINESS_OBJECT) ComponentInstance ci) {
		return ci.getFullName();
	}
}
