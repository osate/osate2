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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.Element;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.ReferenceValue;
import org.osate.aadl2.VirtualProcessorSubcomponent;
import org.osate.aadl2.impl.ContainmentPathElementImpl;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.xtext.aadl2.properties.util.GetProperties;

public class DeploymentHelper {

	public static boolean sameProcessor (ComponentInstance partition1, ComponentInstance partition2) throws Exception
	{
		ComponentInstance runtimePartition1;
		ComponentInstance runtimePartition2;
		ComponentInstance modulePartition1;
		ComponentInstance modulePartition2;
		
		
		if (GetProperties.getActualProcessorBinding (partition1).size() < 1)
		{
			throw new UnsupportedOperationException ("partition " + partition1 + " does not have a runtime");
		}
		
		if (GetProperties.getActualProcessorBinding (partition2).size() < 1)
		{
			throw new UnsupportedOperationException ("partition " + partition2 + " does not have a runtime");

		}
		
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
		
		if (device == null)
		{
			return null;
		}
		
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
		if (GetProperties.getActualProcessorBinding (partition).size() < 1)
		{
			return null;
		}
		return GetProperties.getActualProcessorBinding (partition).get(0);
	}
	
	public static int schedulingOrder (ComponentInstance module, ComponentInstance partition)
	{
		List<PropertyExpression> slotsAllocationList;
		ComponentInstance partitionRuntime;
		
		int val;
		int tmp;
		
		partitionRuntime = getPartitionRuntime (partition);
		slotsAllocationList = SchedulingSlotsHelper.getSlotsAllocation(module);
		
		if (partitionRuntime == null)
		{
			return -1;
		}
		
		val = -1;
		tmp = 0;
		for (Element e : slotsAllocationList)
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
		List<PropertyExpression> slotsAllocationList;
		int tmp;
		
		slotsAllocationList = SchedulingSlotsHelper.getSlotsAllocation(module);
		
		tmp = 0;
		for (Element e : slotsAllocationList)
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
