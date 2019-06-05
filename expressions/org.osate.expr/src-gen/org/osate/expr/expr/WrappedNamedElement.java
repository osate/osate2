/**
 */
package org.osate.expr.expr;

import org.osate.aadl2.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Wrapped Named Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.expr.expr.WrappedNamedElement#getElem <em>Elem</em>}</li>
 * </ul>
 *
 * @see org.osate.expr.expr.ExprPackage#getWrappedNamedElement()
 * @model
 * @generated
 */
public interface WrappedNamedElement extends Value
{
  /**
   * Returns the value of the '<em><b>Elem</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Elem</em>' reference.
   * @see #setElem(NamedElement)
   * @see org.osate.expr.expr.ExprPackage#getWrappedNamedElement_Elem()
   * @model
   * @generated
   */
  NamedElement getElem();

  /**
   * Sets the value of the '{@link org.osate.expr.expr.WrappedNamedElement#getElem <em>Elem</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Elem</em>' reference.
   * @see #getElem()
   * @generated
   */
  void setElem(NamedElement value);

} // WrappedNamedElement
