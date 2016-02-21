/**
 */
package org.osate.xtext.aadl2.errormodel.errorModel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EMV2 Path</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.EMV2Path#getPaTarget <em>Pa Target</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.EMV2Path#getErrorType <em>Error Type</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.EMV2Path#getEmv2Target <em>Emv2 Target</em>}</li>
 * </ul>
 *
 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getEMV2Path()
 * @model
 * @generated
 */
public interface EMV2Path extends EObject
{
  /**
   * Returns the value of the '<em><b>Pa Target</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Pa Target</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Pa Target</em>' attribute.
   * @see #setPaTarget(String)
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getEMV2Path_PaTarget()
   * @model
   * @generated
   */
  String getPaTarget();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.EMV2Path#getPaTarget <em>Pa Target</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Pa Target</em>' attribute.
   * @see #getPaTarget()
   * @generated
   */
  void setPaTarget(String value);

  /**
   * Returns the value of the '<em><b>Error Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Error Type</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Error Type</em>' reference.
   * @see #setErrorType(ErrorTypes)
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getEMV2Path_ErrorType()
   * @model
   * @generated
   */
  ErrorTypes getErrorType();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.EMV2Path#getErrorType <em>Error Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Error Type</em>' reference.
   * @see #getErrorType()
   * @generated
   */
  void setErrorType(ErrorTypes value);

  /**
   * Returns the value of the '<em><b>Emv2 Target</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.xtext.aadl2.errormodel.errorModel.EMV2PathElement}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Emv2 Target</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Emv2 Target</em>' containment reference list.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getEMV2Path_Emv2Target()
   * @model containment="true"
   * @generated
   */
  EList<EMV2PathElement> getEmv2Target();

} // EMV2Path
