/**
 */
package org.osate.verify.verify;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.common.types.JvmFormalParameter;

import org.osate.alisa.common.common.Description;

import org.osate.categories.categories.VerificationCategory;

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
 *   <li>{@link org.osate.verify.verify.VerificationMethod#getTitle <em>Title</em>}</li>
 *   <li>{@link org.osate.verify.verify.VerificationMethod#getMethodType <em>Method Type</em>}</li>
 *   <li>{@link org.osate.verify.verify.VerificationMethod#getScope <em>Scope</em>}</li>
 *   <li>{@link org.osate.verify.verify.VerificationMethod#getReporting <em>Reporting</em>}</li>
 *   <li>{@link org.osate.verify.verify.VerificationMethod#getDescription <em>Description</em>}</li>
 *   <li>{@link org.osate.verify.verify.VerificationMethod#getMethodPath <em>Method Path</em>}</li>
 *   <li>{@link org.osate.verify.verify.VerificationMethod#getConditions <em>Conditions</em>}</li>
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
   * Returns the value of the '<em><b>Scope</b></em>' attribute.
   * The literals are from the enumeration {@link org.osate.verify.verify.SupportedScopes}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Scope</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Scope</em>' attribute.
   * @see org.osate.verify.verify.SupportedScopes
   * @see #setScope(SupportedScopes)
   * @see org.osate.verify.verify.VerifyPackage#getVerificationMethod_Scope()
   * @model
   * @generated
   */
  SupportedScopes getScope();

  /**
   * Sets the value of the '{@link org.osate.verify.verify.VerificationMethod#getScope <em>Scope</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Scope</em>' attribute.
   * @see org.osate.verify.verify.SupportedScopes
   * @see #getScope()
   * @generated
   */
  void setScope(SupportedScopes value);

  /**
   * Returns the value of the '<em><b>Reporting</b></em>' attribute.
   * The literals are from the enumeration {@link org.osate.verify.verify.SupportedReporting}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Reporting</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Reporting</em>' attribute.
   * @see org.osate.verify.verify.SupportedReporting
   * @see #setReporting(SupportedReporting)
   * @see org.osate.verify.verify.VerifyPackage#getVerificationMethod_Reporting()
   * @model
   * @generated
   */
  SupportedReporting getReporting();

  /**
   * Sets the value of the '{@link org.osate.verify.verify.VerificationMethod#getReporting <em>Reporting</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Reporting</em>' attribute.
   * @see org.osate.verify.verify.SupportedReporting
   * @see #getReporting()
   * @generated
   */
  void setReporting(SupportedReporting value);

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

  /**
   * Returns the value of the '<em><b>Category</b></em>' reference list.
   * The list contents are of type {@link org.osate.categories.categories.VerificationCategory}.
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
  EList<VerificationCategory> getCategory();

} // VerificationMethod
