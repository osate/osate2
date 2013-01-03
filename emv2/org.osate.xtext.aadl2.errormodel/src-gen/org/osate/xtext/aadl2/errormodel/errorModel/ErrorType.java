/**
 */
package org.osate.xtext.aadl2.errormodel.errorModel;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Error Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorType#getSuperType <em>Super Type</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorType#getAliasedType <em>Aliased Type</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorType#getSubType <em>Sub Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorType()
 * @model
 * @generated
 */
public interface ErrorType extends ErrorTypes
{
  /**
	 * Returns the value of the '<em><b>Super Type</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorType#getSubType <em>Sub Type</em>}'.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Super Type</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Super Type</em>' reference.
	 * @see #setSuperType(ErrorType)
	 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorType_SuperType()
	 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorType#getSubType
	 * @model opposite="subType"
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

		/**
	 * Returns the value of the '<em><b>Sub Type</b></em>' reference list.
	 * The list contents are of type {@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorType}.
	 * It is bidirectional and its opposite is '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorType#getSuperType <em>Super Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Type</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Type</em>' reference list.
	 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorType_SubType()
	 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorType#getSuperType
	 * @model opposite="superType"
	 * @generated
	 */
	EList<ErrorType> getSubType();

} // ErrorType
