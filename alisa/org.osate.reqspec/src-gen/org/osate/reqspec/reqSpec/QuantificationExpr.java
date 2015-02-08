/**
 */
package org.osate.reqspec.reqSpec;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Quantification Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.reqspec.reqSpec.QuantificationExpr#getVariable <em>Variable</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.QuantificationExpr#getDomain <em>Domain</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.QuantificationExpr#getExpr <em>Expr</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getQuantificationExpr()
 * @model
 * @generated
 */
public interface QuantificationExpr extends Expr
{
  /**
   * Returns the value of the '<em><b>Variable</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Variable</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Variable</em>' containment reference.
   * @see #setVariable(QuantifiedVariable)
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getQuantificationExpr_Variable()
   * @model containment="true"
   * @generated
   */
  QuantifiedVariable getVariable();

  /**
   * Sets the value of the '{@link org.osate.reqspec.reqSpec.QuantificationExpr#getVariable <em>Variable</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Variable</em>' containment reference.
   * @see #getVariable()
   * @generated
   */
  void setVariable(QuantifiedVariable value);

  /**
   * Returns the value of the '<em><b>Domain</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Domain</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Domain</em>' containment reference.
   * @see #setDomain(Domain)
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getQuantificationExpr_Domain()
   * @model containment="true"
   * @generated
   */
  Domain getDomain();

  /**
   * Sets the value of the '{@link org.osate.reqspec.reqSpec.QuantificationExpr#getDomain <em>Domain</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Domain</em>' containment reference.
   * @see #getDomain()
   * @generated
   */
  void setDomain(Domain value);

  /**
   * Returns the value of the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Expr</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expr</em>' containment reference.
   * @see #setExpr(Expr)
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getQuantificationExpr_Expr()
   * @model containment="true"
   * @generated
   */
  Expr getExpr();

  /**
   * Sets the value of the '{@link org.osate.reqspec.reqSpec.QuantificationExpr#getExpr <em>Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expr</em>' containment reference.
   * @see #getExpr()
   * @generated
   */
  void setExpr(Expr value);

} // QuantificationExpr
