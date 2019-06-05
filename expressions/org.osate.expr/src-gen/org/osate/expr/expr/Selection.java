/**
 */
package org.osate.expr.expr;

import org.eclipse.emf.common.util.EList;

import org.osate.aadl2.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Selection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.expr.expr.Selection#getReceiver <em>Receiver</em>}</li>
 *   <li>{@link org.osate.expr.expr.Selection#getRef <em>Ref</em>}</li>
 *   <li>{@link org.osate.expr.expr.Selection#getArgs <em>Args</em>}</li>
 * </ul>
 *
 * @see org.osate.expr.expr.ExprPackage#getSelection()
 * @model
 * @generated
 */
public interface Selection extends Expression
{
  /**
   * Returns the value of the '<em><b>Receiver</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Receiver</em>' containment reference.
   * @see #setReceiver(Expression)
   * @see org.osate.expr.expr.ExprPackage#getSelection_Receiver()
   * @model containment="true"
   * @generated
   */
  Expression getReceiver();

  /**
   * Sets the value of the '{@link org.osate.expr.expr.Selection#getReceiver <em>Receiver</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Receiver</em>' containment reference.
   * @see #getReceiver()
   * @generated
   */
  void setReceiver(Expression value);

  /**
   * Returns the value of the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ref</em>' reference.
   * @see #setRef(NamedElement)
   * @see org.osate.expr.expr.ExprPackage#getSelection_Ref()
   * @model
   * @generated
   */
  NamedElement getRef();

  /**
   * Sets the value of the '{@link org.osate.expr.expr.Selection#getRef <em>Ref</em>}' reference.
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
   * @see org.osate.expr.expr.ExprPackage#getSelection_Args()
   * @model containment="true"
   * @generated
   */
  EList<Expression> getArgs();

} // Selection
