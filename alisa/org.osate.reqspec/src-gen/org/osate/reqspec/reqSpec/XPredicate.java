/**
 */
package org.osate.reqspec.reqSpec;

<<<<<<< HEAD
import org.osate.aadl2.PropertyExpression;
=======
import org.osate.alisa.common.common.AExpression;
>>>>>>> refs/remotes/origin/PeterWork

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XPredicate</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.reqspec.reqSpec.XPredicate#getXpression <em>Xpression</em>}</li>
 * </ul>
 *
 * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getXPredicate()
 * @model
 * @generated
 */
public interface XPredicate extends ReqPredicate
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
<<<<<<< HEAD
   * @see #setXpression(PropertyExpression)
=======
   * @see #setXpression(AExpression)
>>>>>>> refs/remotes/origin/PeterWork
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getXPredicate_Xpression()
   * @model containment="true"
   * @generated
   */
<<<<<<< HEAD
  PropertyExpression getXpression();
=======
  AExpression getXpression();
>>>>>>> refs/remotes/origin/PeterWork

  /**
   * Sets the value of the '{@link org.osate.reqspec.reqSpec.XPredicate#getXpression <em>Xpression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Xpression</em>' containment reference.
   * @see #getXpression()
   * @generated
   */
<<<<<<< HEAD
  void setXpression(PropertyExpression value);
=======
  void setXpression(AExpression value);
>>>>>>> refs/remotes/origin/PeterWork

} // XPredicate
