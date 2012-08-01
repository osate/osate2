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

	
	/**
	 * get the root element of the actual annex subclause/library for the given default annex subclause/library
	 * @param obj EObject DefaultAnnexSubclause or DefaultAnnexLibrary
	 * @return actual annex subclause or library or null
	 */
	public static EObject getAnnexRootElement(EObject obj)	{
		// Find the Parseresult information
		for(Adapter adapter : obj.eAdapters()) {
			if(adapter instanceof AnnexParseResult) {
				AnnexParseResult apr = (AnnexParseResult) adapter;
				if (apr.getParseResult() != null)
					return apr.getParseResult().getRootASTElement();
			}
		}
		return null;
	}

}
