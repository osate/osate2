/**
 */
package org.osate.reqspec.reqSpec;

import org.eclipse.xtext.xbase.XExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XPredicate</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.reqspec.reqSpec.XPredicate#getXlambda <em>Xlambda</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getXPredicate()
 * @model
 * @generated
 */
public interface XPredicate extends ReqPredicate
{
  /**
   * Returns the value of the '<em><b>Xlambda</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Xlambda</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Xlambda</em>' containment reference.
   * @see #setXlambda(XExpression)
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getXPredicate_Xlambda()
   * @model containment="true"
   * @generated
   */
  XExpression getXlambda();

  /**
   * Sets the value of the '{@link org.osate.reqspec.reqSpec.XPredicate#getXlambda <em>Xlambda</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Xlambda</em>' containment reference.
   * @see #getXlambda()
   * @generated
   */
  void setXlambda(XExpression value);

} // XPredicate
