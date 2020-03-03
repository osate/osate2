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

import java.util.Collection ;
import org.eclipse.emf.common.notify.NotificationChain ;
import org.eclipse.emf.common.util.EList ;
import org.eclipse.emf.ecore.EClass ;

import org.eclipse.emf.ecore.InternalEObject ;
import org.eclipse.emf.ecore.util.EObjectContainmentEList ;
import org.eclipse.emf.ecore.util.InternalEList ;
import org.osate.aadl2.Aadl2Package ;
import org.osate.aadl2.Element ;
import org.osate.aadl2.ListValue ;
import org.osate.aadl2.PropertyExpression ;
import org.osate.aadl2.impl.ListValueImpl ;
import org.osate.aadl2.properties.EvaluatedProperty ;
import org.osate.aadl2.properties.EvaluationContext ;
import org.osate.aadl2.properties.InvalidModelException ;
import org.osate.ba.aadlba.BehaviorElement ;
import org.osate.ba.declarative.DeclarativeListValue ;
import org.osate.ba.declarative.DeclarativePackage ;
import org.osate.ba.declarative.DeclarativePropertyExpression ;
import org.osate.ba.utils.AadlBaLocationReference ;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>List Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class DeclarativeListValueImpl extends ListValueImpl implements
                                      DeclarativeListValue
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DeclarativeListValueImpl()
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
    return DeclarativePackage.Literals.DECLARATIVE_LIST_VALUE ;
  }

} //DeclarativeListValueImpl
