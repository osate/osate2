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

import org.eclipse.emf.common.util.EList;
import org.osate.aadl2.ArrayableElement;
import org.osate.aadl2.Data;
import org.osate.aadl2.DataClassifier;
import org.osate.aadl2.PropertyAssociation;
import org.osate.ba.utils.visitor.IBAVisitable ;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Behavior Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.ba.aadlba.BehaviorVariable#getDataClassifier <em>Data Classifier</em>}</li>
 *   <li>{@link org.osate.ba.aadlba.BehaviorVariable#getOwnedPropertyAssociations <em>Owned Property Associations</em>}</li>
 * </ul>
 *
 * @see org.osate.ba.aadlba.AadlBaPackage#getBehaviorVariable()
 * @model
 * @generated
 */
public interface BehaviorVariable extends BehaviorNamedElement, ArrayableElement, Data
{
  /**
   * Returns the value of the '<em><b>Data Classifier</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Data Classifier</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Data Classifier</em>' reference.
   * @see #setDataClassifier(DataClassifier)
   * @see org.osate.ba.aadlba.AadlBaPackage#getBehaviorVariable_DataClassifier()
   * @model required="true"
   * @generated
   */
  DataClassifier getDataClassifier();

  /**
   * Sets the value of the '{@link org.osate.ba.aadlba.BehaviorVariable#getDataClassifier <em>Data Classifier</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Data Classifier</em>' reference.
   * @see #getDataClassifier()
   * @generated
   */
  void setDataClassifier(DataClassifier value);

  /**
   * Returns the value of the '<em><b>Owned Property Associations</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.aadl2.PropertyAssociation}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Owned Property Associations</em>' containment reference list.
   * @see org.osate.ba.aadlba.AadlBaPackage#getBehaviorVariable_OwnedPropertyAssociations()
   * @model containment="true"
   * @generated
   */
  EList<PropertyAssociation> getOwnedPropertyAssociations();

} // BehaviorVariable
