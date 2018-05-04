package org.osate.ge.internal.util;

import org.osate.aadl2.NamedElement;
import org.osate.aadl2.SubprogramCall;

public class AadlSubprogramCallUtil {
	/**
	 * Returns null if it is unable to build a non-empty string.
	 * @param call
	 * @return
	 */
	public static String getCalledSubprogramDescription(final SubprogramCall call) {
		String subprogramReferenceStr = "";
	    if(call.getContext() instanceof NamedElement) {
	    	final String contextTxt = ((NamedElement)call.getContext()).getName();
	    	if(contextTxt != null) {
	    		subprogramReferenceStr = contextTxt + ".";
	    	}
	    }
	
	    if(call.getCalledSubprogram() instanceof NamedElement) {
	    	final String calledSubprogramTxt = ((NamedElement)call.getCalledSubprogram()).getName();
	    	if(calledSubprogramTxt != null) {
	    		subprogramReferenceStr += calledSubprogramTxt;
	    	}
	    }        
	
	    return subprogramReferenceStr.length() == 0 ? null : subprogramReferenceStr;
	}
}
