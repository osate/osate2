/**
 */
package org.osate.verify.verify;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.common.types.JvmFormalParameter;

import org.osate.aadl2.Property;

import org.osate.alisa.common.common.Description;

import org.osate.categories.categories.Category;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Verification Method</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.verify.verify.VerificationMethod#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.verify.verify.VerificationMethod#getParams <em>Params</em>}</li>
 *   <li>{@link org.osate.verify.verify.VerificationMethod#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.osate.verify.verify.VerificationMethod#isIsPredicate <em>Is Predicate</em>}</li>
 *   <li>{@link org.osate.verify.verify.VerificationMethod#isIsResultReport <em>Is Result Report</em>}</li>
 *   <li>{@link org.osate.verify.verify.VerificationMethod#getTitle <em>Title</em>}</li>
 *   <li>{@link org.osate.verify.verify.VerificationMethod#getMethodType <em>Method Type</em>}</li>
 *   <li>{@link org.osate.verify.verify.VerificationMethod#getDescription <em>Description</em>}</li>
 *   <li>{@link org.osate.verify.verify.VerificationMethod#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.osate.verify.verify.VerificationMethod#getCategory <em>Category</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.verify.verify.VerifyPackage#getVerificationMethod()
 * @model
 * @generated
 */
public interface VerificationMethod extends EObject
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
   * @see org.osate.verify.verify.VerifyPackage#getVerificationMethod_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.osate.verify.verify.VerificationMethod#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Params</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.common.types.JvmFormalParameter}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Params</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Params</em>' containment reference list.
   * @see org.osate.verify.verify.VerifyPackage#getVerificationMethod_Params()
   * @model containment="true"
   * @generated
   */
  EList<JvmFormalParameter> getParams();

  /**
   * Returns the value of the '<em><b>Properties</b></em>' reference list.
   * The list contents are of type {@link org.osate.aadl2.Property}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Properties</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Properties</em>' reference list.
   * @see org.osate.verify.verify.VerifyPackage#getVerificationMethod_Properties()
   * @model
   * @generated
   */
  EList<Property> getProperties();

  /**
   * Returns the value of the '<em><b>Is Predicate</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Is Predicate</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Is Predicate</em>' attribute.
   * @see #setIsPredicate(boolean)
   * @see org.osate.verify.verify.VerifyPackage#getVerificationMethod_IsPredicate()
   * @model
   * @generated
   */
  boolean isIsPredicate();

  /**
   * Sets the value of the '{@link org.osate.verify.verify.VerificationMethod#isIsPredicate <em>Is Predicate</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Is Predicate</em>' attribute.
   * @see #isIsPredicate()
   * @generated
   */
  void setIsPredicate(boolean value);

  /**
   * Returns the value of the '<em><b>Is Result Report</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Is Result Report</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Is Result Report</em>' attribute.
   * @see #setIsResultReport(boolean)
   * @see org.osate.verify.verify.VerifyPackage#getVerificationMethod_IsResultReport()
   * @model
   * @generated
   */
  boolean isIsResultReport();

  /**
   * Sets the value of the '{@link org.osate.verify.verify.VerificationMethod#isIsResultReport <em>Is Result Report</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Is Result Report</em>' attribute.
   * @see #isIsResultReport()
   * @generated
   */
  void setIsResultReport(boolean value);

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
   * @see org.osate.verify.verify.VerifyPackage#getVerificationMethod_Title()
   * @model
   * @generated
   */
  String getTitle();

  /**
   * Sets the value of the '{@link org.osate.verify.verify.VerificationMethod#getTitle <em>Title</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Title</em>' attribute.
   * @see #getTitle()
   * @generated
   */
  void setTitle(String value);

  /**
   * Returns the value of the '<em><b>Method Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Method Type</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Method Type</em>' containment reference.
   * @see #setMethodType(MethodType)
   * @see org.osate.verify.verify.VerifyPackage#getVerificationMethod_MethodType()
   * @model containment="true"
   * @generated
   */
  MethodType getMethodType();

  /**
   * Sets the value of the '{@link org.osate.verify.verify.VerificationMethod#getMethodType <em>Method Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Method Type</em>' containment reference.
   * @see #getMethodType()
   * @generated
   */
  void setMethodType(MethodType value);

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
   * @see org.osate.verify.verify.VerifyPackage#getVerificationMethod_Description()
   * @model containment="true"
   * @generated
   */
  Description getDescription();

  /**
   * Sets the value of the '{@link org.osate.verify.verify.VerificationMethod#getDescription <em>Description</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Description</em>' containment reference.
   * @see #getDescription()
   * @generated
   */
  void setDescription(Description value);

  /**
   * Returns the value of the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Condition</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Condition</em>' containment reference.
   * @see #setCondition(VerificationCondition)
   * @see org.osate.verify.verify.VerifyPackage#getVerificationMethod_Condition()
   * @model containment="true"
   * @generated
   */
  VerificationCondition getCondition();

  /**
   * Sets the value of the '{@link org.osate.verify.verify.VerificationMethod#getCondition <em>Condition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Condition</em>' containment reference.
   * @see #getCondition()
   * @generated
   */
  void setCondition(VerificationCondition value);

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
   * @see org.osate.verify.verify.VerifyPackage#getVerificationMethod_Category()
   * @model
   * @generated
   */
  EList<Category> getCategory();

} // VerificationMethod
