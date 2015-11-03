/**
 */
package org.osate.xtext.aadl2.errormodel.errorModel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Error Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorType#getSuperType <em>Super Type</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorType#getAliasedType <em>Aliased Type</em>}</li>
 * </ul>
 *
 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorType()
 * @model
 * @generated
 */
public interface ErrorType extends ErrorTypes
{
  /**
   * Returns the value of the '<em><b>Super Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Super Type</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Super Type</em>' reference.
   * @see #setSuperType(ErrorType)
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorType_SuperType()
   * @model
   * @generated
   */
  ErrorType getSuperType();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorType#getSuperType <em>Super Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Super Type</em>' reference.
   * @see #getSuperType()
   * @generated
   */
  void setSuperType(ErrorType value);

  /**
   * Returns the value of the '<em><b>Aliased Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Aliased Type</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Aliased Type</em>' reference.
   * @see #setAliasedType(ErrorType)
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorType_AliasedType()
   * @model
   * @generated
   */
  ErrorType getAliasedType();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorType#getAliasedType <em>Aliased Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Aliased Type</em>' reference.
   * @see #getAliasedType()
   * @generated
   */
  void setAliasedType(ErrorType value);

} // ErrorType
