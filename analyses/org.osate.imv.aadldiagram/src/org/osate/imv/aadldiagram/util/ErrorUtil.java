package org.osate.imv.aadldiagram.util;

import java.util.List;

import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.ComponentCategory;
import org.osate.xtext.aadl2.properties.util.GetProperties;

public class ErrorUtil {
	/*
	 * returns a factor between 0 and 100 which indicates
	 * the potential impact of a fault ocuring from the selected
	 * component.
	 */
	public static int getFactor (ComponentInstance source, ComponentInstance dest)
	{
		ComponentInstance 		boundProcessor;
		List<ComponentInstance> boundProcessors;

		System.out.println("source=" + source);
		System.out.println("dest  =" + dest);

		if ( (source == null) || (dest == null))
		{
			return -1;
		}
		
		if (source == dest)
		{
			return 99;
		}
		
		if ( (dest.getCategory() == ComponentCategory.DEVICE) && (source.getCategory() == ComponentCategory.PROCESSOR))
		{
			boundProcessors = GetProperties.getActualProcessorBinding(dest);
			if (boundProcessors.size() > 0)
			{
				boundProcessor = boundProcessors.get(0);
				if (boundProcessor == source)
				{
					return 50;
				}
			}
		}
		return -1;
	}
}
