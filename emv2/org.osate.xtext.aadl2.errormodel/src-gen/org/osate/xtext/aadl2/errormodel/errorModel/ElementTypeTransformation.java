/**
 * <copyright>
 * </copyright>
 *
 */
package org.osate.xtext.aadl2.errormodel.errorModel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element Type Transformation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ElementTypeTransformation#getSource <em>Source</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ElementTypeTransformation#getContributor <em>Contributor</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ElementTypeTransformation#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getElementTypeTransformation()
 * @model
 * @generated
 */
public interface ElementTypeTransformation extends TypeTransformation
{
  /**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Source</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(ErrorType)
	 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getElementTypeTransformation_Source()
	 * @model
	 * @generated
	 */
  ErrorType getSource();

  /**
	 * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.ElementTypeTransformation#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
  void setSource(ErrorType value);

  /**
	 * Returns the value of the '<em><b>Contributor</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Contributor</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Contributor</em>' reference.
	 * @see #setContributor(ErrorType)
	 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getElementTypeTransformation_Contributor()
	 * @model
	 * @generated
	 */
  ErrorType getContributor();

  /**
	 * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.ElementTypeTransformation#getContributor <em>Contributor</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Contributor</em>' reference.
	 * @see #getContributor()
	 * @generated
	 */
  void setContributor(ErrorType value);

  /**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Target</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(ErrorType)
	 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getElementTypeTransformation_Target()
	 * @model
	 * @generated
	 */
  ErrorType getTarget();

  /**
	 * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.ElementTypeTransformation#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
  void setTarget(ErrorType value);

} // ElementTypeTransformation
