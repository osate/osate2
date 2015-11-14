/**
 */
package org.osate.reqspec.reqSpec;

import org.osate.aadl2.PropertyExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Value Predicate</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.reqspec.reqSpec.ValuePredicate#getXpression <em>Xpression</em>}</li>
 * </ul>
 *
 * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getValuePredicate()
 * @model
 * @generated
 */
public interface ValuePredicate extends ReqPredicate
{
  /**
   * Returns the value of the '<em><b>Xpression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Xpression</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Xpression</em>' containment reference.
   * @see #setXpression(PropertyExpression)
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getValuePredicate_Xpression()
   * @model containment="true"
   * @generated
   */
  PropertyExpression getXpression();

  /**
   * Sets the value of the '{@link org.osate.reqspec.reqSpec.ValuePredicate#getXpression <em>Xpression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Xpression</em>' containment reference.
   * @see #getXpression()
   * @generated
   */
  void setXpression(PropertyExpression value);

} // ValuePredicate
