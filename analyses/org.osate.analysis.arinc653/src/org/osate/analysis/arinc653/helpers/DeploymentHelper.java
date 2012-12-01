package org.osate.analysis.arinc653.helpers;

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
}
