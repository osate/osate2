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

import org.eclipse.emf.ecore.EObject;

import org.osate.aadl2.Element;
import org.osate.aadl2.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Qualified Propagation Point</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.QualifiedPropagationPoint#getSubcomponent <em>Subcomponent</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.QualifiedPropagationPoint#getNext <em>Next</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.QualifiedPropagationPoint#getPropagationPoint <em>Propagation Point</em>}</li>
 * </ul>
 *
 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getQualifiedPropagationPoint()
 * @model
 * @generated
 */
public interface QualifiedPropagationPoint extends EObject, Element
{
  /**
   * Returns the value of the '<em><b>Subcomponent</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Subcomponent</em>' containment reference.
   * @see #setSubcomponent(SubcomponentElement)
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getQualifiedPropagationPoint_Subcomponent()
   * @model containment="true"
   * @generated
   */
  SubcomponentElement getSubcomponent();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.QualifiedPropagationPoint#getSubcomponent <em>Subcomponent</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Subcomponent</em>' containment reference.
   * @see #getSubcomponent()
   * @generated
   */
  void setSubcomponent(SubcomponentElement value);

  /**
   * Returns the value of the '<em><b>Next</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Next</em>' containment reference.
   * @see #setNext(QualifiedPropagationPoint)
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getQualifiedPropagationPoint_Next()
   * @model containment="true"
   * @generated
   */
  QualifiedPropagationPoint getNext();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.QualifiedPropagationPoint#getNext <em>Next</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Next</em>' containment reference.
   * @see #getNext()
   * @generated
   */
  void setNext(QualifiedPropagationPoint value);

  /**
   * Returns the value of the '<em><b>Propagation Point</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Propagation Point</em>' reference.
   * @see #setPropagationPoint(NamedElement)
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getQualifiedPropagationPoint_PropagationPoint()
   * @model
   * @generated
   */
  NamedElement getPropagationPoint();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.QualifiedPropagationPoint#getPropagationPoint <em>Propagation Point</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Propagation Point</em>' reference.
   * @see #getPropagationPoint()
   * @generated
   */
  void setPropagationPoint(NamedElement value);

} // QualifiedPropagationPoint
