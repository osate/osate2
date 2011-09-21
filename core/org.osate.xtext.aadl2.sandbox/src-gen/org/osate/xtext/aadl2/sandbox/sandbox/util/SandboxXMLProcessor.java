/**
 * <copyright>
 * </copyright>
 *

 */
package org.osate.xtext.aadl2.sandbox.sandbox.util;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.ecore.xmi.util.XMLProcessor;

import org.osate.xtext.aadl2.sandbox.sandbox.SandboxPackage;

/**
 * This class contains helper methods to serialize and deserialize XML documents
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class SandboxXMLProcessor extends XMLProcessor
{

  /**
   * Public constructor to instantiate the helper.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SandboxXMLProcessor()
  {
    super((EPackage.Registry.INSTANCE));
    SandboxPackage.eINSTANCE.eClass();
  }
  
  /**
   * Register for "*" and "xml" file extensions the SandboxResourceFactoryImpl factory.
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
      registrations.put(XML_EXTENSION, new SandboxResourceFactoryImpl());
      registrations.put(STAR_EXTENSION, new SandboxResourceFactoryImpl());
    }
    return registrations;
  }

} //SandboxXMLProcessor
