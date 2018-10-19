package org.osate.ge.internal.businessObjectHandlers;

import javax.inject.Named;

import org.osate.aadl2.instance.ModeInstance;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.GraphicalConfiguration;
import org.osate.ge.GraphicalConfigurationBuilder;
import org.osate.ge.di.GetGraphicalConfiguration;
import org.osate.ge.di.GetName;
import org.osate.ge.di.IsApplicable;
import org.osate.ge.di.Names;
import org.osate.ge.graphics.Style;
import org.osate.ge.graphics.StyleBuilder;
import org.osate.ge.internal.graphics.AadlGraphics;
import org.osate.ge.internal.util.AadlInheritanceUtil;

public class ModeInstanceHandler {
	@IsApplicable
	public boolean isApplicable(final @Named(Names.BUSINESS_OBJECT) ModeInstance mi) {
		return true;
	}

	@GetGraphicalConfiguration
	public GraphicalConfiguration getGraphicalConfiguration(final @Named(Names.BUSINESS_OBJECT) ModeInstance mi,
			final @Named(Names.BUSINESS_OBJECT_CONTEXT) BusinessObjectContext boc) {
		return GraphicalConfigurationBuilder.create()
				.graphic(AadlGraphics.getModeGraphic(mi.getMode()))
				.style(StyleBuilder
						.create(AadlInheritanceUtil.isInherited(boc) ? Styles.INHERITED_ELEMENT : Style.EMPTY)
						.labelsCenter().build())
				.build();
	}

	@GetName
	public String getName(final @Named(Names.BUSINESS_OBJECT) ModeInstance mi) {
		return mi.getName();
	}
}
