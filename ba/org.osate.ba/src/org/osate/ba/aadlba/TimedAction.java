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
import org.osate.aadl2.ProcessorClassifier;
import org.osate.ba.utils.visitor.IBAVisitable ;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Timed Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.ba.aadlba.TimedAction#getLowerTime <em>Lower Time</em>}</li>
 *   <li>{@link org.osate.ba.aadlba.TimedAction#getUpperTime <em>Upper Time</em>}</li>
 *   <li>{@link org.osate.ba.aadlba.TimedAction#getProcessorClassifier <em>Processor Classifier</em>}</li>
 * </ul>
 *
 * @see org.osate.ba.aadlba.AadlBaPackage#getTimedAction()
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
   * @see org.osate.ba.aadlba.AadlBaPackage#getTimedAction_LowerTime()
   * @model containment="true" required="true"
   * @generated
   */
  BehaviorTime getLowerTime();

  /**
   * Sets the value of the '{@link org.osate.ba.aadlba.TimedAction#getLowerTime <em>Lower Time</em>}' containment reference.
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
   * @see org.osate.ba.aadlba.AadlBaPackage#getTimedAction_UpperTime()
   * @model containment="true"
   * @generated
   */
  BehaviorTime getUpperTime();

  /**
   * Sets the value of the '{@link org.osate.ba.aadlba.TimedAction#getUpperTime <em>Upper Time</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Upper Time</em>' containment reference.
   * @see #getUpperTime()
   * @generated
   */
  void setUpperTime(BehaviorTime value);

  /**
   * Returns the value of the '<em><b>Processor Classifier</b></em>' reference list.
   * The list contents are of type {@link org.osate.aadl2.ProcessorClassifier}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Processor Classifier</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Processor Classifier</em>' reference list.
   * @see #isSetProcessorClassifier()
   * @see #unsetProcessorClassifier()
   * @see org.osate.ba.aadlba.AadlBaPackage#getTimedAction_ProcessorClassifier()
   * @model unsettable="true"
   * @generated
   */
  EList<ProcessorClassifier> getProcessorClassifier();

  /**
   * Unsets the value of the '{@link org.osate.ba.aadlba.TimedAction#getProcessorClassifier <em>Processor Classifier</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetProcessorClassifier()
   * @see #getProcessorClassifier()
   * @generated
   */
  void unsetProcessorClassifier();

  /**
   * Returns whether the value of the '{@link org.osate.ba.aadlba.TimedAction#getProcessorClassifier <em>Processor Classifier</em>}' reference list is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Processor Classifier</em>' reference list is set.
   * @see #unsetProcessorClassifier()
   * @see #getProcessorClassifier()
   * @generated
   */
  boolean isSetProcessorClassifier();

} // TimedAction
