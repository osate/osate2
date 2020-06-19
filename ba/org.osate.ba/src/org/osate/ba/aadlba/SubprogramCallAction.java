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
import org.osate.ba.utils.visitor.IBAVisitable ;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Subprogram Call Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.ba.aadlba.SubprogramCallAction#getSubprogram <em>Subprogram</em>}</li>
 *   <li>{@link org.osate.ba.aadlba.SubprogramCallAction#getParameterLabels <em>Parameter Labels</em>}</li>
 *   <li>{@link org.osate.ba.aadlba.SubprogramCallAction#getProxy <em>Proxy</em>}</li>
 * </ul>
 *
 * @see org.osate.ba.aadlba.AadlBaPackage#getSubprogramCallAction()
 * @model
 * @generated
 */
public interface SubprogramCallAction extends CommunicationAction
{
  /**
   * Returns the value of the '<em><b>Subprogram</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Subprogram</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Subprogram</em>' containment reference.
   * @see #setSubprogram(CalledSubprogramHolder)
   * @see org.osate.ba.aadlba.AadlBaPackage#getSubprogramCallAction_Subprogram()
   * @model containment="true" required="true"
   * @generated
   */
  CalledSubprogramHolder getSubprogram();

  /**
   * Sets the value of the '{@link org.osate.ba.aadlba.SubprogramCallAction#getSubprogram <em>Subprogram</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Subprogram</em>' containment reference.
   * @see #getSubprogram()
   * @generated
   */
  void setSubprogram(CalledSubprogramHolder value);

  /**
   * Returns the value of the '<em><b>Parameter Labels</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.ba.aadlba.ParameterLabel}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parameter Labels</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parameter Labels</em>' containment reference list.
   * @see #isSetParameterLabels()
   * @see #unsetParameterLabels()
   * @see org.osate.ba.aadlba.AadlBaPackage#getSubprogramCallAction_ParameterLabels()
   * @model containment="true" unsettable="true"
   * @generated
   */
  EList<ParameterLabel> getParameterLabels();

  /**
   * Unsets the value of the '{@link org.osate.ba.aadlba.SubprogramCallAction#getParameterLabels <em>Parameter Labels</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetParameterLabels()
   * @see #getParameterLabels()
   * @generated
   */
  void unsetParameterLabels();

  /**
   * Returns whether the value of the '{@link org.osate.ba.aadlba.SubprogramCallAction#getParameterLabels <em>Parameter Labels</em>}' containment reference list is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Parameter Labels</em>' containment reference list is set.
   * @see #unsetParameterLabels()
   * @see #getParameterLabels()
   * @generated
   */
  boolean isSetParameterLabels();

  /**
   * Returns the value of the '<em><b>Proxy</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Proxy</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Proxy</em>' containment reference.
   * @see #setProxy(SubprogramHolderProxy)
   * @see org.osate.ba.aadlba.AadlBaPackage#getSubprogramCallAction_Proxy()
   * @model containment="true"
   * @generated
   */
  SubprogramHolderProxy getProxy();

  /**
   * Sets the value of the '{@link org.osate.ba.aadlba.SubprogramCallAction#getProxy <em>Proxy</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Proxy</em>' containment reference.
   * @see #getProxy()
   * @generated
   */
  void setProxy(SubprogramHolderProxy value);

} // SubprogramCallAction
