/**
 */
package org.osate.verify.verify;

import org.osate.aadl2.ComponentClassifier;

import org.osate.alisa.common.common.Description;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Verification Library</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.verify.verify.VerificationLibrary#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.verify.verify.VerificationLibrary#getTarget <em>Target</em>}</li>
 *   <li>{@link org.osate.verify.verify.VerificationLibrary#getTitle <em>Title</em>}</li>
 *   <li>{@link org.osate.verify.verify.VerificationLibrary#getDescription <em>Description</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.verify.verify.VerifyPackage#getVerificationLibrary()
 * @model
 * @generated
 */
public interface VerificationLibrary extends VerificationContainer
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
   * @see org.osate.verify.verify.VerifyPackage#getVerificationLibrary_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.osate.verify.verify.VerificationLibrary#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Target</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Target</em>' reference.
   * @see #setTarget(ComponentClassifier)
   * @see org.osate.verify.verify.VerifyPackage#getVerificationLibrary_Target()
   * @model
   * @generated
   */
  ComponentClassifier getTarget();

  /**
   * Sets the value of the '{@link org.osate.verify.verify.VerificationLibrary#getTarget <em>Target</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target</em>' reference.
   * @see #getTarget()
   * @generated
   */
  void setTarget(ComponentClassifier value);

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
   * @see org.osate.verify.verify.VerifyPackage#getVerificationLibrary_Title()
   * @model
   * @generated
   */
  String getTitle();

  /**
   * Sets the value of the '{@link org.osate.verify.verify.VerificationLibrary#getTitle <em>Title</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Title</em>' attribute.
   * @see #getTitle()
   * @generated
   */
  void setTitle(String value);

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
   * @see org.osate.verify.verify.VerifyPackage#getVerificationLibrary_Description()
   * @model containment="true"
   * @generated
   */
  Description getDescription();

  /**
   * Sets the value of the '{@link org.osate.verify.verify.VerificationLibrary#getDescription <em>Description</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Description</em>' containment reference.
   * @see #getDescription()
   * @generated
   */
  void setDescription(Description value);

} // VerificationLibrary
