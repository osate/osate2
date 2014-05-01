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
			criticalityProperty = GetProperties.lookupPropertyDefinition (ph, ARINC653._NAME, ARINC653.DAL);
		}
		
		
		try
		{
			EnumerationLiteral el = PropertyUtils.getEnumLiteral(ph, criticalityProperty);
			//System.out.println ("[CriticalityHelper] criticality=" + el);
			if (el.getName().equals(ARINC653.DAL_LEVEL_A))
			{
				return LEVEL_A;
			}
			
			if (el.getName().equals(ARINC653.DAL_LEVEL_B))
			{
				return LEVEL_B;
			}
			
			if (el.getName().equals(ARINC653.DAL_LEVEL_C))
			{
				return LEVEL_C;
			}
			
			if (el.getName().equals(ARINC653.DAL_LEVEL_D))
			{
				return LEVEL_D;
			}
			
			if (el.getName().equals(ARINC653.DAL_LEVEL_E))
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
