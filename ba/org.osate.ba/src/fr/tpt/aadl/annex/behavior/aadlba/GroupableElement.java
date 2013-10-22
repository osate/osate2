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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Groupable Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.GroupableElement#getGroupHolders <em>Group Holders</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getGroupableElement()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface GroupableElement extends BehaviorElement
{
  /**
   * Returns the value of the '<em><b>Group Holders</b></em>' containment reference list.
   * The list contents are of type {@link fr.tpt.aadl.annex.behavior.aadlba.GroupHolder}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Group Holders</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Group Holders</em>' containment reference list.
   * @see #isSetGroupHolders()
   * @see #unsetGroupHolders()
   * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getGroupableElement_GroupHolders()
   * @model containment="true" unsettable="true"
   * @generated
   */
  EList<GroupHolder> getGroupHolders();

  /**
   * Unsets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.GroupableElement#getGroupHolders <em>Group Holders</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetGroupHolders()
   * @see #getGroupHolders()
   * @generated
   */
  void unsetGroupHolders();

  /**
   * Returns whether the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.GroupableElement#getGroupHolders <em>Group Holders</em>}' containment reference list is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Group Holders</em>' containment reference list is set.
   * @see #unsetGroupHolders()
   * @see #getGroupHolders()
   * @generated
   */
  boolean isSetGroupHolders();

} // GroupableElement
