package fr.tpt.aadl.annex.behavior;

import edu.cmu.sei.aadl.aadl2.AnnexLibrary;
import edu.cmu.sei.aadl.aadl2.AnnexSubclause;
import fr.tpt.aadl.annex.behavior.unparser.AadlBaUnparser;


public class AadlBaUnParserAction implements edu.cmu.sei.aadl.annex.AnnexUnparser {

	/**
	 * AadlBa unparser instance
	 */
	protected AadlBaUnparser unparser = null;
	
	/**
	 * Top-level annex libray unparse method called by
	 * the unparser registry.
	 */
	public String unparseAnnexLibrary(AnnexLibrary library, String indent) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Top-level annex subclause method called by
	 * the unparser registry.
	 */
	public String unparseAnnexSubclause(AnnexSubclause subclause, String indent) {
		unparser = new AadlBaUnparser(subclause, indent);
		return unparser.process(subclause);
	}

}