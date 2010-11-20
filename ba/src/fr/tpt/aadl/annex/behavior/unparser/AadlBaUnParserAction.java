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

	protected AadlBaUnparser unparser = null;
	@Override
	public String unparseAnnexLibrary(AnnexLibrary library, String indent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String unparseAnnexSubclause(AnnexSubclause subclause, String indent) {
		// TODO Auto-generated method stub
		System.out.println("annex unparser called");
		unparser = new AadlBaUnparser(subclause, indent);
		unparser.process(subclause);
		return "";
	}

}