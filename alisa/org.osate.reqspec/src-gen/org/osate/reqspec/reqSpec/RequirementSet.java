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
package org.osate.reqspec.reqSpec;

import org.eclipse.emf.common.util.EList;

import org.osate.alisa.common.common.AVariableDeclaration;
import org.osate.alisa.common.common.ValDeclaration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Requirement Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.reqspec.reqSpec.RequirementSet#getImportConstants <em>Import Constants</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.RequirementSet#getConstants <em>Constants</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.RequirementSet#getComputes <em>Computes</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.RequirementSet#getRequirements <em>Requirements</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.RequirementSet#getStakeholderGoals <em>Stakeholder Goals</em>}</li>
 * </ul>
 *
 * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getRequirementSet()
 * @model
 * @generated
 */
public interface RequirementSet extends ReqRoot
{
  /**
   * Returns the value of the '<em><b>Import Constants</b></em>' reference list.
   * The list contents are of type {@link org.osate.reqspec.reqSpec.GlobalConstants}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Import Constants</em>' reference list.
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getRequirementSet_ImportConstants()
   * @model
   * @generated
   */
  EList<GlobalConstants> getImportConstants();

  /**
   * Returns the value of the '<em><b>Constants</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.alisa.common.common.ValDeclaration}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Constants</em>' containment reference list.
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getRequirementSet_Constants()
   * @model containment="true"
   * @generated
   */
  EList<ValDeclaration> getConstants();

  /**
   * Returns the value of the '<em><b>Computes</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.alisa.common.common.AVariableDeclaration}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Computes</em>' containment reference list.
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getRequirementSet_Computes()
   * @model containment="true"
   * @generated
   */
  EList<AVariableDeclaration> getComputes();

  /**
   * Returns the value of the '<em><b>Requirements</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.reqspec.reqSpec.Requirement}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Requirements</em>' containment reference list.
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getRequirementSet_Requirements()
   * @model containment="true"
   * @generated
   */
  EList<Requirement> getRequirements();

  /**
   * Returns the value of the '<em><b>Stakeholder Goals</b></em>' reference list.
   * The list contents are of type {@link org.osate.reqspec.reqSpec.ReqRoot}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Stakeholder Goals</em>' reference list.
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getRequirementSet_StakeholderGoals()
   * @model
   * @generated
   */
  EList<ReqRoot> getStakeholderGoals();

} // RequirementSet
