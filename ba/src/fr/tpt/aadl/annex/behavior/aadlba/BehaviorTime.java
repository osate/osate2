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

import org.osate.aadl2.UnitLiteral;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Behavior Time</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorTime#getIntegerValue <em>Integer Value</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorTime#getUnit <em>Unit</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getBehaviorTime()
 * @model
 * @generated
 */
public interface BehaviorTime extends BehaviorElement
{
  /**
   * Returns the value of the '<em><b>Integer Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Integer Value</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Integer Value</em>' containment reference.
   * @see #setIntegerValue(IntegerValue)
   * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getBehaviorTime_IntegerValue()
   * @model containment="true" required="true"
   * @generated
   */
  IntegerValue getIntegerValue();

  /**
   * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorTime#getIntegerValue <em>Integer Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Integer Value</em>' containment reference.
   * @see #getIntegerValue()
   * @generated
   */
  void setIntegerValue(IntegerValue value);

  /**
   * Returns the value of the '<em><b>Unit</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Unit</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Unit</em>' reference.
   * @see #setUnit(UnitLiteral)
   * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getBehaviorTime_Unit()
   * @model required="true"
   * @generated
   */
  UnitLiteral getUnit();

  /**
   * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorTime#getUnit <em>Unit</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Unit</em>' reference.
   * @see #getUnit()
   * @generated
   */
  void setUnit(UnitLiteral value);

} // BehaviorTime
