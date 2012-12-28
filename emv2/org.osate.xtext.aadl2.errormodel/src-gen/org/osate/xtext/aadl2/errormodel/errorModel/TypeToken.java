/**
 * <copyright>
 * </copyright>
 *
 */
package org.osate.xtext.aadl2.errormodel.errorModel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.osate.aadl2.Element;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type Token</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.TypeToken#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getTypeToken()
 * @model
 * @generated
 */
public interface TypeToken extends EObject, Element
{
  /**
	 * Returns the value of the '<em><b>Type</b></em>' reference list.
	 * The list contents are of type {@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorType}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference list.
	 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getTypeToken_Type()
	 * @model
	 * @generated
	 */
  EList<ErrorType> getType();

} // TypeToken
