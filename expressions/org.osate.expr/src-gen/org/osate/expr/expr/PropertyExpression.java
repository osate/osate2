/**
 */
package org.osate.expr.expr;

import org.osate.aadl2.AbstractNamedValue;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.expr.expr.PropertyExpression#getModelElement <em>Model Element</em>}</li>
 *   <li>{@link org.osate.expr.expr.PropertyExpression#getProperty <em>Property</em>}</li>
 * </ul>
 *
 * @see org.osate.expr.expr.ExprPackage#getPropertyExpression()
 * @model
 * @generated
 */
public interface PropertyExpression extends Expression
{
  /**
   * Returns the value of the '<em><b>Model Element</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Model Element</em>' containment reference.
   * @see #setModelElement(Expression)
   * @see org.osate.expr.expr.ExprPackage#getPropertyExpression_ModelElement()
   * @model containment="true"
   * @generated
   */
  Expression getModelElement();

  /**
   * Sets the value of the '{@link org.osate.expr.expr.PropertyExpression#getModelElement <em>Model Element</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Model Element</em>' containment reference.
   * @see #getModelElement()
   * @generated
   */
  void setModelElement(Expression value);

  /**
   * Returns the value of the '<em><b>Property</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Property</em>' reference.
   * @see #setProperty(AbstractNamedValue)
   * @see org.osate.expr.expr.ExprPackage#getPropertyExpression_Property()
   * @model
   * @generated
   */
  AbstractNamedValue getProperty();

  /**
   * Sets the value of the '{@link org.osate.expr.expr.PropertyExpression#getProperty <em>Property</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Property</em>' reference.
   * @see #getProperty()
   * @generated
   */
  void setProperty(AbstractNamedValue value);

} // PropertyExpression
