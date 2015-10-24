package org.osate.assure.metrics.utils

import org.osate.reqspec.reqSpec.Requirement
import org.osate.aadl2.ComponentClassifier
import org.osate.aadl2.SystemImplementation
import org.osate.reqspec.reqSpec.SystemRequirements

class ReqSpecHelper
{
	def static ComponentClassifier getRelatedComponentClassifier (Requirement req)
	{
		println("container" + req.eContainer)
		
		
		if (req.target == null)
		{
			return ((req.eContainer as SystemRequirements).target as ComponentClassifier)
		}	
		
		return null
	} 
	
	
	def static int getCoverageLevel (Requirement req, ComponentClassifier cl)
	{
		
		val ComponentClassifier cc = req.relatedComponentClassifier
//		println ("cc0" + cc)
		
		if (cc == null)
		{
			return -1;
		}
		
		if (cc == cl)
		{
			return 1;
		}
		
//		
//		println ("cc1" + cc.containingClassifier)
//		println ("cc2" + cc.containingClassifier)
		
		if (AadlHelper.isSubcomponent (cc, cl))
		{
			return 2;
		}
		 
		return 0;
	}
} 