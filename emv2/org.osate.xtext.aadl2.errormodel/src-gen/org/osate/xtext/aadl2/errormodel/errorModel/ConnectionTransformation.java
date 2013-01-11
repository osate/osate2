/**
 */
package org.osate.xtext.aadl2.errormodel.errorModel;

import org.eclipse.emf.ecore.EObject;

import org.osate.aadl2.Element;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Connection Transformation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ConnectionTransformation#getTypeTransformationSet <em>Type Transformation Set</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getConnectionTransformation()
 * @model
 * @generated
 */
public interface ConnectionTransformation extends EObject, Element
{
  /**
	 * Returns the value of the '<em><b>Type Transformation Set</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type Transformation Set</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Transformation Set</em>' reference.
	 * @see #setTypeTransformationSet(TypeTransformationSet)
	 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getConnectionTransformation_TypeTransformationSet()
	 * @model
	 * @generated
	 */
  TypeTransformationSet getTypeTransformationSet();

  /**
	 * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.ConnectionTransformation#getTypeTransformationSet <em>Type Transformation Set</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Transformation Set</em>' reference.
	 * @see #getTypeTransformationSet()
	 * @generated
	 */
  void setTypeTransformationSet(TypeTransformationSet value);

} // ConnectionTransformation
