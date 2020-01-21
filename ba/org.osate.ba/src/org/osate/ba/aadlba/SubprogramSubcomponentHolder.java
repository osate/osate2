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
package org.osate.ba.aadlba;

import org.osate.aadl2.SubprogramSubcomponent;
import org.osate.ba.utils.visitor.IBAVisitable ;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Subprogram Subcomponent Holder</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.osate.ba.aadlba.AadlBaPackage#getSubprogramSubcomponentHolder()
 * @model
 * @generated
 */
public interface SubprogramSubcomponentHolder extends SubcomponentHolder, CalledSubprogramHolder, IBAVisitable
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model subprogramSubcomponentRequired="true"
   *        annotation="http://www.eclipse.org/emf/2002/GenModel body='element = subprogramSubcomponent ;'"
   * @generated
   */
  void setSubprogramSubcomponent(SubprogramSubcomponent subprogramSubcomponent);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation" required="true"
   *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return (SubprogramSubcomponent) element;'"
   * @generated
   */
  SubprogramSubcomponent getSubprogramSubcomponent();

} // SubprogramSubcomponentHolder
