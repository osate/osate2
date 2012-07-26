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
 * A representation of the model object '<em><b>Timed Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.TimedAction#getLowerTime <em>Lower Time</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.TimedAction#getUpperTime <em>Upper Time</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getTimedAction()
 * @model
 * @generated
 */
public interface TimedAction extends BasicAction
{
  /**
	 * Returns the value of the '<em><b>Lower Time</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Lower Time</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Lower Time</em>' containment reference.
	 * @see #setLowerTime(BehaviorTime)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getTimedAction_LowerTime()
	 * @model containment="true" required="true"
	 * @generated
	 */
  BehaviorTime getLowerTime();

  /**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.TimedAction#getLowerTime <em>Lower Time</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lower Time</em>' containment reference.
	 * @see #getLowerTime()
	 * @generated
	 */
  void setLowerTime(BehaviorTime value);

  /**
	 * Returns the value of the '<em><b>Upper Time</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Upper Time</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Upper Time</em>' containment reference.
	 * @see #setUpperTime(BehaviorTime)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getTimedAction_UpperTime()
	 * @model containment="true"
	 * @generated
	 */
  BehaviorTime getUpperTime();

  /**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.TimedAction#getUpperTime <em>Upper Time</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Upper Time</em>' containment reference.
	 * @see #getUpperTime()
	 * @generated
	 */
  void setUpperTime(BehaviorTime value);

} // TimedAction
