/**
 */
package org.osate.alisa.common.common;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.osate.aadl2.PropertyExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ASet Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.alisa.common.common.ASetLiteral#getElements <em>Elements</em>}</li>
 * </ul>
 *
 * @see org.osate.alisa.common.common.CommonPackage#getASetLiteral()
 * @model
 * @generated
 */
public interface ASetLiteral extends EObject, PropertyExpression
{
  /**
   * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.aadl2.PropertyExpression}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Elements</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Elements</em>' containment reference list.
   * @see org.osate.alisa.common.common.CommonPackage#getASetLiteral_Elements()
   * @model containment="true"
   * @generated
   */
  EList<PropertyExpression> getElements();

} // ASetLiteral
