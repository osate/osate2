/**
 */
package org.osate.alisa.common.common;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Predicate Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.alisa.common.common.PredicateExpression#getOp <em>Op</em>}</li>
 *   <li>{@link org.osate.alisa.common.common.PredicateExpression#getLimit <em>Limit</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.alisa.common.common.CommonPackage#getPredicateExpression()
 * @model
 * @generated
 */
public interface PredicateExpression extends EObject
{
  /**
   * Returns the value of the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Op</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Op</em>' attribute.
   * @see #setOp(String)
   * @see org.osate.alisa.common.common.CommonPackage#getPredicateExpression_Op()
   * @model
   * @generated
   */
  String getOp();

  /**
   * Sets the value of the '{@link org.osate.alisa.common.common.PredicateExpression#getOp <em>Op</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Op</em>' attribute.
   * @see #getOp()
   * @generated
   */
  void setOp(String value);

  /**
   * Returns the value of the '<em><b>Limit</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Limit</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Limit</em>' reference.
   * @see #setLimit(ConstantDecl)
   * @see org.osate.alisa.common.common.CommonPackage#getPredicateExpression_Limit()
   * @model
   * @generated
   */
  ConstantDecl getLimit();

  /**
   * Sets the value of the '{@link org.osate.alisa.common.common.PredicateExpression#getLimit <em>Limit</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Limit</em>' reference.
   * @see #getLimit()
   * @generated
   */
  void setLimit(ConstantDecl value);

} // PredicateExpression
