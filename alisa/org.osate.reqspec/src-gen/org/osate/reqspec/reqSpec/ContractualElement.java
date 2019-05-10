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

import org.eclipse.emf.ecore.EObject;

import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.NamedElement;

import org.osate.alisa.common.common.Description;
import org.osate.alisa.common.common.Rationale;
import org.osate.alisa.common.common.Uncertainty;
import org.osate.alisa.common.common.ValDeclaration;

import org.osate.categories.categories.Category;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Contractual Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.reqspec.reqSpec.ContractualElement#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.ContractualElement#getTitle <em>Title</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.ContractualElement#getTargetDescription <em>Target Description</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.ContractualElement#getTarget <em>Target</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.ContractualElement#getTargetElement <em>Target Element</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.ContractualElement#getCategory <em>Category</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.ContractualElement#getDescription <em>Description</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.ContractualElement#getConstants <em>Constants</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.ContractualElement#getWhencondition <em>Whencondition</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.ContractualElement#getRationale <em>Rationale</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.ContractualElement#getChangeUncertainty <em>Change Uncertainty</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.ContractualElement#getEvolvesReference <em>Evolves Reference</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.ContractualElement#isDropped <em>Dropped</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.ContractualElement#getDropRationale <em>Drop Rationale</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.ContractualElement#getDocReference <em>Doc Reference</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.ContractualElement#getIssues <em>Issues</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.ContractualElement#getGoalReference <em>Goal Reference</em>}</li>
 * </ul>
 *
 * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getContractualElement()
 * @model
 * @generated
 */
