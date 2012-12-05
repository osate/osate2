package org.osate.analysis.arinc653.helpers;


import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.properties.PropertyNotPresentException;
import org.osate.contribution.sei.names.ARINC653;
import org.osate.xtext.aadl2.properties.util.GetProperties;
import org.osate.xtext.aadl2.properties.util.PropertyUtils;



public class SchedulingSlotsHelper
{

	private static Property partitionsSlotsProperty = null;
	private static Property slotsAllocationProperty = null;
	private static Property moduleMajorFrameProperty = null;
	
	public static void loadProperties(NamedElement ph)
	{
		if (slotsAllocationProperty == null)
		{
			slotsAllocationProperty = GetProperties.lookupPropertyDefinition (ph, ARINC653._NAME, ARINC653.SLOTS_ALLOCATION);
		}
		
		if (partitionsSlotsProperty == null)
		{
			partitionsSlotsProperty = GetProperties.lookupPropertyDefinition (ph, ARINC653._NAME, ARINC653.PARTITION_SLOTS);
		}
		
		if (moduleMajorFrameProperty == null)
		{
			moduleMajorFrameProperty = GetProperties.lookupPropertyDefinition (ph, ARINC653._NAME, ARINC653.MODULE_MAJOR_FRAME);
		}
	}
	/*
	 * Get the ARINC653::Partitions_Slots property
	 * from a processor. The argument must be a ComponentInstance that has
	 * is a kind of processor.
	 */
	public static ListValue getSlots (ComponentInstance ci)
	{
		PropertyExpression pe;
		loadProperties(ci);
		
		pe = PropertyUtils.getSimplePropertyListValue(ci, partitionsSlotsProperty);
		if (pe instanceof ListValue)
		{
			ListValue list = (ListValue) pe;
			return list;
		}
		return null;
	}
	
	/*
	 * Get the ARINC653::Slots_Allocation property
	 * from a processor. The argument must be a ComponentInstance that has
	 * is a kind of processor.
	 */
	public static ListValue getSlotsAllocation (ComponentInstance ci) 
	{
		PropertyExpression pe;
		loadProperties(ci);
		
		pe = PropertyUtils.getSimplePropertyListValue(ci, slotsAllocationProperty);
		if (pe instanceof ListValue)
		{			
			ListValue list = (ListValue) pe;
			return list;
		}
		return null;
	}
	
	/*
	 * Get the ARINC653::Module_Major_Frame property
	 * from a processor component. The argument
	 * must be a ComponentInstance that is a processor.
	 */
	public static long getMajorFrame (ComponentInstance ci) 
	{
		PropertyExpression pv;
		long val;
		
		val = 0;
		
		loadProperties(ci);
		
		try
		{
			pv = ci.getSimplePropertyValue(moduleMajorFrameProperty);
		
				if (pv instanceof IntegerLiteral) 
				{
					val = ((IntegerLiteral) pv).getValue();
				}
		}
		catch (PropertyNotPresentException pnpe)
		{
			return 0;
		}
		return val;

	}
}
