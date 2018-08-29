/**
 * Copyright 2015 Carnegie Mellon University. All Rights Reserved.
 *
 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING INSTITUTE
 * MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO
 * WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY,
 * EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON
 * UNIVERSITY DOES NOT MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM
 * PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * Released under the Eclipse Public License (http://www.eclipse.org/org/documents/epl-v10.php)
 *
 * See COPYRIGHT file for full details.
 */

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