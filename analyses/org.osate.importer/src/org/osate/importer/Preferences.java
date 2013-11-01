/*
 * Copyright 2013 Carnegie Mellon University

 * Any opinions, findings and conclusions or recommendations expressed in this 
 * Material are those of the author(s) and do not necessarily reflect the 
 * views of the United States Department of Defense. 

 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING 
 * INSTITUTE MATERIAL IS FURNISHED ON AN �AS-IS� BASIS. CARNEGIE MELLON 
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
 * Carnegie Mellon� is registered in the U.S. Patent and Trademark 
 * Office by Carnegie Mellon University. 
 * 
 */

package org.osate.importer;

import org.osate.aadl2.util.OsateDebug;

public class Preferences {

	public static final int WEIGHT_BOOLEAN 		= 0;
	public static final int WEIGHT_REFINED 		= 1;
	
	public static final int DEPENDENCY_SUM 		= 0;
	public static final int DEPENDENCY_AVER 	= 1;
	public static final int DEPENDENCY_MAX 		= 2;
	
	public static final int MAPPING_SUBPROGRAM  = 0;
	public static final int MAPPING_THREAD      = 1;
	public static final int MAPPING_PROCESS     = 2;
	
	private static int 		weightMethod 			= WEIGHT_BOOLEAN;
	private static int 		dependencyMethod 		= DEPENDENCY_SUM;
	private static String 	invalidSystems	 		= "";
	private static String 	packagePrefix	 		= "";
	private static boolean 	useArinc 				= false;
	private static int 		ignoreHierarchyLevel 	= 0;
	private static int		mappingComponent 		= MAPPING_SUBPROGRAM;
	private static boolean	simulinkGrouping		= false;
	
	public static int getWeightMethod ()
	{
		return weightMethod;
	}
	
	public static boolean getSimulinkGrouping ()
	{
		return simulinkGrouping;
	}
	
	public static boolean shouldGroupSimulinkBlocks ()
	{
		return simulinkGrouping;
	}
	
	public static void setSimulinkGrouping (boolean b)
	{
		simulinkGrouping = b;
	}
	
	public static void setPackagePrefix (String s)
	{
		packagePrefix = s;
	}
	
	public static String getPackagePrefix ()
	{
		return packagePrefix;
	}
	
	public static void enableArinc ()
	{
		useArinc = true;
	}
	
	
	public static void disableArinc ()
	{
		useArinc = false;
	}
	
	public static boolean useArinc ()
	{
		return useArinc;
	}
	
	public static void setWeightMethod (int wm)
	{
		System.out.println ("Weight method=" + wm);
		weightMethod = wm;
	}
	
	public static int getParallelDependencyMethod ()
	{
		return dependencyMethod;
	}
	
	public static void setParallelDependencyMethod (int d)
	{
		System.out.println ("[VDID Preferences] Parallel method=" + d);
		dependencyMethod = d;
	}
	
	public static void setInvalidSystems (String str)
	{
		System.out.println ("[VDID Preferences] set invalid system string to" + str);
		invalidSystems = str;
	}
	
	public static String[] getInvalidSystems ()
	{
		
		return invalidSystems.split (",");
	}
	
	
	public static boolean isNameInvalid (String systemName)
	{
		String[] invalidNames = getInvalidSystems();

		if (invalidNames[0].length() == 0)
		{
			return false;
		}
		
		for (int i = 0 ; i < invalidNames.length ; i++)
		{
			//System.out.println ("[VDID Preferences] Invalid name=" + invalidNames[i]);

			if (systemName.toLowerCase().contains(invalidNames[i].toLowerCase()))
			{
				//System.out.println ("[VDID Preferences] Invalid system=" + systemName);

				return true;
			}
			
		}
		return false;
	}

	
	public static int getIgnoreHierarchyLevel ()
	{
		return ignoreHierarchyLevel;
	}
	
	public static void setIgnoreHierarchy(String text)
	{
		try
		{
			ignoreHierarchyLevel = Integer.parseInt(text);
		}
		catch (NumberFormatException nfe)
		{
			ignoreHierarchyLevel = 0;
		}
	}
	
	public static boolean mapSubprogram ()
	{
		return (mappingComponent == MAPPING_SUBPROGRAM);
	}
	
	public static boolean mapThread ()
	{
		return ((mappingComponent == MAPPING_SUBPROGRAM) || (mappingComponent == MAPPING_THREAD));
	}
	
	public static boolean mapProcess ()
	{
		return ((mappingComponent == MAPPING_PROCESS) || (mappingComponent == MAPPING_THREAD) || (mappingComponent == MAPPING_SUBPROGRAM));
	}
	
	public static void setMappingComponent (int i)
	{
		OsateDebug.osateDebug("[Preferences] set mapping component to" + i);
		mappingComponent = i;
	}
	
	public static int getMappingComponent ()
	{
		return mappingComponent;
	}
}
