package org.osate.xtext.aadl2.sandbox.validation;
 
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.osate.xtext.aadl2.validation.Aadl2JavaValidator;
import org.eclipse.xtext.validation.ComposedChecks;

@ComposedChecks(validators= {org.eclipse.xtext.validation.NamesAreUniqueValidator.class})
public class AbstractSandboxJavaValidator extends Aadl2JavaValidator {

	@Override
	protected List<EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(org.osate.xtext.aadl2.sandbox.sandbox.SandboxPackage.eINSTANCE);
	    result.add(EPackage.Registry.INSTANCE.getEPackage("http://aadl.info/AADL/2.0"));
		return result;
	}

}
