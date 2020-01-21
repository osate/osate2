/**
 * AADL-BA-FrontEnd
 * 
 * Copyright © 2013 TELECOM ParisTech and CNRS
 * 
 * TELECOM ParisTech/LTCI
 * 
 * Authors: see AUTHORS
 * 
 * This program is free software: you can redistribute it and/or modify 
 * it under the terms of the Eclipse Public License as published by Eclipse,
 * either version 2.0 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * Eclipse Public License for more details.
 * You should have received a copy of the Eclipse Public License
 * along with this program.  If not, see 
 * https://www.eclipse.org/legal/epl-2.0/
 */

package org.osate.ba.declarative.util ;

import java.util.Map ;

import org.eclipse.emf.ecore.EPackage ;

import org.eclipse.emf.ecore.resource.Resource ;

import org.eclipse.emf.ecore.xmi.util.XMLProcessor ;
import org.osate.ba.declarative.DeclarativePackage ;

/**
 * This class contains helper methods to serialize and deserialize XML documents
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class DeclarativeXMLProcessor extends XMLProcessor
{

  /**
   * Public constructor to instantiate the helper.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DeclarativeXMLProcessor()
  {
    super((EPackage.Registry.INSTANCE)) ;
    DeclarativePackage.eINSTANCE.eClass() ;
  }

  /**
   * Register for "*" and "xml" file extensions the DeclarativeResourceFactoryImpl factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected Map<String, Resource.Factory> getRegistrations()
  {
    if(registrations == null)
    {
      super.getRegistrations() ;
      registrations.put(XML_EXTENSION, new DeclarativeResourceFactoryImpl()) ;
      registrations.put(STAR_EXTENSION, new DeclarativeResourceFactoryImpl()) ;
    }
    return registrations ;
  }

} //DeclarativeXMLProcessor
