/**
 */
package org.osate.expr.expr;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Set Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.expr.expr.SetLiteral#getElements <em>Elements</em>}</li>
 * </ul>
 *
 * @see org.osate.expr.expr.ExprPackage#getSetLiteral()
 * @model
 * @generated
 */
public interface SetLiteral extends Literal
{
  /**
   * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.expr.expr.Expression}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Elements</em>' containment reference list.
   * @see org.osate.expr.expr.ExprPackage#getSetLiteral_Elements()
   * @model containment="true"
   * @generated
   */
  EList<Expression> getElements();

} // SetLiteral
