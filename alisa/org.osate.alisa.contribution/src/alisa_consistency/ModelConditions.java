package alisa_consistency;

import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;

public class ModelConditions {

	public static boolean isLeafComponent(EObject ne){
		if (ne instanceof ComponentImplementation){
			ComponentImplementation cimpl = (ComponentImplementation)ne;
			return cimpl.getAllSubcomponents().isEmpty();
		} else if (ne instanceof ComponentType){
			return true;
		}
		return false;
	}
}