public interface ContractualElement extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getContractualElement_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.osate.reqspec.reqSpec.ContractualElement#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Title</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Title</em>' attribute.
   * @see #setTitle(String)
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getContractualElement_Title()
   * @model
   * @generated
   */
  String getTitle();

  /**
   * Sets the value of the '{@link org.osate.reqspec.reqSpec.ContractualElement#getTitle <em>Title</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Title</em>' attribute.
   * @see #getTitle()
   * @generated
   */
  void setTitle(String value);

  /**
   * Returns the value of the '<em><b>Target Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Target Description</em>' attribute.
   * @see #setTargetDescription(String)
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getContractualElement_TargetDescription()
   * @model
   * @generated
   */
  String getTargetDescription();

  /**
   * Sets the value of the '{@link org.osate.reqspec.reqSpec.ContractualElement#getTargetDescription <em>Target Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target Description</em>' attribute.
   * @see #getTargetDescription()
   * @generated
   */
  void setTargetDescription(String value);

  /**
   * Returns the value of the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Target</em>' reference.
   * @see #setTarget(ComponentClassifier)
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getContractualElement_Target()
   * @model
   * @generated
   */
  ComponentClassifier getTarget();

  /**
   * Sets the value of the '{@link org.osate.reqspec.reqSpec.ContractualElement#getTarget <em>Target</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target</em>' reference.
   * @see #getTarget()
   * @generated
   */
  void setTarget(ComponentClassifier value);

  /**
   * Returns the value of the '<em><b>Target Element</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Target Element</em>' reference.
   * @see #setTargetElement(NamedElement)
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getContractualElement_TargetElement()
   * @model
   * @generated
   */
  NamedElement getTargetElement();

  /**
   * Sets the value of the '{@link org.osate.reqspec.reqSpec.ContractualElement#getTargetElement <em>Target Element</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target Element</em>' reference.
   * @see #getTargetElement()
   * @generated
   */
  void setTargetElement(NamedElement value);

  /**
   * Returns the value of the '<em><b>Category</b></em>' reference list.
   * The list contents are of type {@link org.osate.categories.categories.Category}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Category</em>' reference list.
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getContractualElement_Category()
   * @model
   * @generated
   */
  EList<Category> getCategory();

  /**
   * Returns the value of the '<em><b>Description</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Description</em>' containment reference.
   * @see #setDescription(Description)
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getContractualElement_Description()
   * @model containment="true"
   * @generated
   */
  Description getDescription();

  /**
   * Sets the value of the '{@link org.osate.reqspec.reqSpec.ContractualElement#getDescription <em>Description</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Description</em>' containment reference.
   * @see #getDescription()
   * @generated
   */
  void setDescription(Description value);

  /**
   * Returns the value of the '<em><b>Constants</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.alisa.common.common.ValDeclaration}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Constants</em>' containment reference list.
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getContractualElement_Constants()
   * @model containment="true"
   * @generated
   */
  EList<ValDeclaration> getConstants();

  /**
   * Returns the value of the '<em><b>Whencondition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Whencondition</em>' containment reference.
   * @see #setWhencondition(WhenCondition)
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getContractualElement_Whencondition()
   * @model containment="true"
   * @generated
   */
  WhenCondition getWhencondition();

  /**
   * Sets the value of the '{@link org.osate.reqspec.reqSpec.ContractualElement#getWhencondition <em>Whencondition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Whencondition</em>' containment reference.
   * @see #getWhencondition()
   * @generated
   */
  void setWhencondition(WhenCondition value);

  /**
   * Returns the value of the '<em><b>Rationale</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Rationale</em>' containment reference.
   * @see #setRationale(Rationale)
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getContractualElement_Rationale()
   * @model containment="true"
   * @generated
   */
  Rationale getRationale();

  /**
   * Sets the value of the '{@link org.osate.reqspec.reqSpec.ContractualElement#getRationale <em>Rationale</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Rationale</em>' containment reference.
   * @see #getRationale()
   * @generated
   */
  void setRationale(Rationale value);

  /**
   * Returns the value of the '<em><b>Change Uncertainty</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Change Uncertainty</em>' containment reference.
   * @see #setChangeUncertainty(Uncertainty)
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getContractualElement_ChangeUncertainty()
   * @model containment="true"
   * @generated
   */
  Uncertainty getChangeUncertainty();

  /**
   * Sets the value of the '{@link org.osate.reqspec.reqSpec.ContractualElement#getChangeUncertainty <em>Change Uncertainty</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Change Uncertainty</em>' containment reference.
   * @see #getChangeUncertainty()
   * @generated
   */
  void setChangeUncertainty(Uncertainty value);

  /**
   * Returns the value of the '<em><b>Evolves Reference</b></em>' reference list.
   * The list contents are of type {@link org.osate.reqspec.reqSpec.Requirement}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Evolves Reference</em>' reference list.
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getContractualElement_EvolvesReference()
   * @model
   * @generated
   */
  EList<Requirement> getEvolvesReference();

  /**
   * Returns the value of the '<em><b>Dropped</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Dropped</em>' attribute.
   * @see #setDropped(boolean)
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getContractualElement_Dropped()
   * @model
   * @generated
   */
  boolean isDropped();

  /**
   * Sets the value of the '{@link org.osate.reqspec.reqSpec.ContractualElement#isDropped <em>Dropped</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Dropped</em>' attribute.
   * @see #isDropped()
   * @generated
   */
  void setDropped(boolean value);

  /**
   * Returns the value of the '<em><b>Drop Rationale</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Drop Rationale</em>' attribute.
   * @see #setDropRationale(String)
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getContractualElement_DropRationale()
   * @model
   * @generated
   */
  String getDropRationale();

  /**
   * Sets the value of the '{@link org.osate.reqspec.reqSpec.ContractualElement#getDropRationale <em>Drop Rationale</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Drop Rationale</em>' attribute.
   * @see #getDropRationale()
   * @generated
   */
  void setDropRationale(String value);

  /**
   * Returns the value of the '<em><b>Doc Reference</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.reqspec.reqSpec.ExternalDocument}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Doc Reference</em>' containment reference list.
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getContractualElement_DocReference()
   * @model containment="true"
   * @generated
   */
  EList<ExternalDocument> getDocReference();

  /**
   * Returns the value of the '<em><b>Issues</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Issues</em>' attribute list.
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getContractualElement_Issues()
   * @model unique="false"
   * @generated
   */
  EList<String> getIssues();

  /**
   * Returns the value of the '<em><b>Goal Reference</b></em>' reference list.
   * The list contents are of type {@link org.osate.reqspec.reqSpec.Goal}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Goal Reference</em>' reference list.
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getContractualElement_GoalReference()
   * @model
   * @generated
   */
  EList<Goal> getGoalReference();

} // ContractualElement
