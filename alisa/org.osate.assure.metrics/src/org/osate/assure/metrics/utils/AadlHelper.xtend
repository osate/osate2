package org.osate.assure.metrics.utils

import java.util.List
import org.osate.reqspec.reqSpec.Requirement
import org.osate.aadl2.ComponentClassifier
import org.osate.aadl2.ComponentImplementation
import org.osate.aadl2.Subcomponent

class AadlHelper
{
	
	def static boolean isSubcomponent (ComponentClassifier parent, ComponentClassifier lookFor)
	{
//		println ("parent=" + parent + " with " + lookFor);
//	
//		println ("Compare parent " + parent.name + " with " + lookFor.name);
		if (parent == lookFor)
		{
			return true
		}
		
		if (parent instanceof ComponentImplementation)
		{
			for (Subcomponent sc : parent.allSubcomponents)
			{
				if (isSubcomponent(sc.classifier, lookFor))
				{
					return true
				}
			}
		}
		
		return false;
	}
}


