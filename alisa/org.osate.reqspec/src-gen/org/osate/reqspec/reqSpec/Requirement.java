/**
 */
package org.osate.reqspec.reqSpec;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.osate.alisa.common.common.ConstantDecl;
import org.osate.alisa.common.common.PredicateExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Requirement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.reqspec.reqSpec.Requirement#getConstants <em>Constants</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.Requirement#getAssert <em>Assert</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.Requirement#getGoalReference <em>Goal Reference</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.Requirement#getException <em>Exception</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.Requirement#getExceptionText <em>Exception Text</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.Requirement#getRefinedReference <em>Refined Reference</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.Requirement#getStakeholderRequirementReference <em>Stakeholder Requirement Reference</em>}</li>
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
   * Returns the value of the '<em><b>Constants</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.alisa.common.common.ConstantDecl}.
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
  EList<ConstantDecl> getConstants();

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
   * Returns the value of the '<em><b>Exception</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Exception</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Exception</em>' reference.
   * @see #setException(EObject)
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getRequirement_Exception()
   * @model
   * @generated
   */
  EObject getException();

  /**
   * Sets the value of the '{@link org.osate.reqspec.reqSpec.Requirement#getException <em>Exception</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Exception</em>' reference.
   * @see #getException()
   * @generated
   */
  void setException(EObject value);

  /**
   * Returns the value of the '<em><b>Exception Text</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Exception Text</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Exception Text</em>' attribute.
   * @see #setExceptionText(String)
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getRequirement_ExceptionText()
   * @model
   * @generated
   */
  String getExceptionText();

  /**
   * Sets the value of the '{@link org.osate.reqspec.reqSpec.Requirement#getExceptionText <em>Exception Text</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Exception Text</em>' attribute.
   * @see #getExceptionText()
   * @generated
   */
  void setExceptionText(String value);

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

} // Requirement
