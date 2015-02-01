/**
 */
package org.osate.verify.verify;

import org.eclipse.emf.common.util.EList;

import org.osate.categories.categories.VerificationCategory;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Verification Method</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.verify.verify.VerificationMethod#getMethodType <em>Method Type</em>}</li>
 *   <li>{@link org.osate.verify.verify.VerificationMethod#getMethodPath <em>Method Path</em>}</li>
 *   <li>{@link org.osate.verify.verify.VerificationMethod#getMarker <em>Marker</em>}</li>
 *   <li>{@link org.osate.verify.verify.VerificationMethod#getCategory <em>Category</em>}</li>
 *   <li>{@link org.osate.verify.verify.VerificationMethod#getConditions <em>Conditions</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.verify.verify.VerifyPackage#getVerificationMethod()
 * @model
 * @generated
 */
public interface VerificationMethod extends VerificationAction
{
  /**
   * Returns the value of the '<em><b>Method Type</b></em>' attribute.
   * The literals are from the enumeration {@link org.osate.verify.verify.SupportedTypes}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Method Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Method Type</em>' attribute.
   * @see org.osate.verify.verify.SupportedTypes
   * @see #setMethodType(SupportedTypes)
   * @see org.osate.verify.verify.VerifyPackage#getVerificationMethod_MethodType()
   * @model
   * @generated
   */
  SupportedTypes getMethodType();

  /**
   * Sets the value of the '{@link org.osate.verify.verify.VerificationMethod#getMethodType <em>Method Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Method Type</em>' attribute.
   * @see org.osate.verify.verify.SupportedTypes
   * @see #getMethodType()
   * @generated
   */
  void setMethodType(SupportedTypes value);

  /**
   * Returns the value of the '<em><b>Method Path</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Method Path</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Method Path</em>' attribute.
   * @see #setMethodPath(String)
   * @see org.osate.verify.verify.VerifyPackage#getVerificationMethod_MethodPath()
   * @model
   * @generated
   */
  String getMethodPath();

  /**
   * Sets the value of the '{@link org.osate.verify.verify.VerificationMethod#getMethodPath <em>Method Path</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Method Path</em>' attribute.
   * @see #getMethodPath()
   * @generated
   */
  void setMethodPath(String value);

  /**
   * Returns the value of the '<em><b>Marker</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Marker</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Marker</em>' attribute.
   * @see #setMarker(String)
   * @see org.osate.verify.verify.VerifyPackage#getVerificationMethod_Marker()
   * @model
   * @generated
   */
  String getMarker();

  /**
   * Sets the value of the '{@link org.osate.verify.verify.VerificationMethod#getMarker <em>Marker</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Marker</em>' attribute.
   * @see #getMarker()
   * @generated
   */
  void setMarker(String value);

  /**
   * Returns the value of the '<em><b>Category</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Category</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Category</em>' reference.
   * @see #setCategory(VerificationCategory)
   * @see org.osate.verify.verify.VerifyPackage#getVerificationMethod_Category()
   * @model
   * @generated
   */
  VerificationCategory getCategory();

  /**
   * Sets the value of the '{@link org.osate.verify.verify.VerificationMethod#getCategory <em>Category</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Category</em>' reference.
   * @see #getCategory()
   * @generated
   */
  void setCategory(VerificationCategory value);

  /**
   * Returns the value of the '<em><b>Conditions</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.verify.verify.VerificationCondition}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Conditions</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Conditions</em>' containment reference list.
   * @see org.osate.verify.verify.VerifyPackage#getVerificationMethod_Conditions()
   * @model containment="true"
   * @generated
   */
  EList<VerificationCondition> getConditions();

} // VerificationMethod
