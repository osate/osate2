/**
 */
package org.osate.alisa.workbench.alisa;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.osate.categories.categories.RequirementCategory;
import org.osate.categories.categories.SelectionCategory;
import org.osate.categories.categories.VerificationCategory;

import org.osate.verify.verify.Claim;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Assurance Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.alisa.workbench.alisa.AssuranceTask#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.AssuranceTask#getTitle <em>Title</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.AssuranceTask#getAssurancePlan <em>Assurance Plan</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.AssuranceTask#getDescription <em>Description</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.AssuranceTask#getRequirementFilter <em>Requirement Filter</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.AssuranceTask#getVerificationFilter <em>Verification Filter</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.AssuranceTask#getSelectionFilter <em>Selection Filter</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.AssuranceTask#getClaims <em>Claims</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.AssuranceTask#getIssues <em>Issues</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.alisa.workbench.alisa.AlisaPackage#getAssuranceTask()
 * @model
 * @generated
 */
public interface AssuranceTask extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.osate.alisa.workbench.alisa.AlisaPackage#getAssuranceTask_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.osate.alisa.workbench.alisa.AssuranceTask#getName <em>Name</em>}' attribute.
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
   * <p>
   * If the meaning of the '<em>Title</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Title</em>' attribute.
   * @see #setTitle(String)
   * @see org.osate.alisa.workbench.alisa.AlisaPackage#getAssuranceTask_Title()
   * @model
   * @generated
   */
  String getTitle();

  /**
   * Sets the value of the '{@link org.osate.alisa.workbench.alisa.AssuranceTask#getTitle <em>Title</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Title</em>' attribute.
   * @see #getTitle()
   * @generated
   */
  void setTitle(String value);

  /**
   * Returns the value of the '<em><b>Assurance Plan</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Assurance Plan</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Assurance Plan</em>' reference.
   * @see #setAssurancePlan(AssurancePlan)
   * @see org.osate.alisa.workbench.alisa.AlisaPackage#getAssuranceTask_AssurancePlan()
   * @model
   * @generated
   */
  AssurancePlan getAssurancePlan();

  /**
   * Sets the value of the '{@link org.osate.alisa.workbench.alisa.AssuranceTask#getAssurancePlan <em>Assurance Plan</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Assurance Plan</em>' reference.
   * @see #getAssurancePlan()
   * @generated
   */
  void setAssurancePlan(AssurancePlan value);

  /**
   * Returns the value of the '<em><b>Description</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Description</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Description</em>' containment reference.
   * @see #setDescription(Description)
   * @see org.osate.alisa.workbench.alisa.AlisaPackage#getAssuranceTask_Description()
   * @model containment="true"
   * @generated
   */
  Description getDescription();

  /**
   * Sets the value of the '{@link org.osate.alisa.workbench.alisa.AssuranceTask#getDescription <em>Description</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Description</em>' containment reference.
   * @see #getDescription()
   * @generated
   */
  void setDescription(Description value);

  /**
   * Returns the value of the '<em><b>Requirement Filter</b></em>' reference list.
   * The list contents are of type {@link org.osate.categories.categories.RequirementCategory}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Requirement Filter</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Requirement Filter</em>' reference list.
   * @see org.osate.alisa.workbench.alisa.AlisaPackage#getAssuranceTask_RequirementFilter()
   * @model
   * @generated
   */
  EList<RequirementCategory> getRequirementFilter();

  /**
   * Returns the value of the '<em><b>Verification Filter</b></em>' reference list.
   * The list contents are of type {@link org.osate.categories.categories.VerificationCategory}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Verification Filter</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Verification Filter</em>' reference list.
   * @see org.osate.alisa.workbench.alisa.AlisaPackage#getAssuranceTask_VerificationFilter()
   * @model
   * @generated
   */
  EList<VerificationCategory> getVerificationFilter();

  /**
   * Returns the value of the '<em><b>Selection Filter</b></em>' reference list.
   * The list contents are of type {@link org.osate.categories.categories.SelectionCategory}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Selection Filter</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Selection Filter</em>' reference list.
   * @see org.osate.alisa.workbench.alisa.AlisaPackage#getAssuranceTask_SelectionFilter()
   * @model
   * @generated
   */
  EList<SelectionCategory> getSelectionFilter();

  /**
   * Returns the value of the '<em><b>Claims</b></em>' reference list.
   * The list contents are of type {@link org.osate.verify.verify.Claim}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Claims</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Claims</em>' reference list.
   * @see org.osate.alisa.workbench.alisa.AlisaPackage#getAssuranceTask_Claims()
   * @model
   * @generated
   */
  EList<Claim> getClaims();

  /**
   * Returns the value of the '<em><b>Issues</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Issues</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Issues</em>' attribute list.
   * @see org.osate.alisa.workbench.alisa.AlisaPackage#getAssuranceTask_Issues()
   * @model unique="false"
   * @generated
   */
  EList<String> getIssues();

} // AssuranceTask
