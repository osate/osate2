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
 * either version 1.0 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * Eclipse Public License for more details.
 * You should have received a copy of the Eclipse Public License
 * along with this program.  If not, see 
 * http://www.eclipse.org/org/documents/epl-v10.php
 */

package org.osate.ba.declarative.util ;

import org.eclipse.emf.common.util.URI ;

import org.eclipse.emf.ecore.resource.Resource ;

import org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl ;

import org.eclipse.emf.ecore.xmi.XMLResource ;

/**
 * <!-- begin-user-doc -->
 * The <b>Resource Factory</b> associated with the package.
 * <!-- end-user-doc -->
 * @see org.osate.ba.declarative.util.DeclarativeResourceImpl
 * @generated
 */
public class DeclarativeResourceFactoryImpl extends ResourceFactoryImpl
{
  /**
   * Creates an instance of the resource factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DeclarativeResourceFactoryImpl()
  {
    super() ;
  }

  /**
   * Creates an instance of the resource.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Resource createResource(URI uri)
  {
    XMLResource result = new DeclarativeResourceImpl(uri) ;
    result.getDefaultSaveOptions().put(XMLResource.OPTION_EXTENDED_META_DATA,
                                       Boolean.TRUE) ;
    result.getDefaultLoadOptions().put(XMLResource.OPTION_EXTENDED_META_DATA,
                                       Boolean.TRUE) ;

    result.getDefaultSaveOptions().put(XMLResource.OPTION_SCHEMA_LOCATION,
                                       Boolean.TRUE) ;

    result.getDefaultLoadOptions()
          .put(XMLResource.OPTION_USE_ENCODED_ATTRIBUTE_STYLE, Boolean.TRUE) ;
    result.getDefaultSaveOptions()
          .put(XMLResource.OPTION_USE_ENCODED_ATTRIBUTE_STYLE, Boolean.TRUE) ;

    result.getDefaultLoadOptions().put(XMLResource.OPTION_USE_LEXICAL_HANDLER,
                                       Boolean.TRUE) ;
    return result ;
  }

} //DeclarativeResourceFactoryImpl
