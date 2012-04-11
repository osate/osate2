/**
 * AADL-BA-FrontEnd
 * 
 * Copyright © 2011 TELECOM ParisTech and CNRS
 * 
 * TELECOM ParisTech/LTCI
 * 
 * Authors: see AUTHORS
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the Eclipse Public License as published by Eclipse, either
 * version 1.0 of the License, or (at your option) any later version. This
 * program is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the Eclipse Public License for
 * more details. You should have received a copy of the Eclipse Public License
 * along with this program. If not, see
 * http://www.eclipse.org/org/documents/epl-v10.php
 */
package fr.tpt.aadl.annex.behavior.aadlba;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Shared Data Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.SharedDataAction#getDataAccess <em>Data Access</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getSharedDataAction()
 * @model abstract="true"
 * @generated
 */
public interface SharedDataAction extends CommunicationAction
{
  /**
   * Returns the value of the '<em><b>Data Access</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Data Access</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Data Access</em>' containment reference.
   * @see #setDataAccess(DataAccessHolder)
   * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getSharedDataAction_DataAccess()
   * @model containment="true"
   * @generated
   */
  DataAccessHolder getDataAccess();

  /**
   * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.SharedDataAction#getDataAccess <em>Data Access</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Data Access</em>' containment reference.
   * @see #getDataAccess()
   * @generated
   */
  void setDataAccess(DataAccessHolder value);

} // SharedDataAction
