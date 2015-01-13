/**
 */
package org.osate.verify.verify;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>All Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.verify.verify.AllExpr#getAll <em>All</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.verify.verify.VerifyPackage#getAllExpr()
 * @model
 * @generated
 */
public interface AllExpr extends ArgumentExpr
{
  /**
   * Returns the value of the '<em><b>All</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.verify.verify.ArgumentExpr}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>All</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>All</em>' containment reference list.
   * @see org.osate.verify.verify.VerifyPackage#getAllExpr_All()
   * @model containment="true"
   * @generated
   */
  EList<ArgumentExpr> getAll();

} // AllExpr
