package fr.tpt.aadl.annex.behavior.unparser;

import org.eclipse.emf.ecore.EClass;

import edu.cmu.sei.aadl.aadl2.Aadl2Package;
import edu.cmu.sei.aadl.aadl2.AnnexLibrary;
import edu.cmu.sei.aadl.aadl2.AnnexSubclause;
import edu.cmu.sei.aadl.aadl2.Element;
import edu.cmu.sei.aadl.aadl2.instance.InstancePackage;
import edu.cmu.sei.aadl.aadl2.util.Aadl2Switch;
import fr.tpt.aadl.annex.behavior.aadlba.util.AadlBaSwitch;


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