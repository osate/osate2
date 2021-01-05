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
package org.osate.ba.declarative ;

import org.eclipse.emf.common.util.EList ;

import org.eclipse.emf.ecore.EObject ;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Behavior Annex</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.ba.declarative.DeclarativeBehaviorAnnex#getDeclarativeBehaviorElements <em>Declarative Behavior Elements</em>}</li>
 * </ul>
 *
 * @see org.osate.ba.declarative.DeclarativePackage#getDeclarativeBehaviorAnnex()
 * @model
 * @generated
 */
public interface DeclarativeBehaviorAnnex extends EObject
{
  /**
   * Returns the value of the '<em><b>Declarative Behavior Elements</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.ba.declarative.DeclarativeBehaviorElement}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Declarative Behavior Elements</em>' containment reference list.
   * @see org.osate.ba.declarative.DeclarativePackage#getDeclarativeBehaviorAnnex_DeclarativeBehaviorElements()
   * @model containment="true"
   * @generated
   */
  EList<DeclarativeBehaviorElement> getDeclarativeBehaviorElements() ;

} // DeclarativeBehaviorAnnex
