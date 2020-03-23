/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
 * All Rights Reserved.
 * 
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 * 
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.xtext.aadl2.errormodel.errorModel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Error Path</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorPath#getIncoming <em>Incoming</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorPath#isAllIncoming <em>All Incoming</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorPath#getOutgoing <em>Outgoing</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorPath#isAllOutgoing <em>All Outgoing</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorPath#getTargetToken <em>Target Token</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorPath#getTypeMappingSet <em>Type Mapping Set</em>}</li>
 * </ul>
 *
 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorPath()
 * @model
 * @generated
 */
public interface ErrorPath extends ErrorFlow
{
  /**
   * Returns the value of the '<em><b>Incoming</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Incoming</em>' reference.
   * @see #setIncoming(ErrorPropagation)
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorPath_Incoming()
   * @model
   * @generated
   */
  ErrorPropagation getIncoming();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorPath#getIncoming <em>Incoming</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Incoming</em>' reference.
   * @see #getIncoming()
   * @generated
   */
  void setIncoming(ErrorPropagation value);

  /**
   * Returns the value of the '<em><b>All Incoming</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>All Incoming</em>' attribute.
   * @see #setAllIncoming(boolean)
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorPath_AllIncoming()
   * @model
   * @generated
   */
  boolean isAllIncoming();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorPath#isAllIncoming <em>All Incoming</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>All Incoming</em>' attribute.
   * @see #isAllIncoming()
   * @generated
   */
  void setAllIncoming(boolean value);

  /**
   * Returns the value of the '<em><b>Outgoing</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Outgoing</em>' reference.
   * @see #setOutgoing(ErrorPropagation)
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorPath_Outgoing()
   * @model
   * @generated
   */
  ErrorPropagation getOutgoing();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorPath#getOutgoing <em>Outgoing</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Outgoing</em>' reference.
   * @see #getOutgoing()
   * @generated
   */
  void setOutgoing(ErrorPropagation value);

  /**
   * Returns the value of the '<em><b>All Outgoing</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>All Outgoing</em>' attribute.
   * @see #setAllOutgoing(boolean)
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorPath_AllOutgoing()
   * @model
   * @generated
   */
  boolean isAllOutgoing();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorPath#isAllOutgoing <em>All Outgoing</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>All Outgoing</em>' attribute.
   * @see #isAllOutgoing()
   * @generated
   */
  void setAllOutgoing(boolean value);

  /**
   * Returns the value of the '<em><b>Target Token</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Target Token</em>' containment reference.
   * @see #setTargetToken(TypeSet)
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorPath_TargetToken()
   * @model containment="true"
   * @generated
   */
  TypeSet getTargetToken();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorPath#getTargetToken <em>Target Token</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target Token</em>' containment reference.
   * @see #getTargetToken()
   * @generated
   */
  void setTargetToken(TypeSet value);

  /**
   * Returns the value of the '<em><b>Type Mapping Set</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type Mapping Set</em>' reference.
   * @see #setTypeMappingSet(TypeMappingSet)
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorPath_TypeMappingSet()
   * @model
   * @generated
   */
  TypeMappingSet getTypeMappingSet();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorPath#getTypeMappingSet <em>Type Mapping Set</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type Mapping Set</em>' reference.
   * @see #getTypeMappingSet()
   * @generated
   */
  void setTypeMappingSet(TypeMappingSet value);

} // ErrorPath
