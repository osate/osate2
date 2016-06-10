/**
 */
package org.osate.xtext.aadl2.errormodel.errorModel.util;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.ecore.xmi.util.XMLProcessor;

import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;

/**
 * This class contains helper methods to serialize and deserialize XML documents
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ErrorModelXMLProcessor extends XMLProcessor
{

  /**
   * Public constructor to instantiate the helper.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErrorModelXMLProcessor()
  {
    super((EPackage.Registry.INSTANCE));
    ErrorModelPackage.eINSTANCE.eClass();
  }
  
  /**
   * Register for "*" and "xml" file extensions the ErrorModelResourceFactoryImpl factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected Map<String, Resource.Factory> getRegistrations()
  {
    if (registrations == null)
    {
      super.getRegistrations();
      registrations.put(XML_EXTENSION, new ErrorModelResourceFactoryImpl());
      registrations.put(STAR_EXTENSION, new ErrorModelResourceFactoryImpl());
    }
    return registrations;
  }

} //ErrorModelXMLProcessor
