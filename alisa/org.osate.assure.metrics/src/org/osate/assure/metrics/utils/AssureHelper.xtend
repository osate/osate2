package org.osate.assure.metrics.utils

import java.util.List
import org.osate.reqspec.reqSpec.Requirement
import org.osate.assure.assure.AssuranceEvidence
import java.util.ArrayList

public class AssureHelper
{
	
	def static List<Requirement> getRequirements (AssuranceEvidence evidence)
	{
		val List<Requirement> res = new ArrayList<Requirement>()
		
		evidence.claimResult.forEach[cr |
			res.add(cr.target); println ("ClaimResult" + cr.target)
		]
		
		res
	}
}


