/**
 * Copyright 2015 Carnegie Mellon University. All Rights Reserved.
 * 
 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING INSTITUTE
 * MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO
 * WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY,
 * EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON
 * UNIVERSITY DOES NOT MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM
 * PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * Released under the Eclipse Public License (http://www.eclipse.org/org/documents/epl-v10.php)
 * 
 * See COPYRIGHT file for full details.
 */
package org.osate.reqspec.reqSpec;

import org.eclipse.emf.ecore.EObject;

import org.osate.aadl2.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Include Global Requirement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.reqspec.reqSpec.IncludeGlobalRequirement#getInclude <em>Include</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.IncludeGlobalRequirement#isLocal <em>Local</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.IncludeGlobalRequirement#getTargetElement <em>Target Element</em>}</li>
 * </ul>
 *
 * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getIncludeGlobalRequirement()
 * @model
 * @generated
 */
public interface IncludeGlobalRequirement extends EObject
{
  /**
   * Returns the value of the '<em><b>Include</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Include</em>' reference.
   * @see #setInclude(EObject)
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getIncludeGlobalRequirement_Include()
   * @model
   * @generated
   */
  EObject getInclude();

  /**
   * Sets the value of the '{@link org.osate.reqspec.reqSpec.IncludeGlobalRequirement#getInclude <em>Include</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Include</em>' reference.
   * @see #getInclude()
   * @generated
   */
  void setInclude(EObject value);

  /**
   * Returns the value of the '<em><b>Local</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Local</em>' attribute.
   * @see #setLocal(boolean)
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getIncludeGlobalRequirement_Local()
   * @model
   * @generated
   */
  boolean isLocal();

  /**
   * Sets the value of the '{@link org.osate.reqspec.reqSpec.IncludeGlobalRequirement#isLocal <em>Local</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Local</em>' attribute.
   * @see #isLocal()
   * @generated
   */
  void setLocal(boolean value);

  /**
   * Returns the value of the '<em><b>Target Element</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Target Element</em>' reference.
   * @see #setTargetElement(NamedElement)
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getIncludeGlobalRequirement_TargetElement()
   * @model
   * @generated
   */
  NamedElement getTargetElement();

  /**
   * Sets the value of the '{@link org.osate.reqspec.reqSpec.IncludeGlobalRequirement#getTargetElement <em>Target Element</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target Element</em>' reference.
   * @see #getTargetElement()
   * @generated
   */
  void setTargetElement(NamedElement value);

} // IncludeGlobalRequirement
