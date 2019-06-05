/**
 */
package org.osate.expr.expr;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Union Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.expr.expr.UnionLiteral#getFieldValue <em>Field Value</em>}</li>
 * </ul>
 *
 * @see org.osate.expr.expr.ExprPackage#getUnionLiteral()
 * @model
 * @generated
 */
public interface UnionLiteral extends Literal
{
  /**
   * Returns the value of the '<em><b>Field Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Field Value</em>' containment reference.
   * @see #setFieldValue(FieldValue)
   * @see org.osate.expr.expr.ExprPackage#getUnionLiteral_FieldValue()
   * @model containment="true"
   * @generated
   */
  FieldValue getFieldValue();

  /**
   * Sets the value of the '{@link org.osate.expr.expr.UnionLiteral#getFieldValue <em>Field Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Field Value</em>' containment reference.
   * @see #getFieldValue()
   * @generated
   */
  void setFieldValue(FieldValue value);

} // UnionLiteral
