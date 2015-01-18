/**
 */
package org.osate.alisa.workbench.alisa;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>And Selection Condition Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.alisa.workbench.alisa.AndSelectionConditionExpr#getLeft <em>Left</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.AndSelectionConditionExpr#getRight <em>Right</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.alisa.workbench.alisa.AlisaPackage#getAndSelectionConditionExpr()
 * @model
 * @generated
 */
public interface AndSelectionConditionExpr extends SelectionConditionExpr
{
  /**
   * Returns the value of the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Left</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Left</em>' containment reference.
   * @see #setLeft(SelectionConditionExpr)
   * @see org.osate.alisa.workbench.alisa.AlisaPackage#getAndSelectionConditionExpr_Left()
   * @model containment="true"
   * @generated
   */
  SelectionConditionExpr getLeft();

  /**
   * Sets the value of the '{@link org.osate.alisa.workbench.alisa.AndSelectionConditionExpr#getLeft <em>Left</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Left</em>' containment reference.
   * @see #getLeft()
   * @generated
   */
  void setLeft(SelectionConditionExpr value);

  /**
   * Returns the value of the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Right</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Right</em>' containment reference.
   * @see #setRight(SelectionConditionExpr)
   * @see org.osate.alisa.workbench.alisa.AlisaPackage#getAndSelectionConditionExpr_Right()
   * @model containment="true"
   * @generated
   */
  SelectionConditionExpr getRight();

  /**
   * Sets the value of the '{@link org.osate.alisa.workbench.alisa.AndSelectionConditionExpr#getRight <em>Right</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Right</em>' containment reference.
   * @see #getRight()
   * @generated
   */
  void setRight(SelectionConditionExpr value);

} // AndSelectionConditionExpr
