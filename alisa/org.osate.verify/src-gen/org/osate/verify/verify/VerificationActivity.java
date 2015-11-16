/**
 */
package org.osate.verify.verify;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.osate.aadl2.ComponentImplementation;

import org.osate.alisa.common.common.ComputeDeclaration;
import org.osate.alisa.common.common.ValDeclaration;

import org.osate.categories.categories.Category;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Verification Activity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.verify.verify.VerificationActivity#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.verify.verify.VerificationActivity#getTitle <em>Title</em>}</li>
 *   <li>{@link org.osate.verify.verify.VerificationActivity#getTarget <em>Target</em>}</li>
 *   <li>{@link org.osate.verify.verify.VerificationActivity#getCategory <em>Category</em>}</li>
 *   <li>{@link org.osate.verify.verify.VerificationActivity#getResult <em>Result</em>}</li>
 *   <li>{@link org.osate.verify.verify.VerificationActivity#getMethod <em>Method</em>}</li>
 *   <li>{@link org.osate.verify.verify.VerificationActivity#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.osate.verify.verify.VerificationActivity#getPropertyValues <em>Property Values</em>}</li>
 *   <li>{@link org.osate.verify.verify.VerificationActivity#getTimeout <em>Timeout</em>}</li>
 * </ul>
 *
 * @see org.osate.verify.verify.VerifyPackage#getVerificationActivity()
 * @model
 * @generated
 */
public interface VerificationActivity extends EObject
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
   * @see org.osate.verify.verify.VerifyPackage#getVerificationActivity_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.osate.verify.verify.VerificationActivity#getName <em>Name</em>}' attribute.
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
   * @see org.osate.verify.verify.VerifyPackage#getVerificationActivity_Title()
   * @model
   * @generated
   */
  String getTitle();

  /**
   * Sets the value of the '{@link org.osate.verify.verify.VerificationActivity#getTitle <em>Title</em>}' attribute.
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
   * @see #setTarget(ComponentImplementation)
   * @see org.osate.verify.verify.VerifyPackage#getVerificationActivity_Target()
   * @model
   * @generated
   */
  ComponentImplementation getTarget();

  /**
   * Sets the value of the '{@link org.osate.verify.verify.VerificationActivity#getTarget <em>Target</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target</em>' reference.
   * @see #getTarget()
   * @generated
   */
  void setTarget(ComponentImplementation value);

  /**
   * Returns the value of the '<em><b>Category</b></em>' reference list.
   * The list contents are of type {@link org.osate.categories.categories.Category}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Category</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Category</em>' reference list.
   * @see org.osate.verify.verify.VerifyPackage#getVerificationActivity_Category()
   * @model
   * @generated
   */
  EList<Category> getCategory();

  /**
   * Returns the value of the '<em><b>Result</b></em>' reference list.
   * The list contents are of type {@link org.osate.alisa.common.common.ComputeDeclaration}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Result</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Result</em>' reference list.
   * @see org.osate.verify.verify.VerifyPackage#getVerificationActivity_Result()
   * @model
   * @generated
   */
  EList<ComputeDeclaration> getResult();

  /**
   * Returns the value of the '<em><b>Method</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Method</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Method</em>' reference.
   * @see #setMethod(VerificationMethod)
   * @see org.osate.verify.verify.VerifyPackage#getVerificationActivity_Method()
   * @model
   * @generated
   */
  VerificationMethod getMethod();

  /**
   * Sets the value of the '{@link org.osate.verify.verify.VerificationActivity#getMethod <em>Method</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Method</em>' reference.
   * @see #getMethod()
   * @generated
   */
  void setMethod(VerificationMethod value);

  /**
   * Returns the value of the '<em><b>Parameters</b></em>' reference list.
   * The list contents are of type {@link org.osate.alisa.common.common.ValDeclaration}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parameters</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parameters</em>' reference list.
   * @see org.osate.verify.verify.VerifyPackage#getVerificationActivity_Parameters()
   * @model
   * @generated
   */
  EList<ValDeclaration> getParameters();

  /**
   * Returns the value of the '<em><b>Property Values</b></em>' reference list.
   * The list contents are of type {@link org.osate.alisa.common.common.ValDeclaration}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Property Values</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Property Values</em>' reference list.
   * @see org.osate.verify.verify.VerifyPackage#getVerificationActivity_PropertyValues()
   * @model
   * @generated
   */
  EList<ValDeclaration> getPropertyValues();

  /**
   * Returns the value of the '<em><b>Timeout</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Timeout</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Timeout</em>' attribute.
   * @see #setTimeout(int)
   * @see org.osate.verify.verify.VerifyPackage#getVerificationActivity_Timeout()
   * @model
   * @generated
   */
  int getTimeout();

  /**
   * Sets the value of the '{@link org.osate.verify.verify.VerificationActivity#getTimeout <em>Timeout</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Timeout</em>' attribute.
   * @see #getTimeout()
   * @generated
   */
  void setTimeout(int value);

} // VerificationActivity
