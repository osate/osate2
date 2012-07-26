/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.declarative.util;

import fr.tpt.aadl.annex.behavior.declarative.DeclarativePackage;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.ecore.xmi.util.XMLProcessor;

/**
 * This class contains helper methods to serialize and deserialize XML documents
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class DeclarativeXMLProcessor extends XMLProcessor {

	/**
	 * Public constructor to instantiate the helper.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeclarativeXMLProcessor() {
		super((EPackage.Registry.INSTANCE));
		DeclarativePackage.eINSTANCE.eClass();
	}

	/**
	 * Register for "*" and "xml" file extensions the DeclarativeResourceFactoryImpl factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Map<String, Resource.Factory> getRegistrations() {
		if (registrations == null) {
			super.getRegistrations();
			registrations.put(XML_EXTENSION,
					new DeclarativeResourceFactoryImpl());
			registrations.put(STAR_EXTENSION,
					new DeclarativeResourceFactoryImpl());
		}
		return registrations;
	}

} //DeclarativeXMLProcessor
