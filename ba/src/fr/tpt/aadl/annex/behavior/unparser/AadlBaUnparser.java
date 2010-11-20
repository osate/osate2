package fr.tpt.aadl.annex.behavior.unparser;

import org.eclipse.emf.ecore.EClass;

import edu.cmu.sei.aadl.aadl2.AnnexSubclause;
import edu.cmu.sei.aadl.aadl2.Element;
import fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage;
import fr.tpt.aadl.annex.behavior.aadlba.util.AadlBaSwitch;

public class AadlBaUnparser {
	
	protected AadlBaSwitch<String> aadlbaSwitch = null;
	
	String startIndent = "";
	
	AnnexSubclause rootAnnex = null;
	

	public AadlBaUnparser(AnnexSubclause root, String indent) {
		this.rootAnnex = root;
		this.startIndent = indent;
		this.initSwitches();
	}

	/**
	 * Calls the package-specific switch
	 */
	public final void process(Element theElement) {
		/**
		 * This checks to make sure we only invoke doSwitch with non-null
		 * objects This is necessary as some feature retrieval methods may
		 * return null
		 */
		if (theElement == null) {
			return;
		}
		EClass theEClass = theElement.eClass();
		if (aadlbaSwitch != null && theEClass.eContainer() == AadlBaPackage.eINSTANCE)
			aadlbaSwitch.doSwitch(theElement);
		else 
			System.out.println("process aadlba switch failed");
	}
	
	protected void initSwitches() {

		aadlbaSwitch = new AadlBaSwitch<String>() {
			
			
		};
	}
}
