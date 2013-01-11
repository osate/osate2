/**
 */
package org.osate.xtext.aadl2.errormodel.errorModel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type Token Transformation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.TypeTokenTransformation#getSource <em>Source</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.TypeTokenTransformation#getContributor <em>Contributor</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.TypeTokenTransformation#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getTypeTokenTransformation()
 * @model
 * @generated
 */
public interface TypeTokenTransformation extends TypeTransformation
{
  /**
	 * Returns the value of the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Source</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' containment reference.
	 * @see #setSource(TypeSet)
	 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getTypeTokenTransformation_Source()
	 * @model containment="true"
	 * @generated
	 */
  TypeSet getSource();

  /**
	 * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.TypeTokenTransformation#getSource <em>Source</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' containment reference.
	 * @see #getSource()
	 * @generated
	 */
  void setSource(TypeSet value);

  /**
	 * Returns the value of the '<em><b>Contributor</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Contributor</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Contributor</em>' containment reference.
	 * @see #setContributor(TypeSet)
	 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getTypeTokenTransformation_Contributor()
	 * @model containment="true"
	 * @generated
	 */
  TypeSet getContributor();

  /**
	 * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.TypeTokenTransformation#getContributor <em>Contributor</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Contributor</em>' containment reference.
	 * @see #getContributor()
	 * @generated
	 */
  void setContributor(TypeSet value);

  /**
	 * Returns the value of the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Target</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' containment reference.
	 * @see #setTarget(TypeToken)
	 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getTypeTokenTransformation_Target()
	 * @model containment="true"
	 * @generated
	 */
  TypeToken getTarget();

  /**
	 * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.TypeTokenTransformation#getTarget <em>Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' containment reference.
	 * @see #getTarget()
	 * @generated
	 */
  void setTarget(TypeToken value);

} // TypeTokenTransformation
