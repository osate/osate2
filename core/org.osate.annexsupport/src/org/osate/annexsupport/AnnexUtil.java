package org.osate.annexsupport;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;

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

	
	/**
	 * get the line number for a given model object in the core model
	 * This method makes use of the Xtext parse tree.
	 * @return line number
	 */
	public static int getLineNumberFor(EObject obj)	{
		INode node = NodeModelUtils.findActualNodeFor(obj);
		if (node != null){
			return node.getStartLine();
		}
		return 0;
	}

}
