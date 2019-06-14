/**
 */
package org.osate.expr.expr;

import org.eclipse.emf.common.util.EList;

import org.osate.aadl2.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Named Element Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.expr.expr.NamedElementRef#isCore <em>Core</em>}</li>
 *   <li>{@link org.osate.expr.expr.NamedElementRef#getRef <em>Ref</em>}</li>
 *   <li>{@link org.osate.expr.expr.NamedElementRef#getArgs <em>Args</em>}</li>
 * </ul>
 *
 * @see org.osate.expr.expr.ExprPackage#getNamedElementRef()
 * @model
 * @generated
 */
public interface NamedElementRef extends Expression
{
  /**
   * Returns the value of the '<em><b>Core</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Core</em>' attribute.
   * @see #setCore(boolean)
   * @see org.osate.expr.expr.ExprPackage#getNamedElementRef_Core()
   * @model
   * @generated
   */
  boolean isCore();

  /**
   * Sets the value of the '{@link org.osate.expr.expr.NamedElementRef#isCore <em>Core</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Core</em>' attribute.
   * @see #isCore()
   * @generated
   */
  void setCore(boolean value);

  /**
   * Returns the value of the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ref</em>' reference.
   * @see #setRef(NamedElement)
   * @see org.osate.expr.expr.ExprPackage#getNamedElementRef_Ref()
   * @model
   * @generated
   */
  NamedElement getRef();

  /**
   * Sets the value of the '{@link org.osate.expr.expr.NamedElementRef#getRef <em>Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ref</em>' reference.
   * @see #getRef()
   * @generated
   */
  void setRef(NamedElement value);

  /**
   * Returns the value of the '<em><b>Args</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.expr.expr.Expression}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Args</em>' containment reference list.
   * @see org.osate.expr.expr.ExprPackage#getNamedElementRef_Args()
   * @model containment="true"
   * @generated
   */
  EList<Expression> getArgs();

} // NamedElementRef
