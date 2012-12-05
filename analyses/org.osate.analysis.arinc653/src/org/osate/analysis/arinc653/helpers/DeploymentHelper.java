package org.osate.analysis.arinc653.helpers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.Element;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.ReferenceValue;
import org.osate.aadl2.VirtualProcessorSubcomponent;
import org.osate.aadl2.impl.ContainmentPathElementImpl;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.FeatureInstance;
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
		
//		System.out.println("[DeploymentHelper] runtime partition1=" + runtimePartition1);
//		System.out.println("[DeploymentHelper] runtime partition2=" + runtimePartition2);

		modulePartition1 = runtimePartition1.getContainingComponentInstance();
		modulePartition2 = runtimePartition2.getContainingComponentInstance();

//		System.out.println("[DeploymentHelper] module partition1=" + modulePartition1);
//		System.out.println("[DeploymentHelper] module partition2=" + modulePartition2);
		
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
	
	public static ComponentInstance getConnectedBus (ComponentInstance device)
	{
		ComponentInstance bus;	
		List<FeatureInstance> features;
	
		bus = null;
		features = device.getFeatureInstances();
		for (FeatureInstance fi : features)
		{
			for ( ConnectionInstance conn : fi.getDstConnectionInstances() )
			{

//				System.out.println("e " + conn.getSource());
				if ((conn.getSource() != null) && (conn.getSource() instanceof ComponentInstance))
				{
					
					bus = (ComponentInstance)conn.getSource();
				}
			}
		}

		
		return bus;
	}
	
	
	public static ComponentInstance getDeviceConnected (ComponentInstance processor, String busName)
	{
		ComponentInstance root;
		ComponentInstance device;
		ComponentInstance component;
		
		List<FeatureInstance> features;
		boolean busChecked;
		boolean processorChecked;
		
		
		device = null;
		busChecked = false;
		processorChecked = false;
		
		root = processor.getContainingComponentInstance();
		
		for (Element child : root.getChildren())
		{
			if (child instanceof ComponentInstance)
			{
				component = (ComponentInstance) child;
				if (component.getCategory() != ComponentCategory.DEVICE)
				{
					continue;
				}
				
				busChecked = false;
				processorChecked = false;
				features = component.getFeatureInstances();
				
				for (FeatureInstance fi : features)
				{
					for ( ConnectionInstance conn : fi.getDstConnectionInstances() )
					{
						
//						System.out.println("e " + conn.getSource());
//						System.out.println("bus " + busName);
						if (conn.getSource().getName() == busName)
						{
//							System.out.println("[DeploymentHelper] bus found");

							busChecked = true;
						}
					}
				}
				
				

				
				if ((GetProperties.getActualProcessorBinding(component).get(0) == processor) ||
					(GetProperties.getActualProcessorBinding(component).get(0).getContainingComponentInstance() == processor))
				{
					processorChecked = true;
				}
				
				if (busChecked && processorChecked)
				{
					return component;
				}
			}

			
		}
		
		return device;
	}
	
	public static boolean isDeviceConnectedToBus (ComponentInstance device, ComponentInstance bus)
	{
		boolean result;
		
		result = false;
		
		return result;
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
//				System.out.println("rv=" + rv);
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
//								System.out.println("[DeploymentHelper] Found scheduled partition at" + tmp);

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
		int tmp;
		
		slotsAllocationList = SchedulingSlotsHelper.getSlotsAllocation(module);
		
		tmp = 0;
		for (Element e : slotsAllocationList.getChildren())
		{

			if (e instanceof ReferenceValue)
			{
				tmp++;
				/*
				ReferenceValue rv = (ReferenceValue) e;
				for (Element e2 : rv.getChildren())
				{
					tmp++;
				}*/
			}
		}
		
		return tmp;
	}

	public static Map<ComponentInstance, Integer> getConnectionsPerProcessor (ComponentInstance partition) {
		Map<ComponentInstance, Integer> result;
		ComponentInstance localProcessor;
		ComponentInstance remoteProcessor;
		ComponentInstance remotePartition;
		int temp;
		
		localProcessor= DeploymentHelper.getModule (partition);
		result = new HashMap<ComponentInstance,Integer>();
		
		result.put(localProcessor, 0);
		
		for (FeatureInstance fi : partition.getFeatureInstances())
		{
			//System.out.println(fi);
			if (fi.getDirection().outgoing())
			{
				//System.out.println ("current process=" + partition);

				//System.out.println ("outgoing=" + fi);

				for (ConnectionInstance ci : fi.getSrcConnectionInstances())
				{
					remotePartition = ci.getDestination().getContainingComponentInstance();
					System.out.println ("remote part=" + remotePartition);

					if (remotePartition.getCategory() != ComponentCategory.PROCESS)
					{
						continue;
					}
					
					remoteProcessor= DeploymentHelper.getModule (remotePartition);
					System.out.println ("remote cpu=" + remoteProcessor);
					temp = 0;
					
					if (result.containsKey(remoteProcessor))
					{
						temp = result.get(remoteProcessor);
					}
					temp = temp + 1;
					result.put(remoteProcessor,  temp);
				}
			}
		}
		
		return result;
	}
}
