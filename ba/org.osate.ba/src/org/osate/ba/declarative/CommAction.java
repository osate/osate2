/**
 * AADL-BA-FrontEnd
 * 
 * Copyright © 2013 TELECOM ParisTech and CNRS
 * 
 * TELECOM ParisTech/LTCI
 * 
 * Authors: see AUTHORS
 * 
 * This program is free software: you can redistribute it and/or modify 
 * it under the terms of the Eclipse Public License as published by Eclipse,
 * either version 2.0 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * Eclipse Public License for more details.
 * You should have received a copy of the Eclipse Public License
 * along with this program.  If not, see 
 * https://www.eclipse.org/legal/epl-2.0/
 */

package org.osate.ba.declarative ;

import org.eclipse.emf.common.util.EList ;
import org.osate.ba.aadlba.CommunicationAction ;
import org.osate.ba.aadlba.ParameterLabel ;
import org.osate.ba.aadlba.Target ;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Comm Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.ba.declarative.CommAction#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.osate.ba.declarative.CommAction#isPortFreeze <em>Port Freeze</em>}</li>
 *   <li>{@link org.osate.ba.declarative.CommAction#isPortDequeue <em>Port Dequeue</em>}</li>
 *   <li>{@link org.osate.ba.declarative.CommAction#isLock <em>Lock</em>}</li>
 *   <li>{@link org.osate.ba.declarative.CommAction#isUnlock <em>Unlock</em>}</li>
 *   <li>{@link org.osate.ba.declarative.CommAction#getTarget <em>Target</em>}</li>
 *   <li>{@link org.osate.ba.declarative.CommAction#getQualifiedName <em>Qualified Name</em>}</li>
 *   <li>{@link org.osate.ba.declarative.CommAction#getReference <em>Reference</em>}</li>
 * </ul>
 *
 * @see org.osate.ba.declarative.DeclarativePackage#getCommAction()
 * @model
 * @generated
 */
public interface CommAction extends CommunicationAction,
                            DeclarativeBehaviorElement
{
  /**
   * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.ba.aadlba.ParameterLabel}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parameters</em>' containment reference list.
   * @see #isSetParameters()
   * @see #unsetParameters()
   * @see org.osate.ba.declarative.DeclarativePackage#getCommAction_Parameters()
   * @model containment="true" unsettable="true"
   * @generated
   */
  EList<ParameterLabel> getParameters() ;

  /**
   * Unsets the value of the '{@link org.osate.ba.declarative.CommAction#getParameters <em>Parameters</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetParameters()
   * @see #getParameters()
   * @generated
   */
  void unsetParameters() ;

  /**
   * Returns whether the value of the '{@link org.osate.ba.declarative.CommAction#getParameters <em>Parameters</em>}' containment reference list is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Parameters</em>' containment reference list is set.
   * @see #unsetParameters()
   * @see #getParameters()
   * @generated
   */
  boolean isSetParameters() ;

  /**
   * Returns the value of the '<em><b>Port Freeze</b></em>' attribute.
   * The default value is <code>"false"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Port Freeze</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Port Freeze</em>' attribute.
   * @see #setPortFreeze(boolean)
   * @see org.osate.ba.declarative.DeclarativePackage#getCommAction_PortFreeze()
   * @model default="false" dataType="org.osate.ba.aadlba.Boolean"
   * @generated
   */
  boolean isPortFreeze() ;

  /**
   * Sets the value of the '{@link org.osate.ba.declarative.CommAction#isPortFreeze <em>Port Freeze</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Port Freeze</em>' attribute.
   * @see #isPortFreeze()
   * @generated
   */
  void setPortFreeze(boolean value) ;

  /**
   * Returns the value of the '<em><b>Port Dequeue</b></em>' attribute.
   * The default value is <code>"false"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Port Dequeue</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Port Dequeue</em>' attribute.
   * @see #setPortDequeue(boolean)
   * @see org.osate.ba.declarative.DeclarativePackage#getCommAction_PortDequeue()
   * @model default="false" dataType="org.osate.ba.aadlba.Boolean"
   * @generated
   */
  boolean isPortDequeue() ;

  /**
   * Sets the value of the '{@link org.osate.ba.declarative.CommAction#isPortDequeue <em>Port Dequeue</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Port Dequeue</em>' attribute.
   * @see #isPortDequeue()
   * @generated
   */
  void setPortDequeue(boolean value) ;

  /**
   * Returns the value of the '<em><b>Lock</b></em>' attribute.
   * The default value is <code>"false"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Lock</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Lock</em>' attribute.
   * @see #setLock(boolean)
   * @see org.osate.ba.declarative.DeclarativePackage#getCommAction_Lock()
   * @model default="false" dataType="org.osate.ba.aadlba.Boolean"
   * @generated
   */
  boolean isLock() ;

  /**
   * Sets the value of the '{@link org.osate.ba.declarative.CommAction#isLock <em>Lock</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Lock</em>' attribute.
   * @see #isLock()
   * @generated
   */
  void setLock(boolean value) ;

  /**
   * Returns the value of the '<em><b>Unlock</b></em>' attribute.
   * The default value is <code>"false"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Unlock</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Unlock</em>' attribute.
   * @see #setUnlock(boolean)
   * @see org.osate.ba.declarative.DeclarativePackage#getCommAction_Unlock()
   * @model default="false" dataType="org.osate.ba.aadlba.Boolean"
   * @generated
   */
  boolean isUnlock() ;

  /**
   * Sets the value of the '{@link org.osate.ba.declarative.CommAction#isUnlock <em>Unlock</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Unlock</em>' attribute.
   * @see #isUnlock()
   * @generated
   */
  void setUnlock(boolean value) ;

  /**
   * Returns the value of the '<em><b>Target</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Target</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Target</em>' containment reference.
   * @see #setTarget(Target)
   * @see org.osate.ba.declarative.DeclarativePackage#getCommAction_Target()
   * @model containment="true"
   * @generated
   */
  Target getTarget() ;

  /**
   * Sets the value of the '{@link org.osate.ba.declarative.CommAction#getTarget <em>Target</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target</em>' containment reference.
   * @see #getTarget()
   * @generated
   */
  void setTarget(Target value) ;

  /**
   * Returns the value of the '<em><b>Qualified Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Qualified Name</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Qualified Name</em>' containment reference.
   * @see #setQualifiedName(QualifiedNamedElement)
   * @see org.osate.ba.declarative.DeclarativePackage#getCommAction_QualifiedName()
   * @model containment="true"
   * @generated
   */
  QualifiedNamedElement getQualifiedName() ;

  /**
   * Sets the value of the '{@link org.osate.ba.declarative.CommAction#getQualifiedName <em>Qualified Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Qualified Name</em>' containment reference.
   * @see #getQualifiedName()
   * @generated
   */
  void setQualifiedName(QualifiedNamedElement value) ;

  /**
   * Returns the value of the '<em><b>Reference</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Reference</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Reference</em>' containment reference.
   * @see #setReference(Reference)
   * @see org.osate.ba.declarative.DeclarativePackage#getCommAction_Reference()
   * @model containment="true"
   * @generated
   */
  Reference getReference() ;

  /**
   * Sets the value of the '{@link org.osate.ba.declarative.CommAction#getReference <em>Reference</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Reference</em>' containment reference.
   * @see #getReference()
   * @generated
   */
  void setReference(Reference value) ;

} // CommAction
