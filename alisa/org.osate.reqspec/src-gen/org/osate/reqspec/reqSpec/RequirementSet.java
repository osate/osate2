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
