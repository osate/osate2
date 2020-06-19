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

import org.osate.aadl2.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Error Source</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorSource#getSourceModelElement <em>Source Model Element</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorSource#isAll <em>All</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorSource#getFailureModeReference <em>Failure Mode Reference</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorSource#getFailureModeType <em>Failure Mode Type</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorSource#getFailureModeDescription <em>Failure Mode Description</em>}</li>
 * </ul>
 *
 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorSource()
 * @model
 * @generated
 */
public interface ErrorSource extends ErrorFlow
{
  /**
   * Returns the value of the '<em><b>Source Model Element</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Source Model Element</em>' reference.
   * @see #setSourceModelElement(NamedElement)
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorSource_SourceModelElement()
   * @model
   * @generated
   */
  NamedElement getSourceModelElement();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorSource#getSourceModelElement <em>Source Model Element</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Source Model Element</em>' reference.
   * @see #getSourceModelElement()
   * @generated
   */
  void setSourceModelElement(NamedElement value);

  /**
   * Returns the value of the '<em><b>All</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>All</em>' attribute.
   * @see #setAll(boolean)
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorSource_All()
   * @model
   * @generated
   */
  boolean isAll();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorSource#isAll <em>All</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>All</em>' attribute.
   * @see #isAll()
   * @generated
   */
  void setAll(boolean value);

  /**
   * Returns the value of the '<em><b>Failure Mode Reference</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Failure Mode Reference</em>' reference.
   * @see #setFailureModeReference(ErrorBehaviorState)
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorSource_FailureModeReference()
   * @model
   * @generated
   */
  ErrorBehaviorState getFailureModeReference();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorSource#getFailureModeReference <em>Failure Mode Reference</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Failure Mode Reference</em>' reference.
   * @see #getFailureModeReference()
   * @generated
   */
  void setFailureModeReference(ErrorBehaviorState value);

  /**
   * Returns the value of the '<em><b>Failure Mode Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Failure Mode Type</em>' containment reference.
   * @see #setFailureModeType(TypeSet)
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorSource_FailureModeType()
   * @model containment="true"
   * @generated
   */
  TypeSet getFailureModeType();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorSource#getFailureModeType <em>Failure Mode Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Failure Mode Type</em>' containment reference.
   * @see #getFailureModeType()
   * @generated
   */
  void setFailureModeType(TypeSet value);

  /**
   * Returns the value of the '<em><b>Failure Mode Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Failure Mode Description</em>' attribute.
   * @see #setFailureModeDescription(String)
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorSource_FailureModeDescription()
   * @model
   * @generated
   */
  String getFailureModeDescription();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorSource#getFailureModeDescription <em>Failure Mode Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Failure Mode Description</em>' attribute.
   * @see #getFailureModeDescription()
   * @generated
   */
  void setFailureModeDescription(String value);

} // ErrorSource
