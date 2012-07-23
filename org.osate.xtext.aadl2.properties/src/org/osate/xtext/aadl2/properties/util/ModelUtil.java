package org.osate.xtext.aadl2.properties.util;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.aadl2.util.Aadl2Util;

public class ModelUtil {

	/**
	 * Get all component implementations; in all 
	 * packages (public and private parts)
	 * 
	 * @return EList of component impl
	 */
	public static EList<ComponentImplementation> getAllComponentImpl() {
		EList<ComponentImplementation> result = new BasicEList<ComponentImplementation>();
		EList<IEObjectDescription> cimpllist = EMFIndexRetrieval.getAllClassifiersOfTypeInWorkspace(Aadl2Package.eINSTANCE.getComponentImplementation());
		for (IEObjectDescription eod : cimpllist) {
			EObject res = eod.getEObjectOrProxy();
			res = EcoreUtil.resolve(res, OsateResourceUtil.getResourceSet());
			if (!Aadl2Util.isNull(res)) result.add((ComponentImplementation)res);
		}
		return result;
	}

}
