/**
 */
package org.osate.reqspec.reqSpec;

import org.eclipse.emf.common.util.EList;

import org.osate.alisa.common.common.FinalValue;
import org.osate.alisa.common.common.PredicateExpression;

import org.osate.categories.categories.RequirementCategory;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Requirement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.reqspec.reqSpec.Requirement#getCategory <em>Category</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.Requirement#getConstants <em>Constants</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.Requirement#getAssert <em>Assert</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.Requirement#getGoalReference <em>Goal Reference</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.Requirement#getRefinedReference <em>Refined Reference</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.Requirement#getRefinesReference <em>Refines Reference</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.Requirement#getSubrequirement <em>Subrequirement</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.Requirement#getDecomposedReference <em>Decomposed Reference</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.Requirement#getDecomposesReference <em>Decomposes Reference</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.Requirement#getEvolvesReference <em>Evolves Reference</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.Requirement#getStakeholderRequirementReference <em>Stakeholder Requirement Reference</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.Requirement#getSystemRequirementReference <em>System Requirement Reference</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.Requirement#getDocReference <em>Doc Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getRequirement()
 * @model
 * @generated
 */
public interface Requirement extends ContractualElement
{
  /**
   * Returns the value of the '<em><b>Category</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Category</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Category</em>' reference.
   * @see #setCategory(RequirementCategory)
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getRequirement_Category()
   * @model
   * @generated
   */
  RequirementCategory getCategory();

  /**
   * Sets the value of the '{@link org.osate.reqspec.reqSpec.Requirement#getCategory <em>Category</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Category</em>' reference.
   * @see #getCategory()
   * @generated
   */
  void setCategory(RequirementCategory value);

  /**
   * Returns the value of the '<em><b>Constants</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.alisa.common.common.FinalValue}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Constants</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Constants</em>' containment reference list.
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getRequirement_Constants()
   * @model containment="true"
   * @generated
   */
  EList<FinalValue> getConstants();

  /**
   * Returns the value of the '<em><b>Assert</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Assert</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Assert</em>' containment reference.
   * @see #setAssert(PredicateExpression)
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getRequirement_Assert()
   * @model containment="true"
   * @generated
   */
  PredicateExpression getAssert();

  /**
   * Sets the value of the '{@link org.osate.reqspec.reqSpec.Requirement#getAssert <em>Assert</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Assert</em>' containment reference.
   * @see #getAssert()
   * @generated
   */
  void setAssert(PredicateExpression value);

  /**
   * Returns the value of the '<em><b>Goal Reference</b></em>' reference list.
   * The list contents are of type {@link org.osate.reqspec.reqSpec.Goal}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Goal Reference</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Goal Reference</em>' reference list.
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getRequirement_GoalReference()
   * @model
   * @generated
   */
  EList<Goal> getGoalReference();

  /**
   * Returns the value of the '<em><b>Refined Reference</b></em>' reference list.
   * The list contents are of type {@link org.osate.reqspec.reqSpec.Requirement}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Refined Reference</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Refined Reference</em>' reference list.
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getRequirement_RefinedReference()
   * @model
   * @generated
   */
  EList<Requirement> getRefinedReference();

  /**
   * Returns the value of the '<em><b>Refines Reference</b></em>' reference list.
   * The list contents are of type {@link org.osate.reqspec.reqSpec.Requirement}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Refines Reference</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Refines Reference</em>' reference list.
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getRequirement_RefinesReference()
   * @model
   * @generated
   */
  EList<Requirement> getRefinesReference();

  /**
   * Returns the value of the '<em><b>Subrequirement</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.reqspec.reqSpec.Requirement}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Subrequirement</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Subrequirement</em>' containment reference list.
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getRequirement_Subrequirement()
   * @model containment="true"
   * @generated
   */
  EList<Requirement> getSubrequirement();

  /**
   * Returns the value of the '<em><b>Decomposed Reference</b></em>' reference list.
   * The list contents are of type {@link org.osate.reqspec.reqSpec.Requirement}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Decomposed Reference</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Decomposed Reference</em>' reference list.
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getRequirement_DecomposedReference()
   * @model
   * @generated
   */
  EList<Requirement> getDecomposedReference();

  /**
   * Returns the value of the '<em><b>Decomposes Reference</b></em>' reference list.
   * The list contents are of type {@link org.osate.reqspec.reqSpec.Requirement}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Decomposes Reference</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Decomposes Reference</em>' reference list.
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getRequirement_DecomposesReference()
   * @model
   * @generated
   */
  EList<Requirement> getDecomposesReference();

  /**
   * Returns the value of the '<em><b>Evolves Reference</b></em>' reference list.
   * The list contents are of type {@link org.osate.reqspec.reqSpec.Requirement}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Evolves Reference</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Evolves Reference</em>' reference list.
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getRequirement_EvolvesReference()
   * @model
   * @generated
   */
  EList<Requirement> getEvolvesReference();

  /**
   * Returns the value of the '<em><b>Stakeholder Requirement Reference</b></em>' reference list.
   * The list contents are of type {@link org.osate.reqspec.reqSpec.Goal}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Stakeholder Requirement Reference</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Stakeholder Requirement Reference</em>' reference list.
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getRequirement_StakeholderRequirementReference()
   * @model
   * @generated
   */
  EList<Goal> getStakeholderRequirementReference();

  /**
   * Returns the value of the '<em><b>System Requirement Reference</b></em>' reference list.
   * The list contents are of type {@link org.osate.reqspec.reqSpec.ContractualElement}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>System Requirement Reference</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>System Requirement Reference</em>' reference list.
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getRequirement_SystemRequirementReference()
   * @model
   * @generated
   */
  EList<ContractualElement> getSystemRequirementReference();

  /**
   * Returns the value of the '<em><b>Doc Reference</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.reqspec.reqSpec.ExternalDocument}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Doc Reference</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Doc Reference</em>' containment reference list.
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getRequirement_DocReference()
   * @model containment="true"
   * @generated
   */
  EList<ExternalDocument> getDocReference();

} // Requirement
