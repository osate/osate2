package org.osate.analysis.arinc653.helpers;

import org.osate.aadl2.Element;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.ReferenceValue;
import org.osate.aadl2.VirtualProcessorSubcomponent;
import org.osate.aadl2.impl.ContainmentPathElementImpl;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.xtext.aadl2.properties.util.GetProperties;

public class DeploymentHelper {

	public static boolean sameProcessor (ComponentInstance partition1, ComponentInstance partition2)
	{
		ComponentInstance runtimePartition1;
		ComponentInstance runtimePartition2;
		ComponentInstance modulePartition1;
		ComponentInstance modulePartition2;
		
		
		runtimePartition1 = GetProperties.getActualProcessorBinding (partition1).get(0);
		runtimePartition2 = GetProperties.getActualProcessorBinding (partition2).get(0);
		
		System.out.println("[DeploymentHelper] runtime partition1=" + runtimePartition1);
		System.out.println("[DeploymentHelper] runtime partition2=" + runtimePartition2);

		modulePartition1 = runtimePartition1.getContainingComponentInstance();
		modulePartition2 = runtimePartition2.getContainingComponentInstance();

		System.out.println("[DeploymentHelper] module partition1=" + modulePartition1);
		System.out.println("[DeploymentHelper] module partition2=" + modulePartition2);
		
		if (modulePartition1 == modulePartition2)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	public static ComponentInstance getModule (ComponentInstance partition)
	{
		ComponentInstance runtimePartition;
		ComponentInstance modulePartition;
		
		
		runtimePartition = GetProperties.getActualProcessorBinding (partition).get(0);
		
		modulePartition = runtimePartition.getContainingComponentInstance();
		
		return modulePartition;
		
	}
	
	public static ComponentInstance getPartitionRuntime (ComponentInstance partition)
	{
		return GetProperties.getActualProcessorBinding (partition).get(0);
	}
	
	public static int schedulingOrder (ComponentInstance module, ComponentInstance partition)
	{
		ListValue slotsAllocationList;
		ComponentInstance partitionRuntime;
		
		int val;
		int tmp;
		
		partitionRuntime = getPartitionRuntime (partition);
		slotsAllocationList = SchedulingSlotsHelper.getSlotsAllocation(module);
		val = -1;
		tmp = 0;
		for (Element e : slotsAllocationList.getChildren())
		{

			if (e instanceof ReferenceValue)
			{
				ReferenceValue rv = (ReferenceValue) e;
				System.out.println("rv=" + rv);
				for (Element e2 : rv.getChildren())
				{
					if (e2 instanceof ContainmentPathElementImpl)
					{
						ContainmentPathElementImpl cpei = (ContainmentPathElementImpl) e2;
						if (cpei.getNamedElement() instanceof VirtualProcessorSubcomponent)
						{
							VirtualProcessorSubcomponent vp = (VirtualProcessorSubcomponent) cpei.getNamedElement();
							if (vp.getName().equals (partitionRuntime.getName()))
							{
								System.out.println("[DeploymentHelper] Found scheduled partition at" + tmp);

								val = tmp;
							}
						}
					}
					tmp++;
						
				}
			}
		}
		
		return val;
	}
	
	public static int schedulingListSize (ComponentInstance module)
	{
		ListValue slotsAllocationList;
		int val;
		int tmp;
		
		slotsAllocationList = SchedulingSlotsHelper.getSlotsAllocation(module);
		
		tmp = 0;
		for (Element e : slotsAllocationList.getChildren())
		{

			if (e instanceof ReferenceValue)
			{
				ReferenceValue rv = (ReferenceValue) e;
				System.out.println("rv=" + rv);
				for (Element e2 : rv.getChildren())
				{
					tmp++;
						
				}
			}
		}
		
		return tmp;
	}
}
