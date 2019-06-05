/**
 */
package org.osate.expr.expr;

import org.eclipse.emf.ecore.EObject;

import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Type;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Field</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.expr.expr.Field#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see org.osate.expr.expr.ExprPackage#getField()
 * @model
 * @generated
 */
public interface Field extends EObject, NamedElement
{
  /**
   * Returns the value of the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' containment reference.
   * @see #setType(Type)
   * @see org.osate.expr.expr.ExprPackage#getField_Type()
   * @model containment="true"
   * @generated
   */
  Type getType();

  /**
   * Sets the value of the '{@link org.osate.expr.expr.Field#getType <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' containment reference.
   * @see #getType()
   * @generated
   */
  void setType(Type value);

} // Field
