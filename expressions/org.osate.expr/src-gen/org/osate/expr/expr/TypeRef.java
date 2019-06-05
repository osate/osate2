/**
 */
package org.osate.expr.expr;

import org.eclipse.emf.ecore.EObject;

import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Type;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.expr.expr.TypeRef#getRef <em>Ref</em>}</li>
 * </ul>
 *
 * @see org.osate.expr.expr.ExprPackage#getTypeRef()
 * @model
 * @generated
 */
public interface TypeRef extends EObject, Type
{
  /**
   * Returns the value of the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ref</em>' reference.
   * @see #setRef(NamedElement)
   * @see org.osate.expr.expr.ExprPackage#getTypeRef_Ref()
   * @model
   * @generated
   */
  NamedElement getRef();

  /**
   * Sets the value of the '{@link org.osate.expr.expr.TypeRef#getRef <em>Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ref</em>' reference.
   * @see #getRef()
   * @generated
   */
  void setRef(NamedElement value);

} // TypeRef
