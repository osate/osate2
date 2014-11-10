package org.osate.aadl2.util;

import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.Property;

/**
 * Property service lookup to be used by getPropertyValues in NamedElement. An implementation of this service is provided by
 * the org.osate.xtext.aadl2.properties.ui plugin tha tmakes used of the GetProperties class performing a lookup through the
 * workspace property sets.
 *
 * Note: A different implementation would need to be provided for running OSATE outside the Eclipse IDE.
 *
 * @author dblouin
 */
public interface IPropertyService {

	/**
	 * find property definition for given name. The property may be qualified by the property set name via the ps parameter
	 * For predeclared properties this is not required
	 * @param context EObject the model object that references the property definition
	 * @param propertySetName String property set name, which may be null
	 * @param propertyName String Property Definition name
	 * @return Property or null
	 */
	Property lookupPropertyDefinition(EObject context, String propertySetName, String propertyName);
}
