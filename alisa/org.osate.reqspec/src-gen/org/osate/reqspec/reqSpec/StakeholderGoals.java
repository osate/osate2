/**
 */
package org.osate.reqspec.reqSpec;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.osate.aadl2.Classifier;

import org.osate.alisa.common.common.Description;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Stakeholder Goals</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.reqspec.reqSpec.StakeholderGoals#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.StakeholderGoals#getTitle <em>Title</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.StakeholderGoals#getTarget <em>Target</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.StakeholderGoals#getTargetDescription <em>Target Description</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.StakeholderGoals#isGlobal <em>Global</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.StakeholderGoals#getDescription <em>Description</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.StakeholderGoals#getContent <em>Content</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.StakeholderGoals#getIssues <em>Issues</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getStakeholderGoals()
 * @model
 * @generated
 */
public interface StakeholderGoals extends ReqSpecContainer, ReqRoot
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
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getStakeholderGoals_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.osate.reqspec.reqSpec.StakeholderGoals#getName <em>Name</em>}' attribute.
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
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getStakeholderGoals_Title()
   * @model
   * @generated
   */
  String getTitle();

  /**
   * Sets the value of the '{@link org.osate.reqspec.reqSpec.StakeholderGoals#getTitle <em>Title</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Title</em>' attribute.
   * @see #getTitle()
   * @generated
   */
  void setTitle(String value);

  /**
   * Returns the value of the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Target</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Target</em>' reference.
   * @see #setTarget(Classifier)
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getStakeholderGoals_Target()
   * @model
   * @generated
   */
  Classifier getTarget();

  /**
   * Sets the value of the '{@link org.osate.reqspec.reqSpec.StakeholderGoals#getTarget <em>Target</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target</em>' reference.
   * @see #getTarget()
   * @generated
   */
  void setTarget(Classifier value);

  /**
   * Returns the value of the '<em><b>Target Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Target Description</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Target Description</em>' attribute.
   * @see #setTargetDescription(String)
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getStakeholderGoals_TargetDescription()
   * @model
   * @generated
   */
  String getTargetDescription();

  /**
   * Sets the value of the '{@link org.osate.reqspec.reqSpec.StakeholderGoals#getTargetDescription <em>Target Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target Description</em>' attribute.
   * @see #getTargetDescription()
   * @generated
   */
  void setTargetDescription(String value);

  /**
   * Returns the value of the '<em><b>Global</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Global</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Global</em>' attribute.
   * @see #setGlobal(boolean)
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getStakeholderGoals_Global()
   * @model
   * @generated
   */
  boolean isGlobal();

  /**
   * Sets the value of the '{@link org.osate.reqspec.reqSpec.StakeholderGoals#isGlobal <em>Global</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Global</em>' attribute.
   * @see #isGlobal()
   * @generated
   */
  void setGlobal(boolean value);

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
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getStakeholderGoals_Description()
   * @model containment="true"
   * @generated
   */
  Description getDescription();

  /**
   * Sets the value of the '{@link org.osate.reqspec.reqSpec.StakeholderGoals#getDescription <em>Description</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Description</em>' containment reference.
   * @see #getDescription()
   * @generated
   */
  void setDescription(Description value);

  /**
   * Returns the value of the '<em><b>Content</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Content</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Content</em>' containment reference list.
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getStakeholderGoals_Content()
   * @model containment="true"
   * @generated
   */
  EList<EObject> getContent();

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
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getStakeholderGoals_Issues()
   * @model unique="false"
   * @generated
   */
  EList<String> getIssues();

} // StakeholderGoals
