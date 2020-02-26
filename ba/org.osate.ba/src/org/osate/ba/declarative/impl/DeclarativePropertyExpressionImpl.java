/**
 * AADL-BA-FrontEnd
 * 
 * Copyright (c) 2011-2020 TELECOM ParisTech and CNRS
 * 
 * TELECOM ParisTech/LTCI
 * 
 * Authors: see AUTHORS
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the Eclipse Public License as published by Eclipse, either
 * version 2.0 of the License, or (at your option) any later version. This
 * program is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the Eclipse Public License for
 * more details. You should have received a copy of the Eclipse Public License
 * along with this program. If not, see
 * https://www.eclipse.org/legal/epl-2.0/
 */
package org.osate.ba.declarative.impl ;

import org.eclipse.emf.ecore.EClass ;

import org.eclipse.emf.ecore.impl.EObjectImpl ;
import org.osate.aadl2.impl.PropertyExpressionImpl ;

import org.osate.ba.declarative.DeclarativePackage ;
import org.osate.ba.declarative.DeclarativePropertyExpression ;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class DeclarativePropertyExpressionImpl extends
                                                        PropertyExpressionImpl
                                                        implements
                                                        DeclarativePropertyExpression
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DeclarativePropertyExpressionImpl()
  {
    super() ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return DeclarativePackage.Literals.DECLARATIVE_PROPERTY_EXPRESSION ;
  }

} //DeclarativePropertyExpressionImpl
