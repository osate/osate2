/**
 * <copyright>
 * Copyright  2013 by Carnegie Mellon University, all rights reserved.
 * 
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/org/documents/epl-v10.html.
 * 
 * NO WARRANTY
 * 
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE ''DELIVERABLES'') ARE ON AN ''AS-IS'' BASIS.
 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
 * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
 * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
 * MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
 * APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.
 * 
 * Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
 * employees, and agents from all claims or demands made against them (and any related losses, expenses, or
 * attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
 * misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
 * assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
 * product liability, personal injury, death, damage to property, or violation of any laws or regulations.
 * 
 * Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 * </copyright>
 * 
 */
package org.osate.analysis.arinc653.helpers;


import java.util.List;

import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Property;
import org.osate.aadl2.impl.NamedElementImpl;
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
	public static List<PropertyExpression> getSlots (ComponentInstance ci)
	{
		PropertyExpression pe;
		loadProperties(ci);
		List<PropertyExpression> l = ((NamedElementImpl)ci).getPropertyValueList(partitionsSlotsProperty);
		return l;
	}
	
	/*
	 * Get the ARINC653::Slots_Allocation property
	 * from a processor. The argument must be a ComponentInstance that has
	 * is a kind of processor.
	 */
	public static List<PropertyExpression> getSlotsAllocation (ComponentInstance ci) 
	{
		PropertyExpression pe;
		loadProperties(ci);
		
		return ((NamedElementImpl)ci).getPropertyValueList(slotsAllocationProperty);
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
