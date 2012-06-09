package org.osate.xtext.aadl2.properties.util;

import java.util.HashSet;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ModelUnit;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.aadl2.modelsupport.util.TraverseWorkspace;
import org.osate.xtext.aadl2.properties.resources.OsateResourceUtil;

public class ModelUtil {

	/**
	 * Get all component implementations; in all anon. name spaces and from all
	 * packages (public and private parts)
	 * 
	 * @return EList of component impl
	 */
	public static EList<ComponentImplementation> getAllComponentImpl() {
		EList<ComponentImplementation> result = new BasicEList<ComponentImplementation>();
		HashSet<IFile> files = TraverseWorkspace.getAadlFilesInWorkspace();
		for (IFile file : files){
			ModelUnit target = (ModelUnit)OsateResourceUtil.getElement(file);
			if (target != null){
				if (target instanceof AadlPackage) {
					result.addAll(AadlUtil.getAllComponentImpl((AadlPackage) target));
				}
			}
		}
		return result;
	}

}
