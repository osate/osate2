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

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.osate.aadl2.AnnexLibrary;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Library</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary#getUseTypes <em>Use Types</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary#getExtends <em>Extends</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary#getTypes <em>Types</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary#getTypesets <em>Typesets</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary#getBehaviors <em>Behaviors</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary#getMappings <em>Mappings</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary#getTransformations <em>Transformations</em>}</li>
 * </ul>
 *
 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorModelLibrary()
 * @model
 * @generated
 */
public interface ErrorModelLibrary extends EObject, AnnexLibrary
{
  /**
   * Returns the value of the '<em><b>Use Types</b></em>' reference list.
   * The list contents are of type {@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Use Types</em>' reference list.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorModelLibrary_UseTypes()
   * @model
   * @generated
   */
  EList<ErrorModelLibrary> getUseTypes();

  /**
   * Returns the value of the '<em><b>Extends</b></em>' reference list.
   * The list contents are of type {@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Extends</em>' reference list.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorModelLibrary_Extends()
   * @model
   * @generated
   */
  EList<ErrorModelLibrary> getExtends();

  /**
   * Returns the value of the '<em><b>Types</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorType}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Types</em>' containment reference list.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorModelLibrary_Types()
   * @model containment="true"
   * @generated
   */
  EList<ErrorType> getTypes();

  /**
   * Returns the value of the '<em><b>Typesets</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.xtext.aadl2.errormodel.errorModel.TypeSet}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Typesets</em>' containment reference list.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorModelLibrary_Typesets()
   * @model containment="true"
   * @generated
   */
  EList<TypeSet> getTypesets();

  /**
   * Returns the value of the '<em><b>Properties</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.xtext.aadl2.errormodel.errorModel.EMV2PropertyAssociation}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Properties</em>' containment reference list.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorModelLibrary_Properties()
   * @model containment="true"
   * @generated
   */
  EList<EMV2PropertyAssociation> getProperties();

  /**
   * Returns the value of the '<em><b>Behaviors</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Behaviors</em>' containment reference list.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorModelLibrary_Behaviors()
   * @model containment="true"
   * @generated
   */
  EList<ErrorBehaviorStateMachine> getBehaviors();

  /**
   * Returns the value of the '<em><b>Mappings</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.xtext.aadl2.errormodel.errorModel.TypeMappingSet}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Mappings</em>' containment reference list.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorModelLibrary_Mappings()
   * @model containment="true"
   * @generated
   */
  EList<TypeMappingSet> getMappings();

  /**
   * Returns the value of the '<em><b>Transformations</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.xtext.aadl2.errormodel.errorModel.TypeTransformationSet}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Transformations</em>' containment reference list.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorModelLibrary_Transformations()
   * @model containment="true"
   * @generated
   */
  EList<TypeTransformationSet> getTransformations();

} // ErrorModelLibrary
