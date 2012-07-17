package org.osate.annexsupport;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EObject;

public class AnnexUtil {
	
	public static AnnexParseResult getAnnexParseResult(EObject obj)	{
		// Find the Parseresult information
		for(Adapter adapter : obj.eAdapters()) {
			if(adapter instanceof AnnexParseResult) {
				return (AnnexParseResult)adapter;
			}
		}
		
		return null;
	}


}
