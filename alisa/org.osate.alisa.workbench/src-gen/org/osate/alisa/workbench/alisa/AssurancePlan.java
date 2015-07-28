/**
 */
package org.osate.alisa.workbench.alisa;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.osate.aadl2.ComponentImplementation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Assurance Plan</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.alisa.workbench.alisa.AssurancePlan#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.AssurancePlan#getTitle <em>Title</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.AssurancePlan#getSystem <em>System</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.AssurancePlan#getDescription <em>Description</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.AssurancePlan#getSubsystemPlans <em>Subsystem Plans</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.AssurancePlan#getVerifiedAssumption <em>Verified Assumption</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.AssurancePlan#getIssues <em>Issues</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.alisa.workbench.alisa.AlisaPackage#getAssurancePlan()
 * @model
 * @generated
 */
public interface AssurancePlan extends EObject
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
   * @see org.osate.alisa.workbench.alisa.AlisaPackage#getAssurancePlan_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.osate.alisa.workbench.alisa.AssurancePlan#getName <em>Name</em>}' attribute.
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
   * @see org.osate.alisa.workbench.alisa.AlisaPackage#getAssurancePlan_Title()
   * @model
   * @generated
   */
  String getTitle();

  /**
   * Sets the value of the '{@link org.osate.alisa.workbench.alisa.AssurancePlan#getTitle <em>Title</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Title</em>' attribute.
   * @see #getTitle()
   * @generated
   */
  void setTitle(String value);

  /**
   * Returns the value of the '<em><b>System</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>System</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>System</em>' reference.
   * @see #setSystem(ComponentImplementation)
   * @see org.osate.alisa.workbench.alisa.AlisaPackage#getAssurancePlan_System()
   * @model
   * @generated
   */
  ComponentImplementation getSystem();

  /**
   * Sets the value of the '{@link org.osate.alisa.workbench.alisa.AssurancePlan#getSystem <em>System</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>System</em>' reference.
   * @see #getSystem()
   * @generated
   */
  void setSystem(ComponentImplementation value);

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
   * @see org.osate.alisa.workbench.alisa.AlisaPackage#getAssurancePlan_Description()
   * @model containment="true"
   * @generated
   */
  Description getDescription();

  /**
   * Sets the value of the '{@link org.osate.alisa.workbench.alisa.AssurancePlan#getDescription <em>Description</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Description</em>' containment reference.
   * @see #getDescription()
   * @generated
   */
  void setDescription(Description value);

  /**
   * Returns the value of the '<em><b>Subsystem Plans</b></em>' reference list.
   * The list contents are of type {@link org.osate.alisa.workbench.alisa.AssurancePlan}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Subsystem Plans</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Subsystem Plans</em>' reference list.
   * @see org.osate.alisa.workbench.alisa.AlisaPackage#getAssurancePlan_SubsystemPlans()
   * @model
   * @generated
   */
  EList<AssurancePlan> getSubsystemPlans();

  /**
   * Returns the value of the '<em><b>Verified Assumption</b></em>' reference list.
   * The list contents are of type {@link org.osate.alisa.workbench.alisa.AssurancePlan}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Verified Assumption</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Verified Assumption</em>' reference list.
   * @see org.osate.alisa.workbench.alisa.AlisaPackage#getAssurancePlan_VerifiedAssumption()
   * @model
   * @generated
   */
  EList<AssurancePlan> getVerifiedAssumption();

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
   * @see org.osate.alisa.workbench.alisa.AlisaPackage#getAssurancePlan_Issues()
   * @model unique="false"
   * @generated
   */
  EList<String> getIssues();

} // AssurancePlan
