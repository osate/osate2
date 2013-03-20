/*
 * Copyright 2013 Carnegie Mellon University
 * 
 * The AADL/DSM Bridge (org.osate.importer.lattix ) (the “Content” or “Material”) 
 * is based upon work funded and supported by the Department of Defense under 
 * Contract No. FA8721-05-C-0003 with Carnegie Mellon University for the operation 
 * of the Software Engineering Institute, a federally funded research and development 
 * center.

 * Any opinions, findings and conclusions or recommendations expressed in this 
 * Material are those of the author(s) and do not necessarily reflect the 
 * views of the United States Department of Defense. 

 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING 
 * INSTITUTE MATERIAL IS FURNISHED ON AN “AS-IS” BASIS. CARNEGIE MELLON 
 * UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, 
 * AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR 
 * PURPOSE OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF 
 * THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT MAKE ANY WARRANTY OF 
 * ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT 
 * INFRINGEMENT.
 * 
 * This Material has been approved for public release and unlimited 
 * distribution except as restricted below. 
 * 
 * This Material is provided to you under the terms and conditions of the 
 * Eclipse Public License Version 1.0 ("EPL"). A copy of the EPL is 
 * provided with this Content and is also available at 
 * http://www.eclipse.org/legal/epl-v10.html.
 * 
 * Carnegie Mellon® is registered in the U.S. Patent and Trademark 
 * Office by Carnegie Mellon University. 
 * 
 * DM-0000232
 * 
 */

package org.osate.importer.lattix.vdid;

import java.util.List;

import org.osate.aadl2.Element;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.importer.lattix.properties.InspectProperty;


public class Utils {

	public static String getComponentName (ComponentInstance ci)
	{
		if (ci.getContainingComponentInstance() != null)
		{
			return getComponentName(ci.getContainingComponentInstance()).toLowerCase() + "." + ci.getName().toLowerCase();
		}
		else
		{
			return ci.getName().toLowerCase();
		}
		
	}
	
	public static boolean shallAnalyze (ComponentInstance ci)
	{
		if (ci.getContainingComponentInstance() != null)
		{
			if (InspectProperty.shallInspect(ci.getContainingComponentInstance()))
			{
				return true;
			}
			
			if (ci.getContainingComponentInstance() == ci.getSystemInstance())
			{
				return true;
			}
		}
		else
		{
			return true;
		}
		return false;
	}
	
	
	public static void listComponents (ComponentInstance si, List<ComponentInstance> componentList)
	{

		for (Element c : si.getChildren())
		{
			if (c instanceof ComponentInstance)
			{
		
				ComponentInstance ci = (ComponentInstance) c;
				
				if (InspectProperty.shallInspect(ci))
				{
					listComponents(ci, componentList);
				}
				else
				{
					componentList.add(ci);
				}
			}
		}
	}
	
	public static void listComponentsNames (ComponentInstance si, List<String> componentList)
	{

		for (Element c : si.getChildren())
		{
			if (c instanceof ComponentInstance)
			{
		
				ComponentInstance ci = (ComponentInstance) c;
				
				if (InspectProperty.shallInspect(ci))
				{
					listComponentsNames(ci, componentList);
				}
				else
				{
					String componentName = Utils.getComponentName(ci);
					System.out.println (componentName);
					componentList.add(componentName);
				}
			}
		}
	}
}
