/**
 */
package org.osate.expr.expr;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Block</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.expr.expr.Block#getDecls <em>Decls</em>}</li>
 *   <li>{@link org.osate.expr.expr.Block#getResult <em>Result</em>}</li>
 * </ul>
 *
 * @see org.osate.expr.expr.ExprPackage#getBlock()
 * @model
 * @generated
 */
public interface Block extends Expression
{
  /**
   * Returns the value of the '<em><b>Decls</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.expr.expr.VarDecl}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Decls</em>' containment reference list.
   * @see org.osate.expr.expr.ExprPackage#getBlock_Decls()
   * @model containment="true"
   * @generated
   */
  EList<VarDecl> getDecls();

  /**
   * Returns the value of the '<em><b>Result</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Result</em>' containment reference.
   * @see #setResult(Expression)
   * @see org.osate.expr.expr.ExprPackage#getBlock_Result()
   * @model containment="true"
   * @generated
   */
  Expression getResult();

  /**
   * Sets the value of the '{@link org.osate.expr.expr.Block#getResult <em>Result</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Result</em>' containment reference.
   * @see #getResult()
   * @generated
   */
  void setResult(Expression value);

} // Block
