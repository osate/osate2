/**
 */
package org.osate.alisa.workbench.alisa;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.osate.alisa.common.common.Description;

import org.osate.categories.categories.Category;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Assurance Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.alisa.workbench.alisa.AssuranceTask#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.AssuranceTask#getTitle <em>Title</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.AssuranceTask#getAssurancePlan <em>Assurance Plan</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.AssuranceTask#getDescription <em>Description</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.AssuranceTask#getFilter <em>Filter</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.AssuranceTask#isStrictFilter <em>Strict Filter</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.AssuranceTask#getIssues <em>Issues</em>}</li>
 * </ul>
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
   * Returns the value of the '<em><b>Filter</b></em>' reference list.
   * The list contents are of type {@link org.osate.categories.categories.Category}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Filter</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Filter</em>' reference list.
   * @see org.osate.alisa.workbench.alisa.AlisaPackage#getAssuranceTask_Filter()
   * @model
   * @generated
   */
  EList<Category> getFilter();

  /**
   * Returns the value of the '<em><b>Strict Filter</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Strict Filter</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Strict Filter</em>' attribute.
   * @see #setStrictFilter(boolean)
   * @see org.osate.alisa.workbench.alisa.AlisaPackage#getAssuranceTask_StrictFilter()
   * @model
   * @generated
   */
  boolean isStrictFilter();

  /**
   * Sets the value of the '{@link org.osate.alisa.workbench.alisa.AssuranceTask#isStrictFilter <em>Strict Filter</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Strict Filter</em>' attribute.
   * @see #isStrictFilter()
   * @generated
   */
  void setStrictFilter(boolean value);

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
