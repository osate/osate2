package org.osate.xtext.aadl2.validation;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.validation.NamesAreUniqueValidationHelper;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;

import com.google.common.collect.Maps;

public class Aadl2NamesAreUniqueValidationHelper extends NamesAreUniqueValidationHelper {

	@Override
	protected void checkDescriptionForDuplicatedName(IEObjectDescription description,
			Map<EClass, Map<QualifiedName, IEObjectDescription>> clusterTypeToName,
			ValidationMessageAcceptor acceptor) {
		EObject object = description.getEObjectOrProxy();
		EClass eClass = object.eClass();
		QualifiedName qualifiedName = description.getName().toLowerCase();
		EClass clusterType = getAssociatedClusterType(eClass);
		Map<QualifiedName, IEObjectDescription> nameToDescription = clusterTypeToName.get(clusterType);
		if (nameToDescription == null) {
			nameToDescription = Maps.newHashMap();
			nameToDescription.put(qualifiedName, description);
			clusterTypeToName.put(clusterType, nameToDescription);
		} else {
			if (nameToDescription.containsKey(qualifiedName)) {
				IEObjectDescription prevDescription = nameToDescription.get(qualifiedName);
				if (prevDescription != null) {
					createDuplicateNameError(prevDescription, clusterType, acceptor);
					nameToDescription.put(qualifiedName, null);
				}
				createDuplicateNameError(description, clusterType, acceptor);
			} else {
				nameToDescription.put(qualifiedName, description);
			}
		}
	}

}
