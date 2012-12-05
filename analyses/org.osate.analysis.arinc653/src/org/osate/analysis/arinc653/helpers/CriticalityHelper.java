package org.osate.analysis.arinc653.helpers;


import java.util.List;

import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.Element;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Property;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.properties.PropertyLookupException;
import org.osate.contribution.sei.names.ARINC653;
import org.osate.xtext.aadl2.properties.util.GetProperties;
import org.osate.xtext.aadl2.properties.util.PropertyUtils;



public class CriticalityHelper
{

	private static Property criticalityProperty = null;
	
	public static final int LEVEL_A 		= 0;
	public static final int LEVEL_B 		= 1;
	public static final int LEVEL_C 		= 2;
	public static final int LEVEL_D 		= 3;
	public static final int LEVEL_E 		= 4;
	public static final int LEVEL_UNKNOWN 	= 5;
	public static final int LEVEL_INVALID 	= 5;
	
	public static int getCriticalityForProcess (ComponentInstance process)
	{
		List<ComponentInstance> cpus;
		ComponentInstance proc;
		int crit;
		
		cpus = GetProperties.getActualProcessorBinding(process);
		if (cpus.size() != 1)
		{
			System.out.println("[CriticalityHelper] Error, more than one virtual processor bound");
			return LEVEL_UNKNOWN;
		}
		
		proc =  cpus.get(0);
		crit = getCriticality (proc.getSubcomponent());
		//System.out.println("[CriticalityHelper] Found criticality for process " + process + " (processor="+cpus.get(0)+") =" + crit);
		return crit;
	}
	
	
	public static int getNbPartitionsForCriticalityLevel (ComponentInstance processor, int level)
	{
		int nb;
		nb = 0;
		ComponentInstance subcomponent;
		for (Element sub : processor.getChildren())
		{
			if (sub instanceof ComponentInstance)
			{
				subcomponent = (ComponentInstance) sub;

				if (subcomponent.getCategory() == ComponentCategory.VIRTUAL_PROCESSOR)
				{
					//System.out.println ("subc=" + subcomponent);

					if (CriticalityHelper.getCriticality(subcomponent.getSubcomponent())== level)
					{
						nb = nb + 1;
					}
				}
			}
		}
		return nb;
	}
	
	
	public static int getCriticality(final NamedElement ph) 
	{
	
		if (criticalityProperty == null)
		{
			criticalityProperty = GetProperties.lookupPropertyDefinition (ph, ARINC653._NAME, ARINC653.CRITICALITY);
		}
		
		
		try
		{
			EnumerationLiteral el = PropertyUtils.getEnumLiteral(ph, criticalityProperty);
			//System.out.println ("[CriticalityHelper] criticality=" + el);
			if (el.getName().equals(ARINC653.CRITICALITY_LEVEL_A))
			{
				return LEVEL_A;
			}
			
			if (el.getName().equals(ARINC653.CRITICALITY_LEVEL_B))
			{
				return LEVEL_B;
			}
			
			if (el.getName().equals(ARINC653.CRITICALITY_LEVEL_C))
			{
				return LEVEL_C;
			}
			
			if (el.getName().equals(ARINC653.CRITICALITY_LEVEL_D))
			{
				return LEVEL_D;
			}
			
			if (el.getName().equals(ARINC653.CRITICALITY_LEVEL_E))
			{
				return LEVEL_E;
			}

		}
		catch (PropertyLookupException e)
		{	
			System.out.println ("[CriticalityHelper] Property not defined on " + ph);
			return LEVEL_INVALID;
		}
		
		return LEVEL_INVALID;
	}
	
	public static String getStringFromCode (int c)
	{
		switch (c)
		{
			case LEVEL_A:
			{
				return "A";
			}
			case LEVEL_B:
			{
				return "B";
			}
			case LEVEL_C:
			{
				return "C";
			}
			case LEVEL_D:
			{
				return "D";
			}
			case LEVEL_E:
			{
				return "E";
			}
			default:
			{
				return "unknown";
			}
		}
	}
	
}
